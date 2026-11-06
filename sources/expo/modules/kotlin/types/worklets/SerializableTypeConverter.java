package expo.modules.kotlin.types.worklets;

import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.jni.CppType;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.jni.worklets.Serializable;
import expo.modules.kotlin.types.NonNullableTypeConverter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class SerializableTypeConverter extends NonNullableTypeConverter {
    @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
    public boolean isTrivial() {
        return true;
    }

    @Override // expo.modules.kotlin.types.NonNullableTypeConverter
    public Serializable convertNonNullable(Object value, AppContext appContext, boolean z) {
        Intrinsics.checkNotNullParameter(value, "value");
        return (Serializable) value;
    }

    @Override // expo.modules.kotlin.types.TypeConverter
    public ExpectedType getCppRequiredTypes() {
        return new ExpectedType(CppType.SERIALIZABLE);
    }
}
