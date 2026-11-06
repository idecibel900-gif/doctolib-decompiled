package com.facebook.cache.common;

import android.net.Uri;

/* JADX INFO: loaded from: classes3.dex */
public interface CacheKey {
    boolean containsUri(Uri uri);

    String getUriString();

    boolean isResourceIdForDebugging();
}
