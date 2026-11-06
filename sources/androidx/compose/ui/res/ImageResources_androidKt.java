package androidx.compose.ui.res;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.graphics.ImageBitmap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class ImageResources_androidKt {
    public static final ImageBitmap imageResource(ImageBitmap.Companion companion, Resources resources, int i) {
        Drawable drawable = resources.getDrawable(i, null);
        Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
        return AndroidImageBitmap_androidKt.asImageBitmap(((BitmapDrawable) drawable).getBitmap());
    }
}
