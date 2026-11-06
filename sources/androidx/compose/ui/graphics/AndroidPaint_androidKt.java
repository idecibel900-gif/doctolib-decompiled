package androidx.compose.ui.graphics;

import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.os.Build;
import android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0;

/* JADX INFO: loaded from: classes.dex */
public abstract class AndroidPaint_androidKt {

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[android.graphics.Paint.Style.values().length];
            try {
                iArr[android.graphics.Paint.Style.STROKE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[android.graphics.Paint.Cap.values().length];
            try {
                iArr2[android.graphics.Paint.Cap.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr2[android.graphics.Paint.Cap.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[android.graphics.Paint.Cap.SQUARE.ordinal()] = 3;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[android.graphics.Paint.Join.values().length];
            try {
                iArr3[android.graphics.Paint.Join.MITER.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr3[android.graphics.Paint.Join.BEVEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr3[android.graphics.Paint.Join.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    public static final Paint Paint() {
        return new AndroidPaint();
    }

    public static final Paint asComposePaint(android.graphics.Paint paint) {
        return new AndroidPaint(paint);
    }

    public static final android.graphics.Paint makeNativePaint() {
        return new android.graphics.Paint(7);
    }

    /* JADX INFO: renamed from: setNativeBlendMode-GB0RdKg, reason: not valid java name */
    public static final void m1297setNativeBlendModeGB0RdKg(android.graphics.Paint paint, int i) {
        if (Build.VERSION.SDK_INT >= 29) {
            WrapperVerificationHelperMethods.INSTANCE.m1529setBlendModeGB0RdKg(paint, i);
        } else {
            paint.setXfermode(new PorterDuffXfermode(AndroidBlendMode_androidKt.m1271toPorterDuffModes9anfk8(i)));
        }
    }

    public static final void setNativeColorFilter(android.graphics.Paint paint, ColorFilter colorFilter) {
        paint.setColorFilter(colorFilter != null ? AndroidColorFilter_androidKt.asAndroidColorFilter(colorFilter) : null);
    }

    public static final float getNativeAlpha(android.graphics.Paint paint) {
        return paint.getAlpha() / 255.0f;
    }

    public static final void setNativeAlpha(android.graphics.Paint paint, float f) {
        paint.setAlpha((int) Math.rint(f * 255.0f));
    }

    public static final void setNativeAntiAlias(android.graphics.Paint paint, boolean z) {
        paint.setAntiAlias(z);
    }

    public static final long getNativeColor(android.graphics.Paint paint) {
        return ColorKt.Color(paint.getColor());
    }

    /* JADX INFO: renamed from: setNativeColor-4WTKRHQ, reason: not valid java name */
    public static final void m1298setNativeColor4WTKRHQ(android.graphics.Paint paint, long j) {
        paint.setColor(ColorKt.m1393toArgb8_81llA(j));
    }

    /* JADX INFO: renamed from: setNativeStyle--5YerkU, reason: not valid java name */
    public static final void m1302setNativeStyle5YerkU(android.graphics.Paint paint, int i) {
        paint.setStyle(PaintingStyle.m1460equalsimpl0(i, PaintingStyle.Companion.m1462getStrokeTiuSbCo()) ? android.graphics.Paint.Style.STROKE : android.graphics.Paint.Style.FILL);
    }

    public static final float getNativeStrokeWidth(android.graphics.Paint paint) {
        return paint.getStrokeWidth();
    }

    public static final void setNativeStrokeWidth(android.graphics.Paint paint, float f) {
        paint.setStrokeWidth(f);
    }

    public static final int getNativeStrokeCap(android.graphics.Paint paint) {
        android.graphics.Paint.Cap strokeCap = paint.getStrokeCap();
        int i = strokeCap == null ? -1 : WhenMappings.$EnumSwitchMapping$1[strokeCap.ordinal()];
        if (i == 1) {
            return StrokeCap.Companion.m1500getButtKaPHkGw();
        }
        if (i == 2) {
            return StrokeCap.Companion.m1501getRoundKaPHkGw();
        }
        if (i == 3) {
            return StrokeCap.Companion.m1502getSquareKaPHkGw();
        }
        return StrokeCap.Companion.m1500getButtKaPHkGw();
    }

    /* JADX INFO: renamed from: setNativeStrokeCap-CSYIeUk, reason: not valid java name */
    public static final void m1300setNativeStrokeCapCSYIeUk(android.graphics.Paint paint, int i) {
        android.graphics.Paint.Cap cap;
        StrokeCap.Companion companion = StrokeCap.Companion;
        if (StrokeCap.m1497equalsimpl0(i, companion.m1502getSquareKaPHkGw())) {
            cap = android.graphics.Paint.Cap.SQUARE;
        } else if (StrokeCap.m1497equalsimpl0(i, companion.m1501getRoundKaPHkGw())) {
            cap = android.graphics.Paint.Cap.ROUND;
        } else {
            cap = StrokeCap.m1497equalsimpl0(i, companion.m1500getButtKaPHkGw()) ? android.graphics.Paint.Cap.BUTT : android.graphics.Paint.Cap.BUTT;
        }
        paint.setStrokeCap(cap);
    }

    public static final int getNativeStrokeJoin(android.graphics.Paint paint) {
        android.graphics.Paint.Join strokeJoin = paint.getStrokeJoin();
        int i = strokeJoin == null ? -1 : WhenMappings.$EnumSwitchMapping$2[strokeJoin.ordinal()];
        if (i == 1) {
            return StrokeJoin.Companion.m1508getMiterLxFBmk8();
        }
        if (i == 2) {
            return StrokeJoin.Companion.m1507getBevelLxFBmk8();
        }
        if (i == 3) {
            return StrokeJoin.Companion.m1509getRoundLxFBmk8();
        }
        return StrokeJoin.Companion.m1508getMiterLxFBmk8();
    }

    /* JADX INFO: renamed from: setNativeStrokeJoin-kLtJ_vA, reason: not valid java name */
    public static final void m1301setNativeStrokeJoinkLtJ_vA(android.graphics.Paint paint, int i) {
        android.graphics.Paint.Join join;
        StrokeJoin.Companion companion = StrokeJoin.Companion;
        if (StrokeJoin.m1504equalsimpl0(i, companion.m1508getMiterLxFBmk8())) {
            join = android.graphics.Paint.Join.MITER;
        } else if (StrokeJoin.m1504equalsimpl0(i, companion.m1507getBevelLxFBmk8())) {
            join = android.graphics.Paint.Join.BEVEL;
        } else {
            join = StrokeJoin.m1504equalsimpl0(i, companion.m1509getRoundLxFBmk8()) ? android.graphics.Paint.Join.ROUND : android.graphics.Paint.Join.MITER;
        }
        paint.setStrokeJoin(join);
    }

    public static final float getNativeStrokeMiterLimit(android.graphics.Paint paint) {
        return paint.getStrokeMiter();
    }

    public static final void setNativeStrokeMiterLimit(android.graphics.Paint paint, float f) {
        paint.setStrokeMiter(f);
    }

    public static final int getNativeFilterQuality(android.graphics.Paint paint) {
        if (!paint.isFilterBitmap()) {
            return FilterQuality.Companion.m1410getNonefv9h1I();
        }
        return FilterQuality.Companion.m1409getLowfv9h1I();
    }

    /* JADX INFO: renamed from: setNativeFilterQuality-50PEsBU, reason: not valid java name */
    public static final void m1299setNativeFilterQuality50PEsBU(android.graphics.Paint paint, int i) {
        paint.setFilterBitmap(!FilterQuality.m1406equalsimpl0(i, FilterQuality.Companion.m1410getNonefv9h1I()));
    }

    public static final void setNativeShader(android.graphics.Paint paint, Shader shader) {
        paint.setShader(shader);
    }

    public static final void setNativePathEffect(android.graphics.Paint paint, PathEffect pathEffect) {
        MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(pathEffect);
        paint.setPathEffect(null);
    }
}
