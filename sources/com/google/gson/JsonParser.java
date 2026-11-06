package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/* JADX INFO: loaded from: classes4.dex */
public abstract class JsonParser {
    public static JsonElement parseString(String str) {
        return parseReader(new StringReader(str));
    }

    public static JsonElement parseReader(Reader reader) {
        try {
            JsonReader jsonReader = new JsonReader(reader);
            JsonElement reader2 = parseReader(jsonReader);
            if (!reader2.isJsonNull() && jsonReader.peek() != JsonToken.END_DOCUMENT) {
                throw new JsonSyntaxException("Did not consume the entire document.");
            }
            return reader2;
        } catch (MalformedJsonException | NumberFormatException e) {
            throw new JsonSyntaxException(e);
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        }
    }

    public static JsonElement parseReader(JsonReader jsonReader) {
        Strictness strictness = jsonReader.getStrictness();
        if (strictness == Strictness.LEGACY_STRICT) {
            jsonReader.setStrictness(Strictness.LENIENT);
        }
        try {
            try {
                JsonElement jsonElement = Streams.parse(jsonReader);
                jsonReader.setStrictness(strictness);
                return jsonElement;
            } catch (Throwable th) {
                jsonReader.setStrictness(strictness);
                throw th;
            }
        } catch (OutOfMemoryError | StackOverflowError e) {
            throw new JsonParseException("Failed parsing JSON source: " + jsonReader + " to Json", e);
        }
    }
}
