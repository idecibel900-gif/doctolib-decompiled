package com.datadog.legacy.trace.common.sampling;

import com.datadog.opentracing.DDSpan;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class RateByServiceSampler implements Sampler, PrioritySampler {
    private volatile Map serviceRates;

    @Override // com.datadog.legacy.trace.common.sampling.Sampler
    public boolean sample(DDSpan dDSpan) {
        return true;
    }

    public RateByServiceSampler() {
        this(Double.valueOf(1.0d));
    }

    public RateByServiceSampler(Double d) {
        this.serviceRates = Collections.singletonMap("service:,env:", createRateSampler(d.doubleValue()));
    }

    @Override // com.datadog.legacy.trace.common.sampling.PrioritySampler
    public void setSamplingPriority(DDSpan dDSpan) {
        boolean samplingPriority;
        String str = "service:" + dDSpan.getServiceName() + ",env:" + getSpanEnv(dDSpan);
        Map map = this.serviceRates;
        RateSampler rateSampler = (RateSampler) this.serviceRates.get(str);
        if (rateSampler == null) {
            rateSampler = (RateSampler) map.get("service:,env:");
        }
        if (rateSampler.sample(dDSpan)) {
            samplingPriority = dDSpan.context().setSamplingPriority(1);
        } else {
            samplingPriority = dDSpan.context().setSamplingPriority(0);
        }
        if (samplingPriority) {
            dDSpan.context().setMetric("_dd.agent_psr", Double.valueOf(rateSampler.getSampleRate()));
        }
    }

    private static String getSpanEnv(DDSpan dDSpan) {
        return dDSpan.getTags().get("env") == null ? "" : String.valueOf(dDSpan.getTags().get("env"));
    }

    private RateSampler createRateSampler(double d) {
        if (d < 0.0d || d > 1.0d) {
            d = 1.0d;
        }
        return new DeterministicSampler(d);
    }
}
