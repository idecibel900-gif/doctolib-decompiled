package org.bouncycastle.util;

import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.revenuecat.purchases.common.Constants;
import org.bouncycastle.crypto.digests.SHAKEDigest;

/* JADX INFO: loaded from: classes5.dex */
public class Fingerprint {
    private static char[] encodingTable = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private final byte[] fingerprint;

    public Fingerprint(byte[] bArr) {
        this(bArr, 160);
    }

    public Fingerprint(byte[] bArr, int i) {
        this.fingerprint = calculateFingerprint(bArr, i);
    }

    public static byte[] calculateFingerprint(byte[] bArr, int i) {
        if (i % 8 != 0) {
            throw new IllegalArgumentException("bitLength must be a multiple of 8");
        }
        SHAKEDigest sHAKEDigest = new SHAKEDigest(IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER);
        sHAKEDigest.update(bArr, 0, bArr.length);
        int i2 = i / 8;
        byte[] bArr2 = new byte[i2];
        sHAKEDigest.doFinal(bArr2, 0, i2);
        return bArr2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Fingerprint) {
            return Arrays.areEqual(((Fingerprint) obj).fingerprint, this.fingerprint);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.fingerprint);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i != this.fingerprint.length; i++) {
            if (i > 0) {
                stringBuffer.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
            }
            stringBuffer.append(encodingTable[(this.fingerprint[i] >>> 4) & 15]);
            stringBuffer.append(encodingTable[this.fingerprint[i] & 15]);
        }
        return stringBuffer.toString();
    }
}
