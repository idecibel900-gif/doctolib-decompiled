package app.screeb.sdk.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: app.screeb.sdk.internal.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0324x implements Application.ActivityLifecycleCallbacks {
    public final /* synthetic */ A a;

    public C0324x(A a) {
        this.a = a;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        J j = (J) this.a.b.get();
        if (j == null) {
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        WeakReference weakReference = j.b;
        if ((weakReference != null ? (Activity) weakReference.get() : null) == activity) {
            j.b(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        J j = (J) this.a.b.get();
        if (j == null) {
            return;
        }
        j.a(0);
        j.b(true);
        Intrinsics.checkNotNullParameter(activity, "activity");
        j.b = new WeakReference(activity);
        j.Y0 = 0L;
        j.d();
        j.f();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }
}
