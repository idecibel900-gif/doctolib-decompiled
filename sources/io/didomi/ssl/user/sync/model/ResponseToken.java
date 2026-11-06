package io.didomi.ssl.user.sync.model;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.opentok.android.PublisherKit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Keep
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lio/didomi/sdk/user/sync/model/ResponseToken;", "", "consents", "Lio/didomi/sdk/user/sync/model/ResponseConsents;", "(Lio/didomi/sdk/user/sync/model/ResponseConsents;)V", "getConsents", "()Lio/didomi/sdk/user/sync/model/ResponseConsents;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "", "android_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ResponseToken {

    @SerializedName("consents")
    private final ResponseConsents consents;

    /* JADX WARN: Multi-variable type inference failed */
    public ResponseToken() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ResponseToken copy$default(ResponseToken responseToken, ResponseConsents responseConsents, int i, Object obj) {
        if ((i & 1) != 0) {
            responseConsents = responseToken.consents;
        }
        return responseToken.copy(responseConsents);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ResponseConsents getConsents() {
        return this.consents;
    }

    public final ResponseToken copy(ResponseConsents consents) {
        return new ResponseToken(consents);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ResponseToken) && Intrinsics.areEqual(this.consents, ((ResponseToken) other).consents);
    }

    public final ResponseConsents getConsents() {
        return this.consents;
    }

    public int hashCode() {
        ResponseConsents responseConsents = this.consents;
        if (responseConsents == null) {
            return 0;
        }
        return responseConsents.hashCode();
    }

    public String toString() {
        return "ResponseToken(consents=" + this.consents + ')';
    }

    public ResponseToken(ResponseConsents responseConsents) {
        this.consents = responseConsents;
    }

    public /* synthetic */ ResponseToken(ResponseConsents responseConsents, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : responseConsents);
    }
}
