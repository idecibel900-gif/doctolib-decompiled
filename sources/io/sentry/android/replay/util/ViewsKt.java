package io.sentry.android.replay.util;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import io.sentry.ILogger;
import io.sentry.SentryMaskingOptions;
import io.sentry.android.replay.viewhierarchy.ComposeViewHierarchyNode;
import io.sentry.android.replay.viewhierarchy.ViewHierarchyNode;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ViewsKt {
    public static final int toOpaque(int i) {
        return i | (-16777216);
    }

    public static final void traverse(View view, ViewHierarchyNode parentNode, SentryMaskingOptions options, ILogger logger, List list) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(parentNode, "parentNode");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(logger, "logger");
        if ((view instanceof ViewGroup) && !ComposeViewHierarchyNode.INSTANCE.fromView(view, parentNode, options, logger)) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() == 0) {
                return;
            }
            ArrayList arrayList = new ArrayList(viewGroup.getChildCount());
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt != null) {
                    ViewHierarchyNode viewHierarchyNodeFromView = ViewHierarchyNode.Companion.fromView(childAt, parentNode, viewGroup.indexOfChild(childAt), options);
                    arrayList.add(viewHierarchyNodeFromView);
                    if (list != null && (viewHierarchyNodeFromView instanceof ViewHierarchyNode.SurfaceViewHierarchyNode) && viewHierarchyNodeFromView.isVisible()) {
                        list.add(viewHierarchyNodeFromView);
                    }
                    traverse(childAt, viewHierarchyNodeFromView, options, logger, list);
                }
            }
            parentNode.setChildren(arrayList);
        }
    }

    public static final Pair isVisibleToUser(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (view.isAttachedToWindow()) {
            if (view.getWindowVisibility() != 0) {
                return TuplesKt.to(Boolean.FALSE, null);
            }
            Object parent = view;
            while (parent instanceof View) {
                float transitionAlpha = Build.VERSION.SDK_INT >= 29 ? ((View) parent).getTransitionAlpha() : 1.0f;
                View view2 = (View) parent;
                if (view2.getAlpha() <= 0.0f || transitionAlpha <= 0.0f || view2.getVisibility() != 0) {
                    return TuplesKt.to(Boolean.FALSE, null);
                }
                parent = view2.getParent();
            }
            Rect rect = new Rect();
            return TuplesKt.to(Boolean.valueOf(view.getGlobalVisibleRect(rect, new Point())), rect);
        }
        return TuplesKt.to(Boolean.FALSE, null);
    }

    public static final boolean isMaskable(Drawable drawable) {
        if (drawable instanceof InsetDrawable ? true : drawable instanceof ColorDrawable ? true : drawable instanceof VectorDrawable ? true : drawable instanceof GradientDrawable) {
            return false;
        }
        if (!(drawable instanceof BitmapDrawable)) {
            return true;
        }
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        return bitmap != null && !bitmap.isRecycled() && bitmap.getHeight() > 10 && bitmap.getWidth() > 10;
    }

    public static final List getVisibleRects(TextLayout textLayout, Rect globalRect, int i, int i2) {
        Intrinsics.checkNotNullParameter(globalRect, "globalRect");
        if (textLayout == null) {
            return CollectionsKt.listOf(globalRect);
        }
        ArrayList arrayList = new ArrayList();
        int lineCount = textLayout.getLineCount();
        for (int i3 = 0; i3 < lineCount; i3++) {
            int lineLeft = (int) textLayout.getLineLeft(i3);
            int lineRight = (int) textLayout.getLineRight(i3);
            int lineTop = textLayout.getLineTop(i3);
            int lineBottom = textLayout.getLineBottom(i3);
            Rect rect = new Rect();
            rect.left = globalRect.left + i + lineLeft;
            rect.right = globalRect.left + i + lineRight;
            int i4 = globalRect.top + i2 + lineTop;
            rect.top = i4;
            rect.bottom = i4 + (lineBottom - lineTop);
            arrayList.add(rect);
        }
        return arrayList;
    }

    public static final int getTotalPaddingTopSafe(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        try {
            return textView.getTotalPaddingTop();
        } catch (NullPointerException unused) {
            return textView.getExtendedPaddingTop();
        }
    }

    public static final void addOnDrawListenerSafe(View view, ViewTreeObserver.OnDrawListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (view == null || view.getViewTreeObserver() == null || !view.getViewTreeObserver().isAlive()) {
            return;
        }
        try {
            view.getViewTreeObserver().addOnDrawListener(listener);
        } catch (IllegalStateException unused) {
        }
    }

    public static final void removeOnDrawListenerSafe(View view, ViewTreeObserver.OnDrawListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (view == null || view.getViewTreeObserver() == null || !view.getViewTreeObserver().isAlive()) {
            return;
        }
        try {
            view.getViewTreeObserver().removeOnDrawListener(listener);
        } catch (IllegalStateException unused) {
        }
    }

    public static final void addOnPreDrawListenerSafe(View view, ViewTreeObserver.OnPreDrawListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (view == null || view.getViewTreeObserver() == null || !view.getViewTreeObserver().isAlive()) {
            return;
        }
        try {
            view.getViewTreeObserver().addOnPreDrawListener(listener);
        } catch (IllegalStateException unused) {
        }
    }

    public static final void removeOnPreDrawListenerSafe(View view, ViewTreeObserver.OnPreDrawListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (view == null || view.getViewTreeObserver() == null || !view.getViewTreeObserver().isAlive()) {
            return;
        }
        try {
            view.getViewTreeObserver().removeOnPreDrawListener(listener);
        } catch (IllegalStateException unused) {
        }
    }

    public static final boolean hasSize(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return view.getWidth() > 0 && view.getHeight() > 0;
    }
}
