package io.didomi.ssl;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import io.didomi.ssl.consent.model.ConsentToken;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ,\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004J\"\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004J\u0016\u0010\b\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\tH\u0007J$\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0007¨\u0006\u000f"}, d2 = {"Lio/didomi/sdk/pi;", "", "Lio/didomi/sdk/consent/model/ConsentToken;", "consentToken", "", "appId", "userId", "extra", "a", "", "strings", "Lcom/google/gson/JsonArray;", "b", "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class pi {
    public static final pi a = new pi();

    private pi() {
    }

    public final String a(ConsentToken consentToken, String appId, String userId, String extra) {
        Intrinsics.checkNotNullParameter(consentToken, "consentToken");
        StringBuilder sb = new StringBuilder();
        sb.append("window.didomiOnReady = window.didomiOnReady || [];");
        sb.append("window.didomiOnReady.push(function (Didomi) {");
        sb.append("Didomi.notice.hide();");
        sb.append("Didomi.setUserStatus(");
        sb.append(a.b(consentToken, appId, userId));
        sb.append(");");
        if (extra != null && (!StringsKt.isBlank(extra))) {
            sb.append(extra);
        }
        sb.append("});");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder()\n        …);\")\n        }.toString()");
        return string;
    }

    public final String b(ConsentToken consentToken, String appId, String userId) {
        Intrinsics.checkNotNullParameter(consentToken, "consentToken");
        SimpleDateFormat simpleDateFormatC = t1.a.c();
        JsonArray jsonArrayA = a(u0.h(consentToken));
        JsonArray jsonArrayA2 = a(u0.d(consentToken));
        JsonArray jsonArrayA3 = a(u0.f(consentToken));
        JsonArray jsonArrayA4 = a(u0.b(consentToken));
        JsonArray jsonArrayA5 = a(u0.i(consentToken));
        JsonArray jsonArrayA6 = a(u0.e(consentToken));
        JsonArray jsonArrayA7 = a(u0.g(consentToken));
        JsonArray jsonArrayA8 = a(u0.c(consentToken));
        String str = simpleDateFormatC.format(consentToken.getCreated());
        Intrinsics.checkNotNullExpressionValue(str, "df.format(consentToken.created)");
        String str2 = simpleDateFormatC.format(consentToken.getUpdated());
        Intrinsics.checkNotNullExpressionValue(str2, "df.format(consentToken.updated)");
        try {
            String json = new Gson().toJson(new QueryStringForWebView(jsonArrayA, jsonArrayA2, jsonArrayA3, jsonArrayA4, jsonArrayA5, jsonArrayA6, jsonArrayA7, jsonArrayA8, userId, str, str2, appId));
            Intrinsics.checkNotNullExpressionValue(json, "{\n            Gson().toJson(queryString)\n        }");
            return json;
        } catch (Exception unused) {
            return "";
        }
    }

    public final String a(ConsentToken consentToken, String appId, String userId) {
        Intrinsics.checkNotNullParameter(consentToken, "consentToken");
        String strB = b(consentToken, appId, userId);
        try {
            return "didomiConfig.user.externalConsent.value=" + URLEncoder.encode(strB, "utf-8");
        } catch (UnsupportedEncodingException e) {
            Log.e("Unable to URL-encode consent", e);
            return "didomiConfig.user.externalConsent.value=" + strB;
        }
    }

    public final JsonArray a(Set<String> strings) {
        Intrinsics.checkNotNullParameter(strings, "strings");
        JsonArray jsonArray = new JsonArray();
        for (String str : strings) {
            if (new Regex("^[0-9]{1,5}$").matches(str)) {
                try {
                    jsonArray.add(Integer.valueOf(Integer.parseInt(str)));
                } catch (NumberFormatException e) {
                    Log.e("Invalid vendor id", e);
                    jsonArray.add(str);
                }
            }
            jsonArray.add(str);
        }
        return jsonArray;
    }
}
