package com.adjust.sdk;

import com.adjust.sdk.network.IActivityPackageSender;

/* JADX INFO: loaded from: classes3.dex */
public interface IPurchaseVerificationHandler {
    void init(IActivityHandler iActivityHandler, boolean z, IActivityPackageSender iActivityPackageSender);

    void pauseSending();

    void resumeSending();

    void sendPurchaseVerificationPackage(ActivityPackage activityPackage);

    void teardown();
}
