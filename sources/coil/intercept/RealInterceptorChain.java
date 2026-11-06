package coil.intercept;

import androidx.recyclerview.widget.LinearLayoutManager;
import coil.EventListener;
import coil.request.ImageRequest;
import coil.request.ImageResult;
import coil.request.NullRequestData;
import coil.size.Size;
import java.util.List;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes3.dex */
public final class RealInterceptorChain implements Interceptor.Chain {
    private final EventListener eventListener;
    private final int index;
    private final ImageRequest initialRequest;
    private final List interceptors;
    private final boolean isPlaceholderCached;
    private final ImageRequest request;
    private final Size size;

    /* JADX INFO: renamed from: coil.intercept.RealInterceptorChain$proceed$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return RealInterceptorChain.this.proceed(null, this);
        }
    }

    public RealInterceptorChain(ImageRequest imageRequest, List list, int i, ImageRequest imageRequest2, Size size, EventListener eventListener, boolean z) {
        this.initialRequest = imageRequest;
        this.interceptors = list;
        this.index = i;
        this.request = imageRequest2;
        this.size = size;
        this.eventListener = eventListener;
        this.isPlaceholderCached = z;
    }

    @Override // coil.intercept.Interceptor.Chain
    public ImageRequest getRequest() {
        return this.request;
    }

    @Override // coil.intercept.Interceptor.Chain
    public Size getSize() {
        return this.size;
    }

    public final EventListener getEventListener() {
        return this.eventListener;
    }

    public final boolean isPlaceholderCached() {
        return this.isPlaceholderCached;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public Object proceed(ImageRequest imageRequest, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        Interceptor interceptor;
        RealInterceptorChain realInterceptorChain;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                anonymousClass1.label = i - LinearLayoutManager.INVALID_OFFSET;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            int i3 = this.index;
            if (i3 > 0) {
                checkRequest(imageRequest, (Interceptor) this.interceptors.get(i3 - 1));
            }
            Interceptor interceptor2 = (Interceptor) this.interceptors.get(this.index);
            RealInterceptorChain realInterceptorChainCopy$default = copy$default(this, this.index + 1, imageRequest, null, 4, null);
            anonymousClass1.L$0 = this;
            anonymousClass1.L$1 = interceptor2;
            anonymousClass1.label = 1;
            Object objIntercept = interceptor2.intercept(realInterceptorChainCopy$default, anonymousClass1);
            if (objIntercept == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = objIntercept;
            interceptor = interceptor2;
            realInterceptorChain = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            interceptor = (Interceptor) anonymousClass1.L$1;
            realInterceptorChain = (RealInterceptorChain) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        ImageResult imageResult = (ImageResult) obj;
        realInterceptorChain.checkRequest(imageResult.getRequest(), interceptor);
        return imageResult;
    }

    private final void checkRequest(ImageRequest imageRequest, Interceptor interceptor) {
        if (imageRequest.getContext() != this.initialRequest.getContext()) {
            throw new IllegalStateException(("Interceptor '" + interceptor + "' cannot modify the request's context.").toString());
        }
        if (imageRequest.getData() == NullRequestData.INSTANCE) {
            throw new IllegalStateException(("Interceptor '" + interceptor + "' cannot set the request's data to null.").toString());
        }
        if (imageRequest.getTarget() != this.initialRequest.getTarget()) {
            throw new IllegalStateException(("Interceptor '" + interceptor + "' cannot modify the request's target.").toString());
        }
        if (imageRequest.getLifecycle() != this.initialRequest.getLifecycle()) {
            throw new IllegalStateException(("Interceptor '" + interceptor + "' cannot modify the request's lifecycle.").toString());
        }
        if (imageRequest.getSizeResolver() == this.initialRequest.getSizeResolver()) {
            return;
        }
        throw new IllegalStateException(("Interceptor '" + interceptor + "' cannot modify the request's size resolver. Use `Interceptor.Chain.withSize` instead.").toString());
    }

    static /* synthetic */ RealInterceptorChain copy$default(RealInterceptorChain realInterceptorChain, int i, ImageRequest imageRequest, Size size, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = realInterceptorChain.index;
        }
        if ((i2 & 2) != 0) {
            imageRequest = realInterceptorChain.getRequest();
        }
        if ((i2 & 4) != 0) {
            size = realInterceptorChain.getSize();
        }
        return realInterceptorChain.copy(i, imageRequest, size);
    }

    private final RealInterceptorChain copy(int i, ImageRequest imageRequest, Size size) {
        return new RealInterceptorChain(this.initialRequest, this.interceptors, i, imageRequest, size, this.eventListener, this.isPlaceholderCached);
    }
}
