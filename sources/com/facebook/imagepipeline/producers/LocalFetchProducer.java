package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Closeables;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.InputStream;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public abstract class LocalFetchProducer implements Producer {
    private final Executor mExecutor;
    private final PooledByteBufferFactory mPooledByteBufferFactory;

    protected abstract EncodedImage getEncodedImage(ImageRequest imageRequest);

    protected abstract String getProducerName();

    protected LocalFetchProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory) {
        this.mExecutor = executor;
        this.mPooledByteBufferFactory = pooledByteBufferFactory;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer consumer, final ProducerContext producerContext) {
        final ProducerListener2 producerListener = producerContext.getProducerListener();
        final ImageRequest imageRequest = producerContext.getImageRequest();
        producerContext.putOriginExtra("local", "fetch");
        final StatefulProducerRunnable statefulProducerRunnable = new StatefulProducerRunnable(consumer, producerListener, producerContext, getProducerName()) { // from class: com.facebook.imagepipeline.producers.LocalFetchProducer.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.executors.StatefulRunnable
            public EncodedImage getResult() {
                EncodedImage encodedImage = LocalFetchProducer.this.getEncodedImage(imageRequest);
                if (encodedImage == null) {
                    producerListener.onUltimateProducerReached(producerContext, LocalFetchProducer.this.getProducerName(), false);
                    producerContext.putOriginExtra("local", "fetch");
                    return null;
                }
                encodedImage.parseMetaData();
                producerListener.onUltimateProducerReached(producerContext, LocalFetchProducer.this.getProducerName(), true);
                producerContext.putOriginExtra("local", "fetch");
                producerContext.putExtra("image_color_space", encodedImage.getColorSpace());
                return encodedImage;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.executors.StatefulRunnable
            public void disposeResult(EncodedImage encodedImage) {
                EncodedImage.closeSafely(encodedImage);
            }
        };
        producerContext.addCallbacks(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.LocalFetchProducer.2
            @Override // com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public void onCancellationRequested() {
                statefulProducerRunnable.cancel();
            }
        });
        this.mExecutor.execute(statefulProducerRunnable);
    }

    protected EncodedImage getByteBufferBackedEncodedImage(InputStream inputStream, int i) {
        CloseableReference closeableReferenceOf;
        CloseableReference closeableReference = null;
        try {
            if (i <= 0) {
                closeableReferenceOf = CloseableReference.of(this.mPooledByteBufferFactory.newByteBuffer(inputStream));
            } else {
                closeableReferenceOf = CloseableReference.of(this.mPooledByteBufferFactory.newByteBuffer(inputStream, i));
            }
            closeableReference = closeableReferenceOf;
            EncodedImage encodedImage = new EncodedImage(closeableReference);
            Closeables.closeQuietly(inputStream);
            CloseableReference.closeSafely(closeableReference);
            return encodedImage;
        } catch (Throwable th) {
            Closeables.closeQuietly(inputStream);
            CloseableReference.closeSafely(closeableReference);
            throw th;
        }
    }

    protected EncodedImage getEncodedImage(InputStream inputStream, int i) {
        return getByteBufferBackedEncodedImage(inputStream, i);
    }
}
