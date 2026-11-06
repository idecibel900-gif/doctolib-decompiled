package expo.modules.image;

import android.graphics.RectF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ImageUtilsKt {
    public static final float calcTranslation(float f, float f2, float f3, boolean z, boolean z2) {
        if (!z) {
            return z2 ? (f3 - f2) - f : f;
        }
        if (z2) {
            f = 100.0f - f;
        }
        return (f / 100.0f) * (f3 - f2);
    }

    public static /* synthetic */ float calcXTranslation$default(float f, RectF rectF, RectF rectF2, boolean z, boolean z2, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        if ((i & 16) != 0) {
            z2 = false;
        }
        return calcXTranslation(f, rectF, rectF2, z, z2);
    }

    public static final float calcXTranslation(float f, RectF imageRect, RectF viewRect, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(imageRect, "imageRect");
        Intrinsics.checkNotNullParameter(viewRect, "viewRect");
        return calcTranslation(f, imageRect.width(), viewRect.width(), z, z2);
    }

    public static /* synthetic */ float calcYTranslation$default(float f, RectF rectF, RectF rectF2, boolean z, boolean z2, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        if ((i & 16) != 0) {
            z2 = false;
        }
        return calcYTranslation(f, rectF, rectF2, z, z2);
    }

    public static final float calcYTranslation(float f, RectF imageRect, RectF viewRect, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(imageRect, "imageRect");
        Intrinsics.checkNotNullParameter(viewRect, "viewRect");
        return calcTranslation(f, imageRect.height(), viewRect.height(), z, z2);
    }
}
