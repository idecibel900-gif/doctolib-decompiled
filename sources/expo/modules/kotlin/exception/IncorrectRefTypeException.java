package expo.modules.kotlin.exception;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;

/* JADX INFO: loaded from: classes4.dex */
public final class IncorrectRefTypeException extends CodedException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IncorrectRefTypeException(KType desiredType, Class receivedClass) {
        super("Cannot convert received '" + receivedClass + "' to the '" + desiredType + "', because of the inner ref type mismatch", null, 2, null);
        Intrinsics.checkNotNullParameter(desiredType, "desiredType");
        Intrinsics.checkNotNullParameter(receivedClass, "receivedClass");
    }
}
