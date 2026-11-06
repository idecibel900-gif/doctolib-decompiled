package expo.modules.kotlin.exception;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class FunctionCallException extends DecoratedException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FunctionCallException(String methodName, String moduleName, CodedException cause) {
        super("Call to function '" + moduleName + "." + methodName + "' has been rejected.", cause);
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        Intrinsics.checkNotNullParameter(cause, "cause");
    }
}
