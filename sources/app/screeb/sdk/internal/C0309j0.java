package app.screeb.sdk.internal;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.PixelCopy;
import android.view.SurfaceView;
import android.view.Window;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: app.screeb.sdk.internal.j0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0309j0 {
    public final HandlerThread a;
    public final Handler b;
    public volatile Bitmap c;
    public volatile Bitmap d;
    public final AtomicBoolean e;
    public volatile boolean f;

    public C0309j0() {
        HandlerThread handlerThread = new HandlerThread("screeb-mirror-screenshot", 10);
        handlerThread.start();
        this.a = handlerThread;
        this.b = new Handler(handlerThread.getLooper());
        this.e = new AtomicBoolean(false);
    }

    public static final void a(final C0309j0 c0309j0) {
        if (c0309j0.e.get()) {
            c0309j0.b.postDelayed(new Runnable() { // from class: app.screeb.sdk.internal.j0$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    C0309j0.b(this.f$0);
                }
            }, 1000L);
            return;
        }
        Bitmap bitmap = c0309j0.c;
        if (bitmap != null) {
            bitmap.recycle();
        }
        c0309j0.c = null;
        Bitmap bitmap2 = c0309j0.d;
        if (bitmap2 != null) {
            bitmap2.recycle();
        }
        c0309j0.d = null;
        try {
            c0309j0.a.quitSafely();
        } catch (Throwable unused) {
            Unit unit = Unit.INSTANCE;
        }
    }

    public static final void a(C0309j0 c0309j0, Bitmap bitmap, Function1 function1, int i) {
        c0309j0.e.set(false);
        if (c0309j0.f) {
            if (c0309j0.c == bitmap) {
                c0309j0.c = null;
            }
            try {
                bitmap.recycle();
            } catch (Throwable unused) {
            }
            try {
                c0309j0.a.quitSafely();
            } catch (Throwable unused2) {
            }
            function1.invoke(null);
            return;
        }
        if (i == 0) {
            function1.invoke(bitmap);
            return;
        }
        Z z = Z.b;
        Y.a();
        Z.b("Mirror", "PixelCopy failed code=" + i);
        function1.invoke(null);
    }

    public static final void b(C0309j0 c0309j0) {
        if (c0309j0.f && c0309j0.e.get()) {
            c0309j0.c = null;
            c0309j0.d = null;
            try {
                c0309j0.a.quitSafely();
            } catch (Throwable unused) {
            }
        }
    }

    public static final void b(C0309j0 c0309j0, Bitmap bitmap, Function1 function1, int i) {
        c0309j0.e.set(false);
        if (c0309j0.f) {
            if (c0309j0.d == bitmap) {
                c0309j0.d = null;
            }
            try {
                bitmap.recycle();
            } catch (Throwable unused) {
            }
            try {
                c0309j0.a.quitSafely();
            } catch (Throwable unused2) {
            }
            function1.invoke(null);
            return;
        }
        if (i == 0) {
            function1.invoke(bitmap);
            return;
        }
        Z z = Z.b;
        Y.a();
        Z.b("Mirror", "Surface PixelCopy failed code=" + i);
        function1.invoke(null);
    }

    public final Bitmap a(boolean z, int i, int i2) {
        Bitmap bitmap = z ? this.d : this.c;
        if (bitmap != null && !bitmap.isRecycled()) {
            if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
                return bitmap;
            }
            if (i * i2 * 2 <= bitmap.getAllocationByteCount()) {
                try {
                    bitmap.reconfigure(i, i2, Bitmap.Config.RGB_565);
                    return bitmap;
                } catch (Throwable unused) {
                }
            }
            bitmap.recycle();
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.RGB_565);
        if (z) {
            this.d = bitmapCreateBitmap;
        } else {
            this.c = bitmapCreateBitmap;
        }
        Intrinsics.checkNotNull(bitmapCreateBitmap);
        return bitmapCreateBitmap;
    }

    public final void a() {
        this.f = true;
        this.b.post(new Runnable() { // from class: app.screeb.sdk.internal.j0$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                C0309j0.a(this.f$0);
            }
        });
    }

    public final void a(SurfaceView surfaceView, Rect srcRect, int i, int i2, final Function1 onResult) {
        Intrinsics.checkNotNullParameter(surfaceView, "surfaceView");
        Intrinsics.checkNotNullParameter(srcRect, "srcRect");
        Intrinsics.checkNotNullParameter(onResult, "onResult");
        if (i <= 0 || i2 <= 0 || this.f || !this.e.compareAndSet(false, true)) {
            return;
        }
        try {
            final Bitmap bitmapA = a(true, i, i2);
            PixelCopy.request(surfaceView, srcRect, bitmapA, new PixelCopy.OnPixelCopyFinishedListener() { // from class: app.screeb.sdk.internal.j0$$ExternalSyntheticLambda0
                @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
                public final void onPixelCopyFinished(int i3) {
                    C0309j0.b(this.f$0, bitmapA, onResult, i3);
                }
            }, this.b);
        } catch (Throwable th) {
            this.e.set(false);
            Z z = Z.b;
            Y.a();
            Z.b("Mirror", "Surface PixelCopy threw " + th.getClass().getSimpleName());
            onResult.invoke(null);
        }
    }

    public final boolean a(Window window, Rect rect, int i, int i2, final Function1 onResult) {
        Intrinsics.checkNotNullParameter(window, "window");
        Intrinsics.checkNotNullParameter(onResult, "onResult");
        if (i <= 0 || i2 <= 0 || this.f || !this.e.compareAndSet(false, true)) {
            return false;
        }
        try {
            final Bitmap bitmapA = a(false, i, i2);
            PixelCopy.request(window, rect, bitmapA, new PixelCopy.OnPixelCopyFinishedListener() { // from class: app.screeb.sdk.internal.j0$$ExternalSyntheticLambda3
                @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
                public final void onPixelCopyFinished(int i3) {
                    C0309j0.a(this.f$0, bitmapA, onResult, i3);
                }
            }, this.b);
        } catch (Throwable th) {
            this.e.set(false);
            Z z = Z.b;
            Y.a();
            Z.b("Mirror", "PixelCopy threw " + th.getClass().getSimpleName());
            onResult.invoke(null);
        }
        return true;
    }
}
