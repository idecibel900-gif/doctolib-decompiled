package com.facebook.react.uimanager;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.widget.EditText;
import androidx.core.view.ViewCompat;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.common.annotations.internal.LegacyArchitectureLogLevel;
import com.facebook.react.common.annotations.internal.LegacyArchitectureLogger;
import com.facebook.react.common.build.ReactBuildConfig;
import com.facebook.react.uimanager.common.ViewUtil;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.EventDispatcherProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class UIManagerHelper {
    public static final UIManagerHelper INSTANCE = new UIManagerHelper();

    private UIManagerHelper() {
    }

    public static final UIManager getUIManagerForReactTag(ReactContext context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        return getUIManager(context, ViewUtil.getUIManagerType(i));
    }

    public static final UIManager getUIManager(ReactContext context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        return getUIManager(context, i, true);
    }

    private static final UIManager getUIManager(ReactContext reactContext, int i, boolean z) {
        if (ReactBuildConfig.UNSTABLE_ENABLE_MINIFY_LEGACY_ARCHITECTURE || reactContext.isBridgeless()) {
            UIManager fabricUIManager = reactContext.getFabricUIManager();
            if (fabricUIManager != null) {
                return fabricUIManager;
            }
            ReactSoftExceptionLogger.logSoftException("UIManagerHelper", new ReactNoCrashSoftException("Cannot get UIManager because the instance hasn't been initialized yet."));
            return null;
        }
        LegacyArchitectureLogger.assertLegacyArchitecture("UIManagerHelper.getUIManager(context, uiManagerType)", LegacyArchitectureLogLevel.ERROR);
        if (!reactContext.hasCatalystInstance()) {
            ReactSoftExceptionLogger.logSoftException("UIManagerHelper", new ReactNoCrashSoftException("Cannot get UIManager because the context doesn't contain a CatalystInstance."));
            return null;
        }
        if (!reactContext.hasActiveReactInstance()) {
            ReactSoftExceptionLogger.logSoftException("UIManagerHelper", new ReactNoCrashSoftException("Cannot get UIManager because the context doesn't contain an active CatalystInstance."));
            if (z) {
                return null;
            }
        }
        CatalystInstance catalystInstance = reactContext.getCatalystInstance();
        Intrinsics.checkNotNullExpressionValue(catalystInstance, "getCatalystInstance(...)");
        try {
            return i == 2 ? reactContext.getFabricUIManager() : (UIManager) catalystInstance.getNativeModule(UIManagerModule.class);
        } catch (IllegalArgumentException unused) {
            ReactSoftExceptionLogger.logSoftException("UIManagerHelper", new ReactNoCrashSoftException("Cannot get UIManager for UIManagerType: " + i));
            return (UIManager) catalystInstance.getNativeModule(UIManagerModule.class);
        }
    }

    public static final EventDispatcher getEventDispatcherForReactTag(ReactContext context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        EventDispatcher eventDispatcher = getEventDispatcher(context, ViewUtil.getUIManagerType(i));
        if (eventDispatcher == null) {
            ReactSoftExceptionLogger.logSoftException("UIManagerHelper", new IllegalStateException("Cannot get EventDispatcher for reactTag " + i));
        }
        return eventDispatcher;
    }

    public static final EventDispatcher getEventDispatcher(ReactContext context, int i) {
        Object reactApplicationContext;
        Intrinsics.checkNotNullParameter(context, "context");
        if (context.isBridgeless()) {
            if (context instanceof ThemedReactContext) {
                reactApplicationContext = context;
                reactApplicationContext = ((ThemedReactContext) context).getReactApplicationContext();
            }
            reactApplicationContext = context;
            Intrinsics.checkNotNull(reactApplicationContext, "null cannot be cast to non-null type com.facebook.react.uimanager.events.EventDispatcherProvider");
            return ((EventDispatcherProvider) reactApplicationContext).getEventDispatcher();
        }
        UIManager uIManager = getUIManager(context, i, false);
        if (uIManager == null) {
            ReactSoftExceptionLogger.logSoftException("UIManagerHelper", new ReactNoCrashSoftException("Unable to find UIManager for UIManagerType " + i));
            return null;
        }
        EventDispatcher eventDispatcher = uIManager.getEventDispatcher();
        if (eventDispatcher == null) {
            ReactSoftExceptionLogger.logSoftException("UIManagerHelper", new IllegalStateException("Cannot get EventDispatcher for UIManagerType " + i));
        }
        return eventDispatcher;
    }

    public static final ReactContext getReactContext(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Context context = view.getContext();
        if (!(context instanceof ReactContext) && (context instanceof ContextWrapper)) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        return (ReactContext) context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final int getSurfaceId(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view instanceof ReactRoot) {
            ReactRoot reactRoot = (ReactRoot) view;
            if (reactRoot.getUIManagerType() == 2) {
                return reactRoot.getRootViewTag();
            }
            return -1;
        }
        int id = view.getId();
        if (ViewUtil.getUIManagerType(id) == 1) {
            return -1;
        }
        Context context = view.getContext();
        if (!(context instanceof ThemedReactContext) && (context instanceof ContextWrapper)) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        int surfaceId = getSurfaceId(context);
        if (surfaceId == -1) {
            ReactSoftExceptionLogger.logSoftException("UIManagerHelper", new IllegalStateException("Fabric View [" + id + "] does not have SurfaceId associated with it"));
        }
        return surfaceId;
    }

    public static final int getSurfaceId(Context context) {
        if (context instanceof ThemedReactContext) {
            return ((ThemedReactContext) context).getSurfaceId();
        }
        return -1;
    }

    public static final float[] getDefaultTextInputPadding(Context context) {
        EditText editText = new EditText(context);
        return new float[]{PixelUtil.toDIPFromPixel(ViewCompat.getPaddingStart(editText)), PixelUtil.toDIPFromPixel(ViewCompat.getPaddingEnd(editText)), PixelUtil.toDIPFromPixel(editText.getPaddingTop()), PixelUtil.toDIPFromPixel(editText.getPaddingBottom())};
    }
}
