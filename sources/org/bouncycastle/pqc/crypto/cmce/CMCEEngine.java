package org.bouncycastle.pqc.crypto.cmce;

import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import java.lang.reflect.Array;
import org.bouncycastle.crypto.digests.SHAKEDigest;

/* JADX INFO: loaded from: classes5.dex */
class CMCEEngine {
    private int COND_BYTES;
    private int GFBITS;
    private int GFMASK;
    private int IRR_BYTES;
    private int PK_NCOLS;
    private int PK_NROWS;
    private int PK_ROW_BYTES;
    private int SYND_BYTES;
    private int SYS_N;
    private int SYS_T;
    private BENES benes;
    private boolean countErrorIndices;
    private final int defaultKeySize;
    private GF gf;
    private int[] poly;
    private boolean usePadding;
    private boolean usePivots;

    public CMCEEngine(int i, int i2, int i3, int[] iArr, boolean z, int i4) {
        BENES benes13;
        this.usePivots = z;
        this.SYS_N = i2;
        this.SYS_T = i3;
        this.GFBITS = i;
        this.poly = iArr;
        this.defaultKeySize = i4;
        this.IRR_BYTES = i3 * 2;
        this.COND_BYTES = (1 << (i - 4)) * ((i * 2) - 1);
        int i5 = i3 * i;
        this.PK_NROWS = i5;
        int i6 = i2 - i5;
        this.PK_NCOLS = i6;
        this.PK_ROW_BYTES = (i6 + 7) / 8;
        this.SYND_BYTES = (i5 + 7) / 8;
        this.GFMASK = (1 << i) - 1;
        if (i == 12) {
            this.gf = new GF12();
            benes13 = new BENES12(this.SYS_N, this.SYS_T, this.GFBITS);
        } else {
            this.gf = new GF13();
            benes13 = new BENES13(this.SYS_N, this.SYS_T, this.GFBITS);
        }
        this.benes = benes13;
        this.usePadding = this.SYS_T % 8 != 0;
        this.countErrorIndices = (1 << this.GFBITS) > this.SYS_N;
    }

    private static int ctz(long j) {
        long j2 = ~j;
        long j3 = 72340172838076673L;
        long j4 = 0;
        for (int i = 0; i < 8; i++) {
            j3 &= j2 >>> i;
            j4 += j3;
        }
        long j5 = 578721382704613384L & j4;
        long j6 = j5 | (j5 >>> 1);
        long j7 = j6 | (j6 >>> 2);
        long j8 = j4 >>> 8;
        long j9 = j4 + (j8 & j7);
        for (int i2 = 2; i2 < 8; i2++) {
            j7 &= j7 >>> 8;
            j8 >>>= 8;
            j9 += j8 & j7;
        }
        return ((int) j9) & 255;
    }

    private short eval(short[] sArr, short s) {
        int i = this.SYS_T;
        short sGf_mul = sArr[i];
        for (int i2 = i - 1; i2 >= 0; i2--) {
            sGf_mul = (short) (this.gf.gf_mul(sGf_mul, s) ^ sArr[i2]);
        }
        return sGf_mul;
    }

    private int mov_columns(byte[][] bArr, short[] sArr, long[] jArr) {
        long jLoad8;
        int i = 64;
        long[] jArr2 = new long[64];
        int i2 = 32;
        long[] jArr3 = new long[32];
        byte[] bArr2 = new byte[9];
        int i3 = this.PK_NROWS - 32;
        int i4 = i3 / 8;
        int i5 = i3 % 8;
        char c = 0;
        if (this.usePadding) {
            for (int i6 = 0; i6 < 32; i6++) {
                for (int i7 = 0; i7 < 9; i7++) {
                    bArr2[i7] = bArr[i3 + i6][i4 + i7];
                }
                int i8 = 0;
                while (i8 < 8) {
                    int i9 = i8 + 1;
                    bArr2[i8] = (byte) (((bArr2[i8] & 255) >> i5) | (bArr2[i9] << (8 - i5)));
                    i8 = i9;
                }
                jArr2[i6] = Utils.load8(bArr2, 0);
            }
        } else {
            for (int i10 = 0; i10 < 32; i10++) {
                jArr2[i10] = Utils.load8(bArr[i3 + i10], i4);
            }
        }
        long j = 0;
        jArr[0] = 0;
        int i11 = 0;
        while (true) {
            long j2 = 1;
            if (i11 >= 32) {
                int i12 = 0;
                while (i12 < i2) {
                    int i13 = i12 + 1;
                    int i14 = i13;
                    while (i14 < i) {
                        int i15 = i3 + i12;
                        int i16 = i3 + i14;
                        long[] jArr4 = jArr3;
                        long jSame_mask64 = ((long) (sArr[i15] ^ sArr[i16])) & same_mask64((short) i14, (short) jArr4[i12]);
                        sArr[i15] = (short) (((long) sArr[i15]) ^ jSame_mask64);
                        sArr[i16] = (short) (jSame_mask64 ^ ((long) sArr[i16]));
                        i14++;
                        i13 = i13;
                        jArr3 = jArr4;
                        i = 64;
                        i2 = 32;
                    }
                    i12 = i13;
                }
                long[] jArr5 = jArr3;
                for (int i17 = 0; i17 < this.PK_NROWS; i17++) {
                    if (this.usePadding) {
                        for (int i18 = 0; i18 < 9; i18++) {
                            bArr2[i18] = bArr[i17][i4 + i18];
                        }
                        int i19 = 0;
                        while (i19 < 8) {
                            int i20 = i19 + 1;
                            bArr2[i19] = (byte) (((bArr2[i19] & 255) >> i5) | (bArr2[i20] << (8 - i5)));
                            i19 = i20;
                        }
                        jLoad8 = Utils.load8(bArr2, 0);
                    } else {
                        jLoad8 = Utils.load8(bArr[i17], i4);
                    }
                    for (int i21 = 0; i21 < 32; i21++) {
                        long j3 = jArr5[i21];
                        long j4 = ((jLoad8 >> i21) ^ (jLoad8 >> ((int) j3))) & 1;
                        jLoad8 = (jLoad8 ^ (j4 << ((int) j3))) ^ (j4 << i21);
                    }
                    if (this.usePadding) {
                        Utils.store8(bArr2, 0, jLoad8);
                        byte[] bArr3 = bArr[i17];
                        int i22 = i4 + 8;
                        int i23 = 8 - i5;
                        bArr3[i22] = (byte) ((((bArr3[i22] & 255) >>> i5) << i5) | ((bArr2[7] & 255) >>> i23));
                        bArr3[i4] = (byte) (((bArr2[0] & 255) << i5) | (((bArr3[i4] & 255) << i23) >>> i23));
                        for (int i24 = 7; i24 >= 1; i24--) {
                            bArr[i17][i4 + i24] = (byte) (((bArr2[i24] & 255) << i5) | ((bArr2[i24 - 1] & 255) >>> i23));
                        }
                    } else {
                        Utils.store8(bArr[i17], i4, jLoad8);
                    }
                }
                return 0;
            }
            long j5 = jArr2[i11];
            int i25 = i11 + 1;
            long j6 = j;
            for (int i26 = i25; i26 < 32; i26++) {
                j5 |= jArr2[i26];
            }
            if (j5 == j6) {
                return -1;
            }
            int iCtz = ctz(j5);
            char c2 = c;
            long j7 = iCtz;
            jArr3[i11] = j7;
            jArr[c2] = jArr[c2] | (1 << ((int) j7));
            for (int i27 = i25; i27 < 32; i27++) {
                long j8 = jArr2[i11];
                jArr2[i11] = j8 ^ (jArr2[i27] & (((j8 >> iCtz) & 1) - 1));
            }
            int i28 = i25;
            while (i28 < 32) {
                long j9 = jArr2[i28];
                long j10 = j2;
                jArr2[i28] = j9 ^ (jArr2[i11] & (-((j9 >> iCtz) & j10)));
                i28++;
                j2 = j10;
                c2 = 0;
            }
            c = c2;
            i11 = i25;
            j = j6;
        }
    }

    private int pk_gen(byte[] bArr, byte[] bArr2, int[] iArr, short[] sArr, long[] jArr) {
        int i;
        int i2;
        int i3 = this.SYS_T;
        short[] sArr2 = new short[i3 + 1];
        byte b = 1;
        sArr2[i3] = 1;
        for (int i4 = 0; i4 < this.SYS_T; i4++) {
            sArr2[i4] = Utils.load_gf(bArr2, (i4 * 2) + 40, this.GFMASK);
        }
        int i5 = 1 << this.GFBITS;
        long[] jArr2 = new long[i5];
        for (int i6 = 0; i6 < (1 << this.GFBITS); i6++) {
            long j = iArr[i6];
            jArr2[i6] = j;
            long j2 = j << 31;
            jArr2[i6] = j2;
            long j3 = j2 | ((long) i6);
            jArr2[i6] = j3;
            jArr2[i6] = j3 & Long.MAX_VALUE;
        }
        sort64(jArr2, 0, i5);
        for (int i7 = 1; i7 < (1 << this.GFBITS); i7++) {
            if ((jArr2[i7 - 1] >> 31) == (jArr2[i7] >> 31)) {
                return -1;
            }
        }
        short[] sArr3 = new short[this.SYS_N];
        for (int i8 = 0; i8 < (1 << this.GFBITS); i8++) {
            sArr[i8] = (short) (jArr2[i8] & ((long) this.GFMASK));
        }
        int i9 = 0;
        while (true) {
            i = this.SYS_N;
            if (i9 >= i) {
                break;
            }
            sArr3[i9] = Utils.bitrev(sArr[i9], this.GFBITS);
            i9++;
        }
        short[] sArr4 = new short[i];
        root(sArr4, sArr2, sArr3);
        int i10 = 0;
        while (true) {
            i2 = this.SYS_N;
            if (i10 >= i2) {
                break;
            }
            sArr4[i10] = this.gf.gf_inv(sArr4[i10]);
            i10++;
        }
        byte[][] bArr3 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, this.PK_NROWS, i2 / 8);
        for (int i11 = 0; i11 < this.PK_NROWS; i11++) {
            for (int i12 = 0; i12 < this.SYS_N / 8; i12++) {
                bArr3[i11][i12] = 0;
            }
        }
        int i13 = 0;
        while (i13 < this.SYS_T) {
            for (int i14 = 0; i14 < this.SYS_N; i14 += 8) {
                int i15 = 0;
                while (true) {
                    int i16 = this.GFBITS;
                    if (i15 < i16) {
                        bArr3[(i16 * i13) + i15][i14 / 8] = (byte) (((byte) (((byte) (((byte) (((byte) (((byte) (((byte) (((byte) (((byte) (((byte) (((byte) (((byte) (((byte) (((byte) (((byte) ((sArr4[i14 + 7] >>> i15) & 1)) << 1)) | ((sArr4[i14 + 6] >>> i15) & 1))) << 1)) | ((sArr4[i14 + 5] >>> i15) & 1))) << 1)) | ((sArr4[i14 + 4] >>> i15) & 1))) << 1)) | ((sArr4[i14 + 3] >>> i15) & 1))) << 1)) | ((sArr4[i14 + 2] >>> i15) & 1))) << 1)) | ((sArr4[i14 + 1] >>> i15) & 1))) << 1)) | ((sArr4[i14] >>> i15) & 1));
                        i15++;
                    }
                }
            }
            for (int i17 = 0; i17 < this.SYS_N; i17++) {
                sArr4[i17] = this.gf.gf_mul(sArr4[i17], sArr3[i17]);
            }
            i13++;
        }
        int i18 = 0;
        while (true) {
            int i19 = this.PK_NROWS;
            if (i18 >= i19) {
                if (bArr != null) {
                    if (!this.usePadding) {
                        int i20 = ((this.SYS_N - i19) + 7) / 8;
                        int i21 = 0;
                        while (true) {
                            int i22 = this.PK_NROWS;
                            if (i21 >= i22) {
                                break;
                            }
                            System.arraycopy(bArr3[i21], i22 / 8, bArr, i20 * i21, i20);
                            i21++;
                        }
                    } else {
                        int i23 = i19 % 8;
                        if (i23 != 0) {
                            int i24 = 0;
                            int i25 = 0;
                            while (true) {
                                int i26 = this.PK_NROWS;
                                if (i24 >= i26) {
                                    break;
                                }
                                int i27 = (i26 - 1) / 8;
                                while (i27 < (this.SYS_N / 8) - 1) {
                                    byte[] bArr4 = bArr3[i24];
                                    int i28 = (bArr4[i27] & 255) >>> i23;
                                    i27++;
                                    bArr[i25] = (byte) ((bArr4[i27] << (8 - i23)) | i28);
                                    i25++;
                                }
                                bArr[i25] = (byte) ((bArr3[i24][i27] & 255) >>> i23);
                                i24++;
                                i25++;
                            }
                        } else {
                            System.arraycopy(bArr3[i13], (i19 - 1) / 8, bArr, 0, this.SYS_N / 8);
                        }
                    }
                }
                return 0;
            }
            i13 = i18 >>> 3;
            int i29 = i18 & 7;
            if (this.usePivots && i18 == i19 - 32) {
                if (mov_columns(bArr3, sArr, jArr) != 0) {
                    return -1;
                }
            }
            int i30 = i18 + 1;
            for (int i31 = i30; i31 < this.PK_NROWS; i31++) {
                byte b2 = (byte) (-((byte) (((byte) (((byte) (bArr3[i18][i13] ^ bArr3[i31][i13])) >> i29)) & b)));
                int i32 = 0;
                while (i32 < this.SYS_N / 8) {
                    byte[] bArr5 = bArr3[i18];
                    bArr5[i32] = (byte) (bArr5[i32] ^ (bArr3[i31][i32] & b2));
                    i32++;
                    b = b;
                }
            }
            byte b3 = b;
            if (((bArr3[i18][i13] >> i29) & 1) == 0) {
                return -1;
            }
            for (int i33 = 0; i33 < this.PK_NROWS; i33++) {
                if (i33 != i18) {
                    byte b4 = (byte) (-((byte) (((byte) (bArr3[i33][i13] >> i29)) & 1)));
                    for (int i34 = 0; i34 < this.SYS_N / 8; i34++) {
                        byte[] bArr6 = bArr3[i33];
                        bArr6[i34] = (byte) (bArr6[i34] ^ (bArr3[i18][i34] & b4));
                    }
                }
            }
            i18 = i30;
            b = b3;
        }
    }

    private void root(short[] sArr, short[] sArr2, short[] sArr3) {
        for (int i = 0; i < this.SYS_N; i++) {
            sArr[i] = eval(sArr2, sArr3[i]);
        }
    }

    private static long same_mask64(short s, short s2) {
        return -((((long) (s ^ s2)) - 1) >>> 63);
    }

    private static void sort64(long[] jArr, int i, int i2) {
        int i3 = i2 - i;
        if (i3 < 2) {
            return;
        }
        int i4 = 1;
        while (i4 < i3 - i4) {
            i4 += i4;
        }
        for (int i5 = i4; i5 > 0; i5 >>>= 1) {
            int i6 = 0;
            for (int i7 = 0; i7 < i3 - i5; i7++) {
                if ((i7 & i5) == 0) {
                    int i8 = i + i7;
                    int i9 = i8 + i5;
                    long j = jArr[i9];
                    long j2 = jArr[i8];
                    long j3 = (j ^ j2) & (-((j - j2) >>> 63));
                    jArr[i8] = j2 ^ j3;
                    jArr[i9] = jArr[i9] ^ j3;
                }
            }
            for (int i10 = i4; i10 > i5; i10 >>>= 1) {
                while (i6 < i3 - i10) {
                    if ((i6 & i5) == 0) {
                        int i11 = i + i6;
                        int i12 = i11 + i5;
                        long j4 = jArr[i12];
                        for (int i13 = i10; i13 > i5; i13 >>>= 1) {
                            int i14 = i11 + i13;
                            long j5 = jArr[i14];
                            long j6 = (-((j5 - j4) >>> 63)) & (j4 ^ j5);
                            j4 ^= j6;
                            jArr[i14] = j5 ^ j6;
                        }
                        jArr[i12] = j4;
                    }
                    i6++;
                }
            }
        }
    }

    public byte[] generate_public_key_from_private_key(byte[] bArr) {
        byte[] bArr2 = new byte[getPublicKeySize()];
        int i = this.GFBITS;
        short[] sArr = new short[1 << i];
        long[] jArr = {0};
        int[] iArr = new int[1 << i];
        int i2 = (this.SYS_N / 8) + ((1 << i) * 4);
        byte[] bArr3 = new byte[i2];
        int i3 = ((i2 - 32) - this.IRR_BYTES) - ((1 << i) * 4);
        SHAKEDigest sHAKEDigest = new SHAKEDigest(IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER);
        sHAKEDigest.update((byte) 64);
        sHAKEDigest.update(bArr, 0, 32);
        sHAKEDigest.doFinal(bArr3, 0, i2);
        for (int i4 = 0; i4 < (1 << this.GFBITS); i4++) {
            iArr[i4] = Utils.load4(bArr3, (i4 * 4) + i3);
        }
        pk_gen(bArr2, bArr, iArr, sArr, jArr);
        return bArr2;
    }

    public int getPublicKeySize() {
        if (!this.usePadding) {
            return (this.PK_NROWS * this.PK_NCOLS) / 8;
        }
        int i = this.PK_NROWS;
        return i * ((this.SYS_N / 8) - ((i - 1) / 8));
    }
}
