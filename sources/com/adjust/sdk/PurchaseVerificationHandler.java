package com.adjust.sdk;

import com.adjust.sdk.network.IActivityPackageSender;
import com.adjust.sdk.scheduler.SingleThreadCachedScheduler;
import com.adjust.sdk.scheduler.ThreadScheduler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class PurchaseVerificationHandler implements IPurchaseVerificationHandler {
    private static final double MILLISECONDS_TO_SECONDS_DIVISOR = 1000.0d;
    private static final String SCHEDULED_EXECUTOR_SOURCE = "PurchaseVerificationHandler";
    private WeakReference<IActivityHandler> activityHandlerWeakRef;
    private IActivityPackageSender activityPackageSender;
    private boolean isSendingPurchaseVerificationPackage;
    private long lastPackageRetryInMilli = 0;
    private ILogger logger;
    private List<ActivityPackage> packageQueue;
    private boolean paused;
    private ThreadScheduler scheduler;

    public PurchaseVerificationHandler(IActivityHandler iActivityHandler, boolean z, IActivityPackageSender iActivityPackageSender) {
        init(iActivityHandler, z, iActivityPackageSender);
        this.logger = AdjustFactory.getLogger();
        this.scheduler = new SingleThreadCachedScheduler(SCHEDULED_EXECUTOR_SOURCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendNextPurchaseVerificationPackage() {
        this.scheduler.submit(new Runnable() { // from class: com.adjust.sdk.PurchaseVerificationHandler.2
            @Override // java.lang.Runnable
            public final void run() {
                PurchaseVerificationHandler.this.sendNextPurchaseVerificationPackageI();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendNextPurchaseVerificationPackageI() {
        IActivityHandler iActivityHandler = this.activityHandlerWeakRef.get();
        if (iActivityHandler.getActivityState() == null || this.packageQueue.isEmpty()) {
            return;
        }
        if (iActivityHandler.getActivityState().isGdprForgotten) {
            this.logger.debug("purchase_verification request won't be sent for GDPR forgotten user", new Object[0]);
            return;
        }
        if (this.paused) {
            this.logger.debug("PurchaseVerificationHandler is paused", new Object[0]);
            return;
        }
        if (this.isSendingPurchaseVerificationPackage) {
            this.logger.debug("PurchaseVerificationHandler is is already sending a package", new Object[0]);
            return;
        }
        long jWaitTime = waitTime();
        if (jWaitTime > 0) {
            this.scheduler.schedule(new Runnable() { // from class: com.adjust.sdk.PurchaseVerificationHandler.3
                @Override // java.lang.Runnable
                public final void run() {
                    PurchaseVerificationHandler purchaseVerificationHandler = PurchaseVerificationHandler.this;
                    purchaseVerificationHandler.lastPackageRetryInMilli = 0L;
                    purchaseVerificationHandler.sendNextPurchaseVerificationPackage();
                }
            }, jWaitTime);
        } else {
            ActivityPackage activityPackage = this.packageQueue.get(0);
            this.isSendingPurchaseVerificationPackage = true;
            sendPurchaseVerificationPackageSync(activityPackage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendPurchaseVerificationPackageI(ActivityPackage activityPackage) {
        this.packageQueue.add(activityPackage);
        this.logger.debug("Added purchase_verification %d", Integer.valueOf(this.packageQueue.size()));
        this.logger.verbose("%s", activityPackage.getExtendedString());
        sendNextPurchaseVerificationPackage();
    }

    private void sendPurchaseVerificationPackageSync(ActivityPackage activityPackage) {
        IActivityHandler iActivityHandler = this.activityHandlerWeakRef.get();
        ResponseData responseDataSendActivityPackageSync = this.activityPackageSender.sendActivityPackageSync(activityPackage, null);
        if (responseDataSendActivityPackageSync instanceof PurchaseVerificationResponseData) {
            this.isSendingPurchaseVerificationPackage = false;
            PurchaseVerificationResponseData purchaseVerificationResponseData = (PurchaseVerificationResponseData) responseDataSendActivityPackageSync;
            if (purchaseVerificationResponseData.jsonResponse == null) {
                this.logger.error("Could not get purchase_verification JSON response with message: %s", purchaseVerificationResponseData.message);
            } else {
                if (iActivityHandler == null) {
                    return;
                }
                if (purchaseVerificationResponseData.trackingState == TrackingState.OPTED_OUT) {
                    iActivityHandler.gotOptOutResponse();
                    return;
                }
                if (purchaseVerificationResponseData.willRetry) {
                    Long l = responseDataSendActivityPackageSync.retryIn;
                    if (l != null && l.longValue() > 0) {
                        Long l2 = responseDataSendActivityPackageSync.retryIn;
                        this.lastPackageRetryInMilli = l2.longValue();
                        this.logger.error("Retrying purchase_verification package with retry in %d ms", l2);
                    }
                    sendNextPurchaseVerificationPackage();
                    return;
                }
                this.lastPackageRetryInMilli = 0L;
            }
            if (!this.packageQueue.isEmpty()) {
                this.packageQueue.remove(0);
            }
            iActivityHandler.finishedTrackingActivity(purchaseVerificationResponseData);
            sendNextPurchaseVerificationPackage();
        }
    }

    private long waitTime() {
        long j = this.lastPackageRetryInMilli;
        if (j <= 0) {
            return 0L;
        }
        this.logger.verbose("Waiting for %d ms before retrying purchase_verification with retry_in", Long.valueOf(j));
        return this.lastPackageRetryInMilli;
    }

    @Override // com.adjust.sdk.IPurchaseVerificationHandler
    public void init(IActivityHandler iActivityHandler, boolean z, IActivityPackageSender iActivityPackageSender) {
        this.paused = !z;
        this.packageQueue = new ArrayList();
        this.activityHandlerWeakRef = new WeakReference<>(iActivityHandler);
        this.activityPackageSender = iActivityPackageSender;
        this.isSendingPurchaseVerificationPackage = false;
        this.lastPackageRetryInMilli = 0L;
    }

    @Override // com.adjust.sdk.IPurchaseVerificationHandler
    public void pauseSending() {
        this.paused = true;
        this.isSendingPurchaseVerificationPackage = false;
        this.lastPackageRetryInMilli = 0L;
    }

    @Override // com.adjust.sdk.IPurchaseVerificationHandler
    public void resumeSending() {
        this.paused = false;
        sendNextPurchaseVerificationPackage();
    }

    @Override // com.adjust.sdk.IPurchaseVerificationHandler
    public void sendPurchaseVerificationPackage(final ActivityPackage activityPackage) {
        this.scheduler.submit(new Runnable() { // from class: com.adjust.sdk.PurchaseVerificationHandler.1
            @Override // java.lang.Runnable
            public final void run() {
                PurchaseVerificationHandler.this.sendPurchaseVerificationPackageI(activityPackage);
            }
        });
    }

    @Override // com.adjust.sdk.IPurchaseVerificationHandler
    public void teardown() {
        this.logger.verbose("PurchaseVerificationHandler teardown", new Object[0]);
        ThreadScheduler threadScheduler = this.scheduler;
        if (threadScheduler != null) {
            threadScheduler.teardown();
        }
        List<ActivityPackage> list = this.packageQueue;
        if (list != null) {
            list.clear();
        }
        WeakReference<IActivityHandler> weakReference = this.activityHandlerWeakRef;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.logger = null;
        this.packageQueue = null;
        this.scheduler = null;
        this.isSendingPurchaseVerificationPackage = false;
        this.lastPackageRetryInMilli = 0L;
    }
}
