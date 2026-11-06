package com.swmansion.rnscreens;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.Choreographer;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.uimanager.ThemedReactContext;
import com.swmansion.rnscreens.utils.InsetsKtKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public class CustomToolbar extends Toolbar {
    private final ScreenStackHeaderConfig config;
    private boolean isForceShadowStateUpdateOnLayoutRequested;
    private boolean isLayoutEnqueued;
    private Insets lastInsets;
    private final Choreographer.FrameCallback layoutCallback;
    private boolean shouldApplyLayoutCorrectionForTopInset;
    private final boolean shouldApplyTopInset;
    private final boolean shouldAvoidDisplayCutout;

    public final ScreenStackHeaderConfig getConfig() {
        return this.config;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomToolbar(Context context, ScreenStackHeaderConfig config) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
        this.shouldAvoidDisplayCutout = true;
        this.shouldApplyTopInset = true;
        Insets NONE = Insets.NONE;
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        this.lastInsets = NONE;
        getMenu();
        this.layoutCallback = new Choreographer.FrameCallback() { // from class: com.swmansion.rnscreens.CustomToolbar$layoutCallback$1
            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j) {
                this.this$0.isLayoutEnqueued = false;
                CustomToolbar customToolbar = this.this$0;
                customToolbar.measure(View.MeasureSpec.makeMeasureSpec(customToolbar.getWidth(), LinearLayoutManager.INVALID_OFFSET), View.MeasureSpec.makeMeasureSpec(this.this$0.getHeight(), LinearLayoutManager.INVALID_OFFSET));
                CustomToolbar customToolbar2 = this.this$0;
                customToolbar2.layout(customToolbar2.getLeft(), this.this$0.getTop(), this.this$0.getRight(), this.this$0.getBottom());
            }
        };
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        Window window;
        WindowManager.LayoutParams attributes;
        super.requestLayout();
        ViewParent parent = getParent();
        Integer numValueOf = null;
        CustomAppBarLayout customAppBarLayout = parent instanceof CustomAppBarLayout ? (CustomAppBarLayout) parent : null;
        if (customAppBarLayout != null && this.shouldApplyLayoutCorrectionForTopInset && !customAppBarLayout.isInLayout()) {
            customAppBarLayout.applyToolbarLayoutCorrection$react_native_screens_release(getPaddingTop());
            this.shouldApplyLayoutCorrectionForTopInset = false;
        }
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.uimanager.ThemedReactContext");
        Activity currentActivity = ((ThemedReactContext) context).getCurrentActivity();
        if (currentActivity != null && (window = currentActivity.getWindow()) != null && (attributes = window.getAttributes()) != null) {
            numValueOf = Integer.valueOf(attributes.softInputMode);
        }
        if (Build.VERSION.SDK_INT > 29 || numValueOf == null || numValueOf.intValue() != 32 || this.isLayoutEnqueued || this.layoutCallback == null) {
            return;
        }
        this.isLayoutEnqueued = true;
        ReactChoreographer.Companion.getInstance().postFrameCallback(ReactChoreographer.CallbackType.NATIVE_ANIMATED_MODULE, this.layoutCallback);
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        WindowInsets windowInsetsOnApplyWindowInsets = super.onApplyWindowInsets(windowInsets);
        Insets insetsResolveInsetsOrZero$default = InsetsKtKt.resolveInsetsOrZero$default(this, WindowInsetsCompat.Type.displayCutout(), windowInsetsOnApplyWindowInsets, false, 4, null);
        Insets insetsResolveInsetsOrZero$default2 = InsetsKtKt.resolveInsetsOrZero$default(this, WindowInsetsCompat.Type.systemBars(), windowInsetsOnApplyWindowInsets, false, 4, null);
        Insets insetsOf = Insets.of(insetsResolveInsetsOrZero$default.left + insetsResolveInsetsOrZero$default2.left, 0, insetsResolveInsetsOrZero$default.right + insetsResolveInsetsOrZero$default2.right, 0);
        Intrinsics.checkNotNullExpressionValue(insetsOf, "of(...)");
        Insets insetsOf2 = Insets.of(0, Math.max(insetsResolveInsetsOrZero$default.top, this.shouldApplyTopInset ? insetsResolveInsetsOrZero$default2.top : 0), 0, Math.max(insetsResolveInsetsOrZero$default.bottom, 0));
        Intrinsics.checkNotNullExpressionValue(insetsOf2, "of(...)");
        Insets insetsAdd = Insets.add(insetsOf, insetsOf2);
        Intrinsics.checkNotNullExpressionValue(insetsAdd, "add(...)");
        if (!Intrinsics.areEqual(this.lastInsets, insetsAdd)) {
            this.lastInsets = insetsAdd;
            applyExactPadding(insetsAdd.left, insetsAdd.top, insetsAdd.right, insetsAdd.bottom);
        }
        return windowInsetsOnApplyWindowInsets;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.config.onNativeToolbarLayout(this, z || this.isForceShadowStateUpdateOnLayoutRequested);
        this.isForceShadowStateUpdateOnLayoutRequested = false;
    }

    public final void updateContentInsets() {
        setContentInsetStartWithNavigation(this.config.getPreferredContentInsetStartWithNavigation());
        setContentInsetsRelative(this.config.getPreferredContentInsetStart(), this.config.getPreferredContentInsetEnd());
    }

    private final void applyExactPadding(int i, int i2, int i3, int i4) {
        this.shouldApplyLayoutCorrectionForTopInset = true;
        requestForceShadowStateUpdateOnLayout();
        setPadding(i, i2, i3, i4);
    }

    private final void requestForceShadowStateUpdateOnLayout() {
        this.isForceShadowStateUpdateOnLayoutRequested = this.shouldAvoidDisplayCutout;
    }
}
