package kotlinx.serialization.json.internal;

/* JADX INFO: loaded from: classes5.dex */
public interface JsonWriter {
    void write(String str);

    void writeChar(char c);

    void writeLong(long j);

    void writeQuoted(String str);
}
