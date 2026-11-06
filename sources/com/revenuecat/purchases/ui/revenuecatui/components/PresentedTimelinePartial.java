package com.revenuecat.purchases.ui.revenuecatui.components;

import com.revenuecat.purchases.paywalls.components.PartialTimelineComponent;
import com.revenuecat.purchases.paywalls.components.TimelineComponent;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0000H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedTimelinePartial;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedPartial;", "partial", "Lcom/revenuecat/purchases/paywalls/components/PartialTimelineComponent;", "(Lcom/revenuecat/purchases/paywalls/components/PartialTimelineComponent;)V", "getPartial", "()Lcom/revenuecat/purchases/paywalls/components/PartialTimelineComponent;", "combine", "with", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PresentedTimelinePartial implements PresentedPartial<PresentedTimelinePartial> {
    public static final int $stable = 0;
    private final PartialTimelineComponent partial;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PresentedTimelinePartial) && Intrinsics.areEqual(this.partial, ((PresentedTimelinePartial) obj).partial);
    }

    public int hashCode() {
        return this.partial.hashCode();
    }

    public String toString() {
        return "PresentedTimelinePartial(partial=" + this.partial + ')';
    }

    public PresentedTimelinePartial(PartialTimelineComponent partial) {
        Intrinsics.checkNotNullParameter(partial, "partial");
        this.partial = partial;
    }

    public final /* synthetic */ PartialTimelineComponent getPartial() {
        return this.partial;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.PresentedPartial
    public PresentedTimelinePartial combine(PresentedTimelinePartial with) {
        Boolean visible;
        Integer itemSpacing;
        Integer textSpacing;
        Integer columnGutter;
        TimelineComponent.IconAlignment iconAlignment;
        Size size;
        Padding padding;
        Padding margin;
        PartialTimelineComponent partialTimelineComponent = with != null ? with.partial : null;
        if (partialTimelineComponent == null || (visible = partialTimelineComponent.getVisible()) == null) {
            visible = this.partial.getVisible();
        }
        if (partialTimelineComponent == null || (itemSpacing = partialTimelineComponent.getItemSpacing()) == null) {
            itemSpacing = this.partial.getItemSpacing();
        }
        if (partialTimelineComponent == null || (textSpacing = partialTimelineComponent.getTextSpacing()) == null) {
            textSpacing = this.partial.getTextSpacing();
        }
        if (partialTimelineComponent == null || (columnGutter = partialTimelineComponent.getColumnGutter()) == null) {
            columnGutter = this.partial.getColumnGutter();
        }
        if (partialTimelineComponent == null || (iconAlignment = partialTimelineComponent.getIconAlignment()) == null) {
            iconAlignment = this.partial.getIconAlignment();
        }
        if (partialTimelineComponent == null || (size = partialTimelineComponent.getSize()) == null) {
            size = this.partial.getSize();
        }
        if (partialTimelineComponent == null || (padding = partialTimelineComponent.getPadding()) == null) {
            padding = this.partial.getPadding();
        }
        if (partialTimelineComponent == null || (margin = partialTimelineComponent.getMargin()) == null) {
            margin = this.partial.getMargin();
        }
        return new PresentedTimelinePartial(new PartialTimelineComponent(visible, itemSpacing, textSpacing, columnGutter, iconAlignment, size, padding, margin));
    }
}
