package com.revenuecat.purchases;

import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import com.revenuecat.purchases.models.GoogleReplacementMode;
import com.revenuecat.purchases.models.StoreReplacementMode;
import com.revenuecat.purchases.models.StoreReplacementModeConversionsKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0000\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"backendName", "", "Lcom/revenuecat/purchases/ReplacementMode;", "getBackendName$annotations", "(Lcom/revenuecat/purchases/ReplacementMode;)V", "getBackendName", "(Lcom/revenuecat/purchases/ReplacementMode;)Ljava/lang/String;", ProductResponseJsonKeys.STORE, "Lcom/revenuecat/purchases/Store;", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ReplacementModeKt {
    @Deprecated
    public static /* synthetic */ void getBackendName$annotations(ReplacementMode replacementMode) {
    }

    public static final String getBackendName(ReplacementMode replacementMode) {
        Intrinsics.checkNotNullParameter(replacementMode, "<this>");
        if (replacementMode instanceof GoogleReplacementMode) {
            return StoreReplacementModeConversionsKt.legacyPlayBackendName(StoreReplacementModeConversionsKt.toStoreReplacementMode((GoogleReplacementMode) replacementMode));
        }
        return replacementMode instanceof StoreReplacementMode ? StoreReplacementModeConversionsKt.legacyPlayBackendName((StoreReplacementMode) replacementMode) : replacementMode.getName();
    }

    public static final String backendName(ReplacementMode replacementMode, Store store) {
        Intrinsics.checkNotNullParameter(replacementMode, "<this>");
        Intrinsics.checkNotNullParameter(store, "store");
        StoreReplacementMode storeReplacementModeOrNull = StoreReplacementModeConversionsKt.toStoreReplacementModeOrNull(replacementMode);
        if (storeReplacementModeOrNull != null) {
            return StoreReplacementModeConversionsKt.storeBackendName(storeReplacementModeOrNull, store);
        }
        return null;
    }
}
