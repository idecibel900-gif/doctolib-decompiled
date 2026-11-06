package app.screeb.sdk.internal;

import com.revenuecat.purchases.common.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: renamed from: app.screeb.sdk.internal.h0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0305h0 {
    public static String a(String url) {
        URI uri;
        String scheme;
        String host;
        String str;
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            uri = new URI(url);
        } catch (Exception unused) {
            uri = null;
        }
        if (uri == null || (scheme = uri.getScheme()) == null || (host = uri.getHost()) == null) {
            return null;
        }
        if (uri.getPort() != -1) {
            str = Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + uri.getPort();
        } else {
            str = "";
        }
        return scheme + "://" + host + str;
    }

    public static String a(String str, String str2, boolean z) throws UnsupportedEncodingException {
        String str3 = "https://t.screeb.app/webview.html?version=6";
        Intrinsics.checkNotNullParameter("https://t.screeb.app/webview.html?version=6", "baseUrl");
        if (str != null) {
            String str4 = StringsKt.contains$default((CharSequence) "https://t.screeb.app/webview.html?version=6", (CharSequence) "?", false, 2, (Object) null) ? "&" : "?";
            String strEncode = URLEncoder.encode(str, Charsets.UTF_8.name());
            Intrinsics.checkNotNullExpressionValue(strEncode, "encode(...)");
            str3 = "https://t.screeb.app/webview.html?version=6" + str4 + "platform=" + strEncode;
        }
        if (str2 != null && str2.length() != 0) {
            String str5 = StringsKt.contains$default((CharSequence) str3, (CharSequence) "?", false, 2, (Object) null) ? "&" : "?";
            String strEncode2 = URLEncoder.encode(str2, Charsets.UTF_8.name());
            Intrinsics.checkNotNullExpressionValue(strEncode2, "encode(...)");
            str3 = str3 + str5 + "tagVersion=" + strEncode2;
        }
        return str3 + (StringsKt.contains$default((CharSequence) str3, (CharSequence) "?", false, 2, (Object) null) ? "&" : "?") + "mirror=" + (z ? "0" : "1");
    }

    public static boolean a(int i) {
        return i == -2 || i == -6 || i == -8 || i == -7;
    }

    public static boolean a(String str, String str2) {
        if (str2 != null && StringsKt.contains$default((CharSequence) str2, (CharSequence) "webview.html", false, 2, (Object) null) && str != null) {
            String lowerCase = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (lowerCase != null) {
                return Intrinsics.areEqual(lowerCase, "localhost") || Intrinsics.areEqual(lowerCase, "screeb.app") || StringsKt.endsWith$default(lowerCase, ".screeb.app", false, 2, (Object) null);
            }
        }
        return false;
    }
}
