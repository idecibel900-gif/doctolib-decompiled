package io.sentry.featureflags;

import android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0;
import io.sentry.ISentryLifecycleToken;
import io.sentry.SentryOptions;
import io.sentry.protocol.FeatureFlags;
import io.sentry.util.AutoClosableReentrantLock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes5.dex */
public final class FeatureFlagBuffer implements IFeatureFlagBuffer {
    private volatile CopyOnWriteArrayList flags;
    private final AutoClosableReentrantLock lock;
    private int maxSize;

    private FeatureFlagBuffer(int i) {
        this.lock = new AutoClosableReentrantLock();
        this.maxSize = i;
        this.flags = new CopyOnWriteArrayList();
    }

    private FeatureFlagBuffer(int i, CopyOnWriteArrayList copyOnWriteArrayList) {
        this.lock = new AutoClosableReentrantLock();
        this.maxSize = i;
        this.flags = copyOnWriteArrayList;
    }

    private FeatureFlagBuffer(FeatureFlagBuffer featureFlagBuffer) {
        this.lock = new AutoClosableReentrantLock();
        this.maxSize = featureFlagBuffer.maxSize;
        this.flags = new CopyOnWriteArrayList(featureFlagBuffer.flags);
    }

    @Override // io.sentry.featureflags.IFeatureFlagBuffer
    public void clear() {
        ISentryLifecycleToken iSentryLifecycleTokenAcquire = this.lock.acquire();
        try {
            this.flags.clear();
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
        ArrayList arrayList = new ArrayList();
        Iterator it = this.flags.iterator();
        if (it.hasNext()) {
            MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(it.next());
            throw null;
        }
        return new FeatureFlags(arrayList);
    }

    @Override // io.sentry.featureflags.IFeatureFlagBuffer
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public IFeatureFlagBuffer m5218clone() {
        return new FeatureFlagBuffer(this);
    }

    public static IFeatureFlagBuffer create(SentryOptions sentryOptions) {
        int maxFeatureFlags = sentryOptions.getMaxFeatureFlags();
        if (maxFeatureFlags > 0) {
            return new FeatureFlagBuffer(maxFeatureFlags);
        }
        return NoOpFeatureFlagBuffer.getInstance();
    }

    public static IFeatureFlagBuffer merged(SentryOptions sentryOptions, IFeatureFlagBuffer iFeatureFlagBuffer, IFeatureFlagBuffer iFeatureFlagBuffer2, IFeatureFlagBuffer iFeatureFlagBuffer3) {
        int maxFeatureFlags = sentryOptions.getMaxFeatureFlags();
        if (maxFeatureFlags <= 0) {
            return NoOpFeatureFlagBuffer.getInstance();
        }
        return merged(maxFeatureFlags, iFeatureFlagBuffer instanceof FeatureFlagBuffer ? (FeatureFlagBuffer) iFeatureFlagBuffer : null, iFeatureFlagBuffer2 instanceof FeatureFlagBuffer ? (FeatureFlagBuffer) iFeatureFlagBuffer2 : null, iFeatureFlagBuffer3 instanceof FeatureFlagBuffer ? (FeatureFlagBuffer) iFeatureFlagBuffer3 : null);
    }

    private static IFeatureFlagBuffer merged(int i, FeatureFlagBuffer featureFlagBuffer, FeatureFlagBuffer featureFlagBuffer2, FeatureFlagBuffer featureFlagBuffer3) {
        CopyOnWriteArrayList copyOnWriteArrayList = featureFlagBuffer == null ? null : featureFlagBuffer.flags;
        CopyOnWriteArrayList copyOnWriteArrayList2 = featureFlagBuffer2 == null ? null : featureFlagBuffer2.flags;
        CopyOnWriteArrayList copyOnWriteArrayList3 = featureFlagBuffer3 != null ? featureFlagBuffer3.flags : null;
        int size = copyOnWriteArrayList == null ? 0 : copyOnWriteArrayList.size();
        int size2 = copyOnWriteArrayList2 == null ? 0 : copyOnWriteArrayList2.size();
        int size3 = copyOnWriteArrayList3 != null ? copyOnWriteArrayList3.size() : 0;
        if (size == 0 && size2 == 0 && size3 == 0) {
            return NoOpFeatureFlagBuffer.getInstance();
        }
        int i2 = size - 1;
        int i3 = size2 - 1;
        int i4 = size3 - 1;
        if (copyOnWriteArrayList != null && i2 >= 0) {
            MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(copyOnWriteArrayList.get(i2));
        }
        if (copyOnWriteArrayList2 != null && i3 >= 0) {
            MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(copyOnWriteArrayList2.get(i3));
        }
        if (copyOnWriteArrayList3 != null && i4 >= 0) {
            MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(copyOnWriteArrayList3.get(i4));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(i);
        linkedHashMap.size();
        ArrayList arrayList = new ArrayList(linkedHashMap.values());
        Collections.reverse(arrayList);
        return new FeatureFlagBuffer(i, new CopyOnWriteArrayList(arrayList));
    }
}
