package com.revenuecat.purchases.common.networking;

import com.opentok.android.PublisherKit;
import java.net.URL;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\bHÆ\u0003J5\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/revenuecat/purchases/common/networking/HTTPRequest;", "", "fullURL", "Ljava/net/URL;", "headers", "", "", "body", "Lorg/json/JSONObject;", "(Ljava/net/URL;Ljava/util/Map;Lorg/json/JSONObject;)V", "getBody", "()Lorg/json/JSONObject;", "getFullURL", "()Ljava/net/URL;", "getHeaders", "()Ljava/util/Map;", "component1", "component2", "component3", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class HTTPRequest {
    public static final String ETAG_HEADER_NAME = "X-RevenueCat-ETag";
    public static final String ETAG_LAST_REFRESH_NAME = "X-RC-Last-Refresh-Time";
    public static final String POST_PARAMS_HASH = "X-Post-Params-Hash";
    private final JSONObject body;
    private final URL fullURL;
    private final Map<String, String> headers;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HTTPRequest copy$default(HTTPRequest hTTPRequest, URL url, Map map, JSONObject jSONObject, int i, Object obj) {
        if ((i & 1) != 0) {
            url = hTTPRequest.fullURL;
        }
        if ((i & 2) != 0) {
            map = hTTPRequest.headers;
        }
        if ((i & 4) != 0) {
            jSONObject = hTTPRequest.body;
        }
        return hTTPRequest.copy(url, map, jSONObject);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final URL getFullURL() {
        return this.fullURL;
    }

    public final Map<String, String> component2() {
        return this.headers;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final JSONObject getBody() {
        return this.body;
    }

    public final HTTPRequest copy(URL fullURL, Map<String, String> headers, JSONObject body) {
        Intrinsics.checkNotNullParameter(fullURL, "fullURL");
        Intrinsics.checkNotNullParameter(headers, "headers");
        return new HTTPRequest(fullURL, headers, body);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HTTPRequest)) {
            return false;
        }
        HTTPRequest hTTPRequest = (HTTPRequest) other;
        return Intrinsics.areEqual(this.fullURL, hTTPRequest.fullURL) && Intrinsics.areEqual(this.headers, hTTPRequest.headers) && Intrinsics.areEqual(this.body, hTTPRequest.body);
    }

    public int hashCode() {
        int iHashCode = ((this.fullURL.hashCode() * 31) + this.headers.hashCode()) * 31;
        JSONObject jSONObject = this.body;
        return iHashCode + (jSONObject == null ? 0 : jSONObject.hashCode());
    }

    public String toString() {
        return "HTTPRequest(fullURL=" + this.fullURL + ", headers=" + this.headers + ", body=" + this.body + ')';
    }

    public HTTPRequest(URL fullURL, Map<String, String> headers, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(fullURL, "fullURL");
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.fullURL = fullURL;
        this.headers = headers;
        this.body = jSONObject;
    }

    public final URL getFullURL() {
        return this.fullURL;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final JSONObject getBody() {
        return this.body;
    }
}
