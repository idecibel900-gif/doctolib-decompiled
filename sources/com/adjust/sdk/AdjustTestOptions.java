package com.adjust.sdk;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public class AdjustTestOptions {
    public Boolean allowUrlStrategyFallback;
    public String basePath;
    public String baseUrl;
    public Context context;
    public String gdprPath;
    public String gdprUrl;
    public Boolean ignoreSystemLifecycleBootstrap;
    public Boolean noBackoffWait;
    public String purchaseVerificationPath;
    public String purchaseVerificationUrl;
    public Long sessionIntervalInMilliseconds;
    public String subscriptionPath;
    public String subscriptionUrl;
    public Long subsessionIntervalInMilliseconds;
    public Boolean teardown;
    public Long timerIntervalInMilliseconds;
    public Long timerStartInMilliseconds;
    public Boolean tryInstallReferrer;

    public AdjustTestOptions() {
        Boolean bool = Boolean.FALSE;
        this.tryInstallReferrer = bool;
        this.ignoreSystemLifecycleBootstrap = Boolean.TRUE;
        this.allowUrlStrategyFallback = bool;
    }
}
