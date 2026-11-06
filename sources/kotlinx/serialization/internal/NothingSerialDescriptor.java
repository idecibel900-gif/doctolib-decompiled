package kotlinx.serialization.internal;

import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;

/* JADX INFO: loaded from: classes5.dex */
public final class NothingSerialDescriptor implements SerialDescriptor {
    public static final NothingSerialDescriptor INSTANCE = new NothingSerialDescriptor();
    private static final SerialKind kind = StructureKind.OBJECT.INSTANCE;
    private static final String serialName = "kotlin.Nothing";

    public boolean equals(Object obj) {
        return this == obj;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int getElementsCount() {
        return 0;
    }

    private NothingSerialDescriptor() {
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List getAnnotations() {
        return SerialDescriptor.DefaultImpls.getAnnotations(this);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isInline() {
        return SerialDescriptor.DefaultImpls.isInline(this);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isNullable() {
        return SerialDescriptor.DefaultImpls.isNullable(this);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialKind getKind() {
        return kind;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String getSerialName() {
        return serialName;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String getElementName(int i) {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int getElementIndex(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isElementOptional(int i) {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialDescriptor getElementDescriptor(int i) {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List getElementAnnotations(int i) {
        error();
        throw new KotlinNothingValueException();
    }

    public String toString() {
        return "NothingSerialDescriptor";
    }

    public int hashCode() {
        return getSerialName().hashCode() + (getKind().hashCode() * 31);
    }

    private final Void error() {
        throw new IllegalStateException("Descriptor for type `kotlin.Nothing` does not have elements");
    }
}
