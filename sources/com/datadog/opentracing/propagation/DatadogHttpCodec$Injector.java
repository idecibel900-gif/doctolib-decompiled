package com.datadog.opentracing.propagation;

import com.datadog.android.trace.internal.domain.event.BigIntegerUtils;

/* JADX INFO: loaded from: classes3.dex */
public class DatadogHttpCodec$Injector implements HttpCodec.Injector {
    private final BigIntegerUtils bigIntegerUtils;

    public DatadogHttpCodec$Injector(BigIntegerUtils bigIntegerUtils) {
        this.bigIntegerUtils = bigIntegerUtils;
    }

    public DatadogHttpCodec$Injector() {
        this(BigIntegerUtils.INSTANCE);
    }
}
