package expo.modules.kotlin.edgeToEdge;

import android.R;
import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Build;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class EdgeToEdgePackageKt {
    private static final boolean getEnforceContrastFromTheme(Activity activity) {
        TypedArray typedArrayObtainStyledAttributes = activity.getTheme().obtainStyledAttributes(new int[]{R.attr.enforceNavigationBarContrast});
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        try {
            return typedArrayObtainStyledAttributes.getBoolean(0, true);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enforceNavigationBarContrastFromTheme(Activity activity) {
        if (Build.VERSION.SDK_INT >= 29) {
            activity.getWindow().setNavigationBarContrastEnforced(getEnforceContrastFromTheme(activity));
        }
    }
}
