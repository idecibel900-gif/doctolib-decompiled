package expo.modules.image.dataurls;

import android.util.Base64;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class Base64DataFetcher implements DataFetcher {
    private final String data;

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
    }

    public Base64DataFetcher(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public Class getDataClass() {
        return ByteBuffer.class;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void loadData(Priority priority, DataFetcher.DataCallback callback) {
        Intrinsics.checkNotNullParameter(priority, "priority");
        Intrinsics.checkNotNullParameter(callback, "callback");
        callback.onDataReady(ByteBuffer.wrap(Base64.decode(getBase64Section(), 0)));
    }

    private final String getBase64Section() {
        String strSubstring = this.data.substring(StringsKt.indexOf$default((CharSequence) this.data, ',', 0, false, 6, (Object) null) + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }
}
