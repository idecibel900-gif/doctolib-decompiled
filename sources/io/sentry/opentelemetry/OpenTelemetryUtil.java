package io.sentry.opentelemetry;

import io.sentry.NoOpLogger;
import io.sentry.SentryLevel;
import io.sentry.SentryOpenTelemetryMode;
import io.sentry.SentryOptions;
import io.sentry.util.LoadClass;
import io.sentry.util.Platform;
import io.sentry.util.SpanUtils;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public abstract class OpenTelemetryUtil {
    public static void applyIgnoredSpanOrigins(SentryOptions sentryOptions) {
        if (Platform.isJvm()) {
            Iterator it = ignoredSpanOrigins(sentryOptions).iterator();
            while (it.hasNext()) {
                sentryOptions.addIgnoredSpanOrigin((String) it.next());
            }
        }
    }

    public static void updateOpenTelemetryModeIfAuto(SentryOptions sentryOptions, LoadClass loadClass) {
        if (Platform.isJvm()) {
            if (SentryOpenTelemetryMode.AUTO.equals(sentryOptions.getOpenTelemetryMode())) {
                if (loadClass.isClassAvailable("io.sentry.opentelemetry.agent.AgentMarker", NoOpLogger.getInstance())) {
                    sentryOptions.getLogger().log(SentryLevel.DEBUG, "openTelemetryMode has been inferred from AUTO to AGENT", new Object[0]);
                    sentryOptions.setOpenTelemetryMode(SentryOpenTelemetryMode.AGENT);
                } else if (loadClass.isClassAvailable("io.sentry.opentelemetry.agent.AgentlessMarker", NoOpLogger.getInstance())) {
                    sentryOptions.getLogger().log(SentryLevel.DEBUG, "openTelemetryMode has been inferred from AUTO to AGENTLESS", new Object[0]);
                    sentryOptions.setOpenTelemetryMode(SentryOpenTelemetryMode.AGENTLESS);
                } else if (loadClass.isClassAvailable("io.sentry.opentelemetry.agent.AgentlessSpringMarker", NoOpLogger.getInstance())) {
                    sentryOptions.getLogger().log(SentryLevel.DEBUG, "openTelemetryMode has been inferred from AUTO to AGENTLESS_SPRING", new Object[0]);
                    sentryOptions.setOpenTelemetryMode(SentryOpenTelemetryMode.AGENTLESS_SPRING);
                }
            }
        }
    }

    private static List ignoredSpanOrigins(SentryOptions sentryOptions) {
        SentryOpenTelemetryMode openTelemetryMode = sentryOptions.getOpenTelemetryMode();
        if (SentryOpenTelemetryMode.OFF.equals(openTelemetryMode)) {
            return Collections.EMPTY_LIST;
        }
        return SpanUtils.ignoredSpanOriginsForOpenTelemetry(openTelemetryMode);
    }
}
