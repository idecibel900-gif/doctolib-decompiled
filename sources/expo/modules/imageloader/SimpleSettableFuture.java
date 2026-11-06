package expo.modules.imageloader;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes4.dex */
public class SimpleSettableFuture implements Future {
    private Exception mException;
    private final CountDownLatch mReadyLatch = new CountDownLatch(1);
    private Object mResult;

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    public void set(Object obj) {
        checkNotSet();
        this.mResult = obj;
        this.mReadyLatch.countDown();
    }

    public void setException(Exception exc) {
        checkNotSet();
        this.mException = exc;
        this.mReadyLatch.countDown();
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.mReadyLatch.getCount() == 0;
    }

    @Override // java.util.concurrent.Future
    public Object get() throws ExecutionException, InterruptedException {
        this.mReadyLatch.await();
        if (this.mException != null) {
            throw new ExecutionException(this.mException);
        }
        return this.mResult;
    }

    @Override // java.util.concurrent.Future
    public Object get(long j, TimeUnit timeUnit) throws ExecutionException, TimeoutException {
        if (!this.mReadyLatch.await(j, timeUnit)) {
            throw new TimeoutException("Timed out waiting for result");
        }
        if (this.mException != null) {
            throw new ExecutionException(this.mException);
        }
        return this.mResult;
    }

    private void checkNotSet() {
        if (this.mReadyLatch.getCount() == 0) {
            throw new RuntimeException("Result has already been set!");
        }
    }
}
