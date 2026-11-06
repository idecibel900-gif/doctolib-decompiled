package io.sentry.clientreport;

import io.sentry.DataCategory;
import io.sentry.util.LazyEvaluator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes5.dex */
final class AtomicClientReportStorage implements IClientReportStorage {
    private final LazyEvaluator lostEventCounts = new LazyEvaluator(new LazyEvaluator.Evaluator() { // from class: io.sentry.clientreport.AtomicClientReportStorage$$ExternalSyntheticLambda0
        @Override // io.sentry.util.LazyEvaluator.Evaluator
        public final Object evaluate() {
            return AtomicClientReportStorage.m5217$r8$lambda$tV5iJfbZGrF4smxrKjz_spAqQ0();
        }
    });

    /* JADX INFO: renamed from: $r8$lambda$tV5iJfbZGrF4s-mxrKjz_spAqQ0, reason: not valid java name */
    public static /* synthetic */ Map m5217$r8$lambda$tV5iJfbZGrF4smxrKjz_spAqQ0() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (DiscardReason discardReason : DiscardReason.values()) {
            for (DataCategory dataCategory : DataCategory.values()) {
                concurrentHashMap.put(new ClientReportKey(discardReason.getReason(), dataCategory.getCategory()), new AtomicLong(0L));
            }
        }
        return Collections.unmodifiableMap(concurrentHashMap);
    }

    @Override // io.sentry.clientreport.IClientReportStorage
    public void addCount(ClientReportKey clientReportKey, Long l) {
        AtomicLong atomicLong = (AtomicLong) ((Map) this.lostEventCounts.getValue()).get(clientReportKey);
        if (atomicLong != null) {
            atomicLong.addAndGet(l.longValue());
        }
    }

    @Override // io.sentry.clientreport.IClientReportStorage
    public List resetCountsAndGet() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : ((Map) this.lostEventCounts.getValue()).entrySet()) {
            long andSet = ((AtomicLong) entry.getValue()).getAndSet(0L);
            Long lValueOf = Long.valueOf(andSet);
            if (andSet > 0) {
                arrayList.add(new DiscardedEvent(((ClientReportKey) entry.getKey()).getReason(), ((ClientReportKey) entry.getKey()).getCategory(), lValueOf));
            }
        }
        return arrayList;
    }
}
