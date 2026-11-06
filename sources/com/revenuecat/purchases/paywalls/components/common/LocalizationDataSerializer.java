package com.revenuecat.purchases.paywalls.components.common;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/LocalizationDataSerializer;", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/common/LocalizationData;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor$annotations", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class LocalizationDataSerializer implements KSerializer {
    public static final LocalizationDataSerializer INSTANCE = new LocalizationDataSerializer();
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.buildSerialDescriptor$default("LocalizationData", PolymorphicKind.SEALED.INSTANCE, new SerialDescriptor[0], null, 8, null);

    public static /* synthetic */ void getDescriptor$annotations() {
    }

    private LocalizationDataSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, LocalizationData value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        throw new IllegalStateException("Serialization is not implemented as it is not (yet) needed.");
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public LocalizationData deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        try {
            return (LocalizationData) decoder.decodeSerializableValue(LocalizationData.Text.INSTANCE.serializer());
        } catch (SerializationException unused) {
            return (LocalizationData) decoder.decodeSerializableValue(LocalizationData.Image.INSTANCE.serializer());
        }
    }
}
