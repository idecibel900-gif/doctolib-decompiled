package expo.modules.kotlin.types.net;

import android.net.Uri;
import com.facebook.react.bridge.Dynamic;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.exception.DynamicCastException;
import expo.modules.kotlin.jni.CppType;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.types.DynamicAwareTypeConverters;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes4.dex */
public final class UriTypeConverter extends DynamicAwareTypeConverters {
    @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
    public boolean isTrivial() {
        return false;
    }

    @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
    public Uri convertFromDynamic(Dynamic value, AppContext appContext, boolean z) throws DynamicCastException {
        Uri uri;
        Intrinsics.checkNotNullParameter(value, "value");
        String strAsString = value.asString();
        if (strAsString == null || (uri = Uri.parse(strAsString)) == null) {
            throw new DynamicCastException(Reflection.getOrCreateKotlinClass(Uri.class));
        }
        return uri;
    }

    @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
    public Uri convertFromAny(Object value, AppContext appContext, boolean z) {
        Intrinsics.checkNotNullParameter(value, "value");
        return Uri.parse((String) value);
    }

    @Override // expo.modules.kotlin.types.TypeConverter
    public ExpectedType getCppRequiredTypes() {
        return new ExpectedType(CppType.STRING);
    }
}
