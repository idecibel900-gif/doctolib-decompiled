package io.sentry;

import io.sentry.vendor.gson.stream.JsonToken;
import java.io.Closeable;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes5.dex */
public interface ObjectReader extends Closeable {
    void beginArray();

    void beginObject();

    void endArray();

    void endObject();

    boolean hasNext();

    Boolean nextBooleanOrNull();

    Date nextDateOrNull(ILogger iLogger);

    double nextDouble();

    Double nextDoubleOrNull();

    float nextFloat();

    Float nextFloatOrNull();

    int nextInt();

    Integer nextIntegerOrNull();

    List nextListOrNull(ILogger iLogger, JsonDeserializer jsonDeserializer);

    long nextLong();

    Long nextLongOrNull();

    Map nextMapOrNull(ILogger iLogger, JsonDeserializer jsonDeserializer);

    String nextName();

    Object nextObjectOrNull();

    Object nextOrNull(ILogger iLogger, JsonDeserializer jsonDeserializer);

    String nextString();

    String nextStringOrNull();

    TimeZone nextTimeZoneOrNull(ILogger iLogger);

    void nextUnknown(ILogger iLogger, Map map, String str);

    JsonToken peek();

    void setLenient(boolean z);

    void skipValue();

    static Date dateOrNull(String str, ILogger iLogger) {
        if (str == null) {
            return null;
        }
        try {
            try {
                return DateUtils.getDateTime(str);
            } catch (Exception e) {
                iLogger.log(SentryLevel.ERROR, "Error when deserializing millis timestamp format.", e);
                return null;
            }
        } catch (Exception unused) {
            return DateUtils.getDateTimeWithMillisPrecision(str);
        }
    }
}
