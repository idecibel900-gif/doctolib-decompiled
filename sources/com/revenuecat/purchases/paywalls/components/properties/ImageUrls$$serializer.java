package com.revenuecat.purchases.paywalls.components.properties;

import com.revenuecat.purchases.utils.serializers.URLSerializer;
import java.net.URL;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.UInt;
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
import kotlinx.serialization.internal.UIntSerializer;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/paywalls/components/properties/ImageUrls.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/components/properties/ImageUrls;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated
public final class ImageUrls$$serializer implements GeneratedSerializer {
    public static final ImageUrls$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        ImageUrls$$serializer imageUrls$$serializer = new ImageUrls$$serializer();
        INSTANCE = imageUrls$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.properties.ImageUrls", imageUrls$$serializer, 5);
        pluginGeneratedSerialDescriptor.addElement("original", false);
        pluginGeneratedSerialDescriptor.addElement("webp", false);
        pluginGeneratedSerialDescriptor.addElement("webp_low_res", false);
        pluginGeneratedSerialDescriptor.addElement("width", false);
        pluginGeneratedSerialDescriptor.addElement("height", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ImageUrls$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer[] childSerializers() {
        URLSerializer uRLSerializer = URLSerializer.INSTANCE;
        UIntSerializer uIntSerializer = UIntSerializer.INSTANCE;
        return new KSerializer[]{uRLSerializer, uRLSerializer, uRLSerializer, uIntSerializer, uIntSerializer};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public ImageUrls deserialize(Decoder decoder) {
        int i;
        URL url;
        URL url2;
        URL url3;
        UInt uInt;
        UInt uInt2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        URL url4 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            URLSerializer uRLSerializer = URLSerializer.INSTANCE;
            URL url5 = (URL) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, uRLSerializer, null);
            URL url6 = (URL) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 1, uRLSerializer, null);
            URL url7 = (URL) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 2, uRLSerializer, null);
            UIntSerializer uIntSerializer = UIntSerializer.INSTANCE;
            url3 = url7;
            uInt = (UInt) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 3, uIntSerializer, null);
            uInt2 = (UInt) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 4, uIntSerializer, null);
            i = 31;
            url2 = url6;
            url = url5;
        } else {
            boolean z = true;
            int i2 = 0;
            URL url8 = null;
            URL url9 = null;
            UInt uInt3 = null;
            UInt uInt4 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    url4 = (URL) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, URLSerializer.INSTANCE, url4);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    url8 = (URL) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 1, URLSerializer.INSTANCE, url8);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    url9 = (URL) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 2, URLSerializer.INSTANCE, url9);
                    i2 |= 4;
                } else if (iDecodeElementIndex == 3) {
                    uInt3 = (UInt) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 3, UIntSerializer.INSTANCE, uInt3);
                    i2 |= 8;
                } else {
                    if (iDecodeElementIndex != 4) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    uInt4 = (UInt) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 4, UIntSerializer.INSTANCE, uInt4);
                    i2 |= 16;
                }
            }
            i = i2;
            url = url4;
            url2 = url8;
            url3 = url9;
            uInt = uInt3;
            uInt2 = uInt4;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new ImageUrls(i, url, url2, url3, uInt, uInt2, null, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, ImageUrls value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        ImageUrls.write$Self$purchases_defaultsBc8Release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
