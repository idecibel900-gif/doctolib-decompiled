package androidx.sqlite;

/* JADX INFO: loaded from: classes.dex */
public interface SQLiteStatement extends AutoCloseable {
    void bindBlob(int i, byte[] bArr);

    void bindLong(int i, long j);

    void bindNull(int i);

    void bindText(int i, String str);

    void clearBindings();

    @Override // java.lang.AutoCloseable
    void close();

    byte[] getBlob(int i);

    int getColumnCount();

    String getColumnName(int i);

    long getLong(int i);

    String getText(int i);

    boolean isNull(int i);

    void reset();

    boolean step();

    default boolean getBoolean(int i) {
        return getLong(i) != 0;
    }
}
