package expo.modules.kotlin;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty1;
import kotlin.reflect.full.KClasses;

/* JADX INFO: loaded from: classes4.dex */
public abstract class EnumExtensionsKt {
    public static final String convertToString(Enum r4) {
        List parameters;
        Object next;
        Intrinsics.checkNotNullParameter(r4, "<this>");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(r4.getClass());
        KFunction fastPrimaryConstructor = KClassExtensionsKt.getFastPrimaryConstructor(orCreateKotlinClass);
        if (fastPrimaryConstructor != null && (parameters = fastPrimaryConstructor.getParameters()) != null && parameters.size() == 1) {
            String name = ((KParameter) CollectionsKt.first(fastPrimaryConstructor.getParameters())).getName();
            Iterator it = KClasses.getDeclaredMemberProperties(orCreateKotlinClass).iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.areEqual(((KProperty1) next).getName(), name));
            KProperty1 kProperty1 = (KProperty1) next;
            if (kProperty1 == null) {
                throw new IllegalArgumentException(("Cannot find a property for " + name + " parameter").toString());
            }
            if (!Intrinsics.areEqual(kProperty1.getReturnType().getClassifier(), Reflection.getOrCreateKotlinClass(String.class))) {
                throw new IllegalArgumentException("The enum parameter has to be a string.");
            }
            return (String) kProperty1.get(r4);
        }
        return r4.name();
    }
}
