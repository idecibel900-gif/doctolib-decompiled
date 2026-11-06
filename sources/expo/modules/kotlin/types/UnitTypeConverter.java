package expo.modules.kotlin.types;

import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.jni.CppType;
import expo.modules.kotlin.jni.ExpectedType;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class UnitTypeConverter extends NonNullableTypeConverter {
    /* JADX INFO: renamed from: convertNonNullable, reason: collision with other method in class */
    public void m4941convertNonNullable(Object value, AppContext appContext, boolean z) {
        Intrinsics.checkNotNullParameter(value, "value");
    }

    @Override // expo.modules.kotlin.types.NonNullableTypeConverter
    public /* bridge */ /* synthetic */ Object convertNonNullable(Object obj, AppContext appContext, boolean z) {
        m4941convertNonNullable(obj, appContext, z);
        return Unit.INSTANCE;
    }

    @Override // expo.modules.kotlin.types.TypeConverter
    public ExpectedType getCppRequiredTypes() {
        return new ExpectedType(CppType.ANY);
    }
}
