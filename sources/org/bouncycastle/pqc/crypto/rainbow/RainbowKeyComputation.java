package org.bouncycastle.pqc.crypto.rainbow;

import java.security.SecureRandom;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
class RainbowKeyComputation {
    private short[][][] l1_F1;
    private short[][][] l1_F2;
    private short[][][] l1_Q1;
    private short[][][] l1_Q2;
    private short[][][] l2_F1;
    private short[][][] l2_F2;
    private short[][][] l2_F3;
    private short[][][] l2_F5;
    private short[][][] l2_F6;
    private short[][][] l2_Q1;
    private short[][][] l2_Q2;
    private short[][][] l2_Q3;
    private short[][][] l2_Q5;
    private short[][][] l2_Q6;
    private int o1;
    private int o2;
    private byte[] pk_seed;
    private RainbowParameters rainbowParams;
    private short[][] s1;
    private byte[] sk_seed;
    private short[][] t1;
    private short[][] t2;
    private short[][] t3;
    private short[][] t4;
    private int v1;
    private Version version;
    ComputeInField cf = new ComputeInField();
    private SecureRandom random = null;

    public RainbowKeyComputation(RainbowParameters rainbowParameters, byte[] bArr, byte[] bArr2) {
        this.rainbowParams = rainbowParameters;
        this.version = rainbowParameters.getVersion();
        this.pk_seed = bArr;
        this.sk_seed = bArr2;
        this.v1 = this.rainbowParams.getV1();
        this.o1 = this.rainbowParams.getO1();
        this.o2 = this.rainbowParams.getO2();
    }

    private void calculate_F_from_Q() {
        this.l1_F1 = RainbowUtil.cloneArray(this.l1_Q1);
        this.l1_F2 = new short[this.o1][][];
        for (int i = 0; i < this.o1; i++) {
            this.l1_F2[i] = this.cf.addMatrixTranspose(this.l1_Q1[i]);
            short[][][] sArr = this.l1_F2;
            sArr[i] = this.cf.multiplyMatrix(sArr[i], this.t1);
            short[][][] sArr2 = this.l1_F2;
            sArr2[i] = this.cf.addMatrix(sArr2[i], this.l1_Q2[i]);
        }
        int i2 = this.o2;
        this.l2_F2 = new short[i2][][];
        this.l2_F3 = new short[i2][][];
        this.l2_F5 = new short[i2][][];
        this.l2_F6 = new short[i2][][];
        this.l2_F1 = RainbowUtil.cloneArray(this.l2_Q1);
        for (int i3 = 0; i3 < this.o2; i3++) {
            short[][] sArrAddMatrixTranspose = this.cf.addMatrixTranspose(this.l2_Q1[i3]);
            this.l2_F2[i3] = this.cf.multiplyMatrix(sArrAddMatrixTranspose, this.t1);
            short[][][] sArr3 = this.l2_F2;
            sArr3[i3] = this.cf.addMatrix(sArr3[i3], this.l2_Q2[i3]);
            this.l2_F3[i3] = this.cf.multiplyMatrix(sArrAddMatrixTranspose, this.t4);
            short[][] sArrMultiplyMatrix = this.cf.multiplyMatrix(this.l2_Q2[i3], this.t3);
            short[][][] sArr4 = this.l2_F3;
            sArr4[i3] = this.cf.addMatrix(sArr4[i3], sArrMultiplyMatrix);
            short[][][] sArr5 = this.l2_F3;
            sArr5[i3] = this.cf.addMatrix(sArr5[i3], this.l2_Q3[i3]);
            short[][] sArrAddMatrix = this.cf.addMatrix(this.cf.multiplyMatrix(this.l2_Q1[i3], this.t1), this.l2_Q2[i3]);
            short[][] sArrTranspose = this.cf.transpose(this.t1);
            this.l2_F5[i3] = this.cf.multiplyMatrix(sArrTranspose, sArrAddMatrix);
            short[][][] sArr6 = this.l2_F5;
            sArr6[i3] = this.cf.addMatrix(sArr6[i3], this.l2_Q5[i3]);
            short[][][] sArr7 = this.l2_F5;
            sArr7[i3] = this.cf.to_UT(sArr7[i3]);
            this.l2_F6[i3] = this.cf.multiplyMatrix(sArrTranspose, this.l2_F3[i3]);
            ComputeInField computeInField = this.cf;
            short[][] sArrMultiplyMatrix2 = computeInField.multiplyMatrix(computeInField.transpose(this.l2_Q2[i3]), this.t4);
            short[][][] sArr8 = this.l2_F6;
            sArr8[i3] = this.cf.addMatrix(sArr8[i3], sArrMultiplyMatrix2);
            short[][] sArrMultiplyMatrix3 = this.cf.multiplyMatrix(this.cf.addMatrixTranspose(this.l2_Q5[i3]), this.t3);
            short[][][] sArr9 = this.l2_F6;
            sArr9[i3] = this.cf.addMatrix(sArr9[i3], sArrMultiplyMatrix3);
            short[][][] sArr10 = this.l2_F6;
            sArr10[i3] = this.cf.addMatrix(sArr10[i3], this.l2_Q6[i3]);
        }
    }

    private void calculate_t4() {
        this.t4 = this.cf.addMatrix(this.cf.multiplyMatrix(this.t1, this.t3), this.t2);
    }

    private void genPrivateKeyMaterial_cyclic() {
        RainbowDRBG rainbowDRBG = new RainbowDRBG(this.sk_seed, this.rainbowParams.getHash_algo());
        RainbowDRBG rainbowDRBG2 = new RainbowDRBG(this.pk_seed, this.rainbowParams.getHash_algo());
        generate_S_and_T(rainbowDRBG);
        calculate_t4();
        generate_B1_and_B2(rainbowDRBG2);
        this.l1_Q1 = this.cf.obfuscate_l1_polys(this.s1, this.l2_Q1, this.l1_Q1);
        this.l1_Q2 = this.cf.obfuscate_l1_polys(this.s1, this.l2_Q2, this.l1_Q2);
        calculate_F_from_Q();
    }

    private void generate_B1_and_B2(SecureRandom secureRandom) {
        int i = this.o1;
        int i2 = this.v1;
        this.l1_Q1 = RainbowUtil.generate_random(secureRandom, i, i2, i2, true);
        int i3 = this.o1;
        this.l1_Q2 = RainbowUtil.generate_random(secureRandom, i3, this.v1, i3, false);
        int i4 = this.o2;
        int i5 = this.v1;
        this.l2_Q1 = RainbowUtil.generate_random(secureRandom, i4, i5, i5, true);
        this.l2_Q2 = RainbowUtil.generate_random(secureRandom, this.o2, this.v1, this.o1, false);
        int i6 = this.o2;
        this.l2_Q3 = RainbowUtil.generate_random(secureRandom, i6, this.v1, i6, false);
        int i7 = this.o2;
        int i8 = this.o1;
        this.l2_Q5 = RainbowUtil.generate_random(secureRandom, i7, i8, i8, true);
        int i9 = this.o2;
        this.l2_Q6 = RainbowUtil.generate_random(secureRandom, i9, this.o1, i9, false);
    }

    private void generate_S_and_T(SecureRandom secureRandom) {
        this.s1 = RainbowUtil.generate_random_2d(secureRandom, this.o1, this.o2);
        this.t1 = RainbowUtil.generate_random_2d(secureRandom, this.v1, this.o1);
        this.t2 = RainbowUtil.generate_random_2d(secureRandom, this.v1, this.o2);
        this.t3 = RainbowUtil.generate_random_2d(secureRandom, this.o1, this.o2);
    }

    RainbowPrivateKeyParameters generatePrivateKey() {
        this.sk_seed = Arrays.clone(this.sk_seed);
        this.pk_seed = Arrays.clone(this.pk_seed);
        genPrivateKeyMaterial_cyclic();
        return new RainbowPrivateKeyParameters(this.rainbowParams, this.sk_seed, this.s1, this.t1, this.t3, this.t4, this.l1_F1, this.l1_F2, this.l2_F1, this.l2_F2, this.l2_F3, this.l2_F5, this.l2_F6, null);
    }
}
