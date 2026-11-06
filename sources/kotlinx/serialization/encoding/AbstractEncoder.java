package kotlinx.serialization.encoding;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.internal.NoOpEncoder;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractEncoder implements Encoder, CompositeEncoder {
    @Override // kotlinx.serialization.encoding.Encoder
    public CompositeEncoder beginStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return this;
    }

    public boolean encodeElement(SerialDescriptor descriptor, int i) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return true;
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public Encoder encodeInline(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return this;
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public void endStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public CompositeEncoder beginCollection(SerialDescriptor serialDescriptor, int i) {
        return Encoder.DefaultImpls.beginCollection(this, serialDescriptor, i);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeNotNullMark() {
        Encoder.DefaultImpls.encodeNotNullMark(this);
    }

    public void encodeNullableSerializableValue(SerializationStrategy serializationStrategy, Object obj) {
        Encoder.DefaultImpls.encodeNullableSerializableValue(this, serializationStrategy, obj);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeSerializableValue(SerializationStrategy serializationStrategy, Object obj) {
        Encoder.DefaultImpls.encodeSerializableValue(this, serializationStrategy, obj);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public boolean shouldEncodeElementDefault(SerialDescriptor serialDescriptor, int i) {
        return CompositeEncoder.DefaultImpls.shouldEncodeElementDefault(this, serialDescriptor, i);
    }

    public void encodeValue(Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        throw new SerializationException("Non-serializable " + Reflection.getOrCreateKotlinClass(value.getClass()) + " is not supported by " + Reflection.getOrCreateKotlinClass(getClass()) + " encoder");
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeNull() {
        throw new SerializationException("'null' is not supported by default");
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeBoolean(boolean z) {
        encodeValue(Boolean.valueOf(z));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeByte(byte b) {
        encodeValue(Byte.valueOf(b));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeShort(short s) {
        encodeValue(Short.valueOf(s));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeInt(int i) {
        encodeValue(Integer.valueOf(i));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeLong(long j) {
        encodeValue(Long.valueOf(j));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeFloat(float f) {
        encodeValue(Float.valueOf(f));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeDouble(double d) {
        encodeValue(Double.valueOf(d));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeChar(char c) {
        encodeValue(Character.valueOf(c));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeString(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        encodeValue(value);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void encodeEnum(SerialDescriptor enumDescriptor, int i) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        encodeValue(Integer.valueOf(i));
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeBooleanElement(SerialDescriptor descriptor, int i, boolean z) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (encodeElement(descriptor, i)) {
            encodeBoolean(z);
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeByteElement(SerialDescriptor descriptor, int i, byte b) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (encodeElement(descriptor, i)) {
            encodeByte(b);
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeShortElement(SerialDescriptor descriptor, int i, short s) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (encodeElement(descriptor, i)) {
            encodeShort(s);
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeIntElement(SerialDescriptor descriptor, int i, int i2) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (encodeElement(descriptor, i)) {
            encodeInt(i2);
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeLongElement(SerialDescriptor descriptor, int i, long j) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (encodeElement(descriptor, i)) {
            encodeLong(j);
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeFloatElement(SerialDescriptor descriptor, int i, float f) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (encodeElement(descriptor, i)) {
            encodeFloat(f);
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeDoubleElement(SerialDescriptor descriptor, int i, double d) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (encodeElement(descriptor, i)) {
            encodeDouble(d);
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeCharElement(SerialDescriptor descriptor, int i, char c) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (encodeElement(descriptor, i)) {
            encodeChar(c);
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void encodeStringElement(SerialDescriptor descriptor, int i, String value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(value, "value");
        if (encodeElement(descriptor, i)) {
            encodeString(value);
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final Encoder encodeInlineElement(SerialDescriptor descriptor, int i) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return encodeElement(descriptor, i) ? encodeInline(descriptor.getElementDescriptor(i)) : NoOpEncoder.INSTANCE;
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
}
