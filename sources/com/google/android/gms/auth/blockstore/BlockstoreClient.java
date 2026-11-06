package com.google.android.gms.auth.blockstore;

import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes3.dex */
public interface BlockstoreClient {
    Task deleteBytes(DeleteBytesRequest deleteBytesRequest);

    Task retrieveBytes(RetrieveBytesRequest retrieveBytesRequest);

    Task storeBytes(StoreBytesData storeBytesData);
}
