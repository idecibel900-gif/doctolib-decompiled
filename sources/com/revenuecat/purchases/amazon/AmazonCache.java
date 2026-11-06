package com.revenuecat.purchases.amazon;

import com.opentok.android.BaseVideoCapturer;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.common.verification.SigningManager;
import com.revenuecat.purchases.utils.JSONObjectExtensionsKt;
import java.util.Arrays;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001f\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\u001a\u0010\u0011\u001a\u00020\f2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0013J\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0013R\u001b\u0010\u0005\u001a\u00020\u00068@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/revenuecat/purchases/amazon/AmazonCache;", "", "deviceCache", "Lcom/revenuecat/purchases/common/caching/DeviceCache;", "(Lcom/revenuecat/purchases/common/caching/DeviceCache;)V", "amazonPostedTokensKey", "", "getAmazonPostedTokensKey$purchases_defaultsBc8Release", "()Ljava/lang/String;", "amazonPostedTokensKey$delegate", "Lkotlin/Lazy;", "addSuccessfullyPostedToken", "", "token", "isAutoRenewing", "", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "cacheSkusByToken", "receiptsToSkus", "", "getReceiptSkus", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AmazonCache {

    /* JADX INFO: renamed from: amazonPostedTokensKey$delegate, reason: from kotlin metadata */
    private final Lazy amazonPostedTokensKey;
    private final DeviceCache deviceCache;

    public AmazonCache(DeviceCache deviceCache) {
        Intrinsics.checkNotNullParameter(deviceCache, "deviceCache");
        this.deviceCache = deviceCache;
        this.amazonPostedTokensKey = LazyKt.lazy(new Function0() { // from class: com.revenuecat.purchases.amazon.AmazonCache$amazonPostedTokensKey$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return this.this$0.deviceCache.newKey$purchases_defaultsBc8Release("amazon.tokens");
            }
        });
    }

    public final String getAmazonPostedTokensKey$purchases_defaultsBc8Release() {
        return (String) this.amazonPostedTokensKey.getValue();
    }

    public final synchronized void cacheSkusByToken(final Map<String, String> receiptsToSkus) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        try {
            Intrinsics.checkNotNullParameter(receiptsToSkus, "receiptsToSkus");
            final LogIntent logIntent = LogIntent.DEBUG;
            Function0 function0 = new Function0() { // from class: com.revenuecat.purchases.amazon.AmazonCache$cacheSkusByToken$$inlined$log$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sb = new StringBuilder();
                    sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                    sb.append(' ');
                    String str3 = String.format(AmazonStrings.CACHING_RECEIPT_TERM_SKUS, Arrays.copyOf(new Object[]{receiptsToSkus}, 1));
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    sb.append(str3);
                    return sb.toString();
                }
            };
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        str = "[Purchases] - " + logLevel.name();
                        str2 = (String) function0.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel2 = LogLevel.WARN;
                    LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) function0.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel3 = LogLevel.INFO;
                    LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) function0.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel4 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                        str = "[Purchases] - " + logLevel4.name();
                        str2 = (String) function0.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel5 = LogLevel.INFO;
                    LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                        currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) function0.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel6 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                        str = "[Purchases] - " + logLevel6.name();
                        str2 = (String) function0.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 9:
                    LogLevel logLevel7 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                        str = "[Purchases] - " + logLevel7.name();
                        str2 = (String) function0.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 10:
                    LogLevel logLevel8 = LogLevel.WARN;
                    LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                        currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) function0.invoke());
                    }
                    break;
                case BaseVideoCapturer.RGBA /* 11 */:
                    LogLevel logLevel9 = LogLevel.WARN;
                    LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                        currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) function0.invoke());
                    }
                    break;
                case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                    break;
                case 13:
                    LogLevel logLevel10 = LogLevel.WARN;
                    LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                        currentLogHandler7.w("[Purchases] - " + logLevel10.name(), (String) function0.invoke());
                    }
                    break;
                case 14:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                    break;
            }
            JSONObject jSONObject = new JSONObject(MapsKt.plus(getReceiptSkus(), receiptsToSkus));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("receiptsToSkus", jSONObject);
            DeviceCache deviceCache = this.deviceCache;
            String amazonPostedTokensKey$purchases_defaultsBc8Release = getAmazonPostedTokensKey$purchases_defaultsBc8Release();
            String string = jSONObject2.toString();
            Intrinsics.checkNotNullExpressionValue(string, "jsonToCache.toString()");
            deviceCache.putString$purchases_defaultsBc8Release(amazonPostedTokensKey$purchases_defaultsBc8Release, string);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized Map<String, String> getReceiptSkus() {
        Map<String, String> mapEmptyMap;
        try {
            JSONObject jSONObjectOrNull$purchases_defaultsBc8Release = this.deviceCache.getJSONObjectOrNull$purchases_defaultsBc8Release(getAmazonPostedTokensKey$purchases_defaultsBc8Release());
            JSONObject jSONObject = jSONObjectOrNull$purchases_defaultsBc8Release != null ? jSONObjectOrNull$purchases_defaultsBc8Release.getJSONObject("receiptsToSkus") : null;
            if (jSONObject == null || (mapEmptyMap = JSONObjectExtensionsKt.toMap$default(jSONObject, false, 1, null)) == null) {
                mapEmptyMap = MapsKt.emptyMap();
            }
        } catch (Throwable th) {
            throw th;
        }
        return mapEmptyMap;
    }

    public static /* synthetic */ void addSuccessfullyPostedToken$default(AmazonCache amazonCache, String str, Boolean bool, int i, Object obj) {
        if ((i & 2) != 0) {
            bool = null;
        }
        amazonCache.addSuccessfullyPostedToken(str, bool);
    }

    public final synchronized void addSuccessfullyPostedToken(String token, Boolean isAutoRenewing) {
        Intrinsics.checkNotNullParameter(token, "token");
        this.deviceCache.addSuccessfullyPostedToken(token, isAutoRenewing);
    }
}
