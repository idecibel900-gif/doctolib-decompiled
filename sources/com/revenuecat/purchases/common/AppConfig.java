package com.revenuecat.purchases.common;

import android.content.Context;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.opentok.android.BaseVideoCapturer;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.APIKeyValidator;
import com.revenuecat.purchases.DangerousSettings;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.PurchasesAreCompletedBy;
import com.revenuecat.purchases.PurchasesAreCompletedByKt;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import com.revenuecat.purchases.common.verification.SigningManager;
import com.revenuecat.purchases.strings.ConfigureStrings;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\b#\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u0000 M2\u00020\u0001:\u0001MBo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010\u0017J\u0013\u0010H\u001a\u00020\u00072\b\u0010I\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010J\u001a\u00020KH\u0016J\b\u0010L\u001a\u00020\u0016H\u0016R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b \u0010!R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b%\u0010!R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000b0'¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010!\"\u0004\b,\u0010-R\u001c\u0010\u0014\u001a\u00020\u00078FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010!\"\u0004\b/\u0010-R$\u00101\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b1\u0010!\"\u0004\b2\u0010-R\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010!R\u0011\u00103\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0011\u00106\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b7\u00105R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0013\u0010:\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b;\u00105R\u0013\u0010<\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b=\u00105R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0011\u0010\u0013\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b@\u0010!R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bA\u0010!R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0011\u0010D\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\bE\u0010!R\u0011\u0010F\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\bG\u00105¨\u0006N"}, d2 = {"Lcom/revenuecat/purchases/common/AppConfig;", "", "context", "Landroid/content/Context;", "purchasesAreCompletedBy", "Lcom/revenuecat/purchases/PurchasesAreCompletedBy;", "showInAppMessagesAutomatically", "", "platformInfo", "Lcom/revenuecat/purchases/common/PlatformInfo;", "proxyURL", "Ljava/net/URL;", ProductResponseJsonKeys.STORE, "Lcom/revenuecat/purchases/Store;", "isDebugBuild", "apiKeyValidationResult", "Lcom/revenuecat/purchases/APIKeyValidator$ValidationResult;", "dangerousSettings", "Lcom/revenuecat/purchases/DangerousSettings;", "runningTests", "forceSigningErrors", "baseUrlString", "", "(Landroid/content/Context;Lcom/revenuecat/purchases/PurchasesAreCompletedBy;ZLcom/revenuecat/purchases/common/PlatformInfo;Ljava/net/URL;Lcom/revenuecat/purchases/Store;ZLcom/revenuecat/purchases/APIKeyValidator$ValidationResult;Lcom/revenuecat/purchases/DangerousSettings;ZZLjava/lang/String;)V", "_isAppBackgrounded", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getApiKeyValidationResult", "()Lcom/revenuecat/purchases/APIKeyValidator$ValidationResult;", "baseURL", "getBaseURL", "()Ljava/net/URL;", "customEntitlementComputation", "getCustomEntitlementComputation", "()Z", "getDangerousSettings", "()Lcom/revenuecat/purchases/DangerousSettings;", "enableOfflineEntitlements", "getEnableOfflineEntitlements", "fallbackBaseURLs", "", "getFallbackBaseURLs", "()Ljava/util/List;", "finishTransactions", "getFinishTransactions", "setFinishTransactions", "(Z)V", "getForceSigningErrors", "setForceSigningErrors", "value", "isAppBackgrounded", "setAppBackgrounded", "languageTag", "getLanguageTag", "()Ljava/lang/String;", "packageName", "getPackageName", "getPlatformInfo", "()Lcom/revenuecat/purchases/common/PlatformInfo;", "playServicesVersionName", "getPlayServicesVersionName", "playStoreVersionName", "getPlayStoreVersionName", "getPurchasesAreCompletedBy", "()Lcom/revenuecat/purchases/PurchasesAreCompletedBy;", "getRunningTests", "getShowInAppMessagesAutomatically", "getStore", "()Lcom/revenuecat/purchases/Store;", "uiPreviewMode", "getUiPreviewMode", "versionName", "getVersionName", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AppConfig {
    public static final String baseUrlString = "https://api.revenuecat.com/";
    private final AtomicBoolean _isAppBackgrounded;
    private final APIKeyValidator.ValidationResult apiKeyValidationResult;
    private final URL baseURL;
    private final DangerousSettings dangerousSettings;
    private final boolean enableOfflineEntitlements;
    private final List<URL> fallbackBaseURLs;
    private boolean finishTransactions;
    private boolean forceSigningErrors;
    private final boolean isDebugBuild;
    private final String languageTag;
    private final String packageName;
    private final PlatformInfo platformInfo;
    private final String playServicesVersionName;
    private final String playStoreVersionName;
    private final PurchasesAreCompletedBy purchasesAreCompletedBy;
    private final boolean runningTests;
    private final boolean showInAppMessagesAutomatically;
    private final Store store;
    private final String versionName;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final URL diagnosticsURL = new URL("https://api-diagnostics.revenuecat.com/");
    private static final URL paywallEventsURL = new URL("https://api-paywalls.revenuecat.com/");
    private static final URL adEventsURL = new URL("https://a.revenue.cat/");
    private static final URL fallbackURL = new URL("https://api-production.8-lives-cat.io/");

    public AppConfig(Context context, PurchasesAreCompletedBy purchasesAreCompletedBy, boolean z, PlatformInfo platformInfo, URL url, Store store, boolean z2, APIKeyValidator.ValidationResult apiKeyValidationResult, DangerousSettings dangerousSettings, boolean z3, boolean z4, String baseUrlString2) {
        URL url2;
        LogHandler currentLogHandler;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(purchasesAreCompletedBy, "purchasesAreCompletedBy");
        Intrinsics.checkNotNullParameter(platformInfo, "platformInfo");
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(apiKeyValidationResult, "apiKeyValidationResult");
        Intrinsics.checkNotNullParameter(dangerousSettings, "dangerousSettings");
        Intrinsics.checkNotNullParameter(baseUrlString2, "baseUrlString");
        this.purchasesAreCompletedBy = purchasesAreCompletedBy;
        this.showInAppMessagesAutomatically = z;
        this.platformInfo = platformInfo;
        this.store = store;
        this.isDebugBuild = z2;
        this.apiKeyValidationResult = apiKeyValidationResult;
        this.dangerousSettings = dangerousSettings;
        this.runningTests = z3;
        this.forceSigningErrors = z4;
        this._isAppBackgrounded = new AtomicBoolean(true);
        this.enableOfflineEntitlements = true;
        Locale locale = UtilsKt.getLocale(context);
        String languageTag = locale != null ? locale.toLanguageTag() : null;
        this.languageTag = languageTag == null ? "" : languageTag;
        String versionName = UtilsKt.getVersionName(context);
        this.versionName = versionName != null ? versionName : "";
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
        this.packageName = packageName;
        this.finishTransactions = PurchasesAreCompletedByKt.getFinishTransactions(purchasesAreCompletedBy);
        if (url != null) {
            final LogIntent logIntent = LogIntent.INFO;
            Function0 function0 = new Function0() { // from class: com.revenuecat.purchases.common.AppConfig$baseURL$lambda$1$$inlined$log$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + ConfigureStrings.CONFIGURING_PURCHASES_PROXY_URL_SET;
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
            url2 = url;
        } else {
            url2 = new URL(baseUrlString2);
        }
        this.baseURL = url2;
        this.fallbackBaseURLs = url != null ? CollectionsKt.emptyList() : CollectionsKt.listOf(fallbackURL);
        this.playStoreVersionName = UtilsKt.getPlayStoreVersionName(context);
        this.playServicesVersionName = UtilsKt.getPlayServicesVersionName(context);
    }

    public final PurchasesAreCompletedBy getPurchasesAreCompletedBy() {
        return this.purchasesAreCompletedBy;
    }

    public final boolean getShowInAppMessagesAutomatically() {
        return this.showInAppMessagesAutomatically;
    }

    public final PlatformInfo getPlatformInfo() {
        return this.platformInfo;
    }

    public final Store getStore() {
        return this.store;
    }

    /* JADX INFO: renamed from: isDebugBuild, reason: from getter */
    public final boolean getIsDebugBuild() {
        return this.isDebugBuild;
    }

    public final APIKeyValidator.ValidationResult getApiKeyValidationResult() {
        return this.apiKeyValidationResult;
    }

    public /* synthetic */ AppConfig(Context context, PurchasesAreCompletedBy purchasesAreCompletedBy, boolean z, PlatformInfo platformInfo, URL url, Store store, boolean z2, APIKeyValidator.ValidationResult validationResult, DangerousSettings dangerousSettings, boolean z3, boolean z4, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, purchasesAreCompletedBy, z, platformInfo, url, store, z2, validationResult, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? new DangerousSettings(true) : dangerousSettings, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? false : z3, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? false : z4, (i & 2048) != 0 ? baseUrlString : str);
    }

    public final DangerousSettings getDangerousSettings() {
        return this.dangerousSettings;
    }

    public final boolean getRunningTests() {
        return this.runningTests;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/revenuecat/purchases/common/AppConfig$Companion;", "", "()V", "adEventsURL", "Ljava/net/URL;", "getAdEventsURL", "()Ljava/net/URL;", "baseUrlString", "", "diagnosticsURL", "getDiagnosticsURL", "fallbackURL", "getFallbackURL", "paywallEventsURL", "getPaywallEventsURL", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final URL getDiagnosticsURL() {
            return AppConfig.diagnosticsURL;
        }

        public final URL getPaywallEventsURL() {
            return AppConfig.paywallEventsURL;
        }

        public final URL getAdEventsURL() {
            return AppConfig.adEventsURL;
        }

        public final URL getFallbackURL() {
            return AppConfig.fallbackURL;
        }
    }

    public final void setForceSigningErrors(boolean z) {
        this.forceSigningErrors = z;
    }

    public final boolean getForceSigningErrors() {
        return this.runningTests && this.forceSigningErrors;
    }

    public final boolean isAppBackgrounded() {
        return this._isAppBackgrounded.get();
    }

    public final void setAppBackgrounded(boolean z) {
        this._isAppBackgrounded.set(z);
    }

    public final boolean getEnableOfflineEntitlements() {
        return this.enableOfflineEntitlements;
    }

    public final String getLanguageTag() {
        return this.languageTag;
    }

    public final String getVersionName() {
        return this.versionName;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final boolean getFinishTransactions() {
        return this.finishTransactions;
    }

    public final void setFinishTransactions(boolean z) {
        this.finishTransactions = z;
    }

    public final URL getBaseURL() {
        return this.baseURL;
    }

    public final List<URL> getFallbackBaseURLs() {
        return this.fallbackBaseURLs;
    }

    public final boolean getCustomEntitlementComputation() {
        return this.dangerousSettings.getCustomEntitlementComputation();
    }

    public final boolean getUiPreviewMode() {
        return this.dangerousSettings.getUiPreviewMode();
    }

    public final String getPlayStoreVersionName() {
        return this.playStoreVersionName;
    }

    public final String getPlayServicesVersionName() {
        return this.playServicesVersionName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(AppConfig.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.revenuecat.purchases.common.AppConfig");
        AppConfig appConfig = (AppConfig) other;
        return Intrinsics.areEqual(this.platformInfo, appConfig.platformInfo) && this.store == appConfig.store && this.isDebugBuild == appConfig.isDebugBuild && Intrinsics.areEqual(this.dangerousSettings, appConfig.dangerousSettings) && Intrinsics.areEqual(this.languageTag, appConfig.languageTag) && Intrinsics.areEqual(this.versionName, appConfig.versionName) && Intrinsics.areEqual(this.packageName, appConfig.packageName) && this.finishTransactions == appConfig.finishTransactions && getForceSigningErrors() == appConfig.getForceSigningErrors() && Intrinsics.areEqual(this.baseURL, appConfig.baseURL) && this.showInAppMessagesAutomatically == appConfig.showInAppMessagesAutomatically && isAppBackgrounded() == appConfig.isAppBackgrounded() && this.apiKeyValidationResult == appConfig.apiKeyValidationResult;
    }

    public int hashCode() {
        return (((((((((((((((((((((((this.platformInfo.hashCode() * 31) + this.store.hashCode()) * 31) + Boolean.hashCode(this.isDebugBuild)) * 31) + this.dangerousSettings.hashCode()) * 31) + this.languageTag.hashCode()) * 31) + this.versionName.hashCode()) * 31) + this.packageName.hashCode()) * 31) + Boolean.hashCode(this.finishTransactions)) * 31) + Boolean.hashCode(getForceSigningErrors())) * 31) + this.baseURL.hashCode()) * 31) + Boolean.hashCode(this.showInAppMessagesAutomatically)) * 31) + Boolean.hashCode(isAppBackgrounded())) * 31) + this.apiKeyValidationResult.hashCode();
    }

    public String toString() {
        return "AppConfig(platformInfo=" + this.platformInfo + ", store=" + this.store + ", isDebugBuild=" + this.isDebugBuild + ", dangerousSettings=" + this.dangerousSettings + ", languageTag='" + this.languageTag + "', versionName='" + this.versionName + "', packageName='" + this.packageName + "', finishTransactions=" + this.finishTransactions + ", showInAppMessagesAutomatically=" + this.showInAppMessagesAutomatically + ", apiKeyValidationResult=" + this.apiKeyValidationResult + ", baseURL=" + this.baseURL + ')';
    }
}
