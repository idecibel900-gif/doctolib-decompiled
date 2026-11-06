package com.swmansion.enriched.markdown.input.model;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class BlockRange implements MutableRangeBounds {
    private int end;
    private int level;
    private int ordinal;
    private int start;
    private final BlockType type;

    public BlockRange(BlockType type, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.start = i;
        this.end = i2;
        this.level = i3;
        this.ordinal = i4;
    }

    public /* synthetic */ BlockRange(BlockType blockType, int i, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(blockType, i, i2, (i5 & 8) != 0 ? 0 : i3, (i5 & 16) != 0 ? 1 : i4);
    }

    public final BlockType getType() {
        return this.type;
    }

    @Override // com.swmansion.enriched.markdown.input.model.MutableRangeBounds
    public int getStart() {
        return this.start;
    }

    @Override // com.swmansion.enriched.markdown.input.model.MutableRangeBounds
    public void setStart(int i) {
        this.start = i;
    }

    @Override // com.swmansion.enriched.markdown.input.model.MutableRangeBounds
    public int getEnd() {
        return this.end;
    }

    @Override // com.swmansion.enriched.markdown.input.model.MutableRangeBounds
    public void setEnd(int i) {
        this.end = i;
    }

    public final int getLevel() {
        return this.level;
    }

    public final void setLevel(int i) {
        this.level = i;
    }

    public final int getOrdinal() {
        return this.ordinal;
    }

    public final void setOrdinal(int i) {
        this.ordinal = i;
    }

    public final int getLength() {
        return getEnd() - getStart();
    }
}
