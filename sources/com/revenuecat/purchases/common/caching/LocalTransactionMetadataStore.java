package com.revenuecat.purchases.common.caching;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.firebase.messaging.Constants;
import com.revenuecat.purchases.JsonTools;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.UtilsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.json.Json;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fJ\u0014\u0010\u0010\u001a\u00020\f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012J\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0014J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\r\u001a\u00020\u0005J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/revenuecat/purchases/common/caching/LocalTransactionMetadataStore;", "", "context", "Landroid/content/Context;", "apiKey", "", "sharedPreferences", "Landroid/content/SharedPreferences;", "json", "Lkotlinx/serialization/json/Json;", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/SharedPreferences;Lkotlinx/serialization/json/Json;)V", "cacheLocalTransactionMetadata", "", "purchaseToken", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Lcom/revenuecat/purchases/common/caching/LocalTransactionMetadata;", "clearLocalTransactionMetadata", "purchaseTokens", "", "getAllLocalTransactionMetadata", "", "getLocalTransactionMetadata", "getTokenHash", "hasCachedData", "", "tokenHash", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LocalTransactionMetadataStore {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String KEY_PREFIX = "local_transaction_metadata_";
    private final String apiKey;
    private final Json json;
    private final SharedPreferences sharedPreferences;

    public LocalTransactionMetadataStore(Context context, String apiKey, SharedPreferences sharedPreferences, Json json) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        Intrinsics.checkNotNullParameter(json, "json");
        this.apiKey = apiKey;
        this.sharedPreferences = sharedPreferences;
        this.json = json;
    }

    public /* synthetic */ LocalTransactionMetadataStore(Context context, String str, SharedPreferences sharedPreferences, Json json, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, (i & 4) != 0 ? Companion.initializeSharedPreferences(context, str) : sharedPreferences, (i & 8) != 0 ? JsonTools.INSTANCE.getJson() : json);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/revenuecat/purchases/common/caching/LocalTransactionMetadataStore$Companion;", "", "()V", "KEY_PREFIX", "", "initializeSharedPreferences", "Landroid/content/SharedPreferences;", "context", "Landroid/content/Context;", "apiKey", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SharedPreferences initializeSharedPreferences(Context context, String apiKey) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(apiKey, "apiKey");
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.revenuecat.purchases.transaction_metadata." + apiKey, 0);
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…DE_PRIVATE,\n            )");
            return sharedPreferences;
        }
    }

    public final synchronized void cacheLocalTransactionMetadata(String purchaseToken, LocalTransactionMetadata data) {
        Intrinsics.checkNotNullParameter(purchaseToken, "purchaseToken");
        Intrinsics.checkNotNullParameter(data, "data");
        String tokenHash = getTokenHash(purchaseToken);
        if (hasCachedData(tokenHash)) {
            LogLevel logLevel = LogLevel.DEBUG;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.d("[Purchases] - " + logLevel.name(), "Purchase data already cached for token: " + purchaseToken + ". Skipping cache.");
            }
            return;
        }
        try {
            String str = KEY_PREFIX + tokenHash;
            String strEncodeToString = this.json.encodeToString(LocalTransactionMetadata.INSTANCE.serializer(), data);
            SharedPreferences.Editor editor = this.sharedPreferences.edit();
            Intrinsics.checkNotNullExpressionValue(editor, "editor");
            editor.putString(str, strEncodeToString);
            editor.apply();
            LogLevel logLevel2 = LogLevel.DEBUG;
            LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                currentLogHandler2.d("[Purchases] - " + logLevel2.name(), "Local transaction metadata cache updated");
            }
        } catch (SerializationException e) {
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Failed to serialize local transaction metadata", e);
        }
    }

    public final LocalTransactionMetadata getLocalTransactionMetadata(String purchaseToken) {
        Intrinsics.checkNotNullParameter(purchaseToken, "purchaseToken");
        String str = KEY_PREFIX + getTokenHash(purchaseToken);
        String string = this.sharedPreferences.getString(str, null);
        if (string == null) {
            return null;
        }
        try {
            return (LocalTransactionMetadata) this.json.decodeFromString(LocalTransactionMetadata.INSTANCE.serializer(), string);
        } catch (SerializationException e) {
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Failed to deserialize local transaction metadata. Clearing cache.", e);
            SharedPreferences.Editor editor = this.sharedPreferences.edit();
            Intrinsics.checkNotNullExpressionValue(editor, "editor");
            editor.remove(str);
            editor.apply();
            return null;
        }
    }

    public final List<LocalTransactionMetadata> getAllLocalTransactionMetadata() {
        Set<String> setKeySet = this.sharedPreferences.getAll().keySet();
        ArrayList<String> arrayList = new ArrayList();
        for (Object obj : setKeySet) {
            String it = (String) obj;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (StringsKt.startsWith$default(it, KEY_PREFIX, false, 2, (Object) null)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (String str : arrayList) {
            String string = this.sharedPreferences.getString(str, null);
            if (string != null) {
                try {
                    arrayList2.add((LocalTransactionMetadata) this.json.decodeFromString(LocalTransactionMetadata.INSTANCE.serializer(), string));
                } catch (SerializationException e) {
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Failed to deserialize transaction metadata for key: " + str, e);
                    SharedPreferences.Editor editor = this.sharedPreferences.edit();
                    Intrinsics.checkNotNullExpressionValue(editor, "editor");
                    editor.remove(str);
                    editor.apply();
                }
            }
        }
        return arrayList2;
    }

    public final synchronized void clearLocalTransactionMetadata(Set<String> purchaseTokens) {
        try {
            Intrinsics.checkNotNullParameter(purchaseTokens, "purchaseTokens");
            if (purchaseTokens.isEmpty()) {
                return;
            }
            Set<String> set = purchaseTokens;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                arrayList.add(getTokenHash((String) it.next()));
            }
            SharedPreferences.Editor editor = this.sharedPreferences.edit();
            Intrinsics.checkNotNullExpressionValue(editor, "editor");
            Iterator it2 = arrayList.iterator();
            int i = 0;
            while (it2.hasNext()) {
                String str = KEY_PREFIX + ((String) it2.next());
                if (this.sharedPreferences.contains(str)) {
                    editor.remove(str);
                    i++;
                }
            }
            editor.apply();
            if (i > 0) {
                LogLevel logLevel = LogLevel.VERBOSE;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.v("[Purchases] - " + logLevel.name(), "Cleared local transaction metadata for " + i + " token(s)");
                }
            } else {
                LogLevel logLevel2 = LogLevel.DEBUG;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.d("[Purchases] - " + logLevel2.name(), "No transaction metadata found to clear from local cache.");
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private final boolean hasCachedData(String tokenHash) {
        return this.sharedPreferences.contains(KEY_PREFIX + tokenHash);
    }

    private final String getTokenHash(String purchaseToken) {
        return UtilsKt.sha1(purchaseToken);
    }
}
