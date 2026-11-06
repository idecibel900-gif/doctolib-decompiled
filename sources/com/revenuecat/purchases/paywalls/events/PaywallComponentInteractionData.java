package com.revenuecat.purchases.paywalls.events;

import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import okhttp3.internal.http2.Http2;

/* JADX INFO: loaded from: classes4.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 W2\u00020\u0001:\u0002VWB×\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\u0002\u0010\u001bBá\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u001cJ\t\u00104\u001a\u00020\u0005HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010@\u001a\u00020\u0007HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010&J\u0010\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010&J\u000b\u0010D\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010&Jî\u0001\u0010G\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010HJ\u0013\u0010I\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010L\u001a\u00020\u0003HÖ\u0001J\t\u0010M\u001a\u00020\u0007HÖ\u0001J&\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020THÁ\u0001¢\u0006\u0002\bUR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001eR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001eR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001eR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001eR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010'\u001a\u0004\b%\u0010&R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001eR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001eR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001eR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010'\u001a\u0004\b+\u0010&R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001eR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001eR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001eR\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010'\u001a\u0004\b/\u0010&R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001eR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001eR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001eR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001e¨\u0006X"}, d2 = {"Lcom/revenuecat/purchases/paywalls/events/PaywallComponentInteractionData;", "", "seen1", "", "componentType", "Lcom/revenuecat/purchases/paywalls/events/PaywallComponentType;", "componentName", "", "componentValue", "componentUrl", "originIndex", "destinationIndex", "originContextName", "destinationContextName", "defaultIndex", "originPackageIdentifier", "destinationPackageIdentifier", "defaultPackageIdentifier", "originProductIdentifier", "destinationProductIdentifier", "defaultProductIdentifier", "currentPackageIdentifier", "resultingPackageIdentifier", "currentProductIdentifier", "resultingProductIdentifier", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/paywalls/events/PaywallComponentType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/revenuecat/purchases/paywalls/events/PaywallComponentType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getComponentName", "()Ljava/lang/String;", "getComponentType", "()Lcom/revenuecat/purchases/paywalls/events/PaywallComponentType;", "getComponentUrl", "getComponentValue", "getCurrentPackageIdentifier", "getCurrentProductIdentifier", "getDefaultIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDefaultPackageIdentifier", "getDefaultProductIdentifier", "getDestinationContextName", "getDestinationIndex", "getDestinationPackageIdentifier", "getDestinationProductIdentifier", "getOriginContextName", "getOriginIndex", "getOriginPackageIdentifier", "getOriginProductIdentifier", "getResultingPackageIdentifier", "getResultingProductIdentifier", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/revenuecat/purchases/paywalls/events/PaywallComponentType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/revenuecat/purchases/paywalls/events/PaywallComponentInteractionData;", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PaywallComponentInteractionData {
    private final String componentName;
    private final PaywallComponentType componentType;
    private final String componentUrl;
    private final String componentValue;
    private final String currentPackageIdentifier;
    private final String currentProductIdentifier;
    private final Integer defaultIndex;
    private final String defaultPackageIdentifier;
    private final String defaultProductIdentifier;
    private final String destinationContextName;
    private final Integer destinationIndex;
    private final String destinationPackageIdentifier;
    private final String destinationProductIdentifier;
    private final String originContextName;
    private final Integer originIndex;
    private final String originPackageIdentifier;
    private final String originProductIdentifier;
    private final String resultingPackageIdentifier;
    private final String resultingProductIdentifier;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer[] $childSerializers = {PaywallComponentType.INSTANCE.serializer(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null};

    public static /* synthetic */ PaywallComponentInteractionData copy$default(PaywallComponentInteractionData paywallComponentInteractionData, PaywallComponentType paywallComponentType, String str, String str2, String str3, Integer num, Integer num2, String str4, String str5, Integer num3, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, int i, Object obj) {
        String str16;
        String str17;
        PaywallComponentType paywallComponentType2 = (i & 1) != 0 ? paywallComponentInteractionData.componentType : paywallComponentType;
        String str18 = (i & 2) != 0 ? paywallComponentInteractionData.componentName : str;
        String str19 = (i & 4) != 0 ? paywallComponentInteractionData.componentValue : str2;
        String str20 = (i & 8) != 0 ? paywallComponentInteractionData.componentUrl : str3;
        Integer num4 = (i & 16) != 0 ? paywallComponentInteractionData.originIndex : num;
        Integer num5 = (i & 32) != 0 ? paywallComponentInteractionData.destinationIndex : num2;
        String str21 = (i & 64) != 0 ? paywallComponentInteractionData.originContextName : str4;
        String str22 = (i & 128) != 0 ? paywallComponentInteractionData.destinationContextName : str5;
        Integer num6 = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? paywallComponentInteractionData.defaultIndex : num3;
        String str23 = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? paywallComponentInteractionData.originPackageIdentifier : str6;
        String str24 = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? paywallComponentInteractionData.destinationPackageIdentifier : str7;
        String str25 = (i & 2048) != 0 ? paywallComponentInteractionData.defaultPackageIdentifier : str8;
        String str26 = (i & 4096) != 0 ? paywallComponentInteractionData.originProductIdentifier : str9;
        String str27 = (i & 8192) != 0 ? paywallComponentInteractionData.destinationProductIdentifier : str10;
        PaywallComponentType paywallComponentType3 = paywallComponentType2;
        String str28 = (i & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? paywallComponentInteractionData.defaultProductIdentifier : str11;
        String str29 = (i & 32768) != 0 ? paywallComponentInteractionData.currentPackageIdentifier : str12;
        String str30 = (i & 65536) != 0 ? paywallComponentInteractionData.resultingPackageIdentifier : str13;
        String str31 = (i & 131072) != 0 ? paywallComponentInteractionData.currentProductIdentifier : str14;
        if ((i & 262144) != 0) {
            str17 = str31;
            str16 = paywallComponentInteractionData.resultingProductIdentifier;
        } else {
            str16 = str15;
            str17 = str31;
        }
        return paywallComponentInteractionData.copy(paywallComponentType3, str18, str19, str20, num4, num5, str21, str22, num6, str23, str24, str25, str26, str27, str28, str29, str30, str17, str16);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final PaywallComponentType getComponentType() {
        return this.componentType;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getOriginPackageIdentifier() {
        return this.originPackageIdentifier;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getDestinationPackageIdentifier() {
        return this.destinationPackageIdentifier;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getDefaultPackageIdentifier() {
        return this.defaultPackageIdentifier;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getOriginProductIdentifier() {
        return this.originProductIdentifier;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getDestinationProductIdentifier() {
        return this.destinationProductIdentifier;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getDefaultProductIdentifier() {
        return this.defaultProductIdentifier;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getCurrentPackageIdentifier() {
        return this.currentPackageIdentifier;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getResultingPackageIdentifier() {
        return this.resultingPackageIdentifier;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getCurrentProductIdentifier() {
        return this.currentProductIdentifier;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final String getResultingProductIdentifier() {
        return this.resultingProductIdentifier;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getComponentName() {
        return this.componentName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getComponentValue() {
        return this.componentValue;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getComponentUrl() {
        return this.componentUrl;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getOriginIndex() {
        return this.originIndex;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Integer getDestinationIndex() {
        return this.destinationIndex;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getOriginContextName() {
        return this.originContextName;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getDestinationContextName() {
        return this.destinationContextName;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Integer getDefaultIndex() {
        return this.defaultIndex;
    }

    public final PaywallComponentInteractionData copy(PaywallComponentType componentType, String componentName, String componentValue, String componentUrl, Integer originIndex, Integer destinationIndex, String originContextName, String destinationContextName, Integer defaultIndex, String originPackageIdentifier, String destinationPackageIdentifier, String defaultPackageIdentifier, String originProductIdentifier, String destinationProductIdentifier, String defaultProductIdentifier, String currentPackageIdentifier, String resultingPackageIdentifier, String currentProductIdentifier, String resultingProductIdentifier) {
        Intrinsics.checkNotNullParameter(componentType, "componentType");
        Intrinsics.checkNotNullParameter(componentValue, "componentValue");
        return new PaywallComponentInteractionData(componentType, componentName, componentValue, componentUrl, originIndex, destinationIndex, originContextName, destinationContextName, defaultIndex, originPackageIdentifier, destinationPackageIdentifier, defaultPackageIdentifier, originProductIdentifier, destinationProductIdentifier, defaultProductIdentifier, currentPackageIdentifier, resultingPackageIdentifier, currentProductIdentifier, resultingProductIdentifier);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PaywallComponentInteractionData)) {
            return false;
        }
        PaywallComponentInteractionData paywallComponentInteractionData = (PaywallComponentInteractionData) other;
        return this.componentType == paywallComponentInteractionData.componentType && Intrinsics.areEqual(this.componentName, paywallComponentInteractionData.componentName) && Intrinsics.areEqual(this.componentValue, paywallComponentInteractionData.componentValue) && Intrinsics.areEqual(this.componentUrl, paywallComponentInteractionData.componentUrl) && Intrinsics.areEqual(this.originIndex, paywallComponentInteractionData.originIndex) && Intrinsics.areEqual(this.destinationIndex, paywallComponentInteractionData.destinationIndex) && Intrinsics.areEqual(this.originContextName, paywallComponentInteractionData.originContextName) && Intrinsics.areEqual(this.destinationContextName, paywallComponentInteractionData.destinationContextName) && Intrinsics.areEqual(this.defaultIndex, paywallComponentInteractionData.defaultIndex) && Intrinsics.areEqual(this.originPackageIdentifier, paywallComponentInteractionData.originPackageIdentifier) && Intrinsics.areEqual(this.destinationPackageIdentifier, paywallComponentInteractionData.destinationPackageIdentifier) && Intrinsics.areEqual(this.defaultPackageIdentifier, paywallComponentInteractionData.defaultPackageIdentifier) && Intrinsics.areEqual(this.originProductIdentifier, paywallComponentInteractionData.originProductIdentifier) && Intrinsics.areEqual(this.destinationProductIdentifier, paywallComponentInteractionData.destinationProductIdentifier) && Intrinsics.areEqual(this.defaultProductIdentifier, paywallComponentInteractionData.defaultProductIdentifier) && Intrinsics.areEqual(this.currentPackageIdentifier, paywallComponentInteractionData.currentPackageIdentifier) && Intrinsics.areEqual(this.resultingPackageIdentifier, paywallComponentInteractionData.resultingPackageIdentifier) && Intrinsics.areEqual(this.currentProductIdentifier, paywallComponentInteractionData.currentProductIdentifier) && Intrinsics.areEqual(this.resultingProductIdentifier, paywallComponentInteractionData.resultingProductIdentifier);
    }

    public int hashCode() {
        int iHashCode = this.componentType.hashCode() * 31;
        String str = this.componentName;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.componentValue.hashCode()) * 31;
        String str2 = this.componentUrl;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.originIndex;
        int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.destinationIndex;
        int iHashCode5 = (iHashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str3 = this.originContextName;
        int iHashCode6 = (iHashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.destinationContextName;
        int iHashCode7 = (iHashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num3 = this.defaultIndex;
        int iHashCode8 = (iHashCode7 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str5 = this.originPackageIdentifier;
        int iHashCode9 = (iHashCode8 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.destinationPackageIdentifier;
        int iHashCode10 = (iHashCode9 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.defaultPackageIdentifier;
        int iHashCode11 = (iHashCode10 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.originProductIdentifier;
        int iHashCode12 = (iHashCode11 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.destinationProductIdentifier;
        int iHashCode13 = (iHashCode12 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.defaultProductIdentifier;
        int iHashCode14 = (iHashCode13 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.currentPackageIdentifier;
        int iHashCode15 = (iHashCode14 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.resultingPackageIdentifier;
        int iHashCode16 = (iHashCode15 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.currentProductIdentifier;
        int iHashCode17 = (iHashCode16 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.resultingProductIdentifier;
        return iHashCode17 + (str14 != null ? str14.hashCode() : 0);
    }

    public String toString() {
        return "PaywallComponentInteractionData(componentType=" + this.componentType + ", componentName=" + this.componentName + ", componentValue=" + this.componentValue + ", componentUrl=" + this.componentUrl + ", originIndex=" + this.originIndex + ", destinationIndex=" + this.destinationIndex + ", originContextName=" + this.originContextName + ", destinationContextName=" + this.destinationContextName + ", defaultIndex=" + this.defaultIndex + ", originPackageIdentifier=" + this.originPackageIdentifier + ", destinationPackageIdentifier=" + this.destinationPackageIdentifier + ", defaultPackageIdentifier=" + this.defaultPackageIdentifier + ", originProductIdentifier=" + this.originProductIdentifier + ", destinationProductIdentifier=" + this.destinationProductIdentifier + ", defaultProductIdentifier=" + this.defaultProductIdentifier + ", currentPackageIdentifier=" + this.currentPackageIdentifier + ", resultingPackageIdentifier=" + this.resultingPackageIdentifier + ", currentProductIdentifier=" + this.currentProductIdentifier + ", resultingProductIdentifier=" + this.resultingProductIdentifier + ')';
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/events/PaywallComponentInteractionData$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/events/PaywallComponentInteractionData;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer serializer() {
            return PaywallComponentInteractionData$$serializer.INSTANCE;
        }
    }

    @Deprecated
    public /* synthetic */ PaywallComponentInteractionData(int i, PaywallComponentType paywallComponentType, String str, String str2, String str3, Integer num, Integer num2, String str4, String str5, Integer num3, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, SerializationConstructorMarker serializationConstructorMarker) {
        if (5 != (i & 5)) {
            PluginExceptionsKt.throwMissingFieldException(i, 5, PaywallComponentInteractionData$$serializer.INSTANCE.getDescriptor());
        }
        this.componentType = paywallComponentType;
        if ((i & 2) == 0) {
            this.componentName = null;
        } else {
            this.componentName = str;
        }
        this.componentValue = str2;
        if ((i & 8) == 0) {
            this.componentUrl = null;
        } else {
            this.componentUrl = str3;
        }
        if ((i & 16) == 0) {
            this.originIndex = null;
        } else {
            this.originIndex = num;
        }
        if ((i & 32) == 0) {
            this.destinationIndex = null;
        } else {
            this.destinationIndex = num2;
        }
        if ((i & 64) == 0) {
            this.originContextName = null;
        } else {
            this.originContextName = str4;
        }
        if ((i & 128) == 0) {
            this.destinationContextName = null;
        } else {
            this.destinationContextName = str5;
        }
        if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) == 0) {
            this.defaultIndex = null;
        } else {
            this.defaultIndex = num3;
        }
        if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) == 0) {
            this.originPackageIdentifier = null;
        } else {
            this.originPackageIdentifier = str6;
        }
        if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) == 0) {
            this.destinationPackageIdentifier = null;
        } else {
            this.destinationPackageIdentifier = str7;
        }
        if ((i & 2048) == 0) {
            this.defaultPackageIdentifier = null;
        } else {
            this.defaultPackageIdentifier = str8;
        }
        if ((i & 4096) == 0) {
            this.originProductIdentifier = null;
        } else {
            this.originProductIdentifier = str9;
        }
        if ((i & 8192) == 0) {
            this.destinationProductIdentifier = null;
        } else {
            this.destinationProductIdentifier = str10;
        }
        if ((i & Http2.INITIAL_MAX_FRAME_SIZE) == 0) {
            this.defaultProductIdentifier = null;
        } else {
            this.defaultProductIdentifier = str11;
        }
        if ((32768 & i) == 0) {
            this.currentPackageIdentifier = null;
        } else {
            this.currentPackageIdentifier = str12;
        }
        if ((65536 & i) == 0) {
            this.resultingPackageIdentifier = null;
        } else {
            this.resultingPackageIdentifier = str13;
        }
        if ((131072 & i) == 0) {
            this.currentProductIdentifier = null;
        } else {
            this.currentProductIdentifier = str14;
        }
        if ((i & 262144) == 0) {
            this.resultingProductIdentifier = null;
        } else {
            this.resultingProductIdentifier = str15;
        }
    }

    public PaywallComponentInteractionData(PaywallComponentType componentType, String str, String componentValue, String str2, Integer num, Integer num2, String str3, String str4, Integer num3, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
        Intrinsics.checkNotNullParameter(componentType, "componentType");
        Intrinsics.checkNotNullParameter(componentValue, "componentValue");
        this.componentType = componentType;
        this.componentName = str;
        this.componentValue = componentValue;
        this.componentUrl = str2;
        this.originIndex = num;
        this.destinationIndex = num2;
        this.originContextName = str3;
        this.destinationContextName = str4;
        this.defaultIndex = num3;
        this.originPackageIdentifier = str5;
        this.destinationPackageIdentifier = str6;
        this.defaultPackageIdentifier = str7;
        this.originProductIdentifier = str8;
        this.destinationProductIdentifier = str9;
        this.defaultProductIdentifier = str10;
        this.currentPackageIdentifier = str11;
        this.resultingPackageIdentifier = str12;
        this.currentProductIdentifier = str13;
        this.resultingProductIdentifier = str14;
    }

    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(PaywallComponentInteractionData self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, $childSerializers[0], self.componentType);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.componentName != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.componentName);
        }
        output.encodeStringElement(serialDesc, 2, self.componentValue);
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.componentUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.componentUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.originIndex != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, IntSerializer.INSTANCE, self.originIndex);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.destinationIndex != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, IntSerializer.INSTANCE, self.destinationIndex);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.originContextName != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.originContextName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.destinationContextName != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.destinationContextName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.defaultIndex != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, IntSerializer.INSTANCE, self.defaultIndex);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.originPackageIdentifier != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.originPackageIdentifier);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.destinationPackageIdentifier != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, StringSerializer.INSTANCE, self.destinationPackageIdentifier);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.defaultPackageIdentifier != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, StringSerializer.INSTANCE, self.defaultPackageIdentifier);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.originProductIdentifier != null) {
            output.encodeNullableSerializableElement(serialDesc, 12, StringSerializer.INSTANCE, self.originProductIdentifier);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || self.destinationProductIdentifier != null) {
            output.encodeNullableSerializableElement(serialDesc, 13, StringSerializer.INSTANCE, self.destinationProductIdentifier);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || self.defaultProductIdentifier != null) {
            output.encodeNullableSerializableElement(serialDesc, 14, StringSerializer.INSTANCE, self.defaultProductIdentifier);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15) || self.currentPackageIdentifier != null) {
            output.encodeNullableSerializableElement(serialDesc, 15, StringSerializer.INSTANCE, self.currentPackageIdentifier);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 16) || self.resultingPackageIdentifier != null) {
            output.encodeNullableSerializableElement(serialDesc, 16, StringSerializer.INSTANCE, self.resultingPackageIdentifier);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 17) || self.currentProductIdentifier != null) {
            output.encodeNullableSerializableElement(serialDesc, 17, StringSerializer.INSTANCE, self.currentProductIdentifier);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 18) && self.resultingProductIdentifier == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 18, StringSerializer.INSTANCE, self.resultingProductIdentifier);
    }

    public /* synthetic */ PaywallComponentInteractionData(PaywallComponentType paywallComponentType, String str, String str2, String str3, Integer num, Integer num2, String str4, String str5, Integer num3, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(paywallComponentType, (i & 2) != 0 ? null : str, str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : num, (i & 32) != 0 ? null : num2, (i & 64) != 0 ? null : str4, (i & 128) != 0 ? null : str5, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? null : num3, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? null : str6, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? null : str7, (i & 2048) != 0 ? null : str8, (i & 4096) != 0 ? null : str9, (i & 8192) != 0 ? null : str10, (i & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? null : str11, (32768 & i) != 0 ? null : str12, (65536 & i) != 0 ? null : str13, (131072 & i) != 0 ? null : str14, (i & 262144) != 0 ? null : str15);
    }

    public final PaywallComponentType getComponentType() {
        return this.componentType;
    }

    public final String getComponentName() {
        return this.componentName;
    }

    public final String getComponentValue() {
        return this.componentValue;
    }

    public final String getComponentUrl() {
        return this.componentUrl;
    }

    public final Integer getOriginIndex() {
        return this.originIndex;
    }

    public final Integer getDestinationIndex() {
        return this.destinationIndex;
    }

    public final String getOriginContextName() {
        return this.originContextName;
    }

    public final String getDestinationContextName() {
        return this.destinationContextName;
    }

    public final Integer getDefaultIndex() {
        return this.defaultIndex;
    }

    public final String getOriginPackageIdentifier() {
        return this.originPackageIdentifier;
    }

    public final String getDestinationPackageIdentifier() {
        return this.destinationPackageIdentifier;
    }

    public final String getDefaultPackageIdentifier() {
        return this.defaultPackageIdentifier;
    }

    public final String getOriginProductIdentifier() {
        return this.originProductIdentifier;
    }

    public final String getDestinationProductIdentifier() {
        return this.destinationProductIdentifier;
    }

    public final String getDefaultProductIdentifier() {
        return this.defaultProductIdentifier;
    }

    public final String getCurrentPackageIdentifier() {
        return this.currentPackageIdentifier;
    }

    public final String getResultingPackageIdentifier() {
        return this.resultingPackageIdentifier;
    }

    public final String getCurrentProductIdentifier() {
        return this.currentProductIdentifier;
    }

    public final String getResultingProductIdentifier() {
        return this.resultingProductIdentifier;
    }
}
