package expo.modules.kotlin.types;

import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.jni.CppType;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.jni.JavaScriptFunction;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

/* JADX INFO: loaded from: classes4.dex */
public final class JavaScriptFunctionTypeConverter extends NonNullableTypeConverter {
    private final KType type;

    @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
    public boolean isTrivial() {
        return false;
    }

    public JavaScriptFunctionTypeConverter(KType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
    }

    @Override // expo.modules.kotlin.types.NonNullableTypeConverter
    public JavaScriptFunction convertNonNullable(Object value, AppContext appContext, boolean z) {
        Intrinsics.checkNotNullParameter(value, "value");
        JavaScriptFunction javaScriptFunction = (JavaScriptFunction) value;
        KType type = ((KTypeProjection) CollectionsKt.first(this.type.getArguments())).getType();
        if (type == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        javaScriptFunction.setReturnType(type);
        return javaScriptFunction;
    }

    @Override // expo.modules.kotlin.types.TypeConverter
    public ExpectedType getCppRequiredTypes() {
        return new ExpectedType(CppType.JS_FUNCTION);
    }
}
