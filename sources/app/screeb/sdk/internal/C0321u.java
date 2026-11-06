package app.screeb.sdk.internal;

import android.view.Choreographer;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: app.screeb.sdk.internal.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0321u {
    public final C a;
    public final AtomicBoolean b;
    public final AtomicBoolean c;
    public final AtomicLong d;
    public final AtomicBoolean e;
    public final ViewTreeObserver.OnPreDrawListener f;
    public final ViewTreeObserver.OnGlobalLayoutListener g;
    public final ChoreographerFrameCallbackC0320t h;
    public final ArrayList i;

    public C0321u(C onFrame) {
        Intrinsics.checkNotNullParameter(onFrame, "onFrame");
        this.a = onFrame;
        this.b = new AtomicBoolean(false);
        this.c = new AtomicBoolean(false);
        this.d = new AtomicLong(0L);
        this.e = new AtomicBoolean(false);
        this.f = new ViewTreeObserver.OnPreDrawListener() { // from class: app.screeb.sdk.internal.u$$ExternalSyntheticLambda0
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                return C0321u.b(this.f$0);
            }
        };
        this.g = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: app.screeb.sdk.internal.u$$ExternalSyntheticLambda1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                C0321u.a(this.f$0);
            }
        };
        this.h = new ChoreographerFrameCallbackC0320t(this);
        this.i = new ArrayList(4);
    }

    public static final void a(C0321u c0321u) {
        c0321u.c();
    }

    public static final boolean b(C0321u c0321u) {
        c0321u.c();
        return true;
    }

    public final AtomicLong a() {
        return this.d;
    }

    public final void a(View view) {
        try {
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f);
                viewTreeObserver.removeOnGlobalLayoutListener(this.g);
            }
        } catch (Throwable unused) {
        }
    }

    public final void b() {
        c();
    }

    public final void c() {
        this.b.set(true);
        if (this.c.get() && this.e.compareAndSet(false, true)) {
            Choreographer.getInstance().postFrameCallback(this.h);
        }
    }

    public final void d() {
        if (this.c.compareAndSet(true, false)) {
            Choreographer.getInstance().removeFrameCallback(this.h);
            this.e.set(false);
            Iterator it = this.i.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                a((View) next);
            }
            this.i.clear();
        }
    }
}
