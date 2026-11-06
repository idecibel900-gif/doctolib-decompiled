package expo.modules.updates.manifest;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class ResponsePartInfo {
    private final String body;
    private final ResponseHeaderData responseHeaderData;
    private final ResponsePartHeaderData responsePartHeaderData;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResponsePartInfo)) {
            return false;
        }
        ResponsePartInfo responsePartInfo = (ResponsePartInfo) obj;
        return Intrinsics.areEqual(this.responseHeaderData, responsePartInfo.responseHeaderData) && Intrinsics.areEqual(this.responsePartHeaderData, responsePartInfo.responsePartHeaderData) && Intrinsics.areEqual(this.body, responsePartInfo.body);
    }

    public int hashCode() {
        return (((this.responseHeaderData.hashCode() * 31) + this.responsePartHeaderData.hashCode()) * 31) + this.body.hashCode();
    }

    public String toString() {
        return "ResponsePartInfo(responseHeaderData=" + this.responseHeaderData + ", responsePartHeaderData=" + this.responsePartHeaderData + ", body=" + this.body + ")";
    }

    public ResponsePartInfo(ResponseHeaderData responseHeaderData, ResponsePartHeaderData responsePartHeaderData, String body) {
        Intrinsics.checkNotNullParameter(responseHeaderData, "responseHeaderData");
        Intrinsics.checkNotNullParameter(responsePartHeaderData, "responsePartHeaderData");
        Intrinsics.checkNotNullParameter(body, "body");
        this.responseHeaderData = responseHeaderData;
        this.responsePartHeaderData = responsePartHeaderData;
        this.body = body;
    }

    public final ResponseHeaderData getResponseHeaderData() {
        return this.responseHeaderData;
    }

    public final ResponsePartHeaderData getResponsePartHeaderData() {
        return this.responsePartHeaderData;
    }

    public final String getBody() {
        return this.body;
    }
}
