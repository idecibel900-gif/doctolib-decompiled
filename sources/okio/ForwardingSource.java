package okio;

import java.io.IOException;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ForwardingSource implements Source {
    private final Source delegate;

    public ForwardingSource(Source delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    public final Source delegate() {
        return this.delegate;
    }

    @Override // okio.Source
    public long read(Buffer sink, long j) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        return this.delegate.read(sink, j);
    }

    @Override // okio.Source
    public Timeout timeout() {
        return this.delegate.timeout();
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }

    @Deprecated
    /* JADX INFO: renamed from: -deprecated_delegate, reason: not valid java name */
    public final Source m5655deprecated_delegate() {
        return this.delegate;
    }
}
