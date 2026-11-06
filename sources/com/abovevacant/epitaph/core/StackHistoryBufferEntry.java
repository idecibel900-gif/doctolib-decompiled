package com.abovevacant.epitaph.core;

/* JADX INFO: loaded from: classes3.dex */
public final class StackHistoryBufferEntry {
    public final BacktraceFrame addr;
    public final long fp;
    public final long tag;

    public StackHistoryBufferEntry(BacktraceFrame backtraceFrame, long j, long j2) {
        this.addr = backtraceFrame;
        this.fp = j;
        this.tag = j2;
    }
}
