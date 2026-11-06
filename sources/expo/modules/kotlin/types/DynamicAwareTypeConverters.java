package expo.modules.kotlin.types;

import com.facebook.react.bridge.Dynamic;
import expo.modules.kotlin.AppContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class DynamicAwareTypeConverters extends NonNullableTypeConverter {
    public abstract Object convertFromAny(Object obj, AppContext appContext, boolean z);

    public abstract Object convertFromDynamic(Dynamic dynamic, AppContext appContext, boolean z);

    @Override // expo.modules.kotlin.types.NonNullableTypeConverter
    public Object convertNonNullable(Object value, AppContext appContext, boolean z) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (value instanceof Dynamic) {
            return convertFromDynamic((Dynamic) value, appContext, z);
        }
        return convertFromAny(value, appContext, z);
    }
}
