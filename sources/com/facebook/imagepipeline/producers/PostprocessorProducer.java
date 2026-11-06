package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.request.Postprocessor;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public class PostprocessorProducer implements Producer {
    private final PlatformBitmapFactory mBitmapFactory;
    private final Executor mExecutor;
    private final Producer mInputProducer;

    public PostprocessorProducer(Producer producer, PlatformBitmapFactory platformBitmapFactory, Executor executor) {
        this.mInputProducer = (Producer) Preconditions.checkNotNull(producer);
        this.mBitmapFactory = platformBitmapFactory;
        this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer consumer, ProducerContext producerContext) {
        ProducerListener2 producerListener = producerContext.getProducerListener();
        Postprocessor postprocessor = producerContext.getImageRequest().getPostprocessor();
        Preconditions.checkNotNull(postprocessor);
        this.mInputProducer.produceResults(new SingleUsePostprocessorConsumer(new PostprocessorConsumer(consumer, producerListener, postprocessor, producerContext)), producerContext);
    }

    private class PostprocessorConsumer extends DelegatingConsumer {
        private boolean mIsClosed;
        private boolean mIsDirty;
        private boolean mIsPostProcessingRunning;
        private final ProducerListener2 mListener;
        private final Postprocessor mPostprocessor;
        private final ProducerContext mProducerContext;
        private CloseableReference mSourceImageRef;
        private int mStatus;

        public PostprocessorConsumer(Consumer consumer, ProducerListener2 producerListener2, Postprocessor postprocessor, ProducerContext producerContext) {
            super(consumer);
            this.mSourceImageRef = null;
            this.mStatus = 0;
            this.mIsDirty = false;
            this.mIsPostProcessingRunning = false;
            this.mListener = producerListener2;
            this.mPostprocessor = postprocessor;
            this.mProducerContext = producerContext;
            producerContext.addCallbacks(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.PostprocessorProducer.PostprocessorConsumer.1
                @Override // com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onCancellationRequested() {
                    PostprocessorConsumer.this.maybeNotifyOnCancellation();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(CloseableReference closeableReference, int i) {
            if (!CloseableReference.isValid(closeableReference)) {
                if (BaseConsumer.isLast(i)) {
                    maybeNotifyOnNewResult(null, i);
                    return;
                }
                return;
            }
            updateSourceImageRef(closeableReference, i);
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        protected void onFailureImpl(Throwable th) {
            maybeNotifyOnFailure(th);
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        protected void onCancellationImpl() {
            maybeNotifyOnCancellation();
        }

        private void updateSourceImageRef(CloseableReference closeableReference, int i) {
            synchronized (this) {
                try {
                    if (this.mIsClosed) {
                        return;
                    }
                    CloseableReference closeableReference2 = this.mSourceImageRef;
                    this.mSourceImageRef = CloseableReference.cloneOrNull(closeableReference);
                    this.mStatus = i;
                    this.mIsDirty = true;
                    boolean runningIfDirtyAndNotRunning = setRunningIfDirtyAndNotRunning();
                    CloseableReference.closeSafely(closeableReference2);
                    if (runningIfDirtyAndNotRunning) {
                        submitPostprocessing();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        private void submitPostprocessing() {
            PostprocessorProducer.this.mExecutor.execute(new Runnable() { // from class: com.facebook.imagepipeline.producers.PostprocessorProducer.PostprocessorConsumer.2
                @Override // java.lang.Runnable
                public void run() {
                    CloseableReference closeableReference;
                    int i;
                    synchronized (PostprocessorConsumer.this) {
                        closeableReference = PostprocessorConsumer.this.mSourceImageRef;
                        i = PostprocessorConsumer.this.mStatus;
                        PostprocessorConsumer.this.mSourceImageRef = null;
                        PostprocessorConsumer.this.mIsDirty = false;
                    }
                    if (CloseableReference.isValid(closeableReference)) {
                        try {
                            PostprocessorConsumer.this.doPostprocessing(closeableReference, i);
                            CloseableReference.closeSafely(closeableReference);
                        } catch (Throwable th) {
                            CloseableReference.closeSafely(closeableReference);
                            throw th;
                        }
                    }
                    PostprocessorConsumer.this.clearRunningAndStartIfDirty();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRunningAndStartIfDirty() {
            boolean runningIfDirtyAndNotRunning;
            synchronized (this) {
                this.mIsPostProcessingRunning = false;
                runningIfDirtyAndNotRunning = setRunningIfDirtyAndNotRunning();
            }
            if (runningIfDirtyAndNotRunning) {
                submitPostprocessing();
            }
        }

        private synchronized boolean setRunningIfDirtyAndNotRunning() {
            if (this.mIsClosed || !this.mIsDirty || this.mIsPostProcessingRunning || !CloseableReference.isValid(this.mSourceImageRef)) {
                return false;
            }
            this.mIsPostProcessingRunning = true;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void doPostprocessing(CloseableReference closeableReference, int i) {
            Preconditions.checkArgument(Boolean.valueOf(CloseableReference.isValid(closeableReference)));
            if (!shouldPostprocess((CloseableImage) closeableReference.get())) {
                maybeNotifyOnNewResult(closeableReference, i);
                return;
            }
            this.mListener.onProducerStart(this.mProducerContext, "PostprocessorProducer");
            try {
                try {
                    CloseableReference closeableReferencePostprocessInternal = postprocessInternal((CloseableImage) closeableReference.get());
                    ProducerListener2 producerListener2 = this.mListener;
                    ProducerContext producerContext = this.mProducerContext;
                    producerListener2.onProducerFinishWithSuccess(producerContext, "PostprocessorProducer", getExtraMap(producerListener2, producerContext, this.mPostprocessor));
                    maybeNotifyOnNewResult(closeableReferencePostprocessInternal, i);
                    CloseableReference.closeSafely(closeableReferencePostprocessInternal);
                } catch (Exception e) {
                    ProducerListener2 producerListener3 = this.mListener;
                    ProducerContext producerContext2 = this.mProducerContext;
                    producerListener3.onProducerFinishWithFailure(producerContext2, "PostprocessorProducer", e, getExtraMap(producerListener3, producerContext2, this.mPostprocessor));
                    maybeNotifyOnFailure(e);
                    CloseableReference.closeSafely(null);
                }
            } catch (Throwable th) {
                CloseableReference.closeSafely(null);
                throw th;
            }
        }

        private Map getExtraMap(ProducerListener2 producerListener2, ProducerContext producerContext, Postprocessor postprocessor) {
            if (producerListener2.requiresExtraMap(producerContext, "PostprocessorProducer")) {
                return ImmutableMap.of("Postprocessor", postprocessor.getName());
            }
            return null;
        }

        private boolean shouldPostprocess(CloseableImage closeableImage) {
            return closeableImage instanceof CloseableStaticBitmap;
        }

        private CloseableReference postprocessInternal(CloseableImage closeableImage) {
            CloseableStaticBitmap closeableStaticBitmap = (CloseableStaticBitmap) closeableImage;
            CloseableReference closeableReferenceProcess = this.mPostprocessor.process(closeableStaticBitmap.getUnderlyingBitmap(), PostprocessorProducer.this.mBitmapFactory);
            try {
                CloseableStaticBitmap closeableStaticBitmapOf = CloseableStaticBitmap.of(closeableReferenceProcess, closeableImage.getQualityInfo(), closeableStaticBitmap.getRotationAngle(), closeableStaticBitmap.getExifOrientation());
                closeableStaticBitmapOf.putExtras(closeableStaticBitmap.getExtras());
                return CloseableReference.of(closeableStaticBitmapOf);
            } finally {
                CloseableReference.closeSafely(closeableReferenceProcess);
            }
        }

        private void maybeNotifyOnNewResult(CloseableReference closeableReference, int i) {
            boolean zIsLast = BaseConsumer.isLast(i);
            if ((zIsLast || isClosed()) && !(zIsLast && close())) {
                return;
            }
            getConsumer().onNewResult(closeableReference, i);
        }

        private void maybeNotifyOnFailure(Throwable th) {
            if (close()) {
                getConsumer().onFailure(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void maybeNotifyOnCancellation() {
            if (close()) {
                getConsumer().onCancellation();
            }
        }

        private synchronized boolean isClosed() {
            return this.mIsClosed;
        }

        private boolean close() {
            synchronized (this) {
                try {
                    if (this.mIsClosed) {
                        return false;
                    }
                    CloseableReference closeableReference = this.mSourceImageRef;
                    this.mSourceImageRef = null;
                    this.mIsClosed = true;
                    CloseableReference.closeSafely(closeableReference);
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    class SingleUsePostprocessorConsumer extends DelegatingConsumer {
        private SingleUsePostprocessorConsumer(PostprocessorConsumer postprocessorConsumer) {
            super(postprocessorConsumer);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(CloseableReference closeableReference, int i) {
            if (BaseConsumer.isNotLast(i)) {
                return;
            }
            getConsumer().onNewResult(closeableReference, i);
        }
    }
}
