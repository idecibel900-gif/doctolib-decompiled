package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.vonage.webrtc.MediaStreamTrack;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public class LocalVideoThumbnailProducer implements Producer {
    private final ContentResolver mContentResolver;
    private final Executor mExecutor;

    public LocalVideoThumbnailProducer(Executor executor, ContentResolver contentResolver) {
        this.mExecutor = executor;
        this.mContentResolver = contentResolver;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer consumer, final ProducerContext producerContext) {
        final ProducerListener2 producerListener = producerContext.getProducerListener();
        final ImageRequest imageRequest = producerContext.getImageRequest();
        producerContext.putOriginExtra("local", MediaStreamTrack.VIDEO_TRACK_KIND);
        final StatefulProducerRunnable statefulProducerRunnable = new StatefulProducerRunnable(consumer, producerListener, producerContext, "VideoThumbnailProducer") { // from class: com.facebook.imagepipeline.producers.LocalVideoThumbnailProducer.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
            public void onSuccess(CloseableReference closeableReference) {
                super.onSuccess((Object) closeableReference);
                producerListener.onUltimateProducerReached(producerContext, "VideoThumbnailProducer", closeableReference != null);
                producerContext.putOriginExtra("local", MediaStreamTrack.VIDEO_TRACK_KIND);
            }

            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
            protected void onFailure(Exception exc) {
                super.onFailure(exc);
                producerListener.onUltimateProducerReached(producerContext, "VideoThumbnailProducer", false);
                producerContext.putOriginExtra("local", MediaStreamTrack.VIDEO_TRACK_KIND);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.executors.StatefulRunnable
            public CloseableReference getResult() throws Throwable {
                String localFilePath;
                try {
                    localFilePath = LocalVideoThumbnailProducer.this.getLocalFilePath(imageRequest);
                } catch (IllegalArgumentException unused) {
                    localFilePath = null;
                }
                Bitmap bitmapCreateVideoThumbnail = localFilePath != null ? ThumbnailUtils.createVideoThumbnail(localFilePath, LocalVideoThumbnailProducer.calculateKind(imageRequest)) : null;
                if (bitmapCreateVideoThumbnail == null) {
                    bitmapCreateVideoThumbnail = LocalVideoThumbnailProducer.createThumbnailFromContentProvider(LocalVideoThumbnailProducer.this.mContentResolver, imageRequest.getSourceUri());
                }
                if (bitmapCreateVideoThumbnail == null) {
                    return null;
                }
                CloseableStaticBitmap closeableStaticBitmapOf = CloseableStaticBitmap.of(bitmapCreateVideoThumbnail, SimpleBitmapReleaser.getInstance(), ImmutableQualityInfo.FULL_QUALITY, 0);
                producerContext.putExtra("image_format", "thumbnail");
                closeableStaticBitmapOf.putExtras(producerContext.getExtras());
                return CloseableReference.of(closeableStaticBitmapOf);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable
            public Map getExtraMapOnSuccess(CloseableReference closeableReference) {
                return ImmutableMap.of("createdThumbnail", String.valueOf(closeableReference != null));
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.executors.StatefulRunnable
            public void disposeResult(CloseableReference closeableReference) {
                CloseableReference.closeSafely(closeableReference);
            }
        };
        producerContext.addCallbacks(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.LocalVideoThumbnailProducer.2
            @Override // com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public void onCancellationRequested() {
                statefulProducerRunnable.cancel();
            }
        });
        this.mExecutor.execute(statefulProducerRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int calculateKind(ImageRequest imageRequest) {
        return (imageRequest.getPreferredWidth() > 96 || imageRequest.getPreferredHeight() > 96) ? 1 : 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLocalFilePath(ImageRequest imageRequest) {
        return UriUtil.getRealPathFromUri(this.mContentResolver, imageRequest.getSourceUri());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bitmap createThumbnailFromContentProvider(ContentResolver contentResolver, Uri uri) throws Throwable {
        MediaMetadataRetriever mediaMetadataRetriever;
        MediaMetadataRetriever mediaMetadataRetriever2 = null;
        try {
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(uri, "r");
            Preconditions.checkNotNull(parcelFileDescriptorOpenFileDescriptor);
            mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                mediaMetadataRetriever.setDataSource(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(-1L);
                try {
                    mediaMetadataRetriever.release();
                } catch (IOException unused) {
                }
                return frameAtTime;
            } catch (FileNotFoundException unused2) {
                if (mediaMetadataRetriever != null) {
                    try {
                        mediaMetadataRetriever.release();
                    } catch (IOException unused3) {
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                mediaMetadataRetriever2 = mediaMetadataRetriever;
                if (mediaMetadataRetriever2 != null) {
                    try {
                        mediaMetadataRetriever2.release();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException unused5) {
            mediaMetadataRetriever = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
