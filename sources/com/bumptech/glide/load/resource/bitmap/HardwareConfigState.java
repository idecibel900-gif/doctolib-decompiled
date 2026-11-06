package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class HardwareConfigState {
    public static final boolean BLOCK_HARDWARE_BITMAPS_WHEN_GL_CONTEXT_MIGHT_NOT_BE_INITIALIZED;
    private static final File FD_SIZE_LIST;
    public static final boolean HARDWARE_BITMAPS_SUPPORTED;
    private static volatile HardwareConfigState instance;
    private int decodesSinceLastFdCheck;
    private boolean isFdSizeBelowHardwareLimit = true;
    private final AtomicBoolean isHardwareConfigAllowedByAppState = new AtomicBoolean(false);
    private final int sdkBasedMaxFdCount = 20000;

    static {
        int i = Build.VERSION.SDK_INT;
        BLOCK_HARDWARE_BITMAPS_WHEN_GL_CONTEXT_MIGHT_NOT_BE_INITIALIZED = i < 29;
        HARDWARE_BITMAPS_SUPPORTED = i >= 28;
        FD_SIZE_LIST = new File("/proc/self/fd");
    }

    public static HardwareConfigState getInstance() {
        if (instance == null) {
            synchronized (HardwareConfigState.class) {
                try {
                    if (instance == null) {
                        instance = new HardwareConfigState();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }

    HardwareConfigState() {
    }

    public void unblockHardwareBitmaps() {
        Util.assertMainThread();
        this.isHardwareConfigAllowedByAppState.set(true);
    }

    public boolean isHardwareConfigAllowed(int i, int i2, boolean z, boolean z2) {
        return z && HARDWARE_BITMAPS_SUPPORTED && !areHardwareBitmapsBlockedByAppState() && !z2 && i >= 0 && i2 >= 0 && isFdSizeBelowHardwareLimit();
    }

    private boolean areHardwareBitmapsBlockedByAppState() {
        return BLOCK_HARDWARE_BITMAPS_WHEN_GL_CONTEXT_MIGHT_NOT_BE_INITIALIZED && !this.isHardwareConfigAllowedByAppState.get();
    }

    boolean setHardwareConfigIfAllowed(int i, int i2, BitmapFactory.Options options, boolean z, boolean z2) {
        boolean zIsHardwareConfigAllowed = isHardwareConfigAllowed(i, i2, z, z2);
        if (zIsHardwareConfigAllowed) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return zIsHardwareConfigAllowed;
    }

    private static boolean isHardwareBitmapCountReducedOnApi28ByB139097735() {
        if (Build.VERSION.SDK_INT != 28) {
            return false;
        }
        Iterator it = Arrays.asList("GM1900", "GM1901", "GM1903", "GM1911", "GM1915", "ONEPLUS A3000", "ONEPLUS A3010", "ONEPLUS A5010", "ONEPLUS A5000", "ONEPLUS A3003", "ONEPLUS A6000", "ONEPLUS A6003", "ONEPLUS A6010", "ONEPLUS A6013").iterator();
        while (it.hasNext()) {
            if (Build.MODEL.startsWith((String) it.next())) {
                return true;
            }
        }
        return false;
    }

    private int getMaxFdCount() {
        if (isHardwareBitmapCountReducedOnApi28ByB139097735()) {
            return 500;
        }
        return this.sdkBasedMaxFdCount;
    }

    private synchronized boolean isFdSizeBelowHardwareLimit() {
        try {
            boolean z = true;
            int i = this.decodesSinceLastFdCheck + 1;
            this.decodesSinceLastFdCheck = i;
            if (i >= 50) {
                this.decodesSinceLastFdCheck = 0;
                if (FD_SIZE_LIST.list().length >= getMaxFdCount()) {
                    z = false;
                }
                this.isFdSizeBelowHardwareLimit = z;
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.isFdSizeBelowHardwareLimit;
    }
}
