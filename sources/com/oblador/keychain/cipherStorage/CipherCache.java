package com.oblador.keychain.cipherStorage;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.crypto.Cipher;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class CipherCache {
    public static final CipherCache INSTANCE = new CipherCache();
    private static final String LOG_TAG = CipherCache.class.getSimpleName();
    private static final ThreadLocal cipherCache = new ThreadLocal();

    private CipherCache() {
    }

    public final Cipher getCipher(String transformation) {
        Cipher cipher;
        Intrinsics.checkNotNullParameter(transformation, "transformation");
        synchronized (this) {
            try {
                ThreadLocal threadLocal = cipherCache;
                Map linkedHashMap = (Map) threadLocal.get();
                if (linkedHashMap == null) {
                    linkedHashMap = new LinkedHashMap();
                    threadLocal.set(linkedHashMap);
                }
                Object cipher2 = linkedHashMap.get(transformation);
                if (cipher2 == null) {
                    cipher2 = Cipher.getInstance(transformation);
                    Intrinsics.checkNotNullExpressionValue(cipher2, "getInstance(...)");
                    linkedHashMap.put(transformation, cipher2);
                }
                cipher = (Cipher) cipher2;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cipher;
    }

    public final void clearCache() {
        try {
            cipherCache.remove();
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
