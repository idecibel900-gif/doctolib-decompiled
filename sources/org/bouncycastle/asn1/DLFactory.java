package org.bouncycastle.asn1;

/* JADX INFO: loaded from: classes5.dex */
abstract class DLFactory {
    static final DLSequence EMPTY_SEQUENCE = new DLSequence();
    static final DLSet EMPTY_SET = new DLSet();

    static DLSequence createSequence(ASN1EncodableVector aSN1EncodableVector) {
        return aSN1EncodableVector.size() < 1 ? EMPTY_SEQUENCE : new DLSequence(aSN1EncodableVector);
    }

    static DLSet createSet(ASN1EncodableVector aSN1EncodableVector) {
        return aSN1EncodableVector.size() < 1 ? EMPTY_SET : new DLSet(aSN1EncodableVector);
    }
}
