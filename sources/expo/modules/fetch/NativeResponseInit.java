package expo.modules.fetch;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class NativeResponseInit {
    private final List headers;
    private final boolean redirected;
    private final int status;
    private final String statusText;
    private final String url;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NativeResponseInit)) {
            return false;
        }
        NativeResponseInit nativeResponseInit = (NativeResponseInit) obj;
        return Intrinsics.areEqual(this.headers, nativeResponseInit.headers) && this.status == nativeResponseInit.status && Intrinsics.areEqual(this.statusText, nativeResponseInit.statusText) && Intrinsics.areEqual(this.url, nativeResponseInit.url) && this.redirected == nativeResponseInit.redirected;
    }

    public int hashCode() {
        return (((((((this.headers.hashCode() * 31) + Integer.hashCode(this.status)) * 31) + this.statusText.hashCode()) * 31) + this.url.hashCode()) * 31) + Boolean.hashCode(this.redirected);
    }

    public String toString() {
        return "NativeResponseInit(headers=" + this.headers + ", status=" + this.status + ", statusText=" + this.statusText + ", url=" + this.url + ", redirected=" + this.redirected + ")";
    }

    public NativeResponseInit(List headers, int i, String statusText, String url, boolean z) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(statusText, "statusText");
        Intrinsics.checkNotNullParameter(url, "url");
        this.headers = headers;
        this.status = i;
        this.statusText = statusText;
        this.url = url;
        this.redirected = z;
    }

    public final List getHeaders() {
        return this.headers;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getStatusText() {
        return this.statusText;
    }

    public final String getUrl() {
        return this.url;
    }

    public final boolean getRedirected() {
        return this.redirected;
    }
}
