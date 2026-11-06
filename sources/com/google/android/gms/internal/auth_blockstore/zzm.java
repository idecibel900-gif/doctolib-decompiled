package com.google.android.gms.internal.auth_blockstore;

import android.os.IInterface;
import com.google.android.gms.auth.blockstore.RetrieveBytesResponse;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes3.dex */
public interface zzm extends IInterface {
    void zza(Status status, byte[] bArr);

    void zzb(Status status, RetrieveBytesResponse retrieveBytesResponse);
}
