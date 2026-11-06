package com.reactnativekeyboardcontroller.views.background;

import android.content.res.Configuration;
import android.view.WindowInsets;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.views.view.ReactViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class KeyboardBackgroundViewGroup extends ReactViewGroup {
    private final ThemedReactContext reactContext;

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.View
    public void setBackgroundColor(int i) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KeyboardBackgroundViewGroup(ThemedReactContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        super.setBackgroundColor(SkinsKt.getInputMethodColor(this.reactContext));
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        super.setBackgroundColor(SkinsKt.getInputMethodColor(this.reactContext));
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        super.setBackgroundColor(SkinsKt.getInputMethodColor(this.reactContext));
        WindowInsets windowInsetsOnApplyWindowInsets = super.onApplyWindowInsets(windowInsets);
        Intrinsics.checkNotNullExpressionValue(windowInsetsOnApplyWindowInsets, "onApplyWindowInsets(...)");
        return windowInsetsOnApplyWindowInsets;
    }
}
