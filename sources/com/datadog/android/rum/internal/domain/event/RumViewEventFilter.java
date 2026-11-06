package com.datadog.android.rum.internal.domain.event;

import com.datadog.android.api.storage.RawBatchEvent;
import com.datadog.android.core.internal.persistence.Deserializer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class RumViewEventFilter {
    private final Deserializer eventMetaDeserializer;

    public RumViewEventFilter(Deserializer eventMetaDeserializer) {
        Intrinsics.checkNotNullParameter(eventMetaDeserializer, "eventMetaDeserializer");
        this.eventMetaDeserializer = eventMetaDeserializer;
    }

    public final List filterOutRedundantViewEvents(List batch) {
        Intrinsics.checkNotNullParameter(batch, "batch");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        List<RawBatchEvent> list = batch;
        for (RawBatchEvent rawBatchEvent : list) {
            RumEventMeta rumEventMeta = (RumEventMeta) this.eventMetaDeserializer.deserialize(rawBatchEvent.getMetadata());
            if (rumEventMeta instanceof RumEventMeta.View) {
                Pair pair = TuplesKt.to(rawBatchEvent, rumEventMeta);
                linkedHashMap2.put(pair.getFirst(), pair.getSecond());
                RumEventMeta.View view = (RumEventMeta.View) rumEventMeta;
                String viewId = view.getViewId();
                long documentVersion = view.getDocumentVersion();
                Long l = (Long) linkedHashMap.get(viewId);
                if (l == null) {
                    linkedHashMap.put(viewId, Long.valueOf(documentVersion));
                } else {
                    linkedHashMap.put(viewId, Long.valueOf(Math.max(documentVersion, l.longValue())));
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            RawBatchEvent rawBatchEvent2 = (RawBatchEvent) obj;
            if (linkedHashMap2.containsKey(rawBatchEvent2)) {
                RumEventMeta.View view2 = (RumEventMeta.View) MapsKt.getValue(linkedHashMap2, rawBatchEvent2);
                if (Intrinsics.areEqual(view2.getHasAccessibility(), Boolean.TRUE) || view2.getDocumentVersion() == ((Number) MapsKt.getValue(linkedHashMap, view2.getViewId())).longValue()) {
                }
            }
            arrayList.add(obj);
        }
        return arrayList;
    }
}
