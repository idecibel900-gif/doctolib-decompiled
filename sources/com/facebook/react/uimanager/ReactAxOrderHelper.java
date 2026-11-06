package com.facebook.react.uimanager;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.R$id;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ReactAxOrderHelper {
    public static final ReactAxOrderHelper INSTANCE = new ReactAxOrderHelper();

    private ReactAxOrderHelper() {
    }

    public static final void cleanUpAxOrder(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Boolean bool = (Boolean) view.getTag(R$id.original_focusability);
        if (bool != null) {
            view.setFocusable(bool.booleanValue());
        }
        if (((View) view.getTag(R$id.accessibility_order_parent)) != null) {
            view.setTag(R$id.accessibility_order_parent, null);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(...)");
                cleanUpAxOrder(childAt);
            }
        }
    }

    public static final void restoreFocusability(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Boolean bool = (Boolean) view.getTag(R$id.original_focusability);
        if (bool != null) {
            view.setFocusable(bool.booleanValue());
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(...)");
                restoreFocusability(childAt);
            }
        }
    }

    public final void disableFocusForSubtree(View view, List axOrderList) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(axOrderList, "axOrderList");
        if (!CollectionsKt.contains(axOrderList, view.getTag(R$id.view_tag_native_id))) {
            if (view.getTag(R$id.original_focusability) == null) {
                view.setTag(R$id.original_focusability, Boolean.valueOf(view.isFocusable()));
            }
            view.setFocusable(false);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(...)");
                disableFocusForSubtree(childAt, axOrderList);
            }
        }
    }

    public final void buildAxOrderList(View view, View parent, List axOrderList, View[] result) {
        int iIndexOf;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(axOrderList, "axOrderList");
        Intrinsics.checkNotNullParameter(result, "result");
        Object tag = view.getTag(R$id.view_tag_native_id);
        view.setTag(R$id.accessibility_order_parent, parent);
        if (CollectionsKt.contains(axOrderList, tag) && (iIndexOf = CollectionsKt.indexOf(axOrderList, tag)) != -1) {
            result[iIndexOf] = view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(...)");
                buildAxOrderList(childAt, parent, axOrderList, result);
            }
        }
    }
}
