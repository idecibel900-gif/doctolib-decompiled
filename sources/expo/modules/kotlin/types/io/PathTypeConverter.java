package expo.modules.kotlin.types.io;

import com.facebook.react.bridge.Dynamic;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.jni.CppType;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.types.DynamicAwareTypeConverters;
import java.nio.file.Path;
import java.nio.file.Paths;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class PathTypeConverter extends DynamicAwareTypeConverters {
    @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
    public boolean isTrivial() {
        return false;
    }

    @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
    public Path convertFromDynamic(Dynamic value, AppContext appContext, boolean z) {
        Intrinsics.checkNotNullParameter(value, "value");
        Path path = Paths.get(value.asString(), new String[0]);
        Intrinsics.checkNotNullExpressionValue(path, "get(...)");
        return path;
    }

    @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
    public Path convertFromAny(Object value, AppContext appContext, boolean z) {
        Intrinsics.checkNotNullParameter(value, "value");
        Path path = Paths.get((String) value, new String[0]);
        Intrinsics.checkNotNullExpressionValue(path, "get(...)");
        return path;
    }

    @Override // expo.modules.kotlin.types.TypeConverter
    public ExpectedType getCppRequiredTypes() {
        return new ExpectedType(CppType.STRING);
    }
}
