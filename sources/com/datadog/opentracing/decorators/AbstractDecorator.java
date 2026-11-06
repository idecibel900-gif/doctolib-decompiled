package com.datadog.opentracing.decorators;

import com.datadog.opentracing.DDSpanContext;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractDecorator {
    private String matchingTag;

    public abstract boolean shouldSetTag(DDSpanContext dDSpanContext, String str, Object obj);

    public String getMatchingTag() {
        return this.matchingTag;
    }

    public void setMatchingTag(String str) {
        this.matchingTag = str;
    }
}
