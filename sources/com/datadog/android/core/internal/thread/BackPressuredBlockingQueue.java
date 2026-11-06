package com.datadog.android.core.internal.thread;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.configuration.BackPressureMitigation;
import com.datadog.android.core.configuration.BackPressureStrategy;
import com.datadog.android.internal.thread.NamedRunnable;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class BackPressuredBlockingQueue extends ObservableLinkedBlockingQueue {
    private final BackPressureStrategy backPressureStrategy;
    private final String executorContext;
    private final InternalLogger logger;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BackPressureMitigation.values().length];
            try {
                iArr[BackPressureMitigation.DROP_OLDEST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BackPressureMitigation.IGNORE_NEWEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackPressuredBlockingQueue(InternalLogger logger, String executorContext, BackPressureStrategy backPressureStrategy) {
        super(backPressureStrategy.getCapacity(), null, 2, null);
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(executorContext, "executorContext");
        Intrinsics.checkNotNullParameter(backPressureStrategy, "backPressureStrategy");
        this.logger = logger;
        this.executorContext = executorContext;
        this.backPressureStrategy = backPressureStrategy;
    }

    @Override // java.util.concurrent.LinkedBlockingQueue, java.util.Queue, java.util.concurrent.BlockingQueue
    public boolean offer(Object e) {
        Intrinsics.checkNotNullParameter(e, "e");
        return addWithBackPressure(e, new Function1() { // from class: com.datadog.android.core.internal.thread.BackPressuredBlockingQueue.offer.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(BackPressuredBlockingQueue.super.offer(it));
            }
        });
    }

    @Override // java.util.concurrent.LinkedBlockingQueue, java.util.concurrent.BlockingQueue
    public boolean offer(Object e, long j, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(e, "e");
        if (!super.offer(e, j, timeUnit)) {
            return offer(e);
        }
        if (remainingCapacity() != 0) {
            return true;
        }
        onThresholdReached();
        return true;
    }

    private final boolean addWithBackPressure(Object obj, Function1 function1) throws InterruptedException {
        int iRemainingCapacity = remainingCapacity();
        if (iRemainingCapacity == 0) {
            int i = WhenMappings.$EnumSwitchMapping$0[this.backPressureStrategy.getBackpressureMitigation().ordinal()];
            if (i != 1) {
                if (i == 2) {
                    onItemDropped(obj);
                    return true;
                }
                throw new NoWhenBranchMatchedException();
            }
            Object first = take();
            Intrinsics.checkNotNullExpressionValue(first, "first");
            onItemDropped(first);
            return ((Boolean) function1.invoke(obj)).booleanValue();
        }
        if (iRemainingCapacity == 1) {
            onThresholdReached();
        }
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    private final void onThresholdReached() {
        Map mapDumpQueue = dumpQueue();
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        mapCreateMapBuilder.put("capacity", Integer.valueOf(this.backPressureStrategy.getCapacity()));
        if (mapDumpQueue != null && !mapDumpQueue.isEmpty()) {
            mapCreateMapBuilder.put("dump", mapDumpQueue);
        }
        Map mapBuild = MapsKt.build(mapCreateMapBuilder);
        this.backPressureStrategy.getOnThresholdReached().invoke();
        this.logger.log(InternalLogger.Level.WARN, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), new Function0() { // from class: com.datadog.android.core.internal.thread.BackPressuredBlockingQueue.onThresholdReached.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "BackPressuredBlockingQueue reached capacity:" + BackPressuredBlockingQueue.this.backPressureStrategy.getCapacity();
            }
        }, (Throwable) null, false, MapsKt.mapOf(TuplesKt.to("backpressure", mapBuild), TuplesKt.to("executor.context", this.executorContext)));
    }

    private final void onItemDropped(Object obj) {
        final String string;
        this.backPressureStrategy.getOnItemDropped().invoke(obj);
        NamedRunnable namedRunnable = obj instanceof NamedRunnable ? (NamedRunnable) obj : null;
        if (namedRunnable == null || (string = namedRunnable.getSanitizedName()) == null) {
            string = obj.toString();
        }
        this.logger.log(InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, new Function0() { // from class: com.datadog.android.core.internal.thread.BackPressuredBlockingQueue.onItemDropped.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Dropped item in BackPressuredBlockingQueue queue: " + string;
            }
        }, (Throwable) null, false, MapsKt.mapOf(TuplesKt.to("backpressure.capacity", Integer.valueOf(this.backPressureStrategy.getCapacity())), TuplesKt.to("executor.context", this.executorContext)));
    }
}
