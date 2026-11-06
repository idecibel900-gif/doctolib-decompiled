package org.bouncycastle.pqc.crypto.rainbow;

import java.lang.reflect.Array;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public class RainbowPublicKeyParameters extends RainbowKeyParameters {
    short[][][] l1_Q3;
    short[][][] l1_Q5;
    short[][][] l1_Q6;
    short[][][] l1_Q9;
    short[][][] l2_Q9;
    short[][][] pk;
    byte[] pk_seed;

    public RainbowPublicKeyParameters(RainbowParameters rainbowParameters, byte[] bArr) {
        super(false, rainbowParameters);
        int m = rainbowParameters.getM();
        int n = rainbowParameters.getN();
        Version version = getParameters().getVersion();
        Version version2 = Version.CLASSIC;
        Class cls = Short.TYPE;
        if (version != version2) {
            this.pk_seed = Arrays.copyOfRange(bArr, 0, rainbowParameters.getLen_pkseed());
            this.l1_Q3 = (short[][][]) Array.newInstance((Class<?>) cls, rainbowParameters.getO1(), rainbowParameters.getV1(), rainbowParameters.getO2());
            this.l1_Q5 = (short[][][]) Array.newInstance((Class<?>) cls, rainbowParameters.getO1(), rainbowParameters.getO1(), rainbowParameters.getO1());
            this.l1_Q6 = (short[][][]) Array.newInstance((Class<?>) cls, rainbowParameters.getO1(), rainbowParameters.getO1(), rainbowParameters.getO2());
            this.l1_Q9 = (short[][][]) Array.newInstance((Class<?>) cls, rainbowParameters.getO1(), rainbowParameters.getO2(), rainbowParameters.getO2());
            this.l2_Q9 = (short[][][]) Array.newInstance((Class<?>) cls, rainbowParameters.getO2(), rainbowParameters.getO2(), rainbowParameters.getO2());
            int len_pkseed = rainbowParameters.getLen_pkseed();
            int iLoadEncoded = len_pkseed + RainbowUtil.loadEncoded(this.l1_Q3, bArr, len_pkseed, false);
            int iLoadEncoded2 = iLoadEncoded + RainbowUtil.loadEncoded(this.l1_Q5, bArr, iLoadEncoded, true);
            int iLoadEncoded3 = iLoadEncoded2 + RainbowUtil.loadEncoded(this.l1_Q6, bArr, iLoadEncoded2, false);
            int iLoadEncoded4 = iLoadEncoded3 + RainbowUtil.loadEncoded(this.l1_Q9, bArr, iLoadEncoded3, true);
            if (iLoadEncoded4 + RainbowUtil.loadEncoded(this.l2_Q9, bArr, iLoadEncoded4, true) != bArr.length) {
                throw new IllegalArgumentException("unparsed data in key encoding");
            }
            return;
        }
        this.pk = (short[][][]) Array.newInstance((Class<?>) cls, m, n, n);
        int i = 0;
        for (int i2 = 0; i2 < n; i2++) {
            for (int i3 = 0; i3 < n; i3++) {
                for (int i4 = 0; i4 < m; i4++) {
                    short[][][] sArr = this.pk;
                    if (i2 > i3) {
                        sArr[i4][i2][i3] = 0;
                    } else {
                        sArr[i4][i2][i3] = (short) (bArr[i] & 255);
                        i++;
                    }
                }
            }
        }
    }

    public byte[] getEncoded() {
        return getParameters().getVersion() != Version.CLASSIC ? Arrays.concatenate(Arrays.concatenate(Arrays.concatenate(Arrays.concatenate(Arrays.concatenate(this.pk_seed, RainbowUtil.getEncoded(this.l1_Q3, false)), RainbowUtil.getEncoded(this.l1_Q5, true)), RainbowUtil.getEncoded(this.l1_Q6, false)), RainbowUtil.getEncoded(this.l1_Q9, true)), RainbowUtil.getEncoded(this.l2_Q9, true)) : RainbowUtil.getEncoded(this.pk, true);
    }
}
