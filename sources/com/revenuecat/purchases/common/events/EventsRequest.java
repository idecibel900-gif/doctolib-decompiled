package com.revenuecat.purchases.common.events;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 \u00192\u00020\u0001:\u0002\u0018\u0019B)\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB\u0015\b\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\nJ&\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016HÁ\u0001¢\u0006\u0002\b\u0017R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00058F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/revenuecat/purchases/common/events/EventsRequest;", "", "seen1", "", "events", "", "Lcom/revenuecat/purchases/common/events/BackendEvent;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/util/List;)V", "cacheKey", "", "getCacheKey", "()Ljava/util/List;", "getEvents$purchases_defaultsBc8Release", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class EventsRequest {
    private final List<BackendEvent> events;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer[] $childSerializers = {new ArrayListSerializer(BackendEvent.INSTANCE.serializer())};

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof EventsRequest) && Intrinsics.areEqual(this.events, ((EventsRequest) obj).events);
    }

    public int hashCode() {
        return this.events.hashCode();
    }

    public String toString() {
        return "EventsRequest(events=" + this.events + ')';
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/common/events/EventsRequest$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/common/events/EventsRequest;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer serializer() {
            return EventsRequest$$serializer.INSTANCE;
        }
    }

    @Deprecated
    public /* synthetic */ EventsRequest(int i, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1, EventsRequest$$serializer.INSTANCE.getDescriptor());
        }
        this.events = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EventsRequest(List<? extends BackendEvent> events) {
        Intrinsics.checkNotNullParameter(events, "events");
        this.events = events;
    }

    public final List<BackendEvent> getEvents$purchases_defaultsBc8Release() {
        return this.events;
    }

    public final List<String> getCacheKey() {
        List<BackendEvent> list = this.events;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(((BackendEvent) it.next()).hashCode()));
        }
        return arrayList;
    }
}
