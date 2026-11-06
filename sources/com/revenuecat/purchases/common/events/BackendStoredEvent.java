package com.revenuecat.purchases.common.events;

import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.utils.Event;
import java.lang.annotation.Annotation;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u0000 \u00102\u00020\u0001:\u0005\u000f\u0010\u0011\u0012\u0013B\u0019\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0007J!\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eHÇ\u0001\u0082\u0001\u0004\u0014\u0015\u0016\u0017¨\u0006\u0018"}, d2 = {"Lcom/revenuecat/purchases/common/events/BackendStoredEvent;", "Lcom/revenuecat/purchases/utils/Event;", "seen1", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "()V", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Ad", "Companion", "CustomPaywall", "CustomerCenter", "Paywalls", "Lcom/revenuecat/purchases/common/events/BackendStoredEvent$Ad;", "Lcom/revenuecat/purchases/common/events/BackendStoredEvent$CustomPaywall;", "Lcom/revenuecat/purchases/common/events/BackendStoredEvent$CustomerCenter;", "Lcom/revenuecat/purchases/common/events/BackendStoredEvent$Paywalls;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class BackendStoredEvent implements Event {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.revenuecat.purchases.common.events.BackendStoredEvent.Companion.1
        @Override // kotlin.jvm.functions.Function0
        public final KSerializer invoke() {
            return new SealedClassSerializer("com.revenuecat.purchases.common.events.BackendStoredEvent", Reflection.getOrCreateKotlinClass(BackendStoredEvent.class), new KClass[]{Reflection.getOrCreateKotlinClass(Ad.class), Reflection.getOrCreateKotlinClass(CustomPaywall.class), Reflection.getOrCreateKotlinClass(CustomerCenter.class), Reflection.getOrCreateKotlinClass(Paywalls.class)}, new KSerializer[]{BackendStoredEvent$Ad$$serializer.INSTANCE, BackendStoredEvent$CustomPaywall$$serializer.INSTANCE, BackendStoredEvent$CustomerCenter$$serializer.INSTANCE, BackendStoredEvent$Paywalls$$serializer.INSTANCE}, new Annotation[0]);
        }
    });

    public /* synthetic */ BackendStoredEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final /* synthetic */ void write$Self(BackendStoredEvent self, CompositeEncoder output, SerialDescriptor serialDesc) {
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/common/events/BackendStoredEvent$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/common/events/BackendStoredEvent;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) BackendStoredEvent.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer serializer() {
            return get$cachedSerializer();
        }
    }

    private BackendStoredEvent() {
    }

    @Deprecated
    public /* synthetic */ BackendStoredEvent(int i, SerializationConstructorMarker serializationConstructorMarker) {
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001d\u001eB#\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J&\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bHÁ\u0001¢\u0006\u0002\b\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/revenuecat/purchases/common/events/BackendStoredEvent$CustomerCenter;", "Lcom/revenuecat/purchases/common/events/BackendStoredEvent;", "seen1", "", "event", "Lcom/revenuecat/purchases/common/events/BackendEvent$CustomerCenter;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/common/events/BackendEvent$CustomerCenter;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/revenuecat/purchases/common/events/BackendEvent$CustomerCenter;)V", "getEvent", "()Lcom/revenuecat/purchases/common/events/BackendEvent$CustomerCenter;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class CustomerCenter extends BackendStoredEvent {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final BackendEvent.CustomerCenter event;

        public static /* synthetic */ CustomerCenter copy$default(CustomerCenter customerCenter, BackendEvent.CustomerCenter customerCenter2, int i, Object obj) {
            if ((i & 1) != 0) {
                customerCenter2 = customerCenter.event;
            }
            return customerCenter.copy(customerCenter2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final BackendEvent.CustomerCenter getEvent() {
            return this.event;
        }

        public final CustomerCenter copy(BackendEvent.CustomerCenter event) {
            Intrinsics.checkNotNullParameter(event, "event");
            return new CustomerCenter(event);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof CustomerCenter) && Intrinsics.areEqual(this.event, ((CustomerCenter) other).event);
        }

        public int hashCode() {
            return this.event.hashCode();
        }

        @Override // com.revenuecat.purchases.utils.Event
        public String toString() {
            return "CustomerCenter(event=" + this.event + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/common/events/BackendStoredEvent$CustomerCenter$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/common/events/BackendStoredEvent$CustomerCenter;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer serializer() {
                return BackendStoredEvent$CustomerCenter$$serializer.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @Deprecated
        public /* synthetic */ CustomerCenter(int i, BackendEvent.CustomerCenter customerCenter, SerializationConstructorMarker serializationConstructorMarker) {
            super(i, serializationConstructorMarker);
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, BackendStoredEvent$CustomerCenter$$serializer.INSTANCE.getDescriptor());
            }
            this.event = customerCenter;
        }

        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(CustomerCenter self, CompositeEncoder output, SerialDescriptor serialDesc) {
            BackendStoredEvent.write$Self(self, output, serialDesc);
            output.encodeSerializableElement(serialDesc, 0, BackendEvent$CustomerCenter$$serializer.INSTANCE, self.event);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CustomerCenter(BackendEvent.CustomerCenter event) {
            super(null);
            Intrinsics.checkNotNullParameter(event, "event");
            this.event = event;
        }

        public final BackendEvent.CustomerCenter getEvent() {
            return this.event;
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001d\u001eB#\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J&\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bHÁ\u0001¢\u0006\u0002\b\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/revenuecat/purchases/common/events/BackendStoredEvent$Paywalls;", "Lcom/revenuecat/purchases/common/events/BackendStoredEvent;", "seen1", "", "event", "Lcom/revenuecat/purchases/common/events/BackendEvent$Paywalls;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/common/events/BackendEvent$Paywalls;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/revenuecat/purchases/common/events/BackendEvent$Paywalls;)V", "getEvent", "()Lcom/revenuecat/purchases/common/events/BackendEvent$Paywalls;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Paywalls extends BackendStoredEvent {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final BackendEvent.Paywalls event;

        public static /* synthetic */ Paywalls copy$default(Paywalls paywalls, BackendEvent.Paywalls paywalls2, int i, Object obj) {
            if ((i & 1) != 0) {
                paywalls2 = paywalls.event;
            }
            return paywalls.copy(paywalls2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final BackendEvent.Paywalls getEvent() {
            return this.event;
        }

        public final Paywalls copy(BackendEvent.Paywalls event) {
            Intrinsics.checkNotNullParameter(event, "event");
            return new Paywalls(event);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Paywalls) && Intrinsics.areEqual(this.event, ((Paywalls) other).event);
        }

        public int hashCode() {
            return this.event.hashCode();
        }

        @Override // com.revenuecat.purchases.utils.Event
        public String toString() {
            return "Paywalls(event=" + this.event + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/common/events/BackendStoredEvent$Paywalls$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/common/events/BackendStoredEvent$Paywalls;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer serializer() {
                return BackendStoredEvent$Paywalls$$serializer.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @Deprecated
        public /* synthetic */ Paywalls(int i, BackendEvent.Paywalls paywalls, SerializationConstructorMarker serializationConstructorMarker) {
            super(i, serializationConstructorMarker);
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, BackendStoredEvent$Paywalls$$serializer.INSTANCE.getDescriptor());
            }
            this.event = paywalls;
        }

        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Paywalls self, CompositeEncoder output, SerialDescriptor serialDesc) {
            BackendStoredEvent.write$Self(self, output, serialDesc);
            output.encodeSerializableElement(serialDesc, 0, BackendEvent$Paywalls$$serializer.INSTANCE, self.event);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Paywalls(BackendEvent.Paywalls event) {
            super(null);
            Intrinsics.checkNotNullParameter(event, "event");
            this.event = event;
        }

        public final BackendEvent.Paywalls getEvent() {
            return this.event;
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001d\u001eB#\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J&\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bHÁ\u0001¢\u0006\u0002\b\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/revenuecat/purchases/common/events/BackendStoredEvent$Ad;", "Lcom/revenuecat/purchases/common/events/BackendStoredEvent;", "seen1", "", "event", "Lcom/revenuecat/purchases/common/events/BackendEvent$Ad;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/common/events/BackendEvent$Ad;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/revenuecat/purchases/common/events/BackendEvent$Ad;)V", "getEvent", "()Lcom/revenuecat/purchases/common/events/BackendEvent$Ad;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Ad extends BackendStoredEvent {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final BackendEvent.Ad event;

        public static /* synthetic */ Ad copy$default(Ad ad, BackendEvent.Ad ad2, int i, Object obj) {
            if ((i & 1) != 0) {
                ad2 = ad.event;
            }
            return ad.copy(ad2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final BackendEvent.Ad getEvent() {
            return this.event;
        }

        public final Ad copy(BackendEvent.Ad event) {
            Intrinsics.checkNotNullParameter(event, "event");
            return new Ad(event);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Ad) && Intrinsics.areEqual(this.event, ((Ad) other).event);
        }

        public int hashCode() {
            return this.event.hashCode();
        }

        @Override // com.revenuecat.purchases.utils.Event
        public String toString() {
            return "Ad(event=" + this.event + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/common/events/BackendStoredEvent$Ad$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/common/events/BackendStoredEvent$Ad;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer serializer() {
                return BackendStoredEvent$Ad$$serializer.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @Deprecated
        public /* synthetic */ Ad(int i, BackendEvent.Ad ad, SerializationConstructorMarker serializationConstructorMarker) {
            super(i, serializationConstructorMarker);
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, BackendStoredEvent$Ad$$serializer.INSTANCE.getDescriptor());
            }
            this.event = ad;
        }

        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Ad self, CompositeEncoder output, SerialDescriptor serialDesc) {
            BackendStoredEvent.write$Self(self, output, serialDesc);
            output.encodeSerializableElement(serialDesc, 0, BackendEvent$Ad$$serializer.INSTANCE, self.event);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Ad(BackendEvent.Ad event) {
            super(null);
            Intrinsics.checkNotNullParameter(event, "event");
            this.event = event;
        }

        public final BackendEvent.Ad getEvent() {
            return this.event;
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001d\u001eB#\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J&\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bHÁ\u0001¢\u0006\u0002\b\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/revenuecat/purchases/common/events/BackendStoredEvent$CustomPaywall;", "Lcom/revenuecat/purchases/common/events/BackendStoredEvent;", "seen1", "", "event", "Lcom/revenuecat/purchases/common/events/BackendEvent$CustomPaywall;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/common/events/BackendEvent$CustomPaywall;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/revenuecat/purchases/common/events/BackendEvent$CustomPaywall;)V", "getEvent", "()Lcom/revenuecat/purchases/common/events/BackendEvent$CustomPaywall;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class CustomPaywall extends BackendStoredEvent {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final BackendEvent.CustomPaywall event;

        public static /* synthetic */ CustomPaywall copy$default(CustomPaywall customPaywall, BackendEvent.CustomPaywall customPaywall2, int i, Object obj) {
            if ((i & 1) != 0) {
                customPaywall2 = customPaywall.event;
            }
            return customPaywall.copy(customPaywall2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final BackendEvent.CustomPaywall getEvent() {
            return this.event;
        }

        public final CustomPaywall copy(BackendEvent.CustomPaywall event) {
            Intrinsics.checkNotNullParameter(event, "event");
            return new CustomPaywall(event);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof CustomPaywall) && Intrinsics.areEqual(this.event, ((CustomPaywall) other).event);
        }

        public int hashCode() {
            return this.event.hashCode();
        }

        @Override // com.revenuecat.purchases.utils.Event
        public String toString() {
            return "CustomPaywall(event=" + this.event + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/common/events/BackendStoredEvent$CustomPaywall$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/common/events/BackendStoredEvent$CustomPaywall;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer serializer() {
                return BackendStoredEvent$CustomPaywall$$serializer.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @Deprecated
        public /* synthetic */ CustomPaywall(int i, BackendEvent.CustomPaywall customPaywall, SerializationConstructorMarker serializationConstructorMarker) {
            super(i, serializationConstructorMarker);
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, BackendStoredEvent$CustomPaywall$$serializer.INSTANCE.getDescriptor());
            }
            this.event = customPaywall;
        }

        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(CustomPaywall self, CompositeEncoder output, SerialDescriptor serialDesc) {
            BackendStoredEvent.write$Self(self, output, serialDesc);
            output.encodeSerializableElement(serialDesc, 0, BackendEvent$CustomPaywall$$serializer.INSTANCE, self.event);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CustomPaywall(BackendEvent.CustomPaywall event) {
            super(null);
            Intrinsics.checkNotNullParameter(event, "event");
            this.event = event;
        }

        public final BackendEvent.CustomPaywall getEvent() {
            return this.event;
        }
    }
}
