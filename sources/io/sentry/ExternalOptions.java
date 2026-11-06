package io.sentry;

import io.sentry.config.PropertiesProvider;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes5.dex */
public final class ExternalOptions {
    private Boolean captureOpenTelemetryEvents;
    private SentryOptions.Cron cron;
    private Boolean debug;
    private String dist;
    private String dsn;
    private Boolean enableBackpressureHandling;
    private Boolean enableCacheTracing;
    private Boolean enableDatabaseTransactionTracing;
    private Boolean enableDeduplication;
    private Boolean enableLogs;
    private Boolean enableMetrics;
    private Boolean enablePrettySerializationOutput;
    private Boolean enableQueueTracing;
    private Boolean enableSpotlight;
    private Boolean enableUncaughtExceptionHandler;
    private Boolean enabled;
    private String environment;
    private Boolean forceInit;
    private Boolean globalHubMode;
    private Long idleTimeout;
    private List ignoredCheckIns;
    private List ignoredErrors;
    private List ignoredTransactions;
    private SentryOptions.RequestSize maxRequestBodySize;
    private String orgId;
    private Boolean printUncaughtStackTrace;
    private ProfileLifecycle profileLifecycle;
    private Double profileSessionSampleRate;
    private Double profilesSampleRate;
    private String profilingTracesDirPath;
    private String proguardUuid;
    private SentryOptions.Proxy proxy;
    private String release;
    private Double sampleRate;
    private Boolean sendClientReports;
    private Boolean sendDefaultPii;
    private Boolean sendModules;
    private String serverName;
    private Long sessionFlushTimeoutMillis;
    private Long shutdownTimeoutMillis;
    private String spotlightConnectionUrl;
    private Boolean strictTraceContinuation;
    private Double tracesSampleRate;
    private final Map tags = new ConcurrentHashMap();
    private final List inAppExcludes = new CopyOnWriteArrayList();
    private final List inAppIncludes = new CopyOnWriteArrayList();
    private List tracePropagationTargets = null;
    private final List contextTags = new CopyOnWriteArrayList();
    private final Set ignoredExceptionsForType = new CopyOnWriteArraySet();
    private Set bundleIds = new CopyOnWriteArraySet();

    public static ExternalOptions from(PropertiesProvider propertiesProvider, ILogger iLogger) {
        ExternalOptions externalOptions = new ExternalOptions();
        externalOptions.setDsn(propertiesProvider.getProperty("dsn"));
        externalOptions.setEnvironment(propertiesProvider.getProperty("environment"));
        externalOptions.setRelease(propertiesProvider.getProperty("release"));
        externalOptions.setDist(propertiesProvider.getProperty("dist"));
        externalOptions.setServerName(propertiesProvider.getProperty("servername"));
        externalOptions.setEnableUncaughtExceptionHandler(propertiesProvider.getBooleanProperty("uncaught.handler.enabled"));
        externalOptions.setPrintUncaughtStackTrace(propertiesProvider.getBooleanProperty("uncaught.handler.print-stacktrace"));
        externalOptions.setSampleRate(propertiesProvider.getDoubleProperty("sample-rate"));
        externalOptions.setTracesSampleRate(propertiesProvider.getDoubleProperty("traces-sample-rate"));
        externalOptions.setProfilesSampleRate(propertiesProvider.getDoubleProperty("profiles-sample-rate"));
        externalOptions.setDebug(propertiesProvider.getBooleanProperty("debug"));
        externalOptions.setEnableDeduplication(propertiesProvider.getBooleanProperty("enable-deduplication"));
        externalOptions.setSendClientReports(propertiesProvider.getBooleanProperty("send-client-reports"));
        externalOptions.setForceInit(propertiesProvider.getBooleanProperty("force-init"));
        String property = propertiesProvider.getProperty("max-request-body-size");
        if (property != null) {
            externalOptions.setMaxRequestBodySize(SentryOptions.RequestSize.valueOf(property.toUpperCase(Locale.ROOT)));
        }
        for (Map.Entry entry : propertiesProvider.getMap("tags").entrySet()) {
            externalOptions.setTag((String) entry.getKey(), (String) entry.getValue());
        }
        String property2 = propertiesProvider.getProperty("proxy.host");
        String property3 = propertiesProvider.getProperty("proxy.user");
        String property4 = propertiesProvider.getProperty("proxy.pass");
        String property5 = propertiesProvider.getProperty("proxy.port", "80");
        if (property2 != null) {
            externalOptions.setProxy(new SentryOptions.Proxy(property2, property5, property3, property4));
        }
        Iterator it = propertiesProvider.getList("in-app-includes").iterator();
        while (it.hasNext()) {
            externalOptions.addInAppInclude((String) it.next());
        }
        Iterator it2 = propertiesProvider.getList("in-app-excludes").iterator();
        while (it2.hasNext()) {
            externalOptions.addInAppExclude((String) it2.next());
        }
        List list = propertiesProvider.getProperty("trace-propagation-targets") != null ? propertiesProvider.getList("trace-propagation-targets") : null;
        if (list == null && propertiesProvider.getProperty("tracing-origins") != null) {
            list = propertiesProvider.getList("tracing-origins");
        }
        if (list != null) {
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                externalOptions.addTracePropagationTarget((String) it3.next());
            }
        }
        Iterator it4 = propertiesProvider.getList("context-tags").iterator();
        while (it4.hasNext()) {
            externalOptions.addContextTag((String) it4.next());
        }
        externalOptions.setProguardUuid(propertiesProvider.getProperty("proguard-uuid"));
        Iterator it5 = propertiesProvider.getList("bundle-ids").iterator();
        while (it5.hasNext()) {
            externalOptions.addBundleId((String) it5.next());
        }
        externalOptions.setIdleTimeout(propertiesProvider.getLongProperty("idle-timeout"));
        externalOptions.setShutdownTimeoutMillis(propertiesProvider.getLongProperty("shutdown-timeout-millis"));
        externalOptions.setSessionFlushTimeoutMillis(propertiesProvider.getLongProperty("session-flush-timeout-millis"));
        externalOptions.setIgnoredErrors(propertiesProvider.getListOrNull("ignored-errors"));
        externalOptions.setEnabled(propertiesProvider.getBooleanProperty("enabled"));
        externalOptions.setEnablePrettySerializationOutput(propertiesProvider.getBooleanProperty("enable-pretty-serialization-output"));
        externalOptions.setSendModules(propertiesProvider.getBooleanProperty("send-modules"));
        externalOptions.setSendDefaultPii(propertiesProvider.getBooleanProperty("send-default-pii"));
        externalOptions.setIgnoredCheckIns(propertiesProvider.getListOrNull("ignored-checkins"));
        externalOptions.setIgnoredTransactions(propertiesProvider.getListOrNull("ignored-transactions"));
        externalOptions.setEnableBackpressureHandling(propertiesProvider.getBooleanProperty("enable-backpressure-handling"));
        externalOptions.setEnableDatabaseTransactionTracing(propertiesProvider.getBooleanProperty("enable-database-transaction-tracing"));
        externalOptions.setEnableCacheTracing(propertiesProvider.getBooleanProperty("enable-cache-tracing"));
        externalOptions.setEnableQueueTracing(propertiesProvider.getBooleanProperty("enable-queue-tracing"));
        externalOptions.setGlobalHubMode(propertiesProvider.getBooleanProperty("global-hub-mode"));
        externalOptions.setCaptureOpenTelemetryEvents(propertiesProvider.getBooleanProperty("capture-open-telemetry-events"));
        externalOptions.setEnableLogs(propertiesProvider.getBooleanProperty("logs.enabled"));
        externalOptions.setEnableMetrics(propertiesProvider.getBooleanProperty("metrics.enabled"));
        for (String str : propertiesProvider.getList("ignored-exceptions-for-type")) {
            try {
                Class<?> cls = Class.forName(str);
                if (Throwable.class.isAssignableFrom(cls)) {
                    externalOptions.addIgnoredExceptionForType(cls);
                } else {
                    iLogger.log(SentryLevel.WARNING, "Skipping setting %s as ignored-exception-for-type. Reason: %s does not extend Throwable", str, str);
                }
            } catch (ClassNotFoundException unused) {
                iLogger.log(SentryLevel.WARNING, "Skipping setting %s as ignored-exception-for-type. Reason: %s class is not found", str, str);
            }
        }
        Long longProperty = propertiesProvider.getLongProperty("cron.default-checkin-margin");
        Long longProperty2 = propertiesProvider.getLongProperty("cron.default-max-runtime");
        String property6 = propertiesProvider.getProperty("cron.default-timezone");
        Long longProperty3 = propertiesProvider.getLongProperty("cron.default-failure-issue-threshold");
        Long longProperty4 = propertiesProvider.getLongProperty("cron.default-recovery-threshold");
        if (longProperty != null || longProperty2 != null || property6 != null || longProperty3 != null || longProperty4 != null) {
            SentryOptions.Cron cron = new SentryOptions.Cron();
            cron.setDefaultCheckinMargin(longProperty);
            cron.setDefaultMaxRuntime(longProperty2);
            cron.setDefaultTimezone(property6);
            cron.setDefaultFailureIssueThreshold(longProperty3);
            cron.setDefaultRecoveryThreshold(longProperty4);
            externalOptions.setCron(cron);
        }
        externalOptions.setStrictTraceContinuation(propertiesProvider.getBooleanProperty("enable-strict-trace-continuation"));
        externalOptions.setOrgId(propertiesProvider.getProperty("org-id"));
        externalOptions.setEnableSpotlight(propertiesProvider.getBooleanProperty("enable-spotlight"));
        externalOptions.setSpotlightConnectionUrl(propertiesProvider.getProperty("spotlight-connection-url"));
        externalOptions.setProfileSessionSampleRate(propertiesProvider.getDoubleProperty("profile-session-sample-rate"));
        externalOptions.setProfilingTracesDirPath(propertiesProvider.getProperty("profiling-traces-dir-path"));
        String property7 = propertiesProvider.getProperty("profile-lifecycle");
        if (property7 != null && !property7.isEmpty()) {
            externalOptions.setProfileLifecycle(ProfileLifecycle.valueOf(property7.toUpperCase()));
        }
        return externalOptions;
    }

    public String getDsn() {
        return this.dsn;
    }

    public void setDsn(String str) {
        this.dsn = str;
    }

    public String getEnvironment() {
        return this.environment;
    }

    public void setEnvironment(String str) {
        this.environment = str;
    }

    public String getRelease() {
        return this.release;
    }

    public void setRelease(String str) {
        this.release = str;
    }

    public String getDist() {
        return this.dist;
    }

    public void setDist(String str) {
        this.dist = str;
    }

    public String getServerName() {
        return this.serverName;
    }

    public void setServerName(String str) {
        this.serverName = str;
    }

    public Boolean getEnableUncaughtExceptionHandler() {
        return this.enableUncaughtExceptionHandler;
    }

    public void setEnableUncaughtExceptionHandler(Boolean bool) {
        this.enableUncaughtExceptionHandler = bool;
    }

    public List getTracePropagationTargets() {
        return this.tracePropagationTargets;
    }

    public Boolean getDebug() {
        return this.debug;
    }

    public void setDebug(Boolean bool) {
        this.debug = bool;
    }

    public Boolean getEnableDeduplication() {
        return this.enableDeduplication;
    }

    public void setEnableDeduplication(Boolean bool) {
        this.enableDeduplication = bool;
    }

    public Double getSampleRate() {
        return this.sampleRate;
    }

    public void setSampleRate(Double d) {
        this.sampleRate = d;
    }

    public Double getTracesSampleRate() {
        return this.tracesSampleRate;
    }

    public void setTracesSampleRate(Double d) {
        this.tracesSampleRate = d;
    }

    public Double getProfilesSampleRate() {
        return this.profilesSampleRate;
    }

    public void setProfilesSampleRate(Double d) {
        this.profilesSampleRate = d;
    }

    public SentryOptions.RequestSize getMaxRequestBodySize() {
        return this.maxRequestBodySize;
    }

    public void setMaxRequestBodySize(SentryOptions.RequestSize requestSize) {
        this.maxRequestBodySize = requestSize;
    }

    public Map getTags() {
        return this.tags;
    }

    public SentryOptions.Proxy getProxy() {
        return this.proxy;
    }

    public void setProxy(SentryOptions.Proxy proxy) {
        this.proxy = proxy;
    }

    public List getInAppExcludes() {
        return this.inAppExcludes;
    }

    public List getInAppIncludes() {
        return this.inAppIncludes;
    }

    public List getContextTags() {
        return this.contextTags;
    }

    public String getProguardUuid() {
        return this.proguardUuid;
    }

    public void setProguardUuid(String str) {
        this.proguardUuid = str;
    }

    public Set getIgnoredExceptionsForType() {
        return this.ignoredExceptionsForType;
    }

    public void addInAppInclude(String str) {
        this.inAppIncludes.add(str);
    }

    public void addInAppExclude(String str) {
        this.inAppExcludes.add(str);
    }

    public void addTracePropagationTarget(String str) {
        if (this.tracePropagationTargets == null) {
            this.tracePropagationTargets = new CopyOnWriteArrayList();
        }
        if (str.isEmpty()) {
            return;
        }
        this.tracePropagationTargets.add(str);
    }

    public void addContextTag(String str) {
        this.contextTags.add(str);
    }

    public void addIgnoredExceptionForType(Class cls) {
        this.ignoredExceptionsForType.add(cls);
    }

    public void setTag(String str, String str2) {
        this.tags.put(str, str2);
    }

    public Boolean getPrintUncaughtStackTrace() {
        return this.printUncaughtStackTrace;
    }

    public void setPrintUncaughtStackTrace(Boolean bool) {
        this.printUncaughtStackTrace = bool;
    }

    public Long getIdleTimeout() {
        return this.idleTimeout;
    }

    public void setIdleTimeout(Long l) {
        this.idleTimeout = l;
    }

    public Long getShutdownTimeoutMillis() {
        return this.shutdownTimeoutMillis;
    }

    public void setShutdownTimeoutMillis(Long l) {
        this.shutdownTimeoutMillis = l;
    }

    public Long getSessionFlushTimeoutMillis() {
        return this.sessionFlushTimeoutMillis;
    }

    public void setSessionFlushTimeoutMillis(Long l) {
        this.sessionFlushTimeoutMillis = l;
    }

    public List getIgnoredErrors() {
        return this.ignoredErrors;
    }

    public void setIgnoredErrors(List list) {
        this.ignoredErrors = list;
    }

    public Boolean getSendClientReports() {
        return this.sendClientReports;
    }

    public void setSendClientReports(Boolean bool) {
        this.sendClientReports = bool;
    }

    public Set getBundleIds() {
        return this.bundleIds;
    }

    public void addBundleId(String str) {
        this.bundleIds.add(str);
    }

    public Boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(Boolean bool) {
        this.enabled = bool;
    }

    public Boolean isEnablePrettySerializationOutput() {
        return this.enablePrettySerializationOutput;
    }

    public void setEnablePrettySerializationOutput(Boolean bool) {
        this.enablePrettySerializationOutput = bool;
    }

    public Boolean isSendModules() {
        return this.sendModules;
    }

    public void setSendModules(Boolean bool) {
        this.sendModules = bool;
    }

    public Boolean isSendDefaultPii() {
        return this.sendDefaultPii;
    }

    public void setSendDefaultPii(Boolean bool) {
        this.sendDefaultPii = bool;
    }

    public void setIgnoredCheckIns(List list) {
        this.ignoredCheckIns = list;
    }

    public List getIgnoredCheckIns() {
        return this.ignoredCheckIns;
    }

    public void setIgnoredTransactions(List list) {
        this.ignoredTransactions = list;
    }

    public List getIgnoredTransactions() {
        return this.ignoredTransactions;
    }

    public void setEnableBackpressureHandling(Boolean bool) {
        this.enableBackpressureHandling = bool;
    }

    public Boolean isEnableBackpressureHandling() {
        return this.enableBackpressureHandling;
    }

    public void setEnableDatabaseTransactionTracing(Boolean bool) {
        this.enableDatabaseTransactionTracing = bool;
    }

    public Boolean isEnableDatabaseTransactionTracing() {
        return this.enableDatabaseTransactionTracing;
    }

    public void setEnableCacheTracing(Boolean bool) {
        this.enableCacheTracing = bool;
    }

    public Boolean isEnableCacheTracing() {
        return this.enableCacheTracing;
    }

    public void setEnableQueueTracing(Boolean bool) {
        this.enableQueueTracing = bool;
    }

    public Boolean isEnableQueueTracing() {
        return this.enableQueueTracing;
    }

    public void setGlobalHubMode(Boolean bool) {
        this.globalHubMode = bool;
    }

    public Boolean isGlobalHubMode() {
        return this.globalHubMode;
    }

    public void setForceInit(Boolean bool) {
        this.forceInit = bool;
    }

    public Boolean isForceInit() {
        return this.forceInit;
    }

    public SentryOptions.Cron getCron() {
        return this.cron;
    }

    public void setCron(SentryOptions.Cron cron) {
        this.cron = cron;
    }

    public void setEnableSpotlight(Boolean bool) {
        this.enableSpotlight = bool;
    }

    public Boolean isEnableSpotlight() {
        return this.enableSpotlight;
    }

    public String getSpotlightConnectionUrl() {
        return this.spotlightConnectionUrl;
    }

    public void setSpotlightConnectionUrl(String str) {
        this.spotlightConnectionUrl = str;
    }

    public void setCaptureOpenTelemetryEvents(Boolean bool) {
        this.captureOpenTelemetryEvents = bool;
    }

    public Boolean isCaptureOpenTelemetryEvents() {
        return this.captureOpenTelemetryEvents;
    }

    public void setEnableLogs(Boolean bool) {
        this.enableLogs = bool;
    }

    public Boolean isEnableLogs() {
        return this.enableLogs;
    }

    public void setEnableMetrics(Boolean bool) {
        this.enableMetrics = bool;
    }

    public Boolean isEnableMetrics() {
        return this.enableMetrics;
    }

    public Double getProfileSessionSampleRate() {
        return this.profileSessionSampleRate;
    }

    public void setProfileSessionSampleRate(Double d) {
        this.profileSessionSampleRate = d;
    }

    public String getProfilingTracesDirPath() {
        return this.profilingTracesDirPath;
    }

    public void setProfilingTracesDirPath(String str) {
        this.profilingTracesDirPath = str;
    }

    public Boolean isStrictTraceContinuation() {
        return this.strictTraceContinuation;
    }

    public void setStrictTraceContinuation(Boolean bool) {
        this.strictTraceContinuation = bool;
    }

    public String getOrgId() {
        return this.orgId;
    }

    public void setOrgId(String str) {
        this.orgId = str;
    }

    public ProfileLifecycle getProfileLifecycle() {
        return this.profileLifecycle;
    }

    public void setProfileLifecycle(ProfileLifecycle profileLifecycle) {
        this.profileLifecycle = profileLifecycle;
    }
}
