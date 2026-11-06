package kotlin.reflect.full;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KProperty1;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.KFunctionImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;

/* JADX INFO: loaded from: classes5.dex */
public abstract class KClasses {
    public static final KFunction getPrimaryConstructor(KClass kClass) {
        Object next;
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Iterator it = ((KClassImpl) kClass).getConstructors().iterator();
        while (it.hasNext()) {
            next = it.next();
            KFunction kFunction = (KFunction) next;
            Intrinsics.checkNotNull(kFunction, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KFunctionImpl");
            FunctionDescriptor descriptor = ((KFunctionImpl) kFunction).getDescriptor();
            Intrinsics.checkNotNull(descriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ConstructorDescriptor");
            if (((ConstructorDescriptor) descriptor).isPrimary()) {
                return (KFunction) next;
            }
        }
        next = null;
        return (KFunction) next;
    }

    public static final Collection getMemberProperties(KClass kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Collection allNonStaticMembers = ((KClassImpl.Data) ((KClassImpl) kClass).getData().getValue()).getAllNonStaticMembers();
        ArrayList arrayList = new ArrayList();
        for (Object obj : allNonStaticMembers) {
            KCallableImpl kCallableImpl = (KCallableImpl) obj;
            if (isNotExtension(kCallableImpl) && (kCallableImpl instanceof KProperty1)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final Collection getDeclaredMemberProperties(KClass kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Collection declaredNonStaticMembers = ((KClassImpl.Data) ((KClassImpl) kClass).getData().getValue()).getDeclaredNonStaticMembers();
        ArrayList arrayList = new ArrayList();
        for (Object obj : declaredNonStaticMembers) {
            KCallableImpl kCallableImpl = (KCallableImpl) obj;
            if (isNotExtension(kCallableImpl) && (kCallableImpl instanceof KProperty1)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private static final boolean isExtension(KCallableImpl kCallableImpl) {
        return kCallableImpl.getDescriptor().getExtensionReceiverParameter() != null;
    }

    private static final boolean isNotExtension(KCallableImpl kCallableImpl) {
        return !isExtension(kCallableImpl);
    }
}
