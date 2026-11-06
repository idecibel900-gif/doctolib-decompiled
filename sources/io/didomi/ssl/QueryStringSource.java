package io.didomi.ssl;

import com.google.gson.annotations.SerializedName;
import com.opentok.android.PublisherKit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: io.didomi.sdk.wa, reason: from toString */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\f¨\u0006\u0013"}, d2 = {"Lio/didomi/sdk/wa;", "", "", "toString", "", "hashCode", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "type", "b", "getDomain", "domain", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class QueryStringSource {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
    @SerializedName("type")
    private final String type;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
    @SerializedName("domain")
    private final String domain;

    public QueryStringSource(String type, String str) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.domain = str;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QueryStringSource)) {
            return false;
        }
        QueryStringSource queryStringSource = (QueryStringSource) other;
        return Intrinsics.areEqual(this.type, queryStringSource.type) && Intrinsics.areEqual(this.domain, queryStringSource.domain);
    }

    public int hashCode() {
        int iHashCode = this.type.hashCode() * 31;
        String str = this.domain;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "QueryStringSource(type=" + this.type + ", domain=" + this.domain + ')';
    }
}
