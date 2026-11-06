package expo.modules.image;

import com.bumptech.glide.load.model.GlideUrl;
import expo.modules.image.okhttp.GlideUrlWrapper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class UrlModelProvider implements GlideModelProvider {
    private final GlideUrl glideUrl;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof UrlModelProvider) && Intrinsics.areEqual(this.glideUrl, ((UrlModelProvider) obj).glideUrl);
    }

    public int hashCode() {
        return this.glideUrl.hashCode();
    }

    public String toString() {
        return "UrlModelProvider(glideUrl=" + this.glideUrl + ")";
    }

    public UrlModelProvider(GlideUrl glideUrl) {
        Intrinsics.checkNotNullParameter(glideUrl, "glideUrl");
        this.glideUrl = glideUrl;
    }

    @Override // expo.modules.image.GlideModelProvider
    public GlideUrlWrapper getGlideModel() {
        return new GlideUrlWrapper(this.glideUrl);
    }
}
