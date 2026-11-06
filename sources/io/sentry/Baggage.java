package io.sentry;

import io.sentry.protocol.SentryId;
import io.sentry.protocol.TransactionNameSource;
import io.sentry.util.AutoClosableReentrantLock;
import io.sentry.util.SampleRateUtils;
import io.sentry.util.StringUtils;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public final class Baggage {
    private final ConcurrentHashMap keyValues;
    private final AutoClosableReentrantLock keyValuesLock;
    final ILogger logger;
    private boolean mutable;
    private Double sampleRand;
    private Double sampleRate;
    private final boolean shouldFreeze;
    private final String thirdPartyHeader;
    static final Integer MAX_BAGGAGE_STRING_LENGTH = 8192;
    static final Integer MAX_BAGGAGE_LIST_MEMBER_COUNT = 64;
    private static final DecimalFormatterThreadLocal decimalFormatter = new DecimalFormatterThreadLocal();

    public static final class DSCKeys {
        public static final List ALL = Arrays.asList("sentry-trace_id", "sentry-public_key", "sentry-release", "sentry-user_id", "sentry-environment", "sentry-transaction", "sentry-sample_rate", "sentry-sample_rand", "sentry-sampled", "sentry-replay_id", "sentry-org_id");
    }

    private static class DecimalFormatterThreadLocal extends ThreadLocal {
        private DecimalFormatterThreadLocal() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public DecimalFormat initialValue() {
            return new DecimalFormat("#.################", DecimalFormatSymbols.getInstance(Locale.ROOT));
        }
    }

    public static Baggage fromEvent(SentryBaseEvent sentryBaseEvent, String str, SentryOptions sentryOptions) {
        Baggage baggage = new Baggage(sentryOptions.getLogger());
        SpanContext trace = sentryBaseEvent.getContexts().getTrace();
        baggage.setTraceId(trace != null ? trace.getTraceId().toString() : null);
        baggage.setPublicKey(sentryOptions.retrieveParsedDsn().getPublicKey());
        baggage.setRelease(sentryBaseEvent.getRelease());
        baggage.setEnvironment(sentryBaseEvent.getEnvironment());
        baggage.setOrgId(sentryOptions.getEffectiveOrgId());
        baggage.setTransaction(str);
        baggage.setSampleRate(null);
        baggage.setSampled(null);
        baggage.setSampleRand(null);
        Object obj = sentryBaseEvent.getContexts().get("replay_id");
        if (obj != null && !obj.toString().equals(SentryId.EMPTY_ID.toString())) {
            baggage.setReplayId(obj.toString());
            sentryBaseEvent.getContexts().remove("replay_id");
        }
        baggage.freeze();
        return baggage;
    }

    public Baggage(ILogger iLogger) {
        this(new ConcurrentHashMap(), null, null, null, true, false, iLogger);
    }

    public Baggage(ConcurrentHashMap concurrentHashMap, Double d, Double d2, String str, boolean z, boolean z2, ILogger iLogger) {
        this.keyValuesLock = new AutoClosableReentrantLock();
        this.keyValues = concurrentHashMap;
        this.sampleRate = d;
        this.sampleRand = d2;
        this.logger = iLogger;
        this.thirdPartyHeader = str;
        this.mutable = z;
        this.shouldFreeze = z2;
    }

    public void freeze() {
        this.mutable = false;
    }

    public boolean isMutable() {
        return this.mutable;
    }

    public boolean isShouldFreeze() {
        return this.shouldFreeze;
    }

    public String get(String str) {
        if (str == null) {
            return null;
        }
        return (String) this.keyValues.get(str);
    }

    public String getTraceId() {
        return get("sentry-trace_id");
    }

    public void setTraceId(String str) {
        set("sentry-trace_id", str);
    }

    public String getPublicKey() {
        return get("sentry-public_key");
    }

    public void setPublicKey(String str) {
        set("sentry-public_key", str);
    }

    public String getEnvironment() {
        return get("sentry-environment");
    }

    public void setEnvironment(String str) {
        set("sentry-environment", str);
    }

    public String getRelease() {
        return get("sentry-release");
    }

    public void setRelease(String str) {
        set("sentry-release", str);
    }

    public String getUserId() {
        return get("sentry-user_id");
    }

    public String getTransaction() {
        return get("sentry-transaction");
    }

    public void setTransaction(String str) {
        set("sentry-transaction", str);
    }

    public Double getSampleRate() {
        return this.sampleRate;
    }

    public String getSampled() {
        return get("sentry-sampled");
    }

    public void setSampleRate(Double d) {
        if (isMutable()) {
            this.sampleRate = d;
        }
    }

    public void forceSetSampleRate(Double d) {
        this.sampleRate = d;
    }

    public Double getSampleRand() {
        return this.sampleRand;
    }

    public void setSampleRand(Double d) {
        if (isMutable()) {
            this.sampleRand = d;
        }
    }

    public void setSampled(String str) {
        set("sentry-sampled", str);
    }

    public String getReplayId() {
        return get("sentry-replay_id");
    }

    public void setReplayId(String str) {
        set("sentry-replay_id", str);
    }

    public void setOrgId(String str) {
        set("sentry-org_id", str);
    }

    public void set(String str, String str2) {
        if (this.mutable) {
            if (str2 == null) {
                this.keyValues.remove(str);
            } else {
                this.keyValues.put(str, str2);
            }
        }
    }

    public Map getUnknown() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.keyValuesLock.acquire();
        try {
            for (Map.Entry entry : this.keyValues.entrySet()) {
                String str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                if (!DSCKeys.ALL.contains(str) && str2 != null) {
                    concurrentHashMap.put(str.replaceFirst("sentry-", ""), str2);
                }
            }
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
            return concurrentHashMap;
        } catch (Throwable th) {
            if (iSentryLifecycleTokenAcquire != null) {
                try {
                    iSentryLifecycleTokenAcquire.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public void setValuesFromTransaction(SentryId sentryId, SentryId sentryId2, SentryOptions sentryOptions, TracesSamplingDecision tracesSamplingDecision, String str, TransactionNameSource transactionNameSource) {
        setTraceId(sentryId.toString());
        setPublicKey(sentryOptions.retrieveParsedDsn().getPublicKey());
        setRelease(sentryOptions.getRelease());
        setEnvironment(sentryOptions.getEnvironment());
        if (!isHighQualityTransactionName(transactionNameSource)) {
            str = null;
        }
        setTransaction(str);
        if (sentryId2 != null && !SentryId.EMPTY_ID.equals(sentryId2)) {
            setReplayId(sentryId2.toString());
        }
        setOrgId(sentryOptions.getEffectiveOrgId());
        setSampleRate(sampleRate(tracesSamplingDecision));
        setSampled(StringUtils.toString(sampled(tracesSamplingDecision)));
        setSampleRand(sampleRand(tracesSamplingDecision));
    }

    public void setValuesFromSamplingDecision(TracesSamplingDecision tracesSamplingDecision) {
        if (tracesSamplingDecision == null) {
            return;
        }
        setSampled(StringUtils.toString(sampled(tracesSamplingDecision)));
        if (tracesSamplingDecision.getSampleRand() != null) {
            setSampleRand(sampleRand(tracesSamplingDecision));
        }
        if (tracesSamplingDecision.getSampleRate() != null) {
            forceSetSampleRate(sampleRate(tracesSamplingDecision));
        }
    }

    public void setValuesFromScope(IScope iScope, SentryOptions sentryOptions) {
        PropagationContext propagationContext = iScope.getPropagationContext();
        SentryId replayId = iScope.getReplayId();
        setTraceId(propagationContext.getTraceId().toString());
        setPublicKey(sentryOptions.retrieveParsedDsn().getPublicKey());
        setRelease(sentryOptions.getRelease());
        setEnvironment(sentryOptions.getEnvironment());
        if (!SentryId.EMPTY_ID.equals(replayId)) {
            setReplayId(replayId.toString());
        }
        setOrgId(sentryOptions.getEffectiveOrgId());
        setTransaction(null);
        setSampleRate(null);
        setSampled(null);
    }

    private static Double sampleRate(TracesSamplingDecision tracesSamplingDecision) {
        if (tracesSamplingDecision == null) {
            return null;
        }
        return tracesSamplingDecision.getSampleRate();
    }

    private static Double sampleRand(TracesSamplingDecision tracesSamplingDecision) {
        if (tracesSamplingDecision == null) {
            return null;
        }
        return tracesSamplingDecision.getSampleRand();
    }

    private static String sampleRateToString(Double d) {
        if (SampleRateUtils.isValidTracesSampleRate(d, false)) {
            return ((DecimalFormat) decimalFormatter.get()).format(d);
        }
        return null;
    }

    private static Boolean sampled(TracesSamplingDecision tracesSamplingDecision) {
        if (tracesSamplingDecision == null) {
            return null;
        }
        return tracesSamplingDecision.getSampled();
    }

    private static boolean isHighQualityTransactionName(TransactionNameSource transactionNameSource) {
        return (transactionNameSource == null || TransactionNameSource.URL.equals(transactionNameSource)) ? false : true;
    }

    public TraceContext toTraceContext() {
        String traceId = getTraceId();
        String replayId = getReplayId();
        String publicKey = getPublicKey();
        if (traceId == null || publicKey == null) {
            return null;
        }
        SentryId sentryId = new SentryId(traceId);
        SentryId sentryId2 = null;
        String release = getRelease();
        String environment = getEnvironment();
        String userId = getUserId();
        String transaction = getTransaction();
        String strSampleRateToString = sampleRateToString(getSampleRate());
        String sampled = getSampled();
        if (replayId != null) {
            sentryId2 = new SentryId(replayId);
        }
        TraceContext traceContext = new TraceContext(sentryId, publicKey, release, environment, userId, transaction, strSampleRateToString, sampled, sentryId2, sampleRateToString(getSampleRand()));
        traceContext.setUnknown(getUnknown());
        return traceContext;
    }
}
