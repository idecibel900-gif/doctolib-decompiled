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
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b)\u0010*J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJP\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0013\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0014HÖ\u0001J\u0019\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0014HÖ\u0001R\u001a\u0010\u000b\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010 \u001a\u0004\b!\u0010\"R\u001a\u0010\f\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010 \u001a\u0004\b#\u0010\"R\u001a\u0010\r\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010 \u001a\u0004\b$\u0010\"R\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010 \u001a\u0004\b%\u0010\"R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010 \u001a\u0004\b&\u0010\"R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010'\u001a\u0004\b(\u0010\n¨\u0006+"}, d2 = {"Lio/didomi/sdk/user/UserAuthWithHashParams;", "Lio/didomi/sdk/ih;", "", "component1", "component2", "component3", "component4", "component5", "", "component6", "()Ljava/lang/Long;", DiagnosticsEntry.ID_KEY, "algorithm", "secretId", "digest", "salt", "expiration", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lio/didomi/sdk/user/UserAuthWithHashParams;", "toString", "", "hashCode", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "getAlgorithm", "getSecretId", "getDigest", "getSalt", "Ljava/lang/Long;", "getExpiration", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class UserAuthWithHashParams implements ih {
    public static final Parcelable.Creator<UserAuthWithHashParams> CREATOR = new a();
    private final String algorithm;
    private final String digest;
    private final Long expiration;
    private final String id;
    private final String salt;
    private final String secretId;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<UserAuthWithHashParams> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final UserAuthWithHashParams createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new UserAuthWithHashParams(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()));
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final UserAuthWithHashParams[] newArray(int i) {
            return new UserAuthWithHashParams[i];
        }
    }

    public UserAuthWithHashParams(String id, String algorithm, String secretId, String digest, String str, Long l) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        Intrinsics.checkNotNullParameter(secretId, "secretId");
        Intrinsics.checkNotNullParameter(digest, "digest");
        this.id = id;
        this.algorithm = algorithm;
        this.secretId = secretId;
        this.digest = digest;
        this.salt = str;
        this.expiration = l;
    }

    public static /* synthetic */ UserAuthWithHashParams copy$default(UserAuthWithHashParams userAuthWithHashParams, String str, String str2, String str3, String str4, String str5, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userAuthWithHashParams.id;
        }
        if ((i & 2) != 0) {
            str2 = userAuthWithHashParams.algorithm;
        }
        if ((i & 4) != 0) {
            str3 = userAuthWithHashParams.secretId;
        }
        if ((i & 8) != 0) {
            str4 = userAuthWithHashParams.digest;
        }
        if ((i & 16) != 0) {
            str5 = userAuthWithHashParams.salt;
        }
        if ((i & 32) != 0) {
            l = userAuthWithHashParams.expiration;
        }
        String str6 = str5;
        Long l2 = l;
        return userAuthWithHashParams.copy(str, str2, str3, str4, str6, l2);
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
    public final String getDigest() {
        return this.digest;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getSalt() {
        return this.salt;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Long getExpiration() {
        return this.expiration;
    }

    public final UserAuthWithHashParams copy(String id, String algorithm, String secretId, String digest, String salt, Long expiration) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        Intrinsics.checkNotNullParameter(secretId, "secretId");
        Intrinsics.checkNotNullParameter(digest, "digest");
        return new UserAuthWithHashParams(id, algorithm, secretId, digest, salt, expiration);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserAuthWithHashParams)) {
            return false;
        }
        UserAuthWithHashParams userAuthWithHashParams = (UserAuthWithHashParams) other;
        return Intrinsics.areEqual(this.id, userAuthWithHashParams.id) && Intrinsics.areEqual(this.algorithm, userAuthWithHashParams.algorithm) && Intrinsics.areEqual(this.secretId, userAuthWithHashParams.secretId) && Intrinsics.areEqual(this.digest, userAuthWithHashParams.digest) && Intrinsics.areEqual(this.salt, userAuthWithHashParams.salt) && Intrinsics.areEqual(this.expiration, userAuthWithHashParams.expiration);
    }

    @Override // io.didomi.ssl.ih
    public String getAlgorithm() {
        return this.algorithm;
    }

    public final String getDigest() {
        return this.digest;
    }

    @Override // io.didomi.ssl.ih
    public Long getExpiration() {
        return this.expiration;
    }

    @Override // io.didomi.ssl.hh
    public String getId() {
        return this.id;
    }

    public final String getSalt() {
        return this.salt;
    }

    @Override // io.didomi.ssl.ih
    public String getSecretId() {
        return this.secretId;
    }

    public int hashCode() {
        int iHashCode = ((((((this.id.hashCode() * 31) + this.algorithm.hashCode()) * 31) + this.secretId.hashCode()) * 31) + this.digest.hashCode()) * 31;
        String str = this.salt;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Long l = this.expiration;
        return iHashCode2 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        return "UserAuthWithHashParams(id=" + this.id + ", algorithm=" + this.algorithm + ", secretId=" + this.secretId + ", digest=" + this.digest + ", salt=" + this.salt + ", expiration=" + this.expiration + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.id);
        parcel.writeString(this.algorithm);
        parcel.writeString(this.secretId);
        parcel.writeString(this.digest);
        parcel.writeString(this.salt);
        Long l = this.expiration;
        if (l == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        }
    }

    public /* synthetic */ UserAuthWithHashParams(String str, String str2, String str3, String str4, String str5, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : l);
    }
}
