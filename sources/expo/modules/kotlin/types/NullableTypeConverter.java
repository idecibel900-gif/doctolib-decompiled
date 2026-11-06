package expo.modules.kotlin.types;

import com.facebook.react.bridge.Dynamic;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.jni.CppType;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.jni.SingleType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class NullableTypeConverter implements TypeConverter {
    private final TypeConverter innerConverter;

    public NullableTypeConverter(TypeConverter innerConverter) {
        Intrinsics.checkNotNullParameter(innerConverter, "innerConverter");
        this.innerConverter = innerConverter;
    }

    @Override // expo.modules.kotlin.types.TypeConverter
    public Object convert(Object obj, AppContext appContext, boolean z) {
        if (obj == null) {
            return null;
        }
        boolean z2 = obj instanceof Dynamic;
        if (z2 && ((Dynamic) obj).isNull()) {
            return null;
        }
        return (!this.innerConverter.isTrivial() || z || z2) ? this.innerConverter.convert(obj, appContext, z) : obj;
    }

    @Override // expo.modules.kotlin.types.TypeConverter
    public boolean isTrivial() {
        return this.innerConverter.isTrivial();
    }

    @Override // expo.modules.kotlin.types.TypeConverter
    public ExpectedType getCppRequiredTypes() {
        return new ExpectedType(new SingleType(CppType.NULLABLE, new ExpectedType[]{this.innerConverter.getCppRequiredTypes()}));
    }
}
