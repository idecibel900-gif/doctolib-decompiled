package io.didomi.ssl.user.sync.model;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.opentok.android.PublisherKit;
import io.didomi.ssl.Didomi;
import io.didomi.ssl.consent.model.ConsentChoices;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Keep
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, d2 = {"Lio/didomi/sdk/user/sync/model/ResponseConsents;", "", "consentPurposes", "Lio/didomi/sdk/consent/model/ConsentChoices;", "liPurposes", "consentVendors", "liVendors", "(Lio/didomi/sdk/consent/model/ConsentChoices;Lio/didomi/sdk/consent/model/ConsentChoices;Lio/didomi/sdk/consent/model/ConsentChoices;Lio/didomi/sdk/consent/model/ConsentChoices;)V", "getConsentPurposes", "()Lio/didomi/sdk/consent/model/ConsentChoices;", "getConsentVendors", "getLiPurposes", "getLiVendors", "component1", "component2", "component3", "component4", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "", "android_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ResponseConsents {

    @SerializedName(Didomi.VIEW_PURPOSES)
    private final ConsentChoices consentPurposes;

    @SerializedName(Didomi.VIEW_VENDORS)
    private final ConsentChoices consentVendors;

    @SerializedName("purposes_li")
    private final ConsentChoices liPurposes;

    @SerializedName("vendors_li")
    private final ConsentChoices liVendors;

    public ResponseConsents() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ ResponseConsents copy$default(ResponseConsents responseConsents, ConsentChoices consentChoices, ConsentChoices consentChoices2, ConsentChoices consentChoices3, ConsentChoices consentChoices4, int i, Object obj) {
        if ((i & 1) != 0) {
            consentChoices = responseConsents.consentPurposes;
        }
        if ((i & 2) != 0) {
            consentChoices2 = responseConsents.liPurposes;
        }
        if ((i & 4) != 0) {
            consentChoices3 = responseConsents.consentVendors;
        }
        if ((i & 8) != 0) {
            consentChoices4 = responseConsents.liVendors;
        }
        return responseConsents.copy(consentChoices, consentChoices2, consentChoices3, consentChoices4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ConsentChoices getConsentPurposes() {
        return this.consentPurposes;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ConsentChoices getLiPurposes() {
        return this.liPurposes;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ConsentChoices getConsentVendors() {
        return this.consentVendors;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final ConsentChoices getLiVendors() {
        return this.liVendors;
    }

    public final ResponseConsents copy(ConsentChoices consentPurposes, ConsentChoices liPurposes, ConsentChoices consentVendors, ConsentChoices liVendors) {
        return new ResponseConsents(consentPurposes, liPurposes, consentVendors, liVendors);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ResponseConsents)) {
            return false;
        }
        ResponseConsents responseConsents = (ResponseConsents) other;
        return Intrinsics.areEqual(this.consentPurposes, responseConsents.consentPurposes) && Intrinsics.areEqual(this.liPurposes, responseConsents.liPurposes) && Intrinsics.areEqual(this.consentVendors, responseConsents.consentVendors) && Intrinsics.areEqual(this.liVendors, responseConsents.liVendors);
    }

    public final ConsentChoices getConsentPurposes() {
        return this.consentPurposes;
    }

    public final ConsentChoices getConsentVendors() {
        return this.consentVendors;
    }

    public final ConsentChoices getLiPurposes() {
        return this.liPurposes;
    }

    public final ConsentChoices getLiVendors() {
        return this.liVendors;
    }

    public int hashCode() {
        ConsentChoices consentChoices = this.consentPurposes;
        int iHashCode = (consentChoices == null ? 0 : consentChoices.hashCode()) * 31;
        ConsentChoices consentChoices2 = this.liPurposes;
        int iHashCode2 = (iHashCode + (consentChoices2 == null ? 0 : consentChoices2.hashCode())) * 31;
        ConsentChoices consentChoices3 = this.consentVendors;
        int iHashCode3 = (iHashCode2 + (consentChoices3 == null ? 0 : consentChoices3.hashCode())) * 31;
        ConsentChoices consentChoices4 = this.liVendors;
        return iHashCode3 + (consentChoices4 != null ? consentChoices4.hashCode() : 0);
    }

    public String toString() {
        return "ResponseConsents(consentPurposes=" + this.consentPurposes + ", liPurposes=" + this.liPurposes + ", consentVendors=" + this.consentVendors + ", liVendors=" + this.liVendors + ')';
    }

    public ResponseConsents(ConsentChoices consentChoices, ConsentChoices consentChoices2, ConsentChoices consentChoices3, ConsentChoices consentChoices4) {
        this.consentPurposes = consentChoices;
        this.liPurposes = consentChoices2;
        this.consentVendors = consentChoices3;
        this.liVendors = consentChoices4;
    }

    public /* synthetic */ ResponseConsents(ConsentChoices consentChoices, ConsentChoices consentChoices2, ConsentChoices consentChoices3, ConsentChoices consentChoices4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : consentChoices, (i & 2) != 0 ? null : consentChoices2, (i & 4) != 0 ? null : consentChoices3, (i & 8) != 0 ? null : consentChoices4);
    }
}
