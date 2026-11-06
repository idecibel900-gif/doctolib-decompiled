package com.google.android.gms.internal.auth_blockstore;

import android.content.Context;
import com.google.android.gms.auth.blockstore.BlockstoreClient;
import com.google.android.gms.auth.blockstore.DeleteBytesRequest;
import com.google.android.gms.auth.blockstore.RetrieveBytesRequest;
import com.google.android.gms.auth.blockstore.StoreBytesData;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes3.dex */
public final class zzaa extends GoogleApi implements BlockstoreClient {
    private static final Api.ClientKey zza;
    private static final Api.AbstractClientBuilder zzb;
    private static final Api zzc;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        zza = clientKey;
        zzu zzuVar = new zzu();
        zzb = zzuVar;
        zzc = new Api("Blockstore.API", zzuVar, clientKey);
    }

    public zzaa(Context context) {
        super(context, zzc, Api.ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    @Override // com.google.android.gms.auth.blockstore.BlockstoreClient
    public final Task deleteBytes(final DeleteBytesRequest deleteBytesRequest) {
        Preconditions.checkNotNull(deleteBytesRequest, "DeleteBytesRequest cannot be null");
        return doWrite(TaskApiCall.builder().setFeatures(zzab.zzg).run(new RemoteCall() { // from class: com.google.android.gms.internal.auth_blockstore.zzp
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                ((zzg) ((zzf) obj).getService()).zza(new zzy(this.zza, (TaskCompletionSource) obj2), deleteBytesRequest);
            }
        }).setAutoResolveMissingFeatures(false).setMethodKey(1669).build());
    }

    @Override // com.google.android.gms.auth.blockstore.BlockstoreClient
    public final Task storeBytes(final StoreBytesData storeBytesData) {
        return doWrite(TaskApiCall.builder().setFeatures(zzab.zzd, zzab.zzf).run(new RemoteCall() { // from class: com.google.android.gms.internal.auth_blockstore.zzq
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                ((zzg) ((zzf) obj).getService()).zze(new zzv(this.zza, (TaskCompletionSource) obj2), storeBytesData);
            }
        }).setMethodKey(1645).setAutoResolveMissingFeatures(false).build());
    }

    @Override // com.google.android.gms.auth.blockstore.BlockstoreClient
    public final Task retrieveBytes(final RetrieveBytesRequest retrieveBytesRequest) {
        Preconditions.checkNotNull(retrieveBytesRequest, "RetrieveBytesRequest cannot be null");
        return doRead(TaskApiCall.builder().setFeatures(zzab.zzh).run(new RemoteCall() { // from class: com.google.android.gms.internal.auth_blockstore.zzs
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                ((zzg) ((zzf) obj).getService()).zzd(new zzw(this.zza, (TaskCompletionSource) obj2), retrieveBytesRequest);
            }
        }).setAutoResolveMissingFeatures(false).setMethodKey(1668).build());
    }
}
