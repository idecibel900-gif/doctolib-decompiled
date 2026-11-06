package com.horcrux.svg;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.facebook.react.bridge.ReactContext;
import java.util.HashMap;

/* JADX INFO: loaded from: classes4.dex */
class FeBlendView extends FilterPrimitiveView {
    String mIn1;
    String mIn2;
    FilterProperties$FeBlendMode mMode;

    public FeBlendView(ReactContext reactContext) {
        super(reactContext);
        this.mFilterSubregion.mX = new SVGLength(0.0d);
        this.mFilterSubregion.mY = new SVGLength(0.0d);
        this.mFilterSubregion.mW = new SVGLength("100%");
        this.mFilterSubregion.mH = new SVGLength("100%");
    }

    public void setIn1(String str) {
        this.mIn1 = str;
        invalidate();
    }

    public void setIn2(String str) {
        this.mIn2 = str;
        invalidate();
    }

    public void setMode(String str) {
        this.mMode = FilterProperties$FeBlendMode.getEnum(str);
        invalidate();
    }

    @Override // com.horcrux.svg.FilterPrimitiveView
    public Bitmap applyFilter(HashMap map, Bitmap bitmap) {
        Bitmap source = FilterPrimitiveView.getSource(map, bitmap, this.mIn1);
        Bitmap source2 = FilterPrimitiveView.getSource(map, bitmap, this.mIn2);
        if (this.mMode == FilterProperties$FeBlendMode.MULTIPLY) {
            return CustomFilter.apply(source, source2, new CustomFilterFunction() { // from class: com.horcrux.svg.FeBlendView$$ExternalSyntheticLambda0
                @Override // com.horcrux.svg.CustomFilterFunction
                public final float[] execute(float[] fArr, float[] fArr2) {
                    return FeBlendView.$r8$lambda$fcN02mS9XkwgmTwBUMpqC8NZxjg(fArr, fArr2);
                }
            });
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(1);
        canvas.drawBitmap(source, 0.0f, 0.0f, paint);
        int i = AnonymousClass1.$SwitchMap$com$horcrux$svg$FilterProperties$FeBlendMode[this.mMode.ordinal()];
        if (i == 1 || i == 2) {
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        } else if (i == 3) {
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SCREEN));
        } else if (i == 4) {
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.LIGHTEN));
        } else if (i == 5) {
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DARKEN));
        }
        canvas.drawBitmap(source2, 0.0f, 0.0f, paint);
        return bitmapCreateBitmap;
    }

    public static /* synthetic */ float[] $r8$lambda$fcN02mS9XkwgmTwBUMpqC8NZxjg(float[] fArr, float[] fArr2) {
        float f = fArr[0];
        float f2 = 1.0f - f;
        float f3 = fArr2[0];
        float f4 = 1.0f - f3;
        float f5 = fArr[1] * f;
        float f6 = fArr2[1];
        float f7 = (f5 * f4) + (f6 * f3 * f2) + (f5 * f6 * f3);
        float f8 = fArr[2] * f;
        float f9 = fArr2[2];
        float f10 = fArr[3] * f;
        float f11 = fArr2[3];
        return new float[]{1.0f - (f2 * f4), f7, (f8 * f4) + (f9 * f3 * f2) + (f8 * f9 * f3), (f4 * f10) + (f11 * f3 * f2) + (f10 * f11 * f3)};
    }

    /* JADX INFO: renamed from: com.horcrux.svg.FeBlendView$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$horcrux$svg$FilterProperties$FeBlendMode;

        static {
            int[] iArr = new int[FilterProperties$FeBlendMode.values().length];
            $SwitchMap$com$horcrux$svg$FilterProperties$FeBlendMode = iArr;
            try {
                iArr[FilterProperties$FeBlendMode.UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$horcrux$svg$FilterProperties$FeBlendMode[FilterProperties$FeBlendMode.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$horcrux$svg$FilterProperties$FeBlendMode[FilterProperties$FeBlendMode.SCREEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$horcrux$svg$FilterProperties$FeBlendMode[FilterProperties$FeBlendMode.LIGHTEN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$horcrux$svg$FilterProperties$FeBlendMode[FilterProperties$FeBlendMode.DARKEN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$horcrux$svg$FilterProperties$FeBlendMode[FilterProperties$FeBlendMode.MULTIPLY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }
}
