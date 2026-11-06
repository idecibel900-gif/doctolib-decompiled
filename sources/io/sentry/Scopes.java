package io.sentry;

import io.sentry.clientreport.DiscardReason;
import io.sentry.clientreport.IClientReportRecorder;
import io.sentry.hints.SessionEndHint;
import io.sentry.hints.SessionStartHint;
import io.sentry.logger.ILoggerApi;
import io.sentry.logger.LoggerApi;
import io.sentry.metrics.IMetricsApi;
import io.sentry.metrics.MetricsApi;
import io.sentry.protocol.Feedback;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentryTransaction;
import io.sentry.transport.RateLimiter;
import io.sentry.util.HintUtils;
import io.sentry.util.Objects;
import io.sentry.util.SpanUtils;
import java.io.Closeable;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes5.dex */
public final class Scopes implements IScopes {
    private final CombinedScopeView combinedScope;
    private final CompositePerformanceCollector compositePerformanceCollector;
    private final String creator;
    private final IFeedbackApi feedbackApi;
    private final IScope globalScope;
    private final IScope isolationScope;
    private final ILoggerApi logger;
    private final IMetricsApi metrics;
    private final Scopes parentScopes;
    private final IScope scope;

    public Scopes(IScope iScope, IScope iScope2, IScope iScope3, String str) {
        this(iScope, iScope2, iScope3, null, str);
    }

    private Scopes(IScope iScope, IScope iScope2, IScope iScope3, Scopes scopes, String str) {
        this.combinedScope = new CombinedScopeView(iScope3, iScope2, iScope);
        this.scope = iScope;
        this.isolationScope = iScope2;
        this.globalScope = iScope3;
        this.parentScopes = scopes;
        this.creator = str;
        SentryOptions options = getOptions();
        validateOptions(options);
        this.compositePerformanceCollector = options.getCompositePerformanceCollector();
        this.logger = new LoggerApi(this);
        this.metrics = new MetricsApi(this);
        this.feedbackApi = new FeedbackApi(this);
    }

    @Override // io.sentry.IScopes
    public IScope getScope() {
        return this.scope;
    }

    @Override // io.sentry.IScopes
    public IScope getGlobalScope() {
        return this.globalScope;
    }

    @Override // io.sentry.IScopes
    public IScopes forkedScopes(String str) {
        return new Scopes(this.scope.m5135clone(), this.isolationScope.m5135clone(), this.globalScope, this, str);
    }

    @Override // io.sentry.IScopes
    public boolean isEnabled() {
        return getClient().isEnabled();
    }

    @Override // io.sentry.IScopes
    public SentryId captureEvent(SentryEvent sentryEvent, Hint hint) {
        return captureEventInternal(sentryEvent, hint, null);
    }

    private SentryId captureEventInternal(SentryEvent sentryEvent, Hint hint, ScopeCallback scopeCallback) {
        SentryId sentryIdCaptureEvent = SentryId.EMPTY_ID;
        if (!isEnabled()) {
            getOptions().getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'captureEvent' call is a no-op.", new Object[0]);
            return sentryIdCaptureEvent;
        }
        if (sentryEvent == null) {
            getOptions().getLogger().log(SentryLevel.WARNING, "captureEvent called with null parameter.", new Object[0]);
            return sentryIdCaptureEvent;
        }
        try {
            assignTraceContext(sentryEvent);
            sentryIdCaptureEvent = getClient().captureEvent(sentryEvent, buildLocalScope(getCombinedScopeView(), scopeCallback), hint);
            updateLastEventId(sentryIdCaptureEvent);
            return sentryIdCaptureEvent;
        } catch (Throwable th) {
            getOptions().getLogger().log(SentryLevel.ERROR, "Error while capturing event with id: " + sentryEvent.getEventId(), th);
            return sentryIdCaptureEvent;
        }
    }

    public ISentryClient getClient() {
        return getCombinedScopeView().getClient();
    }

    private void assignTraceContext(SentryEvent sentryEvent) {
        getCombinedScopeView().assignTraceContext(sentryEvent);
    }

    private IScope buildLocalScope(IScope iScope, ScopeCallback scopeCallback) {
        if (scopeCallback != null) {
            try {
                IScope iScopeM5135clone = iScope.m5135clone();
                scopeCallback.run(iScopeM5135clone);
                return iScopeM5135clone;
            } catch (Throwable th) {
                getOptions().getLogger().log(SentryLevel.ERROR, "Error in the 'ScopeCallback' callback.", th);
            }
        }
        return iScope;
    }

    @Override // io.sentry.IScopes
    public SentryId captureFeedback(Feedback feedback, Hint hint, ScopeCallback scopeCallback) {
        SentryId sentryId = SentryId.EMPTY_ID;
        if (!isEnabled()) {
            getOptions().getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'captureFeedback' call is a no-op.", new Object[0]);
        } else if (feedback.getMessage().isEmpty()) {
            getOptions().getLogger().log(SentryLevel.WARNING, "captureFeedback called with empty message.", new Object[0]);
        } else {
            try {
                return getClient().captureFeedback(feedback, hint, buildLocalScope(getCombinedScopeView(), scopeCallback));
            } catch (Throwable th) {
                getOptions().getLogger().log(SentryLevel.ERROR, "Error while capturing feedback: " + feedback.getMessage(), th);
            }
        }
        return sentryId;
    }

    @Override // io.sentry.IScopes
    public SentryId captureEnvelope(SentryEnvelope sentryEnvelope, Hint hint) {
        Objects.requireNonNull(sentryEnvelope, "SentryEnvelope is required.");
        SentryId sentryId = SentryId.EMPTY_ID;
        if (!isEnabled()) {
            getOptions().getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'captureEnvelope' call is a no-op.", new Object[0]);
        } else {
            try {
                SentryId sentryIdCaptureEnvelope = getClient().captureEnvelope(sentryEnvelope, hint);
                if (sentryIdCaptureEnvelope != null) {
                    return sentryIdCaptureEnvelope;
                }
            } catch (Throwable th) {
                getOptions().getLogger().log(SentryLevel.ERROR, "Error while capturing envelope.", th);
            }
        }
        return sentryId;
    }

    @Override // io.sentry.IScopes
    public SentryId captureException(Throwable th, Hint hint) {
        return captureExceptionInternal(th, hint, null);
    }

    private SentryId captureExceptionInternal(Throwable th, Hint hint, ScopeCallback scopeCallback) {
        SentryId sentryIdCaptureEvent = SentryId.EMPTY_ID;
        if (!isEnabled()) {
            getOptions().getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'captureException' call is a no-op.", new Object[0]);
        } else if (th == null) {
            getOptions().getLogger().log(SentryLevel.WARNING, "captureException called with null parameter.", new Object[0]);
        } else {
            try {
                SentryEvent sentryEvent = new SentryEvent(th);
                assignTraceContext(sentryEvent);
                sentryIdCaptureEvent = getClient().captureEvent(sentryEvent, buildLocalScope(getCombinedScopeView(), scopeCallback), hint);
            } catch (Throwable th2) {
                getOptions().getLogger().log(SentryLevel.ERROR, "Error while capturing exception: " + th.getMessage(), th2);
            }
        }
        updateLastEventId(sentryIdCaptureEvent);
        return sentryIdCaptureEvent;
    }

    @Override // io.sentry.IScopes
    public void startSession() {
        if (!isEnabled()) {
            getOptions().getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'startSession' call is a no-op.", new Object[0]);
            return;
        }
        Scope.SessionPair sessionPairStartSession = getCombinedScopeView().startSession();
        if (sessionPairStartSession != null) {
            if (sessionPairStartSession.getPrevious() != null) {
                getClient().captureSession(sessionPairStartSession.getPrevious(), HintUtils.createWithTypeCheckHint(new SessionEndHint()));
            }
            getClient().captureSession(sessionPairStartSession.getCurrent(), HintUtils.createWithTypeCheckHint(new SessionStartHint()));
            return;
        }
        getOptions().getLogger().log(SentryLevel.WARNING, "Session could not be started.", new Object[0]);
    }

    @Override // io.sentry.IScopes
    public void endSession() {
        if (!isEnabled()) {
            getOptions().getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'endSession' call is a no-op.", new Object[0]);
            return;
        }
        Session sessionEndSession = getCombinedScopeView().endSession();
        if (sessionEndSession != null) {
            getClient().captureSession(sessionEndSession, HintUtils.createWithTypeCheckHint(new SessionEndHint()));
        }
    }

    public IScope getCombinedScopeView() {
        return this.combinedScope;
    }

    @Override // io.sentry.IScopes
    public void close(final boolean z) {
        if (!isEnabled()) {
            getOptions().getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'close' call is a no-op.", new Object[0]);
            return;
        }
        try {
            for (Integration integration : getOptions().getIntegrations()) {
                if (integration instanceof Closeable) {
                    try {
                        ((Closeable) integration).close();
                    } catch (Throwable th) {
                        getOptions().getLogger().log(SentryLevel.WARNING, "Failed to close the integration {}.", integration, th);
                    }
                }
            }
            for (EventProcessor eventProcessor : getOptions().getEventProcessors()) {
                if (eventProcessor instanceof Closeable) {
                    try {
                        ((Closeable) eventProcessor).close();
                    } catch (Throwable th2) {
                        getOptions().getLogger().log(SentryLevel.WARNING, "Failed to close the event processor {}.", eventProcessor, th2);
                    }
                }
            }
            configureScope(new ScopeCallback() { // from class: io.sentry.Scopes$$ExternalSyntheticLambda0
                @Override // io.sentry.ScopeCallback
                public final void run(IScope iScope) {
                    iScope.clear();
                }
            });
            configureScope(ScopeType.ISOLATION, new ScopeCallback() { // from class: io.sentry.Scopes$$ExternalSyntheticLambda1
                @Override // io.sentry.ScopeCallback
                public final void run(IScope iScope) {
                    iScope.clear();
                }
            });
            getOptions().getBackpressureMonitor().close();
            getOptions().getTransactionProfiler().close();
            getOptions().getContinuousProfiler().close(true);
            getOptions().getCompositePerformanceCollector().close();
            getOptions().getConnectionStatusProvider().close();
            final ISentryExecutorService executorService = getOptions().getExecutorService();
            if (z) {
                try {
                    executorService.submit(new Runnable() { // from class: io.sentry.Scopes$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            executorService.close(this.f$0.getOptions().getShutdownTimeoutMillis());
                        }
                    });
                } catch (RejectedExecutionException e) {
                    getOptions().getLogger().log(SentryLevel.WARNING, "Failed to submit executor service shutdown task during restart. Shutting down synchronously.", e);
                    executorService.close(getOptions().getShutdownTimeoutMillis());
                }
            } else {
                executorService.close(getOptions().getShutdownTimeoutMillis());
            }
            configureScope(ScopeType.CURRENT, new ScopeCallback() { // from class: io.sentry.Scopes$$ExternalSyntheticLambda3
                @Override // io.sentry.ScopeCallback
                public final void run(IScope iScope) {
                    iScope.getClient().close(z);
                }
            });
            configureScope(ScopeType.ISOLATION, new ScopeCallback() { // from class: io.sentry.Scopes$$ExternalSyntheticLambda4
                @Override // io.sentry.ScopeCallback
                public final void run(IScope iScope) {
                    iScope.getClient().close(z);
                }
            });
            configureScope(ScopeType.GLOBAL, new ScopeCallback() { // from class: io.sentry.Scopes$$ExternalSyntheticLambda5
                @Override // io.sentry.ScopeCallback
                public final void run(IScope iScope) {
                    iScope.getClient().close(z);
                }
            });
        } catch (Throwable th3) {
            getOptions().getLogger().log(SentryLevel.ERROR, "Error while closing the Scopes.", th3);
        }
    }

    @Override // io.sentry.IScopes
    public void addBreadcrumb(Breadcrumb breadcrumb, Hint hint) {
        if (!isEnabled()) {
            getOptions().getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'addBreadcrumb' call is a no-op.", new Object[0]);
        } else if (breadcrumb == null) {
            getOptions().getLogger().log(SentryLevel.WARNING, "addBreadcrumb called with null parameter.", new Object[0]);
        } else {
            getCombinedScopeView().addBreadcrumb(breadcrumb, hint);
        }
    }

    @Override // io.sentry.IScopes
    public void addBreadcrumb(Breadcrumb breadcrumb) {
        addBreadcrumb(breadcrumb, new Hint());
    }

    private void updateLastEventId(SentryId sentryId) {
        getCombinedScopeView().setLastEventId(sentryId);
    }

    @Override // io.sentry.IScopes
    public void configureScope(ScopeType scopeType, ScopeCallback scopeCallback) {
        if (!isEnabled()) {
            getOptions().getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'configureScope' call is a no-op.", new Object[0]);
            return;
        }
        try {
            scopeCallback.run(this.combinedScope.getSpecificScope(scopeType));
        } catch (Throwable th) {
            getOptions().getLogger().log(SentryLevel.ERROR, "Error in the 'configureScope' callback.", th);
        }
    }

    @Override // io.sentry.IScopes
    public boolean isHealthy() {
        return getClient().isHealthy();
    }

    @Override // io.sentry.IScopes
    public void flush(long j) {
        if (!isEnabled()) {
            getOptions().getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'flush' call is a no-op.", new Object[0]);
            return;
        }
        try {
            getClient().flush(j);
        } catch (Throwable th) {
            getOptions().getLogger().log(SentryLevel.ERROR, "Error in the 'client.flush'.", th);
        }
    }

    @Override // io.sentry.IScopes
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public IHub m5149clone() {
        if (!isEnabled()) {
            getOptions().getLogger().log(SentryLevel.WARNING, "Disabled Scopes cloned.", new Object[0]);
        }
        return new HubScopesWrapper(forkedScopes("scopes clone"));
    }

    @Override // io.sentry.IScopes
    public SentryId captureTransaction(SentryTransaction sentryTransaction, TraceContext traceContext, Hint hint, ProfilingTraceData profilingTraceData) {
        SentryTransaction sentryTransaction2;
        Objects.requireNonNull(sentryTransaction, "transaction is required");
        SentryId sentryId = SentryId.EMPTY_ID;
        if (!isEnabled()) {
            getOptions().getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'captureTransaction' call is a no-op.", new Object[0]);
        } else if (!sentryTransaction.isFinished()) {
            getOptions().getLogger().log(SentryLevel.WARNING, "Transaction: %s is not finished and this 'captureTransaction' call is a no-op.", sentryTransaction.getEventId());
        } else if (!Boolean.TRUE.equals(Boolean.valueOf(sentryTransaction.isSampled()))) {
            getOptions().getLogger().log(SentryLevel.DEBUG, "Transaction %s was dropped due to sampling decision.", sentryTransaction.getEventId());
            if (getOptions().getBackpressureMonitor().getDownsampleFactor() > 0) {
                IClientReportRecorder clientReportRecorder = getOptions().getClientReportRecorder();
                DiscardReason discardReason = DiscardReason.BACKPRESSURE;
                clientReportRecorder.recordLostEvent(discardReason, DataCategory.Transaction);
                getOptions().getClientReportRecorder().recordLostEvent(discardReason, DataCategory.Span, sentryTransaction.getSpans().size() + 1);
            } else {
                IClientReportRecorder clientReportRecorder2 = getOptions().getClientReportRecorder();
                DiscardReason discardReason2 = DiscardReason.SAMPLE_RATE;
                clientReportRecorder2.recordLostEvent(discardReason2, DataCategory.Transaction);
                getOptions().getClientReportRecorder().recordLostEvent(discardReason2, DataCategory.Span, sentryTransaction.getSpans().size() + 1);
            }
        } else {
            try {
                sentryTransaction2 = sentryTransaction;
                try {
                    return getClient().captureTransaction(sentryTransaction2, traceContext, getCombinedScopeView(), hint, profilingTraceData);
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    getOptions().getLogger().log(SentryLevel.ERROR, "Error while capturing transaction with id: " + sentryTransaction2.getEventId(), th2);
                    return sentryId;
                }
            } catch (Throwable th3) {
                th = th3;
                sentryTransaction2 = sentryTransaction;
            }
        }
        return sentryId;
    }

    @Override // io.sentry.IScopes
    public SentryId captureProfileChunk(ProfileChunk profileChunk) {
        Objects.requireNonNull(profileChunk, "profilingContinuousData is required");
        SentryId sentryId = SentryId.EMPTY_ID;
        if (!isEnabled()) {
            getOptions().getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'captureTransaction' call is a no-op.", new Object[0]);
        } else {
            try {
                return getClient().captureProfileChunk(profileChunk, getScope());
            } catch (Throwable th) {
                getOptions().getLogger().log(SentryLevel.ERROR, "Error while capturing profile chunk with id: " + profileChunk.getChunkId(), th);
            }
        }
        return sentryId;
    }

    @Override // io.sentry.IScopes
    public ITransaction startTransaction(TransactionContext transactionContext, TransactionOptions transactionOptions) {
        return createTransaction(transactionContext, transactionOptions);
    }

    private ITransaction createTransaction(TransactionContext transactionContext, TransactionOptions transactionOptions) {
        ITransaction iTransactionCreateTransaction;
        Objects.requireNonNull(transactionContext, "transactionContext is required");
        transactionContext.setOrigin(transactionOptions.getOrigin());
        if (!isEnabled()) {
            getOptions().getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'startTransaction' returns a no-op.", new Object[0]);
            iTransactionCreateTransaction = NoOpTransaction.getInstance();
        } else if (SpanUtils.isIgnored(getOptions().getIgnoredSpanOrigins(), transactionContext.getOrigin())) {
            getOptions().getLogger().log(SentryLevel.DEBUG, "Returning no-op for span origin %s as the SDK has been configured to ignore it", transactionContext.getOrigin());
            iTransactionCreateTransaction = NoOpTransaction.getInstance();
        } else if (!getOptions().getInstrumenter().equals(transactionContext.getInstrumenter())) {
            getOptions().getLogger().log(SentryLevel.DEBUG, "Returning no-op for instrumenter %s as the SDK has been configured to use instrumenter %s", transactionContext.getInstrumenter(), getOptions().getInstrumenter());
            iTransactionCreateTransaction = NoOpTransaction.getInstance();
        } else if (!getOptions().isTracingEnabled()) {
            getOptions().getLogger().log(SentryLevel.INFO, "Tracing is disabled and this 'startTransaction' returns a no-op.", new Object[0]);
            iTransactionCreateTransaction = NoOpTransaction.getInstance();
        } else {
            Double sampleRand = getSampleRand(transactionContext);
            transactionOptions.getCustomSamplingContext();
            TracesSamplingDecision tracesSamplingDecisionSample = getOptions().getInternalTracesSampler().sample(new SamplingContext(transactionContext, null, sampleRand, null));
            transactionContext.setSamplingDecision(tracesSamplingDecisionSample);
            ISpanFactory spanFactory = transactionOptions.getSpanFactory();
            if (spanFactory == null) {
                spanFactory = getOptions().getSpanFactory();
            }
            if (tracesSamplingDecisionSample.getSampled().booleanValue() && getOptions().isContinuousProfilingEnabled()) {
                ProfileLifecycle profileLifecycle = getOptions().getProfileLifecycle();
                ProfileLifecycle profileLifecycle2 = ProfileLifecycle.TRACE;
                if (profileLifecycle == profileLifecycle2 && transactionContext.getProfilerId().equals(SentryId.EMPTY_ID)) {
                    getOptions().getContinuousProfiler().startProfiler(profileLifecycle2, getOptions().getInternalTracesSampler());
                }
            }
            iTransactionCreateTransaction = spanFactory.createTransaction(transactionContext, this, transactionOptions, this.compositePerformanceCollector);
            if (tracesSamplingDecisionSample.getSampled().booleanValue() && tracesSamplingDecisionSample.getProfileSampled().booleanValue()) {
                ITransactionProfiler transactionProfiler = getOptions().getTransactionProfiler();
                if (!transactionProfiler.isRunning()) {
                    transactionProfiler.start();
                    transactionProfiler.bindTransaction(iTransactionCreateTransaction);
                } else if (transactionOptions.isAppStartTransaction()) {
                    transactionProfiler.bindTransaction(iTransactionCreateTransaction);
                }
            }
        }
        if (transactionOptions.isBindToScope()) {
            iTransactionCreateTransaction.makeCurrent();
        }
        return iTransactionCreateTransaction;
    }

    private Double getSampleRand(TransactionContext transactionContext) {
        Double sampleRand;
        Baggage baggage = transactionContext.getBaggage();
        return (baggage == null || (sampleRand = baggage.getSampleRand()) == null) ? getCombinedScopeView().getPropagationContext().getSampleRand() : sampleRand;
    }

    @Override // io.sentry.IScopes
    public void setSpanContext(Throwable th, ISpan iSpan, String str) {
        getCombinedScopeView().setSpanContext(th, iSpan, str);
    }

    @Override // io.sentry.IScopes
    public ITransaction getTransaction() {
        if (!isEnabled()) {
            getOptions().getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'getTransaction' call is a no-op.", new Object[0]);
            return null;
        }
        return getCombinedScopeView().getTransaction();
    }

    @Override // io.sentry.IScopes
    public SentryOptions getOptions() {
        return this.combinedScope.getOptions();
    }

    @Override // io.sentry.IScopes
    public Boolean isCrashedLastRun() {
        return SentryCrashLastRunState.getInstance().isCrashedLastRun(getOptions().getCacheDirPath(), !getOptions().isEnableAutoSessionTracking());
    }

    @Override // io.sentry.IScopes
    public SentryId captureReplay(SentryReplayEvent sentryReplayEvent, Hint hint) {
        SentryId sentryId = SentryId.EMPTY_ID;
        if (!isEnabled()) {
            getOptions().getLogger().log(SentryLevel.WARNING, "Instance is disabled and this 'captureReplay' call is a no-op.", new Object[0]);
        } else {
            try {
                return getClient().captureReplayEvent(sentryReplayEvent, getCombinedScopeView(), hint);
            } catch (Throwable th) {
                getOptions().getLogger().log(SentryLevel.ERROR, "Error while capturing replay", th);
            }
        }
        return sentryId;
    }

    @Override // io.sentry.IScopes
    public RateLimiter getRateLimiter() {
        return getClient().getRateLimiter();
    }

    @Override // io.sentry.IScopes
    public IFeedbackApi feedback() {
        return this.feedbackApi;
    }

    private static void validateOptions(SentryOptions sentryOptions) {
        Objects.requireNonNull(sentryOptions, "SentryOptions is required.");
        if (sentryOptions.getDsn() == null || sentryOptions.getDsn().isEmpty()) {
            throw new IllegalArgumentException("Scopes requires a DSN to be instantiated. Considering using the NoOpScopes if no DSN is available.");
        }
    }
}
