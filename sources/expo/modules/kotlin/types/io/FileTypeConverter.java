package expo.modules.kotlin.types.io;

import com.facebook.react.bridge.Dynamic;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.exception.Exceptions$IllegalArgument;
import expo.modules.kotlin.jni.CppType;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.types.DynamicAwareTypeConverters;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class FileTypeConverter extends DynamicAwareTypeConverters {
    @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
    public boolean isTrivial() {
        return false;
    }

    @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
    public File convertFromDynamic(Dynamic value, AppContext appContext, boolean z) throws Exceptions$IllegalArgument {
        Intrinsics.checkNotNullParameter(value, "value");
        String strAsString = value.asString();
        if (strAsString == null) {
            throw new Exceptions$IllegalArgument("Cannot convert " + value.getType() + " to File", null, 2, null);
        }
        return new File(strAsString);
    }

    @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
    public File convertFromAny(Object value, AppContext appContext, boolean z) {
        Intrinsics.checkNotNullParameter(value, "value");
        return new File((String) value);
    }

    @Override // expo.modules.kotlin.types.TypeConverter
    public ExpectedType getCppRequiredTypes() {
        return new ExpectedType(CppType.STRING);
    }
}
