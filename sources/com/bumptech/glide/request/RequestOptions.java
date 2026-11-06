package com.bumptech.glide.request;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/* JADX INFO: loaded from: classes3.dex */
public class RequestOptions extends BaseRequestOptions {
    private static RequestOptions skipMemoryCacheFalseOptions;
    private static RequestOptions skipMemoryCacheTrueOptions;

    public static RequestOptions diskCacheStrategyOf(DiskCacheStrategy diskCacheStrategy) {
        return (RequestOptions) new RequestOptions().diskCacheStrategy(diskCacheStrategy);
    }

    public static RequestOptions skipMemoryCacheOf(boolean z) {
        if (z) {
            if (skipMemoryCacheTrueOptions == null) {
                skipMemoryCacheTrueOptions = (RequestOptions) ((RequestOptions) new RequestOptions().skipMemoryCache(true)).autoClone();
            }
            return skipMemoryCacheTrueOptions;
        }
        if (skipMemoryCacheFalseOptions == null) {
            skipMemoryCacheFalseOptions = (RequestOptions) ((RequestOptions) new RequestOptions().skipMemoryCache(false)).autoClone();
        }
        return skipMemoryCacheFalseOptions;
    }

    public static RequestOptions signatureOf(Key key) {
        return (RequestOptions) new RequestOptions().signature(key);
    }

    public static RequestOptions decodeTypeOf(Class cls) {
        return (RequestOptions) new RequestOptions().decode(cls);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public boolean equals(Object obj) {
        return (obj instanceof RequestOptions) && super.equals(obj);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public int hashCode() {
        return super.hashCode();
    }
}
