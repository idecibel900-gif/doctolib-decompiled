package com.facebook.cache.common;

import android.net.Uri;
import com.facebook.common.internal.Preconditions;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class MultiCacheKey implements CacheKey {
    final List mCacheKeys;

    @Override // com.facebook.cache.common.CacheKey
    public boolean isResourceIdForDebugging() {
        return false;
    }

    public MultiCacheKey(List list) {
        this.mCacheKeys = (List) Preconditions.checkNotNull(list);
    }

    public List getCacheKeys() {
        return this.mCacheKeys;
    }

    public String toString() {
        return "MultiCacheKey:" + this.mCacheKeys.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MultiCacheKey) {
            return this.mCacheKeys.equals(((MultiCacheKey) obj).mCacheKeys);
        }
        return false;
    }

    public int hashCode() {
        return this.mCacheKeys.hashCode();
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean containsUri(Uri uri) {
        for (int i = 0; i < this.mCacheKeys.size(); i++) {
            if (((CacheKey) this.mCacheKeys.get(i)).containsUri(uri)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.cache.common.CacheKey
    public String getUriString() {
        return ((CacheKey) this.mCacheKeys.get(0)).getUriString();
    }
}
