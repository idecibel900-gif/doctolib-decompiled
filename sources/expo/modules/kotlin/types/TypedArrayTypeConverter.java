package expo.modules.kotlin.types;

import expo.modules.kotlin.jni.JavaScriptTypedArray;
import expo.modules.kotlin.typedarray.TypedArray;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class TypedArrayTypeConverter extends BaseTypeArrayConverter {
    /* JADX INFO: Access modifiers changed from: private */
    public static final TypedArray _init_$lambda$0(JavaScriptTypedArray it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it;
    }

    @Override // expo.modules.kotlin.types.BaseTypeArrayConverter, expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
    public boolean isTrivial() {
        return true;
    }

    public TypedArrayTypeConverter() {
        super(new Function1() { // from class: expo.modules.kotlin.types.TypedArrayTypeConverter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TypedArrayTypeConverter._init_$lambda$0((JavaScriptTypedArray) obj);
            }
        });
    }
}
