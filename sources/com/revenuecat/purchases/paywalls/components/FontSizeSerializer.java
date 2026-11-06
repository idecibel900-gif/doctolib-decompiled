package com.revenuecat.purchases.paywalls.components;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonPrimitive;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0015\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000bJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/FontSizeSerializer;", "Lkotlinx/serialization/KSerializer;", "", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Integer;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class FontSizeSerializer implements KSerializer {
    public static final FontSizeSerializer INSTANCE = new FontSizeSerializer();
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.PrimitiveSerialDescriptor("FontSize", PrimitiveKind.INT.INSTANCE);

    private FontSizeSerializer() {
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object obj) {
        serialize(encoder, ((Number) obj).intValue());
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public void serialize(Encoder encoder, int value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        throw new IllegalStateException("Serialization is not implemented as it is not (yet) needed.");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // kotlinx.serialization.DeserializationStrategy
    public Integer deserialize(Decoder decoder) {
        int i;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        JsonDecoder jsonDecoder = decoder instanceof JsonDecoder ? (JsonDecoder) decoder : null;
        if (jsonDecoder == null) {
            throw new SerializationException("Expected font_size to be part of a JSON object");
        }
        JsonElement jsonElementDecodeJsonElement = jsonDecoder.decodeJsonElement();
        JsonPrimitive jsonPrimitive = jsonElementDecodeJsonElement instanceof JsonPrimitive ? (JsonPrimitive) jsonElementDecodeJsonElement : null;
        if (jsonPrimitive == null) {
            throw new SerializationException("Expected font_size to be a JsonPrimitive");
        }
        if (jsonPrimitive.isString()) {
            String content = jsonPrimitive.getContent();
            switch (content) {
                case "body_l":
                    i = 17;
                    break;
                case "body_m":
                    i = 15;
                    break;
                case "body_s":
                    i = 13;
                    break;
                case "heading_l":
                    i = 28;
                    break;
                case "heading_m":
                    i = 24;
                    break;
                case "heading_s":
                    i = 20;
                    break;
                case "body_xl":
                    i = 18;
                    break;
                case "heading_xxl":
                    i = 40;
                    break;
                case "heading_xl":
                    i = 34;
                    break;
                case "heading_xs":
                    i = 16;
                    break;
                default:
                    if (content.equals("body_l")) {
                        i = 17;
                        break;
                    }
                    throw new SerializationException("Unknown font size name: " + content);
            }
        }
        i = JsonElementKt.getInt(jsonPrimitive);
        return Integer.valueOf(i);
    }
}
