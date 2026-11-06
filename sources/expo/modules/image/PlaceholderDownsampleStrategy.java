package expo.modules.image;

import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class PlaceholderDownsampleStrategy extends CustomDownsampleStrategy {
    private final ImageViewWrapperTarget target;
    private boolean wasTriggered;

    public PlaceholderDownsampleStrategy(ImageViewWrapperTarget target) {
        Intrinsics.checkNotNullParameter(target, "target");
        this.target = target;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
    public float getScaleFactor(int i, int i2, int i3, int i4) {
        if (this.wasTriggered) {
            return 1.0f;
        }
        this.target.setPlaceholderWidth(i);
        this.target.setPlaceholderHeight(i2);
        this.wasTriggered = true;
        return 1.0f;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
    public DownsampleStrategy.SampleSizeRounding getSampleSizeRounding(int i, int i2, int i3, int i4) {
        return DownsampleStrategy.SampleSizeRounding.QUALITY;
    }
}
