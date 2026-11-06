package com.bumptech.glide.load.engine;

/* JADX INFO: loaded from: classes3.dex */
public interface Resource {
    Object get();

    Class getResourceClass();

    int getSize();

    void recycle();
}
