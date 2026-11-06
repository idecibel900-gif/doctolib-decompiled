package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes3.dex */
final class zbk extends zbl {
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    protected final /* bridge */ /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    protected final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) {
        zbe zbeVar = (zbe) anyClient;
        ((zbs) zbeVar.getService()).zbe(new zbj(this), zbeVar.zba());
    }
}
