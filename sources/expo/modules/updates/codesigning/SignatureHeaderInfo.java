package expo.modules.updates.codesigning;

import expo.modules.structuredheaders.ListElement;
import expo.modules.structuredheaders.Parser;
import expo.modules.structuredheaders.StringItem;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class SignatureHeaderInfo {
    public static final Companion Companion = new Companion(null);
    private final CodeSigningAlgorithm algorithm;
    private final String keyId;
    private final String signature;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SignatureHeaderInfo)) {
            return false;
        }
        SignatureHeaderInfo signatureHeaderInfo = (SignatureHeaderInfo) obj;
        return Intrinsics.areEqual(this.signature, signatureHeaderInfo.signature) && Intrinsics.areEqual(this.keyId, signatureHeaderInfo.keyId) && this.algorithm == signatureHeaderInfo.algorithm;
    }

    public int hashCode() {
        return (((this.signature.hashCode() * 31) + this.keyId.hashCode()) * 31) + this.algorithm.hashCode();
    }

    public String toString() {
        return "SignatureHeaderInfo(signature=" + this.signature + ", keyId=" + this.keyId + ", algorithm=" + this.algorithm + ")";
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SignatureHeaderInfo parseSignatureHeader(String signatureHeader) throws Exception {
            String str;
            Intrinsics.checkNotNullParameter(signatureHeader, "signatureHeader");
            Map map = new Parser(signatureHeader).parseDictionary().get();
            ListElement listElement = (ListElement) map.get("sig");
            ListElement listElement2 = (ListElement) map.get("keyid");
            ListElement listElement3 = (ListElement) map.get("alg");
            if (listElement instanceof StringItem) {
                String str2 = ((StringItem) listElement).get();
                if (listElement2 instanceof StringItem) {
                    str = ((StringItem) listElement2).get();
                } else {
                    str = "root";
                }
                String str3 = listElement3 instanceof StringItem ? ((StringItem) listElement3).get() : null;
                Intrinsics.checkNotNull(str2);
                Intrinsics.checkNotNull(str);
                return new SignatureHeaderInfo(str2, str, CodeSigningAlgorithm.Companion.parseFromString(str3));
            }
            throw new Exception("Structured field sig not found in expo-signature header");
        }
    }

    public SignatureHeaderInfo(String signature, String keyId, CodeSigningAlgorithm algorithm) {
        Intrinsics.checkNotNullParameter(signature, "signature");
        Intrinsics.checkNotNullParameter(keyId, "keyId");
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        this.signature = signature;
        this.keyId = keyId;
        this.algorithm = algorithm;
    }

    public final CodeSigningAlgorithm getAlgorithm() {
        return this.algorithm;
    }

    public final String getKeyId() {
        return this.keyId;
    }

    public final String getSignature() {
        return this.signature;
    }
}
