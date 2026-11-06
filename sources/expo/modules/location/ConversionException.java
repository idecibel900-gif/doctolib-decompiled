package expo.modules.location;

import expo.modules.kotlin.exception.CodedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes4.dex */
public final class ConversionException extends CodedException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConversionException(Class fromClass, Class toClass, String str) {
        super("Couldn't cast from " + Reflection.getOrCreateKotlinClass(fromClass.getClass()).getSimpleName() + " to " + toClass.getClass().getSimpleName() + ": " + str, null, 2, null);
        Intrinsics.checkNotNullParameter(fromClass, "fromClass");
        Intrinsics.checkNotNullParameter(toClass, "toClass");
    }
}
