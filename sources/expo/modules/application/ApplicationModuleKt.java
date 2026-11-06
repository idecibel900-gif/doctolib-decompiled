package expo.modules.application;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ApplicationModuleKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final PackageInfo getPackageInfoCompat(PackageManager packageManager, String str, int i) throws ApplicationPackageNameNotFoundException {
        PackageInfo packageInfo;
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                packageInfo = packageManager.getPackageInfo(str, PackageManager.PackageInfoFlags.of(i));
            } else {
                packageInfo = packageManager.getPackageInfo(str, i);
            }
            Intrinsics.checkNotNull(packageInfo);
            return packageInfo;
        } catch (PackageManager.NameNotFoundException e) {
            throw new ApplicationPackageNameNotFoundException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long getLongVersionCode(PackageInfo packageInfo) {
        if (Build.VERSION.SDK_INT >= 28) {
            return packageInfo.getLongVersionCode();
        }
        return packageInfo.versionCode;
    }
}
