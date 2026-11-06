package expo.modules.image.svg;

import android.graphics.RectF;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.SimpleResource;
import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParseException;
import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class SVGDecoder implements ResourceDecoder {
    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(InputStream source, Options options) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(options, "options");
        return true;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource decode(InputStream source, int i, int i2, Options options) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(options, "options");
        try {
            SVG fromInputStream = SVG.getFromInputStream(source);
            Intrinsics.checkNotNullExpressionValue(fromInputStream, "getFromInputStream(...)");
            if (fromInputStream.getDocumentViewBox() == null) {
                float documentWidth = fromInputStream.getDocumentWidth();
                float documentHeight = fromInputStream.getDocumentHeight();
                if (documentWidth != -1.0f && documentHeight != -1.0f) {
                    fromInputStream.setDocumentViewBox(0.0f, 0.0f, documentWidth, documentHeight);
                }
            }
            RectF documentViewBox = fromInputStream.getDocumentViewBox();
            if (documentViewBox != null && documentViewBox.width() > 0.0f && documentViewBox.height() > 0.0f) {
                float fWidth = i > 0 ? i / documentViewBox.width() : Float.POSITIVE_INFINITY;
                float fHeight = i2 > 0 ? i2 / documentViewBox.height() : Float.POSITIVE_INFINITY;
                float fMin = (Math.abs(fWidth) > Float.MAX_VALUE && Math.abs(fHeight) > Float.MAX_VALUE) ? 1.0f : Math.min(fWidth, fHeight);
                if (Math.abs(fMin) <= Float.MAX_VALUE && fMin > 0.0f) {
                    fromInputStream.setDocumentWidth(documentViewBox.width() * fMin);
                    fromInputStream.setDocumentHeight(documentViewBox.height() * fMin);
                }
            } else if (i > 0 && i2 > 0) {
                fromInputStream.setDocumentWidth(i);
                fromInputStream.setDocumentHeight(i2);
            }
            return new SimpleResource(fromInputStream);
        } catch (SVGParseException e) {
            throw new IOException("Cannot load SVG from stream", e);
        }
    }
}
