package com.revenuecat.purchases.ui.revenuecatui.components.style;

import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StickyFooterComponentStyle;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;", "stackComponentStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;)V", "size", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "getSize", "()Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "getStackComponentStyle", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;", "visible", "", "getVisible", "()Z", "component1", "copy", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class StickyFooterComponentStyle implements ComponentStyle {
    public static final int $stable = 0;
    private final Size size;
    private final StackComponentStyle stackComponentStyle;
    private final boolean visible;

    public static /* synthetic */ StickyFooterComponentStyle copy$default(StickyFooterComponentStyle stickyFooterComponentStyle, StackComponentStyle stackComponentStyle, int i, Object obj) {
        if ((i & 1) != 0) {
            stackComponentStyle = stickyFooterComponentStyle.stackComponentStyle;
        }
        return stickyFooterComponentStyle.copy(stackComponentStyle);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final StackComponentStyle getStackComponentStyle() {
        return this.stackComponentStyle;
    }

    public final StickyFooterComponentStyle copy(StackComponentStyle stackComponentStyle) {
        Intrinsics.checkNotNullParameter(stackComponentStyle, "stackComponentStyle");
        return new StickyFooterComponentStyle(stackComponentStyle);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof StickyFooterComponentStyle) && Intrinsics.areEqual(this.stackComponentStyle, ((StickyFooterComponentStyle) other).stackComponentStyle);
    }

    public int hashCode() {
        return this.stackComponentStyle.hashCode();
    }

    public String toString() {
        return "StickyFooterComponentStyle(stackComponentStyle=" + this.stackComponentStyle + ')';
    }

    public StickyFooterComponentStyle(StackComponentStyle stackComponentStyle) {
        Intrinsics.checkNotNullParameter(stackComponentStyle, "stackComponentStyle");
        this.stackComponentStyle = stackComponentStyle;
        this.visible = stackComponentStyle.getVisible();
        this.size = stackComponentStyle.getSize();
    }

    public final /* synthetic */ StackComponentStyle getStackComponentStyle() {
        return this.stackComponentStyle;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle
    public boolean getVisible() {
        return this.visible;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle
    public Size getSize() {
        return this.size;
    }
}
