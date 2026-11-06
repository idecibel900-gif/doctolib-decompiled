package com.revenuecat.purchases.google;

import com.android.billingclient.api.BillingFlowParams;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.ReplaceProductInfo;
import com.revenuecat.purchases.models.StoreReplacementMode;
import com.revenuecat.purchases.models.StoreReplacementModeConversionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"setUpgradeInfo", "", "Lcom/android/billingclient/api/BillingFlowParams$Builder;", "replaceProductInfo", "Lcom/revenuecat/purchases/common/ReplaceProductInfo;", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BillingFlowParamsExtensionsKt {
    public static final void setUpgradeInfo(BillingFlowParams.Builder builder, ReplaceProductInfo replaceProductInfo) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(replaceProductInfo, "replaceProductInfo");
        BillingFlowParams.SubscriptionUpdateParams.Builder builderNewBuilder = BillingFlowParams.SubscriptionUpdateParams.newBuilder();
        builderNewBuilder.setOldPurchaseToken(replaceProductInfo.getOldPurchase().getPurchaseToken());
        StoreReplacementMode storeReplacementModeOrNull = StoreReplacementModeConversionsKt.toStoreReplacementModeOrNull(replaceProductInfo.getReplacementMode());
        if (storeReplacementModeOrNull != null) {
            builderNewBuilder.setSubscriptionReplacementMode(StoreReplacementModeConversionsKt.toPlayBillingClientMode(storeReplacementModeOrNull));
        } else if (replaceProductInfo.getReplacementMode() != null) {
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Got unidentified replacement mode", null);
        }
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder().apply {\n   …t mode\" }\n        }\n    }");
        builder.setSubscriptionUpdateParams(builderNewBuilder.build());
    }
}
