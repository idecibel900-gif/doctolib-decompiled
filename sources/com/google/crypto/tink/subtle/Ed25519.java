package com.google.crypto.tink.subtle;

import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import io.sentry.SentryOptions;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
abstract class Ed25519 {
    private static final CachedXYT CACHED_NEUTRAL = new CachedXYT(new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
    private static final PartialXYZT NEUTRAL = new PartialXYZT(new XYZ(new long[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}), new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0});
    static final byte[] GROUP_ORDER = {-19, -45, -11, 92, 26, 99, 18, 88, -42, -100, -9, -94, -34, -7, -34, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16};

    private static class XYZ {
        final long[] x;
        final long[] y;
        final long[] z;

        XYZ() {
            this(new long[10], new long[10], new long[10]);
        }

        XYZ(long[] jArr, long[] jArr2, long[] jArr3) {
            this.x = jArr;
            this.y = jArr2;
            this.z = jArr3;
        }

        XYZ(XYZ xyz) {
            this.x = Arrays.copyOf(xyz.x, 10);
            this.y = Arrays.copyOf(xyz.y, 10);
            this.z = Arrays.copyOf(xyz.z, 10);
        }

        XYZ(PartialXYZT partialXYZT) {
            this();
            fromPartialXYZT(this, partialXYZT);
        }

        static XYZ fromPartialXYZT(XYZ xyz, PartialXYZT partialXYZT) {
            Field25519.mult(xyz.x, partialXYZT.xyz.x, partialXYZT.t);
            long[] jArr = xyz.y;
            XYZ xyz2 = partialXYZT.xyz;
            Field25519.mult(jArr, xyz2.y, xyz2.z);
            Field25519.mult(xyz.z, partialXYZT.xyz.z, partialXYZT.t);
            return xyz;
        }

        byte[] toBytes() {
            long[] jArr = new long[10];
            long[] jArr2 = new long[10];
            long[] jArr3 = new long[10];
            Field25519.inverse(jArr, this.z);
            Field25519.mult(jArr2, this.x, jArr);
            Field25519.mult(jArr3, this.y, jArr);
            byte[] bArrContract = Field25519.contract(jArr3);
            bArrContract[31] = (byte) ((Ed25519.getLsb(jArr2) << 7) ^ bArrContract[31]);
            return bArrContract;
        }
    }

    private static class XYZT {
        final long[] t;
        final XYZ xyz;

        XYZT() {
            this(new XYZ(), new long[10]);
        }

        XYZT(XYZ xyz, long[] jArr) {
            this.xyz = xyz;
            this.t = jArr;
        }

        XYZT(PartialXYZT partialXYZT) {
            this();
            fromPartialXYZT(this, partialXYZT);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static XYZT fromPartialXYZT(XYZT xyzt, PartialXYZT partialXYZT) {
            Field25519.mult(xyzt.xyz.x, partialXYZT.xyz.x, partialXYZT.t);
            long[] jArr = xyzt.xyz.y;
            XYZ xyz = partialXYZT.xyz;
            Field25519.mult(jArr, xyz.y, xyz.z);
            Field25519.mult(xyzt.xyz.z, partialXYZT.xyz.z, partialXYZT.t);
            long[] jArr2 = xyzt.t;
            XYZ xyz2 = partialXYZT.xyz;
            Field25519.mult(jArr2, xyz2.x, xyz2.y);
            return xyzt;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static XYZT fromBytesNegateVarTime(byte[] bArr) throws GeneralSecurityException {
            long[] jArr = new long[10];
            long[] jArrExpand = Field25519.expand(bArr);
            long[] jArr2 = new long[10];
            jArr2[0] = 1;
            long[] jArr3 = new long[10];
            long[] jArr4 = new long[10];
            long[] jArr5 = new long[10];
            long[] jArr6 = new long[10];
            long[] jArr7 = new long[10];
            Field25519.square(jArr4, jArrExpand);
            Field25519.mult(jArr5, jArr4, Ed25519Constants.D);
            Field25519.sub(jArr4, jArr4, jArr2);
            Field25519.sum(jArr5, jArr5, jArr2);
            long[] jArr8 = new long[10];
            Field25519.square(jArr8, jArr5);
            Field25519.mult(jArr8, jArr8, jArr5);
            Field25519.square(jArr, jArr8);
            Field25519.mult(jArr, jArr, jArr5);
            Field25519.mult(jArr, jArr, jArr4);
            Ed25519.pow2252m3(jArr, jArr);
            Field25519.mult(jArr, jArr, jArr8);
            Field25519.mult(jArr, jArr, jArr4);
            Field25519.square(jArr6, jArr);
            Field25519.mult(jArr6, jArr6, jArr5);
            Field25519.sub(jArr7, jArr6, jArr4);
            if (Ed25519.isNonZeroVarTime(jArr7)) {
                Field25519.sum(jArr7, jArr6, jArr4);
                if (Ed25519.isNonZeroVarTime(jArr7)) {
                    throw new GeneralSecurityException("Cannot convert given bytes to extended projective coordinates. No square root exists for modulo 2^255-19");
                }
                Field25519.mult(jArr, jArr, Ed25519Constants.SQRTM1);
            }
            if (Ed25519.isNonZeroVarTime(jArr) || ((bArr[31] & 255) >> 7) == 0) {
                if (Ed25519.getLsb(jArr) == ((bArr[31] & 255) >> 7)) {
                    Ed25519.neg(jArr, jArr);
                }
                Field25519.mult(jArr3, jArr, jArrExpand);
                return new XYZT(new XYZ(jArr, jArrExpand, jArr2), jArr3);
            }
            throw new GeneralSecurityException("Cannot convert given bytes to extended projective coordinates. Computed x is zero and encoded x's least significant bit is not zero");
        }
    }

    private static class PartialXYZT {
        final long[] t;
        final XYZ xyz;

        PartialXYZT() {
            this(new XYZ(), new long[10]);
        }

        PartialXYZT(XYZ xyz, long[] jArr) {
            this.xyz = xyz;
            this.t = jArr;
        }

        PartialXYZT(PartialXYZT partialXYZT) {
            this.xyz = new XYZ(partialXYZT.xyz);
            this.t = Arrays.copyOf(partialXYZT.t, 10);
        }
    }

    static class CachedXYT {
        final long[] t2d;
        final long[] yMinusX;
        final long[] yPlusX;

        CachedXYT(long[] jArr, long[] jArr2, long[] jArr3) {
            this.yPlusX = jArr;
            this.yMinusX = jArr2;
            this.t2d = jArr3;
        }

        void multByZ(long[] jArr, long[] jArr2) {
            System.arraycopy(jArr2, 0, jArr, 0, 10);
        }
    }

    private static class CachedXYZT extends CachedXYT {
        private final long[] z;

        CachedXYZT() {
            this(new long[10], new long[10], new long[10], new long[10]);
        }

        CachedXYZT(XYZT xyzt) {
            this();
            long[] jArr = this.yPlusX;
            XYZ xyz = xyzt.xyz;
            Field25519.sum(jArr, xyz.y, xyz.x);
            long[] jArr2 = this.yMinusX;
            XYZ xyz2 = xyzt.xyz;
            Field25519.sub(jArr2, xyz2.y, xyz2.x);
            System.arraycopy(xyzt.xyz.z, 0, this.z, 0, 10);
            Field25519.mult(this.t2d, xyzt.t, Ed25519Constants.D2);
        }

        CachedXYZT(long[] jArr, long[] jArr2, long[] jArr3, long[] jArr4) {
            super(jArr, jArr2, jArr4);
            this.z = jArr3;
        }

        @Override // com.google.crypto.tink.subtle.Ed25519.CachedXYT
        public void multByZ(long[] jArr, long[] jArr2) {
            Field25519.mult(jArr, jArr2, this.z);
        }
    }

    private static void add(PartialXYZT partialXYZT, XYZT xyzt, CachedXYT cachedXYT) {
        long[] jArr = new long[10];
        long[] jArr2 = partialXYZT.xyz.x;
        XYZ xyz = xyzt.xyz;
        Field25519.sum(jArr2, xyz.y, xyz.x);
        long[] jArr3 = partialXYZT.xyz.y;
        XYZ xyz2 = xyzt.xyz;
        Field25519.sub(jArr3, xyz2.y, xyz2.x);
        long[] jArr4 = partialXYZT.xyz.y;
        Field25519.mult(jArr4, jArr4, cachedXYT.yMinusX);
        XYZ xyz3 = partialXYZT.xyz;
        Field25519.mult(xyz3.z, xyz3.x, cachedXYT.yPlusX);
        Field25519.mult(partialXYZT.t, xyzt.t, cachedXYT.t2d);
        cachedXYT.multByZ(partialXYZT.xyz.x, xyzt.xyz.z);
        long[] jArr5 = partialXYZT.xyz.x;
        Field25519.sum(jArr, jArr5, jArr5);
        XYZ xyz4 = partialXYZT.xyz;
        Field25519.sub(xyz4.x, xyz4.z, xyz4.y);
        XYZ xyz5 = partialXYZT.xyz;
        long[] jArr6 = xyz5.y;
        Field25519.sum(jArr6, xyz5.z, jArr6);
        Field25519.sum(partialXYZT.xyz.z, jArr, partialXYZT.t);
        long[] jArr7 = partialXYZT.t;
        Field25519.sub(jArr7, jArr, jArr7);
    }

    private static void sub(PartialXYZT partialXYZT, XYZT xyzt, CachedXYT cachedXYT) {
        long[] jArr = new long[10];
        long[] jArr2 = partialXYZT.xyz.x;
        XYZ xyz = xyzt.xyz;
        Field25519.sum(jArr2, xyz.y, xyz.x);
        long[] jArr3 = partialXYZT.xyz.y;
        XYZ xyz2 = xyzt.xyz;
        Field25519.sub(jArr3, xyz2.y, xyz2.x);
        long[] jArr4 = partialXYZT.xyz.y;
        Field25519.mult(jArr4, jArr4, cachedXYT.yPlusX);
        XYZ xyz3 = partialXYZT.xyz;
        Field25519.mult(xyz3.z, xyz3.x, cachedXYT.yMinusX);
        Field25519.mult(partialXYZT.t, xyzt.t, cachedXYT.t2d);
        cachedXYT.multByZ(partialXYZT.xyz.x, xyzt.xyz.z);
        long[] jArr5 = partialXYZT.xyz.x;
        Field25519.sum(jArr, jArr5, jArr5);
        XYZ xyz4 = partialXYZT.xyz;
        Field25519.sub(xyz4.x, xyz4.z, xyz4.y);
        XYZ xyz5 = partialXYZT.xyz;
        long[] jArr6 = xyz5.y;
        Field25519.sum(jArr6, xyz5.z, jArr6);
        Field25519.sub(partialXYZT.xyz.z, jArr, partialXYZT.t);
        long[] jArr7 = partialXYZT.t;
        Field25519.sum(jArr7, jArr, jArr7);
    }

    private static void doubleXYZ(PartialXYZT partialXYZT, XYZ xyz) {
        long[] jArr = new long[10];
        Field25519.square(partialXYZT.xyz.x, xyz.x);
        Field25519.square(partialXYZT.xyz.z, xyz.y);
        Field25519.square(partialXYZT.t, xyz.z);
        long[] jArr2 = partialXYZT.t;
        Field25519.sum(jArr2, jArr2, jArr2);
        Field25519.sum(partialXYZT.xyz.y, xyz.x, xyz.y);
        Field25519.square(jArr, partialXYZT.xyz.y);
        XYZ xyz2 = partialXYZT.xyz;
        Field25519.sum(xyz2.y, xyz2.z, xyz2.x);
        XYZ xyz3 = partialXYZT.xyz;
        long[] jArr3 = xyz3.z;
        Field25519.sub(jArr3, jArr3, xyz3.x);
        XYZ xyz4 = partialXYZT.xyz;
        Field25519.sub(xyz4.x, jArr, xyz4.y);
        long[] jArr4 = partialXYZT.t;
        Field25519.sub(jArr4, jArr4, partialXYZT.xyz.z);
    }

    private static void doubleXYZT(PartialXYZT partialXYZT, XYZT xyzt) {
        doubleXYZ(partialXYZT, xyzt.xyz);
    }

    private static byte[] slide(byte[] bArr) {
        int i;
        byte[] bArr2 = new byte[IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER];
        for (int i2 = 0; i2 < 256; i2++) {
            bArr2[i2] = (byte) (1 & ((bArr[i2 >> 3] & 255) >> (i2 & 7)));
        }
        for (int i3 = 0; i3 < 256; i3++) {
            if (bArr2[i3] != 0) {
                for (int i4 = 1; i4 <= 6 && (i = i3 + i4) < 256; i4++) {
                    byte b = bArr2[i];
                    if (b != 0) {
                        byte b2 = bArr2[i3];
                        if ((b << i4) + b2 <= 15) {
                            bArr2[i3] = (byte) (b2 + (b << i4));
                            bArr2[i] = 0;
                        } else {
                            if (b2 - (b << i4) < -15) {
                                break;
                            }
                            bArr2[i3] = (byte) (b2 - (b << i4));
                            while (i < 256) {
                                if (bArr2[i] == 0) {
                                    bArr2[i] = 1;
                                    break;
                                }
                                bArr2[i] = 0;
                                i++;
                            }
                        }
                    }
                }
            }
        }
        return bArr2;
    }

    private static XYZ doubleScalarMultVarTime(byte[] bArr, XYZT xyzt, byte[] bArr2) {
        CachedXYZT[] cachedXYZTArr = new CachedXYZT[8];
        cachedXYZTArr[0] = new CachedXYZT(xyzt);
        PartialXYZT partialXYZT = new PartialXYZT();
        doubleXYZT(partialXYZT, xyzt);
        XYZT xyzt2 = new XYZT(partialXYZT);
        for (int i = 1; i < 8; i++) {
            add(partialXYZT, xyzt2, cachedXYZTArr[i - 1]);
            cachedXYZTArr[i] = new CachedXYZT(new XYZT(partialXYZT));
        }
        byte[] bArrSlide = slide(bArr);
        byte[] bArrSlide2 = slide(bArr2);
        PartialXYZT partialXYZT2 = new PartialXYZT(NEUTRAL);
        XYZT xyzt3 = new XYZT();
        int i2 = 255;
        while (i2 >= 0 && bArrSlide[i2] == 0 && bArrSlide2[i2] == 0) {
            i2--;
        }
        while (i2 >= 0) {
            doubleXYZ(partialXYZT2, new XYZ(partialXYZT2));
            byte b = bArrSlide[i2];
            if (b > 0) {
                add(partialXYZT2, XYZT.fromPartialXYZT(xyzt3, partialXYZT2), cachedXYZTArr[bArrSlide[i2] / 2]);
            } else if (b < 0) {
                sub(partialXYZT2, XYZT.fromPartialXYZT(xyzt3, partialXYZT2), cachedXYZTArr[(-bArrSlide[i2]) / 2]);
            }
            byte b2 = bArrSlide2[i2];
            if (b2 > 0) {
                add(partialXYZT2, XYZT.fromPartialXYZT(xyzt3, partialXYZT2), Ed25519Constants.B2[bArrSlide2[i2] / 2]);
            } else if (b2 < 0) {
                sub(partialXYZT2, XYZT.fromPartialXYZT(xyzt3, partialXYZT2), Ed25519Constants.B2[(-bArrSlide2[i2]) / 2]);
            }
            i2--;
        }
        return new XYZ(partialXYZT2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isNonZeroVarTime(long[] jArr) {
        long[] jArr2 = new long[jArr.length + 1];
        System.arraycopy(jArr, 0, jArr2, 0, jArr.length);
        Field25519.reduceCoefficients(jArr2);
        for (byte b : Field25519.contract(jArr2)) {
            if (b != 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getLsb(long[] jArr) {
        return Field25519.contract(jArr)[0] & 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void neg(long[] jArr, long[] jArr2) {
        for (int i = 0; i < jArr2.length; i++) {
            jArr[i] = -jArr2[i];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void pow2252m3(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[10];
        long[] jArr4 = new long[10];
        long[] jArr5 = new long[10];
        Field25519.square(jArr3, jArr2);
        Field25519.square(jArr4, jArr3);
        Field25519.square(jArr4, jArr4);
        Field25519.mult(jArr4, jArr2, jArr4);
        Field25519.mult(jArr3, jArr3, jArr4);
        Field25519.square(jArr3, jArr3);
        Field25519.mult(jArr3, jArr4, jArr3);
        Field25519.square(jArr4, jArr3);
        for (int i = 1; i < 5; i++) {
            Field25519.square(jArr4, jArr4);
        }
        Field25519.mult(jArr3, jArr4, jArr3);
        Field25519.square(jArr4, jArr3);
        for (int i2 = 1; i2 < 10; i2++) {
            Field25519.square(jArr4, jArr4);
        }
        Field25519.mult(jArr4, jArr4, jArr3);
        Field25519.square(jArr5, jArr4);
        for (int i3 = 1; i3 < 20; i3++) {
            Field25519.square(jArr5, jArr5);
        }
        Field25519.mult(jArr4, jArr5, jArr4);
        Field25519.square(jArr4, jArr4);
        for (int i4 = 1; i4 < 10; i4++) {
            Field25519.square(jArr4, jArr4);
        }
        Field25519.mult(jArr3, jArr4, jArr3);
        Field25519.square(jArr4, jArr3);
        for (int i5 = 1; i5 < 50; i5++) {
            Field25519.square(jArr4, jArr4);
        }
        Field25519.mult(jArr4, jArr4, jArr3);
        Field25519.square(jArr5, jArr4);
        for (int i6 = 1; i6 < 100; i6++) {
            Field25519.square(jArr5, jArr5);
        }
        Field25519.mult(jArr4, jArr5, jArr4);
        Field25519.square(jArr4, jArr4);
        for (int i7 = 1; i7 < 50; i7++) {
            Field25519.square(jArr4, jArr4);
        }
        Field25519.mult(jArr3, jArr4, jArr3);
        Field25519.square(jArr3, jArr3);
        Field25519.square(jArr3, jArr3);
        Field25519.mult(jArr, jArr3, jArr2);
    }

    private static long load3(byte[] bArr, int i) {
        return (((long) (bArr[i + 2] & 255)) << 16) | (((long) bArr[i]) & 255) | (((long) (bArr[i + 1] & 255)) << 8);
    }

    private static long load4(byte[] bArr, int i) {
        return (((long) (bArr[i + 3] & 255)) << 24) | load3(bArr, i);
    }

    private static void reduce(byte[] bArr) {
        long jLoad3 = load3(bArr, 0) & 2097151;
        long jLoad4 = (load4(bArr, 2) >> 5) & 2097151;
        long jLoad5 = (load3(bArr, 5) >> 2) & 2097151;
        long jLoad6 = (load4(bArr, 7) >> 7) & 2097151;
        long jLoad7 = (load4(bArr, 10) >> 4) & 2097151;
        long jLoad8 = (load3(bArr, 13) >> 1) & 2097151;
        long jLoad9 = (load4(bArr, 15) >> 6) & 2097151;
        long jLoad10 = (load3(bArr, 18) >> 3) & 2097151;
        long jLoad11 = load3(bArr, 21) & 2097151;
        long jLoad12 = (load4(bArr, 23) >> 5) & 2097151;
        long jLoad13 = (load3(bArr, 26) >> 2) & 2097151;
        long jLoad14 = (load4(bArr, 28) >> 7) & 2097151;
        long jLoad15 = (load4(bArr, 31) >> 4) & 2097151;
        long jLoad16 = (load3(bArr, 34) >> 1) & 2097151;
        long jLoad17 = (load4(bArr, 36) >> 6) & 2097151;
        long jLoad18 = (load3(bArr, 39) >> 3) & 2097151;
        long jLoad19 = load3(bArr, 42) & 2097151;
        long jLoad20 = (load4(bArr, 44) >> 5) & 2097151;
        long jLoad21 = (load3(bArr, 47) >> 2) & 2097151;
        long jLoad22 = (load4(bArr, 49) >> 7) & 2097151;
        long jLoad23 = (load4(bArr, 52) >> 4) & 2097151;
        long jLoad24 = (load3(bArr, 55) >> 1) & 2097151;
        long jLoad25 = (load4(bArr, 57) >> 6) & 2097151;
        long jLoad26 = load4(bArr, 60) >> 3;
        long j = jLoad19 - (jLoad26 * 683901);
        long j2 = ((jLoad17 - (jLoad26 * 997805)) + (jLoad25 * 136657)) - (jLoad24 * 683901);
        long j3 = ((((jLoad15 + (jLoad26 * 470296)) + (jLoad25 * 654183)) - (jLoad24 * 997805)) + (jLoad23 * 136657)) - (jLoad22 * 683901);
        long j4 = jLoad9 + (jLoad21 * 666643);
        long j5 = jLoad10 + (jLoad22 * 666643) + (jLoad21 * 470296);
        long j6 = jLoad11 + (jLoad23 * 666643) + (jLoad22 * 470296) + (jLoad21 * 654183);
        long j7 = (((jLoad12 + (jLoad24 * 666643)) + (jLoad23 * 470296)) + (jLoad22 * 654183)) - (jLoad21 * 997805);
        long j8 = ((((jLoad13 + (jLoad25 * 666643)) + (jLoad24 * 470296)) + (jLoad23 * 654183)) - (jLoad22 * 997805)) + (jLoad21 * 136657);
        long j9 = (((((jLoad14 + (jLoad26 * 666643)) + (jLoad25 * 470296)) + (jLoad24 * 654183)) - (jLoad23 * 997805)) + (jLoad22 * 136657)) - (jLoad21 * 683901);
        long j10 = (j4 + SentryOptions.MAX_EVENT_SIZE_BYTES) >> 21;
        long j11 = j5 + j10;
        long j12 = j4 - (j10 << 21);
        long j13 = (j6 + SentryOptions.MAX_EVENT_SIZE_BYTES) >> 21;
        long j14 = j7 + j13;
        long j15 = j6 - (j13 << 21);
        long j16 = (j8 + SentryOptions.MAX_EVENT_SIZE_BYTES) >> 21;
        long j17 = j9 + j16;
        long j18 = j8 - (j16 << 21);
        long j19 = (j3 + SentryOptions.MAX_EVENT_SIZE_BYTES) >> 21;
        long j20 = ((((jLoad16 + (jLoad26 * 654183)) - (jLoad25 * 997805)) + (jLoad24 * 136657)) - (jLoad23 * 683901)) + j19;
        long j21 = j3 - (j19 << 21);
        long j22 = (j2 + SentryOptions.MAX_EVENT_SIZE_BYTES) >> 21;
        long j23 = ((jLoad18 + (jLoad26 * 136657)) - (jLoad25 * 683901)) + j22;
        long j24 = j2 - (j22 << 21);
        long j25 = (j + SentryOptions.MAX_EVENT_SIZE_BYTES) >> 21;
        long j26 = jLoad20 + j25;
        long j27 = j - (j25 << 21);
        long j28 = (j11 + SentryOptions.MAX_EVENT_SIZE_BYTES) >> 21;
        long j29 = j15 + j28;
        long j30 = j11 - (j28 << 21);
        long j31 = (j14 + SentryOptions.MAX_EVENT_SIZE_BYTES) >> 21;
        long j32 = j18 + j31;
        long j33 = j14 - (j31 << 21);
        long j34 = (j17 + SentryOptions.MAX_EVENT_SIZE_BYTES) >> 21;
        long j35 = j21 + j34;
        long j36 = j17 - (j34 << 21);
        long j37 = (j20 + SentryOptions.MAX_EVENT_SIZE_BYTES) >> 21;
        long j38 = j24 + j37;
        long j39 = j20 - (j37 << 21);
        long j40 = (j23 + SentryOptions.MAX_EVENT_SIZE_BYTES) >> 21;
        long j41 = j27 + j40;
        long j42 = j23 - (j40 << 21);
        long j43 = j32 - (j26 * 683901);
        long j44 = ((j29 - (j26 * 997805)) + (j41 * 136657)) - (j42 * 683901);
        long j45 = ((((j12 + (j26 * 470296)) + (j41 * 654183)) - (j42 * 997805)) + (j38 * 136657)) - (j39 * 683901);
        long j46 = jLoad3 + (j35 * 666643);
        long j47 = jLoad4 + (j39 * 666643) + (j35 * 470296);
        long j48 = jLoad5 + (j38 * 666643) + (j39 * 470296) + (j35 * 654183);
        long j49 = (((jLoad6 + (j42 * 666643)) + (j38 * 470296)) + (j39 * 654183)) - (j35 * 997805);
        long j50 = ((((jLoad7 + (j41 * 666643)) + (j42 * 470296)) + (j38 * 654183)) - (j39 * 997805)) + (j35 * 136657);
        long j51 = (((((jLoad8 + (j26 * 666643)) + (j41 * 470296)) + (j42 * 654183)) - (j38 * 997805)) + (j39 * 136657)) - (j35 * 683901);
        long j52 = (j46 + SentryOptions.MAX_EVENT_SIZE_BYTES) >> 21;
        long j53 = j47 + j52;
        long j54 = j46 - (j52 << 21);
        long j55 = (j48 + SentryOptions.MAX_EVENT_SIZE_BYTES) >> 21;
        long j56 = j49 + j55;
        long j57 = j48 - (j55 << 21);
        long j58 = (j50 + SentryOptions.MAX_EVENT_SIZE_BYTES) >> 21;
        long j59 = j51 + j58;
        long j60 = j50 - (j58 << 21);
        long j61 = (j45 + SentryOptions.MAX_EVENT_SIZE_BYTES) >> 21;
        long j62 = ((((j30 + (j26 * 654183)) - (j41 * 997805)) + (j42 * 136657)) - (j38 * 683901)) + j61;
        long j63 = j45 - (j61 << 21);
        long j64 = (j44 + SentryOptions.MAX_EVENT_SIZE_BYTES) >> 21;
        long j65 = ((j33 + (j26 * 136657)) - (j41 * 683901)) + j64;
        long j66 = j44 - (j64 << 21);
        long j67 = (j43 + SentryOptions.MAX_EVENT_SIZE_BYTES) >> 21;
        long j68 = j36 + j67;
        long j69 = j43 - (j67 << 21);
        long j70 = (j53 + SentryOptions.MAX_EVENT_SIZE_BYTES) >> 21;
        long j71 = j57 + j70;
        long j72 = j53 - (j70 << 21);
        long j73 = (j56 + SentryOptions.MAX_EVENT_SIZE_BYTES) >> 21;
        long j74 = j60 + j73;
        long j75 = j56 - (j73 << 21);
        long j76 = (j59 + SentryOptions.MAX_EVENT_SIZE_BYTES) >> 21;
        long j77 = j63 + j76;
        long j78 = j59 - (j76 << 21);
        long j79 = (j62 + SentryOptions.MAX_EVENT_SIZE_BYTES) >> 21;
        long j80 = j66 + j79;
        long j81 = j62 - (j79 << 21);
        long j82 = (j65 + SentryOptions.MAX_EVENT_SIZE_BYTES) >> 21;
        long j83 = (j68 + SentryOptions.MAX_EVENT_SIZE_BYTES) >> 21;
        long j84 = j68 - (j83 << 21);
        long j85 = j54 + (j83 * 666643);
        long j86 = j72 + (j83 * 470296);
        long j87 = j71 + (j83 * 654183);
        long j88 = j75 - (j83 * 997805);
        long j89 = j74 + (j83 * 136657);
        long j90 = j78 - (j83 * 683901);
        long j91 = j85 >> 21;
        long j92 = j86 + j91;
        long j93 = j85 - (j91 << 21);
        long j94 = j92 >> 21;
        long j95 = j87 + j94;
        long j96 = j92 - (j94 << 21);
        long j97 = j95 >> 21;
        long j98 = j88 + j97;
        long j99 = j95 - (j97 << 21);
        long j100 = j98 >> 21;
        long j101 = j89 + j100;
        long j102 = j98 - (j100 << 21);
        long j103 = j101 >> 21;
        long j104 = j90 + j103;
        long j105 = j101 - (j103 << 21);
        long j106 = j104 >> 21;
        long j107 = j77 + j106;
        long j108 = j104 - (j106 << 21);
        long j109 = j107 >> 21;
        long j110 = j81 + j109;
        long j111 = j107 - (j109 << 21);
        long j112 = j110 >> 21;
        long j113 = j80 + j112;
        long j114 = j110 - (j112 << 21);
        long j115 = j113 >> 21;
        long j116 = (j65 - (j82 << 21)) + j115;
        long j117 = j113 - (j115 << 21);
        long j118 = j116 >> 21;
        long j119 = j69 + j82 + j118;
        long j120 = j116 - (j118 << 21);
        long j121 = j119 >> 21;
        long j122 = j84 + j121;
        long j123 = j119 - (j121 << 21);
        long j124 = j122 >> 21;
        long j125 = j122 - (j124 << 21);
        long j126 = j93 + (666643 * j124);
        long j127 = j96 + (470296 * j124);
        long j128 = j99 + (654183 * j124);
        long j129 = j102 - (997805 * j124);
        long j130 = j105 + (136657 * j124);
        long j131 = j108 - (j124 * 683901);
        long j132 = j126 >> 21;
        long j133 = j127 + j132;
        long j134 = j126 - (j132 << 21);
        long j135 = j133 >> 21;
        long j136 = j128 + j135;
        long j137 = j133 - (j135 << 21);
        long j138 = j136 >> 21;
        long j139 = j129 + j138;
        long j140 = j136 - (j138 << 21);
        long j141 = j139 >> 21;
        long j142 = j130 + j141;
        long j143 = j139 - (j141 << 21);
        long j144 = j142 >> 21;
        long j145 = j131 + j144;
        long j146 = j142 - (j144 << 21);
        long j147 = j145 >> 21;
        long j148 = j111 + j147;
        long j149 = j145 - (j147 << 21);
        long j150 = j148 >> 21;
        long j151 = j114 + j150;
        long j152 = j148 - (j150 << 21);
        long j153 = j151 >> 21;
        long j154 = j117 + j153;
        long j155 = j151 - (j153 << 21);
        long j156 = j154 >> 21;
        long j157 = j120 + j156;
        long j158 = j154 - (j156 << 21);
        long j159 = j157 >> 21;
        long j160 = j123 + j159;
        long j161 = j157 - (j159 << 21);
        long j162 = j160 >> 21;
        long j163 = j125 + j162;
        long j164 = j160 - (j162 << 21);
        bArr[0] = (byte) j134;
        bArr[1] = (byte) (j134 >> 8);
        bArr[2] = (byte) ((j134 >> 16) | (j137 << 5));
        bArr[3] = (byte) (j137 >> 3);
        bArr[4] = (byte) (j137 >> 11);
        bArr[5] = (byte) ((j137 >> 19) | (j140 << 2));
        bArr[6] = (byte) (j140 >> 6);
        bArr[7] = (byte) ((j140 >> 14) | (j143 << 7));
        bArr[8] = (byte) (j143 >> 1);
        bArr[9] = (byte) (j143 >> 9);
        bArr[10] = (byte) ((j143 >> 17) | (j146 << 4));
        bArr[11] = (byte) (j146 >> 4);
        bArr[12] = (byte) (j146 >> 12);
        bArr[13] = (byte) ((j146 >> 20) | (j149 << 1));
        bArr[14] = (byte) (j149 >> 7);
        bArr[15] = (byte) ((j149 >> 15) | (j152 << 6));
        bArr[16] = (byte) (j152 >> 2);
        bArr[17] = (byte) (j152 >> 10);
        bArr[18] = (byte) ((j152 >> 18) | (j155 << 3));
        bArr[19] = (byte) (j155 >> 5);
        bArr[20] = (byte) (j155 >> 13);
        bArr[21] = (byte) j158;
        bArr[22] = (byte) (j158 >> 8);
        bArr[23] = (byte) ((j158 >> 16) | (j161 << 5));
        bArr[24] = (byte) (j161 >> 3);
        bArr[25] = (byte) (j161 >> 11);
        bArr[26] = (byte) ((j161 >> 19) | (j164 << 2));
        bArr[27] = (byte) (j164 >> 6);
        bArr[28] = (byte) ((j164 >> 14) | (j163 << 7));
        bArr[29] = (byte) (j163 >> 1);
        bArr[30] = (byte) (j163 >> 9);
        bArr[31] = (byte) (j163 >> 17);
    }

    private static boolean isSmallerThanGroupOrder(byte[] bArr) {
        for (int i = 31; i >= 0; i--) {
            int i2 = bArr[i] & 255;
            int i3 = GROUP_ORDER[i] & 255;
            if (i2 != i3) {
                return i2 < i3;
            }
        }
        return false;
    }

    static boolean verify(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr2.length != 64) {
            return false;
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr2, 32, 64);
        if (!isSmallerThanGroupOrder(bArrCopyOfRange)) {
            return false;
        }
        MessageDigest messageDigest = (MessageDigest) EngineFactory.MESSAGE_DIGEST.getInstance("SHA-512");
        messageDigest.update(bArr2, 0, 32);
        messageDigest.update(bArr3);
        messageDigest.update(bArr);
        byte[] bArrDigest = messageDigest.digest();
        reduce(bArrDigest);
        byte[] bytes = doubleScalarMultVarTime(bArrDigest, XYZT.fromBytesNegateVarTime(bArr3), bArrCopyOfRange).toBytes();
        for (int i = 0; i < 32; i++) {
            if (bytes[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }
}
