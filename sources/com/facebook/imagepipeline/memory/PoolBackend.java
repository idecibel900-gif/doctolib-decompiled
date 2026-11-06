package com.facebook.imagepipeline.memory;

/* JADX INFO: loaded from: classes3.dex */
public interface PoolBackend {
    Object get(int i);

    int getSize(Object obj);

    Object pop();

    void put(Object obj);
}
