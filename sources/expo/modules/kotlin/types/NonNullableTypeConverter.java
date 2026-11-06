package expo.modules.kotlin.types;

import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.exception.NullArgumentException;

/* JADX INFO: loaded from: classes4.dex */
public abstract class NonNullableTypeConverter implements TypeConverter {
    public abstract Object convertNonNullable(Object obj, AppContext appContext, boolean z);

    @Override // expo.modules.kotlin.types.TypeConverter
    public boolean isTrivial() {
        return TypeConverter.DefaultImpls.isTrivial(this);
    }

    @Override // expo.modules.kotlin.types.TypeConverter
    public Object convert(Object obj, AppContext appContext, boolean z) throws NullArgumentException {
        if (obj != null) {
            return convertNonNullable(obj, appContext, z);
        }
        throw new NullArgumentException();
    }
}
