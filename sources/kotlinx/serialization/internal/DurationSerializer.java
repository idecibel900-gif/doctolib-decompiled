package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* JADX INFO: loaded from: classes5.dex */
public final class DurationSerializer implements KSerializer {
    public static final DurationSerializer INSTANCE = new DurationSerializer();
    private static final SerialDescriptor descriptor = new PrimitiveSerialDescriptor("kotlin.time.Duration", PrimitiveKind.STRING.INSTANCE);

    private DurationSerializer() {
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public /* bridge */ /* synthetic */ Object deserialize(Decoder decoder) {
        return Duration.m5399boximpl(m5478deserialize5sfh64U(decoder));
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object obj) {
        m5479serializeHG0u8IE(encoder, ((Duration) obj).m5431unboximpl());
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    /* JADX INFO: renamed from: serialize-HG0u8IE, reason: not valid java name */
    public void m5479serializeHG0u8IE(Encoder encoder, long j) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        encoder.encodeString(Duration.m5426toIsoStringimpl(j));
    }

    /* JADX INFO: renamed from: deserialize-5sfh64U, reason: not valid java name */
    public long m5478deserialize5sfh64U(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return Duration.Companion.m5434parseIsoStringUwyO8pc(decoder.decodeString());
    }
}
