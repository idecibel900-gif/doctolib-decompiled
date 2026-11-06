package io.sentry;

import io.sentry.protocol.Feedback;
import io.sentry.protocol.SentryId;

/* JADX INFO: loaded from: classes5.dex */
public interface IFeedbackApi {
    SentryId capture(Feedback feedback);

    SentryId capture(Feedback feedback, Hint hint);

    SentryId capture(Feedback feedback, Hint hint, ScopeCallback scopeCallback);
}
