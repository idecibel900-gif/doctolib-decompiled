package com.datadog.android.core.internal.logger;

import android.util.Log;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class LogcatLogHandler {
    public static final Companion Companion = new Companion(null);
    private final Function1 predicate;
    private final String tag;

    public LogcatLogHandler(String tag, Function1 predicate) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        this.tag = tag;
        this.predicate = predicate;
    }

    public /* synthetic */ LogcatLogHandler(String str, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? new Function1() { // from class: com.datadog.android.core.internal.logger.LogcatLogHandler.1
            public final Boolean invoke(int i2) {
                return Boolean.TRUE;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }
        } : function1);
    }

    public final boolean canLog(int i) {
        return ((Boolean) this.predicate.invoke(Integer.valueOf(i))).booleanValue();
    }

    public final void log(int i, String message, Throwable th) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (((Boolean) this.predicate.invoke(Integer.valueOf(i))).booleanValue()) {
            String strResolveTag = resolveTag();
            Log.println(i, strResolveTag, message);
            if (th != null) {
                Log.println(i, strResolveTag, Log.getStackTraceString(th));
            }
        }
    }

    private final String resolveTag() {
        this.tag.length();
        return this.tag;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
