package com.datadog.android.core.internal;

import androidx.core.content.res.FontResourcesParserCompat$$ExternalSyntheticAutoCloseableForwarder1;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.context.NetworkInfo;
import com.datadog.android.api.context.TimeInfo;
import com.datadog.android.api.feature.Feature;
import com.datadog.android.api.feature.FeatureContextUpdateReceiver;
import com.datadog.android.api.feature.FeatureEventReceiver;
import com.datadog.android.api.feature.FeatureScope;
import com.datadog.android.core.InternalSdkCore;
import com.datadog.android.core.internal.logger.SdkInternalLogger;
import com.datadog.android.core.internal.net.DefaultFirstPartyHostHeaderTypeResolver;
import com.datadog.android.core.internal.net.FirstPartyHostHeaderTypeResolver;
import com.datadog.android.privacy.TrackingConsent;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes3.dex */
public final class NoOpInternalSdkCore implements InternalSdkCore {
    public static final NoOpInternalSdkCore INSTANCE = new NoOpInternalSdkCore();
    private static final String name = "no-op";
    private static final TimeInfo time;

    @Override // com.datadog.android.api.SdkCore
    public void addUserProperties(Map extraInfo) {
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
    }

    @Override // com.datadog.android.api.SdkCore
    public void clearAllData() {
    }

    @Override // com.datadog.android.core.InternalSdkCore
    public long getAppStartTimeNs() {
        return 0L;
    }

    @Override // com.datadog.android.core.InternalSdkCore
    public DatadogContext getDatadogContext() {
        return null;
    }

    @Override // com.datadog.android.api.feature.FeatureSdkCore
    public FeatureScope getFeature(String featureName) {
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        return null;
    }

    @Override // com.datadog.android.core.InternalSdkCore
    public Long getLastFatalAnrSent() {
        return null;
    }

    @Override // com.datadog.android.core.InternalSdkCore
    public JsonObject getLastViewEvent() {
        return null;
    }

    @Override // com.datadog.android.core.InternalSdkCore
    public boolean isDeveloperModeEnabled() {
        return false;
    }

    @Override // com.datadog.android.api.feature.FeatureSdkCore
    public void registerFeature(Feature feature) {
        Intrinsics.checkNotNullParameter(feature, "feature");
    }

    @Override // com.datadog.android.api.feature.FeatureSdkCore
    public void removeContextUpdateReceiver(String featureName, FeatureContextUpdateReceiver listener) {
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    @Override // com.datadog.android.api.feature.FeatureSdkCore
    public void removeEventReceiver(String featureName) {
        Intrinsics.checkNotNullParameter(featureName, "featureName");
    }

    @Override // com.datadog.android.api.feature.FeatureSdkCore
    public void setAnonymousId(UUID uuid) {
    }

    @Override // com.datadog.android.api.feature.FeatureSdkCore
    public void setContextUpdateReceiver(String featureName, FeatureContextUpdateReceiver listener) {
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    @Override // com.datadog.android.api.feature.FeatureSdkCore
    public void setEventReceiver(String featureName, FeatureEventReceiver receiver) {
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
    }

    @Override // com.datadog.android.api.SdkCore
    public void setTrackingConsent(TrackingConsent consent) {
        Intrinsics.checkNotNullParameter(consent, "consent");
    }

    @Override // com.datadog.android.api.SdkCore
    public void setUserInfo(String str, String str2, String str3, Map extraInfo) {
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
    }

    @Override // com.datadog.android.api.feature.FeatureSdkCore
    public void updateFeatureContext(String featureName, Function1 updateCallback) {
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        Intrinsics.checkNotNullParameter(updateCallback, "updateCallback");
    }

    @Override // com.datadog.android.core.InternalSdkCore
    public void writeLastFatalAnrSent(long j) {
    }

    @Override // com.datadog.android.core.InternalSdkCore
    public void writeLastViewEvent(byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    private NoOpInternalSdkCore() {
    }

    static {
        long jCurrentTimeMillis = System.currentTimeMillis();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        time = new TimeInfo(timeUnit.toNanos(jCurrentTimeMillis), timeUnit.toNanos(jCurrentTimeMillis), 0L, 0L);
    }

    @Override // com.datadog.android.api.SdkCore
    public String getName() {
        return name;
    }

    @Override // com.datadog.android.api.SdkCore
    public TimeInfo getTime() {
        return time;
    }

    @Override // com.datadog.android.api.SdkCore
    public String getService() {
        return "";
    }

    @Override // com.datadog.android.api.feature.FeatureSdkCore
    public InternalLogger getInternalLogger() {
        return new SdkInternalLogger(this, null, null, 6, null);
    }

    @Override // com.datadog.android.core.InternalSdkCore
    public NetworkInfo getNetworkInfo() {
        return new NetworkInfo(NetworkInfo.Connectivity.NETWORK_OTHER, null, null, null, null, null, null, WebSocketProtocol.PAYLOAD_SHORT, null);
    }

    @Override // com.datadog.android.core.InternalSdkCore
    public FirstPartyHostHeaderTypeResolver getFirstPartyHostResolver() {
        return new DefaultFirstPartyHostHeaderTypeResolver(MapsKt.emptyMap());
    }

    @Override // com.datadog.android.api.feature.FeatureSdkCore
    public Map getFeatureContext(String featureName) {
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        return MapsKt.emptyMap();
    }

    @Override // com.datadog.android.api.feature.FeatureSdkCore
    public ExecutorService createSingleThreadExecutorService(String executorContext) {
        Intrinsics.checkNotNullParameter(executorContext, "executorContext");
        return new NoOpExecutorService();
    }

    @Override // com.datadog.android.api.feature.FeatureSdkCore
    public ScheduledExecutorService createScheduledExecutorService(String executorContext) {
        Intrinsics.checkNotNullParameter(executorContext, "executorContext");
        return new NoOpScheduledExecutorService();
    }

    @Override // com.datadog.android.core.InternalSdkCore
    public ExecutorService getPersistenceExecutorService() {
        return new NoOpExecutorService();
    }

    @Override // com.datadog.android.core.InternalSdkCore
    public List getAllFeatures() {
        return CollectionsKt.emptyList();
    }

    public static final class NoOpExecutorService implements ExecutorService, AutoCloseable {
        @Override // java.util.concurrent.ExecutorService
        public boolean awaitTermination(long j, TimeUnit timeUnit) {
            return true;
        }

        @Override // java.lang.AutoCloseable
        public /* synthetic */ void close() {
            FontResourcesParserCompat$$ExternalSyntheticAutoCloseableForwarder1.m(this);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
        }

        @Override // java.util.concurrent.ExecutorService
        public Object invokeAny(Collection collection) {
            return null;
        }

        @Override // java.util.concurrent.ExecutorService
        public Object invokeAny(Collection collection, long j, TimeUnit timeUnit) {
            return null;
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isShutdown() {
            return true;
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isTerminated() {
            return true;
        }

        @Override // java.util.concurrent.ExecutorService
        public void shutdown() {
        }

        @Override // java.util.concurrent.ExecutorService
        public Future submit(Runnable runnable) {
            return null;
        }

        @Override // java.util.concurrent.ExecutorService
        public Future submit(Runnable runnable, Object obj) {
            return null;
        }

        @Override // java.util.concurrent.ExecutorService
        public Future submit(Callable callable) {
            return null;
        }

        @Override // java.util.concurrent.ExecutorService
        public List shutdownNow() {
            return new ArrayList();
        }

        @Override // java.util.concurrent.ExecutorService
        public List invokeAll(Collection collection) {
            return new ArrayList();
        }

        @Override // java.util.concurrent.ExecutorService
        public List invokeAll(Collection collection, long j, TimeUnit timeUnit) {
            return new ArrayList();
        }
    }

    public static final class NoOpScheduledExecutorService implements ScheduledExecutorService, AutoCloseable {
        @Override // java.util.concurrent.ExecutorService
        public boolean awaitTermination(long j, TimeUnit timeUnit) {
            return true;
        }

        @Override // java.lang.AutoCloseable
        public /* synthetic */ void close() {
            FontResourcesParserCompat$$ExternalSyntheticAutoCloseableForwarder1.m(this);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
        }

        @Override // java.util.concurrent.ExecutorService
        public Object invokeAny(Collection collection) {
            return null;
        }

        @Override // java.util.concurrent.ExecutorService
        public Object invokeAny(Collection collection, long j, TimeUnit timeUnit) {
            return null;
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isShutdown() {
            return true;
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isTerminated() {
            return true;
        }

        @Override // java.util.concurrent.ExecutorService
        public void shutdown() {
        }

        @Override // java.util.concurrent.ExecutorService
        public Future submit(Runnable runnable) {
            return null;
        }

        @Override // java.util.concurrent.ExecutorService
        public Future submit(Runnable runnable, Object obj) {
            return null;
        }

        @Override // java.util.concurrent.ExecutorService
        public Future submit(Callable callable) {
            return null;
        }

        @Override // java.util.concurrent.ExecutorService
        public List shutdownNow() {
            return new ArrayList();
        }

        @Override // java.util.concurrent.ExecutorService
        public List invokeAll(Collection collection) {
            return new ArrayList();
        }

        @Override // java.util.concurrent.ExecutorService
        public List invokeAll(Collection collection, long j, TimeUnit timeUnit) {
            return new ArrayList();
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture schedule(Callable callable, long j, TimeUnit timeUnit) {
            return new NoOpScheduledFuture();
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            return new NoOpScheduledFuture();
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            return new NoOpScheduledFuture();
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            return new NoOpScheduledFuture();
        }
    }

    public static final class NoOpScheduledFuture implements ScheduledFuture {
        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z) {
            return false;
        }

        @Override // java.lang.Comparable
        public int compareTo(Delayed delayed) {
            return 0;
        }

        @Override // java.util.concurrent.Delayed
        public long getDelay(TimeUnit timeUnit) {
            return 0L;
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return false;
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return false;
        }

        @Override // java.util.concurrent.Future
        public Object get() throws ExecutionException {
            throw new ExecutionException("Unsupported", new UnsupportedOperationException());
        }

        @Override // java.util.concurrent.Future
        public Object get(long j, TimeUnit timeUnit) throws ExecutionException {
            throw new ExecutionException("Unsupported", new UnsupportedOperationException());
        }
    }
}
