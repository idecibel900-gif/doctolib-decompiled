package androidx.window.layout.util;

import android.app.Activity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivityCompatHelperApi24 {
    public static final ActivityCompatHelperApi24 INSTANCE = new ActivityCompatHelperApi24();

    private ActivityCompatHelperApi24() {
    }

    public final boolean isInMultiWindowMode(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return activity.isInMultiWindowMode();
    }
}
