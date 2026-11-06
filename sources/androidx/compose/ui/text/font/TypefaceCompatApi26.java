package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Paint;
import androidx.compose.ui.unit.AndroidDensity_androidKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.util.ListUtilsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
final class TypefaceCompatApi26 {
    public static final TypefaceCompatApi26 INSTANCE = new TypefaceCompatApi26();
    private static ThreadLocal threadLocalPaint = new ThreadLocal();

    private TypefaceCompatApi26() {
    }

    public final android.graphics.Typeface setFontVariationSettings(android.graphics.Typeface typeface, FontVariation.Settings settings, Context context) {
        if (typeface == null) {
            return null;
        }
        if (settings.getSettings().isEmpty()) {
            return typeface;
        }
        Paint paint = (Paint) threadLocalPaint.get();
        if (paint == null) {
            paint = new Paint();
            threadLocalPaint.set(paint);
        }
        paint.setTypeface(typeface);
        paint.setFontVariationSettings(toAndroidString(settings, context));
        return paint.getTypeface();
    }

    private final String toAndroidString(FontVariation.Settings settings, Context context) {
        final Density Density = AndroidDensity_androidKt.Density(context);
        return ListUtilsKt.fastJoinToString$default(settings.getSettings(), null, null, null, 0, null, new Function1() { // from class: androidx.compose.ui.text.font.TypefaceCompatApi26.toAndroidString.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(FontVariation.Setting setting) {
                return '\'' + setting.getAxisName() + "' " + setting.toVariationValue(Density);
            }
        }, 31, null);
    }
}
