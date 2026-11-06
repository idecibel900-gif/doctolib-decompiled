package androidx.window.core;

import android.app.Activity;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KClasses;

/* JADX INFO: loaded from: classes.dex */
public final class ConsumerAdapter {
    private final ClassLoader loader;

    public interface Subscription {
        void dispose();
    }

    public ConsumerAdapter(ClassLoader loader) {
        Intrinsics.checkNotNullParameter(loader, "loader");
        this.loader = loader;
    }

    public final Class consumerClassOrNull$window_release() {
        try {
            return unsafeConsumerClass();
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private final Class unsafeConsumerClass() throws ClassNotFoundException {
        Class<?> clsLoadClass = this.loader.loadClass("java.util.function.Consumer");
        Intrinsics.checkNotNullExpressionValue(clsLoadClass, "loader.loadClass(\"java.util.function.Consumer\")");
        return clsLoadClass;
    }

    private final Object buildConsumer(KClass kClass, Function1 function1) {
        Object objNewProxyInstance = Proxy.newProxyInstance(this.loader, new Class[]{unsafeConsumerClass()}, new ConsumerHandler(kClass, function1));
        Intrinsics.checkNotNullExpressionValue(objNewProxyInstance, "newProxyInstance(loader,…onsumerClass()), handler)");
        return objNewProxyInstance;
    }

    public final Subscription createSubscription(final Object obj, KClass clazz, String addMethodName, String removeMethodName, Activity activity, Function1 consumer) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(obj, "obj");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(addMethodName, "addMethodName");
        Intrinsics.checkNotNullParameter(removeMethodName, "removeMethodName");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        final Object objBuildConsumer = buildConsumer(clazz, consumer);
        obj.getClass().getMethod(addMethodName, Activity.class, unsafeConsumerClass()).invoke(obj, activity, objBuildConsumer);
        final Method method = obj.getClass().getMethod(removeMethodName, unsafeConsumerClass());
        return new Subscription() { // from class: androidx.window.core.ConsumerAdapter.createSubscription.1
            @Override // androidx.window.core.ConsumerAdapter.Subscription
            public void dispose() throws IllegalAccessException, InvocationTargetException {
                method.invoke(obj, objBuildConsumer);
            }
        };
    }

    private static final class ConsumerHandler implements InvocationHandler {
        private final KClass clazz;
        private final Function1 consumer;

        public ConsumerHandler(KClass clazz, Function1 consumer) {
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            Intrinsics.checkNotNullParameter(consumer, "consumer");
            this.clazz = clazz;
            this.consumer = consumer;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            Intrinsics.checkNotNullParameter(obj, "obj");
            Intrinsics.checkNotNullParameter(method, "method");
            if (isAccept(method, objArr)) {
                invokeAccept(KClasses.cast(this.clazz, objArr != null ? objArr[0] : null));
                return Unit.INSTANCE;
            }
            if (isEquals(method, objArr)) {
                return Boolean.valueOf(obj == (objArr != null ? objArr[0] : null));
            }
            if (isHashCode(method, objArr)) {
                return Integer.valueOf(this.consumer.hashCode());
            }
            if (isToString(method, objArr)) {
                return this.consumer.toString();
            }
            throw new UnsupportedOperationException("Unexpected method call object:" + obj + ", method: " + method + ", args: " + objArr);
        }

        public final void invokeAccept(Object parameter) {
            Intrinsics.checkNotNullParameter(parameter, "parameter");
            this.consumer.invoke(parameter);
        }

        private final boolean isEquals(Method method, Object[] objArr) {
            return Intrinsics.areEqual(method.getName(), "equals") && method.getReturnType().equals(Boolean.TYPE) && objArr != null && objArr.length == 1;
        }

        private final boolean isHashCode(Method method, Object[] objArr) {
            return Intrinsics.areEqual(method.getName(), "hashCode") && method.getReturnType().equals(Integer.TYPE) && objArr == null;
        }

        private final boolean isAccept(Method method, Object[] objArr) {
            return Intrinsics.areEqual(method.getName(), "accept") && objArr != null && objArr.length == 1;
        }

        private final boolean isToString(Method method, Object[] objArr) {
            return Intrinsics.areEqual(method.getName(), "toString") && method.getReturnType().equals(String.class) && objArr == null;
        }
    }
}
