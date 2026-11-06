package com.datadog.legacy.trace.common.sampling;

import com.datadog.opentracing.DDSpan;

/* JADX INFO: loaded from: classes3.dex */
public interface PrioritySampler {
    void setSamplingPriority(DDSpan dDSpan);
}
