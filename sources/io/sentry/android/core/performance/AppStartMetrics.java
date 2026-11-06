package io.sentry.android.core.performance;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.app.ApplicationStartInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.SystemClock;
import io.sentry.IContinuousProfiler;
import io.sentry.ISentryLifecycleToken;
import io.sentry.ITransactionProfiler;
import io.sentry.NoOpLogger;
import io.sentry.TracesSamplingDecision;
import io.sentry.android.core.BuildInfoProvider;
import io.sentry.android.core.ContextUtils;
import io.sentry.android.core.CurrentActivityHolder;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.android.core.internal.util.FirstDrawDoneListener;
import io.sentry.util.AutoClosableReentrantLock;
import io.sentry.util.LazyEvaluator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public class AppStartMetrics extends ActivityLifecycleCallbacksAdapter {
    private static volatile AppStartMetrics instance;
    private static long CLASS_LOADED_UPTIME_MS = SystemClock.uptimeMillis();
    public static final AutoClosableReentrantLock staticLock = new AutoClosableReentrantLock();
    private AppStartType appStartType = AppStartType.UNKNOWN;
    private final LazyEvaluator appLaunchedInForeground = new LazyEvaluator(new LazyEvaluator.Evaluator() { // from class: io.sentry.android.core.performance.AppStartMetrics.1
        @Override // io.sentry.util.LazyEvaluator.Evaluator
        public Boolean evaluate() {
            return Boolean.valueOf(ContextUtils.isForegroundImportance());
        }
    });
    private volatile long firstIdle = -1;
    private ITransactionProfiler appStartProfiler = null;
    private IContinuousProfiler appStartContinuousProfiler = null;
    private TracesSamplingDecision appStartSamplingDecision = null;
    private boolean isCallbackRegistered = false;
    private boolean shouldSendStartMeasurements = true;
    private final AtomicInteger activeActivitiesCounter = new AtomicInteger();
    private final AtomicBoolean firstDrawDone = new AtomicBoolean(false);
    private final TimeSpan appStartSpan = new TimeSpan();
    private final TimeSpan sdkInitTimeSpan = new TimeSpan();
    private final TimeSpan applicationOnCreate = new TimeSpan();
    private final Map contentProviderOnCreates = new HashMap();
    private final List activityLifecycles = new ArrayList();

    public enum AppStartType {
        UNKNOWN,
        COLD,
        WARM
    }

    public static AppStartMetrics getInstance() {
        if (instance == null) {
            ISentryLifecycleToken iSentryLifecycleTokenAcquire = staticLock.acquire();
            try {
                if (instance == null) {
                    instance = new AppStartMetrics();
                }
                if (iSentryLifecycleTokenAcquire != null) {
                    iSentryLifecycleTokenAcquire.close();
                }
            } catch (Throwable th) {
                if (iSentryLifecycleTokenAcquire != null) {
                    try {
                        iSentryLifecycleTokenAcquire.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        return instance;
    }

    public TimeSpan getAppStartTimeSpan() {
        return this.appStartSpan;
    }

    public TimeSpan createProcessInitSpan() {
        TimeSpan timeSpan = new TimeSpan();
        timeSpan.setup("Process Initialization", this.appStartSpan.getStartTimestampMs(), this.appStartSpan.getStartUptimeMs(), CLASS_LOADED_UPTIME_MS);
        return timeSpan;
    }

    public TimeSpan getSdkInitTimeSpan() {
        return this.sdkInitTimeSpan;
    }

    public TimeSpan getApplicationOnCreateTimeSpan() {
        return this.applicationOnCreate;
    }

    public AppStartType getAppStartType() {
        return this.appStartType;
    }

    public boolean isAppLaunchedInForeground() {
        return ((Boolean) this.appLaunchedInForeground.getValue()).booleanValue();
    }

    public List getContentProviderOnCreateTimeSpans() {
        ArrayList arrayList = new ArrayList(this.contentProviderOnCreates.values());
        Collections.sort(arrayList);
        return arrayList;
    }

    public List getActivityLifecycleTimeSpans() {
        ArrayList arrayList = new ArrayList(this.activityLifecycles);
        Collections.sort(arrayList);
        return arrayList;
    }

    public void addActivityLifecycleTimeSpans(ActivityLifecycleTimeSpan activityLifecycleTimeSpan) {
        this.activityLifecycles.add(activityLifecycleTimeSpan);
    }

    public void onAppStartSpansSent() {
        this.shouldSendStartMeasurements = false;
        this.contentProviderOnCreates.clear();
        this.activityLifecycles.clear();
    }

    public boolean shouldSendStartMeasurements() {
        return this.shouldSendStartMeasurements && ((Boolean) this.appLaunchedInForeground.getValue()).booleanValue();
    }

    public TimeSpan getAppStartTimeSpanWithFallback(SentryAndroidOptions sentryAndroidOptions) {
        if (this.appStartType != AppStartType.UNKNOWN && ((Boolean) this.appLaunchedInForeground.getValue()).booleanValue()) {
            if (sentryAndroidOptions.isEnablePerformanceV2()) {
                TimeSpan appStartTimeSpan = getAppStartTimeSpan();
                if (appStartTimeSpan.hasStarted() && appStartTimeSpan.getDurationMs() <= TimeUnit.MINUTES.toMillis(1L)) {
                    return appStartTimeSpan;
                }
            }
            TimeSpan sdkInitTimeSpan = getSdkInitTimeSpan();
            if (sdkInitTimeSpan.hasStarted() && sdkInitTimeSpan.getDurationMs() <= TimeUnit.MINUTES.toMillis(1L)) {
                return sdkInitTimeSpan;
            }
        }
        return new TimeSpan();
    }

    public ITransactionProfiler getAppStartProfiler() {
        return this.appStartProfiler;
    }

    public void setAppStartProfiler(ITransactionProfiler iTransactionProfiler) {
        this.appStartProfiler = iTransactionProfiler;
    }

    public IContinuousProfiler getAppStartContinuousProfiler() {
        return this.appStartContinuousProfiler;
    }

    public void setAppStartContinuousProfiler(IContinuousProfiler iContinuousProfiler) {
        this.appStartContinuousProfiler = iContinuousProfiler;
    }

    public void setAppStartSamplingDecision(TracesSamplingDecision tracesSamplingDecision) {
        this.appStartSamplingDecision = tracesSamplingDecision;
    }

    public TracesSamplingDecision getAppStartSamplingDecision() {
        return this.appStartSamplingDecision;
    }

    public void registerLifecycleCallbacks(Application application) {
        ActivityManager activityManager;
        if (this.isCallbackRegistered) {
            return;
        }
        this.isCallbackRegistered = true;
        this.appLaunchedInForeground.resetValue();
        application.registerActivityLifecycleCallbacks(instance);
        if (Build.VERSION.SDK_INT >= 35 && (activityManager = (ActivityManager) application.getSystemService("activity")) != null) {
            List historicalProcessStartReasons = activityManager.getHistoricalProcessStartReasons(1);
            if (!historicalProcessStartReasons.isEmpty()) {
                ApplicationStartInfo applicationStartInfoM = AppStartMetrics$$ExternalSyntheticApiModelOutline0.m(historicalProcessStartReasons.get(0));
                if (applicationStartInfoM.getStartupState() == 0) {
                    if (applicationStartInfoM.getStartType() == 1) {
                        this.appStartType = AppStartType.COLD;
                    } else {
                        this.appStartType = AppStartType.WARM;
                    }
                }
            }
        }
        AppStartType appStartType = this.appStartType;
        AppStartType appStartType2 = AppStartType.UNKNOWN;
        if (appStartType == appStartType2) {
            Looper.getMainLooper().getQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: io.sentry.android.core.performance.AppStartMetrics.2
                @Override // android.os.MessageQueue.IdleHandler
                public boolean queueIdle() {
                    AppStartMetrics.this.firstIdle = SystemClock.uptimeMillis();
                    AppStartMetrics.this.checkCreateTimeOnMain();
                    return false;
                }
            });
        } else if (appStartType == appStartType2) {
            Handler handler = new Handler(Looper.getMainLooper());
            handler.post(new AnonymousClass3(handler));
        }
    }

    /* JADX INFO: renamed from: io.sentry.android.core.performance.AppStartMetrics$3, reason: invalid class name */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ Handler val$handler;

        AnonymousClass3(Handler handler) {
            this.val$handler = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            AppStartMetrics.this.firstIdle = SystemClock.uptimeMillis();
            this.val$handler.post(new Runnable() { // from class: io.sentry.android.core.performance.AppStartMetrics$3$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    AppStartMetrics.this.checkCreateTimeOnMain();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkCreateTimeOnMain() {
        if (this.activeActivitiesCounter.get() == 0) {
            this.appLaunchedInForeground.setValue(Boolean.FALSE);
            ITransactionProfiler iTransactionProfiler = this.appStartProfiler;
            if (iTransactionProfiler != null && iTransactionProfiler.isRunning()) {
                this.appStartProfiler.close();
                this.appStartProfiler = null;
            }
            IContinuousProfiler iContinuousProfiler = this.appStartContinuousProfiler;
            if (iContinuousProfiler == null || !iContinuousProfiler.isRunning()) {
                return;
            }
            this.appStartContinuousProfiler.close(true);
            this.appStartContinuousProfiler = null;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        CurrentActivityHolder.getInstance().setActivity(activity);
        if (this.activeActivitiesCounter.incrementAndGet() == 1 && !this.firstDrawDone.get()) {
            long jUptimeMillis2 = SystemClock.uptimeMillis() - this.appStartSpan.getStartUptimeMs();
            if (!((Boolean) this.appLaunchedInForeground.getValue()).booleanValue() || jUptimeMillis2 > TimeUnit.MINUTES.toMillis(1L)) {
                this.appStartType = AppStartType.WARM;
                this.shouldSendStartMeasurements = true;
                this.appStartSpan.reset();
                this.appStartSpan.setStartedAt(jUptimeMillis);
                CLASS_LOADED_UPTIME_MS = jUptimeMillis;
                this.contentProviderOnCreates.clear();
                this.applicationOnCreate.reset();
            } else if (this.appStartType == AppStartType.UNKNOWN) {
                if (bundle != null) {
                    this.appStartType = AppStartType.WARM;
                } else if (this.firstIdle != -1 && jUptimeMillis > this.firstIdle) {
                    this.appStartType = AppStartType.WARM;
                } else {
                    this.appStartType = AppStartType.COLD;
                }
            }
        }
        this.appLaunchedInForeground.setValue(Boolean.TRUE);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        CurrentActivityHolder.getInstance().setActivity(activity);
        if (this.firstDrawDone.get()) {
            return;
        }
        if (activity.getWindow() != null) {
            FirstDrawDoneListener.registerForNextDraw(activity, new Runnable() { // from class: io.sentry.android.core.performance.AppStartMetrics$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.onFirstFrameDrawn();
                }
            }, new BuildInfoProvider(NoOpLogger.getInstance()));
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: io.sentry.android.core.performance.AppStartMetrics$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.onFirstFrameDrawn();
                }
            });
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        CurrentActivityHolder.getInstance().setActivity(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        CurrentActivityHolder.getInstance().clearActivity(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        CurrentActivityHolder.getInstance().clearActivity(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        CurrentActivityHolder.getInstance().clearActivity(activity);
        if (this.activeActivitiesCounter.decrementAndGet() != 0 || activity.isChangingConfigurations()) {
            return;
        }
        this.appStartType = AppStartType.WARM;
        this.appLaunchedInForeground.setValue(Boolean.TRUE);
        this.shouldSendStartMeasurements = true;
        this.firstDrawDone.set(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void onFirstFrameDrawn() {
        if (!this.firstDrawDone.getAndSet(true)) {
            AppStartMetrics appStartMetrics = getInstance();
            appStartMetrics.getSdkInitTimeSpan().stop();
            appStartMetrics.getAppStartTimeSpan().stop();
        }
    }
}
