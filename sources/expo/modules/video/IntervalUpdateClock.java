package expo.modules.video;

import android.os.Handler;
import android.os.Looper;
import expo.modules.video.delegates.IgnoreSameSet;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes5.dex */
public final class IntervalUpdateClock {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(IntervalUpdateClock.class, "interval", "getInterval()J", 0))};
    private final WeakReference emitter;
    private Handler handler;
    private final IgnoreSameSet interval$delegate;
    private boolean isRunning;

    public IntervalUpdateClock(IntervalUpdateEmitter emitter) {
        Intrinsics.checkNotNullParameter(emitter, "emitter");
        this.emitter = new WeakReference(emitter);
        this.handler = new Handler(Looper.getMainLooper());
        this.interval$delegate = new IgnoreSameSet(0L, null, new Function2() { // from class: expo.modules.video.IntervalUpdateClock$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return IntervalUpdateClock.interval_delegate$lambda$0(this.f$0, ((Long) obj).longValue(), (Long) obj2);
            }
        }, 2, null);
    }

    public final long getInterval() {
        return ((Number) this.interval$delegate.getValue(this, $$delegatedProperties[0])).longValue();
    }

    public final void setInterval(long j) {
        this.interval$delegate.setValue(this, $$delegatedProperties[0], Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit interval_delegate$lambda$0(IntervalUpdateClock intervalUpdateClock, long j, Long l) {
        if (j <= 0) {
            intervalUpdateClock.stop();
        } else {
            intervalUpdateClock.startOrUpdate();
        }
        return Unit.INSTANCE;
    }

    private final void stop() {
        this.handler.removeCallbacksAndMessages(null);
        this.isRunning = false;
    }

    private final void startOrUpdate() {
        if (!this.isRunning) {
            IntervalUpdateEmitter intervalUpdateEmitter = (IntervalUpdateEmitter) this.emitter.get();
            if (intervalUpdateEmitter != null) {
                intervalUpdateEmitter.emitTimeUpdate();
            }
        } else {
            this.handler.removeCallbacksAndMessages(null);
        }
        this.isRunning = true;
        scheduleNextUpdate();
    }

    private final void scheduleNextUpdate() {
        if (getInterval() <= 0) {
            return;
        }
        final Function0 function0 = new Function0() { // from class: expo.modules.video.IntervalUpdateClock$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return IntervalUpdateClock.scheduleNextUpdate$lambda$1(this.f$0);
            }
        };
        this.handler.postDelayed(new Runnable() { // from class: expo.modules.video.IntervalUpdateClock$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                function0.invoke();
            }
        }, getInterval());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit scheduleNextUpdate$lambda$1(IntervalUpdateClock intervalUpdateClock) {
        IntervalUpdateEmitter intervalUpdateEmitter = (IntervalUpdateEmitter) intervalUpdateClock.emitter.get();
        if (intervalUpdateEmitter != null) {
            intervalUpdateEmitter.emitTimeUpdate();
        }
        intervalUpdateClock.scheduleNextUpdate();
        return Unit.INSTANCE;
    }
}
