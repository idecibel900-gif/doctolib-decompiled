package com.airbnb.lottie.network;

import android.content.Context;
import android.util.Pair;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieResult;
import com.airbnb.lottie.utils.Logger;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkFetcher {
    private final LottieNetworkFetcher fetcher;
    private final NetworkCache networkCache;

    public NetworkFetcher(NetworkCache networkCache, LottieNetworkFetcher lottieNetworkFetcher) {
        this.networkCache = networkCache;
        this.fetcher = lottieNetworkFetcher;
    }

    public LottieResult fetchSync(Context context, String str, String str2) {
        LottieComposition lottieCompositionFetchFromCache = fetchFromCache(context, str, str2);
        if (lottieCompositionFetchFromCache != null) {
            return new LottieResult(lottieCompositionFetchFromCache);
        }
        Logger.debug("Animation for " + str + " not found in cache. Fetching from network.");
        return fetchFromNetwork(context, str, str2);
    }

    private LottieComposition fetchFromCache(Context context, String str, String str2) {
        NetworkCache networkCache;
        Pair pairFetch;
        LottieResult lottieResultFromZipStreamSync;
        if (str2 == null || (networkCache = this.networkCache) == null || (pairFetch = networkCache.fetch(str)) == null) {
            return null;
        }
        FileExtension fileExtension = (FileExtension) pairFetch.first;
        InputStream inputStream = (InputStream) pairFetch.second;
        int i = AnonymousClass1.$SwitchMap$com$airbnb$lottie$network$FileExtension[fileExtension.ordinal()];
        if (i == 1) {
            lottieResultFromZipStreamSync = LottieCompositionFactory.fromZipStreamSync(context, new ZipInputStream(inputStream), str2);
        } else if (i == 2) {
            try {
                lottieResultFromZipStreamSync = LottieCompositionFactory.fromJsonInputStreamSync(new GZIPInputStream(inputStream), str2);
            } catch (IOException e) {
                lottieResultFromZipStreamSync = new LottieResult((Throwable) e);
            }
        } else {
            lottieResultFromZipStreamSync = LottieCompositionFactory.fromJsonInputStreamSync(inputStream, str2);
        }
        if (lottieResultFromZipStreamSync.getValue() != null) {
            return (LottieComposition) lottieResultFromZipStreamSync.getValue();
        }
        return null;
    }

    /* JADX INFO: renamed from: com.airbnb.lottie.network.NetworkFetcher$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$network$FileExtension;

        static {
            int[] iArr = new int[FileExtension.values().length];
            $SwitchMap$com$airbnb$lottie$network$FileExtension = iArr;
            try {
                iArr[FileExtension.ZIP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$network$FileExtension[FileExtension.GZIP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private LottieResult fetchFromNetwork(Context context, String str, String str2) {
        LottieResult lottieResult;
        Logger.debug("Fetching " + str);
        Closeable closeable = null;
        try {
            try {
                LottieFetchResult lottieFetchResultFetchSync = this.fetcher.fetchSync(str);
                if (lottieFetchResultFetchSync.isSuccessful()) {
                    lottieResult = fromInputStream(context, str, lottieFetchResultFetchSync.bodyByteStream(), lottieFetchResultFetchSync.contentType(), str2);
                    StringBuilder sb = new StringBuilder();
                    sb.append("Completed fetch from network. Success: ");
                    sb.append(lottieResult.getValue() != null);
                    Logger.debug(sb.toString());
                } else {
                    lottieResult = new LottieResult((Throwable) new IllegalArgumentException(lottieFetchResultFetchSync.error()));
                }
                try {
                    lottieFetchResultFetchSync.close();
                    return lottieResult;
                } catch (IOException e) {
                    Logger.warning("LottieFetchResult close failed ", e);
                    return lottieResult;
                }
            } catch (Exception e2) {
                LottieResult lottieResult2 = new LottieResult((Throwable) e2);
                if (0 != 0) {
                    try {
                        closeable.close();
                    } catch (IOException e3) {
                        Logger.warning("LottieFetchResult close failed ", e3);
                    }
                }
                return lottieResult2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    closeable.close();
                    throw th;
                } catch (IOException e4) {
                    Logger.warning("LottieFetchResult close failed ", e4);
                    throw th;
                }
            }
            throw th;
        }
    }

    private LottieResult fromInputStream(Context context, String str, InputStream inputStream, String str2, String str3) {
        LottieResult lottieResultFromZipStream;
        FileExtension fileExtension;
        NetworkCache networkCache;
        if (str2 == null) {
            str2 = "application/json";
        }
        if (str2.contains("application/zip") || str2.contains("application/x-zip") || str2.contains("application/x-zip-compressed") || str.split("\\?")[0].endsWith(".lottie")) {
            Logger.debug("Handling zip response.");
            FileExtension fileExtension2 = FileExtension.ZIP;
            lottieResultFromZipStream = fromZipStream(context, str, inputStream, str3);
            fileExtension = fileExtension2;
        } else if (str2.contains("application/gzip") || str2.contains("application/x-gzip") || str.split("\\?")[0].endsWith(".tgs")) {
            Logger.debug("Handling gzip response.");
            fileExtension = FileExtension.GZIP;
            lottieResultFromZipStream = fromGzipStream(str, inputStream, str3);
        } else {
            Logger.debug("Received json response.");
            fileExtension = FileExtension.JSON;
            lottieResultFromZipStream = fromJsonStream(str, inputStream, str3);
        }
        if (str3 != null && lottieResultFromZipStream.getValue() != null && (networkCache = this.networkCache) != null) {
            networkCache.renameTempFile(str, fileExtension);
        }
        return lottieResultFromZipStream;
    }

    private LottieResult fromZipStream(Context context, String str, InputStream inputStream, String str2) {
        NetworkCache networkCache;
        if (str2 == null || (networkCache = this.networkCache) == null) {
            return LottieCompositionFactory.fromZipStreamSync(context, new ZipInputStream(inputStream), null);
        }
        return LottieCompositionFactory.fromZipStreamSync(context, new ZipInputStream(new FileInputStream(networkCache.writeTempCacheFile(str, inputStream, FileExtension.ZIP))), str);
    }

    private LottieResult fromGzipStream(String str, InputStream inputStream, String str2) {
        NetworkCache networkCache;
        if (str2 == null || (networkCache = this.networkCache) == null) {
            return LottieCompositionFactory.fromJsonInputStreamSync(new GZIPInputStream(inputStream), null);
        }
        return LottieCompositionFactory.fromJsonInputStreamSync(new GZIPInputStream(new FileInputStream(networkCache.writeTempCacheFile(str, inputStream, FileExtension.GZIP))), str);
    }

    private LottieResult fromJsonStream(String str, InputStream inputStream, String str2) {
        NetworkCache networkCache;
        if (str2 == null || (networkCache = this.networkCache) == null) {
            return LottieCompositionFactory.fromJsonInputStreamSync(inputStream, null);
        }
        return LottieCompositionFactory.fromJsonInputStreamSync(new FileInputStream(networkCache.writeTempCacheFile(str, inputStream, FileExtension.JSON).getAbsolutePath()), str);
    }
}
