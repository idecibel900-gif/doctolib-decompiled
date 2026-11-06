package io.didomi.ssl.apiEvents;

import androidx.annotation.Keep;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.google.gson.annotations.SerializedName;
import com.opentok.android.PublisherKit;
import io.didomi.ssl.Didomi;
import io.didomi.ssl.consent.model.ConsentChoices;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Keep
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003Jg\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\tHÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0016\u0010\u000b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0016\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012¨\u0006)"}, d2 = {"Lio/didomi/sdk/apiEvents/Token;", "", "userId", "", "userIdType", "created", "updated", "issuer", Didomi.VIEW_PURPOSES, "Lio/didomi/sdk/consent/model/ConsentChoices;", "legitimatePurposes", Didomi.VIEW_VENDORS, "vendorsLegInt", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/didomi/sdk/consent/model/ConsentChoices;Lio/didomi/sdk/consent/model/ConsentChoices;Lio/didomi/sdk/consent/model/ConsentChoices;Lio/didomi/sdk/consent/model/ConsentChoices;)V", "getCreated", "()Ljava/lang/String;", "getIssuer", "getLegitimatePurposes", "()Lio/didomi/sdk/consent/model/ConsentChoices;", "getPurposes", "getUpdated", "getUserId", "getUserIdType", "getVendors", "getVendorsLegInt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "android_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class Token {

    @SerializedName("created")
    private final String created;

    @SerializedName("issuer")
    private final String issuer;

    @SerializedName("purposes_li")
    private final ConsentChoices legitimatePurposes;

    @SerializedName(Didomi.VIEW_PURPOSES)
    private final ConsentChoices purposes;

    @SerializedName("updated")
    private final String updated;

    @SerializedName("user_id")
    private final String userId;

    @SerializedName("user_id_type")
    private final String userIdType;

    @SerializedName(Didomi.VIEW_VENDORS)
    private final ConsentChoices vendors;

    @SerializedName("vendors_li")
    private final ConsentChoices vendorsLegInt;

    public Token(String userId, String userIdType, String str, String str2, String issuer, ConsentChoices purposes, ConsentChoices legitimatePurposes, ConsentChoices vendors, ConsentChoices vendorsLegInt) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(userIdType, "userIdType");
        Intrinsics.checkNotNullParameter(issuer, "issuer");
        Intrinsics.checkNotNullParameter(purposes, "purposes");
        Intrinsics.checkNotNullParameter(legitimatePurposes, "legitimatePurposes");
        Intrinsics.checkNotNullParameter(vendors, "vendors");
        Intrinsics.checkNotNullParameter(vendorsLegInt, "vendorsLegInt");
        this.userId = userId;
        this.userIdType = userIdType;
        this.created = str;
        this.updated = str2;
        this.issuer = issuer;
        this.purposes = purposes;
        this.legitimatePurposes = legitimatePurposes;
        this.vendors = vendors;
        this.vendorsLegInt = vendorsLegInt;
    }

    public static /* synthetic */ Token copy$default(Token token, String str, String str2, String str3, String str4, String str5, ConsentChoices consentChoices, ConsentChoices consentChoices2, ConsentChoices consentChoices3, ConsentChoices consentChoices4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = token.userId;
        }
        if ((i & 2) != 0) {
            str2 = token.userIdType;
        }
        if ((i & 4) != 0) {
            str3 = token.created;
        }
        if ((i & 8) != 0) {
            str4 = token.updated;
        }
        if ((i & 16) != 0) {
            str5 = token.issuer;
        }
        if ((i & 32) != 0) {
            consentChoices = token.purposes;
        }
        if ((i & 64) != 0) {
            consentChoices2 = token.legitimatePurposes;
        }
        if ((i & 128) != 0) {
            consentChoices3 = token.vendors;
        }
        if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0) {
            consentChoices4 = token.vendorsLegInt;
        }
        ConsentChoices consentChoices5 = consentChoices3;
        ConsentChoices consentChoices6 = consentChoices4;
        ConsentChoices consentChoices7 = consentChoices;
        ConsentChoices consentChoices8 = consentChoices2;
        String str6 = str5;
        String str7 = str3;
        return token.copy(str, str2, str7, str4, str6, consentChoices7, consentChoices8, consentChoices5, consentChoices6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUserIdType() {
        return this.userIdType;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCreated() {
        return this.created;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getUpdated() {
        return this.updated;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getIssuer() {
        return this.issuer;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final ConsentChoices getPurposes() {
        return this.purposes;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final ConsentChoices getLegitimatePurposes() {
        return this.legitimatePurposes;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final ConsentChoices getVendors() {
        return this.vendors;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final ConsentChoices getVendorsLegInt() {
        return this.vendorsLegInt;
    }

    public final Token copy(String userId, String userIdType, String created, String updated, String issuer, ConsentChoices purposes, ConsentChoices legitimatePurposes, ConsentChoices vendors, ConsentChoices vendorsLegInt) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(userIdType, "userIdType");
        Intrinsics.checkNotNullParameter(issuer, "issuer");
        Intrinsics.checkNotNullParameter(purposes, "purposes");
        Intrinsics.checkNotNullParameter(legitimatePurposes, "legitimatePurposes");
        Intrinsics.checkNotNullParameter(vendors, "vendors");
        Intrinsics.checkNotNullParameter(vendorsLegInt, "vendorsLegInt");
        return new Token(userId, userIdType, created, updated, issuer, purposes, legitimatePurposes, vendors, vendorsLegInt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Token)) {
            return false;
        }
        Token token = (Token) other;
        return Intrinsics.areEqual(this.userId, token.userId) && Intrinsics.areEqual(this.userIdType, token.userIdType) && Intrinsics.areEqual(this.created, token.created) && Intrinsics.areEqual(this.updated, token.updated) && Intrinsics.areEqual(this.issuer, token.issuer) && Intrinsics.areEqual(this.purposes, token.purposes) && Intrinsics.areEqual(this.legitimatePurposes, token.legitimatePurposes) && Intrinsics.areEqual(this.vendors, token.vendors) && Intrinsics.areEqual(this.vendorsLegInt, token.vendorsLegInt);
    }

    public final String getCreated() {
        return this.created;
    }

    public final String getIssuer() {
        return this.issuer;
    }

    public final ConsentChoices getLegitimatePurposes() {
        return this.legitimatePurposes;
    }

    public final ConsentChoices getPurposes() {
        return this.purposes;
    }

    public final String getUpdated() {
        return this.updated;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserIdType() {
        return this.userIdType;
    }

    public final ConsentChoices getVendors() {
        return this.vendors;
    }

    public final ConsentChoices getVendorsLegInt() {
        return this.vendorsLegInt;
    }

    public int hashCode() {
        int iHashCode = ((this.userId.hashCode() * 31) + this.userIdType.hashCode()) * 31;
        String str = this.created;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.updated;
        return ((((((((((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.issuer.hashCode()) * 31) + this.purposes.hashCode()) * 31) + this.legitimatePurposes.hashCode()) * 31) + this.vendors.hashCode()) * 31) + this.vendorsLegInt.hashCode();
    }

    public String toString() {
        return "Token(userId=" + this.userId + ", userIdType=" + this.userIdType + ", created=" + this.created + ", updated=" + this.updated + ", issuer=" + this.issuer + ", purposes=" + this.purposes + ", legitimatePurposes=" + this.legitimatePurposes + ", vendors=" + this.vendors + ", vendorsLegInt=" + this.vendorsLegInt + ')';
    }

    public /* synthetic */ Token(String str, String str2, String str3, String str4, String str5, ConsentChoices consentChoices, ConsentChoices consentChoices2, ConsentChoices consentChoices3, ConsentChoices consentChoices4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, (i & 16) != 0 ? "didomi" : str5, consentChoices, consentChoices2, consentChoices3, consentChoices4);
    }
}
