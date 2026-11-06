package com.facebook.react.uimanager.layoutanimation;

import android.view.View;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.annotations.internal.LegacyArchitectureLogLevel;
import com.facebook.react.common.annotations.internal.LegacyArchitectureLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public class LayoutAnimationController {
    public final void initializeFromConfig(ReadableMap readableMap, Callback callback) {
        LegacyArchitectureLogger.assertLegacyArchitecture("LayoutAnimationController", LegacyArchitectureLogLevel.ERROR);
    }

    public void reset() {
        LegacyArchitectureLogger.assertLegacyArchitecture("LayoutAnimationController", LegacyArchitectureLogLevel.ERROR);
    }

    public boolean shouldAnimateLayout(View view) {
        LegacyArchitectureLogger.assertLegacyArchitecture("LayoutAnimationController", LegacyArchitectureLogLevel.ERROR);
        return false;
    }

    public void applyLayoutUpdate(View view, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(view, "view");
        LegacyArchitectureLogger.assertLegacyArchitecture("LayoutAnimationController", LegacyArchitectureLogLevel.ERROR);
    }

    public void deleteView(View view, LayoutAnimationListener listener) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(listener, "listener");
        LegacyArchitectureLogger.assertLegacyArchitecture("LayoutAnimationController", LegacyArchitectureLogLevel.ERROR);
    }
}
