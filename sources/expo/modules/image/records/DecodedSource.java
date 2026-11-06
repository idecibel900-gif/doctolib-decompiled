package expo.modules.image.records;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import expo.modules.image.DecodedModelProvider;
import expo.modules.image.GlideModelProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class DecodedSource implements Source {
    private final Drawable drawable;
    private final int height;
    private final double scale;
    private final int width;

    public DecodedSource(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        this.drawable = drawable;
        this.width = drawable.getIntrinsicWidth();
        this.height = drawable.getIntrinsicHeight();
        this.scale = 1.0d;
    }

    @Override // expo.modules.image.records.Source
    public double getPixelCount() {
        return Source.DefaultImpls.getPixelCount(this);
    }

    @Override // expo.modules.image.records.Source
    public boolean usesPlaceholderContentFit() {
        return Source.DefaultImpls.usesPlaceholderContentFit(this);
    }

    @Override // expo.modules.image.records.Source
    public GlideModelProvider createGlideModelProvider(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new DecodedModelProvider(this.drawable);
    }

    @Override // expo.modules.image.records.Source
    public int getWidth() {
        return this.width;
    }

    @Override // expo.modules.image.records.Source
    public int getHeight() {
        return this.height;
    }

    @Override // expo.modules.image.records.Source
    public double getScale() {
        return this.scale;
    }

    @Override // expo.modules.image.records.Source
    public RequestOptions createGlideOptions(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        BaseRequestOptions baseRequestOptionsDiskCacheStrategy = ((RequestOptions) new RequestOptions().skipMemoryCache(true)).diskCacheStrategy(DiskCacheStrategy.NONE);
        Intrinsics.checkNotNullExpressionValue(baseRequestOptionsDiskCacheStrategy, "diskCacheStrategy(...)");
        return (RequestOptions) baseRequestOptionsDiskCacheStrategy;
    }
}
