package com.datadog.android.api.net;

import java.util.Arrays;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class Request {
    private final byte[] body;
    private final String contentType;
    private final String description;
    private final Map headers;
    private final String id;
    private final String url;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Request)) {
            return false;
        }
        Request request = (Request) obj;
        return Intrinsics.areEqual(this.id, request.id) && Intrinsics.areEqual(this.description, request.description) && Intrinsics.areEqual(this.url, request.url) && Intrinsics.areEqual(this.headers, request.headers) && Intrinsics.areEqual(this.body, request.body) && Intrinsics.areEqual(this.contentType, request.contentType);
    }

    public int hashCode() {
        int iHashCode = ((((((((this.id.hashCode() * 31) + this.description.hashCode()) * 31) + this.url.hashCode()) * 31) + this.headers.hashCode()) * 31) + Arrays.hashCode(this.body)) * 31;
        String str = this.contentType;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "Request(id=" + this.id + ", description=" + this.description + ", url=" + this.url + ", headers=" + this.headers + ", body=" + Arrays.toString(this.body) + ", contentType=" + this.contentType + ")";
    }

    public Request(String id, String description, String url, Map headers, byte[] body, String str) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(body, "body");
        this.id = id;
        this.description = description;
        this.url = url;
        this.headers = headers;
        this.body = body;
        this.contentType = str;
    }

    public final String getId() {
        return this.id;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getUrl() {
        return this.url;
    }

    public final Map getHeaders() {
        return this.headers;
    }

    public final byte[] getBody() {
        return this.body;
    }

    public final String getContentType() {
        return this.contentType;
    }
}
