package kotlinx.serialization.internal;

import kotlin.UInt;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* JADX INFO: loaded from: classes5.dex */
public final class UIntSerializer implements KSerializer {
    public static final UIntSerializer INSTANCE = new UIntSerializer();
    private static final SerialDescriptor descriptor = InlineClassDescriptorKt.InlinePrimitiveDescriptor("kotlin.UInt", BuiltinSerializersKt.serializer(IntCompanionObject.INSTANCE));

    private UIntSerializer() {
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public /* bridge */ /* synthetic */ Object deserialize(Decoder decoder) {
        return UInt.m5274boximpl(m5494deserializeOGnWXxg(decoder));
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object obj) {
        m5495serializeQn1smSk(encoder, ((UInt) obj).m5279unboximpl());
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    /* JADX INFO: renamed from: serialize-Qn1smSk, reason: not valid java name */
    public void m5495serializeQn1smSk(Encoder encoder, int i) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        encoder.encodeInline(getDescriptor()).encodeInt(i);
    }

    /* JADX INFO: renamed from: deserialize-OGnWXxg, reason: not valid java name */
    public int m5494deserializeOGnWXxg(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return UInt.m5275constructorimpl(decoder.decodeInline(getDescriptor()).decodeInt());
    }
}
