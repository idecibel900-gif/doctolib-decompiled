package kotlinx.serialization.internal;

import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.ShortCompanionObject;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* JADX INFO: loaded from: classes5.dex */
public final class UShortSerializer implements KSerializer {
    public static final UShortSerializer INSTANCE = new UShortSerializer();
    private static final SerialDescriptor descriptor = InlineClassDescriptorKt.InlinePrimitiveDescriptor("kotlin.UShort", BuiltinSerializersKt.serializer(ShortCompanionObject.INSTANCE));

    private UShortSerializer() {
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public /* bridge */ /* synthetic */ Object deserialize(Decoder decoder) {
        return UShort.m5319boximpl(m5510deserializeBwKQO78(decoder));
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object obj) {
        m5511serializei8woANY(encoder, ((UShort) obj).m5324unboximpl());
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    /* JADX INFO: renamed from: serialize-i8woANY, reason: not valid java name */
    public void m5511serializei8woANY(Encoder encoder, short s) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        encoder.encodeInline(getDescriptor()).encodeShort(s);
    }

    /* JADX INFO: renamed from: deserialize-BwKQO78, reason: not valid java name */
    public short m5510deserializeBwKQO78(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return UShort.m5320constructorimpl(decoder.decodeInline(getDescriptor()).decodeShort());
    }
}
