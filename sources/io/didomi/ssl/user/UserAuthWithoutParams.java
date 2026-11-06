package io.didomi.ssl.user;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import io.didomi.ssl.hh;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Keep
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\u0005\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0002HÆ\u0001J\t\u0010\u0006\u001a\u00020\u0002HÖ\u0001J\t\u0010\b\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003J\t\u0010\r\u001a\u00020\u0007HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lio/didomi/sdk/user/UserAuthWithoutParams;", "Lio/didomi/sdk/hh;", "", "component1", DiagnosticsEntry.ID_KEY, "copy", "toString", "", "hashCode", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class UserAuthWithoutParams implements hh {
    public static final Parcelable.Creator<UserAuthWithoutParams> CREATOR = new a();
    private final String id;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<UserAuthWithoutParams> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final UserAuthWithoutParams createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new UserAuthWithoutParams(parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final UserAuthWithoutParams[] newArray(int i) {
            return new UserAuthWithoutParams[i];
        }
    }

    public UserAuthWithoutParams(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.id = id;
    }

    public static /* synthetic */ UserAuthWithoutParams copy$default(UserAuthWithoutParams userAuthWithoutParams, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userAuthWithoutParams.id;
        }
        return userAuthWithoutParams.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final UserAuthWithoutParams copy(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return new UserAuthWithoutParams(id);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof UserAuthWithoutParams) && Intrinsics.areEqual(this.id, ((UserAuthWithoutParams) other).id);
    }

    @Override // io.didomi.ssl.hh
    public String getId() {
        return this.id;
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    public String toString() {
        return "UserAuthWithoutParams(id=" + this.id + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.id);
    }
}
