package io.sentry;

import io.sentry.protocol.Feedback;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentryTransaction;
import io.sentry.transport.RateLimiter;

/* JADX INFO: loaded from: classes5.dex */
public interface IScopes {
    void addBreadcrumb(Breadcrumb breadcrumb);

    void addBreadcrumb(Breadcrumb breadcrumb, Hint hint);

    SentryId captureEnvelope(SentryEnvelope sentryEnvelope, Hint hint);

    SentryId captureEvent(SentryEvent sentryEvent, Hint hint);

    SentryId captureException(Throwable th, Hint hint);

    SentryId captureFeedback(Feedback feedback, Hint hint, ScopeCallback scopeCallback);

    SentryId captureProfileChunk(ProfileChunk profileChunk);

    SentryId captureReplay(SentryReplayEvent sentryReplayEvent, Hint hint);

    SentryId captureTransaction(SentryTransaction sentryTransaction, TraceContext traceContext, Hint hint, ProfilingTraceData profilingTraceData);

    IHub clone();

    void close(boolean z);

    void configureScope(ScopeType scopeType, ScopeCallback scopeCallback);

    void endSession();

    IFeedbackApi feedback();

    void flush(long j);

    IScopes forkedScopes(String str);

    IScope getGlobalScope();

    SentryOptions getOptions();

    RateLimiter getRateLimiter();

    IScope getScope();

    ITransaction getTransaction();

    Boolean isCrashedLastRun();

    boolean isEnabled();

    boolean isHealthy();

    default boolean isNoOp() {
        return false;
    }

    void setSpanContext(Throwable th, ISpan iSpan, String str);

    void startSession();

    ITransaction startTransaction(TransactionContext transactionContext, TransactionOptions transactionOptions);

    default SentryId captureFeedback(Feedback feedback) {
        return captureFeedback(feedback, null);
    }

    default SentryId captureFeedback(Feedback feedback, Hint hint) {
        return captureFeedback(feedback, hint, null);
    }

    default SentryId captureEnvelope(SentryEnvelope sentryEnvelope) {
        return captureEnvelope(sentryEnvelope, new Hint());
    }

    default SentryId captureException(Throwable th) {
        return captureException(th, new Hint());
    }

    default void configureScope(ScopeCallback scopeCallback) {
        configureScope(null, scopeCallback);
    }

    default SentryId captureTransaction(SentryTransaction sentryTransaction, TraceContext traceContext, Hint hint) {
        return captureTransaction(sentryTransaction, traceContext, hint, null);
    }
}
