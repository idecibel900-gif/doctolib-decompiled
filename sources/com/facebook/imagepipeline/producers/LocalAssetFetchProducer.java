package com.facebook.imagepipeline.producers;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class LocalAssetFetchProducer extends LocalFetchProducer {
    public static final Companion Companion = new Companion(null);
    private final AssetManager assetManager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalAssetFetchProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, AssetManager assetManager) {
        super(executor, pooledByteBufferFactory);
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(pooledByteBufferFactory, "pooledByteBufferFactory");
        Intrinsics.checkNotNullParameter(assetManager, "assetManager");
        this.assetManager = assetManager;
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    protected EncodedImage getEncodedImage(ImageRequest imageRequest) {
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        return getEncodedImage(this.assetManager.open(Companion.getAssetName(imageRequest), 2), getLength(imageRequest));
    }

    private final int getLength(ImageRequest imageRequest) {
        AssetFileDescriptor assetFileDescriptorOpenFd = null;
        try {
            assetFileDescriptorOpenFd = this.assetManager.openFd(Companion.getAssetName(imageRequest));
            int length = (int) assetFileDescriptorOpenFd.getLength();
            try {
                assetFileDescriptorOpenFd.close();
                return length;
            } catch (IOException unused) {
                return length;
            }
        } catch (IOException unused2) {
            if (assetFileDescriptorOpenFd != null) {
                try {
                    assetFileDescriptorOpenFd.close();
                } catch (IOException unused3) {
                }
            }
            return -1;
        } catch (Throwable th) {
            if (assetFileDescriptorOpenFd != null) {
                try {
                    assetFileDescriptorOpenFd.close();
                } catch (IOException unused4) {
                }
            }
            throw th;
        }
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    protected String getProducerName() {
        return "LocalAssetFetchProducer";
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String getAssetName(ImageRequest imageRequest) {
            String path = imageRequest.getSourceUri().getPath();
            Intrinsics.checkNotNull(path);
            String strSubstring = path.substring(1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            return strSubstring;
        }
    }
}
