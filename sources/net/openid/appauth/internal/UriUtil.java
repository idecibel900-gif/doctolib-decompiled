package net.openid.appauth.internal;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.util.Pair;
import com.amazon.a.a.o.b.f;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.openid.appauth.Preconditions;

/* JADX INFO: loaded from: classes5.dex */
public final class UriUtil {
    private UriUtil() {
        throw new IllegalStateException("This type is not intended to be instantiated");
    }

    public static Uri parseUriIfAvailable(String str) {
        if (str == null) {
            return null;
        }
        return Uri.parse(str);
    }

    public static void appendQueryParameterIfNotNull(Uri.Builder builder, String str, Object obj) {
        if (obj == null || obj.toString() == null) {
            return;
        }
        builder.appendQueryParameter(str, obj.toString());
    }

    public static Long getLongQueryParameter(Uri uri, String str) {
        String queryParameter = uri.getQueryParameter(str);
        if (queryParameter != null) {
            return Long.valueOf(Long.parseLong(queryParameter));
        }
        return null;
    }

    public static List<Bundle> toCustomTabUriBundle(Uri[] uriArr, int i) {
        Preconditions.checkArgument(i >= 0, "startIndex must be positive");
        if (uriArr == null || uriArr.length <= i) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList(uriArr.length - i);
        while (i < uriArr.length) {
            if (uriArr[i] == null) {
                Logger.warn("Null URI in possibleUris list - ignoring", new Object[0]);
            } else {
                Bundle bundle = new Bundle();
                bundle.putParcelable("android.support.customtabs.otherurls.URL", uriArr[i]);
                arrayList.add(bundle);
            }
            i++;
        }
        return arrayList;
    }

    public static String formUrlEncode(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(entry.getKey() + f.b + formUrlEncodeValue(entry.getValue()));
        }
        return TextUtils.join("&", arrayList);
    }

    public static String formUrlEncodeValue(String str) {
        Preconditions.checkNotNull(str);
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException unused) {
            throw new IllegalStateException("Unable to encode using UTF-8");
        }
    }

    public static List<Pair> formUrlDecode(String str) {
        if (TextUtils.isEmpty(str)) {
            return Collections.EMPTY_LIST;
        }
        String[] strArrSplit = str.split("&");
        ArrayList arrayList = new ArrayList();
        for (String str2 : strArrSplit) {
            String[] strArrSplit2 = str2.split(f.b);
            try {
                arrayList.add(Pair.create(strArrSplit2[0], URLDecoder.decode(strArrSplit2[1], "utf-8")));
            } catch (UnsupportedEncodingException e) {
                Logger.error("Unable to decode parameter, ignoring", e);
            }
        }
        return arrayList;
    }

    public static Map<String, String> formUrlDecodeUnique(String str) {
        List<Pair> listFormUrlDecode = formUrlDecode(str);
        HashMap map = new HashMap();
        for (Pair pair : listFormUrlDecode) {
            map.put((String) pair.first, (String) pair.second);
        }
        return map;
    }
}
