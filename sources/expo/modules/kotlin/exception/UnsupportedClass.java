package expo.modules.kotlin.exception;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes4.dex */
public final class UnsupportedClass extends CodedException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnsupportedClass(KClass clazz) {
        super("Unsupported type: '" + clazz + "'", null, 2, null);
        Intrinsics.checkNotNullParameter(clazz, "clazz");
    }
}
