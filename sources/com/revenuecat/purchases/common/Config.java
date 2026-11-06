package com.revenuecat.purchases.common;

import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.LogLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/revenuecat/purchases/common/Config;", "", "()V", "frameworkVersion", "", "logLevel", "Lcom/revenuecat/purchases/LogLevel;", "getLogLevel", "()Lcom/revenuecat/purchases/LogLevel;", "setLogLevel", "(Lcom/revenuecat/purchases/LogLevel;)V", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Config {
    public static final String frameworkVersion = "10.3.1";
    public static final Config INSTANCE = new Config();
    private static LogLevel logLevel = LogUtilsKt.debugLogsEnabled(LogLevel.INSTANCE, false);

    private Config() {
    }

    public final LogLevel getLogLevel() {
        return logLevel;
    }

    public final void setLogLevel(LogLevel logLevel2) {
        Intrinsics.checkNotNullParameter(logLevel2, "<set-?>");
        logLevel = logLevel2;
    }
}
