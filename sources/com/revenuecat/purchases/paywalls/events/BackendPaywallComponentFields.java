package com.revenuecat.purchases.paywalls.events;

import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http2.Http2;

/* JADX INFO: loaded from: classes4.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b;\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0081\b\u0018\u00002\u00020\u0001Bé\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010<\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010=\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010 Jò\u0001\u0010A\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010BJ\u0013\u0010C\u001a\u00020D2\b\u0010E\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010F\u001a\u00020\bHÖ\u0001J\t\u0010G\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0015\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019R\u0015\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010!\u001a\u0004\b%\u0010 R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0019R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0019R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0019R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010!\u001a\u0004\b)\u0010 R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0019R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0019R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0019R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0019¨\u0006H"}, d2 = {"Lcom/revenuecat/purchases/paywalls/events/BackendPaywallComponentFields;", "", "componentType", "", "componentName", "componentValue", "componentUrl", "originIndex", "", "destinationIndex", "originContextName", "destinationContextName", "defaultIndex", "originPackageIdentifier", "destinationPackageIdentifier", "defaultPackageIdentifier", "originProductIdentifier", "destinationProductIdentifier", "defaultProductIdentifier", "currentPackageIdentifier", "resultingPackageIdentifier", "currentProductIdentifier", "resultingProductIdentifier", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getComponentName", "()Ljava/lang/String;", "getComponentType", "getComponentUrl", "getComponentValue", "getCurrentPackageIdentifier", "getCurrentProductIdentifier", "getDefaultIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDefaultPackageIdentifier", "getDefaultProductIdentifier", "getDestinationContextName", "getDestinationIndex", "getDestinationPackageIdentifier", "getDestinationProductIdentifier", "getOriginContextName", "getOriginIndex", "getOriginPackageIdentifier", "getOriginProductIdentifier", "getResultingPackageIdentifier", "getResultingProductIdentifier", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/revenuecat/purchases/paywalls/events/BackendPaywallComponentFields;", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "toString", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class BackendPaywallComponentFields {
    private final String componentName;
    private final String componentType;
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

    public BackendPaywallComponentFields() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 524287, null);
    }

    public static /* synthetic */ BackendPaywallComponentFields copy$default(BackendPaywallComponentFields backendPaywallComponentFields, String str, String str2, String str3, String str4, Integer num, Integer num2, String str5, String str6, Integer num3, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, int i, Object obj) {
        String str17;
        String str18;
        String str19 = (i & 1) != 0 ? backendPaywallComponentFields.componentType : str;
        String str20 = (i & 2) != 0 ? backendPaywallComponentFields.componentName : str2;
        String str21 = (i & 4) != 0 ? backendPaywallComponentFields.componentValue : str3;
        String str22 = (i & 8) != 0 ? backendPaywallComponentFields.componentUrl : str4;
        Integer num4 = (i & 16) != 0 ? backendPaywallComponentFields.originIndex : num;
        Integer num5 = (i & 32) != 0 ? backendPaywallComponentFields.destinationIndex : num2;
        String str23 = (i & 64) != 0 ? backendPaywallComponentFields.originContextName : str5;
        String str24 = (i & 128) != 0 ? backendPaywallComponentFields.destinationContextName : str6;
        Integer num6 = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? backendPaywallComponentFields.defaultIndex : num3;
        String str25 = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? backendPaywallComponentFields.originPackageIdentifier : str7;
        String str26 = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? backendPaywallComponentFields.destinationPackageIdentifier : str8;
        String str27 = (i & 2048) != 0 ? backendPaywallComponentFields.defaultPackageIdentifier : str9;
        String str28 = (i & 4096) != 0 ? backendPaywallComponentFields.originProductIdentifier : str10;
        String str29 = (i & 8192) != 0 ? backendPaywallComponentFields.destinationProductIdentifier : str11;
        String str30 = str19;
        String str31 = (i & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? backendPaywallComponentFields.defaultProductIdentifier : str12;
        String str32 = (i & 32768) != 0 ? backendPaywallComponentFields.currentPackageIdentifier : str13;
        String str33 = (i & 65536) != 0 ? backendPaywallComponentFields.resultingPackageIdentifier : str14;
        String str34 = (i & 131072) != 0 ? backendPaywallComponentFields.currentProductIdentifier : str15;
        if ((i & 262144) != 0) {
            str18 = str34;
            str17 = backendPaywallComponentFields.resultingProductIdentifier;
        } else {
            str17 = str16;
            str18 = str34;
        }
        return backendPaywallComponentFields.copy(str30, str20, str21, str22, num4, num5, str23, str24, num6, str25, str26, str27, str28, str29, str31, str32, str33, str18, str17);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getComponentType() {
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

    public final BackendPaywallComponentFields copy(String componentType, String componentName, String componentValue, String componentUrl, Integer originIndex, Integer destinationIndex, String originContextName, String destinationContextName, Integer defaultIndex, String originPackageIdentifier, String destinationPackageIdentifier, String defaultPackageIdentifier, String originProductIdentifier, String destinationProductIdentifier, String defaultProductIdentifier, String currentPackageIdentifier, String resultingPackageIdentifier, String currentProductIdentifier, String resultingProductIdentifier) {
        return new BackendPaywallComponentFields(componentType, componentName, componentValue, componentUrl, originIndex, destinationIndex, originContextName, destinationContextName, defaultIndex, originPackageIdentifier, destinationPackageIdentifier, defaultPackageIdentifier, originProductIdentifier, destinationProductIdentifier, defaultProductIdentifier, currentPackageIdentifier, resultingPackageIdentifier, currentProductIdentifier, resultingProductIdentifier);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BackendPaywallComponentFields)) {
            return false;
        }
        BackendPaywallComponentFields backendPaywallComponentFields = (BackendPaywallComponentFields) other;
        return Intrinsics.areEqual(this.componentType, backendPaywallComponentFields.componentType) && Intrinsics.areEqual(this.componentName, backendPaywallComponentFields.componentName) && Intrinsics.areEqual(this.componentValue, backendPaywallComponentFields.componentValue) && Intrinsics.areEqual(this.componentUrl, backendPaywallComponentFields.componentUrl) && Intrinsics.areEqual(this.originIndex, backendPaywallComponentFields.originIndex) && Intrinsics.areEqual(this.destinationIndex, backendPaywallComponentFields.destinationIndex) && Intrinsics.areEqual(this.originContextName, backendPaywallComponentFields.originContextName) && Intrinsics.areEqual(this.destinationContextName, backendPaywallComponentFields.destinationContextName) && Intrinsics.areEqual(this.defaultIndex, backendPaywallComponentFields.defaultIndex) && Intrinsics.areEqual(this.originPackageIdentifier, backendPaywallComponentFields.originPackageIdentifier) && Intrinsics.areEqual(this.destinationPackageIdentifier, backendPaywallComponentFields.destinationPackageIdentifier) && Intrinsics.areEqual(this.defaultPackageIdentifier, backendPaywallComponentFields.defaultPackageIdentifier) && Intrinsics.areEqual(this.originProductIdentifier, backendPaywallComponentFields.originProductIdentifier) && Intrinsics.areEqual(this.destinationProductIdentifier, backendPaywallComponentFields.destinationProductIdentifier) && Intrinsics.areEqual(this.defaultProductIdentifier, backendPaywallComponentFields.defaultProductIdentifier) && Intrinsics.areEqual(this.currentPackageIdentifier, backendPaywallComponentFields.currentPackageIdentifier) && Intrinsics.areEqual(this.resultingPackageIdentifier, backendPaywallComponentFields.resultingPackageIdentifier) && Intrinsics.areEqual(this.currentProductIdentifier, backendPaywallComponentFields.currentProductIdentifier) && Intrinsics.areEqual(this.resultingProductIdentifier, backendPaywallComponentFields.resultingProductIdentifier);
    }

    public int hashCode() {
        String str = this.componentType;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.componentName;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.componentValue;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.componentUrl;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num = this.originIndex;
        int iHashCode5 = (iHashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.destinationIndex;
        int iHashCode6 = (iHashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str5 = this.originContextName;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.destinationContextName;
        int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Integer num3 = this.defaultIndex;
        int iHashCode9 = (iHashCode8 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str7 = this.originPackageIdentifier;
        int iHashCode10 = (iHashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.destinationPackageIdentifier;
        int iHashCode11 = (iHashCode10 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.defaultPackageIdentifier;
        int iHashCode12 = (iHashCode11 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.originProductIdentifier;
        int iHashCode13 = (iHashCode12 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.destinationProductIdentifier;
        int iHashCode14 = (iHashCode13 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.defaultProductIdentifier;
        int iHashCode15 = (iHashCode14 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.currentPackageIdentifier;
        int iHashCode16 = (iHashCode15 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.resultingPackageIdentifier;
        int iHashCode17 = (iHashCode16 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.currentProductIdentifier;
        int iHashCode18 = (iHashCode17 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.resultingProductIdentifier;
        return iHashCode18 + (str16 != null ? str16.hashCode() : 0);
    }

    public String toString() {
        return "BackendPaywallComponentFields(componentType=" + this.componentType + ", componentName=" + this.componentName + ", componentValue=" + this.componentValue + ", componentUrl=" + this.componentUrl + ", originIndex=" + this.originIndex + ", destinationIndex=" + this.destinationIndex + ", originContextName=" + this.originContextName + ", destinationContextName=" + this.destinationContextName + ", defaultIndex=" + this.defaultIndex + ", originPackageIdentifier=" + this.originPackageIdentifier + ", destinationPackageIdentifier=" + this.destinationPackageIdentifier + ", defaultPackageIdentifier=" + this.defaultPackageIdentifier + ", originProductIdentifier=" + this.originProductIdentifier + ", destinationProductIdentifier=" + this.destinationProductIdentifier + ", defaultProductIdentifier=" + this.defaultProductIdentifier + ", currentPackageIdentifier=" + this.currentPackageIdentifier + ", resultingPackageIdentifier=" + this.resultingPackageIdentifier + ", currentProductIdentifier=" + this.currentProductIdentifier + ", resultingProductIdentifier=" + this.resultingProductIdentifier + ')';
    }

    public BackendPaywallComponentFields(String str, String str2, String str3, String str4, Integer num, Integer num2, String str5, String str6, Integer num3, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16) {
        this.componentType = str;
        this.componentName = str2;
        this.componentValue = str3;
        this.componentUrl = str4;
        this.originIndex = num;
        this.destinationIndex = num2;
        this.originContextName = str5;
        this.destinationContextName = str6;
        this.defaultIndex = num3;
        this.originPackageIdentifier = str7;
        this.destinationPackageIdentifier = str8;
        this.defaultPackageIdentifier = str9;
        this.originProductIdentifier = str10;
        this.destinationProductIdentifier = str11;
        this.defaultProductIdentifier = str12;
        this.currentPackageIdentifier = str13;
        this.resultingPackageIdentifier = str14;
        this.currentProductIdentifier = str15;
        this.resultingProductIdentifier = str16;
    }

    public /* synthetic */ BackendPaywallComponentFields(String str, String str2, String str3, String str4, Integer num, Integer num2, String str5, String str6, Integer num3, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : num, (i & 32) != 0 ? null : num2, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : str6, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? null : num3, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? null : str7, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? null : str8, (i & 2048) != 0 ? null : str9, (i & 4096) != 0 ? null : str10, (i & 8192) != 0 ? null : str11, (i & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? null : str12, (i & 32768) != 0 ? null : str13, (i & 65536) != 0 ? null : str14, (i & 131072) != 0 ? null : str15, (i & 262144) != 0 ? null : str16);
    }

    public final String getComponentType() {
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
