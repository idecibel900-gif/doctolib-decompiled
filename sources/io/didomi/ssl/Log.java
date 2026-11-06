package io.didomi.ssl;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Keep
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J\u001c\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J\u001c\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0006H\u0007J\u001c\u0010\u0016\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J\u001c\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R$\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lio/didomi/sdk/Log;", "", "()V", "TAG", "", "level", "", "getLevel$annotations", "getLevel", "()I", "setLevel", "(I)V", "d", "", "message", "throwable", "", "e", "i", "preventLogForLevel", "", "logLevel", "v", "w", "android_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Log {
    private static final String TAG = "Didomi";
    public static final Log INSTANCE = new Log();
    private static int level = 4;

    private Log() {
    }

    public static final void d(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        d$default(message, null, 2, null);
    }

    public static /* synthetic */ void d$default(String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        d(str, th);
    }

    public static final void e(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        e$default(message, null, 2, null);
    }

    public static /* synthetic */ void e$default(String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        e(str, th);
    }

    public static final int getLevel() {
        return level;
    }

    public static /* synthetic */ void getLevel$annotations() {
    }

    public static final void i(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        i$default(message, null, 2, null);
    }

    public static /* synthetic */ void i$default(String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        i(str, th);
    }

    public static final void setLevel(int i) {
        level = i;
    }

    public static final void v(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        v$default(message, null, 2, null);
    }

    public static /* synthetic */ void v$default(String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        v(str, th);
    }

    public static final void w(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        w$default(message, null, 2, null);
    }

    public static /* synthetic */ void w$default(String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        w(str, th);
    }

    public final boolean preventLogForLevel(int logLevel) {
        return level > logLevel;
    }

    public static final void d(String message, Throwable throwable) {
        Intrinsics.checkNotNullParameter(message, "message");
        INSTANCE.preventLogForLevel(3);
    }

    public static final void e(String message, Throwable throwable) {
        Intrinsics.checkNotNullParameter(message, "message");
        INSTANCE.preventLogForLevel(6);
    }

    public static final void i(String message, Throwable throwable) {
        Intrinsics.checkNotNullParameter(message, "message");
        INSTANCE.preventLogForLevel(4);
    }

    public static final void v(String message, Throwable throwable) {
        Intrinsics.checkNotNullParameter(message, "message");
        INSTANCE.preventLogForLevel(2);
    }

    public static final void w(String message, Throwable throwable) {
        Intrinsics.checkNotNullParameter(message, "message");
        INSTANCE.preventLogForLevel(5);
    }
}
