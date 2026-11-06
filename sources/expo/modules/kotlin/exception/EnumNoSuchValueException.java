package expo.modules.kotlin.exception;

import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes4.dex */
public final class EnumNoSuchValueException extends CodedException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnumNoSuchValueException(KClass enumType, Enum[] enumConstants, Object obj) {
        super("'" + obj + "' is not present in " + enumType.getSimpleName() + " enum, it must be one of: " + ArraysKt.joinToString$default(enumConstants, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: expo.modules.kotlin.exception.EnumNoSuchValueException$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return EnumNoSuchValueException._init_$lambda$0((Enum) obj2);
            }
        }, 30, (Object) null), null, 2, null);
        Intrinsics.checkNotNullParameter(enumType, "enumType");
        Intrinsics.checkNotNullParameter(enumConstants, "enumConstants");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence _init_$lambda$0(Enum it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return "'" + it.name() + "'";
    }
}
