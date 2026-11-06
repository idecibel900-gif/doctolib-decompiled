package com.revenuecat.purchases.common;

import android.os.Handler;
import android.os.Looper;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.networking.HTTPResult;
import com.revenuecat.purchases.common.networking.NullPointerReadingErrorStreamException;
import com.revenuecat.purchases.common.verification.SignatureVerificationException;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt;
import kotlin.time.Duration;
import org.json.JSONException;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000 \u00122\u00020\u0001:\u0002\u0011\u0012B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u001a\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/revenuecat/purchases/common/Dispatcher;", "", "executorService", "Ljava/util/concurrent/ExecutorService;", "mainHandler", "Landroid/os/Handler;", "runningIntegrationTests", "", "(Ljava/util/concurrent/ExecutorService;Landroid/os/Handler;Z)V", "close", "", "enqueue", "command", "Ljava/lang/Runnable;", "delay", "Lcom/revenuecat/purchases/common/Delay;", "isClosed", "AsyncCall", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class Dispatcher {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final double INTEGRATION_TEST_DELAY_PERCENTAGE = 0.01d;
    private final ExecutorService executorService;
    private final Handler mainHandler;
    private final boolean runningIntegrationTests;

    public Dispatcher(ExecutorService executorService, Handler handler, boolean z) {
        Intrinsics.checkNotNullParameter(executorService, "executorService");
        this.executorService = executorService;
        this.mainHandler = handler;
        this.runningIntegrationTests = z;
    }

    public /* synthetic */ Dispatcher(ExecutorService executorService, Handler handler, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(executorService, (i & 2) != 0 ? new Handler(Looper.getMainLooper()) : handler, (i & 4) != 0 ? false : z);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/revenuecat/purchases/common/Dispatcher$Companion;", "", "()V", "INTEGRATION_TEST_DELAY_PERCENTAGE", "", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016¨\u0006\f"}, d2 = {"Lcom/revenuecat/purchases/common/Dispatcher$AsyncCall;", "Ljava/lang/Runnable;", "()V", "call", "Lcom/revenuecat/purchases/common/networking/HTTPResult;", "onCompletion", "", "result", "onError", "error", "Lcom/revenuecat/purchases/PurchasesError;", "run", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static abstract class AsyncCall implements Runnable {
        public abstract HTTPResult call() throws JSONException, IOException;

        public void onCompletion(HTTPResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
        }

        public void onError(PurchasesError error) {
            Intrinsics.checkNotNullParameter(error, "error");
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                onCompletion(call());
            } catch (NullPointerReadingErrorStreamException e) {
                PurchasesError purchasesError = ErrorsKt.toPurchasesError(e);
                LogUtilsKt.errorLog(purchasesError);
                onError(purchasesError);
            } catch (SignatureVerificationException e2) {
                PurchasesError purchasesError2 = ErrorsKt.toPurchasesError(e2);
                LogUtilsKt.errorLog(purchasesError2);
                onError(purchasesError2);
            } catch (IOException e3) {
                PurchasesError purchasesError3 = ErrorsKt.toPurchasesError(e3);
                LogUtilsKt.errorLog(purchasesError3);
                onError(purchasesError3);
            } catch (SecurityException e4) {
                PurchasesError purchasesError4 = ErrorsKt.toPurchasesError(e4);
                LogUtilsKt.errorLog(purchasesError4);
                onError(purchasesError4);
            } catch (JSONException e5) {
                PurchasesError purchasesError5 = ErrorsKt.toPurchasesError(e5);
                LogUtilsKt.errorLog(purchasesError5);
                onError(purchasesError5);
            }
        }
    }

    public static /* synthetic */ void enqueue$default(Dispatcher dispatcher, Runnable runnable, Delay delay, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enqueue");
        }
        if ((i & 2) != 0) {
            delay = Delay.NONE;
        }
        dispatcher.enqueue(runnable, delay);
    }

    public void enqueue(final Runnable command, Delay delay) {
        Intrinsics.checkNotNullParameter(command, "command");
        Intrinsics.checkNotNullParameter(delay, "delay");
        synchronized (this.executorService) {
            try {
                if (!this.executorService.isShutdown()) {
                    Runnable runnable = new Runnable() { // from class: com.revenuecat.purchases.common.Dispatcher$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            Dispatcher.enqueue$lambda$3$lambda$2(command, this);
                        }
                    };
                    if (delay != Delay.NONE && (this.executorService instanceof ScheduledExecutorService)) {
                        long jRandom = RangesKt.random(new LongRange(Duration.m5408getInWholeMillisecondsimpl(delay.getMinDelay()), Duration.m5408getInWholeMillisecondsimpl(delay.getMaxDelay())), Random.Default);
                        if (this.runningIntegrationTests) {
                            jRandom = (long) (jRandom * 0.01d);
                        }
                        ((ScheduledExecutorService) this.executorService).schedule(runnable, jRandom, TimeUnit.MILLISECONDS);
                    } else {
                        this.executorService.submit(runnable);
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enqueue$lambda$3$lambda$2(Runnable runnable, Dispatcher dispatcher) {
        try {
            runnable.run();
        } catch (Throwable th) {
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Exception running command: " + th, null);
            Handler handler = dispatcher.mainHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.revenuecat.purchases.common.Dispatcher$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() throws Throwable {
                        Dispatcher.enqueue$lambda$3$lambda$2$lambda$1(th);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enqueue$lambda$3$lambda$2$lambda$1(Throwable th) throws Throwable {
        throw th;
    }

    public void close() {
        synchronized (this.executorService) {
            this.executorService.shutdownNow();
        }
    }

    public boolean isClosed() {
        boolean zIsShutdown;
        synchronized (this.executorService) {
            zIsShutdown = this.executorService.isShutdown();
        }
        return zIsShutdown;
    }
}
