package com.revenuecat.purchases.models;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
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
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/revenuecat/purchases/models/PriceSerializer;", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/models/Price;", "()V", "AMOUNT_MICROS_INDEX", "", "CURRENCY_CODE_INDEX", "FORMATTED_INDEX", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PriceSerializer implements KSerializer {
    private static final int AMOUNT_MICROS_INDEX = 1;
    private static final int CURRENCY_CODE_INDEX = 2;
    private static final int FORMATTED_INDEX = 0;
    public static final PriceSerializer INSTANCE = new PriceSerializer();
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.buildClassSerialDescriptor("Price", new SerialDescriptor[0], new Function1() { // from class: com.revenuecat.purchases.models.PriceSerializer$descriptor$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((ClassSerialDescriptorBuilder) obj);
            return Unit.INSTANCE;
        }

        public final void invoke(ClassSerialDescriptorBuilder buildClassSerialDescriptor) {
            Intrinsics.checkNotNullParameter(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            ClassSerialDescriptorBuilder.element$default(buildClassSerialDescriptor, "formatted", BuiltinSerializersKt.serializer(stringCompanionObject).getDescriptor(), null, false, 12, null);
            ClassSerialDescriptorBuilder.element$default(buildClassSerialDescriptor, "amount_micros", BuiltinSerializersKt.serializer(LongCompanionObject.INSTANCE).getDescriptor(), null, false, 12, null);
            ClassSerialDescriptorBuilder.element$default(buildClassSerialDescriptor, "currency_code", BuiltinSerializersKt.serializer(stringCompanionObject).getDescriptor(), null, false, 12, null);
        }
    });

    private PriceSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, Price value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        PriceSerializer priceSerializer = INSTANCE;
        compositeEncoderBeginStructure.encodeStringElement(priceSerializer.getDescriptor(), 0, value.getFormatted());
        compositeEncoderBeginStructure.encodeLongElement(priceSerializer.getDescriptor(), 1, value.getAmountMicros());
        compositeEncoderBeginStructure.encodeStringElement(priceSerializer.getDescriptor(), 2, value.getCurrencyCode());
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public Price deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        String strDecodeStringElement = "";
        long jDecodeLongElement = 0;
        String strDecodeStringElement2 = "";
        while (true) {
            PriceSerializer priceSerializer = INSTANCE;
            int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(priceSerializer.getDescriptor());
            if (iDecodeElementIndex == -1) {
                Price price = new Price(strDecodeStringElement, jDecodeLongElement, strDecodeStringElement2);
                compositeDecoderBeginStructure.endStructure(descriptor2);
                return price;
            }
            if (iDecodeElementIndex == 0) {
                strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(priceSerializer.getDescriptor(), 0);
            } else if (iDecodeElementIndex == 1) {
                jDecodeLongElement = compositeDecoderBeginStructure.decodeLongElement(priceSerializer.getDescriptor(), 1);
            } else if (iDecodeElementIndex == 2) {
                strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(priceSerializer.getDescriptor(), 2);
            } else {
                throw new IllegalStateException(("Unexpected index: " + iDecodeElementIndex).toString());
            }
        }
    }
}
