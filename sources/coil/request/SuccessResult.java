package coil.request;

import android.graphics.drawable.Drawable;
import coil.decode.DataSource;
import coil.memory.MemoryCache;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class SuccessResult extends ImageResult {
    private final DataSource dataSource;
    private final String diskCacheKey;
    private final Drawable drawable;
    private final boolean isPlaceholderCached;
    private final boolean isSampled;
    private final MemoryCache.Key memoryCacheKey;
    private final ImageRequest request;

    public /* synthetic */ SuccessResult(Drawable drawable, ImageRequest imageRequest, DataSource dataSource, MemoryCache.Key key, String str, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(drawable, imageRequest, dataSource, (i & 8) != 0 ? null : key, (i & 16) != 0 ? null : str, (i & 32) != 0 ? false : z, (i & 64) != 0 ? false : z2);
    }

    @Override // coil.request.ImageResult
    public Drawable getDrawable() {
        return this.drawable;
    }

    @Override // coil.request.ImageResult
    public ImageRequest getRequest() {
        return this.request;
    }

    public final DataSource getDataSource() {
        return this.dataSource;
    }

    public final boolean isPlaceholderCached() {
        return this.isPlaceholderCached;
    }

    public SuccessResult(Drawable drawable, ImageRequest imageRequest, DataSource dataSource, MemoryCache.Key key, String str, boolean z, boolean z2) {
        super(null);
        this.drawable = drawable;
        this.request = imageRequest;
        this.dataSource = dataSource;
        this.memoryCacheKey = key;
        this.diskCacheKey = str;
        this.isSampled = z;
        this.isPlaceholderCached = z2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SuccessResult)) {
            return false;
        }
        SuccessResult successResult = (SuccessResult) obj;
        return Intrinsics.areEqual(getDrawable(), successResult.getDrawable()) && Intrinsics.areEqual(getRequest(), successResult.getRequest()) && this.dataSource == successResult.dataSource && Intrinsics.areEqual(this.memoryCacheKey, successResult.memoryCacheKey) && Intrinsics.areEqual(this.diskCacheKey, successResult.diskCacheKey) && this.isSampled == successResult.isSampled && this.isPlaceholderCached == successResult.isPlaceholderCached;
    }

    public int hashCode() {
        int iHashCode = ((((getDrawable().hashCode() * 31) + getRequest().hashCode()) * 31) + this.dataSource.hashCode()) * 31;
        MemoryCache.Key key = this.memoryCacheKey;
        int iHashCode2 = (iHashCode + (key != null ? key.hashCode() : 0)) * 31;
        String str = this.diskCacheKey;
        return ((((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31) + Boolean.hashCode(this.isSampled)) * 31) + Boolean.hashCode(this.isPlaceholderCached);
    }
}
