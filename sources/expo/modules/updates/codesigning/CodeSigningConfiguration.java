package expo.modules.updates.codesigning;

import android.util.Base64;
import expo.modules.structuredheaders.BooleanItem;
import expo.modules.structuredheaders.Dictionary;
import expo.modules.structuredheaders.StringItem;
import java.security.Signature;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class CodeSigningConfiguration {
    public static final Companion Companion = new Companion(null);
    private final Lazy algorithmFromMetadata$delegate;
    private final boolean allowUnsignedManifests;
    private final Map codeSigningMetadata;
    private final String embeddedCertificateString;
    private final boolean includeManifestResponseCertificateChain;
    private final Lazy keyIdFromMetadata$delegate;

    public CodeSigningConfiguration(String embeddedCertificateString, Map map, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(embeddedCertificateString, "embeddedCertificateString");
        this.embeddedCertificateString = embeddedCertificateString;
        this.codeSigningMetadata = map;
        this.includeManifestResponseCertificateChain = z;
        this.allowUnsignedManifests = z2;
        this.algorithmFromMetadata$delegate = LazyKt.lazy(new Function0() { // from class: expo.modules.updates.codesigning.CodeSigningConfiguration$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CodeSigningConfiguration.algorithmFromMetadata_delegate$lambda$0(this.f$0);
            }
        });
        this.keyIdFromMetadata$delegate = LazyKt.lazy(new Function0() { // from class: expo.modules.updates.codesigning.CodeSigningConfiguration$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CodeSigningConfiguration.keyIdFromMetadata_delegate$lambda$1(this.f$0);
            }
        });
    }

    private final CodeSigningAlgorithm getAlgorithmFromMetadata() {
        return (CodeSigningAlgorithm) this.algorithmFromMetadata$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CodeSigningAlgorithm algorithmFromMetadata_delegate$lambda$0(CodeSigningConfiguration codeSigningConfiguration) {
        CodeSigningAlgorithm.Companion companion = CodeSigningAlgorithm.Companion;
        Map map = codeSigningConfiguration.codeSigningMetadata;
        return companion.parseFromString(map != null ? (String) map.get("alg") : null);
    }

    private final String getKeyIdFromMetadata() {
        return (String) this.keyIdFromMetadata$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String keyIdFromMetadata_delegate$lambda$1(CodeSigningConfiguration codeSigningConfiguration) {
        String str;
        Map map = codeSigningConfiguration.codeSigningMetadata;
        return (map == null || (str = (String) map.get("keyid")) == null) ? "root" : str;
    }

    public final SignatureValidationResult validateSignature(String str, byte[] bodyBytes, String str2) throws Exception {
        Intrinsics.checkNotNullParameter(bodyBytes, "bodyBytes");
        if (str == null) {
            if (!this.allowUnsignedManifests) {
                throw new Exception("No expo-signature header specified");
            }
            return new SignatureValidationResult(ValidationResult.SKIPPED, null);
        }
        return validateSignatureInternal(SignatureHeaderInfo.Companion.parseSignatureHeader(str), bodyBytes, str2);
    }

    private final SignatureValidationResult validateSignatureInternal(SignatureHeaderInfo signatureHeaderInfo, byte[] bArr, String str) throws Exception {
        CertificateChain certificateChain;
        if (this.includeManifestResponseCertificateChain) {
            Companion companion = Companion;
            if (str == null) {
                str = "";
            }
            certificateChain = new CertificateChain(CollectionsKt.plus((Collection) companion.separateCertificateChain(str), (Object) this.embeddedCertificateString));
        } else {
            if (!Intrinsics.areEqual(signatureHeaderInfo.getKeyId(), getKeyIdFromMetadata())) {
                throw new Exception("Key with keyid=" + signatureHeaderInfo.getKeyId() + " from signature not found in client configuration");
            }
            if (signatureHeaderInfo.getAlgorithm() != getAlgorithmFromMetadata()) {
                Objects.toString(signatureHeaderInfo.getAlgorithm());
            }
            certificateChain = new CertificateChain(CollectionsKt.listOf(this.embeddedCertificateString));
        }
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initVerify(certificateChain.getCodeSigningCertificate().getPublicKey());
        signature.update(bArr);
        return new SignatureValidationResult(signature.verify(Base64.decode(signatureHeaderInfo.getSignature(), 0)) ? ValidationResult.VALID : ValidationResult.INVALID, CertificateChain.Companion.expoProjectInformation(certificateChain.getCodeSigningCertificate()));
    }

    public final String getAcceptSignatureHeader() {
        String strSerialize = Dictionary.valueOf(MapsKt.mapOf(TuplesKt.to("sig", BooleanItem.valueOf(true)), TuplesKt.to("keyid", StringItem.valueOf(getKeyIdFromMetadata())), TuplesKt.to("alg", StringItem.valueOf(getAlgorithmFromMetadata().getAlgorithmName())))).serialize();
        Intrinsics.checkNotNullExpressionValue(strSerialize, "serialize(...)");
        return strSerialize;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List separateCertificateChain(String certificateChainInManifestResponse) {
            Intrinsics.checkNotNullParameter(certificateChainInManifestResponse, "certificateChainInManifestResponse");
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                String str = certificateChainInManifestResponse;
                int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str, "-----BEGIN CERTIFICATE-----", i, false, 4, (Object) null);
                int iIndexOf$default2 = StringsKt.indexOf$default((CharSequence) str, "-----END CERTIFICATE-----", i, false, 4, (Object) null);
                if (iIndexOf$default == -1 || iIndexOf$default2 == -1) {
                    break;
                }
                i = iIndexOf$default2 + 25;
                String strSubstring = str.substring(iIndexOf$default, i);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                arrayList.add(strSubstring);
                certificateChainInManifestResponse = str;
            }
            return arrayList;
        }
    }
}
