package expo.modules.kotlin;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.full.KClasses;

/* JADX INFO: loaded from: classes4.dex */
public abstract class KClassExtensionsKt {
    public static final KFunction getFastPrimaryConstructor(KClass kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        KFunction kFunction = (KFunction) CollectionsKt.singleOrNull(kClass.getConstructors());
        return kFunction == null ? KClasses.getPrimaryConstructor(kClass) : kFunction;
    }

    public static final boolean fastIsSupperClassOf(KClass kClass, Class jClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Intrinsics.checkNotNullParameter(jClass, "jClass");
        return JvmClassMappingKt.getJavaObjectType(kClass).isAssignableFrom(jClass) || JvmClassMappingKt.getJavaClass(kClass).isAssignableFrom(jClass);
    }
}
