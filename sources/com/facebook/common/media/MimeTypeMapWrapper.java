package com.facebook.common.media;

import android.webkit.MimeTypeMap;
import com.facebook.common.internal.ImmutableMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class MimeTypeMapWrapper {
    private static final MimeTypeMap sMimeTypeMap = MimeTypeMap.getSingleton();
    private static final Map sMimeTypeToExtensionMap = ImmutableMap.of("image/heif", "heif", "image/heic", "heic");
    private static final Map sExtensionToMimeTypeMap = ImmutableMap.of("heif", "image/heif", "heic", "image/heic");

    public static String getMimeTypeFromExtension(String str) {
        String str2 = (String) sExtensionToMimeTypeMap.get(str);
        return str2 != null ? str2 : sMimeTypeMap.getMimeTypeFromExtension(str);
    }
}
