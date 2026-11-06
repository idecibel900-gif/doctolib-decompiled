package expo.modules.updates;

import android.net.Uri;
import com.adjust.sdk.Constants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class UpdatesConfigurationKt {
    private static final int getDefaultPortForScheme(String str) {
        if (str == null) {
            return -1;
        }
        switch (str.hashCode()) {
            case 3804:
                return str.equals("ws") ? 80 : -1;
            case 101730:
                return !str.equals("ftp") ? -1 : 21;
            case 118039:
                return !str.equals("wss") ? -1 : 443;
            case 3213448:
                return !str.equals("http") ? -1 : 80;
            case 99617003:
                return !str.equals(Constants.SCHEME) ? -1 : 443;
            default:
                return -1;
        }
    }

    public static final String getNormalizedUrlOrigin(Uri url) {
        Intrinsics.checkNotNullParameter(url, "url");
        String scheme = url.getScheme();
        int port = url.getPort();
        if (port == getDefaultPortForScheme(scheme)) {
            port = -1;
        }
        String host = url.getHost();
        if (port > -1) {
            return scheme + "://" + host + com.revenuecat.purchases.common.Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + port;
        }
        return scheme + "://" + host;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String maybeGetDefaultScopeKey(String str, Uri uri) {
        return str == null ? getNormalizedUrlOrigin(uri) : str;
    }
}
