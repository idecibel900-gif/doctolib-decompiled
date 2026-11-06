package com.facebook.react.runtime.internal.bolts;

import com.facebook.react.interfaces.TaskInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class Task implements TaskInterface {
    private boolean cancelled;
    private boolean complete;
    private Exception error;
    private Object result;
    public static final Companion Companion = new Companion(null);
    public static final Executor IMMEDIATE_EXECUTOR = Executors.IMMEDIATE;
    public static final Executor UI_THREAD_EXECUTOR = Executors.UI_THREAD;
    private static final Task TASK_NULL = new Task((Object) null);
    private static final Task TASK_TRUE = new Task(Boolean.TRUE);
    private static final Task TASK_FALSE = new Task(Boolean.FALSE);
    private static final Task TASK_CANCELLED = new Task(true);
    private final Object lock = new Object();
    private final List continuations = new ArrayList();

    public Task() {
    }

    private Task(Object obj) {
        trySetResult$ReactAndroid_release(obj);
    }

    private Task(boolean z) {
        if (z) {
            trySetCancelled$ReactAndroid_release();
        } else {
            trySetResult$ReactAndroid_release(null);
        }
    }

    public boolean isCompleted() {
        boolean z;
        synchronized (this.lock) {
            z = this.complete;
        }
        return z;
    }

    public boolean isCancelled() {
        boolean z;
        synchronized (this.lock) {
            z = this.cancelled;
        }
        return z;
    }

    public boolean isFaulted() {
        boolean z;
        synchronized (this.lock) {
            z = getError() != null;
        }
        return z;
    }

    public Object getResult() {
        Object obj;
        synchronized (this.lock) {
            obj = this.result;
        }
        return obj;
    }

    public Exception getError() {
        Exception exc;
        synchronized (this.lock) {
            exc = this.error;
        }
        return exc;
    }

    public final Task makeVoid() {
        return continueWithTask$default(this, new Continuation() { // from class: com.facebook.react.runtime.internal.bolts.Task$$ExternalSyntheticLambda0
            @Override // com.facebook.react.runtime.internal.bolts.Continuation
            public final Object then(Task task) {
                return Task.makeVoid$lambda$7(task);
            }
        }, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Task makeVoid$lambda$7(Task task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (task.isCancelled()) {
            return Companion.cancelled();
        }
        return task.isFaulted() ? Companion.forError(task.getError()) : TASK_NULL;
    }

    public static /* synthetic */ Task continueWith$default(Task task, Continuation continuation, Executor executor, int i, Object obj) {
        if ((i & 2) != 0) {
            executor = IMMEDIATE_EXECUTOR;
        }
        return task.continueWith(continuation, executor);
    }

    public final Task continueWith(final Continuation continuation, final Executor executor) {
        boolean zIsCompleted;
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        Intrinsics.checkNotNullParameter(executor, "executor");
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        synchronized (this.lock) {
            try {
                zIsCompleted = isCompleted();
                if (!zIsCompleted) {
                    this.continuations.add(new Continuation() { // from class: com.facebook.react.runtime.internal.bolts.Task$$ExternalSyntheticLambda3
                        @Override // com.facebook.react.runtime.internal.bolts.Continuation
                        public final Object then(Task task) {
                            return Task.continueWith$lambda$9$lambda$8(taskCompletionSource, continuation, executor, task);
                        }
                    });
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zIsCompleted) {
            Companion.completeImmediately(taskCompletionSource, continuation, this, executor);
        }
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit continueWith$lambda$9$lambda$8(TaskCompletionSource taskCompletionSource, Continuation continuation, Executor executor, Task task) {
        Intrinsics.checkNotNullParameter(task, "task");
        Companion.completeImmediately(taskCompletionSource, continuation, task, executor);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Task continueWithTask$default(Task task, Continuation continuation, Executor executor, int i, Object obj) {
        if ((i & 2) != 0) {
            executor = IMMEDIATE_EXECUTOR;
        }
        return task.continueWithTask(continuation, executor);
    }

    public final Task continueWithTask(final Continuation continuation, final Executor executor) {
        boolean zIsCompleted;
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        Intrinsics.checkNotNullParameter(executor, "executor");
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        synchronized (this.lock) {
            try {
                zIsCompleted = isCompleted();
                if (!zIsCompleted) {
                    this.continuations.add(new Continuation() { // from class: com.facebook.react.runtime.internal.bolts.Task$$ExternalSyntheticLambda1
                        @Override // com.facebook.react.runtime.internal.bolts.Continuation
                        public final Object then(Task task) {
                            return Task.continueWithTask$lambda$11$lambda$10(taskCompletionSource, continuation, executor, task);
                        }
                    });
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zIsCompleted) {
            Companion.completeAfterTask(taskCompletionSource, continuation, this, executor);
        }
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit continueWithTask$lambda$11$lambda$10(TaskCompletionSource taskCompletionSource, Continuation continuation, Executor executor, Task task) {
        Intrinsics.checkNotNullParameter(task, "task");
        Companion.completeAfterTask(taskCompletionSource, continuation, task, executor);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Task onSuccess$default(Task task, Continuation continuation, Executor executor, int i, Object obj) {
        if ((i & 2) != 0) {
            executor = IMMEDIATE_EXECUTOR;
        }
        return task.onSuccess(continuation, executor);
    }

    public final Task onSuccess(final Continuation continuation, Executor executor) {
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        Intrinsics.checkNotNullParameter(executor, "executor");
        return continueWithTask(new Continuation() { // from class: com.facebook.react.runtime.internal.bolts.Task$$ExternalSyntheticLambda2
            @Override // com.facebook.react.runtime.internal.bolts.Continuation
            public final Object then(Task task) {
                return Task.onSuccess$lambda$12(continuation, task);
            }
        }, executor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Task onSuccess$lambda$12(Continuation continuation, Task task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (task.isCancelled()) {
            return Companion.cancelled();
        }
        return task.isFaulted() ? Companion.forError(task.getError()) : continueWith$default(task, continuation, null, 2, null);
    }

    public final Task onSuccessTask(final Continuation continuation, Executor executor) {
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        Intrinsics.checkNotNullParameter(executor, "executor");
        return continueWithTask(new Continuation() { // from class: com.facebook.react.runtime.internal.bolts.Task$$ExternalSyntheticLambda4
            @Override // com.facebook.react.runtime.internal.bolts.Continuation
            public final Object then(Task task) {
                return Task.onSuccessTask$lambda$13(continuation, task);
            }
        }, executor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Task onSuccessTask$lambda$13(Continuation continuation, Task task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (task.isCancelled()) {
            return Companion.cancelled();
        }
        return task.isFaulted() ? Companion.forError(task.getError()) : continueWithTask$default(task, continuation, null, 2, null);
    }

    private final void runContinuations() {
        synchronized (this.lock) {
            Iterator it = this.continuations.iterator();
            while (it.hasNext()) {
                try {
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
            }
            this.continuations.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final boolean trySetCancelled$ReactAndroid_release() {
        synchronized (this.lock) {
            if (this.complete) {
                return false;
            }
            this.complete = true;
            this.cancelled = true;
            this.lock.notifyAll();
            runContinuations();
            return true;
        }
    }

    public final boolean trySetResult$ReactAndroid_release(Object obj) {
        synchronized (this.lock) {
            if (this.complete) {
                return false;
            }
            this.complete = true;
            this.result = obj;
            this.lock.notifyAll();
            runContinuations();
            return true;
        }
    }

    public final boolean trySetError$ReactAndroid_release(Exception exc) {
        synchronized (this.lock) {
            if (this.complete) {
                return false;
            }
            this.complete = true;
            this.error = exc;
            this.lock.notifyAll();
            runContinuations();
            return true;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Task forResult(Object obj) {
            if (obj == null) {
                Task task = Task.TASK_NULL;
                Intrinsics.checkNotNull(task, "null cannot be cast to non-null type com.facebook.react.runtime.internal.bolts.Task<TResult of com.facebook.react.runtime.internal.bolts.Task.Companion.forResult>");
                return task;
            }
            if (obj instanceof Boolean) {
                Task task2 = ((Boolean) obj).booleanValue() ? Task.TASK_TRUE : Task.TASK_FALSE;
                Intrinsics.checkNotNull(task2, "null cannot be cast to non-null type com.facebook.react.runtime.internal.bolts.Task<TResult of com.facebook.react.runtime.internal.bolts.Task.Companion.forResult>");
                return task2;
            }
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.setResult(obj);
            return taskCompletionSource.getTask();
        }

        public final Task forError(Exception exc) {
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.setError(exc);
            return taskCompletionSource.getTask();
        }

        public final Task cancelled() {
            Task task = Task.TASK_CANCELLED;
            Intrinsics.checkNotNull(task, "null cannot be cast to non-null type com.facebook.react.runtime.internal.bolts.Task<TResult of com.facebook.react.runtime.internal.bolts.Task.Companion.cancelled>");
            return task;
        }

        public final Task call(final Callable callable, Executor executor) {
            Intrinsics.checkNotNullParameter(callable, "callable");
            Intrinsics.checkNotNullParameter(executor, "executor");
            final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            try {
                executor.execute(new Runnable() { // from class: com.facebook.react.runtime.internal.bolts.Task$Companion$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        Task.Companion.call$lambda$2(callable, taskCompletionSource);
                    }
                });
            } catch (Exception e) {
                taskCompletionSource.setError(new ExecutorException(e));
            }
            return taskCompletionSource.getTask();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void call$lambda$2(Callable callable, final TaskCompletionSource taskCompletionSource) {
            Continuation continuation = new Continuation() { // from class: com.facebook.react.runtime.internal.bolts.Task$Companion$$ExternalSyntheticLambda1
                @Override // com.facebook.react.runtime.internal.bolts.Continuation
                public final Object then(Task task) {
                    return Task.Companion.call$lambda$2$lambda$0(taskCompletionSource, task);
                }
            };
            try {
                Task task = (Task) callable.call();
                synchronized (task.lock) {
                    try {
                        if (!task.isCompleted()) {
                            task.continuations.add(continuation);
                        } else {
                            Intrinsics.checkNotNull(task);
                            continuation.then(task);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (CancellationException unused) {
                taskCompletionSource.setCancelled();
            } catch (Exception e) {
                taskCompletionSource.setError(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit call$lambda$2$lambda$0(TaskCompletionSource taskCompletionSource, Task task) {
            Intrinsics.checkNotNullParameter(task, "task");
            if (task.isCancelled()) {
                taskCompletionSource.setCancelled();
            } else if (task.isFaulted()) {
                taskCompletionSource.setError(task.getError());
            } else {
                taskCompletionSource.setResult(task.getResult());
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void completeImmediately(final TaskCompletionSource taskCompletionSource, final Continuation continuation, final Task task, Executor executor) {
            try {
                executor.execute(new Runnable() { // from class: com.facebook.react.runtime.internal.bolts.Task$Companion$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        Task.Companion.completeImmediately$lambda$3(continuation, task, taskCompletionSource);
                    }
                });
            } catch (Exception e) {
                taskCompletionSource.setError(new ExecutorException(e));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void completeImmediately$lambda$3(Continuation continuation, Task task, TaskCompletionSource taskCompletionSource) {
            try {
                taskCompletionSource.setResult(continuation.then(task));
            } catch (CancellationException unused) {
                taskCompletionSource.setCancelled();
            } catch (Exception e) {
                taskCompletionSource.setError(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void completeAfterTask(final TaskCompletionSource taskCompletionSource, final Continuation continuation, final Task task, Executor executor) {
            try {
                executor.execute(new Runnable() { // from class: com.facebook.react.runtime.internal.bolts.Task$Companion$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        Task.Companion.completeAfterTask$lambda$5(continuation, task, taskCompletionSource);
                    }
                });
            } catch (Exception e) {
                taskCompletionSource.setError(new ExecutorException(e));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void completeAfterTask$lambda$5(Continuation continuation, Task task, final TaskCompletionSource taskCompletionSource) {
            try {
                Task task2 = (Task) continuation.then(task);
                if (task2 == null) {
                    taskCompletionSource.setResult(null);
                } else {
                    Task.continueWith$default(task2, new Continuation() { // from class: com.facebook.react.runtime.internal.bolts.Task$Companion$$ExternalSyntheticLambda4
                        @Override // com.facebook.react.runtime.internal.bolts.Continuation
                        public final Object then(Task task3) {
                            return Task.Companion.completeAfterTask$lambda$5$lambda$4(taskCompletionSource, task3);
                        }
                    }, null, 2, null);
                }
            } catch (CancellationException unused) {
                taskCompletionSource.setCancelled();
            } catch (Exception e) {
                taskCompletionSource.setError(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit completeAfterTask$lambda$5$lambda$4(TaskCompletionSource taskCompletionSource, Task task) {
            Intrinsics.checkNotNullParameter(task, "task");
            if (task.isCancelled()) {
                taskCompletionSource.setCancelled();
            } else if (task.isFaulted()) {
                taskCompletionSource.setError(task.getError());
            } else {
                taskCompletionSource.setResult(task.getResult());
            }
            return Unit.INSTANCE;
        }
    }
}
