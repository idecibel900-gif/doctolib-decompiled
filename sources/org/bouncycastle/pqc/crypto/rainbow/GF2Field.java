package org.bouncycastle.pqc.crypto.rainbow;

import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import java.lang.reflect.Array;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes5.dex */
abstract class GF2Field {
    static final byte[][] gfMulTable = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER, IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER);
    static final byte[] gfInvTable = new byte[IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER];

    static {
        long j;
        int i = 1;
        long j2 = 72340172838076673L;
        while (true) {
            j = 506097522914230528L;
            if (i > 255) {
                break;
            }
            for (int i2 = 0; i2 < 256; i2 += 8) {
                Pack.longToLittleEndian(gf256Mul_64(j2, j), gfMulTable[i], i2);
                j += 578721382704613384L;
            }
            j2 += 72340172838076673L;
            i++;
        }
        for (int i3 = 0; i3 < 256; i3 += 8) {
            Pack.longToLittleEndian(gf256Inv_64(j), gfInvTable, i3);
            j += 578721382704613384L;
        }
    }

    public static short addElem(short s, short s2) {
        return (short) (s ^ s2);
    }

    private static long gf16Mul8_64(long j) {
        long j2 = 3689348814741910323L & j;
        long j3 = j & (-3689348814741910324L);
        long j4 = (j2 << 2) ^ j3;
        long j5 = j3 >>> 2;
        return j5 ^ gf4Mul2_64(j4 ^ j5);
    }

    private static long gf16Mul_64(long j, long j2) {
        long jGf4Mul_64 = gf4Mul_64(j, j2);
        long j3 = 3689348814741910323L & jGf4Mul_64;
        return (gf4Mul_64(((j ^ (j << 2)) & (-3689348814741910324L)) ^ ((jGf4Mul_64 & (-3689348814741910324L)) >>> 2), ((j2 ^ (j2 << 2)) & (-3689348814741910324L)) ^ 2459565876494606882L) ^ (j3 << 2)) ^ j3;
    }

    private static long gf16Squ_64(long j) {
        long jGf4Squ_64 = gf4Squ_64(j);
        return jGf4Squ_64 ^ (gf4Mul2_64((-3689348814741910324L) & jGf4Squ_64) >>> 2);
    }

    private static long gf256Inv_64(long j) {
        long jGf256Squ_64 = gf256Squ_64(j);
        long jGf256Squ_65 = gf256Squ_64(jGf256Squ_64);
        long jGf256Mul_64 = gf256Mul_64(gf256Mul_64(jGf256Squ_65, jGf256Squ_64), gf256Squ_64(jGf256Squ_65));
        return gf256Mul_64(jGf256Squ_64, gf256Squ_64(gf256Mul_64(gf256Squ_64(gf256Squ_64(gf256Squ_64(jGf256Mul_64))), jGf256Mul_64)));
    }

    private static long gf256Mul_64(long j, long j2) {
        long jGf16Mul_64 = gf16Mul_64(j, j2);
        long j3 = 1085102592571150095L & jGf16Mul_64;
        return (gf16Mul_64(((j ^ (j << 4)) & (-1085102592571150096L)) ^ ((jGf16Mul_64 & (-1085102592571150096L)) >>> 4), ((j2 ^ (j2 << 4)) & (-1085102592571150096L)) ^ 578721382704613384L) ^ (j3 << 4)) ^ j3;
    }

    private static long gf256Squ_64(long j) {
        long jGf16Squ_64 = gf16Squ_64(j);
        return jGf16Squ_64 ^ (gf16Mul8_64((-1085102592571150096L) & jGf16Squ_64) >>> 4);
    }

    private static long gf4Mul2_64(long j) {
        long j2 = 6148914691236517205L & j;
        long j3 = j & (-6148914691236517206L);
        return (j3 >>> 1) ^ ((j2 << 1) ^ j3);
    }

    private static long gf4Mul_64(long j, long j2) {
        long j3 = (((j << 1) & j2) ^ ((j2 << 1) & j)) & (-6148914691236517206L);
        long j4 = j & j2;
        return ((j4 & (-6148914691236517206L)) >>> 1) ^ (j4 ^ j3);
    }

    private static long gf4Squ_64(long j) {
        return j ^ (((-6148914691236517206L) & j) >>> 1);
    }

    public static short multElem(short s, short s2) {
        return (short) (gfMulTable[s][s2] & 255);
    }
}
