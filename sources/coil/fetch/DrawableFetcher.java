package coil.fetch;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import coil.ImageLoader;
import coil.decode.DataSource;
import coil.request.Options;
import coil.util.DrawableUtils;
import coil.util.Utils;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes3.dex */
public final class DrawableFetcher implements Fetcher {
    private final Drawable data;
    private final Options options;

    public DrawableFetcher(Drawable drawable, Options options) {
        this.data = drawable;
        this.options = options;
    }

    @Override // coil.fetch.Fetcher
    public Object fetch(Continuation continuation) {
        Drawable bitmapDrawable;
        boolean zIsVector = Utils.isVector(this.data);
        if (zIsVector) {
            bitmapDrawable = new BitmapDrawable(this.options.getContext().getResources(), DrawableUtils.INSTANCE.convertToBitmap(this.data, this.options.getConfig(), this.options.getSize(), this.options.getScale(), this.options.getAllowInexactSize()));
        } else {
            bitmapDrawable = this.data;
        }
        return new DrawableResult(bitmapDrawable, zIsVector, DataSource.MEMORY);
    }

    public static final class Factory implements Fetcher.Factory {
        @Override // coil.fetch.Fetcher.Factory
        public Fetcher create(Drawable drawable, Options options, ImageLoader imageLoader) {
            return new DrawableFetcher(drawable, options);
        }
    }
}
