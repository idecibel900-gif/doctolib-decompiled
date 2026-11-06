package com.revenuecat.purchases;

import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.strings.ConfigureStrings;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0002\u0010\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0016\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u0012"}, d2 = {"Lcom/revenuecat/purchases/APIKeyValidator;", "", "()V", "getApiKeyPlatform", "Lcom/revenuecat/purchases/APIKeyValidator$APIKeyPlatform;", "apiKey", "", "logValidationResult", "", "validationResult", "Lcom/revenuecat/purchases/APIKeyValidator$ValidationResult;", "redactApiKey", "validate", "configuredStore", "Lcom/revenuecat/purchases/Store;", "validateAndLog", "APIKeyPlatform", "ValidationResult", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class APIKeyValidator {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/revenuecat/purchases/APIKeyValidator$APIKeyPlatform;", "", "(Ljava/lang/String;I)V", "GOOGLE", "AMAZON", "GALAXY", "LEGACY", "TEST", "OTHER_PLATFORM", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private enum APIKeyPlatform {
        GOOGLE,
        AMAZON,
        GALAXY,
        LEGACY,
        TEST,
        OTHER_PLATFORM
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/revenuecat/purchases/APIKeyValidator$ValidationResult;", "", "(Ljava/lang/String;I)V", "VALID", "GOOGLE_KEY_AMAZON_STORE", "GOOGLE_KEY_GALAXY_STORE", "AMAZON_KEY_GOOGLE_STORE", "AMAZON_KEY_GALAXY_STORE", "GALAXY_KEY_GOOGLE_STORE", "GALAXY_KEY_AMAZON_STORE", "LEGACY", "SIMULATED_STORE", "OTHER_PLATFORM", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum ValidationResult {
        VALID,
        GOOGLE_KEY_AMAZON_STORE,
        GOOGLE_KEY_GALAXY_STORE,
        AMAZON_KEY_GOOGLE_STORE,
        AMAZON_KEY_GALAXY_STORE,
        GALAXY_KEY_GOOGLE_STORE,
        GALAXY_KEY_AMAZON_STORE,
        LEGACY,
        SIMULATED_STORE,
        OTHER_PLATFORM
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ValidationResult.values().length];
            try {
                iArr[ValidationResult.AMAZON_KEY_GOOGLE_STORE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ValidationResult.GOOGLE_KEY_AMAZON_STORE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ValidationResult.GALAXY_KEY_GOOGLE_STORE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ValidationResult.GOOGLE_KEY_GALAXY_STORE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ValidationResult.GALAXY_KEY_AMAZON_STORE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ValidationResult.AMAZON_KEY_GALAXY_STORE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ValidationResult.LEGACY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[ValidationResult.OTHER_PLATFORM.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[ValidationResult.SIMULATED_STORE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[ValidationResult.VALID.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final ValidationResult validateAndLog(String apiKey, Store configuredStore) {
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        Intrinsics.checkNotNullParameter(configuredStore, "configuredStore");
        ValidationResult validationResultValidate = validate(apiKey, configuredStore);
        logValidationResult(validationResultValidate);
        return validationResultValidate;
    }

    private final ValidationResult validate(String apiKey, Store configuredStore) {
        APIKeyPlatform apiKeyPlatform = getApiKeyPlatform(apiKey);
        if (apiKeyPlatform == APIKeyPlatform.TEST) {
            return ValidationResult.SIMULATED_STORE;
        }
        APIKeyPlatform aPIKeyPlatform = APIKeyPlatform.GOOGLE;
        if (apiKeyPlatform == aPIKeyPlatform && configuredStore == Store.PLAY_STORE) {
            return ValidationResult.VALID;
        }
        APIKeyPlatform aPIKeyPlatform2 = APIKeyPlatform.AMAZON;
        if (apiKeyPlatform == aPIKeyPlatform2 && configuredStore == Store.AMAZON) {
            return ValidationResult.VALID;
        }
        APIKeyPlatform aPIKeyPlatform3 = APIKeyPlatform.GALAXY;
        if (apiKeyPlatform == aPIKeyPlatform3 && configuredStore == Store.GALAXY) {
            return ValidationResult.VALID;
        }
        if (apiKeyPlatform == aPIKeyPlatform && configuredStore == Store.AMAZON) {
            return ValidationResult.GOOGLE_KEY_AMAZON_STORE;
        }
        if (apiKeyPlatform == aPIKeyPlatform2 && configuredStore == Store.PLAY_STORE) {
            return ValidationResult.AMAZON_KEY_GOOGLE_STORE;
        }
        if (apiKeyPlatform == aPIKeyPlatform && configuredStore == Store.GALAXY) {
            return ValidationResult.GOOGLE_KEY_GALAXY_STORE;
        }
        if (apiKeyPlatform == aPIKeyPlatform3 && configuredStore == Store.PLAY_STORE) {
            return ValidationResult.GALAXY_KEY_GOOGLE_STORE;
        }
        if (apiKeyPlatform == aPIKeyPlatform3 && configuredStore == Store.AMAZON) {
            return ValidationResult.GALAXY_KEY_AMAZON_STORE;
        }
        if (apiKeyPlatform == aPIKeyPlatform2 && configuredStore == Store.GALAXY) {
            return ValidationResult.AMAZON_KEY_GALAXY_STORE;
        }
        if (apiKeyPlatform == APIKeyPlatform.LEGACY) {
            return ValidationResult.LEGACY;
        }
        return apiKeyPlatform == APIKeyPlatform.OTHER_PLATFORM ? ValidationResult.OTHER_PLATFORM : ValidationResult.OTHER_PLATFORM;
    }

    private final void logValidationResult(ValidationResult validationResult) {
        switch (WhenMappings.$EnumSwitchMapping$0[validationResult.ordinal()]) {
            case 1:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", ConfigureStrings.AMAZON_API_KEY_GOOGLE_STORE, null);
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", ConfigureStrings.GOOGLE_API_KEY_AMAZON_STORE, null);
                break;
            case 3:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", ConfigureStrings.GALAXY_API_KEY_GOOGLE_STORE, null);
                break;
            case 4:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", ConfigureStrings.GOOGLE_API_KEY_GALAXY_STORE, null);
                break;
            case 5:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", ConfigureStrings.GALAXY_API_KEY_AMAZON_STORE, null);
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", ConfigureStrings.AMAZON_API_KEY_GALAXY_STORE, null);
                break;
            case 7:
                LogLevel logLevel = LogLevel.DEBUG;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.d("[Purchases] - " + logLevel.name(), ConfigureStrings.LEGACY_API_KEY);
                }
                break;
            case 8:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", ConfigureStrings.INVALID_API_KEY, null);
                break;
            case 9:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), ConfigureStrings.SIMULATED_STORE_API_KEY);
                }
                break;
        }
    }

    private final APIKeyPlatform getApiKeyPlatform(String apiKey) {
        if (StringsKt.startsWith$default(apiKey, "goog_", false, 2, (Object) null)) {
            return APIKeyPlatform.GOOGLE;
        }
        if (StringsKt.startsWith$default(apiKey, "amzn_", false, 2, (Object) null)) {
            return APIKeyPlatform.AMAZON;
        }
        if (StringsKt.startsWith$default(apiKey, "galx_", false, 2, (Object) null)) {
            return APIKeyPlatform.GALAXY;
        }
        if (StringsKt.startsWith$default(apiKey, "test_", false, 2, (Object) null)) {
            return APIKeyPlatform.TEST;
        }
        return !StringsKt.contains$default((CharSequence) apiKey, '_', false, 2, (Object) null) ? APIKeyPlatform.LEGACY : APIKeyPlatform.OTHER_PLATFORM;
    }

    public final String redactApiKey(String apiKey) {
        String strTake;
        String strSubstring;
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) apiKey, '_', 0, false, 6, (Object) null);
        if (iIndexOf$default == -1) {
            strTake = "";
            strSubstring = apiKey;
        } else {
            int i = iIndexOf$default + 1;
            strTake = StringsKt.take(apiKey, i);
            strSubstring = apiKey.substring(i);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        }
        if (strSubstring.length() < 6) {
            return apiKey;
        }
        return strTake + StringsKt.take(strSubstring, 2) + "********" + StringsKt.takeLast(strSubstring, 4);
    }
}
