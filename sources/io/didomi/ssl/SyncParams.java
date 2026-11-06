package io.didomi.ssl;

import com.amazon.a.a.o.b;
import com.opentok.android.PublisherKit;
import io.didomi.ssl.config.app.SyncConfiguration;
import io.didomi.ssl.consent.model.ConsentChoices;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: io.didomi.sdk.lc, reason: from toString */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\u0006\u0010!\u001a\u00020\u0002\u0012\u0006\u0010#\u001a\u00020\u0002\u0012\u0006\u0010%\u001a\u00020\u0002\u0012\u0006\u0010'\u001a\u00020\u000f\u0012\b\u0010*\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010.\u001a\u00020+\u0012\u0006\u0010/\u001a\u00020+\u0012\u0006\u00101\u001a\u00020+\u0012\u0006\u00103\u001a\u00020+\u0012\b\u00104\u001a\u0004\u0018\u00010\u0002\u0012\b\u00107\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b8\u00109J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0018\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0010\u0010\u0017R\u0017\u0010\u0019\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u0016\u001a\u0004\b\n\u0010\u0017R\u0017\u0010\u001b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017R\u0017\u0010\u001e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u0017R\u0017\u0010!\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0016\u001a\u0004\b \u0010\u0017R\u0017\u0010#\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\"\u0010\u0016\u001a\u0004\b\"\u0010\u0017R\u0017\u0010%\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0016\u001a\u0004\b$\u0010\u0017R\u0017\u0010'\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b&\u0010\u0011\u001a\u0004\b\u001f\u0010\u0013R\u0019\u0010*\u001a\u0004\u0018\u00010\u000f8\u0006¢\u0006\f\n\u0004\b(\u0010\u0011\u001a\u0004\b)\u0010\u0013R\u0017\u0010.\u001a\u00020+8\u0006¢\u0006\f\n\u0004\b\u001d\u0010,\u001a\u0004\b\u001a\u0010-R\u0017\u0010/\u001a\u00020+8\u0006¢\u0006\f\n\u0004\b \u0010,\u001a\u0004\b&\u0010-R\u0017\u00101\u001a\u00020+8\u0006¢\u0006\f\n\u0004\b0\u0010,\u001a\u0004\b\u001c\u0010-R\u0017\u00103\u001a\u00020+8\u0006¢\u0006\f\n\u0004\b2\u0010,\u001a\u0004\b(\u0010-R\u0019\u00104\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b)\u0010\u0016\u001a\u0004\b0\u0010\u0017R\u0019\u00107\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b$\u00105\u001a\u0004\b2\u00106¨\u0006:"}, d2 = {"Lio/didomi/sdk/lc;", "", "", "toString", "", "hashCode", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "Lio/didomi/sdk/config/app/SyncConfiguration;", "a", "Lio/didomi/sdk/config/app/SyncConfiguration;", "d", "()Lio/didomi/sdk/config/app/SyncConfiguration;", "config", "Ljava/util/Date;", "b", "Ljava/util/Date;", "i", "()Ljava/util/Date;", "lastSyncDate", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "apiBaseURL", "agent", "e", "apiKey", "f", "l", b.I, "g", "m", "sourceType", "h", "domain", "q", "userId", "j", "created", "k", "p", "updated", "Lio/didomi/sdk/consent/model/ConsentChoices;", "Lio/didomi/sdk/consent/model/ConsentChoices;", "()Lio/didomi/sdk/consent/model/ConsentChoices;", "consentPurposes", "liPurposes", "n", "consentVendors", "o", "liVendors", "tcfcs", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "tcfv", "<init>", "(Lio/didomi/sdk/config/app/SyncConfiguration;Ljava/util/Date;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Lio/didomi/sdk/consent/model/ConsentChoices;Lio/didomi/sdk/consent/model/ConsentChoices;Lio/didomi/sdk/consent/model/ConsentChoices;Lio/didomi/sdk/consent/model/ConsentChoices;Ljava/lang/String;Ljava/lang/Integer;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class SyncParams {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
    private final SyncConfiguration config;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
    private final Date lastSyncDate;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
    private final String apiBaseURL;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata and from toString */
    private final String agent;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata and from toString */
    private final String apiKey;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata and from toString */
    private final String sdkVersion;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata and from toString */
    private final String sourceType;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata and from toString */
    private final String domain;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata and from toString */
    private final String userId;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata and from toString */
    private final Date created;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata and from toString */
    private final Date updated;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata and from toString */
    private final ConsentChoices consentPurposes;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata and from toString */
    private final ConsentChoices liPurposes;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata and from toString */
    private final ConsentChoices consentVendors;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata and from toString */
    private final ConsentChoices liVendors;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata and from toString */
    private final String tcfcs;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata and from toString */
    private final Integer tcfv;

    public SyncParams(SyncConfiguration config, Date date, String apiBaseURL, String agent, String apiKey, String sdkVersion, String sourceType, String domain, String userId, Date created, Date date2, ConsentChoices consentPurposes, ConsentChoices liPurposes, ConsentChoices consentVendors, ConsentChoices liVendors, String str, Integer num) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(apiBaseURL, "apiBaseURL");
        Intrinsics.checkNotNullParameter(agent, "agent");
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        Intrinsics.checkNotNullParameter(sdkVersion, "sdkVersion");
        Intrinsics.checkNotNullParameter(sourceType, "sourceType");
        Intrinsics.checkNotNullParameter(domain, "domain");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(created, "created");
        Intrinsics.checkNotNullParameter(consentPurposes, "consentPurposes");
        Intrinsics.checkNotNullParameter(liPurposes, "liPurposes");
        Intrinsics.checkNotNullParameter(consentVendors, "consentVendors");
        Intrinsics.checkNotNullParameter(liVendors, "liVendors");
        this.config = config;
        this.lastSyncDate = date;
        this.apiBaseURL = apiBaseURL;
        this.agent = agent;
        this.apiKey = apiKey;
        this.sdkVersion = sdkVersion;
        this.sourceType = sourceType;
        this.domain = domain;
        this.userId = userId;
        this.created = created;
        this.updated = date2;
        this.consentPurposes = consentPurposes;
        this.liPurposes = liPurposes;
        this.consentVendors = consentVendors;
        this.liVendors = liVendors;
        this.tcfcs = str;
        this.tcfv = num;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getAgent() {
        return this.agent;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getApiBaseURL() {
        return this.apiBaseURL;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getApiKey() {
        return this.apiKey;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final SyncConfiguration getConfig() {
        return this.config;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final ConsentChoices getConsentPurposes() {
        return this.consentPurposes;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SyncParams)) {
            return false;
        }
        SyncParams syncParams = (SyncParams) other;
        return Intrinsics.areEqual(this.config, syncParams.config) && Intrinsics.areEqual(this.lastSyncDate, syncParams.lastSyncDate) && Intrinsics.areEqual(this.apiBaseURL, syncParams.apiBaseURL) && Intrinsics.areEqual(this.agent, syncParams.agent) && Intrinsics.areEqual(this.apiKey, syncParams.apiKey) && Intrinsics.areEqual(this.sdkVersion, syncParams.sdkVersion) && Intrinsics.areEqual(this.sourceType, syncParams.sourceType) && Intrinsics.areEqual(this.domain, syncParams.domain) && Intrinsics.areEqual(this.userId, syncParams.userId) && Intrinsics.areEqual(this.created, syncParams.created) && Intrinsics.areEqual(this.updated, syncParams.updated) && Intrinsics.areEqual(this.consentPurposes, syncParams.consentPurposes) && Intrinsics.areEqual(this.liPurposes, syncParams.liPurposes) && Intrinsics.areEqual(this.consentVendors, syncParams.consentVendors) && Intrinsics.areEqual(this.liVendors, syncParams.liVendors) && Intrinsics.areEqual(this.tcfcs, syncParams.tcfcs) && Intrinsics.areEqual(this.tcfv, syncParams.tcfv);
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final ConsentChoices getConsentVendors() {
        return this.consentVendors;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final Date getCreated() {
        return this.created;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final String getDomain() {
        return this.domain;
    }

    public int hashCode() {
        int iHashCode = this.config.hashCode() * 31;
        Date date = this.lastSyncDate;
        int iHashCode2 = (((((((((((((((((iHashCode + (date == null ? 0 : date.hashCode())) * 31) + this.apiBaseURL.hashCode()) * 31) + this.agent.hashCode()) * 31) + this.apiKey.hashCode()) * 31) + this.sdkVersion.hashCode()) * 31) + this.sourceType.hashCode()) * 31) + this.domain.hashCode()) * 31) + this.userId.hashCode()) * 31) + this.created.hashCode()) * 31;
        Date date2 = this.updated;
        int iHashCode3 = (((((((((iHashCode2 + (date2 == null ? 0 : date2.hashCode())) * 31) + this.consentPurposes.hashCode()) * 31) + this.liPurposes.hashCode()) * 31) + this.consentVendors.hashCode()) * 31) + this.liVendors.hashCode()) * 31;
        String str = this.tcfcs;
        int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.tcfv;
        return iHashCode4 + (num != null ? num.hashCode() : 0);
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final Date getLastSyncDate() {
        return this.lastSyncDate;
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    public final ConsentChoices getLiPurposes() {
        return this.liPurposes;
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final ConsentChoices getLiVendors() {
        return this.liVendors;
    }

    /* JADX INFO: renamed from: l, reason: from getter */
    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    /* JADX INFO: renamed from: m, reason: from getter */
    public final String getSourceType() {
        return this.sourceType;
    }

    /* JADX INFO: renamed from: n, reason: from getter */
    public final String getTcfcs() {
        return this.tcfcs;
    }

    /* JADX INFO: renamed from: o, reason: from getter */
    public final Integer getTcfv() {
        return this.tcfv;
    }

    /* JADX INFO: renamed from: p, reason: from getter */
    public final Date getUpdated() {
        return this.updated;
    }

    /* JADX INFO: renamed from: q, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    public String toString() {
        return "SyncParams(config=" + this.config + ", lastSyncDate=" + this.lastSyncDate + ", apiBaseURL=" + this.apiBaseURL + ", agent=" + this.agent + ", apiKey=" + this.apiKey + ", sdkVersion=" + this.sdkVersion + ", sourceType=" + this.sourceType + ", domain=" + this.domain + ", userId=" + this.userId + ", created=" + this.created + ", updated=" + this.updated + ", consentPurposes=" + this.consentPurposes + ", liPurposes=" + this.liPurposes + ", consentVendors=" + this.consentVendors + ", liVendors=" + this.liVendors + ", tcfcs=" + this.tcfcs + ", tcfv=" + this.tcfv + ')';
    }
}
