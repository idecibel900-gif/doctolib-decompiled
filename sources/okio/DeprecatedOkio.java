package okio;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: okio.-DeprecatedOkio, reason: invalid class name */
/* JADX INFO: loaded from: classes5.dex */
public final class DeprecatedOkio {
    public static final DeprecatedOkio INSTANCE = new DeprecatedOkio();

    private DeprecatedOkio() {
    }

    public final BufferedSink buffer(Sink sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        return Okio.buffer(sink);
    }

    public final BufferedSource buffer(Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return Okio.buffer(source);
    }

    public final Sink sink(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return Okio__JvmOkioKt.sink$default(file, false, 1, null);
    }

    public final Sink sink(OutputStream outputStream) {
        Intrinsics.checkNotNullParameter(outputStream, "outputStream");
        return Okio.sink(outputStream);
    }

    public final Source source(InputStream inputStream) {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        return Okio.source(inputStream);
    }
}
