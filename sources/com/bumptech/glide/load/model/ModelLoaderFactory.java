package com.bumptech.glide.load.model;

/* JADX INFO: loaded from: classes3.dex */
public interface ModelLoaderFactory {
    ModelLoader build(MultiModelLoaderFactory multiModelLoaderFactory);

    void teardown();
}
