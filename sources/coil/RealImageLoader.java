package coil;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import coil.decode.BitmapFactoryDecoder;
import coil.fetch.AssetUriFetcher;
import coil.fetch.BitmapFetcher;
import coil.fetch.ByteBufferFetcher;
import coil.fetch.ContentUriFetcher;
import coil.fetch.DrawableFetcher;
import coil.fetch.FileFetcher;
import coil.fetch.HttpUriFetcher;
import coil.fetch.ResourceUriFetcher;
import coil.intercept.EngineInterceptor;
import coil.key.FileKeyer;
import coil.key.UriKeyer;
import coil.map.ByteArrayMapper;
import coil.map.FileUriMapper;
import coil.map.HttpUrlMapper;
import coil.map.ResourceIntMapper;
import coil.map.ResourceUriMapper;
import coil.map.StringMapper;
import coil.memory.MemoryCache;
import coil.request.DefaultRequestOptions;
import coil.request.Disposable;
import coil.request.ErrorResult;
import coil.request.ImageRequest;
import coil.request.ImageResult;
import coil.request.NullRequestData;
import coil.request.NullRequestDataException;
import coil.request.OneShotDisposable;
import coil.request.RequestDelegate;
import coil.request.RequestService;
import coil.request.SuccessResult;
import coil.size.Size;
import coil.size.SizeResolver;
import coil.target.Target;
import coil.transition.NoneTransition;
import coil.transition.Transition;
import coil.transition.TransitionTarget;
import coil.util.ImageLoaderOptions;
import coil.util.Lifecycles;
import coil.util.Logger;
import coil.util.SystemCallbacks;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.SupervisorKt;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes3.dex */
public final class RealImageLoader implements ImageLoader {
    public static final Companion Companion = new Companion(null);
    private final Lazy callFactoryLazy;
    private final ComponentRegistry componentRegistry;
    private final ComponentRegistry components;
    private final Context context;
    private final DefaultRequestOptions defaults;
    private final Lazy diskCacheLazy;
    private final EventListener.Factory eventListenerFactory;
    private final List interceptors;
    private final Lazy memoryCacheLazy;
    private final ImageLoaderOptions options;
    private final RequestService requestService;
    private final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()).plus(new RealImageLoader$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE, this)));
    private final AtomicBoolean shutdown;
    private final SystemCallbacks systemCallbacks;

    /* JADX INFO: renamed from: coil.RealImageLoader$executeMain$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return RealImageLoader.this.executeMain(null, 0, this);
        }
    }

    public final Logger getLogger() {
        return null;
    }

    public RealImageLoader(Context context, DefaultRequestOptions defaultRequestOptions, Lazy lazy, Lazy lazy2, Lazy lazy3, EventListener.Factory factory, ComponentRegistry componentRegistry, ImageLoaderOptions imageLoaderOptions, Logger logger) {
        this.context = context;
        this.defaults = defaultRequestOptions;
        this.memoryCacheLazy = lazy;
        this.diskCacheLazy = lazy2;
        this.callFactoryLazy = lazy3;
        this.eventListenerFactory = factory;
        this.componentRegistry = componentRegistry;
        this.options = imageLoaderOptions;
        SystemCallbacks systemCallbacks = new SystemCallbacks(this, context, imageLoaderOptions.getNetworkObserverEnabled());
        this.systemCallbacks = systemCallbacks;
        RequestService requestService = new RequestService(this, systemCallbacks, null);
        this.requestService = requestService;
        this.components = componentRegistry.newBuilder().add(new HttpUrlMapper(), HttpUrl.class).add(new StringMapper(), String.class).add(new FileUriMapper(), Uri.class).add(new ResourceUriMapper(), Uri.class).add(new ResourceIntMapper(), Integer.class).add(new ByteArrayMapper(), byte[].class).add(new UriKeyer(), Uri.class).add(new FileKeyer(imageLoaderOptions.getAddLastModifiedToFileCacheKey()), File.class).add(new HttpUriFetcher.Factory(lazy3, lazy2, imageLoaderOptions.getRespectCacheHeaders()), Uri.class).add(new FileFetcher.Factory(), File.class).add(new AssetUriFetcher.Factory(), Uri.class).add(new ContentUriFetcher.Factory(), Uri.class).add(new ResourceUriFetcher.Factory(), Uri.class).add(new DrawableFetcher.Factory(), Drawable.class).add(new BitmapFetcher.Factory(), Bitmap.class).add(new ByteBufferFetcher.Factory(), ByteBuffer.class).add(new BitmapFactoryDecoder.Factory(imageLoaderOptions.getBitmapFactoryMaxParallelism(), imageLoaderOptions.getBitmapFactoryExifOrientationPolicy())).build();
        this.interceptors = CollectionsKt.plus((Collection) getComponents().getInterceptors(), (Object) new EngineInterceptor(this, requestService, null));
        this.shutdown = new AtomicBoolean(false);
        systemCallbacks.register();
    }

    @Override // coil.ImageLoader
    public DefaultRequestOptions getDefaults() {
        return this.defaults;
    }

    @Override // coil.ImageLoader
    public MemoryCache getMemoryCache() {
        return (MemoryCache) this.memoryCacheLazy.getValue();
    }

    @Override // coil.ImageLoader
    public ComponentRegistry getComponents() {
        return this.components;
    }

    @Override // coil.ImageLoader
    public Disposable enqueue(ImageRequest imageRequest) {
        Deferred deferredAsync$default = BuildersKt__Builders_commonKt.async$default(this.scope, null, null, new RealImageLoader$enqueue$job$1(this, imageRequest, null), 3, null);
        imageRequest.getTarget();
        return new OneShotDisposable(deferredAsync$default);
    }

    /* JADX INFO: renamed from: coil.RealImageLoader$execute$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        final /* synthetic */ ImageRequest $request;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ RealImageLoader this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ImageRequest imageRequest, RealImageLoader realImageLoader, Continuation continuation) {
            super(2, continuation);
            this.$request = imageRequest;
            this.this$0 = realImageLoader;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$request, this.this$0, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            Deferred deferredAsync$default = BuildersKt__Builders_commonKt.async$default((CoroutineScope) this.L$0, Dispatchers.getMain().getImmediate(), null, new RealImageLoader$execute$2$job$1(this.this$0, this.$request, null), 2, null);
            this.$request.getTarget();
            this.label = 1;
            Object objAwait = deferredAsync$default.await(this);
            return objAwait == coroutine_suspended ? coroutine_suspended : objAwait;
        }
    }

    @Override // coil.ImageLoader
    public Object execute(ImageRequest imageRequest, Continuation continuation) {
        return CoroutineScopeKt.coroutineScope(new AnonymousClass2(imageRequest, this, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:55:0x0113  */
    /* JADX WARN: Code duplicated, block: B:75:0x0183  */
    /* JADX WARN: Code duplicated, block: B:78:0x018d A[Catch: all -> 0x004b, TryCatch #5 {all -> 0x004b, blocks: (B:14:0x0046, B:76:0x0187, B:78:0x018d, B:79:0x0198, B:81:0x019c), top: B:111:0x0046 }] */
    /* JADX WARN: Code duplicated, block: B:79:0x0198 A[Catch: all -> 0x004b, TryCatch #5 {all -> 0x004b, blocks: (B:14:0x0046, B:76:0x0187, B:78:0x018d, B:79:0x0198, B:81:0x019c), top: B:111:0x0046 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code duplicated, block: B:81:0x019c A[Catch: all -> 0x004b, TRY_LEAVE, TryCatch #5 {all -> 0x004b, blocks: (B:14:0x0046, B:76:0x0187, B:78:0x018d, B:79:0x0198, B:81:0x019c), top: B:111:0x0046 }] */
    /* JADX WARN: Code duplicated, block: B:92:0x01be A[Catch: all -> 0x01cf, TRY_LEAVE, TryCatch #7 {all -> 0x01cf, blocks: (B:90:0x01ba, B:92:0x01be, B:97:0x01d1, B:98:0x01d4), top: B:113:0x01ba }] */
    /* JADX WARN: Code duplicated, block: B:97:0x01d1 A[Catch: all -> 0x01cf, TRY_ENTER, TryCatch #7 {all -> 0x01cf, blocks: (B:90:0x01ba, B:92:0x01be, B:97:0x01d1, B:98:0x01d4), top: B:113:0x01ba }] */
    public final Object executeMain(ImageRequest imageRequest, int i, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        RequestDelegate requestDelegate;
        ImageRequest imageRequestBuild;
        RealImageLoader realImageLoader;
        RequestDelegate requestDelegate2;
        EventListener eventListener;
        RealImageLoader realImageLoader2;
        ImageRequest imageRequest2;
        EventListener eventListener2;
        RequestDelegate requestDelegate3;
        Bitmap bitmap;
        Drawable placeholder;
        ImageRequest imageRequest3;
        RealImageLoader realImageLoader3;
        RequestDelegate requestDelegate4;
        EventListener eventListener3;
        ImageResult imageResult;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i2 = anonymousClass1.label;
            if ((i2 & LinearLayoutManager.INVALID_OFFSET) != 0) {
                anonymousClass1.label = i2 - LinearLayoutManager.INVALID_OFFSET;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objWithContext = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = anonymousClass1.label;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(objWithContext);
                requestDelegate = this.requestService.requestDelegate(imageRequest, JobKt.getJob(anonymousClass1.getContext()));
                requestDelegate.assertActive();
                imageRequestBuild = ImageRequest.newBuilder$default(imageRequest, null, 1, null).defaults(getDefaults()).build();
                EventListener eventListenerCreate = this.eventListenerFactory.create(imageRequestBuild);
                try {
                    if (imageRequestBuild.getData() == NullRequestData.INSTANCE) {
                        throw new NullRequestDataException();
                    }
                    requestDelegate.start();
                    if (i == 0) {
                        Lifecycle lifecycle = imageRequestBuild.getLifecycle();
                        anonymousClass1.L$0 = this;
                        anonymousClass1.L$1 = requestDelegate;
                        anonymousClass1.L$2 = imageRequestBuild;
                        anonymousClass1.L$3 = eventListenerCreate;
                        anonymousClass1.label = 1;
                        if (Lifecycles.awaitStarted(lifecycle, anonymousClass1) != coroutine_suspended) {
                            realImageLoader2 = this;
                            imageRequest2 = imageRequestBuild;
                            eventListener2 = eventListenerCreate;
                            requestDelegate3 = requestDelegate;
                            requestDelegate = requestDelegate3;
                        }
                    } else {
                        realImageLoader2 = this;
                        imageRequest2 = imageRequestBuild;
                        eventListener2 = eventListenerCreate;
                    }
                    return coroutine_suspended;
                } catch (Throwable th) {
                    th = th;
                    realImageLoader = this;
                    requestDelegate2 = requestDelegate;
                    eventListener = eventListenerCreate;
                }
            } else {
                if (i3 != 1) {
                    if (i3 == 2) {
                        bitmap = (Bitmap) anonymousClass1.L$4;
                        eventListener2 = (EventListener) anonymousClass1.L$3;
                        ImageRequest imageRequest4 = (ImageRequest) anonymousClass1.L$2;
                        requestDelegate4 = (RequestDelegate) anonymousClass1.L$1;
                        RealImageLoader realImageLoader4 = (RealImageLoader) anonymousClass1.L$0;
                        try {
                            ResultKt.throwOnFailure(objWithContext);
                            imageRequest3 = imageRequest4;
                            realImageLoader3 = realImageLoader4;
                            Bitmap bitmap2 = bitmap;
                            try {
                                Size size = (Size) objWithContext;
                                eventListener2.resolveSizeEnd(imageRequest3, size);
                                CoroutineDispatcher interceptorDispatcher = imageRequest3.getInterceptorDispatcher();
                                eventListener3 = eventListener2;
                                try {
                                    RealImageLoader$executeMain$result$1 realImageLoader$executeMain$result$1 = new RealImageLoader$executeMain$result$1(imageRequest3, realImageLoader3, size, eventListener3, bitmap2, null);
                                    anonymousClass1.L$0 = realImageLoader3;
                                    anonymousClass1.L$1 = requestDelegate4;
                                    anonymousClass1.L$2 = imageRequest3;
                                    anonymousClass1.L$3 = eventListener2;
                                    anonymousClass1.L$4 = null;
                                    anonymousClass1.label = 3;
                                    objWithContext = BuildersKt.withContext(interceptorDispatcher, realImageLoader$executeMain$result$1, anonymousClass1);
                                    if (objWithContext != coroutine_suspended) {
                                        eventListener = eventListener2;
                                        requestDelegate2 = requestDelegate4;
                                        imageRequestBuild = imageRequest3;
                                        realImageLoader = realImageLoader3;
                                        imageResult = (ImageResult) objWithContext;
                                        if (imageResult instanceof SuccessResult) {
                                            realImageLoader.onSuccess((SuccessResult) imageResult, imageRequestBuild.getTarget(), eventListener);
                                        } else if (imageResult instanceof ErrorResult) {
                                            realImageLoader.onError((ErrorResult) imageResult, imageRequestBuild.getTarget(), eventListener);
                                        }
                                        requestDelegate2.complete();
                                        return imageResult;
                                    }
                                    return coroutine_suspended;
                                } catch (Throwable th2) {
                                    th = th2;
                                    eventListener2 = eventListener3;
                                    eventListener = eventListener2;
                                    requestDelegate2 = requestDelegate4;
                                    imageRequestBuild = imageRequest3;
                                    realImageLoader = realImageLoader3;
                                    if (th instanceof CancellationException) {
                                        realImageLoader.onCancel(imageRequestBuild, eventListener);
                                        throw th;
                                    }
                                    ErrorResult errorResult = realImageLoader.requestService.errorResult(imageRequestBuild, th);
                                    realImageLoader.onError(errorResult, imageRequestBuild.getTarget(), eventListener);
                                    requestDelegate2.complete();
                                    return errorResult;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            eventListener = eventListener2;
                            imageRequestBuild = imageRequest4;
                            requestDelegate2 = requestDelegate4;
                            realImageLoader = realImageLoader4;
                        }
                    } else {
                        if (i3 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        eventListener = (EventListener) anonymousClass1.L$3;
                        imageRequestBuild = (ImageRequest) anonymousClass1.L$2;
                        requestDelegate2 = (RequestDelegate) anonymousClass1.L$1;
                        realImageLoader = (RealImageLoader) anonymousClass1.L$0;
                        try {
                            ResultKt.throwOnFailure(objWithContext);
                            imageResult = (ImageResult) objWithContext;
                            if (imageResult instanceof SuccessResult) {
                                realImageLoader.onSuccess((SuccessResult) imageResult, imageRequestBuild.getTarget(), eventListener);
                            } else if (imageResult instanceof ErrorResult) {
                                realImageLoader.onError((ErrorResult) imageResult, imageRequestBuild.getTarget(), eventListener);
                            }
                            requestDelegate2.complete();
                            return imageResult;
                        } catch (Throwable th5) {
                            th = th5;
                        }
                    }
                    try {
                        if (th instanceof CancellationException) {
                            realImageLoader.onCancel(imageRequestBuild, eventListener);
                            throw th;
                        }
                        ErrorResult errorResult2 = realImageLoader.requestService.errorResult(imageRequestBuild, th);
                        realImageLoader.onError(errorResult2, imageRequestBuild.getTarget(), eventListener);
                        requestDelegate2.complete();
                        return errorResult2;
                    } catch (Throwable th6) {
                        requestDelegate2.complete();
                        throw th6;
                    }
                }
                eventListener2 = (EventListener) anonymousClass1.L$3;
                imageRequest2 = (ImageRequest) anonymousClass1.L$2;
                requestDelegate3 = (RequestDelegate) anonymousClass1.L$1;
                realImageLoader2 = (RealImageLoader) anonymousClass1.L$0;
                try {
                    ResultKt.throwOnFailure(objWithContext);
                    requestDelegate = requestDelegate3;
                } catch (Throwable th7) {
                    th = th7;
                    eventListener = eventListener2;
                    imageRequestBuild = imageRequest2;
                    requestDelegate2 = requestDelegate3;
                    realImageLoader = realImageLoader2;
                    if (th instanceof CancellationException) {
                        realImageLoader.onCancel(imageRequestBuild, eventListener);
                        throw th;
                    }
                    ErrorResult errorResult3 = realImageLoader.requestService.errorResult(imageRequestBuild, th);
                    realImageLoader.onError(errorResult3, imageRequestBuild.getTarget(), eventListener);
                    requestDelegate2.complete();
                    return errorResult3;
                }
            }
            MemoryCache memoryCache = realImageLoader2.getMemoryCache();
            if (memoryCache == null) {
                bitmap = null;
            } else {
                MemoryCache.Key placeholderMemoryCacheKey = imageRequest2.getPlaceholderMemoryCacheKey();
                MemoryCache.Value value = placeholderMemoryCacheKey != null ? memoryCache.get(placeholderMemoryCacheKey) : null;
                if (value != null) {
                    bitmap = value.getBitmap();
                } else {
                    bitmap = null;
                }
            }
            if (bitmap == null) {
                placeholder = imageRequest2.getPlaceholder();
            } else {
                placeholder = new BitmapDrawable(imageRequest2.getContext().getResources(), bitmap);
            }
            Target target = imageRequest2.getTarget();
            if (target != null) {
                target.onStart(placeholder);
            }
            eventListener2.onStart(imageRequest2);
            ImageRequest.Listener listener = imageRequest2.getListener();
            if (listener != null) {
                listener.onStart(imageRequest2);
            }
            eventListener2.resolveSizeStart(imageRequest2);
            SizeResolver sizeResolver = imageRequest2.getSizeResolver();
            anonymousClass1.L$0 = realImageLoader2;
            anonymousClass1.L$1 = requestDelegate;
            anonymousClass1.L$2 = imageRequest2;
            anonymousClass1.L$3 = eventListener2;
            anonymousClass1.L$4 = bitmap;
            anonymousClass1.label = 2;
            Object size2 = sizeResolver.size(anonymousClass1);
            if (size2 != coroutine_suspended) {
                imageRequest3 = imageRequest2;
                realImageLoader3 = realImageLoader2;
                requestDelegate4 = requestDelegate;
                objWithContext = size2;
                Bitmap bitmap3 = bitmap;
                Size size3 = (Size) objWithContext;
                eventListener2.resolveSizeEnd(imageRequest3, size3);
                CoroutineDispatcher interceptorDispatcher2 = imageRequest3.getInterceptorDispatcher();
                eventListener3 = eventListener2;
                RealImageLoader$executeMain$result$1 realImageLoader$executeMain$result$2 = new RealImageLoader$executeMain$result$1(imageRequest3, realImageLoader3, size3, eventListener3, bitmap3, null);
                anonymousClass1.L$0 = realImageLoader3;
                anonymousClass1.L$1 = requestDelegate4;
                anonymousClass1.L$2 = imageRequest3;
                anonymousClass1.L$3 = eventListener2;
                anonymousClass1.L$4 = null;
                anonymousClass1.label = 3;
                objWithContext = BuildersKt.withContext(interceptorDispatcher2, realImageLoader$executeMain$result$2, anonymousClass1);
                if (objWithContext != coroutine_suspended) {
                    eventListener = eventListener2;
                    requestDelegate2 = requestDelegate4;
                    imageRequestBuild = imageRequest3;
                    realImageLoader = realImageLoader3;
                    imageResult = (ImageResult) objWithContext;
                    if (imageResult instanceof SuccessResult) {
                        realImageLoader.onSuccess((SuccessResult) imageResult, imageRequestBuild.getTarget(), eventListener);
                    } else if (imageResult instanceof ErrorResult) {
                        realImageLoader.onError((ErrorResult) imageResult, imageRequestBuild.getTarget(), eventListener);
                    }
                    requestDelegate2.complete();
                    return imageResult;
                }
            }
            return coroutine_suspended;
        } catch (Throwable th8) {
            th = th8;
            requestDelegate2 = requestDelegate;
            eventListener = eventListener2;
            imageRequestBuild = imageRequest2;
            realImageLoader = realImageLoader2;
        }
    }

    public final void onTrimMemory$coil_base_release(int i) {
        MemoryCache memoryCache;
        Lazy lazy = this.memoryCacheLazy;
        if (lazy == null || (memoryCache = (MemoryCache) lazy.getValue()) == null) {
            return;
        }
        memoryCache.trimMemory(i);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0021  */
    private final void onSuccess(SuccessResult successResult, Target target, EventListener eventListener) {
        ImageRequest request = successResult.getRequest();
        successResult.getDataSource();
        if (target instanceof TransitionTarget) {
            Transition transitionCreate = successResult.getRequest().getTransitionFactory().create((TransitionTarget) target, successResult);
            if (transitionCreate instanceof NoneTransition) {
                target.onSuccess(successResult.getDrawable());
            } else {
                eventListener.transitionStart(successResult.getRequest(), transitionCreate);
                transitionCreate.transition();
                eventListener.transitionEnd(successResult.getRequest(), transitionCreate);
            }
        } else if (target != null) {
            target.onSuccess(successResult.getDrawable());
        }
        eventListener.onSuccess(request, successResult);
        ImageRequest.Listener listener = request.getListener();
        if (listener != null) {
            listener.onSuccess(request, successResult);
        }
    }

    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    private final void onError(ErrorResult errorResult, Target target, EventListener eventListener) {
        ImageRequest request = errorResult.getRequest();
        if (target instanceof TransitionTarget) {
            Transition transitionCreate = errorResult.getRequest().getTransitionFactory().create((TransitionTarget) target, errorResult);
            if (transitionCreate instanceof NoneTransition) {
                target.onError(errorResult.getDrawable());
            } else {
                eventListener.transitionStart(errorResult.getRequest(), transitionCreate);
                transitionCreate.transition();
                eventListener.transitionEnd(errorResult.getRequest(), transitionCreate);
            }
        } else if (target != null) {
            target.onError(errorResult.getDrawable());
        }
        eventListener.onError(request, errorResult);
        ImageRequest.Listener listener = request.getListener();
        if (listener != null) {
            listener.onError(request, errorResult);
        }
    }

    private final void onCancel(ImageRequest imageRequest, EventListener eventListener) {
        eventListener.onCancel(imageRequest);
        ImageRequest.Listener listener = imageRequest.getListener();
        if (listener != null) {
            listener.onCancel(imageRequest);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
