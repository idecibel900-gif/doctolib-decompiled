package kotlin.math;

import androidx.recyclerview.widget.LinearLayoutManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes5.dex */
public abstract class MathKt__MathJVMKt extends MathKt__MathHKt {
    public static int roundToInt(double d) {
        if (Double.isNaN(d)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        if (d > 2.147483647E9d) {
            return Integer.MAX_VALUE;
        }
        return d < -2.147483648E9d ? LinearLayoutManager.INVALID_OFFSET : (int) Math.round(d);
    }

    public static long roundToLong(double d) {
        if (Double.isNaN(d)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return Math.round(d);
    }

    public static int roundToInt(float f) {
        if (Float.isNaN(f)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return Math.round(f);
    }

    public static long roundToLong(float f) {
        return roundToLong(f);
    }

    public static int getSign(int i) {
        return Integer.signum(i);
    }

    public static int getSign(long j) {
        return Long.signum(j);
    }
}
