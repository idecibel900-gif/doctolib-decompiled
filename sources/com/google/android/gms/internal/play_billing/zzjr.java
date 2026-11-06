package com.google.android.gms.internal.play_billing;

import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import okhttp3.internal.http2.Http2;

/* JADX INFO: loaded from: classes3.dex */
public final class zzjr extends zzfu implements zzhc {
    private static final zzjr zzb;
    private int zzd;
    private int zzh;
    private long zzi;
    private long zzj;
    private boolean zzk;
    private int zzl;
    private int zzm;
    private long zzn;
    private int zzs;
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private String zzo = "";
    private String zzp = "";
    private String zzq = "";
    private String zzr = "";

    static {
        zzjr zzjrVar = new zzjr();
        zzb = zzjrVar;
        zzfu.zzB(zzjr.class, zzjrVar);
    }

    private zzjr() {
    }

    static /* synthetic */ void zzG(zzjr zzjrVar, long j) {
        zzjrVar.zzd |= IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING;
        zzjrVar.zzn = 846465066L;
    }

    static /* synthetic */ void zzH(zzjr zzjrVar, String str) {
        str.getClass();
        zzjrVar.zzd |= 4;
        zzjrVar.zzg = str;
    }

    static /* synthetic */ void zzI(zzjr zzjrVar, String str) {
        str.getClass();
        zzjrVar.zzd |= IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET;
        zzjrVar.zzo = str;
    }

    static /* synthetic */ void zzJ(zzjr zzjrVar, String str) {
        str.getClass();
        zzjrVar.zzd |= 8192;
        zzjrVar.zzr = str;
    }

    static /* synthetic */ void zzK(zzjr zzjrVar, String str) {
        str.getClass();
        zzjrVar.zzd |= 4096;
        zzjrVar.zzq = str;
    }

    static /* synthetic */ void zzL(zzjr zzjrVar, String str) {
        str.getClass();
        zzjrVar.zzd |= 2048;
        zzjrVar.zzp = str;
    }

    static /* synthetic */ void zzM(zzjr zzjrVar, int i) {
        zzjrVar.zzd |= Http2.INITIAL_MAX_FRAME_SIZE;
        zzjrVar.zzs = i;
    }

    static /* synthetic */ void zzN(zzjr zzjrVar, boolean z) {
        zzjrVar.zzd |= 64;
        zzjrVar.zzk = z;
    }

    static /* synthetic */ void zzO(zzjr zzjrVar, String str) {
        str.getClass();
        zzjrVar.zzd |= 1;
        zzjrVar.zze = str;
    }

    static /* synthetic */ void zzP(zzjr zzjrVar, String str) {
        zzjrVar.zzd |= 2;
        zzjrVar.zzf = str;
    }

    public static zzjp zza() {
        return (zzjp) zzb.zzp();
    }

    static /* synthetic */ void zzc(zzjr zzjrVar, int i) {
        zzjrVar.zzd |= 128;
        zzjrVar.zzl = i;
    }

    static /* synthetic */ void zze(zzjr zzjrVar, int i) {
        zzjrVar.zzd |= IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER;
        zzjrVar.zzm = i;
    }

    static /* synthetic */ void zzf(zzjr zzjrVar, int i) {
        zzjrVar.zzd |= 8;
        zzjrVar.zzh = i;
    }

    static /* synthetic */ void zzg(zzjr zzjrVar, long j) {
        zzjrVar.zzd |= 16;
        zzjrVar.zzi = j;
    }

    static /* synthetic */ void zzh(zzjr zzjrVar, long j) {
        zzjrVar.zzd |= 32;
        zzjrVar.zzj = j;
    }

    @Override // com.google.android.gms.internal.play_billing.zzfu
    protected final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzfu.zzy(zzb, "\u0004\u000f\u0000\u0001\u0001\u000f\u000f\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0002\u0003င\u0003\u0004ဂ\u0004\u0005ဈ\u0001\u0006ဂ\u0005\u0007ဇ\u0006\bင\u0007\tင\b\nဂ\t\u000bဈ\n\fဈ\u000b\rဈ\f\u000eဈ\r\u000fင\u000e", new Object[]{"zzd", "zze", "zzg", "zzh", "zzi", "zzf", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs"});
        }
        if (i2 == 3) {
            return new zzjr();
        }
        zzjq zzjqVar = null;
        if (i2 == 4) {
            return new zzjp(zzjqVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }
}
