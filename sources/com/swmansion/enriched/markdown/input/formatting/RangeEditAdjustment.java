package com.swmansion.enriched.markdown.input.formatting;

import com.swmansion.enriched.markdown.input.model.MutableRangeBounds;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class RangeEditAdjustment {
    public static final RangeEditAdjustment INSTANCE = new RangeEditAdjustment();

    private enum EditOverlap {
        BEFORE_EDIT,
        AFTER_EDIT,
        FULLY_DELETED,
        DELETED_INSIDE,
        CLIPPED_END,
        CLIPPED_START;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EditOverlap.values().length];
            try {
                iArr[EditOverlap.BEFORE_EDIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EditOverlap.AFTER_EDIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EditOverlap.FULLY_DELETED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EditOverlap.DELETED_INSIDE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EditOverlap.CLIPPED_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[EditOverlap.CLIPPED_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean adjustForEdit$lambda$0(MutableRangeBounds it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean adjustForEdit$lambda$1(MutableRangeBounds it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return false;
    }

    private RangeEditAdjustment() {
    }

    public static /* synthetic */ void adjustForEdit$default(RangeEditAdjustment rangeEditAdjustment, List list, int i, int i2, int i3, Function1 function1, Function1 function2, int i4, Object obj) {
        if ((i4 & 16) != 0) {
            function1 = new Function1() { // from class: com.swmansion.enriched.markdown.input.formatting.RangeEditAdjustment$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return Boolean.valueOf(RangeEditAdjustment.adjustForEdit$lambda$0((MutableRangeBounds) obj2));
                }
            };
        }
        Function1 function3 = function1;
        if ((i4 & 32) != 0) {
            function2 = new Function1() { // from class: com.swmansion.enriched.markdown.input.formatting.RangeEditAdjustment$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return Boolean.valueOf(RangeEditAdjustment.adjustForEdit$lambda$1((MutableRangeBounds) obj2));
                }
            };
        }
        rangeEditAdjustment.adjustForEdit(list, i, i2, i3, function3, function2);
    }

    public final void adjustForEdit(List ranges, int i, int i2, int i3, Function1 inheritsReplacementAtStart, Function1 growsAtStartOnInsert) {
        Intrinsics.checkNotNullParameter(ranges, "ranges");
        Intrinsics.checkNotNullParameter(inheritsReplacementAtStart, "inheritsReplacementAtStart");
        Intrinsics.checkNotNullParameter(growsAtStartOnInsert, "growsAtStartOnInsert");
        if (i2 == 0 && i3 == 0) {
            return;
        }
        int i4 = i + i2;
        ArrayList arrayList = new ArrayList();
        Iterator it = ranges.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            int i6 = i5 + 1;
            MutableRangeBounds mutableRangeBounds = (MutableRangeBounds) it.next();
            if (i2 > 0) {
                boolean z = i3 > 0 && mutableRangeBounds.getStart() == i && ((Boolean) inheritsReplacementAtStart.invoke(mutableRangeBounds)).booleanValue();
                switch (WhenMappings.$EnumSwitchMapping$0[classifyOverlap(mutableRangeBounds.getStart(), mutableRangeBounds.getEnd(), i, i4).ordinal()]) {
                    case 1:
                        break;
                    case 2:
                        mutableRangeBounds.setStart((mutableRangeBounds.getStart() - i2) + i3);
                        mutableRangeBounds.setEnd((mutableRangeBounds.getEnd() - i2) + i3);
                        break;
                    case 3:
                        if (z) {
                            mutableRangeBounds.setStart(i);
                            mutableRangeBounds.setEnd(i + i3);
                        } else {
                            arrayList.add(Integer.valueOf(i5));
                        }
                        break;
                    case 4:
                        mutableRangeBounds.setEnd((mutableRangeBounds.getEnd() - i2) + i3);
                        break;
                    case 5:
                        int i7 = i + i3;
                        int start = i7 > mutableRangeBounds.getStart() ? i7 - mutableRangeBounds.getStart() : 0;
                        mutableRangeBounds.setEnd(mutableRangeBounds.getStart() + start);
                        if (start == 0) {
                            arrayList.add(Integer.valueOf(i5));
                        }
                        break;
                    case 6:
                        int end = (mutableRangeBounds.getEnd() - mutableRangeBounds.getStart()) - (i4 - mutableRangeBounds.getStart());
                        if (z) {
                            mutableRangeBounds.setStart(i);
                            mutableRangeBounds.setEnd(i + i3 + end);
                        } else {
                            mutableRangeBounds.setStart(i + i3);
                            mutableRangeBounds.setEnd(mutableRangeBounds.getStart() + end);
                            if (end == 0) {
                                arrayList.add(Integer.valueOf(i5));
                            }
                        }
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            } else if (mutableRangeBounds.getStart() == i && ((Boolean) growsAtStartOnInsert.invoke(mutableRangeBounds)).booleanValue()) {
                mutableRangeBounds.setEnd(mutableRangeBounds.getEnd() + i3);
            } else if (mutableRangeBounds.getStart() >= i) {
                mutableRangeBounds.setStart(mutableRangeBounds.getStart() + i3);
                mutableRangeBounds.setEnd(mutableRangeBounds.getEnd() + i3);
            } else if (i > mutableRangeBounds.getStart() && i < mutableRangeBounds.getEnd()) {
                mutableRangeBounds.setEnd(mutableRangeBounds.getEnd() + i3);
            }
            i5 = i6;
        }
        Iterator it2 = CollectionsKt.reversed(arrayList).iterator();
        while (it2.hasNext()) {
            ranges.remove(((Number) it2.next()).intValue());
        }
        CollectionsKt.removeAll(ranges, new Function1() { // from class: com.swmansion.enriched.markdown.input.formatting.RangeEditAdjustment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(RangeEditAdjustment.adjustForEdit$lambda$2((MutableRangeBounds) obj));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean adjustForEdit$lambda$2(MutableRangeBounds it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getEnd() - it.getStart() == 0;
    }

    private final EditOverlap classifyOverlap(int i, int i2, int i3, int i4) {
        if (i2 <= i3) {
            return EditOverlap.BEFORE_EDIT;
        }
        if (i >= i4) {
            return EditOverlap.AFTER_EDIT;
        }
        if (i >= i3 && i2 <= i4) {
            return EditOverlap.FULLY_DELETED;
        }
        if (i >= i3 || i2 <= i4) {
            return i < i3 ? EditOverlap.CLIPPED_END : EditOverlap.CLIPPED_START;
        }
        return EditOverlap.DELETED_INSIDE;
    }
}
