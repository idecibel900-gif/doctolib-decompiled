package com.revenuecat.purchases;

import com.BV.LinearGradient.LinearGradientManager;
import java.util.Map;
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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/UiConfig.AppConfig.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/UiConfig$AppConfig;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated
public final class UiConfig$AppConfig$$serializer implements GeneratedSerializer {
    public static final UiConfig$AppConfig$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        UiConfig$AppConfig$$serializer uiConfig$AppConfig$$serializer = new UiConfig$AppConfig$$serializer();
        INSTANCE = uiConfig$AppConfig$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.UiConfig.AppConfig", uiConfig$AppConfig$$serializer, 2);
        pluginGeneratedSerialDescriptor.addElement(LinearGradientManager.PROP_COLORS, true);
        pluginGeneratedSerialDescriptor.addElement("fonts", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private UiConfig$AppConfig$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer[] childSerializers() {
        KSerializer[] kSerializerArr = UiConfig.AppConfig.$childSerializers;
        return new KSerializer[]{kSerializerArr[0], kSerializerArr[1]};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public UiConfig.AppConfig deserialize(Decoder decoder) {
        Map map;
        Map map2;
        int i;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        KSerializer[] kSerializerArr = UiConfig.AppConfig.$childSerializers;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            map2 = (Map) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, kSerializerArr[0], null);
            map = (Map) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 1, kSerializerArr[1], null);
            i = 3;
        } else {
            boolean z = true;
            int i2 = 0;
            Map map3 = null;
            Map map4 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    map4 = (Map) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, kSerializerArr[0], map4);
                    i2 |= 1;
                } else {
                    if (iDecodeElementIndex != 1) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    map3 = (Map) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 1, kSerializerArr[1], map3);
                    i2 |= 2;
                }
            }
            map = map3;
            map2 = map4;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new UiConfig.AppConfig(i, map2, map, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, UiConfig.AppConfig value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        UiConfig.AppConfig.write$Self$purchases_defaultsBc8Release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
