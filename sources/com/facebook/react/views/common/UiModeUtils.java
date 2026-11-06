package com.facebook.react.views.common;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class UiModeUtils {
    public static final UiModeUtils INSTANCE = new UiModeUtils();

    private UiModeUtils() {
    }

    public static final boolean isDarkMode(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }
}
