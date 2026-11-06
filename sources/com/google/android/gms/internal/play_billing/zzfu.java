package com.google.android.gms.internal.play_billing;

import androidx.recyclerview.widget.LinearLayoutManager;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzfu extends zzeg {
    private static final Map zzb = new ConcurrentHashMap();
    private int zzd = -1;
    protected zzic zzc = zzic.zzc();

    protected static void zzB(Class cls, zzfu zzfuVar) {
        zzfuVar.zzA();
        zzb.put(cls, zzfuVar);
    }

    private final int zza(zzhl zzhlVar) {
        return zzhi.zza().zzb(getClass()).zza(this);
    }

    private static zzfu zzb(zzfu zzfuVar, byte[] bArr, int i, int i2, zzfh zzfhVar) throws zzgc {
        if (i2 == 0) {
            return zzfuVar;
        }
        zzfu zzfuVarZzs = zzfuVar.zzs();
        try {
            zzhl zzhlVarZzb = zzhi.zza().zzb(zzfuVarZzs.getClass());
            zzhlVarZzb.zzh(zzfuVarZzs, bArr, 0, i2, new zzej(zzfhVar));
            zzhlVarZzb.zzf(zzfuVarZzs);
            return zzfuVarZzs;
        } catch (zzgc e) {
            throw e;
        } catch (zzia e2) {
            throw e2.zza();
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzgc) {
                throw ((zzgc) e3.getCause());
            }
            throw new zzgc(e3);
        } catch (IndexOutOfBoundsException unused) {
            throw new zzgc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    private static final boolean zzc(zzfu zzfuVar, boolean z) {
        byte bByteValue = ((Byte) zzfuVar.zzd(1, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZzk = zzhi.zza().zzb(zzfuVar.getClass()).zzk(zzfuVar);
        if (z) {
            zzfuVar.zzd(2, true != zZzk ? null : zzfuVar, null);
        }
        return zZzk;
    }

    static zzfu zzr(Class cls) {
        Map map = zzb;
        zzfu zzfuVar = (zzfu) map.get(cls);
        if (zzfuVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzfuVar = (zzfu) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzfuVar != null) {
            return zzfuVar;
        }
        zzfu zzfuVar2 = (zzfu) ((zzfu) zzii.zze(cls)).zzd(6, null, null);
        if (zzfuVar2 == null) {
            throw new IllegalStateException();
        }
        map.put(cls, zzfuVar2);
        return zzfuVar2;
    }

    protected static zzfu zzt(zzfu zzfuVar, byte[] bArr) throws zzgc {
        int length = bArr.length;
        zzfh zzfhVar = zzfh.zza;
        int i = zzei.$r8$clinit;
        zzfu zzfuVarZzb = zzb(zzfuVar, bArr, 0, length, zzfh.zza);
        if (zzfuVarZzb == null || zzc(zzfuVarZzb, true)) {
            return zzfuVarZzb;
        }
        throw new zzia(zzfuVarZzb).zza();
    }

    protected static zzfy zzu() {
        return zzfv.zzf();
    }

    protected static zzfz zzv() {
        return zzhj.zze();
    }

    static Object zzx(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    protected static Object zzy(zzhb zzhbVar, String str, Object[] objArr) {
        return new zzhk(zzhbVar, str, objArr);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzhi.zza().zzb(getClass()).zzj(this, (zzfu) obj);
    }

    public final int hashCode() {
        if (zzF()) {
            return zzm();
        }
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int iZzm = zzm();
        this.zza = iZzm;
        return iZzm;
    }

    public final String toString() {
        return zzhd.zza(this, super.toString());
    }

    final void zzA() {
        this.zzd &= Integer.MAX_VALUE;
    }

    final void zzC(int i) {
        this.zzd = (this.zzd & LinearLayoutManager.INVALID_OFFSET) | Integer.MAX_VALUE;
    }

    @Override // com.google.android.gms.internal.play_billing.zzhb
    public final void zzD(zzfc zzfcVar) {
        zzhi.zza().zzb(getClass()).zzi(this, zzfd.zza(zzfcVar));
    }

    final boolean zzF() {
        return (this.zzd & LinearLayoutManager.INVALID_OFFSET) != 0;
    }

    protected abstract Object zzd(int i, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.play_billing.zzeg
    final int zzi(zzhl zzhlVar) {
        if (zzF()) {
            int iZza = zzhlVar.zza(this);
            if (iZza >= 0) {
                return iZza;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + iZza);
        }
        int i = this.zzd & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int iZza2 = zzhlVar.zza(this);
        if (iZza2 >= 0) {
            this.zzd = (this.zzd & LinearLayoutManager.INVALID_OFFSET) | iZza2;
            return iZza2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + iZza2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhc
    public final /* synthetic */ zzhb zzl() {
        return (zzfu) zzd(6, null, null);
    }

    final int zzm() {
        return zzhi.zza().zzb(getClass()).zzb(this);
    }

    public final boolean zzo() {
        return zzc(this, true);
    }

    protected final zzfq zzp() {
        return (zzfq) zzd(5, null, null);
    }

    public final zzfq zzq() {
        zzfq zzfqVar = (zzfq) zzd(5, null, null);
        zzfqVar.zzh(this);
        return zzfqVar;
    }

    final zzfu zzs() {
        return (zzfu) zzd(4, null, null);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhb
    public final /* synthetic */ zzha zzw() {
        return (zzfq) zzd(5, null, null);
    }

    protected final void zzz() {
        zzhi.zza().zzb(getClass()).zzf(this);
        zzA();
    }

    @Override // com.google.android.gms.internal.play_billing.zzhb
    public final int zzn() {
        if (zzF()) {
            int iZza = zza(null);
            if (iZza >= 0) {
                return iZza;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + iZza);
        }
        int i = this.zzd & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int iZza2 = zza(null);
        if (iZza2 >= 0) {
            this.zzd = (this.zzd & LinearLayoutManager.INVALID_OFFSET) | iZza2;
            return iZza2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + iZza2);
    }
}
