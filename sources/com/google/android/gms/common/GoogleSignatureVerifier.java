package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.internal.common.zzad;
import com.google.android.gms.internal.common.zzah;
import com.google.android.gms.internal.common.zzal;
import com.google.android.gms.internal.common.zzr;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class GoogleSignatureVerifier {
    private static GoogleSignatureVerifier zza;
    private final Context zzb;

    public GoogleSignatureVerifier(Context context) {
        this.zzb = context.getApplicationContext();
    }

    public static GoogleSignatureVerifier getInstance(Context context) {
        Preconditions.checkNotNull(context);
        synchronized (GoogleSignatureVerifier.class) {
            try {
                if (zza == null) {
                    zzo.zza(context);
                    zza = new GoogleSignatureVerifier(context);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zza;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static final boolean zza(PackageInfo packageInfo, boolean z) {
        zzah zzahVarZzj;
        if (packageInfo == null) {
            return false;
        }
        if (z && ("com.android.vending".equals(packageInfo.packageName) || "com.google.android.gms".equals(packageInfo.packageName))) {
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            z = (applicationInfo == null || (applicationInfo.flags & 129) == 0) ? false : true;
        }
        try {
            zzah zzahVar = z ? zzn.zzc : zzn.zzb;
            int i = AndroidUtilsLight.$r8$clinit;
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 28) {
                Signature[] signatureArr = packageInfo.signatures;
                byte[] byteArray = null;
                if (signatureArr != null && signatureArr.length == 1) {
                    byteArray = signatureArr[0].toByteArray();
                }
                zzahVarZzj = byteArray != null ? zzah.zzk(byteArray) : zzah.zzj();
            } else {
                zzr.zza(i2 >= 28);
                SigningInfo signingInfo = packageInfo.signingInfo;
                if (signingInfo == null || signingInfo.hasMultipleSigners() || signingInfo.getSigningCertificateHistory() == null) {
                    zzahVarZzj = zzah.zzj();
                } else {
                    int i3 = zzah.$r8$clinit;
                    zzad zzadVar = new zzad();
                    for (Signature signature : signingInfo.getSigningCertificateHistory()) {
                        zzadVar.zzb(signature.toByteArray());
                    }
                    zzahVarZzj = zzadVar.zzd();
                }
            }
            if (zzahVarZzj.isEmpty()) {
                throw new IllegalArgumentException("Unable to obtain package certificate history.");
            }
            zzah zzahVarZzh = zzahVarZzj.zzh();
            int size = zzahVarZzh.size();
            int i4 = 0;
            while (i4 < size) {
                byte[] bArr = (byte[]) zzahVarZzh.get(i4);
                zzal zzalVarListIterator = zzahVar.listIterator(0);
                do {
                    int i5 = i4 + 1;
                    if (!zzalVarListIterator.hasNext()) {
                        i4 = i5;
                    }
                } while (!Arrays.equals(bArr, (byte[]) zzalVarListIterator.next()));
                return true;
            }
            return false;
        } catch (IllegalArgumentException unused) {
            return (z ? zzc(packageInfo, zzn.zza) : zzc(packageInfo, zzn.zza[0])) != null;
        }
    }

    private static zzj zzc(PackageInfo packageInfo, zzj... zzjVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null || signatureArr.length != 1) {
            return null;
        }
        zzk zzkVar = new zzk(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < zzjVarArr.length; i++) {
            if (zzjVarArr[i].equals(zzkVar)) {
                return zzjVarArr[i];
            }
        }
        return null;
    }

    public boolean isGooglePublicSignedPackage(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (zza(packageInfo, false)) {
            return true;
        }
        return zza(packageInfo, true) && GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzb);
    }
}
