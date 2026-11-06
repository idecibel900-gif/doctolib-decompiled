package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public abstract class ProfileInstaller {
    private static final DiagnosticsCallback EMPTY_DIAGNOSTICS = new DiagnosticsCallback() { // from class: androidx.profileinstaller.ProfileInstaller.1
        @Override // androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback
        public void onDiagnosticReceived(int i, Object obj) {
        }

        @Override // androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback
        public void onResultReceived(int i, Object obj) {
        }
    };
    static final DiagnosticsCallback LOG_DIAGNOSTICS = new DiagnosticsCallback() { // from class: androidx.profileinstaller.ProfileInstaller.2
        @Override // androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback
        public void onDiagnosticReceived(int i, Object obj) {
        }

        @Override // androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback
        public void onResultReceived(int i, Object obj) {
            if (i == 6 || i == 7 || i == 8) {
            }
        }
    };

    public interface DiagnosticsCallback {
        void onDiagnosticReceived(int i, Object obj);

        void onResultReceived(int i, Object obj);
    }

    static void result(Executor executor, final DiagnosticsCallback diagnosticsCallback, final int i, final Object obj) {
        executor.execute(new Runnable() { // from class: androidx.profileinstaller.ProfileInstaller$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                diagnosticsCallback.onResultReceived(i, obj);
            }
        });
    }

    static boolean hasAlreadyWrittenProfileForThisInstall(PackageInfo packageInfo, File file, DiagnosticsCallback diagnosticsCallback) {
        File file2 = new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat");
        if (!file2.exists()) {
            return false;
        }
        try {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file2));
            try {
                long j = dataInputStream.readLong();
                dataInputStream.close();
                boolean z = j == packageInfo.lastUpdateTime;
                if (z) {
                    diagnosticsCallback.onResultReceived(2, null);
                }
                return z;
            } catch (Throwable th) {
                try {
                    dataInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException unused) {
            return false;
        }
    }

    static void noteProfileWrittenFor(PackageInfo packageInfo, File file) {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat")));
            try {
                dataOutputStream.writeLong(packageInfo.lastUpdateTime);
                dataOutputStream.close();
            } catch (Throwable th) {
                try {
                    dataOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException unused) {
        }
    }

    static boolean deleteProfileWrittenFor(File file) {
        return new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat").delete();
    }

    private static boolean transcodeAndWrite(AssetManager assetManager, String str, PackageInfo packageInfo, File file, String str2, Executor executor, DiagnosticsCallback diagnosticsCallback) {
        DeviceProfileWriter deviceProfileWriter = new DeviceProfileWriter(assetManager, executor, diagnosticsCallback, str2, "dexopt/baseline.prof", "dexopt/baseline.profm", new File(new File("/data/misc/profiles/cur/0", str), "primary.prof"));
        if (!deviceProfileWriter.deviceAllowsProfileInstallerAotWrites()) {
            return false;
        }
        boolean zWrite = deviceProfileWriter.read().transcodeIfNeeded().write();
        if (zWrite) {
            noteProfileWrittenFor(packageInfo, file);
        }
        return zWrite;
    }

    public static void writeProfile(Context context) {
        writeProfile(context, new ProfileInstallReceiver$$ExternalSyntheticLambda0(), EMPTY_DIAGNOSTICS);
    }

    public static void writeProfile(Context context, Executor executor, DiagnosticsCallback diagnosticsCallback) {
        writeProfile(context, executor, diagnosticsCallback, false);
    }

    static void writeProfile(Context context, Executor executor, DiagnosticsCallback diagnosticsCallback, boolean z) {
        Context applicationContext = context.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        ApplicationInfo applicationInfo = applicationContext.getApplicationInfo();
        AssetManager assets = applicationContext.getAssets();
        String name = new File(applicationInfo.sourceDir).getName();
        boolean z2 = false;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            File filesDir = context.getFilesDir();
            if (z || !hasAlreadyWrittenProfileForThisInstall(packageInfo, filesDir, diagnosticsCallback)) {
                context.getPackageName();
                if (transcodeAndWrite(assets, packageName, packageInfo, filesDir, name, executor, diagnosticsCallback) && z) {
                    z2 = true;
                }
                ProfileVerifier.writeProfileVerification(context, z2);
                return;
            }
            context.getPackageName();
            ProfileVerifier.writeProfileVerification(context, false);
        } catch (PackageManager.NameNotFoundException e) {
            diagnosticsCallback.onResultReceived(7, e);
            ProfileVerifier.writeProfileVerification(context, false);
        }
    }

    static void writeSkipFile(Context context, Executor executor, DiagnosticsCallback diagnosticsCallback) {
        try {
            noteProfileWrittenFor(context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0), context.getFilesDir());
            result(executor, diagnosticsCallback, 10, null);
        } catch (PackageManager.NameNotFoundException e) {
            result(executor, diagnosticsCallback, 7, e);
        }
    }

    static void deleteSkipFile(Context context, Executor executor, DiagnosticsCallback diagnosticsCallback) {
        deleteProfileWrittenFor(context.getFilesDir());
        result(executor, diagnosticsCallback, 11, null);
    }
}
