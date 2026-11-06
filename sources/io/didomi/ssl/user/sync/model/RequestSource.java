package io.didomi.ssl.user.sync.model;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Keep
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lio/didomi/sdk/user/sync/model/RequestSource;", "", "domain", "", SubscriberAttributeKt.JSON_NAME_KEY, DiagnosticsEntry.VERSION_KEY, "type", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDomain", "()Ljava/lang/String;", "getKey", "getType", "getVersion", "component1", "component2", "component3", "component4", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "android_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class RequestSource {

    @SerializedName("domain")
    private final String domain;

    @SerializedName(SubscriberAttributeKt.JSON_NAME_KEY)
    private final String key;

    @SerializedName("type")
    private final String type;

    @SerializedName(DiagnosticsEntry.VERSION_KEY)
    private final String version;

    public RequestSource(String domain, String key, String version, String type) {
        Intrinsics.checkNotNullParameter(domain, "domain");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(type, "type");
        this.domain = domain;
        this.key = key;
        this.version = version;
        this.type = type;
    }

    public static /* synthetic */ RequestSource copy$default(RequestSource requestSource, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = requestSource.domain;
        }
        if ((i & 2) != 0) {
            str2 = requestSource.key;
        }
        if ((i & 4) != 0) {
            str3 = requestSource.version;
        }
        if ((i & 8) != 0) {
            str4 = requestSource.type;
        }
        return requestSource.copy(str, str2, str3, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDomain() {
        return this.domain;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public final RequestSource copy(String domain, String key, String version, String type) {
        Intrinsics.checkNotNullParameter(domain, "domain");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(type, "type");
        return new RequestSource(domain, key, version, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RequestSource)) {
            return false;
        }
        RequestSource requestSource = (RequestSource) other;
        return Intrinsics.areEqual(this.domain, requestSource.domain) && Intrinsics.areEqual(this.key, requestSource.key) && Intrinsics.areEqual(this.version, requestSource.version) && Intrinsics.areEqual(this.type, requestSource.type);
    }

    public final String getDomain() {
        return this.domain;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getType() {
        return this.type;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        return (((((this.domain.hashCode() * 31) + this.key.hashCode()) * 31) + this.version.hashCode()) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "RequestSource(domain=" + this.domain + ", key=" + this.key + ", version=" + this.version + ", type=" + this.type + ')';
    }
}
