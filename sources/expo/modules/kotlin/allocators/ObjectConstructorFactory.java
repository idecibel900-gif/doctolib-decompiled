package expo.modules.kotlin.allocators;

import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;

/* JADX INFO: loaded from: classes4.dex */
public final class ObjectConstructorFactory {
    public final ObjectConstructor get(KClass clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        ObjectConstructor objectConstructorTryToUseDefaultConstructor = tryToUseDefaultConstructor(JvmClassMappingKt.getJavaClass(clazz));
        return (objectConstructorTryToUseDefaultConstructor == null && (objectConstructorTryToUseDefaultConstructor = tryToUseDefaultKotlinConstructor(clazz)) == null) ? useUnsafeAllocator(JvmClassMappingKt.getJavaClass(clazz)) : objectConstructorTryToUseDefaultConstructor;
    }

    private final ObjectConstructor tryToUseDefaultConstructor(Class cls) {
        try {
            final Constructor declaredConstructor = cls.getDeclaredConstructor(null);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return new ObjectConstructor() { // from class: expo.modules.kotlin.allocators.ObjectConstructorFactory$$ExternalSyntheticLambda1
                @Override // expo.modules.kotlin.allocators.ObjectConstructor
                public final Object construct() {
                    return ObjectConstructorFactory.tryToUseDefaultConstructor$lambda$0(declaredConstructor);
                }
            };
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object tryToUseDefaultConstructor$lambda$0(Constructor constructor) {
        return constructor.newInstance(null);
    }

    private final ObjectConstructor tryToUseDefaultKotlinConstructor(KClass kClass) {
        Iterator it = kClass.getConstructors().iterator();
        boolean z = false;
        Object obj = null;
        while (true) {
            if (!it.hasNext()) {
                if (!z) {
                    break;
                }
                break;
            }
            Object next = it.next();
            List parameters = ((KFunction) next).getParameters();
            if (!(parameters instanceof Collection) || !parameters.isEmpty()) {
                Iterator it2 = parameters.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (!((KParameter) it2.next()).isOptional()) {
                        }
                    }
                }
            }
            if (!z) {
                z = true;
                obj = next;
            }
            obj = null;
            break;
        }
        final KFunction kFunction = (KFunction) obj;
        if (kFunction == null) {
            return null;
        }
        return new ObjectConstructor() { // from class: expo.modules.kotlin.allocators.ObjectConstructorFactory$$ExternalSyntheticLambda2
            @Override // expo.modules.kotlin.allocators.ObjectConstructor
            public final Object construct() {
                return ObjectConstructorFactory.tryToUseDefaultKotlinConstructor$lambda$2(kFunction);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object tryToUseDefaultKotlinConstructor$lambda$2(KFunction kFunction) {
        return kFunction.callBy(MapsKt.emptyMap());
    }

    private final ObjectConstructor useUnsafeAllocator(Class cls) {
        final UnsafeAllocator unsafeAllocatorCreateAllocator = UnsafeAllocator.Companion.createAllocator(cls);
        return new ObjectConstructor() { // from class: expo.modules.kotlin.allocators.ObjectConstructorFactory$$ExternalSyntheticLambda0
            @Override // expo.modules.kotlin.allocators.ObjectConstructor
            public final Object construct() {
                return unsafeAllocatorCreateAllocator.newInstance();
            }
        };
    }
}
