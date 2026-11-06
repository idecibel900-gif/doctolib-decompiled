package com.datadog.opentracing.jfr;

import com.datadog.opentracing.DDSpanContext;

/* JADX INFO: loaded from: classes3.dex */
public interface DDScopeEventFactory {
    DDScopeEvent create(DDSpanContext dDSpanContext);
}
