package com.revenuecat.purchases.storage;

import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.models.Checksum;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH&J$\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH&¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/storage/LocalFileCache;", "", "cachedContentExists", "", "uri", "Ljava/net/URI;", "generateLocalFilesystemURI", "remoteURL", "Ljava/net/URL;", "checksum", "Lcom/revenuecat/purchases/models/Checksum;", "saveData", "", "inputStream", "Ljava/io/InputStream;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface LocalFileCache {
    boolean cachedContentExists(URI uri);

    URI generateLocalFilesystemURI(URL remoteURL, Checksum checksum);

    void saveData(InputStream inputStream, URI uri, Checksum checksum);

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ URI generateLocalFilesystemURI$default(LocalFileCache localFileCache, URL url, Checksum checksum, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: generateLocalFilesystemURI");
        }
        if ((i & 2) != 0) {
            checksum = null;
        }
        return localFileCache.generateLocalFilesystemURI(url, checksum);
    }

    static /* synthetic */ void saveData$default(LocalFileCache localFileCache, InputStream inputStream, URI uri, Checksum checksum, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: saveData");
        }
        if ((i & 4) != 0) {
            checksum = null;
        }
        localFileCache.saveData(inputStream, uri, checksum);
    }
}
