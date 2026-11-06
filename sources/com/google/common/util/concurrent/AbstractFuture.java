package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.internal.InternalFutureFailureAccess;
import com.google.common.util.concurrent.internal.InternalFutures;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractFuture extends AbstractFutureState {

    interface Trusted extends ListenableFuture {
    }

    protected void afterDone() {
    }

    protected void interruptTask() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static abstract class TrustedFuture extends AbstractFuture implements Trusted {
        TrustedFuture() {
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public Object get() {
            return super.get();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final Object get(long j, TimeUnit timeUnit) {
            return super.get(j, timeUnit);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isDone() {
            return super.isDone();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public boolean isCancelled() {
            return super.isCancelled();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, com.google.common.util.concurrent.ListenableFuture
        public void addListener(Runnable runnable, Executor executor) {
            super.addListener(runnable, executor);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public boolean cancel(boolean z) {
            return super.cancel(z);
        }
    }

    static final class Listener {
        static final Listener TOMBSTONE = new Listener();
        final Executor executor;
        Listener next;
        final Runnable task;

        Listener(Runnable runnable, Executor executor) {
            this.task = runnable;
            this.executor = executor;
        }

        Listener() {
            this.task = null;
            this.executor = null;
        }
    }

    private static final class Failure {
        static final Failure FALLBACK_INSTANCE = new Failure(new Throwable("Failure occurred while trying to finish a future.") { // from class: com.google.common.util.concurrent.AbstractFuture.Failure.1
            @Override // java.lang.Throwable
            public Throwable fillInStackTrace() {
                return this;
            }
        });
        final Throwable exception;

        Failure(Throwable th) {
            this.exception = (Throwable) Preconditions.checkNotNull(th);
        }
    }

    private static final class Cancellation {
        static final Cancellation CAUSELESS_CANCELLED;
        static final Cancellation CAUSELESS_INTERRUPTED;
        final Throwable cause;
        final boolean wasInterrupted;

        static {
            if (AbstractFutureState.GENERATE_CANCELLATION_CAUSES) {
                CAUSELESS_CANCELLED = null;
                CAUSELESS_INTERRUPTED = null;
            } else {
                CAUSELESS_CANCELLED = new Cancellation(false, null);
                CAUSELESS_INTERRUPTED = new Cancellation(true, null);
            }
        }

        Cancellation(boolean z, Throwable th) {
            this.wasInterrupted = z;
            this.cause = th;
        }
    }

    private static final class DelegatingToFuture implements Runnable {
        final ListenableFuture future;
        final AbstractFuture owner;

        DelegatingToFuture(AbstractFuture abstractFuture, ListenableFuture listenableFuture) {
            this.owner = abstractFuture;
            this.future = listenableFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.owner.value() != this) {
                return;
            }
            if (AbstractFutureState.casValue(this.owner, this, AbstractFuture.getFutureValue(this.future))) {
                AbstractFuture.complete(this.owner, false);
            }
        }
    }

    protected AbstractFuture() {
    }

    @Override // java.util.concurrent.Future
    public Object get(long j, TimeUnit timeUnit) {
        return Platform.get(this, j, timeUnit);
    }

    @Override // java.util.concurrent.Future
    public Object get() {
        return Platform.get(this);
    }

    static Object getDoneValue(Object obj) throws ExecutionException {
        if (obj instanceof Cancellation) {
            throw cancellationExceptionWithCause("Task was cancelled.", ((Cancellation) obj).cause);
        }
        if (obj instanceof Failure) {
            throw new ExecutionException(((Failure) obj).exception);
        }
        return obj == AbstractFutureState.NULL ? NullnessCasts.uncheckedNull() : obj;
    }

    static boolean notInstanceOfDelegatingToFuture(Object obj) {
        return !(obj instanceof DelegatingToFuture);
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        Object objValue = value();
        return notInstanceOfDelegatingToFuture(objValue) & (objValue != null);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return value() instanceof Cancellation;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        Cancellation cancellation;
        Object objValue = value();
        if (!(objValue == null) && !(objValue instanceof DelegatingToFuture)) {
            return false;
        }
        if (AbstractFutureState.GENERATE_CANCELLATION_CAUSES) {
            cancellation = new Cancellation(z, new CancellationException("Future.cancel() was called."));
        } else {
            if (z) {
                cancellation = Cancellation.CAUSELESS_INTERRUPTED;
            } else {
                cancellation = Cancellation.CAUSELESS_CANCELLED;
            }
            Objects.requireNonNull(cancellation);
        }
        AbstractFuture abstractFuture = this;
        boolean z2 = false;
        while (true) {
            if (AbstractFutureState.casValue(abstractFuture, objValue, cancellation)) {
                complete(abstractFuture, z);
                if (objValue instanceof DelegatingToFuture) {
                    ListenableFuture listenableFuture = ((DelegatingToFuture) objValue).future;
                    if (listenableFuture instanceof Trusted) {
                        abstractFuture = (AbstractFuture) listenableFuture;
                        objValue = abstractFuture.value();
                        if ((objValue == null) | (objValue instanceof DelegatingToFuture)) {
                            z2 = true;
                        }
                    } else {
                        listenableFuture.cancel(z);
                    }
                }
                return true;
            }
            objValue = abstractFuture.value();
            if (notInstanceOfDelegatingToFuture(objValue)) {
                return z2;
            }
        }
    }

    protected final boolean wasInterrupted() {
        Object objValue = value();
        return (objValue instanceof Cancellation) && ((Cancellation) objValue).wasInterrupted;
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable runnable, Executor executor) {
        Listener listenerListeners;
        Preconditions.checkNotNull(runnable, "Runnable was null.");
        Preconditions.checkNotNull(executor, "Executor was null.");
        if (!isDone() && (listenerListeners = listeners()) != Listener.TOMBSTONE) {
            Listener listener = new Listener(runnable, executor);
            do {
                listener.next = listenerListeners;
                if (casListeners(listenerListeners, listener)) {
                    return;
                } else {
                    listenerListeners = listeners();
                }
            } while (listenerListeners != Listener.TOMBSTONE);
        }
        executeListener(runnable, executor);
    }

    protected boolean set(Object obj) {
        if (obj == null) {
            obj = AbstractFutureState.NULL;
        }
        if (!AbstractFutureState.casValue(this, null, obj)) {
            return false;
        }
        complete(this, false);
        return true;
    }

    protected boolean setException(Throwable th) {
        if (!AbstractFutureState.casValue(this, null, new Failure((Throwable) Preconditions.checkNotNull(th)))) {
            return false;
        }
        complete(this, false);
        return true;
    }

    protected boolean setFuture(ListenableFuture listenableFuture) {
        Failure failure;
        Preconditions.checkNotNull(listenableFuture);
        Object objValue = value();
        if (objValue == null) {
            if (listenableFuture.isDone()) {
                if (!AbstractFutureState.casValue(this, null, getFutureValue(listenableFuture))) {
                    return false;
                }
                complete(this, false);
                return true;
            }
            DelegatingToFuture delegatingToFuture = new DelegatingToFuture(this, listenableFuture);
            if (AbstractFutureState.casValue(this, null, delegatingToFuture)) {
                try {
                    listenableFuture.addListener(delegatingToFuture, DirectExecutor.INSTANCE);
                } catch (Throwable th) {
                    try {
                        failure = new Failure(th);
                    } catch (Error | Exception unused) {
                        failure = Failure.FALLBACK_INSTANCE;
                    }
                    AbstractFutureState.casValue(this, delegatingToFuture, failure);
                }
                return true;
            }
            objValue = value();
        }
        if (objValue instanceof Cancellation) {
            listenableFuture.cancel(((Cancellation) objValue).wasInterrupted);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static Object getFutureValue(ListenableFuture listenableFuture) {
        Throwable thTryInternalFastPathGetFailure;
        if (listenableFuture instanceof Trusted) {
            Object objValue = ((AbstractFuture) listenableFuture).value();
            if (objValue instanceof Cancellation) {
                Cancellation cancellation = (Cancellation) objValue;
                if (cancellation.wasInterrupted) {
                    objValue = cancellation.cause != null ? new Cancellation(false, cancellation.cause) : Cancellation.CAUSELESS_CANCELLED;
                }
            }
            Objects.requireNonNull(objValue);
            return objValue;
        }
        if ((listenableFuture instanceof InternalFutureFailureAccess) && (thTryInternalFastPathGetFailure = InternalFutures.tryInternalFastPathGetFailure((InternalFutureFailureAccess) listenableFuture)) != null) {
            return new Failure(thTryInternalFastPathGetFailure);
        }
        boolean zIsCancelled = listenableFuture.isCancelled();
        if ((!AbstractFutureState.GENERATE_CANCELLATION_CAUSES) & zIsCancelled) {
            Cancellation cancellation2 = Cancellation.CAUSELESS_CANCELLED;
            Objects.requireNonNull(cancellation2);
            return cancellation2;
        }
        try {
            Object uninterruptibly = getUninterruptibly(listenableFuture);
            if (!zIsCancelled) {
                return uninterruptibly == null ? AbstractFutureState.NULL : uninterruptibly;
            }
            return new Cancellation(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + listenableFuture));
        } catch (Error | Exception e) {
            return new Failure(e);
        } catch (CancellationException e2) {
            if (!zIsCancelled) {
                return new Failure(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + listenableFuture, e2));
            }
            return new Cancellation(false, e2);
        } catch (ExecutionException e3) {
            if (zIsCancelled) {
                return new Cancellation(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + listenableFuture, e3));
            }
            return new Failure(e3.getCause());
        }
    }

    private static Object getUninterruptibly(Future future) {
        Object obj;
        boolean z = false;
        while (true) {
            try {
                obj = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Platform.interruptCurrentThread();
                }
                throw th;
            }
        }
        if (z) {
            Platform.interruptCurrentThread();
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void complete(AbstractFuture abstractFuture, boolean z) {
        Listener listener = null;
        while (true) {
            abstractFuture.releaseWaiters();
            if (z) {
                abstractFuture.interruptTask();
                z = false;
            }
            abstractFuture.afterDone();
            Listener listenerClearListeners = abstractFuture.clearListeners(listener);
            while (listenerClearListeners != null) {
                listener = listenerClearListeners.next;
                Runnable runnable = listenerClearListeners.task;
                Objects.requireNonNull(runnable);
                Runnable runnable2 = runnable;
                if (runnable2 instanceof DelegatingToFuture) {
                    DelegatingToFuture delegatingToFuture = (DelegatingToFuture) runnable2;
                    abstractFuture = delegatingToFuture.owner;
                    if (abstractFuture.value() != delegatingToFuture || !AbstractFutureState.casValue(abstractFuture, delegatingToFuture, getFutureValue(delegatingToFuture.future))) {
                    }
                } else {
                    Executor executor = listenerClearListeners.executor;
                    Objects.requireNonNull(executor);
                    executeListener(runnable2, executor);
                }
                listenerClearListeners = listener;
            }
            return;
        }
    }

    @Override // com.google.common.util.concurrent.internal.InternalFutureFailureAccess
    protected final Throwable tryInternalFastPathGetFailure() {
        if (!(this instanceof Trusted)) {
            return null;
        }
        Object objValue = value();
        if (objValue instanceof Failure) {
            return ((Failure) objValue).exception;
        }
        return null;
    }

    final void maybePropagateCancellationTo(Future future) {
        if ((future != null) && isCancelled()) {
            future.cancel(wasInterrupted());
        }
    }

    private Listener clearListeners(Listener listener) {
        Listener listener2 = listener;
        Listener listenerGasListeners = gasListeners(Listener.TOMBSTONE);
        while (listenerGasListeners != null) {
            Listener listener3 = listenerGasListeners.next;
            listenerGasListeners.next = listener2;
            listener2 = listenerGasListeners;
            listenerGasListeners = listener3;
        }
        return listener2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            sb.append(getClass().getSimpleName());
        } else {
            sb.append(getClass().getName());
        }
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            addDoneString(sb);
        } else {
            addPendingString(sb);
        }
        sb.append("]");
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected String pendingToString() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    private void addPendingString(StringBuilder sb) {
        String strEmptyToNull;
        int length = sb.length();
        sb.append("PENDING");
        Object objValue = value();
        if (objValue instanceof DelegatingToFuture) {
            sb.append(", setFuture=[");
            appendUserObject(sb, ((DelegatingToFuture) objValue).future);
            sb.append("]");
        } else {
            try {
                strEmptyToNull = Strings.emptyToNull(pendingToString());
            } catch (Throwable th) {
                Platform.rethrowIfErrorOtherThanStackOverflow(th);
                strEmptyToNull = "Exception thrown from implementation: " + th.getClass();
            }
            if (strEmptyToNull != null) {
                sb.append(", info=[");
                sb.append(strEmptyToNull);
                sb.append("]");
            }
        }
        if (isDone()) {
            sb.delete(length, sb.length());
            addDoneString(sb);
        }
    }

    private void addDoneString(StringBuilder sb) {
        try {
            Object uninterruptibly = getUninterruptibly(this);
            sb.append("SUCCESS, result=[");
            appendResultObject(sb, uninterruptibly);
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (ExecutionException e) {
            sb.append("FAILURE, cause=[");
            sb.append(e.getCause());
            sb.append("]");
        } catch (Exception e2) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e2.getClass());
            sb.append(" thrown from get()]");
        }
    }

    private void appendResultObject(StringBuilder sb, Object obj) {
        if (obj == null) {
            sb.append("null");
        } else {
            if (obj == this) {
                sb.append("this future");
                return;
            }
            sb.append(obj.getClass().getName());
            sb.append("@");
            sb.append(Integer.toHexString(System.identityHashCode(obj)));
        }
    }

    private void appendUserObject(StringBuilder sb, Object obj) {
        try {
            if (obj == this) {
                sb.append("this future");
            } else {
                sb.append(obj);
            }
        } catch (Throwable th) {
            Platform.rethrowIfErrorOtherThanStackOverflow(th);
            sb.append("Exception thrown from implementation: ");
            sb.append(th.getClass());
        }
    }

    private static void executeListener(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (Exception e) {
            AbstractFutureState.log.get().log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e);
        }
    }

    private static CancellationException cancellationExceptionWithCause(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }
}
