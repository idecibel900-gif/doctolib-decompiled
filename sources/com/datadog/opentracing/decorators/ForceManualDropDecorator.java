package com.datadog.opentracing.decorators;

import com.datadog.opentracing.DDSpanContext;

/* JADX INFO: loaded from: classes3.dex */
public class ForceManualDropDecorator extends AbstractDecorator {
    public ForceManualDropDecorator() {
        setMatchingTag("manual.drop");
    }

    @Override // com.datadog.opentracing.decorators.AbstractDecorator
    public boolean shouldSetTag(DDSpanContext dDSpanContext, String str, Object obj) {
        if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
            dDSpanContext.setSamplingPriority(-1);
            return false;
        }
        if (!(obj instanceof String) || !Boolean.parseBoolean((String) obj)) {
            return false;
        }
        dDSpanContext.setSamplingPriority(-1);
        return false;
    }
}
