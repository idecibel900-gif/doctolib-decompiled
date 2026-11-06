package expo.modules.updates.loader;

import java.io.IOException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

/* JADX INFO: loaded from: classes5.dex */
final class FileDownloadProgressResponseBody extends ResponseBody {
    private final Lazy bufferedSource$delegate;
    private final FileDownloadProgressListener progressListener;
    private final ResponseBody responseBody;

    public FileDownloadProgressResponseBody(ResponseBody responseBody, FileDownloadProgressListener progressListener) {
        Intrinsics.checkNotNullParameter(responseBody, "responseBody");
        Intrinsics.checkNotNullParameter(progressListener, "progressListener");
        this.responseBody = responseBody;
        this.progressListener = progressListener;
        this.bufferedSource$delegate = LazyKt.lazy(new Function0() { // from class: expo.modules.updates.loader.FileDownloadProgressResponseBody$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FileDownloadProgressResponseBody.bufferedSource_delegate$lambda$0(this.f$0);
            }
        });
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

    private final BufferedSource getBufferedSource() {
        return (BufferedSource) this.bufferedSource$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BufferedSource bufferedSource_delegate$lambda$0(FileDownloadProgressResponseBody fileDownloadProgressResponseBody) {
        return Okio.buffer(fileDownloadProgressResponseBody.source(fileDownloadProgressResponseBody.responseBody.getBodySource()));
    }

    @Override // okhttp3.ResponseBody
    /* JADX INFO: renamed from: source */
    public BufferedSource getBodySource() {
        return getBufferedSource();
    }

    private final Source source(Source source) {
        return new ForwardingSource(source) { // from class: expo.modules.updates.loader.FileDownloadProgressResponseBody.source.1
            private long totalBytesRead;

            @Override // okio.ForwardingSource, okio.Source
            public long read(Buffer sink, long j) throws IOException {
                Intrinsics.checkNotNullParameter(sink, "sink");
                long j2 = super.read(sink, j);
                this.totalBytesRead += j2 != -1 ? j2 : 0L;
                this.progressListener.update(this.totalBytesRead, this.responseBody.getContentLength());
                return j2;
            }
        };
    }
}
