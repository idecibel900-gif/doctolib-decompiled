package io.didomi.ssl.apiEvents;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Keep
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J=\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lio/didomi/sdk/apiEvents/Source;", "", "type", "", SubscriberAttributeKt.JSON_NAME_KEY, "domain", DiagnosticsEntry.VERSION_KEY, "deploymentId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDeploymentId", "()Ljava/lang/String;", "getDomain", "getKey", "getType", "getVersion", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "android_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class Source {

    @SerializedName("deployment_id")
    private final String deploymentId;

    @SerializedName("domain")
    private final String domain;

    @SerializedName(SubscriberAttributeKt.JSON_NAME_KEY)
    private final String key;

    @SerializedName("type")
    private final String type;

    @SerializedName(DiagnosticsEntry.VERSION_KEY)
    private final String version;

    public Source(String type, String key, String domain, String version, String str) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(domain, "domain");
        Intrinsics.checkNotNullParameter(version, "version");
        this.type = type;
        this.key = key;
        this.domain = domain;
        this.version = version;
        this.deploymentId = str;
    }

    public static /* synthetic */ Source copy$default(Source source, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = source.type;
        }
        if ((i & 2) != 0) {
            str2 = source.key;
        }
        if ((i & 4) != 0) {
            str3 = source.domain;
        }
        if ((i & 8) != 0) {
            str4 = source.version;
        }
        if ((i & 16) != 0) {
            str5 = source.deploymentId;
        }
        String str6 = str5;
        String str7 = str3;
        return source.copy(str, str2, str7, str4, str6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDomain() {
        return this.domain;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDeploymentId() {
        return this.deploymentId;
    }

    public final Source copy(String type, String key, String domain, String version, String deploymentId) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(domain, "domain");
        Intrinsics.checkNotNullParameter(version, "version");
        return new Source(type, key, domain, version, deploymentId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Source)) {
            return false;
        }
        Source source = (Source) other;
        return Intrinsics.areEqual(this.type, source.type) && Intrinsics.areEqual(this.key, source.key) && Intrinsics.areEqual(this.domain, source.domain) && Intrinsics.areEqual(this.version, source.version) && Intrinsics.areEqual(this.deploymentId, source.deploymentId);
    }

    public final String getDeploymentId() {
        return this.deploymentId;
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
        int iHashCode = ((((((this.type.hashCode() * 31) + this.key.hashCode()) * 31) + this.domain.hashCode()) * 31) + this.version.hashCode()) * 31;
        String str = this.deploymentId;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "Source(type=" + this.type + ", key=" + this.key + ", domain=" + this.domain + ", version=" + this.version + ", deploymentId=" + this.deploymentId + ')';
    }
}
