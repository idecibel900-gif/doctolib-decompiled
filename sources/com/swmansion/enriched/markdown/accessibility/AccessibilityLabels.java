package com.swmansion.enriched.markdown.accessibility;

import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class AccessibilityLabels {
    private final String blockquote;
    private final String bulletPoint;
    private final String mathEquation;
    private final String nestedBlockquote;
    private final String nestedBulletPoint;
    private final String nestedOrderedItem;
    private final String orderedItem;
    private final String rotorHeadings;
    private final String rotorImages;
    private final String rotorLinks;
    private final String tableRow;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccessibilityLabels)) {
            return false;
        }
        AccessibilityLabels accessibilityLabels = (AccessibilityLabels) obj;
        return Intrinsics.areEqual(this.bulletPoint, accessibilityLabels.bulletPoint) && Intrinsics.areEqual(this.nestedBulletPoint, accessibilityLabels.nestedBulletPoint) && Intrinsics.areEqual(this.orderedItem, accessibilityLabels.orderedItem) && Intrinsics.areEqual(this.nestedOrderedItem, accessibilityLabels.nestedOrderedItem) && Intrinsics.areEqual(this.blockquote, accessibilityLabels.blockquote) && Intrinsics.areEqual(this.nestedBlockquote, accessibilityLabels.nestedBlockquote) && Intrinsics.areEqual(this.tableRow, accessibilityLabels.tableRow) && Intrinsics.areEqual(this.mathEquation, accessibilityLabels.mathEquation) && Intrinsics.areEqual(this.rotorHeadings, accessibilityLabels.rotorHeadings) && Intrinsics.areEqual(this.rotorLinks, accessibilityLabels.rotorLinks) && Intrinsics.areEqual(this.rotorImages, accessibilityLabels.rotorImages);
    }

    public int hashCode() {
        return (((((((((((((((((((this.bulletPoint.hashCode() * 31) + this.nestedBulletPoint.hashCode()) * 31) + this.orderedItem.hashCode()) * 31) + this.nestedOrderedItem.hashCode()) * 31) + this.blockquote.hashCode()) * 31) + this.nestedBlockquote.hashCode()) * 31) + this.tableRow.hashCode()) * 31) + this.mathEquation.hashCode()) * 31) + this.rotorHeadings.hashCode()) * 31) + this.rotorLinks.hashCode()) * 31) + this.rotorImages.hashCode();
    }

    public String toString() {
        return "AccessibilityLabels(bulletPoint=" + this.bulletPoint + ", nestedBulletPoint=" + this.nestedBulletPoint + ", orderedItem=" + this.orderedItem + ", nestedOrderedItem=" + this.nestedOrderedItem + ", blockquote=" + this.blockquote + ", nestedBlockquote=" + this.nestedBlockquote + ", tableRow=" + this.tableRow + ", mathEquation=" + this.mathEquation + ", rotorHeadings=" + this.rotorHeadings + ", rotorLinks=" + this.rotorLinks + ", rotorImages=" + this.rotorImages + ")";
    }

    public AccessibilityLabels(String bulletPoint, String nestedBulletPoint, String orderedItem, String nestedOrderedItem, String blockquote, String nestedBlockquote, String tableRow, String mathEquation, String rotorHeadings, String rotorLinks, String rotorImages) {
        Intrinsics.checkNotNullParameter(bulletPoint, "bulletPoint");
        Intrinsics.checkNotNullParameter(nestedBulletPoint, "nestedBulletPoint");
        Intrinsics.checkNotNullParameter(orderedItem, "orderedItem");
        Intrinsics.checkNotNullParameter(nestedOrderedItem, "nestedOrderedItem");
        Intrinsics.checkNotNullParameter(blockquote, "blockquote");
        Intrinsics.checkNotNullParameter(nestedBlockquote, "nestedBlockquote");
        Intrinsics.checkNotNullParameter(tableRow, "tableRow");
        Intrinsics.checkNotNullParameter(mathEquation, "mathEquation");
        Intrinsics.checkNotNullParameter(rotorHeadings, "rotorHeadings");
        Intrinsics.checkNotNullParameter(rotorLinks, "rotorLinks");
        Intrinsics.checkNotNullParameter(rotorImages, "rotorImages");
        this.bulletPoint = bulletPoint;
        this.nestedBulletPoint = nestedBulletPoint;
        this.orderedItem = orderedItem;
        this.nestedOrderedItem = nestedOrderedItem;
        this.blockquote = blockquote;
        this.nestedBlockquote = nestedBlockquote;
        this.tableRow = tableRow;
        this.mathEquation = mathEquation;
        this.rotorHeadings = rotorHeadings;
        this.rotorLinks = rotorLinks;
        this.rotorImages = rotorImages;
    }

    public /* synthetic */ AccessibilityLabels(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) != 0 ? "" : str7, (i & 128) != 0 ? "" : str8, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? "" : str9, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? "" : str10, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? "" : str11);
    }

    public final String getBulletPoint() {
        return this.bulletPoint;
    }

    public final String getNestedBulletPoint() {
        return this.nestedBulletPoint;
    }

    public final String getOrderedItem() {
        return this.orderedItem;
    }

    public final String getNestedOrderedItem() {
        return this.nestedOrderedItem;
    }

    public final String getBlockquote() {
        return this.blockquote;
    }

    public final String getNestedBlockquote() {
        return this.nestedBlockquote;
    }

    public final String getTableRow() {
        return this.tableRow;
    }
}
