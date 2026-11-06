package io.didomi.ssl;

import com.google.firebase.messaging.Constants;
import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;
import com.opentok.android.PublisherKit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: io.didomi.sdk.ua, reason: from toString */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\u0006\u0010\"\u001a\u00020\u001d\u0012\u0006\u0010%\u001a\u00020\u0002¢\u0006\u0004\b&\u0010'Bm\b\u0016\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u0010*\u001a\u00020(\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u0010,\u001a\u00020(\u0012\u0006\u0010-\u001a\u00020(\u0012\u0006\u0010.\u001a\u00020(\u0012\u0006\u0010/\u001a\u00020(\u0012\u0006\u00100\u001a\u00020(\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\b\u00101\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b&\u00102J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001a\u0010\u000e\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0011\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0019\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u0015R\u001a\u0010\"\u001a\u00020\u001d8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001a\u0010%\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010\u0013\u001a\u0004\b$\u0010\u0015¨\u00063"}, d2 = {"Lio/didomi/sdk/ua;", "", "", "toString", "", "hashCode", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "Lio/didomi/sdk/xa;", "a", "Lio/didomi/sdk/xa;", "getPurposes", "()Lio/didomi/sdk/xa;", Didomi.VIEW_PURPOSES, "b", "getVendors", Didomi.VIEW_VENDORS, "c", "Ljava/lang/String;", "getUserId", "()Ljava/lang/String;", "userId", "d", "getCreated", "created", "e", "getUpdated", "updated", "Lio/didomi/sdk/wa;", "f", "Lio/didomi/sdk/wa;", "getSource", "()Lio/didomi/sdk/wa;", Constants.ScionAnalytics.PARAM_SOURCE, "g", "getAction", "action", "<init>", "(Lio/didomi/sdk/xa;Lio/didomi/sdk/xa;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/didomi/sdk/wa;Ljava/lang/String;)V", "Lcom/google/gson/JsonArray;", "enabledPurposeIds", "disabledPurposeIds", "enabledPurposeLegIntIds", "disabledPurposeLegIntIds", "enabledVendorIds", "disabledVendorIds", "enabledVendorLegIntIds", "disabledVendorLegIntIds", "appId", "(Lcom/google/gson/JsonArray;Lcom/google/gson/JsonArray;Lcom/google/gson/JsonArray;Lcom/google/gson/JsonArray;Lcom/google/gson/JsonArray;Lcom/google/gson/JsonArray;Lcom/google/gson/JsonArray;Lcom/google/gson/JsonArray;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class QueryStringForWebView {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
    @SerializedName(Didomi.VIEW_PURPOSES)
    private final QueryStringStatus purposes;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
    @SerializedName(Didomi.VIEW_VENDORS)
    private final QueryStringStatus vendors;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
    @SerializedName("user_id")
    private final String userId;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata and from toString */
    @SerializedName("created")
    private final String created;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata and from toString */
    @SerializedName("updated")
    private final String updated;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata and from toString */
    @SerializedName(Constants.ScionAnalytics.PARAM_SOURCE)
    private final QueryStringSource source;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata and from toString */
    @SerializedName("action")
    private final String action;

    public QueryStringForWebView(QueryStringStatus purposes, QueryStringStatus vendors, String str, String created, String updated, QueryStringSource source, String action) {
        Intrinsics.checkNotNullParameter(purposes, "purposes");
        Intrinsics.checkNotNullParameter(vendors, "vendors");
        Intrinsics.checkNotNullParameter(created, "created");
        Intrinsics.checkNotNullParameter(updated, "updated");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(action, "action");
        this.purposes = purposes;
        this.vendors = vendors;
        this.userId = str;
        this.created = created;
        this.updated = updated;
        this.source = source;
        this.action = action;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QueryStringForWebView)) {
            return false;
        }
        QueryStringForWebView queryStringForWebView = (QueryStringForWebView) other;
        return Intrinsics.areEqual(this.purposes, queryStringForWebView.purposes) && Intrinsics.areEqual(this.vendors, queryStringForWebView.vendors) && Intrinsics.areEqual(this.userId, queryStringForWebView.userId) && Intrinsics.areEqual(this.created, queryStringForWebView.created) && Intrinsics.areEqual(this.updated, queryStringForWebView.updated) && Intrinsics.areEqual(this.source, queryStringForWebView.source) && Intrinsics.areEqual(this.action, queryStringForWebView.action);
    }

    public int hashCode() {
        int iHashCode = ((this.purposes.hashCode() * 31) + this.vendors.hashCode()) * 31;
        String str = this.userId;
        return ((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.created.hashCode()) * 31) + this.updated.hashCode()) * 31) + this.source.hashCode()) * 31) + this.action.hashCode();
    }

    public String toString() {
        return "QueryStringForWebView(purposes=" + this.purposes + ", vendors=" + this.vendors + ", userId=" + this.userId + ", created=" + this.created + ", updated=" + this.updated + ", source=" + this.source + ", action=" + this.action + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QueryStringForWebView(JsonArray enabledPurposeIds, JsonArray disabledPurposeIds, JsonArray enabledPurposeLegIntIds, JsonArray disabledPurposeLegIntIds, JsonArray enabledVendorIds, JsonArray disabledVendorIds, JsonArray enabledVendorLegIntIds, JsonArray disabledVendorLegIntIds, String str, String created, String updated, String str2) {
        this(new QueryStringStatus(new QueryStringItemsList(enabledPurposeIds, disabledPurposeIds), new QueryStringItemsList(enabledPurposeLegIntIds, disabledPurposeLegIntIds)), new QueryStringStatus(new QueryStringItemsList(enabledVendorIds, disabledVendorIds), new QueryStringItemsList(enabledVendorLegIntIds, disabledVendorLegIntIds)), str, created, updated, new QueryStringSource("app", str2), "webview");
        Intrinsics.checkNotNullParameter(enabledPurposeIds, "enabledPurposeIds");
        Intrinsics.checkNotNullParameter(disabledPurposeIds, "disabledPurposeIds");
        Intrinsics.checkNotNullParameter(enabledPurposeLegIntIds, "enabledPurposeLegIntIds");
        Intrinsics.checkNotNullParameter(disabledPurposeLegIntIds, "disabledPurposeLegIntIds");
        Intrinsics.checkNotNullParameter(enabledVendorIds, "enabledVendorIds");
        Intrinsics.checkNotNullParameter(disabledVendorIds, "disabledVendorIds");
        Intrinsics.checkNotNullParameter(enabledVendorLegIntIds, "enabledVendorLegIntIds");
        Intrinsics.checkNotNullParameter(disabledVendorLegIntIds, "disabledVendorLegIntIds");
        Intrinsics.checkNotNullParameter(created, "created");
        Intrinsics.checkNotNullParameter(updated, "updated");
    }
}
