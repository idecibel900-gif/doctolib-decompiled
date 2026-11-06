package com.swmansion.enriched.markdown.input.formatting;

import com.swmansion.enriched.markdown.input.model.BlockRange;
import com.swmansion.enriched.markdown.input.model.BlockType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
public final class BlockStore {
    private final List ranges = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean adjustForEdit$lambda$4(BlockRange it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean adjustForEdit$lambda$5(BlockRange it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return true;
    }

    public final List getAllRanges() {
        List listUnmodifiableList = Collections.unmodifiableList(this.ranges);
        Intrinsics.checkNotNullExpressionValue(listUnmodifiableList, "unmodifiableList(...)");
        return listUnmodifiableList;
    }

    public final BlockRange blockStartingAt(int i) {
        int size = this.ranges.size() - 1;
        int i2 = 0;
        while (i2 <= size) {
            int i3 = (i2 + size) >>> 1;
            int start = ((BlockRange) this.ranges.get(i3)).getStart();
            if (start < i) {
                i2 = i3 + 1;
            } else {
                if (start <= i) {
                    return (BlockRange) this.ranges.get(i3);
                }
                size = i3 - 1;
            }
        }
        return null;
    }

    public final void setRanges(List newRanges) {
        Intrinsics.checkNotNullParameter(newRanges, "newRanges");
        this.ranges.clear();
        this.ranges.addAll(CollectionsKt.sortedWith(newRanges, new Comparator() { // from class: com.swmansion.enriched.markdown.input.formatting.BlockStore$setRanges$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((BlockRange) obj).getStart()), Integer.valueOf(((BlockRange) obj2).getStart()));
            }
        }));
        recomputeListMetadata();
    }

    public final void setBlock(BlockType type, int i, int i2, int i3, CharSequence text) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(text, "text");
        Pair pairParagraphBounds = paragraphBounds(i2, i3, text);
        int iIntValue = ((Number) pairParagraphBounds.getFirst()).intValue();
        int iIntValue2 = ((Number) pairParagraphBounds.getSecond()).intValue();
        removeBlocksOverlapping(iIntValue, iIntValue2);
        if (iIntValue2 >= iIntValue) {
            if (iIntValue2 != iIntValue || BlockType.Companion.getANCHORED().contains(type)) {
                BlockRange blockRange = new BlockRange(type, iIntValue, iIntValue2, i, 0, 16, null);
                List list = this.ranges;
                list.add(RangeEditAdjustmentKt.sortedInsertionIndex(list, iIntValue), blockRange);
            }
        }
    }

    public final void removeBlock(int i, int i2, CharSequence text) {
        Intrinsics.checkNotNullParameter(text, "text");
        Pair pairParagraphBounds = paragraphBounds(i, i2, text);
        removeBlocksOverlapping(((Number) pairParagraphBounds.getFirst()).intValue(), ((Number) pairParagraphBounds.getSecond()).intValue());
    }

    public final void adjustForEdit(int i, int i2, int i3) {
        Object next;
        if (i2 == 0 && i3 == 0) {
            return;
        }
        int i4 = i + i2;
        int i5 = i3 - i2;
        List list = this.ranges;
        ArrayList<BlockRange> arrayList = new ArrayList();
        for (Object obj : list) {
            BlockRange blockRange = (BlockRange) obj;
            if (blockRange.getLength() == 0 && BlockType.Companion.getANCHORED().contains(blockRange.getType())) {
                arrayList.add(obj);
            }
        }
        CollectionsKt.removeAll(this.ranges, new Function1() { // from class: com.swmansion.enriched.markdown.input.formatting.BlockStore$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return Boolean.valueOf(BlockStore.adjustForEdit$lambda$2((BlockRange) obj2));
            }
        });
        Iterator it = this.ranges.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            BlockRange blockRange2 = (BlockRange) next;
            if (BlockType.Companion.getANCHORED().contains(blockRange2.getType()) && blockRange2.getStart() >= i && blockRange2.getEnd() == i4) {
                break;
            }
        }
        BlockRange blockRange3 = (BlockRange) next;
        RangeEditAdjustment.INSTANCE.adjustForEdit(this.ranges, i, i2, i3, new Function1() { // from class: com.swmansion.enriched.markdown.input.formatting.BlockStore$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return Boolean.valueOf(BlockStore.adjustForEdit$lambda$4((BlockRange) obj2));
            }
        }, new Function1() { // from class: com.swmansion.enriched.markdown.input.formatting.BlockStore$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return Boolean.valueOf(BlockStore.adjustForEdit$lambda$5((BlockRange) obj2));
            }
        });
        for (BlockRange blockRange4 : arrayList) {
            if (blockRange4.getStart() > i) {
                if (blockRange4.getStart() >= i4) {
                    blockRange4.setStart(blockRange4.getStart() + i5);
                    blockRange4.setEnd(blockRange4.getStart());
                }
            }
            List list2 = this.ranges;
            list2.add(RangeEditAdjustmentKt.sortedInsertionIndex(list2, blockRange4.getStart()), blockRange4);
        }
        if (blockRange3 == null || this.ranges.contains(blockRange3)) {
            return;
        }
        List list3 = this.ranges;
        list3.add(RangeEditAdjustmentKt.sortedInsertionIndex(list3, i), new BlockRange(blockRange3.getType(), i, i, blockRange3.getLevel(), 0, 16, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean adjustForEdit$lambda$2(BlockRange it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getLength() == 0;
    }

    public final void normalizeToLineBounds(CharSequence text) {
        Intrinsics.checkNotNullParameter(text, "text");
        if (this.ranges.isEmpty()) {
            return;
        }
        ListIterator listIterator = this.ranges.listIterator();
        int i = -1;
        while (listIterator.hasNext()) {
            BlockRange blockRange = (BlockRange) listIterator.next();
            Pair pairParagraphBounds = paragraphBounds(blockRange.getStart(), blockRange.getStart(), text);
            int iIntValue = ((Number) pairParagraphBounds.getFirst()).intValue();
            int iIntValue2 = ((Number) pairParagraphBounds.getSecond()).intValue();
            if ((iIntValue2 == iIntValue && !BlockType.Companion.getANCHORED().contains(blockRange.getType())) || iIntValue <= i) {
                listIterator.remove();
            } else {
                blockRange.setStart(iIntValue);
                blockRange.setEnd(iIntValue2);
                i = iIntValue2;
            }
        }
        recomputeListMetadata();
    }

    private final void recomputeListMetadata() {
        BlockType[] blockTypeArr;
        int[] iArr = new int[7];
        BlockType[] blockTypeArr2 = new BlockType[7];
        int i = -2;
        while (true) {
            int level = -1;
            for (BlockRange blockRange : this.ranges) {
                if (BlockType.Companion.getLIST_ITEMS().contains(blockRange.getType())) {
                    boolean z = level >= 0 && blockRange.getStart() == i + 1;
                    if (z) {
                        blockTypeArr = blockTypeArr2;
                    } else {
                        ArraysKt.fill$default(iArr, 0, 0, 0, 6, (Object) null);
                        blockTypeArr = blockTypeArr2;
                        ArraysKt.fill$default(blockTypeArr, (Object) null, 0, 0, 6, (Object) null);
                    }
                    int i2 = z ? level + 1 : 0;
                    if (blockRange.getLevel() > i2) {
                        blockRange.setLevel(i2);
                    }
                    int level2 = blockRange.getLevel();
                    for (int i3 = level2 + 1; i3 < 7; i3++) {
                        iArr[i3] = 0;
                        blockTypeArr[i3] = null;
                    }
                    if (blockTypeArr[level2] != blockRange.getType()) {
                        iArr[level2] = 0;
                        blockTypeArr[level2] = blockRange.getType();
                    }
                    int i4 = iArr[level2] + 1;
                    iArr[level2] = i4;
                    blockRange.setOrdinal(i4);
                    int end = blockRange.getEnd();
                    level = blockRange.getLevel();
                    blockTypeArr2 = blockTypeArr;
                    i = end;
                }
            }
            return;
        }
    }

    private final void removeBlocksOverlapping(final int i, final int i2) {
        CollectionsKt.removeAll(this.ranges, new Function1() { // from class: com.swmansion.enriched.markdown.input.formatting.BlockStore$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(BlockStore.removeBlocksOverlapping$lambda$6(i, i2, (BlockRange) obj));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean removeBlocksOverlapping$lambda$6(int i, int i2, BlockRange it) {
        int start;
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.getEnd() <= i || it.getStart() >= i2) {
            return it.getLength() == 0 && i <= (start = it.getStart()) && start <= i2;
        }
        return true;
    }

    private final Pair paragraphBounds(int i, int i2, CharSequence charSequence) {
        if (charSequence.length() == 0) {
            return TuplesKt.to(0, 0);
        }
        int iCoerceIn = RangesKt.coerceIn(i, 0, charSequence.length());
        int iCoerceIn2 = RangesKt.coerceIn(i2, iCoerceIn, charSequence.length());
        while (iCoerceIn > 0 && charSequence.charAt(iCoerceIn - 1) != '\n') {
            iCoerceIn--;
        }
        while (iCoerceIn2 < charSequence.length() && charSequence.charAt(iCoerceIn2) != '\n') {
            iCoerceIn2++;
        }
        return TuplesKt.to(Integer.valueOf(iCoerceIn), Integer.valueOf(iCoerceIn2));
    }
}
