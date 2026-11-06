package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes4.dex */
public final class TreeTypeAdapter<T> extends SerializationDelegatingTypeAdapter<T> {
    private final GsonContextImpl context;
    private volatile TypeAdapter delegate;
    private final JsonDeserializer deserializer;
    final Gson gson;
    private final boolean nullSafe;
    private final JsonSerializer serializer;
    private final TypeAdapterFactory skipPastForGetDelegateAdapter;
    private final TypeToken typeToken;

    public TreeTypeAdapter(JsonSerializer jsonSerializer, JsonDeserializer jsonDeserializer, Gson gson, TypeToken typeToken, TypeAdapterFactory typeAdapterFactory, boolean z) {
        this.context = new GsonContextImpl();
        this.serializer = jsonSerializer;
        this.deserializer = jsonDeserializer;
        this.gson = gson;
        this.typeToken = typeToken;
        this.skipPastForGetDelegateAdapter = typeAdapterFactory;
        this.nullSafe = z;
    }

    public TreeTypeAdapter(JsonSerializer jsonSerializer, JsonDeserializer jsonDeserializer, Gson gson, TypeToken typeToken, TypeAdapterFactory typeAdapterFactory) {
        this(jsonSerializer, jsonDeserializer, gson, typeToken, typeAdapterFactory, true);
    }

    @Override // com.google.gson.TypeAdapter
    public Object read(JsonReader jsonReader) {
        if (this.deserializer == null) {
            return delegate().read(jsonReader);
        }
        JsonElement jsonElement = Streams.parse(jsonReader);
        if (this.nullSafe && jsonElement.isJsonNull()) {
            return null;
        }
        return this.deserializer.deserialize(jsonElement, this.typeToken.getType(), this.context);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Object obj) throws IOException {
        JsonSerializer jsonSerializer = this.serializer;
        if (jsonSerializer == null) {
            delegate().write(jsonWriter, obj);
        } else if (this.nullSafe && obj == null) {
            jsonWriter.nullValue();
        } else {
            Streams.write(jsonSerializer.serialize(obj, this.typeToken.getType(), this.context), jsonWriter);
        }
    }

    private TypeAdapter delegate() {
        TypeAdapter typeAdapter = this.delegate;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        TypeAdapter delegateAdapter = this.gson.getDelegateAdapter(this.skipPastForGetDelegateAdapter, this.typeToken);
        this.delegate = delegateAdapter;
        return delegateAdapter;
    }

    @Override // com.google.gson.internal.bind.SerializationDelegatingTypeAdapter
    public TypeAdapter getSerializationDelegate() {
        return this.serializer != null ? this : delegate();
    }

    private static final class SingleTypeFactory implements TypeAdapterFactory {
        private final JsonDeserializer deserializer;
        private final TypeToken exactType;
        private final Class hierarchyType;
        private final boolean matchRawType;
        private final JsonSerializer serializer;

        @Override // com.google.gson.TypeAdapterFactory
        public TypeAdapter create(Gson gson, TypeToken typeToken) {
            boolean zIsAssignableFrom;
            TypeToken typeToken2 = this.exactType;
            if (typeToken2 != null) {
                zIsAssignableFrom = typeToken2.equals(typeToken) || (this.matchRawType && this.exactType.getType() == typeToken.getRawType());
            } else {
                zIsAssignableFrom = this.hierarchyType.isAssignableFrom(typeToken.getRawType());
            }
            if (zIsAssignableFrom) {
                return new TreeTypeAdapter(this.serializer, this.deserializer, gson, typeToken, this);
            }
            return null;
        }
    }

    private final class GsonContextImpl implements JsonSerializationContext, JsonDeserializationContext {
        private GsonContextImpl() {
        }

        @Override // com.google.gson.JsonDeserializationContext
        public Object deserialize(JsonElement jsonElement, Type type) {
            return TreeTypeAdapter.this.gson.fromJson(jsonElement, type);
        }
    }
}
