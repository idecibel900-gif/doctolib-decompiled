package io.sentry;

/* JADX INFO: loaded from: classes5.dex */
public class SpanOptions {
    private SentryDate startTimestamp = null;
    private ScopeBindingMode scopeBindingMode = ScopeBindingMode.AUTO;
    private boolean trimStart = false;
    private boolean trimEnd = false;
    private boolean isIdle = false;
    protected String origin = "manual";

    public SentryDate getStartTimestamp() {
        return this.startTimestamp;
    }

    public void setStartTimestamp(SentryDate sentryDate) {
        this.startTimestamp = sentryDate;
    }

    public boolean isTrimStart() {
        return this.trimStart;
    }

    public boolean isTrimEnd() {
        return this.trimEnd;
    }

    public boolean isIdle() {
        return this.isIdle;
    }

    public void setTrimEnd(boolean z) {
        this.trimEnd = z;
    }

    public String getOrigin() {
        return this.origin;
    }

    public void setOrigin(String str) {
        this.origin = str;
    }

    public ScopeBindingMode getScopeBindingMode() {
        return this.scopeBindingMode;
    }
}
