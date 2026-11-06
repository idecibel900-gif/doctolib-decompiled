package io.sentry;

import io.sentry.protocol.Feedback;
import io.sentry.protocol.SentryId;

/* JADX INFO: loaded from: classes5.dex */
final class FeedbackApi implements IFeedbackApi {
    private final IScopes scopes;

    FeedbackApi(IScopes iScopes) {
        this.scopes = iScopes;
    }

    @Override // io.sentry.IFeedbackApi
    public SentryId capture(Feedback feedback) {
        return this.scopes.captureFeedback(feedback);
    }

    @Override // io.sentry.IFeedbackApi
    public SentryId capture(Feedback feedback, Hint hint) {
        return this.scopes.captureFeedback(feedback, hint);
    }

    @Override // io.sentry.IFeedbackApi
    public SentryId capture(Feedback feedback, Hint hint, ScopeCallback scopeCallback) {
        return this.scopes.captureFeedback(feedback, hint, scopeCallback);
    }
}
