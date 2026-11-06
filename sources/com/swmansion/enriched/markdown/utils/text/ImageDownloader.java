package com.swmansion.enriched.markdown.utils.text;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes4.dex */
public final class ImageDownloader {
    private static volatile OkHttpClient client;
    private static int maxTargetWidth;
    public static final ImageDownloader INSTANCE = new ImageDownloader();
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());
    private static final HashMap inFlight = new HashMap();

    private ImageDownloader() {
    }

    private final OkHttpClient getClient(Context context) {
        OkHttpClient okHttpClientBuildClient;
        OkHttpClient okHttpClient = client;
        if (okHttpClient != null) {
            return okHttpClient;
        }
        synchronized (this) {
            okHttpClientBuildClient = client;
            if (okHttpClientBuildClient == null) {
                okHttpClientBuildClient = INSTANCE.buildClient(context);
                client = okHttpClientBuildClient;
                maxTargetWidth = context.getApplicationContext().getResources().getDisplayMetrics().widthPixels;
            }
        }
        return okHttpClientBuildClient;
    }

    private final OkHttpClient buildClient(Context context) {
        OkHttpClient.Builder builderCache = new OkHttpClient.Builder().cache(new Cache(new File(context.getApplicationContext().getCacheDir(), "enrm_image_cache"), 104857600L));
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return builderCache.connectTimeout(15L, timeUnit).readTimeout(15L, timeUnit).build();
    }

    public final void download(Context context, final String url, Map headers, Function1 callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ImageCache imageCache = ImageCache.INSTANCE;
        final String strRequestKey = imageCache.requestKey(url, headers);
        Bitmap original = imageCache.getOriginal(strRequestKey);
        if (original != null) {
            callback.invoke(original);
            return;
        }
        HashMap map = inFlight;
        synchronized (map) {
            List list = (List) map.get(strRequestKey);
            if (list != null) {
                list.add(callback);
                return;
            }
            map.put(strRequestKey, CollectionsKt.mutableListOf(callback));
            Unit unit = Unit.INSTANCE;
            Request.Builder builderUrl = new Request.Builder().url(url);
            for (Map.Entry entry : headers.entrySet()) {
                builderUrl.addHeader((String) entry.getKey(), (String) entry.getValue());
            }
            getClient(context).newCall(builderUrl.build()).enqueue(new Callback() { // from class: com.swmansion.enriched.markdown.utils.text.ImageDownloader.download.3
                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) throws IOException {
                    Bitmap bitmapDecodeDownsampled;
                    byte[] bArrBytes;
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    try {
                        ResponseBody responseBodyBody = response.body();
                        bitmapDecodeDownsampled = (responseBodyBody == null || (bArrBytes = responseBodyBody.bytes()) == null) ? null : ImageDownloader.INSTANCE.decodeDownsampled(bArrBytes, ImageDownloader.maxTargetWidth);
                    } catch (Exception | OutOfMemoryError unused) {
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.closeFinally(response, th);
                            throw th2;
                        }
                    }
                    CloseableKt.closeFinally(response, null);
                    if (bitmapDecodeDownsampled != null) {
                        ImageCache.INSTANCE.putOriginal(strRequestKey, bitmapDecodeDownsampled);
                    }
                    ImageDownloader.INSTANCE.dispatchCallbacks(strRequestKey, bitmapDecodeDownsampled);
                }

                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException e) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(e, "e");
                    ImageDownloader.INSTANCE.dispatchCallbacks(strRequestKey, null);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap decodeDownsampled(byte[] bArr, int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        int i2 = options.outWidth;
        if (i2 <= 0 || options.outHeight <= 0) {
            return null;
        }
        options.inSampleSize = calculateInSampleSize(i2, i);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
    }

    public final Bitmap decodeBytesDownsampled(Context context, byte[] bytes) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return decodeDownsampled(bytes, context.getResources().getDisplayMetrics().widthPixels);
    }

    public final Bitmap decodeFileDownsampled(Context context, String path) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(path, "path");
        int i = context.getResources().getDisplayMetrics().widthPixels;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);
        int i2 = options.outWidth;
        if (i2 <= 0 || options.outHeight <= 0) {
            return null;
        }
        options.inSampleSize = calculateInSampleSize(i2, i);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(path, options);
    }

    private final int calculateInSampleSize(int i, int i2) {
        if (i < 0 || i > i2) {
            return Integer.highestOneBit(i / i2);
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatchCallbacks(String str, final Bitmap bitmap) {
        final List list;
        HashMap map = inFlight;
        synchronized (map) {
            list = (List) map.remove(str);
        }
        if (list == null) {
            return;
        }
        mainHandler.post(new Runnable() { // from class: com.swmansion.enriched.markdown.utils.text.ImageDownloader$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ImageDownloader.dispatchCallbacks$lambda$12(list, bitmap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dispatchCallbacks$lambda$12(List list, Bitmap bitmap) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Function1) it.next()).invoke(bitmap);
        }
    }
}
