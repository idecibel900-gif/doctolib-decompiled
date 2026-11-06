package bolts;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public class Task {
    private boolean cancelled;
    private boolean complete;
    private Exception error;
    private boolean errorHasBeenObserved;
    private Object result;
    private UnobservedErrorNotifier unobservedErrorNotifier;
    public static final ExecutorService BACKGROUND_EXECUTOR = BoltsExecutors.background();
    private static final Executor IMMEDIATE_EXECUTOR = BoltsExecutors.immediate();
    public static final Executor UI_THREAD_EXECUTOR = AndroidExecutors.uiThread();
    private static Task TASK_NULL = new Task((Object) null);
    private static Task TASK_TRUE = new Task(Boolean.TRUE);
    private static Task TASK_FALSE = new Task(Boolean.FALSE);
    private static Task TASK_CANCELLED = new Task(true);
    private final Object lock = new Object();
    private List continuations = new ArrayList();

    public interface UnobservedExceptionHandler {
    }

    public static UnobservedExceptionHandler getUnobservedExceptionHandler() {
        return null;
    }

    Task() {
    }

    private Task(Object obj) {
        trySetResult(obj);
    }

    private Task(boolean z) {
        if (z) {
            trySetCancelled();
        } else {
            trySetResult(null);
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
            try {
                if (this.error != null) {
                    this.errorHasBeenObserved = true;
                }
                exc = this.error;
            } catch (Throwable th) {
                throw th;
            }
        }
        return exc;
    }

    public static Task forResult(Object obj) {
        if (obj == null) {
            return TASK_NULL;
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue() ? TASK_TRUE : TASK_FALSE;
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.setResult(obj);
        return taskCompletionSource.getTask();
    }

    public static Task forError(Exception exc) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.setError(exc);
        return taskCompletionSource.getTask();
    }

    public static Task call(Callable callable, Executor executor) {
        return call(callable, executor, null);
    }

    public static Task call(Callable callable, Executor executor, CancellationToken cancellationToken) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        try {
            executor.execute(new Runnable(cancellationToken, taskCompletionSource, callable) { // from class: bolts.Task.4
                final /* synthetic */ Callable val$callable;
                final /* synthetic */ TaskCompletionSource val$tcs;

                {
                    this.val$tcs = taskCompletionSource;
                    this.val$callable = callable;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        this.val$tcs.setResult(this.val$callable.call());
                    } catch (CancellationException unused) {
                        this.val$tcs.setCancelled();
                    } catch (Exception e) {
                        this.val$tcs.setError(e);
                    }
                }
            });
        } catch (Exception e) {
            taskCompletionSource.setError(new ExecutorException(e));
        }
        return taskCompletionSource.getTask();
    }

    public Task continueWith(Continuation continuation, Executor executor, CancellationToken cancellationToken) throws Throwable {
        Continuation continuation2;
        Executor executor2;
        CancellationToken cancellationToken2;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        synchronized (this.lock) {
            try {
                try {
                    boolean zIsCompleted = isCompleted();
                    if (zIsCompleted) {
                        continuation2 = continuation;
                        executor2 = executor;
                        cancellationToken2 = cancellationToken;
                    } else {
                        continuation2 = continuation;
                        executor2 = executor;
                        cancellationToken2 = cancellationToken;
                        this.continuations.add(new Continuation(taskCompletionSource, continuation2, executor2, cancellationToken2) { // from class: bolts.Task.10
                            final /* synthetic */ Continuation val$continuation;
                            final /* synthetic */ Executor val$executor;
                            final /* synthetic */ TaskCompletionSource val$tcs;

                            @Override // bolts.Continuation
                            public Void then(Task task) {
                                Task.completeImmediately(this.val$tcs, this.val$continuation, task, this.val$executor, null);
                                return null;
                            }
                        });
                    }
                    if (zIsCompleted) {
                        completeImmediately(taskCompletionSource, continuation2, this, executor2, cancellationToken2);
                    }
                    return taskCompletionSource.getTask();
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public Task continueWith(Continuation continuation) {
        return continueWith(continuation, IMMEDIATE_EXECUTOR, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void completeImmediately(TaskCompletionSource taskCompletionSource, Continuation continuation, Task task, Executor executor, CancellationToken cancellationToken) {
        try {
            executor.execute(new Runnable(cancellationToken, taskCompletionSource, continuation, task) { // from class: bolts.Task.14
                final /* synthetic */ Continuation val$continuation;
                final /* synthetic */ Task val$task;
                final /* synthetic */ TaskCompletionSource val$tcs;

                {
                    this.val$tcs = taskCompletionSource;
                    this.val$continuation = continuation;
                    this.val$task = task;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        this.val$tcs.setResult(this.val$continuation.then(this.val$task));
                    } catch (CancellationException unused) {
                        this.val$tcs.setCancelled();
                    } catch (Exception e) {
                        this.val$tcs.setError(e);
                    }
                }
            });
        } catch (Exception e) {
            taskCompletionSource.setError(new ExecutorException(e));
        }
    }

    private void runContinuations() {
        synchronized (this.lock) {
            Iterator it = this.continuations.iterator();
            while (it.hasNext()) {
                try {
                    ((Continuation) it.next()).then(this);
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
            }
            this.continuations = null;
        }
    }

    boolean trySetCancelled() {
        synchronized (this.lock) {
            try {
                if (this.complete) {
                    return false;
                }
                this.complete = true;
                this.cancelled = true;
                this.lock.notifyAll();
                runContinuations();
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    boolean trySetResult(Object obj) {
        synchronized (this.lock) {
            try {
                if (this.complete) {
                    return false;
                }
                this.complete = true;
                this.result = obj;
                this.lock.notifyAll();
                runContinuations();
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    boolean trySetError(Exception exc) {
        synchronized (this.lock) {
            try {
                if (this.complete) {
                    return false;
                }
                this.complete = true;
                this.error = exc;
                this.errorHasBeenObserved = false;
                this.lock.notifyAll();
                runContinuations();
                if (!this.errorHasBeenObserved) {
                    getUnobservedExceptionHandler();
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
