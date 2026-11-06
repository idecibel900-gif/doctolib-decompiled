package com.datadog.android.core.internal.utils;

import com.datadog.android.api.InternalLogger;

/* JADX INFO: loaded from: classes3.dex */
public abstract class RuntimeUtilsKt {
    private static InternalLogger unboundInternalLogger = InternalLogger.Companion.getUNBOUND();

    public static final InternalLogger getUnboundInternalLogger() {
        return unboundInternalLogger;
    }
}
