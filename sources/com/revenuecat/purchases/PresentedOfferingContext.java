package com.revenuecat.purchases;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0016B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ*\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/revenuecat/purchases/PresentedOfferingContext;", "Landroid/os/Parcelable;", "offeringIdentifier", "", "(Ljava/lang/String;)V", "placementIdentifier", "targetingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext$TargetingContext;", "(Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/PresentedOfferingContext$TargetingContext;)V", "getOfferingIdentifier", "()Ljava/lang/String;", "getPlacementIdentifier", "getTargetingContext", "()Lcom/revenuecat/purchases/PresentedOfferingContext$TargetingContext;", "copy", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "TargetingContext", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PresentedOfferingContext implements Parcelable {
    public static final Parcelable.Creator<PresentedOfferingContext> CREATOR = new Creator();
    private final String offeringIdentifier;
    private final String placementIdentifier;
    private final TargetingContext targetingContext;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PresentedOfferingContext> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PresentedOfferingContext createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PresentedOfferingContext(parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : TargetingContext.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PresentedOfferingContext[] newArray(int i) {
            return new PresentedOfferingContext[i];
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
        if (!(obj instanceof PresentedOfferingContext)) {
            return false;
        }
        PresentedOfferingContext presentedOfferingContext = (PresentedOfferingContext) obj;
        return Intrinsics.areEqual(this.offeringIdentifier, presentedOfferingContext.offeringIdentifier) && Intrinsics.areEqual(this.placementIdentifier, presentedOfferingContext.placementIdentifier) && Intrinsics.areEqual(this.targetingContext, presentedOfferingContext.targetingContext);
    }

    public int hashCode() {
        int iHashCode = this.offeringIdentifier.hashCode() * 31;
        String str = this.placementIdentifier;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        TargetingContext targetingContext = this.targetingContext;
        return iHashCode2 + (targetingContext != null ? targetingContext.hashCode() : 0);
    }

    public String toString() {
        return "PresentedOfferingContext(offeringIdentifier=" + this.offeringIdentifier + ", placementIdentifier=" + this.placementIdentifier + ", targetingContext=" + this.targetingContext + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.offeringIdentifier);
        parcel.writeString(this.placementIdentifier);
        TargetingContext targetingContext = this.targetingContext;
        if (targetingContext == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            targetingContext.writeToParcel(parcel, flags);
        }
    }

    public PresentedOfferingContext(String offeringIdentifier, String str, TargetingContext targetingContext) {
        Intrinsics.checkNotNullParameter(offeringIdentifier, "offeringIdentifier");
        this.offeringIdentifier = offeringIdentifier;
        this.placementIdentifier = str;
        this.targetingContext = targetingContext;
    }

    public final String getOfferingIdentifier() {
        return this.offeringIdentifier;
    }

    public final String getPlacementIdentifier() {
        return this.placementIdentifier;
    }

    public final TargetingContext getTargetingContext() {
        return this.targetingContext;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PresentedOfferingContext(String offeringIdentifier) {
        this(offeringIdentifier, null, null);
        Intrinsics.checkNotNullParameter(offeringIdentifier, "offeringIdentifier");
    }

    public static /* synthetic */ PresentedOfferingContext copy$default(PresentedOfferingContext presentedOfferingContext, String str, String str2, TargetingContext targetingContext, int i, Object obj) {
        if ((i & 1) != 0) {
            str = presentedOfferingContext.offeringIdentifier;
        }
        if ((i & 2) != 0) {
            str2 = presentedOfferingContext.placementIdentifier;
        }
        if ((i & 4) != 0) {
            targetingContext = presentedOfferingContext.targetingContext;
        }
        return presentedOfferingContext.copy(str, str2, targetingContext);
    }

    @InternalRevenueCatAPI
    public final /* synthetic */ PresentedOfferingContext copy(String offeringIdentifier, String placementIdentifier, TargetingContext targetingContext) {
        Intrinsics.checkNotNullParameter(offeringIdentifier, "offeringIdentifier");
        return new PresentedOfferingContext(offeringIdentifier, placementIdentifier, targetingContext);
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/revenuecat/purchases/PresentedOfferingContext$TargetingContext;", "Landroid/os/Parcelable;", "revision", "", "ruleId", "", "(ILjava/lang/String;)V", "getRevision", "()I", "getRuleId", "()Ljava/lang/String;", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class TargetingContext implements Parcelable {
        public static final Parcelable.Creator<TargetingContext> CREATOR = new Creator();
        private final int revision;
        private final String ruleId;

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<TargetingContext> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final TargetingContext createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new TargetingContext(parcel.readInt(), parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final TargetingContext[] newArray(int i) {
                return new TargetingContext[i];
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
            if (!(obj instanceof TargetingContext)) {
                return false;
            }
            TargetingContext targetingContext = (TargetingContext) obj;
            return this.revision == targetingContext.revision && Intrinsics.areEqual(this.ruleId, targetingContext.ruleId);
        }

        public int hashCode() {
            return (this.revision * 31) + this.ruleId.hashCode();
        }

        public String toString() {
            return "TargetingContext(revision=" + this.revision + ", ruleId=" + this.ruleId + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(this.revision);
            parcel.writeString(this.ruleId);
        }

        public TargetingContext(int i, String ruleId) {
            Intrinsics.checkNotNullParameter(ruleId, "ruleId");
            this.revision = i;
            this.ruleId = ruleId;
        }

        public final int getRevision() {
            return this.revision;
        }

        public final String getRuleId() {
            return this.ruleId;
        }
    }
}
