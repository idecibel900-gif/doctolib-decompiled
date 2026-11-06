package androidx.media3.decoder;

/* JADX INFO: loaded from: classes.dex */
public interface Decoder {
    Object dequeueInputBuffer();

    Object dequeueOutputBuffer();

    void flush();

    void queueInputBuffer(Object obj);

    void release();

    void setOutputStartTimeUs(long j);
}
