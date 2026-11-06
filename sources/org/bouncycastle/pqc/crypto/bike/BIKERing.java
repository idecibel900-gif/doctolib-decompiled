package org.bouncycastle.pqc.crypto.bike;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.math.raw.Mod;
import org.bouncycastle.util.Integers;

/* JADX INFO: loaded from: classes5.dex */
class BIKERing {
    private final int bits;
    private final Map halfPowers;
    private final int size;
    private final int sizeExt;

    BIKERing(int i) {
        HashMap map = new HashMap();
        this.halfPowers = map;
        if (((-65535) & i) != 1) {
            throw new IllegalArgumentException();
        }
        this.bits = i;
        int i2 = (i + 63) >>> 6;
        this.size = i2;
        this.sizeExt = i2 * 2;
        generateHalfPowersInv(map, i);
    }

    private static int generateHalfPower(int i, int i2, int i3) {
        int i4 = 1;
        while (i3 >= 32) {
            i4 = (int) ((((4294967295L & ((long) (i2 * i4))) * ((long) i)) + ((long) i4)) >>> 32);
            i3 -= 32;
        }
        if (i3 <= 0) {
            return i4;
        }
        return (int) ((((4294967295L & ((long) ((i2 * i4) & ((-1) >>> (-i3))))) * ((long) i)) + ((long) i4)) >>> i3);
    }

    private static void generateHalfPowersInv(Map map, int i) {
        int i2;
        int i3 = i - 2;
        int iNumberOfLeadingZeros = 32 - Integers.numberOfLeadingZeros(i3);
        int iInverse32 = Mod.inverse32(-i);
        for (int i4 = 1; i4 < iNumberOfLeadingZeros; i4++) {
            int i5 = 1 << (i4 - 1);
            if (i5 >= 64 && !map.containsKey(Integers.valueOf(i5))) {
                map.put(Integers.valueOf(i5), Integers.valueOf(generateHalfPower(i, iInverse32, i5)));
            }
            int i6 = 1 << i4;
            if ((i3 & i6) != 0 && (i2 = (i6 - 1) & i3) >= 64 && !map.containsKey(Integers.valueOf(i2))) {
                map.put(Integers.valueOf(i2), Integers.valueOf(generateHalfPower(i, iInverse32, i2)));
            }
        }
    }
}
