package expo.modules.kotlin.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ArrayTypeConverterKt {
    public static final boolean isPrimitiveArray(KType type, Class clazz) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        if (Intrinsics.areEqual(clazz, boolean[].class) || Intrinsics.areEqual(clazz, byte[].class) || Intrinsics.areEqual(clazz, char[].class) || Intrinsics.areEqual(clazz, short[].class) || Intrinsics.areEqual(clazz, int[].class) || Intrinsics.areEqual(clazz, long[].class) || Intrinsics.areEqual(clazz, float[].class) || Intrinsics.areEqual(clazz, double[].class)) {
            return type.getArguments().isEmpty();
        }
        return false;
    }
}
