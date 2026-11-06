package com.datadog.android.core.configuration;

import com.datadog.android.DatadogSite;
import com.datadog.android.core.persistence.PersistenceStrategy;
import com.datadog.android.security.Encryption;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import java.net.Proxy;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Authenticator;

/* JADX INFO: loaded from: classes3.dex */
public final class Configuration {
    public static final Companion Companion = new Companion(null);
    private static final BackPressureStrategy DEFAULT_BACKPRESSURE_STRATEGY;
    private static final Core DEFAULT_CORE_CONFIG;
    private final Map additionalConfig;
    private final String clientToken;
    private final Core coreConfig;
    private final boolean crashReportsEnabled;
    private final String env;
    private final String service;
    private final String variant;

    public static /* synthetic */ Configuration copy$default(Configuration configuration, Core core, String str, String str2, String str3, String str4, boolean z, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            core = configuration.coreConfig;
        }
        if ((i & 2) != 0) {
            str = configuration.clientToken;
        }
        if ((i & 4) != 0) {
            str2 = configuration.env;
        }
        if ((i & 8) != 0) {
            str3 = configuration.variant;
        }
        if ((i & 16) != 0) {
            str4 = configuration.service;
        }
        if ((i & 32) != 0) {
            z = configuration.crashReportsEnabled;
        }
        if ((i & 64) != 0) {
            map = configuration.additionalConfig;
        }
        boolean z2 = z;
        Map map2 = map;
        String str5 = str4;
        String str6 = str2;
        return configuration.copy(core, str, str6, str3, str5, z2, map2);
    }

    public final Configuration copy(Core coreConfig, String clientToken, String env, String variant, String str, boolean z, Map additionalConfig) {
        Intrinsics.checkNotNullParameter(coreConfig, "coreConfig");
        Intrinsics.checkNotNullParameter(clientToken, "clientToken");
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(variant, "variant");
        Intrinsics.checkNotNullParameter(additionalConfig, "additionalConfig");
        return new Configuration(coreConfig, clientToken, env, variant, str, z, additionalConfig);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Configuration)) {
            return false;
        }
        Configuration configuration = (Configuration) obj;
        return Intrinsics.areEqual(this.coreConfig, configuration.coreConfig) && Intrinsics.areEqual(this.clientToken, configuration.clientToken) && Intrinsics.areEqual(this.env, configuration.env) && Intrinsics.areEqual(this.variant, configuration.variant) && Intrinsics.areEqual(this.service, configuration.service) && this.crashReportsEnabled == configuration.crashReportsEnabled && Intrinsics.areEqual(this.additionalConfig, configuration.additionalConfig);
    }

    public int hashCode() {
        int iHashCode = ((((((this.coreConfig.hashCode() * 31) + this.clientToken.hashCode()) * 31) + this.env.hashCode()) * 31) + this.variant.hashCode()) * 31;
        String str = this.service;
        return ((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.crashReportsEnabled)) * 31) + this.additionalConfig.hashCode();
    }

    public String toString() {
        return "Configuration(coreConfig=" + this.coreConfig + ", clientToken=" + this.clientToken + ", env=" + this.env + ", variant=" + this.variant + ", service=" + this.service + ", crashReportsEnabled=" + this.crashReportsEnabled + ", additionalConfig=" + this.additionalConfig + ")";
    }

    public Configuration(Core coreConfig, String clientToken, String env, String variant, String str, boolean z, Map additionalConfig) {
        Intrinsics.checkNotNullParameter(coreConfig, "coreConfig");
        Intrinsics.checkNotNullParameter(clientToken, "clientToken");
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(variant, "variant");
        Intrinsics.checkNotNullParameter(additionalConfig, "additionalConfig");
        this.coreConfig = coreConfig;
        this.clientToken = clientToken;
        this.env = env;
        this.variant = variant;
        this.service = str;
        this.crashReportsEnabled = z;
        this.additionalConfig = additionalConfig;
    }

    public final Core getCoreConfig$dd_sdk_android_core_release() {
        return this.coreConfig;
    }

    public final String getClientToken$dd_sdk_android_core_release() {
        return this.clientToken;
    }

    public final String getEnv$dd_sdk_android_core_release() {
        return this.env;
    }

    public final String getVariant$dd_sdk_android_core_release() {
        return this.variant;
    }

    public final String getService$dd_sdk_android_core_release() {
        return this.service;
    }

    public final boolean getCrashReportsEnabled$dd_sdk_android_core_release() {
        return this.crashReportsEnabled;
    }

    public final Map getAdditionalConfig$dd_sdk_android_core_release() {
        return this.additionalConfig;
    }

    public static final class Core {
        private final BackPressureStrategy backpressureStrategy;
        private final BatchProcessingLevel batchProcessingLevel;
        private final BatchSize batchSize;
        private final boolean enableDeveloperModeWhenDebuggable;
        private final Map firstPartyHostsWithHeaderTypes;
        private final boolean needsClearTextHttp;
        private final Proxy proxy;
        private final Authenticator proxyAuth;
        private final DatadogSite site;
        private final UploadFrequency uploadFrequency;
        private final UploadSchedulerStrategy uploadSchedulerStrategy;

        public static /* synthetic */ Core copy$default(Core core, boolean z, boolean z2, Map map, BatchSize batchSize, UploadFrequency uploadFrequency, Proxy proxy, Authenticator authenticator, Encryption encryption, DatadogSite datadogSite, BatchProcessingLevel batchProcessingLevel, PersistenceStrategy.Factory factory, BackPressureStrategy backPressureStrategy, UploadSchedulerStrategy uploadSchedulerStrategy, int i, Object obj) {
            Encryption encryption2;
            if ((i & 1) != 0) {
                z = core.needsClearTextHttp;
            }
            boolean z3 = (i & 2) != 0 ? core.enableDeveloperModeWhenDebuggable : z2;
            Map map2 = (i & 4) != 0 ? core.firstPartyHostsWithHeaderTypes : map;
            BatchSize batchSize2 = (i & 8) != 0 ? core.batchSize : batchSize;
            UploadFrequency uploadFrequency2 = (i & 16) != 0 ? core.uploadFrequency : uploadFrequency;
            Proxy proxy2 = (i & 32) != 0 ? core.proxy : proxy;
            Authenticator authenticator2 = (i & 64) != 0 ? core.proxyAuth : authenticator;
            PersistenceStrategy.Factory factory2 = null;
            if ((i & 128) != 0) {
                core.getClass();
                encryption2 = null;
            } else {
                encryption2 = encryption;
            }
            DatadogSite datadogSite2 = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? core.site : datadogSite;
            BatchProcessingLevel batchProcessingLevel2 = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? core.batchProcessingLevel : batchProcessingLevel;
            if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0) {
                core.getClass();
            } else {
                factory2 = factory;
            }
            return core.copy(z, z3, map2, batchSize2, uploadFrequency2, proxy2, authenticator2, encryption2, datadogSite2, batchProcessingLevel2, factory2, (i & 2048) != 0 ? core.backpressureStrategy : backPressureStrategy, (i & 4096) != 0 ? core.uploadSchedulerStrategy : uploadSchedulerStrategy);
        }

        public final Core copy(boolean z, boolean z2, Map firstPartyHostsWithHeaderTypes, BatchSize batchSize, UploadFrequency uploadFrequency, Proxy proxy, Authenticator proxyAuth, Encryption encryption, DatadogSite site, BatchProcessingLevel batchProcessingLevel, PersistenceStrategy.Factory factory, BackPressureStrategy backpressureStrategy, UploadSchedulerStrategy uploadSchedulerStrategy) {
            Intrinsics.checkNotNullParameter(firstPartyHostsWithHeaderTypes, "firstPartyHostsWithHeaderTypes");
            Intrinsics.checkNotNullParameter(batchSize, "batchSize");
            Intrinsics.checkNotNullParameter(uploadFrequency, "uploadFrequency");
            Intrinsics.checkNotNullParameter(proxyAuth, "proxyAuth");
            Intrinsics.checkNotNullParameter(site, "site");
            Intrinsics.checkNotNullParameter(batchProcessingLevel, "batchProcessingLevel");
            Intrinsics.checkNotNullParameter(backpressureStrategy, "backpressureStrategy");
            return new Core(z, z2, firstPartyHostsWithHeaderTypes, batchSize, uploadFrequency, proxy, proxyAuth, encryption, site, batchProcessingLevel, factory, backpressureStrategy, uploadSchedulerStrategy);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Core)) {
                return false;
            }
            Core core = (Core) obj;
            return this.needsClearTextHttp == core.needsClearTextHttp && this.enableDeveloperModeWhenDebuggable == core.enableDeveloperModeWhenDebuggable && Intrinsics.areEqual(this.firstPartyHostsWithHeaderTypes, core.firstPartyHostsWithHeaderTypes) && this.batchSize == core.batchSize && this.uploadFrequency == core.uploadFrequency && Intrinsics.areEqual(this.proxy, core.proxy) && Intrinsics.areEqual(this.proxyAuth, core.proxyAuth) && Intrinsics.areEqual((Object) null, (Object) null) && this.site == core.site && this.batchProcessingLevel == core.batchProcessingLevel && Intrinsics.areEqual((Object) null, (Object) null) && Intrinsics.areEqual(this.backpressureStrategy, core.backpressureStrategy) && Intrinsics.areEqual(this.uploadSchedulerStrategy, core.uploadSchedulerStrategy);
        }

        public final Encryption getEncryption() {
            return null;
        }

        public final PersistenceStrategy.Factory getPersistenceStrategyFactory() {
            return null;
        }

        public int hashCode() {
            int iHashCode = ((((((((Boolean.hashCode(this.needsClearTextHttp) * 31) + Boolean.hashCode(this.enableDeveloperModeWhenDebuggable)) * 31) + this.firstPartyHostsWithHeaderTypes.hashCode()) * 31) + this.batchSize.hashCode()) * 31) + this.uploadFrequency.hashCode()) * 31;
            Proxy proxy = this.proxy;
            int iHashCode2 = (((((((((iHashCode + (proxy == null ? 0 : proxy.hashCode())) * 31) + this.proxyAuth.hashCode()) * 961) + this.site.hashCode()) * 31) + this.batchProcessingLevel.hashCode()) * 961) + this.backpressureStrategy.hashCode()) * 31;
            UploadSchedulerStrategy uploadSchedulerStrategy = this.uploadSchedulerStrategy;
            return iHashCode2 + (uploadSchedulerStrategy != null ? uploadSchedulerStrategy.hashCode() : 0);
        }

        public String toString() {
            return "Core(needsClearTextHttp=" + this.needsClearTextHttp + ", enableDeveloperModeWhenDebuggable=" + this.enableDeveloperModeWhenDebuggable + ", firstPartyHostsWithHeaderTypes=" + this.firstPartyHostsWithHeaderTypes + ", batchSize=" + this.batchSize + ", uploadFrequency=" + this.uploadFrequency + ", proxy=" + this.proxy + ", proxyAuth=" + this.proxyAuth + ", encryption=" + ((Object) null) + ", site=" + this.site + ", batchProcessingLevel=" + this.batchProcessingLevel + ", persistenceStrategyFactory=" + ((Object) null) + ", backpressureStrategy=" + this.backpressureStrategy + ", uploadSchedulerStrategy=" + this.uploadSchedulerStrategy + ")";
        }

        public Core(boolean z, boolean z2, Map firstPartyHostsWithHeaderTypes, BatchSize batchSize, UploadFrequency uploadFrequency, Proxy proxy, Authenticator proxyAuth, Encryption encryption, DatadogSite site, BatchProcessingLevel batchProcessingLevel, PersistenceStrategy.Factory factory, BackPressureStrategy backpressureStrategy, UploadSchedulerStrategy uploadSchedulerStrategy) {
            Intrinsics.checkNotNullParameter(firstPartyHostsWithHeaderTypes, "firstPartyHostsWithHeaderTypes");
            Intrinsics.checkNotNullParameter(batchSize, "batchSize");
            Intrinsics.checkNotNullParameter(uploadFrequency, "uploadFrequency");
            Intrinsics.checkNotNullParameter(proxyAuth, "proxyAuth");
            Intrinsics.checkNotNullParameter(site, "site");
            Intrinsics.checkNotNullParameter(batchProcessingLevel, "batchProcessingLevel");
            Intrinsics.checkNotNullParameter(backpressureStrategy, "backpressureStrategy");
            this.needsClearTextHttp = z;
            this.enableDeveloperModeWhenDebuggable = z2;
            this.firstPartyHostsWithHeaderTypes = firstPartyHostsWithHeaderTypes;
            this.batchSize = batchSize;
            this.uploadFrequency = uploadFrequency;
            this.proxy = proxy;
            this.proxyAuth = proxyAuth;
            this.site = site;
            this.batchProcessingLevel = batchProcessingLevel;
            this.backpressureStrategy = backpressureStrategy;
            this.uploadSchedulerStrategy = uploadSchedulerStrategy;
        }

        public final boolean getNeedsClearTextHttp() {
            return this.needsClearTextHttp;
        }

        public final boolean getEnableDeveloperModeWhenDebuggable() {
            return this.enableDeveloperModeWhenDebuggable;
        }

        public final Map getFirstPartyHostsWithHeaderTypes() {
            return this.firstPartyHostsWithHeaderTypes;
        }

        public final BatchSize getBatchSize() {
            return this.batchSize;
        }

        public final UploadFrequency getUploadFrequency() {
            return this.uploadFrequency;
        }

        public final Proxy getProxy() {
            return this.proxy;
        }

        public final Authenticator getProxyAuth() {
            return this.proxyAuth;
        }

        public final DatadogSite getSite() {
            return this.site;
        }

        public final BatchProcessingLevel getBatchProcessingLevel() {
            return this.batchProcessingLevel;
        }

        public final BackPressureStrategy getBackpressureStrategy() {
            return this.backpressureStrategy;
        }

        public final UploadSchedulerStrategy getUploadSchedulerStrategy() {
            return this.uploadSchedulerStrategy;
        }
    }

    public static final class Builder {
        private Map additionalConfig;
        private final String clientToken;
        private Core coreConfig;
        private boolean crashReportsEnabled;
        private final String env;
        private HostsSanitizer hostsSanitizer;
        private final String service;
        private final String variant;

        public Builder(String clientToken, String env, String variant, String str) {
            Intrinsics.checkNotNullParameter(clientToken, "clientToken");
            Intrinsics.checkNotNullParameter(env, "env");
            Intrinsics.checkNotNullParameter(variant, "variant");
            this.clientToken = clientToken;
            this.env = env;
            this.variant = variant;
            this.service = str;
            this.additionalConfig = MapsKt.emptyMap();
            this.coreConfig = Configuration.Companion.getDEFAULT_CORE_CONFIG$dd_sdk_android_core_release();
            this.crashReportsEnabled = true;
            this.hostsSanitizer = new HostsSanitizer();
        }

        public final Configuration build() {
            return new Configuration(this.coreConfig, this.clientToken, this.env, this.variant, this.service, this.crashReportsEnabled, this.additionalConfig);
        }

        public final Builder setFirstPartyHostsWithHeaderType(Map hostsWithHeaderType) {
            Intrinsics.checkNotNullParameter(hostsWithHeaderType, "hostsWithHeaderType");
            List listSanitizeHosts = this.hostsSanitizer.sanitizeHosts(CollectionsKt.toList(hostsWithHeaderType.keySet()), "Network requests");
            Core core = this.coreConfig;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : hostsWithHeaderType.entrySet()) {
                if (listSanitizeHosts.contains((String) entry.getKey())) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            this.coreConfig = Core.copy$default(core, false, false, linkedHashMap, null, null, null, null, null, null, null, null, null, null, 8187, null);
            return this;
        }

        public final Builder useSite(DatadogSite site) {
            Intrinsics.checkNotNullParameter(site, "site");
            this.coreConfig = Core.copy$default(this.coreConfig, false, false, null, null, null, null, null, null, site, null, null, null, null, 7934, null);
            return this;
        }

        public final Builder setBatchSize(BatchSize batchSize) {
            Intrinsics.checkNotNullParameter(batchSize, "batchSize");
            this.coreConfig = Core.copy$default(this.coreConfig, false, false, null, batchSize, null, null, null, null, null, null, null, null, null, 8183, null);
            return this;
        }

        public final Builder setUploadFrequency(UploadFrequency uploadFrequency) {
            Intrinsics.checkNotNullParameter(uploadFrequency, "uploadFrequency");
            this.coreConfig = Core.copy$default(this.coreConfig, false, false, null, null, uploadFrequency, null, null, null, null, null, null, null, null, 8175, null);
            return this;
        }

        public final Builder setBatchProcessingLevel(BatchProcessingLevel batchProcessingLevel) {
            Intrinsics.checkNotNullParameter(batchProcessingLevel, "batchProcessingLevel");
            this.coreConfig = Core.copy$default(this.coreConfig, false, false, null, null, null, null, null, null, null, batchProcessingLevel, null, null, null, 7679, null);
            return this;
        }

        public final Builder setAdditionalConfiguration(Map additionalConfig) {
            Intrinsics.checkNotNullParameter(additionalConfig, "additionalConfig");
            this.additionalConfig = additionalConfig;
            return this;
        }

        public final Builder setProxy(Proxy proxy, Authenticator authenticator) {
            Intrinsics.checkNotNullParameter(proxy, "proxy");
            this.coreConfig = Core.copy$default(this.coreConfig, false, false, null, null, null, proxy, authenticator == null ? Authenticator.NONE : authenticator, null, null, null, null, null, null, 8095, null);
            return this;
        }

        public final Builder setCrashReportsEnabled(boolean z) {
            this.crashReportsEnabled = z;
            return this;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Core getDEFAULT_CORE_CONFIG$dd_sdk_android_core_release() {
            return Configuration.DEFAULT_CORE_CONFIG;
        }
    }

    static {
        BackPressureStrategy backPressureStrategy = new BackPressureStrategy(IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET, new Function0() { // from class: com.datadog.android.core.configuration.Configuration$Companion$DEFAULT_BACKPRESSURE_STRATEGY$1
            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m3141invoke() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m3141invoke();
                return Unit.INSTANCE;
            }
        }, new Function1() { // from class: com.datadog.android.core.configuration.Configuration$Companion$DEFAULT_BACKPRESSURE_STRATEGY$2
            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m3142invoke(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m3142invoke(obj);
                return Unit.INSTANCE;
            }
        }, BackPressureMitigation.IGNORE_NEWEST);
        DEFAULT_BACKPRESSURE_STRATEGY = backPressureStrategy;
        DEFAULT_CORE_CONFIG = new Core(false, false, MapsKt.emptyMap(), BatchSize.MEDIUM, UploadFrequency.AVERAGE, null, Authenticator.NONE, null, DatadogSite.US1, BatchProcessingLevel.MEDIUM, null, backPressureStrategy, null);
    }
}
