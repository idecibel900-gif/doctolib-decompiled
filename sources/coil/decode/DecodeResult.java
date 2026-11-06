package coil.decode;

import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DecodeResult {
    private final Drawable drawable;
    private final boolean isSampled;

    public DecodeResult(Drawable drawable, boolean z) {
        this.drawable = drawable;
        this.isSampled = z;
    }

    public final Drawable getDrawable() {
        return this.drawable;
    }

    public final boolean isSampled() {
        return this.isSampled;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DecodeResult)) {
            return false;
        }
        DecodeResult decodeResult = (DecodeResult) obj;
        return Intrinsics.areEqual(this.drawable, decodeResult.drawable) && this.isSampled == decodeResult.isSampled;
    }

    public int hashCode() {
        return (this.drawable.hashCode() * 31) + Boolean.hashCode(this.isSampled);
    }
}
