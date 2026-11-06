package com.revenuecat.purchases.ui.revenuecatui.components;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.paywalls.components.common.ComponentOverride;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedPartial;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B\u001b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0002\u0010\bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0007\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedOverride;", "T", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedPartial;", "", "conditions", "", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition;", DiagnosticsEntry.PROPERTIES_KEY, "(Ljava/util/List;Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedPartial;)V", "getConditions", "()Ljava/util/List;", "getProperties", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedPartial;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedPartial;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PresentedOverride<T extends PresentedPartial<T>> {
    public static final int $stable = 8;
    private final List<ComponentOverride.Condition> conditions;
    private final T properties;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PresentedOverride)) {
            return false;
        }
        PresentedOverride presentedOverride = (PresentedOverride) obj;
        return Intrinsics.areEqual(this.conditions, presentedOverride.conditions) && Intrinsics.areEqual(this.properties, presentedOverride.properties);
    }

    public int hashCode() {
        return (this.conditions.hashCode() * 31) + this.properties.hashCode();
    }

    public String toString() {
        return "PresentedOverride(conditions=" + this.conditions + ", properties=" + this.properties + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PresentedOverride(List<? extends ComponentOverride.Condition> conditions, T properties) {
        Intrinsics.checkNotNullParameter(conditions, "conditions");
        Intrinsics.checkNotNullParameter(properties, "properties");
        this.conditions = conditions;
        this.properties = properties;
    }

    public final /* synthetic */ List getConditions() {
        return this.conditions;
    }

    public final /* synthetic */ PresentedPartial getProperties() {
        return this.properties;
    }
}
