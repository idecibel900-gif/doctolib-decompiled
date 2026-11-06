package expo.modules.image;

import android.net.Uri;
import expo.modules.image.thumbhash.ThumbhashModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ThumbhashModelProvider implements GlideModelProvider {
    private final Uri uri;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ThumbhashModelProvider) && Intrinsics.areEqual(this.uri, ((ThumbhashModelProvider) obj).uri);
    }

    public int hashCode() {
        return this.uri.hashCode();
    }

    public String toString() {
        return "ThumbhashModelProvider(uri=" + this.uri + ")";
    }

    public ThumbhashModelProvider(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.uri = uri;
    }

    @Override // expo.modules.image.GlideModelProvider
    public ThumbhashModel getGlideModel() {
        return new ThumbhashModel(this.uri);
    }
}
