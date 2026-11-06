package io.didomi.ssl.consent.model;

import androidx.annotation.Keep;
import com.facebook.react.bridge.BaseJavaModule;
import com.google.gson.annotations.SerializedName;
import com.opentok.android.PublisherKit;
import io.didomi.ssl.Didomi;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Keep
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0087\b\u0018\u00002\u00020\u0001:\u0001)B[\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b'\u0010(J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0007HÆ\u0003Jc\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\t\u0010\u0015\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0016HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001e\u0010\u001dR\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u001f\u0010\u001dR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b \u0010\u001dR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010!\u001a\u0004\b\"\u0010#R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010!\u001a\u0004\b$\u0010#R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010!\u001a\u0004\b%\u0010#R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010!\u001a\u0004\b&\u0010#¨\u0006*"}, d2 = {"Lio/didomi/sdk/consent/model/DidomiConsentToken;", "", "", "component1", "component2", "component3", "component4", "Lio/didomi/sdk/consent/model/DidomiConsentToken$a;", "component5", "component6", "component7", "component8", "userId", "created", "updated", BaseJavaModule.METHOD_TYPE_SYNC, Didomi.VIEW_VENDORS, Didomi.VIEW_PURPOSES, "vendorsLI", "purposesLI", "copy", "toString", "", "hashCode", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "Ljava/lang/String;", "getUserId", "()Ljava/lang/String;", "getCreated", "getUpdated", "getSync", "Lio/didomi/sdk/consent/model/DidomiConsentToken$a;", "getVendors", "()Lio/didomi/sdk/consent/model/DidomiConsentToken$a;", "getPurposes", "getVendorsLI", "getPurposesLI", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/didomi/sdk/consent/model/DidomiConsentToken$a;Lio/didomi/sdk/consent/model/DidomiConsentToken$a;Lio/didomi/sdk/consent/model/DidomiConsentToken$a;Lio/didomi/sdk/consent/model/DidomiConsentToken$a;)V", "a", "android_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class DidomiConsentToken {

    @SerializedName("created")
    private final String created;

    @SerializedName(Didomi.VIEW_PURPOSES)
    private final Ids purposes;

    @SerializedName("purposes_li")
    private final Ids purposesLI;

    @SerializedName(BaseJavaModule.METHOD_TYPE_SYNC)
    private final String sync;

    @SerializedName("updated")
    private final String updated;

    @SerializedName("user_id")
    private final String userId;

    @SerializedName(Didomi.VIEW_VENDORS)
    private final Ids vendors;

    @SerializedName("vendors_li")
    private final Ids vendorsLI;

    /* JADX INFO: renamed from: io.didomi.sdk.consent.model.DidomiConsentToken$a, reason: from toString */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\t\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\t¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r¨\u0006\u0014"}, d2 = {"Lio/didomi/sdk/consent/model/DidomiConsentToken$a;", "", "", "toString", "", "hashCode", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "", "a", "Ljava/util/Set;", "getEnabled", "()Ljava/util/Set;", "enabled", "b", "getDisabled", "disabled", "<init>", "(Ljava/util/Set;Ljava/util/Set;)V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class Ids {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
        @SerializedName("enabled")
        private final Set<Integer> enabled;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
        @SerializedName("disabled")
        private final Set<Integer> disabled;

        /* JADX WARN: Multi-variable type inference failed */
        public Ids() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Ids)) {
                return false;
            }
            Ids ids = (Ids) other;
            return Intrinsics.areEqual(this.enabled, ids.enabled) && Intrinsics.areEqual(this.disabled, ids.disabled);
        }

        public int hashCode() {
            return (this.enabled.hashCode() * 31) + this.disabled.hashCode();
        }

        public String toString() {
            return "Ids(enabled=" + this.enabled + ", disabled=" + this.disabled + ')';
        }

        public Ids(Set<Integer> enabled, Set<Integer> disabled) {
            Intrinsics.checkNotNullParameter(enabled, "enabled");
            Intrinsics.checkNotNullParameter(disabled, "disabled");
            this.enabled = enabled;
            this.disabled = disabled;
        }

        public /* synthetic */ Ids(Set set, Set set2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? SetsKt.emptySet() : set, (i & 2) != 0 ? SetsKt.emptySet() : set2);
        }
    }

    public DidomiConsentToken(String userId, String created, String updated, String str, Ids ids, Ids ids2, Ids ids3, Ids ids4) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(created, "created");
        Intrinsics.checkNotNullParameter(updated, "updated");
        this.userId = userId;
        this.created = created;
        this.updated = updated;
        this.sync = str;
        this.vendors = ids;
        this.purposes = ids2;
        this.vendorsLI = ids3;
        this.purposesLI = ids4;
    }

    public static /* synthetic */ DidomiConsentToken copy$default(DidomiConsentToken didomiConsentToken, String str, String str2, String str3, String str4, Ids ids, Ids ids2, Ids ids3, Ids ids4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = didomiConsentToken.userId;
        }
        if ((i & 2) != 0) {
            str2 = didomiConsentToken.created;
        }
        if ((i & 4) != 0) {
            str3 = didomiConsentToken.updated;
        }
        if ((i & 8) != 0) {
            str4 = didomiConsentToken.sync;
        }
        if ((i & 16) != 0) {
            ids = didomiConsentToken.vendors;
        }
        if ((i & 32) != 0) {
            ids2 = didomiConsentToken.purposes;
        }
        if ((i & 64) != 0) {
            ids3 = didomiConsentToken.vendorsLI;
        }
        if ((i & 128) != 0) {
            ids4 = didomiConsentToken.purposesLI;
        }
        Ids ids5 = ids3;
        Ids ids6 = ids4;
        Ids ids7 = ids;
        Ids ids8 = ids2;
        return didomiConsentToken.copy(str, str2, str3, str4, ids7, ids8, ids5, ids6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCreated() {
        return this.created;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getUpdated() {
        return this.updated;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSync() {
        return this.sync;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Ids getVendors() {
        return this.vendors;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Ids getPurposes() {
        return this.purposes;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Ids getVendorsLI() {
        return this.vendorsLI;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Ids getPurposesLI() {
        return this.purposesLI;
    }

    public final DidomiConsentToken copy(String userId, String created, String updated, String sync, Ids vendors, Ids purposes, Ids vendorsLI, Ids purposesLI) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(created, "created");
        Intrinsics.checkNotNullParameter(updated, "updated");
        return new DidomiConsentToken(userId, created, updated, sync, vendors, purposes, vendorsLI, purposesLI);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DidomiConsentToken)) {
            return false;
        }
        DidomiConsentToken didomiConsentToken = (DidomiConsentToken) other;
        return Intrinsics.areEqual(this.userId, didomiConsentToken.userId) && Intrinsics.areEqual(this.created, didomiConsentToken.created) && Intrinsics.areEqual(this.updated, didomiConsentToken.updated) && Intrinsics.areEqual(this.sync, didomiConsentToken.sync) && Intrinsics.areEqual(this.vendors, didomiConsentToken.vendors) && Intrinsics.areEqual(this.purposes, didomiConsentToken.purposes) && Intrinsics.areEqual(this.vendorsLI, didomiConsentToken.vendorsLI) && Intrinsics.areEqual(this.purposesLI, didomiConsentToken.purposesLI);
    }

    public final String getCreated() {
        return this.created;
    }

    public final Ids getPurposes() {
        return this.purposes;
    }

    public final Ids getPurposesLI() {
        return this.purposesLI;
    }

    public final String getSync() {
        return this.sync;
    }

    public final String getUpdated() {
        return this.updated;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final Ids getVendors() {
        return this.vendors;
    }

    public final Ids getVendorsLI() {
        return this.vendorsLI;
    }

    public int hashCode() {
        int iHashCode = ((((this.userId.hashCode() * 31) + this.created.hashCode()) * 31) + this.updated.hashCode()) * 31;
        String str = this.sync;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Ids ids = this.vendors;
        int iHashCode3 = (iHashCode2 + (ids == null ? 0 : ids.hashCode())) * 31;
        Ids ids2 = this.purposes;
        int iHashCode4 = (iHashCode3 + (ids2 == null ? 0 : ids2.hashCode())) * 31;
        Ids ids3 = this.vendorsLI;
        int iHashCode5 = (iHashCode4 + (ids3 == null ? 0 : ids3.hashCode())) * 31;
        Ids ids4 = this.purposesLI;
        return iHashCode5 + (ids4 != null ? ids4.hashCode() : 0);
    }

    public String toString() {
        return "DidomiConsentToken(userId=" + this.userId + ", created=" + this.created + ", updated=" + this.updated + ", sync=" + this.sync + ", vendors=" + this.vendors + ", purposes=" + this.purposes + ", vendorsLI=" + this.vendorsLI + ", purposesLI=" + this.purposesLI + ')';
    }

    public /* synthetic */ DidomiConsentToken(String str, String str2, String str3, String str4, Ids ids, Ids ids2, Ids ids3, Ids ids4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : ids, (i & 32) != 0 ? null : ids2, (i & 64) != 0 ? null : ids3, (i & 128) != 0 ? null : ids4);
    }
}
