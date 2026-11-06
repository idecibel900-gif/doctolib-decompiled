package com.revenuecat.purchases.paywalls.components.common;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.paywalls.components.PartialComponent;
import java.util.List;
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
@Metadata(d1 = {"\u0000<\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\u0004\b\u0001\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0004B\u0015\b\u0017\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u000fHÖ\u0001¢\u0006\u0002\u0010\u0010J\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u001f\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003HÖ\u0001J\u0018\u0010\u0019\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u000fHÖ\u0001¢\u0006\u0002\u0010\u0010R\u0014\u0010\b\u001a\u00020\t8VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u00068BXÂ\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"com/revenuecat/purchases/paywalls/components/common/ComponentOverride.$serializer", "T", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride;", "()V", "typeSerial0", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "getTypeSerial0", "()Lkotlinx/serialization/KSerializer;", "childSerializers", "", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "typeParametersSerializers", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Deprecated
public final class ComponentOverride$$serializer<T> implements GeneratedSerializer {
    private final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;
    private final /* synthetic */ KSerializer typeSerial0;

    private ComponentOverride$$serializer() {
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.common.ComponentOverride", this, 2);
        pluginGeneratedSerialDescriptor.addElement("conditions", false);
        pluginGeneratedSerialDescriptor.addElement(DiagnosticsEntry.PROPERTIES_KEY, false);
        this.descriptor = pluginGeneratedSerialDescriptor;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public /* synthetic */ ComponentOverride$$serializer(KSerializer typeSerial0) {
        this();
        Intrinsics.checkNotNullParameter(typeSerial0, "typeSerial0");
        this.typeSerial0 = typeSerial0;
    }

    private final KSerializer getTypeSerial0() {
        return this.typeSerial0;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer[] childSerializers() {
        return new KSerializer[]{ComponentOverride.$childSerializers[0], this.typeSerial0};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public ComponentOverride<T> deserialize(Decoder decoder) {
        List list;
        PartialComponent partialComponent;
        int i;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor);
        KSerializer[] kSerializerArr = ComponentOverride.$childSerializers;
        SerializationConstructorMarker serializationConstructorMarker = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            list = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 0, kSerializerArr[0], null);
            partialComponent = (PartialComponent) compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 1, this.typeSerial0, null);
            i = 3;
        } else {
            boolean z = true;
            int i2 = 0;
            List list2 = null;
            PartialComponent partialComponent2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    list2 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 0, kSerializerArr[0], list2);
                    i2 |= 1;
                } else {
                    if (iDecodeElementIndex != 1) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    partialComponent2 = (PartialComponent) compositeDecoderBeginStructure.decodeSerializableElement(descriptor, 1, this.typeSerial0, partialComponent2);
                    i2 |= 2;
                }
            }
            list = list2;
            partialComponent = partialComponent2;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(descriptor);
        return new ComponentOverride<>(i, list, partialComponent, serializationConstructorMarker);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, ComponentOverride<T> value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor);
        ComponentOverride.write$Self$purchases_defaultsBc8Release(value, compositeEncoderBeginStructure, descriptor, this.typeSerial0);
        compositeEncoderBeginStructure.endStructure(descriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer[] typeParametersSerializers() {
        return new KSerializer[]{this.typeSerial0};
    }
}
