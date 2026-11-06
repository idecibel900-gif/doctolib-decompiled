package com.facebook.common.memory;

/* JADX INFO: loaded from: classes3.dex */
public class NoOpMemoryTrimmableRegistry implements MemoryTrimmableRegistry {
    private static NoOpMemoryTrimmableRegistry sInstance;

    @Override // com.facebook.common.memory.MemoryTrimmableRegistry
    public void registerMemoryTrimmable(MemoryTrimmable memoryTrimmable) {
    }

    public static synchronized NoOpMemoryTrimmableRegistry getInstance() {
        try {
            if (sInstance == null) {
                sInstance = new NoOpMemoryTrimmableRegistry();
            }
        } catch (Throwable th) {
            throw th;
        }
        return sInstance;
    }
}
