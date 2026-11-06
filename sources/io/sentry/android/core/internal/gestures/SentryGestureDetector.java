package io.sentry.android.core.internal.gestures;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import io.sentry.ISentryLifecycleToken;
import io.sentry.util.AutoClosableReentrantLock;

/* JADX INFO: loaded from: classes5.dex */
public final class SentryGestureDetector {
    private MotionEvent currentDownEvent;
    private float downX;
    private float downY;
    private boolean ignoreUpEvent;
    private boolean isInTapRegion;
    private float lastX;
    private float lastY;
    private final GestureDetector.OnGestureListener listener;
    private final AutoClosableReentrantLock lock = new AutoClosableReentrantLock();
    private final int maximumFlingVelocity;
    private final int minimumFlingVelocity;
    private final int touchSlopSquare;
    private VelocityTracker velocityTracker;

    SentryGestureDetector(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this.listener = onGestureListener;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.touchSlopSquare = scaledTouchSlop * scaledTouchSlop;
        this.minimumFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.maximumFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    void onTouchEvent(MotionEvent motionEvent) {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            int actionMasked = motionEvent.getActionMasked();
            if (this.velocityTracker == null) {
                this.velocityTracker = VelocityTracker.obtain();
            }
            this.velocityTracker.addMovement(motionEvent);
            if (actionMasked == 0) {
                this.downX = motionEvent.getX();
                float y = motionEvent.getY();
                this.downY = y;
                this.lastX = this.downX;
                this.lastY = y;
                this.isInTapRegion = true;
                this.ignoreUpEvent = false;
                MotionEvent motionEvent2 = this.currentDownEvent;
                if (motionEvent2 != null) {
                    motionEvent2.recycle();
                }
                this.currentDownEvent = MotionEvent.obtain(motionEvent);
                this.listener.onDown(motionEvent);
            } else if (actionMasked != 1) {
                if (actionMasked == 2) {
                    float x = motionEvent.getX();
                    float y2 = motionEvent.getY();
                    float f = x - this.downX;
                    float f2 = y2 - this.downY;
                    if ((f * f) + (f2 * f2) > this.touchSlopSquare) {
                        this.listener.onScroll(this.currentDownEvent, motionEvent, this.lastX - x, this.lastY - y2);
                        this.isInTapRegion = false;
                        this.lastX = x;
                        this.lastY = y2;
                    }
                } else if (actionMasked == 3) {
                    recycle();
                } else if (actionMasked == 5) {
                    this.isInTapRegion = false;
                    this.ignoreUpEvent = true;
                }
            } else if (this.ignoreUpEvent) {
                recycle();
            } else {
                if (this.isInTapRegion) {
                    this.listener.onSingleTapUp(motionEvent);
                } else {
                    int pointerId = motionEvent.getPointerId(0);
                    this.velocityTracker.computeCurrentVelocity(1000, this.maximumFlingVelocity);
                    float xVelocity = this.velocityTracker.getXVelocity(pointerId);
                    float yVelocity = this.velocityTracker.getYVelocity(pointerId);
                    if (Math.abs(xVelocity) > this.minimumFlingVelocity || Math.abs(yVelocity) > this.minimumFlingVelocity) {
                        this.listener.onFling(this.currentDownEvent, motionEvent, xVelocity, yVelocity);
                    }
                }
                recycle();
            }
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
        } catch (Throwable th) {
            if (iSentryLifecycleTokenAcquire != null) {
                try {
                    iSentryLifecycleTokenAcquire.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    void recycle() {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            MotionEvent motionEvent = this.currentDownEvent;
            this.currentDownEvent = null;
            VelocityTracker velocityTracker = this.velocityTracker;
            this.velocityTracker = null;
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
            if (motionEvent != null) {
                motionEvent.recycle();
            }
            if (velocityTracker != null) {
                velocityTracker.recycle();
            }
        } catch (Throwable th) {
            if (iSentryLifecycleTokenAcquire != null) {
                try {
                    iSentryLifecycleTokenAcquire.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
