package com.facebook.systrace;

import androidx.tracing.Trace;
import com.amazon.a.a.o.b.f;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class Systrace {
    public static final Systrace INSTANCE = new Systrace();

    public static final boolean isTracing(long j) {
        return false;
    }

    public static final void registerListener(TraceListener traceListener) {
    }

    public static final void traceInstant(long j, String str, EventScope eventScope) {
    }

    public static final void unregisterListener(TraceListener traceListener) {
    }

    private Systrace() {
    }

    public static final void traceSection(long j, String sectionName, Runnable block) {
        Intrinsics.checkNotNullParameter(sectionName, "sectionName");
        Intrinsics.checkNotNullParameter(block, "block");
        beginSection(j, sectionName);
        try {
            block.run();
        } finally {
            endSection(j);
        }
    }

    public static final void beginSection(long j, String sectionName) {
        Intrinsics.checkNotNullParameter(sectionName, "sectionName");
        Trace.beginSection(sectionName);
    }

    public static final void beginSection(long j, String sectionName, String[] args, int i) {
        Intrinsics.checkNotNullParameter(sectionName, "sectionName");
        Intrinsics.checkNotNullParameter(args, "args");
        Trace.beginSection(sectionName + f.c + INSTANCE.convertArgsToText(args, i));
    }

    private final String convertArgsToText(String[] strArr, int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 1; i2 < i; i2 += 2) {
            String str = strArr[i2 - 1];
            String str2 = strArr[i2];
            sb.append(str);
            sb.append('=');
            sb.append(str2);
            if (i2 < i - 1) {
                sb.append(';');
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static final void endSection(long j) {
        Trace.endSection();
    }

    public static final void beginAsyncSection(long j, String sectionName, int i) {
        Intrinsics.checkNotNullParameter(sectionName, "sectionName");
        Trace.beginAsyncSection(sectionName, i);
    }

    public static final void beginAsyncSection(long j, String sectionName, int i, long j2) {
        Intrinsics.checkNotNullParameter(sectionName, "sectionName");
        beginAsyncSection(j, sectionName, i);
    }

    public static final void endAsyncSection(long j, String sectionName, int i) {
        Intrinsics.checkNotNullParameter(sectionName, "sectionName");
        Trace.endAsyncSection(sectionName, i);
    }

    public static final void endAsyncSection(long j, String sectionName, int i, long j2) {
        Intrinsics.checkNotNullParameter(sectionName, "sectionName");
        endAsyncSection(j, sectionName, i);
    }

    public static final void traceCounter(long j, String counterName, int i) {
        Intrinsics.checkNotNullParameter(counterName, "counterName");
        Trace.setCounter(counterName, i);
    }

    public static final void startAsyncFlow(long j, String sectionName, int i) {
        Intrinsics.checkNotNullParameter(sectionName, "sectionName");
        beginAsyncSection(j, sectionName, i);
    }

    public static final void endAsyncFlow(long j, String sectionName, int i) {
        Intrinsics.checkNotNullParameter(sectionName, "sectionName");
        endAsyncSection(j, sectionName, i);
    }

    public enum EventScope {
        THREAD('t'),
        PROCESS('p'),
        GLOBAL('g');

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
        private final char code;

        EventScope(char c) {
            this.code = c;
        }
    }
}
