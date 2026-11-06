package com.revenuecat.purchases.ui.revenuecatui.activity;

import android.os.Parcel;
import android.os.Parcelable;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.PurchasesError;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallResult;", "Landroid/os/Parcelable;", "()V", "Cancelled", "Error", "Purchased", "Restored", "Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallResult$Cancelled;", "Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallResult$Error;", "Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallResult$Purchased;", "Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallResult$Restored;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class PaywallResult implements Parcelable {
    public static final int $stable = 0;

    public /* synthetic */ PaywallResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private PaywallResult() {
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005HÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallResult$Cancelled;", "Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallResult;", "Landroid/os/Parcelable;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Cancelled extends PaywallResult implements Parcelable {
        public static final int $stable = 0;
        public static final Cancelled INSTANCE = new Cancelled();
        public static final Parcelable.Creator<Cancelled> CREATOR = new Creator();

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<Cancelled> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Cancelled createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return Cancelled.INSTANCE;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Cancelled[] newArray(int i) {
                return new Cancelled[i];
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(1);
        }

        private Cancelled() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\tHÖ\u0001J\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallResult$Purchased;", "Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallResult;", "Landroid/os/Parcelable;", "customerInfo", "Lcom/revenuecat/purchases/CustomerInfo;", "(Lcom/revenuecat/purchases/CustomerInfo;)V", "getCustomerInfo", "()Lcom/revenuecat/purchases/CustomerInfo;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Purchased extends PaywallResult implements Parcelable {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Purchased> CREATOR = new Creator();
        private final CustomerInfo customerInfo;

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<Purchased> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Purchased createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Purchased((CustomerInfo) parcel.readParcelable(Purchased.class.getClassLoader()));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Purchased[] newArray(int i) {
                return new Purchased[i];
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Purchased) && Intrinsics.areEqual(this.customerInfo, ((Purchased) obj).customerInfo);
        }

        public int hashCode() {
            return this.customerInfo.hashCode();
        }

        public String toString() {
            return "Purchased(customerInfo=" + this.customerInfo + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeParcelable(this.customerInfo, flags);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Purchased(CustomerInfo customerInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
            this.customerInfo = customerInfo;
        }

        public final CustomerInfo getCustomerInfo() {
            return this.customerInfo;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\tHÖ\u0001J\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallResult$Error;", "Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallResult;", "Landroid/os/Parcelable;", "error", "Lcom/revenuecat/purchases/PurchasesError;", "(Lcom/revenuecat/purchases/PurchasesError;)V", "getError", "()Lcom/revenuecat/purchases/PurchasesError;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Error extends PaywallResult implements Parcelable {
        public static final int $stable = 0;
        public static final Parcelable.Creator<Error> CREATOR = new Creator();
        private final PurchasesError error;

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<Error> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Error createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Error((PurchasesError) parcel.readParcelable(Error.class.getClassLoader()));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Error[] newArray(int i) {
                return new Error[i];
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Error) && Intrinsics.areEqual(this.error, ((Error) obj).error);
        }

        public int hashCode() {
            return this.error.hashCode();
        }

        public String toString() {
            return "Error(error=" + this.error + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeParcelable(this.error, flags);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(PurchasesError error) {
            super(null);
            Intrinsics.checkNotNullParameter(error, "error");
            this.error = error;
        }

        public final PurchasesError getError() {
            return this.error;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\tHÖ\u0001J\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallResult$Restored;", "Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallResult;", "Landroid/os/Parcelable;", "customerInfo", "Lcom/revenuecat/purchases/CustomerInfo;", "(Lcom/revenuecat/purchases/CustomerInfo;)V", "getCustomerInfo", "()Lcom/revenuecat/purchases/CustomerInfo;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Restored extends PaywallResult implements Parcelable {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Restored> CREATOR = new Creator();
        private final CustomerInfo customerInfo;

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<Restored> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Restored createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Restored((CustomerInfo) parcel.readParcelable(Restored.class.getClassLoader()));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Restored[] newArray(int i) {
                return new Restored[i];
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Restored) && Intrinsics.areEqual(this.customerInfo, ((Restored) obj).customerInfo);
        }

        public int hashCode() {
            return this.customerInfo.hashCode();
        }

        public String toString() {
            return "Restored(customerInfo=" + this.customerInfo + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeParcelable(this.customerInfo, flags);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Restored(CustomerInfo customerInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
            this.customerInfo = customerInfo;
        }

        public final CustomerInfo getCustomerInfo() {
            return this.customerInfo;
        }
    }
}
