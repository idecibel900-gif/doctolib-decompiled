package com.swmansion.rnscreens.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class RNSLog {
    public static final RNSLog INSTANCE = new RNSLog();

    public final void d(String tag, String message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
    }

    private RNSLog() {
    }
}
