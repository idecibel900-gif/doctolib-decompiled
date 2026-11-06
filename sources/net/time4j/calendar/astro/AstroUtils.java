package net.time4j.calendar.astro;

/* JADX INFO: loaded from: classes5.dex */
abstract class AstroUtils {
    static double toRange_0_360(double d) {
        while (Double.compare(0.0d, d) > 0) {
            d += 360.0d;
        }
        while (Double.compare(d, 360.0d) >= 0) {
            d -= 360.0d;
        }
        return d;
    }

    static int hashCode(double d) {
        long jDoubleToLongBits = Double.doubleToLongBits(d);
        return (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
    }
}
