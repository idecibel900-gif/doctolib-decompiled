package io.didomi.ssl.user.sync.model;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Keep
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b'\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u008d\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014¢\u0006\u0002\u0010\u0015J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u000eHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010'J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00106\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J²\u0001\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014HÆ\u0001¢\u0006\u0002\u0010:J\u0013\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010>\u001a\u00020\u0011HÖ\u0001J\t\u0010?\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R\u0016\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*¨\u0006@"}, d2 = {"Lio/didomi/sdk/user/sync/model/RequestUser;", "", DiagnosticsEntry.ID_KEY, "", "organizationUserId", "organizationUserIdAlgorithm", "organizationUserIdSid", "organizationUserIdSalt", "organizationUserIdDigest", "organizationUserIdExp", "", "organizationUserIdIv", "agent", "token", "Lio/didomi/sdk/user/sync/model/RequestToken;", "tcfcs", "tcfv", "", "lastSync", "regs", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Lio/didomi/sdk/user/sync/model/RequestToken;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/Set;)V", "getAgent", "()Ljava/lang/String;", "getId", "getLastSync", "getOrganizationUserId", "getOrganizationUserIdAlgorithm", "getOrganizationUserIdDigest", "getOrganizationUserIdExp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getOrganizationUserIdIv", "getOrganizationUserIdSalt", "getOrganizationUserIdSid", "getRegs", "()Ljava/util/Set;", "getTcfcs", "getTcfv", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getToken", "()Lio/didomi/sdk/user/sync/model/RequestToken;", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Lio/didomi/sdk/user/sync/model/RequestToken;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/Set;)Lio/didomi/sdk/user/sync/model/RequestUser;", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "toString", "android_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class RequestUser {

    @SerializedName("agent")
    private final String agent;

    @SerializedName(DiagnosticsEntry.ID_KEY)
    private final String id;

    @SerializedName("last_sync")
    private final String lastSync;

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
    private final String tcfcs;

    @SerializedName("tcfv")
    private final Integer tcfv;

    @SerializedName("token")
    private final RequestToken token;

    public RequestUser(String id, String organizationUserId, String str, String str2, String str3, String str4, Long l, String str5, String agent, RequestToken token, String str6, Integer num, String str7, Set<String> regs) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(organizationUserId, "organizationUserId");
        Intrinsics.checkNotNullParameter(agent, "agent");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(regs, "regs");
        this.id = id;
        this.organizationUserId = organizationUserId;
        this.organizationUserIdAlgorithm = str;
        this.organizationUserIdSid = str2;
        this.organizationUserIdSalt = str3;
        this.organizationUserIdDigest = str4;
        this.organizationUserIdExp = l;
        this.organizationUserIdIv = str5;
        this.agent = agent;
        this.token = token;
        this.tcfcs = str6;
        this.tcfv = num;
        this.lastSync = str7;
        this.regs = regs;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final RequestToken getToken() {
        return this.token;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getTcfcs() {
        return this.tcfcs;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Integer getTcfv() {
        return this.tcfv;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getLastSync() {
        return this.lastSync;
    }

    public final Set<String> component14() {
        return this.regs;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getOrganizationUserId() {
        return this.organizationUserId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getOrganizationUserIdAlgorithm() {
        return this.organizationUserIdAlgorithm;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getOrganizationUserIdSid() {
        return this.organizationUserIdSid;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getOrganizationUserIdSalt() {
        return this.organizationUserIdSalt;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getOrganizationUserIdDigest() {
        return this.organizationUserIdDigest;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Long getOrganizationUserIdExp() {
        return this.organizationUserIdExp;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getOrganizationUserIdIv() {
        return this.organizationUserIdIv;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getAgent() {
        return this.agent;
    }

    public final RequestUser copy(String id, String organizationUserId, String organizationUserIdAlgorithm, String organizationUserIdSid, String organizationUserIdSalt, String organizationUserIdDigest, Long organizationUserIdExp, String organizationUserIdIv, String agent, RequestToken token, String tcfcs, Integer tcfv, String lastSync, Set<String> regs) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(organizationUserId, "organizationUserId");
        Intrinsics.checkNotNullParameter(agent, "agent");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(regs, "regs");
        return new RequestUser(id, organizationUserId, organizationUserIdAlgorithm, organizationUserIdSid, organizationUserIdSalt, organizationUserIdDigest, organizationUserIdExp, organizationUserIdIv, agent, token, tcfcs, tcfv, lastSync, regs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RequestUser)) {
            return false;
        }
        RequestUser requestUser = (RequestUser) other;
        return Intrinsics.areEqual(this.id, requestUser.id) && Intrinsics.areEqual(this.organizationUserId, requestUser.organizationUserId) && Intrinsics.areEqual(this.organizationUserIdAlgorithm, requestUser.organizationUserIdAlgorithm) && Intrinsics.areEqual(this.organizationUserIdSid, requestUser.organizationUserIdSid) && Intrinsics.areEqual(this.organizationUserIdSalt, requestUser.organizationUserIdSalt) && Intrinsics.areEqual(this.organizationUserIdDigest, requestUser.organizationUserIdDigest) && Intrinsics.areEqual(this.organizationUserIdExp, requestUser.organizationUserIdExp) && Intrinsics.areEqual(this.organizationUserIdIv, requestUser.organizationUserIdIv) && Intrinsics.areEqual(this.agent, requestUser.agent) && Intrinsics.areEqual(this.token, requestUser.token) && Intrinsics.areEqual(this.tcfcs, requestUser.tcfcs) && Intrinsics.areEqual(this.tcfv, requestUser.tcfv) && Intrinsics.areEqual(this.lastSync, requestUser.lastSync) && Intrinsics.areEqual(this.regs, requestUser.regs);
    }

    public final String getAgent() {
        return this.agent;
    }

    public final String getId() {
        return this.id;
    }

    public final String getLastSync() {
        return this.lastSync;
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

    public final String getTcfcs() {
        return this.tcfcs;
    }

    public final Integer getTcfv() {
        return this.tcfv;
    }

    public final RequestToken getToken() {
        return this.token;
    }

    public int hashCode() {
        int iHashCode = ((this.id.hashCode() * 31) + this.organizationUserId.hashCode()) * 31;
        String str = this.organizationUserIdAlgorithm;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.organizationUserIdSid;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.organizationUserIdSalt;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.organizationUserIdDigest;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Long l = this.organizationUserIdExp;
        int iHashCode6 = (iHashCode5 + (l == null ? 0 : l.hashCode())) * 31;
        String str5 = this.organizationUserIdIv;
        int iHashCode7 = (((((iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.agent.hashCode()) * 31) + this.token.hashCode()) * 31;
        String str6 = this.tcfcs;
        int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Integer num = this.tcfv;
        int iHashCode9 = (iHashCode8 + (num == null ? 0 : num.hashCode())) * 31;
        String str7 = this.lastSync;
        return ((iHashCode9 + (str7 != null ? str7.hashCode() : 0)) * 31) + this.regs.hashCode();
    }

    public String toString() {
        return "RequestUser(id=" + this.id + ", organizationUserId=" + this.organizationUserId + ", organizationUserIdAlgorithm=" + this.organizationUserIdAlgorithm + ", organizationUserIdSid=" + this.organizationUserIdSid + ", organizationUserIdSalt=" + this.organizationUserIdSalt + ", organizationUserIdDigest=" + this.organizationUserIdDigest + ", organizationUserIdExp=" + this.organizationUserIdExp + ", organizationUserIdIv=" + this.organizationUserIdIv + ", agent=" + this.agent + ", token=" + this.token + ", tcfcs=" + this.tcfcs + ", tcfv=" + this.tcfv + ", lastSync=" + this.lastSync + ", regs=" + this.regs + ')';
    }
}
