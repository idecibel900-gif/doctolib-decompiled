package expo.modules.image.svg;

import android.content.Context;
import android.graphics.Picture;
import android.graphics.RectF;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.SimpleResource;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGStylerKt;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import expo.modules.image.CustomOptions;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class SVGDrawableTranscoder implements ResourceTranscoder {
    private final Context context;

    public SVGDrawableTranscoder(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @Override // com.bumptech.glide.load.resource.transcode.ResourceTranscoder
    public Resource transcode(Resource toTranscode, Options options) {
        Intrinsics.checkNotNullParameter(toTranscode, "toTranscode");
        Intrinsics.checkNotNullParameter(options, "options");
        Object obj = toTranscode.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        SVG svg = (SVG) obj;
        RectF documentViewBox = svg.getDocumentViewBox();
        int iHeight = IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING;
        int iWidth = documentViewBox != null ? (int) documentViewBox.width() : 512;
        RectF documentViewBox2 = svg.getDocumentViewBox();
        if (documentViewBox2 != null) {
            iHeight = (int) documentViewBox2.height();
        }
        Integer num = (Integer) options.get(CustomOptions.INSTANCE.getTintColor());
        if (num != null) {
            SVGStylerKt.applyTintColor(svg, num.intValue());
        }
        Picture pictureRenderToPicture = svg.renderToPicture();
        Intrinsics.checkNotNullExpressionValue(pictureRenderToPicture, "renderToPicture(...)");
        return new SimpleResource(new SVGPictureDrawable(pictureRenderToPicture, iWidth, iHeight));
    }
}
