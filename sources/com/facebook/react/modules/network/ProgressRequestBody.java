package com.facebook.react.modules.network;

import java.io.FilterOutputStream;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.DeprecatedUpgrade;
import okio.Sink;

/* JADX INFO: loaded from: classes3.dex */
public final class ProgressRequestBody extends RequestBody {
    private long contentLength;
    private final ProgressListener progressListener;
    private final RequestBody requestBody;

    public ProgressRequestBody(RequestBody requestBody, ProgressListener progressListener) {
        Intrinsics.checkNotNullParameter(requestBody, "requestBody");
        Intrinsics.checkNotNullParameter(progressListener, "progressListener");
        this.requestBody = requestBody;
        this.progressListener = progressListener;
    }

    @Override // okhttp3.RequestBody
    /* JADX INFO: renamed from: contentType */
    public MediaType get$contentType() {
        return this.requestBody.get$contentType();
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        if (this.contentLength == 0) {
            this.contentLength = this.requestBody.contentLength();
        }
        return this.contentLength;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink sink) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        BufferedSink bufferedSinkBuffer = DeprecatedUpgrade.getOkio().buffer(outputStreamSink(sink));
        contentLength();
        this.requestBody.writeTo(bufferedSinkBuffer);
        bufferedSinkBuffer.flush();
    }

    private final Sink outputStreamSink(BufferedSink bufferedSink) {
        return DeprecatedUpgrade.getOkio().sink(new FilterOutputStream(bufferedSink.outputStream()) { // from class: com.facebook.react.modules.network.ProgressRequestBody.outputStreamSink.1
            private long count;

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] data, int i, int i2) throws IOException {
                Intrinsics.checkNotNullParameter(data, "data");
                super.write(data, i, i2);
                this.count += (long) i2;
                sendProgressUpdate();
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) throws IOException {
                super.write(i);
                this.count++;
                sendProgressUpdate();
            }

            public final void sendProgressUpdate() {
                long j = this.count;
                long jContentLength = ProgressRequestBody.this.contentLength();
                ProgressRequestBody.this.progressListener.onProgress(j, jContentLength, j == jContentLength);
            }
        });
    }

    public final String getBodyPreview() {
        return "[Preview unavailable]";
    }
}
