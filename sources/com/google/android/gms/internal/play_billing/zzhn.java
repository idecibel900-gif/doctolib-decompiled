package com.google.android.gms.internal.play_billing;

import android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzhn {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final zzib zzb;

    static {
        int i = zzei.$r8$clinit;
        zzb = new zzid();
    }

    public static void zzA(int i, List list, zzit zzitVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzitVar.zzB(i, list, z);
    }

    public static void zzB(int i, List list, zzit zzitVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzitVar.zzD(i, list, z);
    }

    public static void zzC(int i, List list, zzit zzitVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzitVar.zzF(i, list, z);
    }

    public static void zzD(int i, List list, zzit zzitVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzitVar.zzK(i, list, z);
    }

    public static void zzE(int i, List list, zzit zzitVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzitVar.zzM(i, list, z);
    }

    static boolean zzF(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static int zza(int i, zzhb zzhbVar, zzhl zzhlVar) {
        int iZzy = zzfc.zzy(i << 3);
        return iZzy + iZzy + ((zzeg) zzhbVar).zzi(zzhlVar);
    }

    static int zzb(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzfv)) {
            int iZzz = 0;
            while (i < size) {
                iZzz += zzfc.zzz(((Integer) list.get(i)).intValue());
                i++;
            }
            return iZzz;
        }
        zzfv zzfvVar = (zzfv) list;
        int iZzz2 = 0;
        while (i < size) {
            iZzz2 += zzfc.zzz(zzfvVar.zze(i));
            i++;
        }
        return iZzz2;
    }

    static int zzc(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzfc.zzy(i << 3) + 4);
    }

    static int zzd(List list) {
        return list.size() * 4;
    }

    static int zze(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzfc.zzy(i << 3) + 8);
    }

    static int zzf(List list) {
        return list.size() * 8;
    }

    static int zzg(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzfv)) {
            int iZzz = 0;
            while (i < size) {
                iZzz += zzfc.zzz(((Integer) list.get(i)).intValue());
                i++;
            }
            return iZzz;
        }
        zzfv zzfvVar = (zzfv) list;
        int iZzz2 = 0;
        while (i < size) {
            iZzz2 += zzfc.zzz(zzfvVar.zze(i));
            i++;
        }
        return iZzz2;
    }

    static int zzh(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgp) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int iZzz = 0;
        for (int i = 0; i < size; i++) {
            iZzz += zzfc.zzz(((Long) list.get(i)).longValue());
        }
        return iZzz;
    }

    static int zzj(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzfv)) {
            int iZzy = 0;
            while (i < size) {
                int iIntValue = ((Integer) list.get(i)).intValue();
                iZzy += zzfc.zzy((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i++;
            }
            return iZzy;
        }
        zzfv zzfvVar = (zzfv) list;
        int iZzy2 = 0;
        while (i < size) {
            int iZze = zzfvVar.zze(i);
            iZzy2 += zzfc.zzy((iZze >> 31) ^ (iZze + iZze));
            i++;
        }
        return iZzy2;
    }

    static int zzk(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgp) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int iZzz = 0;
        for (int i = 0; i < size; i++) {
            long jLongValue = ((Long) list.get(i)).longValue();
            iZzz += zzfc.zzz((jLongValue >> 63) ^ (jLongValue + jLongValue));
        }
        return iZzz;
    }

    static int zzl(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzfv)) {
            int iZzy = 0;
            while (i < size) {
                iZzy += zzfc.zzy(((Integer) list.get(i)).intValue());
                i++;
            }
            return iZzy;
        }
        zzfv zzfvVar = (zzfv) list;
        int iZzy2 = 0;
        while (i < size) {
            iZzy2 += zzfc.zzy(zzfvVar.zze(i));
            i++;
        }
        return iZzy2;
    }

    static int zzm(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgp) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int iZzz = 0;
        for (int i = 0; i < size; i++) {
            iZzz += zzfc.zzz(((Long) list.get(i)).longValue());
        }
        return iZzz;
    }

    public static zzib zzn() {
        return zzb;
    }

    static Object zzo(Object obj, int i, int i2, Object obj2, zzib zzibVar) {
        if (obj2 == null) {
            obj2 = zzibVar.zza(obj);
        }
        ((zzic) obj2).zzj(i << 3, Long.valueOf(i2));
        return obj2;
    }

    static void zzp(zzfi zzfiVar, Object obj, Object obj2) {
        MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(obj2);
        throw null;
    }

    static void zzq(zzib zzibVar, Object obj, Object obj2) {
        zzfu zzfuVar = (zzfu) obj;
        zzic zzicVarZze = zzfuVar.zzc;
        zzic zzicVar = ((zzfu) obj2).zzc;
        if (!zzic.zzc().equals(zzicVar)) {
            if (zzic.zzc().equals(zzicVarZze)) {
                zzicVarZze = zzic.zze(zzicVarZze, zzicVar);
            } else {
                zzicVarZze.zzd(zzicVar);
            }
        }
        zzfuVar.zzc = zzicVarZze;
    }

    public static void zzr(int i, List list, zzit zzitVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzitVar.zzc(i, list, z);
    }

    public static void zzs(int i, List list, zzit zzitVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzitVar.zzg(i, list, z);
    }

    public static void zzt(int i, List list, zzit zzitVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzitVar.zzj(i, list, z);
    }

    public static void zzu(int i, List list, zzit zzitVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzitVar.zzl(i, list, z);
    }

    public static void zzv(int i, List list, zzit zzitVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzitVar.zzn(i, list, z);
    }

    public static void zzw(int i, List list, zzit zzitVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzitVar.zzp(i, list, z);
    }

    public static void zzx(int i, List list, zzit zzitVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzitVar.zzs(i, list, z);
    }

    public static void zzy(int i, List list, zzit zzitVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzitVar.zzu(i, list, z);
    }

    public static void zzz(int i, List list, zzit zzitVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzitVar.zzz(i, list, z);
    }

    static int zzi(int i, Object obj, zzhl zzhlVar) {
        int iZzy = zzfc.zzy(i << 3);
        int iZzi = ((zzeg) obj).zzi(zzhlVar);
        return iZzy + zzfc.zzy(iZzi) + iZzi;
    }
}
