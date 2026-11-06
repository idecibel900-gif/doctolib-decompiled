package org.bouncycastle.asn1;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public final class ASN1ObjectDescriptor extends ASN1Primitive {
    static final ASN1UniversalType TYPE = new ASN1UniversalType(ASN1ObjectDescriptor.class, 7) { // from class: org.bouncycastle.asn1.ASN1ObjectDescriptor.1
        @Override // org.bouncycastle.asn1.ASN1UniversalType
        ASN1Primitive fromImplicitConstructed(ASN1Sequence aSN1Sequence) {
            return new ASN1ObjectDescriptor((ASN1GraphicString) ASN1GraphicString.TYPE.fromImplicitConstructed(aSN1Sequence));
        }

        @Override // org.bouncycastle.asn1.ASN1UniversalType
        ASN1Primitive fromImplicitPrimitive(DEROctetString dEROctetString) {
            return new ASN1ObjectDescriptor((ASN1GraphicString) ASN1GraphicString.TYPE.fromImplicitPrimitive(dEROctetString));
        }
    };
    private final ASN1GraphicString baseGraphicString;

    public ASN1ObjectDescriptor(ASN1GraphicString aSN1GraphicString) {
        if (aSN1GraphicString == null) {
            throw new NullPointerException("'baseGraphicString' cannot be null");
        }
        this.baseGraphicString = aSN1GraphicString;
    }

    static ASN1ObjectDescriptor createPrimitive(byte[] bArr) {
        return new ASN1ObjectDescriptor(ASN1GraphicString.createPrimitive(bArr));
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (aSN1Primitive instanceof ASN1ObjectDescriptor) {
            return this.baseGraphicString.asn1Equals(((ASN1ObjectDescriptor) aSN1Primitive).baseGraphicString);
        }
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    void encode(ASN1OutputStream aSN1OutputStream, boolean z) throws IOException {
        aSN1OutputStream.writeIdentifier(z, 7);
        this.baseGraphicString.encode(aSN1OutputStream, false);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    boolean encodeConstructed() {
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    int encodedLength(boolean z) {
        return this.baseGraphicString.encodedLength(z);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive, org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        return ~this.baseGraphicString.hashCode();
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    ASN1Primitive toDERObject() {
        ASN1GraphicString aSN1GraphicString = (ASN1GraphicString) this.baseGraphicString.toDERObject();
        return aSN1GraphicString == this.baseGraphicString ? this : new ASN1ObjectDescriptor(aSN1GraphicString);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    ASN1Primitive toDLObject() {
        ASN1GraphicString aSN1GraphicString = (ASN1GraphicString) this.baseGraphicString.toDLObject();
        return aSN1GraphicString == this.baseGraphicString ? this : new ASN1ObjectDescriptor(aSN1GraphicString);
    }
}
