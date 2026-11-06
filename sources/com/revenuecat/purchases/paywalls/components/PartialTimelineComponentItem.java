package com.revenuecat.purchases.paywalls.components;

import com.revenuecat.purchases.InternalRevenueCatAPI;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0002\u0019\u001aB-\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u001d\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bJ&\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017HÁ\u0001¢\u0006\u0002\b\u0018R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/PartialTimelineComponentItem;", "Lcom/revenuecat/purchases/paywalls/components/PartialComponent;", "seen1", "", "visible", "", "connector", "Lcom/revenuecat/purchases/paywalls/components/TimelineComponent$Connector;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Boolean;Lcom/revenuecat/purchases/paywalls/components/TimelineComponent$Connector;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/Boolean;Lcom/revenuecat/purchases/paywalls/components/TimelineComponent$Connector;)V", "getConnector", "()Lcom/revenuecat/purchases/paywalls/components/TimelineComponent$Connector;", "getVisible", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PartialTimelineComponentItem implements PartialComponent {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final TimelineComponent.Connector connector;
    private final Boolean visible;

    /* JADX WARN: Multi-variable type inference failed */
    public PartialTimelineComponentItem() {
        this((Boolean) null, (TimelineComponent.Connector) (0 == true ? 1 : 0), 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PartialTimelineComponentItem)) {
            return false;
        }
        PartialTimelineComponentItem partialTimelineComponentItem = (PartialTimelineComponentItem) obj;
        return Intrinsics.areEqual(this.visible, partialTimelineComponentItem.visible) && Intrinsics.areEqual(this.connector, partialTimelineComponentItem.connector);
    }

    public int hashCode() {
        Boolean bool = this.visible;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        TimelineComponent.Connector connector = this.connector;
        return iHashCode + (connector != null ? connector.hashCode() : 0);
    }

    public String toString() {
        return "PartialTimelineComponentItem(visible=" + this.visible + ", connector=" + this.connector + ')';
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/PartialTimelineComponentItem$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/PartialTimelineComponentItem;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer serializer() {
            return PartialTimelineComponentItem$$serializer.INSTANCE;
        }
    }

    @Deprecated
    public /* synthetic */ PartialTimelineComponentItem(int i, Boolean bool, TimelineComponent.Connector connector, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.visible = null;
        } else {
            this.visible = bool;
        }
        if ((i & 2) == 0) {
            this.connector = null;
        } else {
            this.connector = connector;
        }
    }

    public PartialTimelineComponentItem(Boolean bool, TimelineComponent.Connector connector) {
        this.visible = bool;
        this.connector = connector;
    }

    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(PartialTimelineComponentItem self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.visible != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, BooleanSerializer.INSTANCE, self.visible);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 1) && self.connector == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 1, TimelineComponent$Connector$$serializer.INSTANCE, self.connector);
    }

    public /* synthetic */ PartialTimelineComponentItem(Boolean bool, TimelineComponent.Connector connector, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : connector);
    }

    public final /* synthetic */ Boolean getVisible() {
        return this.visible;
    }

    public final /* synthetic */ TimelineComponent.Connector getConnector() {
        return this.connector;
    }
}
