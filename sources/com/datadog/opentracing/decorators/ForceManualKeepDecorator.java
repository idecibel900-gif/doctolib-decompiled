package com.datadog.opentracing.decorators;

import com.datadog.opentracing.DDSpanContext;

/* JADX INFO: loaded from: classes3.dex */
public class ForceManualKeepDecorator extends AbstractDecorator {
    public ForceManualKeepDecorator() {
        setMatchingTag("manual.keep");
    }

    @Override // com.datadog.opentracing.decorators.AbstractDecorator
    public boolean shouldSetTag(DDSpanContext dDSpanContext, String str, Object obj) {
        if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
            dDSpanContext.setSamplingPriority(2);
            return false;
        }
        if (!(obj instanceof String) || !Boolean.parseBoolean((String) obj)) {
            return false;
        }
        dDSpanContext.setSamplingPriority(2);
        return false;
    }
}
