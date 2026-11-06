package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class SafeParcelWriter {
    public static int beginObjectHeader(Parcel parcel) {
        return zzb(parcel, 20293);
    }

    public static void finishObjectHeader(Parcel parcel, int i) {
        zzc(parcel, i);
    }

    public static void writeBoolean(Parcel parcel, int i, boolean z) {
        zza(parcel, i, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    public static void writeBundle(Parcel parcel, int i, Bundle bundle, boolean z) {
        if (bundle == null) {
            if (z) {
                zza(parcel, i, 0);
            }
        } else {
            int iZzb = zzb(parcel, i);
            parcel.writeBundle(bundle);
            zzc(parcel, iZzb);
        }
    }

    public static void writeByteArray(Parcel parcel, int i, byte[] bArr, boolean z) {
        if (bArr == null) {
            if (z) {
                zza(parcel, i, 0);
            }
        } else {
            int iZzb = zzb(parcel, i);
            parcel.writeByteArray(bArr);
            zzc(parcel, iZzb);
        }
    }

    public static void writeDouble(Parcel parcel, int i, double d) {
        zza(parcel, i, 8);
        parcel.writeDouble(d);
    }

    public static void writeFloat(Parcel parcel, int i, float f) {
        zza(parcel, i, 4);
        parcel.writeFloat(f);
    }

    public static void writeIBinder(Parcel parcel, int i, IBinder iBinder, boolean z) {
        if (iBinder == null) {
            if (z) {
                zza(parcel, i, 0);
            }
        } else {
            int iZzb = zzb(parcel, i);
            parcel.writeStrongBinder(iBinder);
            zzc(parcel, iZzb);
        }
    }

    public static void writeInt(Parcel parcel, int i, int i2) {
        zza(parcel, i, 4);
        parcel.writeInt(i2);
    }

    public static void writeIntArray(Parcel parcel, int i, int[] iArr, boolean z) {
        if (iArr == null) {
            if (z) {
                zza(parcel, i, 0);
            }
        } else {
            int iZzb = zzb(parcel, i);
            parcel.writeIntArray(iArr);
            zzc(parcel, iZzb);
        }
    }

    public static void writeIntegerObject(Parcel parcel, int i, Integer num, boolean z) {
        if (num != null) {
            zza(parcel, i, 4);
            parcel.writeInt(num.intValue());
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeLong(Parcel parcel, int i, long j) {
        zza(parcel, i, 8);
        parcel.writeLong(j);
    }

    public static void writeParcelable(Parcel parcel, int i, Parcelable parcelable, int i2, boolean z) {
        if (parcelable == null) {
            if (z) {
                zza(parcel, i, 0);
            }
        } else {
            int iZzb = zzb(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            zzc(parcel, iZzb);
        }
    }

    public static void writeShort(Parcel parcel, int i, short s) {
        zza(parcel, i, 4);
        parcel.writeInt(s);
    }

    public static void writeString(Parcel parcel, int i, String str, boolean z) {
        if (str == null) {
            if (z) {
                zza(parcel, i, 0);
            }
        } else {
            int iZzb = zzb(parcel, i);
            parcel.writeString(str);
            zzc(parcel, iZzb);
        }
    }

    public static void writeStringList(Parcel parcel, int i, List list, boolean z) {
        if (list == null) {
            if (z) {
                zza(parcel, i, 0);
            }
        } else {
            int iZzb = zzb(parcel, i);
            parcel.writeStringList(list);
            zzc(parcel, iZzb);
        }
    }

    public static void writeTypedArray(Parcel parcel, int i, Parcelable[] parcelableArr, int i2, boolean z) {
        if (parcelableArr == null) {
            if (z) {
                zza(parcel, i, 0);
                return;
            }
            return;
        }
        int iZzb = zzb(parcel, i);
        parcel.writeInt(parcelableArr.length);
        for (Parcelable parcelable : parcelableArr) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                zzd(parcel, parcelable, i2);
            }
        }
        zzc(parcel, iZzb);
    }

    public static void writeTypedList(Parcel parcel, int i, List list, boolean z) {
        if (list == null) {
            if (z) {
                zza(parcel, i, 0);
                return;
            }
            return;
        }
        int iZzb = zzb(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            Parcelable parcelable = (Parcelable) list.get(i2);
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                zzd(parcel, parcelable, 0);
            }
        }
        zzc(parcel, iZzb);
    }

    private static void zza(Parcel parcel, int i, int i2) {
        parcel.writeInt(i | (i2 << 16));
    }

    private static int zzb(Parcel parcel, int i) {
        parcel.writeInt(i | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void zzc(Parcel parcel, int i) {
        int iDataPosition = parcel.dataPosition();
        parcel.setDataPosition(i - 4);
        parcel.writeInt(iDataPosition - i);
        parcel.setDataPosition(iDataPosition);
    }

    private static void zzd(Parcel parcel, Parcelable parcelable, int i) {
        int iDataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int iDataPosition2 = parcel.dataPosition();
        parcelable.writeToParcel(parcel, i);
        int iDataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(iDataPosition);
        parcel.writeInt(iDataPosition3 - iDataPosition2);
        parcel.setDataPosition(iDataPosition3);
    }
}
