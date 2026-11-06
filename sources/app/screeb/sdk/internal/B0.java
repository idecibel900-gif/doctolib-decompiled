package app.screeb.sdk.internal;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import java.lang.ref.WeakReference;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class B0 {
    public final I a;
    public Function2 b;
    public WeakReference c;
    public WeakReference d;
    public Window.Callback e;
    public long f;
    public final int[] g;

    public B0(I onPointer) {
        Intrinsics.checkNotNullParameter(onPointer, "onPointer");
        this.a = onPointer;
        this.g = new int[2];
    }

    public static final void a(B0 b0, MotionEvent motionEvent) {
        int i;
        View view;
        b0.getClass();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            i = 2;
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    i = 1;
                } else if (actionMasked != 3) {
                    return;
                }
            }
        } else {
            i = 0;
        }
        if (i == 1) {
            long jUptimeMillis = SystemClock.uptimeMillis();
            if (jUptimeMillis - b0.f < 33) {
                return;
            } else {
                b0.f = jUptimeMillis;
            }
        }
        WeakReference weakReference = b0.d;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        Function2 function2 = b0.b;
        if (function2 == null || !((Boolean) function2.invoke(Integer.valueOf(rawX), Integer.valueOf(rawY))).booleanValue()) {
            do {
                try {
                    if (!o0.b(view)) {
                        if (!(view instanceof ViewGroup)) {
                            break;
                        }
                        int childCount = ((ViewGroup) view).getChildCount() - 1;
                        while (true) {
                            if (-1 >= childCount) {
                                view = null;
                                break;
                            }
                            View childAt = ((ViewGroup) view).getChildAt(childCount);
                            if (childAt != null && childAt.getVisibility() == 0) {
                                childAt.getLocationOnScreen(b0.g);
                                int i2 = b0.g[0];
                                if (rawX <= childAt.getWidth() + i2 && i2 <= rawX) {
                                    int i3 = b0.g[1];
                                    if (rawY <= childAt.getHeight() + i3 && i3 <= rawY) {
                                        view = childAt;
                                        break;
                                    }
                                }
                            }
                            childCount--;
                        }
                    } else {
                        return;
                    }
                } catch (Throwable unused) {
                }
            } while (view != null);
            b0.a.invoke(Integer.valueOf(i), Integer.valueOf(rawX), Integer.valueOf(rawY));
        }
    }

    public final void a() {
        Window window;
        WeakReference weakReference = this.c;
        if (weakReference == null || (window = (Window) weakReference.get()) == null) {
            return;
        }
        try {
            Window.Callback callback = window.getCallback();
            if ((callback instanceof A0) && ((A0) callback).a() == this) {
                window.setCallback(this.e);
            }
        } catch (Throwable th) {
            Z z = Z.b;
            Y.a();
            Z.b("Mirror", "TouchTracker.detach failed: " + th.getClass().getSimpleName());
        }
        this.c = null;
        this.d = null;
        this.e = null;
    }
}
