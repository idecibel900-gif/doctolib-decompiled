package com.swmansion.enriched.markdown.input.editing;

import android.text.Editable;
import com.swmansion.enriched.markdown.input.formatting.BlockStore;
import com.swmansion.enriched.markdown.input.model.BlockRange;
import com.swmansion.enriched.markdown.input.model.BlockType;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
public final class BlockEditCoordinator {
    private final BlockStore blockStore;

    public enum DepthChangeResult {
        CHANGED,
        STARTED_LIST,
        EXITED_LIST,
        NO_OP;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    }

    public BlockEditCoordinator(BlockStore blockStore) {
        Intrinsics.checkNotNullParameter(blockStore, "blockStore");
        this.blockStore = blockStore;
    }

    public final BlockRange blockAtPosition(CharSequence text, int i) {
        Intrinsics.checkNotNullParameter(text, "text");
        return this.blockStore.blockStartingAt(lineStartOf(text, i));
    }

    public final BlockRange listBlockAtPosition(CharSequence text, int i) {
        Intrinsics.checkNotNullParameter(text, "text");
        BlockRange blockRangeBlockAtPosition = blockAtPosition(text, i);
        if (blockRangeBlockAtPosition == null || !BlockType.Companion.getLIST_ITEMS().contains(blockRangeBlockAtPosition.getType())) {
            return null;
        }
        return blockRangeBlockAtPosition;
    }

    public final BlockRange listBlockAtLineStart(int i) {
        BlockRange blockRangeBlockStartingAt = this.blockStore.blockStartingAt(i);
        if (blockRangeBlockStartingAt == null || !BlockType.Companion.getLIST_ITEMS().contains(blockRangeBlockStartingAt.getType())) {
            return null;
        }
        return blockRangeBlockStartingAt;
    }

    public final int headingLevelAtPosition(CharSequence text, int i) {
        Intrinsics.checkNotNullParameter(text, "text");
        BlockRange blockRangeBlockAtPosition = blockAtPosition(text, i);
        if (blockRangeBlockAtPosition != null && BlockType.Companion.getHEADINGS().contains(blockRangeBlockAtPosition.getType())) {
            return blockRangeBlockAtPosition.getLevel();
        }
        return 0;
    }

    public final Pair listStateAtPosition(CharSequence text, int i, BlockType type) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(type, "type");
        BlockRange blockRangeListBlockAtPosition = listBlockAtPosition(text, i);
        if (blockRangeListBlockAtPosition != null && blockRangeListBlockAtPosition.getType() == type) {
            return TuplesKt.to(Boolean.TRUE, Integer.valueOf(blockRangeListBlockAtPosition.getLevel()));
        }
        return TuplesKt.to(Boolean.FALSE, 0);
    }

    public final boolean toggleBlock(Editable text, BlockType type, int i, int i2, int i3) {
        Editable editable;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(type, "type");
        BlockRange blockRangeBlockAtPosition = blockAtPosition(text, i2);
        boolean z = blockRangeBlockAtPosition != null && blockRangeBlockAtPosition.getType() == type && blockRangeBlockAtPosition.getLevel() == i;
        if (z) {
            this.blockStore.removeBlock(i2, i3, text);
        } else {
            int iLineStartOf = lineStartOf(text, i2);
            while (iLineStartOf <= text.length()) {
                int iLineEndOf = lineEndOf(text, iLineStartOf);
                editable = text;
                BlockType blockType = type;
                int i4 = i;
                this.blockStore.setBlock(blockType, i4, iLineStartOf, iLineEndOf, editable);
                if (iLineEndOf >= i3) {
                    this.blockStore.normalizeToLineBounds(editable);
                    return z;
                }
                iLineStartOf = iLineEndOf + 1;
                type = blockType;
                i = i4;
                text = editable;
            }
        }
        editable = text;
        this.blockStore.normalizeToLineBounds(editable);
        return z;
    }

    public final boolean toggleList(Editable text, BlockType type, int i, int i2, int i3) {
        Editable editable;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(type, "type");
        BlockRange blockRangeListBlockAtPosition = listBlockAtPosition(text, i);
        boolean z = (blockRangeListBlockAtPosition != null ? blockRangeListBlockAtPosition.getType() : null) == type;
        if (z) {
            int iLineStartOf = lineStartOf(text, i2);
            while (iLineStartOf <= text.length()) {
                int iLineEndOf = lineEndOf(text, iLineStartOf);
                this.blockStore.removeBlock(iLineStartOf, iLineEndOf, text);
                if (iLineEndOf >= i3) {
                    break;
                }
                iLineStartOf = iLineEndOf + 1;
            }
        } else {
            int iLineStartOf2 = lineStartOf(text, i2);
            while (iLineStartOf2 <= text.length()) {
                int iLineEndOf2 = lineEndOf(text, iLineStartOf2);
                BlockRange blockRangeListBlockAtLineStart = listBlockAtLineStart(iLineStartOf2);
                editable = text;
                BlockType blockType = type;
                this.blockStore.setBlock(blockType, blockRangeListBlockAtLineStart != null ? blockRangeListBlockAtLineStart.getLevel() : 0, iLineStartOf2, iLineEndOf2, editable);
                if (iLineEndOf2 >= i3) {
                    this.blockStore.normalizeToLineBounds(editable);
                    return z;
                }
                iLineStartOf2 = iLineEndOf2 + 1;
                type = blockType;
                text = editable;
            }
        }
        editable = text;
        this.blockStore.normalizeToLineBounds(editable);
        return z;
    }

    public final DepthChangeResult changeDepth(Editable text, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(text, "text");
        BlockRange blockRangeListBlockAtPosition = listBlockAtPosition(text, i);
        if (blockRangeListBlockAtPosition == null) {
            if (i4 > 0 && blockAtPosition(text, i) == null) {
                toggleList(text, BlockType.UNORDERED_LIST_ITEM, i, i2, i3);
                return DepthChangeResult.STARTED_LIST;
            }
            return DepthChangeResult.NO_OP;
        }
        Editable editable = text;
        if (i4 < 0 && blockRangeListBlockAtPosition.getLevel() == 0) {
            toggleList(editable, blockRangeListBlockAtPosition.getType(), i, i2, i3);
            return DepthChangeResult.EXITED_LIST;
        }
        int iLineStartOf = lineStartOf(editable, i2);
        while (iLineStartOf <= editable.length()) {
            int iLineEndOf = lineEndOf(editable, iLineStartOf);
            BlockRange blockRangeListBlockAtLineStart = listBlockAtLineStart(iLineStartOf);
            if (blockRangeListBlockAtLineStart != null) {
                Editable editable2 = editable;
                this.blockStore.setBlock(blockRangeListBlockAtLineStart.getType(), RangesKt.coerceIn(blockRangeListBlockAtLineStart.getLevel() + i4, 0, 5), iLineStartOf, iLineStartOf, editable2);
                editable = editable2;
            }
            if (iLineEndOf >= i3) {
                break;
            }
            iLineStartOf = iLineEndOf + 1;
        }
        this.blockStore.normalizeToLineBounds(editable);
        return DepthChangeResult.CHANGED;
    }

    public final int lineStartOf(CharSequence text, int i) {
        Intrinsics.checkNotNullParameter(text, "text");
        int iCoerceIn = RangesKt.coerceIn(i, 0, text.length());
        while (iCoerceIn > 0 && !EditPipelineKt.isLineBreak(text.charAt(iCoerceIn - 1))) {
            iCoerceIn--;
        }
        return iCoerceIn;
    }

    public final int lineEndOf(CharSequence text, int i) {
        Intrinsics.checkNotNullParameter(text, "text");
        int iCoerceIn = RangesKt.coerceIn(i, 0, text.length());
        while (iCoerceIn < text.length() && !EditPipelineKt.isLineBreak(text.charAt(iCoerceIn))) {
            iCoerceIn++;
        }
        return iCoerceIn;
    }
}
