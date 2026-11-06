package io.sentry.android.core.internal.util;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import io.sentry.android.core.BuildInfoProvider;
import io.sentry.android.core.internal.gestures.NoOpWindowCallback;
import io.sentry.android.core.performance.WindowContentChangedCallback;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public class FirstDrawDoneListener implements ViewTreeObserver.OnDrawListener {
    private final Runnable callback;
    private final Handler mainThreadHandler = new Handler(Looper.getMainLooper());
    private final AtomicReference viewReference;

    public static void registerForNextDraw(Activity activity, final Runnable runnable, final BuildInfoProvider buildInfoProvider) {
        final Window window = activity.getWindow();
        if (window != null) {
            View viewPeekDecorView = window.peekDecorView();
            if (viewPeekDecorView != null) {
                registerForNextDraw(viewPeekDecorView, runnable, buildInfoProvider);
            } else {
                final Window.Callback callback = window.getCallback();
                window.setCallback(new WindowContentChangedCallback(callback != null ? callback : new NoOpWindowCallback(), new Runnable() { // from class: io.sentry.android.core.internal.util.FirstDrawDoneListener$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        FirstDrawDoneListener.$r8$lambda$trMRWNICWTJTkPydcG3pQDGg2PI(window, callback, runnable, buildInfoProvider);
                    }
                }));
            }
        }
    }

    public static /* synthetic */ void $r8$lambda$trMRWNICWTJTkPydcG3pQDGg2PI(Window window, Window.Callback callback, Runnable runnable, BuildInfoProvider buildInfoProvider) {
        View viewPeekDecorView = window.peekDecorView();
        if (viewPeekDecorView != null) {
            window.setCallback(callback);
            registerForNextDraw(viewPeekDecorView, runnable, buildInfoProvider);
        }
    }

    public static void registerForNextDraw(View view, Runnable runnable, BuildInfoProvider buildInfoProvider) {
        FirstDrawDoneListener firstDrawDoneListener = new FirstDrawDoneListener(view, runnable);
        if (buildInfoProvider.getSdkInfoVersion() < 26 && !isAliveAndAttached(view)) {
            view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: io.sentry.android.core.internal.util.FirstDrawDoneListener.1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view2) {
                    view2.getViewTreeObserver().addOnDrawListener(FirstDrawDoneListener.this);
                    view2.removeOnAttachStateChangeListener(this);
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view2) {
                    view2.removeOnAttachStateChangeListener(this);
                }
            });
        } else {
            view.getViewTreeObserver().addOnDrawListener(firstDrawDoneListener);
        }
    }

    private FirstDrawDoneListener(View view, Runnable runnable) {
        this.viewReference = new AtomicReference(view);
        this.callback = runnable;
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public void onDraw() {
        final View view = (View) this.viewReference.getAndSet(null);
        if (view == null) {
            return;
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: io.sentry.android.core.internal.util.FirstDrawDoneListener$$ExternalSyntheticLambda1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                FirstDrawDoneListener.$r8$lambda$2mMWobaa7xILHuYfByqKZm4TFbY(this.f$0, view);
            }
        });
        this.mainThreadHandler.postAtFrontOfQueue(this.callback);
    }

    public static /* synthetic */ void $r8$lambda$2mMWobaa7xILHuYfByqKZm4TFbY(FirstDrawDoneListener firstDrawDoneListener, View view) {
        firstDrawDoneListener.getClass();
        view.getViewTreeObserver().removeOnDrawListener(firstDrawDoneListener);
    }

    private static boolean isAliveAndAttached(View view) {
        return view.getViewTreeObserver().isAlive() && view.isAttachedToWindow();
    }
}
