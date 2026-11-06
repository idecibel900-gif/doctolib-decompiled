package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzdd {
    static void zza(Throwable th) {
        if ((th instanceof Error) && !(th instanceof StackOverflowError)) {
            throw ((Error) th);
        }
    }
}
