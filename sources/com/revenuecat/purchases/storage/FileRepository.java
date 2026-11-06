package com.revenuecat.purchases.storage;

import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.models.Checksum;
import java.net.URI;
import java.net.URL;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes4.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H¦@¢\u0006\u0002\u0010\bJ\u001e\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J$\u0010\n\u001a\u00020\u000b2\u001a\u0010\f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000e0\rH&¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/storage/FileRepository;", "", "generateOrGetCachedFileURL", "Ljava/net/URI;", "url", "Ljava/net/URL;", "checksum", "Lcom/revenuecat/purchases/models/Checksum;", "(Ljava/net/URL;Lcom/revenuecat/purchases/models/Checksum;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFile", "prefetch", "", "urls", "", "Lkotlin/Pair;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface FileRepository {
    Object generateOrGetCachedFileURL(URL url, Checksum checksum, Continuation continuation);

    URI getFile(URL url, Checksum checksum);

    void prefetch(List<Pair<URL, Checksum>> urls);

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object generateOrGetCachedFileURL$default(FileRepository fileRepository, URL url, Checksum checksum, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: generateOrGetCachedFileURL");
        }
        if ((i & 2) != 0) {
            checksum = null;
        }
        return fileRepository.generateOrGetCachedFileURL(url, checksum, continuation);
    }

    static /* synthetic */ URI getFile$default(FileRepository fileRepository, URL url, Checksum checksum, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getFile");
        }
        if ((i & 2) != 0) {
            checksum = null;
        }
        return fileRepository.getFile(url, checksum);
    }
}
