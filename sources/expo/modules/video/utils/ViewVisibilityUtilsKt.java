package expo.modules.video.utils;

import android.graphics.Rect;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ViewVisibilityUtilsKt {
    public static final boolean isVisibleOnScreen(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return view.getGlobalVisibleRect(new Rect());
    }

    public static final float visiblePercentage(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Rect rect = new Rect();
        if (!view.getGlobalVisibleRect(rect)) {
            return 0.0f;
        }
        int iHeight = rect.height() * rect.width();
        int height = view.getHeight() * view.getWidth();
        if (height == 0) {
            return 0.0f;
        }
        return (iHeight * 100.0f) / height;
    }
}
