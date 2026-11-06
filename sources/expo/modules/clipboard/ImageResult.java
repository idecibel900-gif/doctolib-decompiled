package expo.modules.clipboard;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import com.google.firebase.messaging.Constants;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ImageResult {
    private final String base64Image;
    private final int height;
    private final int width;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageResult)) {
            return false;
        }
        ImageResult imageResult = (ImageResult) obj;
        return Intrinsics.areEqual(this.base64Image, imageResult.base64Image) && this.width == imageResult.width && this.height == imageResult.height;
    }

    public int hashCode() {
        return (((this.base64Image.hashCode() * 31) + Integer.hashCode(this.width)) * 31) + Integer.hashCode(this.height);
    }

    public String toString() {
        return "ImageResult(base64Image=" + this.base64Image + ", width=" + this.width + ", height=" + this.height + ")";
    }

    public ImageResult(String base64Image, int i, int i2) {
        Intrinsics.checkNotNullParameter(base64Image, "base64Image");
        this.base64Image = base64Image;
        this.width = i;
        this.height = i2;
    }

    public final Bundle toBundle() {
        return BundleKt.bundleOf(TuplesKt.to(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, this.base64Image), TuplesKt.to("size", BundleKt.bundleOf(TuplesKt.to("width", Integer.valueOf(this.width)), TuplesKt.to("height", Integer.valueOf(this.height)))));
    }
}
