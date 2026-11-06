package com.datadog.legacy.trace.api;

import com.amazon.a.a.o.b.f;
import com.revenuecat.purchases.common.Constants;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import io.sentry.protocol.DebugImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public class Config {
    private static final String DEFAULT_PROPAGATION_STYLE_EXTRACT;
    private static final String DEFAULT_PROPAGATION_STYLE_INJECT;
    private static final String DEFAULT_TRACE_ANNOTATIONS;
    private static final String DEFAULT_TRACE_METHODS;
    private static final Config INSTANCE;
    private static Properties propertiesFromConfigFile;
    private final String agentHost;
    private final int agentPort;
    private final String agentUnixDomainSocket;
    private final boolean dbClientSplitByInstance;
    private final List excludedClasses;
    private final Map headerTags;
    private final boolean healthMetricsEnabled;
    private final String healthMetricsStatsdHost;
    private final Integer healthMetricsStatsdPort;
    private final Set httpClientErrorStatuses;
    private final boolean httpClientSplitByDomain;
    private final boolean httpClientTagQueryString;
    private final Set httpServerErrorStatuses;
    private final boolean httpServerTagQueryString;
    private final boolean integrationsEnabled;
    private final Integer jmxFetchCheckPeriod;
    private final String jmxFetchConfigDir;
    private final List jmxFetchConfigs;
    private final boolean jmxFetchEnabled;
    private final List jmxFetchMetricsConfigs;
    private final Integer jmxFetchRefreshBeansPeriod;
    private final String jmxFetchStatsdHost;
    private final Integer jmxFetchStatsdPort;
    private final Map jmxTags;
    private final boolean logsInjectionEnabled;
    private final Integer partialFlushMinSpans;
    private final boolean prioritySamplingEnabled;
    private final boolean profilingEnabled;
    private final int profilingExceptionHistogramMaxCollectionSize;
    private final int profilingExceptionHistogramTopItems;
    private final int profilingExceptionSampleLimit;
    private final String profilingProxyHost;
    private final String profilingProxyPassword;
    private final int profilingProxyPort;
    private final String profilingProxyUsername;
    private final int profilingStartDelay;
    private final boolean profilingStartForceFirst;
    private final Map profilingTags;
    private final String profilingTemplateOverrideFile;
    private final String profilingUploadCompression;
    private final int profilingUploadPeriod;
    private final int profilingUploadTimeout;
    private final String profilingUrl;
    private final Set propagationStylesToExtract;
    private final Set propagationStylesToInject;
    private final boolean reportHostName;
    private final boolean runtimeContextFieldInjection;
    private final String runtimeId;
    private final Integer scopeDepthLimit;
    private final Map serviceMapping;
    private final String serviceName;
    private final String site;
    private final Map spanTags;
    private final Set splitByTags;
    private final Map tags;
    private final boolean traceAnalyticsEnabled;
    private final String traceAnnotations;
    private final boolean traceEnabled;
    private final List traceExecutors;
    private final boolean traceExecutorsAll;
    private final String traceMethods;
    private final Double traceRateLimit;
    private final boolean traceResolverEnabled;
    private final Double traceSampleRate;
    private final Map traceSamplingOperationRules;
    private final Map traceSamplingServiceRules;
    private final String writerType;
    private static final Pattern ENV_REPLACEMENT = Pattern.compile("[^a-zA-Z0-9_]");
    public static final String DEFAULT_AGENT_UNIX_DOMAIN_SOCKET = null;
    private static final Set DEFAULT_HTTP_SERVER_ERROR_STATUSES = parseIntegerRangeSet("500-599", "default");
    private static final Set DEFAULT_HTTP_CLIENT_ERROR_STATUSES = parseIntegerRangeSet("400-499", "default");

    public enum PropagationStyle {
        DATADOG,
        B3,
        B3MULTI,
        TRACECONTEXT,
        HAYSTACK
    }

    static {
        PropagationStyle propagationStyle = PropagationStyle.DATADOG;
        DEFAULT_PROPAGATION_STYLE_EXTRACT = propagationStyle.name();
        DEFAULT_PROPAGATION_STYLE_INJECT = propagationStyle.name();
        DEFAULT_TRACE_ANNOTATIONS = null;
        DEFAULT_TRACE_METHODS = null;
        INSTANCE = new Config();
    }

    Config() {
        propertiesFromConfigFile = loadConfigurationFile();
        this.runtimeId = UUID.randomUUID().toString();
        this.site = getSettingFromEnvironment("site", "datadoghq.com");
        this.serviceName = getSettingFromEnvironment("service", getSettingFromEnvironment("service.name", "unnamed-java-app"));
        Boolean bool = Boolean.TRUE;
        this.traceEnabled = getBooleanSettingFromEnvironment("trace.enabled", bool).booleanValue();
        this.integrationsEnabled = getBooleanSettingFromEnvironment("integrations.enabled", bool).booleanValue();
        this.writerType = getSettingFromEnvironment("writer.type", "DDAgentWriter");
        this.agentHost = getSettingFromEnvironment("agent.host", "localhost");
        this.agentPort = getIntegerSettingFromEnvironment("trace.agent.port", getIntegerSettingFromEnvironment("agent.port", 8126)).intValue();
        this.agentUnixDomainSocket = getSettingFromEnvironment("trace.agent.unix.domain.socket", DEFAULT_AGENT_UNIX_DOMAIN_SOCKET);
        this.prioritySamplingEnabled = getBooleanSettingFromEnvironment("priority.sampling", bool).booleanValue();
        this.traceResolverEnabled = getBooleanSettingFromEnvironment("trace.resolver.enabled", bool).booleanValue();
        this.serviceMapping = getMapSettingFromEnvironment("service.mapping", null);
        HashMap map = new HashMap(getMapSettingFromEnvironment("trace.global.tags", null));
        map.putAll(getMapSettingFromEnvironment("tags", null));
        this.tags = getMapWithPropertiesDefinedByEnvironment(map, "env", DiagnosticsEntry.VERSION_KEY);
        this.spanTags = getMapSettingFromEnvironment("trace.span.tags", null);
        this.jmxTags = getMapSettingFromEnvironment("trace.jmx.tags", null);
        this.excludedClasses = getListSettingFromEnvironment("trace.classes.exclude", null);
        this.headerTags = getMapSettingFromEnvironment("trace.header.tags", null);
        this.httpServerErrorStatuses = getIntegerRangeSettingFromEnvironment("http.server.error.statuses", DEFAULT_HTTP_SERVER_ERROR_STATUSES);
        this.httpClientErrorStatuses = getIntegerRangeSettingFromEnvironment("http.client.error.statuses", DEFAULT_HTTP_CLIENT_ERROR_STATUSES);
        Boolean bool2 = Boolean.FALSE;
        this.httpServerTagQueryString = getBooleanSettingFromEnvironment("http.server.tag.query-string", bool2).booleanValue();
        this.httpClientTagQueryString = getBooleanSettingFromEnvironment("http.client.tag.query-string", bool2).booleanValue();
        this.httpClientSplitByDomain = getBooleanSettingFromEnvironment("trace.http.client.split-by-domain", bool2).booleanValue();
        this.dbClientSplitByInstance = getBooleanSettingFromEnvironment("trace.db.client.split-by-instance", bool2).booleanValue();
        this.splitByTags = Collections.unmodifiableSet(new LinkedHashSet(getListSettingFromEnvironment("trace.split-by-tags", "")));
        this.scopeDepthLimit = getIntegerSettingFromEnvironment("trace.scope.depth.limit", 100);
        this.partialFlushMinSpans = getIntegerSettingFromEnvironment("trace.partial.flush.min.spans", 1000);
        this.runtimeContextFieldInjection = getBooleanSettingFromEnvironment("trace.runtime.context.field.injection", bool).booleanValue();
        this.propagationStylesToExtract = getPropagationStyleSetSettingFromEnvironmentOrDefault("propagation.style.extract", DEFAULT_PROPAGATION_STYLE_EXTRACT);
        this.propagationStylesToInject = getPropagationStyleSetSettingFromEnvironmentOrDefault("propagation.style.inject", DEFAULT_PROPAGATION_STYLE_INJECT);
        this.jmxFetchEnabled = getBooleanSettingFromEnvironment("jmxfetch.enabled", bool).booleanValue();
        this.jmxFetchConfigDir = getSettingFromEnvironment("jmxfetch.config.dir", null);
        this.jmxFetchConfigs = getListSettingFromEnvironment("jmxfetch.config", null);
        this.jmxFetchMetricsConfigs = getListSettingFromEnvironment("jmxfetch.metrics-configs", null);
        this.jmxFetchCheckPeriod = getIntegerSettingFromEnvironment("jmxfetch.check-period", null);
        this.jmxFetchRefreshBeansPeriod = getIntegerSettingFromEnvironment("jmxfetch.refresh-beans-period", null);
        this.jmxFetchStatsdHost = getSettingFromEnvironment("jmxfetch.statsd.host", null);
        this.jmxFetchStatsdPort = getIntegerSettingFromEnvironment("jmxfetch.statsd.port", 8125);
        this.healthMetricsEnabled = getBooleanSettingFromEnvironment("trace.health.metrics.enabled", bool2).booleanValue();
        this.healthMetricsStatsdHost = getSettingFromEnvironment("trace.health.metrics.statsd.host", null);
        this.healthMetricsStatsdPort = getIntegerSettingFromEnvironment("trace.health.metrics.statsd.port", null);
        this.logsInjectionEnabled = getBooleanSettingFromEnvironment("logs.injection", bool2).booleanValue();
        this.reportHostName = getBooleanSettingFromEnvironment("trace.report-hostname", bool2).booleanValue();
        this.traceAnnotations = getSettingFromEnvironment("trace.annotations", DEFAULT_TRACE_ANNOTATIONS);
        this.traceMethods = getSettingFromEnvironment("trace.methods", DEFAULT_TRACE_METHODS);
        this.traceExecutorsAll = getBooleanSettingFromEnvironment("trace.executors.all", bool2).booleanValue();
        this.traceExecutors = getListSettingFromEnvironment("trace.executors", "");
        this.traceAnalyticsEnabled = getBooleanSettingFromEnvironment("trace.analytics.enabled", bool2).booleanValue();
        this.traceSamplingServiceRules = getMapSettingFromEnvironment("trace.sampling.service.rules", null);
        this.traceSamplingOperationRules = getMapSettingFromEnvironment("trace.sampling.operation.rules", null);
        this.traceSampleRate = getDoubleSettingFromEnvironment("trace.sample.rate", null);
        this.traceRateLimit = getDoubleSettingFromEnvironment("trace.rate.limit", Double.valueOf(100.0d));
        this.profilingEnabled = getBooleanSettingFromEnvironment("profiling.enabled", bool2).booleanValue();
        this.profilingUrl = getSettingFromEnvironment("profiling.url", null);
        this.profilingTags = getMapSettingFromEnvironment("profiling.tags", null);
        this.profilingStartDelay = getIntegerSettingFromEnvironment("profiling.start-delay", 10).intValue();
        this.profilingStartForceFirst = getBooleanSettingFromEnvironment("profiling.experimental.start-force-first", bool2).booleanValue();
        this.profilingUploadPeriod = getIntegerSettingFromEnvironment("profiling.upload.period", 60).intValue();
        this.profilingTemplateOverrideFile = getSettingFromEnvironment("profiling.jfr-template-override-file", null);
        this.profilingUploadTimeout = getIntegerSettingFromEnvironment("profiling.upload.timeout", 30).intValue();
        this.profilingUploadCompression = getSettingFromEnvironment("profiling.upload.compression", "on");
        this.profilingProxyHost = getSettingFromEnvironment("profiling.proxy.host", null);
        this.profilingProxyPort = getIntegerSettingFromEnvironment("profiling.proxy.port", 8080).intValue();
        this.profilingProxyUsername = getSettingFromEnvironment("profiling.proxy.username", null);
        this.profilingProxyPassword = getSettingFromEnvironment("profiling.proxy.password", null);
        Integer numValueOf = Integer.valueOf(ColorExtractionConstants.MAX_PIXEL_SAMPLES);
        this.profilingExceptionSampleLimit = getIntegerSettingFromEnvironment("profiling.exception.sample.limit", numValueOf).intValue();
        this.profilingExceptionHistogramTopItems = getIntegerSettingFromEnvironment("profiling.exception.histogram.top-items", 50).intValue();
        this.profilingExceptionHistogramMaxCollectionSize = getIntegerSettingFromEnvironment("profiling.exception.histogram.max-collection-size", numValueOf).intValue();
    }

    private Config(Properties properties, Config config) {
        this.runtimeId = config.runtimeId;
        this.site = properties.getProperty("site", config.site);
        this.serviceName = properties.getProperty("service", properties.getProperty("service.name", config.serviceName));
        this.traceEnabled = getPropertyBooleanValue(properties, "trace.enabled", Boolean.valueOf(config.traceEnabled)).booleanValue();
        this.integrationsEnabled = getPropertyBooleanValue(properties, "integrations.enabled", Boolean.valueOf(config.integrationsEnabled)).booleanValue();
        this.writerType = properties.getProperty("writer.type", config.writerType);
        this.agentHost = properties.getProperty("agent.host", config.agentHost);
        this.agentPort = getPropertyIntegerValue(properties, "trace.agent.port", getPropertyIntegerValue(properties, "agent.port", Integer.valueOf(config.agentPort))).intValue();
        this.agentUnixDomainSocket = properties.getProperty("trace.agent.unix.domain.socket", config.agentUnixDomainSocket);
        this.prioritySamplingEnabled = getPropertyBooleanValue(properties, "priority.sampling", Boolean.valueOf(config.prioritySamplingEnabled)).booleanValue();
        this.traceResolverEnabled = getPropertyBooleanValue(properties, "trace.resolver.enabled", Boolean.valueOf(config.traceResolverEnabled)).booleanValue();
        this.serviceMapping = getPropertyMapValue(properties, "service.mapping", config.serviceMapping);
        HashMap map = new HashMap(getPropertyMapValue(properties, "trace.global.tags", Collections.EMPTY_MAP));
        map.putAll(getPropertyMapValue(properties, "tags", config.tags));
        this.tags = overwriteKeysFromProperties(map, properties, "env", DiagnosticsEntry.VERSION_KEY);
        this.spanTags = getPropertyMapValue(properties, "trace.span.tags", config.spanTags);
        this.jmxTags = getPropertyMapValue(properties, "trace.jmx.tags", config.jmxTags);
        this.excludedClasses = getPropertyListValue(properties, "trace.classes.exclude", config.excludedClasses);
        this.headerTags = getPropertyMapValue(properties, "trace.header.tags", config.headerTags);
        this.httpServerErrorStatuses = getPropertyIntegerRangeValue(properties, "http.server.error.statuses", config.httpServerErrorStatuses);
        this.httpClientErrorStatuses = getPropertyIntegerRangeValue(properties, "http.client.error.statuses", config.httpClientErrorStatuses);
        this.httpServerTagQueryString = getPropertyBooleanValue(properties, "http.server.tag.query-string", Boolean.valueOf(config.httpServerTagQueryString)).booleanValue();
        this.httpClientTagQueryString = getPropertyBooleanValue(properties, "http.client.tag.query-string", Boolean.valueOf(config.httpClientTagQueryString)).booleanValue();
        this.httpClientSplitByDomain = getPropertyBooleanValue(properties, "trace.http.client.split-by-domain", Boolean.valueOf(config.httpClientSplitByDomain)).booleanValue();
        this.dbClientSplitByInstance = getPropertyBooleanValue(properties, "trace.db.client.split-by-instance", Boolean.valueOf(config.dbClientSplitByInstance)).booleanValue();
        this.splitByTags = Collections.unmodifiableSet(new LinkedHashSet(getPropertyListValue(properties, "trace.split-by-tags", new ArrayList(config.splitByTags))));
        this.scopeDepthLimit = getPropertyIntegerValue(properties, "trace.scope.depth.limit", config.scopeDepthLimit);
        this.partialFlushMinSpans = getPropertyIntegerValue(properties, "trace.partial.flush.min.spans", config.partialFlushMinSpans);
        this.runtimeContextFieldInjection = getPropertyBooleanValue(properties, "trace.runtime.context.field.injection", Boolean.valueOf(config.runtimeContextFieldInjection)).booleanValue();
        Set propagationStyleSetFromPropertyValue = getPropagationStyleSetFromPropertyValue(properties, "propagation.style.extract");
        this.propagationStylesToExtract = propagationStyleSetFromPropertyValue == null ? config.propagationStylesToExtract : propagationStyleSetFromPropertyValue;
        Set propagationStyleSetFromPropertyValue2 = getPropagationStyleSetFromPropertyValue(properties, "propagation.style.inject");
        this.propagationStylesToInject = propagationStyleSetFromPropertyValue2 == null ? config.propagationStylesToInject : propagationStyleSetFromPropertyValue2;
        this.jmxFetchEnabled = getPropertyBooleanValue(properties, "jmxfetch.enabled", Boolean.valueOf(config.jmxFetchEnabled)).booleanValue();
        this.jmxFetchConfigDir = properties.getProperty("jmxfetch.config.dir", config.jmxFetchConfigDir);
        this.jmxFetchConfigs = getPropertyListValue(properties, "jmxfetch.config", config.jmxFetchConfigs);
        this.jmxFetchMetricsConfigs = getPropertyListValue(properties, "jmxfetch.metrics-configs", config.jmxFetchMetricsConfigs);
        this.jmxFetchCheckPeriod = getPropertyIntegerValue(properties, "jmxfetch.check-period", config.jmxFetchCheckPeriod);
        this.jmxFetchRefreshBeansPeriod = getPropertyIntegerValue(properties, "jmxfetch.refresh-beans-period", config.jmxFetchRefreshBeansPeriod);
        this.jmxFetchStatsdHost = properties.getProperty("jmxfetch.statsd.host", config.jmxFetchStatsdHost);
        this.jmxFetchStatsdPort = getPropertyIntegerValue(properties, "jmxfetch.statsd.port", config.jmxFetchStatsdPort);
        Boolean bool = Boolean.FALSE;
        this.healthMetricsEnabled = getPropertyBooleanValue(properties, "trace.health.metrics.enabled", bool).booleanValue();
        this.healthMetricsStatsdHost = properties.getProperty("trace.health.metrics.statsd.host", config.healthMetricsStatsdHost);
        this.healthMetricsStatsdPort = getPropertyIntegerValue(properties, "trace.health.metrics.statsd.port", config.healthMetricsStatsdPort);
        this.logsInjectionEnabled = getBooleanSettingFromEnvironment("logs.injection", bool).booleanValue();
        this.reportHostName = getPropertyBooleanValue(properties, "trace.report-hostname", Boolean.valueOf(config.reportHostName)).booleanValue();
        this.traceAnnotations = properties.getProperty("trace.annotations", config.traceAnnotations);
        this.traceMethods = properties.getProperty("trace.methods", config.traceMethods);
        this.traceExecutorsAll = getPropertyBooleanValue(properties, "trace.executors.all", Boolean.valueOf(config.traceExecutorsAll)).booleanValue();
        this.traceExecutors = getPropertyListValue(properties, "trace.executors", config.traceExecutors);
        this.traceAnalyticsEnabled = getPropertyBooleanValue(properties, "trace.analytics.enabled", Boolean.valueOf(config.traceAnalyticsEnabled)).booleanValue();
        this.traceSamplingServiceRules = getPropertyMapValue(properties, "trace.sampling.service.rules", config.traceSamplingServiceRules);
        this.traceSamplingOperationRules = getPropertyMapValue(properties, "trace.sampling.operation.rules", config.traceSamplingOperationRules);
        this.traceSampleRate = getPropertyDoubleValue(properties, "trace.sample.rate", config.traceSampleRate);
        this.traceRateLimit = getPropertyDoubleValue(properties, "trace.rate.limit", config.traceRateLimit);
        this.profilingEnabled = getPropertyBooleanValue(properties, "profiling.enabled", Boolean.valueOf(config.profilingEnabled)).booleanValue();
        this.profilingUrl = properties.getProperty("profiling.url", config.profilingUrl);
        this.profilingTags = getPropertyMapValue(properties, "profiling.tags", config.profilingTags);
        this.profilingStartDelay = getPropertyIntegerValue(properties, "profiling.start-delay", Integer.valueOf(config.profilingStartDelay)).intValue();
        this.profilingStartForceFirst = getPropertyBooleanValue(properties, "profiling.experimental.start-force-first", Boolean.valueOf(config.profilingStartForceFirst)).booleanValue();
        this.profilingUploadPeriod = getPropertyIntegerValue(properties, "profiling.upload.period", Integer.valueOf(config.profilingUploadPeriod)).intValue();
        this.profilingTemplateOverrideFile = properties.getProperty("profiling.jfr-template-override-file", config.profilingTemplateOverrideFile);
        this.profilingUploadTimeout = getPropertyIntegerValue(properties, "profiling.upload.timeout", Integer.valueOf(config.profilingUploadTimeout)).intValue();
        this.profilingUploadCompression = properties.getProperty("profiling.upload.compression", config.profilingUploadCompression);
        this.profilingProxyHost = properties.getProperty("profiling.proxy.host", config.profilingProxyHost);
        this.profilingProxyPort = getPropertyIntegerValue(properties, "profiling.proxy.port", Integer.valueOf(config.profilingProxyPort)).intValue();
        this.profilingProxyUsername = properties.getProperty("profiling.proxy.username", config.profilingProxyUsername);
        this.profilingProxyPassword = properties.getProperty("profiling.proxy.password", config.profilingProxyPassword);
        this.profilingExceptionSampleLimit = getPropertyIntegerValue(properties, "profiling.exception.sample.limit", Integer.valueOf(config.profilingExceptionSampleLimit)).intValue();
        this.profilingExceptionHistogramTopItems = getPropertyIntegerValue(properties, "profiling.exception.histogram.top-items", Integer.valueOf(config.profilingExceptionHistogramTopItems)).intValue();
        this.profilingExceptionHistogramMaxCollectionSize = getPropertyIntegerValue(properties, "profiling.exception.histogram.max-collection-size", Integer.valueOf(config.profilingExceptionHistogramMaxCollectionSize)).intValue();
    }

    public Map getLocalRootSpanTags() {
        String hostName;
        HashMap map = new HashMap(getRuntimeTags());
        map.put("language", DebugImage.JVM);
        if (this.reportHostName && (hostName = getHostName()) != null && !hostName.isEmpty()) {
            map.put("_dd.hostname", hostName);
        }
        return Collections.unmodifiableMap(map);
    }

    public Map getMergedSpanTags() {
        Map mapNewHashMap = newHashMap(getGlobalTags().size() + this.spanTags.size());
        mapNewHashMap.putAll(getGlobalTags());
        mapNewHashMap.putAll(this.spanTags);
        return Collections.unmodifiableMap(mapNewHashMap);
    }

    private Map getGlobalTags() {
        return this.tags;
    }

    private Map getRuntimeTags() {
        Map mapNewHashMap = newHashMap(2);
        mapNewHashMap.put("runtime-id", this.runtimeId);
        return Collections.unmodifiableMap(mapNewHashMap);
    }

    public boolean isRuleEnabled(String str) {
        String str2 = "trace." + str + ".enabled";
        Boolean bool = Boolean.TRUE;
        if (!getBooleanSettingFromEnvironment(str2, bool).booleanValue()) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("trace.");
        sb.append(str.toLowerCase(Locale.US));
        sb.append(".enabled");
        return getBooleanSettingFromEnvironment(sb.toString(), bool).booleanValue();
    }

    public static String getSettingFromEnvironment(String str, String str2) {
        String property = System.getProperties().getProperty(propertyNameToSystemPropertyName(str));
        return property != null ? property : str2;
    }

    private static Map getMapSettingFromEnvironment(String str, String str2) {
        return parseMap(getSettingFromEnvironment(str, str2), propertyNameToSystemPropertyName(str));
    }

    private static List getListSettingFromEnvironment(String str, String str2) {
        return parseList(getSettingFromEnvironment(str, str2));
    }

    public static Boolean getBooleanSettingFromEnvironment(String str, Boolean bool) {
        return (Boolean) getSettingFromEnvironmentWithLog(str, Boolean.class, bool);
    }

    private static Double getDoubleSettingFromEnvironment(String str, Double d) {
        return (Double) getSettingFromEnvironmentWithLog(str, Double.class, d);
    }

    private static Integer getIntegerSettingFromEnvironment(String str, Integer num) {
        return (Integer) getSettingFromEnvironmentWithLog(str, Integer.class, num);
    }

    private static Object getSettingFromEnvironmentWithLog(String str, Class cls, Object obj) {
        try {
            return valueOf(getSettingFromEnvironment(str, null), cls, obj);
        } catch (NumberFormatException unused) {
            return obj;
        }
    }

    private static Set getPropagationStyleSetSettingFromEnvironmentOrDefault(String str, String str2) {
        Set setConvertStringSetToPropagationStyleSet = convertStringSetToPropagationStyleSet(parseStringIntoSetOfNonEmptyStrings(getSettingFromEnvironment(str, str2)));
        return setConvertStringSetToPropagationStyleSet.isEmpty() ? convertStringSetToPropagationStyleSet(parseStringIntoSetOfNonEmptyStrings(str2)) : setConvertStringSetToPropagationStyleSet;
    }

    private static Set getIntegerRangeSettingFromEnvironment(String str, Set set) {
        String settingFromEnvironment = getSettingFromEnvironment(str, null);
        if (settingFromEnvironment == null) {
            return set;
        }
        try {
            return parseIntegerRangeSet(settingFromEnvironment, str);
        } catch (NumberFormatException unused) {
            return set;
        }
    }

    private static String propertyNameToEnvironmentVariableName(String str) {
        return ENV_REPLACEMENT.matcher(propertyNameToSystemPropertyName(str).toUpperCase(Locale.US)).replaceAll("_");
    }

    private static String propertyNameToSystemPropertyName(String str) {
        return "dd." + str;
    }

    private static Object valueOf(String str, Class cls, Object obj) {
        if (str == null || str.trim().isEmpty()) {
            return obj;
        }
        try {
            return cls.getMethod("valueOf", String.class).invoke(null, str);
        } catch (IllegalAccessException | NoSuchMethodException e) {
            throw new NumberFormatException(e.toString());
        } catch (NumberFormatException e2) {
            throw e2;
        } catch (Throwable th) {
            throw new NumberFormatException(th.toString());
        }
    }

    private static Map getPropertyMapValue(Properties properties, String str, Map map) {
        String property = properties.getProperty(str);
        return (property == null || property.trim().isEmpty()) ? map : parseMap(property, str);
    }

    private static List getPropertyListValue(Properties properties, String str, List list) {
        String property = properties.getProperty(str);
        return (property == null || property.trim().isEmpty()) ? list : parseList(property);
    }

    private static Boolean getPropertyBooleanValue(Properties properties, String str, Boolean bool) {
        return (Boolean) valueOf(properties.getProperty(str), Boolean.class, bool);
    }

    private static Integer getPropertyIntegerValue(Properties properties, String str, Integer num) {
        return (Integer) valueOf(properties.getProperty(str), Integer.class, num);
    }

    private static Double getPropertyDoubleValue(Properties properties, String str, Double d) {
        return (Double) valueOf(properties.getProperty(str), Double.class, d);
    }

    private static Set getPropagationStyleSetFromPropertyValue(Properties properties, String str) {
        String property = properties.getProperty(str);
        if (property == null) {
            return null;
        }
        Set setConvertStringSetToPropagationStyleSet = convertStringSetToPropagationStyleSet(parseStringIntoSetOfNonEmptyStrings(property));
        if (setConvertStringSetToPropagationStyleSet.isEmpty()) {
            return null;
        }
        return setConvertStringSetToPropagationStyleSet;
    }

    private static Set getPropertyIntegerRangeValue(Properties properties, String str, Set set) {
        String property = properties.getProperty(str);
        if (property == null) {
            return set;
        }
        try {
            return parseIntegerRangeSet(property, str);
        } catch (NumberFormatException unused) {
            return set;
        }
    }

    private static Map parseMap(String str, String str2) {
        if (str == null || str.trim().isEmpty()) {
            return Collections.EMPTY_MAP;
        }
        if (!str.matches("(([^,:]+:[^,:]*,)*([^,:]+:[^,:]*),?)?")) {
            return Collections.EMPTY_MAP;
        }
        String[] strArrSplit = str.split(f.a, -1);
        Map mapNewHashMap = newHashMap(strArrSplit.length);
        for (String str3 : strArrSplit) {
            String[] strArrSplit2 = str3.split(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, -1);
            if (strArrSplit2.length == 2) {
                String strTrim = strArrSplit2[0].trim();
                String strTrim2 = strArrSplit2[1].trim();
                if (strTrim2.length() > 0) {
                    mapNewHashMap.put(strTrim, strTrim2);
                }
            }
        }
        return Collections.unmodifiableMap(mapNewHashMap);
    }

    private static Set parseIntegerRangeSet(String str, String str2) {
        String strReplaceAll = str.replaceAll("\\s", "");
        if (!strReplaceAll.matches("\\d{3}(?:-\\d{3})?(?:,\\d{3}(?:-\\d{3})?)*")) {
            throw new NumberFormatException();
        }
        String[] strArrSplit = strReplaceAll.split(f.a, -1);
        HashSet hashSet = new HashSet();
        for (String str3 : strArrSplit) {
            String[] strArrSplit2 = str3.split("-", -1);
            if (strArrSplit2.length == 1) {
                hashSet.add(Integer.valueOf(Integer.parseInt(strArrSplit2[0])));
            } else if (strArrSplit2.length == 2) {
                int i = Integer.parseInt(strArrSplit2[0]);
                int i2 = Integer.parseInt(strArrSplit2[1]);
                int iMax = Math.max(i, i2);
                for (int iMin = Math.min(i, i2); iMin <= iMax; iMin++) {
                    hashSet.add(Integer.valueOf(iMin));
                }
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    private static Map newHashMap(int i) {
        return new HashMap(i + 1, 1.0f);
    }

    private static Map getMapWithPropertiesDefinedByEnvironment(Map map, String... strArr) {
        HashMap map2 = new HashMap(map);
        for (String str : strArr) {
            String settingFromEnvironment = getSettingFromEnvironment(str, null);
            if (settingFromEnvironment != null) {
                map2.put(str, settingFromEnvironment);
            }
        }
        return Collections.unmodifiableMap(map2);
    }

    private static Map overwriteKeysFromProperties(Map map, Properties properties, String... strArr) {
        HashMap map2 = new HashMap(map);
        for (String str : strArr) {
            String property = properties.getProperty(str, null);
            if (property != null) {
                map2.put(str, property);
            }
        }
        return Collections.unmodifiableMap(map2);
    }

    private static List parseList(String str) {
        if (str == null || str.trim().isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        String[] strArrSplit = str.split(f.a, -1);
        for (int i = 0; i < strArrSplit.length; i++) {
            strArrSplit[i] = strArrSplit[i].trim();
        }
        return Collections.unmodifiableList(Arrays.asList(strArrSplit));
    }

    private static Set parseStringIntoSetOfNonEmptyStrings(String str) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String str2 : str.split("[,\\s]+")) {
            if (!str2.isEmpty()) {
                linkedHashSet.add(str2);
            }
        }
        return Collections.unmodifiableSet(linkedHashSet);
    }

    private static Set convertStringSetToPropagationStyleSet(Set set) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            try {
                linkedHashSet.add(PropagationStyle.valueOf(((String) it.next()).toUpperCase(Locale.US)));
            } catch (IllegalArgumentException unused) {
            }
        }
        return Collections.unmodifiableSet(linkedHashSet);
    }

    private static Properties loadConfigurationFile() {
        Properties properties = new Properties();
        String property = System.getProperty(propertyNameToSystemPropertyName("trace.config"));
        if (property == null) {
            property = System.getenv(propertyNameToEnvironmentVariableName("trace.config"));
        }
        if (property != null) {
            File file = new File(property.replaceFirst("^~", System.getProperty("user.home")));
            if (file.exists()) {
                try {
                    FileReader fileReader = new FileReader(file);
                    try {
                        properties.load(fileReader);
                        fileReader.close();
                        return properties;
                    } catch (Throwable th) {
                        try {
                            fileReader.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (FileNotFoundException | IOException unused) {
                }
            }
        }
        return properties;
    }

    private static String getHostName() {
        String line;
        if (System.getProperty("os.name").startsWith("Windows")) {
            line = System.getenv("COMPUTERNAME");
        } else {
            line = System.getenv("HOSTNAME");
        }
        if (line != null && !line.isEmpty()) {
            return line.trim();
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("hostname").getInputStream()));
            try {
                line = bufferedReader.readLine();
                bufferedReader.close();
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Exception unused) {
        }
        if (line != null && !line.isEmpty()) {
            return line.trim();
        }
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException unused2) {
            return null;
        }
    }

    public static Config get() {
        return INSTANCE;
    }

    public static Config get(Properties properties) {
        if (properties == null || properties.isEmpty()) {
            return INSTANCE;
        }
        return new Config(properties, INSTANCE);
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public boolean isPrioritySamplingEnabled() {
        return this.prioritySamplingEnabled;
    }

    public Map getServiceMapping() {
        return this.serviceMapping;
    }

    public Map getHeaderTags() {
        return this.headerTags;
    }

    public Set getSplitByTags() {
        return this.splitByTags;
    }

    public Integer getScopeDepthLimit() {
        return this.scopeDepthLimit;
    }

    public Integer getPartialFlushMinSpans() {
        return this.partialFlushMinSpans;
    }

    public Set getPropagationStylesToExtract() {
        return this.propagationStylesToExtract;
    }

    public Set getPropagationStylesToInject() {
        return this.propagationStylesToInject;
    }

    public Double getTraceSampleRate() {
        return this.traceSampleRate;
    }

    public String toString() {
        return "Config{runtimeId='" + this.runtimeId + "', site='" + this.site + "', serviceName='" + this.serviceName + "', traceEnabled=" + this.traceEnabled + ", integrationsEnabled=" + this.integrationsEnabled + ", writerType='" + this.writerType + "', agentHost='" + this.agentHost + "', agentPort=" + this.agentPort + ", agentUnixDomainSocket='" + this.agentUnixDomainSocket + "', prioritySamplingEnabled=" + this.prioritySamplingEnabled + ", traceResolverEnabled=" + this.traceResolverEnabled + ", serviceMapping=" + this.serviceMapping + ", tags=" + this.tags + ", spanTags=" + this.spanTags + ", jmxTags=" + this.jmxTags + ", excludedClasses=" + this.excludedClasses + ", headerTags=" + this.headerTags + ", httpServerErrorStatuses=" + this.httpServerErrorStatuses + ", httpClientErrorStatuses=" + this.httpClientErrorStatuses + ", httpServerTagQueryString=" + this.httpServerTagQueryString + ", httpClientTagQueryString=" + this.httpClientTagQueryString + ", httpClientSplitByDomain=" + this.httpClientSplitByDomain + ", dbClientSplitByInstance=" + this.dbClientSplitByInstance + ", splitByTags=" + this.splitByTags + ", scopeDepthLimit=" + this.scopeDepthLimit + ", partialFlushMinSpans=" + this.partialFlushMinSpans + ", runtimeContextFieldInjection=" + this.runtimeContextFieldInjection + ", propagationStylesToExtract=" + this.propagationStylesToExtract + ", propagationStylesToInject=" + this.propagationStylesToInject + ", jmxFetchEnabled=" + this.jmxFetchEnabled + ", jmxFetchConfigDir='" + this.jmxFetchConfigDir + "', jmxFetchConfigs=" + this.jmxFetchConfigs + ", jmxFetchMetricsConfigs=" + this.jmxFetchMetricsConfigs + ", jmxFetchCheckPeriod=" + this.jmxFetchCheckPeriod + ", jmxFetchRefreshBeansPeriod=" + this.jmxFetchRefreshBeansPeriod + ", jmxFetchStatsdHost='" + this.jmxFetchStatsdHost + "', jmxFetchStatsdPort=" + this.jmxFetchStatsdPort + ", healthMetricsEnabled=" + this.healthMetricsEnabled + ", healthMetricsStatsdHost='" + this.healthMetricsStatsdHost + "', healthMetricsStatsdPort=" + this.healthMetricsStatsdPort + ", logsInjectionEnabled=" + this.logsInjectionEnabled + ", reportHostName=" + this.reportHostName + ", traceAnnotations='" + this.traceAnnotations + "', traceMethods='" + this.traceMethods + "', traceExecutorsAll=" + this.traceExecutorsAll + ", traceExecutors=" + this.traceExecutors + ", traceAnalyticsEnabled=" + this.traceAnalyticsEnabled + ", traceSamplingServiceRules=" + this.traceSamplingServiceRules + ", traceSamplingOperationRules=" + this.traceSamplingOperationRules + ", traceSampleRate=" + this.traceSampleRate + ", traceRateLimit=" + this.traceRateLimit + ", profilingEnabled=" + this.profilingEnabled + ", profilingUrl='" + this.profilingUrl + "', profilingTags=" + this.profilingTags + ", profilingStartDelay=" + this.profilingStartDelay + ", profilingStartForceFirst=" + this.profilingStartForceFirst + ", profilingUploadPeriod=" + this.profilingUploadPeriod + ", profilingTemplateOverrideFile='" + this.profilingTemplateOverrideFile + "', profilingUploadTimeout=" + this.profilingUploadTimeout + ", profilingUploadCompression='" + this.profilingUploadCompression + "', profilingProxyHost='" + this.profilingProxyHost + "', profilingProxyPort=" + this.profilingProxyPort + ", profilingProxyUsername='" + this.profilingProxyUsername + "', profilingProxyPassword='" + this.profilingProxyPassword + "', profilingExceptionSampleLimit=" + this.profilingExceptionSampleLimit + ", profilingExceptionHistogramTopItems=" + this.profilingExceptionHistogramTopItems + ", profilingExceptionHistogramMaxCollectionSize=" + this.profilingExceptionHistogramMaxCollectionSize + '}';
    }
}
