package com.datadog.legacy.trace.common.sampling;

import com.datadog.opentracing.DDSpan;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractSampler implements Sampler {
    protected Map skipTagsPatterns = new HashMap();

    protected abstract boolean doSample(DDSpan dDSpan);

    @Override // com.datadog.legacy.trace.common.sampling.Sampler
    public boolean sample(DDSpan dDSpan) {
        for (Map.Entry entry : this.skipTagsPatterns.entrySet()) {
            Object obj = dDSpan.getTags().get(entry.getKey());
            if (obj != null) {
                if (((Pattern) entry.getValue()).matcher(String.valueOf(obj)).matches()) {
                    return false;
                }
            }
        }
        return doSample(dDSpan);
    }
}
