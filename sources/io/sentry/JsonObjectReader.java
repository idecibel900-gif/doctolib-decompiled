package io.sentry;

import io.sentry.vendor.gson.stream.JsonReader;
import io.sentry.vendor.gson.stream.JsonToken;
import j$.util.DesugarTimeZone;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes5.dex */
public final class JsonObjectReader implements ObjectReader {
    private final JsonReader jsonReader;
    private final Deque recoveryStates = new ArrayDeque();
    private int depth = 0;

    public JsonObjectReader(Reader reader) {
        this.jsonReader = new JsonReader(reader);
    }

    @Override // io.sentry.ObjectReader
    public String nextStringOrNull() {
        if (this.jsonReader.peek() == JsonToken.NULL) {
            nextNull();
            return null;
        }
        return nextString();
    }

    @Override // io.sentry.ObjectReader
    public Double nextDoubleOrNull() {
        if (this.jsonReader.peek() == JsonToken.NULL) {
            nextNull();
            return null;
        }
        return Double.valueOf(nextDouble());
    }

    @Override // io.sentry.ObjectReader
    public Float nextFloatOrNull() {
        if (this.jsonReader.peek() == JsonToken.NULL) {
            nextNull();
            return null;
        }
        return Float.valueOf(nextFloat());
    }

    @Override // io.sentry.ObjectReader
    public float nextFloat() throws IOException {
        double dNextDouble = this.jsonReader.nextDouble();
        markValueConsumed();
        return (float) dNextDouble;
    }

    @Override // io.sentry.ObjectReader
    public Long nextLongOrNull() {
        if (this.jsonReader.peek() == JsonToken.NULL) {
            nextNull();
            return null;
        }
        return Long.valueOf(nextLong());
    }

    @Override // io.sentry.ObjectReader
    public Integer nextIntegerOrNull() {
        if (this.jsonReader.peek() == JsonToken.NULL) {
            nextNull();
            return null;
        }
        return Integer.valueOf(nextInt());
    }

    @Override // io.sentry.ObjectReader
    public Boolean nextBooleanOrNull() {
        if (this.jsonReader.peek() == JsonToken.NULL) {
            nextNull();
            return null;
        }
        return Boolean.valueOf(nextBoolean());
    }

    @Override // io.sentry.ObjectReader
    public void nextUnknown(ILogger iLogger, Map map, String str) {
        RecoveryState recoveryStateBeginRecovery = null;
        try {
            recoveryStateBeginRecovery = beginRecovery(peek());
            map.put(str, nextObjectOrNull());
        } catch (Exception e) {
            iLogger.log(SentryLevel.ERROR, "Stream unrecoverable after unknown key deserialization failure.", e);
        } catch (Exception e2) {
            iLogger.log(SentryLevel.ERROR, e2, "Error deserializing unknown key: %s", str);
            if (recoveryStateBeginRecovery != null) {
                recoverValue(recoveryStateBeginRecovery);
            }
        } finally {
            endRecovery(recoveryStateBeginRecovery);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    @Override // io.sentry.ObjectReader
    public List nextListOrNull(ILogger iLogger, JsonDeserializer jsonDeserializer) throws Throwable {
        Throwable th;
        ILogger iLogger2;
        if (this.jsonReader.peek() == JsonToken.NULL) {
            nextNull();
            return null;
        }
        beginArray();
        ArrayList arrayList = new ArrayList();
        while (this.jsonReader.hasNext()) {
            RecoveryState recoveryStateBeginRecovery = beginRecovery(peek());
            try {
                arrayList.add(jsonDeserializer.deserialize(this, iLogger));
                endRecovery(recoveryStateBeginRecovery);
                iLogger2 = iLogger;
            } catch (Exception e) {
                iLogger2 = iLogger;
                try {
                    if (!recoverAfterValueFailure(iLogger2, e, "Failed to deserialize object in list.", "Stream unrecoverable, aborting list deserialization.", recoveryStateBeginRecovery)) {
                        endRecovery(recoveryStateBeginRecovery);
                        endArray();
                        return arrayList;
                    }
                    endRecovery(recoveryStateBeginRecovery);
                } catch (Throwable th2) {
                    th = th2;
                    endRecovery(recoveryStateBeginRecovery);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                endRecovery(recoveryStateBeginRecovery);
                throw th;
            }
            iLogger = iLogger2;
        }
        endArray();
        return arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    @Override // io.sentry.ObjectReader
    public Map nextMapOrNull(ILogger iLogger, JsonDeserializer jsonDeserializer) throws Throwable {
        Throwable th;
        JsonObjectReader jsonObjectReader;
        ILogger iLogger2;
        if (this.jsonReader.peek() == JsonToken.NULL) {
            nextNull();
            return null;
        }
        beginObject();
        HashMap map = new HashMap();
        if (this.jsonReader.hasNext()) {
            while (true) {
                String strNextName = this.jsonReader.nextName();
                RecoveryState recoveryStateBeginRecovery = beginRecovery(peek());
                try {
                    map.put(strNextName, jsonDeserializer.deserialize(this, iLogger));
                    endRecovery(recoveryStateBeginRecovery);
                    jsonObjectReader = this;
                    iLogger2 = iLogger;
                } catch (Exception e) {
                    jsonObjectReader = this;
                    iLogger2 = iLogger;
                    try {
                        if (!jsonObjectReader.recoverAfterValueFailure(iLogger2, e, "Failed to deserialize object in map.", "Stream unrecoverable, aborting map deserialization.", recoveryStateBeginRecovery)) {
                            endRecovery(recoveryStateBeginRecovery);
                            break;
                        }
                        endRecovery(recoveryStateBeginRecovery);
                        endObject();
                        return map;
                    } catch (Throwable th2) {
                        th = th2;
                        endRecovery(recoveryStateBeginRecovery);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    endRecovery(recoveryStateBeginRecovery);
                    throw th;
                }
                if (jsonObjectReader.jsonReader.peek() != JsonToken.BEGIN_OBJECT && jsonObjectReader.jsonReader.peek() != JsonToken.NAME) {
                    break;
                }
                iLogger = iLogger2;
            }
        }
        endObject();
        return map;
    }

    @Override // io.sentry.ObjectReader
    public Object nextOrNull(ILogger iLogger, JsonDeserializer jsonDeserializer) {
        if (this.jsonReader.peek() == JsonToken.NULL) {
            nextNull();
            return null;
        }
        return jsonDeserializer.deserialize(this, iLogger);
    }

    @Override // io.sentry.ObjectReader
    public Date nextDateOrNull(ILogger iLogger) {
        if (this.jsonReader.peek() == JsonToken.NULL) {
            nextNull();
            return null;
        }
        return ObjectReader.dateOrNull(nextString(), iLogger);
    }

    @Override // io.sentry.ObjectReader
    public TimeZone nextTimeZoneOrNull(ILogger iLogger) {
        if (this.jsonReader.peek() == JsonToken.NULL) {
            nextNull();
            return null;
        }
        try {
            return DesugarTimeZone.getTimeZone(nextString());
        } catch (Exception e) {
            iLogger.log(SentryLevel.ERROR, "Error when deserializing TimeZone", e);
            return null;
        }
    }

    @Override // io.sentry.ObjectReader
    public Object nextObjectOrNull() {
        return new JsonObjectDeserializer().deserialize(this);
    }

    @Override // io.sentry.ObjectReader
    public JsonToken peek() {
        return this.jsonReader.peek();
    }

    @Override // io.sentry.ObjectReader
    public String nextName() {
        return this.jsonReader.nextName();
    }

    @Override // io.sentry.ObjectReader
    public void beginObject() {
        this.jsonReader.beginObject();
        markValueConsumed();
        this.depth++;
    }

    @Override // io.sentry.ObjectReader
    public void endObject() {
        this.jsonReader.endObject();
        this.depth--;
    }

    @Override // io.sentry.ObjectReader
    public void beginArray() {
        this.jsonReader.beginArray();
        markValueConsumed();
        this.depth++;
    }

    @Override // io.sentry.ObjectReader
    public void endArray() {
        this.jsonReader.endArray();
        this.depth--;
    }

    @Override // io.sentry.ObjectReader
    public boolean hasNext() {
        return this.jsonReader.hasNext();
    }

    @Override // io.sentry.ObjectReader
    public int nextInt() throws IOException {
        int iNextInt = this.jsonReader.nextInt();
        markValueConsumed();
        return iNextInt;
    }

    @Override // io.sentry.ObjectReader
    public long nextLong() throws IOException {
        long jNextLong = this.jsonReader.nextLong();
        markValueConsumed();
        return jNextLong;
    }

    @Override // io.sentry.ObjectReader
    public String nextString() throws IOException {
        String strNextString = this.jsonReader.nextString();
        markValueConsumed();
        return strNextString;
    }

    public boolean nextBoolean() throws IOException {
        boolean zNextBoolean = this.jsonReader.nextBoolean();
        markValueConsumed();
        return zNextBoolean;
    }

    @Override // io.sentry.ObjectReader
    public double nextDouble() throws IOException {
        double dNextDouble = this.jsonReader.nextDouble();
        markValueConsumed();
        return dNextDouble;
    }

    public void nextNull() {
        this.jsonReader.nextNull();
        markValueConsumed();
    }

    @Override // io.sentry.ObjectReader
    public void setLenient(boolean z) {
        this.jsonReader.setLenient(z);
    }

    @Override // io.sentry.ObjectReader
    public void skipValue() throws IOException {
        this.jsonReader.skipValue();
        markValueConsumed();
    }

    private boolean recoverAfterValueFailure(ILogger iLogger, Exception exc, String str, String str2, RecoveryState recoveryState) {
        iLogger.log(SentryLevel.WARNING, str, exc);
        try {
            recoverValue(recoveryState);
            return true;
        } catch (Exception e) {
            iLogger.log(SentryLevel.ERROR, str2, e);
            return false;
        }
    }

    private RecoveryState beginRecovery(JsonToken jsonToken) {
        RecoveryState recoveryState = new RecoveryState(this.depth, jsonToken);
        this.recoveryStates.addLast(recoveryState);
        return recoveryState;
    }

    private void endRecovery(RecoveryState recoveryState) {
        if (recoveryState == null) {
            return;
        }
        if (!this.recoveryStates.isEmpty() && this.recoveryStates.peekLast() == recoveryState) {
            this.recoveryStates.removeLast();
        } else {
            this.recoveryStates.remove(recoveryState);
        }
    }

    private void markValueConsumed() {
        RecoveryState recoveryState = (RecoveryState) this.recoveryStates.peekLast();
        if (recoveryState != null) {
            recoveryState.valueConsumed = true;
        }
    }

    private void recoverValue(RecoveryState recoveryState) throws IOException {
        while (this.depth > recoveryState.startDepth) {
            JsonToken jsonTokenPeek = peek();
            if (jsonTokenPeek == JsonToken.END_OBJECT) {
                endObject();
            } else if (jsonTokenPeek == JsonToken.END_ARRAY) {
                endArray();
            } else {
                skipValue();
            }
        }
        if (recoveryState.valueConsumed || peek() != recoveryState.startToken) {
            return;
        }
        skipValue();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.jsonReader.close();
    }

    private static final class RecoveryState {
        private final int startDepth;
        private final JsonToken startToken;
        private boolean valueConsumed;

        private RecoveryState(int i, JsonToken jsonToken) {
            this.startDepth = i;
            this.startToken = jsonToken;
        }
    }
}
