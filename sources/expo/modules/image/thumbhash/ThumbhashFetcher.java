package expo.modules.image.thumbhash;

import android.graphics.Bitmap;
import android.util.Base64;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ThumbhashFetcher implements DataFetcher {
    private final String thumbhash;

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
    }

    public ThumbhashFetcher(String str) {
        this.thumbhash = str;
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
        try {
            byte[] bArrDecode = Base64.decode(this.thumbhash, 0);
            ThumbhashDecoder thumbhashDecoder = ThumbhashDecoder.INSTANCE;
            Intrinsics.checkNotNull(bArrDecode);
            callback.onDataReady(thumbhashDecoder.thumbHashToBitmap(bArrDecode));
        } catch (Exception e) {
            callback.onLoadFailed(new ThumbhashDecodingFailure(this.thumbhash, e));
        }
    }
}
