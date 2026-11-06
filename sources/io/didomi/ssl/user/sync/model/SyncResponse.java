package io.didomi.ssl.user.sync.model;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.opentok.android.PublisherKit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Keep
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lio/didomi/sdk/user/sync/model/SyncResponse;", "", "synced", "", "user", "Lio/didomi/sdk/user/sync/model/ResponseUser;", "(Ljava/lang/Boolean;Lio/didomi/sdk/user/sync/model/ResponseUser;)V", "getSynced", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getUser", "()Lio/didomi/sdk/user/sync/model/ResponseUser;", "component1", "component2", "copy", "(Ljava/lang/Boolean;Lio/didomi/sdk/user/sync/model/ResponseUser;)Lio/didomi/sdk/user/sync/model/SyncResponse;", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "", "android_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SyncResponse {

    @SerializedName("synced")
    private final Boolean synced;

    @SerializedName("user")
    private final ResponseUser user;

    /* JADX WARN: Multi-variable type inference failed */
    public SyncResponse() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SyncResponse copy$default(SyncResponse syncResponse, Boolean bool, ResponseUser responseUser, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = syncResponse.synced;
        }
        if ((i & 2) != 0) {
            responseUser = syncResponse.user;
        }
        return syncResponse.copy(bool, responseUser);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Boolean getSynced() {
        return this.synced;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ResponseUser getUser() {
        return this.user;
    }

    public final SyncResponse copy(Boolean synced, ResponseUser user) {
        return new SyncResponse(synced, user);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SyncResponse)) {
            return false;
        }
        SyncResponse syncResponse = (SyncResponse) other;
        return Intrinsics.areEqual(this.synced, syncResponse.synced) && Intrinsics.areEqual(this.user, syncResponse.user);
    }

    public final Boolean getSynced() {
        return this.synced;
    }

    public final ResponseUser getUser() {
        return this.user;
    }

    public int hashCode() {
        Boolean bool = this.synced;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        ResponseUser responseUser = this.user;
        return iHashCode + (responseUser != null ? responseUser.hashCode() : 0);
    }

    public String toString() {
        return "SyncResponse(synced=" + this.synced + ", user=" + this.user + ')';
    }

    public SyncResponse(Boolean bool, ResponseUser responseUser) {
        this.synced = bool;
        this.user = responseUser;
    }

    public /* synthetic */ SyncResponse(Boolean bool, ResponseUser responseUser, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Boolean.FALSE : bool, (i & 2) != 0 ? null : responseUser);
    }
}
