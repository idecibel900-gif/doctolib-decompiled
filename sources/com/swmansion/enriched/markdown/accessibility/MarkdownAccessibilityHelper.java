package com.swmansion.enriched.markdown.accessibility;

import android.graphics.Rect;
import android.os.Bundle;
import android.text.Layout;
import android.text.Spanned;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.swmansion.enriched.markdown.spans.BaseListSpan;
import com.swmansion.enriched.markdown.spans.BlockquoteSpan;
import com.swmansion.enriched.markdown.spans.HeadingSpan;
import com.swmansion.enriched.markdown.spans.ImageSpan;
import com.swmansion.enriched.markdown.spans.LinkSpan;
import com.swmansion.enriched.markdown.spans.OrderedListSpan;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class MarkdownAccessibilityHelper extends ExploreByTouchHelper {
    private List items;
    private AccessibilityLabels labels;
    private int lastLayoutHashCode;
    private boolean needsRebuild;
    private ViewTreeObserver.OnGlobalLayoutListener pendingLayoutListener;
    private final TextView textView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarkdownAccessibilityHelper(TextView textView) {
        super(textView);
        Intrinsics.checkNotNullParameter(textView, "textView");
        this.textView = textView;
        this.items = CollectionsKt.emptyList();
        this.labels = new AccessibilityLabels(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    public final void setLabels(AccessibilityLabels value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(this.labels, value)) {
            return;
        }
        this.labels = value;
        invalidateAccessibilityItems();
    }

    public static final class AccessibilityItem {
        private final int end;
        private final int headingLevel;
        private final int id;
        private final String imageAltText;
        private final String linkUrl;
        private final ListItemInfo listInfo;
        private final int start;
        private final String text;
        private final int visibleEnd;
        private final int visibleStart;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AccessibilityItem)) {
                return false;
            }
            AccessibilityItem accessibilityItem = (AccessibilityItem) obj;
            return this.id == accessibilityItem.id && Intrinsics.areEqual(this.text, accessibilityItem.text) && this.start == accessibilityItem.start && this.end == accessibilityItem.end && this.visibleStart == accessibilityItem.visibleStart && this.visibleEnd == accessibilityItem.visibleEnd && this.headingLevel == accessibilityItem.headingLevel && Intrinsics.areEqual(this.linkUrl, accessibilityItem.linkUrl) && Intrinsics.areEqual(this.listInfo, accessibilityItem.listInfo) && Intrinsics.areEqual(this.imageAltText, accessibilityItem.imageAltText);
        }

        public int hashCode() {
            int iHashCode = ((((((((((((Integer.hashCode(this.id) * 31) + this.text.hashCode()) * 31) + Integer.hashCode(this.start)) * 31) + Integer.hashCode(this.end)) * 31) + Integer.hashCode(this.visibleStart)) * 31) + Integer.hashCode(this.visibleEnd)) * 31) + Integer.hashCode(this.headingLevel)) * 31;
            String str = this.linkUrl;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            ListItemInfo listItemInfo = this.listInfo;
            int iHashCode3 = (iHashCode2 + (listItemInfo == null ? 0 : listItemInfo.hashCode())) * 31;
            String str2 = this.imageAltText;
            return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "AccessibilityItem(id=" + this.id + ", text=" + this.text + ", start=" + this.start + ", end=" + this.end + ", visibleStart=" + this.visibleStart + ", visibleEnd=" + this.visibleEnd + ", headingLevel=" + this.headingLevel + ", linkUrl=" + this.linkUrl + ", listInfo=" + this.listInfo + ", imageAltText=" + this.imageAltText + ")";
        }

        public AccessibilityItem(int i, String text, int i2, int i3, int i4, int i5, int i6, String str, ListItemInfo listItemInfo, String str2) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.id = i;
            this.text = text;
            this.start = i2;
            this.end = i3;
            this.visibleStart = i4;
            this.visibleEnd = i5;
            this.headingLevel = i6;
            this.linkUrl = str;
            this.listInfo = listItemInfo;
            this.imageAltText = str2;
        }

        public /* synthetic */ AccessibilityItem(int i, String str, int i2, int i3, int i4, int i5, int i6, String str2, ListItemInfo listItemInfo, String str3, int i7, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, str, i2, i3, (i7 & 16) != 0 ? i2 : i4, (i7 & 32) != 0 ? i3 : i5, (i7 & 64) != 0 ? 0 : i6, (i7 & 128) != 0 ? null : str2, (i7 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? null : listItemInfo, (i7 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? null : str3);
        }

        public final int getId() {
            return this.id;
        }

        public final String getText() {
            return this.text;
        }

        public final int getStart() {
            return this.start;
        }

        public final int getEnd() {
            return this.end;
        }

        public final int getVisibleStart() {
            return this.visibleStart;
        }

        public final int getVisibleEnd() {
            return this.visibleEnd;
        }

        public final ListItemInfo getListInfo() {
            return this.listInfo;
        }

        public final boolean isHeading() {
            return this.headingLevel > 0;
        }

        public final boolean isLink() {
            return this.linkUrl != null;
        }

        public final boolean isListItem() {
            return this.listInfo != null;
        }

        public final boolean isImage() {
            return this.imageAltText != null;
        }
    }

    public static final class ListItemInfo {
        private final int depth;
        private final boolean isOrdered;
        private final int itemNumber;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ListItemInfo)) {
                return false;
            }
            ListItemInfo listItemInfo = (ListItemInfo) obj;
            return this.isOrdered == listItemInfo.isOrdered && this.itemNumber == listItemInfo.itemNumber && this.depth == listItemInfo.depth;
        }

        public int hashCode() {
            return (((Boolean.hashCode(this.isOrdered) * 31) + Integer.hashCode(this.itemNumber)) * 31) + Integer.hashCode(this.depth);
        }

        public String toString() {
            return "ListItemInfo(isOrdered=" + this.isOrdered + ", itemNumber=" + this.itemNumber + ", depth=" + this.depth + ")";
        }

        public ListItemInfo(boolean z, int i, int i2) {
            this.isOrdered = z;
            this.itemNumber = i;
            this.depth = i2;
        }

        public final boolean isOrdered() {
            return this.isOrdered;
        }

        public final int getItemNumber() {
            return this.itemNumber;
        }

        public final int getDepth() {
            return this.depth;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class SpanRange {
        private final int end;
        private final int headingLevel;
        private final String imageAltText;
        private final String linkUrl;
        private final int start;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SpanRange)) {
                return false;
            }
            SpanRange spanRange = (SpanRange) obj;
            return this.start == spanRange.start && this.end == spanRange.end && this.headingLevel == spanRange.headingLevel && Intrinsics.areEqual(this.linkUrl, spanRange.linkUrl) && Intrinsics.areEqual(this.imageAltText, spanRange.imageAltText);
        }

        public int hashCode() {
            int iHashCode = ((((Integer.hashCode(this.start) * 31) + Integer.hashCode(this.end)) * 31) + Integer.hashCode(this.headingLevel)) * 31;
            String str = this.linkUrl;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.imageAltText;
            return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "SpanRange(start=" + this.start + ", end=" + this.end + ", headingLevel=" + this.headingLevel + ", linkUrl=" + this.linkUrl + ", imageAltText=" + this.imageAltText + ")";
        }

        public SpanRange(int i, int i2, int i3, String str, String str2) {
            this.start = i;
            this.end = i2;
            this.headingLevel = i3;
            this.linkUrl = str;
            this.imageAltText = str2;
        }

        public /* synthetic */ SpanRange(int i, int i2, int i3, String str, String str2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, i2, (i4 & 4) != 0 ? 0 : i3, (i4 & 8) != 0 ? null : str, (i4 & 16) != 0 ? null : str2);
        }

        public final int getStart() {
            return this.start;
        }

        public final int getEnd() {
            return this.end;
        }

        public final int getHeadingLevel() {
            return this.headingLevel;
        }

        public final String getLinkUrl() {
            return this.linkUrl;
        }

        public final String getImageAltText() {
            return this.imageAltText;
        }
    }

    public final void invalidateAccessibilityItems() {
        this.needsRebuild = true;
        if (this.textView.getLayout() != null) {
            rebuildIfNeeded();
            invalidateRoot();
        } else {
            schedulePostLayoutRebuild();
        }
    }

    private final void schedulePostLayoutRebuild() {
        if (this.pendingLayoutListener != null) {
            return;
        }
        ViewTreeObserver viewTreeObserver = this.textView.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.swmansion.enriched.markdown.accessibility.MarkdownAccessibilityHelper$$ExternalSyntheticLambda0
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    MarkdownAccessibilityHelper.schedulePostLayoutRebuild$lambda$0(this.f$0);
                }
            };
            this.pendingLayoutListener = onGlobalLayoutListener;
            viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void schedulePostLayoutRebuild$lambda$0(MarkdownAccessibilityHelper markdownAccessibilityHelper) {
        markdownAccessibilityHelper.removePendingLayoutListener();
        if (markdownAccessibilityHelper.needsRebuild) {
            markdownAccessibilityHelper.rebuildIfNeeded();
            markdownAccessibilityHelper.invalidateRoot();
        }
    }

    private final void removePendingLayoutListener() {
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.pendingLayoutListener;
        if (onGlobalLayoutListener == null) {
            return;
        }
        this.pendingLayoutListener = null;
        ViewTreeObserver viewTreeObserver = this.textView.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    private final void updateHostFocusability() {
        boolean zIsEmpty = this.items.isEmpty();
        int i = !zIsEmpty ? 1 : 0;
        ViewCompat.setScreenReaderFocusable(this.textView, zIsEmpty);
        this.textView.setImportantForAccessibility(i);
    }

    private final void rebuildIfNeeded() {
        Layout layout = this.textView.getLayout();
        if (layout == null) {
            return;
        }
        if (this.needsRebuild || this.lastLayoutHashCode != layout.hashCode()) {
            this.items = buildItems();
            this.needsRebuild = false;
            this.lastLayoutHashCode = layout.hashCode();
            updateHostFocusability();
        }
    }

    private final List buildItems() {
        int iAddSegmentedItems;
        int i;
        ArrayList arrayList;
        MarkdownAccessibilityHelper markdownAccessibilityHelper = this;
        CharSequence text = markdownAccessibilityHelper.textView.getText();
        Spanned spanned = text instanceof Spanned ? (Spanned) text : null;
        if (spanned != null && spanned.length() != 0) {
            String string = spanned.toString();
            ArrayList arrayList2 = new ArrayList();
            List listCollectSemanticSpans = markdownAccessibilityHelper.collectSemanticSpans(spanned);
            int i2 = 0;
            int i3 = 0;
            while (i3 < string.length()) {
                int i4 = i3;
                int iIndexOf$default = StringsKt.indexOf$default((CharSequence) string, '\n', i4, false, 4, (Object) null);
                int length = iIndexOf$default == -1 ? string.length() : iIndexOf$default + 1;
                String strSubstring = string.substring(i4, length);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                String string2 = StringsKt.trim(strSubstring).toString();
                if (string2.length() > 0) {
                    Spanned spanned2 = spanned;
                    ArrayList arrayList3 = new ArrayList();
                    for (Object obj : listCollectSemanticSpans) {
                        SpanRange spanRange = (SpanRange) obj;
                        if (spanRange.getStart() < length && spanRange.getEnd() > i4) {
                            arrayList3.add(obj);
                        }
                    }
                    if (arrayList3.isEmpty()) {
                        iAddSegmentedItems = i2 + 1;
                        String str = string;
                        string = str;
                        spanned = spanned2;
                        arrayList2.add(markdownAccessibilityHelper.createTextItem(i2, string2, i4, length, str, spanned2));
                    } else {
                        i = length;
                        int i5 = i2;
                        spanned = spanned2;
                        arrayList = arrayList2;
                        iAddSegmentedItems = markdownAccessibilityHelper.addSegmentedItems(arrayList, spanned, string, i4, i, arrayList3, i5);
                    }
                    markdownAccessibilityHelper = this;
                    arrayList2 = arrayList;
                    i3 = i;
                    i2 = iAddSegmentedItems;
                } else {
                    iAddSegmentedItems = i2;
                }
                i = length;
                arrayList = arrayList2;
                markdownAccessibilityHelper = this;
                arrayList2 = arrayList;
                i3 = i;
                i2 = iAddSegmentedItems;
            }
            ArrayList arrayList4 = arrayList2;
            return arrayList4.isEmpty() ? CollectionsKt.listOf(new AccessibilityItem(0, StringsKt.trim(string).toString(), 0, spanned.length(), 0, 0, 0, null, null, null, 1008, null)) : arrayList4;
        }
        return CollectionsKt.emptyList();
    }

    private final List collectSemanticSpans(Spanned spanned) {
        Object[] spans = spanned.getSpans(0, spanned.length(), HeadingSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans, "getSpans(...)");
        ArrayList arrayList = new ArrayList(spans.length);
        for (Object obj : spans) {
            HeadingSpan headingSpan = (HeadingSpan) obj;
            arrayList.add(new SpanRange(spanned.getSpanStart(headingSpan), spanned.getSpanEnd(headingSpan), headingSpan.getLevel(), null, null, 24, null));
        }
        Object[] spans2 = spanned.getSpans(0, spanned.length(), LinkSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans2, "getSpans(...)");
        ArrayList arrayList2 = new ArrayList(spans2.length);
        for (Object obj2 : spans2) {
            LinkSpan linkSpan = (LinkSpan) obj2;
            arrayList2.add(new SpanRange(spanned.getSpanStart(linkSpan), spanned.getSpanEnd(linkSpan), 0, linkSpan.getUrl(), null, 20, null));
        }
        List listPlus = CollectionsKt.plus((Collection) arrayList, (Iterable) arrayList2);
        Object[] spans3 = spanned.getSpans(0, spanned.length(), ImageSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans3, "getSpans(...)");
        ArrayList arrayList3 = new ArrayList(spans3.length);
        for (Object obj3 : spans3) {
            ImageSpan imageSpan = (ImageSpan) obj3;
            arrayList3.add(new SpanRange(spanned.getSpanStart(imageSpan), spanned.getSpanEnd(imageSpan), 0, null, imageSpan.getAltText(), 12, null));
        }
        return CollectionsKt.sortedWith(CollectionsKt.plus((Collection) listPlus, (Iterable) arrayList3), new Comparator() { // from class: com.swmansion.enriched.markdown.accessibility.MarkdownAccessibilityHelper$collectSemanticSpans$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(Object obj4, Object obj5) {
                return ComparisonsKt.compareValues(Integer.valueOf(((MarkdownAccessibilityHelper.SpanRange) obj4).getStart()), Integer.valueOf(((MarkdownAccessibilityHelper.SpanRange) obj5).getStart()));
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0064 A[EDGE_INSN: B:17:0x0064->B:18:0x0067 BREAK  A[LOOP:1: B:11:0x003a->B:16:0x005d], PHI: r10
      0x0064: PHI (r10v6 java.lang.String) = (r10v1 java.lang.String), (r10v1 java.lang.String), (r10v9 java.lang.String) binds: [B:8:0x001f, B:10:0x0038, B:44:0x0064] A[DONT_GENERATE, DONT_INLINE]] */
    private final int addSegmentedItems(List list, Spanned spanned, String str, int i, int i2, List list2, int i3) {
        int i4;
        Spanned spanned2;
        String str2;
        Iterator it = list2.iterator();
        int end = i;
        int i5 = i3;
        while (true) {
            i4 = 0;
            if (!it.hasNext()) {
                break;
            }
            SpanRange spanRange = (SpanRange) it.next();
            if (spanRange.getStart() >= end) {
                if (end >= spanRange.getStart()) {
                    spanned2 = spanned;
                    str2 = str;
                    break;
                }
                String strSubstring = str.substring(end, spanRange.getStart());
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                String string = StringsKt.trim(strSubstring).toString();
                if (string.length() <= 0) {
                    spanned2 = spanned;
                    str2 = str;
                    break;
                }
                while (true) {
                    if (i4 >= string.length()) {
                        spanned2 = spanned;
                        str2 = str;
                        break;
                    }
                    if (Character.isLetterOrDigit(string.charAt(i4))) {
                        spanned2 = spanned;
                        str2 = str;
                        list.add(createTextItem(i5, string, end, spanRange.getStart(), str2, spanned2));
                        i5++;
                        break;
                    }
                    i4++;
                    str = str;
                }
                String imageAltText = spanRange.getImageAltText();
                if (imageAltText == null) {
                    imageAltText = StringsKt.trim(spanned2.subSequence(spanRange.getStart(), spanRange.getEnd()).toString()).toString();
                }
                if (imageAltText.length() > 0) {
                    list.add(createSpanItem(i5, imageAltText, spanRange, spanned2));
                    i5++;
                }
                end = spanRange.getEnd();
                str = str2;
                spanned = spanned2;
            } else {
                str = str;
            }
        }
        Spanned spanned3 = spanned;
        String str3 = str;
        if (end < i2) {
            String strSubstring2 = str3.substring(end, i2);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
            String string2 = StringsKt.trim(strSubstring2).toString();
            if (string2.length() > 0) {
                while (i4 < string2.length()) {
                    if (Character.isLetterOrDigit(string2.charAt(i4))) {
                        int i6 = i5 + 1;
                        list.add(createTextItem(i5, string2, end, i2, str3, spanned3));
                        return i6;
                    }
                    i4++;
                }
            }
        }
        return i5;
    }

    private final AccessibilityItem createTextItem(int i, String str, int i2, int i3, String str2, Spanned spanned) {
        return new AccessibilityItem(i, str, i2, i3, MarkdownAccessibilityHelperKt.findFirstNonWhitespace(str2, i2, i3), MarkdownAccessibilityHelperKt.findLastNonWhitespace(str2, i2, i3), 0, null, getListInfoAt(spanned, i2, true), null, 704, null);
    }

    private final AccessibilityItem createSpanItem(int i, String str, SpanRange spanRange, Spanned spanned) {
        ListItemInfo listInfoAt;
        if (spanRange.getHeadingLevel() > 0 || spanRange.getImageAltText() != null) {
            listInfoAt = null;
        } else {
            listInfoAt = getListInfoAt(spanned, spanRange.getStart(), spanRange.getLinkUrl() == null);
        }
        return new AccessibilityItem(i, str, spanRange.getStart(), spanRange.getEnd(), 0, 0, spanRange.getHeadingLevel(), spanRange.getLinkUrl(), listInfoAt, spanRange.getImageAltText(), 48, null);
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    protected int getVirtualViewAt(float f, float f2) {
        Object next;
        rebuildIfNeeded();
        if (this.items.isEmpty()) {
            return -1;
        }
        int charOffsetAt = getCharOffsetAt(f, f2);
        List list = this.items;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            AccessibilityItem accessibilityItem = (AccessibilityItem) obj;
            int start = accessibilityItem.getStart();
            if (charOffsetAt < accessibilityItem.getEnd() && start <= charOffsetAt) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        Object next2 = null;
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                int hitTestPriority = getHitTestPriority((AccessibilityItem) next);
                do {
                    Object next3 = it.next();
                    int hitTestPriority2 = getHitTestPriority((AccessibilityItem) next3);
                    if (hitTestPriority > hitTestPriority2) {
                        next = next3;
                        hitTestPriority = hitTestPriority2;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        AccessibilityItem accessibilityItem2 = (AccessibilityItem) next;
        if (accessibilityItem2 != null) {
            return accessibilityItem2.getId();
        }
        Iterator it2 = this.items.iterator();
        if (it2.hasNext()) {
            next2 = it2.next();
            if (it2.hasNext()) {
                int iDistanceTo = distanceTo((AccessibilityItem) next2, charOffsetAt);
                do {
                    Object next4 = it2.next();
                    int iDistanceTo2 = distanceTo((AccessibilityItem) next4, charOffsetAt);
                    if (iDistanceTo > iDistanceTo2) {
                        next2 = next4;
                        iDistanceTo = iDistanceTo2;
                    }
                } while (it2.hasNext());
            }
        }
        AccessibilityItem accessibilityItem3 = (AccessibilityItem) next2;
        if (accessibilityItem3 != null) {
            return accessibilityItem3.getId();
        }
        return -1;
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    protected void getVisibleVirtualViews(List ids) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        rebuildIfNeeded();
        Iterator it = this.items.iterator();
        while (it.hasNext()) {
            ids.add(Integer.valueOf(((AccessibilityItem) it.next()).getId()));
        }
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    protected void onPopulateNodeForHost(AccessibilityNodeInfoCompat host) {
        Intrinsics.checkNotNullParameter(host, "host");
        super.onPopulateNodeForHost(host);
        rebuildIfNeeded();
        if (this.items.isEmpty()) {
            return;
        }
        host.setScreenReaderFocusable(false);
        host.setFocusable(false);
        host.setText(null);
        host.setContentDescription(null);
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    protected void onPopulateNodeForVirtualView(int i, AccessibilityNodeInfoCompat node) {
        Intrinsics.checkNotNullParameter(node, "node");
        AccessibilityItem accessibilityItem = (AccessibilityItem) CollectionsKt.getOrNull(this.items, i);
        if (accessibilityItem == null) {
            node.setContentDescription("");
            node.setBoundsInParent(new Rect());
            return;
        }
        node.setText(accessibilityItem.getText());
        node.setContentDescription(accessibilityItem.getText());
        node.setFocusable(true);
        node.setScreenReaderFocusable(true);
        node.setBoundsInParent(boundsForItem(accessibilityItem));
        applySemantics(node, accessibilityItem);
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    protected boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle) {
        AccessibilityItem accessibilityItem = (AccessibilityItem) CollectionsKt.getOrNull(this.items, i);
        if (accessibilityItem == null || i2 != 16 || !accessibilityItem.isLink()) {
            return false;
        }
        CharSequence text = this.textView.getText();
        Spanned spanned = text instanceof Spanned ? (Spanned) text : null;
        if (spanned == null) {
            return false;
        }
        Object[] spans = spanned.getSpans(accessibilityItem.getStart(), accessibilityItem.getEnd(), LinkSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans, "getSpans(...)");
        LinkSpan linkSpan = (LinkSpan) ArraysKt.firstOrNull(spans);
        if (linkSpan == null) {
            return false;
        }
        linkSpan.onClick(this.textView);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0067  */
    private final void applySemantics(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, AccessibilityItem accessibilityItem) {
        String str;
        ListItemInfo listInfo = accessibilityItem.getListInfo();
        if (listInfo != null) {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(listInfo.getItemNumber() - 1, 1, 0, 1, false, false));
        }
        String strBlockquoteAnnouncementFor = blockquoteAnnouncementFor(accessibilityItem);
        if (accessibilityItem.isHeading()) {
            accessibilityNodeInfoCompat.setHeading(true);
            if (strBlockquoteAnnouncementFor != null) {
                accessibilityNodeInfoCompat.setRoleDescription(strBlockquoteAnnouncementFor);
                return;
            }
            return;
        }
        if (accessibilityItem.isImage()) {
            accessibilityNodeInfoCompat.setRoleDescription(appendBlockquote("image", strBlockquoteAnnouncementFor));
            return;
        }
        if (accessibilityItem.isLink()) {
            accessibilityNodeInfoCompat.setClickable(true);
            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
            ListItemInfo listInfo2 = accessibilityItem.getListInfo();
            if (listInfo2 != null) {
                str = "link, " + getListAnnouncement(listInfo2);
                if (str == null) {
                    str = "link";
                }
            } else {
                str = "link";
            }
            accessibilityNodeInfoCompat.setRoleDescription(appendBlockquote(str, strBlockquoteAnnouncementFor));
            return;
        }
        if (accessibilityItem.isListItem()) {
            ListItemInfo listInfo3 = accessibilityItem.getListInfo();
            Intrinsics.checkNotNull(listInfo3);
            accessibilityNodeInfoCompat.setRoleDescription(appendBlockquote(getListAnnouncement(listInfo3), strBlockquoteAnnouncementFor));
        } else if (strBlockquoteAnnouncementFor != null) {
            accessibilityNodeInfoCompat.setRoleDescription(strBlockquoteAnnouncementFor);
        }
    }

    private final String appendBlockquote(String str, String str2) {
        if (str2 == null) {
            return str;
        }
        return str + ", " + str2;
    }

    private final String blockquoteAnnouncementFor(AccessibilityItem accessibilityItem) {
        int iCoerceAtLeast;
        CharSequence text = this.textView.getText();
        Spanned spanned = text instanceof Spanned ? (Spanned) text : null;
        if (spanned == null || spanned.length() == 0 || (iCoerceAtLeast = RangesKt.coerceAtLeast(RangesKt.coerceIn(accessibilityItem.getStart(), 0, spanned.length() - 1), 0)) >= spanned.length()) {
            return null;
        }
        BlockquoteSpan[] blockquoteSpanArr = (BlockquoteSpan[]) spanned.getSpans(iCoerceAtLeast, iCoerceAtLeast + 1, BlockquoteSpan.class);
        Intrinsics.checkNotNull(blockquoteSpanArr);
        if (blockquoteSpanArr.length == 0) {
            return null;
        }
        if (blockquoteSpanArr.length == 0) {
            throw new NoSuchElementException();
        }
        int depth = blockquoteSpanArr[0].getDepth();
        int lastIndex = ArraysKt.getLastIndex(blockquoteSpanArr);
        if (1 <= lastIndex) {
            int i = 1;
            while (true) {
                int depth2 = blockquoteSpanArr[i].getDepth();
                if (depth < depth2) {
                    depth = depth2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        AccessibilityLabels accessibilityLabels = this.labels;
        return depth >= 1 ? accessibilityLabels.getNestedBlockquote() : accessibilityLabels.getBlockquote();
    }

    private final String getListAnnouncement(ListItemInfo listItemInfo) {
        boolean z = listItemInfo.getDepth() > 0;
        if (listItemInfo.isOrdered()) {
            return StringsKt.replace$default(z ? this.labels.getNestedOrderedItem() : this.labels.getOrderedItem(), "{n}", String.valueOf(listItemInfo.getItemNumber()), false, 4, (Object) null);
        }
        AccessibilityLabels accessibilityLabels = this.labels;
        return z ? accessibilityLabels.getNestedBulletPoint() : accessibilityLabels.getBulletPoint();
    }

    private final Rect boundsForItem(AccessibilityItem accessibilityItem) {
        Layout layout = this.textView.getLayout();
        if (layout == null) {
            return new Rect();
        }
        int visibleStart = accessibilityItem.getVisibleStart();
        int visibleEnd = accessibilityItem.getVisibleEnd();
        int lineForOffset = layout.getLineForOffset(visibleStart);
        int lineForOffset2 = layout.getLineForOffset(Math.max(visibleStart, visibleEnd - 1));
        if (lineForOffset == lineForOffset2) {
            return singleLineBounds(visibleStart, visibleEnd, lineForOffset);
        }
        return multiLineBounds(visibleStart, lineForOffset, lineForOffset2);
    }

    private final Rect singleLineBounds(int i, int i2, int i3) {
        Layout layout = this.textView.getLayout();
        int primaryHorizontal = ((int) layout.getPrimaryHorizontal(i)) + this.textView.getPaddingLeft();
        int primaryHorizontal2 = ((int) layout.getPrimaryHorizontal(i2)) + this.textView.getPaddingLeft();
        if (primaryHorizontal2 <= primaryHorizontal) {
            primaryHorizontal2 = ((int) layout.getLineRight(i3)) + this.textView.getPaddingLeft();
        }
        return new Rect(primaryHorizontal, layout.getLineTop(i3) + this.textView.getPaddingTop(), primaryHorizontal2, layout.getLineBottom(i3) + this.textView.getPaddingTop());
    }

    private final Rect multiLineBounds(int i, int i2, int i3) {
        Layout layout = this.textView.getLayout();
        int paddingLeft = this.textView.getPaddingLeft();
        int primaryHorizontal = ((int) layout.getPrimaryHorizontal(i)) + paddingLeft;
        int lineRight = ((int) layout.getLineRight(i2)) + paddingLeft;
        int i4 = i2 + 1;
        int iMin = primaryHorizontal;
        if (i4 <= i3) {
            while (true) {
                iMin = Math.min(iMin, ((int) layout.getLineLeft(i4)) + paddingLeft);
                lineRight = Math.max(lineRight, ((int) layout.getLineRight(i4)) + paddingLeft);
                if (i4 == i3) {
                    break;
                }
                i4++;
            }
        }
        return new Rect(Math.min(primaryHorizontal, iMin), layout.getLineTop(i2) + this.textView.getPaddingTop(), lineRight, layout.getLineBottom(i3) + this.textView.getPaddingTop());
    }

    private final int getCharOffsetAt(float f, float f2) {
        Layout layout = this.textView.getLayout();
        if (layout == null) {
            return 0;
        }
        return layout.getOffsetForHorizontal(RangesKt.coerceIn(layout.getLineForVertical((int) f2), 0, layout.getLineCount() - 1), f);
    }

    private final int getHitTestPriority(AccessibilityItem accessibilityItem) {
        if (accessibilityItem.isLink()) {
            return 0;
        }
        if (accessibilityItem.isImage()) {
            return 1;
        }
        if (accessibilityItem.isHeading()) {
            return 2;
        }
        return accessibilityItem.isListItem() ? 3 : 4;
    }

    private final int distanceTo(AccessibilityItem accessibilityItem, int i) {
        if (i < accessibilityItem.getStart()) {
            return accessibilityItem.getStart() - i;
        }
        if (i >= accessibilityItem.getEnd()) {
            return (i - accessibilityItem.getEnd()) + 1;
        }
        return 0;
    }

    private final ListItemInfo getListInfoAt(Spanned spanned, int i, boolean z) {
        Object obj;
        Object next;
        Object[] spans = spanned.getSpans(i, i + 1, BaseListSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans, "getSpans(...)");
        if (spans.length != 0) {
            obj = spans[0];
            int lastIndex = ArraysKt.getLastIndex(spans);
            if (lastIndex != 0) {
                int depth = ((BaseListSpan) obj).getDepth();
                if (1 <= lastIndex) {
                    int i2 = 1;
                    while (true) {
                        Object obj2 = spans[i2];
                        int depth2 = ((BaseListSpan) obj2).getDepth();
                        if (depth < depth2) {
                            obj = obj2;
                            depth = depth2;
                        }
                        if (i2 == lastIndex) {
                            break;
                        }
                        i2++;
                    }
                }
            }
        } else {
            obj = null;
        }
        BaseListSpan baseListSpan = (BaseListSpan) obj;
        if (baseListSpan == null) {
            return null;
        }
        if (z) {
            int spanStart = spanned.getSpanStart(baseListSpan);
            Iterator it = RangesKt.until(spanStart, Math.min(spanStart + 10, spanned.length())).iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (CharsKt.isWhitespace(spanned.charAt(((Number) next).intValue())));
            Integer num = (Integer) next;
            if (num != null) {
                spanStart = num.intValue();
            }
            if (i > spanStart + 1) {
                return null;
            }
        }
        boolean z2 = baseListSpan instanceof OrderedListSpan;
        OrderedListSpan orderedListSpan = z2 ? (OrderedListSpan) baseListSpan : null;
        return new ListItemInfo(z2, orderedListSpan != null ? orderedListSpan.getItemNumber() : 0, baseListSpan.getDepth());
    }
}
