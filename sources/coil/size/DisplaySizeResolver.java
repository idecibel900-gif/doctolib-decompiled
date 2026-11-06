package coil.size;

import android.content.Context;
import android.util.DisplayMetrics;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DisplaySizeResolver implements SizeResolver {
    private final Context context;

    public DisplaySizeResolver(Context context) {
        this.context = context;
    }

    @Override // coil.size.SizeResolver
    public Object size(Continuation continuation) {
        DisplayMetrics displayMetrics = this.context.getResources().getDisplayMetrics();
        Dimension.Pixels pixelsDimension = Dimensions.Dimension(Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels));
        return new Size(pixelsDimension, pixelsDimension);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DisplaySizeResolver) && Intrinsics.areEqual(this.context, ((DisplaySizeResolver) obj).context);
    }

    public int hashCode() {
        return this.context.hashCode();
    }
}
