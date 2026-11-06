package com.facebook.react.views.safeareaview;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.common.build.ReactBuildConfig;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ReactSafeAreaView extends ViewGroup {
    private final ThemedReactContext reactContext;
    private StateWrapper stateWrapper;

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactSafeAreaView(ThemedReactContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
    }

    public final ThemedReactContext getReactContext() {
        return this.reactContext;
    }

    public final StateWrapper getStateWrapper$ReactAndroid_release() {
        return this.stateWrapper;
    }

    public final void setStateWrapper$ReactAndroid_release(StateWrapper stateWrapper) {
        this.stateWrapper = stateWrapper;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener() { // from class: com.facebook.react.views.safeareaview.ReactSafeAreaView$$ExternalSyntheticLambda0
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return ReactSafeAreaView.onAttachedToWindow$lambda$0(this.f$0, view, windowInsetsCompat);
            }
        });
        requestApplyInsets();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat onAttachedToWindow$lambda$0(ReactSafeAreaView reactSafeAreaView, View view, WindowInsetsCompat windowInsets) {
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        Intrinsics.checkNotNullParameter(windowInsets, "windowInsets");
        Insets insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout());
        Intrinsics.checkNotNullExpressionValue(insets, "getInsets(...)");
        reactSafeAreaView.updateState(insets);
        return WindowInsetsCompat.CONSUMED;
    }

    private final void updateState(final Insets insets) {
        StateWrapper stateWrapper = this.stateWrapper;
        if (stateWrapper != null) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            PixelUtil pixelUtil = PixelUtil.INSTANCE;
            writableNativeMap.putDouble("left", pixelUtil.pxToDp(insets.left));
            writableNativeMap.putDouble("top", pixelUtil.pxToDp(insets.top));
            writableNativeMap.putDouble("bottom", pixelUtil.pxToDp(insets.bottom));
            writableNativeMap.putDouble("right", pixelUtil.pxToDp(insets.right));
            stateWrapper.updateState(writableNativeMap);
            return;
        }
        if (ReactBuildConfig.UNSTABLE_ENABLE_MINIFY_LEGACY_ARCHITECTURE) {
            return;
        }
        ThemedReactContext themedReactContext = this.reactContext;
        themedReactContext.runOnNativeModulesQueueThread(new GuardedRunnable(themedReactContext) { // from class: com.facebook.react.views.safeareaview.ReactSafeAreaView.updateState.2
            @Override // com.facebook.react.bridge.GuardedRunnable
            public void runGuarded() {
                UIManagerModule uIManagerModule = (UIManagerModule) ReactSafeAreaView.this.getReactContext().getReactApplicationContext().getNativeModule(UIManagerModule.class);
                if (uIManagerModule != null) {
                    int id = ReactSafeAreaView.this.getId();
                    Insets insets2 = insets;
                    uIManagerModule.updateInsetsPadding(id, insets2.top, insets2.left, insets2.bottom, insets2.right);
                }
            }
        });
    }
}
