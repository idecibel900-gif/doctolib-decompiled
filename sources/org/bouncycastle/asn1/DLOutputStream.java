package org.bouncycastle.asn1;

import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
class DLOutputStream extends ASN1OutputStream {
    DLOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // org.bouncycastle.asn1.ASN1OutputStream
    DLOutputStream getDLSubStream() {
        return this;
    }

    @Override // org.bouncycastle.asn1.ASN1OutputStream
    void writeElements(ASN1Encodable[] aSN1EncodableArr) {
        for (ASN1Encodable aSN1Encodable : aSN1EncodableArr) {
            aSN1Encodable.toASN1Primitive().toDLObject().encode(this, true);
        }
    }

    @Override // org.bouncycastle.asn1.ASN1OutputStream
    void writePrimitive(ASN1Primitive aSN1Primitive, boolean z) {
        aSN1Primitive.toDLObject().encode(this, z);
    }

    @Override // org.bouncycastle.asn1.ASN1OutputStream
    void writePrimitives(ASN1Primitive[] aSN1PrimitiveArr) {
        for (ASN1Primitive aSN1Primitive : aSN1PrimitiveArr) {
            aSN1Primitive.toDLObject().encode(this, true);
        }
    }
}
