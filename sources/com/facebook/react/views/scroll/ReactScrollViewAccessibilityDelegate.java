package com.facebook.react.views.scroll;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.facebook.react.R$id;
import com.facebook.react.bridge.AssertionException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ReactAccessibilityDelegate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ReactScrollViewAccessibilityDelegate extends AccessibilityDelegateCompat {
    private final String TAG;

    public ReactScrollViewAccessibilityDelegate() {
        String simpleName = ReactScrollViewAccessibilityDelegate.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        this.TAG = simpleName;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(event, "event");
        super.onInitializeAccessibilityEvent(host, event);
        if (host instanceof ReactAccessibleScrollView) {
            onInitializeAccessibilityEventInternal(host, event);
            return;
        }
        ReactSoftExceptionLogger.logSoftException(this.TAG, new AssertionException("ReactScrollViewAccessibilityDelegate should only be used with ReactAccessibleScrollView, not with class: " + host.getClass().getSimpleName()));
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(info, "info");
        super.onInitializeAccessibilityNodeInfo(host, info);
        if (host instanceof ReactAccessibleScrollView) {
            onInitializeAccessibilityNodeInfoInternal(host, info);
            return;
        }
        ReactSoftExceptionLogger.logSoftException(this.TAG, new AssertionException("ReactScrollViewAccessibilityDelegate should only be used with ReactAccessibleScrollView, not with class: " + host.getClass().getSimpleName()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void onInitializeAccessibilityEventInternal(View view, AccessibilityEvent accessibilityEvent) {
        Object tag = view.getTag(R$id.accessibility_collection);
        Integer numValueOf = null;
        ReadableMap readableMap = tag instanceof ReadableMap ? (ReadableMap) tag : null;
        if (readableMap == null) {
            return;
        }
        accessibilityEvent.setItemCount(readableMap.getInt("itemCount"));
        ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
        View childAt = viewGroup != null ? viewGroup.getChildAt(0) : null;
        ViewGroup viewGroup2 = childAt instanceof ViewGroup ? (ViewGroup) childAt : null;
        if (viewGroup2 == null) {
            return;
        }
        int childCount = viewGroup2.getChildCount();
        Integer numValueOf2 = null;
        for (int i = 0; i < childCount; i++) {
            View childAt2 = viewGroup2.getChildAt(i);
            if (!(view instanceof ReactAccessibleScrollView)) {
                return;
            }
            Intrinsics.checkNotNull(childAt2);
            boolean zIsPartiallyScrolledInView = ((ReactAccessibleScrollView) view).isPartiallyScrolledInView(childAt2);
            Object tag2 = childAt2.getTag(R$id.accessibility_collection_item);
            Intrinsics.checkNotNull(tag2, "null cannot be cast to non-null type com.facebook.react.bridge.ReadableMap");
            ReadableMap readableMap2 = (ReadableMap) tag2;
            if (!(childAt2 instanceof ViewGroup)) {
                return;
            }
            ((ViewGroup) childAt2).getChildCount();
            if (zIsPartiallyScrolledInView) {
                if (numValueOf == null) {
                    numValueOf = Integer.valueOf(readableMap2.getInt("itemIndex"));
                }
                numValueOf2 = Integer.valueOf(readableMap2.getInt("itemIndex"));
            }
            if (numValueOf != null && numValueOf2 != null) {
                accessibilityEvent.setFromIndex(numValueOf.intValue());
                accessibilityEvent.setToIndex(numValueOf2.intValue());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void onInitializeAccessibilityNodeInfoInternal(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ReactAccessibilityDelegate.AccessibilityRole accessibilityRoleFromViewTag = ReactAccessibilityDelegate.AccessibilityRole.Companion.fromViewTag(view);
        if (accessibilityRoleFromViewTag != null) {
            ReactAccessibilityDelegate.Companion companion = ReactAccessibilityDelegate.Companion;
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            companion.setRole(accessibilityNodeInfoCompat, accessibilityRoleFromViewTag, context);
        }
        Object tag = view.getTag(R$id.accessibility_collection);
        ReadableMap readableMap = tag instanceof ReadableMap ? (ReadableMap) tag : null;
        if (readableMap != null) {
            accessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(readableMap.getInt("rowCount"), readableMap.getInt("columnCount"), readableMap.getBoolean("hierarchical")));
        }
        if (view instanceof ReactAccessibleScrollView) {
            accessibilityNodeInfoCompat.setScrollable(((ReactAccessibleScrollView) view).getScrollEnabled());
        }
    }
}
