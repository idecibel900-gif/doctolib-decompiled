package io.didomi.ssl.user;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import io.didomi.ssl.ih;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Keep
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b&\u0010'J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0002HÆ\u0003J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJD\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0011\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0012HÖ\u0001J\u0019\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0012HÖ\u0001R\u001a\u0010\n\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001a\u0010\u000b\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001e\u001a\u0004\b!\u0010 R\u001a\u0010\f\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\u001e\u001a\u0004\b\"\u0010 R\u0017\u0010\r\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b#\u0010 R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010$\u001a\u0004\b%\u0010\t¨\u0006("}, d2 = {"Lio/didomi/sdk/user/UserAuthWithEncryptionParams;", "Lio/didomi/sdk/ih;", "", "component1", "component2", "component3", "component4", "", "component5", "()Ljava/lang/Long;", DiagnosticsEntry.ID_KEY, "algorithm", "secretId", "initializationVector", "expiration", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lio/didomi/sdk/user/UserAuthWithEncryptionParams;", "toString", "", "hashCode", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "getAlgorithm", "getSecretId", "getInitializationVector", "Ljava/lang/Long;", "getExpiration", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class UserAuthWithEncryptionParams implements ih {
    public static final Parcelable.Creator<UserAuthWithEncryptionParams> CREATOR = new a();
    private final String algorithm;
    private final Long expiration;
    private final String id;
    private final String initializationVector;
    private final String secretId;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<UserAuthWithEncryptionParams> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final UserAuthWithEncryptionParams createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new UserAuthWithEncryptionParams(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()));
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final UserAuthWithEncryptionParams[] newArray(int i) {
            return new UserAuthWithEncryptionParams[i];
        }
    }

    public UserAuthWithEncryptionParams(String id, String algorithm, String secretId, String initializationVector, Long l) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        Intrinsics.checkNotNullParameter(secretId, "secretId");
        Intrinsics.checkNotNullParameter(initializationVector, "initializationVector");
        this.id = id;
        this.algorithm = algorithm;
        this.secretId = secretId;
        this.initializationVector = initializationVector;
        this.expiration = l;
    }

    public static /* synthetic */ UserAuthWithEncryptionParams copy$default(UserAuthWithEncryptionParams userAuthWithEncryptionParams, String str, String str2, String str3, String str4, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userAuthWithEncryptionParams.id;
        }
        if ((i & 2) != 0) {
            str2 = userAuthWithEncryptionParams.algorithm;
        }
        if ((i & 4) != 0) {
            str3 = userAuthWithEncryptionParams.secretId;
        }
        if ((i & 8) != 0) {
            str4 = userAuthWithEncryptionParams.initializationVector;
        }
        if ((i & 16) != 0) {
            l = userAuthWithEncryptionParams.expiration;
        }
        Long l2 = l;
        String str5 = str3;
        return userAuthWithEncryptionParams.copy(str, str2, str5, str4, l2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAlgorithm() {
        return this.algorithm;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSecretId() {
        return this.secretId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getInitializationVector() {
        return this.initializationVector;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Long getExpiration() {
        return this.expiration;
    }

    public final UserAuthWithEncryptionParams copy(String id, String algorithm, String secretId, String initializationVector, Long expiration) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        Intrinsics.checkNotNullParameter(secretId, "secretId");
        Intrinsics.checkNotNullParameter(initializationVector, "initializationVector");
        return new UserAuthWithEncryptionParams(id, algorithm, secretId, initializationVector, expiration);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserAuthWithEncryptionParams)) {
            return false;
        }
        UserAuthWithEncryptionParams userAuthWithEncryptionParams = (UserAuthWithEncryptionParams) other;
        return Intrinsics.areEqual(this.id, userAuthWithEncryptionParams.id) && Intrinsics.areEqual(this.algorithm, userAuthWithEncryptionParams.algorithm) && Intrinsics.areEqual(this.secretId, userAuthWithEncryptionParams.secretId) && Intrinsics.areEqual(this.initializationVector, userAuthWithEncryptionParams.initializationVector) && Intrinsics.areEqual(this.expiration, userAuthWithEncryptionParams.expiration);
    }

    @Override // io.didomi.ssl.ih
    public String getAlgorithm() {
        return this.algorithm;
    }

    @Override // io.didomi.ssl.ih
    public Long getExpiration() {
        return this.expiration;
    }

    @Override // io.didomi.ssl.hh
    public String getId() {
        return this.id;
    }

    public final String getInitializationVector() {
        return this.initializationVector;
    }

    @Override // io.didomi.ssl.ih
    public String getSecretId() {
        return this.secretId;
    }

    public int hashCode() {
        int iHashCode = ((((((this.id.hashCode() * 31) + this.algorithm.hashCode()) * 31) + this.secretId.hashCode()) * 31) + this.initializationVector.hashCode()) * 31;
        Long l = this.expiration;
        return iHashCode + (l == null ? 0 : l.hashCode());
    }

    public String toString() {
        return "UserAuthWithEncryptionParams(id=" + this.id + ", algorithm=" + this.algorithm + ", secretId=" + this.secretId + ", initializationVector=" + this.initializationVector + ", expiration=" + this.expiration + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.id);
        parcel.writeString(this.algorithm);
        parcel.writeString(this.secretId);
        parcel.writeString(this.initializationVector);
        Long l = this.expiration;
        if (l == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        }
    }

    public /* synthetic */ UserAuthWithEncryptionParams(String str, String str2, String str3, String str4, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, (i & 16) != 0 ? null : l);
    }
}
