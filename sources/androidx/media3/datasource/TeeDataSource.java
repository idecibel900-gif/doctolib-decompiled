package androidx.media3.datasource;

import android.net.Uri;
import androidx.media3.common.util.Assertions;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class TeeDataSource implements DataSource {
    private long bytesRemaining;
    private final DataSink dataSink;
    private boolean dataSinkNeedsClosing;
    private final DataSource upstream;

    public TeeDataSource(DataSource dataSource, DataSink dataSink) {
        this.upstream = (DataSource) Assertions.checkNotNull(dataSource);
        this.dataSink = (DataSink) Assertions.checkNotNull(dataSink);
    }

    @Override // androidx.media3.datasource.DataSource
    public void addTransferListener(TransferListener transferListener) {
        Assertions.checkNotNull(transferListener);
        this.upstream.addTransferListener(transferListener);
    }

    @Override // androidx.media3.datasource.DataSource
    public long open(DataSpec dataSpec) {
        long jOpen = this.upstream.open(dataSpec);
        this.bytesRemaining = jOpen;
        if (jOpen == 0) {
            return 0L;
        }
        if (dataSpec.length == -1 && jOpen != -1) {
            dataSpec = dataSpec.subrange(0L, jOpen);
        }
        this.dataSinkNeedsClosing = true;
        this.dataSink.open(dataSpec);
        return this.bytesRemaining;
    }

    @Override // androidx.media3.common.DataReader
    public int read(byte[] bArr, int i, int i2) {
        if (this.bytesRemaining == 0) {
            return -1;
        }
        int i3 = this.upstream.read(bArr, i, i2);
        if (i3 > 0) {
            this.dataSink.write(bArr, i, i3);
            long j = this.bytesRemaining;
            if (j != -1) {
                this.bytesRemaining = j - ((long) i3);
            }
        }
        return i3;
    }

    @Override // androidx.media3.datasource.DataSource
    public Uri getUri() {
        return this.upstream.getUri();
    }

    @Override // androidx.media3.datasource.DataSource
    public Map getResponseHeaders() {
        return this.upstream.getResponseHeaders();
    }

    @Override // androidx.media3.datasource.DataSource
    public void close() {
        try {
            this.upstream.close();
        } finally {
            if (this.dataSinkNeedsClosing) {
                this.dataSinkNeedsClosing = false;
                this.dataSink.close();
            }
        }
    }
}
