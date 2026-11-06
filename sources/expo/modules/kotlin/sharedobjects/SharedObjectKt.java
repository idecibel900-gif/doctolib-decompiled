package expo.modules.kotlin.sharedobjects;

import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes4.dex */
public abstract class SharedObjectKt {
    public static final boolean isSharedObjectClass(KClass kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        return SharedObject.class.isAssignableFrom(JvmClassMappingKt.getJavaClass(kClass));
    }
}
