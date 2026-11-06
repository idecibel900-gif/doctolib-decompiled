package com.revenuecat.purchases.paywalls.components;

import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
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
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/paywalls/components/TimelineComponent.Connector.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/components/TimelineComponent$Connector;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated
public final class TimelineComponent$Connector$$serializer implements GeneratedSerializer {
    public static final TimelineComponent$Connector$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        TimelineComponent$Connector$$serializer timelineComponent$Connector$$serializer = new TimelineComponent$Connector$$serializer();
        INSTANCE = timelineComponent$Connector$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.TimelineComponent.Connector", timelineComponent$Connector$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("width", false);
        pluginGeneratedSerialDescriptor.addElement("margin", false);
        pluginGeneratedSerialDescriptor.addElement("color", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private TimelineComponent$Connector$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer[] childSerializers() {
        return new KSerializer[]{IntSerializer.INSTANCE, Padding$$serializer.INSTANCE, ColorScheme$$serializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public TimelineComponent.Connector deserialize(Decoder decoder) {
        int iDecodeIntElement;
        int i;
        Padding padding;
        ColorScheme colorScheme;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            iDecodeIntElement = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 0);
            Padding padding2 = (Padding) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 1, Padding$$serializer.INSTANCE, null);
            colorScheme = (ColorScheme) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 2, ColorScheme$$serializer.INSTANCE, null);
            padding = padding2;
            i = 7;
        } else {
            boolean z = true;
            iDecodeIntElement = 0;
            Padding padding3 = null;
            ColorScheme colorScheme2 = null;
            int i2 = 0;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    iDecodeIntElement = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 0);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    padding3 = (Padding) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 1, Padding$$serializer.INSTANCE, padding3);
                    i2 |= 2;
                } else {
                    if (iDecodeElementIndex != 2) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    colorScheme2 = (ColorScheme) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 2, ColorScheme$$serializer.INSTANCE, colorScheme2);
                    i2 |= 4;
                }
            }
            i = i2;
            padding = padding3;
            colorScheme = colorScheme2;
        }
        int i3 = iDecodeIntElement;
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new TimelineComponent.Connector(i, i3, padding, colorScheme, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, TimelineComponent.Connector value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        TimelineComponent.Connector.write$Self$purchases_defaultsBc8Release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
