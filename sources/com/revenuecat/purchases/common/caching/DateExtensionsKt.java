package com.revenuecat.purchases.common.caching;

import com.opentok.android.BaseVideoCapturer;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.verification.SigningManager;
import com.revenuecat.purchases.strings.ReceiptStrings;
import java.util.Arrays;
import java.util.Date;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a \u0010\u0004\u001a\u00020\u0005*\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tH\u0000\u001a*\u0010\u0004\u001a\u00020\u0005*\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\tH\u0000ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\r"}, d2 = {"CACHE_REFRESH_PERIOD_IN_BACKGROUND", "Lkotlin/time/Duration;", "J", "CACHE_REFRESH_PERIOD_IN_FOREGROUND", "isCacheStale", "", "Ljava/util/Date;", "appInBackground", "dateProvider", "Lcom/revenuecat/purchases/common/DateProvider;", "cacheDuration", "isCacheStale-8Mi8wO0", "(Ljava/util/Date;JLcom/revenuecat/purchases/common/DateProvider;)Z", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DateExtensionsKt {
    private static final long CACHE_REFRESH_PERIOD_IN_BACKGROUND;
    private static final long CACHE_REFRESH_PERIOD_IN_FOREGROUND;

    static {
        Duration.Companion companion = Duration.Companion;
        CACHE_REFRESH_PERIOD_IN_FOREGROUND = DurationKt.toDuration(5, DurationUnit.MINUTES);
        CACHE_REFRESH_PERIOD_IN_BACKGROUND = DurationKt.toDuration(25, DurationUnit.HOURS);
    }

    public static /* synthetic */ boolean isCacheStale$default(Date date, boolean z, DateProvider dateProvider, int i, Object obj) {
        if ((i & 2) != 0) {
            dateProvider = new DefaultDateProvider();
        }
        return isCacheStale(date, z, dateProvider);
    }

    public static final boolean isCacheStale(Date date, final boolean z, DateProvider dateProvider) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        if (date == null) {
            return true;
        }
        final LogIntent logIntent = LogIntent.DEBUG;
        Function0 function0 = new Function0() { // from class: com.revenuecat.purchases.common.caching.DateExtensionsKt$isCacheStale$lambda$1$$inlined$log$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str3 = String.format(ReceiptStrings.CHECKING_IF_CACHE_STALE, Arrays.copyOf(new Object[]{Boolean.valueOf(z)}, 1));
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
        return m3854isCacheStale8Mi8wO0(date, z ? CACHE_REFRESH_PERIOD_IN_BACKGROUND : CACHE_REFRESH_PERIOD_IN_FOREGROUND, dateProvider);
    }

    /* JADX INFO: renamed from: isCacheStale-8Mi8wO0$default, reason: not valid java name */
    public static /* synthetic */ boolean m3855isCacheStale8Mi8wO0$default(Date date, long j, DateProvider dateProvider, int i, Object obj) {
        if ((i & 2) != 0) {
            dateProvider = new DefaultDateProvider();
        }
        return m3854isCacheStale8Mi8wO0(date, j, dateProvider);
    }

    /* JADX INFO: renamed from: isCacheStale-8Mi8wO0, reason: not valid java name */
    public static final boolean m3854isCacheStale8Mi8wO0(Date date, long j, DateProvider dateProvider) {
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        if (date == null) {
            return true;
        }
        Duration.Companion companion = Duration.Companion;
        return Duration.m5400compareToLRDsOJo(DurationKt.toDuration(dateProvider.getNow().getTime() - date.getTime(), DurationUnit.MILLISECONDS), j) >= 0;
    }
}
