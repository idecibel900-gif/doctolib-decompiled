package com.reactnativekeyboardcontroller.managers;

import com.facebook.react.uimanager.ThemedReactContext;
import com.reactnativekeyboardcontroller.views.background.KeyboardBackgroundViewGroup;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class KeyboardBackgroundViewManagerImpl {
    public static final Companion Companion = new Companion(null);

    public final KeyboardBackgroundViewGroup createViewInstance(ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return new KeyboardBackgroundViewGroup(reactContext);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
