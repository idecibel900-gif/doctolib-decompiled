package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.listener.RequestListener2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class InternalRequestListener extends InternalProducerListener implements RequestListener2 {
    private final RequestListener requestListener;
    private final RequestListener2 requestListener2;

    public InternalRequestListener(RequestListener requestListener, RequestListener2 requestListener2) {
        super(requestListener, requestListener2);
        this.requestListener = requestListener;
        this.requestListener2 = requestListener2;
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener2
    public void onRequestStart(ProducerContext producerContext) {
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        RequestListener requestListener = this.requestListener;
        if (requestListener != null) {
            requestListener.onRequestStart(producerContext.getImageRequest(), producerContext.getCallerContext(), producerContext.getId(), producerContext.isPrefetch());
        }
        RequestListener2 requestListener2 = this.requestListener2;
        if (requestListener2 != null) {
            requestListener2.onRequestStart(producerContext);
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener2
    public void onRequestSuccess(ProducerContext producerContext) {
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        RequestListener requestListener = this.requestListener;
        if (requestListener != null) {
            requestListener.onRequestSuccess(producerContext.getImageRequest(), producerContext.getId(), producerContext.isPrefetch());
        }
        RequestListener2 requestListener2 = this.requestListener2;
        if (requestListener2 != null) {
            requestListener2.onRequestSuccess(producerContext);
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener2
    public void onRequestFailure(ProducerContext producerContext, Throwable th) {
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        RequestListener requestListener = this.requestListener;
        if (requestListener != null) {
            requestListener.onRequestFailure(producerContext.getImageRequest(), producerContext.getId(), th, producerContext.isPrefetch());
        }
        RequestListener2 requestListener2 = this.requestListener2;
        if (requestListener2 != null) {
            requestListener2.onRequestFailure(producerContext, th);
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener2
    public void onRequestCancellation(ProducerContext producerContext) {
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        RequestListener requestListener = this.requestListener;
        if (requestListener != null) {
            requestListener.onRequestCancellation(producerContext.getId());
        }
        RequestListener2 requestListener2 = this.requestListener2;
        if (requestListener2 != null) {
            requestListener2.onRequestCancellation(producerContext);
        }
    }
}
