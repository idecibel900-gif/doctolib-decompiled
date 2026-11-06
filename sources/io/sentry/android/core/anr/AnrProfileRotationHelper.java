package io.sentry.android.core.anr;

import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AnrProfileRotationHelper {
    private static final AtomicBoolean shouldRotate = new AtomicBoolean(true);
    private static final Object rotationLock = new Object();

    public static void rotate() {
        shouldRotate.set(true);
    }

    private static void performRotationIfNeeded(File file) {
        AtomicBoolean atomicBoolean = shouldRotate;
        if (atomicBoolean.get()) {
            synchronized (rotationLock) {
                try {
                    if (atomicBoolean.get()) {
                        File file2 = new File(file, "anr_profile");
                        File file3 = new File(file, "anr_profile_old");
                        try {
                            file3.delete();
                        } catch (Throwable unused) {
                        }
                        try {
                            file2.renameTo(file3);
                        } catch (Throwable unused2) {
                        }
                        shouldRotate.set(false);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static File getFileForRecording(File file) {
        performRotationIfNeeded(file);
        return new File(file, "anr_profile");
    }

    public static File getLastFile(File file) {
        performRotationIfNeeded(file);
        return new File(file, "anr_profile_old");
    }

    public static boolean deleteLastFile(File file) {
        File file2 = new File(file, "anr_profile_old");
        if (file2.exists()) {
            return file2.delete();
        }
        return true;
    }
}
