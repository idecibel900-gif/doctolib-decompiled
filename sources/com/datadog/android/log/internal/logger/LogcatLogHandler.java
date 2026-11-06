package com.datadog.android.log.internal.logger;

import android.util.Log;
import com.amazon.a.a.o.c.a.b;
import com.datadog.android.log.Logger;
import com.revenuecat.purchases.common.Constants;
import java.util.Map;
import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class LogcatLogHandler implements LogHandler {
    private static final String[] IGNORED_CLASS_NAMES;
    private static final String[] IGNORED_PACKAGE_PREFIXES;
    private final boolean isDebug;
    private final String serviceName;
    private final boolean useClassnameAsTag;
    public static final Companion Companion = new Companion(0 == true ? 1 : 0);
    private static final Regex ANONYMOUS_CLASS = new Regex("(\\$\\d+)+$");

    public LogcatLogHandler(String serviceName, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(serviceName, "serviceName");
        this.serviceName = serviceName;
        this.useClassnameAsTag = z;
        this.isDebug = z2;
    }

    public /* synthetic */ LogcatLogHandler(String str, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, (i & 4) != 0 ? false : z2);
    }

    @Override // com.datadog.android.log.internal.logger.LogHandler
    public void handleLog(int i, String message, Throwable th, Map attributes, Set tags, Long l) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(tags, "tags");
        StackTraceElement callerStackElement$dd_sdk_android_logs_release = getCallerStackElement$dd_sdk_android_logs_release();
        String strResolveTag = resolveTag(callerStackElement$dd_sdk_android_logs_release);
        Log.println(i, strResolveTag, message + resolveSuffix(callerStackElement$dd_sdk_android_logs_release));
        if (th != null) {
            Log.println(i, strResolveTag, Log.getStackTraceString(th));
        }
    }

    @Override // com.datadog.android.log.internal.logger.LogHandler
    public void handleLog(int i, String message, String str, String str2, String str3, Map attributes, Set tags, Long l) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(tags, "tags");
        StackTraceElement callerStackElement$dd_sdk_android_logs_release = getCallerStackElement$dd_sdk_android_logs_release();
        String strResolveTag = resolveTag(callerStackElement$dd_sdk_android_logs_release);
        Log.println(i, strResolveTag, message + resolveSuffix(callerStackElement$dd_sdk_android_logs_release));
        if (str3 != null) {
            Log.println(i, strResolveTag, str3);
        }
    }

    private final String resolveTag(StackTraceElement stackTraceElement) {
        String strSubstringAfterLast$default;
        if (stackTraceElement == null) {
            strSubstringAfterLast$default = this.serviceName;
        } else {
            String className = stackTraceElement.getClassName();
            Intrinsics.checkNotNullExpressionValue(className, "stackTraceElement.className");
            strSubstringAfterLast$default = StringsKt.substringAfterLast$default(ANONYMOUS_CLASS.replace(className, ""), b.a, (String) null, 2, (Object) null);
        }
        strSubstringAfterLast$default.length();
        return strSubstringAfterLast$default;
    }

    private final String resolveSuffix(StackTraceElement stackTraceElement) {
        if (stackTraceElement == null) {
            return "";
        }
        return "\t| at ." + stackTraceElement.getMethodName() + "(" + stackTraceElement.getFileName() + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + stackTraceElement.getLineNumber() + ")";
    }

    public final StackTraceElement getCallerStackElement$dd_sdk_android_logs_release() {
        if (!this.isDebug || !this.useClassnameAsTag) {
            return null;
        }
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        Intrinsics.checkNotNullExpressionValue(stackTrace, "stackTrace");
        return findValidCallStackElement$dd_sdk_android_logs_release(stackTrace);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        String str = null;
        String canonicalName = Logger.class.getCanonicalName();
        String canonicalName2 = LogHandler.class.getCanonicalName();
        String canonicalName3 = LogHandler.class.getCanonicalName();
        if (canonicalName3 != null) {
            str = canonicalName3 + "$DefaultImpls";
        }
        IGNORED_CLASS_NAMES = new String[]{canonicalName, canonicalName2, str, LogcatLogHandler.class.getCanonicalName(), ConditionalLogHandler.class.getCanonicalName(), CombinedLogHandler.class.getCanonicalName(), DatadogLogHandler.class.getCanonicalName()};
        IGNORED_PACKAGE_PREFIXES = new String[]{"com.datadog.android.timber", "timber.log"};
    }

    public final StackTraceElement findValidCallStackElement$dd_sdk_android_logs_release(StackTraceElement[] stackTrace) {
        Intrinsics.checkNotNullParameter(stackTrace, "stackTrace");
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (!ArraysKt.contains(IGNORED_CLASS_NAMES, stackTraceElement.getClassName())) {
                for (String str : IGNORED_PACKAGE_PREFIXES) {
                    String className = stackTraceElement.getClassName();
                    Intrinsics.checkNotNullExpressionValue(className, "element.className");
                    if (!StringsKt.startsWith$default(className, str, false, 2, (Object) null)) {
                    }
                }
                return stackTraceElement;
            }
        }
        return null;
    }
}
