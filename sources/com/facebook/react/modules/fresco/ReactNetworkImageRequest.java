package com.facebook.react.modules.fresco;

import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.react.bridge.ReadableMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ReactNetworkImageRequest extends ImageRequest {
    public static final Companion Companion = new Companion(null);
    private final ImageCacheControl cacheControl;
    private final ReadableMap headers;

    public /* synthetic */ ReactNetworkImageRequest(ImageRequestBuilder imageRequestBuilder, ReadableMap readableMap, ImageCacheControl imageCacheControl, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageRequestBuilder, readableMap, imageCacheControl);
    }

    public final ReadableMap getHeaders$ReactAndroid_release() {
        return this.headers;
    }

    public final ImageCacheControl getCacheControl$ReactAndroid_release() {
        return this.cacheControl;
    }

    private ReactNetworkImageRequest(ImageRequestBuilder imageRequestBuilder, ReadableMap readableMap, ImageCacheControl imageCacheControl) {
        super(imageRequestBuilder);
        this.headers = readableMap;
        this.cacheControl = imageCacheControl;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ ReactNetworkImageRequest fromBuilderWithHeaders$default(Companion companion, ImageRequestBuilder imageRequestBuilder, ReadableMap readableMap, ImageCacheControl imageCacheControl, int i, Object obj) {
            if ((i & 4) != 0) {
                imageCacheControl = ImageCacheControl.DEFAULT;
            }
            return companion.fromBuilderWithHeaders(imageRequestBuilder, readableMap, imageCacheControl);
        }

        public final ReactNetworkImageRequest fromBuilderWithHeaders(ImageRequestBuilder builder, ReadableMap readableMap, ImageCacheControl cacheControl) {
            Intrinsics.checkNotNullParameter(builder, "builder");
            Intrinsics.checkNotNullParameter(cacheControl, "cacheControl");
            return new ReactNetworkImageRequest(builder, readableMap, cacheControl, null);
        }
    }
}
