package kotlinx.serialization.internal;

import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;

/* JADX INFO: loaded from: classes5.dex */
public final class ULongArraySerializer extends PrimitiveArraySerializer implements KSerializer {
    public static final ULongArraySerializer INSTANCE = new ULongArraySerializer();

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public /* bridge */ /* synthetic */ int collectionSize(Object obj) {
        return m5498collectionSizeQwZRm1k(((ULongArray) obj).m5317unboximpl());
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public /* bridge */ /* synthetic */ Object empty() {
        return ULongArray.m5303boximpl(m5499emptyY2RjT0g());
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public /* bridge */ /* synthetic */ Object toBuilder(Object obj) {
        return m5500toBuilderQwZRm1k(((ULongArray) obj).m5317unboximpl());
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public /* bridge */ /* synthetic */ void writeContent(CompositeEncoder compositeEncoder, Object obj, int i) {
        m5501writeContent0q3Fkuo(compositeEncoder, ((ULongArray) obj).m5317unboximpl(), i);
    }

    private ULongArraySerializer() {
        super(BuiltinSerializersKt.serializer(ULong.Companion));
    }

    /* JADX INFO: renamed from: collectionSize-QwZRm1k, reason: not valid java name */
    protected int m5498collectionSizeQwZRm1k(long[] collectionSize) {
        Intrinsics.checkNotNullParameter(collectionSize, "$this$collectionSize");
        return ULongArray.m5310getSizeimpl(collectionSize);
    }

    /* JADX INFO: renamed from: toBuilder-QwZRm1k, reason: not valid java name */
    protected ULongArrayBuilder m5500toBuilderQwZRm1k(long[] toBuilder) {
        Intrinsics.checkNotNullParameter(toBuilder, "$this$toBuilder");
        return new ULongArrayBuilder(toBuilder, null);
    }

    /* JADX INFO: renamed from: empty-Y2RjT0g, reason: not valid java name */
    protected long[] m5499emptyY2RjT0g() {
        return ULongArray.m5304constructorimpl(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.CollectionLikeSerializer, kotlinx.serialization.internal.AbstractCollectionSerializer
    public void readElement(CompositeDecoder decoder, int i, ULongArrayBuilder builder, boolean z) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Intrinsics.checkNotNullParameter(builder, "builder");
        builder.m5496appendVKZWuLQ$kotlinx_serialization_core(ULong.m5297constructorimpl(decoder.decodeInlineElement(getDescriptor(), i).decodeLong()));
    }

    /* JADX INFO: renamed from: writeContent-0q3Fkuo, reason: not valid java name */
    protected void m5501writeContent0q3Fkuo(CompositeEncoder encoder, long[] content, int i) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(content, "content");
        for (int i2 = 0; i2 < i; i2++) {
            encoder.encodeInlineElement(getDescriptor(), i2).encodeLong(ULongArray.m5309getsVKNKU(content, i2));
        }
    }
}
