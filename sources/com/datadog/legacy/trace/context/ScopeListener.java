package com.datadog.legacy.trace.context;

/* JADX INFO: loaded from: classes3.dex */
public interface ScopeListener {
    void afterScopeActivated();

    void afterScopeClosed();
}
