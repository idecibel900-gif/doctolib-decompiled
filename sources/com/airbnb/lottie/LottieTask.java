package com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import androidx.profileinstaller.ProfileInstallReceiver$$ExternalSyntheticLambda0;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.LottieThreadFactory;
import com.amazon.a.a.o.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes3.dex */
public class LottieTask {
    public static Executor EXECUTOR;
    private final Set failureListeners;
    private final Handler handler;
    private volatile LottieResult result;
    private final Set successListeners;

    static {
        if (b.af.equals(System.getProperty("lottie.testing.directExecutor"))) {
            EXECUTOR = new ProfileInstallReceiver$$ExternalSyntheticLambda0();
        } else {
            EXECUTOR = Executors.newCachedThreadPool(new LottieThreadFactory());
        }
    }

    public LottieTask(Callable callable) {
        this(callable, false);
    }

    public LottieTask(Object obj) {
        this.successListeners = new LinkedHashSet(1);
        this.failureListeners = new LinkedHashSet(1);
        this.handler = new Handler(Looper.getMainLooper());
        this.result = null;
        setResult(new LottieResult(obj));
    }

    LottieTask(Callable callable, boolean z) {
        this.successListeners = new LinkedHashSet(1);
        this.failureListeners = new LinkedHashSet(1);
        this.handler = new Handler(Looper.getMainLooper());
        this.result = null;
        if (z) {
            try {
                setResult((LottieResult) callable.call());
                return;
            } catch (Throwable th) {
                setResult(new LottieResult(th));
                return;
            }
        }
        EXECUTOR.execute(new LottieFutureTask(this, callable));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResult(LottieResult lottieResult) {
        if (this.result != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.result = lottieResult;
        notifyListeners();
    }

    public synchronized LottieTask addListener(LottieListener lottieListener) {
        try {
            LottieResult lottieResult = this.result;
            if (lottieResult != null && lottieResult.getValue() != null) {
                lottieListener.onResult(lottieResult.getValue());
            }
            this.successListeners.add(lottieListener);
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public synchronized LottieTask removeListener(LottieListener lottieListener) {
        this.successListeners.remove(lottieListener);
        return this;
    }

    public synchronized LottieTask addFailureListener(LottieListener lottieListener) {
        try {
            LottieResult lottieResult = this.result;
            if (lottieResult != null && lottieResult.getException() != null) {
                lottieListener.onResult(lottieResult.getException());
            }
            this.failureListeners.add(lottieListener);
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public synchronized LottieTask removeFailureListener(LottieListener lottieListener) {
        this.failureListeners.remove(lottieListener);
        return this;
    }

    public LottieResult getResult() {
        return this.result;
    }

    private void notifyListeners() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            notifyListenersInternal();
        } else {
            this.handler.post(new Runnable() { // from class: com.airbnb.lottie.LottieTask$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.notifyListenersInternal();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyListenersInternal() {
        LottieResult lottieResult = this.result;
        if (lottieResult == null) {
            return;
        }
        if (lottieResult.getValue() != null) {
            notifySuccessListeners(lottieResult.getValue());
        } else {
            notifyFailureListeners(lottieResult.getException());
        }
    }

    private synchronized void notifySuccessListeners(Object obj) {
        Iterator it = new ArrayList(this.successListeners).iterator();
        while (it.hasNext()) {
            ((LottieListener) it.next()).onResult(obj);
        }
    }

    private synchronized void notifyFailureListeners(Throwable th) {
        ArrayList arrayList = new ArrayList(this.failureListeners);
        if (arrayList.isEmpty()) {
            Logger.warning("Lottie encountered an error but no failure listener was added:", th);
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((LottieListener) it.next()).onResult(th);
        }
    }

    private static class LottieFutureTask extends FutureTask {
        private LottieTask lottieTask;

        LottieFutureTask(LottieTask lottieTask, Callable callable) {
            super(callable);
            this.lottieTask = lottieTask;
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            try {
                if (isCancelled()) {
                    return;
                }
                try {
                    this.lottieTask.setResult((LottieResult) get());
                } catch (InterruptedException | ExecutionException e) {
                    this.lottieTask.setResult(new LottieResult(e));
                }
            } finally {
                this.lottieTask = null;
            }
        }
    }
}
