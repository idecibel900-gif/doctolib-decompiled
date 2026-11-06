package com.abovevacant.epitaph.core;

/* JADX INFO: loaded from: classes3.dex */
public final class BacktraceFrame {
    public final String buildId;
    public final long fileMapOffset;
    public final String fileName;
    public final String functionName;
    public final long functionOffset;
    public final long pc;
    public final long relPc;
    public final long sp;

    public BacktraceFrame(long j, long j2, long j3, String str, long j4, String str2, long j5, String str3) {
        this.relPc = j;
        this.pc = j2;
        this.sp = j3;
        this.functionName = str;
        this.functionOffset = j4;
        this.fileName = str2;
        this.fileMapOffset = j5;
        this.buildId = str3;
    }
}
