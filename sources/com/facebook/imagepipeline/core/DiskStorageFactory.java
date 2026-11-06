package com.facebook.imagepipeline.core;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.cache.disk.DiskStorage;

/* JADX INFO: loaded from: classes3.dex */
public interface DiskStorageFactory {
    DiskStorage get(DiskCacheConfig diskCacheConfig);
}
