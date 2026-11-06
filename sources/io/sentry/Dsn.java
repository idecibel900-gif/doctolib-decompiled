package io.sentry;

import com.adjust.sdk.Constants;
import io.sentry.util.Objects;
import java.net.URI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes5.dex */
final class Dsn {
    private static final Pattern ORG_ID_PATTERN = Pattern.compile("^o(\\d+)\\.");
    private final String orgId;
    private final String path;
    private final String projectId;
    private final String publicKey;
    private final String secretKey;
    private final URI sentryUri;

    public String getSecretKey() {
        return this.secretKey;
    }

    public String getPublicKey() {
        return this.publicKey;
    }

    URI getSentryUri() {
        return this.sentryUri;
    }

    Dsn(String str) {
        try {
            String strTrim = ((String) Objects.requireNonNull(str, "The DSN is required.")).trim();
            if (strTrim.isEmpty()) {
                throw new IllegalArgumentException("The DSN is empty.");
            }
            URI uriNormalize = new URI(strTrim).normalize();
            String scheme = uriNormalize.getScheme();
            if (!"http".equalsIgnoreCase(scheme) && !Constants.SCHEME.equalsIgnoreCase(scheme)) {
                throw new IllegalArgumentException("Invalid DSN scheme: " + scheme);
            }
            String userInfo = uriNormalize.getUserInfo();
            if (userInfo == null || userInfo.isEmpty()) {
                throw new IllegalArgumentException("Invalid DSN: No public key provided.");
            }
            String[] strArrSplit = userInfo.split(com.revenuecat.purchases.common.Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, -1);
            String str2 = strArrSplit[0];
            this.publicKey = str2;
            if (str2 == null || str2.isEmpty()) {
                throw new IllegalArgumentException("Invalid DSN: No public key provided.");
            }
            String strGroup = null;
            this.secretKey = strArrSplit.length > 1 ? strArrSplit[1] : null;
            String path = uriNormalize.getPath();
            path = path.endsWith("/") ? path.substring(0, path.length() - 1) : path;
            int iLastIndexOf = path.lastIndexOf("/") + 1;
            String strSubstring = path.substring(0, iLastIndexOf);
            if (!strSubstring.endsWith("/")) {
                strSubstring = strSubstring + "/";
            }
            this.path = strSubstring;
            String strSubstring2 = path.substring(iLastIndexOf);
            this.projectId = strSubstring2;
            if (strSubstring2.isEmpty()) {
                throw new IllegalArgumentException("Invalid DSN: A Project Id is required.");
            }
            String str3 = strSubstring;
            this.sentryUri = new URI(scheme, null, uriNormalize.getHost(), uriNormalize.getPort(), str3 + "api/" + strSubstring2, null, null);
            String host = uriNormalize.getHost();
            if (host != null) {
                Matcher matcher = ORG_ID_PATTERN.matcher(host);
                if (matcher.find()) {
                    strGroup = matcher.group(1);
                }
            }
            this.orgId = strGroup;
        } catch (Throwable th) {
            throw new IllegalArgumentException(th);
        }
    }

    public String getOrgId() {
        return this.orgId;
    }
}
