package com.revenuecat.purchases.common;

import com.opentok.android.BaseVideoCapturer;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.common.verification.SigningManager;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u001a$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u000e\b\u0004\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0080\bø\u0001\u0000\"\u001a\u0010\u0000\u001a\u00020\u0001X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0004\b\u0004\u0010\u0005\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2 = {"currentLogHandler", "Lcom/revenuecat/purchases/LogHandler;", "getCurrentLogHandler", "()Lcom/revenuecat/purchases/LogHandler;", "setCurrentLogHandler", "(Lcom/revenuecat/purchases/LogHandler;)V", "log", "", "intent", "Lcom/revenuecat/purchases/common/LogIntent;", "messageBuilder", "Lkotlin/Function0;", "", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LogWrapperKt {
    private static LogHandler currentLogHandler = new DefaultLogHandler();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 176)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LogIntent.values().length];
            try {
                iArr[LogIntent.DEBUG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LogIntent.GOOGLE_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LogIntent.GOOGLE_WARNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LogIntent.INFO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[LogIntent.PURCHASE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[LogIntent.RC_ERROR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[LogIntent.RC_PURCHASE_SUCCESS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[LogIntent.RC_SUCCESS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[LogIntent.USER.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[LogIntent.WARNING.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[LogIntent.AMAZON_WARNING.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[LogIntent.AMAZON_ERROR.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[LogIntent.GALAXY_WARNING.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[LogIntent.GALAXY_ERROR.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final LogHandler getCurrentLogHandler() {
        return currentLogHandler;
    }

    public static final void setCurrentLogHandler(LogHandler logHandler) {
        Intrinsics.checkNotNullParameter(logHandler, "<set-?>");
        currentLogHandler = logHandler;
    }

    public static final void log(final LogIntent intent, final Function0 messageBuilder) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(messageBuilder, "messageBuilder");
        Function0 function0 = new Function0() { // from class: com.revenuecat.purchases.common.LogWrapperKt$log$fullMessageBuilder$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return CollectionsKt.joinToString$default(intent.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + ((String) messageBuilder.invoke());
            }
        };
        switch (WhenMappings.$EnumSwitchMapping$0[intent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                LogHandler currentLogHandler2 = getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler2.d("[Purchases] - " + logLevel.name(), (String) function0.invoke());
                }
                break;
            case 2:
                getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler3 = getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler3.w("[Purchases] - " + logLevel2.name(), (String) function0.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler4 = getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel3.name(), (String) function0.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                LogHandler currentLogHandler5 = getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    currentLogHandler5.d("[Purchases] - " + logLevel4.name(), (String) function0.invoke());
                }
                break;
            case 6:
                getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler6 = getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler6.i("[Purchases] - " + logLevel5.name(), (String) function0.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                LogHandler currentLogHandler7 = getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    currentLogHandler7.d("[Purchases] - " + logLevel6.name(), (String) function0.invoke());
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                LogHandler currentLogHandler8 = getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    currentLogHandler8.d("[Purchases] - " + logLevel7.name(), (String) function0.invoke());
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler9 = getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler9.w("[Purchases] - " + logLevel8.name(), (String) function0.invoke());
                }
                break;
            case BaseVideoCapturer.RGBA /* 11 */:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler10 = getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler10.w("[Purchases] - " + logLevel9.name(), (String) function0.invoke());
                }
                break;
            case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                break;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler11 = getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler11.w("[Purchases] - " + logLevel10.name(), (String) function0.invoke());
                }
                break;
            case 14:
                getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                break;
        }
    }
}
