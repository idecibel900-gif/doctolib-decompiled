package net.time4j.base;

import com.opentok.android.BaseVideoCapturer;
import com.revenuecat.purchases.common.verification.SigningManager;

/* JADX INFO: loaded from: classes5.dex */
public abstract class GregorianMath {
    public static int readDayOfMonth(long j) {
        return (int) (j & 255);
    }

    public static int readMonth(long j) {
        return (int) ((j >> 16) & 255);
    }

    public static int readYear(long j) {
        return (int) (j >> 32);
    }

    public static boolean isLeapYear(int i) {
        if (i <= 1900 || i >= 2100) {
            return ((i & 3) == 0 && i % 100 != 0) || i % 400 == 0;
        }
        return (i & 3) == 0;
    }

    public static int getLengthOfMonth(int i, int i2) {
        switch (i2) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                return 31;
            case 2:
                return isLeapYear(i) ? 29 : 28;
            case 4:
            case 6:
            case 9:
            case BaseVideoCapturer.RGBA /* 11 */:
                return 30;
            default:
                throw new IllegalArgumentException("Invalid month: " + i2);
        }
    }

    public static boolean isValid(int i, int i2, int i3) {
        return i >= -999999999 && i <= 999999999 && i2 >= 1 && i2 <= 12 && i3 >= 1 && i3 <= getLengthOfMonth(i, i2);
    }

    public static void checkDate(int i, int i2, int i3) {
        if (i < -999999999 || i > 999999999) {
            throw new IllegalArgumentException("YEAR out of range: " + i);
        }
        if (i2 < 1 || i2 > 12) {
            throw new IllegalArgumentException("MONTH out of range: " + i2);
        }
        if (i3 < 1 || i3 > 31) {
            throw new IllegalArgumentException("DAY_OF_MONTH out of range: " + i3);
        }
        if (i3 <= getLengthOfMonth(i, i2)) {
            return;
        }
        throw new IllegalArgumentException("DAY_OF_MONTH exceeds month length in given year: " + toString(i, i2, i3));
    }

    public static int getDayOfWeek(int i, int i2, int i3) {
        if (i3 < 1 || i3 > 31) {
            throw new IllegalArgumentException("Day out of range: " + i3);
        }
        if (i3 > getLengthOfMonth(i, i2)) {
            throw new IllegalArgumentException("Day exceeds month length: " + toString(i, i2, i3));
        }
        int iGaussianWeekTerm = gaussianWeekTerm(i2);
        int i4 = i % 100;
        int iFloorDivide = MathUtils.floorDivide(i, 100);
        if (i4 < 0) {
            i4 += 100;
        }
        if (i2 <= 2 && (i4 = i4 - 1) < 0) {
            iFloorDivide--;
            i4 = 99;
        }
        int iFloorDivide2 = (((((i3 + iGaussianWeekTerm) + i4) + (i4 / 4)) + MathUtils.floorDivide(iFloorDivide, 4)) - (iFloorDivide * 2)) % 7;
        return iFloorDivide2 <= 0 ? iFloorDivide2 + 7 : iFloorDivide2;
    }

    public static long toPackedDate(long j) {
        long j2;
        long jSafeAdd = MathUtils.safeAdd(j, 678881L);
        long jFloorDivide = MathUtils.floorDivide(jSafeAdd, 146097);
        int iFloorModulo = MathUtils.floorModulo(jSafeAdd, 146097);
        int i = 29;
        int i2 = 2;
        if (iFloorModulo == 146096) {
            j2 = (jFloorDivide + 1) * 400;
        } else {
            int i3 = iFloorModulo / 36524;
            int i4 = iFloorModulo % 36524;
            int i5 = i4 / 1461;
            int i6 = i4 % 1461;
            if (i6 == 1460) {
                j2 = (jFloorDivide * 400) + ((long) (i3 * 100)) + ((long) ((i5 + 1) * 4));
            } else {
                int i7 = i6 / 365;
                int i8 = i6 % 365;
                j2 = (jFloorDivide * 400) + ((long) (i3 * 100)) + ((long) (i5 * 4)) + ((long) i7);
                int i9 = ((i8 + 31) * 5) / 153;
                i2 = i9 + 2;
                i = (i8 - (((i9 + 3) * 153) / 5)) + 123;
                if (i2 > 12) {
                    j2++;
                    i2 = i9 - 10;
                }
            }
        }
        if (j2 >= -999999999 && j2 <= 999999999) {
            return (j2 << 32) | ((long) (i2 << 16)) | ((long) i);
        }
        throw new IllegalArgumentException("Year out of range: " + j2);
    }

    public static long toMJD(GregorianDate gregorianDate) {
        return toMJD(gregorianDate.getYear(), gregorianDate.getMonth(), gregorianDate.getDayOfMonth());
    }

    public static long toMJD(int i, int i2, int i3) {
        checkDate(i, i2, i3);
        long j = i;
        if (i2 < 3) {
            j--;
            i2 += 12;
        }
        return (((((((365 * j) + MathUtils.floorDivide(j, 4)) - MathUtils.floorDivide(j, 100)) + MathUtils.floorDivide(j, 400)) + ((long) (((i2 + 1) * 153) / 5))) - 123) + ((long) i3)) - 678881;
    }

    static String toString(int i, int i2, int i3) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append('-');
        if (i2 < 10) {
            sb.append('0');
        }
        sb.append(i2);
        sb.append('-');
        if (i3 < 10) {
            sb.append('0');
        }
        sb.append(i3);
        return sb.toString();
    }

    private static int gaussianWeekTerm(int i) {
        switch (i) {
            case 1:
                return 28;
            case 2:
                return 31;
            case 3:
                return 2;
            case 4:
                return 5;
            case 5:
                return 7;
            case 6:
                return 10;
            case 7:
                return 12;
            case 8:
                return 15;
            case 9:
                return 18;
            case 10:
                return 20;
            case BaseVideoCapturer.RGBA /* 11 */:
                return 23;
            case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                return 25;
            default:
                throw new IllegalArgumentException("Month out of range: " + i);
        }
    }
}
