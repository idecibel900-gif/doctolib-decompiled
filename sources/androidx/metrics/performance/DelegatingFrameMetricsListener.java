package androidx.metrics.performance;

import android.os.Handler;
import android.os.HandlerThread;
import android.view.FrameMetrics;
import android.view.Window;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
final class DelegatingFrameMetricsListener implements Window.OnFrameMetricsAvailableListener {
    public static final Companion Companion = new Companion(null);
    private static Handler frameMetricsHandler;
    private final List delegates;

    public DelegatingFrameMetricsListener(List delegates) {
        Intrinsics.checkNotNullParameter(delegates, "delegates");
        this.delegates = delegates;
    }

    public final List getDelegates() {
        return this.delegates;
    }

    @Override // android.view.Window.OnFrameMetricsAvailableListener
    public void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int i) {
        synchronized (this) {
            try {
                Iterator it = this.delegates.iterator();
                while (it.hasNext()) {
                    ((Window.OnFrameMetricsAvailableListener) it.next()).onFrameMetricsAvailable(window, frameMetrics, i);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void add(Window.OnFrameMetricsAvailableListener delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        synchronized (this) {
            this.delegates.add(delegate);
        }
    }

    public final void remove(Window.OnFrameMetricsAvailableListener delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        synchronized (this) {
            this.delegates.remove(delegate);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Handler getFrameMetricsHandler$metrics_performance_release() {
            return DelegatingFrameMetricsListener.frameMetricsHandler;
        }

        public final void setFrameMetricsHandler$metrics_performance_release(Handler handler) {
            DelegatingFrameMetricsListener.frameMetricsHandler = handler;
        }

        public final void addDelegateToWindow(Window window, Window.OnFrameMetricsAvailableListener delegate) {
            Intrinsics.checkNotNullParameter(window, "window");
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            DelegatingFrameMetricsListener delegatingFrameMetricsListener = (DelegatingFrameMetricsListener) window.getDecorView().getTag(R$id.metricsDelegator);
            if (delegatingFrameMetricsListener == null) {
                DelegatingFrameMetricsListener delegatingFrameMetricsListener2 = new DelegatingFrameMetricsListener(CollectionsKt.mutableListOf(delegate));
                if (getFrameMetricsHandler$metrics_performance_release() == null) {
                    HandlerThread handlerThread = new HandlerThread("FrameMetricsAggregator");
                    handlerThread.start();
                    setFrameMetricsHandler$metrics_performance_release(new Handler(handlerThread.getLooper()));
                }
                window.getDecorView().setTag(R$id.metricsDelegator, delegatingFrameMetricsListener2);
                window.addOnFrameMetricsAvailableListener(delegatingFrameMetricsListener2, getFrameMetricsHandler$metrics_performance_release());
                return;
            }
            delegatingFrameMetricsListener.add(delegate);
        }

        public final void removeDelegateFromWindow(Window window, Window.OnFrameMetricsAvailableListener delegate) {
            Intrinsics.checkNotNullParameter(window, "window");
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            DelegatingFrameMetricsListener delegatingFrameMetricsListener = (DelegatingFrameMetricsListener) window.getDecorView().getTag(R$id.metricsDelegator);
            if (delegatingFrameMetricsListener != null) {
                delegatingFrameMetricsListener.remove(delegate);
                if (delegatingFrameMetricsListener.getDelegates().isEmpty()) {
                    window.removeOnFrameMetricsAvailableListener(delegatingFrameMetricsListener);
                    window.getDecorView().setTag(R$id.metricsDelegator, null);
                }
            }
        }
    }
}
