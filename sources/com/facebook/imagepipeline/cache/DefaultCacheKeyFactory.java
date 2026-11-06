package com.facebook.imagepipeline.cache;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.Postprocessor;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultCacheKeyFactory implements CacheKeyFactory {
    private static DefaultCacheKeyFactory sInstance = null;
    private static boolean sShouldRemoveCallerContextFromCacheKey = false;

    protected Uri getCacheKeySourceUri(Uri uri) {
        return uri;
    }

    protected DefaultCacheKeyFactory() {
    }

    public static synchronized DefaultCacheKeyFactory getInstance() {
        try {
            if (sInstance == null) {
                sInstance = new DefaultCacheKeyFactory();
            }
        } catch (Throwable th) {
            throw th;
        }
        return sInstance;
    }

    @Override // com.facebook.imagepipeline.cache.CacheKeyFactory
    public CacheKey getBitmapCacheKey(ImageRequest imageRequest, Object obj) {
        BitmapMemoryCacheKey bitmapMemoryCacheKey = new BitmapMemoryCacheKey(getCacheKeySourceUri(imageRequest.getSourceUri()).toString(), imageRequest.getResizeOptions(), imageRequest.getRotationOptions(), imageRequest.getImageDecodeOptions(), null, null);
        if (sShouldRemoveCallerContextFromCacheKey) {
            bitmapMemoryCacheKey.setCallerContext(null);
            return bitmapMemoryCacheKey;
        }
        bitmapMemoryCacheKey.setCallerContext(obj);
        return bitmapMemoryCacheKey;
    }

    @Override // com.facebook.imagepipeline.cache.CacheKeyFactory
    public CacheKey getPostprocessedBitmapCacheKey(ImageRequest imageRequest, Object obj) {
        CacheKey cacheKey;
        String name;
        Postprocessor postprocessor = imageRequest.getPostprocessor();
        if (postprocessor != null) {
            CacheKey postprocessorCacheKey = postprocessor.getPostprocessorCacheKey();
            name = postprocessor.getClass().getName();
            cacheKey = postprocessorCacheKey;
        } else {
            cacheKey = null;
            name = null;
        }
        BitmapMemoryCacheKey bitmapMemoryCacheKey = new BitmapMemoryCacheKey(getCacheKeySourceUri(imageRequest.getSourceUri()).toString(), imageRequest.getResizeOptions(), imageRequest.getRotationOptions(), imageRequest.getImageDecodeOptions(), cacheKey, name);
        if (sShouldRemoveCallerContextFromCacheKey) {
            bitmapMemoryCacheKey.setCallerContext(null);
            return bitmapMemoryCacheKey;
        }
        bitmapMemoryCacheKey.setCallerContext(obj);
        return bitmapMemoryCacheKey;
    }

    @Override // com.facebook.imagepipeline.cache.CacheKeyFactory
    public CacheKey getEncodedCacheKey(ImageRequest imageRequest, Object obj) {
        return getEncodedCacheKey(imageRequest, imageRequest.getSourceUri(), obj);
    }

    @Override // com.facebook.imagepipeline.cache.CacheKeyFactory
    public CacheKey getEncodedCacheKey(ImageRequest imageRequest, Uri uri, Object obj) {
        return new SimpleCacheKey(getCacheKeySourceUri(uri).toString());
    }
}
