package androidx.window;

import androidx.window.reflection.ReflectionUtils;
import java.lang.reflect.Method;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class SafeWindowExtensionsProvider {
    private final ClassLoader loader;

    public SafeWindowExtensionsProvider(ClassLoader loader) {
        Intrinsics.checkNotNullParameter(loader, "loader");
        this.loader = loader;
    }

    public final Class getWindowExtensionsClass$window_release() throws ClassNotFoundException {
        Class<?> clsLoadClass = this.loader.loadClass("androidx.window.extensions.WindowExtensions");
        Intrinsics.checkNotNullExpressionValue(clsLoadClass, "loader.loadClass(WindowE….WINDOW_EXTENSIONS_CLASS)");
        return clsLoadClass;
    }

    public final boolean isWindowExtensionsValid$window_release() {
        return isWindowExtensionsPresent() && ReflectionUtils.validateReflection$window_release("WindowExtensionsProvider#getWindowExtensions is not valid", new Function0() { // from class: androidx.window.SafeWindowExtensionsProvider$isWindowExtensionsValid$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() throws NoSuchMethodException, ClassNotFoundException {
                Method getWindowExtensionsMethod = this.this$0.getWindowExtensionsProviderClass().getDeclaredMethod("getWindowExtensions", null);
                Class windowExtensionsClass$window_release = this.this$0.getWindowExtensionsClass$window_release();
                ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(getWindowExtensionsMethod, "getWindowExtensionsMethod");
                return Boolean.valueOf(reflectionUtils.doesReturn$window_release(getWindowExtensionsMethod, windowExtensionsClass$window_release) && reflectionUtils.isPublic$window_release(getWindowExtensionsMethod));
            }
        });
    }

    private final boolean isWindowExtensionsPresent() {
        return ReflectionUtils.INSTANCE.checkIsPresent$window_release(new Function0() { // from class: androidx.window.SafeWindowExtensionsProvider.isWindowExtensionsPresent.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Class invoke() throws ClassNotFoundException {
                Class<?> clsLoadClass = SafeWindowExtensionsProvider.this.loader.loadClass("androidx.window.extensions.WindowExtensionsProvider");
                Intrinsics.checkNotNullExpressionValue(clsLoadClass, "loader.loadClass(WindowE…XTENSIONS_PROVIDER_CLASS)");
                return clsLoadClass;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Class getWindowExtensionsProviderClass() throws ClassNotFoundException {
        Class<?> clsLoadClass = this.loader.loadClass("androidx.window.extensions.WindowExtensionsProvider");
        Intrinsics.checkNotNullExpressionValue(clsLoadClass, "loader.loadClass(WindowE…XTENSIONS_PROVIDER_CLASS)");
        return clsLoadClass;
    }
}
