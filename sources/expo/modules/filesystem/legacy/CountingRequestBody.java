package expo.modules.filesystem.legacy;

import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.Okio;

/* JADX INFO: loaded from: classes4.dex */
public final class CountingRequestBody extends RequestBody {
    private final CountingRequestListener progressListener;
    private final RequestBody requestBody;

    public CountingRequestBody(RequestBody requestBody, CountingRequestListener progressListener) {
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
        return this.requestBody.contentLength();
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink sink) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        BufferedSink bufferedSinkBuffer = Okio.buffer(new CountingSink(sink, this, this.progressListener));
        this.requestBody.writeTo(bufferedSinkBuffer);
        bufferedSinkBuffer.flush();
    }
}
