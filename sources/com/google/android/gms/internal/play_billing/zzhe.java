package com.google.android.gms.internal.play_billing;

import android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.opentok.android.BaseVideoCapturer;
import com.opentok.android.BluetoothManager;
import com.revenuecat.purchases.common.verification.SigningManager;
import com.revenuecat.purchases.ui.revenuecatui.composables.BackgroundUIConstants;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.revenuecat.purchases.utils.PurchaseParamsValidator;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.openid.appauth.CodeVerifierUtil;
import okhttp3.internal.ws.WebSocketProtocol;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes3.dex */
final class zzhe implements zzhl {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzii.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzhb zzg;
    private final boolean zzh = false;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zzib zzl;
    private final zzfi zzm;

    private zzhe(int[] iArr, Object[] objArr, int i, int i2, zzhb zzhbVar, boolean z, int[] iArr2, int i3, int i4, zzhg zzhgVar, zzgk zzgkVar, zzib zzibVar, zzfi zzfiVar, zzgw zzgwVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = iArr2;
        this.zzj = i3;
        this.zzk = i4;
        this.zzl = zzibVar;
        this.zzm = zzfiVar;
        this.zzg = zzhbVar;
    }

    private static void zzA(Object obj) {
        if (!zzL(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    private final void zzB(Object obj, Object obj2, int i) {
        if (zzI(obj2, i)) {
            int iZzs = zzs(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzs;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzhl zzhlVarZzv = zzv(i);
            if (!zzI(obj, i)) {
                if (zzL(object)) {
                    Object objZze = zzhlVarZzv.zze();
                    zzhlVarZzv.zzg(objZze, object);
                    unsafe.putObject(obj, j, objZze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzD(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzL(object2)) {
                Object objZze2 = zzhlVarZzv.zze();
                zzhlVarZzv.zzg(objZze2, object2);
                unsafe.putObject(obj, j, objZze2);
                object2 = objZze2;
            }
            zzhlVarZzv.zzg(object2, object);
        }
    }

    private final void zzC(Object obj, Object obj2, int i) {
        int[] iArr = this.zzc;
        int i2 = iArr[i];
        if (zzM(obj2, i2, i)) {
            int iZzs = zzs(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzs;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + iArr[i] + " is present but null: " + obj2.toString());
            }
            zzhl zzhlVarZzv = zzv(i);
            if (!zzM(obj, i2, i)) {
                if (zzL(object)) {
                    Object objZze = zzhlVarZzv.zze();
                    zzhlVarZzv.zzg(objZze, object);
                    unsafe.putObject(obj, j, objZze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzE(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzL(object2)) {
                Object objZze2 = zzhlVarZzv.zze();
                zzhlVarZzv.zzg(objZze2, object2);
                unsafe.putObject(obj, j, objZze2);
                object2 = objZze2;
            }
            zzhlVarZzv.zzg(object2, object);
        }
    }

    private final void zzD(Object obj, int i) {
        int iZzp = zzp(i);
        long j = 1048575 & iZzp;
        if (j == 1048575) {
            return;
        }
        zzii.zzq(obj, j, (1 << (iZzp >>> 20)) | zzii.zzc(obj, j));
    }

    private final void zzE(Object obj, int i, int i2) {
        zzii.zzq(obj, zzp(i2) & 1048575, i);
    }

    private final void zzF(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzs(i) & 1048575, obj2);
        zzD(obj, i);
    }

    private final void zzG(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, zzs(i2) & 1048575, obj2);
        zzE(obj, i, i2);
    }

    private final boolean zzH(Object obj, Object obj2, int i) {
        return zzI(obj, i) == zzI(obj2, i);
    }

    private final boolean zzI(Object obj, int i) {
        int iZzp = zzp(i);
        long j = iZzp & 1048575;
        if (j != 1048575) {
            return (zzii.zzc(obj, j) & (1 << (iZzp >>> 20))) != 0;
        }
        int iZzs = zzs(i);
        long j2 = iZzs & 1048575;
        switch (zzr(iZzs)) {
            case 0:
                return Double.doubleToRawLongBits(zzii.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzii.zzb(obj, j2)) != 0;
            case 2:
                return zzii.zzd(obj, j2) != 0;
            case 3:
                return zzii.zzd(obj, j2) != 0;
            case 4:
                return zzii.zzc(obj, j2) != 0;
            case 5:
                return zzii.zzd(obj, j2) != 0;
            case 6:
                return zzii.zzc(obj, j2) != 0;
            case 7:
                return zzii.zzw(obj, j2);
            case 8:
                Object objZzf = zzii.zzf(obj, j2);
                if (objZzf instanceof String) {
                    return !((String) objZzf).isEmpty();
                }
                if (objZzf instanceof zzev) {
                    return !zzev.zza.equals(objZzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzii.zzf(obj, j2) != null;
            case 10:
                return !zzev.zza.equals(zzii.zzf(obj, j2));
            case BaseVideoCapturer.RGBA /* 11 */:
                return zzii.zzc(obj, j2) != 0;
            case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                return zzii.zzc(obj, j2) != 0;
            case 13:
                return zzii.zzc(obj, j2) != 0;
            case 14:
                return zzii.zzd(obj, j2) != 0;
            case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                return zzii.zzc(obj, j2) != 0;
            case 16:
                return zzii.zzd(obj, j2) != 0;
            case 17:
                return zzii.zzf(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzJ(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzI(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private static boolean zzK(Object obj, int i, zzhl zzhlVar) {
        return zzhlVar.zzk(zzii.zzf(obj, i & 1048575));
    }

    private static boolean zzL(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzfu) {
            return ((zzfu) obj).zzF();
        }
        return true;
    }

    private final boolean zzM(Object obj, int i, int i2) {
        return zzii.zzc(obj, (long) (zzp(i2) & 1048575)) == i;
    }

    private static boolean zzN(Object obj, long j) {
        return ((Boolean) zzii.zzf(obj, j)).booleanValue();
    }

    private static final void zzP(int i, Object obj, zzit zzitVar) {
        if (obj instanceof String) {
            zzitVar.zzH(i, (String) obj);
        } else {
            zzitVar.zzd(i, (zzev) obj);
        }
    }

    static zzic zzd(Object obj) {
        zzfu zzfuVar = (zzfu) obj;
        zzic zzicVar = zzfuVar.zzc;
        if (zzicVar != zzic.zzc()) {
            return zzicVar;
        }
        zzic zzicVarZzf = zzic.zzf();
        zzfuVar.zzc = zzicVarZzf;
        return zzicVarZzf;
    }

    /* JADX WARN: Code duplicated, block: B:126:0x026e  */
    /* JADX WARN: Code duplicated, block: B:128:0x0274  */
    /* JADX WARN: Code duplicated, block: B:131:0x028c  */
    /* JADX WARN: Code duplicated, block: B:132:0x028f  */
    /* JADX WARN: Code duplicated, block: B:171:0x0350  */
    /* JADX WARN: Code duplicated, block: B:187:0x03a6  */
    /* JADX WARN: Code duplicated, block: B:190:0x03b0  */
    static zzhe zzl(Class cls, zzgy zzgyVar, zzhg zzhgVar, zzgk zzgkVar, zzib zzibVar, zzfi zzfiVar, zzgw zzgwVar) {
        int i;
        int iCharAt;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int[] iArr;
        int i7;
        int i8;
        char cCharAt;
        int i9;
        char cCharAt2;
        int i10;
        char cCharAt3;
        int i11;
        char cCharAt4;
        int i12;
        char cCharAt5;
        int i13;
        char cCharAt6;
        int i14;
        char cCharAt7;
        int i15;
        char cCharAt8;
        int i16;
        int i17;
        int i18;
        int iObjectFieldOffset;
        char c;
        int iObjectFieldOffset2;
        int i19;
        int i20;
        int i21;
        Field fieldZzz;
        char cCharAt9;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        Object obj;
        Field fieldZzz2;
        int i27;
        Object obj2;
        Field fieldZzz3;
        int i28;
        char cCharAt10;
        int i29;
        char cCharAt11;
        int i30;
        char cCharAt12;
        int i31;
        char cCharAt13;
        if (!(zzgyVar instanceof zzhk)) {
            MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(zzgyVar);
            throw null;
        }
        zzhk zzhkVar = (zzhk) zzgyVar;
        String strZzd = zzhkVar.zzd();
        int length = strZzd.length();
        char c2 = 55296;
        if (strZzd.charAt(0) >= 55296) {
            int i32 = 1;
            while (true) {
                i = i32 + 1;
                if (strZzd.charAt(i32) < 55296) {
                    break;
                }
                i32 = i;
            }
        } else {
            i = 1;
        }
        int i33 = i + 1;
        int iCharAt2 = strZzd.charAt(i);
        if (iCharAt2 >= 55296) {
            int i34 = iCharAt2 & 8191;
            int i35 = 13;
            while (true) {
                i31 = i33 + 1;
                cCharAt13 = strZzd.charAt(i33);
                if (cCharAt13 < 55296) {
                    break;
                }
                i34 |= (cCharAt13 & 8191) << i35;
                i35 += 13;
                i33 = i31;
            }
            iCharAt2 = i34 | (cCharAt13 << i35);
            i33 = i31;
        }
        if (iCharAt2 == 0) {
            i3 = 0;
            i6 = 0;
            iCharAt = 0;
            i2 = 0;
            i4 = 0;
            i5 = 0;
            iArr = zza;
            i7 = 0;
        } else {
            int i36 = i33 + 1;
            int iCharAt3 = strZzd.charAt(i33);
            if (iCharAt3 >= 55296) {
                int i37 = iCharAt3 & 8191;
                int i38 = 13;
                while (true) {
                    i15 = i36 + 1;
                    cCharAt8 = strZzd.charAt(i36);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i37 |= (cCharAt8 & 8191) << i38;
                    i38 += 13;
                    i36 = i15;
                }
                iCharAt3 = i37 | (cCharAt8 << i38);
                i36 = i15;
            }
            int i39 = i36 + 1;
            int iCharAt4 = strZzd.charAt(i36);
            if (iCharAt4 >= 55296) {
                int i40 = iCharAt4 & 8191;
                int i41 = 13;
                while (true) {
                    i14 = i39 + 1;
                    cCharAt7 = strZzd.charAt(i39);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i40 |= (cCharAt7 & 8191) << i41;
                    i41 += 13;
                    i39 = i14;
                }
                iCharAt4 = i40 | (cCharAt7 << i41);
                i39 = i14;
            }
            int i42 = i39 + 1;
            int iCharAt5 = strZzd.charAt(i39);
            if (iCharAt5 >= 55296) {
                int i43 = iCharAt5 & 8191;
                int i44 = 13;
                while (true) {
                    i13 = i42 + 1;
                    cCharAt6 = strZzd.charAt(i42);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i43 |= (cCharAt6 & 8191) << i44;
                    i44 += 13;
                    i42 = i13;
                }
                iCharAt5 = i43 | (cCharAt6 << i44);
                i42 = i13;
            }
            int i45 = i42 + 1;
            int iCharAt6 = strZzd.charAt(i42);
            if (iCharAt6 >= 55296) {
                int i46 = iCharAt6 & 8191;
                int i47 = 13;
                while (true) {
                    i12 = i45 + 1;
                    cCharAt5 = strZzd.charAt(i45);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i46 |= (cCharAt5 & 8191) << i47;
                    i47 += 13;
                    i45 = i12;
                }
                iCharAt6 = i46 | (cCharAt5 << i47);
                i45 = i12;
            }
            int i48 = i45 + 1;
            iCharAt = strZzd.charAt(i45);
            if (iCharAt >= 55296) {
                int i49 = iCharAt & 8191;
                int i50 = 13;
                while (true) {
                    i11 = i48 + 1;
                    cCharAt4 = strZzd.charAt(i48);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i49 |= (cCharAt4 & 8191) << i50;
                    i50 += 13;
                    i48 = i11;
                }
                iCharAt = i49 | (cCharAt4 << i50);
                i48 = i11;
            }
            int i51 = i48 + 1;
            int iCharAt7 = strZzd.charAt(i48);
            if (iCharAt7 >= 55296) {
                int i52 = iCharAt7 & 8191;
                int i53 = 13;
                while (true) {
                    i10 = i51 + 1;
                    cCharAt3 = strZzd.charAt(i51);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i52 |= (cCharAt3 & 8191) << i53;
                    i53 += 13;
                    i51 = i10;
                }
                iCharAt7 = i52 | (cCharAt3 << i53);
                i51 = i10;
            }
            int i54 = i51 + 1;
            int iCharAt8 = strZzd.charAt(i51);
            if (iCharAt8 >= 55296) {
                int i55 = iCharAt8 & 8191;
                int i56 = 13;
                while (true) {
                    i9 = i54 + 1;
                    cCharAt2 = strZzd.charAt(i54);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i55 |= (cCharAt2 & 8191) << i56;
                    i56 += 13;
                    i54 = i9;
                }
                iCharAt8 = i55 | (cCharAt2 << i56);
                i54 = i9;
            }
            int i57 = i54 + 1;
            int iCharAt9 = strZzd.charAt(i54);
            if (iCharAt9 >= 55296) {
                int i58 = iCharAt9 & 8191;
                int i59 = 13;
                while (true) {
                    i8 = i57 + 1;
                    cCharAt = strZzd.charAt(i57);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i58 |= (cCharAt & 8191) << i59;
                    i59 += 13;
                    i57 = i8;
                }
                iCharAt9 = i58 | (cCharAt << i59);
                i57 = i8;
            }
            int i60 = iCharAt3 + iCharAt3 + iCharAt4;
            int[] iArr2 = new int[iCharAt9 + iCharAt7 + iCharAt8];
            int i61 = iCharAt7;
            i2 = iCharAt5;
            i3 = i61;
            i4 = iCharAt6;
            i5 = iCharAt9;
            i6 = i60;
            iArr = iArr2;
            i7 = iCharAt3;
            i33 = i57;
        }
        Unsafe unsafe = zzb;
        Object[] objArrZze = zzhkVar.zze();
        Class<?> cls2 = zzhkVar.zza().getClass();
        int i62 = i5 + i3;
        int i63 = iCharAt + iCharAt;
        int[] iArr3 = new int[iCharAt * 3];
        Object[] objArr = new Object[i63];
        int i64 = i5;
        int i65 = i62;
        int i66 = 0;
        int i67 = 0;
        while (i33 < length) {
            int i68 = i33 + 1;
            int iCharAt10 = strZzd.charAt(i33);
            if (iCharAt10 >= c2) {
                int i69 = iCharAt10 & 8191;
                int i70 = i68;
                int i71 = 13;
                while (true) {
                    i30 = i70 + 1;
                    cCharAt12 = strZzd.charAt(i70);
                    if (cCharAt12 < c2) {
                        break;
                    }
                    i69 |= (cCharAt12 & 8191) << i71;
                    i71 += 13;
                    i70 = i30;
                }
                iCharAt10 = i69 | (cCharAt12 << i71);
                i16 = i30;
            } else {
                i16 = i68;
            }
            int i72 = i16 + 1;
            int iCharAt11 = strZzd.charAt(i16);
            if (iCharAt11 >= c2) {
                int i73 = iCharAt11 & 8191;
                int i74 = i72;
                int i75 = 13;
                while (true) {
                    i29 = i74 + 1;
                    cCharAt11 = strZzd.charAt(i74);
                    if (cCharAt11 < c2) {
                        break;
                    }
                    i73 |= (cCharAt11 & 8191) << i75;
                    i75 += 13;
                    i74 = i29;
                }
                iCharAt11 = i73 | (cCharAt11 << i75);
                i17 = i29;
            } else {
                i17 = i72;
            }
            if ((iCharAt11 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0) {
                iArr[i66] = i67;
                i66++;
            }
            int i76 = iCharAt11 & 255;
            zzhk zzhkVar2 = zzhkVar;
            int i77 = iCharAt11 & 2048;
            if (i76 >= 51) {
                int i78 = i17 + 1;
                int iCharAt12 = strZzd.charAt(i17);
                char c3 = 55296;
                if (iCharAt12 >= 55296) {
                    int i79 = iCharAt12 & 8191;
                    int i80 = i78;
                    int i81 = 13;
                    while (true) {
                        i28 = i80 + 1;
                        cCharAt10 = strZzd.charAt(i80);
                        if (cCharAt10 < c3) {
                            break;
                        }
                        i79 |= (cCharAt10 & 8191) << i81;
                        i81 += 13;
                        i80 = i28;
                        c3 = 55296;
                    }
                    iCharAt12 = i79 | (cCharAt10 << i81);
                    i23 = i28;
                } else {
                    i23 = i78;
                }
                int i82 = i23;
                int i83 = i76 - 51;
                if (i83 == 9 || i83 == 17) {
                    i24 = i6 + 1;
                    int i84 = i67 / 3;
                    objArr[i84 + i84 + 1] = objArrZze[i6];
                } else {
                    if (i83 != 12) {
                        i25 = i77;
                    } else if (zzhkVar2.zzc() == 1 || i77 != 0) {
                        i24 = i6 + 1;
                        int i85 = i67 / 3;
                        objArr[i85 + i85 + 1] = objArrZze[i6];
                    } else {
                        i25 = 0;
                    }
                    i26 = iCharAt12 + iCharAt12;
                    obj = objArrZze[i26];
                    int i86 = i25;
                    if (obj instanceof Field) {
                        fieldZzz2 = (Field) obj;
                    } else {
                        fieldZzz2 = zzz(cls2, (String) obj);
                        objArrZze[i26] = fieldZzz2;
                    }
                    int i87 = i7;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzz2);
                    i27 = i26 + 1;
                    obj2 = objArrZze[i27];
                    i18 = i87;
                    if (obj2 instanceof Field) {
                        fieldZzz3 = (Field) obj2;
                    } else {
                        fieldZzz3 = zzz(cls2, (String) obj2);
                        objArrZze[i27] = fieldZzz3;
                    }
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzz3);
                    strZzd = strZzd;
                    i20 = i86;
                    i17 = i82;
                    i19 = 0;
                    c = 55296;
                }
                i6 = i24;
                i25 = i77;
                i26 = iCharAt12 + iCharAt12;
                obj = objArrZze[i26];
                int i88 = i25;
                if (obj instanceof Field) {
                    fieldZzz2 = (Field) obj;
                } else {
                    fieldZzz2 = zzz(cls2, (String) obj);
                    objArrZze[i26] = fieldZzz2;
                }
                int i89 = i7;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzz2);
                i27 = i26 + 1;
                obj2 = objArrZze[i27];
                i18 = i89;
                if (obj2 instanceof Field) {
                    fieldZzz3 = (Field) obj2;
                } else {
                    fieldZzz3 = zzz(cls2, (String) obj2);
                    objArrZze[i27] = fieldZzz3;
                }
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzz3);
                strZzd = strZzd;
                i20 = i88;
                i17 = i82;
                i19 = 0;
                c = 55296;
            } else {
                i18 = i7;
                int i90 = i6 + 1;
                Field fieldZzz4 = zzz(cls2, (String) objArrZze[i6]);
                if (i76 == 9 || i76 == 17) {
                    int i91 = i67 / 3;
                    objArr[i91 + i91 + 1] = fieldZzz4.getType();
                } else {
                    if (i76 != 27) {
                        if (i76 == 49) {
                            i6 += 2;
                            i22 = 1;
                        } else if (i76 == 12 || i76 == 30 || i76 == 44) {
                            if (zzhkVar2.zzc() == 1 || i77 != 0) {
                                i6 += 2;
                                int i92 = i67 / 3;
                                objArr[i92 + i92 + 1] = objArrZze[i90];
                            } else {
                                i6 = i90;
                                i77 = 0;
                            }
                        } else if (i76 == 50) {
                            int i93 = i6 + 2;
                            int i94 = i64 + 1;
                            iArr[i64] = i67;
                            int i95 = i67 / 3;
                            int i96 = i95 + i95;
                            objArr[i96] = objArrZze[i90];
                            if (i77 != 0) {
                                objArr[i96 + 1] = objArrZze[i93];
                                i6 += 3;
                                i64 = i94;
                            } else {
                                i6 = i93;
                                i64 = i94;
                                i77 = 0;
                            }
                        }
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzz4);
                        if ((iCharAt11 & 4096) != 0 || i76 > 17) {
                            c = 55296;
                            iObjectFieldOffset2 = 1048575;
                            i19 = 0;
                        } else {
                            int i97 = i17 + 1;
                            int iCharAt13 = strZzd.charAt(i17);
                            if (iCharAt13 >= 55296) {
                                int i98 = iCharAt13 & 8191;
                                int i99 = 13;
                                while (true) {
                                    i21 = i97 + 1;
                                    cCharAt9 = strZzd.charAt(i97);
                                    if (cCharAt9 < 55296) {
                                        break;
                                    }
                                    i98 |= (cCharAt9 & 8191) << i99;
                                    i99 += 13;
                                    i97 = i21;
                                }
                                iCharAt13 = i98 | (cCharAt9 << i99);
                            } else {
                                i21 = i97;
                            }
                            int i100 = i18 + i18 + (iCharAt13 / 32);
                            Object obj3 = objArrZze[i100];
                            if (obj3 instanceof Field) {
                                fieldZzz = (Field) obj3;
                            } else {
                                fieldZzz = zzz(cls2, (String) obj3);
                                objArrZze[i100] = fieldZzz;
                            }
                            int i101 = iCharAt13;
                            int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZzz);
                            i19 = i101 % 32;
                            i17 = i21;
                            c = 55296;
                            iObjectFieldOffset2 = iObjectFieldOffset3;
                        }
                        if (i76 >= 18 && i76 <= 49) {
                            iArr[i65] = iObjectFieldOffset;
                            i65++;
                        }
                        i20 = i77;
                    } else {
                        i22 = 1;
                        i6 += 2;
                    }
                    int i102 = i67 / 3;
                    objArr[i102 + i102 + i22] = objArrZze[i90];
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzz4);
                    if ((iCharAt11 & 4096) != 0) {
                        c = 55296;
                        iObjectFieldOffset2 = 1048575;
                        i19 = 0;
                    } else {
                        c = 55296;
                        iObjectFieldOffset2 = 1048575;
                        i19 = 0;
                    }
                    if (i76 >= 18) {
                        iArr[i65] = iObjectFieldOffset;
                        i65++;
                    }
                    i20 = i77;
                }
                i6 = i90;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzz4);
                if ((iCharAt11 & 4096) != 0) {
                    c = 55296;
                    iObjectFieldOffset2 = 1048575;
                    i19 = 0;
                } else {
                    c = 55296;
                    iObjectFieldOffset2 = 1048575;
                    i19 = 0;
                }
                if (i76 >= 18) {
                    iArr[i65] = iObjectFieldOffset;
                    i65++;
                }
                i20 = i77;
            }
            int i103 = i67 + 1;
            iArr3[i67] = iCharAt10;
            int i104 = i67 + 2;
            iArr3[i103] = ((iCharAt11 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? 536870912 : 0) | ((iCharAt11 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? 268435456 : 0) | (i20 != 0 ? LinearLayoutManager.INVALID_OFFSET : 0) | (i76 << 20) | iObjectFieldOffset;
            i67 += 3;
            iArr3[i104] = (i19 << 20) | iObjectFieldOffset2;
            i33 = i17;
            strZzd = strZzd;
            c2 = c;
            zzhkVar = zzhkVar2;
            length = length;
            i7 = i18;
        }
        return new zzhe(iArr3, objArr, i2, i4, zzhkVar.zza(), false, iArr, i5, i62, zzhgVar, zzgkVar, zzibVar, zzfiVar, zzgwVar);
    }

    private static double zzm(Object obj, long j) {
        return ((Double) zzii.zzf(obj, j)).doubleValue();
    }

    private static float zzn(Object obj, long j) {
        return ((Float) zzii.zzf(obj, j)).floatValue();
    }

    private static int zzo(Object obj, long j) {
        return ((Integer) zzii.zzf(obj, j)).intValue();
    }

    private final int zzp(int i) {
        return this.zzc[i + 2];
    }

    private final int zzq(int i, int i2) {
        int[] iArr = this.zzc;
        int length = (iArr.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = iArr[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private static int zzr(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzs(int i) {
        return this.zzc[i + 1];
    }

    private static long zzt(Object obj, long j) {
        return ((Long) zzii.zzf(obj, j)).longValue();
    }

    private final zzfx zzu(int i) {
        int i2 = i / 3;
        return (zzfx) this.zzd[i2 + i2 + 1];
    }

    private final zzhl zzv(int i) {
        Object[] objArr = this.zzd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzhl zzhlVar = (zzhl) objArr[i3];
        if (zzhlVar != null) {
            return zzhlVar;
        }
        zzhl zzhlVarZzb = zzhi.zza().zzb((Class) objArr[i3 + 1]);
        objArr[i3] = zzhlVarZzb;
        return zzhlVarZzb;
    }

    private final Object zzw(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final Object zzx(Object obj, int i) {
        zzhl zzhlVarZzv = zzv(i);
        int iZzs = zzs(i) & 1048575;
        if (!zzI(obj, i)) {
            return zzhlVarZzv.zze();
        }
        Object object = zzb.getObject(obj, iZzs);
        if (zzL(object)) {
            return object;
        }
        Object objZze = zzhlVarZzv.zze();
        if (object != null) {
            zzhlVarZzv.zzg(objZze, object);
        }
        return objZze;
    }

    private final Object zzy(Object obj, int i, int i2) {
        zzhl zzhlVarZzv = zzv(i2);
        if (!zzM(obj, i, i2)) {
            return zzhlVarZzv.zze();
        }
        Object object = zzb.getObject(obj, zzs(i2) & 1048575);
        if (zzL(object)) {
            return object;
        }
        Object objZze = zzhlVarZzv.zze();
        if (object != null) {
            zzhlVarZzv.zzg(objZze, object);
        }
        return objZze;
    }

    private static Field zzz(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields), e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:143:0x038c  */
    /* JADX WARN: Code duplicated, block: B:176:0x0476  */
    @Override // com.google.android.gms.internal.play_billing.zzhl
    public final int zza(Object obj) {
        int i;
        int iZzy;
        int iZzy2;
        int iZzz;
        int iZzy3;
        int iZzy4;
        int iZzy5;
        int iZzb;
        int iZzy6;
        int iZzi;
        int iZzh;
        int size;
        int iZzm;
        int iZzy7;
        int iZzb2;
        int iZzy8;
        int iZzb3;
        int iZzy9;
        int iZzy10;
        int iZzy11;
        int iZzz2;
        int iZzf;
        int iZzy12;
        int iZzy13;
        int iZza;
        int iZzy14;
        int iZzy15;
        int iZzy16;
        int iZzb4;
        int iZzy17;
        zzhe zzheVar = this;
        Unsafe unsafe = zzb;
        int i2 = 0;
        int i3 = 0;
        int iZzy18 = 0;
        int i4 = 1048575;
        while (true) {
            int[] iArr = zzheVar.zzc;
            if (i2 >= iArr.length) {
                int iZza2 = iZzy18 + ((zzfu) obj).zzc.zza();
                if (!zzheVar.zzh) {
                    return iZza2;
                }
                MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(obj);
                throw null;
            }
            int iZzs = zzheVar.zzs(i2);
            int iZzr = zzr(iZzs);
            int i5 = iArr[i2];
            int i6 = iArr[i2 + 2];
            int i7 = i6 & 1048575;
            if (iZzr <= 17) {
                if (i7 != i4) {
                    i3 = i7 == 1048575 ? 0 : unsafe.getInt(obj, i7);
                    i4 = i7;
                }
                i = 1 << (i6 >>> 20);
            } else {
                i = 0;
            }
            int i8 = iZzs & 1048575;
            if (iZzr >= zzfn.zzJ.zza()) {
                zzfn.zzW.zza();
            }
            long j = i8;
            switch (iZzr) {
                case 0:
                    if (zzheVar.zzJ(obj, i2, i4, i3, i)) {
                        iZzy18 += zzfc.zzy(i5 << 3) + 8;
                    }
                    i2 += 3;
                    break;
                case 1:
                    if (zzheVar.zzJ(obj, i2, i4, i3, i)) {
                        iZzy = zzfc.zzy(i5 << 3);
                        iZzy4 = iZzy + 4;
                        iZzy18 += iZzy4;
                    }
                    zzheVar = this;
                    i2 += 3;
                    break;
                case 2:
                    if (zzheVar.zzJ(obj, i2, i4, i3, i)) {
                        long j2 = unsafe.getLong(obj, j);
                        iZzy2 = zzfc.zzy(i5 << 3);
                        iZzz = zzfc.zzz(j2);
                        iZzy4 = iZzy2 + iZzz;
                        iZzy18 += iZzy4;
                    }
                    zzheVar = this;
                    i2 += 3;
                    break;
                case 3:
                    if (zzheVar.zzJ(obj, i2, i4, i3, i)) {
                        long j3 = unsafe.getLong(obj, j);
                        iZzy2 = zzfc.zzy(i5 << 3);
                        iZzz = zzfc.zzz(j3);
                        iZzy4 = iZzy2 + iZzz;
                        iZzy18 += iZzy4;
                    }
                    zzheVar = this;
                    i2 += 3;
                    break;
                case 4:
                    if (zzheVar.zzJ(obj, i2, i4, i3, i)) {
                        long j4 = unsafe.getInt(obj, j);
                        iZzy2 = zzfc.zzy(i5 << 3);
                        iZzz = zzfc.zzz(j4);
                        iZzy4 = iZzy2 + iZzz;
                        iZzy18 += iZzy4;
                    }
                    zzheVar = this;
                    i2 += 3;
                    break;
                case 5:
                    if (zzheVar.zzJ(obj, i2, i4, i3, i)) {
                        iZzy3 = zzfc.zzy(i5 << 3);
                        iZzy4 = iZzy3 + 8;
                        iZzy18 += iZzy4;
                    }
                    zzheVar = this;
                    i2 += 3;
                    break;
                case 6:
                    if (zzheVar.zzJ(obj, i2, i4, i3, i)) {
                        iZzy = zzfc.zzy(i5 << 3);
                        iZzy4 = iZzy + 4;
                        iZzy18 += iZzy4;
                    }
                    zzheVar = this;
                    i2 += 3;
                    break;
                case 7:
                    if (zzheVar.zzJ(obj, i2, i4, i3, i)) {
                        iZzy4 = zzfc.zzy(i5 << 3) + 1;
                        iZzy18 += iZzy4;
                    }
                    zzheVar = this;
                    i2 += 3;
                    break;
                case 8:
                    if (zzheVar.zzJ(obj, i2, i4, i3, i)) {
                        int i9 = i5 << 3;
                        Object object = unsafe.getObject(obj, j);
                        if (object instanceof zzev) {
                            iZzy5 = zzfc.zzy(i9);
                            iZzb = ((zzev) object).zze();
                            iZzy6 = zzfc.zzy(iZzb);
                        } else {
                            iZzy5 = zzfc.zzy(i9);
                            iZzb = zzin.zzb((String) object);
                            iZzy6 = zzfc.zzy(iZzb);
                        }
                        iZzy4 = iZzy5 + iZzy6 + iZzb;
                        iZzy18 += iZzy4;
                    }
                    zzheVar = this;
                    i2 += 3;
                    break;
                case 9:
                    if (zzheVar.zzJ(obj, i2, i4, i3, i)) {
                        iZzi = zzhn.zzi(i5, unsafe.getObject(obj, j), zzheVar.zzv(i2));
                        iZzy18 += iZzi;
                    }
                    i2 += 3;
                    break;
                case 10:
                    if (zzheVar.zzJ(obj, i2, i4, i3, i)) {
                        zzev zzevVar = (zzev) unsafe.getObject(obj, j);
                        iZzy5 = zzfc.zzy(i5 << 3);
                        iZzb = zzevVar.zze();
                        iZzy6 = zzfc.zzy(iZzb);
                        iZzy4 = iZzy5 + iZzy6 + iZzb;
                        iZzy18 += iZzy4;
                    }
                    zzheVar = this;
                    i2 += 3;
                    break;
                case BaseVideoCapturer.RGBA /* 11 */:
                    if (zzheVar.zzJ(obj, i2, i4, i3, i)) {
                        int i10 = unsafe.getInt(obj, j);
                        iZzy2 = zzfc.zzy(i5 << 3);
                        iZzz = zzfc.zzy(i10);
                        iZzy4 = iZzy2 + iZzz;
                        iZzy18 += iZzy4;
                    }
                    zzheVar = this;
                    i2 += 3;
                    break;
                case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                    if (zzheVar.zzJ(obj, i2, i4, i3, i)) {
                        long j5 = unsafe.getInt(obj, j);
                        iZzy2 = zzfc.zzy(i5 << 3);
                        iZzz = zzfc.zzz(j5);
                        iZzy4 = iZzy2 + iZzz;
                        iZzy18 += iZzy4;
                    }
                    zzheVar = this;
                    i2 += 3;
                    break;
                case 13:
                    if (zzheVar.zzJ(obj, i2, i4, i3, i)) {
                        iZzy = zzfc.zzy(i5 << 3);
                        iZzy4 = iZzy + 4;
                        iZzy18 += iZzy4;
                    }
                    zzheVar = this;
                    i2 += 3;
                    break;
                case 14:
                    if (zzheVar.zzJ(obj, i2, i4, i3, i)) {
                        iZzy3 = zzfc.zzy(i5 << 3);
                        iZzy4 = iZzy3 + 8;
                        iZzy18 += iZzy4;
                    }
                    zzheVar = this;
                    i2 += 3;
                    break;
                case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                    if (zzheVar.zzJ(obj, i2, i4, i3, i)) {
                        int i11 = unsafe.getInt(obj, j);
                        iZzy2 = zzfc.zzy(i5 << 3);
                        iZzz = zzfc.zzy((i11 >> 31) ^ (i11 + i11));
                        iZzy4 = iZzy2 + iZzz;
                        iZzy18 += iZzy4;
                    }
                    zzheVar = this;
                    i2 += 3;
                    break;
                case 16:
                    if (zzheVar.zzJ(obj, i2, i4, i3, i)) {
                        long j6 = unsafe.getLong(obj, j);
                        iZzy2 = zzfc.zzy(i5 << 3);
                        iZzz = zzfc.zzz((j6 >> 63) ^ (j6 + j6));
                        iZzy4 = iZzy2 + iZzz;
                        iZzy18 += iZzy4;
                    }
                    zzheVar = this;
                    i2 += 3;
                    break;
                case 17:
                    if (zzheVar.zzJ(obj, i2, i4, i3, i)) {
                        iZzi = zzhn.zza(i5, (zzhb) unsafe.getObject(obj, j), zzheVar.zzv(i2));
                        iZzy18 += iZzi;
                    }
                    i2 += 3;
                    break;
                case 18:
                    iZzi = zzhn.zze(i5, (List) unsafe.getObject(obj, j), false);
                    iZzy18 += iZzi;
                    i2 += 3;
                    break;
                case 19:
                    iZzi = zzhn.zzc(i5, (List) unsafe.getObject(obj, j), false);
                    iZzy18 += iZzi;
                    i2 += 3;
                    break;
                case 20:
                    List list = (List) unsafe.getObject(obj, j);
                    int i12 = zzhn.$r8$clinit;
                    if (list.size() == 0) {
                        iZzh = 0;
                    } else {
                        iZzh = zzhn.zzh(list) + (list.size() * zzfc.zzy(i5 << 3));
                    }
                    iZzy18 += iZzh;
                    i2 += 3;
                    break;
                case 21:
                    List list2 = (List) unsafe.getObject(obj, j);
                    int i13 = zzhn.$r8$clinit;
                    size = list2.size();
                    if (size == 0) {
                        iZzi = 0;
                    } else {
                        iZzm = zzhn.zzm(list2);
                        iZzy7 = zzfc.zzy(i5 << 3);
                        iZzz2 = size * iZzy7;
                        iZzi = iZzm + iZzz2;
                    }
                    iZzy18 += iZzi;
                    i2 += 3;
                    break;
                case 22:
                    List list3 = (List) unsafe.getObject(obj, j);
                    int i14 = zzhn.$r8$clinit;
                    size = list3.size();
                    if (size == 0) {
                        iZzi = 0;
                    } else {
                        iZzm = zzhn.zzg(list3);
                        iZzy7 = zzfc.zzy(i5 << 3);
                        iZzz2 = size * iZzy7;
                        iZzi = iZzm + iZzz2;
                    }
                    iZzy18 += iZzi;
                    i2 += 3;
                    break;
                case 23:
                    iZzi = zzhn.zze(i5, (List) unsafe.getObject(obj, j), false);
                    iZzy18 += iZzi;
                    i2 += 3;
                    break;
                case ColorExtractionConstants.ALPHA_CHANNEL_SHIFT /* 24 */:
                    iZzi = zzhn.zzc(i5, (List) unsafe.getObject(obj, j), false);
                    iZzy18 += iZzi;
                    i2 += 3;
                    break;
                case BluetoothManager.SCO_CONNECTION_ATTEMPT_DELAY /* 25 */:
                    List list4 = (List) unsafe.getObject(obj, j);
                    int i15 = zzhn.$r8$clinit;
                    int size2 = list4.size();
                    if (size2 == 0) {
                        iZzi = 0;
                    } else {
                        iZzi = size2 * (zzfc.zzy(i5 << 3) + 1);
                    }
                    iZzy18 += iZzi;
                    i2 += 3;
                    break;
                case 26:
                    List list5 = (List) unsafe.getObject(obj, j);
                    int i16 = zzhn.$r8$clinit;
                    int size3 = list5.size();
                    if (size3 == 0) {
                        iZzh = 0;
                    } else {
                        iZzh = zzfc.zzy(i5 << 3) * size3;
                        if (list5 instanceof zzgj) {
                            zzgj zzgjVar = (zzgj) list5;
                            for (int i17 = 0; i17 < size3; i17++) {
                                Object objZza = zzgjVar.zza();
                                if (objZza instanceof zzev) {
                                    iZzb3 = ((zzev) objZza).zze();
                                    iZzy9 = zzfc.zzy(iZzb3);
                                } else {
                                    iZzb3 = zzin.zzb((String) objZza);
                                    iZzy9 = zzfc.zzy(iZzb3);
                                }
                                iZzh += iZzy9 + iZzb3;
                            }
                        } else {
                            for (int i18 = 0; i18 < size3; i18++) {
                                Object obj2 = list5.get(i18);
                                if (obj2 instanceof zzev) {
                                    iZzb2 = ((zzev) obj2).zze();
                                    iZzy8 = zzfc.zzy(iZzb2);
                                } else {
                                    iZzb2 = zzin.zzb((String) obj2);
                                    iZzy8 = zzfc.zzy(iZzb2);
                                }
                                iZzh += iZzy8 + iZzb2;
                            }
                        }
                    }
                    iZzy18 += iZzh;
                    i2 += 3;
                    break;
                case 27:
                    List list6 = (List) unsafe.getObject(obj, j);
                    zzhl zzhlVarZzv = zzheVar.zzv(i2);
                    int i19 = zzhn.$r8$clinit;
                    int size4 = list6.size();
                    if (size4 == 0) {
                        iZzy10 = 0;
                    } else {
                        iZzy10 = zzfc.zzy(i5 << 3) * size4;
                        for (int i20 = 0; i20 < size4; i20++) {
                            int iZzi2 = ((zzeg) list6.get(i20)).zzi(zzhlVarZzv);
                            iZzy10 += zzfc.zzy(iZzi2) + iZzi2;
                        }
                    }
                    iZzy18 += iZzy10;
                    i2 += 3;
                    break;
                case 28:
                    List list7 = (List) unsafe.getObject(obj, j);
                    int i21 = zzhn.$r8$clinit;
                    int size5 = list7.size();
                    if (size5 == 0) {
                        iZzy11 = 0;
                    } else {
                        iZzy11 = size5 * zzfc.zzy(i5 << 3);
                        for (int i22 = 0; i22 < list7.size(); i22++) {
                            int iZze = ((zzev) list7.get(i22)).zze();
                            iZzy11 += zzfc.zzy(iZze) + iZze;
                        }
                    }
                    iZzy18 += iZzy11;
                    i2 += 3;
                    break;
                case 29:
                    List list8 = (List) unsafe.getObject(obj, j);
                    int i23 = zzhn.$r8$clinit;
                    size = list8.size();
                    if (size == 0) {
                        iZzi = 0;
                    } else {
                        iZzm = zzhn.zzl(list8);
                        iZzy7 = zzfc.zzy(i5 << 3);
                        iZzz2 = size * iZzy7;
                        iZzi = iZzm + iZzz2;
                    }
                    iZzy18 += iZzi;
                    i2 += 3;
                    break;
                case 30:
                    List list9 = (List) unsafe.getObject(obj, j);
                    int i24 = zzhn.$r8$clinit;
                    size = list9.size();
                    if (size == 0) {
                        iZzi = 0;
                    } else {
                        iZzm = zzhn.zzb(list9);
                        iZzy7 = zzfc.zzy(i5 << 3);
                        iZzz2 = size * iZzy7;
                        iZzi = iZzm + iZzz2;
                    }
                    iZzy18 += iZzi;
                    i2 += 3;
                    break;
                case BackgroundUIConstants.minSDKVersionSupportingBlur /* 31 */:
                    iZzi = zzhn.zzc(i5, (List) unsafe.getObject(obj, j), false);
                    iZzy18 += iZzi;
                    i2 += 3;
                    break;
                case 32:
                    iZzi = zzhn.zze(i5, (List) unsafe.getObject(obj, j), false);
                    iZzy18 += iZzi;
                    i2 += 3;
                    break;
                case 33:
                    List list10 = (List) unsafe.getObject(obj, j);
                    int i25 = zzhn.$r8$clinit;
                    size = list10.size();
                    if (size == 0) {
                        iZzi = 0;
                    } else {
                        iZzm = zzhn.zzj(list10);
                        iZzy7 = zzfc.zzy(i5 << 3);
                        iZzz2 = size * iZzy7;
                        iZzi = iZzm + iZzz2;
                    }
                    iZzy18 += iZzi;
                    i2 += 3;
                    break;
                case 34:
                    List list11 = (List) unsafe.getObject(obj, j);
                    int i26 = zzhn.$r8$clinit;
                    size = list11.size();
                    if (size == 0) {
                        iZzi = 0;
                    } else {
                        iZzm = zzhn.zzk(list11);
                        iZzy7 = zzfc.zzy(i5 << 3);
                        iZzz2 = size * iZzy7;
                        iZzi = iZzm + iZzz2;
                    }
                    iZzy18 += iZzi;
                    i2 += 3;
                    break;
                case 35:
                    iZzf = zzhn.zzf((List) unsafe.getObject(obj, j));
                    if (iZzf > 0) {
                        iZzy12 = zzfc.zzy(i5 << 3);
                        iZzy13 = zzfc.zzy(iZzf);
                        iZzy11 = iZzy12 + iZzy13 + iZzf;
                        iZzy18 += iZzy11;
                    }
                    i2 += 3;
                    break;
                case 36:
                    iZzf = zzhn.zzd((List) unsafe.getObject(obj, j));
                    if (iZzf > 0) {
                        iZzy12 = zzfc.zzy(i5 << 3);
                        iZzy13 = zzfc.zzy(iZzf);
                        iZzy11 = iZzy12 + iZzy13 + iZzf;
                        iZzy18 += iZzy11;
                    }
                    i2 += 3;
                    break;
                case 37:
                    iZzf = zzhn.zzh((List) unsafe.getObject(obj, j));
                    if (iZzf > 0) {
                        iZzy12 = zzfc.zzy(i5 << 3);
                        iZzy13 = zzfc.zzy(iZzf);
                        iZzy11 = iZzy12 + iZzy13 + iZzf;
                        iZzy18 += iZzy11;
                    }
                    i2 += 3;
                    break;
                case 38:
                    iZzf = zzhn.zzm((List) unsafe.getObject(obj, j));
                    if (iZzf > 0) {
                        iZzy12 = zzfc.zzy(i5 << 3);
                        iZzy13 = zzfc.zzy(iZzf);
                        iZzy11 = iZzy12 + iZzy13 + iZzf;
                        iZzy18 += iZzy11;
                    }
                    i2 += 3;
                    break;
                case 39:
                    iZzf = zzhn.zzg((List) unsafe.getObject(obj, j));
                    if (iZzf > 0) {
                        iZzy12 = zzfc.zzy(i5 << 3);
                        iZzy13 = zzfc.zzy(iZzf);
                        iZzy11 = iZzy12 + iZzy13 + iZzf;
                        iZzy18 += iZzy11;
                    }
                    i2 += 3;
                    break;
                case 40:
                    iZzf = zzhn.zzf((List) unsafe.getObject(obj, j));
                    if (iZzf > 0) {
                        iZzy12 = zzfc.zzy(i5 << 3);
                        iZzy13 = zzfc.zzy(iZzf);
                        iZzy11 = iZzy12 + iZzy13 + iZzf;
                        iZzy18 += iZzy11;
                    }
                    i2 += 3;
                    break;
                case 41:
                    iZzf = zzhn.zzd((List) unsafe.getObject(obj, j));
                    if (iZzf > 0) {
                        iZzy12 = zzfc.zzy(i5 << 3);
                        iZzy13 = zzfc.zzy(iZzf);
                        iZzy11 = iZzy12 + iZzy13 + iZzf;
                        iZzy18 += iZzy11;
                    }
                    i2 += 3;
                    break;
                case 42:
                    List list12 = (List) unsafe.getObject(obj, j);
                    int i27 = zzhn.$r8$clinit;
                    iZzf = list12.size();
                    if (iZzf > 0) {
                        iZzy12 = zzfc.zzy(i5 << 3);
                        iZzy13 = zzfc.zzy(iZzf);
                        iZzy11 = iZzy12 + iZzy13 + iZzf;
                        iZzy18 += iZzy11;
                    }
                    i2 += 3;
                    break;
                case CodeVerifierUtil.MIN_CODE_VERIFIER_LENGTH /* 43 */:
                    iZzf = zzhn.zzl((List) unsafe.getObject(obj, j));
                    if (iZzf > 0) {
                        iZzy12 = zzfc.zzy(i5 << 3);
                        iZzy13 = zzfc.zzy(iZzf);
                        iZzy11 = iZzy12 + iZzy13 + iZzf;
                        iZzy18 += iZzy11;
                    }
                    i2 += 3;
                    break;
                case 44:
                    iZzf = zzhn.zzb((List) unsafe.getObject(obj, j));
                    if (iZzf > 0) {
                        iZzy12 = zzfc.zzy(i5 << 3);
                        iZzy13 = zzfc.zzy(iZzf);
                        iZzy11 = iZzy12 + iZzy13 + iZzf;
                        iZzy18 += iZzy11;
                    }
                    i2 += 3;
                    break;
                case 45:
                    iZzf = zzhn.zzd((List) unsafe.getObject(obj, j));
                    if (iZzf > 0) {
                        iZzy12 = zzfc.zzy(i5 << 3);
                        iZzy13 = zzfc.zzy(iZzf);
                        iZzy11 = iZzy12 + iZzy13 + iZzf;
                        iZzy18 += iZzy11;
                    }
                    i2 += 3;
                    break;
                case 46:
                    iZzf = zzhn.zzf((List) unsafe.getObject(obj, j));
                    if (iZzf > 0) {
                        iZzy12 = zzfc.zzy(i5 << 3);
                        iZzy13 = zzfc.zzy(iZzf);
                        iZzy11 = iZzy12 + iZzy13 + iZzf;
                        iZzy18 += iZzy11;
                    }
                    i2 += 3;
                    break;
                case 47:
                    iZzf = zzhn.zzj((List) unsafe.getObject(obj, j));
                    if (iZzf > 0) {
                        iZzy12 = zzfc.zzy(i5 << 3);
                        iZzy13 = zzfc.zzy(iZzf);
                        iZzy11 = iZzy12 + iZzy13 + iZzf;
                        iZzy18 += iZzy11;
                    }
                    i2 += 3;
                    break;
                case 48:
                    iZzf = zzhn.zzk((List) unsafe.getObject(obj, j));
                    if (iZzf > 0) {
                        iZzy12 = zzfc.zzy(i5 << 3);
                        iZzy13 = zzfc.zzy(iZzf);
                        iZzy11 = iZzy12 + iZzy13 + iZzf;
                        iZzy18 += iZzy11;
                    }
                    i2 += 3;
                    break;
                case PurchaseParamsValidator.MAX_NUMBER_OF_ADD_ON_PRODUCTS /* 49 */:
                    List list13 = (List) unsafe.getObject(obj, j);
                    zzhl zzhlVarZzv2 = zzheVar.zzv(i2);
                    int i28 = zzhn.$r8$clinit;
                    int size6 = list13.size();
                    if (size6 == 0) {
                        iZza = 0;
                    } else {
                        iZza = 0;
                        for (int i29 = 0; i29 < size6; i29++) {
                            iZza += zzhn.zza(i5, (zzhb) list13.get(i29), zzhlVarZzv2);
                        }
                    }
                    iZzy18 += iZza;
                    i2 += 3;
                    break;
                case 50:
                    zzgv zzgvVar = (zzgv) unsafe.getObject(obj, j);
                    MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(zzheVar.zzw(i2));
                    if (zzgvVar.isEmpty()) {
                        continue;
                    } else {
                        Iterator it = zzgvVar.entrySet().iterator();
                        if (it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            entry.getKey();
                            entry.getValue();
                            throw null;
                        }
                    }
                    i2 += 3;
                case 51:
                    if (zzheVar.zzM(obj, i5, i2)) {
                        iZzy14 = zzfc.zzy(i5 << 3);
                        iZzi = iZzy14 + 8;
                        iZzy18 += iZzi;
                    }
                    i2 += 3;
                    break;
                case 52:
                    if (zzheVar.zzM(obj, i5, i2)) {
                        iZzy15 = zzfc.zzy(i5 << 3);
                        iZzi = iZzy15 + 4;
                        iZzy18 += iZzi;
                    }
                    i2 += 3;
                    break;
                case 53:
                    if (zzheVar.zzM(obj, i5, i2)) {
                        long jZzt = zzt(obj, j);
                        iZzm = zzfc.zzy(i5 << 3);
                        iZzz2 = zzfc.zzz(jZzt);
                        iZzi = iZzm + iZzz2;
                        iZzy18 += iZzi;
                    }
                    i2 += 3;
                    break;
                case 54:
                    if (zzheVar.zzM(obj, i5, i2)) {
                        long jZzt2 = zzt(obj, j);
                        iZzm = zzfc.zzy(i5 << 3);
                        iZzz2 = zzfc.zzz(jZzt2);
                        iZzi = iZzm + iZzz2;
                        iZzy18 += iZzi;
                    }
                    i2 += 3;
                    break;
                case 55:
                    if (zzheVar.zzM(obj, i5, i2)) {
                        long jZzo = zzo(obj, j);
                        iZzm = zzfc.zzy(i5 << 3);
                        iZzz2 = zzfc.zzz(jZzo);
                        iZzi = iZzm + iZzz2;
                        iZzy18 += iZzi;
                    }
                    i2 += 3;
                    break;
                case 56:
                    if (zzheVar.zzM(obj, i5, i2)) {
                        iZzy14 = zzfc.zzy(i5 << 3);
                        iZzi = iZzy14 + 8;
                        iZzy18 += iZzi;
                    }
                    i2 += 3;
                    break;
                case 57:
                    if (zzheVar.zzM(obj, i5, i2)) {
                        iZzy15 = zzfc.zzy(i5 << 3);
                        iZzi = iZzy15 + 4;
                        iZzy18 += iZzi;
                    }
                    i2 += 3;
                    break;
                case 58:
                    if (zzheVar.zzM(obj, i5, i2)) {
                        iZzi = zzfc.zzy(i5 << 3) + 1;
                        iZzy18 += iZzi;
                    }
                    i2 += 3;
                    break;
                case 59:
                    if (zzheVar.zzM(obj, i5, i2)) {
                        int i30 = i5 << 3;
                        Object object2 = unsafe.getObject(obj, j);
                        if (object2 instanceof zzev) {
                            iZzy16 = zzfc.zzy(i30);
                            iZzb4 = ((zzev) object2).zze();
                            iZzy17 = zzfc.zzy(iZzb4);
                        } else {
                            iZzy16 = zzfc.zzy(i30);
                            iZzb4 = zzin.zzb((String) object2);
                            iZzy17 = zzfc.zzy(iZzb4);
                        }
                        iZzi = iZzy16 + iZzy17 + iZzb4;
                        iZzy18 += iZzi;
                    }
                    i2 += 3;
                    break;
                case 60:
                    if (zzheVar.zzM(obj, i5, i2)) {
                        iZzi = zzhn.zzi(i5, unsafe.getObject(obj, j), zzheVar.zzv(i2));
                        iZzy18 += iZzi;
                    }
                    i2 += 3;
                    break;
                case 61:
                    if (zzheVar.zzM(obj, i5, i2)) {
                        zzev zzevVar2 = (zzev) unsafe.getObject(obj, j);
                        iZzy16 = zzfc.zzy(i5 << 3);
                        iZzb4 = zzevVar2.zze();
                        iZzy17 = zzfc.zzy(iZzb4);
                        iZzi = iZzy16 + iZzy17 + iZzb4;
                        iZzy18 += iZzi;
                    }
                    i2 += 3;
                    break;
                case 62:
                    if (zzheVar.zzM(obj, i5, i2)) {
                        int iZzo = zzo(obj, j);
                        iZzm = zzfc.zzy(i5 << 3);
                        iZzz2 = zzfc.zzy(iZzo);
                        iZzi = iZzm + iZzz2;
                        iZzy18 += iZzi;
                    }
                    i2 += 3;
                    break;
                case 63:
                    if (zzheVar.zzM(obj, i5, i2)) {
                        long jZzo2 = zzo(obj, j);
                        iZzm = zzfc.zzy(i5 << 3);
                        iZzz2 = zzfc.zzz(jZzo2);
                        iZzi = iZzm + iZzz2;
                        iZzy18 += iZzi;
                    }
                    i2 += 3;
                    break;
                case 64:
                    if (zzheVar.zzM(obj, i5, i2)) {
                        iZzy15 = zzfc.zzy(i5 << 3);
                        iZzi = iZzy15 + 4;
                        iZzy18 += iZzi;
                    }
                    i2 += 3;
                    break;
                case 65:
                    if (zzheVar.zzM(obj, i5, i2)) {
                        iZzy14 = zzfc.zzy(i5 << 3);
                        iZzi = iZzy14 + 8;
                        iZzy18 += iZzi;
                    }
                    i2 += 3;
                    break;
                case 66:
                    if (zzheVar.zzM(obj, i5, i2)) {
                        int iZzo2 = zzo(obj, j);
                        iZzm = zzfc.zzy(i5 << 3);
                        iZzz2 = zzfc.zzy((iZzo2 >> 31) ^ (iZzo2 + iZzo2));
                        iZzi = iZzm + iZzz2;
                        iZzy18 += iZzi;
                    }
                    i2 += 3;
                    break;
                case 67:
                    if (zzheVar.zzM(obj, i5, i2)) {
                        long jZzt3 = zzt(obj, j);
                        iZzm = zzfc.zzy(i5 << 3);
                        iZzz2 = zzfc.zzz((jZzt3 >> 63) ^ (jZzt3 + jZzt3));
                        iZzi = iZzm + iZzz2;
                        iZzy18 += iZzi;
                    }
                    i2 += 3;
                    break;
                case 68:
                    if (zzheVar.zzM(obj, i5, i2)) {
                        iZzi = zzhn.zza(i5, (zzhb) unsafe.getObject(obj, j), zzheVar.zzv(i2));
                        iZzy18 += iZzi;
                    }
                    i2 += 3;
                    break;
                default:
                    i2 += 3;
                    break;
            }
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzhl
    public final int zzb(Object obj) {
        int i;
        long jDoubleToLongBits;
        int iFloatToIntBits;
        int i2;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int[] iArr = this.zzc;
            if (i3 >= iArr.length) {
                int iHashCode = (i4 * 53) + ((zzfu) obj).zzc.hashCode();
                if (!this.zzh) {
                    return iHashCode;
                }
                MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(obj);
                throw null;
            }
            int iZzs = zzs(i3);
            int i5 = 1048575 & iZzs;
            int iZzr = zzr(iZzs);
            int i6 = iArr[i3];
            long j = i5;
            int iHashCode2 = 37;
            switch (iZzr) {
                case 0:
                    i = i4 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(zzii.zza(obj, j));
                    byte[] bArr = zzga.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 1:
                    i = i4 * 53;
                    iFloatToIntBits = Float.floatToIntBits(zzii.zzb(obj, j));
                    i4 = i + iFloatToIntBits;
                    break;
                case 2:
                    i = i4 * 53;
                    jDoubleToLongBits = zzii.zzd(obj, j);
                    byte[] bArr2 = zzga.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 3:
                    i = i4 * 53;
                    jDoubleToLongBits = zzii.zzd(obj, j);
                    byte[] bArr3 = zzga.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 4:
                    i = i4 * 53;
                    iFloatToIntBits = zzii.zzc(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 5:
                    i = i4 * 53;
                    jDoubleToLongBits = zzii.zzd(obj, j);
                    byte[] bArr4 = zzga.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 6:
                    i = i4 * 53;
                    iFloatToIntBits = zzii.zzc(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 7:
                    i = i4 * 53;
                    iFloatToIntBits = zzga.zza(zzii.zzw(obj, j));
                    i4 = i + iFloatToIntBits;
                    break;
                case 8:
                    i = i4 * 53;
                    iFloatToIntBits = ((String) zzii.zzf(obj, j)).hashCode();
                    i4 = i + iFloatToIntBits;
                    break;
                case 9:
                    i2 = i4 * 53;
                    Object objZzf = zzii.zzf(obj, j);
                    if (objZzf != null) {
                        iHashCode2 = objZzf.hashCode();
                    }
                    i4 = i2 + iHashCode2;
                    break;
                case 10:
                    i = i4 * 53;
                    iFloatToIntBits = zzii.zzf(obj, j).hashCode();
                    i4 = i + iFloatToIntBits;
                    break;
                case BaseVideoCapturer.RGBA /* 11 */:
                    i = i4 * 53;
                    iFloatToIntBits = zzii.zzc(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                    i = i4 * 53;
                    iFloatToIntBits = zzii.zzc(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 13:
                    i = i4 * 53;
                    iFloatToIntBits = zzii.zzc(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 14:
                    i = i4 * 53;
                    jDoubleToLongBits = zzii.zzd(obj, j);
                    byte[] bArr5 = zzga.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                    i = i4 * 53;
                    iFloatToIntBits = zzii.zzc(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 16:
                    i = i4 * 53;
                    jDoubleToLongBits = zzii.zzd(obj, j);
                    byte[] bArr6 = zzga.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 17:
                    i2 = i4 * 53;
                    Object objZzf2 = zzii.zzf(obj, j);
                    if (objZzf2 != null) {
                        iHashCode2 = objZzf2.hashCode();
                    }
                    i4 = i2 + iHashCode2;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case ColorExtractionConstants.ALPHA_CHANNEL_SHIFT /* 24 */:
                case BluetoothManager.SCO_CONNECTION_ATTEMPT_DELAY /* 25 */:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case BackgroundUIConstants.minSDKVersionSupportingBlur /* 31 */:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case CodeVerifierUtil.MIN_CODE_VERIFIER_LENGTH /* 43 */:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case PurchaseParamsValidator.MAX_NUMBER_OF_ADD_ON_PRODUCTS /* 49 */:
                    i = i4 * 53;
                    iFloatToIntBits = zzii.zzf(obj, j).hashCode();
                    i4 = i + iFloatToIntBits;
                    break;
                case 50:
                    i = i4 * 53;
                    iFloatToIntBits = zzii.zzf(obj, j).hashCode();
                    i4 = i + iFloatToIntBits;
                    break;
                case 51:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(zzm(obj, j));
                        byte[] bArr7 = zzga.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 52:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = Float.floatToIntBits(zzn(obj, j));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 53:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr8 = zzga.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 54:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr9 = zzga.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 55:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 56:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr10 = zzga.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 57:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 58:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzga.zza(zzN(obj, j));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 59:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = ((String) zzii.zzf(obj, j)).hashCode();
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 60:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzii.zzf(obj, j).hashCode();
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 61:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzii.zzf(obj, j).hashCode();
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 62:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 63:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 64:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 65:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr11 = zzga.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 66:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 67:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr12 = zzga.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 68:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzii.zzf(obj, j).hashCode();
                        i4 = i + iFloatToIntBits;
                    }
                    break;
            }
            i3 += 3;
        }
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 34001. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    final int zzc(java.lang.Object r32, byte[] r33, int r34, int r35, int r36, com.google.android.gms.internal.play_billing.zzej r37) {
        /*
            Method dump skipped, instruction units count: 3400
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzhe.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.play_billing.zzej):int");
    }

    @Override // com.google.android.gms.internal.play_billing.zzhl
    public final Object zze() {
        return ((zzfu) this.zzg).zzs();
    }

    /* JADX WARN: Code duplicated, block: B:26:0x006f  */
    /* JADX WARN: Code duplicated, block: B:28:0x0075  */
    /* JADX WARN: Code duplicated, block: B:41:0x0082 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.play_billing.zzhl
    public final void zzf(Object obj) {
        if (zzL(obj)) {
            if (obj instanceof zzfu) {
                zzfu zzfuVar = (zzfu) obj;
                zzfuVar.zzC(Integer.MAX_VALUE);
                zzfuVar.zza = 0;
                zzfuVar.zzA();
            }
            int[] iArr = this.zzc;
            for (int i = 0; i < iArr.length; i += 3) {
                int iZzs = zzs(i);
                int i2 = 1048575 & iZzs;
                int iZzr = zzr(iZzs);
                long j = i2;
                if (iZzr != 9) {
                    if (iZzr != 60 && iZzr != 68) {
                        switch (iZzr) {
                            case 17:
                                if (zzI(obj, i)) {
                                    zzv(i).zzf(zzb.getObject(obj, j));
                                }
                                break;
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case ColorExtractionConstants.ALPHA_CHANNEL_SHIFT /* 24 */:
                            case BluetoothManager.SCO_CONNECTION_ATTEMPT_DELAY /* 25 */:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case BackgroundUIConstants.minSDKVersionSupportingBlur /* 31 */:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case CodeVerifierUtil.MIN_CODE_VERIFIER_LENGTH /* 43 */:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case 48:
                            case PurchaseParamsValidator.MAX_NUMBER_OF_ADD_ON_PRODUCTS /* 49 */:
                                ((zzfz) zzii.zzf(obj, j)).zzb();
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((zzgv) object).zzc();
                                    unsafe.putObject(obj, j, object);
                                }
                                break;
                        }
                    } else if (zzM(obj, iArr[i], i)) {
                        zzv(i).zzf(zzb.getObject(obj, j));
                    }
                } else if (zzI(obj, i)) {
                    zzv(i).zzf(zzb.getObject(obj, j));
                }
            }
            this.zzl.zzb(obj);
            if (this.zzh) {
                this.zzm.zza(obj);
            }
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzhl
    public final void zzg(Object obj, Object obj2) {
        zzA(obj);
        obj2.getClass();
        int i = 0;
        while (true) {
            int[] iArr = this.zzc;
            if (i >= iArr.length) {
                zzhn.zzq(this.zzl, obj, obj2);
                if (this.zzh) {
                    zzhn.zzp(this.zzm, obj, obj2);
                    return;
                }
                return;
            }
            int iZzs = zzs(i);
            int i2 = 1048575 & iZzs;
            int iZzr = zzr(iZzs);
            int i3 = iArr[i];
            long j = i2;
            switch (iZzr) {
                case 0:
                    if (zzI(obj2, i)) {
                        zzii.zzo(obj, j, zzii.zza(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 1:
                    if (zzI(obj2, i)) {
                        zzii.zzp(obj, j, zzii.zzb(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 2:
                    if (zzI(obj2, i)) {
                        zzii.zzr(obj, j, zzii.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 3:
                    if (zzI(obj2, i)) {
                        zzii.zzr(obj, j, zzii.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 4:
                    if (zzI(obj2, i)) {
                        zzii.zzq(obj, j, zzii.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 5:
                    if (zzI(obj2, i)) {
                        zzii.zzr(obj, j, zzii.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 6:
                    if (zzI(obj2, i)) {
                        zzii.zzq(obj, j, zzii.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 7:
                    if (zzI(obj2, i)) {
                        zzii.zzm(obj, j, zzii.zzw(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 8:
                    if (zzI(obj2, i)) {
                        zzii.zzs(obj, j, zzii.zzf(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 9:
                    zzB(obj, obj2, i);
                    break;
                case 10:
                    if (zzI(obj2, i)) {
                        zzii.zzs(obj, j, zzii.zzf(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case BaseVideoCapturer.RGBA /* 11 */:
                    if (zzI(obj2, i)) {
                        zzii.zzq(obj, j, zzii.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                    if (zzI(obj2, i)) {
                        zzii.zzq(obj, j, zzii.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 13:
                    if (zzI(obj2, i)) {
                        zzii.zzq(obj, j, zzii.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 14:
                    if (zzI(obj2, i)) {
                        zzii.zzr(obj, j, zzii.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                    if (zzI(obj2, i)) {
                        zzii.zzq(obj, j, zzii.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 16:
                    if (zzI(obj2, i)) {
                        zzii.zzr(obj, j, zzii.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 17:
                    zzB(obj, obj2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case ColorExtractionConstants.ALPHA_CHANNEL_SHIFT /* 24 */:
                case BluetoothManager.SCO_CONNECTION_ATTEMPT_DELAY /* 25 */:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case BackgroundUIConstants.minSDKVersionSupportingBlur /* 31 */:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case CodeVerifierUtil.MIN_CODE_VERIFIER_LENGTH /* 43 */:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case PurchaseParamsValidator.MAX_NUMBER_OF_ADD_ON_PRODUCTS /* 49 */:
                    zzfz zzfzVarZzd = (zzfz) zzii.zzf(obj, j);
                    zzfz zzfzVar = (zzfz) zzii.zzf(obj2, j);
                    int size = zzfzVarZzd.size();
                    int size2 = zzfzVar.size();
                    if (size > 0 && size2 > 0) {
                        if (!zzfzVarZzd.zzc()) {
                            zzfzVarZzd = zzfzVarZzd.zzd(size2 + size);
                        }
                        zzfzVarZzd.addAll(zzfzVar);
                    }
                    if (size > 0) {
                        zzfzVar = zzfzVarZzd;
                    }
                    zzii.zzs(obj, j, zzfzVar);
                    break;
                case 50:
                    int i4 = zzhn.$r8$clinit;
                    zzii.zzs(obj, j, zzgw.zza(zzii.zzf(obj, j), zzii.zzf(obj2, j)));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (zzM(obj2, i3, i)) {
                        zzii.zzs(obj, j, zzii.zzf(obj2, j));
                        zzE(obj, i3, i);
                    }
                    break;
                case 60:
                    zzC(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzM(obj2, i3, i)) {
                        zzii.zzs(obj, j, zzii.zzf(obj2, j));
                        zzE(obj, i3, i);
                    }
                    break;
                case 68:
                    zzC(obj, obj2, i);
                    break;
            }
            i += 3;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzhl
    public final void zzh(Object obj, byte[] bArr, int i, int i2, zzej zzejVar) {
        zzc(obj, bArr, i, i2, 0, zzejVar);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhl
    public final void zzi(Object obj, zzit zzitVar) throws Throwable {
        Throwable th;
        int i;
        zzhe zzheVar = this;
        if (zzheVar.zzh) {
            MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(obj);
            throw null;
        }
        int[] iArr = zzheVar.zzc;
        Unsafe unsafe = zzb;
        int i2 = 1048575;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (i4 < iArr.length) {
            int iZzs = zzheVar.zzs(i4);
            int iZzr = zzr(iZzs);
            int i6 = iArr[i4];
            if (iZzr <= 17) {
                int i7 = iArr[i4 + 2];
                th = null;
                int i8 = i7 & i2;
                if (i8 != i3) {
                    i5 = i8 == i2 ? 0 : unsafe.getInt(obj, i8);
                    i3 = i8;
                }
                i = 1 << (i7 >>> 20);
            } else {
                th = null;
                i = 0;
            }
            long j = iZzs & i2;
            switch (iZzr) {
                case 0:
                    if (zzheVar.zzJ(obj, i4, i3, i5, i)) {
                        zzitVar.zzf(i6, zzii.zza(obj, j));
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzheVar = this;
                    break;
                case 1:
                    if (zzheVar.zzJ(obj, i4, i3, i5, i)) {
                        zzitVar.zzo(i6, zzii.zzb(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzheVar = this;
                    break;
                case 2:
                    if (zzheVar.zzJ(obj, i4, i3, i5, i)) {
                        zzitVar.zzt(i6, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzheVar = this;
                    break;
                case 3:
                    if (zzheVar.zzJ(obj, i4, i3, i5, i)) {
                        zzitVar.zzL(i6, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzheVar = this;
                    break;
                case 4:
                    if (zzheVar.zzJ(obj, i4, i3, i5, i)) {
                        zzitVar.zzr(i6, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzheVar = this;
                    break;
                case 5:
                    if (zzheVar.zzJ(obj, i4, i3, i5, i)) {
                        zzitVar.zzm(i6, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzheVar = this;
                    break;
                case 6:
                    if (zzheVar.zzJ(obj, i4, i3, i5, i)) {
                        zzitVar.zzk(i6, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzheVar = this;
                    break;
                case 7:
                    if (zzheVar.zzJ(obj, i4, i3, i5, i)) {
                        zzitVar.zzb(i6, zzii.zzw(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzheVar = this;
                    break;
                case 8:
                    if (zzheVar.zzJ(obj, i4, i3, i5, i)) {
                        zzP(i6, unsafe.getObject(obj, j), zzitVar);
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzheVar = this;
                    break;
                case 9:
                    if (zzheVar.zzJ(obj, i4, i3, i5, i)) {
                        zzitVar.zzw(i6, unsafe.getObject(obj, j), zzheVar.zzv(i4));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzheVar = this;
                    break;
                case 10:
                    if (zzheVar.zzJ(obj, i4, i3, i5, i)) {
                        zzitVar.zzd(i6, (zzev) unsafe.getObject(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzheVar = this;
                    break;
                case BaseVideoCapturer.RGBA /* 11 */:
                    if (zzheVar.zzJ(obj, i4, i3, i5, i)) {
                        zzitVar.zzJ(i6, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzheVar = this;
                    break;
                case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                    if (zzheVar.zzJ(obj, i4, i3, i5, i)) {
                        zzitVar.zzi(i6, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzheVar = this;
                    break;
                case 13:
                    if (zzheVar.zzJ(obj, i4, i3, i5, i)) {
                        zzitVar.zzy(i6, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzheVar = this;
                    break;
                case 14:
                    if (zzheVar.zzJ(obj, i4, i3, i5, i)) {
                        zzitVar.zzA(i6, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzheVar = this;
                    break;
                case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                    if (zzheVar.zzJ(obj, i4, i3, i5, i)) {
                        zzitVar.zzC(i6, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzheVar = this;
                    break;
                case 16:
                    if (zzheVar.zzJ(obj, i4, i3, i5, i)) {
                        zzitVar.zzE(i6, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzheVar = this;
                    break;
                case 17:
                    if (zzheVar.zzJ(obj, i4, i3, i5, i)) {
                        zzitVar.zzq(i6, unsafe.getObject(obj, j), zzheVar.zzv(i4));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzheVar = this;
                    break;
                case 18:
                    zzhn.zzs(iArr[i4], (List) unsafe.getObject(obj, j), zzitVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzheVar = this;
                    break;
                case 19:
                    zzhn.zzw(iArr[i4], (List) unsafe.getObject(obj, j), zzitVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzheVar = this;
                    break;
                case 20:
                    zzhn.zzy(iArr[i4], (List) unsafe.getObject(obj, j), zzitVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzheVar = this;
                    break;
                case 21:
                    zzhn.zzE(iArr[i4], (List) unsafe.getObject(obj, j), zzitVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzheVar = this;
                    break;
                case 22:
                    zzhn.zzx(iArr[i4], (List) unsafe.getObject(obj, j), zzitVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzheVar = this;
                    break;
                case 23:
                    zzhn.zzv(iArr[i4], (List) unsafe.getObject(obj, j), zzitVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzheVar = this;
                    break;
                case ColorExtractionConstants.ALPHA_CHANNEL_SHIFT /* 24 */:
                    zzhn.zzu(iArr[i4], (List) unsafe.getObject(obj, j), zzitVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzheVar = this;
                    break;
                case BluetoothManager.SCO_CONNECTION_ATTEMPT_DELAY /* 25 */:
                    zzhn.zzr(iArr[i4], (List) unsafe.getObject(obj, j), zzitVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzheVar = this;
                    break;
                case 26:
                    int i9 = iArr[i4];
                    List list = (List) unsafe.getObject(obj, j);
                    int i10 = zzhn.$r8$clinit;
                    if (list != null && !list.isEmpty()) {
                        zzitVar.zzI(i9, list);
                    }
                    break;
                case 27:
                    int i11 = iArr[i4];
                    List list2 = (List) unsafe.getObject(obj, j);
                    zzhl zzhlVarZzv = zzheVar.zzv(i4);
                    int i12 = zzhn.$r8$clinit;
                    if (list2 != null && !list2.isEmpty()) {
                        for (int i13 = 0; i13 < list2.size(); i13++) {
                            ((zzfd) zzitVar).zzw(i11, list2.get(i13), zzhlVarZzv);
                        }
                    }
                    break;
                case 28:
                    int i14 = iArr[i4];
                    List list3 = (List) unsafe.getObject(obj, j);
                    int i15 = zzhn.$r8$clinit;
                    if (list3 != null && !list3.isEmpty()) {
                        zzitVar.zze(i14, list3);
                    }
                    break;
                case 29:
                    zzhn.zzD(iArr[i4], (List) unsafe.getObject(obj, j), zzitVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzheVar = this;
                    break;
                case 30:
                    zzhn.zzt(iArr[i4], (List) unsafe.getObject(obj, j), zzitVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzheVar = this;
                    break;
                case BackgroundUIConstants.minSDKVersionSupportingBlur /* 31 */:
                    zzhn.zzz(iArr[i4], (List) unsafe.getObject(obj, j), zzitVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzheVar = this;
                    break;
                case 32:
                    zzhn.zzA(iArr[i4], (List) unsafe.getObject(obj, j), zzitVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzheVar = this;
                    break;
                case 33:
                    zzhn.zzB(iArr[i4], (List) unsafe.getObject(obj, j), zzitVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzheVar = this;
                    break;
                case 34:
                    zzhn.zzC(iArr[i4], (List) unsafe.getObject(obj, j), zzitVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzheVar = this;
                    break;
                case 35:
                    zzhn.zzs(iArr[i4], (List) unsafe.getObject(obj, j), zzitVar, true);
                    break;
                case 36:
                    zzhn.zzw(iArr[i4], (List) unsafe.getObject(obj, j), zzitVar, true);
                    break;
                case 37:
                    zzhn.zzy(iArr[i4], (List) unsafe.getObject(obj, j), zzitVar, true);
                    break;
                case 38:
                    zzhn.zzE(iArr[i4], (List) unsafe.getObject(obj, j), zzitVar, true);
                    break;
                case 39:
                    zzhn.zzx(iArr[i4], (List) unsafe.getObject(obj, j), zzitVar, true);
                    break;
                case 40:
                    zzhn.zzv(iArr[i4], (List) unsafe.getObject(obj, j), zzitVar, true);
                    break;
                case 41:
                    zzhn.zzu(iArr[i4], (List) unsafe.getObject(obj, j), zzitVar, true);
                    break;
                case 42:
                    zzhn.zzr(iArr[i4], (List) unsafe.getObject(obj, j), zzitVar, true);
                    break;
                case CodeVerifierUtil.MIN_CODE_VERIFIER_LENGTH /* 43 */:
                    zzhn.zzD(iArr[i4], (List) unsafe.getObject(obj, j), zzitVar, true);
                    break;
                case 44:
                    zzhn.zzt(iArr[i4], (List) unsafe.getObject(obj, j), zzitVar, true);
                    break;
                case 45:
                    zzhn.zzz(iArr[i4], (List) unsafe.getObject(obj, j), zzitVar, true);
                    break;
                case 46:
                    zzhn.zzA(iArr[i4], (List) unsafe.getObject(obj, j), zzitVar, true);
                    break;
                case 47:
                    zzhn.zzB(iArr[i4], (List) unsafe.getObject(obj, j), zzitVar, true);
                    break;
                case 48:
                    zzhn.zzC(iArr[i4], (List) unsafe.getObject(obj, j), zzitVar, true);
                    break;
                case PurchaseParamsValidator.MAX_NUMBER_OF_ADD_ON_PRODUCTS /* 49 */:
                    int i16 = iArr[i4];
                    List list4 = (List) unsafe.getObject(obj, j);
                    zzhl zzhlVarZzv2 = zzheVar.zzv(i4);
                    int i17 = zzhn.$r8$clinit;
                    if (list4 != null && !list4.isEmpty()) {
                        for (int i18 = 0; i18 < list4.size(); i18++) {
                            ((zzfd) zzitVar).zzq(i16, list4.get(i18), zzhlVarZzv2);
                        }
                    }
                    break;
                case 50:
                    if (unsafe.getObject(obj, j) != null) {
                        MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(zzheVar.zzw(i4));
                        throw th;
                    }
                    break;
                case 51:
                    if (zzheVar.zzM(obj, i6, i4)) {
                        zzitVar.zzf(i6, zzm(obj, j));
                    }
                    break;
                case 52:
                    if (zzheVar.zzM(obj, i6, i4)) {
                        zzitVar.zzo(i6, zzn(obj, j));
                    }
                    break;
                case 53:
                    if (zzheVar.zzM(obj, i6, i4)) {
                        zzitVar.zzt(i6, zzt(obj, j));
                    }
                    break;
                case 54:
                    if (zzheVar.zzM(obj, i6, i4)) {
                        zzitVar.zzL(i6, zzt(obj, j));
                    }
                    break;
                case 55:
                    if (zzheVar.zzM(obj, i6, i4)) {
                        zzitVar.zzr(i6, zzo(obj, j));
                    }
                    break;
                case 56:
                    if (zzheVar.zzM(obj, i6, i4)) {
                        zzitVar.zzm(i6, zzt(obj, j));
                    }
                    break;
                case 57:
                    if (zzheVar.zzM(obj, i6, i4)) {
                        zzitVar.zzk(i6, zzo(obj, j));
                    }
                    break;
                case 58:
                    if (zzheVar.zzM(obj, i6, i4)) {
                        zzitVar.zzb(i6, zzN(obj, j));
                    }
                    break;
                case 59:
                    if (zzheVar.zzM(obj, i6, i4)) {
                        zzP(i6, unsafe.getObject(obj, j), zzitVar);
                    }
                    break;
                case 60:
                    if (zzheVar.zzM(obj, i6, i4)) {
                        zzitVar.zzw(i6, unsafe.getObject(obj, j), zzheVar.zzv(i4));
                    }
                    break;
                case 61:
                    if (zzheVar.zzM(obj, i6, i4)) {
                        zzitVar.zzd(i6, (zzev) unsafe.getObject(obj, j));
                    }
                    break;
                case 62:
                    if (zzheVar.zzM(obj, i6, i4)) {
                        zzitVar.zzJ(i6, zzo(obj, j));
                    }
                    break;
                case 63:
                    if (zzheVar.zzM(obj, i6, i4)) {
                        zzitVar.zzi(i6, zzo(obj, j));
                    }
                    break;
                case 64:
                    if (zzheVar.zzM(obj, i6, i4)) {
                        zzitVar.zzy(i6, zzo(obj, j));
                    }
                    break;
                case 65:
                    if (zzheVar.zzM(obj, i6, i4)) {
                        zzitVar.zzA(i6, zzt(obj, j));
                    }
                    break;
                case 66:
                    if (zzheVar.zzM(obj, i6, i4)) {
                        zzitVar.zzC(i6, zzo(obj, j));
                    }
                    break;
                case 67:
                    if (zzheVar.zzM(obj, i6, i4)) {
                        zzitVar.zzE(i6, zzt(obj, j));
                    }
                    break;
                case 68:
                    if (zzheVar.zzM(obj, i6, i4)) {
                        zzitVar.zzq(i6, unsafe.getObject(obj, j), zzheVar.zzv(i4));
                    }
                    break;
            }
            i4 += 3;
            i2 = 1048575;
            zzheVar = this;
        }
        ((zzfu) obj).zzc.zzl(zzitVar);
    }

    @Override // com.google.android.gms.internal.play_billing.zzhl
    public final boolean zzj(Object obj, Object obj2) {
        boolean zZzF;
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzs = zzs(i);
            long j = iZzs & 1048575;
            switch (zzr(iZzs)) {
                case 0:
                    if (!zzH(obj, obj2, i) || Double.doubleToLongBits(zzii.zza(obj, j)) != Double.doubleToLongBits(zzii.zza(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!zzH(obj, obj2, i) || Float.floatToIntBits(zzii.zzb(obj, j)) != Float.floatToIntBits(zzii.zzb(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!zzH(obj, obj2, i) || zzii.zzd(obj, j) != zzii.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!zzH(obj, obj2, i) || zzii.zzd(obj, j) != zzii.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!zzH(obj, obj2, i) || zzii.zzc(obj, j) != zzii.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!zzH(obj, obj2, i) || zzii.zzd(obj, j) != zzii.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!zzH(obj, obj2, i) || zzii.zzc(obj, j) != zzii.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!zzH(obj, obj2, i) || zzii.zzw(obj, j) != zzii.zzw(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!zzH(obj, obj2, i) || !zzhn.zzF(zzii.zzf(obj, j), zzii.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!zzH(obj, obj2, i) || !zzhn.zzF(zzii.zzf(obj, j), zzii.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!zzH(obj, obj2, i) || !zzhn.zzF(zzii.zzf(obj, j), zzii.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case BaseVideoCapturer.RGBA /* 11 */:
                    if (!zzH(obj, obj2, i) || zzii.zzc(obj, j) != zzii.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                    if (!zzH(obj, obj2, i) || zzii.zzc(obj, j) != zzii.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!zzH(obj, obj2, i) || zzii.zzc(obj, j) != zzii.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!zzH(obj, obj2, i) || zzii.zzd(obj, j) != zzii.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                    if (!zzH(obj, obj2, i) || zzii.zzc(obj, j) != zzii.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!zzH(obj, obj2, i) || zzii.zzd(obj, j) != zzii.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!zzH(obj, obj2, i) || !zzhn.zzF(zzii.zzf(obj, j), zzii.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case ColorExtractionConstants.ALPHA_CHANNEL_SHIFT /* 24 */:
                case BluetoothManager.SCO_CONNECTION_ATTEMPT_DELAY /* 25 */:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case BackgroundUIConstants.minSDKVersionSupportingBlur /* 31 */:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case CodeVerifierUtil.MIN_CODE_VERIFIER_LENGTH /* 43 */:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case PurchaseParamsValidator.MAX_NUMBER_OF_ADD_ON_PRODUCTS /* 49 */:
                    zZzF = zzhn.zzF(zzii.zzf(obj, j), zzii.zzf(obj2, j));
                    break;
                case 50:
                    zZzF = zzhn.zzF(zzii.zzf(obj, j), zzii.zzf(obj2, j));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long jZzp = zzp(i) & 1048575;
                    if (zzii.zzc(obj, jZzp) != zzii.zzc(obj2, jZzp) || !zzhn.zzF(zzii.zzf(obj, j), zzii.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    continue;
                    break;
            }
            if (!zZzF) {
                return false;
            }
        }
        if (!((zzfu) obj).zzc.equals(((zzfu) obj2).zzc)) {
            return false;
        }
        if (!this.zzh) {
            return true;
        }
        MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(obj);
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x008f  */
    /* JADX WARN: Code duplicated, block: B:44:0x009e  */
    /* JADX WARN: Code duplicated, block: B:47:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:50:0x00b4 A[LOOP:1: B:45:0x00a3->B:50:0x00b4, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:66:0x00b3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x00c9 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.play_billing.zzhl
    public final boolean zzk(Object obj) {
        int i;
        int i2;
        int i3;
        List list;
        zzhl zzhlVarZzv;
        int i4;
        int i5 = 0;
        int i6 = 0;
        int i7 = 1048575;
        while (i6 < this.zzj) {
            int[] iArr = this.zzi;
            int[] iArr2 = this.zzc;
            int i8 = iArr[i6];
            int i9 = iArr2[i8];
            int iZzs = zzs(i8);
            int i10 = iArr2[i8 + 2];
            int i11 = i10 & 1048575;
            int i12 = 1 << (i10 >>> 20);
            if (i11 != i7) {
                if (i11 != 1048575) {
                    i5 = zzb.getInt(obj, i11);
                }
                i = i5;
                i7 = i11;
            } else {
                i = i5;
            }
            if ((268435456 & iZzs) != 0) {
                i2 = i8;
                i3 = i7;
                if (!zzJ(obj, i2, i3, i, i12)) {
                    return false;
                }
            } else {
                i2 = i8;
                i3 = i7;
            }
            int iZzr = zzr(iZzs);
            if (iZzr == 9 || iZzr == 17) {
                if (zzJ(obj, i2, i3, i, i12) && !zzK(obj, iZzs, zzv(i2))) {
                    return false;
                }
            } else if (iZzr == 27) {
                list = (List) zzii.zzf(obj, iZzs & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzhlVarZzv = zzv(i2);
                    for (i4 = 0; i4 < list.size(); i4++) {
                        if (!zzhlVarZzv.zzk(list.get(i4))) {
                            return false;
                        }
                    }
                }
            } else if (iZzr == 60 || iZzr == 68) {
                if (zzM(obj, i9, i2) && !zzK(obj, iZzs, zzv(i2))) {
                    return false;
                }
            } else if (iZzr == 49) {
                list = (List) zzii.zzf(obj, iZzs & 1048575);
                if (list.isEmpty()) {
                    zzhlVarZzv = zzv(i2);
                    while (i4 < list.size()) {
                        if (!zzhlVarZzv.zzk(list.get(i4))) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            } else if (iZzr == 50 && !((zzgv) zzii.zzf(obj, iZzs & 1048575)).isEmpty()) {
                MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(zzw(i2));
                throw null;
            }
            i6++;
            i7 = i3;
            i5 = i;
        }
        if (!this.zzh) {
            return true;
        }
        MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(obj);
        throw null;
    }
}
