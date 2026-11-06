package androidx.media3.datasource;

/* JADX INFO: loaded from: classes.dex */
public interface DataSink {

    public interface Factory {
        DataSink createDataSink();
    }

    void close();

    void open(DataSpec dataSpec);

    void write(byte[] bArr, int i, int i2);
}
