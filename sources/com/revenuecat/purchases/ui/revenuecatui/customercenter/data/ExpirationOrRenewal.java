package com.revenuecat.purchases.ui.revenuecatui.customercenter.data;

import com.opentok.android.PublisherKit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/ExpirationOrRenewal;", "", "()V", "Expiration", "Renewal", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/ExpirationOrRenewal$Expiration;", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/ExpirationOrRenewal$Renewal;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class ExpirationOrRenewal {
    public static final int $stable = 0;

    public /* synthetic */ ExpirationOrRenewal(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/ExpirationOrRenewal$Expiration;", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/ExpirationOrRenewal;", "date", "", "(Ljava/lang/String;)V", "getDate", "()Ljava/lang/String;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Expiration extends ExpirationOrRenewal {
        public static final int $stable = 0;
        private final String date;

        public static /* synthetic */ Expiration copy$default(Expiration expiration, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = expiration.date;
            }
            return expiration.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getDate() {
            return this.date;
        }

        public final Expiration copy(String date) {
            Intrinsics.checkNotNullParameter(date, "date");
            return new Expiration(date);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Expiration) && Intrinsics.areEqual(this.date, ((Expiration) other).date);
        }

        public int hashCode() {
            return this.date.hashCode();
        }

        public String toString() {
            return "Expiration(date=" + this.date + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Expiration(String date) {
            super(null);
            Intrinsics.checkNotNullParameter(date, "date");
            this.date = date;
        }

        public final String getDate() {
            return this.date;
        }
    }

    private ExpirationOrRenewal() {
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/ExpirationOrRenewal$Renewal;", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/ExpirationOrRenewal;", "date", "", "(Ljava/lang/String;)V", "getDate", "()Ljava/lang/String;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Renewal extends ExpirationOrRenewal {
        public static final int $stable = 0;
        private final String date;

        public static /* synthetic */ Renewal copy$default(Renewal renewal, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = renewal.date;
            }
            return renewal.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getDate() {
            return this.date;
        }

        public final Renewal copy(String date) {
            Intrinsics.checkNotNullParameter(date, "date");
            return new Renewal(date);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Renewal) && Intrinsics.areEqual(this.date, ((Renewal) other).date);
        }

        public int hashCode() {
            return this.date.hashCode();
        }

        public String toString() {
            return "Renewal(date=" + this.date + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Renewal(String date) {
            super(null);
            Intrinsics.checkNotNullParameter(date, "date");
            this.date = date;
        }

        public final String getDate() {
            return this.date;
        }
    }
}
