package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;

/* JADX INFO: loaded from: classes5.dex */
public abstract class JavaDescriptorUtilKt {
    public static final boolean isJavaField(PropertyDescriptor propertyDescriptor) {
        Intrinsics.checkNotNullParameter(propertyDescriptor, "<this>");
        return propertyDescriptor.getGetter() == null;
    }
}
