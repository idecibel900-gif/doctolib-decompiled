package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class BitmapMemoryCacheGetProducer extends BitmapMemoryCacheProducer {
    public static final Companion Companion = new Companion(null);

    @Override // com.facebook.imagepipeline.producers.BitmapMemoryCacheProducer
    protected Consumer wrapConsumer(Consumer consumer, CacheKey cacheKey, boolean z) {
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        return consumer;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BitmapMemoryCacheGetProducer(MemoryCache memoryCache, CacheKeyFactory cacheKeyFactory, Producer inputProducer) {
        super(memoryCache, cacheKeyFactory, inputProducer);
        Intrinsics.checkNotNullParameter(memoryCache, "memoryCache");
        Intrinsics.checkNotNullParameter(cacheKeyFactory, "cacheKeyFactory");
        Intrinsics.checkNotNullParameter(inputProducer, "inputProducer");
    }

    @Override // com.facebook.imagepipeline.producers.BitmapMemoryCacheProducer
    protected String getProducerName() {
        return "BitmapMemoryCacheGetProducer";
    }

    @Override // com.facebook.imagepipeline.producers.BitmapMemoryCacheProducer
    protected String getOriginSubcategory() {
        return "pipe_ui";
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
