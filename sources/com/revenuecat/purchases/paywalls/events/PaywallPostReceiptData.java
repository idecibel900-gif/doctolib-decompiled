package com.revenuecat.purchases.paywalls.events;

import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.utils.JsonElementExtensionsKt;
import com.revenuecat.purchases.utils.MapExtensionsKt;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 :2\u00020\u0001:\u00029:Bi\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\t\u001a\u00020\n\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fB?\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005¢\u0006\u0002\u0010\u0010J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\nHÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003JQ\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u0005HÆ\u0001J\u0013\u0010+\u001a\u00020\n2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\u0014\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010/J\t\u00100\u001a\u00020\u0005HÖ\u0001J&\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00002\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207HÁ\u0001¢\u0006\u0002\b8R\u001c\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0017R\u001c\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0017R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u0017R\u001c\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0012\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0012\u001a\u0004\b\"\u0010\u0017¨\u0006;"}, d2 = {"Lcom/revenuecat/purchases/paywalls/events/PaywallPostReceiptData;", "", "seen1", "", "paywallID", "", "sessionID", "revision", "displayMode", "darkMode", "", "localeIdentifier", "offeringId", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "getDarkMode$annotations", "()V", "getDarkMode", "()Z", "getDisplayMode$annotations", "getDisplayMode", "()Ljava/lang/String;", "getLocaleIdentifier$annotations", "getLocaleIdentifier", "getOfferingId$annotations", "getOfferingId", "getPaywallID$annotations", "getPaywallID", "getRevision$annotations", "getRevision", "()I", "getSessionID$annotations", "getSessionID", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "toMap", "", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PaywallPostReceiptData {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Json.Default json = Json.Default;
    private final boolean darkMode;
    private final String displayMode;
    private final String localeIdentifier;
    private final String offeringId;
    private final String paywallID;
    private final int revision;
    private final String sessionID;

    public static /* synthetic */ PaywallPostReceiptData copy$default(PaywallPostReceiptData paywallPostReceiptData, String str, String str2, int i, String str3, boolean z, String str4, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = paywallPostReceiptData.paywallID;
        }
        if ((i2 & 2) != 0) {
            str2 = paywallPostReceiptData.sessionID;
        }
        if ((i2 & 4) != 0) {
            i = paywallPostReceiptData.revision;
        }
        if ((i2 & 8) != 0) {
            str3 = paywallPostReceiptData.displayMode;
        }
        if ((i2 & 16) != 0) {
            z = paywallPostReceiptData.darkMode;
        }
        if ((i2 & 32) != 0) {
            str4 = paywallPostReceiptData.localeIdentifier;
        }
        if ((i2 & 64) != 0) {
            str5 = paywallPostReceiptData.offeringId;
        }
        String str6 = str4;
        String str7 = str5;
        boolean z2 = z;
        int i3 = i;
        return paywallPostReceiptData.copy(str, str2, i3, str3, z2, str6, str7);
    }

    public static /* synthetic */ void getDarkMode$annotations() {
    }

    public static /* synthetic */ void getDisplayMode$annotations() {
    }

    public static /* synthetic */ void getLocaleIdentifier$annotations() {
    }

    public static /* synthetic */ void getOfferingId$annotations() {
    }

    public static /* synthetic */ void getPaywallID$annotations() {
    }

    public static /* synthetic */ void getRevision$annotations() {
    }

    public static /* synthetic */ void getSessionID$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPaywallID() {
        return this.paywallID;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSessionID() {
        return this.sessionID;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getRevision() {
        return this.revision;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getDisplayMode() {
        return this.displayMode;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getDarkMode() {
        return this.darkMode;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getLocaleIdentifier() {
        return this.localeIdentifier;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getOfferingId() {
        return this.offeringId;
    }

    public final PaywallPostReceiptData copy(String paywallID, String sessionID, int revision, String displayMode, boolean darkMode, String localeIdentifier, String offeringId) {
        Intrinsics.checkNotNullParameter(sessionID, "sessionID");
        Intrinsics.checkNotNullParameter(displayMode, "displayMode");
        Intrinsics.checkNotNullParameter(localeIdentifier, "localeIdentifier");
        Intrinsics.checkNotNullParameter(offeringId, "offeringId");
        return new PaywallPostReceiptData(paywallID, sessionID, revision, displayMode, darkMode, localeIdentifier, offeringId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PaywallPostReceiptData)) {
            return false;
        }
        PaywallPostReceiptData paywallPostReceiptData = (PaywallPostReceiptData) other;
        return Intrinsics.areEqual(this.paywallID, paywallPostReceiptData.paywallID) && Intrinsics.areEqual(this.sessionID, paywallPostReceiptData.sessionID) && this.revision == paywallPostReceiptData.revision && Intrinsics.areEqual(this.displayMode, paywallPostReceiptData.displayMode) && this.darkMode == paywallPostReceiptData.darkMode && Intrinsics.areEqual(this.localeIdentifier, paywallPostReceiptData.localeIdentifier) && Intrinsics.areEqual(this.offeringId, paywallPostReceiptData.offeringId);
    }

    public int hashCode() {
        String str = this.paywallID;
        return ((((((((((((str == null ? 0 : str.hashCode()) * 31) + this.sessionID.hashCode()) * 31) + Integer.hashCode(this.revision)) * 31) + this.displayMode.hashCode()) * 31) + Boolean.hashCode(this.darkMode)) * 31) + this.localeIdentifier.hashCode()) * 31) + this.offeringId.hashCode();
    }

    public String toString() {
        return "PaywallPostReceiptData(paywallID=" + this.paywallID + ", sessionID=" + this.sessionID + ", revision=" + this.revision + ", displayMode=" + this.displayMode + ", darkMode=" + this.darkMode + ", localeIdentifier=" + this.localeIdentifier + ", offeringId=" + this.offeringId + ')';
    }

    @Deprecated
    public /* synthetic */ PaywallPostReceiptData(int i, String str, String str2, int i2, String str3, boolean z, String str4, String str5, SerializationConstructorMarker serializationConstructorMarker) {
        if (127 != (i & 127)) {
            PluginExceptionsKt.throwMissingFieldException(i, 127, PaywallPostReceiptData$$serializer.INSTANCE.getDescriptor());
        }
        this.paywallID = str;
        this.sessionID = str2;
        this.revision = i2;
        this.displayMode = str3;
        this.darkMode = z;
        this.localeIdentifier = str4;
        this.offeringId = str5;
    }

    public PaywallPostReceiptData(String str, String sessionID, int i, String displayMode, boolean z, String localeIdentifier, String offeringId) {
        Intrinsics.checkNotNullParameter(sessionID, "sessionID");
        Intrinsics.checkNotNullParameter(displayMode, "displayMode");
        Intrinsics.checkNotNullParameter(localeIdentifier, "localeIdentifier");
        Intrinsics.checkNotNullParameter(offeringId, "offeringId");
        this.paywallID = str;
        this.sessionID = sessionID;
        this.revision = i;
        this.displayMode = displayMode;
        this.darkMode = z;
        this.localeIdentifier = localeIdentifier;
        this.offeringId = offeringId;
    }

    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(PaywallPostReceiptData self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.paywallID);
        output.encodeStringElement(serialDesc, 1, self.sessionID);
        output.encodeIntElement(serialDesc, 2, self.revision);
        output.encodeStringElement(serialDesc, 3, self.displayMode);
        output.encodeBooleanElement(serialDesc, 4, self.darkMode);
        output.encodeStringElement(serialDesc, 5, self.localeIdentifier);
        output.encodeStringElement(serialDesc, 6, self.offeringId);
    }

    public final String getPaywallID() {
        return this.paywallID;
    }

    public final String getSessionID() {
        return this.sessionID;
    }

    public final int getRevision() {
        return this.revision;
    }

    public final String getDisplayMode() {
        return this.displayMode;
    }

    public final boolean getDarkMode() {
        return this.darkMode;
    }

    public final String getLocaleIdentifier() {
        return this.localeIdentifier;
    }

    public final String getOfferingId() {
        return this.offeringId;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/revenuecat/purchases/paywalls/events/PaywallPostReceiptData$Companion;", "", "()V", "json", "Lkotlinx/serialization/json/Json$Default;", "getJson", "()Lkotlinx/serialization/json/Json$Default;", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/events/PaywallPostReceiptData;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer serializer() {
            return PaywallPostReceiptData$$serializer.INSTANCE;
        }

        public final Json.Default getJson() {
            return PaywallPostReceiptData.json;
        }
    }

    public final Map<String, Object> toMap() {
        Json.Default r0 = json;
        r0.getSerializersModule();
        Map<String, Object> mapAsMap = JsonElementExtensionsKt.asMap(r0.encodeToJsonElement(INSTANCE.serializer(), this));
        if (mapAsMap == null) {
            return null;
        }
        return MapExtensionsKt.filterNotNullValues(mapAsMap);
    }
}
