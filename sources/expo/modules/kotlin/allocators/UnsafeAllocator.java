package expo.modules.kotlin.allocators;

import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public interface UnsafeAllocator {
    public static final Companion Companion = Companion.$$INSTANCE;

    Object newInstance();

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final UnsafeAllocator createAllocator(final Class clazz) {
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            try {
                try {
                    Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                    declaredMethod.setAccessible(true);
                    Object objInvoke = declaredMethod.invoke(null, Object.class);
                    Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.Int");
                    final int iIntValue = ((Integer) objInvoke).intValue();
                    final Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                    declaredMethod2.setAccessible(true);
                    return new UnsafeAllocator() { // from class: expo.modules.kotlin.allocators.UnsafeAllocator$Companion$$ExternalSyntheticLambda0
                        @Override // expo.modules.kotlin.allocators.UnsafeAllocator
                        public final Object newInstance() {
                            return UnsafeAllocator.Companion.createAllocator$lambda$0(declaredMethod2, clazz, iIntValue);
                        }
                    };
                } catch (Throwable unused) {
                    Class<?> cls = Class.forName("sun.misc.Unsafe");
                    Field declaredField = cls.getDeclaredField("theUnsafe");
                    declaredField.setAccessible(true);
                    final Object obj = declaredField.get(null);
                    final Method method = cls.getMethod("allocateInstance", Class.class);
                    return new UnsafeAllocator() { // from class: expo.modules.kotlin.allocators.UnsafeAllocator$Companion$$ExternalSyntheticLambda1
                        @Override // expo.modules.kotlin.allocators.UnsafeAllocator
                        public final Object newInstance() {
                            return UnsafeAllocator.Companion.createAllocator$lambda$1(method, obj, clazz);
                        }
                    };
                }
            } catch (Throwable unused2) {
                return new UnsafeAllocator() { // from class: expo.modules.kotlin.allocators.UnsafeAllocator$Companion$$ExternalSyntheticLambda2
                    @Override // expo.modules.kotlin.allocators.UnsafeAllocator
                    public final Object newInstance() {
                        return UnsafeAllocator.Companion.createAllocator$lambda$2(clazz);
                    }
                };
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Object createAllocator$lambda$0(Method method, Class cls, int i) {
            return method.invoke(null, cls, Integer.valueOf(i));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Object createAllocator$lambda$1(Method method, Object obj, Class cls) {
            return method.invoke(obj, cls);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Object createAllocator$lambda$2(Class cls) {
            throw new IllegalArgumentException("Cannot allocate " + cls);
        }
    }
}
