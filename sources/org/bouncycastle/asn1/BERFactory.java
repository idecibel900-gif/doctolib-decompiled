package org.bouncycastle.asn1;

/* JADX INFO: loaded from: classes5.dex */
abstract class BERFactory {
    static final BERSequence EMPTY_SEQUENCE = new BERSequence();
    static final BERSet EMPTY_SET = new BERSet();

    static BERSequence createSequence(ASN1EncodableVector aSN1EncodableVector) {
        return aSN1EncodableVector.size() < 1 ? EMPTY_SEQUENCE : new BERSequence(aSN1EncodableVector);
    }
}
