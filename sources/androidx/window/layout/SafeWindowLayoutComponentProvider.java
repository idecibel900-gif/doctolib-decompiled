package androidx.window.layout;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import androidx.window.SafeWindowExtensionsProvider;
import androidx.window.core.ConsumerAdapter;
import androidx.window.core.ExtensionsUtil;
import androidx.window.extensions.WindowExtensionsProvider;
import androidx.window.extensions.core.util.function.Consumer;
import androidx.window.extensions.layout.WindowLayoutComponent;
import androidx.window.reflection.ReflectionUtils;
import java.lang.reflect.Method;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes3.dex */
public final class SafeWindowLayoutComponentProvider {
    private final ConsumerAdapter consumerAdapter;
    private final ClassLoader loader;
    private final SafeWindowExtensionsProvider safeWindowExtensionsProvider;

    public SafeWindowLayoutComponentProvider(ClassLoader loader, ConsumerAdapter consumerAdapter) {
        Intrinsics.checkNotNullParameter(loader, "loader");
        Intrinsics.checkNotNullParameter(consumerAdapter, "consumerAdapter");
        this.loader = loader;
        this.consumerAdapter = consumerAdapter;
        this.safeWindowExtensionsProvider = new SafeWindowExtensionsProvider(loader);
    }

    public final WindowLayoutComponent getWindowLayoutComponent() {
        if (!canUseWindowLayoutComponent()) {
            return null;
        }
        try {
            return WindowExtensionsProvider.getWindowExtensions().getWindowLayoutComponent();
        } catch (UnsupportedOperationException unused) {
            return null;
        }
    }

    private final boolean canUseWindowLayoutComponent() {
        if (!isWindowLayoutComponentAccessible$window_release()) {
            return false;
        }
        int safeVendorApiLevel = ExtensionsUtil.INSTANCE.getSafeVendorApiLevel();
        if (safeVendorApiLevel == 1) {
            return hasValidVendorApiLevel1$window_release();
        }
        if (2 > safeVendorApiLevel || safeVendorApiLevel > Integer.MAX_VALUE) {
            return false;
        }
        return hasValidVendorApiLevel2$window_release();
    }

    public final boolean isWindowLayoutComponentAccessible$window_release() {
        return this.safeWindowExtensionsProvider.isWindowExtensionsValid$window_release() && isWindowLayoutProviderValid() && isFoldingFeatureValid();
    }

    public final boolean hasValidVendorApiLevel1$window_release() {
        return isMethodWindowLayoutInfoListenerJavaConsumerValid();
    }

    public final boolean hasValidVendorApiLevel2$window_release() {
        return hasValidVendorApiLevel1$window_release() && isMethodWindowLayoutInfoListenerWindowConsumerValid();
    }

    private final boolean isWindowLayoutProviderValid() {
        return ReflectionUtils.validateReflection$window_release("WindowExtensions#getWindowLayoutComponent is not valid", new Function0() { // from class: androidx.window.layout.SafeWindowLayoutComponentProvider.isWindowLayoutProviderValid.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() throws NoSuchMethodException, ClassNotFoundException {
                Method getWindowLayoutComponentMethod = SafeWindowLayoutComponentProvider.this.safeWindowExtensionsProvider.getWindowExtensionsClass$window_release().getMethod("getWindowLayoutComponent", null);
                Class windowLayoutComponentClass = SafeWindowLayoutComponentProvider.this.getWindowLayoutComponentClass();
                ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(getWindowLayoutComponentMethod, "getWindowLayoutComponentMethod");
                return Boolean.valueOf(reflectionUtils.isPublic$window_release(getWindowLayoutComponentMethod) && reflectionUtils.doesReturn$window_release(getWindowLayoutComponentMethod, windowLayoutComponentClass));
            }
        });
    }

    private final boolean isFoldingFeatureValid() {
        return ReflectionUtils.validateReflection$window_release("FoldingFeature class is not valid", new Function0() { // from class: androidx.window.layout.SafeWindowLayoutComponentProvider.isFoldingFeatureValid.1
            {
                super(0);
            }

            /* JADX WARN: Code duplicated, block: B:15:0x0060  */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() throws NoSuchMethodException, ClassNotFoundException {
                boolean z;
                Class foldingFeatureClass = SafeWindowLayoutComponentProvider.this.getFoldingFeatureClass();
                Method getBoundsMethod = foldingFeatureClass.getMethod("getBounds", null);
                Method getTypeMethod = foldingFeatureClass.getMethod("getType", null);
                Method getStateMethod = foldingFeatureClass.getMethod("getState", null);
                ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(getBoundsMethod, "getBoundsMethod");
                if (reflectionUtils.doesReturn$window_release(getBoundsMethod, Reflection.getOrCreateKotlinClass(Rect.class)) && reflectionUtils.isPublic$window_release(getBoundsMethod)) {
                    Intrinsics.checkNotNullExpressionValue(getTypeMethod, "getTypeMethod");
                    Class cls = Integer.TYPE;
                    if (reflectionUtils.doesReturn$window_release(getTypeMethod, Reflection.getOrCreateKotlinClass(cls)) && reflectionUtils.isPublic$window_release(getTypeMethod)) {
                        Intrinsics.checkNotNullExpressionValue(getStateMethod, "getStateMethod");
                        if (reflectionUtils.doesReturn$window_release(getStateMethod, Reflection.getOrCreateKotlinClass(cls)) && reflectionUtils.isPublic$window_release(getStateMethod)) {
                            z = true;
                        } else {
                            z = false;
                        }
                    } else {
                        z = false;
                    }
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        });
    }

    private final boolean isMethodWindowLayoutInfoListenerJavaConsumerValid() {
        return ReflectionUtils.validateReflection$window_release("WindowLayoutComponent#addWindowLayoutInfoListener(" + Activity.class.getName() + ", java.util.function.Consumer) is not valid", new Function0() { // from class: androidx.window.layout.SafeWindowLayoutComponentProvider.isMethodWindowLayoutInfoListenerJavaConsumerValid.1
            {
                super(0);
            }

            /* JADX WARN: Code duplicated, block: B:11:0x0045  */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() throws NoSuchMethodException, ClassNotFoundException {
                boolean z;
                Class clsConsumerClassOrNull$window_release = SafeWindowLayoutComponentProvider.this.consumerAdapter.consumerClassOrNull$window_release();
                if (clsConsumerClassOrNull$window_release == null) {
                    return Boolean.FALSE;
                }
                Class windowLayoutComponentClass = SafeWindowLayoutComponentProvider.this.getWindowLayoutComponentClass();
                Method addListenerMethod = windowLayoutComponentClass.getMethod("addWindowLayoutInfoListener", Activity.class, clsConsumerClassOrNull$window_release);
                Method removeListenerMethod = windowLayoutComponentClass.getMethod("removeWindowLayoutInfoListener", clsConsumerClassOrNull$window_release);
                ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(addListenerMethod, "addListenerMethod");
                if (reflectionUtils.isPublic$window_release(addListenerMethod)) {
                    Intrinsics.checkNotNullExpressionValue(removeListenerMethod, "removeListenerMethod");
                    if (reflectionUtils.isPublic$window_release(removeListenerMethod)) {
                        z = true;
                    } else {
                        z = false;
                    }
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        });
    }

    private final boolean isMethodWindowLayoutInfoListenerWindowConsumerValid() {
        return ReflectionUtils.validateReflection$window_release("WindowLayoutComponent#addWindowLayoutInfoListener(" + Context.class.getName() + ", androidx.window.extensions.core.util.function.Consumer) is not valid", new Function0() { // from class: androidx.window.layout.SafeWindowLayoutComponentProvider.isMethodWindowLayoutInfoListenerWindowConsumerValid.1
            {
                super(0);
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0038  */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() throws NoSuchMethodException, ClassNotFoundException {
                boolean z;
                Class windowLayoutComponentClass = SafeWindowLayoutComponentProvider.this.getWindowLayoutComponentClass();
                Method addListenerMethod = windowLayoutComponentClass.getMethod("addWindowLayoutInfoListener", Context.class, Consumer.class);
                Method removeListenerMethod = windowLayoutComponentClass.getMethod("removeWindowLayoutInfoListener", Consumer.class);
                ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(addListenerMethod, "addListenerMethod");
                if (reflectionUtils.isPublic$window_release(addListenerMethod)) {
                    Intrinsics.checkNotNullExpressionValue(removeListenerMethod, "removeListenerMethod");
                    if (reflectionUtils.isPublic$window_release(removeListenerMethod)) {
                        z = true;
                    } else {
                        z = false;
                    }
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Class getFoldingFeatureClass() throws ClassNotFoundException {
        Class<?> clsLoadClass = this.loader.loadClass("androidx.window.extensions.layout.FoldingFeature");
        Intrinsics.checkNotNullExpressionValue(clsLoadClass, "loader.loadClass(FOLDING_FEATURE_CLASS)");
        return clsLoadClass;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Class getWindowLayoutComponentClass() throws ClassNotFoundException {
        Class<?> clsLoadClass = this.loader.loadClass("androidx.window.extensions.layout.WindowLayoutComponent");
        Intrinsics.checkNotNullExpressionValue(clsLoadClass, "loader.loadClass(WINDOW_LAYOUT_COMPONENT_CLASS)");
        return clsLoadClass;
    }
}
