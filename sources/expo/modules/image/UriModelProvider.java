package expo.modules.image;

import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class UriModelProvider implements GlideModelProvider {
    private final Uri uri;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof UriModelProvider) && Intrinsics.areEqual(this.uri, ((UriModelProvider) obj).uri);
    }

    public int hashCode() {
        return this.uri.hashCode();
    }

    public String toString() {
        return "UriModelProvider(uri=" + this.uri + ")";
    }

    public UriModelProvider(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.uri = uri;
    }

    @Override // expo.modules.image.GlideModelProvider
    public Uri getGlideModel() {
        return this.uri;
    }
}
