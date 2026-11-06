package com.abovevacant.epitaph.core;

/* JADX INFO: loaded from: classes3.dex */
public final class Cause {
    public final String humanReadable;
    public final MemoryError memoryError;

    public Cause(String str, MemoryError memoryError) {
        this.humanReadable = str;
        this.memoryError = memoryError;
    }
}
