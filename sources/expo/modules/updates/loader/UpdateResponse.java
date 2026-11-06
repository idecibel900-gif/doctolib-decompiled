package expo.modules.updates.loader;

import expo.modules.updates.manifest.ResponseHeaderData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class UpdateResponse {
    private final UpdateResponsePart.DirectiveUpdateResponsePart directiveUpdateResponsePart;
    private final UpdateResponsePart.ManifestUpdateResponsePart manifestUpdateResponsePart;
    private final ResponseHeaderData responseHeaderData;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UpdateResponse)) {
            return false;
        }
        UpdateResponse updateResponse = (UpdateResponse) obj;
        return Intrinsics.areEqual(this.responseHeaderData, updateResponse.responseHeaderData) && Intrinsics.areEqual(this.manifestUpdateResponsePart, updateResponse.manifestUpdateResponsePart) && Intrinsics.areEqual(this.directiveUpdateResponsePart, updateResponse.directiveUpdateResponsePart);
    }

    public int hashCode() {
        ResponseHeaderData responseHeaderData = this.responseHeaderData;
        int iHashCode = (responseHeaderData == null ? 0 : responseHeaderData.hashCode()) * 31;
        UpdateResponsePart.ManifestUpdateResponsePart manifestUpdateResponsePart = this.manifestUpdateResponsePart;
        int iHashCode2 = (iHashCode + (manifestUpdateResponsePart == null ? 0 : manifestUpdateResponsePart.hashCode())) * 31;
        UpdateResponsePart.DirectiveUpdateResponsePart directiveUpdateResponsePart = this.directiveUpdateResponsePart;
        return iHashCode2 + (directiveUpdateResponsePart != null ? directiveUpdateResponsePart.hashCode() : 0);
    }

    public String toString() {
        return "UpdateResponse(responseHeaderData=" + this.responseHeaderData + ", manifestUpdateResponsePart=" + this.manifestUpdateResponsePart + ", directiveUpdateResponsePart=" + this.directiveUpdateResponsePart + ")";
    }

    public UpdateResponse(ResponseHeaderData responseHeaderData, UpdateResponsePart.ManifestUpdateResponsePart manifestUpdateResponsePart, UpdateResponsePart.DirectiveUpdateResponsePart directiveUpdateResponsePart) {
        this.responseHeaderData = responseHeaderData;
        this.manifestUpdateResponsePart = manifestUpdateResponsePart;
        this.directiveUpdateResponsePart = directiveUpdateResponsePart;
    }

    public final ResponseHeaderData getResponseHeaderData() {
        return this.responseHeaderData;
    }

    public final UpdateResponsePart.ManifestUpdateResponsePart getManifestUpdateResponsePart() {
        return this.manifestUpdateResponsePart;
    }

    public final UpdateResponsePart.DirectiveUpdateResponsePart getDirectiveUpdateResponsePart() {
        return this.directiveUpdateResponsePart;
    }
}
