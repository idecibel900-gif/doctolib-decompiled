package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class QualifiedResourceFetchProducer extends LocalFetchProducer {
    public static final Companion Companion = new Companion(null);
    private final ContentResolver contentResolver;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QualifiedResourceFetchProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, ContentResolver contentResolver) {
        super(executor, pooledByteBufferFactory);
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(pooledByteBufferFactory, "pooledByteBufferFactory");
        Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
        this.contentResolver = contentResolver;
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    protected EncodedImage getEncodedImage(ImageRequest imageRequest) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        InputStream inputStreamOpenInputStream = this.contentResolver.openInputStream(imageRequest.getSourceUri());
        if (inputStreamOpenInputStream != null) {
            EncodedImage encodedImage = getEncodedImage(inputStreamOpenInputStream, -1);
            Intrinsics.checkNotNullExpressionValue(encodedImage, "getEncodedImage(...)");
            return encodedImage;
        }
        throw new IllegalStateException("ContentResolver returned null InputStream");
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    protected String getProducerName() {
        return "QualifiedResourceFetchProducer";
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
