package com.revenuecat.purchases.customercenter;

import com.revenuecat.purchases.paywalls.EmptyStringToNullSerializer;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/customercenter/CustomerCenterConfigData.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated
public final class CustomerCenterConfigData$$serializer implements GeneratedSerializer {
    public static final CustomerCenterConfigData$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        CustomerCenterConfigData$$serializer customerCenterConfigData$$serializer = new CustomerCenterConfigData$$serializer();
        INSTANCE = customerCenterConfigData$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.customercenter.CustomerCenterConfigData", customerCenterConfigData$$serializer, 5);
        pluginGeneratedSerialDescriptor.addElement("screens", false);
        pluginGeneratedSerialDescriptor.addElement("appearance", false);
        pluginGeneratedSerialDescriptor.addElement("localization", false);
        pluginGeneratedSerialDescriptor.addElement("support", false);
        pluginGeneratedSerialDescriptor.addElement("last_published_app_version", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private CustomerCenterConfigData$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer[] childSerializers() {
        return new KSerializer[]{ScreenMapSerializer.INSTANCE, CustomerCenterConfigData$Appearance$$serializer.INSTANCE, CustomerCenterConfigData$Localization$$serializer.INSTANCE, CustomerCenterConfigData$Support$$serializer.INSTANCE, BuiltinSerializersKt.getNullable(EmptyStringToNullSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public CustomerCenterConfigData deserialize(Decoder decoder) {
        int i;
        Map map;
        CustomerCenterConfigData.Appearance appearance;
        CustomerCenterConfigData.Localization localization;
        CustomerCenterConfigData.Support support;
        String str;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        Map map2 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            Map map3 = (Map) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, ScreenMapSerializer.INSTANCE, null);
            CustomerCenterConfigData.Appearance appearance2 = (CustomerCenterConfigData.Appearance) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 1, CustomerCenterConfigData$Appearance$$serializer.INSTANCE, null);
            CustomerCenterConfigData.Localization localization2 = (CustomerCenterConfigData.Localization) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 2, CustomerCenterConfigData$Localization$$serializer.INSTANCE, null);
            map = map3;
            support = (CustomerCenterConfigData.Support) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 3, CustomerCenterConfigData$Support$$serializer.INSTANCE, null);
            str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, EmptyStringToNullSerializer.INSTANCE, null);
            localization = localization2;
            appearance = appearance2;
            i = 31;
        } else {
            boolean z = true;
            int i2 = 0;
            CustomerCenterConfigData.Appearance appearance3 = null;
            CustomerCenterConfigData.Localization localization3 = null;
            CustomerCenterConfigData.Support support2 = null;
            String str2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    map2 = (Map) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, ScreenMapSerializer.INSTANCE, map2);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    appearance3 = (CustomerCenterConfigData.Appearance) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 1, CustomerCenterConfigData$Appearance$$serializer.INSTANCE, appearance3);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    localization3 = (CustomerCenterConfigData.Localization) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 2, CustomerCenterConfigData$Localization$$serializer.INSTANCE, localization3);
                    i2 |= 4;
                } else if (iDecodeElementIndex == 3) {
                    support2 = (CustomerCenterConfigData.Support) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 3, CustomerCenterConfigData$Support$$serializer.INSTANCE, support2);
                    i2 |= 8;
                } else {
                    if (iDecodeElementIndex != 4) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    str2 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, EmptyStringToNullSerializer.INSTANCE, str2);
                    i2 |= 16;
                }
            }
            i = i2;
            map = map2;
            appearance = appearance3;
            localization = localization3;
            support = support2;
            str = str2;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new CustomerCenterConfigData(i, map, appearance, localization, support, str, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, CustomerCenterConfigData value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        CustomerCenterConfigData.write$Self$purchases_defaultsBc8Release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
