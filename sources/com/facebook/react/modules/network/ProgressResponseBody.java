package com.facebook.react.modules.network;

import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.DeprecatedUpgrade;
import okio.ForwardingSource;
import okio.Source;

/* JADX INFO: loaded from: classes3.dex */
public final class ProgressResponseBody extends ResponseBody {
    private BufferedSource bufferedSource;
    private final ProgressListener progressListener;
    private final ResponseBody responseBody;
    private long totalBytesRead;

    public ProgressResponseBody(ResponseBody responseBody, ProgressListener progressListener) {
        Intrinsics.checkNotNullParameter(responseBody, "responseBody");
        Intrinsics.checkNotNullParameter(progressListener, "progressListener");
        this.responseBody = responseBody;
        this.progressListener = progressListener;
    }

    @Override // okhttp3.ResponseBody
    /* JADX INFO: renamed from: contentType */
    public MediaType get$contentType() {
        return this.responseBody.get$contentType();
    }

    @Override // okhttp3.ResponseBody
    /* JADX INFO: renamed from: contentLength */
    public long getContentLength() {
        return this.responseBody.getContentLength();
    }

    public final long totalBytesRead() {
        return this.totalBytesRead;
    }

    @Override // okhttp3.ResponseBody
    /* JADX INFO: renamed from: source */
    public BufferedSource getBodySource() {
        if (this.bufferedSource == null) {
            this.bufferedSource = DeprecatedUpgrade.getOkio().buffer(source(this.responseBody.getBodySource()));
        }
        BufferedSource bufferedSource = this.bufferedSource;
        if (bufferedSource != null) {
            return bufferedSource;
        }
        Intrinsics.throwUninitializedPropertyAccessException("bufferedSource");
        return null;
    }

    private final Source source(Source source) {
        return new ForwardingSource(source) { // from class: com.facebook.react.modules.network.ProgressResponseBody.source.1
            @Override // okio.ForwardingSource, okio.Source
            public long read(Buffer sink, long j) throws IOException {
                Intrinsics.checkNotNullParameter(sink, "sink");
                long j2 = super.read(sink, j);
                ProgressResponseBody progressResponseBody = this;
                if (j2 != -1) {
                    progressResponseBody.totalBytesRead += j2;
                }
                progressResponseBody.progressListener.onProgress(progressResponseBody.totalBytesRead, progressResponseBody.responseBody.getContentLength(), j2 == -1);
                return j2;
            }
        };
    }
}
