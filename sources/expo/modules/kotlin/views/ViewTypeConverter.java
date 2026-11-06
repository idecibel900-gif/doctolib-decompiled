package expo.modules.kotlin.views;

import android.view.View;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.Exceptions$AppContextLost;
import expo.modules.kotlin.jni.CppType;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.types.NonNullableTypeConverter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;

/* JADX INFO: loaded from: classes4.dex */
public final class ViewTypeConverter extends NonNullableTypeConverter {
    private final KType type;

    @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
    public boolean isTrivial() {
        return false;
    }

    public ViewTypeConverter(KType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
    }

    @Override // expo.modules.kotlin.types.NonNullableTypeConverter
    public View convertNonNullable(Object value, AppContext appContext, boolean z) throws CodedException {
        Intrinsics.checkNotNullParameter(value, "value");
        if (appContext != null) {
            appContext.assertMainThread$expo_modules_core_release();
            final int iIntValue = ((Integer) value).intValue();
            View viewFindView = appContext.findView(iIntValue);
            if (viewFindView != null) {
                return viewFindView;
            }
            KClassifier classifier = this.type.getClassifier();
            Intrinsics.checkNotNull(classifier, "null cannot be cast to non-null type kotlin.reflect.KClass<*>");
            final KClass kClass = (KClass) classifier;
            throw new CodedException(kClass, iIntValue) { // from class: expo.modules.kotlin.exception.Exceptions$ViewNotFound
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super("Unable to find the " + kClass + " view with tag " + iIntValue, null, 2, null);
                    Intrinsics.checkNotNullParameter(kClass, "viewType");
                }
            };
        }
        throw new Exceptions$AppContextLost();
    }

    @Override // expo.modules.kotlin.types.TypeConverter
    public ExpectedType getCppRequiredTypes() {
        return new ExpectedType(CppType.INT, CppType.VIEW_TAG);
    }
}
