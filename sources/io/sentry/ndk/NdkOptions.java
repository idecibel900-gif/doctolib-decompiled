package io.sentry.ndk;

/* JADX INFO: loaded from: classes5.dex */
public final class NdkOptions {
    private final String dist;
    private final String dsn;
    private final String environment;
    private final boolean isDebug;
    private final int maxBreadcrumbs;
    private final String outboxPath;
    private final String release;
    private final String sdkName;
    private NdkHandlerStrategy ndkHandlerStrategy = NdkHandlerStrategy.SENTRY_HANDLER_STRATEGY_DEFAULT;
    private float tracesSampleRate = 0.0f;

    public NdkOptions(String str, boolean z, String str2, String str3, String str4, String str5, int i, String str6) {
        this.dsn = str;
        this.isDebug = z;
        this.outboxPath = str2;
        this.release = str3;
        this.environment = str4;
        this.dist = str5;
        this.maxBreadcrumbs = i;
        this.sdkName = str6;
    }

    public String getDsn() {
        return this.dsn;
    }

    public boolean isDebug() {
        return this.isDebug;
    }

    public String getOutboxPath() {
        return this.outboxPath;
    }

    public String getRelease() {
        return this.release;
    }

    public String getEnvironment() {
        return this.environment;
    }

    public String getDist() {
        return this.dist;
    }

    public int getMaxBreadcrumbs() {
        return this.maxBreadcrumbs;
    }

    public String getSdkName() {
        return this.sdkName;
    }

    public void setNdkHandlerStrategy(NdkHandlerStrategy ndkHandlerStrategy) {
        this.ndkHandlerStrategy = ndkHandlerStrategy;
    }

    public int getNdkHandlerStrategy() {
        return this.ndkHandlerStrategy.getValue();
    }

    public void setTracesSampleRate(float f) {
        this.tracesSampleRate = f;
    }

    public float getTracesSampleRate() {
        return this.tracesSampleRate;
    }
}
