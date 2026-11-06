package expo.modules.image.decodedsource;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class DecodedFetcher implements DataFetcher {
    private final Drawable drawable;

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
    }

    public DecodedFetcher(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        this.drawable = drawable;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public Class getDataClass() {
        return Drawable.class;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void loadData(Priority priority, DataFetcher.DataCallback callback) {
        Intrinsics.checkNotNullParameter(priority, "priority");
        Intrinsics.checkNotNullParameter(callback, "callback");
        callback.onDataReady(this.drawable);
    }
}
