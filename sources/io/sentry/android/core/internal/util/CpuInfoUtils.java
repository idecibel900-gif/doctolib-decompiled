package io.sentry.android.core.internal.util;

import io.sentry.ISentryLifecycleToken;
import io.sentry.util.AutoClosableReentrantLock;
import io.sentry.util.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class CpuInfoUtils {
    private static final CpuInfoUtils instance = new CpuInfoUtils();
    private final AutoClosableReentrantLock lock = new AutoClosableReentrantLock();
    private final List cpuMaxFrequenciesMhz = new ArrayList();

    public static CpuInfoUtils getInstance() {
        return instance;
    }

    private CpuInfoUtils() {
    }

    public List readMaxFrequencies() {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            if (!this.cpuMaxFrequenciesMhz.isEmpty()) {
                List list = this.cpuMaxFrequenciesMhz;
                if (iSentryLifecycleTokenAcquire != null) {
                    iSentryLifecycleTokenAcquire.close();
                }
                return list;
            }
            File[] fileArrListFiles = new File(getSystemCpuPath()).listFiles();
            if (fileArrListFiles == null) {
                ArrayList arrayList = new ArrayList();
                if (iSentryLifecycleTokenAcquire != null) {
                    iSentryLifecycleTokenAcquire.close();
                }
                return arrayList;
            }
            for (File file : fileArrListFiles) {
                if (file.getName().matches("cpu[0-9]+")) {
                    try {
                        String text = FileUtils.readText(new File(file, "cpufreq/cpuinfo_max_freq"));
                        if (text != null) {
                            this.cpuMaxFrequenciesMhz.add(Integer.valueOf((int) (Long.parseLong(text.trim()) / 1000)));
                        }
                    } catch (IOException | NumberFormatException unused) {
                    }
                }
            }
            List list2 = this.cpuMaxFrequenciesMhz;
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
            return list2;
        } catch (Throwable th) {
            if (iSentryLifecycleTokenAcquire != null) {
                try {
                    iSentryLifecycleTokenAcquire.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    String getSystemCpuPath() {
        return "/sys/devices/system/cpu";
    }
}
