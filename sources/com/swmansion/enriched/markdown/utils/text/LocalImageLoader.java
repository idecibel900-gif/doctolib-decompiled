package com.swmansion.enriched.markdown.utils.text;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Base64;
import com.amazon.a.a.o.c.a.b;
import com.google.firebase.messaging.Constants;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Locale;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class LocalImageLoader {
    public static final LocalImageLoader INSTANCE = new LocalImageLoader();

    private LocalImageLoader() {
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final Bitmap load(Context context, String source) {
        String lowerCase;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        try {
            Uri uri = Uri.parse(source);
            String scheme = uri.getScheme();
            if (scheme != null) {
                lowerCase = scheme.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            } else {
                lowerCase = null;
            }
            if (lowerCase == null) {
                return StringsKt.startsWith$default((CharSequence) source, '/', false, 2, (Object) null) ? ImageDownloader.INSTANCE.decodeFileDownsampled(context, source) : decodeResourceByName(context, source);
            }
            switch (lowerCase.hashCode()) {
                case 112800:
                    if (lowerCase.equals("res")) {
                        Intrinsics.checkNotNull(uri);
                        return decodeResourceByName(context, schemelessPath(uri));
                    }
                    return null;
                case 3076010:
                    if (lowerCase.equals(Constants.ScionAnalytics.MessageType.DATA_MESSAGE)) {
                        return decodeDataUri(context, source);
                    }
                    return null;
                case 3143036:
                    if (!lowerCase.equals("file")) {
                        return null;
                    }
                    Intrinsics.checkNotNull(uri);
                    return loadFileUri(context, uri);
                case 93121264:
                    if (!lowerCase.equals("asset")) {
                        return null;
                    }
                    AssetManager assets = context.getAssets();
                    LocalImageLoader localImageLoader = INSTANCE;
                    Intrinsics.checkNotNull(uri);
                    InputStream inputStreamOpen = assets.open(localImageLoader.schemelessPath(uri));
                    Intrinsics.checkNotNullExpressionValue(inputStreamOpen, "open(...)");
                    try {
                        Bitmap bitmapDecodeBytesDownsampled = ImageDownloader.INSTANCE.decodeBytesDownsampled(context, ByteStreamsKt.readBytes(inputStreamOpen));
                        CloseableKt.closeFinally(inputStreamOpen, null);
                        return bitmapDecodeBytesDownsampled;
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.closeFinally(inputStreamOpen, th);
                            throw th2;
                        }
                    }
                case 951530617:
                    if (!lowerCase.equals("content")) {
                        return null;
                    }
                    InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
                    if (inputStreamOpenInputStream == null) {
                        throw new FileNotFoundException(source);
                    }
                    try {
                        Bitmap bitmapDecodeBytesDownsampled2 = ImageDownloader.INSTANCE.decodeBytesDownsampled(context, ByteStreamsKt.readBytes(inputStreamOpenInputStream));
                        CloseableKt.closeFinally(inputStreamOpenInputStream, null);
                        return bitmapDecodeBytesDownsampled2;
                    } catch (Throwable th3) {
                        try {
                            throw th3;
                        } catch (Throwable th4) {
                            CloseableKt.closeFinally(inputStreamOpenInputStream, th3);
                            throw th4;
                        }
                    }
                default:
                    return null;
            }
        } catch (Exception | OutOfMemoryError unused) {
            return null;
        }
    }

    private final Bitmap loadFileUri(Context context, Uri uri) throws IOException {
        String path = uri.getPath();
        if (path == null) {
            return null;
        }
        if (StringsKt.startsWith$default(path, "/android_asset/", false, 2, (Object) null)) {
            InputStream inputStreamOpen = context.getAssets().open(StringsKt.removePrefix(path, "/android_asset/"));
            Intrinsics.checkNotNullExpressionValue(inputStreamOpen, "open(...)");
            try {
                Bitmap bitmapDecodeBytesDownsampled = ImageDownloader.INSTANCE.decodeBytesDownsampled(context, ByteStreamsKt.readBytes(inputStreamOpen));
                CloseableKt.closeFinally(inputStreamOpen, null);
                return bitmapDecodeBytesDownsampled;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(inputStreamOpen, th);
                    throw th2;
                }
            }
        }
        if (StringsKt.startsWith$default(path, "/android_res/", false, 2, (Object) null)) {
            return decodeAndroidRes(context, uri);
        }
        return ImageDownloader.INSTANCE.decodeFileDownsampled(context, path);
    }

    private final Bitmap decodeAndroidRes(Context context, Uri uri) throws IOException {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() < 3) {
            return null;
        }
        String str = pathSegments.get(1);
        Intrinsics.checkNotNullExpressionValue(str, "get(...)");
        String strSubstringBefore$default = StringsKt.substringBefore$default(str, '-', (String) null, 2, (Object) null);
        String str2 = pathSegments.get(2);
        Intrinsics.checkNotNullExpressionValue(str2, "get(...)");
        int identifier = context.getResources().getIdentifier(StringsKt.substringBeforeLast$default(str2, b.a, (String) null, 2, (Object) null), strSubstringBefore$default, context.getPackageName());
        if (identifier == 0) {
            return null;
        }
        InputStream inputStreamOpenRawResource = context.getResources().openRawResource(identifier);
        Intrinsics.checkNotNullExpressionValue(inputStreamOpenRawResource, "openRawResource(...)");
        try {
            Bitmap bitmapDecodeBytesDownsampled = ImageDownloader.INSTANCE.decodeBytesDownsampled(context, ByteStreamsKt.readBytes(inputStreamOpenRawResource));
            CloseableKt.closeFinally(inputStreamOpenRawResource, null);
            return bitmapDecodeBytesDownsampled;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(inputStreamOpenRawResource, th);
                throw th2;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0024 A[PHI: r0
      0x0024: PHI (r0v14 java.lang.Integer) = (r0v2 java.lang.Integer), (r0v6 java.lang.Integer) binds: [B:6:0x0022, B:12:0x0043] A[DONT_GENERATE, DONT_INLINE]] */
    private final Bitmap decodeResourceByName(Context context, String str) throws IOException {
        int identifier;
        if (str.length() == 0) {
            return null;
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String strReplace$default = StringsKt.replace$default(lowerCase, '-', '_', false, 4, (Object) null);
        Integer intOrNull = StringsKt.toIntOrNull(strReplace$default);
        if (intOrNull != null) {
            identifier = intOrNull.intValue();
        } else {
            intOrNull = Integer.valueOf(context.getResources().getIdentifier(strReplace$default, "drawable", context.getPackageName()));
            if (intOrNull.intValue() == 0) {
                intOrNull = null;
            }
            if (intOrNull != null) {
                identifier = intOrNull.intValue();
            } else {
                identifier = context.getResources().getIdentifier(strReplace$default, "raw", context.getPackageName());
            }
        }
        if (identifier == 0) {
            return null;
        }
        InputStream inputStreamOpenRawResource = context.getResources().openRawResource(identifier);
        Intrinsics.checkNotNullExpressionValue(inputStreamOpenRawResource, "openRawResource(...)");
        try {
            Bitmap bitmapDecodeBytesDownsampled = ImageDownloader.INSTANCE.decodeBytesDownsampled(context, ByteStreamsKt.readBytes(inputStreamOpenRawResource));
            CloseableKt.closeFinally(inputStreamOpenRawResource, null);
            return bitmapDecodeBytesDownsampled;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(inputStreamOpenRawResource, th);
                throw th2;
            }
        }
    }

    private final Bitmap decodeDataUri(Context context, String str) {
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str, "base64,", 0, false, 6, (Object) null);
        if (iIndexOf$default == -1) {
            return null;
        }
        String strSubstring = str.substring(iIndexOf$default + 7);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        byte[] bArrDecode = Base64.decode(strSubstring, 0);
        ImageDownloader imageDownloader = ImageDownloader.INSTANCE;
        Intrinsics.checkNotNull(bArrDecode);
        return imageDownloader.decodeBytesDownsampled(context, bArrDecode);
    }

    private final String schemelessPath(Uri uri) {
        String host = uri.getHost();
        if (host == null) {
            host = "";
        }
        String path = uri.getPath();
        return StringsKt.trimStart(host + (path != null ? path : ""), '/');
    }
}
