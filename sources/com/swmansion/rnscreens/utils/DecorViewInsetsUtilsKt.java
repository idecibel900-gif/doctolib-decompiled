package com.swmansion.rnscreens.utils;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class DecorViewInsetsUtilsKt {
    public static final int getDecorViewTopInset(View decorView) {
        Intrinsics.checkNotNullParameter(decorView, "decorView");
        WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(decorView);
        if (rootWindowInsets == null) {
            return 0;
        }
        return getTopInset(rootWindowInsets);
    }

    private static final int getTopInset(WindowInsetsCompat windowInsetsCompat) {
        return windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout()).top;
    }

    public static final Boolean isSoftKeyboardVisibleOrNull(View decorView) {
        Intrinsics.checkNotNullParameter(decorView, "decorView");
        WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(decorView);
        if (rootWindowInsets == null) {
            return null;
        }
        return Boolean.valueOf(rootWindowInsets.isVisible(WindowInsetsCompat.Type.ime()));
    }
}
