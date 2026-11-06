package expo.modules.kotlin.types.worklets;

import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.jni.worklets.Serializable;
import expo.modules.kotlin.jni.worklets.Worklet;
import expo.modules.kotlin.types.NonNullableTypeConverter;
import expo.modules.kotlin.types.TypeConverter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class WorkletTypeConverter extends NonNullableTypeConverter {
    private final TypeConverter serializableTypeConverter;

    @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
    public boolean isTrivial() {
        return false;
    }

    public WorkletTypeConverter(TypeConverter serializableTypeConverter) {
        Intrinsics.checkNotNullParameter(serializableTypeConverter, "serializableTypeConverter");
        this.serializableTypeConverter = serializableTypeConverter;
    }

    @Override // expo.modules.kotlin.types.NonNullableTypeConverter
    public Worklet convertNonNullable(Object value, AppContext appContext, boolean z) {
        Intrinsics.checkNotNullParameter(value, "value");
        Serializable serializable = (Serializable) this.serializableTypeConverter.convert(value, appContext, z);
        if (serializable == null) {
            throw new IllegalArgumentException("Cannot convert '" + value + "' to Serializable.");
        }
        if (serializable.getType() != Serializable.ValueType.Worklet) {
            throw new IllegalArgumentException("Expected Serializable of type Worklet but got " + serializable.getType() + ".");
        }
        return new Worklet(serializable);
    }

    @Override // expo.modules.kotlin.types.TypeConverter
    public ExpectedType getCppRequiredTypes() {
        return this.serializableTypeConverter.getCppRequiredTypes();
    }
}
