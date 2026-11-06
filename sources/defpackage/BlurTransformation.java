package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import coil.size.Size;
import coil.transform.Transformation;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class BlurTransformation implements Transformation {
    private final String cacheKey;
    private final Context context;
    private final float radius;

    public BlurTransformation(Context context, float f) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.radius = f;
        this.cacheKey = BlurTransformation.class.getName() + '-' + f;
    }

    @Override // coil.transform.Transformation
    public String getCacheKey() {
        return this.cacheKey;
    }

    @Override // coil.transform.Transformation
    public Object transform(Bitmap bitmap, Size size, Continuation continuation) {
        return BlurTransformationKt.blur$default(bitmap, this.context, this.radius, false, 4, null);
    }
}
