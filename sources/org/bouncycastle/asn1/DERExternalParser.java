package org.bouncycastle.asn1;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class DERExternalParser implements ASN1Encodable, InMemoryRepresentable {
    private ASN1StreamParser _parser;

    public DERExternalParser(ASN1StreamParser aSN1StreamParser) {
        this._parser = aSN1StreamParser;
    }

    static DLExternal parse(ASN1StreamParser aSN1StreamParser) throws ASN1Exception {
        try {
            return new DLExternal(new DLSequence(aSN1StreamParser.readVector()));
        } catch (IllegalArgumentException e) {
            throw new ASN1Exception(e.getMessage(), e);
        }
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
            throw new ASN1ParsingException("unable to get DER object", e);
        } catch (IllegalArgumentException e2) {
            throw new ASN1ParsingException("unable to get DER object", e2);
        }
    }
}
