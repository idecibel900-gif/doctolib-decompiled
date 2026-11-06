package com.reactnativekeyboardcontroller.managers;

import com.facebook.react.uimanager.ThemedReactContext;
import com.reactnativekeyboardcontroller.views.KeyboardGestureAreaReactViewGroup;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class KeyboardGestureAreaViewManagerImpl {
    public static final Companion Companion = new Companion(null);

    public final KeyboardGestureAreaReactViewGroup createViewInstance(ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return new KeyboardGestureAreaReactViewGroup(reactContext);
    }

    public final void setOffset(KeyboardGestureAreaReactViewGroup view, double d) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setOffset(d);
    }

    public final void setInterpolator(KeyboardGestureAreaReactViewGroup view, String interpolator) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(interpolator, "interpolator");
        view.setInterpolator(interpolator);
    }

    public final void setScrollKeyboardOffScreenWhenVisible(KeyboardGestureAreaReactViewGroup view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setScrollKeyboardOffScreenWhenVisible(z);
    }

    public final void setScrollKeyboardOnScreenWhenNotVisible(KeyboardGestureAreaReactViewGroup view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setScrollKeyboardOnScreenWhenNotVisible(z);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
