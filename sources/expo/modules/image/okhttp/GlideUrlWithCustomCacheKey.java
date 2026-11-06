package expo.modules.image.okhttp;

import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.Headers;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class GlideUrlWithCustomCacheKey extends GlideUrl {
    private final String cacheKey;
    private int hashCode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlideUrlWithCustomCacheKey(String str, Headers headers, String cacheKey) {
        super(str, headers);
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        this.cacheKey = cacheKey;
    }

    private final String getBaseCacheKey() {
        String cacheKey = super.getCacheKey();
        Intrinsics.checkNotNullExpressionValue(cacheKey, "getCacheKey(...)");
        return cacheKey;
    }

    @Override // com.bumptech.glide.load.model.GlideUrl
    public String getCacheKey() {
        return this.cacheKey;
    }

    @Override // com.bumptech.glide.load.model.GlideUrl, com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof GlideUrlWithCustomCacheKey) {
            GlideUrlWithCustomCacheKey glideUrlWithCustomCacheKey = (GlideUrlWithCustomCacheKey) obj;
            return Intrinsics.areEqual(getBaseCacheKey(), glideUrlWithCustomCacheKey.getBaseCacheKey()) && getHeaders().equals(glideUrlWithCustomCacheKey.getHeaders());
        }
        if (obj instanceof GlideUrl) {
            GlideUrl glideUrl = (GlideUrl) obj;
            if (Intrinsics.areEqual(getBaseCacheKey(), glideUrl.getCacheKey()) && getHeaders().equals(glideUrl.getHeaders())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bumptech.glide.load.model.GlideUrl, com.bumptech.glide.load.Key
    public int hashCode() {
        if (this.hashCode == 0) {
            int iHashCode = getBaseCacheKey().hashCode();
            this.hashCode = iHashCode;
            this.hashCode = (iHashCode * 31) + getHeaders().hashCode();
        }
        return this.hashCode;
    }
}
