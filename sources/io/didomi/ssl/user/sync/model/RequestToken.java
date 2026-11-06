package io.didomi.ssl.user.sync.model;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.opentok.android.PublisherKit;
import io.didomi.ssl.Didomi;
import io.didomi.ssl.consent.model.ConsentChoices;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Keep
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\t\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006 "}, d2 = {"Lio/didomi/sdk/user/sync/model/RequestToken;", "", "created", "", "updated", "consentPurposes", "Lio/didomi/sdk/consent/model/ConsentChoices;", "liPurposes", "consentVendors", "liVendors", "(Ljava/lang/String;Ljava/lang/String;Lio/didomi/sdk/consent/model/ConsentChoices;Lio/didomi/sdk/consent/model/ConsentChoices;Lio/didomi/sdk/consent/model/ConsentChoices;Lio/didomi/sdk/consent/model/ConsentChoices;)V", "getConsentPurposes", "()Lio/didomi/sdk/consent/model/ConsentChoices;", "getConsentVendors", "getCreated", "()Ljava/lang/String;", "getLiPurposes", "getLiVendors", "getUpdated", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "android_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class RequestToken {

    @SerializedName(Didomi.VIEW_PURPOSES)
    private final ConsentChoices consentPurposes;

    @SerializedName(Didomi.VIEW_VENDORS)
    private final ConsentChoices consentVendors;

    @SerializedName("created")
    private final String created;

    @SerializedName("purposes_li")
    private final ConsentChoices liPurposes;

    @SerializedName("vendors_li")
    private final ConsentChoices liVendors;

    @SerializedName("updated")
    private final String updated;

    public RequestToken(String created, String updated, ConsentChoices consentPurposes, ConsentChoices liPurposes, ConsentChoices consentVendors, ConsentChoices liVendors) {
        Intrinsics.checkNotNullParameter(created, "created");
        Intrinsics.checkNotNullParameter(updated, "updated");
        Intrinsics.checkNotNullParameter(consentPurposes, "consentPurposes");
        Intrinsics.checkNotNullParameter(liPurposes, "liPurposes");
        Intrinsics.checkNotNullParameter(consentVendors, "consentVendors");
        Intrinsics.checkNotNullParameter(liVendors, "liVendors");
        this.created = created;
        this.updated = updated;
        this.consentPurposes = consentPurposes;
        this.liPurposes = liPurposes;
        this.consentVendors = consentVendors;
        this.liVendors = liVendors;
    }

    public static /* synthetic */ RequestToken copy$default(RequestToken requestToken, String str, String str2, ConsentChoices consentChoices, ConsentChoices consentChoices2, ConsentChoices consentChoices3, ConsentChoices consentChoices4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = requestToken.created;
        }
        if ((i & 2) != 0) {
            str2 = requestToken.updated;
        }
        if ((i & 4) != 0) {
            consentChoices = requestToken.consentPurposes;
        }
        if ((i & 8) != 0) {
            consentChoices2 = requestToken.liPurposes;
        }
        if ((i & 16) != 0) {
            consentChoices3 = requestToken.consentVendors;
        }
        if ((i & 32) != 0) {
            consentChoices4 = requestToken.liVendors;
        }
        ConsentChoices consentChoices5 = consentChoices3;
        ConsentChoices consentChoices6 = consentChoices4;
        return requestToken.copy(str, str2, consentChoices, consentChoices2, consentChoices5, consentChoices6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCreated() {
        return this.created;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUpdated() {
        return this.updated;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ConsentChoices getConsentPurposes() {
        return this.consentPurposes;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final ConsentChoices getLiPurposes() {
        return this.liPurposes;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final ConsentChoices getConsentVendors() {
        return this.consentVendors;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final ConsentChoices getLiVendors() {
        return this.liVendors;
    }

    public final RequestToken copy(String created, String updated, ConsentChoices consentPurposes, ConsentChoices liPurposes, ConsentChoices consentVendors, ConsentChoices liVendors) {
        Intrinsics.checkNotNullParameter(created, "created");
        Intrinsics.checkNotNullParameter(updated, "updated");
        Intrinsics.checkNotNullParameter(consentPurposes, "consentPurposes");
        Intrinsics.checkNotNullParameter(liPurposes, "liPurposes");
        Intrinsics.checkNotNullParameter(consentVendors, "consentVendors");
        Intrinsics.checkNotNullParameter(liVendors, "liVendors");
        return new RequestToken(created, updated, consentPurposes, liPurposes, consentVendors, liVendors);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RequestToken)) {
            return false;
        }
        RequestToken requestToken = (RequestToken) other;
        return Intrinsics.areEqual(this.created, requestToken.created) && Intrinsics.areEqual(this.updated, requestToken.updated) && Intrinsics.areEqual(this.consentPurposes, requestToken.consentPurposes) && Intrinsics.areEqual(this.liPurposes, requestToken.liPurposes) && Intrinsics.areEqual(this.consentVendors, requestToken.consentVendors) && Intrinsics.areEqual(this.liVendors, requestToken.liVendors);
    }

    public final ConsentChoices getConsentPurposes() {
        return this.consentPurposes;
    }

    public final ConsentChoices getConsentVendors() {
        return this.consentVendors;
    }

    public final String getCreated() {
        return this.created;
    }

    public final ConsentChoices getLiPurposes() {
        return this.liPurposes;
    }

    public final ConsentChoices getLiVendors() {
        return this.liVendors;
    }

    public final String getUpdated() {
        return this.updated;
    }

    public int hashCode() {
        return (((((((((this.created.hashCode() * 31) + this.updated.hashCode()) * 31) + this.consentPurposes.hashCode()) * 31) + this.liPurposes.hashCode()) * 31) + this.consentVendors.hashCode()) * 31) + this.liVendors.hashCode();
    }

    public String toString() {
        return "RequestToken(created=" + this.created + ", updated=" + this.updated + ", consentPurposes=" + this.consentPurposes + ", liPurposes=" + this.liPurposes + ", consentVendors=" + this.consentVendors + ", liVendors=" + this.liVendors + ')';
    }
}
