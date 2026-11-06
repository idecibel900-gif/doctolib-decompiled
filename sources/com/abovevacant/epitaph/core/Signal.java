package com.abovevacant.epitaph.core;

/* JADX INFO: loaded from: classes3.dex */
public final class Signal {
    public final int code;
    public final String codeName;
    public final long faultAddress;
    public final MemoryDump faultAdjacentMetadata;
    public final boolean hasFaultAddress;
    public final boolean hasSender;
    public final String name;
    public final int number;
    public final int senderPid;
    public final int senderUid;

    public Signal(int i, String str, int i2, String str2, boolean z, int i3, int i4, boolean z2, long j, MemoryDump memoryDump) {
        this.number = i;
        this.name = str;
        this.code = i2;
        this.codeName = str2;
        this.hasSender = z;
        this.senderUid = i3;
        this.senderPid = i4;
        this.hasFaultAddress = z2;
        this.faultAddress = j;
        this.faultAdjacentMetadata = memoryDump;
    }
}
