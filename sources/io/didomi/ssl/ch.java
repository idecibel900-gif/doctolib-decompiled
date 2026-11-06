package io.didomi.ssl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\t\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\b¨\u0006\u000e"}, d2 = {"Lio/didomi/sdk/ch;", "", "", "message", "", "b", "a", "", "J", "startTime", "c", "lastTime", "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class ch {
    public static final ch a = new ch();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private static long startTime;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private static long lastTime;

    private ch() {
    }

    public static /* synthetic */ void a(ch chVar, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "Starting time measure";
        }
        chVar.b(str);
    }

    public final void b(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        long jCurrentTimeMillis = System.currentTimeMillis();
        startTime = jCurrentTimeMillis;
        lastTime = jCurrentTimeMillis;
        Log.v$default("TIME MEASUREMENT - " + message, null, 2, null);
    }

    public final void a(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        long jCurrentTimeMillis = System.currentTimeMillis();
        Log.v$default("TIME MEASUREMENT - " + (jCurrentTimeMillis - lastTime) + "ms since last measure - " + (jCurrentTimeMillis - startTime) + "ms since start -- Log : " + message, null, 2, null);
        lastTime = jCurrentTimeMillis;
    }
}
