package com.datadog.android.rum.internal.anr;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.feature.event.ThreadDump;
import com.datadog.android.internal.utils.StringBuilderExtKt;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class AndroidTraceParser {
    public static final Companion Companion = new Companion(null);
    private static final Regex THREAD_NAME_REGEX = new Regex("^\"(.+)\".+$");
    private final InternalLogger internalLogger;

    public AndroidTraceParser(InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.internalLogger = internalLogger;
    }

    public final List parse$dd_sdk_android_rum_release(InputStream traceInputStream) {
        Intrinsics.checkNotNullParameter(traceInputStream, "traceInputStream");
        String strSafeReadText = safeReadText(traceInputStream);
        return StringsKt.isBlank(strSafeReadText) ? CollectionsKt.emptyList() : parse(strSafeReadText);
    }

    private final List parse(String str) {
        List groupValues;
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        String str2 = null;
        String str3 = null;
        for (String str4 : StringsKt.lines(str)) {
            if (StringsKt.isBlank(str4) && z) {
                if (sb.length() > 0 && str2 != null) {
                    String strConvertThreadState = convertThreadState(str3 == null ? "" : str3);
                    String string = sb.toString();
                    Intrinsics.checkNotNullExpressionValue(string, "currentThreadStack.toString()");
                    arrayList.add(new ThreadDump(str2, strConvertThreadState, string, Intrinsics.areEqual(str2, "main")));
                }
                StringsKt.clear(sb);
                z = false;
            } else if (StringsKt.contains$default((CharSequence) str4, (CharSequence) " prio=", false, 2, (Object) null) && StringsKt.contains$default((CharSequence) str4, (CharSequence) " tid=", false, 2, (Object) null)) {
                str3 = (String) CollectionsKt.lastOrNull(StringsKt.split$default((CharSequence) str4, new String[]{" "}, false, 0, 6, (Object) null));
                MatchResult matchResultMatchEntire = THREAD_NAME_REGEX.matchEntire(str4);
                str2 = (matchResultMatchEntire == null || (groupValues = matchResultMatchEntire.getGroupValues()) == null) ? null : (String) CollectionsKt.getOrNull(groupValues, 1);
                z = true;
            } else if (z) {
                String string2 = StringsKt.trimStart(str4).toString();
                if (StringsKt.startsWith$default(string2, "at ", false, 2, (Object) null) || StringsKt.startsWith$default(string2, "native: ", false, 2, (Object) null)) {
                    StringBuilderExtKt.appendIfNotEmpty(sb, '\n').append(str4);
                }
            }
        }
        if (arrayList.isEmpty()) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0() { // from class: com.datadog.android.rum.internal.anr.AndroidTraceParser.parse.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Parsing tracing information for the exit reason wasn't successful, no thread dumps were parsed.";
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        }
        return arrayList;
    }

    private final String convertThreadState(String str) {
        if (Intrinsics.areEqual(str, "TimedWaiting")) {
            str = "Timed_Waiting";
        }
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = str.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    private final String safeReadText(InputStream inputStream) {
        try {
            try {
                String text = TextStreamsKt.readText(new InputStreamReader(inputStream, Charsets.UTF_8));
                CloseableKt.closeFinally(inputStream, null);
                return text;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(inputStream, th);
                    throw th2;
                }
            }
        } catch (IOException e) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0() { // from class: com.datadog.android.rum.internal.anr.AndroidTraceParser.safeReadText.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Failed to read crash trace stream.";
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return "";
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
