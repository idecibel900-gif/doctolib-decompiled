package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public abstract class PaintCompat {
    private static final ThreadLocal sRectThreadLocal = new ThreadLocal();

    public static boolean hasGlyph(Paint paint, String str) {
        return Api23Impl.hasGlyph(paint, str);
    }

    public static boolean setBlendMode(Paint paint, BlendModeCompat blendModeCompat) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.setBlendMode(paint, blendModeCompat != null ? BlendModeUtils.Api29Impl.obtainBlendModeFromCompat(blendModeCompat) : null);
            return true;
        }
        if (blendModeCompat != null) {
            PorterDuff.Mode modeObtainPorterDuffFromCompat = BlendModeUtils.obtainPorterDuffFromCompat(blendModeCompat);
            paint.setXfermode(modeObtainPorterDuffFromCompat != null ? new PorterDuffXfermode(modeObtainPorterDuffFromCompat) : null);
            return modeObtainPorterDuffFromCompat != null;
        }
        paint.setXfermode(null);
        return true;
    }

    static class Api29Impl {
        static void setBlendMode(Paint paint, Object obj) {
            paint.setBlendMode((BlendMode) obj);
        }
    }

    static class Api23Impl {
        static boolean hasGlyph(Paint paint, String str) {
            return paint.hasGlyph(str);
        }
    }
}
