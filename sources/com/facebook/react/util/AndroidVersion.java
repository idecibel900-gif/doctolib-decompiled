package com.facebook.react.util;

import android.content.Context;
import android.os.Build;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class AndroidVersion {
    public static final AndroidVersion INSTANCE = new AndroidVersion();

    private AndroidVersion() {
    }

    public static final boolean isAtLeastTargetSdk36(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return Build.VERSION.SDK_INT >= 36 && context.getApplicationInfo().targetSdkVersion >= 36;
    }
}
