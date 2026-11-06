package com.datadog.opentracing.decorators;

import com.datadog.opentracing.DDSpanContext;

/* JADX INFO: loaded from: classes3.dex */
public class ServiceNameDecorator extends AbstractDecorator {
    private final boolean setTag;

    public ServiceNameDecorator() {
        this("service.name", false);
    }

    public ServiceNameDecorator(String str, boolean z) {
        this.setTag = z;
        setMatchingTag(str);
    }

    @Override // com.datadog.opentracing.decorators.AbstractDecorator
    public boolean shouldSetTag(DDSpanContext dDSpanContext, String str, Object obj) {
        dDSpanContext.setServiceName(String.valueOf(obj));
        return this.setTag;
    }
}
