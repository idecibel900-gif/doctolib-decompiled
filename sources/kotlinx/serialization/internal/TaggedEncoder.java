package kotlinx.serialization.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;

/* JADX INFO: loaded from: classes5.dex */
public abstract class TaggedEncoder implements Encoder, CompositeEncoder {
    private final ArrayList tagStack = new ArrayList();

    @Override // kotlinx.serialization.encoding.Encoder
    public abstract void encodeSerializableValue(SerializationStrategy serializationStrategy, Object obj);

    protected abstract void encodeTaggedBoolean(Object obj, boolean z);

    protected abstract void encodeTaggedByte(Object obj, byte b);

    protected abstract void encodeTaggedChar(Object obj, char c);

    protected abstract void encodeTaggedDouble(Object obj, double d);

    protected abstract void encodeTaggedEnum(Object obj, SerialDescriptor serialDescriptor, int i);

    protected abstract void encodeTaggedFloat(Object obj, float f);

    protected abstract void encodeTaggedInt(Object obj, int i);

    protected abstract void encodeTaggedLong(Object obj, long j);

    protected abstract void encodeTaggedShort(Object obj, short s);

    protected abstract void encodeTaggedString(Object obj, String str);

    protected abstract void endEncode(SerialDescriptor serialDescriptor);

    protected abstract Object getTag(SerialDescriptor serialDescriptor, int i);

    @Override // kotlinx.serialization.encoding.Encoder
    public CompositeEncoder beginCollection(SerialDescriptor serialDescriptor, int i) {
        return Encoder.DefaultImpls.beginCollection(this, serialDescriptor, i);
    }

    public void encodeNullableSerializableValue(SerializationStrategy serializationStrategy, Object obj) {
        Encoder.DefaultImpls.encodeNullableSerializableValue(this, serializationStrategy, obj);
    }

    protected Encoder encodeTaggedInline(Object obj, SerialDescriptor inlineDescriptor) {
        Intrinsics.checkNotNullParameter(inlineDescriptor, "inlineDescriptor");
        pushTag(obj);
        return this;
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public Encoder encodeInline(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return encodeTaggedInline(popTag(), descriptor);
    }

    private final boolean encodeElement(SerialDescriptor serialDescriptor, int i) {
        pushTag(getTag(serialDescriptor, i));
        return true;
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeBoolean(boolean z) {
        encodeTaggedBoolean(popTag(), z);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeByte(byte b) {
        encodeTaggedByte(popTag(), b);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeShort(short s) {
        encodeTaggedShort(popTag(), s);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeInt(int i) {
        encodeTaggedInt(popTag(), i);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeLong(long j) {
        encodeTaggedLong(popTag(), j);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeFloat(float f) {
        encodeTaggedFloat(popTag(), f);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeDouble(double d) {
        encodeTaggedDouble(popTag(), d);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeChar(char c) {
        encodeTaggedChar(popTag(), c);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeString(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        encodeTaggedString(popTag(), value);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void encodeEnum(SerialDescriptor enumDescriptor, int i) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        encodeTaggedEnum(popTag(), enumDescriptor, i);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void endStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (!this.tagStack.isEmpty()) {
            popTag();
        }
        endEncode(descriptor);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeBooleanElement(SerialDescriptor descriptor, int i, boolean z) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        encodeTaggedBoolean(getTag(descriptor, i), z);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeByteElement(SerialDescriptor descriptor, int i, byte b) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        encodeTaggedByte(getTag(descriptor, i), b);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeShortElement(SerialDescriptor descriptor, int i, short s) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        encodeTaggedShort(getTag(descriptor, i), s);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeIntElement(SerialDescriptor descriptor, int i, int i2) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        encodeTaggedInt(getTag(descriptor, i), i2);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeLongElement(SerialDescriptor descriptor, int i, long j) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        encodeTaggedLong(getTag(descriptor, i), j);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeFloatElement(SerialDescriptor descriptor, int i, float f) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        encodeTaggedFloat(getTag(descriptor, i), f);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeDoubleElement(SerialDescriptor descriptor, int i, double d) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        encodeTaggedDouble(getTag(descriptor, i), d);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeCharElement(SerialDescriptor descriptor, int i, char c) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        encodeTaggedChar(getTag(descriptor, i), c);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeStringElement(SerialDescriptor descriptor, int i, String value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(value, "value");
        encodeTaggedString(getTag(descriptor, i), value);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final Encoder encodeInlineElement(SerialDescriptor descriptor, int i) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return encodeTaggedInline(getTag(descriptor, i), descriptor.getElementDescriptor(i));
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public void encodeSerializableElement(SerialDescriptor descriptor, int i, SerializationStrategy serializer, Object obj) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        if (encodeElement(descriptor, i)) {
            encodeSerializableValue(serializer, obj);
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public void encodeNullableSerializableElement(SerialDescriptor descriptor, int i, SerializationStrategy serializer, Object obj) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        if (encodeElement(descriptor, i)) {
            encodeNullableSerializableValue(serializer, obj);
        }
    }

    protected final Object getCurrentTag() {
        return CollectionsKt.last((List) this.tagStack);
    }

    protected final Object getCurrentTagOrNull() {
        return CollectionsKt.lastOrNull((List) this.tagStack);
    }

    protected final void pushTag(Object obj) {
        this.tagStack.add(obj);
    }

    protected final Object popTag() {
        if (!this.tagStack.isEmpty()) {
            ArrayList arrayList = this.tagStack;
            return arrayList.remove(CollectionsKt.getLastIndex(arrayList));
        }
        throw new SerializationException("No tag in stack for requested element");
    }
}
