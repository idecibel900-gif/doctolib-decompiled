package expo.modules.image.svg;

import android.graphics.Picture;
import android.graphics.drawable.PictureDrawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class SVGPictureDrawable extends PictureDrawable {
    private final int svgIntrinsicHeight;
    private final int svgIntrinsicWidth;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SVGPictureDrawable(Picture picture, int i, int i2) {
        super(picture);
        Intrinsics.checkNotNullParameter(picture, "picture");
        this.svgIntrinsicWidth = i;
        this.svgIntrinsicHeight = i2;
    }

    public final int getSvgIntrinsicHeight() {
        return this.svgIntrinsicHeight;
    }

    public final int getSvgIntrinsicWidth() {
        return this.svgIntrinsicWidth;
    }
}
