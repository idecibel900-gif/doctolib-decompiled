package com.facebook.imagepipeline.cache;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class BitmapMemoryCacheKey implements CacheKey {
    private Object callerContext;
    private final int hash;
    private final ImageDecodeOptions imageDecodeOptions;
    private final long inBitmapCacheSince;
    private final CacheKey postprocessorCacheKey;
    private final String postprocessorName;
    private final ResizeOptions resizeOptions;
    private final RotationOptions rotationOptions;
    private final String sourceString;

    @Override // com.facebook.cache.common.CacheKey
    public boolean isResourceIdForDebugging() {
        return false;
    }

    public String toString() {
        return "BitmapMemoryCacheKey(sourceString=" + this.sourceString + ", resizeOptions=" + this.resizeOptions + ", rotationOptions=" + this.rotationOptions + ", imageDecodeOptions=" + this.imageDecodeOptions + ", postprocessorCacheKey=" + this.postprocessorCacheKey + ", postprocessorName=" + this.postprocessorName + ")";
    }

    public BitmapMemoryCacheKey(String sourceString, ResizeOptions resizeOptions, RotationOptions rotationOptions, ImageDecodeOptions imageDecodeOptions, CacheKey cacheKey, String str) {
        Intrinsics.checkNotNullParameter(sourceString, "sourceString");
        Intrinsics.checkNotNullParameter(rotationOptions, "rotationOptions");
        Intrinsics.checkNotNullParameter(imageDecodeOptions, "imageDecodeOptions");
        this.sourceString = sourceString;
        this.resizeOptions = resizeOptions;
        this.rotationOptions = rotationOptions;
        this.imageDecodeOptions = imageDecodeOptions;
        this.postprocessorCacheKey = cacheKey;
        this.postprocessorName = str;
        this.hash = (((((((((sourceString.hashCode() * 31) + (resizeOptions != null ? resizeOptions.hashCode() : 0)) * 31) + rotationOptions.hashCode()) * 31) + imageDecodeOptions.hashCode()) * 31) + (cacheKey != null ? cacheKey.hashCode() : 0)) * 31) + (str != null ? str.hashCode() : 0);
        this.inBitmapCacheSince = RealtimeSinceBootClock.get().now();
    }

    public final void setCallerContext(Object obj) {
        this.callerContext = obj;
    }

    public int hashCode() {
        return this.hash;
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean containsUri(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        String uriString = getUriString();
        String string = uri.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return StringsKt.contains$default((CharSequence) uriString, (CharSequence) string, false, 2, (Object) null);
    }

    @Override // com.facebook.cache.common.CacheKey
    public String getUriString() {
        return this.sourceString;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(BitmapMemoryCacheKey.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.facebook.imagepipeline.cache.BitmapMemoryCacheKey");
        BitmapMemoryCacheKey bitmapMemoryCacheKey = (BitmapMemoryCacheKey) obj;
        return Intrinsics.areEqual(this.sourceString, bitmapMemoryCacheKey.sourceString) && Intrinsics.areEqual(this.resizeOptions, bitmapMemoryCacheKey.resizeOptions) && Intrinsics.areEqual(this.rotationOptions, bitmapMemoryCacheKey.rotationOptions) && Intrinsics.areEqual(this.imageDecodeOptions, bitmapMemoryCacheKey.imageDecodeOptions) && Intrinsics.areEqual(this.postprocessorCacheKey, bitmapMemoryCacheKey.postprocessorCacheKey) && Intrinsics.areEqual(this.postprocessorName, bitmapMemoryCacheKey.postprocessorName);
    }
}
