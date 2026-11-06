package com.revenuecat.purchases;

import android.os.Parcel;
import android.os.Parcelable;
import com.opentok.android.PublisherKit;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.ResponseTypeValues;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001\u001bB\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u000fH\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0016J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/revenuecat/purchases/PurchasesError;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", ResponseTypeValues.CODE, "Lcom/revenuecat/purchases/PurchasesErrorCode;", "underlyingErrorMessage", "", "(Lcom/revenuecat/purchases/PurchasesErrorCode;Ljava/lang/String;)V", "getCode", "()Lcom/revenuecat/purchases/PurchasesErrorCode;", "message", "getMessage", "()Ljava/lang/String;", "getUnderlyingErrorMessage", "describeContents", "", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PurchasesError implements Parcelable, Serializable {
    private static final long serialVersionUID = 81719171;
    private final PurchasesErrorCode code;
    private final String underlyingErrorMessage;
    public static final Parcelable.Creator<PurchasesError> CREATOR = new Creator();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PurchasesError> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PurchasesError createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PurchasesError(PurchasesErrorCode.valueOf(parcel.readString()), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PurchasesError[] newArray(int i) {
            return new PurchasesError[i];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.code.name());
        parcel.writeString(this.underlyingErrorMessage);
    }

    public PurchasesError(PurchasesErrorCode code, String str) {
        Intrinsics.checkNotNullParameter(code, "code");
        this.code = code;
        this.underlyingErrorMessage = str;
    }

    public /* synthetic */ PurchasesError(PurchasesErrorCode purchasesErrorCode, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(purchasesErrorCode, (i & 2) != 0 ? null : str);
    }

    public final PurchasesErrorCode getCode() {
        return this.code;
    }

    public final String getUnderlyingErrorMessage() {
        return this.underlyingErrorMessage;
    }

    public final String getMessage() {
        return this.code.getDescription();
    }

    public String toString() {
        return "PurchasesError(code=" + this.code + ", underlyingErrorMessage=" + this.underlyingErrorMessage + ", message='" + getMessage() + "')";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(PurchasesError.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.revenuecat.purchases.PurchasesError");
        PurchasesError purchasesError = (PurchasesError) other;
        return this.code == purchasesError.code && Intrinsics.areEqual(this.underlyingErrorMessage, purchasesError.underlyingErrorMessage);
    }

    public int hashCode() {
        int iHashCode = this.code.hashCode() * 31;
        String str = this.underlyingErrorMessage;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }
}
