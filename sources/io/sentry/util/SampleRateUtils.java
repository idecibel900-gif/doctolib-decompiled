package io.sentry.util;

import io.sentry.TracesSamplingDecision;

/* JADX INFO: loaded from: classes5.dex */
public abstract class SampleRateUtils {
    public static boolean isValidSampleRate(Double d) {
        return isValidRate(d, true);
    }

    public static boolean isValidTracesSampleRate(Double d) {
        return isValidTracesSampleRate(d, true);
    }

    public static boolean isValidTracesSampleRate(Double d, boolean z) {
        return isValidRate(d, z);
    }

    public static boolean isValidProfilesSampleRate(Double d) {
        return isValidRate(d, true);
    }

    public static boolean isValidContinuousProfilesSampleRate(Double d) {
        return isValidRate(d, true);
    }

    public static Double backfilledSampleRand(Double d, Double d2, Boolean bool) {
        if (d != null) {
            return d;
        }
        double dNextDouble = SentryRandom.current().nextDouble();
        if (d2 != null && bool != null) {
            if (bool.booleanValue()) {
                return Double.valueOf(dNextDouble * d2.doubleValue());
            }
            return Double.valueOf(d2.doubleValue() + (dNextDouble * (1.0d - d2.doubleValue())));
        }
        return Double.valueOf(dNextDouble);
    }

    public static TracesSamplingDecision backfilledSampleRand(TracesSamplingDecision tracesSamplingDecision) {
        if (tracesSamplingDecision.getSampleRand() != null) {
            return tracesSamplingDecision;
        }
        return new TracesSamplingDecision(tracesSamplingDecision.getSampled(), tracesSamplingDecision.getSampleRate(), backfilledSampleRand(null, tracesSamplingDecision.getSampleRate(), tracesSamplingDecision.getSampled()), tracesSamplingDecision.getProfileSampled(), tracesSamplingDecision.getProfileSampleRate());
    }

    private static boolean isValidRate(Double d, boolean z) {
        if (d == null) {
            return z;
        }
        return !d.isNaN() && d.doubleValue() >= 0.0d && d.doubleValue() <= 1.0d;
    }
}
