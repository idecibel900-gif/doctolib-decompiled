package io.didomi.ssl;

import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;
import com.opentok.android.PublisherKit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: io.didomi.sdk.va, reason: from toString */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\t¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001a\u0010\u000e\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0011\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r¨\u0006\u0014"}, d2 = {"Lio/didomi/sdk/va;", "", "", "toString", "", "hashCode", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "Lcom/google/gson/JsonArray;", "a", "Lcom/google/gson/JsonArray;", "getEnabledList", "()Lcom/google/gson/JsonArray;", "enabledList", "b", "getDisabledList", "disabledList", "<init>", "(Lcom/google/gson/JsonArray;Lcom/google/gson/JsonArray;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class QueryStringItemsList {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
    @SerializedName("enabled")
    private final JsonArray enabledList;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
    @SerializedName("disabled")
    private final JsonArray disabledList;

    public QueryStringItemsList(JsonArray enabledList, JsonArray disabledList) {
        Intrinsics.checkNotNullParameter(enabledList, "enabledList");
        Intrinsics.checkNotNullParameter(disabledList, "disabledList");
        this.enabledList = enabledList;
        this.disabledList = disabledList;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QueryStringItemsList)) {
            return false;
        }
        QueryStringItemsList queryStringItemsList = (QueryStringItemsList) other;
        return Intrinsics.areEqual(this.enabledList, queryStringItemsList.enabledList) && Intrinsics.areEqual(this.disabledList, queryStringItemsList.disabledList);
    }

    public int hashCode() {
        return (this.enabledList.hashCode() * 31) + this.disabledList.hashCode();
    }

    public String toString() {
        return "QueryStringItemsList(enabledList=" + this.enabledList + ", disabledList=" + this.disabledList + ')';
    }
}
