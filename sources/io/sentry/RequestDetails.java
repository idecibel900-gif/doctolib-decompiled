package io.sentry;

import io.sentry.util.Objects;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class RequestDetails {
    private final Map headers;
    private final URL url;

    public RequestDetails(String str, Map map) {
        Objects.requireNonNull(str, "url is required");
        Objects.requireNonNull(map, "headers is required");
        try {
            this.url = URI.create(str).toURL();
            this.headers = map;
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Failed to compose the Sentry's server URL.", e);
        }
    }

    public URL getUrl() {
        return this.url;
    }

    public Map getHeaders() {
        return this.headers;
    }
}
