package expo.modules.kotlin.services;

import android.content.Context;
import expo.modules.kotlin.AppContext;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lexpo/modules/kotlin/services/Service;", "", "Companion", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface Service {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final Service construct(Class serviceClass, AppContext appContext) throws IllegalAccessException, InstantiationException, InvocationTargetException {
            Intrinsics.checkNotNullParameter(serviceClass, "serviceClass");
            Intrinsics.checkNotNullParameter(appContext, "appContext");
            Context reactContext = appContext.getReactContext();
            if (reactContext == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            Constructor<?>[] constructors = serviceClass.getConstructors();
            Intrinsics.checkNotNullExpressionValue(constructors, "getConstructors(...)");
            Constructor constructor = (Constructor) ArraysKt.single(constructors);
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            Intrinsics.checkNotNull(parameterTypes);
            if (parameterTypes.length == 0) {
                Object objNewInstance = constructor.newInstance(null);
                Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type expo.modules.kotlin.services.Service");
                return (Service) objNewInstance;
            }
            if (parameterTypes.length != 1) {
                throw new IllegalArgumentException("Service " + serviceClass.getSimpleName() + " has an invalid constructor.");
            }
            Class cls = (Class) ArraysKt.single(parameterTypes);
            if (Intrinsics.areEqual(cls, Context.class)) {
                Object objNewInstance2 = constructor.newInstance(reactContext);
                Intrinsics.checkNotNull(objNewInstance2, "null cannot be cast to non-null type expo.modules.kotlin.services.Service");
                return (Service) objNewInstance2;
            }
            if (Intrinsics.areEqual(cls, AppContext.class)) {
                Object objNewInstance3 = constructor.newInstance(appContext);
                Intrinsics.checkNotNull(objNewInstance3, "null cannot be cast to non-null type expo.modules.kotlin.services.Service");
                return (Service) objNewInstance3;
            }
            throw new IllegalArgumentException("Service " + serviceClass.getSimpleName() + " has an invalid constructor.");
        }
    }
}
