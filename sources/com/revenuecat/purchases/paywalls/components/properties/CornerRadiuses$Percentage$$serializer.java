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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/paywalls/components/properties/CornerRadiuses.Percentage.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/components/properties/CornerRadiuses$Percentage;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated
public final class CornerRadiuses$Percentage$$serializer implements GeneratedSerializer {
    public static final CornerRadiuses$Percentage$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        CornerRadiuses$Percentage$$serializer cornerRadiuses$Percentage$$serializer = new CornerRadiuses$Percentage$$serializer();
        INSTANCE = cornerRadiuses$Percentage$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.properties.CornerRadiuses.Percentage", cornerRadiuses$Percentage$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement("top_leading", false);
        pluginGeneratedSerialDescriptor.addElement("top_trailing", false);
        pluginGeneratedSerialDescriptor.addElement("bottom_leading", false);
        pluginGeneratedSerialDescriptor.addElement("bottom_trailing", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private CornerRadiuses$Percentage$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer[] childSerializers() {
        IntSerializer intSerializer = IntSerializer.INSTANCE;
        return new KSerializer[]{intSerializer, intSerializer, intSerializer, intSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public CornerRadiuses.Percentage deserialize(Decoder decoder) {
        int iDecodeIntElement;
        int iDecodeIntElement2;
        int i;
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            iDecodeIntElement = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 0);
            int iDecodeIntElement3 = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 1);
            int iDecodeIntElement4 = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 2);
            iDecodeIntElement2 = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 3);
            i = iDecodeIntElement4;
            i2 = iDecodeIntElement3;
            i3 = 15;
        } else {
            boolean z = true;
            iDecodeIntElement = 0;
            int iDecodeIntElement5 = 0;
            int iDecodeIntElement6 = 0;
            int iDecodeIntElement7 = 0;
            int i4 = 0;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    iDecodeIntElement = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 0);
                    i4 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    iDecodeIntElement7 = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 1);
                    i4 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    iDecodeIntElement6 = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 2);
                    i4 |= 4;
                } else {
                    if (iDecodeElementIndex != 3) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    iDecodeIntElement5 = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 3);
                    i4 |= 8;
                }
            }
            iDecodeIntElement2 = iDecodeIntElement5;
            i = iDecodeIntElement6;
            i2 = iDecodeIntElement7;
            i3 = i4;
        }
        int i5 = iDecodeIntElement;
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new CornerRadiuses.Percentage(i3, i5, i2, i, iDecodeIntElement2, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, CornerRadiuses.Percentage value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        CornerRadiuses.Percentage.write$Self$purchases_defaultsBc8Release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
