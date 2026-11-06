package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0;
import android.util.Base64;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.LottieCompositionCache;
import com.airbnb.lottie.parser.LottieCompositionMoshiParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;

/* JADX INFO: loaded from: classes3.dex */
public abstract class LottieCompositionFactory {
    private static final Map taskCache = new HashMap();
    private static final Set taskIdleListeners = new HashSet();
    private static final byte[] ZIP_MAGIC = {80, 75, 3, 4};
    private static final byte[] GZIP_MAGIC = {31, -117, 8};

    public static LottieTask fromUrl(Context context, String str) {
        return fromUrl(context, str, "url_" + str);
    }

    public static LottieTask fromUrl(final Context context, final String str, final String str2) {
        return cache(str2, new Callable() { // from class: com.airbnb.lottie.LottieCompositionFactory$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LottieCompositionFactory.$r8$lambda$8IVBeWUOc6rgMkz15dajmpTCFXI(context, str, str2);
            }
        }, null);
    }

    public static /* synthetic */ LottieResult $r8$lambda$8IVBeWUOc6rgMkz15dajmpTCFXI(Context context, String str, String str2) {
        LottieResult lottieResultFetchSync = L.networkFetcher(context).fetchSync(context, str, str2);
        if (str2 != null && lottieResultFetchSync.getValue() != null) {
            LottieCompositionCache.getInstance().put(str2, (LottieComposition) lottieResultFetchSync.getValue());
        }
        return lottieResultFetchSync;
    }

    public static LottieTask fromAsset(Context context, String str) {
        return fromAsset(context, str, "asset_" + str);
    }

    public static LottieTask fromAsset(Context context, final String str, final String str2) {
        final Context applicationContext = context.getApplicationContext();
        return cache(str2, new Callable() { // from class: com.airbnb.lottie.LottieCompositionFactory$$ExternalSyntheticLambda5
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LottieCompositionFactory.fromAssetSync(applicationContext, str, str2);
            }
        }, null);
    }

    public static LottieResult fromAssetSync(Context context, String str) {
        return fromAssetSync(context, str, "asset_" + str);
    }

    public static LottieResult fromAssetSync(Context context, String str, String str2) {
        LottieComposition lottieComposition = str2 == null ? null : LottieCompositionCache.getInstance().get(str2);
        if (lottieComposition != null) {
            return new LottieResult(lottieComposition);
        }
        try {
            return fromInputStreamSync(context, context.getAssets().open(str), str2);
        } catch (IOException e) {
            return new LottieResult((Throwable) e);
        }
    }

    public static LottieResult fromInputStreamSync(Context context, InputStream inputStream, String str) {
        LottieComposition lottieComposition = str == null ? null : LottieCompositionCache.getInstance().get(str);
        if (lottieComposition != null) {
            return new LottieResult(lottieComposition);
        }
        try {
            BufferedSource bufferedSourceBuffer = Okio.buffer(Okio.source(inputStream));
            if (isZipCompressed(bufferedSourceBuffer).booleanValue()) {
                return fromZipStreamSync(context, new ZipInputStream(bufferedSourceBuffer.inputStream()), str);
            }
            if (isGzipCompressed(bufferedSourceBuffer).booleanValue()) {
                return fromJsonInputStreamSync(new GZIPInputStream(bufferedSourceBuffer.inputStream()), str);
            }
            return fromJsonReaderSync(JsonReader.of(bufferedSourceBuffer), str);
        } catch (IOException e) {
            return new LottieResult((Throwable) e);
        }
    }

    public static LottieTask fromRawRes(Context context, int i) {
        return fromRawRes(context, i, rawResCacheKey(context, i));
    }

    public static LottieTask fromRawRes(Context context, final int i, final String str) {
        final WeakReference weakReference = new WeakReference(context);
        final Context applicationContext = context.getApplicationContext();
        return cache(str, new Callable() { // from class: com.airbnb.lottie.LottieCompositionFactory$$ExternalSyntheticLambda8
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LottieCompositionFactory.$r8$lambda$9v9p2gRjDkigAhaar_d_38ecvlM(weakReference, applicationContext, i, str);
            }
        }, null);
    }

    public static /* synthetic */ LottieResult $r8$lambda$9v9p2gRjDkigAhaar_d_38ecvlM(WeakReference weakReference, Context context, int i, String str) {
        Context context2 = (Context) weakReference.get();
        if (context2 != null) {
            context = context2;
        }
        return fromRawResSync(context, i, str);
    }

    public static LottieResult fromRawResSync(Context context, int i) {
        return fromRawResSync(context, i, rawResCacheKey(context, i));
    }

    public static LottieResult fromRawResSync(Context context, int i, String str) {
        LottieComposition lottieComposition = str == null ? null : LottieCompositionCache.getInstance().get(str);
        if (lottieComposition != null) {
            return new LottieResult(lottieComposition);
        }
        try {
            BufferedSource bufferedSourceBuffer = Okio.buffer(Okio.source(context.getResources().openRawResource(i)));
            if (isZipCompressed(bufferedSourceBuffer).booleanValue()) {
                return fromZipStreamSync(context, new ZipInputStream(bufferedSourceBuffer.inputStream()), str);
            }
            if (isGzipCompressed(bufferedSourceBuffer).booleanValue()) {
                try {
                    return fromJsonInputStreamSync(new GZIPInputStream(bufferedSourceBuffer.inputStream()), str);
                } catch (IOException e) {
                    return new LottieResult((Throwable) e);
                }
            }
            return fromJsonReaderSync(JsonReader.of(bufferedSourceBuffer), str);
        } catch (Resources.NotFoundException e2) {
            return new LottieResult((Throwable) e2);
        }
    }

    private static String rawResCacheKey(Context context, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("rawRes");
        sb.append(isNightMode(context) ? "_night_" : "_day_");
        sb.append(i);
        return sb.toString();
    }

    private static boolean isNightMode(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    public static LottieTask fromJsonInputStream(final InputStream inputStream, final String str) {
        return cache(str, new Callable() { // from class: com.airbnb.lottie.LottieCompositionFactory$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LottieCompositionFactory.fromJsonInputStreamSync(inputStream, str);
            }
        }, new Runnable() { // from class: com.airbnb.lottie.LottieCompositionFactory$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                Utils.closeQuietly(inputStream);
            }
        });
    }

    public static LottieResult fromJsonInputStreamSync(InputStream inputStream, String str) {
        return fromJsonInputStreamSync(inputStream, str, true);
    }

    public static LottieResult fromJsonInputStreamSync(InputStream inputStream, String str, boolean z) {
        return fromJsonSourceSync(Okio.source(inputStream), str, z);
    }

    public static LottieResult fromJsonSourceSync(Source source, String str, boolean z) {
        return fromJsonReaderSyncInternal(JsonReader.of(Okio.buffer(source)), str, z);
    }

    public static LottieResult fromJsonReaderSync(JsonReader jsonReader, String str) {
        return fromJsonReaderSync(jsonReader, str, true);
    }

    public static LottieResult fromJsonReaderSync(JsonReader jsonReader, String str, boolean z) {
        return fromJsonReaderSyncInternal(jsonReader, str, z);
    }

    private static LottieResult fromJsonReaderSyncInternal(JsonReader jsonReader, String str, boolean z) {
        try {
            LottieComposition lottieComposition = str == null ? null : LottieCompositionCache.getInstance().get(str);
            if (lottieComposition != null) {
                return new LottieResult(lottieComposition);
            }
            LottieComposition lottieComposition2 = LottieCompositionMoshiParser.parse(jsonReader);
            if (str != null) {
                LottieCompositionCache.getInstance().put(str, lottieComposition2);
            }
            return new LottieResult(lottieComposition2);
        } catch (Exception e) {
            return new LottieResult((Throwable) e);
        } finally {
            if (z) {
                Utils.closeQuietly(jsonReader);
            }
        }
    }

    public static LottieTask fromZipStream(ZipInputStream zipInputStream, String str) {
        return fromZipStream(null, zipInputStream, str);
    }

    public static LottieTask fromZipStream(final Context context, final ZipInputStream zipInputStream, final String str) {
        return cache(str, new Callable() { // from class: com.airbnb.lottie.LottieCompositionFactory$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LottieCompositionFactory.fromZipStreamSync(context, zipInputStream, str);
            }
        }, new Runnable() { // from class: com.airbnb.lottie.LottieCompositionFactory$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                Utils.closeQuietly(zipInputStream);
            }
        });
    }

    public static LottieResult fromZipStreamSync(Context context, ZipInputStream zipInputStream, String str) {
        return fromZipStreamSync(context, zipInputStream, str, true);
    }

    public static LottieResult fromZipStreamSync(Context context, ZipInputStream zipInputStream, String str, boolean z) {
        try {
            return fromZipStreamSyncInternal(context, zipInputStream, str);
        } finally {
            if (z) {
                Utils.closeQuietly(zipInputStream);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:72:0x014b A[Catch: IOException -> 0x02b0, TryCatch #4 {IOException -> 0x02b0, blocks: (B:7:0x0019, B:9:0x001f, B:12:0x0028, B:14:0x0034, B:75:0x017b, B:15:0x0039, B:17:0x0045, B:18:0x004a, B:20:0x0056, B:21:0x006f, B:24:0x0079, B:26:0x0081, B:28:0x0089, B:31:0x0093, B:33:0x009b, B:36:0x00a4, B:37:0x00a9, B:39:0x00bb, B:41:0x00dc, B:70:0x0141, B:72:0x014b, B:73:0x0168, B:69:0x0120, B:74:0x016c, B:5:0x000f, B:42:0x00e5, B:53:0x0106, B:68:0x011f, B:67:0x011c, B:64:0x0117, B:43:0x00ea, B:52:0x0103, B:63:0x0116, B:62:0x0113), top: B:131:0x000f, inners: #2 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:72:0x014b, please report this as an issue */
    private static LottieResult fromZipStreamSyncInternal(Context context, ZipInputStream zipInputStream, String str) {
        LottieComposition lottieComposition;
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        if (str == null) {
            lottieComposition = null;
        } else {
            try {
                lottieComposition = LottieCompositionCache.getInstance().get(str);
            } catch (IOException e) {
                return new LottieResult((Throwable) e);
            }
        }
        if (lottieComposition != null) {
            return new LottieResult(lottieComposition);
        }
        ZipEntry nextEntry = zipInputStream.getNextEntry();
        LottieComposition lottieComposition2 = null;
        while (nextEntry != null) {
            String name = nextEntry.getName();
            if (name.contains("__MACOSX")) {
                zipInputStream.closeEntry();
            } else if (nextEntry.getName().equalsIgnoreCase("manifest.json")) {
                zipInputStream.closeEntry();
            } else if (nextEntry.getName().contains(".json")) {
                lottieComposition2 = (LottieComposition) fromJsonReaderSyncInternal(JsonReader.of(Okio.buffer(Okio.source(zipInputStream))), null, false).getValue();
            } else if (name.contains(".png") || name.contains(".webp") || name.contains(".jpg") || name.contains(".jpeg")) {
                String[] strArrSplit = name.split("/");
                map.put(strArrSplit[strArrSplit.length - 1], BitmapFactory.decodeStream(zipInputStream));
            } else if (name.contains(".ttf") || name.contains(".otf")) {
                String[] strArrSplit2 = name.split("/");
                String str2 = strArrSplit2[strArrSplit2.length - 1];
                String str3 = str2.split("\\.")[0];
                if (context == null) {
                    return new LottieResult((Throwable) new IllegalStateException("Unable to extract font " + str3 + " please pass a non-null Context parameter"));
                }
                File file = new File(context.getCacheDir(), str2);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    try {
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                        try {
                            byte[] bArr = new byte[4096];
                            while (true) {
                                int i = zipInputStream.read(bArr);
                                if (i == -1) {
                                    break;
                                }
                                fileOutputStream2.write(bArr, 0, i);
                            }
                            fileOutputStream2.flush();
                            fileOutputStream2.close();
                            fileOutputStream.close();
                            Typeface typefaceCreateFromFile = Typeface.createFromFile(file);
                            if (!file.delete()) {
                                Logger.warning("Failed to delete temp font file " + file.getAbsolutePath() + ".");
                            }
                            map2.put(str3, typefaceCreateFromFile);
                        } catch (Throwable th) {
                            try {
                                fileOutputStream2.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th4) {
                            th3.addSuppressed(th4);
                        }
                        throw th3;
                    }
                } catch (Throwable th5) {
                    Logger.warning("Unable to save font " + str3 + " to the temporary file: " + str2 + ". ", th5);
                    Typeface typefaceCreateFromFile2 = Typeface.createFromFile(file);
                    if (!file.delete()) {
                        Logger.warning("Failed to delete temp font file " + file.getAbsolutePath() + ".");
                    }
                    map2.put(str3, typefaceCreateFromFile2);
                    nextEntry = zipInputStream.getNextEntry();
                }
            } else {
                zipInputStream.closeEntry();
            }
            nextEntry = zipInputStream.getNextEntry();
        }
        if (lottieComposition2 == null) {
            return new LottieResult((Throwable) new IllegalArgumentException("Unable to parse composition"));
        }
        for (Map.Entry entry : map.entrySet()) {
            LottieImageAsset lottieImageAssetFindImageAssetForFileName = findImageAssetForFileName(lottieComposition2, (String) entry.getKey());
            if (lottieImageAssetFindImageAssetForFileName != null) {
                lottieImageAssetFindImageAssetForFileName.setBitmap(Utils.resizeBitmapIfNeeded((Bitmap) entry.getValue(), lottieImageAssetFindImageAssetForFileName.getWidth(), lottieImageAssetFindImageAssetForFileName.getHeight()));
            }
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            boolean z = false;
            for (Font font : lottieComposition2.getFonts().values()) {
                if (font.getFamily().equals(entry2.getKey())) {
                    font.setTypeface((Typeface) entry2.getValue());
                    z = true;
                }
            }
            if (!z) {
                Logger.warning("Parsed font for " + ((String) entry2.getKey()) + " however it was not found in the animation.");
            }
        }
        if (map.isEmpty()) {
            Iterator it = lottieComposition2.getImages().entrySet().iterator();
            while (it.hasNext()) {
                LottieImageAsset lottieImageAsset = (LottieImageAsset) ((Map.Entry) it.next()).getValue();
                if (lottieImageAsset == null) {
                    return null;
                }
                String fileName = lottieImageAsset.getFileName();
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inScaled = true;
                options.inDensity = 160;
                if (fileName.startsWith("data:") && fileName.indexOf("base64,") > 0) {
                    try {
                        byte[] bArrDecode = Base64.decode(fileName.substring(fileName.indexOf(44) + 1), 0);
                        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options);
                        if (bitmapDecodeByteArray != null) {
                            lottieImageAsset.setBitmap(Utils.resizeBitmapIfNeeded(bitmapDecodeByteArray, lottieImageAsset.getWidth(), lottieImageAsset.getHeight()));
                        }
                    } catch (IllegalArgumentException e2) {
                        Logger.warning("data URL did not have correct base64 format.", e2);
                        return null;
                    }
                }
            }
        }
        if (str != null) {
            LottieCompositionCache.getInstance().put(str, lottieComposition2);
        }
        return new LottieResult(lottieComposition2);
    }

    private static Boolean isZipCompressed(BufferedSource bufferedSource) {
        return matchesMagicBytes(bufferedSource, ZIP_MAGIC);
    }

    private static Boolean isGzipCompressed(BufferedSource bufferedSource) {
        return matchesMagicBytes(bufferedSource, GZIP_MAGIC);
    }

    private static Boolean matchesMagicBytes(BufferedSource bufferedSource, byte[] bArr) {
        try {
            BufferedSource bufferedSourcePeek = bufferedSource.peek();
            for (byte b : bArr) {
                if (bufferedSourcePeek.readByte() != b) {
                    return Boolean.FALSE;
                }
            }
            bufferedSourcePeek.close();
            return Boolean.TRUE;
        } catch (Exception e) {
            Logger.error("Failed to check zip file header", e);
            return Boolean.FALSE;
        } catch (NoSuchMethodError unused) {
            return Boolean.FALSE;
        }
    }

    private static LottieImageAsset findImageAssetForFileName(LottieComposition lottieComposition, String str) {
        for (LottieImageAsset lottieImageAsset : lottieComposition.getImages().values()) {
            if (lottieImageAsset.getFileName().equals(str)) {
                return lottieImageAsset;
            }
        }
        return null;
    }

    private static LottieTask cache(final String str, Callable callable, Runnable runnable) {
        LottieComposition lottieComposition = str == null ? null : LottieCompositionCache.getInstance().get(str);
        LottieTask lottieTask = lottieComposition != null ? new LottieTask(lottieComposition) : null;
        if (str != null) {
            Map map = taskCache;
            if (map.containsKey(str)) {
                lottieTask = (LottieTask) map.get(str);
            }
        }
        if (lottieTask != null) {
            if (runnable != null) {
                runnable.run();
            }
            return lottieTask;
        }
        LottieTask lottieTask2 = new LottieTask(callable);
        if (str != null) {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            lottieTask2.addListener(new LottieListener() { // from class: com.airbnb.lottie.LottieCompositionFactory$$ExternalSyntheticLambda6
                @Override // com.airbnb.lottie.LottieListener
                public final void onResult(Object obj) {
                    LottieCompositionFactory.$r8$lambda$w_diAIWn4AcMyZxe_PGTjzqVCuw(str, atomicBoolean, (LottieComposition) obj);
                }
            });
            lottieTask2.addFailureListener(new LottieListener() { // from class: com.airbnb.lottie.LottieCompositionFactory$$ExternalSyntheticLambda7
                @Override // com.airbnb.lottie.LottieListener
                public final void onResult(Object obj) {
                    LottieCompositionFactory.$r8$lambda$2hj6rCJTEUGIPib76KC8uDlefe4(str, atomicBoolean, (Throwable) obj);
                }
            });
            if (!atomicBoolean.get()) {
                Map map2 = taskCache;
                map2.put(str, lottieTask2);
                if (map2.size() == 1) {
                    notifyTaskCacheIdleListeners(false);
                }
            }
        }
        return lottieTask2;
    }

    public static /* synthetic */ void $r8$lambda$w_diAIWn4AcMyZxe_PGTjzqVCuw(String str, AtomicBoolean atomicBoolean, LottieComposition lottieComposition) {
        Map map = taskCache;
        map.remove(str);
        atomicBoolean.set(true);
        if (map.size() == 0) {
            notifyTaskCacheIdleListeners(true);
        }
    }

    public static /* synthetic */ void $r8$lambda$2hj6rCJTEUGIPib76KC8uDlefe4(String str, AtomicBoolean atomicBoolean, Throwable th) {
        Map map = taskCache;
        map.remove(str);
        atomicBoolean.set(true);
        if (map.size() == 0) {
            notifyTaskCacheIdleListeners(true);
        }
    }

    private static void notifyTaskCacheIdleListeners(boolean z) {
        ArrayList arrayList = new ArrayList(taskIdleListeners);
        if (arrayList.size() <= 0) {
            return;
        }
        MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(arrayList.get(0));
        throw null;
    }
}
