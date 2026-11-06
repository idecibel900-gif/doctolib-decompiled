package expo.modules.updates.manifest;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class ResponsePartHeaderData {
    private final String signature;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ResponsePartHeaderData) && Intrinsics.areEqual(this.signature, ((ResponsePartHeaderData) obj).signature);
    }

    public int hashCode() {
        String str = this.signature;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "ResponsePartHeaderData(signature=" + this.signature + ")";
    }

    public ResponsePartHeaderData(String str) {
        this.signature = str;
    }

    public final String getSignature() {
        return this.signature;
    }
}
