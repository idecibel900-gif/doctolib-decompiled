package com.revenuecat.purchases.paywalls.events;

import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.common.events.BackendEvent;
import com.revenuecat.purchases.utils.Event;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.Json;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 $2\u00020\u0001:\u0002#$B-\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u0007H\u0016J&\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!HÁ\u0001¢\u0006\u0002\b\"R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006%"}, d2 = {"Lcom/revenuecat/purchases/paywalls/events/PaywallStoredEvent;", "Lcom/revenuecat/purchases/utils/Event;", "seen1", "", "event", "Lcom/revenuecat/purchases/paywalls/events/PaywallEvent;", "userID", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/paywalls/events/PaywallEvent;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/revenuecat/purchases/paywalls/events/PaywallEvent;Ljava/lang/String;)V", "getEvent", "()Lcom/revenuecat/purchases/paywalls/events/PaywallEvent;", "getUserID", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "toBackendEvent", "Lcom/revenuecat/purchases/common/events/BackendEvent$Paywalls;", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PaywallStoredEvent implements Event {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Json.Default json = Json.Default;
    private final PaywallEvent event;
    private final String userID;

    public static /* synthetic */ PaywallStoredEvent copy$default(PaywallStoredEvent paywallStoredEvent, PaywallEvent paywallEvent, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            paywallEvent = paywallStoredEvent.event;
        }
        if ((i & 2) != 0) {
            str = paywallStoredEvent.userID;
        }
        return paywallStoredEvent.copy(paywallEvent, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final PaywallEvent getEvent() {
        return this.event;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUserID() {
        return this.userID;
    }

    public final PaywallStoredEvent copy(PaywallEvent event, String userID) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(userID, "userID");
        return new PaywallStoredEvent(event, userID);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PaywallStoredEvent)) {
            return false;
        }
        PaywallStoredEvent paywallStoredEvent = (PaywallStoredEvent) other;
        return Intrinsics.areEqual(this.event, paywallStoredEvent.event) && Intrinsics.areEqual(this.userID, paywallStoredEvent.userID);
    }

    public int hashCode() {
        return (this.event.hashCode() * 31) + this.userID.hashCode();
    }

    @Deprecated
    public /* synthetic */ PaywallStoredEvent(int i, PaywallEvent paywallEvent, String str, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, PaywallStoredEvent$$serializer.INSTANCE.getDescriptor());
        }
        this.event = paywallEvent;
        this.userID = str;
    }

    public PaywallStoredEvent(PaywallEvent event, String userID) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(userID, "userID");
        this.event = event;
        this.userID = userID;
    }

    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(PaywallStoredEvent self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, PaywallEvent$$serializer.INSTANCE, self.event);
        output.encodeStringElement(serialDesc, 1, self.userID);
    }

    public final PaywallEvent getEvent() {
        return this.event;
    }

    public final String getUserID() {
        return this.userID;
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fHÆ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/revenuecat/purchases/paywalls/events/PaywallStoredEvent$Companion;", "", "()V", "json", "Lkotlinx/serialization/json/Json$Default;", "getJson", "()Lkotlinx/serialization/json/Json$Default;", "fromString", "Lcom/revenuecat/purchases/paywalls/events/PaywallStoredEvent;", "string", "", "serializer", "Lkotlinx/serialization/KSerializer;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer serializer() {
            return PaywallStoredEvent$$serializer.INSTANCE;
        }

        public final Json.Default getJson() {
            return PaywallStoredEvent.json;
        }

        public final PaywallStoredEvent fromString(String string) {
            Intrinsics.checkNotNullParameter(string, "string");
            Json.Default json = getJson();
            json.getSerializersModule();
            return (PaywallStoredEvent) json.decodeFromString(PaywallStoredEvent.INSTANCE.serializer(), string);
        }
    }

    public final BackendEvent.Paywalls toBackendEvent() {
        BackendPaywallComponentFields backendComponentFields = PaywallEventKt.toBackendComponentFields(this.event.getComponentInteraction());
        String string = this.event.getCreationData().getId().toString();
        Intrinsics.checkNotNullExpressionValue(string, "event.creationData.id.toString()");
        String value = this.event.getType().getValue();
        String str = this.userID;
        String string2 = this.event.getData().getSessionIdentifier().toString();
        Intrinsics.checkNotNullExpressionValue(string2, "event.data.sessionIdentifier.toString()");
        String offeringIdentifier = this.event.getData().getPresentedOfferingContext().getOfferingIdentifier();
        String paywallIdentifier = this.event.getData().getPaywallIdentifier();
        int paywallRevision = this.event.getData().getPaywallRevision();
        long time = this.event.getCreationData().getDate().getTime();
        String displayMode = this.event.getData().getDisplayMode();
        boolean darkMode = this.event.getData().getDarkMode();
        String localeIdentifier = this.event.getData().getLocaleIdentifier();
        BackendEvent.PresentedOfferingContextData presentedOfferingContextDataFromContext = BackendEvent.PresentedOfferingContextData.INSTANCE.fromContext(this.event.getData().getPresentedOfferingContext());
        ExitOfferType exitOfferType = this.event.getData().getExitOfferType();
        return new BackendEvent.Paywalls(string, 1, value, str, string2, offeringIdentifier, paywallIdentifier, paywallRevision, time, displayMode, darkMode, localeIdentifier, presentedOfferingContextDataFromContext, exitOfferType != null ? exitOfferType.getValue() : null, this.event.getData().getExitOfferingIdentifier(), this.event.getData().getPackageIdentifier(), this.event.getData().getProductIdentifier(), this.event.getData().getErrorCode(), this.event.getData().getErrorMessage(), backendComponentFields.getComponentType(), backendComponentFields.getComponentName(), backendComponentFields.getComponentValue(), backendComponentFields.getComponentUrl(), backendComponentFields.getOriginIndex(), backendComponentFields.getDestinationIndex(), backendComponentFields.getOriginContextName(), backendComponentFields.getDestinationContextName(), backendComponentFields.getDefaultIndex(), backendComponentFields.getOriginPackageIdentifier(), backendComponentFields.getDestinationPackageIdentifier(), backendComponentFields.getDefaultPackageIdentifier(), backendComponentFields.getOriginProductIdentifier(), backendComponentFields.getDestinationProductIdentifier(), backendComponentFields.getDefaultProductIdentifier(), backendComponentFields.getCurrentPackageIdentifier(), backendComponentFields.getResultingPackageIdentifier(), backendComponentFields.getCurrentProductIdentifier(), backendComponentFields.getResultingProductIdentifier());
    }

    @Override // com.revenuecat.purchases.utils.Event
    public String toString() {
        Json.Default r0 = json;
        r0.getSerializersModule();
        return r0.encodeToString(INSTANCE.serializer(), this);
    }
}
