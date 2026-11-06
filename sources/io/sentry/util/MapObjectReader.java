package io.sentry.util;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.ObjectReader;
import io.sentry.SentryLevel;
import io.sentry.vendor.gson.stream.JsonToken;
import j$.util.DesugarTimeZone;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes5.dex */
public final class MapObjectReader implements ObjectReader {
    private final Deque stack;

    @Override // io.sentry.ObjectReader
    public void setLenient(boolean z) {
    }

    public MapObjectReader(Map map) {
        ArrayDeque arrayDeque = new ArrayDeque();
        this.stack = arrayDeque;
        arrayDeque.addLast(new AbstractMap.SimpleEntry(null, map));
    }

    @Override // io.sentry.ObjectReader
    public void nextUnknown(ILogger iLogger, Map map, String str) {
        int size = this.stack.size();
        try {
            map.put(str, nextObjectOrNull());
        } catch (Exception e) {
            iLogger.log(SentryLevel.ERROR, e, "Error deserializing unknown key: %s", str);
            recoverValue(size);
        }
    }

    @Override // io.sentry.ObjectReader
    public List nextListOrNull(ILogger iLogger, JsonDeserializer jsonDeserializer) throws IOException {
        if (peek() == JsonToken.NULL) {
            nextNull();
            return null;
        }
        try {
            beginArray();
            ArrayList arrayList = new ArrayList();
            while (peek() != JsonToken.END_ARRAY) {
                int size = this.stack.size();
                try {
                    arrayList.add(jsonDeserializer.deserialize(this, iLogger));
                } catch (Exception e) {
                    iLogger.log(SentryLevel.WARNING, "Failed to deserialize object in list.", e);
                    recoverValue(size);
                }
            }
            endArray();
            return arrayList;
        } catch (Exception e2) {
            throw new IOException(e2);
        }
    }

    @Override // io.sentry.ObjectReader
    public Map nextMapOrNull(ILogger iLogger, JsonDeserializer jsonDeserializer) throws IOException {
        if (peek() == JsonToken.NULL) {
            nextNull();
            return null;
        }
        try {
            beginObject();
            HashMap map = new HashMap();
            if (peek() == JsonToken.NAME) {
                while (true) {
                    String strNextName = nextName();
                    int size = this.stack.size();
                    try {
                        map.put(strNextName, jsonDeserializer.deserialize(this, iLogger));
                    } catch (Exception e) {
                        iLogger.log(SentryLevel.WARNING, "Failed to deserialize object in map.", e);
                        recoverValue(size);
                    }
                    if (peek() != JsonToken.BEGIN_OBJECT && peek() != JsonToken.NAME) {
                        break;
                    }
                }
            }
            endObject();
            return map;
        } catch (Exception e2) {
            throw new IOException(e2);
        }
    }

    @Override // io.sentry.ObjectReader
    public Object nextOrNull(ILogger iLogger, JsonDeserializer jsonDeserializer) {
        return nextValueOrNull(iLogger, jsonDeserializer);
    }

    @Override // io.sentry.ObjectReader
    public Date nextDateOrNull(ILogger iLogger) {
        return ObjectReader.dateOrNull(nextStringOrNull(), iLogger);
    }

    @Override // io.sentry.ObjectReader
    public TimeZone nextTimeZoneOrNull(ILogger iLogger) {
        String strNextStringOrNull = nextStringOrNull();
        if (strNextStringOrNull != null) {
            return DesugarTimeZone.getTimeZone(strNextStringOrNull);
        }
        return null;
    }

    @Override // io.sentry.ObjectReader
    public Object nextObjectOrNull() {
        return nextValueOrNull();
    }

    @Override // io.sentry.ObjectReader
    public JsonToken peek() {
        if (this.stack.isEmpty()) {
            return JsonToken.END_DOCUMENT;
        }
        Map.Entry entry = (Map.Entry) this.stack.peekLast();
        if (entry == null) {
            return JsonToken.END_DOCUMENT;
        }
        if (entry.getKey() != null) {
            return JsonToken.NAME;
        }
        Object value = entry.getValue();
        if (value instanceof Map) {
            return JsonToken.BEGIN_OBJECT;
        }
        if (value instanceof List) {
            return JsonToken.BEGIN_ARRAY;
        }
        if (value instanceof String) {
            return JsonToken.STRING;
        }
        if (value instanceof Number) {
            return JsonToken.NUMBER;
        }
        if (value instanceof Boolean) {
            return JsonToken.BOOLEAN;
        }
        if (value instanceof JsonToken) {
            return (JsonToken) value;
        }
        return JsonToken.END_DOCUMENT;
    }

    @Override // io.sentry.ObjectReader
    public String nextName() throws IOException {
        Map.Entry entry = (Map.Entry) this.stack.peekLast();
        if (entry != null && entry.getKey() != null) {
            return (String) entry.getKey();
        }
        throw new IOException("Expected a name but was " + peek());
    }

    @Override // io.sentry.ObjectReader
    public void beginObject() throws IOException {
        Map.Entry entry = (Map.Entry) this.stack.peekLast();
        if (entry == null) {
            throw new IOException("No more entries");
        }
        Object value = entry.getValue();
        if (value instanceof Map) {
            this.stack.removeLast();
            this.stack.addLast(new AbstractMap.SimpleEntry(null, JsonToken.END_OBJECT));
            Iterator it = ((Map) value).entrySet().iterator();
            while (it.hasNext()) {
                this.stack.addLast((Map.Entry) it.next());
            }
            return;
        }
        throw new IOException("Current token is not an object");
    }

    @Override // io.sentry.ObjectReader
    public void endObject() {
        if (this.stack.size() > 1) {
            this.stack.removeLast();
        }
    }

    @Override // io.sentry.ObjectReader
    public void beginArray() throws IOException {
        Map.Entry entry = (Map.Entry) this.stack.peekLast();
        if (entry == null) {
            throw new IOException("No more entries");
        }
        Object value = entry.getValue();
        if (value instanceof List) {
            this.stack.removeLast();
            this.stack.addLast(new AbstractMap.SimpleEntry(null, JsonToken.END_ARRAY));
            List list = (List) value;
            for (int size = list.size() - 1; size >= 0; size--) {
                this.stack.addLast(new AbstractMap.SimpleEntry(null, list.get(size)));
            }
            return;
        }
        throw new IOException("Current token is not an object");
    }

    @Override // io.sentry.ObjectReader
    public void endArray() {
        if (this.stack.size() > 1) {
            this.stack.removeLast();
        }
    }

    @Override // io.sentry.ObjectReader
    public boolean hasNext() {
        return !this.stack.isEmpty();
    }

    @Override // io.sentry.ObjectReader
    public int nextInt() throws IOException {
        Object objNextValueOrNull = nextValueOrNull();
        if (objNextValueOrNull instanceof Number) {
            return ((Number) objNextValueOrNull).intValue();
        }
        throw new IOException("Expected int");
    }

    @Override // io.sentry.ObjectReader
    public Integer nextIntegerOrNull() throws IOException {
        Object objNextValueOrNull = nextValueOrNull();
        if (objNextValueOrNull instanceof Number) {
            return Integer.valueOf(((Number) objNextValueOrNull).intValue());
        }
        return null;
    }

    @Override // io.sentry.ObjectReader
    public long nextLong() throws IOException {
        Object objNextValueOrNull = nextValueOrNull();
        if (objNextValueOrNull instanceof Number) {
            return ((Number) objNextValueOrNull).longValue();
        }
        throw new IOException("Expected long");
    }

    @Override // io.sentry.ObjectReader
    public Long nextLongOrNull() throws IOException {
        Object objNextValueOrNull = nextValueOrNull();
        if (objNextValueOrNull instanceof Number) {
            return Long.valueOf(((Number) objNextValueOrNull).longValue());
        }
        return null;
    }

    @Override // io.sentry.ObjectReader
    public String nextString() throws IOException {
        String str = (String) nextValueOrNull();
        if (str != null) {
            return str;
        }
        throw new IOException("Expected string");
    }

    @Override // io.sentry.ObjectReader
    public String nextStringOrNull() {
        return (String) nextValueOrNull();
    }

    @Override // io.sentry.ObjectReader
    public Boolean nextBooleanOrNull() {
        return (Boolean) nextValueOrNull();
    }

    @Override // io.sentry.ObjectReader
    public double nextDouble() throws IOException {
        Object objNextValueOrNull = nextValueOrNull();
        if (objNextValueOrNull instanceof Number) {
            return ((Number) objNextValueOrNull).doubleValue();
        }
        throw new IOException("Expected double");
    }

    @Override // io.sentry.ObjectReader
    public Double nextDoubleOrNull() throws IOException {
        Object objNextValueOrNull = nextValueOrNull();
        if (objNextValueOrNull instanceof Number) {
            return Double.valueOf(((Number) objNextValueOrNull).doubleValue());
        }
        return null;
    }

    @Override // io.sentry.ObjectReader
    public Float nextFloatOrNull() throws IOException {
        Object objNextValueOrNull = nextValueOrNull();
        if (objNextValueOrNull instanceof Number) {
            return Float.valueOf(((Number) objNextValueOrNull).floatValue());
        }
        return null;
    }

    @Override // io.sentry.ObjectReader
    public float nextFloat() throws IOException {
        Object objNextValueOrNull = nextValueOrNull();
        if (objNextValueOrNull instanceof Number) {
            return ((Number) objNextValueOrNull).floatValue();
        }
        throw new IOException("Expected float");
    }

    public void nextNull() throws IOException {
        if (nextValueOrNull() == null) {
            return;
        }
        throw new IOException("Expected null but was " + peek());
    }

    @Override // io.sentry.ObjectReader
    public void skipValue() {
        if (this.stack.isEmpty()) {
            return;
        }
        this.stack.removeLast();
    }

    private void recoverValue(int i) {
        while (!this.stack.isEmpty() && this.stack.size() >= i) {
            this.stack.removeLast();
        }
    }

    private Object nextValueOrNull() throws IOException {
        try {
            return nextValueOrNull(null, null);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    private Object nextValueOrNull(ILogger iLogger, JsonDeserializer jsonDeserializer) {
        Map.Entry entry = (Map.Entry) this.stack.peekLast();
        if (entry == null) {
            return null;
        }
        Object value = entry.getValue();
        if (jsonDeserializer != null && iLogger != null) {
            return jsonDeserializer.deserialize(this, iLogger);
        }
        this.stack.removeLast();
        return value;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.stack.clear();
    }
}
