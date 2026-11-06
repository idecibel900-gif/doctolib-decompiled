package com.google.android.gms.auth.blockstore;

import android.content.Context;
import com.google.android.gms.internal.auth_blockstore.zzaa;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Blockstore {
    public static BlockstoreClient getClient(Context context) {
        return new zzaa(context);
    }
}
