package com.revenuecat.purchases.ui.revenuecatui.customercenter.data;

import com.amazon.a.a.o.b;
import com.opentok.android.PublisherKit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/PriceDetails;", "", "()V", "Free", "Paid", "Unknown", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/PriceDetails$Free;", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/PriceDetails$Paid;", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/PriceDetails$Unknown;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class PriceDetails {
    public static final int $stable = 0;

    public /* synthetic */ PriceDetails(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/PriceDetails$Free;", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/PriceDetails;", "()V", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Free extends PriceDetails {
        public static final int $stable = 0;
        public static final Free INSTANCE = new Free();

        private Free() {
            super(null);
        }
    }

    private PriceDetails() {
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/PriceDetails$Paid;", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/PriceDetails;", b.x, "", "(Ljava/lang/String;)V", "getPrice", "()Ljava/lang/String;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Paid extends PriceDetails {
        public static final int $stable = 0;
        private final String price;

        public static /* synthetic */ Paid copy$default(Paid paid, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = paid.price;
            }
            return paid.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getPrice() {
            return this.price;
        }

        public final Paid copy(String price) {
            Intrinsics.checkNotNullParameter(price, "price");
            return new Paid(price);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Paid) && Intrinsics.areEqual(this.price, ((Paid) other).price);
        }

        public int hashCode() {
            return this.price.hashCode();
        }

        public String toString() {
            return "Paid(price=" + this.price + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Paid(String price) {
            super(null);
            Intrinsics.checkNotNullParameter(price, "price");
            this.price = price;
        }

        public final String getPrice() {
            return this.price;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/PriceDetails$Unknown;", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/PriceDetails;", "()V", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Unknown extends PriceDetails {
        public static final int $stable = 0;
        public static final Unknown INSTANCE = new Unknown();

        private Unknown() {
            super(null);
        }
    }
}
