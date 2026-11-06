package org.bouncycastle.asn1;

/* JADX INFO: loaded from: classes5.dex */
public class DLExternal extends ASN1External {
    public DLExternal(DLSequence dLSequence) {
        super(dLSequence);
    }

    @Override // org.bouncycastle.asn1.ASN1External
    ASN1Sequence buildSequence() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(4);
        ASN1ObjectIdentifier aSN1ObjectIdentifier = this.directReference;
        if (aSN1ObjectIdentifier != null) {
            aSN1EncodableVector.add(aSN1ObjectIdentifier);
        }
        ASN1Integer aSN1Integer = this.indirectReference;
        if (aSN1Integer != null) {
            aSN1EncodableVector.add(aSN1Integer);
        }
        ASN1Primitive aSN1Primitive = this.dataValueDescriptor;
        if (aSN1Primitive != null) {
            aSN1EncodableVector.add(aSN1Primitive.toDLObject());
        }
        int i = this.encoding;
        aSN1EncodableVector.add(new DLTaggedObject(i == 0, i, this.externalContent));
        return new DLSequence(aSN1EncodableVector);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    ASN1Primitive toDLObject() {
        return this;
    }
}
