package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ModalityUtilsKt {
    public static final boolean isFinalClass(ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(classDescriptor, "<this>");
        return classDescriptor.getModality() == Modality.FINAL && classDescriptor.getKind() != ClassKind.ENUM_CLASS;
    }
}
