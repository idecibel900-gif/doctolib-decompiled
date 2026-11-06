package com.revenuecat.purchases.ads.events.networking;

import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.common.events.BackendEvent;
import com.revenuecat.purchases.common.events.BackendEvent$Ad$$serializer;
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
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000  2\u00020\u0001:\u0002\u001f B)\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\nJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u0019\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\fHÖ\u0001J&\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dHÁ\u0001¢\u0006\u0002\b\u001eR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00058F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006!"}, d2 = {"Lcom/revenuecat/purchases/ads/events/networking/AdEventsRequest;", "", "seen1", "", "events", "", "Lcom/revenuecat/purchases/common/events/BackendEvent$Ad;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/util/List;)V", "cacheKey", "", "getCacheKey", "()Ljava/util/List;", "getEvents", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AdEventsRequest {
    private final List<BackendEvent.Ad> events;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer[] $childSerializers = {new ArrayListSerializer(BackendEvent$Ad$$serializer.INSTANCE)};

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AdEventsRequest copy$default(AdEventsRequest adEventsRequest, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = adEventsRequest.events;
        }
        return adEventsRequest.copy(list);
    }

    public final List<BackendEvent.Ad> component1() {
        return this.events;
    }

    public final AdEventsRequest copy(List<BackendEvent.Ad> events) {
        Intrinsics.checkNotNullParameter(events, "events");
        return new AdEventsRequest(events);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof AdEventsRequest) && Intrinsics.areEqual(this.events, ((AdEventsRequest) other).events);
    }

    public int hashCode() {
        return this.events.hashCode();
    }

    public String toString() {
        return "AdEventsRequest(events=" + this.events + ')';
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/ads/events/networking/AdEventsRequest$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/ads/events/networking/AdEventsRequest;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer serializer() {
            return AdEventsRequest$$serializer.INSTANCE;
        }
    }

    @Deprecated
    public /* synthetic */ AdEventsRequest(int i, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1, AdEventsRequest$$serializer.INSTANCE.getDescriptor());
        }
        this.events = list;
    }

    public AdEventsRequest(List<BackendEvent.Ad> events) {
        Intrinsics.checkNotNullParameter(events, "events");
        this.events = events;
    }

    public final List<BackendEvent.Ad> getEvents() {
        return this.events;
    }

    public final List<String> getCacheKey() {
        List<BackendEvent.Ad> list = this.events;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(((BackendEvent.Ad) it.next()).hashCode()));
        }
        return arrayList;
    }
}
