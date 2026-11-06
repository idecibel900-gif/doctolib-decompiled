package com.revenuecat.purchases.paywalls.events;

import com.amazon.a.a.o.b;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.google.firebase.messaging.Constants;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.common.events.FeatureEvent;
import com.revenuecat.purchases.utils.serializers.DateSerializer;
import com.revenuecat.purchases.utils.serializers.UUIDSerializer;
import java.util.Date;
import java.util.UUID;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u0000 22\u00020\u0001:\u00041234BA\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eB)\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u000fJ\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u000bHÆ\u0003J3\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010 \u001a\u00020\u00172\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\r\u0010$\u001a\u00020%H\u0000¢\u0006\u0002\b&J\t\u0010'\u001a\u00020(HÖ\u0001J&\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/HÁ\u0001¢\u0006\u0002\b0R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0018R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u00065"}, d2 = {"Lcom/revenuecat/purchases/paywalls/events/PaywallEvent;", "Lcom/revenuecat/purchases/common/events/FeatureEvent;", "seen1", "", "creationData", "Lcom/revenuecat/purchases/paywalls/events/PaywallEvent$CreationData;", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Lcom/revenuecat/purchases/paywalls/events/PaywallEvent$Data;", "type", "Lcom/revenuecat/purchases/paywalls/events/PaywallEventType;", "componentInteraction", "Lcom/revenuecat/purchases/paywalls/events/PaywallComponentInteractionData;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/paywalls/events/PaywallEvent$CreationData;Lcom/revenuecat/purchases/paywalls/events/PaywallEvent$Data;Lcom/revenuecat/purchases/paywalls/events/PaywallEventType;Lcom/revenuecat/purchases/paywalls/events/PaywallComponentInteractionData;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/revenuecat/purchases/paywalls/events/PaywallEvent$CreationData;Lcom/revenuecat/purchases/paywalls/events/PaywallEvent$Data;Lcom/revenuecat/purchases/paywalls/events/PaywallEventType;Lcom/revenuecat/purchases/paywalls/events/PaywallComponentInteractionData;)V", "getComponentInteraction", "()Lcom/revenuecat/purchases/paywalls/events/PaywallComponentInteractionData;", "getCreationData", "()Lcom/revenuecat/purchases/paywalls/events/PaywallEvent$CreationData;", "getData", "()Lcom/revenuecat/purchases/paywalls/events/PaywallEvent$Data;", "isPriorityEvent", "", "()Z", "getType", "()Lcom/revenuecat/purchases/paywalls/events/PaywallEventType;", "component1", "component2", "component3", "component4", "copy", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "toPaywallPostReceiptData", "Lcom/revenuecat/purchases/paywalls/events/PaywallPostReceiptData;", "toPaywallPostReceiptData$purchases_defaultsBc8Release", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "CreationData", "Data", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PaywallEvent implements FeatureEvent {
    private final PaywallComponentInteractionData componentInteraction;
    private final CreationData creationData;
    private final Data data;
    private final PaywallEventType type;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer[] $childSerializers = {null, null, PaywallEventType.INSTANCE.serializer(), null};

    public static /* synthetic */ PaywallEvent copy$default(PaywallEvent paywallEvent, CreationData creationData, Data data, PaywallEventType paywallEventType, PaywallComponentInteractionData paywallComponentInteractionData, int i, Object obj) {
        if ((i & 1) != 0) {
            creationData = paywallEvent.creationData;
        }
        if ((i & 2) != 0) {
            data = paywallEvent.data;
        }
        if ((i & 4) != 0) {
            paywallEventType = paywallEvent.type;
        }
        if ((i & 8) != 0) {
            paywallComponentInteractionData = paywallEvent.componentInteraction;
        }
        return paywallEvent.copy(creationData, data, paywallEventType, paywallComponentInteractionData);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final CreationData getCreationData() {
        return this.creationData;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Data getData() {
        return this.data;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final PaywallEventType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final PaywallComponentInteractionData getComponentInteraction() {
        return this.componentInteraction;
    }

    public final PaywallEvent copy(CreationData creationData, Data data, PaywallEventType type, PaywallComponentInteractionData componentInteraction) {
        Intrinsics.checkNotNullParameter(creationData, "creationData");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(type, "type");
        return new PaywallEvent(creationData, data, type, componentInteraction);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PaywallEvent)) {
            return false;
        }
        PaywallEvent paywallEvent = (PaywallEvent) other;
        return Intrinsics.areEqual(this.creationData, paywallEvent.creationData) && Intrinsics.areEqual(this.data, paywallEvent.data) && this.type == paywallEvent.type && Intrinsics.areEqual(this.componentInteraction, paywallEvent.componentInteraction);
    }

    public int hashCode() {
        int iHashCode = ((((this.creationData.hashCode() * 31) + this.data.hashCode()) * 31) + this.type.hashCode()) * 31;
        PaywallComponentInteractionData paywallComponentInteractionData = this.componentInteraction;
        return iHashCode + (paywallComponentInteractionData == null ? 0 : paywallComponentInteractionData.hashCode());
    }

    public String toString() {
        return "PaywallEvent(creationData=" + this.creationData + ", data=" + this.data + ", type=" + this.type + ", componentInteraction=" + this.componentInteraction + ')';
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/events/PaywallEvent$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/events/PaywallEvent;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer serializer() {
            return PaywallEvent$$serializer.INSTANCE;
        }
    }

    @Deprecated
    public /* synthetic */ PaywallEvent(int i, CreationData creationData, Data data, PaywallEventType paywallEventType, PaywallComponentInteractionData paywallComponentInteractionData, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i, 7, PaywallEvent$$serializer.INSTANCE.getDescriptor());
        }
        this.creationData = creationData;
        this.data = data;
        this.type = paywallEventType;
        if ((i & 8) == 0) {
            this.componentInteraction = null;
        } else {
            this.componentInteraction = paywallComponentInteractionData;
        }
    }

    public PaywallEvent(CreationData creationData, Data data, PaywallEventType type, PaywallComponentInteractionData paywallComponentInteractionData) {
        Intrinsics.checkNotNullParameter(creationData, "creationData");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(type, "type");
        this.creationData = creationData;
        this.data = data;
        this.type = type;
        this.componentInteraction = paywallComponentInteractionData;
    }

    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(PaywallEvent self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer[] kSerializerArr = $childSerializers;
        output.encodeSerializableElement(serialDesc, 0, PaywallEvent$CreationData$$serializer.INSTANCE, self.creationData);
        output.encodeSerializableElement(serialDesc, 1, PaywallEventDataSerializer.INSTANCE, self.data);
        output.encodeSerializableElement(serialDesc, 2, kSerializerArr[2], self.type);
        if (!output.shouldEncodeElementDefault(serialDesc, 3) && self.componentInteraction == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 3, PaywallComponentInteractionData$$serializer.INSTANCE, self.componentInteraction);
    }

    public /* synthetic */ PaywallEvent(CreationData creationData, Data data, PaywallEventType paywallEventType, PaywallComponentInteractionData paywallComponentInteractionData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(creationData, data, paywallEventType, (i & 8) != 0 ? null : paywallComponentInteractionData);
    }

    public final CreationData getCreationData() {
        return this.creationData;
    }

    public final Data getData() {
        return this.data;
    }

    public final PaywallEventType getType() {
        return this.type;
    }

    public final PaywallComponentInteractionData getComponentInteraction() {
        return this.componentInteraction;
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0002$%B1\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\u001d\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J&\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"HÁ\u0001¢\u0006\u0002\b#R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u0012¨\u0006&"}, d2 = {"Lcom/revenuecat/purchases/paywalls/events/PaywallEvent$CreationData;", "", "seen1", "", DiagnosticsEntry.ID_KEY, "Ljava/util/UUID;", "date", "Ljava/util/Date;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/UUID;Ljava/util/Date;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/util/UUID;Ljava/util/Date;)V", "getDate$annotations", "()V", "getDate", "()Ljava/util/Date;", "getId$annotations", "getId", "()Ljava/util/UUID;", "component1", "component2", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class CreationData {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Date date;
        private final UUID id;

        public static /* synthetic */ CreationData copy$default(CreationData creationData, UUID uuid, Date date, int i, Object obj) {
            if ((i & 1) != 0) {
                uuid = creationData.id;
            }
            if ((i & 2) != 0) {
                date = creationData.date;
            }
            return creationData.copy(uuid, date);
        }

        public static /* synthetic */ void getDate$annotations() {
        }

        public static /* synthetic */ void getId$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final UUID getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Date getDate() {
            return this.date;
        }

        public final CreationData copy(UUID id, Date date) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(date, "date");
            return new CreationData(id, date);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CreationData)) {
                return false;
            }
            CreationData creationData = (CreationData) other;
            return Intrinsics.areEqual(this.id, creationData.id) && Intrinsics.areEqual(this.date, creationData.date);
        }

        public int hashCode() {
            return (this.id.hashCode() * 31) + this.date.hashCode();
        }

        public String toString() {
            return "CreationData(id=" + this.id + ", date=" + this.date + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/events/PaywallEvent$CreationData$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/events/PaywallEvent$CreationData;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer serializer() {
                return PaywallEvent$CreationData$$serializer.INSTANCE;
            }
        }

        @Deprecated
        public /* synthetic */ CreationData(int i, UUID uuid, Date date, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i & 3)) {
                PluginExceptionsKt.throwMissingFieldException(i, 3, PaywallEvent$CreationData$$serializer.INSTANCE.getDescriptor());
            }
            this.id = uuid;
            this.date = date;
        }

        public CreationData(UUID id, Date date) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(date, "date");
            this.id = id;
            this.date = date;
        }

        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(CreationData self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeSerializableElement(serialDesc, 0, UUIDSerializer.INSTANCE, self.id);
            output.encodeSerializableElement(serialDesc, 1, DateSerializer.INSTANCE, self.date);
        }

        public final UUID getId() {
            return this.id;
        }

        public final Date getDate() {
            return this.date;
        }
    }

    @Override // com.revenuecat.purchases.common.events.FeatureEvent
    public boolean isPriorityEvent() {
        return this.type == PaywallEventType.IMPRESSION;
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b2\b\u0087\b\u0018\u0000 @2\u00020\u0001:\u0001@B\u0087\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0007HÆ\u0003J\t\u00104\u001a\u00020\tHÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\rHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u009e\u0001\u0010:\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010;J\u0013\u0010<\u001a\u00020\r2\b\u0010=\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010>\u001a\u00020\u0007HÖ\u0001J\t\u0010?\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0019R\u001c\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010*\u001a\u0004\b+\u0010,¨\u0006A"}, d2 = {"Lcom/revenuecat/purchases/paywalls/events/PaywallEvent$Data;", "", "paywallIdentifier", "", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "paywallRevision", "", "sessionIdentifier", "Ljava/util/UUID;", "displayMode", "localeIdentifier", "darkMode", "", "exitOfferType", "Lcom/revenuecat/purchases/paywalls/events/ExitOfferType;", "exitOfferingIdentifier", "packageIdentifier", "productIdentifier", "errorCode", b.f, "(Ljava/lang/String;Lcom/revenuecat/purchases/PresentedOfferingContext;ILjava/util/UUID;Ljava/lang/String;Ljava/lang/String;ZLcom/revenuecat/purchases/paywalls/events/ExitOfferType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getDarkMode", "()Z", "getDisplayMode", "()Ljava/lang/String;", "getErrorCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getErrorMessage", "getExitOfferType", "()Lcom/revenuecat/purchases/paywalls/events/ExitOfferType;", "getExitOfferingIdentifier", "getLocaleIdentifier", "getPackageIdentifier", "getPaywallIdentifier", "getPaywallRevision", "()I", "getPresentedOfferingContext", "()Lcom/revenuecat/purchases/PresentedOfferingContext;", "getProductIdentifier", "getSessionIdentifier$annotations", "()V", "getSessionIdentifier", "()Ljava/util/UUID;", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Lcom/revenuecat/purchases/PresentedOfferingContext;ILjava/util/UUID;Ljava/lang/String;Ljava/lang/String;ZLcom/revenuecat/purchases/paywalls/events/ExitOfferType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/revenuecat/purchases/paywalls/events/PaywallEvent$Data;", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "toString", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Data {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean darkMode;
        private final String displayMode;
        private final Integer errorCode;
        private final String errorMessage;
        private final ExitOfferType exitOfferType;
        private final String exitOfferingIdentifier;
        private final String localeIdentifier;
        private final String packageIdentifier;
        private final String paywallIdentifier;
        private final int paywallRevision;
        private final PresentedOfferingContext presentedOfferingContext;
        private final String productIdentifier;
        private final UUID sessionIdentifier;

        public static /* synthetic */ Data copy$default(Data data, String str, PresentedOfferingContext presentedOfferingContext, int i, UUID uuid, String str2, String str3, boolean z, ExitOfferType exitOfferType, String str4, String str5, String str6, Integer num, String str7, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = data.paywallIdentifier;
            }
            return data.copy(str, (i2 & 2) != 0 ? data.presentedOfferingContext : presentedOfferingContext, (i2 & 4) != 0 ? data.paywallRevision : i, (i2 & 8) != 0 ? data.sessionIdentifier : uuid, (i2 & 16) != 0 ? data.displayMode : str2, (i2 & 32) != 0 ? data.localeIdentifier : str3, (i2 & 64) != 0 ? data.darkMode : z, (i2 & 128) != 0 ? data.exitOfferType : exitOfferType, (i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? data.exitOfferingIdentifier : str4, (i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? data.packageIdentifier : str5, (i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? data.productIdentifier : str6, (i2 & 2048) != 0 ? data.errorCode : num, (i2 & 4096) != 0 ? data.errorMessage : str7);
        }

        public static /* synthetic */ void getSessionIdentifier$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getPaywallIdentifier() {
            return this.paywallIdentifier;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final String getPackageIdentifier() {
            return this.packageIdentifier;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final String getProductIdentifier() {
            return this.productIdentifier;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final Integer getErrorCode() {
            return this.errorCode;
        }

        /* JADX INFO: renamed from: component13, reason: from getter */
        public final String getErrorMessage() {
            return this.errorMessage;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final PresentedOfferingContext getPresentedOfferingContext() {
            return this.presentedOfferingContext;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getPaywallRevision() {
            return this.paywallRevision;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final UUID getSessionIdentifier() {
            return this.sessionIdentifier;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getDisplayMode() {
            return this.displayMode;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getLocaleIdentifier() {
            return this.localeIdentifier;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final boolean getDarkMode() {
            return this.darkMode;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final ExitOfferType getExitOfferType() {
            return this.exitOfferType;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getExitOfferingIdentifier() {
            return this.exitOfferingIdentifier;
        }

        public final Data copy(String paywallIdentifier, PresentedOfferingContext presentedOfferingContext, int paywallRevision, UUID sessionIdentifier, String displayMode, String localeIdentifier, boolean darkMode, ExitOfferType exitOfferType, String exitOfferingIdentifier, String packageIdentifier, String productIdentifier, Integer errorCode, String errorMessage) {
            Intrinsics.checkNotNullParameter(presentedOfferingContext, "presentedOfferingContext");
            Intrinsics.checkNotNullParameter(sessionIdentifier, "sessionIdentifier");
            Intrinsics.checkNotNullParameter(displayMode, "displayMode");
            Intrinsics.checkNotNullParameter(localeIdentifier, "localeIdentifier");
            return new Data(paywallIdentifier, presentedOfferingContext, paywallRevision, sessionIdentifier, displayMode, localeIdentifier, darkMode, exitOfferType, exitOfferingIdentifier, packageIdentifier, productIdentifier, errorCode, errorMessage);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Data)) {
                return false;
            }
            Data data = (Data) other;
            return Intrinsics.areEqual(this.paywallIdentifier, data.paywallIdentifier) && Intrinsics.areEqual(this.presentedOfferingContext, data.presentedOfferingContext) && this.paywallRevision == data.paywallRevision && Intrinsics.areEqual(this.sessionIdentifier, data.sessionIdentifier) && Intrinsics.areEqual(this.displayMode, data.displayMode) && Intrinsics.areEqual(this.localeIdentifier, data.localeIdentifier) && this.darkMode == data.darkMode && this.exitOfferType == data.exitOfferType && Intrinsics.areEqual(this.exitOfferingIdentifier, data.exitOfferingIdentifier) && Intrinsics.areEqual(this.packageIdentifier, data.packageIdentifier) && Intrinsics.areEqual(this.productIdentifier, data.productIdentifier) && Intrinsics.areEqual(this.errorCode, data.errorCode) && Intrinsics.areEqual(this.errorMessage, data.errorMessage);
        }

        public int hashCode() {
            String str = this.paywallIdentifier;
            int iHashCode = (((((((((((((str == null ? 0 : str.hashCode()) * 31) + this.presentedOfferingContext.hashCode()) * 31) + Integer.hashCode(this.paywallRevision)) * 31) + this.sessionIdentifier.hashCode()) * 31) + this.displayMode.hashCode()) * 31) + this.localeIdentifier.hashCode()) * 31) + Boolean.hashCode(this.darkMode)) * 31;
            ExitOfferType exitOfferType = this.exitOfferType;
            int iHashCode2 = (iHashCode + (exitOfferType == null ? 0 : exitOfferType.hashCode())) * 31;
            String str2 = this.exitOfferingIdentifier;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.packageIdentifier;
            int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.productIdentifier;
            int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            Integer num = this.errorCode;
            int iHashCode6 = (iHashCode5 + (num == null ? 0 : num.hashCode())) * 31;
            String str5 = this.errorMessage;
            return iHashCode6 + (str5 != null ? str5.hashCode() : 0);
        }

        public String toString() {
            return "Data(paywallIdentifier=" + this.paywallIdentifier + ", presentedOfferingContext=" + this.presentedOfferingContext + ", paywallRevision=" + this.paywallRevision + ", sessionIdentifier=" + this.sessionIdentifier + ", displayMode=" + this.displayMode + ", localeIdentifier=" + this.localeIdentifier + ", darkMode=" + this.darkMode + ", exitOfferType=" + this.exitOfferType + ", exitOfferingIdentifier=" + this.exitOfferingIdentifier + ", packageIdentifier=" + this.packageIdentifier + ", productIdentifier=" + this.productIdentifier + ", errorCode=" + this.errorCode + ", errorMessage=" + this.errorMessage + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/events/PaywallEvent$Data$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/events/PaywallEvent$Data;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer serializer() {
                return PaywallEventDataSerializer.INSTANCE;
            }
        }

        public Data(String str, PresentedOfferingContext presentedOfferingContext, int i, UUID sessionIdentifier, String displayMode, String localeIdentifier, boolean z, ExitOfferType exitOfferType, String str2, String str3, String str4, Integer num, String str5) {
            Intrinsics.checkNotNullParameter(presentedOfferingContext, "presentedOfferingContext");
            Intrinsics.checkNotNullParameter(sessionIdentifier, "sessionIdentifier");
            Intrinsics.checkNotNullParameter(displayMode, "displayMode");
            Intrinsics.checkNotNullParameter(localeIdentifier, "localeIdentifier");
            this.paywallIdentifier = str;
            this.presentedOfferingContext = presentedOfferingContext;
            this.paywallRevision = i;
            this.sessionIdentifier = sessionIdentifier;
            this.displayMode = displayMode;
            this.localeIdentifier = localeIdentifier;
            this.darkMode = z;
            this.exitOfferType = exitOfferType;
            this.exitOfferingIdentifier = str2;
            this.packageIdentifier = str3;
            this.productIdentifier = str4;
            this.errorCode = num;
            this.errorMessage = str5;
        }

        public /* synthetic */ Data(String str, PresentedOfferingContext presentedOfferingContext, int i, UUID uuid, String str2, String str3, boolean z, ExitOfferType exitOfferType, String str4, String str5, String str6, Integer num, String str7, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, presentedOfferingContext, i, uuid, str2, str3, z, (i2 & 128) != 0 ? null : exitOfferType, (i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? null : str4, (i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? null : str5, (i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? null : str6, (i2 & 2048) != 0 ? null : num, (i2 & 4096) != 0 ? null : str7);
        }

        public final String getPaywallIdentifier() {
            return this.paywallIdentifier;
        }

        public final PresentedOfferingContext getPresentedOfferingContext() {
            return this.presentedOfferingContext;
        }

        public final int getPaywallRevision() {
            return this.paywallRevision;
        }

        public final UUID getSessionIdentifier() {
            return this.sessionIdentifier;
        }

        public final String getDisplayMode() {
            return this.displayMode;
        }

        public final String getLocaleIdentifier() {
            return this.localeIdentifier;
        }

        public final boolean getDarkMode() {
            return this.darkMode;
        }

        public final ExitOfferType getExitOfferType() {
            return this.exitOfferType;
        }

        public final String getExitOfferingIdentifier() {
            return this.exitOfferingIdentifier;
        }

        public final String getPackageIdentifier() {
            return this.packageIdentifier;
        }

        public final String getProductIdentifier() {
            return this.productIdentifier;
        }

        public final Integer getErrorCode() {
            return this.errorCode;
        }

        public final String getErrorMessage() {
            return this.errorMessage;
        }
    }

    public final PaywallPostReceiptData toPaywallPostReceiptData$purchases_defaultsBc8Release() {
        String paywallIdentifier = this.data.getPaywallIdentifier();
        String string = this.data.getSessionIdentifier().toString();
        Intrinsics.checkNotNullExpressionValue(string, "data.sessionIdentifier.toString()");
        return new PaywallPostReceiptData(paywallIdentifier, string, this.data.getPaywallRevision(), this.data.getDisplayMode(), this.data.getDarkMode(), this.data.getLocaleIdentifier(), this.data.getPresentedOfferingContext().getOfferingIdentifier());
    }
}
