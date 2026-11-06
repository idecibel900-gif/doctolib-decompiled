package org.bouncycastle.pqc.asn1;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public class XMSSMTPublicKey extends ASN1Object {
    private final byte[] publicSeed;
    private final byte[] root;

    public XMSSMTPublicKey(byte[] bArr, byte[] bArr2) {
        this.publicSeed = Arrays.clone(bArr);
        this.root = Arrays.clone(bArr2);
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new ASN1Integer(0L));
        aSN1EncodableVector.add(new DEROctetString(this.publicSeed));
        aSN1EncodableVector.add(new DEROctetString(this.root));
        return new DERSequence(aSN1EncodableVector);
    }
}
