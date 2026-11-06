package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.CryptoServicePurpose;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes5.dex */
public abstract class LongDigest implements Digest {
    static final long[] K = {4794697086780616226L, 8158064640168781261L, -5349999486874862801L, -1606136188198331460L, 4131703408338449720L, 6480981068601479193L, -7908458776815382629L, -6116909921290321640L, -2880145864133508542L, 1334009975649890238L, 2608012711638119052L, 6128411473006802146L, 8268148722764581231L, -9160688886553864527L, -7215885187991268811L, -4495734319001033068L, -1973867731355612462L, -1171420211273849373L, 1135362057144423861L, 2597628984639134821L, 3308224258029322869L, 5365058923640841347L, 6679025012923562964L, 8573033837759648693L, -7476448914759557205L, -6327057829258317296L, -5763719355590565569L, -4658551843659510044L, -4116276920077217854L, -3051310485924567259L, 489312712824947311L, 1452737877330783856L, 2861767655752347644L, 3322285676063803686L, 5560940570517711597L, 5996557281743188959L, 7280758554555802590L, 8532644243296465576L, -9096487096722542874L, -7894198246740708037L, -6719396339535248540L, -6333637450476146687L, -4446306890439682159L, -4076793802049405392L, -3345356375505022440L, -2983346525034927856L, -860691631967231958L, 1182934255886127544L, 1847814050463011016L, 2177327727835720531L, 2830643537854262169L, 3796741975233480872L, 4115178125766777443L, 5681478168544905931L, 6601373596472566643L, 7507060721942968483L, 8399075790359081724L, 8693463985226723168L, -8878714635349349518L, -8302665154208450068L, -8016688836872298968L, -6606660893046293015L, -4685533653050689259L, -4147400797238176981L, -3880063495543823972L, -3348786107499101689L, -1523767162380948706L, -757361751448694408L, 500013540394364858L, 748580250866718886L, 1242879168328830382L, 1977374033974150939L, 2944078676154940804L, 3659926193048069267L, 4368137639120453308L, 4836135668995329356L, 5532061633213252278L, 6448918945643986474L, 6902733635092675308L, 7801388544844847127L};
    protected long H1;
    protected long H2;
    protected long H3;
    protected long H4;
    protected long H5;
    protected long H6;
    protected long H7;
    protected long H8;
    private long byteCount1;
    private long byteCount2;
    protected final CryptoServicePurpose purpose;
    private int wOff;
    private byte[] xBuf = new byte[8];
    private long[] W = new long[80];
    private int xBufOff = 0;

    protected LongDigest(CryptoServicePurpose cryptoServicePurpose) {
        this.purpose = cryptoServicePurpose;
        reset();
    }

    private long Ch(long j, long j2, long j3) {
        return ((~j) & j3) ^ (j2 & j);
    }

    private long Maj(long j, long j2, long j3) {
        return ((j & j3) ^ (j & j2)) ^ (j2 & j3);
    }

    private long Sigma0(long j) {
        return (j >>> 7) ^ (((j << 63) | (j >>> 1)) ^ ((j << 56) | (j >>> 8)));
    }

    private long Sigma1(long j) {
        return (j >>> 6) ^ (((j << 45) | (j >>> 19)) ^ ((j << 3) | (j >>> 61)));
    }

    private long Sum0(long j) {
        return ((j >>> 39) | (j << 25)) ^ (((j << 36) | (j >>> 28)) ^ ((j << 30) | (j >>> 34)));
    }

    private long Sum1(long j) {
        return ((j >>> 41) | (j << 23)) ^ (((j << 50) | (j >>> 14)) ^ ((j << 46) | (j >>> 18)));
    }

    private void adjustByteCounts() {
        long j = this.byteCount1;
        if (j > 2305843009213693951L) {
            this.byteCount2 += j >>> 61;
            this.byteCount1 = j & 2305843009213693951L;
        }
    }

    public void finish() {
        adjustByteCounts();
        long j = this.byteCount1 << 3;
        long j2 = this.byteCount2;
        byte b = -128;
        while (true) {
            update(b);
            if (this.xBufOff == 0) {
                processLength(j, j2);
                processBlock();
                return;
            }
            b = 0;
        }
    }

    protected void processBlock() {
        adjustByteCounts();
        for (int i = 16; i <= 79; i++) {
            long[] jArr = this.W;
            long jSigma1 = Sigma1(jArr[i - 2]);
            long[] jArr2 = this.W;
            jArr[i] = jSigma1 + jArr2[i - 7] + Sigma0(jArr2[i - 15]) + this.W[i - 16];
        }
        long j = this.H1;
        long j2 = this.H2;
        long j3 = this.H3;
        long j4 = this.H4;
        long j5 = this.H5;
        long j6 = j4;
        long j7 = this.H6;
        int i2 = 0;
        int i3 = 0;
        long j8 = j3;
        long j9 = this.H7;
        long j10 = this.H8;
        long jSum0 = j;
        long j11 = j5;
        long j12 = j2;
        while (i2 < 10) {
            long j13 = j7;
            long j14 = j11;
            long j15 = j9;
            long jSum1 = Sum1(j11) + Ch(j11, j13, j9);
            long[] jArr3 = K;
            int i4 = i3 + 1;
            long j16 = j10 + jSum1 + jArr3[i3] + this.W[i3];
            long j17 = j6 + j16;
            long j18 = jSum0;
            long j19 = j12;
            long j20 = j8;
            long jSum2 = j16 + Sum0(jSum0) + Maj(j18, j19, j20);
            int i5 = i3 + 2;
            long jSum3 = j15 + Sum1(j17) + Ch(j17, j14, j13) + jArr3[i4] + this.W[i4];
            long j21 = j20 + jSum3;
            long jSum4 = jSum3 + Sum0(jSum2) + Maj(jSum2, j18, j19);
            int i6 = i3 + 3;
            long jSum5 = j13 + Sum1(j21) + Ch(j21, j17, j14) + jArr3[i5] + this.W[i5];
            long j22 = j19 + jSum5;
            long jSum6 = jSum5 + Sum0(jSum4) + Maj(jSum4, jSum2, j18);
            int i7 = i3 + 4;
            long jSum7 = j14 + Sum1(j22) + Ch(j22, j21, j17) + jArr3[i6] + this.W[i6];
            long j23 = j18 + jSum7;
            long jSum8 = jSum7 + Sum0(jSum6) + Maj(jSum6, jSum4, jSum2);
            int i8 = i3 + 5;
            long jSum9 = j17 + Sum1(j23) + Ch(j23, j22, j21) + jArr3[i7] + this.W[i7];
            long j24 = jSum2 + jSum9;
            long jSum10 = jSum9 + Sum0(jSum8) + Maj(jSum8, jSum6, jSum4);
            int i9 = i3 + 6;
            long jSum11 = j21 + Sum1(j24) + Ch(j24, j23, j22) + jArr3[i8] + this.W[i8];
            long j25 = jSum4 + jSum11;
            long jSum12 = jSum11 + Sum0(jSum10) + Maj(jSum10, jSum8, jSum6);
            int i10 = i3 + 7;
            long jSum13 = j22 + Sum1(j25) + Ch(j25, j24, j23) + jArr3[i9] + this.W[i9];
            long j26 = jSum6 + jSum13;
            long jSum14 = jSum13 + Sum0(jSum12) + Maj(jSum12, jSum10, jSum8);
            i3 += 8;
            long jSum15 = j23 + Sum1(j26) + Ch(j26, j25, j24) + jArr3[i10] + this.W[i10];
            long j27 = jSum8 + jSum15;
            jSum0 = jSum15 + Sum0(jSum14) + Maj(jSum14, jSum12, jSum10);
            i2++;
            j12 = jSum14;
            j11 = j27;
            j8 = jSum12;
            j10 = j24;
            j7 = j26;
            j9 = j25;
            j6 = jSum10;
        }
        this.H1 += jSum0;
        this.H2 += j12;
        this.H3 += j8;
        this.H4 += j6;
        this.H5 += j11;
        this.H6 += j7;
        this.H7 += j9;
        this.H8 += j10;
        this.wOff = 0;
        for (int i11 = 0; i11 < 16; i11++) {
            this.W[i11] = 0;
        }
    }

    protected void processLength(long j, long j2) {
        if (this.wOff > 14) {
            processBlock();
        }
        long[] jArr = this.W;
        jArr[14] = j2;
        jArr[15] = j;
    }

    protected void processWord(byte[] bArr, int i) {
        this.W[this.wOff] = Pack.bigEndianToLong(bArr, i);
        int i2 = this.wOff + 1;
        this.wOff = i2;
        if (i2 == 16) {
            processBlock();
        }
    }

    public void reset() {
        this.byteCount1 = 0L;
        this.byteCount2 = 0L;
        int i = 0;
        this.xBufOff = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = this.xBuf;
            if (i2 >= bArr.length) {
                break;
            }
            bArr[i2] = 0;
            i2++;
        }
        this.wOff = 0;
        while (true) {
            long[] jArr = this.W;
            if (i == jArr.length) {
                return;
            }
            jArr[i] = 0;
            i++;
        }
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte b) {
        byte[] bArr = this.xBuf;
        int i = this.xBufOff;
        int i2 = i + 1;
        this.xBufOff = i2;
        bArr[i] = b;
        if (i2 == bArr.length) {
            processWord(bArr, 0);
            this.xBufOff = 0;
        }
        this.byteCount1++;
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte[] bArr, int i, int i2) {
        while (this.xBufOff != 0 && i2 > 0) {
            update(bArr[i]);
            i++;
            i2--;
        }
        while (i2 >= this.xBuf.length) {
            processWord(bArr, i);
            byte[] bArr2 = this.xBuf;
            i += bArr2.length;
            i2 -= bArr2.length;
            this.byteCount1 += (long) bArr2.length;
        }
        while (i2 > 0) {
            update(bArr[i]);
            i++;
            i2--;
        }
    }
}
