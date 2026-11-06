package com.facebook.imagepipeline.core;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DefaultExecutorSupplier implements ExecutorSupplier {
    public static final Companion Companion = new Companion(null);
    private final Executor backgroundExecutor;
    private final ScheduledExecutorService backgroundScheduledExecutorService;
    private final Executor decodeExecutor;
    private final Executor ioBoundExecutor;
    private final Executor lightWeightBackgroundExecutor;

    public DefaultExecutorSupplier(int i) {
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(2, new PriorityThreadFactory(10, "FrescoIoBoundExecutor", true));
        Intrinsics.checkNotNullExpressionValue(executorServiceNewFixedThreadPool, "newFixedThreadPool(...)");
        this.ioBoundExecutor = executorServiceNewFixedThreadPool;
        ExecutorService executorServiceNewFixedThreadPool2 = Executors.newFixedThreadPool(i, new PriorityThreadFactory(10, "FrescoDecodeExecutor", true));
        Intrinsics.checkNotNullExpressionValue(executorServiceNewFixedThreadPool2, "newFixedThreadPool(...)");
        this.decodeExecutor = executorServiceNewFixedThreadPool2;
        ExecutorService executorServiceNewFixedThreadPool3 = Executors.newFixedThreadPool(i, new PriorityThreadFactory(10, "FrescoBackgroundExecutor", true));
        Intrinsics.checkNotNullExpressionValue(executorServiceNewFixedThreadPool3, "newFixedThreadPool(...)");
        this.backgroundExecutor = executorServiceNewFixedThreadPool3;
        ExecutorService executorServiceNewFixedThreadPool4 = Executors.newFixedThreadPool(1, new PriorityThreadFactory(10, "FrescoLightWeightBackgroundExecutor", true));
        Intrinsics.checkNotNullExpressionValue(executorServiceNewFixedThreadPool4, "newFixedThreadPool(...)");
        this.lightWeightBackgroundExecutor = executorServiceNewFixedThreadPool4;
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(i, new PriorityThreadFactory(10, "FrescoBackgroundExecutor", true));
        Intrinsics.checkNotNullExpressionValue(scheduledExecutorServiceNewScheduledThreadPool, "newScheduledThreadPool(...)");
        this.backgroundScheduledExecutorService = scheduledExecutorServiceNewScheduledThreadPool;
    }

    @Override // com.facebook.imagepipeline.core.ExecutorSupplier
    public Executor forLocalStorageRead() {
        return this.ioBoundExecutor;
    }

    @Override // com.facebook.imagepipeline.core.ExecutorSupplier
    public Executor forLocalStorageWrite() {
        return this.ioBoundExecutor;
    }

    @Override // com.facebook.imagepipeline.core.ExecutorSupplier
    public Executor forDecode() {
        return this.decodeExecutor;
    }

    @Override // com.facebook.imagepipeline.core.ExecutorSupplier
    public Executor forBackgroundTasks() {
        return this.backgroundExecutor;
    }

    @Override // com.facebook.imagepipeline.core.ExecutorSupplier
    public ScheduledExecutorService scheduledExecutorServiceForBackgroundTasks() {
        return this.backgroundScheduledExecutorService;
    }

    @Override // com.facebook.imagepipeline.core.ExecutorSupplier
    public Executor forLightweightBackgroundTasks() {
        return this.lightWeightBackgroundExecutor;
    }

    @Override // com.facebook.imagepipeline.core.ExecutorSupplier
    public Executor forThumbnailProducer() {
        return this.ioBoundExecutor;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
