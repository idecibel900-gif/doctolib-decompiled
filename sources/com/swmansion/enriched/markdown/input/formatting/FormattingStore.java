package com.swmansion.enriched.markdown.input.formatting;

import com.swmansion.enriched.markdown.input.model.FormattingRange;
import com.swmansion.enriched.markdown.input.model.StyleType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class FormattingStore {
    private final List ranges = new ArrayList();

    public enum ToggleResult {
        WAS_ACTIVE,
        WAS_INACTIVE;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    }

    public final List getAllRanges() {
        List listUnmodifiableList = Collections.unmodifiableList(this.ranges);
        Intrinsics.checkNotNullExpressionValue(listUnmodifiableList, "unmodifiableList(...)");
        return listUnmodifiableList;
    }

    public final void setRanges(List newRanges) {
        Intrinsics.checkNotNullParameter(newRanges, "newRanges");
        this.ranges.clear();
        this.ranges.addAll(CollectionsKt.sortedWith(newRanges, new Comparator() { // from class: com.swmansion.enriched.markdown.input.formatting.FormattingStore$setRanges$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((FormattingRange) obj).getStart()), Integer.valueOf(((FormattingRange) obj2).getStart()));
            }
        }));
    }

    public final void clearAll() {
        this.ranges.clear();
    }

    public final FormattingRange rangeOfType(StyleType type, int i) {
        Object next;
        Intrinsics.checkNotNullParameter(type, "type");
        Iterator it = this.ranges.iterator();
        while (it.hasNext()) {
            next = it.next();
            FormattingRange formattingRange = (FormattingRange) next;
            if (formattingRange.getType() == type && i >= formattingRange.getStart() && i < formattingRange.getEnd()) {
                return (FormattingRange) next;
            }
        }
        next = null;
        return (FormattingRange) next;
    }

    public final boolean isStyleActive(StyleType type, int i) {
        Intrinsics.checkNotNullParameter(type, "type");
        return rangeOfType(type, i) != null;
    }

    public final boolean isStyleActiveInRange(StyleType type, int i, int i2) {
        Intrinsics.checkNotNullParameter(type, "type");
        List<FormattingRange> list = this.ranges;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        for (FormattingRange formattingRange : list) {
            if (formattingRange.getType() == type && formattingRange.getStart() < i2 && formattingRange.getEnd() > i) {
                return true;
            }
        }
        return false;
    }

    public final Pair selectionAdjustedForAtomicLinks(int i, int i2) {
        FormattingRange formattingRangeRangeOfType;
        if (i != i2) {
            StyleType styleType = StyleType.LINK;
            FormattingRange formattingRangeRangeOfType2 = rangeOfType(styleType, i);
            int iMin = formattingRangeRangeOfType2 != null ? Math.min(i, formattingRangeRangeOfType2.getStart()) : i;
            int iMax = (i2 <= 0 || (formattingRangeRangeOfType = rangeOfType(styleType, i2 + (-1))) == null) ? i2 : Math.max(i2, formattingRangeRangeOfType.getEnd());
            if (iMin == i && iMax == i2) {
                return null;
            }
            return new Pair(Integer.valueOf(iMin), Integer.valueOf(iMax));
        }
        FormattingRange formattingRangeRangeOfType3 = rangeOfType(StyleType.LINK, i);
        if (formattingRangeRangeOfType3 == null || i <= formattingRangeRangeOfType3.getStart() || i >= formattingRangeRangeOfType3.getEnd()) {
            return null;
        }
        return new Pair(Integer.valueOf(formattingRangeRangeOfType3.getEnd()), Integer.valueOf(formattingRangeRangeOfType3.getEnd()));
    }

    public final ToggleResult toggleStyle(StyleType type, int i, int i2, Set conflictingStyles) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(conflictingStyles, "conflictingStyles");
        boolean zIsStyleActive = isStyleActive(type, i);
        if (i < i2) {
            if (zIsStyleActive) {
                removeType(type, i, i2);
            } else {
                Iterator it = conflictingStyles.iterator();
                while (it.hasNext()) {
                    removeType((StyleType) it.next(), i, i2);
                }
                addRange(new FormattingRange(type, i, i2, null, 8, null));
            }
        }
        return zIsStyleActive ? ToggleResult.WAS_ACTIVE : ToggleResult.WAS_INACTIVE;
    }

    public final boolean isToggleBlocked(StyleType type, int i, Set blockingStyles) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(blockingStyles, "blockingStyles");
        if (blockingStyles.isEmpty() || isStyleActive(type, i)) {
            return false;
        }
        Set set = blockingStyles;
        if ((set instanceof Collection) && set.isEmpty()) {
            return false;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (isStyleActive((StyleType) it.next(), i)) {
                return true;
            }
        }
        return false;
    }

    public final void addRange(FormattingRange newRange) {
        Intrinsics.checkNotNullParameter(newRange, "newRange");
        int start = newRange.getStart();
        int end = newRange.getEnd();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (FormattingRange formattingRange : this.ranges) {
            int i2 = i + 1;
            if (formattingRange.getType() == newRange.getType() && formattingRange.getStart() <= end && formattingRange.getEnd() >= start) {
                start = Math.min(start, formattingRange.getStart());
                end = Math.max(end, formattingRange.getEnd());
                arrayList.add(Integer.valueOf(i));
            }
            i = i2;
        }
        Iterator it = CollectionsKt.reversed(arrayList).iterator();
        while (it.hasNext()) {
            this.ranges.remove(((Number) it.next()).intValue());
        }
        FormattingRange formattingRange2 = new FormattingRange(newRange.getType(), start, end, newRange.getUrl());
        this.ranges.add(RangeEditAdjustmentKt.sortedInsertionIndex(this.ranges, start), formattingRange2);
    }

    public final void removeType(StyleType type, int i, int i2) {
        Intrinsics.checkNotNullParameter(type, "type");
        ArrayList<FormattingRange> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i3 = 0;
        for (FormattingRange formattingRange : this.ranges) {
            int i4 = i3 + 1;
            if (formattingRange.getType() == type && formattingRange.getEnd() > i && formattingRange.getStart() < i2) {
                arrayList2.add(Integer.valueOf(i3));
                if (formattingRange.getStart() < i) {
                    arrayList.add(new FormattingRange(type, formattingRange.getStart(), i, formattingRange.getUrl()));
                }
                if (formattingRange.getEnd() > i2) {
                    arrayList.add(new FormattingRange(type, i2, formattingRange.getEnd(), formattingRange.getUrl()));
                }
            }
            i3 = i4;
        }
        Iterator it = CollectionsKt.reversed(arrayList2).iterator();
        while (it.hasNext()) {
            this.ranges.remove(((Number) it.next()).intValue());
        }
        for (FormattingRange formattingRange2 : arrayList) {
            this.ranges.add(RangeEditAdjustmentKt.sortedInsertionIndex(this.ranges, formattingRange2.getStart()), formattingRange2);
        }
    }

    public final void removeRange(FormattingRange range) {
        Intrinsics.checkNotNullParameter(range, "range");
        this.ranges.remove(range);
    }

    public final void adjustForEdit(int i, int i2, int i3) {
        RangeEditAdjustment.adjustForEdit$default(RangeEditAdjustment.INSTANCE, this.ranges, i, i2, i3, new Function1() { // from class: com.swmansion.enriched.markdown.input.formatting.FormattingStore$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(FormattingStore.adjustForEdit$lambda$6((FormattingRange) obj));
            }
        }, null, 32, null);
        coalesceAdjacentSameTypeRanges();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean adjustForEdit$lambda$6(FormattingRange it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getType() != StyleType.LINK;
    }

    private final void coalesceAdjacentSameTypeRanges() {
        int i = 0;
        while (i < this.ranges.size()) {
            FormattingRange formattingRange = (FormattingRange) this.ranges.get(i);
            i++;
            int i2 = i;
            while (i2 < this.ranges.size() && ((FormattingRange) this.ranges.get(i2)).getStart() <= formattingRange.getEnd()) {
                FormattingRange formattingRange2 = (FormattingRange) this.ranges.get(i2);
                if (formattingRange2.getType() == formattingRange.getType() && Intrinsics.areEqual(formattingRange2.getUrl(), formattingRange.getUrl())) {
                    formattingRange.setEnd(Math.max(formattingRange.getEnd(), formattingRange2.getEnd()));
                    this.ranges.remove(i2);
                } else {
                    i2++;
                }
            }
        }
    }
}
