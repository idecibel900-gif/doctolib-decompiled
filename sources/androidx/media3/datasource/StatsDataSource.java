package androidx.media3.datasource;

import android.net.Uri;
import androidx.media3.common.util.Assertions;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class StatsDataSource implements DataSource {
    private long bytesRead;
    private final DataSource dataSource;
    private Uri lastOpenedUri = Uri.EMPTY;
    private Map lastResponseHeaders = Collections.EMPTY_MAP;

    public StatsDataSource(DataSource dataSource) {
        this.dataSource = (DataSource) Assertions.checkNotNull(dataSource);
    }

    public void resetBytesRead() {
        this.bytesRead = 0L;
    }

    public long getBytesRead() {
        return this.bytesRead;
    }

    public Uri getLastOpenedUri() {
        return this.lastOpenedUri;
    }

    public Map getLastResponseHeaders() {
        return this.lastResponseHeaders;
    }

    @Override // androidx.media3.datasource.DataSource
    public void addTransferListener(TransferListener transferListener) {
        Assertions.checkNotNull(transferListener);
        this.dataSource.addTransferListener(transferListener);
    }

    @Override // androidx.media3.datasource.DataSource
    public long open(DataSpec dataSpec) {
        this.lastOpenedUri = dataSpec.uri;
        this.lastResponseHeaders = Collections.EMPTY_MAP;
        try {
            return this.dataSource.open(dataSpec);
        } finally {
            Uri uri = getUri();
            if (uri != null) {
                this.lastOpenedUri = uri;
            }
            this.lastResponseHeaders = getResponseHeaders();
        }
    }

    @Override // androidx.media3.common.DataReader
    public int read(byte[] bArr, int i, int i2) {
        int i3 = this.dataSource.read(bArr, i, i2);
        if (i3 != -1) {
            this.bytesRead += (long) i3;
        }
        return i3;
    }

    @Override // androidx.media3.datasource.DataSource
    public Uri getUri() {
        return this.dataSource.getUri();
    }

    @Override // androidx.media3.datasource.DataSource
    public Map getResponseHeaders() {
        return this.dataSource.getResponseHeaders();
    }

    @Override // androidx.media3.datasource.DataSource
    public void close() {
        this.dataSource.close();
    }
}
