package io.sentry.util;

import com.amazon.a.a.o.b.f;
import io.sentry.SentryIntegrationPackageStorage;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

/* JADX INFO: loaded from: classes5.dex */
public abstract class DebugMetaPropertiesApplier {
    public static String DEBUG_META_PROPERTIES_FILENAME = "sentry-debug-meta.properties";

    public static void apply(SentryOptions sentryOptions, List list) {
        if (list != null) {
            applyToOptions(sentryOptions, list);
            applyBuildTool(sentryOptions, list);
            applyDistributionOptions(sentryOptions, list);
        }
    }

    public static void applyToOptions(SentryOptions sentryOptions, List list) {
        if (list != null) {
            applyBundleIds(sentryOptions, list);
            applyProguardUuid(sentryOptions, list);
        }
    }

    private static void applyBundleIds(SentryOptions sentryOptions, List list) {
        if (sentryOptions.getBundleIds().isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String property = ((Properties) it.next()).getProperty("io.sentry.bundle-ids");
                sentryOptions.getLogger().log(SentryLevel.DEBUG, "Bundle IDs found: %s", property);
                if (property != null) {
                    for (String str : property.split(f.a, -1)) {
                        sentryOptions.addBundleId(str);
                    }
                }
            }
        }
    }

    private static void applyProguardUuid(SentryOptions sentryOptions, List list) {
        if (sentryOptions.getProguardUuid() == null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String proguardUuid = getProguardUuid((Properties) it.next());
                if (proguardUuid != null) {
                    sentryOptions.getLogger().log(SentryLevel.DEBUG, "Proguard UUID found: %s", proguardUuid);
                    sentryOptions.setProguardUuid(proguardUuid);
                    return;
                }
            }
        }
    }

    private static void applyBuildTool(SentryOptions sentryOptions, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Properties properties = (Properties) it.next();
            String buildTool = getBuildTool(properties);
            if (buildTool != null) {
                String buildToolVersion = getBuildToolVersion(properties);
                if (buildToolVersion == null) {
                    buildToolVersion = "unknown";
                }
                sentryOptions.getLogger().log(SentryLevel.DEBUG, "Build tool found: %s, version %s", buildTool, buildToolVersion);
                SentryIntegrationPackageStorage.getInstance().addPackage(buildTool, buildToolVersion);
                return;
            }
        }
    }

    public static String getProguardUuid(Properties properties) {
        return properties.getProperty("io.sentry.ProguardUuids");
    }

    public static String getBuildTool(Properties properties) {
        return properties.getProperty("io.sentry.build-tool");
    }

    public static String getBuildToolVersion(Properties properties) {
        return properties.getProperty("io.sentry.build-tool-version");
    }

    private static void applyDistributionOptions(SentryOptions sentryOptions, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Properties properties = (Properties) it.next();
            String distributionOrgSlug = getDistributionOrgSlug(properties);
            String distributionProjectSlug = getDistributionProjectSlug(properties);
            String distributionAuthToken = getDistributionAuthToken(properties);
            String distributionBuildConfiguration = getDistributionBuildConfiguration(properties);
            String distributionInstallGroupsOverride = getDistributionInstallGroupsOverride(properties);
            if (distributionOrgSlug != null || distributionProjectSlug != null || distributionAuthToken != null || distributionBuildConfiguration != null || distributionInstallGroupsOverride != null) {
                SentryOptions.DistributionOptions distribution = sentryOptions.getDistribution();
                if (distributionOrgSlug != null && !distributionOrgSlug.isEmpty() && distribution.orgSlug.isEmpty()) {
                    sentryOptions.getLogger().log(SentryLevel.DEBUG, "Distribution org slug found: %s", distributionOrgSlug);
                    distribution.orgSlug = distributionOrgSlug;
                }
                if (distributionProjectSlug != null && !distributionProjectSlug.isEmpty() && distribution.projectSlug.isEmpty()) {
                    sentryOptions.getLogger().log(SentryLevel.DEBUG, "Distribution project slug found: %s", distributionProjectSlug);
                    distribution.projectSlug = distributionProjectSlug;
                }
                if (distributionAuthToken != null && !distributionAuthToken.isEmpty() && distribution.orgAuthToken.isEmpty()) {
                    sentryOptions.getLogger().log(SentryLevel.DEBUG, "Distribution org auth token found", new Object[0]);
                    distribution.orgAuthToken = distributionAuthToken;
                }
                if (distributionBuildConfiguration != null && !distributionBuildConfiguration.isEmpty() && distribution.buildConfiguration == null) {
                    sentryOptions.getLogger().log(SentryLevel.DEBUG, "Distribution build configuration found: %s", distributionBuildConfiguration);
                    distribution.buildConfiguration = distributionBuildConfiguration;
                }
                if (distributionInstallGroupsOverride == null || distributionInstallGroupsOverride.isEmpty() || distribution.installGroupsOverride != null) {
                    return;
                }
                String[] strArrSplit = distributionInstallGroupsOverride.split(f.a, -1);
                ArrayList arrayList = new ArrayList();
                for (String str : strArrSplit) {
                    String strTrim = str.trim();
                    if (!strTrim.isEmpty()) {
                        arrayList.add(strTrim);
                    }
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                sentryOptions.getLogger().log(SentryLevel.DEBUG, "Distribution install groups override found: %s", arrayList);
                distribution.installGroupsOverride = arrayList;
                return;
            }
        }
    }

    private static String getDistributionOrgSlug(Properties properties) {
        return properties.getProperty("io.sentry.distribution.org-slug");
    }

    private static String getDistributionProjectSlug(Properties properties) {
        return properties.getProperty("io.sentry.distribution.project-slug");
    }

    private static String getDistributionAuthToken(Properties properties) {
        return properties.getProperty("io.sentry.distribution.auth-token");
    }

    private static String getDistributionBuildConfiguration(Properties properties) {
        return properties.getProperty("io.sentry.distribution.build-configuration");
    }

    private static String getDistributionInstallGroupsOverride(Properties properties) {
        return properties.getProperty("io.sentry.distribution.install-groups-override");
    }
}
