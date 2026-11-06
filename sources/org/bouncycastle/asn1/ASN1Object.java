package org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import org.bouncycastle.util.Encodable;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ASN1Object implements ASN1Encodable, Encodable {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ASN1Encodable) {
            return toASN1Primitive().equals(((ASN1Encodable) obj).toASN1Primitive());
        }
        return false;
    }

    @Override // org.bouncycastle.util.Encodable
    public byte[] getEncoded() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        toASN1Primitive().encodeTo(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public byte[] getEncoded(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        toASN1Primitive().encodeTo(byteArrayOutputStream, str);
        return byteArrayOutputStream.toByteArray();
    }

    public int hashCode() {
        return toASN1Primitive().hashCode();
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public abstract ASN1Primitive toASN1Primitive();
}
