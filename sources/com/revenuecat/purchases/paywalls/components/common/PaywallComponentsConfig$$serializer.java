package com.revenuecat.purchases.paywalls.components.common;

import com.facebook.react.modules.appstate.AppStateModule;
import com.revenuecat.purchases.paywalls.components.HeaderComponent;
import com.revenuecat.purchases.paywalls.components.HeaderComponent$$serializer;
import com.revenuecat.purchases.paywalls.components.StackComponent;
import com.revenuecat.purchases.paywalls.components.StackComponent$$serializer;
import com.revenuecat.purchases.paywalls.components.StickyFooterComponent;
import com.revenuecat.purchases.paywalls.components.StickyFooterComponent$$serializer;
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
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/revenuecat/purchases/paywalls/components/common/PaywallComponentsConfig.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/components/common/PaywallComponentsConfig;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated
public final class PaywallComponentsConfig$$serializer implements GeneratedSerializer {
    public static final PaywallComponentsConfig$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PaywallComponentsConfig$$serializer paywallComponentsConfig$$serializer = new PaywallComponentsConfig$$serializer();
        INSTANCE = paywallComponentsConfig$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.common.PaywallComponentsConfig", paywallComponentsConfig$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement("stack", false);
        pluginGeneratedSerialDescriptor.addElement(AppStateModule.APP_STATE_BACKGROUND, false);
        pluginGeneratedSerialDescriptor.addElement("sticky_footer", true);
        pluginGeneratedSerialDescriptor.addElement("header", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PaywallComponentsConfig$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer[] childSerializers() {
        return new KSerializer[]{StackComponent$$serializer.INSTANCE, BackgroundDeserializer.INSTANCE, BuiltinSerializersKt.getNullable(StickyFooterComponent$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(HeaderComponent$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PaywallComponentsConfig deserialize(Decoder decoder) {
        int i;
        StackComponent stackComponent;
        Background background;
        StickyFooterComponent stickyFooterComponent;
        HeaderComponent headerComponent;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        StackComponent stackComponent2 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            StackComponent stackComponent3 = (StackComponent) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, StackComponent$$serializer.INSTANCE, null);
            Background background2 = (Background) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 1, BackgroundDeserializer.INSTANCE, null);
            StickyFooterComponent stickyFooterComponent2 = (StickyFooterComponent) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, StickyFooterComponent$$serializer.INSTANCE, null);
            stackComponent = stackComponent3;
            headerComponent = (HeaderComponent) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, HeaderComponent$$serializer.INSTANCE, null);
            stickyFooterComponent = stickyFooterComponent2;
            background = background2;
            i = 15;
        } else {
            boolean z = true;
            int i2 = 0;
            Background background3 = null;
            StickyFooterComponent stickyFooterComponent3 = null;
            HeaderComponent headerComponent2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    stackComponent2 = (StackComponent) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, StackComponent$$serializer.INSTANCE, stackComponent2);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    background3 = (Background) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 1, BackgroundDeserializer.INSTANCE, background3);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    stickyFooterComponent3 = (StickyFooterComponent) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, StickyFooterComponent$$serializer.INSTANCE, stickyFooterComponent3);
                    i2 |= 4;
                } else {
                    if (iDecodeElementIndex != 3) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    headerComponent2 = (HeaderComponent) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, HeaderComponent$$serializer.INSTANCE, headerComponent2);
                    i2 |= 8;
                }
            }
            i = i2;
            stackComponent = stackComponent2;
            background = background3;
            stickyFooterComponent = stickyFooterComponent3;
            headerComponent = headerComponent2;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new PaywallComponentsConfig(i, stackComponent, background, stickyFooterComponent, headerComponent, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PaywallComponentsConfig value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        PaywallComponentsConfig.write$Self$purchases_defaultsBc8Release(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
