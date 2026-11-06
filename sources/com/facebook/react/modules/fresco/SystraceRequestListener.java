package com.facebook.react.modules.fresco;

import android.util.Pair;
import com.facebook.imagepipeline.listener.BaseRequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.systrace.Systrace;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class SystraceRequestListener extends BaseRequestListener {
    private int currentId;
    private final Map producerId = new LinkedHashMap();
    private final Map requestsId = new LinkedHashMap();

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.producers.ProducerListener
    public boolean requiresExtraMap(String requestId) {
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        return false;
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.producers.ProducerListener
    public void onProducerStart(String requestId, String producerName) {
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        Intrinsics.checkNotNullParameter(producerName, "producerName");
        if (Systrace.isTracing(0L)) {
            Pair pairCreate = Pair.create(Integer.valueOf(this.currentId), "FRESCO_PRODUCER_" + StringsKt.replace$default(producerName, ':', '_', false, 4, (Object) null));
            Object second = pairCreate.second;
            Intrinsics.checkNotNullExpressionValue(second, "second");
            Systrace.beginAsyncSection(0L, (String) second, this.currentId);
            this.producerId.put(requestId, pairCreate);
            this.currentId++;
        }
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.producers.ProducerListener
    public void onProducerFinishWithSuccess(String requestId, String producerName, Map map) {
        Pair pair;
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        Intrinsics.checkNotNullParameter(producerName, "producerName");
        if (Systrace.isTracing(0L) && (pair = (Pair) this.producerId.get(requestId)) != null) {
            Object second = pair.second;
            Intrinsics.checkNotNullExpressionValue(second, "second");
            Object first = pair.first;
            Intrinsics.checkNotNullExpressionValue(first, "first");
            Systrace.endAsyncSection(0L, (String) second, ((Number) first).intValue());
            this.producerId.remove(requestId);
        }
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.producers.ProducerListener
    public void onProducerFinishWithFailure(String requestId, String producerName, Throwable t, Map map) {
        Pair pair;
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        Intrinsics.checkNotNullParameter(producerName, "producerName");
        Intrinsics.checkNotNullParameter(t, "t");
        if (Systrace.isTracing(0L) && (pair = (Pair) this.producerId.get(requestId)) != null) {
            Object second = pair.second;
            Intrinsics.checkNotNullExpressionValue(second, "second");
            Object first = pair.first;
            Intrinsics.checkNotNullExpressionValue(first, "first");
            Systrace.endAsyncSection(0L, (String) second, ((Number) first).intValue());
            this.producerId.remove(requestId);
        }
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.producers.ProducerListener
    public void onProducerFinishWithCancellation(String requestId, String producerName, Map map) {
        Pair pair;
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        Intrinsics.checkNotNullParameter(producerName, "producerName");
        if (Systrace.isTracing(0L) && (pair = (Pair) this.producerId.get(requestId)) != null) {
            Object second = pair.second;
            Intrinsics.checkNotNullExpressionValue(second, "second");
            Object first = pair.first;
            Intrinsics.checkNotNullExpressionValue(first, "first");
            Systrace.endAsyncSection(0L, (String) second, ((Number) first).intValue());
            this.producerId.remove(requestId);
        }
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.producers.ProducerListener
    public void onProducerEvent(String requestId, String producerName, String eventName) {
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        Intrinsics.checkNotNullParameter(producerName, "producerName");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        if (Systrace.isTracing(0L)) {
            Systrace.traceInstant(0L, "FRESCO_PRODUCER_EVENT_" + StringsKt.replace$default(requestId, ':', '_', false, 4, (Object) null) + "_" + StringsKt.replace$default(producerName, ':', '_', false, 4, (Object) null) + "_" + StringsKt.replace$default(eventName, ':', '_', false, 4, (Object) null), Systrace.EventScope.THREAD);
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public void onRequestStart(ImageRequest request, Object callerContext, String requestId, boolean z) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(callerContext, "callerContext");
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        if (Systrace.isTracing(0L)) {
            StringBuilder sb = new StringBuilder();
            sb.append("FRESCO_REQUEST_");
            String string = request.getSourceUri().toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            sb.append(StringsKt.replace$default(string, ':', '_', false, 4, (Object) null));
            Pair pairCreate = Pair.create(Integer.valueOf(this.currentId), sb.toString());
            Object second = pairCreate.second;
            Intrinsics.checkNotNullExpressionValue(second, "second");
            Systrace.beginAsyncSection(0L, (String) second, this.currentId);
            this.requestsId.put(requestId, pairCreate);
            this.currentId++;
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public void onRequestSuccess(ImageRequest request, String requestId, boolean z) {
        Pair pair;
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        if (Systrace.isTracing(0L) && (pair = (Pair) this.requestsId.get(requestId)) != null) {
            Object second = pair.second;
            Intrinsics.checkNotNullExpressionValue(second, "second");
            Object first = pair.first;
            Intrinsics.checkNotNullExpressionValue(first, "first");
            Systrace.endAsyncSection(0L, (String) second, ((Number) first).intValue());
            this.requestsId.remove(requestId);
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public void onRequestFailure(ImageRequest request, String requestId, Throwable throwable, boolean z) {
        Pair pair;
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        if (Systrace.isTracing(0L) && (pair = (Pair) this.requestsId.get(requestId)) != null) {
            Object second = pair.second;
            Intrinsics.checkNotNullExpressionValue(second, "second");
            Object first = pair.first;
            Intrinsics.checkNotNullExpressionValue(first, "first");
            Systrace.endAsyncSection(0L, (String) second, ((Number) first).intValue());
            this.requestsId.remove(requestId);
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public void onRequestCancellation(String requestId) {
        Pair pair;
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        if (Systrace.isTracing(0L) && (pair = (Pair) this.requestsId.get(requestId)) != null) {
            Object second = pair.second;
            Intrinsics.checkNotNullExpressionValue(second, "second");
            Object first = pair.first;
            Intrinsics.checkNotNullExpressionValue(first, "first");
            Systrace.endAsyncSection(0L, (String) second, ((Number) first).intValue());
            this.requestsId.remove(requestId);
        }
    }
}
