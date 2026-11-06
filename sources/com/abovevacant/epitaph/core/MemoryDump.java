package com.abovevacant.epitaph.core;

/* JADX INFO: loaded from: classes3.dex */
public final class MemoryDump {
    public final ArmMTEMetadata armMteMetadata;
    public final long beginAddress;
    public final String mappingName;
    public final byte[] memory;
    public final String registerName;

    public MemoryDump(String str, String str2, long j, byte[] bArr, ArmMTEMetadata armMTEMetadata) {
        this.registerName = str;
        this.mappingName = str2;
        this.beginAddress = j;
        this.memory = bArr;
        this.armMteMetadata = armMTEMetadata;
    }
}
