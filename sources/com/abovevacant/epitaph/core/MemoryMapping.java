package com.abovevacant.epitaph.core;

/* JADX INFO: loaded from: classes3.dex */
public final class MemoryMapping {
    public final long beginAddress;
    public final String buildId;
    public final long endAddress;
    public final boolean execute;
    public final long loadBias;
    public final String mappingName;
    public final long offset;
    public final boolean read;
    public final boolean write;

    public MemoryMapping(long j, long j2, long j3, boolean z, boolean z2, boolean z3, String str, String str2, long j4) {
        this.beginAddress = j;
        this.endAddress = j2;
        this.offset = j3;
        this.read = z;
        this.write = z2;
        this.execute = z3;
        this.mappingName = str;
        this.buildId = str2;
        this.loadBias = j4;
    }
}
