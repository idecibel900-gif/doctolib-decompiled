package com.google.android.gms.internal.play_billing;

import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzcb {
    public static Object zza(Iterable iterable, Object obj) {
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }
}
