package com.swmansion.enriched.markdown.renderer;

import com.swmansion.enriched.markdown.styles.BaseBlockStyle;
import com.swmansion.enriched.markdown.styles.BlockquoteStyle;
import com.swmansion.enriched.markdown.styles.CodeBlockStyle;
import com.swmansion.enriched.markdown.styles.HeadingStyle;
import com.swmansion.enriched.markdown.styles.ListStyle;
import com.swmansion.enriched.markdown.styles.ParagraphStyle;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArrayDeque;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class BlockStyleContext {
    private int accumulatedIndent;
    private int blockquoteDepth;
    private int currentHeadingLevel;
    private int listDepth;
    private int listItemNumber;
    private ListType listType;
    private int taskItemCount;
    private BlockType currentBlockType = BlockType.NONE;
    private final ArrayDeque blockStyleStack = new ArrayDeque();
    private final List listItemStarts = new ArrayList();
    private final ArrayDeque orderedListItemNumbers = new ArrayDeque();

    public enum ListType {
        UNORDERED,
        ORDERED;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    }

    public final BlockType getCurrentBlockType() {
        return this.currentBlockType;
    }

    public final int getBlockquoteDepth() {
        return this.blockquoteDepth;
    }

    public final void setBlockquoteDepth(int i) {
        this.blockquoteDepth = i;
    }

    public final int getListDepth() {
        return this.listDepth;
    }

    public final void setListDepth(int i) {
        this.listDepth = i;
    }

    public final ListType getListType() {
        return this.listType;
    }

    public final void setListType(ListType listType) {
        this.listType = listType;
    }

    public final int getListItemNumber() {
        return this.listItemNumber;
    }

    public final int getTaskItemCount() {
        return this.taskItemCount;
    }

    public final void setTaskItemCount(int i) {
        this.taskItemCount = i;
    }

    public final int getAccumulatedIndent() {
        return this.accumulatedIndent;
    }

    public final void setAccumulatedIndent(int i) {
        this.accumulatedIndent = i;
    }

    public final List getListItemStarts() {
        return this.listItemStarts;
    }

    static /* synthetic */ void pushBlockStyle$default(BlockStyleContext blockStyleContext, BlockType blockType, BaseBlockStyle baseBlockStyle, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        blockStyleContext.pushBlockStyle(blockType, baseBlockStyle, i);
    }

    private final void pushBlockStyle(BlockType blockType, BaseBlockStyle baseBlockStyle, int i) {
        this.blockStyleStack.addLast(new BlockStyleEntry(blockType, new BlockStyle(baseBlockStyle.getFontSize(), baseBlockStyle.getFontFamily(), baseBlockStyle.getFontWeight(), baseBlockStyle.getColor()), i));
        this.currentBlockType = blockType;
        this.currentHeadingLevel = i;
    }

    public final void popBlockStyle() {
        if (!this.blockStyleStack.isEmpty()) {
            this.blockStyleStack.removeLast();
        }
        BlockStyleEntry blockStyleEntry = (BlockStyleEntry) this.blockStyleStack.lastOrNull();
        if (blockStyleEntry != null) {
            this.currentBlockType = blockStyleEntry.getBlockType();
            this.currentHeadingLevel = blockStyleEntry.getHeadingLevel();
        } else {
            this.currentBlockType = BlockType.NONE;
            this.currentHeadingLevel = 0;
        }
    }

    public final void setParagraphStyle(ParagraphStyle style) {
        Intrinsics.checkNotNullParameter(style, "style");
        pushBlockStyle$default(this, BlockType.PARAGRAPH, style, 0, 4, null);
    }

    public final void setHeadingStyle(HeadingStyle style, int i) {
        Intrinsics.checkNotNullParameter(style, "style");
        pushBlockStyle(BlockType.HEADING, style, i);
    }

    public final void setBlockquoteStyle(BlockquoteStyle style) {
        Intrinsics.checkNotNullParameter(style, "style");
        pushBlockStyle$default(this, BlockType.BLOCKQUOTE, style, 0, 4, null);
    }

    public final void setUnorderedListStyle(ListStyle style) {
        Intrinsics.checkNotNullParameter(style, "style");
        this.listType = ListType.UNORDERED;
        pushBlockStyle$default(this, BlockType.UNORDERED_LIST, style, 0, 4, null);
    }

    public final void setOrderedListStyle(ListStyle style) {
        Intrinsics.checkNotNullParameter(style, "style");
        this.listType = ListType.ORDERED;
        pushBlockStyle$default(this, BlockType.ORDERED_LIST, style, 0, 4, null);
    }

    public final void setCodeBlockStyle(CodeBlockStyle style) {
        Intrinsics.checkNotNullParameter(style, "style");
        pushBlockStyle$default(this, BlockType.CODE_BLOCK, style, 0, 4, null);
    }

    public final boolean isInsideBlockElement() {
        return this.blockquoteDepth > 0 || this.listDepth > 0;
    }

    public final void incrementListItemNumber() {
        this.listItemNumber++;
    }

    public final void resetListItemNumber(int i) {
        this.listItemNumber = i - 1;
    }

    public final void pushOrderedListItemNumber() {
        this.orderedListItemNumbers.addLast(Integer.valueOf(this.listItemNumber));
    }

    public final void popOrderedListItemNumber() {
        if (this.orderedListItemNumbers.isEmpty()) {
            return;
        }
        this.listItemNumber = ((Number) this.orderedListItemNumbers.removeLast()).intValue();
    }

    public final void clearListStyle() {
        popBlockStyle();
        if (this.listDepth == 0) {
            this.listType = null;
            this.listItemNumber = 0;
            this.orderedListItemNumbers.clear();
        }
    }

    public final BlockStyle requireBlockStyle() {
        BlockStyle blockStyle;
        BlockStyleEntry blockStyleEntry = (BlockStyleEntry) this.blockStyleStack.lastOrNull();
        if (blockStyleEntry == null || (blockStyle = blockStyleEntry.getBlockStyle()) == null) {
            throw new IllegalStateException("BlockStyle is null. Inline renderers must be used within a block context.");
        }
        return blockStyle;
    }

    public final void resetForNewRender() {
        this.blockStyleStack.clear();
        this.currentBlockType = BlockType.NONE;
        this.currentHeadingLevel = 0;
        this.blockquoteDepth = 0;
        this.listDepth = 0;
        this.listType = null;
        this.listItemNumber = 0;
        this.taskItemCount = 0;
        this.accumulatedIndent = 0;
        this.listItemStarts.clear();
        this.orderedListItemNumbers.clear();
    }
}
