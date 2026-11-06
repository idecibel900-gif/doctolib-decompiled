package io.sentry;

import io.sentry.protocol.Feedback;
import io.sentry.protocol.SentryId;

/* JADX INFO: loaded from: classes5.dex */
public final class NoOpFeedbackApi implements IFeedbackApi {
    private static final NoOpFeedbackApi instance = new NoOpFeedbackApi();

    private NoOpFeedbackApi() {
    }

    public static NoOpFeedbackApi getInstance() {
        return instance;
    }

    @Override // io.sentry.IFeedbackApi
    public SentryId capture(Feedback feedback) {
        return SentryId.EMPTY_ID;
    }

    @Override // io.sentry.IFeedbackApi
    public SentryId capture(Feedback feedback, Hint hint) {
        return SentryId.EMPTY_ID;
    }

    @Override // io.sentry.IFeedbackApi
    public SentryId capture(Feedback feedback, Hint hint, ScopeCallback scopeCallback) {
        return SentryId.EMPTY_ID;
    }
}
