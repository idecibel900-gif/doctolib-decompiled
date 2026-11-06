package com.revenuecat.purchases.models;

import com.revenuecat.purchases.ReplacementMode;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\u0002H\u0000\u001a\u0016\u0010\t\u001a\u0004\u0018\u00010\b*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0000\u001a\f\u0010\f\u001a\u00020\r*\u00020\u0002H\u0000\u001a\f\u0010\u000e\u001a\u00020\u000f*\u00020\u0002H\u0000\u001a\f\u0010\u0010\u001a\u00020\u0002*\u00020\rH\u0000\u001a\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u0012H\u0000\"\u001a\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0018\u0010\u0004\u001a\u00020\u0003*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"storeReplacementModeMappings", "", "Lcom/revenuecat/purchases/models/StoreReplacementMode;", "Lcom/revenuecat/purchases/models/StoreReplacementModeMapping;", "mapping", "getMapping", "(Lcom/revenuecat/purchases/models/StoreReplacementMode;)Lcom/revenuecat/purchases/models/StoreReplacementModeMapping;", "legacyPlayBackendName", "", "storeBackendName", ProductResponseJsonKeys.STORE, "Lcom/revenuecat/purchases/Store;", "toGoogleReplacementMode", "Lcom/revenuecat/purchases/models/GoogleReplacementMode;", "toPlayBillingClientMode", "", "toStoreReplacementMode", "toStoreReplacementModeOrNull", "Lcom/revenuecat/purchases/ReplacementMode;", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class StoreReplacementModeConversionsKt {
    private static final Map<StoreReplacementMode, StoreReplacementModeMapping> storeReplacementModeMappings = MapsKt.mapOf(TuplesKt.to(StoreReplacementMode.WITHOUT_PRORATION, new StoreReplacementModeMapping(3, "IMMEDIATE_WITHOUT_PRORATION", "INSTANT_NO_PRORATION", GoogleReplacementMode.WITHOUT_PRORATION)), TuplesKt.to(StoreReplacementMode.WITH_TIME_PRORATION, new StoreReplacementModeMapping(1, "IMMEDIATE_WITH_TIME_PRORATION", "INSTANT_PRORATED_DATE", GoogleReplacementMode.WITH_TIME_PRORATION)), TuplesKt.to(StoreReplacementMode.CHARGE_FULL_PRICE, new StoreReplacementModeMapping(5, "IMMEDIATE_AND_CHARGE_FULL_PRICE", null, GoogleReplacementMode.CHARGE_FULL_PRICE)), TuplesKt.to(StoreReplacementMode.CHARGE_PRORATED_PRICE, new StoreReplacementModeMapping(2, "IMMEDIATE_AND_CHARGE_PRORATED_PRICE", "INSTANT_PRORATED_CHARGE", GoogleReplacementMode.CHARGE_PRORATED_PRICE)), TuplesKt.to(StoreReplacementMode.DEFERRED, new StoreReplacementModeMapping(6, "DEFERRED", "DEFERRED", GoogleReplacementMode.DEFERRED)));

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[Store.values().length];
            try {
                iArr[Store.PLAY_STORE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Store.GALAXY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[GoogleReplacementMode.values().length];
            try {
                iArr2[GoogleReplacementMode.WITHOUT_PRORATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[GoogleReplacementMode.WITH_TIME_PRORATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[GoogleReplacementMode.CHARGE_FULL_PRICE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[GoogleReplacementMode.CHARGE_PRORATED_PRICE.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[GoogleReplacementMode.DEFERRED.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    private static final StoreReplacementModeMapping getMapping(StoreReplacementMode storeReplacementMode) {
        return (StoreReplacementModeMapping) MapsKt.getValue(storeReplacementModeMappings, storeReplacementMode);
    }

    public static final int toPlayBillingClientMode(StoreReplacementMode storeReplacementMode) {
        Intrinsics.checkNotNullParameter(storeReplacementMode, "<this>");
        return getMapping(storeReplacementMode).getPlayBillingClientMode();
    }

    public static final String legacyPlayBackendName(StoreReplacementMode storeReplacementMode) {
        Intrinsics.checkNotNullParameter(storeReplacementMode, "<this>");
        return getMapping(storeReplacementMode).getLegacyPlayBackendName();
    }

    public static final String storeBackendName(StoreReplacementMode storeReplacementMode, Store store) {
        Intrinsics.checkNotNullParameter(storeReplacementMode, "<this>");
        Intrinsics.checkNotNullParameter(store, "store");
        int i = WhenMappings.$EnumSwitchMapping$0[store.ordinal()];
        if (i == 1) {
            return legacyPlayBackendName(storeReplacementMode);
        }
        if (i != 2) {
            return null;
        }
        return getMapping(storeReplacementMode).getGalaxyBackendName();
    }

    public static final GoogleReplacementMode toGoogleReplacementMode(StoreReplacementMode storeReplacementMode) {
        Intrinsics.checkNotNullParameter(storeReplacementMode, "<this>");
        return getMapping(storeReplacementMode).getGoogleReplacementMode();
    }

    public static final StoreReplacementMode toStoreReplacementMode(GoogleReplacementMode googleReplacementMode) {
        Intrinsics.checkNotNullParameter(googleReplacementMode, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$1[googleReplacementMode.ordinal()];
        if (i == 1) {
            return StoreReplacementMode.WITHOUT_PRORATION;
        }
        if (i == 2) {
            return StoreReplacementMode.WITH_TIME_PRORATION;
        }
        if (i == 3) {
            return StoreReplacementMode.CHARGE_FULL_PRICE;
        }
        if (i == 4) {
            return StoreReplacementMode.CHARGE_PRORATED_PRICE;
        }
        if (i == 5) {
            return StoreReplacementMode.DEFERRED;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final StoreReplacementMode toStoreReplacementModeOrNull(ReplacementMode replacementMode) {
        if (replacementMode == null) {
            return null;
        }
        if (replacementMode instanceof StoreReplacementMode) {
            return (StoreReplacementMode) replacementMode;
        }
        if (replacementMode instanceof GoogleReplacementMode) {
            return toStoreReplacementMode((GoogleReplacementMode) replacementMode);
        }
        return null;
    }
}
