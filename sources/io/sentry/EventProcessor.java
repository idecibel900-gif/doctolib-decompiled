package io.sentry;

import io.sentry.protocol.SentryTransaction;

/* JADX INFO: loaded from: classes5.dex */
public interface EventProcessor {
    SentryEvent process(SentryEvent sentryEvent, Hint hint);

    default SentryReplayEvent process(SentryReplayEvent sentryReplayEvent, Hint hint) {
        return sentryReplayEvent;
    }

    default SentryTransaction process(SentryTransaction sentryTransaction, Hint hint) {
        return sentryTransaction;
    }
}
