package coil.transform;

import android.graphics.Bitmap;
import coil.size.Size;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes3.dex */
public interface Transformation {
    String getCacheKey();

    Object transform(Bitmap bitmap, Size size, Continuation continuation);
}
