package com.datadog.legacy.trace.common.sampling;

import com.datadog.legacy.trace.api.Config;
import com.datadog.opentracing.DDSpan;

/* JADX INFO: loaded from: classes3.dex */
public interface Sampler {
    boolean sample(DDSpan dDSpan);

    public static final class Builder {
        public static Sampler forConfig(Config config) {
            if (config != null) {
                if (config.isPrioritySamplingEnabled()) {
                    if (config.getTraceSampleRate() != null) {
                        return new RateByServiceSampler(config.getTraceSampleRate());
                    }
                    return new RateByServiceSampler();
                }
                return new AllSampler();
            }
            return new AllSampler();
        }
    }
}
