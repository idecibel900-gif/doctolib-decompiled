package org.bouncycastle.asn1;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ASN1Util {
    static ASN1TaggedObject checkContextTagClass(ASN1TaggedObject aSN1TaggedObject) {
        return checkTagClass(aSN1TaggedObject, 128);
    }

    static ASN1TaggedObject checkTagClass(ASN1TaggedObject aSN1TaggedObject, int i) {
        if (aSN1TaggedObject.hasTagClass(i)) {
            return aSN1TaggedObject;
        }
        throw new IllegalStateException("Expected " + getTagClassText(i) + " tag but found " + getTagClassText(aSN1TaggedObject));
    }

    public static String getTagClassText(int i) {
        if (i == 64) {
            return "APPLICATION";
        }
        if (i != 128) {
            return i != 192 ? "UNIVERSAL" : "PRIVATE";
        }
        return "CONTEXT";
    }

    public static String getTagClassText(ASN1TaggedObject aSN1TaggedObject) {
        return getTagClassText(aSN1TaggedObject.getTagClass());
    }

    public static String getTagText(int i, int i2) {
        StringBuilder sb;
        String str;
        if (i == 64) {
            sb = new StringBuilder();
            str = "[APPLICATION ";
        } else if (i == 128) {
            sb = new StringBuilder();
            str = "[CONTEXT ";
        } else if (i != 192) {
            sb = new StringBuilder();
            str = "[UNIVERSAL ";
        } else {
            sb = new StringBuilder();
            str = "[PRIVATE ";
        }
        sb.append(str);
        sb.append(i2);
        sb.append("]");
        return sb.toString();
    }

    public static String getTagText(ASN1TaggedObject aSN1TaggedObject) {
        return getTagText(aSN1TaggedObject.getTagClass(), aSN1TaggedObject.getTagNo());
    }
}
