package com.google.android.gms.internal.play_billing;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzb' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgd {
    public static final zzgd zza;
    public static final zzgd zzb;
    public static final zzgd zzc;
    public static final zzgd zzd;
    public static final zzgd zze;
    public static final zzgd zzf;
    public static final zzgd zzg;
    public static final zzgd zzh;
    public static final zzgd zzi;
    public static final zzgd zzj;
    private static final /* synthetic */ zzgd[] zzk;
    private final Class zzl;

    static {
        zzgd zzgdVar = new zzgd("VOID", 0, Void.class, Void.class, null);
        zza = zzgdVar;
        Class cls = Integer.TYPE;
        zzgd zzgdVar2 = new zzgd("INT", 1, cls, Integer.class, 0);
        zzb = zzgdVar2;
        zzgd zzgdVar3 = new zzgd("LONG", 2, Long.TYPE, Long.class, 0L);
        zzc = zzgdVar3;
        zzgd zzgdVar4 = new zzgd("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        zzd = zzgdVar4;
        zzgd zzgdVar5 = new zzgd("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        zze = zzgdVar5;
        zzgd zzgdVar6 = new zzgd("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        zzf = zzgdVar6;
        zzgd zzgdVar7 = new zzgd("STRING", 6, String.class, String.class, "");
        zzg = zzgdVar7;
        zzgd zzgdVar8 = new zzgd("BYTE_STRING", 7, zzev.class, zzev.class, zzev.zza);
        zzh = zzgdVar8;
        zzgd zzgdVar9 = new zzgd("ENUM", 8, cls, Integer.class, null);
        zzi = zzgdVar9;
        zzgd zzgdVar10 = new zzgd("MESSAGE", 9, Object.class, Object.class, null);
        zzj = zzgdVar10;
        zzk = new zzgd[]{zzgdVar, zzgdVar2, zzgdVar3, zzgdVar4, zzgdVar5, zzgdVar6, zzgdVar7, zzgdVar8, zzgdVar9, zzgdVar10};
    }

    private zzgd(String str, int i, Class cls, Class cls2, Object obj) {
        super(str, i);
        this.zzl = cls2;
    }

    public static zzgd[] values() {
        return (zzgd[]) zzk.clone();
    }

    public final Class zza() {
        return this.zzl;
    }
}
