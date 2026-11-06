package io.didomi.ssl.consent.model;

import androidx.annotation.Keep;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.opentok.android.PublisherKit;
import io.didomi.ssl.Purpose;
import io.didomi.ssl.Vendor;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Keep
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b'\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004Bç\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00110\u000b\u0012\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00110\u000b\u0012\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00110\u000b\u0012\u0014\b\u0002\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00110\u000b\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010\u0017J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\u0015\u00100\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00110\u000bHÆ\u0003J\u0015\u00101\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00110\u000bHÆ\u0003J\u0015\u00102\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00110\u000bHÆ\u0003J\t\u00103\u001a\u00020\u0016HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0015\u00107\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\u0015\u00108\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\u0015\u00109\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\u0015\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\u0015\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00110\u000bHÆ\u0003Jï\u0001\u0010<\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000b2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000b2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000b2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000b2\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00110\u000b2\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00110\u000b2\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00110\u000b2\u0014\b\u0002\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00110\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u0016HÆ\u0001J\u0013\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010@\u001a\u00020\u0016HÖ\u0001J\t\u0010A\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00110\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u001d\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u001d\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00110\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u001d\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00110\u000b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u001d\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00110\u000b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001bR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0019\"\u0004\b$\u0010\u0004R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0019\"\u0004\b.\u0010\u0004¨\u0006B"}, d2 = {"Lio/didomi/sdk/consent/model/ConsentToken;", "", "date", "Ljava/util/Date;", "(Ljava/util/Date;)V", "created", "updated", "lastSyncDate", "lastSyncedUserId", "", "enabledPurposes", "", "Lio/didomi/sdk/Purpose;", "disabledPurposes", "enabledLegitimatePurposes", "disabledLegitimatePurposes", "enabledVendors", "Lio/didomi/sdk/Vendor;", "disabledVendors", "enabledLegitimateVendors", "disabledLegitimateVendors", "tcfVersion", "", "(Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;I)V", "getCreated", "()Ljava/util/Date;", "getDisabledLegitimatePurposes", "()Ljava/util/Map;", "getDisabledLegitimateVendors", "getDisabledPurposes", "getDisabledVendors", "getEnabledLegitimatePurposes", "getEnabledLegitimateVendors", "getEnabledPurposes", "getEnabledVendors", "getLastSyncDate", "setLastSyncDate", "getLastSyncedUserId", "()Ljava/lang/String;", "setLastSyncedUserId", "(Ljava/lang/String;)V", "getTcfVersion", "()I", "setTcfVersion", "(I)V", "getUpdated", "setUpdated", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "toString", "android_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ConsentToken {
    private final Date created;
    private final Map<String, Purpose> disabledLegitimatePurposes;
    private final Map<String, Vendor> disabledLegitimateVendors;
    private final Map<String, Purpose> disabledPurposes;
    private final Map<String, Vendor> disabledVendors;
    private final Map<String, Purpose> enabledLegitimatePurposes;
    private final Map<String, Vendor> enabledLegitimateVendors;
    private final Map<String, Purpose> enabledPurposes;
    private final Map<String, Vendor> enabledVendors;
    private Date lastSyncDate;
    private String lastSyncedUserId;
    private int tcfVersion;
    private Date updated;

    public ConsentToken(Date created, Date updated, Date date, String str, Map<String, Purpose> enabledPurposes, Map<String, Purpose> disabledPurposes, Map<String, Purpose> enabledLegitimatePurposes, Map<String, Purpose> disabledLegitimatePurposes, Map<String, Vendor> enabledVendors, Map<String, Vendor> disabledVendors, Map<String, Vendor> enabledLegitimateVendors, Map<String, Vendor> disabledLegitimateVendors, int i) {
        Intrinsics.checkNotNullParameter(created, "created");
        Intrinsics.checkNotNullParameter(updated, "updated");
        Intrinsics.checkNotNullParameter(enabledPurposes, "enabledPurposes");
        Intrinsics.checkNotNullParameter(disabledPurposes, "disabledPurposes");
        Intrinsics.checkNotNullParameter(enabledLegitimatePurposes, "enabledLegitimatePurposes");
        Intrinsics.checkNotNullParameter(disabledLegitimatePurposes, "disabledLegitimatePurposes");
        Intrinsics.checkNotNullParameter(enabledVendors, "enabledVendors");
        Intrinsics.checkNotNullParameter(disabledVendors, "disabledVendors");
        Intrinsics.checkNotNullParameter(enabledLegitimateVendors, "enabledLegitimateVendors");
        Intrinsics.checkNotNullParameter(disabledLegitimateVendors, "disabledLegitimateVendors");
        this.created = created;
        this.updated = updated;
        this.lastSyncDate = date;
        this.lastSyncedUserId = str;
        this.enabledPurposes = enabledPurposes;
        this.disabledPurposes = disabledPurposes;
        this.enabledLegitimatePurposes = enabledLegitimatePurposes;
        this.disabledLegitimatePurposes = disabledLegitimatePurposes;
        this.enabledVendors = enabledVendors;
        this.disabledVendors = disabledVendors;
        this.enabledLegitimateVendors = enabledLegitimateVendors;
        this.disabledLegitimateVendors = disabledLegitimateVendors;
        this.tcfVersion = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConsentToken copy$default(ConsentToken consentToken, Date date, Date date2, Date date3, String str, Map map, Map map2, Map map3, Map map4, Map map5, Map map6, Map map7, Map map8, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            date = consentToken.created;
        }
        return consentToken.copy(date, (i2 & 2) != 0 ? consentToken.updated : date2, (i2 & 4) != 0 ? consentToken.lastSyncDate : date3, (i2 & 8) != 0 ? consentToken.lastSyncedUserId : str, (i2 & 16) != 0 ? consentToken.enabledPurposes : map, (i2 & 32) != 0 ? consentToken.disabledPurposes : map2, (i2 & 64) != 0 ? consentToken.enabledLegitimatePurposes : map3, (i2 & 128) != 0 ? consentToken.disabledLegitimatePurposes : map4, (i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? consentToken.enabledVendors : map5, (i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? consentToken.disabledVendors : map6, (i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? consentToken.enabledLegitimateVendors : map7, (i2 & 2048) != 0 ? consentToken.disabledLegitimateVendors : map8, (i2 & 4096) != 0 ? consentToken.tcfVersion : i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Date getCreated() {
        return this.created;
    }

    public final Map<String, Vendor> component10() {
        return this.disabledVendors;
    }

    public final Map<String, Vendor> component11() {
        return this.enabledLegitimateVendors;
    }

    public final Map<String, Vendor> component12() {
        return this.disabledLegitimateVendors;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final int getTcfVersion() {
        return this.tcfVersion;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Date getUpdated() {
        return this.updated;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Date getLastSyncDate() {
        return this.lastSyncDate;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getLastSyncedUserId() {
        return this.lastSyncedUserId;
    }

    public final Map<String, Purpose> component5() {
        return this.enabledPurposes;
    }

    public final Map<String, Purpose> component6() {
        return this.disabledPurposes;
    }

    public final Map<String, Purpose> component7() {
        return this.enabledLegitimatePurposes;
    }

    public final Map<String, Purpose> component8() {
        return this.disabledLegitimatePurposes;
    }

    public final Map<String, Vendor> component9() {
        return this.enabledVendors;
    }

    public final ConsentToken copy(Date created, Date updated, Date lastSyncDate, String lastSyncedUserId, Map<String, Purpose> enabledPurposes, Map<String, Purpose> disabledPurposes, Map<String, Purpose> enabledLegitimatePurposes, Map<String, Purpose> disabledLegitimatePurposes, Map<String, Vendor> enabledVendors, Map<String, Vendor> disabledVendors, Map<String, Vendor> enabledLegitimateVendors, Map<String, Vendor> disabledLegitimateVendors, int tcfVersion) {
        Intrinsics.checkNotNullParameter(created, "created");
        Intrinsics.checkNotNullParameter(updated, "updated");
        Intrinsics.checkNotNullParameter(enabledPurposes, "enabledPurposes");
        Intrinsics.checkNotNullParameter(disabledPurposes, "disabledPurposes");
        Intrinsics.checkNotNullParameter(enabledLegitimatePurposes, "enabledLegitimatePurposes");
        Intrinsics.checkNotNullParameter(disabledLegitimatePurposes, "disabledLegitimatePurposes");
        Intrinsics.checkNotNullParameter(enabledVendors, "enabledVendors");
        Intrinsics.checkNotNullParameter(disabledVendors, "disabledVendors");
        Intrinsics.checkNotNullParameter(enabledLegitimateVendors, "enabledLegitimateVendors");
        Intrinsics.checkNotNullParameter(disabledLegitimateVendors, "disabledLegitimateVendors");
        return new ConsentToken(created, updated, lastSyncDate, lastSyncedUserId, enabledPurposes, disabledPurposes, enabledLegitimatePurposes, disabledLegitimatePurposes, enabledVendors, disabledVendors, enabledLegitimateVendors, disabledLegitimateVendors, tcfVersion);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConsentToken)) {
            return false;
        }
        ConsentToken consentToken = (ConsentToken) other;
        return Intrinsics.areEqual(this.created, consentToken.created) && Intrinsics.areEqual(this.updated, consentToken.updated) && Intrinsics.areEqual(this.lastSyncDate, consentToken.lastSyncDate) && Intrinsics.areEqual(this.lastSyncedUserId, consentToken.lastSyncedUserId) && Intrinsics.areEqual(this.enabledPurposes, consentToken.enabledPurposes) && Intrinsics.areEqual(this.disabledPurposes, consentToken.disabledPurposes) && Intrinsics.areEqual(this.enabledLegitimatePurposes, consentToken.enabledLegitimatePurposes) && Intrinsics.areEqual(this.disabledLegitimatePurposes, consentToken.disabledLegitimatePurposes) && Intrinsics.areEqual(this.enabledVendors, consentToken.enabledVendors) && Intrinsics.areEqual(this.disabledVendors, consentToken.disabledVendors) && Intrinsics.areEqual(this.enabledLegitimateVendors, consentToken.enabledLegitimateVendors) && Intrinsics.areEqual(this.disabledLegitimateVendors, consentToken.disabledLegitimateVendors) && this.tcfVersion == consentToken.tcfVersion;
    }

    public final Date getCreated() {
        return this.created;
    }

    public final Map<String, Purpose> getDisabledLegitimatePurposes() {
        return this.disabledLegitimatePurposes;
    }

    public final Map<String, Vendor> getDisabledLegitimateVendors() {
        return this.disabledLegitimateVendors;
    }

    public final Map<String, Purpose> getDisabledPurposes() {
        return this.disabledPurposes;
    }

    public final Map<String, Vendor> getDisabledVendors() {
        return this.disabledVendors;
    }

    public final Map<String, Purpose> getEnabledLegitimatePurposes() {
        return this.enabledLegitimatePurposes;
    }

    public final Map<String, Vendor> getEnabledLegitimateVendors() {
        return this.enabledLegitimateVendors;
    }

    public final Map<String, Purpose> getEnabledPurposes() {
        return this.enabledPurposes;
    }

    public final Map<String, Vendor> getEnabledVendors() {
        return this.enabledVendors;
    }

    public final Date getLastSyncDate() {
        return this.lastSyncDate;
    }

    public final String getLastSyncedUserId() {
        return this.lastSyncedUserId;
    }

    public final int getTcfVersion() {
        return this.tcfVersion;
    }

    public final Date getUpdated() {
        return this.updated;
    }

    public int hashCode() {
        int iHashCode = ((this.created.hashCode() * 31) + this.updated.hashCode()) * 31;
        Date date = this.lastSyncDate;
        int iHashCode2 = (iHashCode + (date == null ? 0 : date.hashCode())) * 31;
        String str = this.lastSyncedUserId;
        return ((((((((((((((((((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31) + this.enabledPurposes.hashCode()) * 31) + this.disabledPurposes.hashCode()) * 31) + this.enabledLegitimatePurposes.hashCode()) * 31) + this.disabledLegitimatePurposes.hashCode()) * 31) + this.enabledVendors.hashCode()) * 31) + this.disabledVendors.hashCode()) * 31) + this.enabledLegitimateVendors.hashCode()) * 31) + this.disabledLegitimateVendors.hashCode()) * 31) + Integer.hashCode(this.tcfVersion);
    }

    public final void setLastSyncDate(Date date) {
        this.lastSyncDate = date;
    }

    public final void setLastSyncedUserId(String str) {
        this.lastSyncedUserId = str;
    }

    public final void setTcfVersion(int i) {
        this.tcfVersion = i;
    }

    public final void setUpdated(Date date) {
        Intrinsics.checkNotNullParameter(date, "<set-?>");
        this.updated = date;
    }

    public String toString() {
        return "ConsentToken(created=" + this.created + ", updated=" + this.updated + ", lastSyncDate=" + this.lastSyncDate + ", lastSyncedUserId=" + this.lastSyncedUserId + ", enabledPurposes=" + this.enabledPurposes + ", disabledPurposes=" + this.disabledPurposes + ", enabledLegitimatePurposes=" + this.enabledLegitimatePurposes + ", disabledLegitimatePurposes=" + this.disabledLegitimatePurposes + ", enabledVendors=" + this.enabledVendors + ", disabledVendors=" + this.disabledVendors + ", enabledLegitimateVendors=" + this.enabledLegitimateVendors + ", disabledLegitimateVendors=" + this.disabledLegitimateVendors + ", tcfVersion=" + this.tcfVersion + ')';
    }

    public /* synthetic */ ConsentToken(Date date, Date date2, Date date3, String str, Map map, Map map2, Map map3, Map map4, Map map5, Map map6, Map map7, Map map8, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(date, date2, (i2 & 4) != 0 ? null : date3, (i2 & 8) != 0 ? null : str, (i2 & 16) != 0 ? new LinkedHashMap() : map, (i2 & 32) != 0 ? new LinkedHashMap() : map2, (i2 & 64) != 0 ? new LinkedHashMap() : map3, (i2 & 128) != 0 ? new LinkedHashMap() : map4, (i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? new LinkedHashMap() : map5, (i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? new LinkedHashMap() : map6, (i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? new LinkedHashMap() : map7, (i2 & 2048) != 0 ? new LinkedHashMap() : map8, (i2 & 4096) != 0 ? 1 : i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ConsentToken(Date date) {
        this(date, date, null, null, null, null, null, null, null, null, null, null, 0, 8188, null);
        Intrinsics.checkNotNullParameter(date, "date");
    }
}
