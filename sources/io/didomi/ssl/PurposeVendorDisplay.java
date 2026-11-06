package io.didomi.ssl;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.messaging.Constants;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: io.didomi.sdk.ea, reason: from toString */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\b¢\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\n\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0014\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013R\u0017\u0010\u0018\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017R\u0017\u0010\u001c\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u001b¨\u0006\u001f"}, d2 = {"Lio/didomi/sdk/ea;", "Landroid/os/Parcelable;", "", "toString", "", "hashCode", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "", "a", "J", "()J", DiagnosticsEntry.ID_KEY, "b", "Ljava/lang/String;", "()Ljava/lang/String;", Constants.ScionAnalytics.PARAM_LABEL, "c", "Z", "()Z", "isIab", "<init>", "(JLjava/lang/String;Z)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class PurposeVendorDisplay implements Parcelable {
    public static final Parcelable.Creator<PurposeVendorDisplay> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
    private final long id;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
    private final String label;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
    private final boolean isIab;

    /* JADX INFO: renamed from: io.didomi.sdk.ea$a */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<PurposeVendorDisplay> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final PurposeVendorDisplay createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PurposeVendorDisplay(parcel.readLong(), parcel.readString(), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final PurposeVendorDisplay[] newArray(int i) {
            return new PurposeVendorDisplay[i];
        }
    }

    public PurposeVendorDisplay(long j, String label, boolean z) {
        Intrinsics.checkNotNullParameter(label, "label");
        this.id = j;
        this.label = label;
        this.isIab = z;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final boolean getIsIab() {
        return this.isIab;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PurposeVendorDisplay)) {
            return false;
        }
        PurposeVendorDisplay purposeVendorDisplay = (PurposeVendorDisplay) other;
        return this.id == purposeVendorDisplay.id && Intrinsics.areEqual(this.label, purposeVendorDisplay.label) && this.isIab == purposeVendorDisplay.isIab;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public int hashCode() {
        int iHashCode = ((Long.hashCode(this.id) * 31) + this.label.hashCode()) * 31;
        boolean z = this.isIab;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        return "PurposeVendorDisplay(id=" + this.id + ", label=" + this.label + ", isIab=" + this.isIab + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeLong(this.id);
        parcel.writeString(this.label);
        parcel.writeInt(this.isIab ? 1 : 0);
    }
}
