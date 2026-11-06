package coil.request;

import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ImageResult {
    public /* synthetic */ ImageResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract Drawable getDrawable();

    public abstract ImageRequest getRequest();

    private ImageResult() {
    }
}
