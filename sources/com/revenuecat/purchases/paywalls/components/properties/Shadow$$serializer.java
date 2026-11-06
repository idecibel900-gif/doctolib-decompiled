package com.revenuecat.purchases.paywalls.components.properties;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/paywalls/components/properties/Shadow.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/components/properties/Shadow;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated
public final class Shadow$$serializer implements GeneratedSerializer {
    public static final Shadow$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        Shadow$$serializer shadow$$serializer = new Shadow$$serializer();
        INSTANCE = shadow$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.properties.Shadow", shadow$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement("color", false);
        pluginGeneratedSerialDescriptor.addElement("radius", false);
        pluginGeneratedSerialDescriptor.addElement("x", false);
        pluginGeneratedSerialDescriptor.addElement("y", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private Shadow$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer[] childSerializers() {
        DoubleSerializer doubleSerializer = DoubleSerializer.INSTANCE;
        return new KSerializer[]{ColorScheme$$serializer.INSTANCE, doubleSerializer, doubleSerializer, doubleSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public Shadow deserialize(Decoder decoder) {
        int i;
        ColorScheme colorScheme;
        double dDecodeDoubleElement;
        double d;
        double d2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        ColorScheme colorScheme2 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            ColorScheme colorScheme3 = (ColorScheme) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, ColorScheme$$serializer.INSTANCE, null);
            double dDecodeDoubleElement2 = compositeDecoderBeginStructure.decodeDoubleElement(descriptor2, 1);
            double dDecodeDoubleElement3 = compositeDecoderBeginStructure.decodeDoubleElement(descriptor2, 2);
            colorScheme = colorScheme3;
            dDecodeDoubleElement = compositeDecoderBeginStructure.decodeDoubleElement(descriptor2, 3);
            d = dDecodeDoubleElement2;
            d2 = dDecodeDoubleElement3;
            i = 15;
        } else {
            double dDecodeDoubleElement4 = 0.0d;
            boolean z = true;
            int i2 = 0;
            double dDecodeDoubleElement5 = 0.0d;
            double dDecodeDoubleElement6 = 0.0d;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    colorScheme2 = (ColorScheme) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, ColorScheme$$serializer.INSTANCE, colorScheme2);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    dDecodeDoubleElement5 = compositeDecoderBeginStructure.decodeDoubleElement(descriptor2, 1);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    dDecodeDoubleElement6 = compositeDecoderBeginStructure.decodeDoubleElement(descriptor2, 2);
                    i2 |= 4;
                } else {
                    if (iDecodeElementIndex != 3) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    dDecodeDoubleElement4 = compositeDecoderBeginStructure.decodeDoubleElement(descriptor2, 3);
                    i2 |= 8;
                }
            }
            i = i2;
            colorScheme = colorScheme2;
            dDecodeDoubleElement = dDecodeDoubleElement4;
            d = dDecodeDoubleElement5;
            d2 = dDecodeDoubleElement6;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new Shadow(i, colorScheme, d, d2, dDecodeDoubleElement, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, Shadow value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        Shadow.write$Self$purchases_defaultsBc8Release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
