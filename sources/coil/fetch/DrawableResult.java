package coil.fetch;

import android.graphics.drawable.Drawable;
import coil.decode.DataSource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DrawableResult extends FetchResult {
    private final DataSource dataSource;
    private final Drawable drawable;
    private final boolean isSampled;

    public final Drawable getDrawable() {
        return this.drawable;
    }

    public final boolean isSampled() {
        return this.isSampled;
    }

    public final DataSource getDataSource() {
        return this.dataSource;
    }

    public DrawableResult(Drawable drawable, boolean z, DataSource dataSource) {
        super(null);
        this.drawable = drawable;
        this.isSampled = z;
        this.dataSource = dataSource;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DrawableResult)) {
            return false;
        }
        DrawableResult drawableResult = (DrawableResult) obj;
        return Intrinsics.areEqual(this.drawable, drawableResult.drawable) && this.isSampled == drawableResult.isSampled && this.dataSource == drawableResult.dataSource;
    }

    public int hashCode() {
        return (((this.drawable.hashCode() * 31) + Boolean.hashCode(this.isSampled)) * 31) + this.dataSource.hashCode();
    }
}
