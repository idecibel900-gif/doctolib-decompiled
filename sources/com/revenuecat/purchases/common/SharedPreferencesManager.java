package com.revenuecat.purchases.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.opentok.android.BaseVideoCapturer;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.backup.RevenueCatBackupAgent;
import com.revenuecat.purchases.common.verification.SigningManager;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0002J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002J\u0006\u0010\u000e\u001a\u00020\u0005J\b\u0010\u000f\u001a\u00020\u0010H\u0002J \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\rH\u0002J\b\u0010\u0016\u001a\u00020\nH\u0002J\b\u0010\u0017\u001a\u00020\nH\u0002R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019²\u0006\n\u0010\u0012\u001a\u00020\u0005X\u008a\u0084\u0002²\u0006\n\u0010\u0012\u001a\u00020\u0005X\u008a\u0084\u0002"}, d2 = {"Lcom/revenuecat/purchases/common/SharedPreferencesManager;", "", "context", "Landroid/content/Context;", "revenueCatSharedPreferences", "Landroid/content/SharedPreferences;", "legacySharedPreferences", "Lkotlin/Lazy;", "(Landroid/content/Context;Landroid/content/SharedPreferences;Lkotlin/Lazy;)V", "ensureMigrated", "", "getRevenueCatKeysToMigrate", "", "", "getSharedPreferences", "hasRevenueCatVersion", "", "migratePreferenceValue", "legacyPrefs", "editor", "Landroid/content/SharedPreferences$Editor;", SubscriberAttributeKt.JSON_NAME_KEY, "performMigration", "updateSharedPreferencesVersion", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SharedPreferencesManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int EXPECTED_VERSION = 1;
    public static final String EXPECTED_VERSION_KEY = "com.revenuecat.purchases.shared_preferences_version";
    public static final String SHARED_PREFERENCES_PREFIX = "com.revenuecat.purchases.";
    private final Lazy legacySharedPreferences;
    private final SharedPreferences revenueCatSharedPreferences;

    public SharedPreferencesManager(Context context, SharedPreferences revenueCatSharedPreferences, Lazy legacySharedPreferences) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(revenueCatSharedPreferences, "revenueCatSharedPreferences");
        Intrinsics.checkNotNullParameter(legacySharedPreferences, "legacySharedPreferences");
        this.revenueCatSharedPreferences = revenueCatSharedPreferences;
        this.legacySharedPreferences = legacySharedPreferences;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ SharedPreferencesManager(final Context context, SharedPreferences sharedPreferences, Lazy lazy, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 2) != 0) {
            sharedPreferences = context.getSharedPreferences(RevenueCatBackupAgent.REVENUECAT_PREFS_FILE_NAME, 0);
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…ntext.MODE_PRIVATE,\n    )");
        }
        this(context, sharedPreferences, (i & 4) != 0 ? LazyKt.lazy(new Function0() { // from class: com.revenuecat.purchases.common.SharedPreferencesManager.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final SharedPreferences invoke() {
                return PreferenceManager.getDefaultSharedPreferences(context);
            }
        }) : lazy);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0002R\u0016\u0010\t\u001a\u00020\u00078\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u0002¨\u0006\u000b"}, d2 = {"Lcom/revenuecat/purchases/common/SharedPreferencesManager$Companion;", "", "()V", "EXPECTED_VERSION", "", "getEXPECTED_VERSION$annotations", "EXPECTED_VERSION_KEY", "", "getEXPECTED_VERSION_KEY$annotations", "SHARED_PREFERENCES_PREFIX", "getSHARED_PREFERENCES_PREFIX$annotations", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getEXPECTED_VERSION$annotations() {
        }

        public static /* synthetic */ void getEXPECTED_VERSION_KEY$annotations() {
        }

        public static /* synthetic */ void getSHARED_PREFERENCES_PREFIX$annotations() {
        }

        private Companion() {
        }
    }

    public final SharedPreferences getSharedPreferences() {
        synchronized (this) {
            ensureMigrated();
            Unit unit = Unit.INSTANCE;
        }
        return this.revenueCatSharedPreferences;
    }

    private final void ensureMigrated() {
        if (hasRevenueCatVersion()) {
            return;
        }
        Set<String> setKeySet = ((SharedPreferences) this.legacySharedPreferences.getValue()).getAll().keySet();
        if (!(setKeySet instanceof Collection) || !setKeySet.isEmpty()) {
            for (String key : setKeySet) {
                Intrinsics.checkNotNullExpressionValue(key, "key");
                if (StringsKt.startsWith$default(key, SHARED_PREFERENCES_PREFIX, false, 2, (Object) null)) {
                    performMigration();
                    break;
                }
            }
        }
        updateSharedPreferencesVersion();
    }

    private final void performMigration() {
        LogHandler currentLogHandler;
        String str;
        String str2;
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0 function0 = new Function0() { // from class: com.revenuecat.purchases.common.SharedPreferencesManager$performMigration$$inlined$log$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + " Starting shared preferences migration from legacy to RevenueCat-specific preferences";
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
        List<String> revenueCatKeysToMigrate = getRevenueCatKeysToMigrate();
        Lazy lazy = this.legacySharedPreferences;
        SharedPreferences.Editor editor = this.revenueCatSharedPreferences.edit();
        Intrinsics.checkNotNullExpressionValue(editor, "editor");
        Iterator<String> it = revenueCatKeysToMigrate.iterator();
        while (it.hasNext()) {
            migratePreferenceValue(performMigration$lambda$3(lazy), editor, it.next());
        }
        editor.apply();
        final LogIntent logIntent2 = LogIntent.DEBUG;
        Function0 function1 = new Function0() { // from class: com.revenuecat.purchases.common.SharedPreferencesManager$performMigration$$inlined$log$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return CollectionsKt.joinToString$default(logIntent2.getEmojiList(), "", null, null, 0, null, null, 62, null) + " Finished shared preferences migration from legacy to RevenueCat-specific preferences";
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
    }

    private static final SharedPreferences performMigration$lambda$3(Lazy lazy) {
        return (SharedPreferences) lazy.getValue();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final List<String> getRevenueCatKeysToMigrate() {
        Set<String> setKeySet = getRevenueCatKeysToMigrate$lambda$6(this.legacySharedPreferences).getAll().keySet();
        final ArrayList arrayList = new ArrayList();
        for (Object obj : setKeySet) {
            String key = (String) obj;
            Intrinsics.checkNotNullExpressionValue(key, "key");
            if (StringsKt.startsWith$default(key, SHARED_PREFERENCES_PREFIX, false, 2, (Object) null)) {
                arrayList.add(obj);
            }
        }
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0 function0 = new Function0() { // from class: com.revenuecat.purchases.common.SharedPreferencesManager$getRevenueCatKeysToMigrate$$inlined$log$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                sb.append("Found " + arrayList.size() + " RevenueCat keys to migrate: " + arrayList);
                return sb.toString();
            }
        };
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.d("[Purchases] - " + logLevel.name(), (String) function0.invoke());
                }
                return arrayList;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                return arrayList;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) function0.invoke());
                    return arrayList;
                }
                return arrayList;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) function0.invoke());
                    return arrayList;
                }
                return arrayList;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    currentLogHandler4.d("[Purchases] - " + logLevel4.name(), (String) function0.invoke());
                    return arrayList;
                }
                return arrayList;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                return arrayList;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler5.i("[Purchases] - " + logLevel5.name(), (String) function0.invoke());
                    return arrayList;
                }
                return arrayList;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    currentLogHandler6.d("[Purchases] - " + logLevel6.name(), (String) function0.invoke());
                    return arrayList;
                }
                return arrayList;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    currentLogHandler7.d("[Purchases] - " + logLevel7.name(), (String) function0.invoke());
                    return arrayList;
                }
                return arrayList;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler8.w("[Purchases] - " + logLevel8.name(), (String) function0.invoke());
                    return arrayList;
                }
                return arrayList;
            case BaseVideoCapturer.RGBA /* 11 */:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler9.w("[Purchases] - " + logLevel9.name(), (String) function0.invoke());
                    return arrayList;
                }
                return arrayList;
            case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                return arrayList;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler10.w("[Purchases] - " + logLevel10.name(), (String) function0.invoke());
                    return arrayList;
                }
                return arrayList;
            case 14:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                return arrayList;
            default:
                return arrayList;
        }
    }

    private static final SharedPreferences getRevenueCatKeysToMigrate$lambda$6(Lazy lazy) {
        return (SharedPreferences) lazy.getValue();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final boolean migratePreferenceValue(SharedPreferences legacyPrefs, SharedPreferences.Editor editor, final String key) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        try {
            final Object obj = legacyPrefs.getAll().get(key);
            if (obj instanceof String) {
                editor.putString(key, (String) obj);
                return true;
            }
            if (obj instanceof Boolean) {
                editor.putBoolean(key, ((Boolean) obj).booleanValue());
                return true;
            }
            if (obj instanceof Integer) {
                editor.putInt(key, ((Number) obj).intValue());
                return true;
            }
            if (obj instanceof Long) {
                editor.putLong(key, ((Number) obj).longValue());
                return true;
            }
            if (obj instanceof Float) {
                editor.putFloat(key, ((Number) obj).floatValue());
                return true;
            }
            if (obj instanceof Set) {
                editor.putStringSet(key, (Set) obj);
                return true;
            }
            final LogIntent logIntent = LogIntent.WARNING;
            Function0 function0 = new Function0() { // from class: com.revenuecat.purchases.common.SharedPreferencesManager$migratePreferenceValue$$inlined$log$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sb = new StringBuilder();
                    sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                    sb.append(' ');
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Unknown preference type for key ");
                    sb2.append(key);
                    sb2.append(": ");
                    Object obj2 = obj;
                    sb2.append(obj2 != null ? obj2.getClass().getSimpleName() : null);
                    sb.append(sb2.toString());
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
                    return false;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                    return false;
                case 3:
                    LogLevel logLevel2 = LogLevel.WARN;
                    LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) function0.invoke());
                    }
                    return false;
                case 4:
                    LogLevel logLevel3 = LogLevel.INFO;
                    LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) function0.invoke());
                    }
                    return false;
                case 5:
                    LogLevel logLevel4 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                        str = "[Purchases] - " + logLevel4.name();
                        str2 = (String) function0.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    return false;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                    return false;
                case 7:
                    LogLevel logLevel5 = LogLevel.INFO;
                    LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                        currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) function0.invoke());
                    }
                    return false;
                case 8:
                    LogLevel logLevel6 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                        str = "[Purchases] - " + logLevel6.name();
                        str2 = (String) function0.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    return false;
                case 9:
                    LogLevel logLevel7 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                        str = "[Purchases] - " + logLevel7.name();
                        str2 = (String) function0.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    return false;
                case 10:
                    LogLevel logLevel8 = LogLevel.WARN;
                    LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                        currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) function0.invoke());
                    }
                    return false;
                case BaseVideoCapturer.RGBA /* 11 */:
                    LogLevel logLevel9 = LogLevel.WARN;
                    LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                        currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) function0.invoke());
                    }
                    return false;
                case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                    return false;
                case 13:
                    LogLevel logLevel10 = LogLevel.WARN;
                    LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                        currentLogHandler7.w("[Purchases] - " + logLevel10.name(), (String) function0.invoke());
                    }
                    return false;
                case 14:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                    return false;
                default:
                    return false;
            }
        } catch (ClassCastException e) {
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Failed to migrate preference with key due to type casting: " + key, e);
            return false;
        }
    }

    private final boolean hasRevenueCatVersion() {
        return this.revenueCatSharedPreferences.contains(EXPECTED_VERSION_KEY);
    }

    private final void updateSharedPreferencesVersion() {
        SharedPreferences.Editor editor = this.revenueCatSharedPreferences.edit();
        Intrinsics.checkNotNullExpressionValue(editor, "editor");
        editor.putInt(EXPECTED_VERSION_KEY, 1);
        editor.apply();
    }
}
