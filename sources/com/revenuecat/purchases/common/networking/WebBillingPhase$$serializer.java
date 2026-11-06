package com.revenuecat.purchases.common.networking;

import com.amazon.a.a.o.b;
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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/common/networking/WebBillingPhase.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/common/networking/WebBillingPhase;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated
public final class WebBillingPhase$$serializer implements GeneratedSerializer {
    public static final WebBillingPhase$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        WebBillingPhase$$serializer webBillingPhase$$serializer = new WebBillingPhase$$serializer();
        INSTANCE = webBillingPhase$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.common.networking.WebBillingPhase", webBillingPhase$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement(b.x, true);
        pluginGeneratedSerialDescriptor.addElement("period_duration", true);
        pluginGeneratedSerialDescriptor.addElement("cycle_count", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private WebBillingPhase$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(WebBillingPrice$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), IntSerializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public WebBillingPhase deserialize(Decoder decoder) {
        int iDecodeIntElement;
        int i;
        WebBillingPrice webBillingPrice;
        String str;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            WebBillingPrice webBillingPrice2 = (WebBillingPrice) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, WebBillingPrice$$serializer.INSTANCE, null);
            String str2 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, null);
            webBillingPrice = webBillingPrice2;
            iDecodeIntElement = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 2);
            str = str2;
            i = 7;
        } else {
            boolean z = true;
            int iDecodeIntElement2 = 0;
            WebBillingPrice webBillingPrice3 = null;
            String str3 = null;
            int i2 = 0;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    webBillingPrice3 = (WebBillingPrice) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, WebBillingPrice$$serializer.INSTANCE, webBillingPrice3);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    str3 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, str3);
                    i2 |= 2;
                } else {
                    if (iDecodeElementIndex != 2) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    iDecodeIntElement2 = compositeDecoderBeginStructure.decodeIntElement(descriptor2, 2);
                    i2 |= 4;
                }
            }
            iDecodeIntElement = iDecodeIntElement2;
            i = i2;
            webBillingPrice = webBillingPrice3;
            str = str3;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new WebBillingPhase(i, webBillingPrice, str, iDecodeIntElement, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, WebBillingPhase value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        WebBillingPhase.write$Self$purchases_defaultsBc8Release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
