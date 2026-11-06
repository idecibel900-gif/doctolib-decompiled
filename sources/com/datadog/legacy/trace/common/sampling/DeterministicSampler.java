package com.datadog.legacy.trace.common.sampling;

import com.datadog.opentracing.DDSpan;
import com.datadog.opentracing.DDTracer;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes3.dex */
public class DeterministicSampler implements RateSampler {
    private final BigInteger cutoff;
    private final double rate;
    private static final BigInteger KNUTH_FACTOR = new BigInteger("1111111111111111111");
    private static final BigDecimal SPAN_ID_MAX_AS_BIG_DECIMAL = new BigDecimal(DDTracer.TRACE_ID_64_BITS_MAX);
    private static final BigInteger MODULUS = new BigInteger("2").pow(64);

    public DeterministicSampler(double d) {
        this.rate = d;
        this.cutoff = new BigDecimal(d).multiply(SPAN_ID_MAX_AS_BIG_DECIMAL).toBigInteger();
    }

    @Override // com.datadog.legacy.trace.common.sampling.Sampler
    public boolean sample(DDSpan dDSpan) {
        double d = this.rate;
        if (d == 1.0d) {
            return true;
        }
        return d != 0.0d && dDSpan.getSpanId().multiply(KNUTH_FACTOR).mod(MODULUS).compareTo(this.cutoff) < 0;
    }

    @Override // com.datadog.legacy.trace.common.sampling.RateSampler
    public double getSampleRate() {
        return this.rate;
    }
}
