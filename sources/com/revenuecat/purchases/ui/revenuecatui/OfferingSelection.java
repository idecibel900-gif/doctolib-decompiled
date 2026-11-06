package com.revenuecat.purchases.ui.revenuecatui;

import android.os.Parcel;
import android.os.Parcelable;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.PresentedOfferingContext;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u00002\u00020\u0001:\u0003\u000b\f\rB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0082\u0001\u0003\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/OfferingSelection;", "", "()V", "offering", "Lcom/revenuecat/purchases/Offering;", "getOffering", "()Lcom/revenuecat/purchases/Offering;", "offeringIdentifier", "", "getOfferingIdentifier", "()Ljava/lang/String;", "IdAndPresentedOfferingContext", "None", "OfferingType", "Lcom/revenuecat/purchases/ui/revenuecatui/OfferingSelection$IdAndPresentedOfferingContext;", "Lcom/revenuecat/purchases/ui/revenuecatui/OfferingSelection$None;", "Lcom/revenuecat/purchases/ui/revenuecatui/OfferingSelection$OfferingType;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class OfferingSelection {
    public static final int $stable = 0;

    public /* synthetic */ OfferingSelection(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private OfferingSelection() {
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/OfferingSelection$OfferingType;", "Lcom/revenuecat/purchases/ui/revenuecatui/OfferingSelection;", "offeringType", "Lcom/revenuecat/purchases/Offering;", "(Lcom/revenuecat/purchases/Offering;)V", "getOfferingType", "()Lcom/revenuecat/purchases/Offering;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class OfferingType extends OfferingSelection {
        public static final int $stable = 0;
        private final Offering offeringType;

        public static /* synthetic */ OfferingType copy$default(OfferingType offeringType, Offering offering, int i, Object obj) {
            if ((i & 1) != 0) {
                offering = offeringType.offeringType;
            }
            return offeringType.copy(offering);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Offering getOfferingType() {
            return this.offeringType;
        }

        public final OfferingType copy(Offering offeringType) {
            Intrinsics.checkNotNullParameter(offeringType, "offeringType");
            return new OfferingType(offeringType);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OfferingType) && Intrinsics.areEqual(this.offeringType, ((OfferingType) other).offeringType);
        }

        public int hashCode() {
            return this.offeringType.hashCode();
        }

        public String toString() {
            return "OfferingType(offeringType=" + this.offeringType + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OfferingType(Offering offeringType) {
            super(null);
            Intrinsics.checkNotNullParameter(offeringType, "offeringType");
            this.offeringType = offeringType;
        }

        public final Offering getOfferingType() {
            return this.offeringType;
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/OfferingSelection$IdAndPresentedOfferingContext;", "Landroid/os/Parcelable;", "Lcom/revenuecat/purchases/ui/revenuecatui/OfferingSelection;", "offeringId", "", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "(Ljava/lang/String;Lcom/revenuecat/purchases/PresentedOfferingContext;)V", "getOfferingId", "()Ljava/lang/String;", "getPresentedOfferingContext", "()Lcom/revenuecat/purchases/PresentedOfferingContext;", "component1", "component2", "copy", "describeContents", "", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class IdAndPresentedOfferingContext extends OfferingSelection implements Parcelable {
        public static final int $stable = 0;
        public static final Parcelable.Creator<IdAndPresentedOfferingContext> CREATOR = new Creator();
        private final String offeringId;
        private final PresentedOfferingContext presentedOfferingContext;

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<IdAndPresentedOfferingContext> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final IdAndPresentedOfferingContext createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new IdAndPresentedOfferingContext(parcel.readString(), (PresentedOfferingContext) parcel.readParcelable(IdAndPresentedOfferingContext.class.getClassLoader()));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final IdAndPresentedOfferingContext[] newArray(int i) {
                return new IdAndPresentedOfferingContext[i];
            }
        }

        public static /* synthetic */ IdAndPresentedOfferingContext copy$default(IdAndPresentedOfferingContext idAndPresentedOfferingContext, String str, PresentedOfferingContext presentedOfferingContext, int i, Object obj) {
            if ((i & 1) != 0) {
                str = idAndPresentedOfferingContext.offeringId;
            }
            if ((i & 2) != 0) {
                presentedOfferingContext = idAndPresentedOfferingContext.presentedOfferingContext;
            }
            return idAndPresentedOfferingContext.copy(str, presentedOfferingContext);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getOfferingId() {
            return this.offeringId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final PresentedOfferingContext getPresentedOfferingContext() {
            return this.presentedOfferingContext;
        }

        public final IdAndPresentedOfferingContext copy(String offeringId, PresentedOfferingContext presentedOfferingContext) {
            Intrinsics.checkNotNullParameter(offeringId, "offeringId");
            return new IdAndPresentedOfferingContext(offeringId, presentedOfferingContext);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof IdAndPresentedOfferingContext)) {
                return false;
            }
            IdAndPresentedOfferingContext idAndPresentedOfferingContext = (IdAndPresentedOfferingContext) other;
            return Intrinsics.areEqual(this.offeringId, idAndPresentedOfferingContext.offeringId) && Intrinsics.areEqual(this.presentedOfferingContext, idAndPresentedOfferingContext.presentedOfferingContext);
        }

        public int hashCode() {
            int iHashCode = this.offeringId.hashCode() * 31;
            PresentedOfferingContext presentedOfferingContext = this.presentedOfferingContext;
            return iHashCode + (presentedOfferingContext == null ? 0 : presentedOfferingContext.hashCode());
        }

        public String toString() {
            return "IdAndPresentedOfferingContext(offeringId=" + this.offeringId + ", presentedOfferingContext=" + this.presentedOfferingContext + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.offeringId);
            parcel.writeParcelable(this.presentedOfferingContext, flags);
        }

        public final String getOfferingId() {
            return this.offeringId;
        }

        public final PresentedOfferingContext getPresentedOfferingContext() {
            return this.presentedOfferingContext;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IdAndPresentedOfferingContext(String offeringId, PresentedOfferingContext presentedOfferingContext) {
            super(null);
            Intrinsics.checkNotNullParameter(offeringId, "offeringId");
            this.offeringId = offeringId;
            this.presentedOfferingContext = presentedOfferingContext;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/OfferingSelection$None;", "Lcom/revenuecat/purchases/ui/revenuecatui/OfferingSelection;", "()V", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class None extends OfferingSelection {
        public static final int $stable = 0;
        public static final None INSTANCE = new None();

        private None() {
            super(null);
        }
    }

    public final Offering getOffering() {
        if (this instanceof OfferingType) {
            return ((OfferingType) this).getOfferingType();
        }
        if ((this instanceof IdAndPresentedOfferingContext) || Intrinsics.areEqual(this, None.INSTANCE)) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final String getOfferingIdentifier() {
        if (this instanceof OfferingType) {
            return ((OfferingType) this).getOfferingType().getIdentifier();
        }
        if (this instanceof IdAndPresentedOfferingContext) {
            return ((IdAndPresentedOfferingContext) this).getOfferingId();
        }
        if (Intrinsics.areEqual(this, None.INSTANCE)) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }
}
