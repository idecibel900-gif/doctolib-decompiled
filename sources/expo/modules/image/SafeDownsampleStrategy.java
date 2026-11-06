package expo.modules.image;

import android.os.Build;
import com.amazon.a.a.o.b;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import expo.modules.image.records.DecodeFormat;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
public final class SafeDownsampleStrategy extends CustomDownsampleStrategy {
    private final DecodeFormat decodeFormat;
    private final Lazy maxBitmapSize$delegate;

    public SafeDownsampleStrategy(DecodeFormat decodeFormat) {
        Intrinsics.checkNotNullParameter(decodeFormat, "decodeFormat");
        this.decodeFormat = decodeFormat;
        this.maxBitmapSize$delegate = LazyKt.lazy(new Function0() { // from class: expo.modules.image.SafeDownsampleStrategy$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(SafeDownsampleStrategy.maxBitmapSize_delegate$lambda$0());
            }
        });
    }

    @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
    public float getScaleFactor(int i, int i2, int i3, int i4) {
        if (getMaxBitmapSize() <= 0 || i * i2 * this.decodeFormat.toBytes() <= getMaxBitmapSize()) {
            return 1.0f;
        }
        return (float) (((double) ((int) Math.floor(Math.sqrt(((double) (getMaxBitmapSize() / this.decodeFormat.toBytes())) / (((double) Math.min(i, i2)) / ((double) Math.max(i, i2))))))) / ((double) Math.max(i, i2)));
    }

    @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
    public DownsampleStrategy.SampleSizeRounding getSampleSizeRounding(int i, int i2, int i3, int i4) {
        return DownsampleStrategy.SampleSizeRounding.MEMORY;
    }

    private final int getMaxBitmapSize() {
        return ((Number) this.maxBitmapSize$delegate.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int maxBitmapSize_delegate$lambda$0() {
        if (Build.VERSION.SDK_INT < 29) {
            return -1;
        }
        try {
            Method method = Class.forName(b.at).getMethod("getInt", String.class, Integer.TYPE);
            method.setAccessible(true);
            Object objInvoke = method.invoke(null, "ro.hwui.max_texture_allocation_size", 104857600);
            Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.Int");
            return RangesKt.coerceAtLeast(((Integer) objInvoke).intValue(), 104857600);
        } catch (Throwable unused) {
            return -1;
        }
    }

    @Override // expo.modules.image.CustomDownsampleStrategy
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SafeDownsampleStrategy) && this.decodeFormat == ((SafeDownsampleStrategy) obj).decodeFormat;
    }

    @Override // expo.modules.image.CustomDownsampleStrategy
    public int hashCode() {
        return (super.hashCode() * 31) + this.decodeFormat.hashCode();
    }
}
