package com.facebook.cache.common;

import com.adjust.sdk.Constants;
import com.facebook.common.util.SecureHashUtil;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class CacheKeyUtil {
    public static final CacheKeyUtil INSTANCE = new CacheKeyUtil();

    private CacheKeyUtil() {
    }

    public static final List getResourceIds(CacheKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            if (key instanceof MultiCacheKey) {
                List cacheKeys = ((MultiCacheKey) key).getCacheKeys();
                Intrinsics.checkNotNullExpressionValue(cacheKeys, "getCacheKeys(...)");
                ArrayList arrayList = new ArrayList(cacheKeys.size());
                int size = cacheKeys.size();
                for (int i = 0; i < size; i++) {
                    CacheKeyUtil cacheKeyUtil = INSTANCE;
                    Object obj = cacheKeys.get(i);
                    Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                    arrayList.add(cacheKeyUtil.secureHashKey((CacheKey) obj));
                }
                return arrayList;
            }
            ArrayList arrayList2 = new ArrayList(1);
            arrayList2.add(key.isResourceIdForDebugging() ? key.getUriString() : INSTANCE.secureHashKey(key));
            return arrayList2;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static final String getFirstResourceId(CacheKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            if (key instanceof MultiCacheKey) {
                List cacheKeys = ((MultiCacheKey) key).getCacheKeys();
                Intrinsics.checkNotNullExpressionValue(cacheKeys, "getCacheKeys(...)");
                CacheKeyUtil cacheKeyUtil = INSTANCE;
                Object obj = cacheKeys.get(0);
                Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                return cacheKeyUtil.secureHashKey((CacheKey) obj);
            }
            return INSTANCE.secureHashKey(key);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    private final String secureHashKey(CacheKey cacheKey) {
        String uriString = cacheKey.getUriString();
        Intrinsics.checkNotNullExpressionValue(uriString, "getUriString(...)");
        Charset charsetForName = Charset.forName(Constants.ENCODING);
        Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(...)");
        byte[] bytes = uriString.getBytes(charsetForName);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        String strMakeSHA1HashBase64 = SecureHashUtil.makeSHA1HashBase64(bytes);
        Intrinsics.checkNotNullExpressionValue(strMakeSHA1HashBase64, "makeSHA1HashBase64(...)");
        return strMakeSHA1HashBase64;
    }
}
