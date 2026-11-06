package io.sentry;

import io.sentry.util.Objects;
import java.net.URI;
import java.util.HashMap;

/* JADX INFO: loaded from: classes5.dex */
public final class RequestDetailsResolver {
    private final Dsn dsn;
    private final String sentryClientName;

    public RequestDetailsResolver(SentryOptions sentryOptions) {
        Objects.requireNonNull(sentryOptions, "options is required");
        this.dsn = sentryOptions.retrieveParsedDsn();
        this.sentryClientName = sentryOptions.getSentryClientName();
    }

    public RequestDetails resolve() {
        String str;
        URI sentryUri = this.dsn.getSentryUri();
        String string = sentryUri.resolve(sentryUri.getPath() + "/envelope/").toString();
        String publicKey = this.dsn.getPublicKey();
        String secretKey = this.dsn.getSecretKey();
        StringBuilder sb = new StringBuilder();
        sb.append("Sentry sentry_version=7,sentry_client=");
        sb.append(this.sentryClientName);
        sb.append(",sentry_key=");
        sb.append(publicKey);
        if (secretKey == null || secretKey.length() <= 0) {
            str = "";
        } else {
            str = ",sentry_secret=" + secretKey;
        }
        sb.append(str);
        String string2 = sb.toString();
        HashMap map = new HashMap();
        map.put("User-Agent", this.sentryClientName);
        map.put("X-Sentry-Auth", string2);
        return new RequestDetails(string, map);
    }
}
