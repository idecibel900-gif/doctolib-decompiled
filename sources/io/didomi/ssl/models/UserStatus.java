package io.didomi.ssl.models;

import androidx.annotation.Keep;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.google.gson.annotations.SerializedName;
import com.opentok.android.PublisherKit;
import io.didomi.ssl.Didomi;
import io.didomi.ssl.Regulation;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.AuthorizationRequest;

/* JADX INFO: loaded from: classes5.dex */
@Keep
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001:\u0003./0B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007¢\u0006\u0002\u0010\u000eJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\t\u0010%\u001a\u00020\u0007HÆ\u0003J\t\u0010&\u001a\u00020\u0007HÂ\u0003Jc\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u0007HÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020\u0007HÖ\u0001R\u0016\u0010\u000b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\n\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0016\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0010\u0010\r\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u00061"}, d2 = {"Lio/didomi/sdk/models/UserStatus;", "", Didomi.VIEW_PURPOSES, "Lio/didomi/sdk/models/UserStatus$Purposes;", Didomi.VIEW_VENDORS, "Lio/didomi/sdk/models/UserStatus$Vendors;", "userId", "", "created", "updated", "consentString", "additionalConsent", "didomiDcs", "regulationString", "(Lio/didomi/sdk/models/UserStatus$Purposes;Lio/didomi/sdk/models/UserStatus$Vendors;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAdditionalConsent", "()Ljava/lang/String;", "getConsentString", "getCreated", "getDidomiDcs", "getPurposes", "()Lio/didomi/sdk/models/UserStatus$Purposes;", "regulation", "Lio/didomi/sdk/Regulation;", "getRegulation", "()Lio/didomi/sdk/Regulation;", "getUpdated", "getUserId", "getVendors", "()Lio/didomi/sdk/models/UserStatus$Vendors;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "Ids", "Purposes", "Vendors", "android_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class UserStatus {

    @SerializedName("addtl_consent")
    private final String additionalConsent;

    @SerializedName("consent_string")
    private final String consentString;

    @SerializedName("created")
    private final String created;

    @SerializedName("didomi_dcs")
    private final String didomiDcs;

    @SerializedName(Didomi.VIEW_PURPOSES)
    private final Purposes purposes;
    private final transient Regulation regulation;

    @SerializedName("regulation")
    private final String regulationString;

    @SerializedName("updated")
    private final String updated;

    @SerializedName("user_id")
    private final String userId;

    @SerializedName(Didomi.VIEW_VENDORS)
    private final Vendors vendors;

    @Keep
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0006J\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J)\u0010\f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0004HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lio/didomi/sdk/models/UserStatus$Ids;", "", "disabled", "", "", "enabled", "(Ljava/util/Set;Ljava/util/Set;)V", "getDisabled", "()Ljava/util/Set;", "getEnabled", "component1", "component2", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "android_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Ids {

        @SerializedName("disabled")
        private final Set<String> disabled;

        @SerializedName("enabled")
        private final Set<String> enabled;

        /* JADX WARN: Multi-variable type inference failed */
        public Ids() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Ids copy$default(Ids ids, Set set, Set set2, int i, Object obj) {
            if ((i & 1) != 0) {
                set = ids.disabled;
            }
            if ((i & 2) != 0) {
                set2 = ids.enabled;
            }
            return ids.copy(set, set2);
        }

        public final Set<String> component1() {
            return this.disabled;
        }

        public final Set<String> component2() {
            return this.enabled;
        }

        public final Ids copy(Set<String> disabled, Set<String> enabled) {
            Intrinsics.checkNotNullParameter(disabled, "disabled");
            Intrinsics.checkNotNullParameter(enabled, "enabled");
            return new Ids(disabled, enabled);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Ids)) {
                return false;
            }
            Ids ids = (Ids) other;
            return Intrinsics.areEqual(this.disabled, ids.disabled) && Intrinsics.areEqual(this.enabled, ids.enabled);
        }

        public final Set<String> getDisabled() {
            return this.disabled;
        }

        public final Set<String> getEnabled() {
            return this.enabled;
        }

        public int hashCode() {
            return (this.disabled.hashCode() * 31) + this.enabled.hashCode();
        }

        public String toString() {
            return "Ids(disabled=" + this.disabled + ", enabled=" + this.enabled + ')';
        }

        public Ids(Set<String> disabled, Set<String> enabled) {
            Intrinsics.checkNotNullParameter(disabled, "disabled");
            Intrinsics.checkNotNullParameter(enabled, "enabled");
            this.disabled = disabled;
            this.enabled = enabled;
        }

        public /* synthetic */ Ids(Set set, Set set2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? SetsKt.emptySet() : set, (i & 2) != 0 ? SetsKt.emptySet() : set2);
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\bHÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001b"}, d2 = {"Lio/didomi/sdk/models/UserStatus$Purposes;", "", "global", "Lio/didomi/sdk/models/UserStatus$Ids;", AuthorizationRequest.Prompt.CONSENT, "legitimateInterest", "essential", "", "", "(Lio/didomi/sdk/models/UserStatus$Ids;Lio/didomi/sdk/models/UserStatus$Ids;Lio/didomi/sdk/models/UserStatus$Ids;Ljava/util/Set;)V", "getConsent", "()Lio/didomi/sdk/models/UserStatus$Ids;", "getEssential", "()Ljava/util/Set;", "getGlobal", "getLegitimateInterest", "component1", "component2", "component3", "component4", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "android_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Purposes {

        @SerializedName(AuthorizationRequest.Prompt.CONSENT)
        private final Ids consent;

        @SerializedName("essential")
        private final Set<String> essential;

        @SerializedName("global")
        private final Ids global;

        @SerializedName("legitimate_interest")
        private final Ids legitimateInterest;

        public Purposes() {
            this(null, null, null, null, 15, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Purposes copy$default(Purposes purposes, Ids ids, Ids ids2, Ids ids3, Set set, int i, Object obj) {
            if ((i & 1) != 0) {
                ids = purposes.global;
            }
            if ((i & 2) != 0) {
                ids2 = purposes.consent;
            }
            if ((i & 4) != 0) {
                ids3 = purposes.legitimateInterest;
            }
            if ((i & 8) != 0) {
                set = purposes.essential;
            }
            return purposes.copy(ids, ids2, ids3, set);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Ids getGlobal() {
            return this.global;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Ids getConsent() {
            return this.consent;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Ids getLegitimateInterest() {
            return this.legitimateInterest;
        }

        public final Set<String> component4() {
            return this.essential;
        }

        public final Purposes copy(Ids global, Ids consent, Ids legitimateInterest, Set<String> essential) {
            Intrinsics.checkNotNullParameter(global, "global");
            Intrinsics.checkNotNullParameter(consent, "consent");
            Intrinsics.checkNotNullParameter(legitimateInterest, "legitimateInterest");
            Intrinsics.checkNotNullParameter(essential, "essential");
            return new Purposes(global, consent, legitimateInterest, essential);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Purposes)) {
                return false;
            }
            Purposes purposes = (Purposes) other;
            return Intrinsics.areEqual(this.global, purposes.global) && Intrinsics.areEqual(this.consent, purposes.consent) && Intrinsics.areEqual(this.legitimateInterest, purposes.legitimateInterest) && Intrinsics.areEqual(this.essential, purposes.essential);
        }

        public final Ids getConsent() {
            return this.consent;
        }

        public final Set<String> getEssential() {
            return this.essential;
        }

        public final Ids getGlobal() {
            return this.global;
        }

        public final Ids getLegitimateInterest() {
            return this.legitimateInterest;
        }

        public int hashCode() {
            return (((((this.global.hashCode() * 31) + this.consent.hashCode()) * 31) + this.legitimateInterest.hashCode()) * 31) + this.essential.hashCode();
        }

        public String toString() {
            return "Purposes(global=" + this.global + ", consent=" + this.consent + ", legitimateInterest=" + this.legitimateInterest + ", essential=" + this.essential + ')';
        }

        public Purposes(Ids global, Ids consent, Ids legitimateInterest, Set<String> essential) {
            Intrinsics.checkNotNullParameter(global, "global");
            Intrinsics.checkNotNullParameter(consent, "consent");
            Intrinsics.checkNotNullParameter(legitimateInterest, "legitimateInterest");
            Intrinsics.checkNotNullParameter(essential, "essential");
            this.global = global;
            this.consent = consent;
            this.legitimateInterest = legitimateInterest;
            this.essential = essential;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Multi-variable type inference failed */
        public /* synthetic */ Purposes(Ids ids, Ids ids2, Ids ids3, Set set, int i, DefaultConstructorMarker defaultConstructorMarker) {
            int i2 = 2;
            this((i & 1) != 0 ? new Ids(SetsKt.emptySet(), null, i2, 0 == true ? 1 : 0) : ids, (i & 2) != 0 ? new Ids(SetsKt.emptySet(), 0 == true ? 1 : 0, i2, 0 == true ? 1 : 0) : ids2, (i & 4) != 0 ? new Ids(SetsKt.emptySet(), 0 == true ? 1 : 0, i2, 0 == true ? 1 : 0) : ids3, (i & 8) != 0 ? SetsKt.emptySet() : set);
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001c"}, d2 = {"Lio/didomi/sdk/models/UserStatus$Vendors;", "", "global", "Lio/didomi/sdk/models/UserStatus$Ids;", "globalConsent", "globalLegitimateInterest", AuthorizationRequest.Prompt.CONSENT, "legitimateInterest", "(Lio/didomi/sdk/models/UserStatus$Ids;Lio/didomi/sdk/models/UserStatus$Ids;Lio/didomi/sdk/models/UserStatus$Ids;Lio/didomi/sdk/models/UserStatus$Ids;Lio/didomi/sdk/models/UserStatus$Ids;)V", "getConsent", "()Lio/didomi/sdk/models/UserStatus$Ids;", "getGlobal", "getGlobalConsent", "getGlobalLegitimateInterest", "getLegitimateInterest", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "", "android_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Vendors {

        @SerializedName(AuthorizationRequest.Prompt.CONSENT)
        private final Ids consent;

        @SerializedName("global")
        private final Ids global;

        @SerializedName("global_consent")
        private final Ids globalConsent;

        @SerializedName("global_li")
        private final Ids globalLegitimateInterest;

        @SerializedName("legitimate_interest")
        private final Ids legitimateInterest;

        public Vendors() {
            this(null, null, null, null, null, 31, null);
        }

        public static /* synthetic */ Vendors copy$default(Vendors vendors, Ids ids, Ids ids2, Ids ids3, Ids ids4, Ids ids5, int i, Object obj) {
            if ((i & 1) != 0) {
                ids = vendors.global;
            }
            if ((i & 2) != 0) {
                ids2 = vendors.globalConsent;
            }
            if ((i & 4) != 0) {
                ids3 = vendors.globalLegitimateInterest;
            }
            if ((i & 8) != 0) {
                ids4 = vendors.consent;
            }
            if ((i & 16) != 0) {
                ids5 = vendors.legitimateInterest;
            }
            Ids ids6 = ids5;
            Ids ids7 = ids3;
            return vendors.copy(ids, ids2, ids7, ids4, ids6);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Ids getGlobal() {
            return this.global;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Ids getGlobalConsent() {
            return this.globalConsent;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Ids getGlobalLegitimateInterest() {
            return this.globalLegitimateInterest;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Ids getConsent() {
            return this.consent;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Ids getLegitimateInterest() {
            return this.legitimateInterest;
        }

        public final Vendors copy(Ids global, Ids globalConsent, Ids globalLegitimateInterest, Ids consent, Ids legitimateInterest) {
            Intrinsics.checkNotNullParameter(global, "global");
            Intrinsics.checkNotNullParameter(globalConsent, "globalConsent");
            Intrinsics.checkNotNullParameter(globalLegitimateInterest, "globalLegitimateInterest");
            Intrinsics.checkNotNullParameter(consent, "consent");
            Intrinsics.checkNotNullParameter(legitimateInterest, "legitimateInterest");
            return new Vendors(global, globalConsent, globalLegitimateInterest, consent, legitimateInterest);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Vendors)) {
                return false;
            }
            Vendors vendors = (Vendors) other;
            return Intrinsics.areEqual(this.global, vendors.global) && Intrinsics.areEqual(this.globalConsent, vendors.globalConsent) && Intrinsics.areEqual(this.globalLegitimateInterest, vendors.globalLegitimateInterest) && Intrinsics.areEqual(this.consent, vendors.consent) && Intrinsics.areEqual(this.legitimateInterest, vendors.legitimateInterest);
        }

        public final Ids getConsent() {
            return this.consent;
        }

        public final Ids getGlobal() {
            return this.global;
        }

        public final Ids getGlobalConsent() {
            return this.globalConsent;
        }

        public final Ids getGlobalLegitimateInterest() {
            return this.globalLegitimateInterest;
        }

        public final Ids getLegitimateInterest() {
            return this.legitimateInterest;
        }

        public int hashCode() {
            return (((((((this.global.hashCode() * 31) + this.globalConsent.hashCode()) * 31) + this.globalLegitimateInterest.hashCode()) * 31) + this.consent.hashCode()) * 31) + this.legitimateInterest.hashCode();
        }

        public String toString() {
            return "Vendors(global=" + this.global + ", globalConsent=" + this.globalConsent + ", globalLegitimateInterest=" + this.globalLegitimateInterest + ", consent=" + this.consent + ", legitimateInterest=" + this.legitimateInterest + ')';
        }

        public Vendors(Ids global, Ids globalConsent, Ids globalLegitimateInterest, Ids consent, Ids legitimateInterest) {
            Intrinsics.checkNotNullParameter(global, "global");
            Intrinsics.checkNotNullParameter(globalConsent, "globalConsent");
            Intrinsics.checkNotNullParameter(globalLegitimateInterest, "globalLegitimateInterest");
            Intrinsics.checkNotNullParameter(consent, "consent");
            Intrinsics.checkNotNullParameter(legitimateInterest, "legitimateInterest");
            this.global = global;
            this.globalConsent = globalConsent;
            this.globalLegitimateInterest = globalLegitimateInterest;
            this.consent = consent;
            this.legitimateInterest = legitimateInterest;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Multi-variable type inference failed */
        public /* synthetic */ Vendors(Ids ids, Ids ids2, Ids ids3, Ids ids4, Ids ids5, int i, DefaultConstructorMarker defaultConstructorMarker) {
            int i2 = 3;
            this((i & 1) != 0 ? new Ids(null, 0 == true ? 1 : 0, i2, 0 == true ? 1 : 0) : ids, (i & 2) != 0 ? new Ids(0 == true ? 1 : 0, 0 == true ? 1 : 0, i2, 0 == true ? 1 : 0) : ids2, (i & 4) != 0 ? new Ids(0 == true ? 1 : 0, 0 == true ? 1 : 0, i2, 0 == true ? 1 : 0) : ids3, (i & 8) != 0 ? new Ids(0 == true ? 1 : 0, 0 == true ? 1 : 0, i2, 0 == true ? 1 : 0) : ids4, (i & 16) != 0 ? new Ids(0 == true ? 1 : 0, 0 == true ? 1 : 0, i2, 0 == true ? 1 : 0) : ids5);
        }
    }

    public UserStatus() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    private final String getRegulationString() {
        return this.regulationString;
    }

    public static /* synthetic */ UserStatus copy$default(UserStatus userStatus, Purposes purposes, Vendors vendors, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            purposes = userStatus.purposes;
        }
        if ((i & 2) != 0) {
            vendors = userStatus.vendors;
        }
        if ((i & 4) != 0) {
            str = userStatus.userId;
        }
        if ((i & 8) != 0) {
            str2 = userStatus.created;
        }
        if ((i & 16) != 0) {
            str3 = userStatus.updated;
        }
        if ((i & 32) != 0) {
            str4 = userStatus.consentString;
        }
        if ((i & 64) != 0) {
            str5 = userStatus.additionalConsent;
        }
        if ((i & 128) != 0) {
            str6 = userStatus.didomiDcs;
        }
        if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0) {
            str7 = userStatus.regulationString;
        }
        String str8 = str6;
        String str9 = str7;
        String str10 = str4;
        String str11 = str5;
        String str12 = str3;
        String str13 = str;
        return userStatus.copy(purposes, vendors, str13, str2, str12, str10, str11, str8, str9);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Purposes getPurposes() {
        return this.purposes;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Vendors getVendors() {
        return this.vendors;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCreated() {
        return this.created;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getUpdated() {
        return this.updated;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getConsentString() {
        return this.consentString;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getAdditionalConsent() {
        return this.additionalConsent;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getDidomiDcs() {
        return this.didomiDcs;
    }

    public final UserStatus copy(Purposes purposes, Vendors vendors, String userId, String created, String updated, String consentString, String additionalConsent, String didomiDcs, String regulationString) {
        Intrinsics.checkNotNullParameter(purposes, "purposes");
        Intrinsics.checkNotNullParameter(vendors, "vendors");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(created, "created");
        Intrinsics.checkNotNullParameter(updated, "updated");
        Intrinsics.checkNotNullParameter(consentString, "consentString");
        Intrinsics.checkNotNullParameter(additionalConsent, "additionalConsent");
        Intrinsics.checkNotNullParameter(didomiDcs, "didomiDcs");
        Intrinsics.checkNotNullParameter(regulationString, "regulationString");
        return new UserStatus(purposes, vendors, userId, created, updated, consentString, additionalConsent, didomiDcs, regulationString);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserStatus)) {
            return false;
        }
        UserStatus userStatus = (UserStatus) other;
        return Intrinsics.areEqual(this.purposes, userStatus.purposes) && Intrinsics.areEqual(this.vendors, userStatus.vendors) && Intrinsics.areEqual(this.userId, userStatus.userId) && Intrinsics.areEqual(this.created, userStatus.created) && Intrinsics.areEqual(this.updated, userStatus.updated) && Intrinsics.areEqual(this.consentString, userStatus.consentString) && Intrinsics.areEqual(this.additionalConsent, userStatus.additionalConsent) && Intrinsics.areEqual(this.didomiDcs, userStatus.didomiDcs) && Intrinsics.areEqual(this.regulationString, userStatus.regulationString);
    }

    public final String getAdditionalConsent() {
        return this.additionalConsent;
    }

    public final String getConsentString() {
        return this.consentString;
    }

    public final String getCreated() {
        return this.created;
    }

    public final String getDidomiDcs() {
        return this.didomiDcs;
    }

    public final Purposes getPurposes() {
        return this.purposes;
    }

    public final Regulation getRegulation() {
        return this.regulation;
    }

    public final String getUpdated() {
        return this.updated;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final Vendors getVendors() {
        return this.vendors;
    }

    public int hashCode() {
        return (((((((((((((((this.purposes.hashCode() * 31) + this.vendors.hashCode()) * 31) + this.userId.hashCode()) * 31) + this.created.hashCode()) * 31) + this.updated.hashCode()) * 31) + this.consentString.hashCode()) * 31) + this.additionalConsent.hashCode()) * 31) + this.didomiDcs.hashCode()) * 31) + this.regulationString.hashCode();
    }

    public String toString() {
        return "UserStatus(purposes=" + this.purposes + ", vendors=" + this.vendors + ", userId=" + this.userId + ", created=" + this.created + ", updated=" + this.updated + ", consentString=" + this.consentString + ", additionalConsent=" + this.additionalConsent + ", didomiDcs=" + this.didomiDcs + ", regulationString=" + this.regulationString + ')';
    }

    public UserStatus(Purposes purposes, Vendors vendors, String userId, String created, String updated, String consentString, String additionalConsent, String didomiDcs, String regulationString) {
        Intrinsics.checkNotNullParameter(purposes, "purposes");
        Intrinsics.checkNotNullParameter(vendors, "vendors");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(created, "created");
        Intrinsics.checkNotNullParameter(updated, "updated");
        Intrinsics.checkNotNullParameter(consentString, "consentString");
        Intrinsics.checkNotNullParameter(additionalConsent, "additionalConsent");
        Intrinsics.checkNotNullParameter(didomiDcs, "didomiDcs");
        Intrinsics.checkNotNullParameter(regulationString, "regulationString");
        this.purposes = purposes;
        this.vendors = vendors;
        this.userId = userId;
        this.created = created;
        this.updated = updated;
        this.consentString = consentString;
        this.additionalConsent = additionalConsent;
        this.didomiDcs = didomiDcs;
        this.regulationString = regulationString;
        this.regulation = Regulation.INSTANCE.a(regulationString);
    }

    public /* synthetic */ UserStatus(Purposes purposes, Vendors vendors, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Purposes(null, null, null, null, 15, null) : purposes, (i & 2) != 0 ? new Vendors(null, null, null, null, null, 31, null) : vendors, (i & 4) != 0 ? "" : str, (i & 8) != 0 ? "" : str2, (i & 16) != 0 ? "" : str3, (i & 32) != 0 ? "" : str4, (i & 64) != 0 ? "" : str5, (i & 128) == 0 ? str6 : "", (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? Regulation.GDPR.getValue() : str7);
    }
}
