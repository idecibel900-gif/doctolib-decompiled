package androidx.compose.foundation.lazy.layout;

import android.view.Choreographer;
import android.view.Display;
import android.view.View;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.collection.MutableVector;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidPrefetchScheduler implements PrefetchScheduler, RememberObserver, Runnable, Choreographer.FrameCallback {
    private static long frameIntervalNs;
    private long frameStartTimeNanos;
    private boolean isActive;
    private boolean prefetchScheduled;
    private final View view;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final MutableVector prefetchRequests = new MutableVector(new PrefetchRequest[16], 0);
    private final Choreographer choreographer = Choreographer.getInstance();

    @Override // androidx.compose.runtime.RememberObserver
    public void onAbandoned() {
    }

    public AndroidPrefetchScheduler(View view) {
        this.view = view;
        Companion.calculateFrameIntervalIfNeeded(view);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.prefetchRequests.isEmpty() || !this.prefetchScheduled || !this.isActive || this.view.getWindowVisibility() != 0) {
            this.prefetchScheduled = false;
            return;
        }
        PrefetchRequestScopeImpl prefetchRequestScopeImpl = new PrefetchRequestScopeImpl(this.frameStartTimeNanos + frameIntervalNs);
        boolean z = false;
        while (this.prefetchRequests.isNotEmpty() && !z) {
            if (prefetchRequestScopeImpl.availableTimeNanos() <= 0 || ((PrefetchRequest) this.prefetchRequests.getContent()[0]).execute(prefetchRequestScopeImpl)) {
                z = true;
            } else {
                this.prefetchRequests.removeAt(0);
            }
        }
        if (z) {
            this.choreographer.postFrameCallback(this);
        } else {
            this.prefetchScheduled = false;
        }
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        if (this.isActive) {
            this.frameStartTimeNanos = j;
            this.view.post(this);
        }
    }

    @Override // androidx.compose.foundation.lazy.layout.PrefetchScheduler
    public void schedulePrefetch(PrefetchRequest prefetchRequest) {
        this.prefetchRequests.add(prefetchRequest);
        if (this.prefetchScheduled) {
            return;
        }
        this.prefetchScheduled = true;
        this.view.post(this);
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onRemembered() {
        this.isActive = true;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onForgotten() {
        this.isActive = false;
        this.view.removeCallbacks(this);
        this.choreographer.removeFrameCallback(this);
    }

    public static final class PrefetchRequestScopeImpl implements PrefetchRequestScope {
        private final long nextFrameTimeNs;

        public PrefetchRequestScopeImpl(long j) {
            this.nextFrameTimeNs = j;
        }

        @Override // androidx.compose.foundation.lazy.layout.PrefetchRequestScope
        public long availableTimeNanos() {
            return Math.max(0L, this.nextFrameTimeNs - System.nanoTime());
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code duplicated, block: B:10:0x0021  */
        public final void calculateFrameIntervalIfNeeded(View view) {
            float refreshRate;
            if (AndroidPrefetchScheduler.frameIntervalNs == 0) {
                Display display = view.getDisplay();
                if (view.isInEditMode() || display == null) {
                    refreshRate = 60.0f;
                } else {
                    refreshRate = display.getRefreshRate();
                    if (refreshRate < 30.0f) {
                        refreshRate = 60.0f;
                    }
                }
                AndroidPrefetchScheduler.frameIntervalNs = (long) (Http2Connection.DEGRADED_PONG_TIMEOUT_NS / refreshRate);
            }
        }
    }
}
