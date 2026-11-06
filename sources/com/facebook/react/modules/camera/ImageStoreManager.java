package com.facebook.react.modules.camera;

import android.net.Uri;
import android.util.Base64OutputStream;
import com.amazon.device.simplesignin.a.a.a;
import com.facebook.fbreact.specs.NativeImageStoreAndroidSpec;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@ReactModule(name = "ImageStoreManager")
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/facebook/react/modules/camera/ImageStoreManager;", "Lcom/facebook/fbreact/specs/NativeImageStoreAndroidSpec;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "getBase64ForTag", "", "uri", "", a.s, "Lcom/facebook/react/bridge/Callback;", "error", "Companion", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageStoreManager extends NativeImageStoreAndroidSpec {
    private static final int BUFFER_SIZE = 8192;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String NAME = "ImageStoreManager";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageStoreManager(ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
    }

    @Override // com.facebook.fbreact.specs.NativeImageStoreAndroidSpec
    public void getBase64ForTag(final String uri, final Callback success, final Callback error) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(success, "success");
        Intrinsics.checkNotNullParameter(error, "error");
        Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.facebook.react.modules.camera.ImageStoreManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ImageStoreManager.getBase64ForTag$lambda$0(this.f$0, uri, success, error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getBase64ForTag$lambda$0(ImageStoreManager imageStoreManager, String str, Callback callback, Callback callback2) {
        try {
            InputStream inputStreamOpenInputStream = imageStoreManager.getReactApplicationContext().getContentResolver().openInputStream(Uri.parse(str));
            Intrinsics.checkNotNull(inputStreamOpenInputStream, "null cannot be cast to non-null type java.io.InputStream");
            try {
                try {
                    Companion companion = INSTANCE;
                    callback.invoke(companion.convertInputStreamToBase64OutputStream$ReactAndroid_release(inputStreamOpenInputStream));
                    companion.closeQuietly(inputStreamOpenInputStream);
                } catch (IOException e) {
                    callback2.invoke(e.getMessage());
                    INSTANCE.closeQuietly(inputStreamOpenInputStream);
                }
            } catch (Throwable th) {
                INSTANCE.closeQuietly(inputStreamOpenInputStream);
                throw th;
            }
        } catch (FileNotFoundException e2) {
            callback2.invoke(e2.getMessage());
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void closeQuietly(Closeable closeable) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }

        public final String convertInputStreamToBase64OutputStream$ReactAndroid_release(InputStream inputStream) {
            Intrinsics.checkNotNullParameter(inputStream, "inputStream");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Base64OutputStream base64OutputStream = new Base64OutputStream(byteArrayOutputStream, 2);
            byte[] bArr = new byte[ImageStoreManager.BUFFER_SIZE];
            while (true) {
                try {
                    int i = inputStream.read(bArr);
                    if (i > -1) {
                        base64OutputStream.write(bArr, 0, i);
                    } else {
                        closeQuietly(base64OutputStream);
                        String string = byteArrayOutputStream.toString();
                        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                        return string;
                    }
                } catch (Throwable th) {
                    closeQuietly(base64OutputStream);
                    throw th;
                }
            }
        }
    }
}
