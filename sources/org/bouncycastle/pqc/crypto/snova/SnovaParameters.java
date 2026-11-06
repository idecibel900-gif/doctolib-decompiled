package org.bouncycastle.pqc.crypto.snova;

/* JADX INFO: loaded from: classes5.dex */
public class SnovaParameters {
    private final int alpha;
    private final int l;
    private final int lsq;
    private final String name;
    private final int o;
    private final boolean pkExpandShake;
    private final boolean skIsSeed;
    private final int v;
    public static final SnovaParameters SNOVA_24_5_4_SSK = new SnovaParameters("SNOVA_24_5_4_SSK", 24, 5, 4, true, false);
    public static final SnovaParameters SNOVA_24_5_4_ESK = new SnovaParameters("SNOVA_24_5_4_ESK", 24, 5, 4, false, false);
    public static final SnovaParameters SNOVA_24_5_4_SHAKE_SSK = new SnovaParameters("SNOVA_24_5_4_SHAKE_SSK", 24, 5, 4, true, true);
    public static final SnovaParameters SNOVA_24_5_4_SHAKE_ESK = new SnovaParameters("SNOVA_24_5_4_SHAKE_ESK", 24, 5, 4, false, true);
    public static final SnovaParameters SNOVA_24_5_5_SSK = new SnovaParameters("SNOVA_24_5_5_SSK", 24, 5, 5, true, false);
    public static final SnovaParameters SNOVA_24_5_5_ESK = new SnovaParameters("SNOVA_24_5_5_ESK", 24, 5, 5, false, false);
    public static final SnovaParameters SNOVA_24_5_5_SHAKE_SSK = new SnovaParameters("SNOVA_24_5_5_SHAKE_SSK", 24, 5, 5, true, true);
    public static final SnovaParameters SNOVA_24_5_5_SHAKE_ESK = new SnovaParameters("SNOVA_24_5_5_SHAKE_ESK", 24, 5, 5, false, true);
    public static final SnovaParameters SNOVA_25_8_3_SSK = new SnovaParameters("SNOVA_25_8_3_SSK", 25, 8, 3, true, false);
    public static final SnovaParameters SNOVA_25_8_3_ESK = new SnovaParameters("SNOVA_25_8_3_ESK", 25, 8, 3, false, false);
    public static final SnovaParameters SNOVA_25_8_3_SHAKE_SSK = new SnovaParameters("SNOVA_25_8_3_SHAKE_SSK", 25, 8, 3, true, true);
    public static final SnovaParameters SNOVA_25_8_3_SHAKE_ESK = new SnovaParameters("SNOVA_25_8_3_SHAKE_ESK", 25, 8, 3, false, true);
    public static final SnovaParameters SNOVA_29_6_5_SSK = new SnovaParameters("SNOVA_29_6_5_SSK", 29, 6, 5, true, false);
    public static final SnovaParameters SNOVA_29_6_5_ESK = new SnovaParameters("SNOVA_29_6_5_ESK", 29, 6, 5, false, false);
    public static final SnovaParameters SNOVA_29_6_5_SHAKE_SSK = new SnovaParameters("SNOVA_29_6_5_SHAKE_SSK", 29, 6, 5, true, true);
    public static final SnovaParameters SNOVA_29_6_5_SHAKE_ESK = new SnovaParameters("SNOVA_29_6_5_SHAKE_ESK", 29, 6, 5, false, true);
    public static final SnovaParameters SNOVA_37_8_4_SSK = new SnovaParameters("SNOVA_37_8_4_SSK", 37, 8, 4, true, false);
    public static final SnovaParameters SNOVA_37_8_4_ESK = new SnovaParameters("SNOVA_37_8_4_ESK", 37, 8, 4, false, false);
    public static final SnovaParameters SNOVA_37_8_4_SHAKE_SSK = new SnovaParameters("SNOVA_37_8_4_SHAKE_SSK", 37, 8, 4, true, true);
    public static final SnovaParameters SNOVA_37_8_4_SHAKE_ESK = new SnovaParameters("SNOVA_37_8_4_SHAKE_ESK", 37, 8, 4, false, true);
    public static final SnovaParameters SNOVA_37_17_2_SSK = new SnovaParameters("SNOVA_37_17_2_SSK", 37, 17, 2, true, false);
    public static final SnovaParameters SNOVA_37_17_2_ESK = new SnovaParameters("SNOVA_37_17_2_ESK", 37, 17, 2, false, false);
    public static final SnovaParameters SNOVA_37_17_2_SHAKE_SSK = new SnovaParameters("SNOVA_37_17_2_SHAKE_SSK", 37, 17, 2, true, true);
    public static final SnovaParameters SNOVA_37_17_2_SHAKE_ESK = new SnovaParameters("SNOVA_37_17_2_SHAKE_ESK", 37, 17, 2, false, true);
    public static final SnovaParameters SNOVA_49_11_3_SSK = new SnovaParameters("SNOVA_49_11_3_SSK", 49, 11, 3, true, false);
    public static final SnovaParameters SNOVA_49_11_3_ESK = new SnovaParameters("SNOVA_49_11_3_ESK", 49, 11, 3, false, false);
    public static final SnovaParameters SNOVA_49_11_3_SHAKE_SSK = new SnovaParameters("SNOVA_49_11_3_SHAKE_SSK", 49, 11, 3, true, true);
    public static final SnovaParameters SNOVA_49_11_3_SHAKE_ESK = new SnovaParameters("SNOVA_49_11_3_SHAKE_ESK", 49, 11, 3, false, true);
    public static final SnovaParameters SNOVA_56_25_2_SSK = new SnovaParameters("SNOVA_56_25_2_SSK", 56, 25, 2, true, false);
    public static final SnovaParameters SNOVA_56_25_2_ESK = new SnovaParameters("SNOVA_56_25_2_ESK", 56, 25, 2, false, false);
    public static final SnovaParameters SNOVA_56_25_2_SHAKE_SSK = new SnovaParameters("SNOVA_56_25_2_SHAKE_SSK", 56, 25, 2, true, true);
    public static final SnovaParameters SNOVA_56_25_2_SHAKE_ESK = new SnovaParameters("SNOVA_56_25_2_SHAKE_ESK", 56, 25, 2, false, true);
    public static final SnovaParameters SNOVA_60_10_4_SSK = new SnovaParameters("SNOVA_60_10_4_SSK", 60, 10, 4, true, false);
    public static final SnovaParameters SNOVA_60_10_4_ESK = new SnovaParameters("SNOVA_60_10_4_ESK", 60, 10, 4, false, false);
    public static final SnovaParameters SNOVA_60_10_4_SHAKE_SSK = new SnovaParameters("SNOVA_60_10_4_SHAKE_SSK", 60, 10, 4, true, true);
    public static final SnovaParameters SNOVA_60_10_4_SHAKE_ESK = new SnovaParameters("SNOVA_60_10_4_SHAKE_ESK", 60, 10, 4, false, true);
    public static final SnovaParameters SNOVA_66_15_3_SSK = new SnovaParameters("SNOVA_66_15_3_SSK", 66, 15, 3, true, false);
    public static final SnovaParameters SNOVA_66_15_3_ESK = new SnovaParameters("SNOVA_66_15_3_ESK", 66, 15, 3, false, false);
    public static final SnovaParameters SNOVA_66_15_3_SHAKE_SSK = new SnovaParameters("SNOVA_66_15_3_SHAKE_SSK", 66, 15, 3, true, true);
    public static final SnovaParameters SNOVA_66_15_3_SHAKE_ESK = new SnovaParameters("SNOVA_66_15_3_SHAKE_ESK", 66, 15, 3, false, true);
    public static final SnovaParameters SNOVA_75_33_2_SSK = new SnovaParameters("SNOVA_75_33_2_SSK", 75, 33, 2, true, false);
    public static final SnovaParameters SNOVA_75_33_2_ESK = new SnovaParameters("SNOVA_75_33_2_ESK", 75, 33, 2, false, false);
    public static final SnovaParameters SNOVA_75_33_2_SHAKE_SSK = new SnovaParameters("SNOVA_75_33_2_SHAKE_SSK", 75, 33, 2, true, true);
    public static final SnovaParameters SNOVA_75_33_2_SHAKE_ESK = new SnovaParameters("SNOVA_75_33_2_SHAKE_ESK", 75, 33, 2, false, true);

    private SnovaParameters(String str, int i, int i2, int i3, boolean z, boolean z2) {
        this.name = str;
        this.v = i;
        this.o = i2;
        this.l = i3;
        int i4 = i3 * i3;
        this.lsq = i4;
        this.alpha = i4 + i3;
        this.skIsSeed = z;
        this.pkExpandShake = z2;
    }

    public String getName() {
        return this.name;
    }
}
