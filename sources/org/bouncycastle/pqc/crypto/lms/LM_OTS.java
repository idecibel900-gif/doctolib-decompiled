package org.bouncycastle.pqc.crypto.lms;

import org.bouncycastle.crypto.Digest;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes5.dex */
abstract class LM_OTS {
    public static int cksm(byte[] bArr, int i, LMOtsParameters lMOtsParameters) {
        int w = (1 << lMOtsParameters.getW()) - 1;
        int iCoef = 0;
        for (int i2 = 0; i2 < (i * 8) / lMOtsParameters.getW(); i2++) {
            iCoef = (iCoef + w) - coef(bArr, i2, lMOtsParameters.getW());
        }
        return iCoef << lMOtsParameters.getLs();
    }

    public static int coef(byte[] bArr, int i, int i2) {
        int i3 = (i * i2) / 8;
        return (bArr[i3] >>> (((~i) & ((8 / i2) - 1)) * i2)) & ((1 << i2) - 1);
    }

    public static LMOtsSignature lm_ots_generate_signature(LMOtsPrivateKey lMOtsPrivateKey, byte[] bArr, byte[] bArr2) {
        LMOtsParameters parameter = lMOtsPrivateKey.getParameter();
        int n = parameter.getN();
        int p = parameter.getP();
        int w = parameter.getW();
        byte[] bArr3 = new byte[p * n];
        Digest digest = DigestUtil.getDigest(parameter);
        SeedDerive derivationFunction = lMOtsPrivateKey.getDerivationFunction();
        int iCksm = cksm(bArr, n, parameter);
        bArr[n] = (byte) ((iCksm >>> 8) & 255);
        bArr[n + 1] = (byte) iCksm;
        int i = n + 23;
        byte[] bArrBuild = Composer.compose().bytes(lMOtsPrivateKey.getI()).u32str(lMOtsPrivateKey.getQ()).padUntil(0, i).build();
        derivationFunction.setJ(0);
        int i2 = 0;
        while (i2 < p) {
            Pack.shortToBigEndian((short) i2, bArrBuild, 20);
            derivationFunction.deriveSeed(bArrBuild, i2 < p + (-1), 23);
            int iCoef = coef(bArr, i2, w);
            for (int i3 = 0; i3 < iCoef; i3++) {
                bArrBuild[22] = (byte) i3;
                digest.update(bArrBuild, 0, i);
                digest.doFinal(bArrBuild, 23);
            }
            System.arraycopy(bArrBuild, 23, bArr3, n * i2, n);
            i2++;
        }
        return new LMOtsSignature(parameter, bArr2, bArr3);
    }

    static byte[] lms_ots_generatePublicKey(LMOtsParameters lMOtsParameters, byte[] bArr, int i, byte[] bArr2) {
        Digest digest = DigestUtil.getDigest(lMOtsParameters);
        byte[] bArrBuild = Composer.compose().bytes(bArr).u32str(i).u16str(-32640).padUntil(0, 22).build();
        digest.update(bArrBuild, 0, bArrBuild.length);
        Digest digest2 = DigestUtil.getDigest(lMOtsParameters);
        byte[] bArrBuild2 = Composer.compose().bytes(bArr).u32str(i).padUntil(0, digest2.getDigestSize() + 23).build();
        SeedDerive seedDerive = new SeedDerive(bArr, bArr2, DigestUtil.getDigest(lMOtsParameters));
        seedDerive.setQ(i);
        seedDerive.setJ(0);
        int p = lMOtsParameters.getP();
        int n = lMOtsParameters.getN();
        int w = (1 << lMOtsParameters.getW()) - 1;
        int i2 = 0;
        while (i2 < p) {
            seedDerive.deriveSeed(bArrBuild2, i2 < p + (-1), 23);
            Pack.shortToBigEndian((short) i2, bArrBuild2, 20);
            for (int i3 = 0; i3 < w; i3++) {
                bArrBuild2[22] = (byte) i3;
                digest2.update(bArrBuild2, 0, bArrBuild2.length);
                digest2.doFinal(bArrBuild2, 23);
            }
            digest.update(bArrBuild2, 23, n);
            i2++;
        }
        byte[] bArr3 = new byte[digest.getDigestSize()];
        digest.doFinal(bArr3, 0);
        return bArr3;
    }
}
