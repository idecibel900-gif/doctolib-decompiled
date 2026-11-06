package androidx.media3.common.util;

import android.os.Looper;
import com.google.common.base.Function;

/* JADX INFO: loaded from: classes.dex */
public final class BackgroundThreadStateHandler {
    private final HandlerWrapper backgroundHandler;
    private Object backgroundState;
    private final HandlerWrapper foregroundHandler;
    private Object foregroundState;
    private final StateChangeListener onStateChanged;
    private int pendingOperations;

    public interface StateChangeListener {
        void onStateChanged(Object obj, Object obj2);
    }

    public BackgroundThreadStateHandler(Object obj, Looper looper, Looper looper2, Clock clock, StateChangeListener stateChangeListener) {
        this.backgroundHandler = clock.createHandler(looper, null);
        this.foregroundHandler = clock.createHandler(looper2, null);
        this.foregroundState = obj;
        this.backgroundState = obj;
        this.onStateChanged = stateChangeListener;
    }

    public Object get() {
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper == this.foregroundHandler.getLooper()) {
            return this.foregroundState;
        }
        Assertions.checkState(looperMyLooper == this.backgroundHandler.getLooper());
        return this.backgroundState;
    }

    public void updateStateAsync(Function function, final Function function2) {
        Assertions.checkState(Looper.myLooper() == this.foregroundHandler.getLooper());
        this.pendingOperations++;
        runInBackground(new Runnable() { // from class: androidx.media3.common.util.BackgroundThreadStateHandler$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                BackgroundThreadStateHandler.m2722$r8$lambda$f0hFC73tfQBWeDExFIZmwNfoAE(this.f$0, function2);
            }
        });
        updateStateInForeground(function.apply(this.foregroundState));
    }

    /* JADX INFO: renamed from: $r8$lambda$f0hFC73tfQBWeDExFIZmwNfoA-E, reason: not valid java name */
    public static /* synthetic */ void m2722$r8$lambda$f0hFC73tfQBWeDExFIZmwNfoAE(final BackgroundThreadStateHandler backgroundThreadStateHandler, Function function) {
        final Object objApply = function.apply(backgroundThreadStateHandler.backgroundState);
        backgroundThreadStateHandler.backgroundState = objApply;
        backgroundThreadStateHandler.runInForeground(new Runnable() { // from class: androidx.media3.common.util.BackgroundThreadStateHandler$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                BackgroundThreadStateHandler.m2723$r8$lambda$lNGZQGzRQnsJ9W6th9dnrHlBQ(this.f$0, objApply);
            }
        });
    }

    /* JADX INFO: renamed from: $r8$lambda$lNGZQG-zRQnsJ9W6th9-dnrHlBQ, reason: not valid java name */
    public static /* synthetic */ void m2723$r8$lambda$lNGZQGzRQnsJ9W6th9dnrHlBQ(BackgroundThreadStateHandler backgroundThreadStateHandler, Object obj) {
        int i = backgroundThreadStateHandler.pendingOperations - 1;
        backgroundThreadStateHandler.pendingOperations = i;
        if (i == 0) {
            backgroundThreadStateHandler.updateStateInForeground(obj);
        }
    }

    public void setStateInBackground(final Object obj) {
        this.backgroundState = obj;
        runInForeground(new Runnable() { // from class: androidx.media3.common.util.BackgroundThreadStateHandler$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                BackgroundThreadStateHandler.$r8$lambda$hhYjRnaRRUwjgYpDYJM_auE3ai0(this.f$0, obj);
            }
        });
    }

    public static /* synthetic */ void $r8$lambda$hhYjRnaRRUwjgYpDYJM_auE3ai0(BackgroundThreadStateHandler backgroundThreadStateHandler, Object obj) {
        if (backgroundThreadStateHandler.pendingOperations == 0) {
            backgroundThreadStateHandler.updateStateInForeground(obj);
        }
    }

    public void runInBackground(Runnable runnable) {
        if (this.backgroundHandler.getLooper().getThread().isAlive()) {
            this.backgroundHandler.post(runnable);
        }
    }

    private void runInForeground(Runnable runnable) {
        if (this.foregroundHandler.getLooper().getThread().isAlive()) {
            this.foregroundHandler.post(runnable);
        }
    }

    private void updateStateInForeground(Object obj) {
        Object obj2 = this.foregroundState;
        this.foregroundState = obj;
        if (obj2.equals(obj)) {
            return;
        }
        this.onStateChanged.onStateChanged(obj2, obj);
    }
}
