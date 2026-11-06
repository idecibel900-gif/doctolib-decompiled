package com.lyft.kronos.internal.ntp;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class NTPSyncException extends RuntimeException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NTPSyncException(String message) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
