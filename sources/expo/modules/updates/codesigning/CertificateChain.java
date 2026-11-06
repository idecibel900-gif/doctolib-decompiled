package expo.modules.updates.codesigning;

import java.io.ByteArrayInputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DEROctetString;

/* JADX INFO: loaded from: classes4.dex */
public final class CertificateChain {
    public static final Companion Companion = new Companion(null);
    private final List certificateStrings;
    private final Lazy codeSigningCertificate$delegate;

    public CertificateChain(List certificateStrings) {
        Intrinsics.checkNotNullParameter(certificateStrings, "certificateStrings");
        this.certificateStrings = certificateStrings;
        this.codeSigningCertificate$delegate = LazyKt.lazy(new Function0() { // from class: expo.modules.updates.codesigning.CertificateChain$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CertificateChain.codeSigningCertificate_delegate$lambda$1(this.f$0);
            }
        });
    }

    public final X509Certificate getCodeSigningCertificate() {
        return (X509Certificate) this.codeSigningCertificate$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final X509Certificate codeSigningCertificate_delegate$lambda$1(CertificateChain certificateChain) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateException, NoSuchProviderException {
        if (certificateChain.certificateStrings.isEmpty()) {
            throw new CertificateException("No code signing certificates provided");
        }
        List list = certificateChain.certificateStrings;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Companion.constructCertificate((String) it.next()));
        }
        Companion companion = Companion;
        companion.validateChain(arrayList);
        X509Certificate x509Certificate = (X509Certificate) arrayList.get(0);
        if (companion.isCodeSigningCertificate(x509Certificate)) {
            return x509Certificate;
        }
        throw new CertificateException("First certificate in chain is not a code signing certificate. Must have X509v3 Key Usage: Digital Signature and X509v3 Extended Key Usage: Code Signing");
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final X509Certificate constructCertificate(String str) throws CertificateException {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            Certificate certificateGenerateCertificate = certificateFactory.generateCertificate(new ByteArrayInputStream(bytes));
            Intrinsics.checkNotNull(certificateGenerateCertificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            X509Certificate x509Certificate = (X509Certificate) certificateGenerateCertificate;
            x509Certificate.checkValidity();
            return x509Certificate;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isCodeSigningCertificate(X509Certificate x509Certificate) {
            if (x509Certificate.getKeyUsage() != null) {
                boolean[] keyUsage = x509Certificate.getKeyUsage();
                Intrinsics.checkNotNullExpressionValue(keyUsage, "getKeyUsage(...)");
                if (!(keyUsage.length == 0) && x509Certificate.getKeyUsage()[0] && x509Certificate.getExtendedKeyUsage() != null && x509Certificate.getExtendedKeyUsage().contains("1.3.6.1.5.5.7.3.3")) {
                    return true;
                }
            }
            return false;
        }

        public final ExpoProjectInformation expoProjectInformation(X509Certificate x509Certificate) throws CertificateException {
            ASN1Primitive aSN1PrimitiveFromByteArray;
            String strDecodeToString;
            Intrinsics.checkNotNullParameter(x509Certificate, "<this>");
            byte[] extensionValue = x509Certificate.getExtensionValue("1.2.840.113556.1.8000.2554.43437.254.128.102.157.7894389.20439.2.1");
            if (extensionValue != null && (aSN1PrimitiveFromByteArray = ASN1Primitive.fromByteArray(extensionValue)) != null) {
                if (aSN1PrimitiveFromByteArray instanceof DEROctetString) {
                    byte[] octets = ((DEROctetString) aSN1PrimitiveFromByteArray).getOctets();
                    Intrinsics.checkNotNullExpressionValue(octets, "getOctets(...)");
                    strDecodeToString = StringsKt.decodeToString(octets);
                } else {
                    strDecodeToString = null;
                }
                if (strDecodeToString != null) {
                    List listSplit$default = StringsKt.split$default((CharSequence) strDecodeToString, new char[]{','}, false, 0, 6, (Object) null);
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSplit$default, 10));
                    Iterator it = listSplit$default.iterator();
                    while (it.hasNext()) {
                        arrayList.add(StringsKt.trim((String) it.next()).toString());
                    }
                    if (arrayList.size() != 2) {
                        throw new CertificateException("Invalid Expo project information extension value");
                    }
                    return new ExpoProjectInformation((String) arrayList.get(0), (String) arrayList.get(1));
                }
            }
            return null;
        }

        private final boolean isCACertificate(X509Certificate x509Certificate) {
            if (x509Certificate.getBasicConstraints() > -1 && x509Certificate.getKeyUsage() != null) {
                boolean[] keyUsage = x509Certificate.getKeyUsage();
                Intrinsics.checkNotNullExpressionValue(keyUsage, "getKeyUsage(...)");
                if (!(keyUsage.length == 0) && x509Certificate.getKeyUsage()[5]) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void validateChain(List list) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateException, NoSuchProviderException {
            int size = list.size() - 1;
            int i = 0;
            while (i < size) {
                X509Certificate x509Certificate = (X509Certificate) list.get(i);
                i++;
                X509Certificate x509Certificate2 = (X509Certificate) list.get(i);
                if (!x509Certificate.getIssuerX500Principal().equals(x509Certificate2.getSubjectX500Principal())) {
                    throw new CertificateException("Certificates do not chain");
                }
                x509Certificate.verify(x509Certificate2.getPublicKey());
            }
            if (!((X509Certificate) CollectionsKt.last(list)).getIssuerX500Principal().equals(((X509Certificate) CollectionsKt.last(list)).getSubjectX500Principal())) {
                throw new CertificateException("Root certificate not self-signed");
            }
            ((X509Certificate) CollectionsKt.last(list)).verify(((X509Certificate) CollectionsKt.last(list)).getPublicKey());
            if (list.size() > 1) {
                X509Certificate x509Certificate3 = (X509Certificate) CollectionsKt.last(list);
                if (!isCACertificate(x509Certificate3)) {
                    throw new CertificateException("Root certificate subject must be a Certificate Authority");
                }
                ExpoProjectInformation expoProjectInformation = expoProjectInformation(x509Certificate3);
                int basicConstraints = x509Certificate3.getBasicConstraints();
                int size2 = list.size() - 2;
                while (size2 > 0) {
                    X509Certificate x509Certificate4 = (X509Certificate) list.get(size2);
                    if (!isCACertificate(x509Certificate4)) {
                        throw new CertificateException("Non-leaf certificate subject must be a Certificate Authority");
                    }
                    ExpoProjectInformation expoProjectInformation2 = expoProjectInformation(x509Certificate4);
                    if (expoProjectInformation != null && !Intrinsics.areEqual(expoProjectInformation, expoProjectInformation2)) {
                        throw new CertificateException("Expo project information must be a subset or equal of that of parent certificates");
                    }
                    if (basicConstraints <= 0) {
                        throw new CertificateException("pathLenConstraint violated by intermediate certificate");
                    }
                    basicConstraints = Math.min(x509Certificate4.getBasicConstraints(), basicConstraints - 1);
                    size2--;
                    expoProjectInformation = expoProjectInformation2;
                }
                if (expoProjectInformation != null && !Intrinsics.areEqual(expoProjectInformation, expoProjectInformation((X509Certificate) CollectionsKt.first(list)))) {
                    throw new CertificateException("Expo project information must be a subset of or equal to that of parent certificates");
                }
            }
        }
    }
}
