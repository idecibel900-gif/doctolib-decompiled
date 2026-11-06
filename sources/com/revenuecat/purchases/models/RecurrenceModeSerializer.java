package com.revenuecat.purchases.models;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/revenuecat/purchases/models/RecurrenceModeSerializer;", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/models/RecurrenceMode;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RecurrenceModeSerializer implements KSerializer {
    public static final RecurrenceModeSerializer INSTANCE = new RecurrenceModeSerializer();
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.buildClassSerialDescriptor("RecurrenceMode", new SerialDescriptor[0], new Function1() { // from class: com.revenuecat.purchases.models.RecurrenceModeSerializer$descriptor$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((ClassSerialDescriptorBuilder) obj);
            return Unit.INSTANCE;
        }

        public final void invoke(ClassSerialDescriptorBuilder buildClassSerialDescriptor) {
            Intrinsics.checkNotNullParameter(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
            ClassSerialDescriptorBuilder.element$default(buildClassSerialDescriptor, "name", BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE).getDescriptor(), null, false, 12, null);
        }
    });

    private RecurrenceModeSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, RecurrenceMode value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        compositeEncoderBeginStructure.encodeStringElement(INSTANCE.getDescriptor(), 0, value.name());
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public RecurrenceMode deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        String strDecodeStringElement = "";
        while (true) {
            RecurrenceModeSerializer recurrenceModeSerializer = INSTANCE;
            int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(recurrenceModeSerializer.getDescriptor());
            if (iDecodeElementIndex == -1) {
                RecurrenceMode recurrenceModeValueOf = RecurrenceMode.valueOf(strDecodeStringElement);
                compositeDecoderBeginStructure.endStructure(descriptor2);
                return recurrenceModeValueOf;
            }
            if (iDecodeElementIndex == 0) {
                strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(recurrenceModeSerializer.getDescriptor(), 0);
            } else {
                throw new IllegalStateException(("Unexpected index: " + iDecodeElementIndex).toString());
            }
        }
    }
}
