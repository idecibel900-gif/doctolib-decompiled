package kotlinx.serialization.internal;

import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;

/* JADX INFO: loaded from: classes5.dex */
public final class UByteArraySerializer extends PrimitiveArraySerializer implements KSerializer {
    public static final UByteArraySerializer INSTANCE = new UByteArraySerializer();

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public /* bridge */ /* synthetic */ int collectionSize(Object obj) {
        return m5482collectionSizeGBYM_sE(((UByteArray) obj).m5272unboximpl());
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public /* bridge */ /* synthetic */ Object empty() {
        return UByteArray.m5258boximpl(m5483emptyTcUX1vc());
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public /* bridge */ /* synthetic */ Object toBuilder(Object obj) {
        return m5484toBuilderGBYM_sE(((UByteArray) obj).m5272unboximpl());
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public /* bridge */ /* synthetic */ void writeContent(CompositeEncoder compositeEncoder, Object obj, int i) {
        m5485writeContentCoi6ktg(compositeEncoder, ((UByteArray) obj).m5272unboximpl(), i);
    }

    private UByteArraySerializer() {
        super(BuiltinSerializersKt.serializer(UByte.Companion));
    }

    /* JADX INFO: renamed from: collectionSize-GBYM_sE, reason: not valid java name */
    protected int m5482collectionSizeGBYM_sE(byte[] collectionSize) {
        Intrinsics.checkNotNullParameter(collectionSize, "$this$collectionSize");
        return UByteArray.m5265getSizeimpl(collectionSize);
    }

    /* JADX INFO: renamed from: toBuilder-GBYM_sE, reason: not valid java name */
    protected UByteArrayBuilder m5484toBuilderGBYM_sE(byte[] toBuilder) {
        Intrinsics.checkNotNullParameter(toBuilder, "$this$toBuilder");
        return new UByteArrayBuilder(toBuilder, null);
    }

    /* JADX INFO: renamed from: empty-TcUX1vc, reason: not valid java name */
    protected byte[] m5483emptyTcUX1vc() {
        return UByteArray.m5259constructorimpl(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.CollectionLikeSerializer, kotlinx.serialization.internal.AbstractCollectionSerializer
    public void readElement(CompositeDecoder decoder, int i, UByteArrayBuilder builder, boolean z) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Intrinsics.checkNotNullParameter(builder, "builder");
        builder.m5480append7apg3OU$kotlinx_serialization_core(UByte.m5253constructorimpl(decoder.decodeInlineElement(getDescriptor(), i).decodeByte()));
    }

    /* JADX INFO: renamed from: writeContent-Coi6ktg, reason: not valid java name */
    protected void m5485writeContentCoi6ktg(CompositeEncoder encoder, byte[] content, int i) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(content, "content");
        for (int i2 = 0; i2 < i; i2++) {
            encoder.encodeInlineElement(getDescriptor(), i2).encodeByte(UByteArray.m5264getw2LRezQ(content, i2));
        }
    }
}
