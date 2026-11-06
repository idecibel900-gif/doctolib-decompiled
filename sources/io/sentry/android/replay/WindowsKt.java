package io.sentry.android.replay;

import android.view.View;
import android.view.Window;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public abstract class WindowsKt {
    public static final Window getPhoneWindow(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        WindowSpy windowSpy = WindowSpy.INSTANCE;
        View rootView = view.getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "getRootView(...)");
        return windowSpy.pullWindow(rootView);
    }
}
