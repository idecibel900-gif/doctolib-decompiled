package expo.modules.kotlin.types.net;

import com.facebook.react.bridge.Dynamic;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.jni.CppType;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.types.DynamicAwareTypeConverters;
import java.net.URI;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class JavaURITypeConverter extends DynamicAwareTypeConverters {
    @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
    public boolean isTrivial() {
        return false;
    }

    @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
    public URI convertFromDynamic(Dynamic value, AppContext appContext, boolean z) {
        Intrinsics.checkNotNullParameter(value, "value");
        URI uriCreate = URI.create(value.asString());
        Intrinsics.checkNotNullExpressionValue(uriCreate, "create(...)");
        return uriCreate;
    }

    @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
    public URI convertFromAny(Object value, AppContext appContext, boolean z) {
        Intrinsics.checkNotNullParameter(value, "value");
        URI uriCreate = URI.create((String) value);
        Intrinsics.checkNotNullExpressionValue(uriCreate, "create(...)");
        return uriCreate;
    }

    @Override // expo.modules.kotlin.types.TypeConverter
    public ExpectedType getCppRequiredTypes() {
        return new ExpectedType(CppType.STRING);
    }
}
