package expo.modules.clipboard;

import expo.modules.kotlin.exception.CodedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class InvalidImageException extends CodedException {
    /* JADX WARN: Illegal instructions before constructor call */
    public InvalidImageException(String image, Throwable th) {
        Intrinsics.checkNotNullParameter(image, "image");
        String strSubstring = image.substring(0, Math.min(image.length(), 32));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        super("Invalid base64 image: " + ((Object) (strSubstring + (image.length() > 32 ? "..." : ""))), th);
    }
}
