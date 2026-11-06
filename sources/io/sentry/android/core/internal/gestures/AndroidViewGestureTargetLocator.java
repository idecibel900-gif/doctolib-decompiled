package io.sentry.android.core.internal.gestures;

import android.content.res.Resources;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ScrollView;
import androidx.core.view.ScrollingView;
import io.sentry.android.core.internal.util.ClassUtil;
import io.sentry.internal.gestures.GestureTargetLocator;
import io.sentry.internal.gestures.UiElement;
import io.sentry.util.LazyEvaluator;

/* JADX INFO: loaded from: classes5.dex */
public final class AndroidViewGestureTargetLocator implements GestureTargetLocator {
    private final LazyEvaluator isAndroidXAvailable;

    public AndroidViewGestureTargetLocator(LazyEvaluator lazyEvaluator) {
        this.isAndroidXAvailable = lazyEvaluator;
    }

    @Override // io.sentry.internal.gestures.GestureTargetLocator
    public UiElement locate(Object obj, float f, float f2, UiElement.Type type) {
        if (!(obj instanceof View)) {
            return null;
        }
        View view = (View) obj;
        if (type == UiElement.Type.CLICKABLE && isViewTappable(view)) {
            return createUiElement(view);
        }
        if (type == UiElement.Type.SCROLLABLE && isViewScrollable(view, ((Boolean) this.isAndroidXAvailable.getValue()).booleanValue())) {
            return createUiElement(view);
        }
        return null;
    }

    private UiElement createUiElement(View view) {
        try {
            return new UiElement(view, ClassUtil.getClassName(view), ViewUtils.getResourceId(view), null, "old_view_system");
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }

    private static boolean isViewTappable(View view) {
        return view.isClickable() && view.getVisibility() == 0;
    }

    private static boolean isViewScrollable(View view, boolean z) {
        return (isJetpackScrollingView(view, z) || AbsListView.class.isAssignableFrom(view.getClass()) || ScrollView.class.isAssignableFrom(view.getClass())) && view.getVisibility() == 0;
    }

    private static boolean isJetpackScrollingView(View view, boolean z) {
        if (z) {
            return ScrollingView.class.isAssignableFrom(view.getClass());
        }
        return false;
    }
}
