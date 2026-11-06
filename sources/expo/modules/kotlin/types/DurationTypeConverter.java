package expo.modules.kotlin.types;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableType;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.jni.CppType;
import expo.modules.kotlin.jni.ExpectedType;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: loaded from: classes4.dex */
public final class DurationTypeConverter extends DynamicAwareTypeConverters {
    @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
    public boolean isTrivial() {
        return false;
    }

    @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
    public /* bridge */ /* synthetic */ Object convertFromAny(Object obj, AppContext appContext, boolean z) {
        return Duration.m5399boximpl(m4939convertFromAnyZBGTal8(obj, appContext, z));
    }

    @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
    public /* bridge */ /* synthetic */ Object convertFromDynamic(Dynamic dynamic, AppContext appContext, boolean z) {
        return Duration.m5399boximpl(m4940convertFromDynamicZBGTal8(dynamic, appContext, z));
    }

    /* JADX INFO: renamed from: convertFromDynamic-ZBGTal8, reason: not valid java name */
    public long m4940convertFromDynamicZBGTal8(Dynamic value, AppContext appContext, boolean z) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (value.getType() != ReadableType.Number) {
            throw new IllegalArgumentException("Expected a number, but received " + value.getType());
        }
        return DurationKt.toDuration(value.asDouble(), DurationUnit.SECONDS);
    }

    /* JADX INFO: renamed from: convertFromAny-ZBGTal8, reason: not valid java name */
    public long m4939convertFromAnyZBGTal8(Object value, AppContext appContext, boolean z) {
        Intrinsics.checkNotNullParameter(value, "value");
        return DurationKt.toDuration(((Double) value).doubleValue(), DurationUnit.SECONDS);
    }

    @Override // expo.modules.kotlin.types.TypeConverter
    public ExpectedType getCppRequiredTypes() {
        return new ExpectedType(CppType.DOUBLE);
    }
}
