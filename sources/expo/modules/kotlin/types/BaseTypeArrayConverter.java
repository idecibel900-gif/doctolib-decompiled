package expo.modules.kotlin.types;

import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.jni.CppType;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.jni.JavaScriptTypedArray;
import expo.modules.kotlin.typedarray.TypedArray;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseTypeArrayConverter extends NonNullableTypeConverter {
    private final Function1 typedArrayWrapper;

    @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
    public boolean isTrivial() {
        return false;
    }

    public BaseTypeArrayConverter(Function1 typedArrayWrapper) {
        Intrinsics.checkNotNullParameter(typedArrayWrapper, "typedArrayWrapper");
        this.typedArrayWrapper = typedArrayWrapper;
    }

    @Override // expo.modules.kotlin.types.NonNullableTypeConverter
    public TypedArray convertNonNullable(Object value, AppContext appContext, boolean z) {
        Intrinsics.checkNotNullParameter(value, "value");
        return wrapJavaScriptTypedArray((JavaScriptTypedArray) value);
    }

    @Override // expo.modules.kotlin.types.TypeConverter
    public ExpectedType getCppRequiredTypes() {
        return new ExpectedType(CppType.TYPED_ARRAY);
    }

    public final TypedArray wrapJavaScriptTypedArray(JavaScriptTypedArray value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return (TypedArray) this.typedArrayWrapper.invoke(value);
    }
}
