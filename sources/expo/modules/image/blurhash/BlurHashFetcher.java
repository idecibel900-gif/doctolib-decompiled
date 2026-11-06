package expo.modules.image.blurhash;

import android.graphics.Bitmap;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class BlurHashFetcher implements DataFetcher {
    private final String blurHash;
    private final int height;
    private final float punch;
    private final int width;

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
    }

    public BlurHashFetcher(String str, int i, int i2, float f) {
        this.blurHash = str;
        this.width = i;
        this.height = i2;
        this.punch = f;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public Class getDataClass() {
        return Bitmap.class;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void loadData(Priority priority, DataFetcher.DataCallback callback) {
        Intrinsics.checkNotNullParameter(priority, "priority");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Bitmap bitmapDecode$default = BlurhashDecoder.decode$default(BlurhashDecoder.INSTANCE, this.blurHash, this.width, this.height, this.punch, false, 16, null);
        if (bitmapDecode$default == null) {
            callback.onLoadFailed(new BlurhashDecodingFailure(this.blurHash));
        } else {
            callback.onDataReady(bitmapDecode$default);
        }
    }
}
