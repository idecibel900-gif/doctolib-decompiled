package com.revenuecat.purchases.ui.revenuecatui.components.style;

import com.revenuecat.purchases.paywalls.components.CountdownComponent;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/style/CountdownComponentStyle;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;", "date", "Ljava/util/Date;", "countFrom", "Lcom/revenuecat/purchases/paywalls/components/CountdownComponent$CountFrom;", "countdownStackComponentStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;", "endStackComponentStyle", "fallbackStackComponentStyle", "(Ljava/util/Date;Lcom/revenuecat/purchases/paywalls/components/CountdownComponent$CountFrom;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;)V", "getCountFrom", "()Lcom/revenuecat/purchases/paywalls/components/CountdownComponent$CountFrom;", "getCountdownStackComponentStyle", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;", "getDate", "()Ljava/util/Date;", "getEndStackComponentStyle", "getFallbackStackComponentStyle", "size", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "getSize", "()Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "visible", "", "getVisible", "()Z", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CountdownComponentStyle implements ComponentStyle {
    public static final int $stable = 0;
    private final CountdownComponent.CountFrom countFrom;
    private final StackComponentStyle countdownStackComponentStyle;
    private final Date date;
    private final StackComponentStyle endStackComponentStyle;
    private final StackComponentStyle fallbackStackComponentStyle;
    private final Size size;
    private final boolean visible;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CountdownComponentStyle)) {
            return false;
        }
        CountdownComponentStyle countdownComponentStyle = (CountdownComponentStyle) obj;
        return Intrinsics.areEqual(this.date, countdownComponentStyle.date) && this.countFrom == countdownComponentStyle.countFrom && Intrinsics.areEqual(this.countdownStackComponentStyle, countdownComponentStyle.countdownStackComponentStyle) && Intrinsics.areEqual(this.endStackComponentStyle, countdownComponentStyle.endStackComponentStyle) && Intrinsics.areEqual(this.fallbackStackComponentStyle, countdownComponentStyle.fallbackStackComponentStyle);
    }

    public int hashCode() {
        int iHashCode = ((((this.date.hashCode() * 31) + this.countFrom.hashCode()) * 31) + this.countdownStackComponentStyle.hashCode()) * 31;
        StackComponentStyle stackComponentStyle = this.endStackComponentStyle;
        int iHashCode2 = (iHashCode + (stackComponentStyle == null ? 0 : stackComponentStyle.hashCode())) * 31;
        StackComponentStyle stackComponentStyle2 = this.fallbackStackComponentStyle;
        return iHashCode2 + (stackComponentStyle2 != null ? stackComponentStyle2.hashCode() : 0);
    }

    public String toString() {
        return "CountdownComponentStyle(date=" + this.date + ", countFrom=" + this.countFrom + ", countdownStackComponentStyle=" + this.countdownStackComponentStyle + ", endStackComponentStyle=" + this.endStackComponentStyle + ", fallbackStackComponentStyle=" + this.fallbackStackComponentStyle + ')';
    }

    public CountdownComponentStyle(Date date, CountdownComponent.CountFrom countFrom, StackComponentStyle countdownStackComponentStyle, StackComponentStyle stackComponentStyle, StackComponentStyle stackComponentStyle2) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(countFrom, "countFrom");
        Intrinsics.checkNotNullParameter(countdownStackComponentStyle, "countdownStackComponentStyle");
        this.date = date;
        this.countFrom = countFrom;
        this.countdownStackComponentStyle = countdownStackComponentStyle;
        this.endStackComponentStyle = stackComponentStyle;
        this.fallbackStackComponentStyle = stackComponentStyle2;
        this.visible = countdownStackComponentStyle.getVisible();
        this.size = countdownStackComponentStyle.getSize();
    }

    public final /* synthetic */ Date getDate() {
        return this.date;
    }

    public final /* synthetic */ CountdownComponent.CountFrom getCountFrom() {
        return this.countFrom;
    }

    public final /* synthetic */ StackComponentStyle getCountdownStackComponentStyle() {
        return this.countdownStackComponentStyle;
    }

    public final /* synthetic */ StackComponentStyle getEndStackComponentStyle() {
        return this.endStackComponentStyle;
    }

    public final /* synthetic */ StackComponentStyle getFallbackStackComponentStyle() {
        return this.fallbackStackComponentStyle;
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
