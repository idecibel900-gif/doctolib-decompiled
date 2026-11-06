package com.revenuecat.purchases.paywalls;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0016R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/revenuecat/purchases/paywalls/EmptyStringToNullSerializer;", "Lkotlinx/serialization/KSerializer;", "", "()V", "delegate", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class EmptyStringToNullSerializer implements KSerializer {
    public static final EmptyStringToNullSerializer INSTANCE = new EmptyStringToNullSerializer();
    private static final KSerializer delegate = BuiltinSerializersKt.getNullable(BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE));
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.PrimitiveSerialDescriptor("EmptyStringToNullSerializer", PrimitiveKind.STRING.INSTANCE);

    private EmptyStringToNullSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public String deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        String str = (String) delegate.deserialize(decoder);
        if (str == null || StringsKt.isBlank(str)) {
            return null;
        }
        return str;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, String value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        if (value == null) {
            encoder.encodeString("");
        } else {
            encoder.encodeString(value);
        }
    }
}
