package com.facebook.drawee.components;

import android.os.Looper;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DeferredReleaser {
    private static DeferredReleaser sInstance;

    public interface Releasable {
        void release();
    }

    public abstract void cancelDeferredRelease(Releasable releasable);

    public abstract void scheduleDeferredRelease(Releasable releasable);

    public static synchronized DeferredReleaser getInstance() {
        try {
            if (sInstance == null) {
                sInstance = new DeferredReleaserConcurrentImpl();
            }
        } catch (Throwable th) {
            throw th;
        }
        return sInstance;
    }

    static boolean isOnUiThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
