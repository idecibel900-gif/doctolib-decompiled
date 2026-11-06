package com.facebook.react.views.text;

import android.graphics.Rect;
import android.os.Bundle;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.facebook.react.R$id;
import com.facebook.react.R$string;
import com.facebook.react.uimanager.ReactAccessibilityDelegate;
import com.facebook.react.views.text.internal.span.ReactClickableSpan;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ReactTextViewAccessibilityDelegate extends ReactAccessibilityDelegate {
    public static final Companion Companion = new Companion(null);
    private AccessibilityLinks accessibilityLinks;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactTextViewAccessibilityDelegate(View view, boolean z, int i) {
        super(view, z, i);
        Intrinsics.checkNotNullParameter(view, "view");
        this.accessibilityLinks = (AccessibilityLinks) getHostView().getTag(R$id.accessibility_links);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void setDelegate(View view, boolean z, int i) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (ViewCompat.hasAccessibilityDelegate(view)) {
                return;
            }
            if (view.getTag(R$id.accessibility_role) == null && view.getTag(R$id.accessibility_state) == null && view.getTag(R$id.accessibility_actions) == null && view.getTag(R$id.react_test_id) == null && view.getTag(R$id.accessibility_collection_item) == null && view.getTag(R$id.accessibility_links) == null && view.getTag(R$id.role) == null) {
                return;
            }
            ViewCompat.setAccessibilityDelegate(view, new ReactTextViewAccessibilityDelegate(view, z, i));
        }

        public final void resetDelegate(View view, boolean z, int i) {
            Intrinsics.checkNotNullParameter(view, "view");
            ViewCompat.setAccessibilityDelegate(view, new ReactTextViewAccessibilityDelegate(view, z, i));
        }
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    protected void onVirtualViewKeyboardFocusChanged(int i, boolean z) {
        AccessibilityLinks.AccessibleLink linkById;
        ClickableSpan clickableSpan;
        AccessibilityLinks accessibilityLinks = this.accessibilityLinks;
        if (accessibilityLinks == null || accessibilityLinks == null || (linkById = accessibilityLinks.getLinkById(i)) == null || (clickableSpan = (ClickableSpan) getFirstSpan(linkById.getStart(), linkById.getEnd(), ClickableSpan.class)) == null) {
            return;
        }
        if ((clickableSpan instanceof ReactClickableSpan) && (getHostView() instanceof TextView)) {
            ReactClickableSpan reactClickableSpan = (ReactClickableSpan) clickableSpan;
            reactClickableSpan.setKeyboardFocused(z);
            View hostView = getHostView();
            Intrinsics.checkNotNull(hostView, "null cannot be cast to non-null type android.widget.TextView");
            reactClickableSpan.setFocusBgColor(((TextView) hostView).getHighlightColor());
            getHostView().invalidate();
            return;
        }
        if (getHostView() instanceof PreparedLayoutTextView) {
            if (z) {
                View hostView2 = getHostView();
                Intrinsics.checkNotNull(hostView2, "null cannot be cast to non-null type com.facebook.react.views.text.PreparedLayoutTextView");
                ((PreparedLayoutTextView) hostView2).setSelection(linkById.getStart(), linkById.getEnd());
            } else {
                View hostView3 = getHostView();
                Intrinsics.checkNotNull(hostView3, "null cannot be cast to non-null type com.facebook.react.views.text.PreparedLayoutTextView");
                ((PreparedLayoutTextView) hostView3).clearSelection();
            }
        }
    }

    @Override // com.facebook.react.uimanager.ReactAccessibilityDelegate, androidx.customview.widget.ExploreByTouchHelper
    protected boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle) {
        AccessibilityLinks.AccessibleLink linkById;
        ClickableSpan clickableSpan;
        AccessibilityLinks accessibilityLinks = this.accessibilityLinks;
        if (accessibilityLinks == null || accessibilityLinks == null || (linkById = accessibilityLinks.getLinkById(i)) == null || (clickableSpan = (ClickableSpan) getFirstSpan(linkById.getStart(), linkById.getEnd(), ClickableSpan.class)) == null || i2 != 16) {
            return false;
        }
        clickableSpan.onClick(getHostView());
        return true;
    }

    @Override // com.facebook.react.uimanager.ReactAccessibilityDelegate, androidx.customview.widget.ExploreByTouchHelper
    protected void getVisibleVirtualViews(List virtualViewIds) {
        Intrinsics.checkNotNullParameter(virtualViewIds, "virtualViewIds");
        AccessibilityLinks accessibilityLinks = this.accessibilityLinks;
        if (accessibilityLinks == null) {
            return;
        }
        int size = accessibilityLinks.size();
        for (int i = 0; i < size; i++) {
            virtualViewIds.add(Integer.valueOf(i));
        }
    }

    @Override // com.facebook.react.uimanager.ReactAccessibilityDelegate, androidx.customview.widget.ExploreByTouchHelper
    protected int getVirtualViewAt(float f, float f2) {
        Spanned spannedFromHost;
        AccessibilityLinks.AccessibleLink linkBySpanPos;
        AccessibilityLinks accessibilityLinks = this.accessibilityLinks;
        if (accessibilityLinks != null && accessibilityLinks.size() != 0 && ((getHostView() instanceof TextView) || (getHostView() instanceof PreparedLayoutTextView))) {
            float paddingLeft = f - getHostView().getPaddingLeft();
            float paddingTop = f2 - getHostView().getPaddingTop();
            float scrollX = paddingLeft + getHostView().getScrollX();
            float scrollY = paddingTop + getHostView().getScrollY();
            Layout layoutFromHost = getLayoutFromHost();
            if (layoutFromHost == null) {
                return LinearLayoutManager.INVALID_OFFSET;
            }
            int offsetForHorizontal = layoutFromHost.getOffsetForHorizontal(layoutFromHost.getLineForVertical((int) scrollY), scrollX);
            ClickableSpan clickableSpan = (ClickableSpan) getFirstSpan(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
            if (clickableSpan != null && (spannedFromHost = getSpannedFromHost()) != null && (linkBySpanPos = accessibilityLinks.getLinkBySpanPos(spannedFromHost.getSpanStart(clickableSpan), spannedFromHost.getSpanEnd(clickableSpan))) != null) {
                return linkBySpanPos.getId();
            }
        }
        return LinearLayoutManager.INVALID_OFFSET;
    }

    private final Layout getLayoutFromHost() {
        if (getHostView() instanceof PreparedLayoutTextView) {
            View hostView = getHostView();
            Intrinsics.checkNotNull(hostView, "null cannot be cast to non-null type com.facebook.react.views.text.PreparedLayoutTextView");
            PreparedLayout preparedLayout = ((PreparedLayoutTextView) hostView).getPreparedLayout();
            if (preparedLayout != null) {
                return preparedLayout.getLayout();
            }
            return null;
        }
        if (!(getHostView() instanceof TextView)) {
            return null;
        }
        View hostView2 = getHostView();
        Intrinsics.checkNotNull(hostView2, "null cannot be cast to non-null type android.widget.TextView");
        return ((TextView) hostView2).getLayout();
    }

    protected final Object getFirstSpan(int i, int i2, Class cls) {
        Spanned spannedFromHost = getSpannedFromHost();
        if (spannedFromHost == null) {
            return null;
        }
        Object[] spans = spannedFromHost.getSpans(i, i2, cls);
        Intrinsics.checkNotNull(spans);
        if (spans.length == 0) {
            return null;
        }
        return spans[0];
    }

    private final Spanned getSpannedFromHost() {
        Layout layout;
        View hostView = getHostView();
        if (hostView instanceof PreparedLayoutTextView) {
            PreparedLayout preparedLayout = ((PreparedLayoutTextView) hostView).getPreparedLayout();
            CharSequence text = (preparedLayout == null || (layout = preparedLayout.getLayout()) == null) ? null : layout.getText();
            if (text instanceof Spanned) {
                return (Spanned) text;
            }
            return null;
        }
        if (hostView instanceof TextView) {
            CharSequence text2 = ((TextView) hostView).getText();
            if (text2 instanceof Spanned) {
                return (Spanned) text2;
            }
        }
        return null;
    }

    @Override // com.facebook.react.uimanager.ReactAccessibilityDelegate, androidx.customview.widget.ExploreByTouchHelper, androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(info, "info");
        super.onInitializeAccessibilityNodeInfo(host, info);
        if (host instanceof PreparedLayoutTextView) {
            info.setText(((PreparedLayoutTextView) host).getText());
        }
    }

    @Override // com.facebook.react.uimanager.ReactAccessibilityDelegate, androidx.customview.widget.ExploreByTouchHelper
    protected void onPopulateNodeForVirtualView(int i, AccessibilityNodeInfoCompat node) {
        Intrinsics.checkNotNullParameter(node, "node");
        AccessibilityLinks accessibilityLinks = this.accessibilityLinks;
        if (accessibilityLinks == null) {
            node.setContentDescription("");
            node.setBoundsInParent(new Rect(0, 0, 1, 1));
            return;
        }
        AccessibilityLinks.AccessibleLink linkById = accessibilityLinks.getLinkById(i);
        if (linkById == null) {
            node.setContentDescription("");
            node.setBoundsInParent(new Rect(0, 0, 1, 1));
            return;
        }
        Rect boundsInParent = getBoundsInParent(linkById);
        if (boundsInParent == null) {
            node.setContentDescription("");
            node.setBoundsInParent(new Rect(0, 0, 1, 1));
            return;
        }
        node.setContentDescription(linkById.getDescription());
        node.addAction(16);
        node.setBoundsInParent(boundsInParent);
        node.setRoleDescription(getHostView().getResources().getString(R$string.link_description));
        node.setClassName(ReactAccessibilityDelegate.AccessibilityRole.Companion.getValue(ReactAccessibilityDelegate.AccessibilityRole.BUTTON));
    }

    private final Rect getBoundsInParent(AccessibilityLinks.AccessibleLink accessibleLink) {
        if (!(getHostView() instanceof TextView) && !(getHostView() instanceof PreparedLayoutTextView)) {
            return new Rect(0, 0, getHostView().getWidth(), getHostView().getHeight());
        }
        Layout layoutFromHost = getLayoutFromHost();
        if (layoutFromHost == null) {
            return new Rect(0, 0, getHostView().getWidth(), getHostView().getHeight());
        }
        int start = accessibleLink.getStart();
        int end = accessibleLink.getEnd();
        int lineForOffset = layoutFromHost.getLineForOffset(start);
        int lineEnd = layoutFromHost.getLineEnd(lineForOffset);
        int lineForOffset2 = layoutFromHost.getLineForOffset(end);
        int lineEnd2 = layoutFromHost.getLineEnd(lineForOffset2);
        if (start > lineEnd || end > lineEnd2) {
            return null;
        }
        Rect rect = new Rect();
        double primaryHorizontal = layoutFromHost.getPrimaryHorizontal(start);
        boolean z = lineForOffset != lineForOffset2;
        layoutFromHost.getLineBounds(lineForOffset, rect);
        int scrollY = getHostView().getScrollY() + getHostView().getPaddingTop();
        rect.top += scrollY;
        rect.bottom += scrollY;
        rect.left = (int) (((double) rect.left) + ((primaryHorizontal + ((double) getHostView().getPaddingLeft())) - ((double) getHostView().getScrollX())));
        if (z) {
            return new Rect(rect.left, rect.top, rect.right, rect.bottom);
        }
        return new Rect(rect.left, rect.top, (int) layoutFromHost.getPrimaryHorizontal(end), rect.bottom);
    }

    @Override // com.facebook.react.uimanager.ReactAccessibilityDelegate, androidx.customview.widget.ExploreByTouchHelper, androidx.core.view.AccessibilityDelegateCompat
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View host) {
        Intrinsics.checkNotNullParameter(host, "host");
        if (this.accessibilityLinks != null) {
            return superGetAccessibilityNodeProvider(host);
        }
        return null;
    }

    public static final class AccessibilityLinks {
        private final List links;

        public AccessibilityLinks(final Spanned text) {
            Intrinsics.checkNotNullParameter(text, "text");
            ArrayList arrayList = new ArrayList();
            ClickableSpan[] clickableSpanArr = (ClickableSpan[]) text.getSpans(0, text.length(), ClickableSpan.class);
            Intrinsics.checkNotNull(clickableSpanArr);
            if (clickableSpanArr.length > 1) {
                ArraysKt.sortWith(clickableSpanArr, new Comparator() { // from class: com.facebook.react.views.text.ReactTextViewAccessibilityDelegate$AccessibilityLinks$special$$inlined$sortBy$1
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return ComparisonsKt.compareValues(Integer.valueOf(text.getSpanStart((ClickableSpan) obj)), Integer.valueOf(text.getSpanStart((ClickableSpan) obj2)));
                    }
                });
            }
            int length = clickableSpanArr.length;
            for (int i = 0; i < length; i++) {
                ClickableSpan clickableSpan = clickableSpanArr[i];
                int spanStart = text.getSpanStart(clickableSpan);
                int spanEnd = text.getSpanEnd(clickableSpan);
                if (spanStart != spanEnd && spanStart >= 0 && spanEnd >= 0 && spanStart <= text.length() && spanEnd <= text.length()) {
                    AccessibleLink accessibleLink = new AccessibleLink();
                    accessibleLink.setDescription(text.subSequence(spanStart, spanEnd).toString());
                    accessibleLink.setStart(spanStart);
                    accessibleLink.setEnd(spanEnd);
                    accessibleLink.setId(i);
                    arrayList.add(accessibleLink);
                }
            }
            this.links = arrayList;
        }

        public final AccessibleLink getLinkById(int i) {
            for (AccessibleLink accessibleLink : this.links) {
                if (accessibleLink.getId() == i) {
                    return accessibleLink;
                }
            }
            return null;
        }

        public final AccessibleLink getLinkBySpanPos(int i, int i2) {
            for (AccessibleLink accessibleLink : this.links) {
                if (accessibleLink.getStart() == i && accessibleLink.getEnd() == i2) {
                    return accessibleLink;
                }
            }
            return null;
        }

        public final int size() {
            return this.links.size();
        }

        public static final class AccessibleLink {
            private String description;
            private int end;
            private int id;
            private int start;

            public final String getDescription() {
                return this.description;
            }

            public final void setDescription(String str) {
                this.description = str;
            }

            public final int getStart() {
                return this.start;
            }

            public final void setStart(int i) {
                this.start = i;
            }

            public final int getEnd() {
                return this.end;
            }

            public final void setEnd(int i) {
                this.end = i;
            }

            public final int getId() {
                return this.id;
            }

            public final void setId(int i) {
                this.id = i;
            }
        }
    }
}
