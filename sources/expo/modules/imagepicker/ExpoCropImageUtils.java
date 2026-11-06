package expo.modules.imagepicker;

import android.content.res.Resources;
import android.util.TypedValue;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ExpoCropImageUtils {
    public static final ExpoCropImageUtils INSTANCE = new ExpoCropImageUtils();

    private ExpoCropImageUtils() {
    }

    public final Integer getThemeColor(Resources.Theme theme, int i) {
        Object objM5243constructorimpl;
        Intrinsics.checkNotNullParameter(theme, "theme");
        try {
            Result.Companion companion = Result.Companion;
            TypedValue typedValue = new TypedValue();
            objM5243constructorimpl = Result.m5243constructorimpl(theme.resolveAttribute(i, typedValue, true) ? Integer.valueOf(typedValue.data) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            objM5243constructorimpl = Result.m5243constructorimpl(ResultKt.createFailure(th));
        }
        return (Integer) (Result.m5248isFailureimpl(objM5243constructorimpl) ? null : objM5243constructorimpl);
    }

    public final Integer getColorResource(Resources resources, int i) {
        Object objM5243constructorimpl;
        Intrinsics.checkNotNullParameter(resources, "resources");
        try {
            Result.Companion companion = Result.Companion;
            objM5243constructorimpl = Result.m5243constructorimpl(Integer.valueOf(resources.getColor(i, null)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            objM5243constructorimpl = Result.m5243constructorimpl(ResultKt.createFailure(th));
        }
        return (Integer) (Result.m5248isFailureimpl(objM5243constructorimpl) ? null : objM5243constructorimpl);
    }
}
