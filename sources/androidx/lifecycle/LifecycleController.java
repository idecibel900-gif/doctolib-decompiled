package androidx.lifecycle;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes.dex */
public final class LifecycleController {
    private final DispatchQueue dispatchQueue;
    private final Lifecycle lifecycle;
    private final Lifecycle.State minState;
    private final LifecycleEventObserver observer;

    public LifecycleController(Lifecycle lifecycle, Lifecycle.State minState, DispatchQueue dispatchQueue, final Job parentJob) {
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        Intrinsics.checkNotNullParameter(minState, "minState");
        Intrinsics.checkNotNullParameter(dispatchQueue, "dispatchQueue");
        Intrinsics.checkNotNullParameter(parentJob, "parentJob");
        this.lifecycle = lifecycle;
        this.minState = minState;
        this.dispatchQueue = dispatchQueue;
        LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: androidx.lifecycle.LifecycleController$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                LifecycleController.observer$lambda$0(this.f$0, parentJob, lifecycleOwner, event);
            }
        };
        this.observer = lifecycleEventObserver;
        if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
            lifecycle.addObserver(lifecycleEventObserver);
        } else {
            Job.DefaultImpls.cancel$default(parentJob, null, 1, null);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void observer$lambda$0(LifecycleController this$0, Job parentJob, LifecycleOwner source, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(parentJob, "$parentJob");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "<anonymous parameter 1>");
        if (source.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) {
            if (source.getLifecycle().getCurrentState().compareTo(this$0.minState) < 0) {
                this$0.dispatchQueue.pause();
                return;
            } else {
                this$0.dispatchQueue.resume();
                return;
            }
        }
        Job.DefaultImpls.cancel$default(parentJob, null, 1, null);
        this$0.finish();
    }

    public final void finish() {
        this.lifecycle.removeObserver(this.observer);
        this.dispatchQueue.finish();
    }
}
