package com.revenuecat.purchases.utils.serializers;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0005J\u001c\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J$\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/revenuecat/purchases/utils/serializers/JsonObjectToMapSerializer;", "Lkotlinx/serialization/KSerializer;", "", "", "", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class JsonObjectToMapSerializer implements KSerializer {
    public static final JsonObjectToMapSerializer INSTANCE = new JsonObjectToMapSerializer();
    private static final SerialDescriptor descriptor = JsonObject.INSTANCE.serializer().getDescriptor();

    private JsonObjectToMapSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public Map<String, Object> deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        JsonDecoder jsonDecoder = decoder instanceof JsonDecoder ? (JsonDecoder) decoder : null;
        if (jsonDecoder == null) {
            throw new IllegalStateException("Only JSON decoding is supported");
        }
        JsonElement jsonElementDecodeJsonElement = jsonDecoder.decodeJsonElement();
        JsonObject jsonObject = jsonElementDecodeJsonElement instanceof JsonObject ? (JsonObject) jsonElementDecodeJsonElement : null;
        return jsonObject == null ? MapsKt.emptyMap() : JsonObjectToMapSerializerKt.toAnyMap(jsonObject);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, Map<String, ? extends Object> value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        throw new IllegalStateException("Serialization of Map<String, Any> is not supported");
    }
}
