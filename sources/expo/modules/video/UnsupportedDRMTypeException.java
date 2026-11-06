package expo.modules.video;

import expo.modules.kotlin.exception.CodedException;
import expo.modules.video.enums.DRMType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class UnsupportedDRMTypeException extends CodedException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnsupportedDRMTypeException(DRMType type) {
        super("DRM type `" + type + "` is not supported on Android", null, 2, null);
        Intrinsics.checkNotNullParameter(type, "type");
    }
}
