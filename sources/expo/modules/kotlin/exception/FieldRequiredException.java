package expo.modules.kotlin.exception;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: classes4.dex */
public final class FieldRequiredException extends CodedException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FieldRequiredException(KProperty1 property) {
        super("Value for field '" + property + "' is required, got nil", null, 2, null);
        Intrinsics.checkNotNullParameter(property, "property");
    }
}
