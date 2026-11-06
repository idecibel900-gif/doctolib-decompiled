package expo.modules.video;

import expo.modules.kotlin.exception.CodedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class MethodUnsupportedException extends CodedException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MethodUnsupportedException(String methodName) {
        super("Method `" + methodName + "` is not supported on Android", null, 2, null);
        Intrinsics.checkNotNullParameter(methodName, "methodName");
    }
}
