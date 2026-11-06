package com.facebook.react.views.imagehelper;

import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.react.modules.fresco.ImageCacheControl;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class MultiSourceHelper {
    public static final MultiSourceHelper INSTANCE = new MultiSourceHelper();

    private MultiSourceHelper() {
    }

    public static final MultiSourceResult getBestSourceForSize(int i, int i2, List sources) {
        Intrinsics.checkNotNullParameter(sources, "sources");
        return getBestSourceForSize(i, i2, sources, 1.0d);
    }

    public static final MultiSourceResult getBestSourceForSize(int i, int i2, List sources, double d) {
        Intrinsics.checkNotNullParameter(sources, "sources");
        if (sources.isEmpty()) {
            return new MultiSourceResult(null, null);
        }
        if (sources.size() == 1) {
            return new MultiSourceResult((ImageSource) sources.get(0), null);
        }
        if (i <= 0 || i2 <= 0) {
            return new MultiSourceResult(null, null);
        }
        ImagePipeline imagePipeline = ImagePipelineFactory.getInstance().getImagePipeline();
        Intrinsics.checkNotNullExpressionValue(imagePipeline, "getImagePipeline(...)");
        double d2 = ((double) (i * i2)) * d;
        Iterator it = sources.iterator();
        double d3 = Double.MAX_VALUE;
        double d4 = Double.MAX_VALUE;
        ImageSource imageSource = null;
        ImageSource imageSource2 = null;
        while (it.hasNext()) {
            ImageSource imageSource3 = (ImageSource) it.next();
            double dAbs = Math.abs(1.0d - (imageSource3.getSize() / d2));
            if (dAbs < d3) {
                imageSource2 = imageSource3;
                d3 = dAbs;
            }
            if (dAbs < d4 && imageSource3.getCacheControl() != ImageCacheControl.RELOAD && (imagePipeline.isInBitmapMemoryCache(imageSource3.getUri()) || imagePipeline.isInDiskCacheSync(imageSource3.getUri()))) {
                imageSource = imageSource3;
                d4 = dAbs;
            }
        }
        return new MultiSourceResult(imageSource2, (imageSource == null || imageSource2 == null || !Intrinsics.areEqual(imageSource.getSource(), imageSource2.getSource())) ? imageSource : null);
    }

    public static final class MultiSourceResult {
        public final ImageSource bestResult;
        public final ImageSource bestResultInCache;

        public MultiSourceResult(ImageSource imageSource, ImageSource imageSource2) {
            this.bestResult = imageSource;
            this.bestResultInCache = imageSource2;
        }
    }
}
