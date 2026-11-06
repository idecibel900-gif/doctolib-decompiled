package expo.modules.image.okhttp;

import com.bumptech.glide.load.model.GlideUrl;
import expo.modules.image.events.OkHttpProgressListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class GlideUrlWrapper {
    private final GlideUrl glideUrl;
    private OkHttpProgressListener progressListener;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GlideUrlWrapper) && Intrinsics.areEqual(this.glideUrl, ((GlideUrlWrapper) obj).glideUrl);
    }

    public int hashCode() {
        return this.glideUrl.hashCode();
    }

    public GlideUrlWrapper(GlideUrl glideUrl) {
        Intrinsics.checkNotNullParameter(glideUrl, "glideUrl");
        this.glideUrl = glideUrl;
    }

    public final GlideUrl getGlideUrl() {
        return this.glideUrl;
    }

    public final OkHttpProgressListener getProgressListener() {
        return this.progressListener;
    }

    public final void setProgressListener(OkHttpProgressListener okHttpProgressListener) {
        this.progressListener = okHttpProgressListener;
    }

    public String toString() {
        String string = this.glideUrl.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
