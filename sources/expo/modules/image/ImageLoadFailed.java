package expo.modules.image;

import expo.modules.kotlin.exception.CodedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ImageLoadFailed extends CodedException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageLoadFailed(Exception exception) {
        super("Failed to load the image: " + exception.getMessage(), null, 2, null);
        Intrinsics.checkNotNullParameter(exception, "exception");
    }
}
