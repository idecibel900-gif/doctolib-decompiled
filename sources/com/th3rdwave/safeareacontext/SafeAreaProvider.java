package com.th3rdwave.safeareacontext;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.facebook.react.views.view.ReactViewGroup;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class SafeAreaProvider extends ReactViewGroup implements ViewTreeObserver.OnPreDrawListener {
    private Function3 mInsetsChangeHandler;
    private Rect mLastFrame;
    private EdgeInsets mLastInsets;

    public SafeAreaProvider(Context context) {
        super(context);
    }

    private final void maybeUpdateInsets() {
        EdgeInsets safeAreaInsets;
        Function3 function3 = this.mInsetsChangeHandler;
        if (function3 == null || (safeAreaInsets = SafeAreaUtilsKt.getSafeAreaInsets(this)) == null) {
            return;
        }
        View rootView = getRootView();
        Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
        Rect frame = SafeAreaUtilsKt.getFrame((ViewGroup) rootView, this);
        if (frame == null) {
            return;
        }
        if (Intrinsics.areEqual(this.mLastInsets, safeAreaInsets) && Intrinsics.areEqual(this.mLastFrame, frame)) {
            return;
        }
        function3.invoke(this, safeAreaInsets, frame);
        this.mLastInsets = safeAreaInsets;
        this.mLastFrame = frame;
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnPreDrawListener(this);
        maybeUpdateInsets();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnPreDrawListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        maybeUpdateInsets();
        return true;
    }

    public final void setOnInsetsChangeHandler(Function3 function3) {
        this.mInsetsChangeHandler = function3;
        maybeUpdateInsets();
    }
}
