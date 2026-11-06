package app.screeb.sdk.internal;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class x0 {
    public final int a = 4;
    public final ArrayDeque b = new ArrayDeque(4);
    public final Rect c = new Rect();
    public final Rect d = new Rect();
    public final Canvas e = new Canvas();

    public final Bitmap a() {
        synchronized (this.b) {
            while (!this.b.isEmpty()) {
                Bitmap bitmap = (Bitmap) this.b.removeFirst();
                if (!bitmap.isRecycled() && bitmap.getWidth() == 64 && bitmap.getHeight() == 64) {
                    return bitmap;
                }
            }
            Unit unit = Unit.INSTANCE;
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(64, 64, Bitmap.Config.RGB_565);
            Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
            return bitmapCreateBitmap;
        }
    }

    public final void a(Bitmap b) {
        Intrinsics.checkNotNullParameter(b, "b");
        if (b.isRecycled() || b.getWidth() != 64 || b.getHeight() != 64) {
            if (b.isRecycled()) {
                return;
            }
            b.recycle();
            return;
        }
        synchronized (this.b) {
            if (this.b.size() >= this.a) {
                b.recycle();
            } else {
                this.b.addLast(b);
                Unit unit = Unit.INSTANCE;
            }
        }
    }
}
