package org.bouncycastle.asn1;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class BERSetParser implements ASN1Encodable, InMemoryRepresentable {
    private ASN1StreamParser _parser;

    BERSetParser(ASN1StreamParser aSN1StreamParser) {
        this._parser = aSN1StreamParser;
    }

    static BERSet parse(ASN1StreamParser aSN1StreamParser) {
        return new BERSet(aSN1StreamParser.readVector());
    }

    @Override // org.bouncycastle.asn1.InMemoryRepresentable
    public ASN1Primitive getLoadedObject() {
        return parse(this._parser);
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        try {
            return getLoadedObject();
        } catch (IOException e) {
            throw new ASN1ParsingException(e.getMessage(), e);
        }
    }
}
