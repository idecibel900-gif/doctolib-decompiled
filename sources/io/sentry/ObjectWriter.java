package io.sentry;

/* JADX INFO: loaded from: classes5.dex */
public interface ObjectWriter {
    ObjectWriter beginArray();

    ObjectWriter beginObject();

    ObjectWriter endArray();

    ObjectWriter endObject();

    String getIndent();

    ObjectWriter jsonValue(String str);

    ObjectWriter name(String str);

    ObjectWriter nullValue();

    void setIndent(String str);

    void setLenient(boolean z);

    ObjectWriter value(double d);

    ObjectWriter value(long j);

    ObjectWriter value(ILogger iLogger, Object obj);

    ObjectWriter value(Boolean bool);

    ObjectWriter value(Number number);

    ObjectWriter value(String str);

    ObjectWriter value(boolean z);
}
