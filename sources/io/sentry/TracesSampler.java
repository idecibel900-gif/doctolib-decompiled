package io.sentry;

import io.sentry.util.Objects;
import io.sentry.util.SampleRateUtils;

/* JADX INFO: loaded from: classes5.dex */
public final class TracesSampler {
    private final SentryOptions options;

    public TracesSampler(SentryOptions sentryOptions) {
        this.options = (SentryOptions) Objects.requireNonNull(sentryOptions, "options are required");
    }

    public TracesSamplingDecision sample(SamplingContext samplingContext) {
        Double sampleRand = samplingContext.getSampleRand();
        TracesSamplingDecision samplingDecision = samplingContext.getTransactionContext().getSamplingDecision();
        if (samplingDecision != null) {
            return SampleRateUtils.backfilledSampleRand(samplingDecision);
        }
        this.options.getProfilesSampler();
        Double profilesSampleRate = this.options.getProfilesSampleRate();
        Boolean boolValueOf = Boolean.valueOf(profilesSampleRate != null && sample(profilesSampleRate, sampleRand));
        this.options.getTracesSampler();
        TracesSamplingDecision parentSamplingDecision = samplingContext.getTransactionContext().getParentSamplingDecision();
        if (parentSamplingDecision != null) {
            return SampleRateUtils.backfilledSampleRand(parentSamplingDecision);
        }
        Double tracesSampleRate = this.options.getTracesSampleRate();
        Double dValueOf = tracesSampleRate == null ? null : Double.valueOf(tracesSampleRate.doubleValue() / Math.pow(2.0d, this.options.getBackpressureMonitor().getDownsampleFactor()));
        if (dValueOf != null) {
            return new TracesSamplingDecision(Boolean.valueOf(sample(dValueOf, sampleRand)), dValueOf, sampleRand, boolValueOf, profilesSampleRate);
        }
        Boolean bool = Boolean.FALSE;
        return new TracesSamplingDecision(bool, null, sampleRand, bool, null);
    }

    public boolean sampleSessionProfile(double d) {
        Double profileSessionSampleRate = this.options.getProfileSessionSampleRate();
        return profileSessionSampleRate != null && sample(profileSessionSampleRate, Double.valueOf(d));
    }

    private boolean sample(Double d, Double d2) {
        return d.doubleValue() >= d2.doubleValue();
    }
}
