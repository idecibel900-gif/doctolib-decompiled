package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.ContactsContract;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class LocalContentUriFetchProducer extends LocalFetchProducer {
    public static final Companion Companion = new Companion(null);
    private static final String[] PROJECTION = {"_id", "_data"};
    private final ContentResolver contentResolver;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalContentUriFetchProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, ContentResolver contentResolver) {
        super(executor, pooledByteBufferFactory);
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(pooledByteBufferFactory, "pooledByteBufferFactory");
        Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
        this.contentResolver = contentResolver;
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    protected EncodedImage getEncodedImage(ImageRequest imageRequest) throws IOException {
        EncodedImage cameraImage;
        InputStream inputStreamCreateInputStream;
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        Uri sourceUri = imageRequest.getSourceUri();
        Intrinsics.checkNotNullExpressionValue(sourceUri, "getSourceUri(...)");
        if (UriUtil.isLocalContactUri(sourceUri)) {
            String string = sourceUri.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            if (StringsKt.endsWith$default(string, "/photo", false, 2, (Object) null)) {
                inputStreamCreateInputStream = this.contentResolver.openInputStream(sourceUri);
            } else {
                String string2 = sourceUri.toString();
                Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
                if (StringsKt.endsWith$default(string2, "/display_photo", false, 2, (Object) null)) {
                    try {
                        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = this.contentResolver.openAssetFileDescriptor(sourceUri, "r");
                        if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                            throw new IllegalStateException("Required value was null.");
                        }
                        inputStreamCreateInputStream = assetFileDescriptorOpenAssetFileDescriptor.createInputStream();
                    } catch (IOException unused) {
                        throw new IOException("Contact photo does not exist: " + sourceUri);
                    }
                } else {
                    InputStream inputStreamOpenContactPhotoInputStream = ContactsContract.Contacts.openContactPhotoInputStream(this.contentResolver, sourceUri);
                    if (inputStreamOpenContactPhotoInputStream == null) {
                        throw new IOException("Contact photo does not exist: " + sourceUri);
                    }
                    inputStreamCreateInputStream = inputStreamOpenContactPhotoInputStream;
                }
            }
            if (inputStreamCreateInputStream == null) {
                throw new IllegalStateException("Required value was null.");
            }
            return getEncodedImage(inputStreamCreateInputStream, -1);
        }
        if (UriUtil.isLocalCameraUri(sourceUri) && (cameraImage = getCameraImage(sourceUri)) != null) {
            return cameraImage;
        }
        InputStream inputStreamOpenInputStream = this.contentResolver.openInputStream(sourceUri);
        if (inputStreamOpenInputStream != null) {
            return getEncodedImage(inputStreamOpenInputStream, -1);
        }
        throw new IllegalStateException("Required value was null.");
    }

    private final EncodedImage getCameraImage(Uri uri) throws IOException {
        try {
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = this.contentResolver.openFileDescriptor(uri, "r");
            if (parcelFileDescriptorOpenFileDescriptor == null) {
                throw new IllegalStateException("Required value was null.");
            }
            EncodedImage encodedImage = getEncodedImage(new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()), (int) parcelFileDescriptorOpenFileDescriptor.getStatSize());
            Intrinsics.checkNotNullExpressionValue(encodedImage, "getEncodedImage(...)");
            parcelFileDescriptorOpenFileDescriptor.close();
            return encodedImage;
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    protected String getProducerName() {
        return "LocalContentUriFetchProducer";
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
