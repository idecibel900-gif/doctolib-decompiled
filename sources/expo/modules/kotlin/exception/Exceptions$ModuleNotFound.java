package expo.modules.kotlin.exception;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes4.dex */
public class Exceptions$ModuleNotFound extends CodedException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Exceptions$ModuleNotFound(KClass clazz) {
        super(clazz + " module not found, make sure that everything is linked correctly", null, 2, null);
        Intrinsics.checkNotNullParameter(clazz, "clazz");
    }
}
