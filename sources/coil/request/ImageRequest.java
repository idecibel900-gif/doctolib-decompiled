package coil.request;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.Lifecycle;
import coil.decode.Decoder;
import coil.memory.MemoryCache;
import coil.size.DisplaySizeResolver;
import coil.size.Precision;
import coil.size.Scale;
import coil.size.SizeResolver;
import coil.size.ViewSizeResolver;
import coil.target.Target;
import coil.transition.CrossfadeTransition;
import coil.transition.Transition;
import coil.util.Collections;
import coil.util.Contexts;
import coil.util.Requests;
import coil.util.Utils;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import okhttp3.Headers;

/* JADX INFO: loaded from: classes3.dex */
public final class ImageRequest {
    private final boolean allowConversionToBitmap;
    private final boolean allowHardware;
    private final boolean allowRgb565;
    private final Bitmap.Config bitmapConfig;
    private final ColorSpace colorSpace;
    private final Context context;
    private final Object data;
    private final CoroutineDispatcher decoderDispatcher;
    private final Decoder.Factory decoderFactory;
    private final DefaultRequestOptions defaults;
    private final DefinedRequestOptions defined;
    private final String diskCacheKey;
    private final CachePolicy diskCachePolicy;
    private final Drawable errorDrawable;
    private final Integer errorResId;
    private final Drawable fallbackDrawable;
    private final Integer fallbackResId;
    private final CoroutineDispatcher fetcherDispatcher;
    private final Pair fetcherFactory;
    private final Headers headers;
    private final CoroutineDispatcher interceptorDispatcher;
    private final Lifecycle lifecycle;
    private final Listener listener;
    private final MemoryCache.Key memoryCacheKey;
    private final CachePolicy memoryCachePolicy;
    private final CachePolicy networkCachePolicy;
    private final Parameters parameters;
    private final Drawable placeholderDrawable;
    private final MemoryCache.Key placeholderMemoryCacheKey;
    private final Integer placeholderResId;
    private final Precision precision;
    private final boolean premultipliedAlpha;
    private final Scale scale;
    private final SizeResolver sizeResolver;
    private final Tags tags;
    private final Target target;
    private final CoroutineDispatcher transformationDispatcher;
    private final List transformations;
    private final Transition.Factory transitionFactory;

    public interface Listener {
        void onCancel(ImageRequest imageRequest);

        void onError(ImageRequest imageRequest, ErrorResult errorResult);

        void onStart(ImageRequest imageRequest);

        void onSuccess(ImageRequest imageRequest, SuccessResult successResult);
    }

    public /* synthetic */ ImageRequest(Context context, Object obj, Target target, Listener listener, MemoryCache.Key key, String str, Bitmap.Config config, ColorSpace colorSpace, Precision precision, Pair pair, Decoder.Factory factory, List list, Transition.Factory factory2, Headers headers, Tags tags, boolean z, boolean z2, boolean z3, boolean z4, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, CoroutineDispatcher coroutineDispatcher3, CoroutineDispatcher coroutineDispatcher4, Lifecycle lifecycle, SizeResolver sizeResolver, Scale scale, Parameters parameters, MemoryCache.Key key2, Integer num, Drawable drawable, Integer num2, Drawable drawable2, Integer num3, Drawable drawable3, DefinedRequestOptions definedRequestOptions, DefaultRequestOptions defaultRequestOptions, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, obj, target, listener, key, str, config, colorSpace, precision, pair, factory, list, factory2, headers, tags, z, z2, z3, z4, cachePolicy, cachePolicy2, cachePolicy3, coroutineDispatcher, coroutineDispatcher2, coroutineDispatcher3, coroutineDispatcher4, lifecycle, sizeResolver, scale, parameters, key2, num, drawable, num2, drawable2, num3, drawable3, definedRequestOptions, defaultRequestOptions);
    }

    private ImageRequest(Context context, Object obj, Target target, Listener listener, MemoryCache.Key key, String str, Bitmap.Config config, ColorSpace colorSpace, Precision precision, Pair pair, Decoder.Factory factory, List list, Transition.Factory factory2, Headers headers, Tags tags, boolean z, boolean z2, boolean z3, boolean z4, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, CoroutineDispatcher coroutineDispatcher3, CoroutineDispatcher coroutineDispatcher4, Lifecycle lifecycle, SizeResolver sizeResolver, Scale scale, Parameters parameters, MemoryCache.Key key2, Integer num, Drawable drawable, Integer num2, Drawable drawable2, Integer num3, Drawable drawable3, DefinedRequestOptions definedRequestOptions, DefaultRequestOptions defaultRequestOptions) {
        this.context = context;
        this.data = obj;
        this.target = target;
        this.listener = listener;
        this.memoryCacheKey = key;
        this.diskCacheKey = str;
        this.bitmapConfig = config;
        this.colorSpace = colorSpace;
        this.precision = precision;
        this.fetcherFactory = pair;
        this.decoderFactory = factory;
        this.transformations = list;
        this.transitionFactory = factory2;
        this.headers = headers;
        this.tags = tags;
        this.allowConversionToBitmap = z;
        this.allowHardware = z2;
        this.allowRgb565 = z3;
        this.premultipliedAlpha = z4;
        this.memoryCachePolicy = cachePolicy;
        this.diskCachePolicy = cachePolicy2;
        this.networkCachePolicy = cachePolicy3;
        this.interceptorDispatcher = coroutineDispatcher;
        this.fetcherDispatcher = coroutineDispatcher2;
        this.decoderDispatcher = coroutineDispatcher3;
        this.transformationDispatcher = coroutineDispatcher4;
        this.lifecycle = lifecycle;
        this.sizeResolver = sizeResolver;
        this.scale = scale;
        this.parameters = parameters;
        this.placeholderMemoryCacheKey = key2;
        this.placeholderResId = num;
        this.placeholderDrawable = drawable;
        this.errorResId = num2;
        this.errorDrawable = drawable2;
        this.fallbackResId = num3;
        this.fallbackDrawable = drawable3;
        this.defined = definedRequestOptions;
        this.defaults = defaultRequestOptions;
    }

    public final Context getContext() {
        return this.context;
    }

    public final Object getData() {
        return this.data;
    }

    public final Target getTarget() {
        return this.target;
    }

    public final Listener getListener() {
        return this.listener;
    }

    public final MemoryCache.Key getMemoryCacheKey() {
        return this.memoryCacheKey;
    }

    public final String getDiskCacheKey() {
        return this.diskCacheKey;
    }

    public final Bitmap.Config getBitmapConfig() {
        return this.bitmapConfig;
    }

    public final ColorSpace getColorSpace() {
        return this.colorSpace;
    }

    public final Precision getPrecision() {
        return this.precision;
    }

    public final Pair getFetcherFactory() {
        return this.fetcherFactory;
    }

    public final Decoder.Factory getDecoderFactory() {
        return this.decoderFactory;
    }

    public final List getTransformations() {
        return this.transformations;
    }

    public final Transition.Factory getTransitionFactory() {
        return this.transitionFactory;
    }

    public final Headers getHeaders() {
        return this.headers;
    }

    public final Tags getTags() {
        return this.tags;
    }

    public final boolean getAllowConversionToBitmap() {
        return this.allowConversionToBitmap;
    }

    public final boolean getAllowHardware() {
        return this.allowHardware;
    }

    public final boolean getAllowRgb565() {
        return this.allowRgb565;
    }

    public final boolean getPremultipliedAlpha() {
        return this.premultipliedAlpha;
    }

    public final CachePolicy getMemoryCachePolicy() {
        return this.memoryCachePolicy;
    }

    public final CachePolicy getDiskCachePolicy() {
        return this.diskCachePolicy;
    }

    public final CachePolicy getNetworkCachePolicy() {
        return this.networkCachePolicy;
    }

    public final CoroutineDispatcher getInterceptorDispatcher() {
        return this.interceptorDispatcher;
    }

    public final CoroutineDispatcher getFetcherDispatcher() {
        return this.fetcherDispatcher;
    }

    public final CoroutineDispatcher getDecoderDispatcher() {
        return this.decoderDispatcher;
    }

    public final CoroutineDispatcher getTransformationDispatcher() {
        return this.transformationDispatcher;
    }

    public final Lifecycle getLifecycle() {
        return this.lifecycle;
    }

    public final SizeResolver getSizeResolver() {
        return this.sizeResolver;
    }

    public final Scale getScale() {
        return this.scale;
    }

    public final Parameters getParameters() {
        return this.parameters;
    }

    public final MemoryCache.Key getPlaceholderMemoryCacheKey() {
        return this.placeholderMemoryCacheKey;
    }

    public final DefinedRequestOptions getDefined() {
        return this.defined;
    }

    public final DefaultRequestOptions getDefaults() {
        return this.defaults;
    }

    public final Drawable getPlaceholder() {
        return Requests.getDrawableCompat(this, this.placeholderDrawable, this.placeholderResId, this.defaults.getPlaceholder());
    }

    public final Drawable getError() {
        return Requests.getDrawableCompat(this, this.errorDrawable, this.errorResId, this.defaults.getError());
    }

    public final Drawable getFallback() {
        return Requests.getDrawableCompat(this, this.fallbackDrawable, this.fallbackResId, this.defaults.getFallback());
    }

    public static /* synthetic */ Builder newBuilder$default(ImageRequest imageRequest, Context context, int i, Object obj) {
        if ((i & 1) != 0) {
            context = imageRequest.context;
        }
        return imageRequest.newBuilder(context);
    }

    public final Builder newBuilder(Context context) {
        return new Builder(this, context);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageRequest)) {
            return false;
        }
        ImageRequest imageRequest = (ImageRequest) obj;
        if (Intrinsics.areEqual(this.context, imageRequest.context) && Intrinsics.areEqual(this.data, imageRequest.data) && Intrinsics.areEqual(this.target, imageRequest.target) && Intrinsics.areEqual(this.listener, imageRequest.listener) && Intrinsics.areEqual(this.memoryCacheKey, imageRequest.memoryCacheKey) && Intrinsics.areEqual(this.diskCacheKey, imageRequest.diskCacheKey) && this.bitmapConfig == imageRequest.bitmapConfig) {
            return (Build.VERSION.SDK_INT < 26 || Intrinsics.areEqual(this.colorSpace, imageRequest.colorSpace)) && this.precision == imageRequest.precision && Intrinsics.areEqual(this.fetcherFactory, imageRequest.fetcherFactory) && Intrinsics.areEqual(this.decoderFactory, imageRequest.decoderFactory) && Intrinsics.areEqual(this.transformations, imageRequest.transformations) && Intrinsics.areEqual(this.transitionFactory, imageRequest.transitionFactory) && Intrinsics.areEqual(this.headers, imageRequest.headers) && Intrinsics.areEqual(this.tags, imageRequest.tags) && this.allowConversionToBitmap == imageRequest.allowConversionToBitmap && this.allowHardware == imageRequest.allowHardware && this.allowRgb565 == imageRequest.allowRgb565 && this.premultipliedAlpha == imageRequest.premultipliedAlpha && this.memoryCachePolicy == imageRequest.memoryCachePolicy && this.diskCachePolicy == imageRequest.diskCachePolicy && this.networkCachePolicy == imageRequest.networkCachePolicy && Intrinsics.areEqual(this.interceptorDispatcher, imageRequest.interceptorDispatcher) && Intrinsics.areEqual(this.fetcherDispatcher, imageRequest.fetcherDispatcher) && Intrinsics.areEqual(this.decoderDispatcher, imageRequest.decoderDispatcher) && Intrinsics.areEqual(this.transformationDispatcher, imageRequest.transformationDispatcher) && Intrinsics.areEqual(this.placeholderMemoryCacheKey, imageRequest.placeholderMemoryCacheKey) && Intrinsics.areEqual(this.placeholderResId, imageRequest.placeholderResId) && Intrinsics.areEqual(this.placeholderDrawable, imageRequest.placeholderDrawable) && Intrinsics.areEqual(this.errorResId, imageRequest.errorResId) && Intrinsics.areEqual(this.errorDrawable, imageRequest.errorDrawable) && Intrinsics.areEqual(this.fallbackResId, imageRequest.fallbackResId) && Intrinsics.areEqual(this.fallbackDrawable, imageRequest.fallbackDrawable) && Intrinsics.areEqual(this.lifecycle, imageRequest.lifecycle) && Intrinsics.areEqual(this.sizeResolver, imageRequest.sizeResolver) && this.scale == imageRequest.scale && Intrinsics.areEqual(this.parameters, imageRequest.parameters) && Intrinsics.areEqual(this.defined, imageRequest.defined) && Intrinsics.areEqual(this.defaults, imageRequest.defaults);
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = ((this.context.hashCode() * 31) + this.data.hashCode()) * 31;
        Target target = this.target;
        int iHashCode2 = (iHashCode + (target != null ? target.hashCode() : 0)) * 31;
        Listener listener = this.listener;
        int iHashCode3 = (iHashCode2 + (listener != null ? listener.hashCode() : 0)) * 31;
        MemoryCache.Key key = this.memoryCacheKey;
        int iHashCode4 = (iHashCode3 + (key != null ? key.hashCode() : 0)) * 31;
        String str = this.diskCacheKey;
        int iHashCode5 = (((iHashCode4 + (str != null ? str.hashCode() : 0)) * 31) + this.bitmapConfig.hashCode()) * 31;
        ColorSpace colorSpace = this.colorSpace;
        int iHashCode6 = (((iHashCode5 + (colorSpace != null ? colorSpace.hashCode() : 0)) * 31) + this.precision.hashCode()) * 31;
        Pair pair = this.fetcherFactory;
        int iHashCode7 = (iHashCode6 + (pair != null ? pair.hashCode() : 0)) * 31;
        Decoder.Factory factory = this.decoderFactory;
        int iHashCode8 = (((((((((((((((((((((((((((((((((((((((iHashCode7 + (factory != null ? factory.hashCode() : 0)) * 31) + this.transformations.hashCode()) * 31) + this.transitionFactory.hashCode()) * 31) + this.headers.hashCode()) * 31) + this.tags.hashCode()) * 31) + Boolean.hashCode(this.allowConversionToBitmap)) * 31) + Boolean.hashCode(this.allowHardware)) * 31) + Boolean.hashCode(this.allowRgb565)) * 31) + Boolean.hashCode(this.premultipliedAlpha)) * 31) + this.memoryCachePolicy.hashCode()) * 31) + this.diskCachePolicy.hashCode()) * 31) + this.networkCachePolicy.hashCode()) * 31) + this.interceptorDispatcher.hashCode()) * 31) + this.fetcherDispatcher.hashCode()) * 31) + this.decoderDispatcher.hashCode()) * 31) + this.transformationDispatcher.hashCode()) * 31) + this.lifecycle.hashCode()) * 31) + this.sizeResolver.hashCode()) * 31) + this.scale.hashCode()) * 31) + this.parameters.hashCode()) * 31;
        MemoryCache.Key key2 = this.placeholderMemoryCacheKey;
        int iHashCode9 = (iHashCode8 + (key2 != null ? key2.hashCode() : 0)) * 31;
        Integer num = this.placeholderResId;
        int iHashCode10 = (iHashCode9 + (num != null ? num.hashCode() : 0)) * 31;
        Drawable drawable = this.placeholderDrawable;
        int iHashCode11 = (iHashCode10 + (drawable != null ? drawable.hashCode() : 0)) * 31;
        Integer num2 = this.errorResId;
        int iHashCode12 = (iHashCode11 + (num2 != null ? num2.hashCode() : 0)) * 31;
        Drawable drawable2 = this.errorDrawable;
        int iHashCode13 = (iHashCode12 + (drawable2 != null ? drawable2.hashCode() : 0)) * 31;
        Integer num3 = this.fallbackResId;
        int iHashCode14 = (iHashCode13 + (num3 != null ? num3.hashCode() : 0)) * 31;
        Drawable drawable3 = this.fallbackDrawable;
        return ((((iHashCode14 + (drawable3 != null ? drawable3.hashCode() : 0)) * 31) + this.defined.hashCode()) * 31) + this.defaults.hashCode();
    }

    public static final class Builder {
        private boolean allowConversionToBitmap;
        private Boolean allowHardware;
        private Boolean allowRgb565;
        private Bitmap.Config bitmapConfig;
        private ColorSpace colorSpace;
        private final Context context;
        private Object data;
        private CoroutineDispatcher decoderDispatcher;
        private Decoder.Factory decoderFactory;
        private DefaultRequestOptions defaults;
        private String diskCacheKey;
        private CachePolicy diskCachePolicy;
        private Drawable errorDrawable;
        private Integer errorResId;
        private Drawable fallbackDrawable;
        private Integer fallbackResId;
        private CoroutineDispatcher fetcherDispatcher;
        private Pair fetcherFactory;
        private Headers.Builder headers;
        private CoroutineDispatcher interceptorDispatcher;
        private Lifecycle lifecycle;
        private Listener listener;
        private MemoryCache.Key memoryCacheKey;
        private CachePolicy memoryCachePolicy;
        private CachePolicy networkCachePolicy;
        private Parameters.Builder parameters;
        private Drawable placeholderDrawable;
        private MemoryCache.Key placeholderMemoryCacheKey;
        private Integer placeholderResId;
        private Precision precision;
        private boolean premultipliedAlpha;
        private Lifecycle resolvedLifecycle;
        private Scale resolvedScale;
        private SizeResolver resolvedSizeResolver;
        private Scale scale;
        private SizeResolver sizeResolver;
        private Map tags;
        private Target target;
        private CoroutineDispatcher transformationDispatcher;
        private List transformations;
        private Transition.Factory transitionFactory;

        public Builder(Context context) {
            this.context = context;
            this.defaults = Requests.getDEFAULT_REQUEST_OPTIONS();
            this.data = null;
            this.target = null;
            this.listener = null;
            this.memoryCacheKey = null;
            this.diskCacheKey = null;
            this.bitmapConfig = null;
            if (Build.VERSION.SDK_INT >= 26) {
                this.colorSpace = null;
            }
            this.precision = null;
            this.fetcherFactory = null;
            this.decoderFactory = null;
            this.transformations = CollectionsKt.emptyList();
            this.transitionFactory = null;
            this.headers = null;
            this.tags = null;
            this.allowConversionToBitmap = true;
            this.allowHardware = null;
            this.allowRgb565 = null;
            this.premultipliedAlpha = true;
            this.memoryCachePolicy = null;
            this.diskCachePolicy = null;
            this.networkCachePolicy = null;
            this.interceptorDispatcher = null;
            this.fetcherDispatcher = null;
            this.decoderDispatcher = null;
            this.transformationDispatcher = null;
            this.parameters = null;
            this.placeholderMemoryCacheKey = null;
            this.placeholderResId = null;
            this.placeholderDrawable = null;
            this.errorResId = null;
            this.errorDrawable = null;
            this.fallbackResId = null;
            this.fallbackDrawable = null;
            this.lifecycle = null;
            this.sizeResolver = null;
            this.scale = null;
            this.resolvedLifecycle = null;
            this.resolvedSizeResolver = null;
            this.resolvedScale = null;
        }

        public Builder(ImageRequest imageRequest, Context context) {
            this.context = context;
            this.defaults = imageRequest.getDefaults();
            this.data = imageRequest.getData();
            this.target = imageRequest.getTarget();
            this.listener = imageRequest.getListener();
            this.memoryCacheKey = imageRequest.getMemoryCacheKey();
            this.diskCacheKey = imageRequest.getDiskCacheKey();
            this.bitmapConfig = imageRequest.getDefined().getBitmapConfig();
            if (Build.VERSION.SDK_INT >= 26) {
                this.colorSpace = imageRequest.getColorSpace();
            }
            this.precision = imageRequest.getDefined().getPrecision();
            this.fetcherFactory = imageRequest.getFetcherFactory();
            this.decoderFactory = imageRequest.getDecoderFactory();
            this.transformations = imageRequest.getTransformations();
            this.transitionFactory = imageRequest.getDefined().getTransitionFactory();
            this.headers = imageRequest.getHeaders().newBuilder();
            this.tags = MapsKt.toMutableMap(imageRequest.getTags().asMap());
            this.allowConversionToBitmap = imageRequest.getAllowConversionToBitmap();
            this.allowHardware = imageRequest.getDefined().getAllowHardware();
            this.allowRgb565 = imageRequest.getDefined().getAllowRgb565();
            this.premultipliedAlpha = imageRequest.getPremultipliedAlpha();
            this.memoryCachePolicy = imageRequest.getDefined().getMemoryCachePolicy();
            this.diskCachePolicy = imageRequest.getDefined().getDiskCachePolicy();
            this.networkCachePolicy = imageRequest.getDefined().getNetworkCachePolicy();
            this.interceptorDispatcher = imageRequest.getDefined().getInterceptorDispatcher();
            this.fetcherDispatcher = imageRequest.getDefined().getFetcherDispatcher();
            this.decoderDispatcher = imageRequest.getDefined().getDecoderDispatcher();
            this.transformationDispatcher = imageRequest.getDefined().getTransformationDispatcher();
            this.parameters = imageRequest.getParameters().newBuilder();
            this.placeholderMemoryCacheKey = imageRequest.getPlaceholderMemoryCacheKey();
            this.placeholderResId = imageRequest.placeholderResId;
            this.placeholderDrawable = imageRequest.placeholderDrawable;
            this.errorResId = imageRequest.errorResId;
            this.errorDrawable = imageRequest.errorDrawable;
            this.fallbackResId = imageRequest.fallbackResId;
            this.fallbackDrawable = imageRequest.fallbackDrawable;
            this.lifecycle = imageRequest.getDefined().getLifecycle();
            this.sizeResolver = imageRequest.getDefined().getSizeResolver();
            this.scale = imageRequest.getDefined().getScale();
            if (imageRequest.getContext() == context) {
                this.resolvedLifecycle = imageRequest.getLifecycle();
                this.resolvedSizeResolver = imageRequest.getSizeResolver();
                this.resolvedScale = imageRequest.getScale();
            } else {
                this.resolvedLifecycle = null;
                this.resolvedSizeResolver = null;
                this.resolvedScale = null;
            }
        }

        public final Builder data(Object obj) {
            this.data = obj;
            return this;
        }

        public final Builder transformations(List list) {
            this.transformations = Collections.toImmutableList(list);
            return this;
        }

        public final Builder size(SizeResolver sizeResolver) {
            this.sizeResolver = sizeResolver;
            resetResolvedValues();
            return this;
        }

        public final Builder scale(Scale scale) {
            this.scale = scale;
            return this;
        }

        public final Builder precision(Precision precision) {
            this.precision = precision;
            return this;
        }

        public final Builder memoryCachePolicy(CachePolicy cachePolicy) {
            this.memoryCachePolicy = cachePolicy;
            return this;
        }

        public final Builder diskCachePolicy(CachePolicy cachePolicy) {
            this.diskCachePolicy = cachePolicy;
            return this;
        }

        public final Builder target(Target target) {
            this.target = target;
            resetResolvedValues();
            return this;
        }

        public final Builder crossfade(int i) {
            Transition.Factory factory;
            if (i > 0) {
                factory = new CrossfadeTransition.Factory(i, false, 2, null);
            } else {
                factory = Transition.Factory.NONE;
            }
            transitionFactory(factory);
            return this;
        }

        public final Builder transitionFactory(Transition.Factory factory) {
            this.transitionFactory = factory;
            return this;
        }

        public final Builder defaults(DefaultRequestOptions defaultRequestOptions) {
            this.defaults = defaultRequestOptions;
            resetResolvedScale();
            return this;
        }

        public final ImageRequest build() {
            Context context = this.context;
            Object obj = this.data;
            if (obj == null) {
                obj = NullRequestData.INSTANCE;
            }
            Object obj2 = obj;
            Target target = this.target;
            Listener listener = this.listener;
            MemoryCache.Key key = this.memoryCacheKey;
            String str = this.diskCacheKey;
            Bitmap.Config bitmapConfig = this.bitmapConfig;
            if (bitmapConfig == null) {
                bitmapConfig = this.defaults.getBitmapConfig();
            }
            Bitmap.Config config = bitmapConfig;
            ColorSpace colorSpace = this.colorSpace;
            Precision precision = this.precision;
            if (precision == null) {
                precision = this.defaults.getPrecision();
            }
            Precision precision2 = precision;
            Pair pair = this.fetcherFactory;
            Decoder.Factory factory = this.decoderFactory;
            List list = this.transformations;
            Transition.Factory transitionFactory = this.transitionFactory;
            if (transitionFactory == null) {
                transitionFactory = this.defaults.getTransitionFactory();
            }
            Transition.Factory factory2 = transitionFactory;
            Headers.Builder builder = this.headers;
            Headers headersOrEmpty = Utils.orEmpty(builder != null ? builder.build() : null);
            Map map = this.tags;
            Tags tagsOrEmpty = Utils.orEmpty(map != null ? Tags.Companion.from(map) : null);
            boolean z = this.allowConversionToBitmap;
            Boolean bool = this.allowHardware;
            boolean zBooleanValue = bool != null ? bool.booleanValue() : this.defaults.getAllowHardware();
            Boolean bool2 = this.allowRgb565;
            boolean zBooleanValue2 = bool2 != null ? bool2.booleanValue() : this.defaults.getAllowRgb565();
            boolean z2 = this.premultipliedAlpha;
            CachePolicy memoryCachePolicy = this.memoryCachePolicy;
            if (memoryCachePolicy == null) {
                memoryCachePolicy = this.defaults.getMemoryCachePolicy();
            }
            CachePolicy cachePolicy = memoryCachePolicy;
            CachePolicy diskCachePolicy = this.diskCachePolicy;
            if (diskCachePolicy == null) {
                diskCachePolicy = this.defaults.getDiskCachePolicy();
            }
            CachePolicy cachePolicy2 = diskCachePolicy;
            CachePolicy networkCachePolicy = this.networkCachePolicy;
            if (networkCachePolicy == null) {
                networkCachePolicy = this.defaults.getNetworkCachePolicy();
            }
            CachePolicy cachePolicy3 = networkCachePolicy;
            CoroutineDispatcher interceptorDispatcher = this.interceptorDispatcher;
            if (interceptorDispatcher == null) {
                interceptorDispatcher = this.defaults.getInterceptorDispatcher();
            }
            CoroutineDispatcher coroutineDispatcher = interceptorDispatcher;
            CoroutineDispatcher fetcherDispatcher = this.fetcherDispatcher;
            if (fetcherDispatcher == null) {
                fetcherDispatcher = this.defaults.getFetcherDispatcher();
            }
            CoroutineDispatcher coroutineDispatcher2 = fetcherDispatcher;
            CoroutineDispatcher decoderDispatcher = this.decoderDispatcher;
            if (decoderDispatcher == null) {
                decoderDispatcher = this.defaults.getDecoderDispatcher();
            }
            CoroutineDispatcher coroutineDispatcher3 = decoderDispatcher;
            CoroutineDispatcher transformationDispatcher = this.transformationDispatcher;
            if (transformationDispatcher == null) {
                transformationDispatcher = this.defaults.getTransformationDispatcher();
            }
            CoroutineDispatcher coroutineDispatcher4 = transformationDispatcher;
            Lifecycle lifecycleResolveLifecycle = this.lifecycle;
            if (lifecycleResolveLifecycle == null && (lifecycleResolveLifecycle = this.resolvedLifecycle) == null) {
                lifecycleResolveLifecycle = resolveLifecycle();
            }
            Lifecycle lifecycle = lifecycleResolveLifecycle;
            SizeResolver sizeResolverResolveSizeResolver = this.sizeResolver;
            if (sizeResolverResolveSizeResolver == null && (sizeResolverResolveSizeResolver = this.resolvedSizeResolver) == null) {
                sizeResolverResolveSizeResolver = resolveSizeResolver();
            }
            SizeResolver sizeResolver = sizeResolverResolveSizeResolver;
            Scale scaleResolveScale = this.scale;
            if (scaleResolveScale == null && (scaleResolveScale = this.resolvedScale) == null) {
                scaleResolveScale = resolveScale();
            }
            Scale scale = scaleResolveScale;
            Parameters.Builder builder2 = this.parameters;
            return new ImageRequest(context, obj2, target, listener, key, str, config, colorSpace, precision2, pair, factory, list, factory2, headersOrEmpty, tagsOrEmpty, z, zBooleanValue, zBooleanValue2, z2, cachePolicy, cachePolicy2, cachePolicy3, coroutineDispatcher, coroutineDispatcher2, coroutineDispatcher3, coroutineDispatcher4, lifecycle, sizeResolver, scale, Utils.orEmpty(builder2 != null ? builder2.build() : null), this.placeholderMemoryCacheKey, this.placeholderResId, this.placeholderDrawable, this.errorResId, this.errorDrawable, this.fallbackResId, this.fallbackDrawable, new DefinedRequestOptions(this.lifecycle, this.sizeResolver, this.scale, this.interceptorDispatcher, this.fetcherDispatcher, this.decoderDispatcher, this.transformationDispatcher, this.transitionFactory, this.precision, this.bitmapConfig, this.allowHardware, this.allowRgb565, this.memoryCachePolicy, this.diskCachePolicy, this.networkCachePolicy), this.defaults, null);
        }

        private final void resetResolvedValues() {
            this.resolvedLifecycle = null;
            this.resolvedSizeResolver = null;
            this.resolvedScale = null;
        }

        private final void resetResolvedScale() {
            this.resolvedScale = null;
        }

        private final Lifecycle resolveLifecycle() {
            Lifecycle lifecycle = Contexts.getLifecycle(this.context);
            return lifecycle == null ? GlobalLifecycle.INSTANCE : lifecycle;
        }

        private final SizeResolver resolveSizeResolver() {
            return new DisplaySizeResolver(this.context);
        }

        private final Scale resolveScale() {
            View view;
            SizeResolver sizeResolver = this.sizeResolver;
            View view2 = null;
            ViewSizeResolver viewSizeResolver = sizeResolver instanceof ViewSizeResolver ? (ViewSizeResolver) sizeResolver : null;
            if (viewSizeResolver != null && (view = viewSizeResolver.getView()) != null) {
                view2 = view;
            }
            if (view2 instanceof ImageView) {
                return Utils.getScale((ImageView) view2);
            }
            return Scale.FIT;
        }
    }
}
