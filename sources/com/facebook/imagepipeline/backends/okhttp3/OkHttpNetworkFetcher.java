package com.facebook.imagepipeline.backends.okhttp3;

import android.net.Uri;
import android.os.Looper;
import android.os.SystemClock;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imagepipeline.producers.BaseNetworkFetcher;
import com.facebook.imagepipeline.producers.BaseProducerContextCallbacks;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.FetchState;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.producers.ProducerContext;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes3.dex */
public class OkHttpNetworkFetcher extends BaseNetworkFetcher {
    private static final Companion Companion = new Companion(null);
    private final CacheControl cacheControl;
    private final Call.Factory callFactory;
    private final Executor cancellationExecutor;

    public /* synthetic */ OkHttpNetworkFetcher(Call.Factory factory, Executor executor, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(factory, executor, (i & 4) != 0 ? true : z);
    }

    public OkHttpNetworkFetcher(Call.Factory callFactory, Executor cancellationExecutor, boolean z) {
        Intrinsics.checkNotNullParameter(callFactory, "callFactory");
        Intrinsics.checkNotNullParameter(cancellationExecutor, "cancellationExecutor");
        this.callFactory = callFactory;
        this.cancellationExecutor = cancellationExecutor;
        this.cacheControl = z ? new CacheControl.Builder().noStore().build() : null;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public OkHttpNetworkFetcher(OkHttpClient okHttpClient) {
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        ExecutorService executorService = okHttpClient.dispatcher().executorService();
        Intrinsics.checkNotNullExpressionValue(executorService, "executorService(...)");
        this(okHttpClient, executorService, false, 4, null);
    }

    public static final class OkHttpNetworkFetchState extends FetchState {
        public long fetchCompleteTime;
        public long responseTime;
        public long submitTime;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OkHttpNetworkFetchState(Consumer consumer, ProducerContext producerContext) {
            super(consumer, producerContext);
            Intrinsics.checkNotNullParameter(consumer, "consumer");
            Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        }
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public OkHttpNetworkFetchState createFetchState(Consumer consumer, ProducerContext context) {
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        Intrinsics.checkNotNullParameter(context, "context");
        return new OkHttpNetworkFetchState(consumer, context);
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public void fetch(OkHttpNetworkFetchState fetchState, NetworkFetcher.Callback callback) {
        Intrinsics.checkNotNullParameter(fetchState, "fetchState");
        Intrinsics.checkNotNullParameter(callback, "callback");
        fetchState.submitTime = SystemClock.elapsedRealtime();
        Uri uri = fetchState.getUri();
        Intrinsics.checkNotNullExpressionValue(uri, "getUri(...)");
        try {
            Request.Builder builder = new Request.Builder().url(uri.toString()).get();
            CacheControl cacheControl = this.cacheControl;
            if (cacheControl != null) {
                builder.cacheControl(cacheControl);
            }
            BytesRange bytesRange = fetchState.getContext().getImageRequest().getBytesRange();
            if (bytesRange != null) {
                builder.addHeader("Range", bytesRange.toHttpRangeHeaderValue());
            }
            Request requestBuild = builder.build();
            Intrinsics.checkNotNullExpressionValue(requestBuild, "build(...)");
            fetchWithRequest(fetchState, callback, requestBuild);
        } catch (Exception e) {
            callback.onFailure(e);
        }
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public void onFetchCompletion(OkHttpNetworkFetchState fetchState, int i) {
        Intrinsics.checkNotNullParameter(fetchState, "fetchState");
        fetchState.fetchCompleteTime = SystemClock.elapsedRealtime();
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public Map getExtraMap(OkHttpNetworkFetchState fetchState, int i) {
        Intrinsics.checkNotNullParameter(fetchState, "fetchState");
        return MapsKt.mapOf(TuplesKt.to("queue_time", String.valueOf(fetchState.responseTime - fetchState.submitTime)), TuplesKt.to("fetch_time", String.valueOf(fetchState.fetchCompleteTime - fetchState.responseTime)), TuplesKt.to("total_time", String.valueOf(fetchState.fetchCompleteTime - fetchState.submitTime)), TuplesKt.to("image_size", String.valueOf(i)));
    }

    protected void fetchWithRequest(final OkHttpNetworkFetchState fetchState, final NetworkFetcher.Callback callback, Request request) {
        Intrinsics.checkNotNullParameter(fetchState, "fetchState");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(request, "request");
        Call callNewCall = this.callFactory.newCall(request);
        fetchState.getContext().addCallbacks(new AnonymousClass1(callNewCall, this));
        callNewCall.enqueue(new Callback() { // from class: com.facebook.imagepipeline.backends.okhttp3.OkHttpNetworkFetcher.fetchWithRequest.2
            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                fetchState.responseTime = SystemClock.elapsedRealtime();
                ResponseBody responseBodyBody = response.body();
                if (responseBodyBody != null) {
                    OkHttpNetworkFetcher okHttpNetworkFetcher = this;
                    NetworkFetcher.Callback callback2 = callback;
                    OkHttpNetworkFetchState okHttpNetworkFetchState = fetchState;
                    try {
                        try {
                            if (!response.isSuccessful()) {
                                okHttpNetworkFetcher.handleException(call, okHttpNetworkFetcher.makeExceptionFromResponse("Unexpected HTTP code " + response, response), callback2);
                            } else {
                                BytesRange bytesRangeFromContentRangeHeader = BytesRange.Companion.fromContentRangeHeader(response.header("Content-Range"));
                                if (bytesRangeFromContentRangeHeader != null && (bytesRangeFromContentRangeHeader.from != 0 || bytesRangeFromContentRangeHeader.to != Integer.MAX_VALUE)) {
                                    okHttpNetworkFetchState.setResponseBytesRange(bytesRangeFromContentRangeHeader);
                                    okHttpNetworkFetchState.setOnNewResultStatusFlags(8);
                                }
                                callback2.onResponse(responseBodyBody.byteStream(), responseBodyBody.getContentLength() < 0 ? 0 : (int) responseBodyBody.getContentLength());
                            }
                        } catch (Exception e) {
                            okHttpNetworkFetcher.handleException(call, e, callback2);
                        }
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(responseBodyBody, null);
                        return;
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.closeFinally(responseBodyBody, th);
                            throw th2;
                        }
                    }
                }
                OkHttpNetworkFetcher okHttpNetworkFetcher2 = this;
                okHttpNetworkFetcher2.handleException(call, okHttpNetworkFetcher2.makeExceptionFromResponse("Response body null: " + response, response), callback);
            }

            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException e) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(e, "e");
                this.handleException(call, e, callback);
            }
        });
    }

    /* JADX INFO: renamed from: com.facebook.imagepipeline.backends.okhttp3.OkHttpNetworkFetcher$fetchWithRequest$1, reason: invalid class name */
    public static final class AnonymousClass1 extends BaseProducerContextCallbacks {
        final /* synthetic */ Call $call;
        final /* synthetic */ OkHttpNetworkFetcher this$0;

        AnonymousClass1(Call call, OkHttpNetworkFetcher okHttpNetworkFetcher) {
            this.$call = call;
            this.this$0 = okHttpNetworkFetcher;
        }

        @Override // com.facebook.imagepipeline.producers.ProducerContextCallbacks
        public void onCancellationRequested() {
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                Executor executor = this.this$0.cancellationExecutor;
                final Call call = this.$call;
                executor.execute(new Runnable() { // from class: com.facebook.imagepipeline.backends.okhttp3.OkHttpNetworkFetcher$fetchWithRequest$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        call.cancel();
                    }
                });
                return;
            }
            this.$call.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IOException makeExceptionFromResponse(String str, Response response) {
        return new IOException(str, OkHttpNetworkFetcherException.Companion.fromResponse(response));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleException(Call call, Exception exc, NetworkFetcher.Callback callback) {
        if (call.getCanceled()) {
            callback.onCancellation();
        } else {
            callback.onFailure(exc);
        }
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
