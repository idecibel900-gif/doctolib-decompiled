package com.google.gson;

import com.google.gson.internal.bind.JsonTreeWriter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public abstract class TypeAdapter {
    public abstract Object read(JsonReader jsonReader);

    public abstract void write(JsonWriter jsonWriter, Object obj);

    public final JsonElement toJsonTree(Object obj) {
        try {
            JsonTreeWriter jsonTreeWriter = new JsonTreeWriter();
            write(jsonTreeWriter, obj);
            return jsonTreeWriter.get();
        } catch (IOException e) {
            throw new JsonIOException(e);
        }
    }

    public final TypeAdapter nullSafe() {
        return !(this instanceof NullSafeTypeAdapter) ? new NullSafeTypeAdapter() : this;
    }

    private final class NullSafeTypeAdapter extends TypeAdapter {
        private NullSafeTypeAdapter() {
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object obj) throws IOException {
            if (obj == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter.this.write(jsonWriter, obj);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return TypeAdapter.this.read(jsonReader);
        }

        public String toString() {
            return "NullSafeTypeAdapter[" + TypeAdapter.this + "]";
        }
    }
}
