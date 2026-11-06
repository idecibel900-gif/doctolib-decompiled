package expo.modules.kotlin.types;

import com.facebook.react.bridge.Dynamic;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.jni.ExpectedType;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;

/* JADX INFO: loaded from: classes4.dex */
public final class AnyType {
    private final Lazy converter$delegate;
    private final TypeConverterProvider converterProvider;
    private final KType kType;

    public AnyType(KType kType, TypeConverterProvider typeConverterProvider) {
        Intrinsics.checkNotNullParameter(kType, "kType");
        this.kType = kType;
        this.converterProvider = typeConverterProvider;
        this.converter$delegate = LazyKt.lazy(new Function0() { // from class: expo.modules.kotlin.types.AnyType$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AnyType.converter_delegate$lambda$0(this.f$0);
            }
        });
    }

    public /* synthetic */ AnyType(KType kType, TypeConverterProvider typeConverterProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(kType, (i & 2) != 0 ? null : typeConverterProvider);
    }

    public final KType getKType() {
        return this.kType;
    }

    private final TypeConverter getConverter() {
        return (TypeConverter) this.converter$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TypeConverter converter_delegate$lambda$0(AnyType anyType) {
        TypeConverter typeConverterObtainTypeConverter;
        TypeConverterProvider typeConverterProvider = anyType.converterProvider;
        return (typeConverterProvider == null || (typeConverterObtainTypeConverter = typeConverterProvider.obtainTypeConverter(anyType.kType)) == null) ? TypeConverterProviderImpl.INSTANCE.obtainTypeConverter(anyType.kType) : typeConverterObtainTypeConverter;
    }

    public static /* synthetic */ Object convert$default(AnyType anyType, Object obj, AppContext appContext, boolean z, int i, Object obj2) {
        if ((i & 2) != 0) {
            appContext = null;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        return anyType.convert(obj, appContext, z);
    }

    public final Object convert(Object obj, AppContext appContext, boolean z) {
        return (z || !getConverter().isTrivial() || (obj instanceof Dynamic)) ? getConverter().convert(obj, appContext, z) : obj;
    }

    public final ExpectedType getCppRequiredTypes() {
        return getConverter().getCppRequiredTypes();
    }
}
