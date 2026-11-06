package net.time4j.calendar.astro;

import com.revenuecat.purchases.ui.revenuecatui.components.SensibleDefaults;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.concurrent.TimeUnit;
import net.time4j.Moment;
import net.time4j.PlainTimestamp;
import net.time4j.base.MathUtils;

/* JADX INFO: loaded from: classes5.dex */
public enum MoonPhase {
    NEW_MOON(0),
    FIRST_QUARTER(90),
    FULL_MOON(SensibleDefaults.X_OFFSET),
    LAST_QUARTER(270);

    private final transient int phase;
    private static final int[] FACTORS = {100, 1000, ColorExtractionConstants.MAX_PIXEL_SAMPLES, 100000};
    private static final Moment ZERO_REF = PlainTimestamp.of(2000, 1, 6, 18, 13, 42).atUTC();
    private static final int[] W_NEW_FULL = {0, 1, 0, 0, 1, 1, 2, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private static final int[] W_QUARTER = {0, 1, 1, 0, 0, 1, 2, 0, 0, 0, 1, 1, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private static final int[] X_NEW_FULL = {0, 1, 0, 0, -1, 1, 2, 0, 0, 1, 0, 1, 1, -1, 2, 0, 3, 1, 0, 1, -1, -1, 1, 0};
    private static final int[] X_QUARTER = {0, 1, 1, 0, 0, -1, 2, 0, 0, 0, -1, 1, 1, 2, 1, -1, 0, 1, -2, 1, 3, 0, -1, 1};
    private static final int[] Y_NEW_FULL = {1, 0, 2, 0, 1, 1, 0, 1, 1, 2, 3, 0, 0, 2, 1, 2, 0, 1, 2, 1, 1, 1, 3, 4};
    private static final int[] Y_QUARTER = {1, 0, 1, 2, 0, 1, 0, 1, 1, 3, 2, 0, 0, 1, 2, 1, 2, 1, 1, 1, 0, 2, 1, 3};
    private static final int[] Z_NEW_FULL = {0, 0, 0, 2, 0, 0, 0, -2, 2, 0, 0, 2, -2, 0, 0, -2, 0, -2, 2, 2, 2, -2, 0, 0};
    private static final int[] Z_QUARTER = {0, 0, 0, 0, 2, 0, 0, -2, 2, 0, 0, 2, -2, 0, 0, -2, 2, 2, 0, -2, 0, -2, 2, 0};
    private static final double[] V_NEW = {-0.4072d, 0.17241d, 0.01608d, 0.01039d, 0.00739d, -0.00514d, 0.00208d, -0.00111d, -5.7E-4d, 5.6E-4d, -4.2E-4d, 4.2E-4d, 3.8E-4d, -2.4E-4d, -7.0E-5d, 4.0E-5d, 4.0E-5d, 3.0E-5d, 3.0E-5d, -3.0E-5d, 3.0E-5d, -2.0E-5d, -2.0E-5d, 2.0E-5d};
    private static final double[] V_FULL = {-0.40614d, 0.17302d, 0.01614d, 0.01043d, 0.00734d, -0.00515d, 0.00209d, -0.00111d, -5.7E-4d, 5.6E-4d, -4.2E-4d, 4.2E-4d, 3.8E-4d, -2.4E-4d, -7.0E-5d, 4.0E-5d, 4.0E-5d, 3.0E-5d, 3.0E-5d, -3.0E-5d, 3.0E-5d, -2.0E-5d, -2.0E-5d, 2.0E-5d};
    private static final double[] V_QUARTER = {-0.62801d, 0.17172d, -0.01183d, 0.00862d, 0.00804d, 0.00454d, 0.00204d, -0.0018d, -7.0E-4d, -4.0E-4d, -3.4E-4d, 3.2E-4d, 3.2E-4d, -2.8E-4d, 2.7E-4d, -5.0E-5d, 4.0E-5d, -4.0E-5d, 4.0E-5d, 3.0E-5d, 3.0E-5d, 2.0E-5d, 2.0E-5d, -2.0E-5d};

    MoonPhase(int i) {
        this.phase = i;
    }

    public Moment atOrAfter(Moment moment) {
        int estimatedLunations = getEstimatedLunations(moment);
        Moment momentAtLunation = atLunation(estimatedLunations);
        int i = estimatedLunations;
        while (momentAtLunation.isBefore(moment)) {
            i++;
            momentAtLunation = atLunation(i);
        }
        if (i <= estimatedLunations) {
            while (true) {
                i--;
                Moment momentAtLunation2 = atLunation(i);
                if (momentAtLunation2.isBefore(moment)) {
                    break;
                }
                momentAtLunation = momentAtLunation2;
            }
        }
        return momentAtLunation;
    }

    public Moment before(Moment moment) {
        int estimatedLunations = getEstimatedLunations(moment);
        Moment momentAtLunation = atLunation(estimatedLunations);
        int i = estimatedLunations;
        while (!momentAtLunation.isBefore(moment)) {
            i--;
            momentAtLunation = atLunation(i);
        }
        if (i >= estimatedLunations) {
            while (((Moment) momentAtLunation.plus(29L, TimeUnit.DAYS)).isBefore(moment)) {
                i++;
                Moment momentAtLunation2 = atLunation(i);
                if (!momentAtLunation2.isBefore(moment)) {
                    break;
                }
                momentAtLunation = momentAtLunation2;
            }
        }
        return momentAtLunation;
    }

    public Moment atLunation(int i) {
        double d = ((double) i) + (((double) this.phase) / 360.0d);
        double d2 = d / 1236.85d;
        double d3 = d2 * d2;
        double d4 = 1.0d - (((7.4E-6d * d2) + 0.002516d) * d2);
        double d5 = ((29.1053567d * d) + 2.5534d) - (((1.1E-7d * d2) + 1.4E-6d) * d3);
        double d6 = (385.81693528d * d) + 201.5643d + ((((1.238E-5d - (5.8E-8d * d2)) * d2) + 0.0107582d) * d3);
        double d7 = (390.67050284d * d) + 160.7108d + (((((1.1E-8d * d2) - 2.27E-6d) * d2) - 0.0016118d) * d3);
        double dSin = ((((29.530588861d * d) + 2451550.09766d) + (((((7.3E-10d * d2) - 1.5E-7d) * d2) + 1.5437E-4d) * d3)) - (Math.sin(Math.toRadians((124.7746d - (1.56375588d * d)) + (((2.15E-6d * d2) + 0.0020672d) * d3))) * 1.7E-4d)) + periodic24(d4, d5, d6, d7);
        if (this == FIRST_QUARTER) {
            dSin += corrQuarter(d4, d5, d6, d7);
        } else if (this == LAST_QUARTER) {
            dSin -= corrQuarter(d4, d5, d6, d7);
        }
        double[] dArr = {((0.107408d * d) + 299.77d) - (d3 * 0.009173d), 3.25E-4d, (0.016321d * d) + 251.88d, 1.65E-4d, (26.651886d * d) + 251.83d, 1.64E-4d, (36.412478d * d) + 349.42d, 1.26E-4d, (18.206239d * d) + 84.66d, 1.1E-4d, (53.303771d * d) + 141.74d, 6.2E-5d, (2.453732d * d) + 207.14d, 6.0E-5d, (7.30686d * d) + 154.84d, 5.6E-5d, (27.261239d * d) + 34.52d, 4.7E-5d, (0.121824d * d) + 207.19d, 4.2E-5d, (1.844379d * d) + 291.34d, 4.0E-5d, (24.198154d * d) + 161.72d, 3.7E-5d, (25.513099d * d) + 239.56d, 3.5E-5d, (d * 3.592518d) + 331.55d, 2.3E-5d};
        for (int i2 = 0; i2 < 28; i2 += 2) {
            dSin += dArr[i2 + 1] * Math.sin(Math.toRadians(dArr[i2]));
        }
        return (Moment) JulianDay.ofEphemerisTime(dSin).toMoment().with(Moment.PRECISION, TimeUnit.SECONDS);
    }

    private int getEstimatedLunations(Moment moment) {
        return MathUtils.safeCast(Math.round((ZERO_REF.until(moment, TimeUnit.DAYS) / 29.530588861d) - (((double) this.phase) / 360.0d)));
    }

    private double periodic24(double d, double d2, double d3, double d4) {
        MoonPhase moonPhase = NEW_MOON;
        double[] dArr = this == moonPhase ? V_NEW : this == FULL_MOON ? V_FULL : V_QUARTER;
        int[] iArr = (this == moonPhase || this == FULL_MOON) ? W_NEW_FULL : W_QUARTER;
        int[] iArr2 = (this == moonPhase || this == FULL_MOON) ? X_NEW_FULL : X_QUARTER;
        int[] iArr3 = (this == moonPhase || this == FULL_MOON) ? Y_NEW_FULL : Y_QUARTER;
        int[] iArr4 = (this == moonPhase || this == FULL_MOON) ? Z_NEW_FULL : Z_QUARTER;
        double dSin = 0.0d;
        for (int i = 23; i >= 0; i--) {
            double d5 = dArr[i];
            int i2 = iArr[i];
            if (i2 == 1) {
                d5 *= d;
            } else if (i2 == 2) {
                d5 *= d;
                d5 *= d;
            }
            dSin += d5 * sin((((double) iArr2[i]) * d2) + (((double) iArr3[i]) * d3) + (((double) iArr4[i]) * d4));
        }
        return dSin;
    }

    private static double corrQuarter(double d, double d2, double d3, double d4) {
        return (((0.00306d - ((d * 3.8E-4d) * cos(d2))) + (cos(d3) * 2.6E-4d)) - (cos(d3 - d2) * 2.0E-5d)) + (cos(d3 + d2) * 2.0E-5d) + (cos(d4 * 2.0d) * 2.0E-5d);
    }

    private static double sin(double d) {
        return Math.sin((d * 3.141592653589793d) / 180.0d);
    }

    private static double cos(double d) {
        return Math.cos((d * 3.141592653589793d) / 180.0d);
    }
}
