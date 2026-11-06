package app.screeb.sdk.internal;

import kotlin.ranges.RangesKt;

/* JADX INFO: renamed from: app.screeb.sdk.internal.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0296d {
    public final double a = 60.0d;
    public final double b = 24.0d;
    public final double c = 240.0d;
    public final double d = 1080.0d;
    public final double e = 0.32d;
    public final double f = 0.06d;
    public double g = 16.666666666666668d;
    public double h = 1080.0d;
    public int i;
    public int j;
    public boolean k;
    public int l;
    public boolean m;

    public final synchronized int a() {
        double dMin;
        try {
            int iB = b();
            if (iB != 0) {
                dMin = iB != 1 ? Math.min(this.d, 540.0d) : Math.min(this.d, 720.0d);
            } else {
                dMin = this.d;
            }
        } catch (Throwable th) {
            throw th;
        }
        return RangesKt.coerceIn((int) this.h, (int) this.c, (int) dMin);
    }

    public final synchronized int a(boolean z) {
        int iCoerceIn;
        try {
            double d = this.d - this.c;
            Double dValueOf = Double.valueOf(d);
            if (d <= 0.0d) {
                dValueOf = null;
            }
            iCoerceIn = RangesKt.coerceIn((int) ((RangesKt.coerceIn((this.h - this.c) / (dValueOf != null ? dValueOf.doubleValue() : 1.0d), 0.0d, 1.0d) * ((double) 25)) + ((double) 65)), 10, 100);
            int iB = b();
            if (iB != 0) {
                iCoerceIn = iB != 1 ? Math.max(15, iCoerceIn - 40) : Math.max(30, iCoerceIn - 20);
            }
            int i = this.j;
            if (i != 0) {
                iCoerceIn = i != 1 ? Math.max(15, iCoerceIn - 20) : Math.max(25, iCoerceIn - 10);
            }
            if (z) {
                iCoerceIn = Math.min(iCoerceIn, 72);
            }
        } catch (Throwable th) {
            throw th;
        }
        return iCoerceIn;
    }

    public final synchronized int a(boolean z, boolean z2) {
        int iCoerceAtLeast;
        iCoerceAtLeast = 2;
        if (z) {
            try {
                iCoerceAtLeast = b() < 2 ? RangesKt.coerceAtLeast((int) this.b, 1) : RangesKt.coerceAtLeast((int) (this.b / ((double) 2)), 1);
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z2) {
            iCoerceAtLeast = RangesKt.coerceAtMost(RangesKt.coerceAtLeast((int) (((double) iCoerceAtLeast) * 0.66d), 10), iCoerceAtLeast);
        }
        return iCoerceAtLeast;
    }

    public final synchronized void a(double d) {
        try {
            double d2 = this.g;
            double d3 = d > d2 ? this.e : this.f;
            this.g = (d3 * d) + ((((double) 1) - d3) * d2);
            double dCoerceIn = RangesKt.coerceIn((1000.0d / Math.max(d, 0.001d)) / this.b, 0.1d, 1.5d);
            double d4 = this.h;
            this.h = RangesKt.coerceIn(RangesKt.coerceAtLeast(dCoerceIn * d4, d4 * 0.9d), this.c, this.d);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void a(double d, int i) {
        int iCoerceAtMost;
        if (i <= 0) {
            return;
        }
        double d2 = d / ((double) i);
        try {
            if (d > 64.0d || d2 > 12.0d) {
                iCoerceAtMost = RangesKt.coerceAtMost(this.j + 1, 2);
            } else {
                iCoerceAtMost = (d >= 18.0d || d2 >= 5.0d) ? this.j : RangesKt.coerceAtLeast(this.j - 1, 0);
            }
            this.j = iCoerceAtMost;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final int b() {
        int i = this.i;
        int i2 = this.l;
        int i3 = 2;
        if (i2 < 3) {
            i3 = (i2 >= 2 || this.k || this.m) ? 1 : 0;
        }
        return Math.max(i, i3);
    }

    public final synchronized long c() {
        try {
        } catch (Throwable th) {
            throw th;
        }
        return (long) (1000.0d / (b() == 2 ? this.a / ((double) 2) : this.a));
    }

    public final synchronized long d() {
        return RangesKt.coerceIn((long) (1000.0d / ((double) a(true, false))), 16L, 500L);
    }
}
