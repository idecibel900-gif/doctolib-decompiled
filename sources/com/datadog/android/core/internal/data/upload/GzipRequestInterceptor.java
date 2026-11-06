package com.datadog.android.core.internal.data.upload;

import com.datadog.android.api.InternalLogger;
import java.io.IOException;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;

/* JADX INFO: loaded from: classes3.dex */
public final class GzipRequestInterceptor implements Interceptor {
    public static final Companion Companion = new Companion(null);
    private final InternalLogger internalLogger;

    public GzipRequestInterceptor(InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.internalLogger = internalLogger;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        RequestBody requestBodyBody = request.body();
        if (requestBodyBody == null || request.header("Content-Encoding") != null || (requestBodyBody instanceof MultipartBody)) {
            return chain.proceed(request);
        }
        try {
            request = request.newBuilder().header("Content-Encoding", "gzip").method(request.method(), gzip(requestBodyBody)).build();
        } catch (Exception e) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0() { // from class: com.datadog.android.core.internal.data.upload.GzipRequestInterceptor$intercept$compressedRequest$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Unable to gzip request body";
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
        }
        return chain.proceed(request);
    }

    private final RequestBody gzip(final RequestBody requestBody) {
        return new RequestBody() { // from class: com.datadog.android.core.internal.data.upload.GzipRequestInterceptor.gzip.1
            @Override // okhttp3.RequestBody
            public long contentLength() {
                return -1L;
            }

            @Override // okhttp3.RequestBody
            /* JADX INFO: renamed from: contentType */
            public MediaType getContentType() {
                return requestBody.getContentType();
            }

            @Override // okhttp3.RequestBody
            public void writeTo(BufferedSink sink) throws IOException {
                Intrinsics.checkNotNullParameter(sink, "sink");
                BufferedSink bufferedSinkBuffer = Okio.buffer(new GzipSink(sink));
                requestBody.writeTo(bufferedSinkBuffer);
                bufferedSinkBuffer.close();
            }
        };
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
