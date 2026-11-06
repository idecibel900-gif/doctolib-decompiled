package com.facebook.common.media;

import com.amazon.a.a.o.c.a.b;
import java.util.Locale;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class MediaUtils {
    public static final MediaUtils INSTANCE = new MediaUtils();
    public static final Map ADDITIONAL_ALLOWED_MIME_TYPES = MapsKt.mapOf(TuplesKt.to("mkv", "video/x-matroska"), TuplesKt.to("glb", "model/gltf-binary"));

    private MediaUtils() {
    }

    public static final boolean isVideo(String str) {
        if (str != null) {
            return StringsKt.startsWith$default(str, "video/", false, 2, (Object) null);
        }
        return false;
    }

    public static final String extractMime(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        String strExtractExtension = INSTANCE.extractExtension(path);
        if (strExtractExtension == null) {
            return null;
        }
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = strExtractExtension.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        if (lowerCase == null) {
            return null;
        }
        String mimeTypeFromExtension = MimeTypeMapWrapper.getMimeTypeFromExtension(lowerCase);
        return mimeTypeFromExtension == null ? (String) ADDITIONAL_ALLOWED_MIME_TYPES.get(lowerCase) : mimeTypeFromExtension;
    }

    private final String extractExtension(String str) {
        int iLastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str, b.a, 0, false, 6, (Object) null);
        if (iLastIndexOf$default < 0 || iLastIndexOf$default == str.length() - 1) {
            return null;
        }
        String strSubstring = str.substring(iLastIndexOf$default + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }
}
