package com.facebook.imagepipeline.core;

import android.net.Uri;
import android.os.StrictMode;
import com.facebook.cache.common.CacheKey;
import com.facebook.callercontext.CallerContextVerifier;
import com.facebook.common.internal.Predicate;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSources;
import com.facebook.fresco.urimod.UriModifier;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.datasource.CloseableProducerToDataSourceAdapter;
import com.facebook.imagepipeline.datasource.ProducerToDataSourceAdapter;
import com.facebook.imagepipeline.listener.ForwardingRequestListener;
import com.facebook.imagepipeline.listener.ForwardingRequestListener2;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.listener.RequestListener2;
import com.facebook.imagepipeline.producers.InternalRequestListener;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ImagePipeline {
    private final MemoryCache bitmapMemoryCache;
    private final CacheKeyFactory cacheKeyFactory;
    private final ImagePipelineConfigInterface config;
    private final Supplier diskCachesStoreSupplier;
    private final MemoryCache encodedMemoryCache;
    private final AtomicLong idCounter;
    private final Supplier isLazyDataSource;
    private final Supplier isPrefetchEnabledSupplier;
    private final ProducerSequenceFactory producerSequenceFactory;
    private final RequestListener requestListener;
    private final RequestListener2 requestListener2;
    private final Supplier suppressBitmapPrefetchingSupplier;
    private final ThreadHandoffProducerQueue threadHandoffProducerQueue;
    public static final Companion Companion = new Companion(null);
    private static final CancellationException PREFETCH_EXCEPTION = new CancellationException("Prefetching is not enabled");
    private static final CancellationException NULL_IMAGEREQUEST_EXCEPTION = new CancellationException("ImageRequest is null");
    private static final CancellationException MODIFIED_URL_IS_NULL = new CancellationException("Modified URL is null");

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ImageRequest.CacheChoice.values().length];
            try {
                iArr[ImageRequest.CacheChoice.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ImageRequest.CacheChoice.SMALL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ImageRequest.CacheChoice.DYNAMIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean clearMemoryCaches$lambda$3(CacheKey it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return true;
    }

    private final DataSource submitFetchRequest(Producer producer, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, RequestListener requestListener, String str, Map map) {
        DataSource dataSourceImmediateFailedDataSource;
        if (!FrescoSystrace.isTracing()) {
            InternalRequestListener internalRequestListener = new InternalRequestListener(getRequestListenerForRequest(imageRequest, requestListener), this.requestListener2);
            try {
                ImageRequest.RequestLevel max = ImageRequest.RequestLevel.getMax(imageRequest.getLowestPermittedRequestLevel(), requestLevel);
                Intrinsics.checkNotNullExpressionValue(max, "getMax(...)");
                SettableProducerContext settableProducerContext = new SettableProducerContext(imageRequest, generateUniqueFutureId(), str, internalRequestListener, obj, max, false, imageRequest.getProgressiveRenderingEnabled() || !UriUtil.isNetworkUri(imageRequest.getSourceUri()), imageRequest.getPriority(), this.config);
                settableProducerContext.putExtras(map);
                return CloseableProducerToDataSourceAdapter.create(producer, settableProducerContext, internalRequestListener);
            } catch (Exception e) {
                return DataSources.immediateFailedDataSource(e);
            }
        }
        FrescoSystrace.beginSection("ImagePipeline#submitFetchRequest");
        try {
            InternalRequestListener internalRequestListener2 = new InternalRequestListener(getRequestListenerForRequest(imageRequest, requestListener), this.requestListener2);
            try {
                ImageRequest.RequestLevel max2 = ImageRequest.RequestLevel.getMax(imageRequest.getLowestPermittedRequestLevel(), requestLevel);
                Intrinsics.checkNotNullExpressionValue(max2, "getMax(...)");
                SettableProducerContext settableProducerContext2 = new SettableProducerContext(imageRequest, generateUniqueFutureId(), str, internalRequestListener2, obj, max2, false, imageRequest.getProgressiveRenderingEnabled() || !UriUtil.isNetworkUri(imageRequest.getSourceUri()), imageRequest.getPriority(), this.config);
                settableProducerContext2.putExtras(map);
                dataSourceImmediateFailedDataSource = CloseableProducerToDataSourceAdapter.create(producer, settableProducerContext2, internalRequestListener2);
            } catch (Exception e2) {
                dataSourceImmediateFailedDataSource = DataSources.immediateFailedDataSource(e2);
            }
            FrescoSystrace.endSection();
            return dataSourceImmediateFailedDataSource;
        } catch (Throwable th) {
            FrescoSystrace.endSection();
            throw th;
        }
    }

    public ImagePipeline(ProducerSequenceFactory producerSequenceFactory, Set requestListeners, Set requestListener2s, Supplier isPrefetchEnabledSupplier, MemoryCache bitmapMemoryCache, MemoryCache encodedMemoryCache, Supplier diskCachesStoreSupplier, CacheKeyFactory cacheKeyFactory, ThreadHandoffProducerQueue threadHandoffProducerQueue, Supplier suppressBitmapPrefetchingSupplier, Supplier lazyDataSource, CallerContextVerifier callerContextVerifier, ImagePipelineConfigInterface config) {
        Intrinsics.checkNotNullParameter(producerSequenceFactory, "producerSequenceFactory");
        Intrinsics.checkNotNullParameter(requestListeners, "requestListeners");
        Intrinsics.checkNotNullParameter(requestListener2s, "requestListener2s");
        Intrinsics.checkNotNullParameter(isPrefetchEnabledSupplier, "isPrefetchEnabledSupplier");
        Intrinsics.checkNotNullParameter(bitmapMemoryCache, "bitmapMemoryCache");
        Intrinsics.checkNotNullParameter(encodedMemoryCache, "encodedMemoryCache");
        Intrinsics.checkNotNullParameter(diskCachesStoreSupplier, "diskCachesStoreSupplier");
        Intrinsics.checkNotNullParameter(cacheKeyFactory, "cacheKeyFactory");
        Intrinsics.checkNotNullParameter(threadHandoffProducerQueue, "threadHandoffProducerQueue");
        Intrinsics.checkNotNullParameter(suppressBitmapPrefetchingSupplier, "suppressBitmapPrefetchingSupplier");
        Intrinsics.checkNotNullParameter(lazyDataSource, "lazyDataSource");
        Intrinsics.checkNotNullParameter(config, "config");
        this.producerSequenceFactory = producerSequenceFactory;
        this.isPrefetchEnabledSupplier = isPrefetchEnabledSupplier;
        this.diskCachesStoreSupplier = diskCachesStoreSupplier;
        this.requestListener = new ForwardingRequestListener(requestListeners);
        this.requestListener2 = new ForwardingRequestListener2(requestListener2s);
        this.idCounter = new AtomicLong();
        this.bitmapMemoryCache = bitmapMemoryCache;
        this.encodedMemoryCache = encodedMemoryCache;
        this.cacheKeyFactory = cacheKeyFactory;
        this.threadHandoffProducerQueue = threadHandoffProducerQueue;
        this.suppressBitmapPrefetchingSupplier = suppressBitmapPrefetchingSupplier;
        this.isLazyDataSource = lazyDataSource;
        this.config = config;
    }

    public final MemoryCache getBitmapMemoryCache() {
        return this.bitmapMemoryCache;
    }

    public final CacheKeyFactory getCacheKeyFactory() {
        return this.cacheKeyFactory;
    }

    public final String generateUniqueFutureId() {
        return String.valueOf(this.idCounter.getAndIncrement());
    }

    public final DataSource fetchImageFromBitmapCache(ImageRequest imageRequest, Object obj) {
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        return fetchDecodedImage(imageRequest, obj, ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE);
    }

    public static /* synthetic */ DataSource fetchDecodedImage$default(ImagePipeline imagePipeline, ImageRequest imageRequest, Object obj, ImageRequest.RequestLevel requestLevel, RequestListener requestListener, String str, int i, Object obj2) {
        if ((i & 4) != 0) {
            requestLevel = null;
        }
        if ((i & 8) != 0) {
            requestListener = null;
        }
        if ((i & 16) != 0) {
            str = null;
        }
        return imagePipeline.fetchDecodedImage(imageRequest, obj, requestLevel, requestListener, str);
    }

    public final DataSource fetchDecodedImage(ImageRequest imageRequest, Object obj, ImageRequest.RequestLevel requestLevel, RequestListener requestListener, String str) {
        if (imageRequest == null) {
            DataSource dataSourceImmediateFailedDataSource = DataSources.immediateFailedDataSource(new NullPointerException());
            Intrinsics.checkNotNullExpressionValue(dataSourceImmediateFailedDataSource, "immediateFailedDataSource(...)");
            return dataSourceImmediateFailedDataSource;
        }
        try {
            Producer decodedImageProducerSequence = this.producerSequenceFactory.getDecodedImageProducerSequence(imageRequest);
            if (requestLevel == null) {
                requestLevel = ImageRequest.RequestLevel.FULL_FETCH;
            }
            return submitFetchRequest(decodedImageProducerSequence, imageRequest, requestLevel, obj, requestListener, str);
        } catch (Exception e) {
            return DataSources.immediateFailedDataSource(e);
        }
    }

    public final DataSource fetchDecodedImage(ImageRequest imageRequest, Object obj) {
        return fetchDecodedImage$default(this, imageRequest, obj, null, null, null, 24, null);
    }

    public final DataSource fetchDecodedImage(ImageRequest imageRequest, Object obj, ImageRequest.RequestLevel lowestPermittedRequestLevelOnSubmit) {
        Intrinsics.checkNotNullParameter(lowestPermittedRequestLevelOnSubmit, "lowestPermittedRequestLevelOnSubmit");
        return fetchDecodedImage$default(this, imageRequest, obj, lowestPermittedRequestLevelOnSubmit, null, null, 16, null);
    }

    public final DataSource prefetchToDiskCache(ImageRequest imageRequest, Object obj) {
        return prefetchToDiskCache(imageRequest, obj, Priority.MEDIUM, null);
    }

    public final DataSource prefetchToDiskCache(ImageRequest imageRequest, Object obj, Priority priority, RequestListener requestListener) {
        Intrinsics.checkNotNullParameter(priority, "priority");
        if (!((Boolean) this.isPrefetchEnabledSupplier.get()).booleanValue()) {
            DataSource dataSourceImmediateFailedDataSource = DataSources.immediateFailedDataSource(PREFETCH_EXCEPTION);
            Intrinsics.checkNotNullExpressionValue(dataSourceImmediateFailedDataSource, "immediateFailedDataSource(...)");
            return dataSourceImmediateFailedDataSource;
        }
        if (imageRequest == null) {
            DataSource dataSourceImmediateFailedDataSource2 = DataSources.immediateFailedDataSource(new NullPointerException("imageRequest is null"));
            Intrinsics.checkNotNull(dataSourceImmediateFailedDataSource2);
            return dataSourceImmediateFailedDataSource2;
        }
        try {
            return submitPrefetchRequest(this.producerSequenceFactory.getEncodedImagePrefetchProducerSequence(imageRequest), imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, priority, requestListener);
        } catch (Exception e) {
            return DataSources.immediateFailedDataSource(e);
        }
    }

    public final void evictFromMemoryCache(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Predicate predicatePredicateForUri = predicateForUri(uri);
        this.bitmapMemoryCache.removeAll(predicatePredicateForUri);
        this.encodedMemoryCache.removeAll(predicatePredicateForUri);
    }

    public final void evictFromDiskCache(Uri uri) {
        ImageRequest imageRequestFromUri = ImageRequest.fromUri(uri);
        if (imageRequestFromUri == null) {
            throw new IllegalStateException("Required value was null.");
        }
        evictFromDiskCache(imageRequestFromUri);
    }

    public final void evictFromDiskCache(ImageRequest imageRequest) {
        if (imageRequest == null) {
            return;
        }
        CacheKey encodedCacheKey = this.cacheKeyFactory.getEncodedCacheKey(imageRequest, null);
        Object obj = this.diskCachesStoreSupplier.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        DiskCachesStore diskCachesStore = (DiskCachesStore) obj;
        BufferedDiskCache mainBufferedDiskCache = diskCachesStore.getMainBufferedDiskCache();
        Intrinsics.checkNotNull(encodedCacheKey);
        mainBufferedDiskCache.remove(encodedCacheKey);
        diskCachesStore.getSmallImageBufferedDiskCache().remove(encodedCacheKey);
        Iterator it = diskCachesStore.getDynamicBufferedDiskCaches().entrySet().iterator();
        while (it.hasNext()) {
            ((BufferedDiskCache) ((Map.Entry) it.next()).getValue()).remove(encodedCacheKey);
        }
    }

    public final void evictFromCache(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        evictFromMemoryCache(uri);
        evictFromDiskCache(uri);
    }

    public final void clearMemoryCaches() {
        Predicate predicate = new Predicate() { // from class: com.facebook.imagepipeline.core.ImagePipeline$$ExternalSyntheticLambda1
            @Override // com.facebook.common.internal.Predicate
            public final boolean apply(Object obj) {
                return ImagePipeline.clearMemoryCaches$lambda$3((CacheKey) obj);
            }
        };
        this.bitmapMemoryCache.removeAll(predicate);
        this.encodedMemoryCache.removeAll(predicate);
    }

    public final void clearDiskCaches() {
        Object obj = this.diskCachesStoreSupplier.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        DiskCachesStore diskCachesStore = (DiskCachesStore) obj;
        diskCachesStore.getMainBufferedDiskCache().clearAll();
        diskCachesStore.getSmallImageBufferedDiskCache().clearAll();
        Iterator it = diskCachesStore.getDynamicBufferedDiskCaches().entrySet().iterator();
        while (it.hasNext()) {
            ((BufferedDiskCache) ((Map.Entry) it.next()).getValue()).clearAll();
        }
    }

    public final void clearCaches() {
        clearMemoryCaches();
        clearDiskCaches();
    }

    public final boolean isInBitmapMemoryCache(Uri uri) {
        if (uri == null) {
            return false;
        }
        return this.bitmapMemoryCache.contains(predicateForUri(uri));
    }

    public final boolean isInBitmapMemoryCache(ImageRequest imageRequest) {
        if (imageRequest == null) {
            return false;
        }
        CacheKey bitmapCacheKey = this.cacheKeyFactory.getBitmapCacheKey(imageRequest, null);
        MemoryCache memoryCache = this.bitmapMemoryCache;
        Intrinsics.checkNotNull(bitmapCacheKey);
        CloseableReference closeableReference = memoryCache.get(bitmapCacheKey);
        try {
            return CloseableReference.isValid(closeableReference);
        } finally {
            CloseableReference.closeSafely(closeableReference);
        }
    }

    public final boolean isInDiskCacheSync(Uri uri) {
        return isInDiskCacheSync(uri, ImageRequest.CacheChoice.SMALL) || isInDiskCacheSync(uri, ImageRequest.CacheChoice.DEFAULT) || isInDiskCacheSync(uri, ImageRequest.CacheChoice.DYNAMIC);
    }

    public final boolean isInDiskCacheSync(Uri uri, ImageRequest.CacheChoice cacheChoice) {
        ImageRequest imageRequestBuild = ImageRequestBuilder.newBuilderWithSource(uri).setCacheChoice(cacheChoice).build();
        Intrinsics.checkNotNull(imageRequestBuild);
        return isInDiskCacheSync(imageRequestBuild);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean isInDynamicDiskCachesSync(ImageRequest imageRequest) {
        Object obj = this.diskCachesStoreSupplier.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        DiskCachesStore diskCachesStore = (DiskCachesStore) obj;
        CacheKey encodedCacheKey = this.cacheKeyFactory.getEncodedCacheKey(imageRequest, null);
        String diskCacheId = imageRequest.getDiskCacheId();
        if (diskCacheId == null) {
            Iterator it = diskCachesStore.getDynamicBufferedDiskCaches().entrySet().iterator();
            while (it.hasNext()) {
                BufferedDiskCache bufferedDiskCache = (BufferedDiskCache) ((Map.Entry) it.next()).getValue();
                Intrinsics.checkNotNull(encodedCacheKey);
                if (bufferedDiskCache.diskCheckSync(encodedCacheKey)) {
                    return true;
                }
            }
            return false;
        }
        BufferedDiskCache bufferedDiskCache2 = (BufferedDiskCache) diskCachesStore.getDynamicBufferedDiskCaches().get(diskCacheId);
        if (bufferedDiskCache2 == null) {
            return false;
        }
        Intrinsics.checkNotNull(encodedCacheKey);
        return bufferedDiskCache2.diskCheckSync(encodedCacheKey);
    }

    public final boolean isInDiskCacheSync(ImageRequest imageRequest) {
        boolean zDiskCheckSync;
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        Object obj = this.diskCachesStoreSupplier.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        DiskCachesStore diskCachesStore = (DiskCachesStore) obj;
        CacheKey encodedCacheKey = this.cacheKeyFactory.getEncodedCacheKey(imageRequest, null);
        ImageRequest.CacheChoice cacheChoice = imageRequest.getCacheChoice();
        Intrinsics.checkNotNullExpressionValue(cacheChoice, "getCacheChoice(...)");
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            int i = WhenMappings.$EnumSwitchMapping$0[cacheChoice.ordinal()];
            if (i == 1) {
                BufferedDiskCache mainBufferedDiskCache = diskCachesStore.getMainBufferedDiskCache();
                Intrinsics.checkNotNull(encodedCacheKey);
                zDiskCheckSync = mainBufferedDiskCache.diskCheckSync(encodedCacheKey);
            } else if (i == 2) {
                BufferedDiskCache smallImageBufferedDiskCache = diskCachesStore.getSmallImageBufferedDiskCache();
                Intrinsics.checkNotNull(encodedCacheKey);
                zDiskCheckSync = smallImageBufferedDiskCache.diskCheckSync(encodedCacheKey);
            } else {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                zDiskCheckSync = isInDynamicDiskCachesSync(imageRequest);
            }
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            return zDiskCheckSync;
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            throw th;
        }
    }

    private final DataSource submitFetchRequest(Producer producer, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, RequestListener requestListener, String str) {
        return submitFetchRequest(producer, imageRequest, requestLevel, obj, requestListener, str, null);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x006c  */
    private final DataSource submitPrefetchRequest(Producer producer, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, Priority priority, RequestListener requestListener) {
        boolean z;
        InternalRequestListener internalRequestListener = new InternalRequestListener(getRequestListenerForRequest(imageRequest, requestListener), this.requestListener2);
        Uri sourceUri = imageRequest.getSourceUri();
        Intrinsics.checkNotNullExpressionValue(sourceUri, "getSourceUri(...)");
        Uri uriModifyPrefetchUri = UriModifier.f50INSTANCE.modifyPrefetchUri(sourceUri, obj);
        if (uriModifyPrefetchUri == null) {
            DataSource dataSourceImmediateFailedDataSource = DataSources.immediateFailedDataSource(MODIFIED_URL_IS_NULL);
            Intrinsics.checkNotNullExpressionValue(dataSourceImmediateFailedDataSource, "immediateFailedDataSource(...)");
            return dataSourceImmediateFailedDataSource;
        }
        if (!Intrinsics.areEqual(sourceUri, uriModifyPrefetchUri)) {
            imageRequest = ImageRequestBuilder.fromRequest(imageRequest).setSource(uriModifyPrefetchUri).build();
        }
        ImageRequest imageRequest2 = imageRequest;
        try {
            ImageRequest.RequestLevel max = ImageRequest.RequestLevel.getMax(imageRequest2.getLowestPermittedRequestLevel(), requestLevel);
            Intrinsics.checkNotNullExpressionValue(max, "getMax(...)");
            String strGenerateUniqueFutureId = generateUniqueFutureId();
            ImagePipelineExperiments experiments = this.config.getExperiments();
            if (experiments != null) {
                z = experiments.getAllowProgressiveOnPrefetch() && imageRequest2.getProgressiveRenderingEnabled();
            }
            return ProducerToDataSourceAdapter.Companion.create(producer, new SettableProducerContext(imageRequest2, strGenerateUniqueFutureId, internalRequestListener, obj, max, true, z, priority, this.config), internalRequestListener);
        } catch (Exception e) {
            return DataSources.immediateFailedDataSource(e);
        }
    }

    public final RequestListener getRequestListenerForRequest(ImageRequest imageRequest, RequestListener requestListener) {
        if (imageRequest == null) {
            throw new IllegalStateException("Required value was null.");
        }
        if (requestListener == null) {
            if (imageRequest.getRequestListener() == null) {
                return this.requestListener;
            }
            return new ForwardingRequestListener(this.requestListener, imageRequest.getRequestListener());
        }
        if (imageRequest.getRequestListener() == null) {
            return new ForwardingRequestListener(this.requestListener, requestListener);
        }
        return new ForwardingRequestListener(this.requestListener, requestListener, imageRequest.getRequestListener());
    }

    private final Predicate predicateForUri(final Uri uri) {
        return new Predicate() { // from class: com.facebook.imagepipeline.core.ImagePipeline$$ExternalSyntheticLambda0
            @Override // com.facebook.common.internal.Predicate
            public final boolean apply(Object obj) {
                return ImagePipeline.predicateForUri$lambda$16(uri, (CacheKey) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean predicateForUri$lambda$16(Uri uri, CacheKey key) {
        Intrinsics.checkNotNullParameter(uri, "$uri");
        Intrinsics.checkNotNullParameter(key, "key");
        return key.containsUri(uri);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
