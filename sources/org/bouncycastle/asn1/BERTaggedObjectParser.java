package org.bouncycastle.asn1;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
class BERTaggedObjectParser implements ASN1Encodable, InMemoryRepresentable {
    final ASN1StreamParser _parser;
    final int _tagClass;
    final int _tagNo;

    BERTaggedObjectParser(int i, int i2, ASN1StreamParser aSN1StreamParser) {
        this._tagClass = i;
        this._tagNo = i2;
        this._parser = aSN1StreamParser;
    }

    @Override // org.bouncycastle.asn1.InMemoryRepresentable
    public ASN1Primitive getLoadedObject() {
        return this._parser.loadTaggedIL(this._tagClass, this._tagNo);
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        try {
            return getLoadedObject();
        } catch (IOException e) {
            throw new ASN1ParsingException(e.getMessage());
        }
    }
}
