package expo.modules.image;

import android.net.Uri;
import expo.modules.image.blurhash.BlurhashModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class BlurhashModelProvider implements GlideModelProvider {
    private final int height;
    private final Uri uri;
    private final int width;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BlurhashModelProvider)) {
            return false;
        }
        BlurhashModelProvider blurhashModelProvider = (BlurhashModelProvider) obj;
        return Intrinsics.areEqual(this.uri, blurhashModelProvider.uri) && this.width == blurhashModelProvider.width && this.height == blurhashModelProvider.height;
    }

    public int hashCode() {
        return (((this.uri.hashCode() * 31) + Integer.hashCode(this.width)) * 31) + Integer.hashCode(this.height);
    }

    public String toString() {
        return "BlurhashModelProvider(uri=" + this.uri + ", width=" + this.width + ", height=" + this.height + ")";
    }

    public BlurhashModelProvider(Uri uri, int i, int i2) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.uri = uri;
        this.width = i;
        this.height = i2;
    }

    @Override // expo.modules.image.GlideModelProvider
    public BlurhashModel getGlideModel() {
        return new BlurhashModel(this.uri, this.width, this.height);
    }
}
