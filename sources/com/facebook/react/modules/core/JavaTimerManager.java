package com.facebook.react.modules.core;

import android.util.SparseArray;
import android.view.Choreographer;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.common.SystemClock;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.jstasks.HeadlessJsTaskContext;
import com.facebook.react.jstasks.HeadlessJsTaskEventListener;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes3.dex */
public class JavaTimerManager implements LifecycleEventListener, HeadlessJsTaskEventListener {
    private static final Companion Companion = new Companion(null);
    private IdleCallbackRunnable currentIdleCallbackRunnable;
    private final DevSupportManager devSupportManager;
    private boolean frameCallbackPosted;
    private boolean frameIdleCallbackPosted;
    private final Object idleCallbackGuard;
    private final IdleFrameCallback idleFrameCallback;
    private final AtomicBoolean isPaused;
    private final AtomicBoolean isRunningTasks;
    private final JavaScriptTimerExecutor javaScriptTimerExecutor;
    private final ReactApplicationContext reactApplicationContext;
    private final ReactChoreographer reactChoreographer;
    private boolean sendIdleEvents;
    private final TimerFrameCallback timerFrameCallback;
    private final Object timerGuard;
    private final SparseArray timerIdsToTimers;
    private final PriorityQueue timers;

    public JavaTimerManager(ReactApplicationContext reactApplicationContext, JavaScriptTimerExecutor javaScriptTimerExecutor, ReactChoreographer reactChoreographer, DevSupportManager devSupportManager) {
        Intrinsics.checkNotNullParameter(reactApplicationContext, "reactApplicationContext");
        Intrinsics.checkNotNullParameter(javaScriptTimerExecutor, "javaScriptTimerExecutor");
        Intrinsics.checkNotNullParameter(reactChoreographer, "reactChoreographer");
        Intrinsics.checkNotNullParameter(devSupportManager, "devSupportManager");
        this.reactApplicationContext = reactApplicationContext;
        this.javaScriptTimerExecutor = javaScriptTimerExecutor;
        this.reactChoreographer = reactChoreographer;
        this.devSupportManager = devSupportManager;
        this.timerGuard = new Object();
        this.idleCallbackGuard = new Object();
        this.timerIdsToTimers = new SparseArray();
        this.isPaused = new AtomicBoolean(true);
        this.isRunningTasks = new AtomicBoolean(false);
        this.timerFrameCallback = new TimerFrameCallback();
        this.idleFrameCallback = new IdleFrameCallback();
        final Function2 function2 = new Function2() { // from class: com.facebook.react.modules.core.JavaTimerManager$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Integer.valueOf(JavaTimerManager.timers$lambda$0((JavaTimerManager.Timer) obj, (JavaTimerManager.Timer) obj2));
            }
        };
        this.timers = new PriorityQueue(11, new Comparator() { // from class: com.facebook.react.modules.core.JavaTimerManager$$ExternalSyntheticLambda1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return JavaTimerManager.timers$lambda$1(function2, obj, obj2);
            }
        });
        reactApplicationContext.addLifecycleEventListener(this);
        HeadlessJsTaskContext.Companion.getInstance(reactApplicationContext).addTaskEventListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class Timer {
        private final int interval;
        private final boolean repeat;
        private long targetTime;
        private final int timerId;

        public Timer(int i, long j, int i2, boolean z) {
            this.timerId = i;
            this.targetTime = j;
            this.interval = i2;
            this.repeat = z;
        }

        public final int getTimerId() {
            return this.timerId;
        }

        public final long getTargetTime() {
            return this.targetTime;
        }

        public final void setTargetTime(long j) {
            this.targetTime = j;
        }

        public final int getInterval() {
            return this.interval;
        }

        public final boolean getRepeat() {
            return this.repeat;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int timers$lambda$0(Timer timer, Timer timer2) {
        return MathKt.getSign(timer.getTargetTime() - timer2.getTargetTime());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int timers$lambda$1(Function2 function2, Object obj, Object obj2) {
        return ((Number) function2.invoke(obj, obj2)).intValue();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
        this.isPaused.set(true);
        clearFrameCallback();
        maybeIdleCallback();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
        clearFrameCallback();
        maybeIdleCallback();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
        this.isPaused.set(false);
        setChoreographerCallback();
        maybeSetChoreographerIdleCallback();
    }

    @Override // com.facebook.react.jstasks.HeadlessJsTaskEventListener
    public void onHeadlessJsTaskStart(int i) {
        if (this.isRunningTasks.getAndSet(true)) {
            return;
        }
        setChoreographerCallback();
        maybeSetChoreographerIdleCallback();
    }

    @Override // com.facebook.react.jstasks.HeadlessJsTaskEventListener
    public void onHeadlessJsTaskFinish(int i) {
        if (HeadlessJsTaskContext.Companion.getInstance(this.reactApplicationContext).hasActiveTasks()) {
            return;
        }
        this.isRunningTasks.set(false);
        clearFrameCallback();
        maybeIdleCallback();
    }

    public void onInstanceDestroy() {
        HeadlessJsTaskContext.Companion.getInstance(this.reactApplicationContext).removeTaskEventListener(this);
        this.reactApplicationContext.removeLifecycleEventListener(this);
        clearFrameCallback();
        clearChoreographerIdleCallback();
    }

    private final void maybeSetChoreographerIdleCallback() {
        synchronized (this.idleCallbackGuard) {
            try {
                if (this.sendIdleEvents) {
                    setChoreographerIdleCallback();
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void maybeIdleCallback() {
        if (!this.isPaused.get() || this.isRunningTasks.get()) {
            return;
        }
        clearFrameCallback();
    }

    private final void setChoreographerCallback() {
        if (this.frameCallbackPosted) {
            return;
        }
        this.reactChoreographer.postFrameCallback(ReactChoreographer.CallbackType.TIMERS_EVENTS, this.timerFrameCallback);
        this.frameCallbackPosted = true;
    }

    private final void clearFrameCallback() {
        HeadlessJsTaskContext companion = HeadlessJsTaskContext.Companion.getInstance(this.reactApplicationContext);
        if (this.frameCallbackPosted && this.isPaused.get() && !companion.hasActiveTasks()) {
            this.reactChoreographer.removeFrameCallback(ReactChoreographer.CallbackType.TIMERS_EVENTS, this.timerFrameCallback);
            this.frameCallbackPosted = false;
        }
    }

    private final void setChoreographerIdleCallback() {
        if (this.frameIdleCallbackPosted) {
            return;
        }
        this.reactChoreographer.postFrameCallback(ReactChoreographer.CallbackType.IDLE_EVENT, this.idleFrameCallback);
        this.frameIdleCallbackPosted = true;
    }

    private final void clearChoreographerIdleCallback() {
        if (this.frameIdleCallbackPosted) {
            this.reactChoreographer.removeFrameCallback(ReactChoreographer.CallbackType.IDLE_EVENT, this.idleFrameCallback);
            this.frameIdleCallbackPosted = false;
        }
    }

    @DoNotStrip
    public void createTimer(int i, long j, boolean z) {
        Timer timer = new Timer(i, (SystemClock.nanoTime() / ((long) 1000000)) + j, (int) j, z);
        synchronized (this.timerGuard) {
            this.timers.add(timer);
            this.timerIdsToTimers.put(i, timer);
            Unit unit = Unit.INSTANCE;
        }
    }

    public void createAndMaybeCallTimer(int i, int i2, double d, boolean z) {
        long jCurrentTimeMillis = SystemClock.currentTimeMillis();
        long j = (long) d;
        if (this.devSupportManager.getDevSupportEnabled() && Math.abs(j - jCurrentTimeMillis) > 60000) {
            this.javaScriptTimerExecutor.emitTimeDriftWarning("Debugger and device times have drifted by more than 60s. Please correct this by running adb shell \"date `date +%m%d%H%M%Y.%S`\" on your debugger machine.");
        }
        long jMax = Math.max(0L, (j - jCurrentTimeMillis) + ((long) i2));
        if (i2 == 0 && !z) {
            WritableArray writableArrayCreateArray = Arguments.createArray();
            writableArrayCreateArray.pushInt(i);
            this.javaScriptTimerExecutor.callTimers(writableArrayCreateArray);
            return;
        }
        createTimer(i, jMax, z);
    }

    @DoNotStrip
    public void deleteTimer(int i) {
        synchronized (this.timerGuard) {
            Timer timer = (Timer) this.timerIdsToTimers.get(i);
            if (timer == null) {
                return;
            }
            this.timerIdsToTimers.remove(i);
            this.timers.remove(timer);
        }
    }

    @DoNotStrip
    public void setSendIdleEvents(final boolean z) {
        synchronized (this.idleCallbackGuard) {
            this.sendIdleEvents = z;
            Unit unit = Unit.INSTANCE;
        }
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.modules.core.JavaTimerManager$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                JavaTimerManager.setSendIdleEvents$lambda$7(this.f$0, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setSendIdleEvents$lambda$7(JavaTimerManager javaTimerManager, boolean z) {
        synchronized (javaTimerManager.idleCallbackGuard) {
            try {
                if (z) {
                    javaTimerManager.setChoreographerIdleCallback();
                } else {
                    javaTimerManager.clearChoreographerIdleCallback();
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean hasActiveTimersInRange$ReactAndroid_release(long j) {
        synchronized (this.timerGuard) {
            Timer timer = (Timer) this.timers.peek();
            if (timer == null) {
                return false;
            }
            if (Companion.isTimerInRange(timer, j)) {
                return true;
            }
            Iterator it = this.timers.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                Timer timer2 = (Timer) it.next();
                Companion companion = Companion;
                Intrinsics.checkNotNull(timer2);
                if (companion.isTimerInRange(timer2, j)) {
                    return true;
                }
            }
            Unit unit = Unit.INSTANCE;
            return false;
        }
    }

    private final class TimerFrameCallback implements Choreographer.FrameCallback {
        private WritableArray timersToCall;

        public TimerFrameCallback() {
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            Timer timer;
            if (!JavaTimerManager.this.isPaused.get() || JavaTimerManager.this.isRunningTasks.get()) {
                long j2 = j / ((long) 1000000);
                Object obj = JavaTimerManager.this.timerGuard;
                JavaTimerManager javaTimerManager = JavaTimerManager.this;
                synchronized (obj) {
                    while (!javaTimerManager.timers.isEmpty()) {
                        try {
                            Object objPeek = javaTimerManager.timers.peek();
                            Intrinsics.checkNotNull(objPeek);
                            if (((Timer) objPeek).getTargetTime() >= j2 || (timer = (Timer) javaTimerManager.timers.poll()) == null) {
                                break;
                                break;
                            }
                            if (this.timersToCall == null) {
                                this.timersToCall = Arguments.createArray();
                            }
                            WritableArray writableArray = this.timersToCall;
                            if (writableArray != null) {
                                writableArray.pushInt(timer.getTimerId());
                            }
                            if (!timer.getRepeat()) {
                                javaTimerManager.timerIdsToTimers.remove(timer.getTimerId());
                            } else {
                                timer.setTargetTime(((long) timer.getInterval()) + j2);
                                javaTimerManager.timers.add(timer);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                }
                WritableArray writableArray2 = this.timersToCall;
                if (writableArray2 != null) {
                    JavaTimerManager.this.javaScriptTimerExecutor.callTimers(writableArray2);
                    this.timersToCall = null;
                }
                JavaTimerManager.this.reactChoreographer.postFrameCallback(ReactChoreographer.CallbackType.TIMERS_EVENTS, this);
            }
        }
    }

    private final class IdleFrameCallback implements Choreographer.FrameCallback {
        public IdleFrameCallback() {
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            if (!JavaTimerManager.this.isPaused.get() || JavaTimerManager.this.isRunningTasks.get()) {
                IdleCallbackRunnable idleCallbackRunnable = JavaTimerManager.this.currentIdleCallbackRunnable;
                if (idleCallbackRunnable != null) {
                    idleCallbackRunnable.cancel();
                }
                JavaTimerManager javaTimerManager = JavaTimerManager.this;
                javaTimerManager.currentIdleCallbackRunnable = javaTimerManager.new IdleCallbackRunnable(j);
                JavaTimerManager.this.reactApplicationContext.runOnJSQueueThread(JavaTimerManager.this.currentIdleCallbackRunnable);
                JavaTimerManager.this.reactChoreographer.postFrameCallback(ReactChoreographer.CallbackType.IDLE_EVENT, this);
            }
        }
    }

    private final class IdleCallbackRunnable implements Runnable {
        private final long frameStartTime;
        private volatile boolean isCancelled;

        public IdleCallbackRunnable(long j) {
            this.frameStartTime = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            if (this.isCancelled) {
                return;
            }
            long jUptimeMillis = SystemClock.uptimeMillis() - (this.frameStartTime / ((long) 1000000));
            long jCurrentTimeMillis = SystemClock.currentTimeMillis() - jUptimeMillis;
            if (16.666666f - jUptimeMillis < 1.0f) {
                return;
            }
            Object obj = JavaTimerManager.this.idleCallbackGuard;
            JavaTimerManager javaTimerManager = JavaTimerManager.this;
            synchronized (obj) {
                z = javaTimerManager.sendIdleEvents;
                Unit unit = Unit.INSTANCE;
            }
            if (z) {
                JavaTimerManager.this.javaScriptTimerExecutor.callIdleCallbacks(jCurrentTimeMillis);
            }
            JavaTimerManager.this.currentIdleCallbackRunnable = null;
        }

        public final void cancel() {
            this.isCancelled = true;
        }
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isTimerInRange(Timer timer, long j) {
            return !timer.getRepeat() && ((long) timer.getInterval()) < j;
        }
    }
}
