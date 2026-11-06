package expo.modules.kotlin.sharedobjects;

import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes4.dex */
public abstract class SharedRefKt {
    public static final boolean isSharedRefClass(KClass kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        return SharedRef.class.isAssignableFrom(JvmClassMappingKt.getJavaClass(kClass));
    }
}
