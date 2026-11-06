package com.facebook.react.devsupport;

import android.os.Build;

/* JADX INFO: loaded from: classes3.dex */
public final class WindowOverlayCompat {
    public static final WindowOverlayCompat INSTANCE = new WindowOverlayCompat();
    public static final int TYPE_SYSTEM_OVERLAY;

    private WindowOverlayCompat() {
    }

    static {
        TYPE_SYSTEM_OVERLAY = Build.VERSION.SDK_INT < 26 ? 2006 : 2038;
    }
}
