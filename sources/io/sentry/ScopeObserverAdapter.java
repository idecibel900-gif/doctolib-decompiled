package io.sentry;

import io.sentry.protocol.Contexts;
import io.sentry.protocol.SentryId;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ScopeObserverAdapter implements IScopeObserver {
    @Override // io.sentry.IScopeObserver
    public void clearAttachments() {
    }

    @Override // io.sentry.IScopeObserver
    public void removeExtra(String str) {
    }

    @Override // io.sentry.IScopeObserver
    public void removeTag(String str) {
    }

    @Override // io.sentry.IScopeObserver
    public void setBreadcrumbs(Collection collection) {
    }

    @Override // io.sentry.IScopeObserver
    public void setContexts(Contexts contexts) {
    }

    @Override // io.sentry.IScopeObserver
    public void setExtra(String str, String str2) {
    }

    @Override // io.sentry.IScopeObserver
    public void setExtras(Map map) {
    }

    @Override // io.sentry.IScopeObserver
    public void setReplayId(SentryId sentryId) {
    }

    @Override // io.sentry.IScopeObserver
    public void setTag(String str, String str2) {
    }

    @Override // io.sentry.IScopeObserver
    public void setTags(Map map) {
    }

    @Override // io.sentry.IScopeObserver
    public void setTransaction(String str) {
    }
}
