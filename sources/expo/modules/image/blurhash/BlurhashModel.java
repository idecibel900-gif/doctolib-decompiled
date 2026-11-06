package expo.modules.image.blurhash;

import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class BlurhashModel {
    private final int height;
    private final Uri uri;
    private final int width;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BlurhashModel)) {
            return false;
        }
        BlurhashModel blurhashModel = (BlurhashModel) obj;
        return Intrinsics.areEqual(this.uri, blurhashModel.uri) && this.width == blurhashModel.width && this.height == blurhashModel.height;
    }

    public int hashCode() {
        return (((this.uri.hashCode() * 31) + Integer.hashCode(this.width)) * 31) + Integer.hashCode(this.height);
    }

    public String toString() {
        return "BlurhashModel(uri=" + this.uri + ", width=" + this.width + ", height=" + this.height + ")";
    }

    public BlurhashModel(Uri uri, int i, int i2) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.uri = uri;
        this.width = i;
        this.height = i2;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }
}
