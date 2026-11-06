package io.didomi.ssl.models;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.opentok.android.PublisherKit;
import io.didomi.ssl.Didomi;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Keep
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0003Jb\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\u0006\u0010#\u001a\u00020\u001fJ\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000f¨\u0006%"}, d2 = {"Lio/didomi/sdk/models/DeviceStorageDisclosure;", "", "identifier", "", "type", "maxAgeSeconds", "", "domain", Didomi.VIEW_PURPOSES, "", "didomiPurposes", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getDidomiPurposes", "()Ljava/util/List;", "getDomain", "()Ljava/lang/String;", "getIdentifier", "getMaxAgeSeconds", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getPurposes", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)Lio/didomi/sdk/models/DeviceStorageDisclosure;", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "isValid", "toString", "android_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class DeviceStorageDisclosure {

    @SerializedName("didomiPurposes")
    private final List<String> didomiPurposes;

    @SerializedName("domain")
    private final String domain;

    @SerializedName("identifier")
    private final String identifier;

    @SerializedName("maxAgeSeconds")
    private final Long maxAgeSeconds;

    @SerializedName(Didomi.VIEW_PURPOSES)
    private final List<String> purposes;

    @SerializedName("type")
    private final String type;

    public DeviceStorageDisclosure(String str, String str2, Long l, String str3, List<String> list, List<String> list2) {
        this.identifier = str;
        this.type = str2;
        this.maxAgeSeconds = l;
        this.domain = str3;
        this.purposes = list;
        this.didomiPurposes = list2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DeviceStorageDisclosure copy$default(DeviceStorageDisclosure deviceStorageDisclosure, String str, String str2, Long l, String str3, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deviceStorageDisclosure.identifier;
        }
        if ((i & 2) != 0) {
            str2 = deviceStorageDisclosure.type;
        }
        if ((i & 4) != 0) {
            l = deviceStorageDisclosure.maxAgeSeconds;
        }
        if ((i & 8) != 0) {
            str3 = deviceStorageDisclosure.domain;
        }
        if ((i & 16) != 0) {
            list = deviceStorageDisclosure.purposes;
        }
        if ((i & 32) != 0) {
            list2 = deviceStorageDisclosure.didomiPurposes;
        }
        List list3 = list;
        List list4 = list2;
        return deviceStorageDisclosure.copy(str, str2, l, str3, list3, list4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getIdentifier() {
        return this.identifier;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Long getMaxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getDomain() {
        return this.domain;
    }

    public final List<String> component5() {
        return this.purposes;
    }

    public final List<String> component6() {
        return this.didomiPurposes;
    }

    public final DeviceStorageDisclosure copy(String identifier, String type, Long maxAgeSeconds, String domain, List<String> purposes, List<String> didomiPurposes) {
        return new DeviceStorageDisclosure(identifier, type, maxAgeSeconds, domain, purposes, didomiPurposes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeviceStorageDisclosure)) {
            return false;
        }
        DeviceStorageDisclosure deviceStorageDisclosure = (DeviceStorageDisclosure) other;
        return Intrinsics.areEqual(this.identifier, deviceStorageDisclosure.identifier) && Intrinsics.areEqual(this.type, deviceStorageDisclosure.type) && Intrinsics.areEqual(this.maxAgeSeconds, deviceStorageDisclosure.maxAgeSeconds) && Intrinsics.areEqual(this.domain, deviceStorageDisclosure.domain) && Intrinsics.areEqual(this.purposes, deviceStorageDisclosure.purposes) && Intrinsics.areEqual(this.didomiPurposes, deviceStorageDisclosure.didomiPurposes);
    }

    public final List<String> getDidomiPurposes() {
        return this.didomiPurposes;
    }

    public final String getDomain() {
        return this.domain;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final Long getMaxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    public final List<String> getPurposes() {
        return this.purposes;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.identifier;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.type;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l = this.maxAgeSeconds;
        int iHashCode3 = (iHashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        String str3 = this.domain;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<String> list = this.purposes;
        int iHashCode5 = (iHashCode4 + (list == null ? 0 : list.hashCode())) * 31;
        List<String> list2 = this.didomiPurposes;
        return iHashCode5 + (list2 != null ? list2.hashCode() : 0);
    }

    public final boolean isValid() {
        return (this.identifier == null || this.type == null) ? false : true;
    }

    public String toString() {
        return "DeviceStorageDisclosure(identifier=" + this.identifier + ", type=" + this.type + ", maxAgeSeconds=" + this.maxAgeSeconds + ", domain=" + this.domain + ", purposes=" + this.purposes + ", didomiPurposes=" + this.didomiPurposes + ')';
    }
}
