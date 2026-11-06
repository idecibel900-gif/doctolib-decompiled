package io.sentry.android.core;

import android.content.Context;
import com.adjust.sdk.Constants;
import io.sentry.ISentryLifecycleToken;
import io.sentry.SentryUUID;
import io.sentry.util.AutoClosableReentrantLock;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes5.dex */
abstract class Installation {
    static String deviceId;
    private static final Charset UTF_8 = Charset.forName(Constants.ENCODING);
    protected static final AutoClosableReentrantLock staticLock = new AutoClosableReentrantLock();

    public static String id(Context context) {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = staticLock.acquire();
        try {
            if (deviceId == null) {
                File file = new File(context.getFilesDir(), "INSTALLATION");
                try {
                    if (!file.exists()) {
                        String strWriteInstallationFile = writeInstallationFile(file);
                        deviceId = strWriteInstallationFile;
                        if (iSentryLifecycleTokenAcquire != null) {
                            iSentryLifecycleTokenAcquire.close();
                        }
                        return strWriteInstallationFile;
                    }
                    deviceId = readInstallationFile(file);
                } catch (Throwable th) {
                    throw new RuntimeException(th);
                }
            }
            String str = deviceId;
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
            return str;
        } catch (Throwable th2) {
            if (iSentryLifecycleTokenAcquire != null) {
                try {
                    iSentryLifecycleTokenAcquire.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
            throw th2;
        }
    }

    static String readInstallationFile(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        try {
            byte[] bArr = new byte[(int) randomAccessFile.length()];
            randomAccessFile.readFully(bArr);
            String str = new String(bArr, UTF_8);
            randomAccessFile.close();
            return str;
        } catch (Throwable th) {
            try {
                randomAccessFile.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    static String writeInstallationFile(File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            String strGenerateSentryId = SentryUUID.generateSentryId();
            fileOutputStream.write(strGenerateSentryId.getBytes(UTF_8));
            fileOutputStream.flush();
            fileOutputStream.close();
            return strGenerateSentryId;
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
