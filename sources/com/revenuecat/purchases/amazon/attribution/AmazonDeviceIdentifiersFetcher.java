package com.revenuecat.purchases.amazon.attribution;

import android.app.Application;
import android.content.ContentResolver;
import android.provider.Settings;
import com.amazon.a.a.o.b;
import com.opentok.android.BaseVideoCapturer;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.subscriberattributes.DeviceIdentifiersFetcher;
import com.revenuecat.purchases.common.subscriberattributes.SubscriberAttributeKey;
import com.revenuecat.purchases.common.verification.SigningManager;
import com.revenuecat.purchases.strings.AttributionStrings;
import com.revenuecat.purchases.utils.MapExtensionsKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u001e\u0010\n\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\t0\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/revenuecat/purchases/amazon/attribution/AmazonDeviceIdentifiersFetcher;", "Lcom/revenuecat/purchases/common/subscriberattributes/DeviceIdentifiersFetcher;", "<init>", "()V", "Landroid/app/Application;", "applicationContext", "Lkotlin/Function1;", "", "", "", "completion", "getDeviceIdentifiers", "(Landroid/app/Application;Lkotlin/jvm/functions/Function1;)V", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AmazonDeviceIdentifiersFetcher implements DeviceIdentifiersFetcher {
    @Override // com.revenuecat.purchases.common.subscriberattributes.DeviceIdentifiersFetcher
    public void getDeviceIdentifiers(Application applicationContext, Function1 completion) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(completion, "completion");
        String string = null;
        try {
            ContentResolver contentResolver = applicationContext.getContentResolver();
            if (Settings.Secure.getInt(contentResolver, "limit_ad_tracking") == 0) {
                string = Settings.Secure.getString(contentResolver, "advertising_id");
            }
        } catch (Settings.SettingNotFoundException e) {
            final LogIntent logIntent = LogIntent.AMAZON_ERROR;
            Function0 function0 = new Function0() { // from class: com.revenuecat.purchases.amazon.attribution.AmazonDeviceIdentifiersFetcher$getDeviceIdentifiers$$inlined$log$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sb = new StringBuilder();
                    sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                    sb.append(' ');
                    String str3 = String.format(AttributionStrings.AMAZON_COULD_NOT_GET_ADID, Arrays.copyOf(new Object[]{e.getLocalizedMessage()}, 1));
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
        }
        completion.invoke(MapExtensionsKt.filterNotNullValues(MapsKt.mapOf(TuplesKt.to(SubscriberAttributeKey.DeviceIdentifiers.AmazonAdID.INSTANCE.getBackendKey(), string), TuplesKt.to(SubscriberAttributeKey.DeviceIdentifiers.IP.INSTANCE.getBackendKey(), b.af), TuplesKt.to(SubscriberAttributeKey.DeviceIdentifiers.DeviceVersion.INSTANCE.getBackendKey(), b.af))));
    }
}
