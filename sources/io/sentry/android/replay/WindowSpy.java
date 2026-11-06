package io.sentry.android.replay;

import android.view.View;
import android.view.Window;
import java.lang.reflect.Field;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class WindowSpy {
    public static final int $stable;
    public static final WindowSpy INSTANCE = new WindowSpy();
    private static final Lazy decorViewClass$delegate;
    private static final Lazy windowField$delegate;

    private WindowSpy() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Class getDecorViewClass() {
        return (Class) decorViewClass$delegate.getValue();
    }

    static {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        decorViewClass$delegate = LazyKt.lazy(lazyThreadSafetyMode, new Function0() { // from class: io.sentry.android.replay.WindowSpy$decorViewClass$2
            @Override // kotlin.jvm.functions.Function0
            public final Class invoke() {
                try {
                    return Class.forName("com.android.internal.policy.DecorView");
                } catch (Throwable unused) {
                    return null;
                }
            }
        });
        windowField$delegate = LazyKt.lazy(lazyThreadSafetyMode, new Function0() { // from class: io.sentry.android.replay.WindowSpy$windowField$2
            @Override // kotlin.jvm.functions.Function0
            public final Field invoke() {
                Class decorViewClass = WindowSpy.INSTANCE.getDecorViewClass();
                if (decorViewClass == null) {
                    return null;
                }
                try {
                    Field declaredField = decorViewClass.getDeclaredField("mWindow");
                    declaredField.setAccessible(true);
                    return declaredField;
                } catch (NoSuchFieldException unused) {
                    decorViewClass.toString();
                    return null;
                }
            }
        });
        $stable = 8;
    }

    private final Field getWindowField() {
        return (Field) windowField$delegate.getValue();
    }

    public final Window pullWindow(View maybeDecorView) throws IllegalAccessException {
        Field windowField;
        Intrinsics.checkNotNullParameter(maybeDecorView, "maybeDecorView");
        Class decorViewClass = getDecorViewClass();
        if (decorViewClass == null || !decorViewClass.isInstance(maybeDecorView) || (windowField = INSTANCE.getWindowField()) == null) {
            return null;
        }
        Object obj = windowField.get(maybeDecorView);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.view.Window");
        return (Window) obj;
    }
}
