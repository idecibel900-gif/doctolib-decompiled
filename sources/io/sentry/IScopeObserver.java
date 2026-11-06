package io.sentry;

import io.sentry.protocol.Contexts;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.User;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public interface IScopeObserver {
    void addBreadcrumb(Breadcrumb breadcrumb);

    void clearAttachments();

    void removeExtra(String str);

    void removeTag(String str);

    void setBreadcrumbs(Collection collection);

    void setContexts(Contexts contexts);

    void setExtra(String str, String str2);

    void setExtras(Map map);

    void setReplayId(SentryId sentryId);

    void setTag(String str, String str2);

    void setTags(Map map);

    void setTrace(SpanContext spanContext, IScope iScope);

    void setTransaction(String str);

    void setUser(User user);
}
