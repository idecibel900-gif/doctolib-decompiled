package io.sentry;

import io.sentry.protocol.Feedback;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentryTransaction;
import io.sentry.transport.RateLimiter;
import io.sentry.util.LazyEvaluator;

/* JADX INFO: loaded from: classes5.dex */
public final class NoOpScopes implements IScopes {
    private static final NoOpScopes instance = new NoOpScopes();
    private final LazyEvaluator emptyOptions = new LazyEvaluator(new LazyEvaluator.Evaluator() { // from class: io.sentry.NoOpScopes$$ExternalSyntheticLambda0
        @Override // io.sentry.util.LazyEvaluator.Evaluator
        public final Object evaluate() {
            return SentryOptions.empty();
        }
    });

    @Override // io.sentry.IScopes
    public void addBreadcrumb(Breadcrumb breadcrumb) {
    }

    @Override // io.sentry.IScopes
    public void addBreadcrumb(Breadcrumb breadcrumb, Hint hint) {
    }

    @Override // io.sentry.IScopes
    public void close(boolean z) {
    }

    @Override // io.sentry.IScopes
    public void configureScope(ScopeType scopeType, ScopeCallback scopeCallback) {
    }

    @Override // io.sentry.IScopes
    public void endSession() {
    }

    @Override // io.sentry.IScopes
    public void flush(long j) {
    }

    @Override // io.sentry.IScopes
    public RateLimiter getRateLimiter() {
        return null;
    }

    @Override // io.sentry.IScopes
    public ITransaction getTransaction() {
        return null;
    }

    @Override // io.sentry.IScopes
    public Boolean isCrashedLastRun() {
        return null;
    }

    @Override // io.sentry.IScopes
    public boolean isEnabled() {
        return false;
    }

    @Override // io.sentry.IScopes
    public boolean isHealthy() {
        return true;
    }

    @Override // io.sentry.IScopes
    public boolean isNoOp() {
        return true;
    }

    @Override // io.sentry.IScopes
    public void setSpanContext(Throwable th, ISpan iSpan, String str) {
    }

    @Override // io.sentry.IScopes
    public void startSession() {
    }

    private NoOpScopes() {
    }

    public static NoOpScopes getInstance() {
        return instance;
    }

    @Override // io.sentry.IScopes
    public SentryId captureEvent(SentryEvent sentryEvent, Hint hint) {
        return SentryId.EMPTY_ID;
    }

    @Override // io.sentry.IScopes
    public SentryId captureFeedback(Feedback feedback, Hint hint, ScopeCallback scopeCallback) {
        return SentryId.EMPTY_ID;
    }

    @Override // io.sentry.IScopes
    public SentryId captureEnvelope(SentryEnvelope sentryEnvelope, Hint hint) {
        return SentryId.EMPTY_ID;
    }

    @Override // io.sentry.IScopes
    public SentryId captureException(Throwable th, Hint hint) {
        return SentryId.EMPTY_ID;
    }

    @Override // io.sentry.IScopes
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public IHub m5143clone() {
        return NoOpHub.getInstance();
    }

    @Override // io.sentry.IScopes
    public IScopes forkedScopes(String str) {
        return getInstance();
    }

    @Override // io.sentry.IScopes
    public IScope getScope() {
        return NoOpScope.getInstance();
    }

    @Override // io.sentry.IScopes
    public IScope getGlobalScope() {
        return NoOpScope.getInstance();
    }

    @Override // io.sentry.IScopes
    public SentryId captureTransaction(SentryTransaction sentryTransaction, TraceContext traceContext, Hint hint, ProfilingTraceData profilingTraceData) {
        return SentryId.EMPTY_ID;
    }

    @Override // io.sentry.IScopes
    public SentryId captureProfileChunk(ProfileChunk profileChunk) {
        return SentryId.EMPTY_ID;
    }

    @Override // io.sentry.IScopes
    public ITransaction startTransaction(TransactionContext transactionContext, TransactionOptions transactionOptions) {
        return NoOpTransaction.getInstance();
    }

    @Override // io.sentry.IScopes
    public SentryOptions getOptions() {
        return (SentryOptions) this.emptyOptions.getValue();
    }

    @Override // io.sentry.IScopes
    public SentryId captureReplay(SentryReplayEvent sentryReplayEvent, Hint hint) {
        return SentryId.EMPTY_ID;
    }

    @Override // io.sentry.IScopes
    public IFeedbackApi feedback() {
        return NoOpFeedbackApi.getInstance();
    }
}
