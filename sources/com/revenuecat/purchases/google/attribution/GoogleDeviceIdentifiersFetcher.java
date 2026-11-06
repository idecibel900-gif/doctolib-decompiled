package com.revenuecat.purchases.google.attribution;

import android.app.Application;
import com.amazon.a.a.o.b;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.opentok.android.BaseVideoCapturer;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.subscriberattributes.DeviceIdentifiersFetcher;
import com.revenuecat.purchases.common.subscriberattributes.SubscriberAttributeKey;
import com.revenuecat.purchases.common.verification.SigningManager;
import com.revenuecat.purchases.strings.AttributionStrings;
import com.revenuecat.purchases.utils.MapExtensionsKt;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeoutException;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ7\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u001e\u0010\u000e\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\f\u0012\u0004\u0012\u00020\r0\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/revenuecat/purchases/google/attribution/GoogleDeviceIdentifiersFetcher;", "Lcom/revenuecat/purchases/common/subscriberattributes/DeviceIdentifiersFetcher;", "Lcom/revenuecat/purchases/common/Dispatcher;", "dispatcher", "<init>", "(Lcom/revenuecat/purchases/common/Dispatcher;)V", "Landroid/app/Application;", "applicationContext", "", "getAdvertisingID", "(Landroid/app/Application;)Ljava/lang/String;", "Lkotlin/Function1;", "", "", "completion", "getDeviceIdentifiers", "(Landroid/app/Application;Lkotlin/jvm/functions/Function1;)V", "Lcom/revenuecat/purchases/common/Dispatcher;", "noPermissionAdvertisingIdValue", "Ljava/lang/String;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GoogleDeviceIdentifiersFetcher implements DeviceIdentifiersFetcher {
    private final Dispatcher dispatcher;
    private final String noPermissionAdvertisingIdValue;

    public GoogleDeviceIdentifiersFetcher(Dispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.dispatcher = dispatcher;
        this.noPermissionAdvertisingIdValue = "00000000-0000-0000-0000-000000000000";
    }

    @Override // com.revenuecat.purchases.common.subscriberattributes.DeviceIdentifiersFetcher
    public void getDeviceIdentifiers(final Application applicationContext, final Function1 completion) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(completion, "completion");
        Dispatcher.enqueue$default(this.dispatcher, new Runnable() { // from class: com.revenuecat.purchases.google.attribution.GoogleDeviceIdentifiersFetcher$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() throws GooglePlayServicesRepairableException {
                GoogleDeviceIdentifiersFetcher.getDeviceIdentifiers$lambda$0(this.f$0, applicationContext, completion);
            }
        }, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getDeviceIdentifiers$lambda$0(GoogleDeviceIdentifiersFetcher googleDeviceIdentifiersFetcher, Application application, Function1 function1) throws GooglePlayServicesRepairableException {
        function1.invoke(MapExtensionsKt.filterNotNullValues(MapsKt.mapOf(TuplesKt.to(SubscriberAttributeKey.DeviceIdentifiers.GPSAdID.INSTANCE.getBackendKey(), googleDeviceIdentifiersFetcher.getAdvertisingID(application)), TuplesKt.to(SubscriberAttributeKey.DeviceIdentifiers.IP.INSTANCE.getBackendKey(), b.af), TuplesKt.to(SubscriberAttributeKey.DeviceIdentifiers.DeviceVersion.INSTANCE.getBackendKey(), b.af))));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final String getAdvertisingID(Application applicationContext) throws GooglePlayServicesRepairableException {
        LogHandler currentLogHandler;
        String str;
        String str2;
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(applicationContext);
            if (!advertisingIdInfo.isLimitAdTrackingEnabled()) {
                if (!Intrinsics.areEqual(advertisingIdInfo.getId(), this.noPermissionAdvertisingIdValue)) {
                    return advertisingIdInfo.getId();
                }
                final LogIntent logIntent = LogIntent.WARNING;
                Function0 function0 = new Function0() { // from class: com.revenuecat.purchases.google.attribution.GoogleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + AttributionStrings.GOOGLE_PLAY_ADVERTISING_ID_NOT_AVAILABLE;
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
                    default:
                        break;
                }
            }
        } catch (GooglePlayServicesNotAvailableException e) {
            final LogIntent logIntent2 = LogIntent.GOOGLE_ERROR;
            Function0 function1 = new Function0() { // from class: com.revenuecat.purchases.google.attribution.GoogleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sb = new StringBuilder();
                    sb.append(CollectionsKt.joinToString$default(logIntent2.getEmojiList(), "", null, null, 0, null, null, 62, null));
                    sb.append(' ');
                    String str3 = String.format(AttributionStrings.GOOGLE_PLAY_SERVICES_NOT_INSTALLED_FETCHING_ADVERTISING_IDENTIFIER, Arrays.copyOf(new Object[]{e.getLocalizedMessage()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    sb.append(str3);
                    return sb.toString();
                }
            };
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent2.ordinal()]) {
                case 1:
                    LogLevel logLevel11 = LogLevel.DEBUG;
                    LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                        currentLogHandler8.d("[Purchases] - " + logLevel11.name(), (String) function1.invoke());
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function1.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel12 = LogLevel.WARN;
                    LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                        currentLogHandler9.w("[Purchases] - " + logLevel12.name(), (String) function1.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel13 = LogLevel.INFO;
                    LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                        currentLogHandler10.i("[Purchases] - " + logLevel13.name(), (String) function1.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel14 = LogLevel.DEBUG;
                    LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                        currentLogHandler11.d("[Purchases] - " + logLevel14.name(), (String) function1.invoke());
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function1.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel15 = LogLevel.INFO;
                    LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                        currentLogHandler12.i("[Purchases] - " + logLevel15.name(), (String) function1.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel16 = LogLevel.DEBUG;
                    LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                        currentLogHandler13.d("[Purchases] - " + logLevel16.name(), (String) function1.invoke());
                    }
                    break;
                case 9:
                    LogLevel logLevel17 = LogLevel.DEBUG;
                    LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                        currentLogHandler14.d("[Purchases] - " + logLevel17.name(), (String) function1.invoke());
                    }
                    break;
                case 10:
                    LogLevel logLevel18 = LogLevel.WARN;
                    LogHandler currentLogHandler15 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                        currentLogHandler15.w("[Purchases] - " + logLevel18.name(), (String) function1.invoke());
                    }
                    break;
                case BaseVideoCapturer.RGBA /* 11 */:
                    LogLevel logLevel19 = LogLevel.WARN;
                    LogHandler currentLogHandler16 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel19) <= 0) {
                        currentLogHandler16.w("[Purchases] - " + logLevel19.name(), (String) function1.invoke());
                    }
                    break;
                case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function1.invoke(), null);
                    break;
                case 13:
                    LogLevel logLevel20 = LogLevel.WARN;
                    LogHandler currentLogHandler17 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel20) <= 0) {
                        currentLogHandler17.w("[Purchases] - " + logLevel20.name(), (String) function1.invoke());
                    }
                    break;
                case 14:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function1.invoke(), null);
                    break;
            }
        } catch (IOException e2) {
            final LogIntent logIntent3 = LogIntent.GOOGLE_ERROR;
            Function0 function2 = new Function0() { // from class: com.revenuecat.purchases.google.attribution.GoogleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sb = new StringBuilder();
                    sb.append(CollectionsKt.joinToString$default(logIntent3.getEmojiList(), "", null, null, 0, null, null, 62, null));
                    sb.append(' ');
                    String str3 = String.format(AttributionStrings.IO_EXCEPTION_WHEN_FETCHING_ADVERTISING_IDENTIFIER, Arrays.copyOf(new Object[]{e2.getLocalizedMessage()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    sb.append(str3);
                    return sb.toString();
                }
            };
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent3.ordinal()]) {
                case 1:
                    LogLevel logLevel21 = LogLevel.DEBUG;
                    LogHandler currentLogHandler18 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel21) <= 0) {
                        currentLogHandler18.d("[Purchases] - " + logLevel21.name(), (String) function2.invoke());
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function2.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel22 = LogLevel.WARN;
                    LogHandler currentLogHandler19 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel22) <= 0) {
                        currentLogHandler19.w("[Purchases] - " + logLevel22.name(), (String) function2.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel23 = LogLevel.INFO;
                    LogHandler currentLogHandler20 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel23) <= 0) {
                        currentLogHandler20.i("[Purchases] - " + logLevel23.name(), (String) function2.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel24 = LogLevel.DEBUG;
                    LogHandler currentLogHandler21 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel24) <= 0) {
                        currentLogHandler21.d("[Purchases] - " + logLevel24.name(), (String) function2.invoke());
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function2.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel25 = LogLevel.INFO;
                    LogHandler currentLogHandler22 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel25) <= 0) {
                        currentLogHandler22.i("[Purchases] - " + logLevel25.name(), (String) function2.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel26 = LogLevel.DEBUG;
                    LogHandler currentLogHandler23 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel26) <= 0) {
                        currentLogHandler23.d("[Purchases] - " + logLevel26.name(), (String) function2.invoke());
                    }
                    break;
                case 9:
                    LogLevel logLevel27 = LogLevel.DEBUG;
                    LogHandler currentLogHandler24 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel27) <= 0) {
                        currentLogHandler24.d("[Purchases] - " + logLevel27.name(), (String) function2.invoke());
                    }
                    break;
                case 10:
                    LogLevel logLevel28 = LogLevel.WARN;
                    LogHandler currentLogHandler25 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel28) <= 0) {
                        currentLogHandler25.w("[Purchases] - " + logLevel28.name(), (String) function2.invoke());
                    }
                    break;
                case BaseVideoCapturer.RGBA /* 11 */:
                    LogLevel logLevel29 = LogLevel.WARN;
                    LogHandler currentLogHandler26 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel29) <= 0) {
                        currentLogHandler26.w("[Purchases] - " + logLevel29.name(), (String) function2.invoke());
                    }
                    break;
                case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function2.invoke(), null);
                    break;
                case 13:
                    LogLevel logLevel30 = LogLevel.WARN;
                    LogHandler currentLogHandler27 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel30) <= 0) {
                        currentLogHandler27.w("[Purchases] - " + logLevel30.name(), (String) function2.invoke());
                    }
                    break;
                case 14:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function2.invoke(), null);
                    break;
            }
        } catch (NoSuchMethodError unused) {
            final LogIntent logIntent4 = LogIntent.GOOGLE_ERROR;
            Function0 function3 = new Function0() { // from class: com.revenuecat.purchases.google.attribution.GoogleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$7
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return CollectionsKt.joinToString$default(logIntent4.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + AttributionStrings.NO_SUCH_METHOD_WHEN_FETCHING_ADVERTISING_IDENTIFIER;
                }
            };
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent4.ordinal()]) {
                case 1:
                    LogLevel logLevel31 = LogLevel.DEBUG;
                    LogHandler currentLogHandler28 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel31) <= 0) {
                        currentLogHandler28.d("[Purchases] - " + logLevel31.name(), (String) function3.invoke());
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function3.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel32 = LogLevel.WARN;
                    LogHandler currentLogHandler29 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel32) <= 0) {
                        currentLogHandler29.w("[Purchases] - " + logLevel32.name(), (String) function3.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel33 = LogLevel.INFO;
                    LogHandler currentLogHandler30 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel33) <= 0) {
                        currentLogHandler30.i("[Purchases] - " + logLevel33.name(), (String) function3.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel34 = LogLevel.DEBUG;
                    LogHandler currentLogHandler31 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel34) <= 0) {
                        currentLogHandler31.d("[Purchases] - " + logLevel34.name(), (String) function3.invoke());
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function3.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel35 = LogLevel.INFO;
                    LogHandler currentLogHandler32 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel35) <= 0) {
                        currentLogHandler32.i("[Purchases] - " + logLevel35.name(), (String) function3.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel36 = LogLevel.DEBUG;
                    LogHandler currentLogHandler33 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel36) <= 0) {
                        currentLogHandler33.d("[Purchases] - " + logLevel36.name(), (String) function3.invoke());
                    }
                    break;
                case 9:
                    LogLevel logLevel37 = LogLevel.DEBUG;
                    LogHandler currentLogHandler34 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel37) <= 0) {
                        currentLogHandler34.d("[Purchases] - " + logLevel37.name(), (String) function3.invoke());
                    }
                    break;
                case 10:
                    LogLevel logLevel38 = LogLevel.WARN;
                    LogHandler currentLogHandler35 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel38) <= 0) {
                        currentLogHandler35.w("[Purchases] - " + logLevel38.name(), (String) function3.invoke());
                    }
                    break;
                case BaseVideoCapturer.RGBA /* 11 */:
                    LogLevel logLevel39 = LogLevel.WARN;
                    LogHandler currentLogHandler36 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel39) <= 0) {
                        currentLogHandler36.w("[Purchases] - " + logLevel39.name(), (String) function3.invoke());
                    }
                    break;
                case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function3.invoke(), null);
                    break;
                case 13:
                    LogLevel logLevel40 = LogLevel.WARN;
                    LogHandler currentLogHandler37 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel40) <= 0) {
                        currentLogHandler37.w("[Purchases] - " + logLevel40.name(), (String) function3.invoke());
                    }
                    break;
                case 14:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function3.invoke(), null);
                    break;
            }
        } catch (NullPointerException e3) {
            final LogIntent logIntent5 = LogIntent.GOOGLE_ERROR;
            Function0 function4 = new Function0() { // from class: com.revenuecat.purchases.google.attribution.GoogleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sb = new StringBuilder();
                    sb.append(CollectionsKt.joinToString$default(logIntent5.getEmojiList(), "", null, null, 0, null, null, 62, null));
                    sb.append(' ');
                    String str3 = String.format(AttributionStrings.NULL_EXCEPTION_WHEN_FETCHING_ADVERTISING_IDENTIFIER, Arrays.copyOf(new Object[]{e3.getLocalizedMessage()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    sb.append(str3);
                    return sb.toString();
                }
            };
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent5.ordinal()]) {
                case 1:
                    LogLevel logLevel41 = LogLevel.DEBUG;
                    LogHandler currentLogHandler38 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel41) <= 0) {
                        currentLogHandler38.d("[Purchases] - " + logLevel41.name(), (String) function4.invoke());
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function4.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel42 = LogLevel.WARN;
                    LogHandler currentLogHandler39 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel42) <= 0) {
                        currentLogHandler39.w("[Purchases] - " + logLevel42.name(), (String) function4.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel43 = LogLevel.INFO;
                    LogHandler currentLogHandler40 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel43) <= 0) {
                        currentLogHandler40.i("[Purchases] - " + logLevel43.name(), (String) function4.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel44 = LogLevel.DEBUG;
                    LogHandler currentLogHandler41 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel44) <= 0) {
                        currentLogHandler41.d("[Purchases] - " + logLevel44.name(), (String) function4.invoke());
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function4.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel45 = LogLevel.INFO;
                    LogHandler currentLogHandler42 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel45) <= 0) {
                        currentLogHandler42.i("[Purchases] - " + logLevel45.name(), (String) function4.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel46 = LogLevel.DEBUG;
                    LogHandler currentLogHandler43 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel46) <= 0) {
                        currentLogHandler43.d("[Purchases] - " + logLevel46.name(), (String) function4.invoke());
                    }
                    break;
                case 9:
                    LogLevel logLevel47 = LogLevel.DEBUG;
                    LogHandler currentLogHandler44 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel47) <= 0) {
                        currentLogHandler44.d("[Purchases] - " + logLevel47.name(), (String) function4.invoke());
                    }
                    break;
                case 10:
                    LogLevel logLevel48 = LogLevel.WARN;
                    LogHandler currentLogHandler45 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel48) <= 0) {
                        currentLogHandler45.w("[Purchases] - " + logLevel48.name(), (String) function4.invoke());
                    }
                    break;
                case BaseVideoCapturer.RGBA /* 11 */:
                    LogLevel logLevel49 = LogLevel.WARN;
                    LogHandler currentLogHandler46 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel49) <= 0) {
                        currentLogHandler46.w("[Purchases] - " + logLevel49.name(), (String) function4.invoke());
                    }
                    break;
                case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function4.invoke(), null);
                    break;
                case 13:
                    LogLevel logLevel50 = LogLevel.WARN;
                    LogHandler currentLogHandler47 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel50) <= 0) {
                        currentLogHandler47.w("[Purchases] - " + logLevel50.name(), (String) function4.invoke());
                    }
                    break;
                case 14:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function4.invoke(), null);
                    break;
            }
        } catch (TimeoutException e4) {
            final LogIntent logIntent6 = LogIntent.GOOGLE_ERROR;
            Function0 function5 = new Function0() { // from class: com.revenuecat.purchases.google.attribution.GoogleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sb = new StringBuilder();
                    sb.append(CollectionsKt.joinToString$default(logIntent6.getEmojiList(), "", null, null, 0, null, null, 62, null));
                    sb.append(' ');
                    String str3 = String.format(AttributionStrings.TIMEOUT_EXCEPTION_WHEN_FETCHING_ADVERTISING_IDENTIFIER, Arrays.copyOf(new Object[]{e4.getLocalizedMessage()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    sb.append(str3);
                    return sb.toString();
                }
            };
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent6.ordinal()]) {
                case 1:
                    LogLevel logLevel51 = LogLevel.DEBUG;
                    LogHandler currentLogHandler48 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel51) <= 0) {
                        currentLogHandler48.d("[Purchases] - " + logLevel51.name(), (String) function5.invoke());
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function5.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel52 = LogLevel.WARN;
                    LogHandler currentLogHandler49 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel52) <= 0) {
                        currentLogHandler49.w("[Purchases] - " + logLevel52.name(), (String) function5.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel53 = LogLevel.INFO;
                    LogHandler currentLogHandler50 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel53) <= 0) {
                        currentLogHandler50.i("[Purchases] - " + logLevel53.name(), (String) function5.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel54 = LogLevel.DEBUG;
                    LogHandler currentLogHandler51 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel54) <= 0) {
                        currentLogHandler51.d("[Purchases] - " + logLevel54.name(), (String) function5.invoke());
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function5.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel55 = LogLevel.INFO;
                    LogHandler currentLogHandler52 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel55) <= 0) {
                        currentLogHandler52.i("[Purchases] - " + logLevel55.name(), (String) function5.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel56 = LogLevel.DEBUG;
                    LogHandler currentLogHandler53 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel56) <= 0) {
                        currentLogHandler53.d("[Purchases] - " + logLevel56.name(), (String) function5.invoke());
                    }
                    break;
                case 9:
                    LogLevel logLevel57 = LogLevel.DEBUG;
                    LogHandler currentLogHandler54 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel57) <= 0) {
                        currentLogHandler54.d("[Purchases] - " + logLevel57.name(), (String) function5.invoke());
                    }
                    break;
                case 10:
                    LogLevel logLevel58 = LogLevel.WARN;
                    LogHandler currentLogHandler55 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel58) <= 0) {
                        currentLogHandler55.w("[Purchases] - " + logLevel58.name(), (String) function5.invoke());
                    }
                    break;
                case BaseVideoCapturer.RGBA /* 11 */:
                    LogLevel logLevel59 = LogLevel.WARN;
                    LogHandler currentLogHandler56 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel59) <= 0) {
                        currentLogHandler56.w("[Purchases] - " + logLevel59.name(), (String) function5.invoke());
                    }
                    break;
                case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function5.invoke(), null);
                    break;
                case 13:
                    LogLevel logLevel60 = LogLevel.WARN;
                    LogHandler currentLogHandler57 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel60) <= 0) {
                        currentLogHandler57.w("[Purchases] - " + logLevel60.name(), (String) function5.invoke());
                    }
                    break;
                case 14:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function5.invoke(), null);
                    break;
            }
        }
        return null;
    }
}
