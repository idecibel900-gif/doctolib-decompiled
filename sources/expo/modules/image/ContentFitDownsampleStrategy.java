package expo.modules.image;

import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import expo.modules.image.enums.ContentFit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ContentFitDownsampleStrategy extends CustomDownsampleStrategy {
    private final ContentFit contentFit;
    private final ImageViewWrapperTarget target;
    private boolean wasTriggered;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ContentFit.values().length];
            try {
                iArr[ContentFit.Contain.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ContentFit.Cover.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ContentFit.ScaleDown.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ContentFitDownsampleStrategy(ImageViewWrapperTarget target, ContentFit contentFit) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(contentFit, "contentFit");
        this.target = target;
        this.contentFit = contentFit;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
    public float getScaleFactor(int i, int i2, int i3, int i4) {
        if (!this.wasTriggered) {
            this.target.setSourceWidth(i);
            this.target.setSourceHeight(i2);
            this.wasTriggered = true;
        }
        if (i3 == Integer.MIN_VALUE || i4 == Integer.MIN_VALUE) {
            return 1.0f;
        }
        return Math.min(1.0f, calculateScaleFactor(i, i2, i3, i4));
    }

    private final float calculateScaleFactor(float f, float f2, float f3, float f4) {
        int i = WhenMappings.$EnumSwitchMapping$0[this.contentFit.ordinal()];
        if (i == 1) {
            return Math.min(f3 / f, f4 / f2);
        }
        if (i == 2) {
            return Float.max(f3 / f, f4 / f2);
        }
        if (i != 3) {
            return 1.0f;
        }
        if (f3 < f || f4 < f2) {
            return Math.min(f3 / f, f4 / f2);
        }
        return 1.0f;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
    public DownsampleStrategy.SampleSizeRounding getSampleSizeRounding(int i, int i2, int i3, int i4) {
        return DownsampleStrategy.SampleSizeRounding.QUALITY;
    }
}
