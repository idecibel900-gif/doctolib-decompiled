package io.sentry.android.replay.util;

import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class MainLooperHandler {
    private final Handler handler;

    public MainLooperHandler(Looper looper) {
        Intrinsics.checkNotNullParameter(looper, "looper");
        this.handler = new Handler(looper);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ MainLooperHandler(Looper looper, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            looper = Looper.getMainLooper();
            Intrinsics.checkNotNullExpressionValue(looper, "getMainLooper(...)");
        }
        this(looper);
    }

    public final Handler getHandler() {
        return this.handler;
    }

    public final boolean post(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        return this.handler.post(runnable);
    }

    public final boolean postDelayed(Runnable runnable, long j) {
        Handler handler = this.handler;
        if (runnable == null) {
            return false;
        }
        return handler.postDelayed(runnable, j);
    }

    public final void removeCallbacks(Runnable runnable) {
        Handler handler = this.handler;
        if (runnable == null) {
            return;
        }
        handler.removeCallbacks(runnable);
    }
}
