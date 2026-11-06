package com.adjust.sdk;

import android.content.Context;
import com.adjust.sdk.network.IActivityPackageSender;
import com.adjust.sdk.scheduler.SingleThreadCachedScheduler;
import com.adjust.sdk.scheduler.ThreadScheduler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class PackageHandler implements IPackageHandler, IActivityPackageSender.ResponseDataCallbackSubscriber {
    private static final String PACKAGE_QUEUE_FILENAME = "AdjustIoPackageQueue";
    private static final String PACKAGE_QUEUE_NAME = "Package queue";
    private WeakReference<IActivityHandler> activityHandlerWeakRef;
    private IActivityPackageSender activityPackageSender;
    private Context context;
    private AtomicBoolean isSending;
    private List<ActivityPackage> packageQueue;
    private boolean paused;
    private long retryStartedAtTimeMilliSeconds;
    private ThreadScheduler scheduler = new SingleThreadCachedScheduler("PackageHandler");
    private ILogger logger = AdjustFactory.getLogger();
    private BackoffStrategy backoffStrategy = AdjustFactory.getPackageHandlerBackoffStrategy();
    private BackoffStrategy backoffStrategyForInstallSession = AdjustFactory.getInstallSessionBackoffStrategy();
    private boolean isRetrying = false;
    private double totalWaitTimeSeconds = 0.0d;

    public PackageHandler(IActivityHandler iActivityHandler, Context context, boolean z, IActivityPackageSender iActivityPackageSender) {
        init(iActivityHandler, context, z, iActivityPackageSender);
        this.scheduler.submit(new Runnable() { // from class: com.adjust.sdk.PackageHandler.1
            @Override // java.lang.Runnable
            public final void run() {
                PackageHandler.this.initI();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addI(ActivityPackage activityPackage) {
        if (this.isRetrying) {
            activityPackage.setWaitBeforeSendTimeSeconds(this.totalWaitTimeSeconds - ((System.currentTimeMillis() - this.retryStartedAtTimeMilliSeconds) / 1000.0d));
        }
        PackageBuilder.addLong(activityPackage.getParameters(), "enqueue_size", this.packageQueue.size());
        this.packageQueue.add(activityPackage);
        this.logger.debug("Added package %d (%s)", Integer.valueOf(this.packageQueue.size()), activityPackage);
        this.logger.verbose("%s", activityPackage.getExtendedString());
        writePackageQueueI();
    }

    public static Boolean deletePackageQueue(Context context) {
        return Boolean.valueOf(context.deleteFile(PACKAGE_QUEUE_FILENAME));
    }

    public static void deleteState(Context context) {
        deletePackageQueue(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void flushI() {
        this.packageQueue.clear();
        writePackageQueueI();
    }

    private Map<String, String> generateSendingParametersI() {
        HashMap map = new HashMap();
        int size = this.packageQueue.size() - 1;
        if (size > 0) {
            PackageBuilder.addLong(map, "queue_size", size);
        }
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initI() {
        this.isSending = new AtomicBoolean();
        readPackageQueueI();
    }

    private void readPackageQueueI() {
        try {
            this.packageQueue = (List) Util.readObject(this.context, PACKAGE_QUEUE_FILENAME, PACKAGE_QUEUE_NAME, List.class);
        } catch (Exception e) {
            this.logger.error("Failed to read %s file (%s)", PACKAGE_QUEUE_NAME, e.getMessage());
            this.packageQueue = null;
        }
        List<ActivityPackage> list = this.packageQueue;
        if (list != null) {
            this.logger.debug("Package handler read %d packages", Integer.valueOf(list.size()));
        } else {
            this.packageQueue = new ArrayList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendFirstI() {
        if (this.packageQueue.isEmpty()) {
            return;
        }
        if (this.paused) {
            this.logger.debug("Package handler is paused", new Object[0]);
            return;
        }
        if (this.isSending.getAndSet(true)) {
            this.logger.verbose("Package handler is already sending", new Object[0]);
            return;
        }
        Map<String, String> mapGenerateSendingParametersI = generateSendingParametersI();
        ActivityPackage activityPackage = this.packageQueue.get(0);
        PackageBuilder.addLong(mapGenerateSendingParametersI, "retry_count", activityPackage.getRetryCount());
        PackageBuilder.addLong(mapGenerateSendingParametersI, "first_error", activityPackage.getFirstErrorCode());
        PackageBuilder.addLong(mapGenerateSendingParametersI, "last_error", activityPackage.getLastErrorCode());
        PackageBuilder.addDouble(mapGenerateSendingParametersI, "wait_total", this.totalWaitTimeSeconds);
        PackageBuilder.addDouble(mapGenerateSendingParametersI, "wait_time", activityPackage.getWaitBeforeSendTimeSeconds());
        this.activityPackageSender.sendActivityPackage(activityPackage, mapGenerateSendingParametersI, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendNextI(Long l) {
        this.isRetrying = false;
        this.retryStartedAtTimeMilliSeconds = 0L;
        if (this.packageQueue.isEmpty()) {
            this.totalWaitTimeSeconds = 0.0d;
            return;
        }
        this.packageQueue.remove(0);
        writePackageQueueI();
        if (l == null || l.longValue() <= 0) {
            this.logger.verbose("Package handler can send", new Object[0]);
            this.isSending.set(false);
            sendFirstI();
        } else {
            Runnable runnable = new Runnable() { // from class: com.adjust.sdk.PackageHandler.7
                @Override // java.lang.Runnable
                public final void run() {
                    PackageHandler.this.logger.verbose("Package handler finished waiting to continue", new Object[0]);
                    PackageHandler.this.isSending.set(false);
                    PackageHandler.this.sendFirstPackage();
                }
            };
            this.logger.verbose("Waiting for %d seconds before continuing for next package in continue_in", Double.valueOf(l.longValue() / 1000.0d));
            this.scheduler.schedule(runnable, l.longValue());
        }
    }

    private void writePackageQueueI() {
        Util.writeObject(this.packageQueue, this.context, PACKAGE_QUEUE_FILENAME, PACKAGE_QUEUE_NAME);
        this.logger.debug("Package handler wrote %d packages", Integer.valueOf(this.packageQueue.size()));
    }

    @Override // com.adjust.sdk.IPackageHandler
    public void addPackage(final ActivityPackage activityPackage) {
        this.scheduler.submit(new Runnable() { // from class: com.adjust.sdk.PackageHandler.2
            @Override // java.lang.Runnable
            public final void run() {
                PackageHandler.this.addI(activityPackage);
            }
        });
    }

    @Override // com.adjust.sdk.IPackageHandler
    public void flush() {
        this.scheduler.submit(new Runnable() { // from class: com.adjust.sdk.PackageHandler.6
            @Override // java.lang.Runnable
            public final void run() {
                PackageHandler.this.flushI();
            }
        });
    }

    @Override // com.adjust.sdk.IPackageHandler
    public void init(IActivityHandler iActivityHandler, Context context, boolean z, IActivityPackageSender iActivityPackageSender) {
        this.activityHandlerWeakRef = new WeakReference<>(iActivityHandler);
        this.context = context;
        this.paused = !z;
        this.activityPackageSender = iActivityPackageSender;
    }

    @Override // com.adjust.sdk.network.IActivityPackageSender.ResponseDataCallbackSubscriber
    public void onResponseDataCallback(final ResponseData responseData) {
        this.logger.debug("Got response in PackageHandler", new Object[0]);
        IActivityHandler iActivityHandler = this.activityHandlerWeakRef.get();
        if (iActivityHandler != null && responseData.trackingState == TrackingState.OPTED_OUT) {
            iActivityHandler.gotOptOutResponse();
        }
        if (!responseData.willRetry) {
            this.scheduler.submit(new Runnable() { // from class: com.adjust.sdk.PackageHandler.4
                @Override // java.lang.Runnable
                public final void run() {
                    PackageHandler.this.sendNextI(responseData.continueIn);
                }
            });
            if (iActivityHandler != null) {
                iActivityHandler.finishedTrackingActivity(responseData);
                return;
            }
            return;
        }
        if (!this.isRetrying) {
            this.isRetrying = true;
            this.retryStartedAtTimeMilliSeconds = System.currentTimeMillis();
        }
        writePackageQueueI();
        if (iActivityHandler != null) {
            iActivityHandler.finishedTrackingActivity(responseData);
        }
        Runnable runnable = new Runnable() { // from class: com.adjust.sdk.PackageHandler.5
            @Override // java.lang.Runnable
            public final void run() {
                PackageHandler.this.logger.verbose("Package handler can send", new Object[0]);
                PackageHandler.this.isSending.set(false);
                PackageHandler.this.sendFirstPackage();
            }
        };
        Long l = responseData.retryIn;
        if (l != null && l.longValue() > 0) {
            this.scheduler.schedule(runnable, responseData.retryIn.longValue());
            return;
        }
        int iIncreaseRetries = responseData.activityPackage.increaseRetries();
        long waitingTime = (responseData.activityPackage.getActivityKind() != ActivityKind.SESSION || SharedPreferencesManager.getDefaultInstance(this.context).getInstallTracked()) ? Util.getWaitingTime(iIncreaseRetries, this.backoffStrategy) : Util.getWaitingTime(iIncreaseRetries, this.backoffStrategyForInstallSession);
        double d = waitingTime / 1000.0d;
        String str = Util.SecondsDisplayFormat.format(d);
        this.totalWaitTimeSeconds += d;
        this.logger.verbose("Waiting for %s seconds before retrying %s for the %d time", str, responseData.activityPackage.getActivityKind().toString(), Integer.valueOf(iIncreaseRetries));
        this.scheduler.schedule(runnable, waitingTime);
        ActivityPackage activityPackage = responseData.activityPackage;
        activityPackage.setWaitBeforeSendTimeSeconds(activityPackage.getWaitBeforeSendTimeSeconds() + d);
    }

    @Override // com.adjust.sdk.IPackageHandler
    public void pauseSending() {
        this.paused = true;
    }

    @Override // com.adjust.sdk.IPackageHandler
    public void resumeSending() {
        this.paused = false;
    }

    @Override // com.adjust.sdk.IPackageHandler
    public void sendFirstPackage() {
        this.scheduler.submit(new Runnable() { // from class: com.adjust.sdk.PackageHandler.3
            @Override // java.lang.Runnable
            public final void run() {
                PackageHandler.this.sendFirstI();
            }
        });
    }

    @Override // com.adjust.sdk.IPackageHandler
    public void teardown() {
        this.logger.verbose("PackageHandler teardown", new Object[0]);
        ThreadScheduler threadScheduler = this.scheduler;
        if (threadScheduler != null) {
            threadScheduler.teardown();
        }
        WeakReference<IActivityHandler> weakReference = this.activityHandlerWeakRef;
        if (weakReference != null) {
            weakReference.clear();
        }
        List<ActivityPackage> list = this.packageQueue;
        if (list != null) {
            list.clear();
        }
        this.scheduler = null;
        this.activityHandlerWeakRef = null;
        this.packageQueue = null;
        this.isSending = null;
        this.context = null;
        this.logger = null;
        this.backoffStrategy = null;
    }
}
