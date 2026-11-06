package com.datadog.android.core.internal.thread;

import com.datadog.android.internal.thread.NamedRunnable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ObservableLinkedBlockingQueue extends LinkedBlockingQueue {
    public static final Companion Companion = new Companion(null);
    private static final long DUMPING_TIME_INTERVAL_IN_MS = TimeUnit.SECONDS.toMillis(5);
    private final Function0 currentTimeProvider;
    private AtomicLong lastDumpTimestamp;

    public /* bridge */ int getSize() {
        return super.size();
    }

    @Override // java.util.concurrent.LinkedBlockingQueue, java.util.AbstractCollection, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    public /* synthetic */ ObservableLinkedBlockingQueue(int i, Function0 function0, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? new Function0() { // from class: com.datadog.android.core.internal.thread.ObservableLinkedBlockingQueue.1
            @Override // kotlin.jvm.functions.Function0
            public final Long invoke() {
                return Long.valueOf(System.currentTimeMillis());
            }
        } : function0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObservableLinkedBlockingQueue(int i, Function0 currentTimeProvider) {
        super(i);
        Intrinsics.checkNotNullParameter(currentTimeProvider, "currentTimeProvider");
        this.currentTimeProvider = currentTimeProvider;
        this.lastDumpTimestamp = new AtomicLong(0L);
    }

    public final Map dumpQueue() {
        long jLongValue = ((Number) this.currentTimeProvider.invoke()).longValue();
        long j = this.lastDumpTimestamp.get();
        if (jLongValue - j <= DUMPING_TIME_INTERVAL_IN_MS || !this.lastDumpTimestamp.compareAndSet(j, jLongValue)) {
            return null;
        }
        return buildDumpMap();
    }

    private final Map buildDumpMap() {
        String sanitizedName;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Object[] array = super.toArray();
        Intrinsics.checkNotNullExpressionValue(array, "super.toArray()");
        for (Object obj : array) {
            NamedRunnable namedRunnable = obj instanceof NamedRunnable ? (NamedRunnable) obj : null;
            if (namedRunnable != null && (sanitizedName = namedRunnable.getSanitizedName()) != null) {
                Integer num = (Integer) linkedHashMap.get(sanitizedName);
                linkedHashMap.put(sanitizedName, Integer.valueOf((num != null ? num.intValue() : 0) + 1));
            }
        }
        return linkedHashMap;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
