package kotlinx.serialization.internal;

import java.lang.annotation.Annotation;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;

/* JADX INFO: loaded from: classes5.dex */
public abstract class EnumsKt {
    public static final KSerializer createSimpleEnumSerializer(String serialName, Enum[] values) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(values, "values");
        return new EnumSerializer(serialName, values);
    }

    public static final KSerializer createAnnotatedEnumSerializer(String serialName, Enum[] values, String[] names, Annotation[][] entryAnnotations, Annotation[] annotationArr) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(values, "values");
        Intrinsics.checkNotNullParameter(names, "names");
        Intrinsics.checkNotNullParameter(entryAnnotations, "entryAnnotations");
        EnumDescriptor enumDescriptor = new EnumDescriptor(serialName, values.length);
        if (annotationArr != null) {
            for (Annotation annotation : annotationArr) {
                enumDescriptor.pushClassAnnotation(annotation);
            }
        }
        int length = values.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            Enum r4 = values[i];
            int i3 = i2 + 1;
            String strName = (String) ArraysKt.getOrNull(names, i2);
            if (strName == null) {
                strName = r4.name();
            }
            PluginGeneratedSerialDescriptor.addElement$default(enumDescriptor, strName, false, 2, null);
            Annotation[] annotationArr2 = (Annotation[]) ArraysKt.getOrNull(entryAnnotations, i2);
            if (annotationArr2 != null) {
                for (Annotation annotation2 : annotationArr2) {
                    enumDescriptor.pushAnnotation(annotation2);
                }
            }
            i++;
            i2 = i3;
        }
        return new EnumSerializer(serialName, values, enumDescriptor);
    }
}
