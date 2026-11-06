package com.google.android.gms.common;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzo {
    static final zzm zza = new zzd(zzj.zzf("0\u0082\u0005È0\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u007f¢fú§p\u0085xb±"));
    static final zzm zzb = new zze(zzj.zzf("0\u0082\u0006\u00040\u0082\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014QÕÛ\u0004÷XçB\u0086<"));
    static final zzm zzc = new zzf(zzj.zzf("0\u0082\u0005È0\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010\u008ae\bsù/\u008eQí"));
    static final zzm zzd = new zzg(zzj.zzf("0\u0082\u0006\u00040\u0082\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²\u00ad×árÊkì"));
    static final zzm zze = new zzh(zzj.zzf("0\u0082\u0004C0\u0082\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000Âà\u0087FdJ0\u008d0"));
    static final zzm zzf = new zzi(zzj.zzf("0\u0082\u0004¨0\u0082\u0003\u0090 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ\u0085¸l}ÓNõ0"));
    private static final Object zzi = new Object();
    private static Context zzj;

    static synchronized void zza(Context context) {
        if (zzj == null) {
            if (context != null) {
                zzj = context.getApplicationContext();
            }
        }
    }
}
