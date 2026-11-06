package io.sentry.android.core.anr;

import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public class AggregatedStackTrace {
    int count = 1;
    final int depth;
    private long endTimeMs;
    final float quality;
    private final StackTraceElement[] stack;
    private final int stackEndIdx;
    private final int stackStartIdx;
    private long startTimeMs;

    public AggregatedStackTrace(StackTraceElement[] stackTraceElementArr, int i, int i2, long j, float f) {
        this.stack = stackTraceElementArr;
        this.stackStartIdx = i;
        this.stackEndIdx = i2;
        this.depth = (i2 - i) + 1;
        this.startTimeMs = j;
        this.endTimeMs = j;
        this.quality = f;
    }

    public void addOccurrence(long j) {
        this.startTimeMs = Math.min(this.startTimeMs, j);
        this.endTimeMs = Math.max(this.endTimeMs, j);
        this.count++;
    }

    public StackTraceElement[] getStack() {
        return (StackTraceElement[]) Arrays.copyOfRange(this.stack, this.stackStartIdx, this.stackEndIdx + 1);
    }
}
