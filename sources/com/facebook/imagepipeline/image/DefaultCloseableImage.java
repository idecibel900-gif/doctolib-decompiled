package com.facebook.imagepipeline.image;

import com.facebook.common.logging.FLog;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DefaultCloseableImage extends BaseCloseableImage {
    protected void finalize() throws Throwable {
        if (isClosed()) {
            return;
        }
        FLog.w("CloseableImage", "finalize: %s %x still open.", getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(this)));
        try {
            close();
        } finally {
            super.finalize();
        }
    }
}
