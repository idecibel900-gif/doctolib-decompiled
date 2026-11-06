package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentLifecycleCallbacksDispatcher {
    private final FragmentManager fragmentManager;
    private final CopyOnWriteArrayList lifecycleCallbacks;

    private static final class FragmentLifecycleCallbacksHolder {
        private final FragmentManager.FragmentLifecycleCallbacks callback;
        private final boolean recursive;

        public FragmentLifecycleCallbacksHolder(FragmentManager.FragmentLifecycleCallbacks callback, boolean z) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.callback = callback;
            this.recursive = z;
        }

        public final FragmentManager.FragmentLifecycleCallbacks getCallback() {
            return this.callback;
        }

        public final boolean getRecursive() {
            return this.recursive;
        }
    }

    public FragmentLifecycleCallbacksDispatcher(FragmentManager fragmentManager) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        this.fragmentManager = fragmentManager;
        this.lifecycleCallbacks = new CopyOnWriteArrayList();
    }

    public final void registerFragmentLifecycleCallbacks(FragmentManager.FragmentLifecycleCallbacks cb, boolean z) {
        Intrinsics.checkNotNullParameter(cb, "cb");
        this.lifecycleCallbacks.add(new FragmentLifecycleCallbacksHolder(cb, z));
    }

    public final void dispatchOnFragmentPreAttached(Fragment f, boolean z) {
        Intrinsics.checkNotNullParameter(f, "f");
        Context context = this.fragmentManager.getHost().getContext();
        Fragment parent = this.fragmentManager.getParent();
        if (parent != null) {
            FragmentManager parentFragmentManager = parent.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.getLifecycleCallbacksDispatcher().dispatchOnFragmentPreAttached(f, true);
        }
        for (FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder : this.lifecycleCallbacks) {
            if (!z || fragmentLifecycleCallbacksHolder.getRecursive()) {
                fragmentLifecycleCallbacksHolder.getCallback().onFragmentPreAttached(this.fragmentManager, f, context);
            }
        }
    }

    public final void dispatchOnFragmentAttached(Fragment f, boolean z) {
        Intrinsics.checkNotNullParameter(f, "f");
        Context context = this.fragmentManager.getHost().getContext();
        Fragment parent = this.fragmentManager.getParent();
        if (parent != null) {
            FragmentManager parentFragmentManager = parent.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.getLifecycleCallbacksDispatcher().dispatchOnFragmentAttached(f, true);
        }
        for (FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder : this.lifecycleCallbacks) {
            if (!z || fragmentLifecycleCallbacksHolder.getRecursive()) {
                fragmentLifecycleCallbacksHolder.getCallback().onFragmentAttached(this.fragmentManager, f, context);
            }
        }
    }

    public final void dispatchOnFragmentPreCreated(Fragment f, Bundle bundle, boolean z) {
        Intrinsics.checkNotNullParameter(f, "f");
        Fragment parent = this.fragmentManager.getParent();
        if (parent != null) {
            FragmentManager parentFragmentManager = parent.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.getLifecycleCallbacksDispatcher().dispatchOnFragmentPreCreated(f, bundle, true);
        }
        for (FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder : this.lifecycleCallbacks) {
            if (!z || fragmentLifecycleCallbacksHolder.getRecursive()) {
                fragmentLifecycleCallbacksHolder.getCallback().onFragmentPreCreated(this.fragmentManager, f, bundle);
            }
        }
    }

    public final void dispatchOnFragmentCreated(Fragment f, Bundle bundle, boolean z) {
        Intrinsics.checkNotNullParameter(f, "f");
        Fragment parent = this.fragmentManager.getParent();
        if (parent != null) {
            FragmentManager parentFragmentManager = parent.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.getLifecycleCallbacksDispatcher().dispatchOnFragmentCreated(f, bundle, true);
        }
        for (FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder : this.lifecycleCallbacks) {
            if (!z || fragmentLifecycleCallbacksHolder.getRecursive()) {
                fragmentLifecycleCallbacksHolder.getCallback().onFragmentCreated(this.fragmentManager, f, bundle);
            }
        }
    }

    public final void dispatchOnFragmentActivityCreated(Fragment f, Bundle bundle, boolean z) {
        Intrinsics.checkNotNullParameter(f, "f");
        Fragment parent = this.fragmentManager.getParent();
        if (parent != null) {
            FragmentManager parentFragmentManager = parent.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.getLifecycleCallbacksDispatcher().dispatchOnFragmentActivityCreated(f, bundle, true);
        }
        for (FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder : this.lifecycleCallbacks) {
            if (!z || fragmentLifecycleCallbacksHolder.getRecursive()) {
                fragmentLifecycleCallbacksHolder.getCallback().onFragmentActivityCreated(this.fragmentManager, f, bundle);
            }
        }
    }

    public final void dispatchOnFragmentViewCreated(Fragment f, View v, Bundle bundle, boolean z) {
        Intrinsics.checkNotNullParameter(f, "f");
        Intrinsics.checkNotNullParameter(v, "v");
        Fragment parent = this.fragmentManager.getParent();
        if (parent != null) {
            FragmentManager parentFragmentManager = parent.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.getLifecycleCallbacksDispatcher().dispatchOnFragmentViewCreated(f, v, bundle, true);
        }
        for (FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder : this.lifecycleCallbacks) {
            if (!z || fragmentLifecycleCallbacksHolder.getRecursive()) {
                fragmentLifecycleCallbacksHolder.getCallback().onFragmentViewCreated(this.fragmentManager, f, v, bundle);
            }
        }
    }

    public final void dispatchOnFragmentStarted(Fragment f, boolean z) {
        Intrinsics.checkNotNullParameter(f, "f");
        Fragment parent = this.fragmentManager.getParent();
        if (parent != null) {
            FragmentManager parentFragmentManager = parent.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.getLifecycleCallbacksDispatcher().dispatchOnFragmentStarted(f, true);
        }
        for (FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder : this.lifecycleCallbacks) {
            if (!z || fragmentLifecycleCallbacksHolder.getRecursive()) {
                fragmentLifecycleCallbacksHolder.getCallback().onFragmentStarted(this.fragmentManager, f);
            }
        }
    }

    public final void dispatchOnFragmentResumed(Fragment f, boolean z) {
        Intrinsics.checkNotNullParameter(f, "f");
        Fragment parent = this.fragmentManager.getParent();
        if (parent != null) {
            FragmentManager parentFragmentManager = parent.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.getLifecycleCallbacksDispatcher().dispatchOnFragmentResumed(f, true);
        }
        for (FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder : this.lifecycleCallbacks) {
            if (!z || fragmentLifecycleCallbacksHolder.getRecursive()) {
                fragmentLifecycleCallbacksHolder.getCallback().onFragmentResumed(this.fragmentManager, f);
            }
        }
    }

    public final void dispatchOnFragmentPaused(Fragment f, boolean z) {
        Intrinsics.checkNotNullParameter(f, "f");
        Fragment parent = this.fragmentManager.getParent();
        if (parent != null) {
            FragmentManager parentFragmentManager = parent.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.getLifecycleCallbacksDispatcher().dispatchOnFragmentPaused(f, true);
        }
        for (FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder : this.lifecycleCallbacks) {
            if (!z || fragmentLifecycleCallbacksHolder.getRecursive()) {
                fragmentLifecycleCallbacksHolder.getCallback().onFragmentPaused(this.fragmentManager, f);
            }
        }
    }

    public final void dispatchOnFragmentStopped(Fragment f, boolean z) {
        Intrinsics.checkNotNullParameter(f, "f");
        Fragment parent = this.fragmentManager.getParent();
        if (parent != null) {
            FragmentManager parentFragmentManager = parent.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.getLifecycleCallbacksDispatcher().dispatchOnFragmentStopped(f, true);
        }
        for (FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder : this.lifecycleCallbacks) {
            if (!z || fragmentLifecycleCallbacksHolder.getRecursive()) {
                fragmentLifecycleCallbacksHolder.getCallback().onFragmentStopped(this.fragmentManager, f);
            }
        }
    }

    public final void dispatchOnFragmentSaveInstanceState(Fragment f, Bundle outState, boolean z) {
        Intrinsics.checkNotNullParameter(f, "f");
        Intrinsics.checkNotNullParameter(outState, "outState");
        Fragment parent = this.fragmentManager.getParent();
        if (parent != null) {
            FragmentManager parentFragmentManager = parent.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.getLifecycleCallbacksDispatcher().dispatchOnFragmentSaveInstanceState(f, outState, true);
        }
        for (FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder : this.lifecycleCallbacks) {
            if (!z || fragmentLifecycleCallbacksHolder.getRecursive()) {
                fragmentLifecycleCallbacksHolder.getCallback().onFragmentSaveInstanceState(this.fragmentManager, f, outState);
            }
        }
    }

    public final void dispatchOnFragmentViewDestroyed(Fragment f, boolean z) {
        Intrinsics.checkNotNullParameter(f, "f");
        Fragment parent = this.fragmentManager.getParent();
        if (parent != null) {
            FragmentManager parentFragmentManager = parent.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.getLifecycleCallbacksDispatcher().dispatchOnFragmentViewDestroyed(f, true);
        }
        for (FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder : this.lifecycleCallbacks) {
            if (!z || fragmentLifecycleCallbacksHolder.getRecursive()) {
                fragmentLifecycleCallbacksHolder.getCallback().onFragmentViewDestroyed(this.fragmentManager, f);
            }
        }
    }

    public final void dispatchOnFragmentDestroyed(Fragment f, boolean z) {
        Intrinsics.checkNotNullParameter(f, "f");
        Fragment parent = this.fragmentManager.getParent();
        if (parent != null) {
            FragmentManager parentFragmentManager = parent.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.getLifecycleCallbacksDispatcher().dispatchOnFragmentDestroyed(f, true);
        }
        for (FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder : this.lifecycleCallbacks) {
            if (!z || fragmentLifecycleCallbacksHolder.getRecursive()) {
                fragmentLifecycleCallbacksHolder.getCallback().onFragmentDestroyed(this.fragmentManager, f);
            }
        }
    }

    public final void dispatchOnFragmentDetached(Fragment f, boolean z) {
        Intrinsics.checkNotNullParameter(f, "f");
        Fragment parent = this.fragmentManager.getParent();
        if (parent != null) {
            FragmentManager parentFragmentManager = parent.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parent.getParentFragmentManager()");
            parentFragmentManager.getLifecycleCallbacksDispatcher().dispatchOnFragmentDetached(f, true);
        }
        for (FragmentLifecycleCallbacksHolder fragmentLifecycleCallbacksHolder : this.lifecycleCallbacks) {
            if (!z || fragmentLifecycleCallbacksHolder.getRecursive()) {
                fragmentLifecycleCallbacksHolder.getCallback().onFragmentDetached(this.fragmentManager, f);
            }
        }
    }
}
