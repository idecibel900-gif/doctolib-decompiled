package expo.modules.image;

import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;

/* JADX INFO: loaded from: classes4.dex */
public final class NoopDownsampleStrategy extends DownsampleStrategy {
    public static final NoopDownsampleStrategy INSTANCE = new NoopDownsampleStrategy();

    @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
    public float getScaleFactor(int i, int i2, int i3, int i4) {
        return 1.0f;
    }

    private NoopDownsampleStrategy() {
    }

    @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
    public DownsampleStrategy.SampleSizeRounding getSampleSizeRounding(int i, int i2, int i3, int i4) {
        return DownsampleStrategy.SampleSizeRounding.QUALITY;
    }
}
