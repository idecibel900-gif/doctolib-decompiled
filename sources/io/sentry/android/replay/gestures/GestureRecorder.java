package io.sentry.android.replay.gestures;

import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import io.sentry.ISentryLifecycleToken;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.android.replay.OnRootViewsChangedListener;
import io.sentry.android.replay.WindowsKt;
import io.sentry.android.replay.util.FixedWindowCallback;
import io.sentry.util.AutoClosableReentrantLock;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class GestureRecorder implements OnRootViewsChangedListener {
    private final SentryOptions options;
    private final ArrayList rootViews;
    private final AutoClosableReentrantLock rootViewsLock;
    private final TouchRecorderCallback touchRecorderCallback;
    private final WeakHashMap wrappedWindows;
    private final AutoClosableReentrantLock wrappedWindowsLock;

    public GestureRecorder(SentryOptions options, TouchRecorderCallback touchRecorderCallback) {
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(touchRecorderCallback, "touchRecorderCallback");
        this.options = options;
        this.touchRecorderCallback = touchRecorderCallback;
        this.rootViews = new ArrayList();
        this.rootViewsLock = new AutoClosableReentrantLock();
        this.wrappedWindows = new WeakHashMap();
        this.wrappedWindowsLock = new AutoClosableReentrantLock();
    }

    @Override // io.sentry.android.replay.OnRootViewsChangedListener
    public void onRootViewsChanged(final View root, boolean z) throws Exception {
        Intrinsics.checkNotNullParameter(root, "root");
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.rootViewsLock.acquire();
        try {
            if (z) {
                this.rootViews.add(new WeakReference(root));
                startGestureTracking(root);
                Unit unit = Unit.INSTANCE;
            } else {
                stopGestureTracking(root);
                CollectionsKt.removeAll((List) this.rootViews, new Function1() { // from class: io.sentry.android.replay.gestures.GestureRecorder$onRootViewsChanged$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(WeakReference it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return Boolean.valueOf(Intrinsics.areEqual(it.get(), root));
                    }
                });
            }
            AutoCloseableKt.closeFinally(iSentryLifecycleTokenAcquire, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AutoCloseableKt.closeFinally(iSentryLifecycleTokenAcquire, th);
                throw th2;
            }
        }
    }

    public final void stop() throws Exception {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.rootViewsLock.acquire();
        try {
            Iterator it = this.rootViews.iterator();
            while (it.hasNext()) {
                View view = (View) ((WeakReference) it.next()).get();
                if (view != null) {
                    Intrinsics.checkNotNull(view);
                    stopGestureTracking(view);
                }
            }
            this.rootViews.clear();
            Unit unit = Unit.INSTANCE;
            AutoCloseableKt.closeFinally(iSentryLifecycleTokenAcquire, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AutoCloseableKt.closeFinally(iSentryLifecycleTokenAcquire, th);
                throw th2;
            }
        }
    }

    private final void startGestureTracking(View view) throws Exception {
        Window phoneWindow = WindowsKt.getPhoneWindow(view);
        if (phoneWindow == null) {
            this.options.getLogger().log(SentryLevel.DEBUG, "Window is invalid, not tracking gestures", new Object[0]);
            return;
        }
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.wrappedWindowsLock.acquire();
        try {
            WeakReference weakReference = (WeakReference) this.wrappedWindows.get(phoneWindow);
            if ((weakReference != null ? (SentryReplayGestureRecorder) weakReference.get() : null) != null) {
                AutoCloseableKt.closeFinally(iSentryLifecycleTokenAcquire, null);
                return;
            }
            Unit unit = Unit.INSTANCE;
            AutoCloseableKt.closeFinally(iSentryLifecycleTokenAcquire, null);
            SentryReplayGestureRecorder sentryReplayGestureRecorder = new SentryReplayGestureRecorder(this.options, this.touchRecorderCallback, phoneWindow.getCallback());
            phoneWindow.setCallback(sentryReplayGestureRecorder);
            ISentryLifecycleToken iSentryLifecycleTokenAcquire2 = this.wrappedWindowsLock.acquire();
            try {
                this.wrappedWindows.put(phoneWindow, new WeakReference(sentryReplayGestureRecorder));
                AutoCloseableKt.closeFinally(iSentryLifecycleTokenAcquire2, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    AutoCloseableKt.closeFinally(iSentryLifecycleTokenAcquire2, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                AutoCloseableKt.closeFinally(iSentryLifecycleTokenAcquire, th3);
                throw th4;
            }
        }
    }

    private final void stopGestureTracking(View view) throws Exception {
        Window phoneWindow = WindowsKt.getPhoneWindow(view);
        if (phoneWindow == null) {
            this.options.getLogger().log(SentryLevel.DEBUG, "Window was null in stopGestureTracking", new Object[0]);
            return;
        }
        Window.Callback callback = phoneWindow.getCallback();
        if (callback instanceof SentryReplayGestureRecorder) {
            phoneWindow.setCallback(((SentryReplayGestureRecorder) callback).delegate);
            ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.wrappedWindowsLock.acquire();
            try {
                AutoCloseableKt.closeFinally(iSentryLifecycleTokenAcquire, null);
                return;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    AutoCloseableKt.closeFinally(iSentryLifecycleTokenAcquire, th);
                    throw th2;
                }
            }
        }
        ISentryLifecycleToken iSentryLifecycleTokenAcquire2 = this.wrappedWindowsLock.acquire();
        try {
            WeakReference weakReference = (WeakReference) this.wrappedWindows.get(phoneWindow);
            SentryReplayGestureRecorder sentryReplayGestureRecorder = weakReference != null ? (SentryReplayGestureRecorder) weakReference.get() : null;
            AutoCloseableKt.closeFinally(iSentryLifecycleTokenAcquire2, null);
            if (sentryReplayGestureRecorder != null) {
                sentryReplayGestureRecorder.inert();
            }
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                AutoCloseableKt.closeFinally(iSentryLifecycleTokenAcquire2, th3);
                throw th4;
            }
        }
    }

    public static final class SentryReplayGestureRecorder extends FixedWindowCallback {
        private final SentryOptions options;
        private volatile TouchRecorderCallback touchRecorderCallback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SentryReplayGestureRecorder(SentryOptions options, TouchRecorderCallback touchRecorderCallback, Window.Callback callback) {
            super(callback);
            Intrinsics.checkNotNullParameter(options, "options");
            this.options = options;
            this.touchRecorderCallback = touchRecorderCallback;
        }

        @Override // io.sentry.android.replay.util.FixedWindowCallback, android.view.Window.Callback
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            if (motionEvent != null) {
                MotionEvent motionEventObtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
                Intrinsics.checkNotNullExpressionValue(motionEventObtainNoHistory, "obtainNoHistory(...)");
                try {
                    TouchRecorderCallback touchRecorderCallback = this.touchRecorderCallback;
                    if (touchRecorderCallback != null) {
                        touchRecorderCallback.onTouchEvent(motionEventObtainNoHistory);
                    }
                } catch (Throwable th) {
                    try {
                        this.options.getLogger().log(SentryLevel.ERROR, "Error dispatching touch event", th);
                    } finally {
                        motionEventObtainNoHistory.recycle();
                    }
                }
            }
            return super.dispatchTouchEvent(motionEvent);
        }

        public final void inert() {
            this.touchRecorderCallback = null;
        }
    }
}
