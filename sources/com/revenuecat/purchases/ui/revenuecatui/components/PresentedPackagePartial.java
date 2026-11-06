package com.revenuecat.purchases.ui.revenuecatui.components;

import com.google.firebase.messaging.Constants;
import com.revenuecat.purchases.paywalls.components.PartialPackageComponent;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Result;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0000H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedPackagePartial;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedPartial;", "partial", "Lcom/revenuecat/purchases/paywalls/components/PartialPackageComponent;", "(Lcom/revenuecat/purchases/paywalls/components/PartialPackageComponent;)V", "getPartial", "()Lcom/revenuecat/purchases/paywalls/components/PartialPackageComponent;", "combine", "with", "Companion", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PresentedPackagePartial implements PresentedPartial<PresentedPackagePartial> {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PartialPackageComponent partial;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PresentedPackagePartial) && Intrinsics.areEqual(this.partial, ((PresentedPackagePartial) obj).partial);
    }

    public int hashCode() {
        return this.partial.hashCode();
    }

    public String toString() {
        return "PresentedPackagePartial(partial=" + this.partial + ')';
    }

    public PresentedPackagePartial(PartialPackageComponent partial) {
        Intrinsics.checkNotNullParameter(partial, "partial");
        this.partial = partial;
    }

    public final /* synthetic */ PartialPackageComponent getPartial() {
        return this.partial;
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00042\u0006\u0010\b\u001a\u00020\tH\u0086\u0002¨\u0006\n"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedPackagePartial$Companion;", "", "()V", "invoke", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/Result;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedPackagePartial;", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyList;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError;", Constants.MessagePayloadKeys.FROM, "Lcom/revenuecat/purchases/paywalls/components/PartialPackageComponent;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final /* synthetic */ Result invoke(PartialPackageComponent from) {
            Intrinsics.checkNotNullParameter(from, "from");
            return new Result.Success(new PresentedPackagePartial(from));
        }
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.PresentedPartial
    public PresentedPackagePartial combine(PresentedPackagePartial with) {
        Boolean visible;
        PartialPackageComponent partialPackageComponent = with != null ? with.partial : null;
        if (partialPackageComponent == null || (visible = partialPackageComponent.getVisible()) == null) {
            visible = this.partial.getVisible();
        }
        return new PresentedPackagePartial(new PartialPackageComponent(visible));
    }
}
