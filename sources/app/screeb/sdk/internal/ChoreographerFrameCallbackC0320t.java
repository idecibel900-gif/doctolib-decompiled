package app.screeb.sdk.internal;

import android.view.Choreographer;

/* JADX INFO: renamed from: app.screeb.sdk.internal.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class ChoreographerFrameCallbackC0320t implements Choreographer.FrameCallback {
    public final /* synthetic */ C0321u a;

    public ChoreographerFrameCallbackC0320t(C0321u c0321u) {
        this.a = c0321u;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        this.a.e.set(false);
        if (this.a.c.get()) {
            if (this.a.b.compareAndSet(true, false)) {
                this.a.d.incrementAndGet();
                C0321u c0321u = this.a;
                c0321u.a.invoke(Long.valueOf(c0321u.d.get()));
            }
            if (this.a.b.get()) {
                this.a.c();
            }
        }
    }
}
