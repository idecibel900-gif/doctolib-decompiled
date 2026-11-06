package io.didomi.ssl.apiEvents;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Keep
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b+\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B¡\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0016¢\u0006\u0002\u0010\u0017J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00104\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010+J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00030\u0016HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\bHÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÊ\u0001\u0010?\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0016HÆ\u0001¢\u0006\u0002\u0010@J\u0013\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010D\u001a\u00020\u0013HÖ\u0001J\t\u0010E\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0019R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u00168\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0019R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010,\u001a\u0004\b*\u0010+R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.¨\u0006F"}, d2 = {"Lio/didomi/sdk/apiEvents/User;", "", DiagnosticsEntry.ID_KEY, "", "idType", "country", "agent", "token", "Lio/didomi/sdk/apiEvents/Token;", "organizationUserId", "organizationUserIdAlgorithm", "organizationUserIdSid", "organizationUserIdSalt", "organizationUserIdDigest", "organizationUserIdExp", "", "organizationUserIdIv", "tcfConsentString", "tcfVersion", "", "additionalConsent", "regs", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/didomi/sdk/apiEvents/Token;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/Set;)V", "getAdditionalConsent", "()Ljava/lang/String;", "getAgent", "getCountry", "getId", "getIdType", "getOrganizationUserId", "getOrganizationUserIdAlgorithm", "getOrganizationUserIdDigest", "getOrganizationUserIdExp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getOrganizationUserIdIv", "getOrganizationUserIdSalt", "getOrganizationUserIdSid", "getRegs", "()Ljava/util/Set;", "getTcfConsentString", "getTcfVersion", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getToken", "()Lio/didomi/sdk/apiEvents/Token;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/didomi/sdk/apiEvents/Token;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/Set;)Lio/didomi/sdk/apiEvents/User;", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "toString", "android_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class User {

    @SerializedName("ac")
    private final String additionalConsent;

    @SerializedName("agent")
    private final String agent;

    @SerializedName("country")
    private final String country;

    @SerializedName(DiagnosticsEntry.ID_KEY)
    private final String id;

    @SerializedName("id_type")
    private final String idType;

    @SerializedName("organization_user_id")
    private final String organizationUserId;

    @SerializedName("organization_user_id_algorithm")
    private final String organizationUserIdAlgorithm;

    @SerializedName("organization_user_id_digest")
    private final String organizationUserIdDigest;

    @SerializedName("organization_user_id_exp")
    private final Long organizationUserIdExp;

    @SerializedName("organization_user_id_iv")
    private final String organizationUserIdIv;

    @SerializedName("organization_user_id_salt")
    private final String organizationUserIdSalt;

    @SerializedName("organization_user_id_sid")
    private final String organizationUserIdSid;

    @SerializedName("regs")
    private final Set<String> regs;

    @SerializedName("tcfcs")
    private final String tcfConsentString;

    @SerializedName("tcfv")
    private final Integer tcfVersion;

    @SerializedName("token")
    private final Token token;

    public User(String id, String idType, String str, String agent, Token token, String str2, String str3, String str4, String str5, String str6, Long l, String str7, String str8, Integer num, String str9, Set<String> regs) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(idType, "idType");
        Intrinsics.checkNotNullParameter(agent, "agent");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(regs, "regs");
        this.id = id;
        this.idType = idType;
        this.country = str;
        this.agent = agent;
        this.token = token;
        this.organizationUserId = str2;
        this.organizationUserIdAlgorithm = str3;
        this.organizationUserIdSid = str4;
        this.organizationUserIdSalt = str5;
        this.organizationUserIdDigest = str6;
        this.organizationUserIdExp = l;
        this.organizationUserIdIv = str7;
        this.tcfConsentString = str8;
        this.tcfVersion = num;
        this.additionalConsent = str9;
        this.regs = regs;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getOrganizationUserIdDigest() {
        return this.organizationUserIdDigest;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Long getOrganizationUserIdExp() {
        return this.organizationUserIdExp;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getOrganizationUserIdIv() {
        return this.organizationUserIdIv;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getTcfConsentString() {
        return this.tcfConsentString;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final Integer getTcfVersion() {
        return this.tcfVersion;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getAdditionalConsent() {
        return this.additionalConsent;
    }

    public final Set<String> component16() {
        return this.regs;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getIdType() {
        return this.idType;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCountry() {
        return this.country;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getAgent() {
        return this.agent;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Token getToken() {
        return this.token;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getOrganizationUserId() {
        return this.organizationUserId;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getOrganizationUserIdAlgorithm() {
        return this.organizationUserIdAlgorithm;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getOrganizationUserIdSid() {
        return this.organizationUserIdSid;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getOrganizationUserIdSalt() {
        return this.organizationUserIdSalt;
    }

    public final User copy(String id, String idType, String country, String agent, Token token, String organizationUserId, String organizationUserIdAlgorithm, String organizationUserIdSid, String organizationUserIdSalt, String organizationUserIdDigest, Long organizationUserIdExp, String organizationUserIdIv, String tcfConsentString, Integer tcfVersion, String additionalConsent, Set<String> regs) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(idType, "idType");
        Intrinsics.checkNotNullParameter(agent, "agent");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(regs, "regs");
        return new User(id, idType, country, agent, token, organizationUserId, organizationUserIdAlgorithm, organizationUserIdSid, organizationUserIdSalt, organizationUserIdDigest, organizationUserIdExp, organizationUserIdIv, tcfConsentString, tcfVersion, additionalConsent, regs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof User)) {
            return false;
        }
        User user = (User) other;
        return Intrinsics.areEqual(this.id, user.id) && Intrinsics.areEqual(this.idType, user.idType) && Intrinsics.areEqual(this.country, user.country) && Intrinsics.areEqual(this.agent, user.agent) && Intrinsics.areEqual(this.token, user.token) && Intrinsics.areEqual(this.organizationUserId, user.organizationUserId) && Intrinsics.areEqual(this.organizationUserIdAlgorithm, user.organizationUserIdAlgorithm) && Intrinsics.areEqual(this.organizationUserIdSid, user.organizationUserIdSid) && Intrinsics.areEqual(this.organizationUserIdSalt, user.organizationUserIdSalt) && Intrinsics.areEqual(this.organizationUserIdDigest, user.organizationUserIdDigest) && Intrinsics.areEqual(this.organizationUserIdExp, user.organizationUserIdExp) && Intrinsics.areEqual(this.organizationUserIdIv, user.organizationUserIdIv) && Intrinsics.areEqual(this.tcfConsentString, user.tcfConsentString) && Intrinsics.areEqual(this.tcfVersion, user.tcfVersion) && Intrinsics.areEqual(this.additionalConsent, user.additionalConsent) && Intrinsics.areEqual(this.regs, user.regs);
    }

    public final String getAdditionalConsent() {
        return this.additionalConsent;
    }

    public final String getAgent() {
        return this.agent;
    }

    public final String getCountry() {
        return this.country;
    }

    public final String getId() {
        return this.id;
    }

    public final String getIdType() {
        return this.idType;
    }

    public final String getOrganizationUserId() {
        return this.organizationUserId;
    }

    public final String getOrganizationUserIdAlgorithm() {
        return this.organizationUserIdAlgorithm;
    }

    public final String getOrganizationUserIdDigest() {
        return this.organizationUserIdDigest;
    }

    public final Long getOrganizationUserIdExp() {
        return this.organizationUserIdExp;
    }

    public final String getOrganizationUserIdIv() {
        return this.organizationUserIdIv;
    }

    public final String getOrganizationUserIdSalt() {
        return this.organizationUserIdSalt;
    }

    public final String getOrganizationUserIdSid() {
        return this.organizationUserIdSid;
    }

    public final Set<String> getRegs() {
        return this.regs;
    }

    public final String getTcfConsentString() {
        return this.tcfConsentString;
    }

    public final Integer getTcfVersion() {
        return this.tcfVersion;
    }

    public final Token getToken() {
        return this.token;
    }

    public int hashCode() {
        int iHashCode = ((this.id.hashCode() * 31) + this.idType.hashCode()) * 31;
        String str = this.country;
        int iHashCode2 = (((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.agent.hashCode()) * 31) + this.token.hashCode()) * 31;
        String str2 = this.organizationUserId;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.organizationUserIdAlgorithm;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.organizationUserIdSid;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.organizationUserIdSalt;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.organizationUserIdDigest;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Long l = this.organizationUserIdExp;
        int iHashCode8 = (iHashCode7 + (l == null ? 0 : l.hashCode())) * 31;
        String str7 = this.organizationUserIdIv;
        int iHashCode9 = (iHashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.tcfConsentString;
        int iHashCode10 = (iHashCode9 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Integer num = this.tcfVersion;
        int iHashCode11 = (iHashCode10 + (num == null ? 0 : num.hashCode())) * 31;
        String str9 = this.additionalConsent;
        return ((iHashCode11 + (str9 != null ? str9.hashCode() : 0)) * 31) + this.regs.hashCode();
    }

    public String toString() {
        return "User(id=" + this.id + ", idType=" + this.idType + ", country=" + this.country + ", agent=" + this.agent + ", token=" + this.token + ", organizationUserId=" + this.organizationUserId + ", organizationUserIdAlgorithm=" + this.organizationUserIdAlgorithm + ", organizationUserIdSid=" + this.organizationUserIdSid + ", organizationUserIdSalt=" + this.organizationUserIdSalt + ", organizationUserIdDigest=" + this.organizationUserIdDigest + ", organizationUserIdExp=" + this.organizationUserIdExp + ", organizationUserIdIv=" + this.organizationUserIdIv + ", tcfConsentString=" + this.tcfConsentString + ", tcfVersion=" + this.tcfVersion + ", additionalConsent=" + this.additionalConsent + ", regs=" + this.regs + ')';
    }
}
