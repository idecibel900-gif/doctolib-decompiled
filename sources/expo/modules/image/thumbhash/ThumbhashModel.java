package expo.modules.image.thumbhash;

import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ThumbhashModel {
    private final Uri uri;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ThumbhashModel) && Intrinsics.areEqual(this.uri, ((ThumbhashModel) obj).uri);
    }

    public int hashCode() {
        return this.uri.hashCode();
    }

    public String toString() {
        return "ThumbhashModel(uri=" + this.uri + ")";
    }

    public ThumbhashModel(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.uri = uri;
    }

    public final Uri getUri() {
        return this.uri;
    }
}
