package io.sentry.android.replay;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class WindowManagerSpy {
    public static final int $stable;
    public static final WindowManagerSpy INSTANCE = new WindowManagerSpy();
    private static final Lazy mViewsField$delegate;
    private static final Lazy windowManagerClass$delegate;
    private static final Lazy windowManagerInstance$delegate;

    private WindowManagerSpy() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Class getWindowManagerClass() {
        return (Class) windowManagerClass$delegate.getValue();
    }

    static {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        windowManagerClass$delegate = LazyKt.lazy(lazyThreadSafetyMode, new Function0() { // from class: io.sentry.android.replay.WindowManagerSpy$windowManagerClass$2
            @Override // kotlin.jvm.functions.Function0
            public final Class invoke() {
                try {
                    return Class.forName("android.view.WindowManagerGlobal");
                } catch (Throwable unused) {
                    return null;
                }
            }
        });
        windowManagerInstance$delegate = LazyKt.lazy(lazyThreadSafetyMode, new Function0() { // from class: io.sentry.android.replay.WindowManagerSpy$windowManagerInstance$2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Method method;
                Class windowManagerClass = WindowManagerSpy.INSTANCE.getWindowManagerClass();
                if (windowManagerClass == null || (method = windowManagerClass.getMethod("getInstance", null)) == null) {
                    return null;
                }
                return method.invoke(null, null);
            }
        });
        mViewsField$delegate = LazyKt.lazy(lazyThreadSafetyMode, new Function0() { // from class: io.sentry.android.replay.WindowManagerSpy$mViewsField$2
            @Override // kotlin.jvm.functions.Function0
            public final Field invoke() throws NoSuchFieldException {
                Class windowManagerClass = WindowManagerSpy.INSTANCE.getWindowManagerClass();
                if (windowManagerClass == null) {
                    return null;
                }
                Field declaredField = windowManagerClass.getDeclaredField("mViews");
                declaredField.setAccessible(true);
                return declaredField;
            }
        });
        $stable = 8;
    }

    private final Object getWindowManagerInstance() {
        return windowManagerInstance$delegate.getValue();
    }

    private final Field getMViewsField() {
        return (Field) mViewsField$delegate.getValue();
    }

    public final void swapWindowManagerGlobalMViews(Function1 swap) {
        Field mViewsField;
        Intrinsics.checkNotNullParameter(swap, "swap");
        try {
            Object windowManagerInstance = getWindowManagerInstance();
            if (windowManagerInstance == null || (mViewsField = INSTANCE.getMViewsField()) == null) {
                return;
            }
            Object obj = mViewsField.get(windowManagerInstance);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.util.ArrayList<android.view.View>{ kotlin.collections.TypeAliasesKt.ArrayList<android.view.View> }");
            mViewsField.set(windowManagerInstance, swap.invoke((ArrayList) obj));
        } catch (Throwable unused) {
        }
    }
}
