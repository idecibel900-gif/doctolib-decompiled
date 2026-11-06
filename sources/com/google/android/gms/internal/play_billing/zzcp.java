package com.google.android.gms.internal.play_billing;

import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class zzcp {
    public static /* synthetic */ boolean zza(Unsafe unsafe, Object obj, long j, Object obj2, Object obj3) {
        while (!zzcp$$ExternalSyntheticBackportWithForwarding0.m(unsafe, obj, j, obj2, obj3)) {
            if (unsafe.getObject(obj, j) != obj2) {
                return false;
            }
        }
        return true;
    }
}
