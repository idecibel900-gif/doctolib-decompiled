package com.revenuecat.purchases.deeplinks;

import android.net.Uri;
import com.google.firebase.messaging.Constants;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.WebPurchaseRedemption;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/revenuecat/purchases/deeplinks/DeepLinkParser;", "", "()V", "REDEEM_WEB_PURCHASE_HOST", "", "parseWebPurchaseRedemption", "Lcom/revenuecat/purchases/WebPurchaseRedemption;", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Landroid/net/Uri;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DeepLinkParser {
    public static final DeepLinkParser INSTANCE = new DeepLinkParser();
    private static final String REDEEM_WEB_PURCHASE_HOST = "redeem_web_purchase";

    private DeepLinkParser() {
    }

    public final WebPurchaseRedemption parseWebPurchaseRedemption(Uri data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (Intrinsics.areEqual(data.getHost(), REDEEM_WEB_PURCHASE_HOST)) {
            String queryParameter = data.getQueryParameter("redemption_token");
            if (queryParameter != null && !StringsKt.isBlank(queryParameter)) {
                return new WebPurchaseRedemption(queryParameter);
            }
            LogLevel logLevel = LogLevel.DEBUG;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.d("[Purchases] - " + logLevel.name(), "Redemption token is missing web redemption deep link. Ignoring.");
            }
            return null;
        }
        LogLevel logLevel2 = LogLevel.DEBUG;
        LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
            currentLogHandler2.d("[Purchases] - " + logLevel2.name(), "Unrecognized deep link host: " + data.getHost() + ". Ignoring");
        }
        return null;
    }
}
