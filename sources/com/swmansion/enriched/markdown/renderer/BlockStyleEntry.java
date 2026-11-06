package com.swmansion.enriched.markdown.renderer;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
final class BlockStyleEntry {
    private final BlockStyle blockStyle;
    private final BlockType blockType;
    private final int headingLevel;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BlockStyleEntry)) {
            return false;
        }
        BlockStyleEntry blockStyleEntry = (BlockStyleEntry) obj;
        return this.blockType == blockStyleEntry.blockType && Intrinsics.areEqual(this.blockStyle, blockStyleEntry.blockStyle) && this.headingLevel == blockStyleEntry.headingLevel;
    }

    public int hashCode() {
        return (((this.blockType.hashCode() * 31) + this.blockStyle.hashCode()) * 31) + Integer.hashCode(this.headingLevel);
    }

    public String toString() {
        return "BlockStyleEntry(blockType=" + this.blockType + ", blockStyle=" + this.blockStyle + ", headingLevel=" + this.headingLevel + ")";
    }

    public BlockStyleEntry(BlockType blockType, BlockStyle blockStyle, int i) {
        Intrinsics.checkNotNullParameter(blockType, "blockType");
        Intrinsics.checkNotNullParameter(blockStyle, "blockStyle");
        this.blockType = blockType;
        this.blockStyle = blockStyle;
        this.headingLevel = i;
    }

    public final BlockType getBlockType() {
        return this.blockType;
    }

    public final BlockStyle getBlockStyle() {
        return this.blockStyle;
    }

    public final int getHeadingLevel() {
        return this.headingLevel;
    }
}
