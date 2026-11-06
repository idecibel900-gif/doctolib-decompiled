package com.datadog.legacy.trace.common.sampling;

import com.datadog.opentracing.DDSpan;

/* JADX INFO: loaded from: classes3.dex */
public class AllSampler extends AbstractSampler {
    @Override // com.datadog.legacy.trace.common.sampling.AbstractSampler
    public boolean doSample(DDSpan dDSpan) {
        return true;
    }

    public String toString() {
        return "AllSampler { sample=true }";
    }
}
