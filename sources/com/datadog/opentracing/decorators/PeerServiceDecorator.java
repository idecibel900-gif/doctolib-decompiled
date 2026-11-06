package com.datadog.opentracing.decorators;

import com.datadog.opentracing.DDSpanContext;
import io.opentracing.tag.Tags;

/* JADX INFO: loaded from: classes3.dex */
public class PeerServiceDecorator extends AbstractDecorator {
    public PeerServiceDecorator() {
        setMatchingTag(Tags.PEER_SERVICE.getKey());
    }

    @Override // com.datadog.opentracing.decorators.AbstractDecorator
    public boolean shouldSetTag(DDSpanContext dDSpanContext, String str, Object obj) {
        dDSpanContext.setServiceName(String.valueOf(obj));
        return false;
    }
}
