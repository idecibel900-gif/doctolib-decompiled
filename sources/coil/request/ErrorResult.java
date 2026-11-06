package coil.request;

import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ErrorResult extends ImageResult {
    private final Drawable drawable;
    private final ImageRequest request;
    private final Throwable throwable;

    @Override // coil.request.ImageResult
    public Drawable getDrawable() {
        return this.drawable;
    }

    @Override // coil.request.ImageResult
    public ImageRequest getRequest() {
        return this.request;
    }

    public final Throwable getThrowable() {
        return this.throwable;
    }

    public ErrorResult(Drawable drawable, ImageRequest imageRequest, Throwable th) {
        super(null);
        this.drawable = drawable;
        this.request = imageRequest;
        this.throwable = th;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ErrorResult)) {
            return false;
        }
        ErrorResult errorResult = (ErrorResult) obj;
        return Intrinsics.areEqual(getDrawable(), errorResult.getDrawable()) && Intrinsics.areEqual(getRequest(), errorResult.getRequest()) && Intrinsics.areEqual(this.throwable, errorResult.throwable);
    }

    public int hashCode() {
        Drawable drawable = getDrawable();
        return ((((drawable != null ? drawable.hashCode() : 0) * 31) + getRequest().hashCode()) * 31) + this.throwable.hashCode();
    }
}
