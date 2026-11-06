package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.internal.InternalFutureFailureAccess;
import com.google.common.util.concurrent.internal.InternalFutures;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Futures extends GwtFuturesCatchingSpecialization {
    public static ListenableFuture immediateFuture(Object obj) {
        if (obj == null) {
            return ImmediateFuture.NULL;
        }
        return new ImmediateFuture(obj);
    }

    public static ListenableFuture immediateVoidFuture() {
        return ImmediateFuture.NULL;
    }

    public static ListenableFuture immediateFailedFuture(Throwable th) {
        Preconditions.checkNotNull(th);
        return new ImmediateFuture.ImmediateFailedFuture(th);
    }

    public static ListenableFuture submitAsync(AsyncCallable asyncCallable, Executor executor) {
        TrustedListenableFutureTask trustedListenableFutureTaskCreate = TrustedListenableFutureTask.create(asyncCallable);
        executor.execute(trustedListenableFutureTaskCreate);
        return trustedListenableFutureTaskCreate;
    }

    public static ListenableFuture catchingAsync(ListenableFuture listenableFuture, Class cls, AsyncFunction asyncFunction, Executor executor) {
        return AbstractCatchingFuture.createAsync(listenableFuture, cls, asyncFunction, executor);
    }

    public static ListenableFuture withTimeout(ListenableFuture listenableFuture, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return listenableFuture.isDone() ? listenableFuture : TimeoutFuture.create(listenableFuture, j, timeUnit, scheduledExecutorService);
    }

    public static ListenableFuture transformAsync(ListenableFuture listenableFuture, AsyncFunction asyncFunction, Executor executor) {
        return AbstractTransformFuture.createAsync(listenableFuture, asyncFunction, executor);
    }

    public static ListenableFuture transform(ListenableFuture listenableFuture, Function function, Executor executor) {
        return AbstractTransformFuture.create(listenableFuture, function, executor);
    }

    public static ListenableFuture allAsList(Iterable iterable) {
        return new CollectionFuture.ListFuture(ImmutableList.copyOf(iterable), true);
    }

    public static void addCallback(ListenableFuture listenableFuture, FutureCallback futureCallback, Executor executor) {
        Preconditions.checkNotNull(futureCallback);
        listenableFuture.addListener(new CallbackListener(listenableFuture, futureCallback), executor);
    }

    private static final class CallbackListener implements Runnable {
        final FutureCallback callback;
        final Future future;

        CallbackListener(Future future, FutureCallback futureCallback) {
            this.future = future;
            this.callback = futureCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable thTryInternalFastPathGetFailure;
            Object obj = this.future;
            if ((obj instanceof InternalFutureFailureAccess) && (thTryInternalFastPathGetFailure = InternalFutures.tryInternalFastPathGetFailure((InternalFutureFailureAccess) obj)) != null) {
                this.callback.onFailure(thTryInternalFastPathGetFailure);
                return;
            }
            try {
                this.callback.onSuccess(Futures.getDone(this.future));
            } catch (ExecutionException e) {
                this.callback.onFailure(e.getCause());
            } catch (Throwable th) {
                this.callback.onFailure(th);
            }
        }

        public String toString() {
            return MoreObjects.toStringHelper(this).addValue(this.callback).toString();
        }
    }

    public static Object getDone(Future future) {
        Preconditions.checkState(future.isDone(), "Future was expected to be done: %s", future);
        return Uninterruptibles.getUninterruptibly(future);
    }
}
