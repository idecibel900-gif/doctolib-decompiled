package expo.modules.image.decodedsource;

import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class DecodedModel {
    private final Drawable drawable;

    public DecodedModel(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        this.drawable = drawable;
    }

    public final Drawable getDrawable() {
        return this.drawable;
    }
}
