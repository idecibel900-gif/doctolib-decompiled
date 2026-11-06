package app.notifee.core.utility;

import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class ExtendedListenableFuture implements ListenableFuture {
    private final ListenableFuture future;

    public ExtendedListenableFuture(ListenableFuture listenableFuture) {
        this.future = listenableFuture;
    }

    public ExtendedListenableFuture continueWith(AsyncFunction asyncFunction, Executor executor) {
        return new ExtendedListenableFuture(Futures.transformAsync(this, asyncFunction, executor));
    }

    public ExtendedListenableFuture addOnCompleteListener(final Callbackable callbackable, Executor executor) {
        Futures.addCallback(this, new FutureCallback() { // from class: app.notifee.core.utility.ExtendedListenableFuture.1
            @Override // com.google.common.util.concurrent.FutureCallback
            public void onSuccess(Object obj) {
                callbackable.call(null, obj);
            }

            @Override // com.google.common.util.concurrent.FutureCallback
            public void onFailure(Throwable th) {
                callbackable.call(new Exception(th), null);
            }
        }, executor);
        return this;
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable runnable, Executor executor) {
        this.future.addListener(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return this.future.cancel(z);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.future.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.future.isDone();
    }

    @Override // java.util.concurrent.Future
    public Object get() {
        return this.future.get();
    }

    @Override // java.util.concurrent.Future
    public Object get(long j, TimeUnit timeUnit) {
        return this.future.get(j, timeUnit);
    }
}
