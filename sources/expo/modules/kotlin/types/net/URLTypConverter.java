package expo.modules.kotlin.types.net;

import com.facebook.react.bridge.Dynamic;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.jni.CppType;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.types.DynamicAwareTypeConverters;
import java.net.URL;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class URLTypConverter extends DynamicAwareTypeConverters {
    @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
    public boolean isTrivial() {
        return false;
    }

    @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
    public URL convertFromDynamic(Dynamic value, AppContext appContext, boolean z) {
        Intrinsics.checkNotNullParameter(value, "value");
        return new URL(value.asString());
    }

    @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
    public URL convertFromAny(Object value, AppContext appContext, boolean z) {
        Intrinsics.checkNotNullParameter(value, "value");
        return new URL((String) value);
    }

    @Override // expo.modules.kotlin.types.TypeConverter
    public ExpectedType getCppRequiredTypes() {
        return new ExpectedType(CppType.STRING);
    }
}
