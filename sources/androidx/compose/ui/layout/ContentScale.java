package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Size;

/* JADX INFO: loaded from: classes.dex */
public interface ContentScale {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* JADX INFO: renamed from: computeScaleFactor-H7hwNQA, reason: not valid java name */
    long mo1834computeScaleFactorH7hwNQA(long j, long j2);

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final ContentScale Crop = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$Crop$1
            @Override // androidx.compose.ui.layout.ContentScale
            /* JADX INFO: renamed from: computeScaleFactor-H7hwNQA */
            public long mo1834computeScaleFactorH7hwNQA(long j, long j2) {
                float fM1840computeFillMaxDimensioniLBOSCw = ContentScaleKt.m1840computeFillMaxDimensioniLBOSCw(j, j2);
                return ScaleFactorKt.ScaleFactor(fM1840computeFillMaxDimensioniLBOSCw, fM1840computeFillMaxDimensioniLBOSCw);
            }
        };
        private static final ContentScale Fit = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$Fit$1
            @Override // androidx.compose.ui.layout.ContentScale
            /* JADX INFO: renamed from: computeScaleFactor-H7hwNQA */
            public long mo1834computeScaleFactorH7hwNQA(long j, long j2) {
                float fM1841computeFillMinDimensioniLBOSCw = ContentScaleKt.m1841computeFillMinDimensioniLBOSCw(j, j2);
                return ScaleFactorKt.ScaleFactor(fM1841computeFillMinDimensioniLBOSCw, fM1841computeFillMinDimensioniLBOSCw);
            }
        };
        private static final ContentScale FillHeight = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$FillHeight$1
            @Override // androidx.compose.ui.layout.ContentScale
            /* JADX INFO: renamed from: computeScaleFactor-H7hwNQA */
            public long mo1834computeScaleFactorH7hwNQA(long j, long j2) {
                float fM1839computeFillHeightiLBOSCw = ContentScaleKt.m1839computeFillHeightiLBOSCw(j, j2);
                return ScaleFactorKt.ScaleFactor(fM1839computeFillHeightiLBOSCw, fM1839computeFillHeightiLBOSCw);
            }
        };
        private static final ContentScale FillWidth = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$FillWidth$1
            @Override // androidx.compose.ui.layout.ContentScale
            /* JADX INFO: renamed from: computeScaleFactor-H7hwNQA */
            public long mo1834computeScaleFactorH7hwNQA(long j, long j2) {
                float fM1842computeFillWidthiLBOSCw = ContentScaleKt.m1842computeFillWidthiLBOSCw(j, j2);
                return ScaleFactorKt.ScaleFactor(fM1842computeFillWidthiLBOSCw, fM1842computeFillWidthiLBOSCw);
            }
        };
        private static final ContentScale Inside = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$Inside$1
            @Override // androidx.compose.ui.layout.ContentScale
            /* JADX INFO: renamed from: computeScaleFactor-H7hwNQA */
            public long mo1834computeScaleFactorH7hwNQA(long j, long j2) {
                if (Size.m1261getWidthimpl(j) > Size.m1261getWidthimpl(j2) || Size.m1259getHeightimpl(j) > Size.m1259getHeightimpl(j2)) {
                    float fM1841computeFillMinDimensioniLBOSCw = ContentScaleKt.m1841computeFillMinDimensioniLBOSCw(j, j2);
                    return ScaleFactorKt.ScaleFactor(fM1841computeFillMinDimensioniLBOSCw, fM1841computeFillMinDimensioniLBOSCw);
                }
                return ScaleFactorKt.ScaleFactor(1.0f, 1.0f);
            }
        };
        private static final FixedScale None = new FixedScale(1.0f);
        private static final ContentScale FillBounds = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$FillBounds$1
            @Override // androidx.compose.ui.layout.ContentScale
            /* JADX INFO: renamed from: computeScaleFactor-H7hwNQA */
            public long mo1834computeScaleFactorH7hwNQA(long j, long j2) {
                return ScaleFactorKt.ScaleFactor(ContentScaleKt.m1842computeFillWidthiLBOSCw(j, j2), ContentScaleKt.m1839computeFillHeightiLBOSCw(j, j2));
            }
        };

        private Companion() {
        }

        public final ContentScale getCrop() {
            return Crop;
        }

        public final ContentScale getFit() {
            return Fit;
        }

        public final ContentScale getInside() {
            return Inside;
        }

        public final FixedScale getNone() {
            return None;
        }
    }
}
