package androidx.compose.ui.graphics;

import androidx.collection.FloatFloatPair;
import androidx.compose.ui.util.MathHelpersKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class BezierKt {
    public static final float evaluateCubic(float f, float f2, float f3) {
        return ((((((f - f2) + 0.33333334f) * f3) + (f2 - (2.0f * f))) * f3) + f) * 3.0f * f3;
    }

    private static final float evaluateCubic(float f, float f2, float f3, float f4, float f5) {
        float f6 = (f4 + ((f2 - f3) * 3.0f)) - f;
        return (((((f6 * f5) + (((f3 - (2.0f * f2)) + f) * 3.0f)) * f5) + ((f2 - f) * 3.0f)) * f5) + f;
    }

    private static final int findQuadraticRoots(float f, float f2, float f3, float[] fArr, int i) {
        double d = f;
        double d2 = f2;
        double d3 = f3;
        double d4 = d2 * 2.0d;
        double d5 = (d - d4) + d3;
        if (d5 == 0.0d) {
            if (d2 == d3) {
                return 0;
            }
            return writeValidRootInUnitRange((float) ((d4 - d3) / (d4 - (d3 * 2.0d))), fArr, i);
        }
        double d6 = -Math.sqrt((d2 * d2) - (d3 * d));
        double d7 = (-d) + d2;
        int iWriteValidRootInUnitRange = writeValidRootInUnitRange((float) ((-(d6 + d7)) / d5), fArr, i);
        int iWriteValidRootInUnitRange2 = iWriteValidRootInUnitRange + writeValidRootInUnitRange((float) ((d6 - d7) / d5), fArr, i + iWriteValidRootInUnitRange);
        if (iWriteValidRootInUnitRange2 <= 1) {
            return iWriteValidRootInUnitRange2;
        }
        float f4 = fArr[i];
        int i2 = i + 1;
        float f5 = fArr[i2];
        if (f4 <= f5) {
            return f4 == f5 ? iWriteValidRootInUnitRange2 - 1 : iWriteValidRootInUnitRange2;
        }
        fArr[i] = f5;
        fArr[i2] = f4;
        return iWriteValidRootInUnitRange2;
    }

    public static final long computeCubicVerticalBounds(float f, float f2, float f3, float f4, float[] fArr, int i) {
        float f5 = (f2 - f) * 3.0f;
        float f6 = (f3 - f2) * 3.0f;
        float f7 = (f4 - f3) * 3.0f;
        int iFindQuadraticRoots = findQuadraticRoots(f5, f6, f7, fArr, i);
        float f8 = (f6 - f5) * 2.0f;
        int iWriteValidRootInUnitRange = iFindQuadraticRoots + writeValidRootInUnitRange((-f8) / (((f7 - f6) * 2.0f) - f8), fArr, i + iFindQuadraticRoots);
        float fMin = Math.min(f, f4);
        float fMax = Math.max(f, f4);
        for (int i2 = 0; i2 < iWriteValidRootInUnitRange; i2++) {
            float fEvaluateCubic = evaluateCubic(f, f2, f3, f4, fArr[i2]);
            fMin = Math.min(fMin, fEvaluateCubic);
            fMax = Math.max(fMax, fEvaluateCubic);
        }
        return FloatFloatPair.m20constructorimpl(fMin, fMax);
    }

    /* JADX WARN: Code duplicated, block: B:104:0x018a  */
    /* JADX WARN: Code duplicated, block: B:27:0x0085  */
    /* JADX WARN: Code duplicated, block: B:62:0x0110  */
    /* JADX WARN: Code duplicated, block: B:76:0x013d  */
    public static final float findFirstCubicRoot(float f, float f2, float f3, float f4) {
        double d = f;
        double d2 = ((d - (((double) f2) * 2.0d)) + ((double) f3)) * 3.0d;
        double d3 = ((double) (f2 - f)) * 3.0d;
        double d4 = ((double) (-f)) + (((double) (f2 - f3)) * 3.0d) + ((double) f4);
        if (Math.abs(d4 - 0.0d) < 1.0E-7d) {
            if (Math.abs(d2 - 0.0d) < 1.0E-7d) {
                if (Math.abs(d3 - 0.0d) < 1.0E-7d) {
                    return Float.NaN;
                }
                float f5 = (float) ((-d) / d3);
                if (f5 < 0.0f) {
                    return f5 >= -8.34465E-7f ? 0.0f : Float.NaN;
                }
                if (f5 > 1.0f) {
                    return f5 <= 1.0000008f ? 1.0f : Float.NaN;
                }
                return f5;
            }
            double dSqrt = Math.sqrt((d3 * d3) - ((4.0d * d2) * d));
            double d5 = d2 * 2.0d;
            float f6 = (float) ((dSqrt - d3) / d5);
            if (f6 < 0.0f) {
                if (f6 >= -8.34465E-7f) {
                    f6 = 0.0f;
                } else {
                    f6 = Float.NaN;
                }
            } else if (f6 > 1.0f) {
                if (f6 <= 1.0000008f) {
                    f6 = 1.0f;
                } else {
                    f6 = Float.NaN;
                }
            }
            if (!Float.isNaN(f6)) {
                return f6;
            }
            float f7 = (float) (((-d3) - dSqrt) / d5);
            if (f7 < 0.0f) {
                return f7 >= -8.34465E-7f ? 0.0f : Float.NaN;
            }
            if (f7 > 1.0f) {
                return f7 <= 1.0000008f ? 1.0f : Float.NaN;
            }
            return f7;
        }
        double d6 = d2 / d4;
        double d7 = d3 / d4;
        double d8 = d / d4;
        double d9 = ((d7 * 3.0d) - (d6 * d6)) / 9.0d;
        double d10 = (((((2.0d * d6) * d6) * d6) - ((9.0d * d6) * d7)) + (d8 * 27.0d)) / 54.0d;
        double d11 = d9 * d9 * d9;
        double d12 = (d10 * d10) + d11;
        double d13 = d6 / 3.0d;
        if (d12 >= 0.0d) {
            if (d12 == 0.0d) {
                float f8 = -MathHelpersKt.fastCbrt((float) d10);
                float f9 = (float) d13;
                float f10 = (2.0f * f8) - f9;
                if (f10 < 0.0f) {
                    if (f10 >= -8.34465E-7f) {
                        f10 = 0.0f;
                    } else {
                        f10 = Float.NaN;
                    }
                } else if (f10 > 1.0f) {
                    if (f10 <= 1.0000008f) {
                        f10 = 1.0f;
                    } else {
                        f10 = Float.NaN;
                    }
                }
                if (!Float.isNaN(f10)) {
                    return f10;
                }
                float f11 = (-f8) - f9;
                if (f11 < 0.0f) {
                    return f11 >= -8.34465E-7f ? 0.0f : Float.NaN;
                }
                if (f11 > 1.0f) {
                    return f11 <= 1.0000008f ? 1.0f : Float.NaN;
                }
                return f11;
            }
            double dSqrt2 = Math.sqrt(d12);
            float fFastCbrt = (float) (((double) (MathHelpersKt.fastCbrt((float) ((-d10) + dSqrt2)) - MathHelpersKt.fastCbrt((float) (d10 + dSqrt2)))) - d13);
            if (fFastCbrt < 0.0f) {
                return fFastCbrt >= -8.34465E-7f ? 0.0f : Float.NaN;
            }
            if (fFastCbrt > 1.0f) {
                return fFastCbrt <= 1.0000008f ? 1.0f : Float.NaN;
            }
            return fFastCbrt;
        }
        double dSqrt3 = Math.sqrt(-d11);
        double d14 = (-d10) / dSqrt3;
        if (d14 < -1.0d) {
            d14 = -1.0d;
        }
        if (d14 > 1.0d) {
            d14 = 1.0d;
        }
        double dAcos = Math.acos(d14);
        double dFastCbrt = MathHelpersKt.fastCbrt((float) dSqrt3) * 2.0f;
        float fCos = (float) ((Math.cos(dAcos / 3.0d) * dFastCbrt) - d13);
        if (fCos < 0.0f) {
            if (fCos >= -8.34465E-7f) {
                fCos = 0.0f;
            } else {
                fCos = Float.NaN;
            }
        } else if (fCos > 1.0f) {
            if (fCos <= 1.0000008f) {
                fCos = 1.0f;
            } else {
                fCos = Float.NaN;
            }
        }
        if (!Float.isNaN(fCos)) {
            return fCos;
        }
        float fCos2 = (float) ((Math.cos((6.283185307179586d + dAcos) / 3.0d) * dFastCbrt) - d13);
        if (fCos2 < 0.0f) {
            if (fCos2 >= -8.34465E-7f) {
                fCos2 = 0.0f;
            } else {
                fCos2 = Float.NaN;
            }
        } else if (fCos2 > 1.0f) {
            if (fCos2 <= 1.0000008f) {
                fCos2 = 1.0f;
            } else {
                fCos2 = Float.NaN;
            }
        }
        if (!Float.isNaN(fCos2)) {
            return fCos2;
        }
        float fCos3 = (float) ((dFastCbrt * Math.cos((dAcos + 12.566370614359172d) / 3.0d)) - d13);
        if (fCos3 < 0.0f) {
            return fCos3 >= -8.34465E-7f ? 0.0f : Float.NaN;
        }
        if (fCos3 > 1.0f) {
            return fCos3 <= 1.0000008f ? 1.0f : Float.NaN;
        }
        return fCos3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:6:0x000d A[PHI: r0
      0x000d: PHI (r0v2 float) = (r0v1 float), (r0v0 float) binds: [B:11:0x001c, B:5:0x000b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:7:0x000f  */
    public static final int writeValidRootInUnitRange(float f, float[] fArr, int i) {
        float f2 = 0.0f;
        if (f >= 0.0f) {
            f2 = 1.0f;
            if (f > 1.0f) {
                if (f <= 1.0000008f) {
                    f = f2;
                } else {
                    f = Float.NaN;
                }
            }
        } else if (f >= -8.34465E-7f) {
            f = f2;
        } else {
            f = Float.NaN;
        }
        fArr[i] = f;
        return !Float.isNaN(f) ? 1 : 0;
    }
}
