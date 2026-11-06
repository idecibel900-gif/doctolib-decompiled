package com.revenuecat.purchases.common.networking;

import android.content.Context;
import android.content.SharedPreferences;
import com.opentok.android.BaseVideoCapturer;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.VerificationResult;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.verification.SigningManager;
import com.revenuecat.purchases.strings.NetworkStrings;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u0000 22\u00020\u0001:\u00012B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\r\u0010\n\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\fJ5\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\u0000¢\u0006\u0002\b\u0014J[\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u0012H\u0000¢\u0006\u0002\b!J\u0017\u0010\"\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0010\u001a\u00020\u000fH\u0000¢\u0006\u0002\b#J\u0012\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u0016H\u0002J\u0015\u0010(\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0000¢\u0006\u0002\b)J\u0018\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020%2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J%\u0010,\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\u000fH\u0000¢\u0006\u0002\b.J \u0010/\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u00162\u0006\u00101\u001a\u00020\u000fH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/revenuecat/purchases/common/networking/ETagManager;", "", "context", "Landroid/content/Context;", "prefs", "Lkotlin/Lazy;", "Landroid/content/SharedPreferences;", "dateProvider", "Lcom/revenuecat/purchases/common/DateProvider;", "(Landroid/content/Context;Lkotlin/Lazy;Lcom/revenuecat/purchases/common/DateProvider;)V", "clearCaches", "", "clearCaches$purchases_defaultsBc8Release", "getETagHeaders", "", "", "urlString", "verificationRequested", "", "refreshETag", "getETagHeaders$purchases_defaultsBc8Release", "getHTTPResultFromCacheOrBackend", "Lcom/revenuecat/purchases/common/networking/HTTPResult;", "responseCode", "", "payload", "eTagHeader", "requestDate", "Ljava/util/Date;", "verificationResult", "Lcom/revenuecat/purchases/VerificationResult;", "isLoadShedderResponse", "isFallbackURL", "getHTTPResultFromCacheOrBackend$purchases_defaultsBc8Release", "getStoredResult", "getStoredResult$purchases_defaultsBc8Release", "getStoredResultSavedInSharedPreferences", "Lcom/revenuecat/purchases/common/networking/HTTPResultWithETag;", "shouldStoreBackendResult", "resultFromBackend", "shouldUseCachedVersion", "shouldUseCachedVersion$purchases_defaultsBc8Release", "shouldUseETag", "storedResult", "storeBackendResultIfNoError", "eTagInResponse", "storeBackendResultIfNoError$purchases_defaultsBc8Release", "storeResult", "result", "eTag", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ETagManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final DateProvider dateProvider;
    private final Lazy prefs;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VerificationResult.values().length];
            try {
                iArr[VerificationResult.VERIFIED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VerificationResult.NOT_REQUESTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[VerificationResult.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[VerificationResult.VERIFIED_ON_DEVICE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final boolean shouldUseCachedVersion$purchases_defaultsBc8Release(int responseCode) {
        return responseCode == 304;
    }

    public ETagManager(Context context, Lazy prefs, DateProvider dateProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(prefs, "prefs");
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        this.prefs = prefs;
        this.dateProvider = dateProvider;
    }

    public /* synthetic */ ETagManager(final Context context, Lazy lazy, DateProvider dateProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? LazyKt.lazy(new Function0() { // from class: com.revenuecat.purchases.common.networking.ETagManager.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final SharedPreferences invoke() {
                return ETagManager.INSTANCE.initializeSharedPreferences(context);
            }
        }) : lazy, (i & 4) != 0 ? new DefaultDateProvider() : dateProvider);
    }

    public static /* synthetic */ Map getETagHeaders$purchases_defaultsBc8Release$default(ETagManager eTagManager, String str, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        return eTagManager.getETagHeaders$purchases_defaultsBc8Release(str, z, z2);
    }

    public final Map<String, String> getETagHeaders$purchases_defaultsBc8Release(String urlString, boolean verificationRequested, boolean refreshETag) {
        ETagData eTagData;
        Date lastRefreshTime;
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        String string = null;
        HTTPResultWithETag storedResultSavedInSharedPreferences = refreshETag ? null : getStoredResultSavedInSharedPreferences(urlString);
        if (storedResultSavedInSharedPreferences == null || (eTagData = storedResultSavedInSharedPreferences.getETagData()) == null || !shouldUseETag(storedResultSavedInSharedPreferences, verificationRequested)) {
            eTagData = null;
        }
        String eTag = eTagData != null ? eTagData.getETag() : null;
        if (eTag == null) {
            eTag = "";
        }
        Pair pair = TuplesKt.to("X-RevenueCat-ETag", eTag);
        if (eTagData != null && (lastRefreshTime = eTagData.getLastRefreshTime()) != null) {
            string = Long.valueOf(lastRefreshTime.getTime()).toString();
        }
        return MapsKt.mapOf(pair, TuplesKt.to(HTTPRequest.ETAG_LAST_REFRESH_NAME, string));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final HTTPResult getHTTPResultFromCacheOrBackend$purchases_defaultsBc8Release(int responseCode, String payload, String eTagHeader, String urlString, boolean refreshETag, Date requestDate, VerificationResult verificationResult, boolean isLoadShedderResponse, boolean isFallbackURL) {
        HTTPResult hTTPResultCopy$default;
        Intrinsics.checkNotNullParameter(payload, "payload");
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        Intrinsics.checkNotNullParameter(verificationResult, "verificationResult");
        final HTTPResult hTTPResult = new HTTPResult(responseCode, payload, HTTPResult.Origin.BACKEND, requestDate, verificationResult, isLoadShedderResponse, isFallbackURL);
        if (eTagHeader != null) {
            if (shouldUseCachedVersion$purchases_defaultsBc8Release(responseCode)) {
                HTTPResult storedResult$purchases_defaultsBc8Release = getStoredResult$purchases_defaultsBc8Release(urlString);
                if (storedResult$purchases_defaultsBc8Release != null) {
                    hTTPResultCopy$default = HTTPResult.copy$default(storedResult$purchases_defaultsBc8Release, 0, null, null, requestDate == null ? storedResult$purchases_defaultsBc8Release.getRequestDate() : requestDate, verificationResult, false, false, 103, null);
                } else {
                    hTTPResultCopy$default = null;
                }
                if (hTTPResultCopy$default != null) {
                    return hTTPResultCopy$default;
                }
                if (!refreshETag) {
                    return null;
                }
                final LogIntent logIntent = LogIntent.WARNING;
                Function0 function0 = new Function0() { // from class: com.revenuecat.purchases.common.networking.ETagManager$getHTTPResultFromCacheOrBackend$lambda$3$$inlined$log$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        StringBuilder sb = new StringBuilder();
                        sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                        sb.append(' ');
                        String str = String.format(NetworkStrings.ETAG_CALL_ALREADY_RETRIED, Arrays.copyOf(new Object[]{hTTPResult}, 1));
                        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                        sb.append(str);
                        return sb.toString();
                    }
                };
                switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                    case 1:
                        LogLevel logLevel = LogLevel.DEBUG;
                        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                            currentLogHandler.d("[Purchases] - " + logLevel.name(), (String) function0.invoke());
                            return hTTPResult;
                        }
                        break;
                    case 2:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                        return hTTPResult;
                    case 3:
                        LogLevel logLevel2 = LogLevel.WARN;
                        LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                            currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) function0.invoke());
                            return hTTPResult;
                        }
                        break;
                    case 4:
                        LogLevel logLevel3 = LogLevel.INFO;
                        LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                            currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) function0.invoke());
                            return hTTPResult;
                        }
                        break;
                    case 5:
                        LogLevel logLevel4 = LogLevel.DEBUG;
                        LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                            currentLogHandler4.d("[Purchases] - " + logLevel4.name(), (String) function0.invoke());
                            return hTTPResult;
                        }
                        break;
                    case 6:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                        return hTTPResult;
                    case 7:
                        LogLevel logLevel5 = LogLevel.INFO;
                        LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                            currentLogHandler5.i("[Purchases] - " + logLevel5.name(), (String) function0.invoke());
                            return hTTPResult;
                        }
                        break;
                    case 8:
                        LogLevel logLevel6 = LogLevel.DEBUG;
                        LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                            currentLogHandler6.d("[Purchases] - " + logLevel6.name(), (String) function0.invoke());
                            return hTTPResult;
                        }
                        break;
                    case 9:
                        LogLevel logLevel7 = LogLevel.DEBUG;
                        LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                            currentLogHandler7.d("[Purchases] - " + logLevel7.name(), (String) function0.invoke());
                            return hTTPResult;
                        }
                        break;
                    case 10:
                        LogLevel logLevel8 = LogLevel.WARN;
                        LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                            currentLogHandler8.w("[Purchases] - " + logLevel8.name(), (String) function0.invoke());
                            return hTTPResult;
                        }
                        break;
                    case BaseVideoCapturer.RGBA /* 11 */:
                        LogLevel logLevel9 = LogLevel.WARN;
                        LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                            currentLogHandler9.w("[Purchases] - " + logLevel9.name(), (String) function0.invoke());
                            return hTTPResult;
                        }
                        break;
                    case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                        return hTTPResult;
                    case 13:
                        LogLevel logLevel10 = LogLevel.WARN;
                        LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                            currentLogHandler10.w("[Purchases] - " + logLevel10.name(), (String) function0.invoke());
                            return hTTPResult;
                        }
                        break;
                    case 14:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                        return hTTPResult;
                }
            } else {
                storeBackendResultIfNoError$purchases_defaultsBc8Release(urlString, hTTPResult, eTagHeader);
            }
        }
        return hTTPResult;
    }

    public final HTTPResult getStoredResult$purchases_defaultsBc8Release(String urlString) {
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        HTTPResultWithETag storedResultSavedInSharedPreferences = getStoredResultSavedInSharedPreferences(urlString);
        if (storedResultSavedInSharedPreferences != null) {
            return storedResultSavedInSharedPreferences.getHttpResult();
        }
        return null;
    }

    public final void storeBackendResultIfNoError$purchases_defaultsBc8Release(String urlString, HTTPResult resultFromBackend, String eTagInResponse) {
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        Intrinsics.checkNotNullParameter(resultFromBackend, "resultFromBackend");
        Intrinsics.checkNotNullParameter(eTagInResponse, "eTagInResponse");
        if (shouldStoreBackendResult(resultFromBackend)) {
            storeResult(urlString, resultFromBackend, eTagInResponse);
        }
    }

    public final synchronized void clearCaches$purchases_defaultsBc8Release() {
        ((SharedPreferences) this.prefs.getValue()).edit().clear().apply();
    }

    private final synchronized void storeResult(String urlString, HTTPResult result, String eTag) {
        ((SharedPreferences) this.prefs.getValue()).edit().putString(urlString, new HTTPResultWithETag(new ETagData(eTag, this.dateProvider.getNow()), HTTPResult.copy$default(result, 0, null, HTTPResult.Origin.CACHE, null, null, false, false, 123, null)).serialize()).apply();
    }

    private final HTTPResultWithETag getStoredResultSavedInSharedPreferences(String urlString) {
        String string = ((SharedPreferences) this.prefs.getValue()).getString(urlString, null);
        if (string != null) {
            return HTTPResultWithETag.INSTANCE.deserialize(string);
        }
        return null;
    }

    private final boolean shouldStoreBackendResult(HTTPResult resultFromBackend) {
        int responseCode = resultFromBackend.getResponseCode();
        return (responseCode == 304 || responseCode >= 500 || resultFromBackend.getVerificationResult() == VerificationResult.FAILED) ? false : true;
    }

    private final boolean shouldUseETag(HTTPResultWithETag storedResult, boolean verificationRequested) {
        int i = WhenMappings.$EnumSwitchMapping$0[storedResult.getHttpResult().getVerificationResult().ordinal()];
        if (i == 1) {
            return true;
        }
        if (i == 2) {
            return !verificationRequested;
        }
        if (i == 3 || i == 4) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/common/networking/ETagManager$Companion;", "", "()V", "initializeSharedPreferences", "Landroid/content/SharedPreferences;", "context", "Landroid/content/Context;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SharedPreferences initializeSharedPreferences(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName() + "_preferences_etags", 0);
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…DE_PRIVATE,\n            )");
            return sharedPreferences;
        }
    }
}
