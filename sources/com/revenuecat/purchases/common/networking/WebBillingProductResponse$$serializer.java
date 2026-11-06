package com.revenuecat.purchases.common.networking;

import com.amazon.a.a.o.b;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
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
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/common/networking/WebBillingProductResponse.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/common/networking/WebBillingProductResponse;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated
public final class WebBillingProductResponse$$serializer implements GeneratedSerializer {
    public static final WebBillingProductResponse$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        WebBillingProductResponse$$serializer webBillingProductResponse$$serializer = new WebBillingProductResponse$$serializer();
        INSTANCE = webBillingProductResponse$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.common.networking.WebBillingProductResponse", webBillingProductResponse$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement("identifier", false);
        pluginGeneratedSerialDescriptor.addElement(DiagnosticsTracker.PRODUCT_TYPE_KEY, false);
        pluginGeneratedSerialDescriptor.addElement(b.S, false);
        pluginGeneratedSerialDescriptor.addElement(b.c, true);
        pluginGeneratedSerialDescriptor.addElement("default_purchase_option_id", true);
        pluginGeneratedSerialDescriptor.addElement("purchase_options", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private WebBillingProductResponse$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer[] childSerializers() {
        KSerializer[] kSerializerArr = WebBillingProductResponse.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, stringSerializer, stringSerializer, BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), kSerializerArr[5]};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public WebBillingProductResponse deserialize(Decoder decoder) {
        int i;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Map map;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        KSerializer[] kSerializerArr = WebBillingProductResponse.$childSerializers;
        String strDecodeStringElement = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
            String strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 1);
            String strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 2);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str6 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, stringSerializer, null);
            String str7 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, stringSerializer, null);
            map = (Map) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 5, kSerializerArr[5], null);
            str = strDecodeStringElement2;
            str4 = str6;
            str5 = str7;
            str3 = strDecodeStringElement4;
            i = 63;
            str2 = strDecodeStringElement3;
        } else {
            boolean z = true;
            int i2 = 0;
            String strDecodeStringElement5 = null;
            String strDecodeStringElement6 = null;
            String str8 = null;
            String str9 = null;
            Map map2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        continue;
                    case 0:
                        strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 0);
                        i2 |= 1;
                        continue;
                    case 1:
                        strDecodeStringElement5 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 1);
                        i2 |= 2;
                        break;
                    case 2:
                        strDecodeStringElement6 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 2);
                        i2 |= 4;
                        break;
                    case 3:
                        str8 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, StringSerializer.INSTANCE, str8);
                        i2 |= 8;
                        break;
                    case 4:
                        str9 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, StringSerializer.INSTANCE, str9);
                        i2 |= 16;
                        break;
                    case 5:
                        map2 = (Map) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 5, kSerializerArr[5], map2);
                        i2 |= 32;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            i = i2;
            str = strDecodeStringElement;
            str2 = strDecodeStringElement5;
            str3 = strDecodeStringElement6;
            str4 = str8;
            str5 = str9;
            map = map2;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new WebBillingProductResponse(i, str, str2, str3, str4, str5, map, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, WebBillingProductResponse value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        WebBillingProductResponse.write$Self$purchases_defaultsBc8Release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
