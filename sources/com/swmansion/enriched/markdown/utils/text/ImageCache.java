package com.swmansion.enriched.markdown.utils.text;

import android.graphics.Bitmap;
import android.util.LruCache;
import com.amazon.a.a.o.b.f;
import com.revenuecat.purchases.common.Constants;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes4.dex */
public final class ImageCache {
    public static final ImageCache INSTANCE;
    private static final LruCache originalCache;
    private static final LruCache processedCache;

    private ImageCache() {
    }

    static {
        ImageCache imageCache = new ImageCache();
        INSTANCE = imageCache;
        originalCache = imageCache.bitmapLruCache(20971520);
        processedCache = imageCache.bitmapLruCache(31457280);
    }

    public final String requestKey(String url, Map headers) throws NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headers, "headers");
        if (headers.isEmpty()) {
            return url;
        }
        String strJoinToString$default = CollectionsKt.joinToString$default(CollectionsKt.sortedWith(headers.entrySet(), new Comparator() { // from class: com.swmansion.enriched.markdown.utils.text.ImageCache$requestKey$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ComparisonsKt.compareValues((String) ((Map.Entry) obj).getKey(), (String) ((Map.Entry) obj2).getKey());
            }
        }), "\n", null, null, 0, null, new Function1() { // from class: com.swmansion.enriched.markdown.utils.text.ImageCache$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ImageCache.requestKey$lambda$1((Map.Entry) obj);
            }
        }, 30, null);
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = strJoinToString$default.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] bArrDigest = messageDigest.digest(bytes);
        Intrinsics.checkNotNull(bArrDigest);
        return url + f.c + ArraysKt.joinToString$default(bArrDigest, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.swmansion.enriched.markdown.utils.text.ImageCache$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ImageCache.requestKey$lambda$2(((Byte) obj).byteValue());
            }
        }, 30, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence requestKey$lambda$1(Map.Entry it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getKey() + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + it.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence requestKey$lambda$2(byte b) {
        String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public final Bitmap getOriginal(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return (Bitmap) originalCache.get(url);
    }

    public final void putOriginal(String url, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        originalCache.put(url, bitmap);
    }

    public final Bitmap getProcessed(String url, int i, int i2, int i3, String resizeMode) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(resizeMode, "resizeMode");
        return (Bitmap) processedCache.get(processedKey(url, i, i2, i3, resizeMode));
    }

    public final void putProcessed(String url, int i, int i2, int i3, String resizeMode, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(resizeMode, "resizeMode");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        processedCache.put(processedKey(url, i, i2, i3, resizeMode), bitmap);
    }

    private final String processedKey(String str, int i, int i2, int i3, String str2) {
        return str + "_w" + i + "_h" + i2 + "_r" + i3 + "_m" + str2;
    }

    private final LruCache bitmapLruCache(int i) {
        return new LruCache(i) { // from class: com.swmansion.enriched.markdown.utils.text.ImageCache.bitmapLruCache.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.util.LruCache
            public int sizeOf(String key, Bitmap value) {
                Intrinsics.checkNotNullParameter(key, "key");
                Intrinsics.checkNotNullParameter(value, "value");
                return value.getByteCount();
            }
        };
    }
}
