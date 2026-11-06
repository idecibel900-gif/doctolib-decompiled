package com.revenuecat.purchases;

import com.amazon.a.a.o.b;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.common.HTTPResponseOriginalSource;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002)*B%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0007BQ\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J[\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\u001eJ\u0013\u0010\u001f\u001a\u00020\u000f2\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0013\u0010!\u001a\u0004\u0018\u00010\u00032\u0006\u0010\"\u001a\u00020\u0006H\u0086\u0002J\u0010\u0010#\u001a\u0004\u0018\u00010\u00032\u0006\u0010$\u001a\u00020\u0006J\u0010\u0010%\u001a\u0004\u0018\u00010\u00032\u0006\u0010\"\u001a\u00020\u0006J\b\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\u0006H\u0016R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u000e\u001a\u00020\u000fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\f\u001a\u00020\rX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\b\u001a\u0004\u0018\u00010\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006+"}, d2 = {"Lcom/revenuecat/purchases/Offerings;", "", "current", "Lcom/revenuecat/purchases/Offering;", "all", "", "", "(Lcom/revenuecat/purchases/Offering;Ljava/util/Map;)V", "placements", "Lcom/revenuecat/purchases/Offerings$Placements;", "targeting", "Lcom/revenuecat/purchases/Offerings$Targeting;", "originalSource", "Lcom/revenuecat/purchases/common/HTTPResponseOriginalSource;", "loadedFromDiskCache", "", "(Lcom/revenuecat/purchases/Offering;Ljava/util/Map;Lcom/revenuecat/purchases/Offerings$Placements;Lcom/revenuecat/purchases/Offerings$Targeting;Lcom/revenuecat/purchases/common/HTTPResponseOriginalSource;Z)V", "getAll", "()Ljava/util/Map;", "getCurrent", "()Lcom/revenuecat/purchases/Offering;", "getLoadedFromDiskCache$purchases_defaultsBc8Release", "()Z", "getOriginalSource$purchases_defaultsBc8Release", "()Lcom/revenuecat/purchases/common/HTTPResponseOriginalSource;", "getPlacements$purchases_defaultsBc8Release", "()Lcom/revenuecat/purchases/Offerings$Placements;", "getTargeting$purchases_defaultsBc8Release", "()Lcom/revenuecat/purchases/Offerings$Targeting;", "copy", "copy$purchases_defaultsBc8Release", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, b.au, "identifier", "getCurrentOfferingForPlacement", "placementId", "getOffering", "hashCode", "", "toString", "Placements", "Targeting", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Offerings {
    private final Map<String, Offering> all;
    private final Offering current;
    private final boolean loadedFromDiskCache;
    private final HTTPResponseOriginalSource originalSource;
    private final Placements placements;
    private final Targeting targeting;

    public Offerings(Offering offering, Map<String, Offering> all, Placements placements, Targeting targeting, HTTPResponseOriginalSource originalSource, boolean z) {
        Intrinsics.checkNotNullParameter(all, "all");
        Intrinsics.checkNotNullParameter(originalSource, "originalSource");
        this.current = offering;
        this.all = all;
        this.placements = placements;
        this.targeting = targeting;
        this.originalSource = originalSource;
        this.loadedFromDiskCache = z;
    }

    public final Offering getCurrent() {
        return this.current;
    }

    public final Map<String, Offering> getAll() {
        return this.all;
    }

    /* JADX INFO: renamed from: getPlacements$purchases_defaultsBc8Release, reason: from getter */
    public final Placements getPlacements() {
        return this.placements;
    }

    /* JADX INFO: renamed from: getTargeting$purchases_defaultsBc8Release, reason: from getter */
    public final Targeting getTargeting() {
        return this.targeting;
    }

    public /* synthetic */ Offerings(Offering offering, Map map, Placements placements, Targeting targeting, HTTPResponseOriginalSource hTTPResponseOriginalSource, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(offering, map, (i & 4) != 0 ? null : placements, (i & 8) != 0 ? null : targeting, (i & 16) != 0 ? HTTPResponseOriginalSource.MAIN : hTTPResponseOriginalSource, (i & 32) != 0 ? false : z);
    }

    /* JADX INFO: renamed from: getOriginalSource$purchases_defaultsBc8Release, reason: from getter */
    public final HTTPResponseOriginalSource getOriginalSource() {
        return this.originalSource;
    }

    /* JADX INFO: renamed from: getLoadedFromDiskCache$purchases_defaultsBc8Release, reason: from getter */
    public final boolean getLoadedFromDiskCache() {
        return this.loadedFromDiskCache;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Offerings(Offering offering, Map<String, Offering> all) {
        this(offering, all, null, null, null, false, 48, null);
        Intrinsics.checkNotNullParameter(all, "all");
    }

    public final Offering getOffering(String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        return this.all.get(identifier);
    }

    public final Offering get(String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        return getOffering(identifier);
    }

    public final Offering getCurrentOfferingForPlacement(String placementId) {
        Intrinsics.checkNotNullParameter(placementId, "placementId");
        Placements placements = this.placements;
        if (placements == null) {
            return null;
        }
        String str = placements.getOfferingIdsByPlacement().get(placementId);
        Offering offering = str != null ? getOffering(str) : null;
        String fallbackOfferingId = placements.getFallbackOfferingId();
        Offering offering2 = fallbackOfferingId != null ? getOffering(fallbackOfferingId) : null;
        boolean zContainsKey = placements.getOfferingIdsByPlacement().containsKey(placementId);
        if (offering == null) {
            offering = zContainsKey ? null : offering2;
        }
        if (offering != null) {
            return OfferingsKt.withPresentedContext(offering, placementId, this.targeting);
        }
        return null;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/revenuecat/purchases/Offerings$Targeting;", "", "revision", "", "ruleId", "", "(ILjava/lang/String;)V", "getRevision", "()I", "getRuleId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "toString", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Targeting {
        private final int revision;
        private final String ruleId;

        public static /* synthetic */ Targeting copy$default(Targeting targeting, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = targeting.revision;
            }
            if ((i2 & 2) != 0) {
                str = targeting.ruleId;
            }
            return targeting.copy(i, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getRevision() {
            return this.revision;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getRuleId() {
            return this.ruleId;
        }

        public final Targeting copy(int revision, String ruleId) {
            Intrinsics.checkNotNullParameter(ruleId, "ruleId");
            return new Targeting(revision, ruleId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Targeting)) {
                return false;
            }
            Targeting targeting = (Targeting) other;
            return this.revision == targeting.revision && Intrinsics.areEqual(this.ruleId, targeting.ruleId);
        }

        public int hashCode() {
            return (Integer.hashCode(this.revision) * 31) + this.ruleId.hashCode();
        }

        public String toString() {
            return "Targeting(revision=" + this.revision + ", ruleId=" + this.ruleId + ')';
        }

        public Targeting(int i, String ruleId) {
            Intrinsics.checkNotNullParameter(ruleId, "ruleId");
            this.revision = i;
            this.ruleId = ruleId;
        }

        public final int getRevision() {
            return this.revision;
        }

        public final String getRuleId() {
            return this.ruleId;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0005HÆ\u0003J-\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/revenuecat/purchases/Offerings$Placements;", "", "fallbackOfferingId", "", "offeringIdsByPlacement", "", "(Ljava/lang/String;Ljava/util/Map;)V", "getFallbackOfferingId", "()Ljava/lang/String;", "getOfferingIdsByPlacement", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Placements {
        private final String fallbackOfferingId;
        private final Map<String, String> offeringIdsByPlacement;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Placements copy$default(Placements placements, String str, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                str = placements.fallbackOfferingId;
            }
            if ((i & 2) != 0) {
                map = placements.offeringIdsByPlacement;
            }
            return placements.copy(str, map);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getFallbackOfferingId() {
            return this.fallbackOfferingId;
        }

        public final Map<String, String> component2() {
            return this.offeringIdsByPlacement;
        }

        public final Placements copy(String fallbackOfferingId, Map<String, String> offeringIdsByPlacement) {
            Intrinsics.checkNotNullParameter(offeringIdsByPlacement, "offeringIdsByPlacement");
            return new Placements(fallbackOfferingId, offeringIdsByPlacement);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Placements)) {
                return false;
            }
            Placements placements = (Placements) other;
            return Intrinsics.areEqual(this.fallbackOfferingId, placements.fallbackOfferingId) && Intrinsics.areEqual(this.offeringIdsByPlacement, placements.offeringIdsByPlacement);
        }

        public int hashCode() {
            String str = this.fallbackOfferingId;
            return ((str == null ? 0 : str.hashCode()) * 31) + this.offeringIdsByPlacement.hashCode();
        }

        public String toString() {
            return "Placements(fallbackOfferingId=" + this.fallbackOfferingId + ", offeringIdsByPlacement=" + this.offeringIdsByPlacement + ')';
        }

        public Placements(String str, Map<String, String> offeringIdsByPlacement) {
            Intrinsics.checkNotNullParameter(offeringIdsByPlacement, "offeringIdsByPlacement");
            this.fallbackOfferingId = str;
            this.offeringIdsByPlacement = offeringIdsByPlacement;
        }

        public final String getFallbackOfferingId() {
            return this.fallbackOfferingId;
        }

        public final Map<String, String> getOfferingIdsByPlacement() {
            return this.offeringIdsByPlacement;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Offerings copy$purchases_defaultsBc8Release$default(Offerings offerings, Offering offering, Map map, Placements placements, Targeting targeting, HTTPResponseOriginalSource hTTPResponseOriginalSource, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            offering = offerings.current;
        }
        if ((i & 2) != 0) {
            map = offerings.all;
        }
        if ((i & 4) != 0) {
            placements = offerings.placements;
        }
        if ((i & 8) != 0) {
            targeting = offerings.targeting;
        }
        if ((i & 16) != 0) {
            hTTPResponseOriginalSource = offerings.originalSource;
        }
        if ((i & 32) != 0) {
            z = offerings.loadedFromDiskCache;
        }
        HTTPResponseOriginalSource hTTPResponseOriginalSource2 = hTTPResponseOriginalSource;
        boolean z2 = z;
        return offerings.copy$purchases_defaultsBc8Release(offering, map, placements, targeting, hTTPResponseOriginalSource2, z2);
    }

    public final Offerings copy$purchases_defaultsBc8Release(Offering current, Map<String, Offering> all, Placements placements, Targeting targeting, HTTPResponseOriginalSource originalSource, boolean loadedFromDiskCache) {
        Intrinsics.checkNotNullParameter(all, "all");
        Intrinsics.checkNotNullParameter(originalSource, "originalSource");
        return new Offerings(current, all, placements, targeting, originalSource, loadedFromDiskCache);
    }

    public String toString() {
        return "<Offerings\n current: " + this.current + "\nall:  " + this.all + ",\nplacements: " + this.placements + ",\ntargeting: " + this.targeting + "\n>";
    }

    public boolean equals(Object other) {
        return (other instanceof Offerings) && Intrinsics.areEqual(new OfferingsComparableData(this), new OfferingsComparableData((Offerings) other));
    }

    public int hashCode() {
        return new OfferingsComparableData(this).hashCode();
    }
}
