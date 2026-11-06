package com.datadog.trace.api;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DDTraceId {
    public static final DDTraceId ZERO = from(0);
    public static final DDTraceId ONE = from(1);

    public abstract String toHexString();

    public static DDTraceId from(long j) {
        return DD64bTraceId.from(j);
    }
}
