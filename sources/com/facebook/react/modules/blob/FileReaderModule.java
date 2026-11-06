package com.facebook.react.modules.blob;

import android.util.Base64;
import com.amazon.device.iap.internal.c.b;
import com.facebook.fbreact.specs.NativeFileReaderModuleSpec;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@ReactModule(name = NativeFileReaderModuleSpec.NAME)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0013"}, d2 = {"Lcom/facebook/react/modules/blob/FileReaderModule;", "Lcom/facebook/fbreact/specs/NativeFileReaderModuleSpec;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "getBlobModule", "Lcom/facebook/react/modules/blob/BlobModule;", "reason", "", "readAsText", "", "blob", "Lcom/facebook/react/bridge/ReadableMap;", "encoding", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "readAsDataURL", "Companion", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FileReaderModule extends NativeFileReaderModuleSpec {
    private static final String ERROR_INVALID_BLOB = "ERROR_INVALID_BLOB";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String NAME = NativeFileReaderModuleSpec.NAME;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileReaderModule(ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
    }

    private final BlobModule getBlobModule(String reason) {
        ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
        if (reactApplicationContextIfActiveOrWarn != null) {
            return (BlobModule) reactApplicationContextIfActiveOrWarn.getNativeModule(BlobModule.class);
        }
        return null;
    }

    @Override // com.facebook.fbreact.specs.NativeFileReaderModuleSpec
    public void readAsText(ReadableMap blob, String encoding, Promise promise) {
        Intrinsics.checkNotNullParameter(blob, "blob");
        Intrinsics.checkNotNullParameter(encoding, "encoding");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BlobModule blobModule = getBlobModule("readAsText");
        if (blobModule == null) {
            promise.reject(new IllegalStateException("Could not get BlobModule from ReactApplicationContext"));
            return;
        }
        String string = blob.getString("blobId");
        if (string == null) {
            promise.reject(ERROR_INVALID_BLOB, "The specified blob does not contain a blobId");
            return;
        }
        byte[] bArrResolve = blobModule.resolve(string, blob.getInt(b.as), blob.getInt("size"));
        if (bArrResolve == null) {
            promise.reject(ERROR_INVALID_BLOB, "The specified blob is invalid");
            return;
        }
        try {
            Charset charsetForName = Charset.forName(encoding);
            Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(...)");
            promise.resolve(new String(bArrResolve, charsetForName));
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @Override // com.facebook.fbreact.specs.NativeFileReaderModuleSpec
    public void readAsDataURL(ReadableMap blob, Promise promise) {
        String string;
        Intrinsics.checkNotNullParameter(blob, "blob");
        Intrinsics.checkNotNullParameter(promise, "promise");
        BlobModule blobModule = getBlobModule("readAsDataURL");
        if (blobModule == null) {
            promise.reject(new IllegalStateException("Could not get BlobModule from ReactApplicationContext"));
            return;
        }
        String string2 = blob.getString("blobId");
        if (string2 == null) {
            promise.reject(ERROR_INVALID_BLOB, "The specified blob does not contain a blobId");
            return;
        }
        byte[] bArrResolve = blobModule.resolve(string2, blob.getInt(b.as), blob.getInt("size"));
        if (bArrResolve == null) {
            promise.reject(ERROR_INVALID_BLOB, "The specified blob is invalid");
            return;
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("data:");
            if (blob.hasKey("type") && (string = blob.getString("type")) != null && string.length() != 0) {
                sb.append(blob.getString("type"));
            } else {
                sb.append("application/octet-stream");
            }
            sb.append(";base64,");
            sb.append(Base64.encodeToString(bArrResolve, 2));
            promise.resolve(sb.toString());
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getNAME() {
            return FileReaderModule.NAME;
        }
    }
}
