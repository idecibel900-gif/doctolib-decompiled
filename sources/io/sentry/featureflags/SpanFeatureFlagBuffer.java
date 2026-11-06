package io.sentry.featureflags;

import io.sentry.ISentryLifecycleToken;
import io.sentry.protocol.FeatureFlag;
import io.sentry.protocol.FeatureFlags;
import io.sentry.util.AutoClosableReentrantLock;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class SpanFeatureFlagBuffer implements IFeatureFlagBuffer {
    private Map flags = null;
    private final AutoClosableReentrantLock lock = new AutoClosableReentrantLock();

    private SpanFeatureFlagBuffer() {
    }

    @Override // io.sentry.featureflags.IFeatureFlagBuffer
    public void clear() {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            this.flags = null;
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
        } catch (Throwable th) {
            if (iSentryLifecycleTokenAcquire != null) {
                try {
                    iSentryLifecycleTokenAcquire.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // io.sentry.featureflags.IFeatureFlagBuffer
    public FeatureFlags getFeatureFlags() {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            Map map = this.flags;
            if (map != null && !map.isEmpty()) {
                ArrayList arrayList = new ArrayList(this.flags.size());
                for (Map.Entry entry : this.flags.entrySet()) {
                    arrayList.add(new FeatureFlag((String) entry.getKey(), ((Boolean) entry.getValue()).booleanValue()));
                }
                FeatureFlags featureFlags = new FeatureFlags(arrayList);
                if (iSentryLifecycleTokenAcquire != null) {
                    iSentryLifecycleTokenAcquire.close();
                }
                return featureFlags;
            }
            if (iSentryLifecycleTokenAcquire != null) {
                iSentryLifecycleTokenAcquire.close();
            }
            return null;
        } catch (Throwable th) {
            if (iSentryLifecycleTokenAcquire != null) {
                try {
                    iSentryLifecycleTokenAcquire.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // io.sentry.featureflags.IFeatureFlagBuffer
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public IFeatureFlagBuffer m5220clone() {
        return create();
    }

    public static IFeatureFlagBuffer create() {
        return new SpanFeatureFlagBuffer();
    }
}
