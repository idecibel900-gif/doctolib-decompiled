package com.datadog.opentracing.jfr;

import com.datadog.opentracing.DDSpanContext;

/* JADX INFO: loaded from: classes3.dex */
public final class DDNoopScopeEventFactory implements DDScopeEventFactory {
    @Override // com.datadog.opentracing.jfr.DDScopeEventFactory
    public DDScopeEvent create(DDSpanContext dDSpanContext) {
        return DDNoopScopeEvent.INSTANCE;
    }
}
