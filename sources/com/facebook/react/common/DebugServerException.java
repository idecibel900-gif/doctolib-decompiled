package com.facebook.react.common;

import android.net.Uri;
import com.facebook.common.logging.FLog;
import com.revenuecat.purchases.common.Constants;
import java.util.List;
import java.util.ListIterator;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class DebugServerException extends RuntimeException {
    public static final Companion Companion = new Companion(null);
    private static final String GENERIC_ERROR_MESSAGE = "\n\nTry the following to fix the issue:\n\\u2022 Ensure that Metro is running\n\\u2022 Ensure that your device/emulator is connected to your machine and has USB debugging enabled - run 'adb devices' to see a list of connected devices\n\\u2022 Ensure Airplane Mode is disabled\n\\u2022 If you're on a physical device connected to the same machine, run 'adb reverse tcp:<PORT> tcp:<PORT> to forward requests from your device\n\\u2022 If your device is on the same Wi-Fi network, set 'Debug server host & port for device' in 'Dev settings' to your machine's IP address and the port of the local dev server - e.g. 10.0.1.1:<PORT>\n\n";
    private final String originalMessage;

    public /* synthetic */ DebugServerException(String str, String str2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i, i2);
    }

    private DebugServerException(String str, String str2, int i, int i2) {
        super(str + "\n  at " + str2 + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + i + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + i2);
        this.originalMessage = str;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugServerException(String description) {
        super(description);
        Intrinsics.checkNotNullParameter(description, "description");
        this.originalMessage = description;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugServerException(String detailMessage, Throwable th) {
        super(detailMessage, th);
        Intrinsics.checkNotNullParameter(detailMessage, "detailMessage");
        this.originalMessage = detailMessage;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DebugServerException makeGeneric(String url, String reason, Throwable th) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(reason, "reason");
            return makeGeneric(url, reason, "", th);
        }

        public final DebugServerException makeGeneric(String url, String reason, String extra, Throwable th) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(reason, "reason");
            Intrinsics.checkNotNullParameter(extra, "extra");
            return new DebugServerException(reason + StringsKt.replace$default(DebugServerException.GENERIC_ERROR_MESSAGE, "<PORT>", String.valueOf(Uri.parse(url).getPort()), false, 4, (Object) null) + extra, th);
        }

        public final DebugServerException parse(String str, String str2) {
            if (str2 != null && str2.length() != 0) {
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    String string = jSONObject.getString("filename");
                    String string2 = jSONObject.getString("message");
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    Intrinsics.checkNotNull(string);
                    return new DebugServerException(string2, shortenFileName(string), jSONObject.getInt("lineNumber"), jSONObject.getInt("column"), null);
                } catch (JSONException e) {
                    FLog.w("ReactNative", "Could not parse DebugServerException from: " + str2, e);
                }
            }
            return null;
        }

        private final String shortenFileName(String str) {
            List listEmptyList;
            List listSplit = new Regex("/").split(str, 0);
            if (!listSplit.isEmpty()) {
                ListIterator listIterator = listSplit.listIterator(listSplit.size());
                while (listIterator.hasPrevious()) {
                    if (((String) listIterator.previous()).length() != 0) {
                        listEmptyList = CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                    }
                }
                listEmptyList = CollectionsKt.emptyList();
            } else {
                listEmptyList = CollectionsKt.emptyList();
            }
            return (String) ArraysKt.last((String[]) listEmptyList.toArray(new String[0]));
        }
    }
}
