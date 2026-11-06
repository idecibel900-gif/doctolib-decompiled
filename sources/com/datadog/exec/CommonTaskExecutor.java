package com.datadog.exec;

import androidx.core.content.res.FontResourcesParserCompat$$ExternalSyntheticAutoCloseableForwarder1;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Delayed;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class CommonTaskExecutor extends AbstractExecutorService implements AutoCloseable {
    public static final CommonTaskExecutor INSTANCE = new CommonTaskExecutor();
    private final ScheduledExecutorService executorService;

    public interface Task {
        void run(Object obj);
    }

    @Override // java.lang.AutoCloseable
    public /* synthetic */ void close() {
        FontResourcesParserCompat$$ExternalSyntheticAutoCloseableForwarder1.m(this);
    }

    private CommonTaskExecutor() {
        ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(DaemonThreadFactory.TASK_SCHEDULER);
        this.executorService = scheduledExecutorServiceNewSingleThreadScheduledExecutor;
        try {
            Runtime.getRuntime().addShutdownHook(new ShutdownCallback(scheduledExecutorServiceNewSingleThreadScheduledExecutor));
        } catch (IllegalStateException unused) {
        }
    }

    public ScheduledFuture scheduleAtFixedRate(Task task, Object obj, long j, long j2, TimeUnit timeUnit, String str) {
        if (!INSTANCE.isShutdown()) {
            try {
                PeriodicTask periodicTask = new PeriodicTask(task, obj);
                ScheduledFuture<?> scheduledFutureScheduleWithFixedDelay = this.executorService.scheduleWithFixedDelay(new PeriodicTask(task, obj), j, j2, timeUnit);
                periodicTask.setFuture(scheduledFutureScheduleWithFixedDelay);
                return scheduledFutureScheduleWithFixedDelay;
            } catch (RejectedExecutionException unused) {
            }
        }
        return new UnscheduledFuture(str);
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.executorService.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public List shutdownNow() {
        return this.executorService.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.executorService.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.executorService.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        return this.executorService.awaitTermination(j, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.executorService.execute(runnable);
    }

    private static final class ShutdownCallback extends Thread {
        private final ScheduledExecutorService executorService;

        private ShutdownCallback(ScheduledExecutorService scheduledExecutorService) {
            super("dd-exec-shutdown-hook");
            this.executorService = scheduledExecutorService;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            this.executorService.shutdown();
            try {
                if (this.executorService.awaitTermination(5L, TimeUnit.SECONDS)) {
                    return;
                }
                this.executorService.shutdownNow();
            } catch (InterruptedException unused) {
                this.executorService.shutdownNow();
            }
        }
    }

    private static class PeriodicTask implements Runnable {
        private volatile ScheduledFuture future = null;
        private final WeakReference target;
        private final Task task;

        public PeriodicTask(Task task, Object obj) {
            this.target = new WeakReference(obj);
            this.task = task;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj = this.target.get();
            if (obj != null) {
                this.task.run(obj);
            } else if (this.future != null) {
                this.future.cancel(false);
            }
        }

        public void setFuture(ScheduledFuture scheduledFuture) {
            this.future = scheduledFuture;
        }
    }

    private static class UnscheduledFuture implements ScheduledFuture {
        private final String name;

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z) {
            return false;
        }

        @Override // java.lang.Comparable
        public int compareTo(Delayed delayed) {
            return 0;
        }

        @Override // java.util.concurrent.Future
        public Object get() {
            return null;
        }

        @Override // java.util.concurrent.Future
        public Object get(long j, TimeUnit timeUnit) {
            return null;
        }

        @Override // java.util.concurrent.Delayed
        public long getDelay(TimeUnit timeUnit) {
            return 0L;
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return false;
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return false;
        }

        public UnscheduledFuture(String str) {
            this.name = str;
        }
    }
}
