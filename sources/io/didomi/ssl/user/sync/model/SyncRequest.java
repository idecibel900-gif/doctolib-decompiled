package io.didomi.ssl.user.sync.model;

import androidx.annotation.Keep;
import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.SerializedName;
import com.opentok.android.PublisherKit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Keep
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lio/didomi/sdk/user/sync/model/SyncRequest;", "", Constants.ScionAnalytics.PARAM_SOURCE, "Lio/didomi/sdk/user/sync/model/RequestSource;", "user", "Lio/didomi/sdk/user/sync/model/RequestUser;", "(Lio/didomi/sdk/user/sync/model/RequestSource;Lio/didomi/sdk/user/sync/model/RequestUser;)V", "getSource", "()Lio/didomi/sdk/user/sync/model/RequestSource;", "getUser", "()Lio/didomi/sdk/user/sync/model/RequestUser;", "component1", "component2", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "", "android_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SyncRequest {

    @SerializedName(Constants.ScionAnalytics.PARAM_SOURCE)
    private final RequestSource source;

    @SerializedName("user")
    private final RequestUser user;

    public SyncRequest(RequestSource source, RequestUser user) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(user, "user");
        this.source = source;
        this.user = user;
    }

    public static /* synthetic */ SyncRequest copy$default(SyncRequest syncRequest, RequestSource requestSource, RequestUser requestUser, int i, Object obj) {
        if ((i & 1) != 0) {
            requestSource = syncRequest.source;
        }
        if ((i & 2) != 0) {
            requestUser = syncRequest.user;
        }
        return syncRequest.copy(requestSource, requestUser);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final RequestSource getSource() {
        return this.source;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final RequestUser getUser() {
        return this.user;
    }

    public final SyncRequest copy(RequestSource source, RequestUser user) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(user, "user");
        return new SyncRequest(source, user);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SyncRequest)) {
            return false;
        }
        SyncRequest syncRequest = (SyncRequest) other;
        return Intrinsics.areEqual(this.source, syncRequest.source) && Intrinsics.areEqual(this.user, syncRequest.user);
    }

    public final RequestSource getSource() {
        return this.source;
    }

    public final RequestUser getUser() {
        return this.user;
    }

    public int hashCode() {
        return (this.source.hashCode() * 31) + this.user.hashCode();
    }

    public String toString() {
        return "SyncRequest(source=" + this.source + ", user=" + this.user + ')';
    }
}
