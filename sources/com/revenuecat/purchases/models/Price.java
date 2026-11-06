package com.revenuecat.purchases.models;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/revenuecat/purchases/models/Price;", "Landroid/os/Parcelable;", "formatted", "", "amountMicros", "", "currencyCode", "(Ljava/lang/String;JLjava/lang/String;)V", "getAmountMicros", "()J", "getCurrencyCode", "()Ljava/lang/String;", "getFormatted", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Price implements Parcelable {
    public static final Parcelable.Creator<Price> CREATOR = new Creator();
    private final long amountMicros;
    private final String currencyCode;
    private final String formatted;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<Price> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Price createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new Price(parcel.readString(), parcel.readLong(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Price[] newArray(int i) {
            return new Price[i];
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
        if (!(obj instanceof Price)) {
            return false;
        }
        Price price = (Price) obj;
        return Intrinsics.areEqual(this.formatted, price.formatted) && this.amountMicros == price.amountMicros && Intrinsics.areEqual(this.currencyCode, price.currencyCode);
    }

    public int hashCode() {
        return (((this.formatted.hashCode() * 31) + Long.hashCode(this.amountMicros)) * 31) + this.currencyCode.hashCode();
    }

    public String toString() {
        return "Price(formatted=" + this.formatted + ", amountMicros=" + this.amountMicros + ", currencyCode=" + this.currencyCode + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.formatted);
        parcel.writeLong(this.amountMicros);
        parcel.writeString(this.currencyCode);
    }

    public Price(String formatted, long j, String currencyCode) {
        Intrinsics.checkNotNullParameter(formatted, "formatted");
        Intrinsics.checkNotNullParameter(currencyCode, "currencyCode");
        this.formatted = formatted;
        this.amountMicros = j;
        this.currencyCode = currencyCode;
    }

    public final String getFormatted() {
        return this.formatted;
    }

    public final long getAmountMicros() {
        return this.amountMicros;
    }

    public final String getCurrencyCode() {
        return this.currencyCode;
    }
}
