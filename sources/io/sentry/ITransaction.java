package io.sentry;

import io.sentry.protocol.SentryId;

/* JADX INFO: loaded from: classes5.dex */
public interface ITransaction extends ISpan {
    void forceFinish(SpanStatus spanStatus, boolean z, Hint hint);

    SentryId getEventId();

    ISpan getLatestActiveSpan();

    String getName();

    void scheduleFinish();
}
