package com.google.android.gms.internal.play_billing;

import android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class zzfd implements zzit {
    private final zzfc zza;

    private zzfd(zzfc zzfcVar) {
        byte[] bArr = zzga.zzb;
        this.zza = zzfcVar;
        zzfcVar.zza = this;
    }

    public static zzfd zza(zzfc zzfcVar) {
        Object obj = zzfcVar.zza;
        return obj != null ? (zzfd) obj : new zzfd(zzfcVar);
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzA(int i, long j) {
        this.zza.zzj(i, j);
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzC(int i, int i2) {
        this.zza.zzt(i, (i2 >> 31) ^ (i2 + i2));
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzE(int i, long j) {
        this.zza.zzv(i, (j >> 63) ^ (j + j));
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzG(int i) {
        this.zza.zzs(i, 3);
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzH(int i, String str) {
        this.zza.zzq(i, str);
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzJ(int i, int i2) {
        this.zza.zzt(i, i2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzL(int i, long j) {
        this.zza.zzv(i, j);
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzb(int i, boolean z) {
        this.zza.zzd(i, z);
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzd(int i, zzev zzevVar) {
        this.zza.zzf(i, zzevVar);
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zze(int i, List list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zza.zzf(i, (zzev) list.get(i2));
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzf(int i, double d) {
        this.zza.zzj(i, Double.doubleToRawLongBits(d));
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzh(int i) {
        this.zza.zzs(i, 4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzi(int i, int i2) {
        this.zza.zzl(i, i2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzk(int i, int i2) {
        this.zza.zzh(i, i2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzm(int i, long j) {
        this.zza.zzj(i, j);
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzo(int i, float f) {
        this.zza.zzh(i, Float.floatToRawIntBits(f));
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzq(int i, Object obj, zzhl zzhlVar) {
        zzfc zzfcVar = this.zza;
        zzfcVar.zzs(i, 3);
        zzhlVar.zzi((zzeg) obj, this);
        zzfcVar.zzs(i, 4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzr(int i, int i2) {
        this.zza.zzl(i, i2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzt(int i, long j) {
        this.zza.zzv(i, j);
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzw(int i, Object obj, zzhl zzhlVar) {
        zzfc zzfcVar = this.zza;
        zzeg zzegVar = (zzeg) obj;
        zzfcVar.zzs(i, 2);
        zzfcVar.zzu(zzegVar.zzi(zzhlVar));
        zzhlVar.zzi(zzegVar, this);
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzy(int i, int i2) {
        this.zza.zzh(i, i2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzI(int i, List list) {
        int i2 = 0;
        if (!(list instanceof zzgj)) {
            while (i2 < list.size()) {
                this.zza.zzq(i, (String) list.get(i2));
                i2++;
            }
            return;
        }
        zzgj zzgjVar = (zzgj) list;
        while (i2 < list.size()) {
            Object objZza = zzgjVar.zza();
            if (objZza instanceof String) {
                this.zza.zzq(i, (String) objZza);
            } else {
                this.zza.zzf(i, (zzev) objZza);
            }
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzK(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzfv)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzt(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzfc zzfcVar = this.zza;
            zzfcVar.zzs(i, 2);
            int iZzy = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzy += zzfc.zzy(((Integer) list.get(i3)).intValue());
            }
            zzfcVar.zzu(iZzy);
            while (i2 < list.size()) {
                zzfcVar.zzu(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzfv zzfvVar = (zzfv) list;
        if (!z) {
            while (i2 < zzfvVar.size()) {
                this.zza.zzt(i, zzfvVar.zze(i2));
                i2++;
            }
            return;
        }
        zzfc zzfcVar2 = this.zza;
        zzfcVar2.zzs(i, 2);
        int iZzy2 = 0;
        for (int i4 = 0; i4 < zzfvVar.size(); i4++) {
            iZzy2 += zzfc.zzy(zzfvVar.zze(i4));
        }
        zzfcVar2.zzu(iZzy2);
        while (i2 < zzfvVar.size()) {
            zzfcVar2.zzu(zzfvVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzM(int i, List list, boolean z) {
        if (list instanceof zzgp) {
            MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(list);
            if (!z) {
                throw null;
            }
            this.zza.zzs(i, 2);
            throw null;
        }
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzv(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzfc zzfcVar = this.zza;
        zzfcVar.zzs(i, 2);
        int iZzz = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzz += zzfc.zzz(((Long) list.get(i3)).longValue());
        }
        zzfcVar.zzu(iZzz);
        while (i2 < list.size()) {
            zzfcVar.zzw(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzl(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzfv)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzh(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzfc zzfcVar = this.zza;
            zzfcVar.zzs(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).getClass();
                i3 += 4;
            }
            zzfcVar.zzu(i3);
            while (i2 < list.size()) {
                zzfcVar.zzi(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzfv zzfvVar = (zzfv) list;
        if (!z) {
            while (i2 < zzfvVar.size()) {
                this.zza.zzh(i, zzfvVar.zze(i2));
                i2++;
            }
            return;
        }
        zzfc zzfcVar2 = this.zza;
        zzfcVar2.zzs(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzfvVar.size(); i6++) {
            zzfvVar.zze(i6);
            i5 += 4;
        }
        zzfcVar2.zzu(i5);
        while (i2 < zzfvVar.size()) {
            zzfcVar2.zzi(zzfvVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzn(int i, List list, boolean z) {
        if (list instanceof zzgp) {
            MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(list);
            if (!z) {
                throw null;
            }
            this.zza.zzs(i, 2);
            throw null;
        }
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzj(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzfc zzfcVar = this.zza;
        zzfcVar.zzs(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Long) list.get(i4)).getClass();
            i3 += 8;
        }
        zzfcVar.zzu(i3);
        while (i2 < list.size()) {
            zzfcVar.zzk(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzc(int i, List list, boolean z) {
        if (list instanceof zzel) {
            MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(list);
            if (!z) {
                throw null;
            }
            this.zza.zzs(i, 2);
            throw null;
        }
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzd(i, ((Boolean) list.get(i2)).booleanValue());
                i2++;
            }
            return;
        }
        zzfc zzfcVar = this.zza;
        zzfcVar.zzs(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Boolean) list.get(i4)).getClass();
            i3++;
        }
        zzfcVar.zzu(i3);
        while (i2 < list.size()) {
            zzfcVar.zzb(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : (byte) 0);
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzs(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzfv)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzl(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzfc zzfcVar = this.zza;
            zzfcVar.zzs(i, 2);
            int iZzz = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzz += zzfc.zzz(((Integer) list.get(i3)).intValue());
            }
            zzfcVar.zzu(iZzz);
            while (i2 < list.size()) {
                zzfcVar.zzm(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzfv zzfvVar = (zzfv) list;
        if (!z) {
            while (i2 < zzfvVar.size()) {
                this.zza.zzl(i, zzfvVar.zze(i2));
                i2++;
            }
            return;
        }
        zzfc zzfcVar2 = this.zza;
        zzfcVar2.zzs(i, 2);
        int iZzz2 = 0;
        for (int i4 = 0; i4 < zzfvVar.size(); i4++) {
            iZzz2 += zzfc.zzz(zzfvVar.zze(i4));
        }
        zzfcVar2.zzu(iZzz2);
        while (i2 < zzfvVar.size()) {
            zzfcVar2.zzm(zzfvVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzB(int i, List list, boolean z) {
        if (list instanceof zzgp) {
            MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(list);
            if (!z) {
                throw null;
            }
            this.zza.zzs(i, 2);
            throw null;
        }
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzj(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzfc zzfcVar = this.zza;
        zzfcVar.zzs(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Long) list.get(i4)).getClass();
            i3 += 8;
        }
        zzfcVar.zzu(i3);
        while (i2 < list.size()) {
            zzfcVar.zzk(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzg(int i, List list, boolean z) {
        if (list instanceof zzfe) {
            MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(list);
            if (!z) {
                throw null;
            }
            this.zza.zzs(i, 2);
            throw null;
        }
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzj(i, Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                i2++;
            }
            return;
        }
        zzfc zzfcVar = this.zza;
        zzfcVar.zzs(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Double) list.get(i4)).getClass();
            i3 += 8;
        }
        zzfcVar.zzu(i3);
        while (i2 < list.size()) {
            zzfcVar.zzk(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzp(int i, List list, boolean z) {
        if (list instanceof zzfo) {
            MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(list);
            if (!z) {
                throw null;
            }
            this.zza.zzs(i, 2);
            throw null;
        }
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzh(i, Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                i2++;
            }
            return;
        }
        zzfc zzfcVar = this.zza;
        zzfcVar.zzs(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Float) list.get(i4)).getClass();
            i3 += 4;
        }
        zzfcVar.zzu(i3);
        while (i2 < list.size()) {
            zzfcVar.zzi(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzz(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzfv)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzh(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzfc zzfcVar = this.zza;
            zzfcVar.zzs(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).getClass();
                i3 += 4;
            }
            zzfcVar.zzu(i3);
            while (i2 < list.size()) {
                zzfcVar.zzi(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzfv zzfvVar = (zzfv) list;
        if (!z) {
            while (i2 < zzfvVar.size()) {
                this.zza.zzh(i, zzfvVar.zze(i2));
                i2++;
            }
            return;
        }
        zzfc zzfcVar2 = this.zza;
        zzfcVar2.zzs(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzfvVar.size(); i6++) {
            zzfvVar.zze(i6);
            i5 += 4;
        }
        zzfcVar2.zzu(i5);
        while (i2 < zzfvVar.size()) {
            zzfcVar2.zzi(zzfvVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzD(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzfv)) {
            if (!z) {
                while (i2 < list.size()) {
                    zzfc zzfcVar = this.zza;
                    int iIntValue = ((Integer) list.get(i2)).intValue();
                    zzfcVar.zzt(i, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                    i2++;
                }
                return;
            }
            zzfc zzfcVar2 = this.zza;
            zzfcVar2.zzs(i, 2);
            int iZzy = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                int iIntValue2 = ((Integer) list.get(i3)).intValue();
                iZzy += zzfc.zzy((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
            }
            zzfcVar2.zzu(iZzy);
            while (i2 < list.size()) {
                int iIntValue3 = ((Integer) list.get(i2)).intValue();
                zzfcVar2.zzu((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
                i2++;
            }
            return;
        }
        zzfv zzfvVar = (zzfv) list;
        if (!z) {
            while (i2 < zzfvVar.size()) {
                zzfc zzfcVar3 = this.zza;
                int iZze = zzfvVar.zze(i2);
                zzfcVar3.zzt(i, (iZze >> 31) ^ (iZze + iZze));
                i2++;
            }
            return;
        }
        zzfc zzfcVar4 = this.zza;
        zzfcVar4.zzs(i, 2);
        int iZzy2 = 0;
        for (int i4 = 0; i4 < zzfvVar.size(); i4++) {
            int iZze2 = zzfvVar.zze(i4);
            iZzy2 += zzfc.zzy((iZze2 >> 31) ^ (iZze2 + iZze2));
        }
        zzfcVar4.zzu(iZzy2);
        while (i2 < zzfvVar.size()) {
            int iZze3 = zzfvVar.zze(i2);
            zzfcVar4.zzu((iZze3 >> 31) ^ (iZze3 + iZze3));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzF(int i, List list, boolean z) {
        if (list instanceof zzgp) {
            MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(list);
            if (!z) {
                throw null;
            }
            this.zza.zzs(i, 2);
            throw null;
        }
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                zzfc zzfcVar = this.zza;
                long jLongValue = ((Long) list.get(i2)).longValue();
                zzfcVar.zzv(i, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                i2++;
            }
            return;
        }
        zzfc zzfcVar2 = this.zza;
        zzfcVar2.zzs(i, 2);
        int iZzz = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            long jLongValue2 = ((Long) list.get(i3)).longValue();
            iZzz += zzfc.zzz((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
        }
        zzfcVar2.zzu(iZzz);
        while (i2 < list.size()) {
            long jLongValue3 = ((Long) list.get(i2)).longValue();
            zzfcVar2.zzw((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzj(int i, List list, boolean z) {
        int i2 = 0;
        if (!(list instanceof zzfv)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzl(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzfc zzfcVar = this.zza;
            zzfcVar.zzs(i, 2);
            int iZzz = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzz += zzfc.zzz(((Integer) list.get(i3)).intValue());
            }
            zzfcVar.zzu(iZzz);
            while (i2 < list.size()) {
                zzfcVar.zzm(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzfv zzfvVar = (zzfv) list;
        if (!z) {
            while (i2 < zzfvVar.size()) {
                this.zza.zzl(i, zzfvVar.zze(i2));
                i2++;
            }
            return;
        }
        zzfc zzfcVar2 = this.zza;
        zzfcVar2.zzs(i, 2);
        int iZzz2 = 0;
        for (int i4 = 0; i4 < zzfvVar.size(); i4++) {
            iZzz2 += zzfc.zzz(zzfvVar.zze(i4));
        }
        zzfcVar2.zzu(iZzz2);
        while (i2 < zzfvVar.size()) {
            zzfcVar2.zzm(zzfvVar.zze(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzit
    public final void zzu(int i, List list, boolean z) {
        if (list instanceof zzgp) {
            MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(list);
            if (!z) {
                throw null;
            }
            this.zza.zzs(i, 2);
            throw null;
        }
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zza.zzv(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzfc zzfcVar = this.zza;
        zzfcVar.zzs(i, 2);
        int iZzz = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzz += zzfc.zzz(((Long) list.get(i3)).longValue());
        }
        zzfcVar.zzu(iZzz);
        while (i2 < list.size()) {
            zzfcVar.zzw(((Long) list.get(i2)).longValue());
            i2++;
        }
    }
}
