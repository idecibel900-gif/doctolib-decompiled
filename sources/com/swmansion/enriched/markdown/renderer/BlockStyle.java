package com.swmansion.enriched.markdown.renderer;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class BlockStyle {
    private final int color;
    private final String fontFamily;
    private final float fontSize;
    private final String fontWeight;

    public static /* synthetic */ BlockStyle copy$default(BlockStyle blockStyle, float f, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f = blockStyle.fontSize;
        }
        if ((i2 & 2) != 0) {
            str = blockStyle.fontFamily;
        }
        if ((i2 & 4) != 0) {
            str2 = blockStyle.fontWeight;
        }
        if ((i2 & 8) != 0) {
            i = blockStyle.color;
        }
        return blockStyle.copy(f, str, str2, i);
    }

    public final BlockStyle copy(float f, String fontFamily, String fontWeight, int i) {
        Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        return new BlockStyle(f, fontFamily, fontWeight, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BlockStyle)) {
            return false;
        }
        BlockStyle blockStyle = (BlockStyle) obj;
        return Float.compare(this.fontSize, blockStyle.fontSize) == 0 && Intrinsics.areEqual(this.fontFamily, blockStyle.fontFamily) && Intrinsics.areEqual(this.fontWeight, blockStyle.fontWeight) && this.color == blockStyle.color;
    }

    public int hashCode() {
        return (((((Float.hashCode(this.fontSize) * 31) + this.fontFamily.hashCode()) * 31) + this.fontWeight.hashCode()) * 31) + Integer.hashCode(this.color);
    }

    public String toString() {
        return "BlockStyle(fontSize=" + this.fontSize + ", fontFamily=" + this.fontFamily + ", fontWeight=" + this.fontWeight + ", color=" + this.color + ")";
    }

    public BlockStyle(float f, String fontFamily, String fontWeight, int i) {
        Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        this.fontSize = f;
        this.fontFamily = fontFamily;
        this.fontWeight = fontWeight;
        this.color = i;
    }

    public final float getFontSize() {
        return this.fontSize;
    }

    public final String getFontFamily() {
        return this.fontFamily;
    }

    public final String getFontWeight() {
        return this.fontWeight;
    }

    public final int getColor() {
        return this.color;
    }
}
