package com.revenuecat.purchases.ui.revenuecatui.customercenter;

import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.customercenter.CustomerCenterListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0011B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0011\b\u0000\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/CustomerCenterOptions;", "", "builder", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/CustomerCenterOptions$Builder;", "(Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/CustomerCenterOptions$Builder;)V", "listener", "Lcom/revenuecat/purchases/customercenter/CustomerCenterListener;", "(Lcom/revenuecat/purchases/customercenter/CustomerCenterListener;)V", "getListener$revenuecatui_defaultsBc8Release", "()Lcom/revenuecat/purchases/customercenter/CustomerCenterListener;", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "", "Builder", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CustomerCenterOptions {
    public static final int $stable = 8;
    private final CustomerCenterListener listener;

    public CustomerCenterOptions(CustomerCenterListener customerCenterListener) {
        this.listener = customerCenterListener;
    }

    /* JADX INFO: renamed from: getListener$revenuecatui_defaultsBc8Release, reason: from getter */
    public final CustomerCenterListener getListener() {
        return this.listener;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomerCenterOptions(Builder builder) {
        this(builder.getListener());
        Intrinsics.checkNotNullParameter(builder, "builder");
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/CustomerCenterOptions$Builder;", "", "()V", "listener", "Lcom/revenuecat/purchases/customercenter/CustomerCenterListener;", "getListener$revenuecatui_defaultsBc8Release", "()Lcom/revenuecat/purchases/customercenter/CustomerCenterListener;", "setListener$revenuecatui_defaultsBc8Release", "(Lcom/revenuecat/purchases/customercenter/CustomerCenterListener;)V", "build", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/CustomerCenterOptions;", "setListener", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private CustomerCenterListener listener;

        /* JADX INFO: renamed from: getListener$revenuecatui_defaultsBc8Release, reason: from getter */
        public final CustomerCenterListener getListener() {
            return this.listener;
        }

        public final void setListener$revenuecatui_defaultsBc8Release(CustomerCenterListener customerCenterListener) {
            this.listener = customerCenterListener;
        }

        public final Builder setListener(CustomerCenterListener listener) {
            this.listener = listener;
            return this;
        }

        public final CustomerCenterOptions build() {
            return new CustomerCenterOptions(this);
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(CustomerCenterOptions.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterOptions");
        return Intrinsics.areEqual(this.listener, ((CustomerCenterOptions) other).listener);
    }

    public int hashCode() {
        CustomerCenterListener customerCenterListener = this.listener;
        if (customerCenterListener != null) {
            return customerCenterListener.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "CustomerCenterOptions(listener=" + this.listener + ')';
    }
}
