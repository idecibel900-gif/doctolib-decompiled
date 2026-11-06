package kotlinx.serialization.internal;

import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;

/* JADX INFO: loaded from: classes5.dex */
public final class UIntArraySerializer extends PrimitiveArraySerializer implements KSerializer {
    public static final UIntArraySerializer INSTANCE = new UIntArraySerializer();

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public /* bridge */ /* synthetic */ int collectionSize(Object obj) {
        return m5490collectionSizeajY9A(((UIntArray) obj).m5294unboximpl());
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public /* bridge */ /* synthetic */ Object empty() {
        return UIntArray.m5280boximpl(m5491emptyhP7Qyg());
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public /* bridge */ /* synthetic */ Object toBuilder(Object obj) {
        return m5492toBuilderajY9A(((UIntArray) obj).m5294unboximpl());
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public /* bridge */ /* synthetic */ void writeContent(CompositeEncoder compositeEncoder, Object obj, int i) {
        m5493writeContentCPlH8fI(compositeEncoder, ((UIntArray) obj).m5294unboximpl(), i);
    }

    private UIntArraySerializer() {
        super(BuiltinSerializersKt.serializer(UInt.Companion));
    }

    /* JADX INFO: renamed from: collectionSize--ajY-9A, reason: not valid java name */
    protected int m5490collectionSizeajY9A(int[] collectionSize) {
        Intrinsics.checkNotNullParameter(collectionSize, "$this$collectionSize");
        return UIntArray.m5287getSizeimpl(collectionSize);
    }

    /* JADX INFO: renamed from: toBuilder--ajY-9A, reason: not valid java name */
    protected UIntArrayBuilder m5492toBuilderajY9A(int[] toBuilder) {
        Intrinsics.checkNotNullParameter(toBuilder, "$this$toBuilder");
        return new UIntArrayBuilder(toBuilder, null);
    }

    /* JADX INFO: renamed from: empty--hP7Qyg, reason: not valid java name */
    protected int[] m5491emptyhP7Qyg() {
        return UIntArray.m5281constructorimpl(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.CollectionLikeSerializer, kotlinx.serialization.internal.AbstractCollectionSerializer
    public void readElement(CompositeDecoder decoder, int i, UIntArrayBuilder builder, boolean z) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Intrinsics.checkNotNullParameter(builder, "builder");
        builder.m5488appendWZ4Q5Ns$kotlinx_serialization_core(UInt.m5275constructorimpl(decoder.decodeInlineElement(getDescriptor(), i).decodeInt()));
    }

    /* JADX INFO: renamed from: writeContent-CPlH8fI, reason: not valid java name */
    protected void m5493writeContentCPlH8fI(CompositeEncoder encoder, int[] content, int i) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(content, "content");
        for (int i2 = 0; i2 < i; i2++) {
            encoder.encodeInlineElement(getDescriptor(), i2).encodeInt(UIntArray.m5286getpVg5ArA(content, i2));
        }
    }
}
