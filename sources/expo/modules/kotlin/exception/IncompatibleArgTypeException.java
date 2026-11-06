package expo.modules.kotlin.exception;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes4.dex */
public final class IncompatibleArgTypeException extends CodedException {
    public /* synthetic */ IncompatibleArgTypeException(KClass kClass, KClass kClass2, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(kClass, kClass2, (i & 4) != 0 ? null : th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IncompatibleArgTypeException(KClass argumentType, KClass desiredType, Throwable th) {
        super("Argument type '" + argumentType + "' is not compatible with expected type '" + desiredType + "'.", th);
        Intrinsics.checkNotNullParameter(argumentType, "argumentType");
        Intrinsics.checkNotNullParameter(desiredType, "desiredType");
    }
}
