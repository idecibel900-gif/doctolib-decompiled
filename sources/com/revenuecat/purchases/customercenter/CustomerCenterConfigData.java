package com.revenuecat.purchases.customercenter;

import com.amazon.a.a.o.b;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.facebook.react.modules.appstate.AppStateModule;
import com.opentok.android.BaseVideoCapturer;
import com.opentok.android.BluetoothManager;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.common.verification.SigningManager;
import com.revenuecat.purchases.paywalls.EmptyStringToNullSerializer;
import com.revenuecat.purchases.paywalls.PaywallColor;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import com.revenuecat.purchases.ui.revenuecatui.composables.BackgroundUIConstants;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallLegacyComponentInteraction;
import com.revenuecat.purchases.utils.EventsFileHelper;
import com.revenuecat.purchases.utils.PurchaseParamsValidator;
import java.lang.annotation.Annotation;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import net.openid.appauth.AuthorizationRequest;
import net.openid.appauth.CodeVerifierUtil;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes4.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0087\b\u0018\u0000 82\u00020\u0001:\b6789:;<=B[\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\b\u0001\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012B=\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0013J\u0015\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003J\t\u0010#\u001a\u00020\u000bHÆ\u0003J\t\u0010$\u001a\u00020\rHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u000fHÆ\u0003JI\u0010&\u001a\u00020\u00002\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\b\u0010*\u001a\u0004\u0018\u00010\u0007J\b\u0010+\u001a\u0004\u0018\u00010\u0007J\t\u0010,\u001a\u00020\u0003HÖ\u0001J\t\u0010-\u001a\u00020\u000fHÖ\u0001J&\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204HÁ\u0001¢\u0006\u0002\b5R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR(\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006>"}, d2 = {"Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData;", "", "seen1", "", "screens", "", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Screen$ScreenType;", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Screen;", "appearance", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Appearance;", "localization", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization;", "support", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support;", "lastPublishedAppVersion", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/Map;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Appearance;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/util/Map;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Appearance;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support;Ljava/lang/String;)V", "getAppearance", "()Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Appearance;", "getLastPublishedAppVersion$annotations", "()V", "getLastPublishedAppVersion", "()Ljava/lang/String;", "getLocalization", "()Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization;", "getScreens$annotations", "getScreens", "()Ljava/util/Map;", "getSupport", "()Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "getManagementScreen", "getNoActiveScreen", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Appearance", "Companion", "HelpPath", "Localization", "Screen", "ScreenOffering", "Support", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CustomerCenterConfigData {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Appearance appearance;
    private final String lastPublishedAppVersion;
    private final Localization localization;
    private final Map<Screen.ScreenType, Screen> screens;
    private final Support support;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CustomerCenterConfigData copy$default(CustomerCenterConfigData customerCenterConfigData, Map map, Appearance appearance, Localization localization, Support support, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            map = customerCenterConfigData.screens;
        }
        if ((i & 2) != 0) {
            appearance = customerCenterConfigData.appearance;
        }
        if ((i & 4) != 0) {
            localization = customerCenterConfigData.localization;
        }
        if ((i & 8) != 0) {
            support = customerCenterConfigData.support;
        }
        if ((i & 16) != 0) {
            str = customerCenterConfigData.lastPublishedAppVersion;
        }
        String str2 = str;
        Localization localization2 = localization;
        return customerCenterConfigData.copy(map, appearance, localization2, support, str2);
    }

    public static /* synthetic */ void getLastPublishedAppVersion$annotations() {
    }

    public static /* synthetic */ void getScreens$annotations() {
    }

    public final Map<Screen.ScreenType, Screen> component1() {
        return this.screens;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Appearance getAppearance() {
        return this.appearance;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Localization getLocalization() {
        return this.localization;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Support getSupport() {
        return this.support;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getLastPublishedAppVersion() {
        return this.lastPublishedAppVersion;
    }

    public final CustomerCenterConfigData copy(Map<Screen.ScreenType, Screen> screens, Appearance appearance, Localization localization, Support support, String lastPublishedAppVersion) {
        Intrinsics.checkNotNullParameter(screens, "screens");
        Intrinsics.checkNotNullParameter(appearance, "appearance");
        Intrinsics.checkNotNullParameter(localization, "localization");
        Intrinsics.checkNotNullParameter(support, "support");
        return new CustomerCenterConfigData(screens, appearance, localization, support, lastPublishedAppVersion);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CustomerCenterConfigData)) {
            return false;
        }
        CustomerCenterConfigData customerCenterConfigData = (CustomerCenterConfigData) other;
        return Intrinsics.areEqual(this.screens, customerCenterConfigData.screens) && Intrinsics.areEqual(this.appearance, customerCenterConfigData.appearance) && Intrinsics.areEqual(this.localization, customerCenterConfigData.localization) && Intrinsics.areEqual(this.support, customerCenterConfigData.support) && Intrinsics.areEqual(this.lastPublishedAppVersion, customerCenterConfigData.lastPublishedAppVersion);
    }

    public int hashCode() {
        int iHashCode = ((((((this.screens.hashCode() * 31) + this.appearance.hashCode()) * 31) + this.localization.hashCode()) * 31) + this.support.hashCode()) * 31;
        String str = this.lastPublishedAppVersion;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "CustomerCenterConfigData(screens=" + this.screens + ", appearance=" + this.appearance + ", localization=" + this.localization + ", support=" + this.support + ", lastPublishedAppVersion=" + this.lastPublishedAppVersion + ')';
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer serializer() {
            return CustomerCenterConfigData$$serializer.INSTANCE;
        }
    }

    @Deprecated
    public /* synthetic */ CustomerCenterConfigData(int i, Map map, Appearance appearance, Localization localization, Support support, String str, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (i & 15)) {
            PluginExceptionsKt.throwMissingFieldException(i, 15, CustomerCenterConfigData$$serializer.INSTANCE.getDescriptor());
        }
        this.screens = map;
        this.appearance = appearance;
        this.localization = localization;
        this.support = support;
        if ((i & 16) == 0) {
            this.lastPublishedAppVersion = null;
        } else {
            this.lastPublishedAppVersion = str;
        }
    }

    public CustomerCenterConfigData(Map<Screen.ScreenType, Screen> screens, Appearance appearance, Localization localization, Support support, String str) {
        Intrinsics.checkNotNullParameter(screens, "screens");
        Intrinsics.checkNotNullParameter(appearance, "appearance");
        Intrinsics.checkNotNullParameter(localization, "localization");
        Intrinsics.checkNotNullParameter(support, "support");
        this.screens = screens;
        this.appearance = appearance;
        this.localization = localization;
        this.support = support;
        this.lastPublishedAppVersion = str;
    }

    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(CustomerCenterConfigData self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, ScreenMapSerializer.INSTANCE, self.screens);
        output.encodeSerializableElement(serialDesc, 1, CustomerCenterConfigData$Appearance$$serializer.INSTANCE, self.appearance);
        output.encodeSerializableElement(serialDesc, 2, CustomerCenterConfigData$Localization$$serializer.INSTANCE, self.localization);
        output.encodeSerializableElement(serialDesc, 3, CustomerCenterConfigData$Support$$serializer.INSTANCE, self.support);
        if (!output.shouldEncodeElementDefault(serialDesc, 4) && self.lastPublishedAppVersion == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 4, EmptyStringToNullSerializer.INSTANCE, self.lastPublishedAppVersion);
    }

    public /* synthetic */ CustomerCenterConfigData(Map map, Appearance appearance, Localization localization, Support support, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(map, appearance, localization, support, (i & 16) != 0 ? null : str);
    }

    public final Map<Screen.ScreenType, Screen> getScreens() {
        return this.screens;
    }

    public final Appearance getAppearance() {
        return this.appearance;
    }

    public final Localization getLocalization() {
        return this.localization;
    }

    public final Support getSupport() {
        return this.support;
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0004%&'(B;\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0016\b\u0001\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB!\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u0015\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0003J)\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J&\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#HÁ\u0001¢\u0006\u0002\b$R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR(\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006)"}, d2 = {"Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization;", "", "seen1", "", "locale", "", "localizedStrings", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/util/Map;)V", "getLocale", "()Ljava/lang/String;", "getLocalizedStrings$annotations", "()V", "getLocalizedStrings", "()Ljava/util/Map;", "commonLocalizedString", SubscriberAttributeKt.JSON_NAME_KEY, "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization$CommonLocalizedString;", "component1", "component2", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "CommonLocalizedString", "Companion", "VariableName", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Localization {
        private static final KSerializer[] $childSerializers;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String locale;
        private final Map<String, String> localizedStrings;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Localization copy$default(Localization localization, String str, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                str = localization.locale;
            }
            if ((i & 2) != 0) {
                map = localization.localizedStrings;
            }
            return localization.copy(str, map);
        }

        public static /* synthetic */ void getLocalizedStrings$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getLocale() {
            return this.locale;
        }

        public final Map<String, String> component2() {
            return this.localizedStrings;
        }

        public final Localization copy(String locale, Map<String, String> localizedStrings) {
            Intrinsics.checkNotNullParameter(locale, "locale");
            Intrinsics.checkNotNullParameter(localizedStrings, "localizedStrings");
            return new Localization(locale, localizedStrings);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Localization)) {
                return false;
            }
            Localization localization = (Localization) other;
            return Intrinsics.areEqual(this.locale, localization.locale) && Intrinsics.areEqual(this.localizedStrings, localization.localizedStrings);
        }

        public int hashCode() {
            return (this.locale.hashCode() * 31) + this.localizedStrings.hashCode();
        }

        public String toString() {
            return "Localization(locale=" + this.locale + ", localizedStrings=" + this.localizedStrings + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer serializer() {
                return CustomerCenterConfigData$Localization$$serializer.INSTANCE;
            }
        }

        static {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            $childSerializers = new KSerializer[]{null, new LinkedHashMapSerializer(stringSerializer, stringSerializer)};
        }

        @Deprecated
        public /* synthetic */ Localization(int i, String str, Map map, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i & 3)) {
                PluginExceptionsKt.throwMissingFieldException(i, 3, CustomerCenterConfigData$Localization$$serializer.INSTANCE.getDescriptor());
            }
            this.locale = str;
            this.localizedStrings = map;
        }

        public Localization(String locale, Map<String, String> localizedStrings) {
            Intrinsics.checkNotNullParameter(locale, "locale");
            Intrinsics.checkNotNullParameter(localizedStrings, "localizedStrings");
            this.locale = locale;
            this.localizedStrings = localizedStrings;
        }

        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Localization self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer[] kSerializerArr = $childSerializers;
            output.encodeStringElement(serialDesc, 0, self.locale);
            output.encodeSerializableElement(serialDesc, 1, kSerializerArr[1], self.localizedStrings);
        }

        public final String getLocale() {
            return this.locale;
        }

        public final Map<String, String> getLocalizedStrings() {
            return this.localizedStrings;
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization$VariableName;", "", "identifier", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getIdentifier", "()Ljava/lang/String;", "PRICE", "SUB_OFFER_DURATION", "SUB_OFFER_DURATION_2", "SUB_OFFER_PRICE", "SUB_OFFER_PRICE_2", "DISCOUNTED_RECURRING_PAYMENT_PRICE_PER_PERIOD", "DISCOUNTED_RECURRING_PAYMENT_CYCLES", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public enum VariableName {
            PRICE(b.x),
            SUB_OFFER_DURATION("sub_offer_duration"),
            SUB_OFFER_DURATION_2("sub_offer_duration_2"),
            SUB_OFFER_PRICE("sub_offer_price"),
            SUB_OFFER_PRICE_2("sub_offer_price_2"),
            DISCOUNTED_RECURRING_PAYMENT_PRICE_PER_PERIOD("discounted_recurring_payment_price_per_period"),
            DISCOUNTED_RECURRING_PAYMENT_CYCLES("discounted_recurring_payment_cycles");

            private final String identifier;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private static final Lazy valueMap$delegate = LazyKt.lazy(new Function0() { // from class: com.revenuecat.purchases.customercenter.CustomerCenterConfigData$Localization$VariableName$Companion$valueMap$2
                @Override // kotlin.jvm.functions.Function0
                public final Map<String, CustomerCenterConfigData.Localization.VariableName> invoke() {
                    CustomerCenterConfigData.Localization.VariableName[] variableNameArrValues = CustomerCenterConfigData.Localization.VariableName.values();
                    LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(variableNameArrValues.length), 16));
                    for (CustomerCenterConfigData.Localization.VariableName variableName : variableNameArrValues) {
                        linkedHashMap.put(variableName.getIdentifier(), variableName);
                    }
                    return linkedHashMap;
                }
            });

            VariableName(String str) {
                this.identifier = str;
            }

            public final String getIdentifier() {
                return this.identifier;
            }

            @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u0005R'\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization$VariableName$Companion;", "", "()V", "valueMap", "", "", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization$VariableName;", "getValueMap", "()Ljava/util/Map;", "valueMap$delegate", "Lkotlin/Lazy;", "valueOfIdentifier", "identifier", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                private final Map<String, VariableName> getValueMap() {
                    return (Map) VariableName.valueMap$delegate.getValue();
                }

                public final VariableName valueOfIdentifier(String identifier) {
                    Intrinsics.checkNotNullParameter(identifier, "identifier");
                    return getValueMap().get(identifier);
                }
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b[\b\u0087\u0001\u0018\u0000 ^2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001^B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>j\u0002\b?j\u0002\b@j\u0002\bAj\u0002\bBj\u0002\bCj\u0002\bDj\u0002\bEj\u0002\bFj\u0002\bGj\u0002\bHj\u0002\bIj\u0002\bJj\u0002\bKj\u0002\bLj\u0002\bMj\u0002\bNj\u0002\bOj\u0002\bPj\u0002\bQj\u0002\bRj\u0002\bSj\u0002\bTj\u0002\bUj\u0002\bVj\u0002\bWj\u0002\bXj\u0002\bYj\u0002\bZj\u0002\b[j\u0002\b\\j\u0002\b]¨\u0006_"}, d2 = {"Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization$CommonLocalizedString;", "", "(Ljava/lang/String;I)V", "defaultValue", "", "getDefaultValue", "()Ljava/lang/String;", "NO_THANKS", "NO_SUBSCRIPTIONS_FOUND", "TRY_CHECK_RESTORE", "RESTORE_PURCHASES", "CANCEL", "BILLING_CYCLE", "CURRENT_PRICE", "EXPIRED", "EXPIRES", "NEXT_BILLING_DATE", "REFUND_CANCELED", "REFUND_ERROR_GENERIC", "REFUND_GRANTED", "REFUND_STATUS", "SUB_EARLIEST_EXPIRATION", "SUB_EARLIEST_RENEWAL", "SUB_EXPIRED", "CONTACT_SUPPORT", "DEFAULT_BODY", "DEFAULT_SUBJECT", "DISMISS", "UPDATE_WARNING_TITLE", "UPDATE_WARNING_DESCRIPTION", "UPDATE_WARNING_UPDATE", "UPDATE_WARNING_IGNORE", "PLEASE_CONTACT_SUPPORT", "APPLE_SUBSCRIPTION_MANAGE", "GOOGLE_SUBSCRIPTION_MANAGE", "AMAZON_SUBSCRIPTION_MANAGE", "PLATFORM_MISMATCH", "GOING_TO_CHECK_PURCHASES", "CHECK_PAST_PURCHASES", "PURCHASES_RECOVERED", "PURCHASES_RECOVERED_EXPLANATION", "PURCHASES_NOT_RECOVERED", "PURCHASES_NOT_FOUND", "PURCHASES_RESTORING", "MANAGE_SUBSCRIPTION", "YOU_HAVE_PROMO", "YOU_HAVE_LIFETIME", "WEB_SUBSCRIPTION_MANAGE", "FREE", "NEVER", "FREE_TRIAL_THEN_PRICE", "SINGLE_PAYMENT_THEN_PRICE", "DISCOUNTED_RECURRING_THEN_PRICE", "FREE_TRIAL_SINGLE_PAYMENT_THEN_PRICE", "FREE_TRIAL_DISCOUNTED_THEN_PRICE", "DISCOUNTED_RECURRING_PAYMENT_THEN_PRICE", "FREE_TRIAL_DISCOUNTED_RECURRING_PAYMENT_THEN_PRICE", "DONE", "RENEWS_ON_DATE_FOR_PRICE", "RENEWS_ON_DATE", "PURCHASE_INFO_EXPIRED_ON_DATE", "PURCHASE_INFO_EXPIRES_ON_DATE", "ACTIVE", "BADGE_CANCELLED", "BADGE_FREE_TRIAL", "BADGE_FREE_TRIAL_CANCELLED", "BADGE_LIFETIME", "APP_STORE", "MAC_APP_STORE", "GOOGLE_PLAY_STORE", "AMAZON_STORE", "GALAXY_STORE", "WEB_STORE", "UNKNOWN_STORE", "TEST_STORE", "CARD_STORE_PROMOTIONAL", "RESUBSCRIBE", "TYPE_SUBSCRIPTION", "TYPE_ONE_TIME_PURCHASE", "BUY_SUBSCRIPTION", "LAST_CHARGE_WAS", "NEXT_BILLING_DATE_ON", "SEE_ALL_VIRTUAL_CURRENCIES", "VIRTUAL_CURRENCY_BALANCES_SCREEN_HEADER", "NO_VIRTUAL_CURRENCY_BALANCES_FOUND", "SUPPORT_TICKET_CREATE", "EMAIL", "ENTER_EMAIL", "DESCRIPTION", "SENT", "SUPPORT_TICKET_FAILED", "SUBMIT_TICKET", "INVALID_EMAIL_ERROR", "CHARACTERS_REMAINING", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public enum CommonLocalizedString {
            NO_THANKS,
            NO_SUBSCRIPTIONS_FOUND,
            TRY_CHECK_RESTORE,
            RESTORE_PURCHASES,
            CANCEL,
            BILLING_CYCLE,
            CURRENT_PRICE,
            EXPIRED,
            EXPIRES,
            NEXT_BILLING_DATE,
            REFUND_CANCELED,
            REFUND_ERROR_GENERIC,
            REFUND_GRANTED,
            REFUND_STATUS,
            SUB_EARLIEST_EXPIRATION,
            SUB_EARLIEST_RENEWAL,
            SUB_EXPIRED,
            CONTACT_SUPPORT,
            DEFAULT_BODY,
            DEFAULT_SUBJECT,
            DISMISS,
            UPDATE_WARNING_TITLE,
            UPDATE_WARNING_DESCRIPTION,
            UPDATE_WARNING_UPDATE,
            UPDATE_WARNING_IGNORE,
            PLEASE_CONTACT_SUPPORT,
            APPLE_SUBSCRIPTION_MANAGE,
            GOOGLE_SUBSCRIPTION_MANAGE,
            AMAZON_SUBSCRIPTION_MANAGE,
            PLATFORM_MISMATCH,
            GOING_TO_CHECK_PURCHASES,
            CHECK_PAST_PURCHASES,
            PURCHASES_RECOVERED,
            PURCHASES_RECOVERED_EXPLANATION,
            PURCHASES_NOT_RECOVERED,
            PURCHASES_NOT_FOUND,
            PURCHASES_RESTORING,
            MANAGE_SUBSCRIPTION,
            YOU_HAVE_PROMO,
            YOU_HAVE_LIFETIME,
            WEB_SUBSCRIPTION_MANAGE,
            FREE,
            NEVER,
            FREE_TRIAL_THEN_PRICE,
            SINGLE_PAYMENT_THEN_PRICE,
            DISCOUNTED_RECURRING_THEN_PRICE,
            FREE_TRIAL_SINGLE_PAYMENT_THEN_PRICE,
            FREE_TRIAL_DISCOUNTED_THEN_PRICE,
            DISCOUNTED_RECURRING_PAYMENT_THEN_PRICE,
            FREE_TRIAL_DISCOUNTED_RECURRING_PAYMENT_THEN_PRICE,
            DONE,
            RENEWS_ON_DATE_FOR_PRICE,
            RENEWS_ON_DATE,
            PURCHASE_INFO_EXPIRED_ON_DATE,
            PURCHASE_INFO_EXPIRES_ON_DATE,
            ACTIVE,
            BADGE_CANCELLED,
            BADGE_FREE_TRIAL,
            BADGE_FREE_TRIAL_CANCELLED,
            BADGE_LIFETIME,
            APP_STORE,
            MAC_APP_STORE,
            GOOGLE_PLAY_STORE,
            AMAZON_STORE,
            GALAXY_STORE,
            WEB_STORE,
            UNKNOWN_STORE,
            TEST_STORE,
            CARD_STORE_PROMOTIONAL,
            RESUBSCRIBE,
            TYPE_SUBSCRIPTION,
            TYPE_ONE_TIME_PURCHASE,
            BUY_SUBSCRIPTION,
            LAST_CHARGE_WAS,
            NEXT_BILLING_DATE_ON,
            SEE_ALL_VIRTUAL_CURRENCIES,
            VIRTUAL_CURRENCY_BALANCES_SCREEN_HEADER,
            NO_VIRTUAL_CURRENCY_BALANCES_FOUND,
            SUPPORT_TICKET_CREATE,
            EMAIL,
            ENTER_EMAIL,
            DESCRIPTION,
            SENT,
            SUPPORT_TICKET_FAILED,
            SUBMIT_TICKET,
            INVALID_EMAIL_ERROR,
            CHARACTERS_REMAINING;


            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private static final Lazy $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Localization.CommonLocalizedString.Companion.1
                @Override // kotlin.jvm.functions.Function0
                public final KSerializer invoke() {
                    return EnumsKt.createAnnotatedEnumSerializer("com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Localization.CommonLocalizedString", CommonLocalizedString.values(), new String[]{"no_thanks", "no_subscriptions_found", "try_check_restore", PaywallLegacyComponentInteraction.Value.RESTORE_PURCHASES, "cancel", "billing_cycle", "current_price", "expired", "expires", "next_billing_date", "refund_canceled", "refund_error_generic", "refund_granted", "refund_status", "sub_earliest_expiration", "sub_earliest_renewal", "sub_expired", "contact_support", "default_body", "default_subject", "dismiss", "update_warning_title", "update_warning_description", "update_warning_update", "update_warning_ignore", "please_contact_support", "apple_subscription_manage", "google_subscription_manage", "amazon_subscription_manage", "platform_mismatch", "going_to_check_purchases", "check_past_purchases", "purchases_recovered", "purchases_recovered_explanation", "purchases_not_recovered", "purchases_not_found", "purchases_restoring", "manage_subscription", "you_have_promo", "you_have_lifetime", "web_subscription_manage", "free", "never", "free_trial_then_price", "single_payment_then_price", "discounted_recurring_then_price", "free_trial_single_payment_then_price", "free_trial_discounted_then_price", "discounted_recurring_payment_then_price", "free_trial_discounted_recurring_payment_then_price", "done", "renews_on_date_for_price", "renews_on_date", "purchase_info_expired_on_date", "purchase_info_expires_on_date", AppStateModule.APP_STATE_ACTIVE, "badge_cancelled", "badge_free_trial", "badge_free_trial_cancelled", "badge_lifetime", "app_store", "mac_app_store", "google_play_store", "amazon_store", "galaxy_store", "web_store", "unknown_store", "test_store", "card_store_promotional", "resubscribe", "type_subscription", "type_one_time_purchase", "buy_subscription", "last_charge_was", "next_billing_date_on", "see_all_virtual_currencies", "virtual_currency_balances_screen_header", "no_virtual_currency_balances_found", "support_ticket_create", AuthorizationRequest.Scope.EMAIL, "enter_email", b.c, "sent", "support_ticket_failed", "submit_ticket", "invalid_email_error", "characters_remaining"}, new Annotation[][]{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}, null);
                }
            });

            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[CommonLocalizedString.values().length];
                    try {
                        iArr[CommonLocalizedString.NO_THANKS.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[CommonLocalizedString.NO_SUBSCRIPTIONS_FOUND.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[CommonLocalizedString.TRY_CHECK_RESTORE.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[CommonLocalizedString.RESTORE_PURCHASES.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[CommonLocalizedString.CANCEL.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    try {
                        iArr[CommonLocalizedString.BILLING_CYCLE.ordinal()] = 6;
                    } catch (NoSuchFieldError unused6) {
                    }
                    try {
                        iArr[CommonLocalizedString.CURRENT_PRICE.ordinal()] = 7;
                    } catch (NoSuchFieldError unused7) {
                    }
                    try {
                        iArr[CommonLocalizedString.EXPIRED.ordinal()] = 8;
                    } catch (NoSuchFieldError unused8) {
                    }
                    try {
                        iArr[CommonLocalizedString.EXPIRES.ordinal()] = 9;
                    } catch (NoSuchFieldError unused9) {
                    }
                    try {
                        iArr[CommonLocalizedString.NEXT_BILLING_DATE.ordinal()] = 10;
                    } catch (NoSuchFieldError unused10) {
                    }
                    try {
                        iArr[CommonLocalizedString.REFUND_CANCELED.ordinal()] = 11;
                    } catch (NoSuchFieldError unused11) {
                    }
                    try {
                        iArr[CommonLocalizedString.REFUND_ERROR_GENERIC.ordinal()] = 12;
                    } catch (NoSuchFieldError unused12) {
                    }
                    try {
                        iArr[CommonLocalizedString.REFUND_GRANTED.ordinal()] = 13;
                    } catch (NoSuchFieldError unused13) {
                    }
                    try {
                        iArr[CommonLocalizedString.REFUND_STATUS.ordinal()] = 14;
                    } catch (NoSuchFieldError unused14) {
                    }
                    try {
                        iArr[CommonLocalizedString.SUB_EARLIEST_EXPIRATION.ordinal()] = 15;
                    } catch (NoSuchFieldError unused15) {
                    }
                    try {
                        iArr[CommonLocalizedString.SUB_EARLIEST_RENEWAL.ordinal()] = 16;
                    } catch (NoSuchFieldError unused16) {
                    }
                    try {
                        iArr[CommonLocalizedString.SUB_EXPIRED.ordinal()] = 17;
                    } catch (NoSuchFieldError unused17) {
                    }
                    try {
                        iArr[CommonLocalizedString.CONTACT_SUPPORT.ordinal()] = 18;
                    } catch (NoSuchFieldError unused18) {
                    }
                    try {
                        iArr[CommonLocalizedString.DEFAULT_BODY.ordinal()] = 19;
                    } catch (NoSuchFieldError unused19) {
                    }
                    try {
                        iArr[CommonLocalizedString.DEFAULT_SUBJECT.ordinal()] = 20;
                    } catch (NoSuchFieldError unused20) {
                    }
                    try {
                        iArr[CommonLocalizedString.DISMISS.ordinal()] = 21;
                    } catch (NoSuchFieldError unused21) {
                    }
                    try {
                        iArr[CommonLocalizedString.UPDATE_WARNING_TITLE.ordinal()] = 22;
                    } catch (NoSuchFieldError unused22) {
                    }
                    try {
                        iArr[CommonLocalizedString.UPDATE_WARNING_DESCRIPTION.ordinal()] = 23;
                    } catch (NoSuchFieldError unused23) {
                    }
                    try {
                        iArr[CommonLocalizedString.UPDATE_WARNING_UPDATE.ordinal()] = 24;
                    } catch (NoSuchFieldError unused24) {
                    }
                    try {
                        iArr[CommonLocalizedString.UPDATE_WARNING_IGNORE.ordinal()] = 25;
                    } catch (NoSuchFieldError unused25) {
                    }
                    try {
                        iArr[CommonLocalizedString.PLATFORM_MISMATCH.ordinal()] = 26;
                    } catch (NoSuchFieldError unused26) {
                    }
                    try {
                        iArr[CommonLocalizedString.PLEASE_CONTACT_SUPPORT.ordinal()] = 27;
                    } catch (NoSuchFieldError unused27) {
                    }
                    try {
                        iArr[CommonLocalizedString.APPLE_SUBSCRIPTION_MANAGE.ordinal()] = 28;
                    } catch (NoSuchFieldError unused28) {
                    }
                    try {
                        iArr[CommonLocalizedString.GOOGLE_SUBSCRIPTION_MANAGE.ordinal()] = 29;
                    } catch (NoSuchFieldError unused29) {
                    }
                    try {
                        iArr[CommonLocalizedString.AMAZON_SUBSCRIPTION_MANAGE.ordinal()] = 30;
                    } catch (NoSuchFieldError unused30) {
                    }
                    try {
                        iArr[CommonLocalizedString.GOING_TO_CHECK_PURCHASES.ordinal()] = 31;
                    } catch (NoSuchFieldError unused31) {
                    }
                    try {
                        iArr[CommonLocalizedString.CHECK_PAST_PURCHASES.ordinal()] = 32;
                    } catch (NoSuchFieldError unused32) {
                    }
                    try {
                        iArr[CommonLocalizedString.PURCHASES_RECOVERED.ordinal()] = 33;
                    } catch (NoSuchFieldError unused33) {
                    }
                    try {
                        iArr[CommonLocalizedString.PURCHASES_RECOVERED_EXPLANATION.ordinal()] = 34;
                    } catch (NoSuchFieldError unused34) {
                    }
                    try {
                        iArr[CommonLocalizedString.PURCHASES_NOT_RECOVERED.ordinal()] = 35;
                    } catch (NoSuchFieldError unused35) {
                    }
                    try {
                        iArr[CommonLocalizedString.PURCHASES_NOT_FOUND.ordinal()] = 36;
                    } catch (NoSuchFieldError unused36) {
                    }
                    try {
                        iArr[CommonLocalizedString.PURCHASES_RESTORING.ordinal()] = 37;
                    } catch (NoSuchFieldError unused37) {
                    }
                    try {
                        iArr[CommonLocalizedString.MANAGE_SUBSCRIPTION.ordinal()] = 38;
                    } catch (NoSuchFieldError unused38) {
                    }
                    try {
                        iArr[CommonLocalizedString.YOU_HAVE_PROMO.ordinal()] = 39;
                    } catch (NoSuchFieldError unused39) {
                    }
                    try {
                        iArr[CommonLocalizedString.YOU_HAVE_LIFETIME.ordinal()] = 40;
                    } catch (NoSuchFieldError unused40) {
                    }
                    try {
                        iArr[CommonLocalizedString.WEB_SUBSCRIPTION_MANAGE.ordinal()] = 41;
                    } catch (NoSuchFieldError unused41) {
                    }
                    try {
                        iArr[CommonLocalizedString.FREE.ordinal()] = 42;
                    } catch (NoSuchFieldError unused42) {
                    }
                    try {
                        iArr[CommonLocalizedString.NEVER.ordinal()] = 43;
                    } catch (NoSuchFieldError unused43) {
                    }
                    try {
                        iArr[CommonLocalizedString.FREE_TRIAL_THEN_PRICE.ordinal()] = 44;
                    } catch (NoSuchFieldError unused44) {
                    }
                    try {
                        iArr[CommonLocalizedString.SINGLE_PAYMENT_THEN_PRICE.ordinal()] = 45;
                    } catch (NoSuchFieldError unused45) {
                    }
                    try {
                        iArr[CommonLocalizedString.DISCOUNTED_RECURRING_THEN_PRICE.ordinal()] = 46;
                    } catch (NoSuchFieldError unused46) {
                    }
                    try {
                        iArr[CommonLocalizedString.FREE_TRIAL_SINGLE_PAYMENT_THEN_PRICE.ordinal()] = 47;
                    } catch (NoSuchFieldError unused47) {
                    }
                    try {
                        iArr[CommonLocalizedString.FREE_TRIAL_DISCOUNTED_THEN_PRICE.ordinal()] = 48;
                    } catch (NoSuchFieldError unused48) {
                    }
                    try {
                        iArr[CommonLocalizedString.DISCOUNTED_RECURRING_PAYMENT_THEN_PRICE.ordinal()] = 49;
                    } catch (NoSuchFieldError unused49) {
                    }
                    try {
                        iArr[CommonLocalizedString.FREE_TRIAL_DISCOUNTED_RECURRING_PAYMENT_THEN_PRICE.ordinal()] = 50;
                    } catch (NoSuchFieldError unused50) {
                    }
                    try {
                        iArr[CommonLocalizedString.DONE.ordinal()] = 51;
                    } catch (NoSuchFieldError unused51) {
                    }
                    try {
                        iArr[CommonLocalizedString.RENEWS_ON_DATE_FOR_PRICE.ordinal()] = 52;
                    } catch (NoSuchFieldError unused52) {
                    }
                    try {
                        iArr[CommonLocalizedString.RENEWS_ON_DATE.ordinal()] = 53;
                    } catch (NoSuchFieldError unused53) {
                    }
                    try {
                        iArr[CommonLocalizedString.PURCHASE_INFO_EXPIRED_ON_DATE.ordinal()] = 54;
                    } catch (NoSuchFieldError unused54) {
                    }
                    try {
                        iArr[CommonLocalizedString.PURCHASE_INFO_EXPIRES_ON_DATE.ordinal()] = 55;
                    } catch (NoSuchFieldError unused55) {
                    }
                    try {
                        iArr[CommonLocalizedString.ACTIVE.ordinal()] = 56;
                    } catch (NoSuchFieldError unused56) {
                    }
                    try {
                        iArr[CommonLocalizedString.BADGE_CANCELLED.ordinal()] = 57;
                    } catch (NoSuchFieldError unused57) {
                    }
                    try {
                        iArr[CommonLocalizedString.BADGE_FREE_TRIAL.ordinal()] = 58;
                    } catch (NoSuchFieldError unused58) {
                    }
                    try {
                        iArr[CommonLocalizedString.BADGE_FREE_TRIAL_CANCELLED.ordinal()] = 59;
                    } catch (NoSuchFieldError unused59) {
                    }
                    try {
                        iArr[CommonLocalizedString.BADGE_LIFETIME.ordinal()] = 60;
                    } catch (NoSuchFieldError unused60) {
                    }
                    try {
                        iArr[CommonLocalizedString.APP_STORE.ordinal()] = 61;
                    } catch (NoSuchFieldError unused61) {
                    }
                    try {
                        iArr[CommonLocalizedString.MAC_APP_STORE.ordinal()] = 62;
                    } catch (NoSuchFieldError unused62) {
                    }
                    try {
                        iArr[CommonLocalizedString.GOOGLE_PLAY_STORE.ordinal()] = 63;
                    } catch (NoSuchFieldError unused63) {
                    }
                    try {
                        iArr[CommonLocalizedString.AMAZON_STORE.ordinal()] = 64;
                    } catch (NoSuchFieldError unused64) {
                    }
                    try {
                        iArr[CommonLocalizedString.GALAXY_STORE.ordinal()] = 65;
                    } catch (NoSuchFieldError unused65) {
                    }
                    try {
                        iArr[CommonLocalizedString.WEB_STORE.ordinal()] = 66;
                    } catch (NoSuchFieldError unused66) {
                    }
                    try {
                        iArr[CommonLocalizedString.UNKNOWN_STORE.ordinal()] = 67;
                    } catch (NoSuchFieldError unused67) {
                    }
                    try {
                        iArr[CommonLocalizedString.TEST_STORE.ordinal()] = 68;
                    } catch (NoSuchFieldError unused68) {
                    }
                    try {
                        iArr[CommonLocalizedString.CARD_STORE_PROMOTIONAL.ordinal()] = 69;
                    } catch (NoSuchFieldError unused69) {
                    }
                    try {
                        iArr[CommonLocalizedString.RESUBSCRIBE.ordinal()] = 70;
                    } catch (NoSuchFieldError unused70) {
                    }
                    try {
                        iArr[CommonLocalizedString.TYPE_SUBSCRIPTION.ordinal()] = 71;
                    } catch (NoSuchFieldError unused71) {
                    }
                    try {
                        iArr[CommonLocalizedString.TYPE_ONE_TIME_PURCHASE.ordinal()] = 72;
                    } catch (NoSuchFieldError unused72) {
                    }
                    try {
                        iArr[CommonLocalizedString.BUY_SUBSCRIPTION.ordinal()] = 73;
                    } catch (NoSuchFieldError unused73) {
                    }
                    try {
                        iArr[CommonLocalizedString.LAST_CHARGE_WAS.ordinal()] = 74;
                    } catch (NoSuchFieldError unused74) {
                    }
                    try {
                        iArr[CommonLocalizedString.NEXT_BILLING_DATE_ON.ordinal()] = 75;
                    } catch (NoSuchFieldError unused75) {
                    }
                    try {
                        iArr[CommonLocalizedString.SEE_ALL_VIRTUAL_CURRENCIES.ordinal()] = 76;
                    } catch (NoSuchFieldError unused76) {
                    }
                    try {
                        iArr[CommonLocalizedString.VIRTUAL_CURRENCY_BALANCES_SCREEN_HEADER.ordinal()] = 77;
                    } catch (NoSuchFieldError unused77) {
                    }
                    try {
                        iArr[CommonLocalizedString.NO_VIRTUAL_CURRENCY_BALANCES_FOUND.ordinal()] = 78;
                    } catch (NoSuchFieldError unused78) {
                    }
                    try {
                        iArr[CommonLocalizedString.SUPPORT_TICKET_CREATE.ordinal()] = 79;
                    } catch (NoSuchFieldError unused79) {
                    }
                    try {
                        iArr[CommonLocalizedString.EMAIL.ordinal()] = 80;
                    } catch (NoSuchFieldError unused80) {
                    }
                    try {
                        iArr[CommonLocalizedString.ENTER_EMAIL.ordinal()] = 81;
                    } catch (NoSuchFieldError unused81) {
                    }
                    try {
                        iArr[CommonLocalizedString.DESCRIPTION.ordinal()] = 82;
                    } catch (NoSuchFieldError unused82) {
                    }
                    try {
                        iArr[CommonLocalizedString.SENT.ordinal()] = 83;
                    } catch (NoSuchFieldError unused83) {
                    }
                    try {
                        iArr[CommonLocalizedString.SUPPORT_TICKET_FAILED.ordinal()] = 84;
                    } catch (NoSuchFieldError unused84) {
                    }
                    try {
                        iArr[CommonLocalizedString.SUBMIT_TICKET.ordinal()] = 85;
                    } catch (NoSuchFieldError unused85) {
                    }
                    try {
                        iArr[CommonLocalizedString.INVALID_EMAIL_ERROR.ordinal()] = 86;
                    } catch (NoSuchFieldError unused86) {
                    }
                    try {
                        iArr[CommonLocalizedString.CHARACTERS_REMAINING.ordinal()] = 87;
                    } catch (NoSuchFieldError unused87) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization$CommonLocalizedString$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization$CommonLocalizedString;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                private final /* synthetic */ KSerializer get$cachedSerializer() {
                    return (KSerializer) CommonLocalizedString.$cachedSerializer$delegate.getValue();
                }

                public final KSerializer serializer() {
                    return get$cachedSerializer();
                }
            }

            public final String getDefaultValue() {
                switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
                    case 1:
                        return "No, thanks";
                    case 2:
                        return "No Subscriptions found";
                    case 3:
                        return "We can try checking your Apple account for any previous purchases";
                    case 4:
                        return "Restore purchases";
                    case 5:
                        return "Cancel";
                    case 6:
                        return "Billing cycle";
                    case 7:
                        return "Current price";
                    case 8:
                        return "Expired";
                    case 9:
                        return "Expires";
                    case 10:
                        return "Next billing date";
                    case BaseVideoCapturer.RGBA /* 11 */:
                        return "Refund canceled";
                    case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                        return "An error occurred while processing the refund request. Please try again.";
                    case 13:
                        return "Refund granted successfully!";
                    case 14:
                        return "Refund status";
                    case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                        return "This is your subscription with the earliest expiration date.";
                    case 16:
                        return "This is your subscription with the earliest billing date.";
                    case 17:
                        return "This subscription has expired.";
                    case 18:
                        return "Contact support";
                    case 19:
                        return "Please describe your issue or question.";
                    case 20:
                        return "Support Request";
                    case 21:
                        return "Dismiss";
                    case 22:
                        return "Update available";
                    case 23:
                        return "Downloading the latest version of the app may help solve the problem.";
                    case ColorExtractionConstants.ALPHA_CHANNEL_SHIFT /* 24 */:
                        return "Update";
                    case BluetoothManager.SCO_CONNECTION_ATTEMPT_DELAY /* 25 */:
                        return "Continue";
                    case 26:
                        return "Platform mismatch";
                    case 27:
                        return "Please contact support to manage your subscription.";
                    case 28:
                        return "You can manage your subscription by using the App Store app on an Apple device.";
                    case 29:
                        return "You have an active subscription from the Google Play Store";
                    case 30:
                        return "You have an active subscription from the Amazon Appstore. You can manage your subscription in the Amazon Appstore app.";
                    case BackgroundUIConstants.minSDKVersionSupportingBlur /* 31 */:
                        return "Let's take a look! We're going to check your account for missing purchases.";
                    case 32:
                        return "Check past purchases";
                    case 33:
                        return "Purchases restored";
                    case 34:
                        return "We restored your past purchases and applied them to your account.";
                    case 35:
                        return "We could not find any purchases with your account. If you think this is an error, please contact support.";
                    case 36:
                        return "No past purchases";
                    case 37:
                        return "Restoring...";
                    case 38:
                        return "Manage your subscription";
                    case 39:
                        return "You've been granted a subscription that doesn't renew";
                    case 40:
                        return "Your active lifetime subscription";
                    case 41:
                        return "You have an active subscription that was purchased on the web. You can manage your subscription using the button below.";
                    case 42:
                        return "Free";
                    case CodeVerifierUtil.MIN_CODE_VERIFIER_LENGTH /* 43 */:
                        return "Never";
                    case 44:
                        return "First {{ sub_offer_duration }} free, then {{ price }}";
                    case 45:
                        return "{{ sub_offer_duration }} for {{ sub_offer_price }}, then {{ price }}";
                    case 46:
                        return "{{ sub_offer_price }} during {{ sub_offer_duration }}, then {{ price }}";
                    case 47:
                        return "Try {{ sub_offer_duration }} for free, then {{ sub_offer_duration_2 }} for {{ sub_offer_price_2 }}, and {{ price }} thereafter";
                    case 48:
                        return "Try {{ sub_offer_duration }} for free, then {{ sub_offer_price_2 }} during {{ sub_offer_duration_2 }}, and {{ price }} thereafter";
                    case PurchaseParamsValidator.MAX_NUMBER_OF_ADD_ON_PRODUCTS /* 49 */:
                        return "{{ discounted_recurring_payment_price_per_period }} for {{ discounted_recurring_payment_cycles }} periods, then {{ price }}";
                    case 50:
                        return "Try {{ sub_offer_duration }} for free, then {{ discounted_recurring_payment_price_per_period }} for {{ discounted_recurring_payment_cycles }} periods, and {{ price }} thereafter";
                    case 51:
                        return "Done";
                    case 52:
                        return "Your next charge is {{ price }} on {{ date }}.";
                    case 53:
                        return "Renews on {{ date }}";
                    case 54:
                        return "Expired on {{ date }}";
                    case 55:
                        return "Expires on {{ date }}";
                    case 56:
                        return "Active";
                    case 57:
                        return "Cancelled";
                    case 58:
                        return "Free Trial";
                    case 59:
                        return "Cancelled Trial";
                    case 60:
                        return "Lifetime";
                    case 61:
                        return "App Store";
                    case 62:
                        return "Mac App Store";
                    case 63:
                        return "Google Play Store";
                    case 64:
                        return "Amazon Store";
                    case 65:
                        return "Galaxy Store";
                    case 66:
                        return "Web";
                    case 67:
                        return "Unknown";
                    case 68:
                        return "Test Store";
                    case 69:
                        return "Via Support";
                    case 70:
                        return "Resubscribe";
                    case 71:
                        return "Subscription";
                    case 72:
                        return "One time purchase";
                    case 73:
                        return "Buy Subscription";
                    case 74:
                        return "Last charge: {{ price }}";
                    case 75:
                        return "Next billing date: {{ date }}";
                    case 76:
                        return "See all in-app currencies";
                    case 77:
                        return "In-App Currencies";
                    case 78:
                        return "It doesn't look like you've purchased any in-app currencies.";
                    case 79:
                        return "Create a support ticket";
                    case EventsFileHelper.MAX_EVENT_PROPERTY_SIZE /* 80 */:
                        return "Email";
                    case 81:
                        return "Enter your email";
                    case 82:
                        return "Description";
                    case 83:
                        return "Message sent";
                    case 84:
                        return "Failed to send, please try again.";
                    case 85:
                        return "Submit ticket";
                    case 86:
                        return "Please enter a valid email address";
                    case 87:
                        return "{{ count }} characters";
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            }
        }

        public final String commonLocalizedString(CommonLocalizedString key) {
            Intrinsics.checkNotNullParameter(key, "key");
            Map<String, String> map = this.localizedStrings;
            String lowerCase = key.name().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            String str = map.get(lowerCase);
            return str == null ? key.getDefaultValue() : str;
        }
    }

    public final String getLastPublishedAppVersion() {
        return this.lastPublishedAppVersion;
    }

    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u0000 >2\u00020\u0001:\u0005=>?@ABq\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013BY\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0014J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\bHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jc\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\u0003HÖ\u0001J\t\u00104\u001a\u00020\u0005HÖ\u0001J&\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00002\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;HÁ\u0001¢\u0006\u0002\b<R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0016\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0016\u001a\u0004\b!\u0010\"R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0018¨\u0006B"}, d2 = {"Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath;", "", "seen1", "", DiagnosticsEntry.ID_KEY, "", b.S, "type", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathType;", "promotionalOffer", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer;", "feedbackSurvey", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey;", "url", "openMethod", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$OpenMethod;", "actionIdentifier", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathType;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey;Ljava/lang/String;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$OpenMethod;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathType;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey;Ljava/lang/String;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$OpenMethod;Ljava/lang/String;)V", "getActionIdentifier$annotations", "()V", "getActionIdentifier", "()Ljava/lang/String;", "getFeedbackSurvey$annotations", "getFeedbackSurvey", "()Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey;", "getId", "getOpenMethod$annotations", "getOpenMethod", "()Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$OpenMethod;", "getPromotionalOffer$annotations", "getPromotionalOffer", "()Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer;", "getTitle", "getType", "()Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathType;", "getUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "OpenMethod", "PathDetail", "PathType", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class HelpPath {
        private final String actionIdentifier;
        private final PathDetail.FeedbackSurvey feedbackSurvey;
        private final String id;
        private final OpenMethod openMethod;
        private final PathDetail.PromotionalOffer promotionalOffer;
        private final String title;
        private final PathType type;
        private final String url;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer[] $childSerializers = {null, null, PathType.INSTANCE.serializer(), null, null, null, OpenMethod.INSTANCE.serializer(), null};

        public static /* synthetic */ HelpPath copy$default(HelpPath helpPath, String str, String str2, PathType pathType, PathDetail.PromotionalOffer promotionalOffer, PathDetail.FeedbackSurvey feedbackSurvey, String str3, OpenMethod openMethod, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = helpPath.id;
            }
            if ((i & 2) != 0) {
                str2 = helpPath.title;
            }
            if ((i & 4) != 0) {
                pathType = helpPath.type;
            }
            if ((i & 8) != 0) {
                promotionalOffer = helpPath.promotionalOffer;
            }
            if ((i & 16) != 0) {
                feedbackSurvey = helpPath.feedbackSurvey;
            }
            if ((i & 32) != 0) {
                str3 = helpPath.url;
            }
            if ((i & 64) != 0) {
                openMethod = helpPath.openMethod;
            }
            if ((i & 128) != 0) {
                str4 = helpPath.actionIdentifier;
            }
            OpenMethod openMethod2 = openMethod;
            String str5 = str4;
            PathDetail.FeedbackSurvey feedbackSurvey2 = feedbackSurvey;
            String str6 = str3;
            return helpPath.copy(str, str2, pathType, promotionalOffer, feedbackSurvey2, str6, openMethod2, str5);
        }

        public static /* synthetic */ void getActionIdentifier$annotations() {
        }

        public static /* synthetic */ void getFeedbackSurvey$annotations() {
        }

        public static /* synthetic */ void getOpenMethod$annotations() {
        }

        public static /* synthetic */ void getPromotionalOffer$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final PathType getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final PathDetail.PromotionalOffer getPromotionalOffer() {
            return this.promotionalOffer;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final PathDetail.FeedbackSurvey getFeedbackSurvey() {
            return this.feedbackSurvey;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final OpenMethod getOpenMethod() {
            return this.openMethod;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getActionIdentifier() {
            return this.actionIdentifier;
        }

        public final HelpPath copy(String id, String title, PathType type, PathDetail.PromotionalOffer promotionalOffer, PathDetail.FeedbackSurvey feedbackSurvey, String url, OpenMethod openMethod, String actionIdentifier) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(type, "type");
            return new HelpPath(id, title, type, promotionalOffer, feedbackSurvey, url, openMethod, actionIdentifier);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof HelpPath)) {
                return false;
            }
            HelpPath helpPath = (HelpPath) other;
            return Intrinsics.areEqual(this.id, helpPath.id) && Intrinsics.areEqual(this.title, helpPath.title) && this.type == helpPath.type && Intrinsics.areEqual(this.promotionalOffer, helpPath.promotionalOffer) && Intrinsics.areEqual(this.feedbackSurvey, helpPath.feedbackSurvey) && Intrinsics.areEqual(this.url, helpPath.url) && this.openMethod == helpPath.openMethod && Intrinsics.areEqual(this.actionIdentifier, helpPath.actionIdentifier);
        }

        public int hashCode() {
            int iHashCode = ((((this.id.hashCode() * 31) + this.title.hashCode()) * 31) + this.type.hashCode()) * 31;
            PathDetail.PromotionalOffer promotionalOffer = this.promotionalOffer;
            int iHashCode2 = (iHashCode + (promotionalOffer == null ? 0 : promotionalOffer.hashCode())) * 31;
            PathDetail.FeedbackSurvey feedbackSurvey = this.feedbackSurvey;
            int iHashCode3 = (iHashCode2 + (feedbackSurvey == null ? 0 : feedbackSurvey.hashCode())) * 31;
            String str = this.url;
            int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
            OpenMethod openMethod = this.openMethod;
            int iHashCode5 = (iHashCode4 + (openMethod == null ? 0 : openMethod.hashCode())) * 31;
            String str2 = this.actionIdentifier;
            return iHashCode5 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "HelpPath(id=" + this.id + ", title=" + this.title + ", type=" + this.type + ", promotionalOffer=" + this.promotionalOffer + ", feedbackSurvey=" + this.feedbackSurvey + ", url=" + this.url + ", openMethod=" + this.openMethod + ", actionIdentifier=" + this.actionIdentifier + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer serializer() {
                return CustomerCenterConfigData$HelpPath$$serializer.INSTANCE;
            }
        }

        @Deprecated
        public /* synthetic */ HelpPath(int i, String str, String str2, PathType pathType, PathDetail.PromotionalOffer promotionalOffer, PathDetail.FeedbackSurvey feedbackSurvey, String str3, OpenMethod openMethod, String str4, SerializationConstructorMarker serializationConstructorMarker) {
            if (7 != (i & 7)) {
                PluginExceptionsKt.throwMissingFieldException(i, 7, CustomerCenterConfigData$HelpPath$$serializer.INSTANCE.getDescriptor());
            }
            this.id = str;
            this.title = str2;
            this.type = pathType;
            if ((i & 8) == 0) {
                this.promotionalOffer = null;
            } else {
                this.promotionalOffer = promotionalOffer;
            }
            if ((i & 16) == 0) {
                this.feedbackSurvey = null;
            } else {
                this.feedbackSurvey = feedbackSurvey;
            }
            if ((i & 32) == 0) {
                this.url = null;
            } else {
                this.url = str3;
            }
            if ((i & 64) == 0) {
                this.openMethod = null;
            } else {
                this.openMethod = openMethod;
            }
            if ((i & 128) == 0) {
                this.actionIdentifier = null;
            } else {
                this.actionIdentifier = str4;
            }
        }

        public HelpPath(String id, String title, PathType type, PathDetail.PromotionalOffer promotionalOffer, PathDetail.FeedbackSurvey feedbackSurvey, String str, OpenMethod openMethod, String str2) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(type, "type");
            this.id = id;
            this.title = title;
            this.type = type;
            this.promotionalOffer = promotionalOffer;
            this.feedbackSurvey = feedbackSurvey;
            this.url = str;
            this.openMethod = openMethod;
            this.actionIdentifier = str2;
        }

        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(HelpPath self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer[] kSerializerArr = $childSerializers;
            output.encodeStringElement(serialDesc, 0, self.id);
            output.encodeStringElement(serialDesc, 1, self.title);
            output.encodeSerializableElement(serialDesc, 2, kSerializerArr[2], self.type);
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.promotionalOffer != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer.INSTANCE, self.promotionalOffer);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.feedbackSurvey != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$$serializer.INSTANCE, self.feedbackSurvey);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.url != null) {
                output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.url);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.openMethod != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, kSerializerArr[6], self.openMethod);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 7) && self.actionIdentifier == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.actionIdentifier);
        }

        public /* synthetic */ HelpPath(String str, String str2, PathType pathType, PathDetail.PromotionalOffer promotionalOffer, PathDetail.FeedbackSurvey feedbackSurvey, String str3, OpenMethod openMethod, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, pathType, (i & 8) != 0 ? null : promotionalOffer, (i & 16) != 0 ? null : feedbackSurvey, (i & 32) != 0 ? null : str3, (i & 64) != 0 ? null : openMethod, (i & 128) != 0 ? null : str4);
        }

        public final String getId() {
            return this.id;
        }

        public final String getTitle() {
            return this.title;
        }

        public final PathType getType() {
            return this.type;
        }

        public final PathDetail.PromotionalOffer getPromotionalOffer() {
            return this.promotionalOffer;
        }

        public final PathDetail.FeedbackSurvey getFeedbackSurvey() {
            return this.feedbackSurvey;
        }

        public final String getUrl() {
            return this.url;
        }

        public final OpenMethod getOpenMethod() {
            return this.openMethod;
        }

        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u000f2\u00020\u0001:\u0003\u000f\u0010\u0011B\u0019\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0007J!\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eHÇ\u0001\u0082\u0001\u0002\u0012\u0013¨\u0006\u0014"}, d2 = {"Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathDetail;", "", "seen1", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "()V", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Companion", "FeedbackSurvey", "PromotionalOffer", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey;", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static abstract class PathDetail {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private static final Lazy $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.revenuecat.purchases.customercenter.CustomerCenterConfigData.HelpPath.PathDetail.Companion.1
                @Override // kotlin.jvm.functions.Function0
                public final KSerializer invoke() {
                    return new SealedClassSerializer("com.revenuecat.purchases.customercenter.CustomerCenterConfigData.HelpPath.PathDetail", Reflection.getOrCreateKotlinClass(PathDetail.class), new KClass[]{Reflection.getOrCreateKotlinClass(FeedbackSurvey.class), Reflection.getOrCreateKotlinClass(PromotionalOffer.class)}, new KSerializer[]{CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$$serializer.INSTANCE, CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer.INSTANCE}, new Annotation[0]);
                }
            });

            public /* synthetic */ PathDetail(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public static final /* synthetic */ void write$Self(PathDetail self, CompositeEncoder output, SerialDescriptor serialDesc) {
            }

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathDetail$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathDetail;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                private final /* synthetic */ KSerializer get$cachedSerializer() {
                    return (KSerializer) PathDetail.$cachedSerializer$delegate.getValue();
                }

                public final KSerializer serializer() {
                    return get$cachedSerializer();
                }
            }

            @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 52\u00020\u0001:\u0003456B;\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0002\u0010\nBq\b\u0011\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0001\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\u0016\b\u0001\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000e\u0018\u00010\t\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\t\u0012\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000e0\t¢\u0006\u0002\u0010\u0012J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u0015\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\tHÆ\u0003J\u0015\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000e0\tHÆ\u0003JF\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\tH\u0007J]\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\t2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000e0\tHÆ\u0001J\u0013\u0010'\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020\fHÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001J&\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00002\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202HÁ\u0001¢\u0006\u0002\b3R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R(\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000e0\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR(\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u001d\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016¨\u00067"}, d2 = {"Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer;", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathDetail;", "androidOfferId", "", "eligible", "", b.S, "subtitle", "productMapping", "", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "seen1", "", "crossProductPromotions", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$CrossProductPromotion;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", "getAndroidOfferId$annotations", "()V", "getAndroidOfferId", "()Ljava/lang/String;", "getCrossProductPromotions$annotations", "getCrossProductPromotions", "()Ljava/util/Map;", "getEligible", "()Z", "getProductMapping$annotations", "getProductMapping", "getSubtitle", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "CrossProductPromotion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final /* data */ class PromotionalOffer extends PathDetail {
                private static final KSerializer[] $childSerializers;

                /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                public static final Companion INSTANCE = new Companion(null);
                private final String androidOfferId;
                private final Map<String, CrossProductPromotion> crossProductPromotions;
                private final boolean eligible;
                private final Map<String, String> productMapping;
                private final String subtitle;
                private final String title;

                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ PromotionalOffer copy$default(PromotionalOffer promotionalOffer, String str, boolean z, String str2, String str3, Map map, Map map2, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = promotionalOffer.androidOfferId;
                    }
                    if ((i & 2) != 0) {
                        z = promotionalOffer.eligible;
                    }
                    if ((i & 4) != 0) {
                        str2 = promotionalOffer.title;
                    }
                    if ((i & 8) != 0) {
                        str3 = promotionalOffer.subtitle;
                    }
                    if ((i & 16) != 0) {
                        map = promotionalOffer.productMapping;
                    }
                    if ((i & 32) != 0) {
                        map2 = promotionalOffer.crossProductPromotions;
                    }
                    Map map3 = map;
                    Map map4 = map2;
                    return promotionalOffer.copy(str, z, str2, str3, map3, map4);
                }

                public static /* synthetic */ void getAndroidOfferId$annotations() {
                }

                public static /* synthetic */ void getCrossProductPromotions$annotations() {
                }

                public static /* synthetic */ void getProductMapping$annotations() {
                }

                /* JADX INFO: renamed from: component1, reason: from getter */
                public final String getAndroidOfferId() {
                    return this.androidOfferId;
                }

                /* JADX INFO: renamed from: component2, reason: from getter */
                public final boolean getEligible() {
                    return this.eligible;
                }

                /* JADX INFO: renamed from: component3, reason: from getter */
                public final String getTitle() {
                    return this.title;
                }

                /* JADX INFO: renamed from: component4, reason: from getter */
                public final String getSubtitle() {
                    return this.subtitle;
                }

                public final Map<String, String> component5() {
                    return this.productMapping;
                }

                public final Map<String, CrossProductPromotion> component6() {
                    return this.crossProductPromotions;
                }

                public final PromotionalOffer copy(String androidOfferId, boolean eligible, String title, String subtitle, Map<String, String> productMapping, Map<String, CrossProductPromotion> crossProductPromotions) {
                    Intrinsics.checkNotNullParameter(androidOfferId, "androidOfferId");
                    Intrinsics.checkNotNullParameter(title, "title");
                    Intrinsics.checkNotNullParameter(subtitle, "subtitle");
                    Intrinsics.checkNotNullParameter(productMapping, "productMapping");
                    Intrinsics.checkNotNullParameter(crossProductPromotions, "crossProductPromotions");
                    return new PromotionalOffer(androidOfferId, eligible, title, subtitle, productMapping, crossProductPromotions);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof PromotionalOffer)) {
                        return false;
                    }
                    PromotionalOffer promotionalOffer = (PromotionalOffer) other;
                    return Intrinsics.areEqual(this.androidOfferId, promotionalOffer.androidOfferId) && this.eligible == promotionalOffer.eligible && Intrinsics.areEqual(this.title, promotionalOffer.title) && Intrinsics.areEqual(this.subtitle, promotionalOffer.subtitle) && Intrinsics.areEqual(this.productMapping, promotionalOffer.productMapping) && Intrinsics.areEqual(this.crossProductPromotions, promotionalOffer.crossProductPromotions);
                }

                public int hashCode() {
                    return (((((((((this.androidOfferId.hashCode() * 31) + Boolean.hashCode(this.eligible)) * 31) + this.title.hashCode()) * 31) + this.subtitle.hashCode()) * 31) + this.productMapping.hashCode()) * 31) + this.crossProductPromotions.hashCode();
                }

                public String toString() {
                    return "PromotionalOffer(androidOfferId=" + this.androidOfferId + ", eligible=" + this.eligible + ", title=" + this.title + ", subtitle=" + this.subtitle + ", productMapping=" + this.productMapping + ", crossProductPromotions=" + this.crossProductPromotions + ')';
                }

                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    private Companion() {
                    }

                    public final KSerializer serializer() {
                        return CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer.INSTANCE;
                    }
                }

                static {
                    StringSerializer stringSerializer = StringSerializer.INSTANCE;
                    $childSerializers = new KSerializer[]{null, null, null, null, new LinkedHashMapSerializer(stringSerializer, stringSerializer), new LinkedHashMapSerializer(stringSerializer, CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$CrossProductPromotion$$serializer.INSTANCE)};
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                @Deprecated
                public /* synthetic */ PromotionalOffer(int i, String str, boolean z, String str2, String str3, Map map, Map map2, SerializationConstructorMarker serializationConstructorMarker) {
                    super(i, serializationConstructorMarker);
                    if (31 != (i & 31)) {
                        PluginExceptionsKt.throwMissingFieldException(i, 31, CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer.INSTANCE.getDescriptor());
                    }
                    this.androidOfferId = str;
                    this.eligible = z;
                    this.title = str2;
                    this.subtitle = str3;
                    this.productMapping = map;
                    if ((i & 32) == 0) {
                        this.crossProductPromotions = MapsKt.emptyMap();
                    } else {
                        this.crossProductPromotions = map2;
                    }
                }

                public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(PromotionalOffer self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    PathDetail.write$Self(self, output, serialDesc);
                    KSerializer[] kSerializerArr = $childSerializers;
                    output.encodeStringElement(serialDesc, 0, self.androidOfferId);
                    output.encodeBooleanElement(serialDesc, 1, self.eligible);
                    output.encodeStringElement(serialDesc, 2, self.title);
                    output.encodeStringElement(serialDesc, 3, self.subtitle);
                    output.encodeSerializableElement(serialDesc, 4, kSerializerArr[4], self.productMapping);
                    if (!output.shouldEncodeElementDefault(serialDesc, 5) && Intrinsics.areEqual(self.crossProductPromotions, MapsKt.emptyMap())) {
                        return;
                    }
                    output.encodeSerializableElement(serialDesc, 5, kSerializerArr[5], self.crossProductPromotions);
                }

                public final String getAndroidOfferId() {
                    return this.androidOfferId;
                }

                public final boolean getEligible() {
                    return this.eligible;
                }

                public final String getTitle() {
                    return this.title;
                }

                public final String getSubtitle() {
                    return this.subtitle;
                }

                public final Map<String, String> getProductMapping() {
                    return this.productMapping;
                }

                public final Map<String, CrossProductPromotion> getCrossProductPromotions() {
                    return this.crossProductPromotions;
                }

                public /* synthetic */ PromotionalOffer(String str, boolean z, String str2, String str3, Map map, Map map2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this(str, z, str2, str3, map, (i & 32) != 0 ? MapsKt.emptyMap() : map2);
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public PromotionalOffer(String androidOfferId, boolean z, String title, String subtitle, Map<String, String> productMapping, Map<String, CrossProductPromotion> crossProductPromotions) {
                    super(null);
                    Intrinsics.checkNotNullParameter(androidOfferId, "androidOfferId");
                    Intrinsics.checkNotNullParameter(title, "title");
                    Intrinsics.checkNotNullParameter(subtitle, "subtitle");
                    Intrinsics.checkNotNullParameter(productMapping, "productMapping");
                    Intrinsics.checkNotNullParameter(crossProductPromotions, "crossProductPromotions");
                    this.androidOfferId = androidOfferId;
                    this.eligible = z;
                    this.title = title;
                    this.subtitle = subtitle;
                    this.productMapping = productMapping;
                    this.crossProductPromotions = crossProductPromotions;
                }

                /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
                @Deprecated
                public PromotionalOffer(String androidOfferId, boolean z, String title, String subtitle, Map<String, String> productMapping) {
                    this(androidOfferId, z, title, subtitle, productMapping, MapsKt.emptyMap());
                    Intrinsics.checkNotNullParameter(androidOfferId, "androidOfferId");
                    Intrinsics.checkNotNullParameter(title, "title");
                    Intrinsics.checkNotNullParameter(subtitle, "subtitle");
                    Intrinsics.checkNotNullParameter(productMapping, "productMapping");
                }

                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ PromotionalOffer copy$default(PromotionalOffer promotionalOffer, String str, boolean z, String str2, String str3, Map map, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = promotionalOffer.androidOfferId;
                    }
                    if ((i & 2) != 0) {
                        z = promotionalOffer.eligible;
                    }
                    if ((i & 4) != 0) {
                        str2 = promotionalOffer.title;
                    }
                    if ((i & 8) != 0) {
                        str3 = promotionalOffer.subtitle;
                    }
                    if ((i & 16) != 0) {
                        map = promotionalOffer.productMapping;
                    }
                    Map map2 = map;
                    String str4 = str2;
                    return promotionalOffer.copy(str, z, str4, str3, map2);
                }

                @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0002\u0019\u001aB1\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ&\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017HÁ\u0001¢\u0006\u0002\b\u0018R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$CrossProductPromotion;", "", "seen1", "", "storeOfferIdentifier", "", "targetProductId", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "getStoreOfferIdentifier$annotations", "()V", "getStoreOfferIdentifier", "()Ljava/lang/String;", "getTargetProductId$annotations", "getTargetProductId", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                public static final class CrossProductPromotion {

                    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                    public static final Companion INSTANCE = new Companion(null);
                    private final String storeOfferIdentifier;
                    private final String targetProductId;

                    public static /* synthetic */ void getStoreOfferIdentifier$annotations() {
                    }

                    public static /* synthetic */ void getTargetProductId$annotations() {
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (!(obj instanceof CrossProductPromotion)) {
                            return false;
                        }
                        CrossProductPromotion crossProductPromotion = (CrossProductPromotion) obj;
                        return Intrinsics.areEqual(this.storeOfferIdentifier, crossProductPromotion.storeOfferIdentifier) && Intrinsics.areEqual(this.targetProductId, crossProductPromotion.targetProductId);
                    }

                    public int hashCode() {
                        return (this.storeOfferIdentifier.hashCode() * 31) + this.targetProductId.hashCode();
                    }

                    public String toString() {
                        return "CrossProductPromotion(storeOfferIdentifier=" + this.storeOfferIdentifier + ", targetProductId=" + this.targetProductId + ')';
                    }

                    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$CrossProductPromotion$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$CrossProductPromotion;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                    public static final class Companion {
                        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                            this();
                        }

                        private Companion() {
                        }

                        public final KSerializer serializer() {
                            return CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$CrossProductPromotion$$serializer.INSTANCE;
                        }
                    }

                    @Deprecated
                    public /* synthetic */ CrossProductPromotion(int i, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
                        if (3 != (i & 3)) {
                            PluginExceptionsKt.throwMissingFieldException(i, 3, CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$CrossProductPromotion$$serializer.INSTANCE.getDescriptor());
                        }
                        this.storeOfferIdentifier = str;
                        this.targetProductId = str2;
                    }

                    public CrossProductPromotion(String storeOfferIdentifier, String targetProductId) {
                        Intrinsics.checkNotNullParameter(storeOfferIdentifier, "storeOfferIdentifier");
                        Intrinsics.checkNotNullParameter(targetProductId, "targetProductId");
                        this.storeOfferIdentifier = storeOfferIdentifier;
                        this.targetProductId = targetProductId;
                    }

                    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(CrossProductPromotion self, CompositeEncoder output, SerialDescriptor serialDesc) {
                        output.encodeStringElement(serialDesc, 0, self.storeOfferIdentifier);
                        output.encodeStringElement(serialDesc, 1, self.targetProductId);
                    }

                    public final String getStoreOfferIdentifier() {
                        return this.storeOfferIdentifier;
                    }

                    public final String getTargetProductId() {
                        return this.targetProductId;
                    }
                }

                @Deprecated
                public final PromotionalOffer copy(String androidOfferId, boolean eligible, String title, String subtitle, Map<String, String> productMapping) {
                    Intrinsics.checkNotNullParameter(androidOfferId, "androidOfferId");
                    Intrinsics.checkNotNullParameter(title, "title");
                    Intrinsics.checkNotNullParameter(subtitle, "subtitle");
                    Intrinsics.checkNotNullParameter(productMapping, "productMapping");
                    return copy(androidOfferId, eligible, title, subtitle, productMapping, MapsKt.emptyMap());
                }
            }

            private PathDetail() {
            }

            @Deprecated
            public /* synthetic */ PathDetail(int i, SerializationConstructorMarker serializationConstructorMarker) {
            }

            @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0003\"#$B3\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\fJ\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J#\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J&\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 HÁ\u0001¢\u0006\u0002\b!R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006%"}, d2 = {"Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey;", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathDetail;", "seen1", "", b.S, "", "options", "", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$Option;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/util/List;)V", "getOptions", "()Ljava/util/List;", "getTitle", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "Option", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final /* data */ class FeedbackSurvey extends PathDetail {
                private final List<Option> options;
                private final String title;

                /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                public static final Companion INSTANCE = new Companion(null);
                private static final KSerializer[] $childSerializers = {null, new ArrayListSerializer(CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$Option$$serializer.INSTANCE)};

                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ FeedbackSurvey copy$default(FeedbackSurvey feedbackSurvey, String str, List list, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = feedbackSurvey.title;
                    }
                    if ((i & 2) != 0) {
                        list = feedbackSurvey.options;
                    }
                    return feedbackSurvey.copy(str, list);
                }

                /* JADX INFO: renamed from: component1, reason: from getter */
                public final String getTitle() {
                    return this.title;
                }

                public final List<Option> component2() {
                    return this.options;
                }

                public final FeedbackSurvey copy(String title, List<Option> options) {
                    Intrinsics.checkNotNullParameter(title, "title");
                    Intrinsics.checkNotNullParameter(options, "options");
                    return new FeedbackSurvey(title, options);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof FeedbackSurvey)) {
                        return false;
                    }
                    FeedbackSurvey feedbackSurvey = (FeedbackSurvey) other;
                    return Intrinsics.areEqual(this.title, feedbackSurvey.title) && Intrinsics.areEqual(this.options, feedbackSurvey.options);
                }

                public int hashCode() {
                    return (this.title.hashCode() * 31) + this.options.hashCode();
                }

                public String toString() {
                    return "FeedbackSurvey(title=" + this.title + ", options=" + this.options + ')';
                }

                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    private Companion() {
                    }

                    public final KSerializer serializer() {
                        return CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$$serializer.INSTANCE;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                @Deprecated
                public /* synthetic */ FeedbackSurvey(int i, String str, List list, SerializationConstructorMarker serializationConstructorMarker) {
                    super(i, serializationConstructorMarker);
                    if (3 != (i & 3)) {
                        PluginExceptionsKt.throwMissingFieldException(i, 3, CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$$serializer.INSTANCE.getDescriptor());
                    }
                    this.title = str;
                    this.options = list;
                }

                public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(FeedbackSurvey self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    PathDetail.write$Self(self, output, serialDesc);
                    KSerializer[] kSerializerArr = $childSerializers;
                    output.encodeStringElement(serialDesc, 0, self.title);
                    output.encodeSerializableElement(serialDesc, 1, kSerializerArr[1], self.options);
                }

                public final String getTitle() {
                    return this.title;
                }

                @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002%&B9\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB!\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\fJ\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003J)\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J&\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#HÁ\u0001¢\u0006\u0002\b$R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000e¨\u0006'"}, d2 = {"Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$Option;", "", "seen1", "", DiagnosticsEntry.ID_KEY, "", b.S, "promotionalOffer", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer;)V", "getId", "()Ljava/lang/String;", "getPromotionalOffer$annotations", "()V", "getPromotionalOffer", "()Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer;", "getTitle", "component1", "component2", "component3", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                public static final /* data */ class Option {

                    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                    public static final Companion INSTANCE = new Companion(null);
                    private final String id;
                    private final PromotionalOffer promotionalOffer;
                    private final String title;

                    public static /* synthetic */ Option copy$default(Option option, String str, String str2, PromotionalOffer promotionalOffer, int i, Object obj) {
                        if ((i & 1) != 0) {
                            str = option.id;
                        }
                        if ((i & 2) != 0) {
                            str2 = option.title;
                        }
                        if ((i & 4) != 0) {
                            promotionalOffer = option.promotionalOffer;
                        }
                        return option.copy(str, str2, promotionalOffer);
                    }

                    public static /* synthetic */ void getPromotionalOffer$annotations() {
                    }

                    /* JADX INFO: renamed from: component1, reason: from getter */
                    public final String getId() {
                        return this.id;
                    }

                    /* JADX INFO: renamed from: component2, reason: from getter */
                    public final String getTitle() {
                        return this.title;
                    }

                    /* JADX INFO: renamed from: component3, reason: from getter */
                    public final PromotionalOffer getPromotionalOffer() {
                        return this.promotionalOffer;
                    }

                    public final Option copy(String id, String title, PromotionalOffer promotionalOffer) {
                        Intrinsics.checkNotNullParameter(id, "id");
                        Intrinsics.checkNotNullParameter(title, "title");
                        return new Option(id, title, promotionalOffer);
                    }

                    public boolean equals(Object other) {
                        if (this == other) {
                            return true;
                        }
                        if (!(other instanceof Option)) {
                            return false;
                        }
                        Option option = (Option) other;
                        return Intrinsics.areEqual(this.id, option.id) && Intrinsics.areEqual(this.title, option.title) && Intrinsics.areEqual(this.promotionalOffer, option.promotionalOffer);
                    }

                    public int hashCode() {
                        int iHashCode = ((this.id.hashCode() * 31) + this.title.hashCode()) * 31;
                        PromotionalOffer promotionalOffer = this.promotionalOffer;
                        return iHashCode + (promotionalOffer == null ? 0 : promotionalOffer.hashCode());
                    }

                    public String toString() {
                        return "Option(id=" + this.id + ", title=" + this.title + ", promotionalOffer=" + this.promotionalOffer + ')';
                    }

                    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$Option$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$Option;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                    public static final class Companion {
                        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                            this();
                        }

                        private Companion() {
                        }

                        public final KSerializer serializer() {
                            return CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$Option$$serializer.INSTANCE;
                        }
                    }

                    @Deprecated
                    public /* synthetic */ Option(int i, String str, String str2, PromotionalOffer promotionalOffer, SerializationConstructorMarker serializationConstructorMarker) {
                        if (3 != (i & 3)) {
                            PluginExceptionsKt.throwMissingFieldException(i, 3, CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$Option$$serializer.INSTANCE.getDescriptor());
                        }
                        this.id = str;
                        this.title = str2;
                        if ((i & 4) == 0) {
                            this.promotionalOffer = null;
                        } else {
                            this.promotionalOffer = promotionalOffer;
                        }
                    }

                    public Option(String id, String title, PromotionalOffer promotionalOffer) {
                        Intrinsics.checkNotNullParameter(id, "id");
                        Intrinsics.checkNotNullParameter(title, "title");
                        this.id = id;
                        this.title = title;
                        this.promotionalOffer = promotionalOffer;
                    }

                    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Option self, CompositeEncoder output, SerialDescriptor serialDesc) {
                        output.encodeStringElement(serialDesc, 0, self.id);
                        output.encodeStringElement(serialDesc, 1, self.title);
                        if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.promotionalOffer == null) {
                            return;
                        }
                        output.encodeNullableSerializableElement(serialDesc, 2, CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer.INSTANCE, self.promotionalOffer);
                    }

                    public /* synthetic */ Option(String str, String str2, PromotionalOffer promotionalOffer, int i, DefaultConstructorMarker defaultConstructorMarker) {
                        this(str, str2, (i & 4) != 0 ? null : promotionalOffer);
                    }

                    public final String getId() {
                        return this.id;
                    }

                    public final String getTitle() {
                        return this.title;
                    }

                    public final PromotionalOffer getPromotionalOffer() {
                        return this.promotionalOffer;
                    }
                }

                public final List<Option> getOptions() {
                    return this.options;
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public FeedbackSurvey(String title, List<Option> options) {
                    super(null);
                    Intrinsics.checkNotNullParameter(title, "title");
                    Intrinsics.checkNotNullParameter(options, "options");
                    this.title = title;
                    this.options = options;
                }
            }
        }

        public final String getActionIdentifier() {
            return this.actionIdentifier;
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0087\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathType;", "", "(Ljava/lang/String;I)V", "MISSING_PURCHASE", "REFUND_REQUEST", "CHANGE_PLANS", "CANCEL", "CUSTOM_URL", "CUSTOM_ACTION", "UNKNOWN", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public enum PathType {
            MISSING_PURCHASE,
            REFUND_REQUEST,
            CHANGE_PLANS,
            CANCEL,
            CUSTOM_URL,
            CUSTOM_ACTION,
            UNKNOWN;


            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private static final Lazy $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.revenuecat.purchases.customercenter.CustomerCenterConfigData.HelpPath.PathType.Companion.1
                @Override // kotlin.jvm.functions.Function0
                public final KSerializer invoke() {
                    return EnumsKt.createSimpleEnumSerializer("com.revenuecat.purchases.customercenter.CustomerCenterConfigData.HelpPath.PathType", PathType.values());
                }
            });

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathType$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathType;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                private final /* synthetic */ KSerializer get$cachedSerializer() {
                    return (KSerializer) PathType.$cachedSerializer$delegate.getValue();
                }

                public final KSerializer serializer() {
                    return get$cachedSerializer();
                }
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$OpenMethod;", "", "(Ljava/lang/String;I)V", "IN_APP", "EXTERNAL", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public enum OpenMethod {
            IN_APP,
            EXTERNAL;


            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private static final Lazy $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.revenuecat.purchases.customercenter.CustomerCenterConfigData.HelpPath.OpenMethod.Companion.1
                @Override // kotlin.jvm.functions.Function0
                public final KSerializer invoke() {
                    return EnumsKt.createSimpleEnumSerializer("com.revenuecat.purchases.customercenter.CustomerCenterConfigData.HelpPath.OpenMethod", OpenMethod.values());
                }
            });

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$OpenMethod$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$OpenMethod;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                private final /* synthetic */ KSerializer get$cachedSerializer() {
                    return (KSerializer) OpenMethod.$cachedSerializer$delegate.getValue();
                }

                public final KSerializer serializer() {
                    return get$cachedSerializer();
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 !2\u00020\u0001:\u0003\u001f !B-\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB\u001d\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J&\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dHÁ\u0001¢\u0006\u0002\b\u001eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\""}, d2 = {"Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Appearance;", "", "seen1", "", "light", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Appearance$ColorInformation;", "dark", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Appearance$ColorInformation;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Appearance$ColorInformation;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Appearance$ColorInformation;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Appearance$ColorInformation;)V", "getDark", "()Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Appearance$ColorInformation;", "getLight", "component1", "component2", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "ColorInformation", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Appearance {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final ColorInformation dark;
        private final ColorInformation light;

        /* JADX WARN: Multi-variable type inference failed */
        public Appearance() {
            this((ColorInformation) null, (ColorInformation) (0 == true ? 1 : 0), 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
        }

        public static /* synthetic */ Appearance copy$default(Appearance appearance, ColorInformation colorInformation, ColorInformation colorInformation2, int i, Object obj) {
            if ((i & 1) != 0) {
                colorInformation = appearance.light;
            }
            if ((i & 2) != 0) {
                colorInformation2 = appearance.dark;
            }
            return appearance.copy(colorInformation, colorInformation2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ColorInformation getLight() {
            return this.light;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ColorInformation getDark() {
            return this.dark;
        }

        public final Appearance copy(ColorInformation light, ColorInformation dark) {
            return new Appearance(light, dark);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Appearance)) {
                return false;
            }
            Appearance appearance = (Appearance) other;
            return Intrinsics.areEqual(this.light, appearance.light) && Intrinsics.areEqual(this.dark, appearance.dark);
        }

        public int hashCode() {
            ColorInformation colorInformation = this.light;
            int iHashCode = (colorInformation == null ? 0 : colorInformation.hashCode()) * 31;
            ColorInformation colorInformation2 = this.dark;
            return iHashCode + (colorInformation2 != null ? colorInformation2.hashCode() : 0);
        }

        public String toString() {
            return "Appearance(light=" + this.light + ", dark=" + this.dark + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Appearance$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Appearance;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer serializer() {
                return CustomerCenterConfigData$Appearance$$serializer.INSTANCE;
            }
        }

        @Deprecated
        public /* synthetic */ Appearance(int i, ColorInformation colorInformation, ColorInformation colorInformation2, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 1) == 0) {
                this.light = null;
            } else {
                this.light = colorInformation;
            }
            if ((i & 2) == 0) {
                this.dark = null;
            } else {
                this.dark = colorInformation2;
            }
        }

        public Appearance(ColorInformation colorInformation, ColorInformation colorInformation2) {
            this.light = colorInformation;
            this.dark = colorInformation2;
        }

        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Appearance self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.light != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, CustomerCenterConfigData$Appearance$ColorInformation$$serializer.INSTANCE, self.light);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 1) && self.dark == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 1, CustomerCenterConfigData$Appearance$ColorInformation$$serializer.INSTANCE, self.dark);
        }

        public /* synthetic */ Appearance(ColorInformation colorInformation, ColorInformation colorInformation2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : colorInformation, (i & 2) != 0 ? null : colorInformation2);
        }

        public final ColorInformation getLight() {
            return this.light;
        }

        @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 02\u00020\u0001:\u0002/0Bs\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0001\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006\u0012\u0010\b\u0001\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006\u0012\u0010\b\u0001\u0010\b\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006\u0012\u0010\b\u0001\u0010\t\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006\u0012\u0010\b\u0001\u0010\n\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rB_\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006\u0012\u0010\b\u0002\u0010\b\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006\u0012\u0010\b\u0002\u0010\t\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006\u0012\u0010\b\u0002\u0010\n\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006¢\u0006\u0002\u0010\u000eJ\u0011\u0010\u001b\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006HÆ\u0003J\u0011\u0010\u001d\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006HÆ\u0003J\u0011\u0010\u001e\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006HÆ\u0003J\u0011\u0010\u001f\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006HÆ\u0003Jc\u0010 \u001a\u00020\u00002\u0010\b\u0002\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00062\u0010\b\u0002\u0010\b\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00062\u0010\b\u0002\u0010\t\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00062\u0010\b\u0002\u0010\n\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001J&\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-HÁ\u0001¢\u0006\u0002\b.R$\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R$\u0010\b\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R$\u0010\n\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012R$\u0010\t\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0012R$\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u001a\u0010\u0012¨\u00061"}, d2 = {"Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Appearance$ColorInformation;", "", "seen1", "", "accentColor", "Lcom/revenuecat/purchases/paywalls/PaywallColor;", "Lcom/revenuecat/purchases/customercenter/RCColor;", "textColor", "backgroundColor", "buttonTextColor", "buttonBackgroundColor", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;)V", "getAccentColor$annotations", "()V", "getAccentColor", "()Lcom/revenuecat/purchases/paywalls/PaywallColor;", "getBackgroundColor$annotations", "getBackgroundColor", "getButtonBackgroundColor$annotations", "getButtonBackgroundColor", "getButtonTextColor$annotations", "getButtonTextColor", "getTextColor$annotations", "getTextColor", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final /* data */ class ColorInformation {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final PaywallColor accentColor;
            private final PaywallColor backgroundColor;
            private final PaywallColor buttonBackgroundColor;
            private final PaywallColor buttonTextColor;
            private final PaywallColor textColor;

            public ColorInformation() {
                this((PaywallColor) null, (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, (PaywallColor) null, 31, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ ColorInformation copy$default(ColorInformation colorInformation, PaywallColor paywallColor, PaywallColor paywallColor2, PaywallColor paywallColor3, PaywallColor paywallColor4, PaywallColor paywallColor5, int i, Object obj) {
                if ((i & 1) != 0) {
                    paywallColor = colorInformation.accentColor;
                }
                if ((i & 2) != 0) {
                    paywallColor2 = colorInformation.textColor;
                }
                if ((i & 4) != 0) {
                    paywallColor3 = colorInformation.backgroundColor;
                }
                if ((i & 8) != 0) {
                    paywallColor4 = colorInformation.buttonTextColor;
                }
                if ((i & 16) != 0) {
                    paywallColor5 = colorInformation.buttonBackgroundColor;
                }
                PaywallColor paywallColor6 = paywallColor5;
                PaywallColor paywallColor7 = paywallColor3;
                return colorInformation.copy(paywallColor, paywallColor2, paywallColor7, paywallColor4, paywallColor6);
            }

            public static /* synthetic */ void getAccentColor$annotations() {
            }

            public static /* synthetic */ void getBackgroundColor$annotations() {
            }

            public static /* synthetic */ void getButtonBackgroundColor$annotations() {
            }

            public static /* synthetic */ void getButtonTextColor$annotations() {
            }

            public static /* synthetic */ void getTextColor$annotations() {
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final PaywallColor getAccentColor() {
                return this.accentColor;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final PaywallColor getTextColor() {
                return this.textColor;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final PaywallColor getBackgroundColor() {
                return this.backgroundColor;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final PaywallColor getButtonTextColor() {
                return this.buttonTextColor;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final PaywallColor getButtonBackgroundColor() {
                return this.buttonBackgroundColor;
            }

            public final ColorInformation copy(PaywallColor accentColor, PaywallColor textColor, PaywallColor backgroundColor, PaywallColor buttonTextColor, PaywallColor buttonBackgroundColor) {
                return new ColorInformation(accentColor, textColor, backgroundColor, buttonTextColor, buttonBackgroundColor);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ColorInformation)) {
                    return false;
                }
                ColorInformation colorInformation = (ColorInformation) other;
                return Intrinsics.areEqual(this.accentColor, colorInformation.accentColor) && Intrinsics.areEqual(this.textColor, colorInformation.textColor) && Intrinsics.areEqual(this.backgroundColor, colorInformation.backgroundColor) && Intrinsics.areEqual(this.buttonTextColor, colorInformation.buttonTextColor) && Intrinsics.areEqual(this.buttonBackgroundColor, colorInformation.buttonBackgroundColor);
            }

            public int hashCode() {
                PaywallColor paywallColor = this.accentColor;
                int iHashCode = (paywallColor == null ? 0 : paywallColor.hashCode()) * 31;
                PaywallColor paywallColor2 = this.textColor;
                int iHashCode2 = (iHashCode + (paywallColor2 == null ? 0 : paywallColor2.hashCode())) * 31;
                PaywallColor paywallColor3 = this.backgroundColor;
                int iHashCode3 = (iHashCode2 + (paywallColor3 == null ? 0 : paywallColor3.hashCode())) * 31;
                PaywallColor paywallColor4 = this.buttonTextColor;
                int iHashCode4 = (iHashCode3 + (paywallColor4 == null ? 0 : paywallColor4.hashCode())) * 31;
                PaywallColor paywallColor5 = this.buttonBackgroundColor;
                return iHashCode4 + (paywallColor5 != null ? paywallColor5.hashCode() : 0);
            }

            public String toString() {
                return "ColorInformation(accentColor=" + this.accentColor + ", textColor=" + this.textColor + ", backgroundColor=" + this.backgroundColor + ", buttonTextColor=" + this.buttonTextColor + ", buttonBackgroundColor=" + this.buttonBackgroundColor + ')';
            }

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Appearance$ColorInformation$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Appearance$ColorInformation;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer serializer() {
                    return CustomerCenterConfigData$Appearance$ColorInformation$$serializer.INSTANCE;
                }
            }

            @Deprecated
            public /* synthetic */ ColorInformation(int i, PaywallColor paywallColor, PaywallColor paywallColor2, PaywallColor paywallColor3, PaywallColor paywallColor4, PaywallColor paywallColor5, SerializationConstructorMarker serializationConstructorMarker) {
                if ((i & 1) == 0) {
                    this.accentColor = null;
                } else {
                    this.accentColor = paywallColor;
                }
                if ((i & 2) == 0) {
                    this.textColor = null;
                } else {
                    this.textColor = paywallColor2;
                }
                if ((i & 4) == 0) {
                    this.backgroundColor = null;
                } else {
                    this.backgroundColor = paywallColor3;
                }
                if ((i & 8) == 0) {
                    this.buttonTextColor = null;
                } else {
                    this.buttonTextColor = paywallColor4;
                }
                if ((i & 16) == 0) {
                    this.buttonBackgroundColor = null;
                } else {
                    this.buttonBackgroundColor = paywallColor5;
                }
            }

            public ColorInformation(PaywallColor paywallColor, PaywallColor paywallColor2, PaywallColor paywallColor3, PaywallColor paywallColor4, PaywallColor paywallColor5) {
                this.accentColor = paywallColor;
                this.textColor = paywallColor2;
                this.backgroundColor = paywallColor3;
                this.buttonTextColor = paywallColor4;
                this.buttonBackgroundColor = paywallColor5;
            }

            public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(ColorInformation self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.accentColor != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, PaywallColor.Serializer.INSTANCE, self.accentColor);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.textColor != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, PaywallColor.Serializer.INSTANCE, self.textColor);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.backgroundColor != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, PaywallColor.Serializer.INSTANCE, self.backgroundColor);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.buttonTextColor != null) {
                    output.encodeNullableSerializableElement(serialDesc, 3, PaywallColor.Serializer.INSTANCE, self.buttonTextColor);
                }
                if (!output.shouldEncodeElementDefault(serialDesc, 4) && self.buttonBackgroundColor == null) {
                    return;
                }
                output.encodeNullableSerializableElement(serialDesc, 4, PaywallColor.Serializer.INSTANCE, self.buttonBackgroundColor);
            }

            public /* synthetic */ ColorInformation(PaywallColor paywallColor, PaywallColor paywallColor2, PaywallColor paywallColor3, PaywallColor paywallColor4, PaywallColor paywallColor5, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : paywallColor, (i & 2) != 0 ? null : paywallColor2, (i & 4) != 0 ? null : paywallColor3, (i & 8) != 0 ? null : paywallColor4, (i & 16) != 0 ? null : paywallColor5);
            }

            public final PaywallColor getAccentColor() {
                return this.accentColor;
            }

            public final PaywallColor getTextColor() {
                return this.textColor;
            }

            public final PaywallColor getBackgroundColor() {
                return this.backgroundColor;
            }

            public final PaywallColor getButtonTextColor() {
                return this.buttonTextColor;
            }

            public final PaywallColor getButtonBackgroundColor() {
                return this.buttonBackgroundColor;
            }
        }

        public final ColorInformation getDark() {
            return this.dark;
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0003&'(B;\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\fJ\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J&\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$HÁ\u0001¢\u0006\u0002\b%R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006)"}, d2 = {"Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$ScreenOffering;", "", "seen1", "", "type", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$ScreenOffering$ScreenOfferingType;", "offeringId", "", "buttonText", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$ScreenOffering$ScreenOfferingType;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$ScreenOffering$ScreenOfferingType;Ljava/lang/String;Ljava/lang/String;)V", "getButtonText$annotations", "()V", "getButtonText", "()Ljava/lang/String;", "getOfferingId$annotations", "getOfferingId", "getType", "()Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$ScreenOffering$ScreenOfferingType;", "component1", "component2", "component3", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "ScreenOfferingType", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class ScreenOffering {
        private final String buttonText;
        private final String offeringId;
        private final ScreenOfferingType type;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer[] $childSerializers = {ScreenOfferingType.INSTANCE.serializer(), null, null};

        public static /* synthetic */ ScreenOffering copy$default(ScreenOffering screenOffering, ScreenOfferingType screenOfferingType, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                screenOfferingType = screenOffering.type;
            }
            if ((i & 2) != 0) {
                str = screenOffering.offeringId;
            }
            if ((i & 4) != 0) {
                str2 = screenOffering.buttonText;
            }
            return screenOffering.copy(screenOfferingType, str, str2);
        }

        public static /* synthetic */ void getButtonText$annotations() {
        }

        public static /* synthetic */ void getOfferingId$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ScreenOfferingType getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getOfferingId() {
            return this.offeringId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getButtonText() {
            return this.buttonText;
        }

        public final ScreenOffering copy(ScreenOfferingType type, String offeringId, String buttonText) {
            Intrinsics.checkNotNullParameter(type, "type");
            return new ScreenOffering(type, offeringId, buttonText);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ScreenOffering)) {
                return false;
            }
            ScreenOffering screenOffering = (ScreenOffering) other;
            return this.type == screenOffering.type && Intrinsics.areEqual(this.offeringId, screenOffering.offeringId) && Intrinsics.areEqual(this.buttonText, screenOffering.buttonText);
        }

        public int hashCode() {
            int iHashCode = this.type.hashCode() * 31;
            String str = this.offeringId;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.buttonText;
            return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "ScreenOffering(type=" + this.type + ", offeringId=" + this.offeringId + ", buttonText=" + this.buttonText + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$ScreenOffering$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$ScreenOffering;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer serializer() {
                return CustomerCenterConfigData$ScreenOffering$$serializer.INSTANCE;
            }
        }

        @Deprecated
        public /* synthetic */ ScreenOffering(int i, ScreenOfferingType screenOfferingType, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, CustomerCenterConfigData$ScreenOffering$$serializer.INSTANCE.getDescriptor());
            }
            this.type = screenOfferingType;
            if ((i & 2) == 0) {
                this.offeringId = null;
            } else {
                this.offeringId = str;
            }
            if ((i & 4) == 0) {
                this.buttonText = null;
            } else {
                this.buttonText = str2;
            }
        }

        public ScreenOffering(ScreenOfferingType type, String str, String str2) {
            Intrinsics.checkNotNullParameter(type, "type");
            this.type = type;
            this.offeringId = str;
            this.buttonText = str2;
        }

        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(ScreenOffering self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeSerializableElement(serialDesc, 0, $childSerializers[0], self.type);
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.offeringId != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.offeringId);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.buttonText == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.buttonText);
        }

        public /* synthetic */ ScreenOffering(ScreenOfferingType screenOfferingType, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(screenOfferingType, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2);
        }

        public final ScreenOfferingType getType() {
            return this.type;
        }

        public final String getOfferingId() {
            return this.offeringId;
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0087\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$ScreenOffering$ScreenOfferingType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CURRENT", "SPECIFIC", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public enum ScreenOfferingType {
            CURRENT("CURRENT"),
            SPECIFIC("SPECIFIC");

            private final String value;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private static final Lazy $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.revenuecat.purchases.customercenter.CustomerCenterConfigData.ScreenOffering.ScreenOfferingType.Companion.1
                @Override // kotlin.jvm.functions.Function0
                public final KSerializer invoke() {
                    return EnumsKt.createAnnotatedEnumSerializer("com.revenuecat.purchases.customercenter.CustomerCenterConfigData.ScreenOffering.ScreenOfferingType", ScreenOfferingType.values(), new String[]{"CURRENT", "SPECIFIC"}, new Annotation[][]{null, null}, null);
                }
            });

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$ScreenOffering$ScreenOfferingType$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$ScreenOffering$ScreenOfferingType;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                private final /* synthetic */ KSerializer get$cachedSerializer() {
                    return (KSerializer) ScreenOfferingType.$cachedSerializer$delegate.getValue();
                }

                public final KSerializer serializer() {
                    return get$cachedSerializer();
                }
            }

            ScreenOfferingType(String str) {
                this.value = str;
            }

            public final String getValue() {
                return this.value;
            }
        }

        public final String getButtonText() {
            return this.buttonText;
        }
    }

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 22\u00020\u0001:\u0003123BU\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0001\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010B;\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u0011J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\rHÆ\u0003JE\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0003HÖ\u0001J\t\u0010(\u001a\u00020\u0007HÖ\u0001J&\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/HÁ\u0001¢\u0006\u0002\b0R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u00064"}, d2 = {"Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Screen;", "", "seen1", "", "type", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Screen$ScreenType;", b.S, "", "subtitle", "paths", "", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath;", "offering", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$ScreenOffering;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Screen$ScreenType;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$ScreenOffering;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Screen$ScreenType;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$ScreenOffering;)V", "getOffering", "()Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$ScreenOffering;", "getPaths$annotations", "()V", "getPaths", "()Ljava/util/List;", "getSubtitle$annotations", "getSubtitle", "()Ljava/lang/String;", "getTitle", "getType", "()Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Screen$ScreenType;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "ScreenType", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Screen {
        private final ScreenOffering offering;
        private final List<HelpPath> paths;
        private final String subtitle;
        private final String title;
        private final ScreenType type;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer[] $childSerializers = {ScreenType.INSTANCE.serializer(), null, null, null, null};

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Screen copy$default(Screen screen, ScreenType screenType, String str, String str2, List list, ScreenOffering screenOffering, int i, Object obj) {
            if ((i & 1) != 0) {
                screenType = screen.type;
            }
            if ((i & 2) != 0) {
                str = screen.title;
            }
            if ((i & 4) != 0) {
                str2 = screen.subtitle;
            }
            if ((i & 8) != 0) {
                list = screen.paths;
            }
            if ((i & 16) != 0) {
                screenOffering = screen.offering;
            }
            ScreenOffering screenOffering2 = screenOffering;
            String str3 = str2;
            return screen.copy(screenType, str, str3, list, screenOffering2);
        }

        public static /* synthetic */ void getPaths$annotations() {
        }

        public static /* synthetic */ void getSubtitle$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ScreenType getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getSubtitle() {
            return this.subtitle;
        }

        public final List<HelpPath> component4() {
            return this.paths;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final ScreenOffering getOffering() {
            return this.offering;
        }

        public final Screen copy(ScreenType type, String title, String subtitle, List<HelpPath> paths, ScreenOffering offering) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(paths, "paths");
            return new Screen(type, title, subtitle, paths, offering);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Screen)) {
                return false;
            }
            Screen screen = (Screen) other;
            return this.type == screen.type && Intrinsics.areEqual(this.title, screen.title) && Intrinsics.areEqual(this.subtitle, screen.subtitle) && Intrinsics.areEqual(this.paths, screen.paths) && Intrinsics.areEqual(this.offering, screen.offering);
        }

        public int hashCode() {
            int iHashCode = ((this.type.hashCode() * 31) + this.title.hashCode()) * 31;
            String str = this.subtitle;
            int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.paths.hashCode()) * 31;
            ScreenOffering screenOffering = this.offering;
            return iHashCode2 + (screenOffering != null ? screenOffering.hashCode() : 0);
        }

        public String toString() {
            return "Screen(type=" + this.type + ", title=" + this.title + ", subtitle=" + this.subtitle + ", paths=" + this.paths + ", offering=" + this.offering + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Screen$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Screen;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer serializer() {
                return CustomerCenterConfigData$Screen$$serializer.INSTANCE;
            }
        }

        @Deprecated
        public /* synthetic */ Screen(int i, ScreenType screenType, String str, String str2, List list, ScreenOffering screenOffering, SerializationConstructorMarker serializationConstructorMarker) {
            if (11 != (i & 11)) {
                PluginExceptionsKt.throwMissingFieldException(i, 11, CustomerCenterConfigData$Screen$$serializer.INSTANCE.getDescriptor());
            }
            this.type = screenType;
            this.title = str;
            if ((i & 4) == 0) {
                this.subtitle = null;
            } else {
                this.subtitle = str2;
            }
            this.paths = list;
            if ((i & 16) == 0) {
                this.offering = null;
            } else {
                this.offering = screenOffering;
            }
        }

        public Screen(ScreenType type, String title, String str, List<HelpPath> paths, ScreenOffering screenOffering) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(paths, "paths");
            this.type = type;
            this.title = title;
            this.subtitle = str;
            this.paths = paths;
            this.offering = screenOffering;
        }

        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Screen self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeSerializableElement(serialDesc, 0, $childSerializers[0], self.type);
            output.encodeStringElement(serialDesc, 1, self.title);
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.subtitle != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, EmptyStringToNullSerializer.INSTANCE, self.subtitle);
            }
            output.encodeSerializableElement(serialDesc, 3, HelpPathsSerializer.INSTANCE, self.paths);
            if (!output.shouldEncodeElementDefault(serialDesc, 4) && self.offering == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 4, CustomerCenterConfigData$ScreenOffering$$serializer.INSTANCE, self.offering);
        }

        public /* synthetic */ Screen(ScreenType screenType, String str, String str2, List list, ScreenOffering screenOffering, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(screenType, str, (i & 4) != 0 ? null : str2, list, (i & 16) != 0 ? null : screenOffering);
        }

        public final ScreenType getType() {
            return this.type;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getSubtitle() {
            return this.subtitle;
        }

        public final List<HelpPath> getPaths() {
            return this.paths;
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0001\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Screen$ScreenType;", "", "(Ljava/lang/String;I)V", "MANAGEMENT", "NO_ACTIVE", "UNKNOWN", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public enum ScreenType {
            MANAGEMENT,
            NO_ACTIVE,
            UNKNOWN;


            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private static final Lazy $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Screen.ScreenType.Companion.1
                @Override // kotlin.jvm.functions.Function0
                public final KSerializer invoke() {
                    return EnumsKt.createSimpleEnumSerializer("com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Screen.ScreenType", ScreenType.values());
                }
            });

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Screen$ScreenType$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Screen$ScreenType;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                private final /* synthetic */ KSerializer get$cachedSerializer() {
                    return (KSerializer) ScreenType.$cachedSerializer$delegate.getValue();
                }

                public final KSerializer serializer() {
                    return get$cachedSerializer();
                }
            }
        }

        public final ScreenOffering getOffering() {
            return this.offering;
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 /2\u00020\u0001:\u0003./0BI\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rB3\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0012J\t\u0010\u001f\u001a\u00020\nHÆ\u0003J<\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001J&\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,HÁ\u0001¢\u0006\u0002\b-R \u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0013\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0016R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0013\u0012\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0012R\u001c\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u001a\u0010\u001b¨\u00061"}, d2 = {"Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support;", "", "seen1", "", AuthorizationRequest.Scope.EMAIL, "", "shouldWarnCustomerToUpdate", "", "displayVirtualCurrencies", "supportTickets", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets;)V", "getDisplayVirtualCurrencies$annotations", "()V", "getDisplayVirtualCurrencies", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getEmail$annotations", "getEmail", "()Ljava/lang/String;", "getShouldWarnCustomerToUpdate$annotations", "getShouldWarnCustomerToUpdate", "getSupportTickets$annotations", "getSupportTickets", "()Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets;)Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support;", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "SupportTickets", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Support {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Boolean displayVirtualCurrencies;
        private final String email;
        private final Boolean shouldWarnCustomerToUpdate;
        private final SupportTickets supportTickets;

        public Support() {
            this((String) null, (Boolean) null, (Boolean) null, (SupportTickets) null, 15, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ Support copy$default(Support support, String str, Boolean bool, Boolean bool2, SupportTickets supportTickets, int i, Object obj) {
            if ((i & 1) != 0) {
                str = support.email;
            }
            if ((i & 2) != 0) {
                bool = support.shouldWarnCustomerToUpdate;
            }
            if ((i & 4) != 0) {
                bool2 = support.displayVirtualCurrencies;
            }
            if ((i & 8) != 0) {
                supportTickets = support.supportTickets;
            }
            return support.copy(str, bool, bool2, supportTickets);
        }

        public static /* synthetic */ void getDisplayVirtualCurrencies$annotations() {
        }

        public static /* synthetic */ void getEmail$annotations() {
        }

        public static /* synthetic */ void getShouldWarnCustomerToUpdate$annotations() {
        }

        public static /* synthetic */ void getSupportTickets$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getEmail() {
            return this.email;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Boolean getShouldWarnCustomerToUpdate() {
            return this.shouldWarnCustomerToUpdate;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Boolean getDisplayVirtualCurrencies() {
            return this.displayVirtualCurrencies;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final SupportTickets getSupportTickets() {
            return this.supportTickets;
        }

        public final Support copy(String email, Boolean shouldWarnCustomerToUpdate, Boolean displayVirtualCurrencies, SupportTickets supportTickets) {
            Intrinsics.checkNotNullParameter(supportTickets, "supportTickets");
            return new Support(email, shouldWarnCustomerToUpdate, displayVirtualCurrencies, supportTickets);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Support)) {
                return false;
            }
            Support support = (Support) other;
            return Intrinsics.areEqual(this.email, support.email) && Intrinsics.areEqual(this.shouldWarnCustomerToUpdate, support.shouldWarnCustomerToUpdate) && Intrinsics.areEqual(this.displayVirtualCurrencies, support.displayVirtualCurrencies) && Intrinsics.areEqual(this.supportTickets, support.supportTickets);
        }

        public int hashCode() {
            String str = this.email;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            Boolean bool = this.shouldWarnCustomerToUpdate;
            int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
            Boolean bool2 = this.displayVirtualCurrencies;
            return ((iHashCode2 + (bool2 != null ? bool2.hashCode() : 0)) * 31) + this.supportTickets.hashCode();
        }

        public String toString() {
            return "Support(email=" + this.email + ", shouldWarnCustomerToUpdate=" + this.shouldWarnCustomerToUpdate + ", displayVirtualCurrencies=" + this.displayVirtualCurrencies + ", supportTickets=" + this.supportTickets + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer serializer() {
                return CustomerCenterConfigData$Support$$serializer.INSTANCE;
            }
        }

        @Deprecated
        public /* synthetic */ Support(int i, String str, Boolean bool, Boolean bool2, SupportTickets supportTickets, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 1) == 0) {
                this.email = null;
            } else {
                this.email = str;
            }
            if ((i & 2) == 0) {
                this.shouldWarnCustomerToUpdate = null;
            } else {
                this.shouldWarnCustomerToUpdate = bool;
            }
            if ((i & 4) == 0) {
                this.displayVirtualCurrencies = null;
            } else {
                this.displayVirtualCurrencies = bool2;
            }
            if ((i & 8) != 0) {
                this.supportTickets = supportTickets;
                return;
            }
            this.supportTickets = new SupportTickets(false, (SupportTickets.CustomerDetails) null, (SupportTickets.CustomerType) null, 7, (DefaultConstructorMarker) null);
        }

        public Support(String str, Boolean bool, Boolean bool2, SupportTickets supportTickets) {
            Intrinsics.checkNotNullParameter(supportTickets, "supportTickets");
            this.email = str;
            this.shouldWarnCustomerToUpdate = bool;
            this.displayVirtualCurrencies = bool2;
            this.supportTickets = supportTickets;
        }

        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Support self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.email != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, EmptyStringToNullSerializer.INSTANCE, self.email);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.shouldWarnCustomerToUpdate != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, BooleanSerializer.INSTANCE, self.shouldWarnCustomerToUpdate);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.displayVirtualCurrencies != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, BooleanSerializer.INSTANCE, self.displayVirtualCurrencies);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 3)) {
                if (Intrinsics.areEqual(self.supportTickets, new SupportTickets(false, (SupportTickets.CustomerDetails) null, (SupportTickets.CustomerType) null, 7, (DefaultConstructorMarker) null))) {
                    return;
                }
            }
            output.encodeSerializableElement(serialDesc, 3, CustomerCenterConfigData$Support$SupportTickets$$serializer.INSTANCE, self.supportTickets);
        }

        public final String getEmail() {
            return this.email;
        }

        public final Boolean getShouldWarnCustomerToUpdate() {
            return this.shouldWarnCustomerToUpdate;
        }

        public final Boolean getDisplayVirtualCurrencies() {
            return this.displayVirtualCurrencies;
        }

        @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u0000 ,2\u00020\u0001:\u0004+,-.B;\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fB#\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\rJ\u0006\u0010\u0018\u001a\u00020\u0005J\u0006\u0010\u0019\u001a\u00020\u0005J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J'\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001J&\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)HÁ\u0001¢\u0006\u0002\b*R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0017¨\u0006/"}, d2 = {"Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets;", "", "seen1", "", "allowCreation", "", "customerDetails", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets$CustomerDetails;", "customerType", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets$CustomerType;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZLcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets$CustomerDetails;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets$CustomerType;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(ZLcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets$CustomerDetails;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets$CustomerType;)V", "getAllowCreation$annotations", "()V", "getAllowCreation", "()Z", "getCustomerDetails$annotations", "getCustomerDetails", "()Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets$CustomerDetails;", "getCustomerType$annotations", "getCustomerType", "()Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets$CustomerType;", "allowsActiveCustomers", "allowsNonActiveCustomers", "component1", "component2", "component3", "copy", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "CustomerDetails", "CustomerType", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final /* data */ class SupportTickets {
            private final boolean allowCreation;
            private final CustomerDetails customerDetails;
            private final CustomerType customerType;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private static final KSerializer[] $childSerializers = {null, null, CustomerType.INSTANCE.serializer()};

            public SupportTickets() {
                this(false, (CustomerDetails) null, (CustomerType) null, 7, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ SupportTickets copy$default(SupportTickets supportTickets, boolean z, CustomerDetails customerDetails, CustomerType customerType, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = supportTickets.allowCreation;
                }
                if ((i & 2) != 0) {
                    customerDetails = supportTickets.customerDetails;
                }
                if ((i & 4) != 0) {
                    customerType = supportTickets.customerType;
                }
                return supportTickets.copy(z, customerDetails, customerType);
            }

            public static /* synthetic */ void getAllowCreation$annotations() {
            }

            public static /* synthetic */ void getCustomerDetails$annotations() {
            }

            public static /* synthetic */ void getCustomerType$annotations() {
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getAllowCreation() {
                return this.allowCreation;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final CustomerDetails getCustomerDetails() {
                return this.customerDetails;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final CustomerType getCustomerType() {
                return this.customerType;
            }

            public final SupportTickets copy(boolean allowCreation, CustomerDetails customerDetails, CustomerType customerType) {
                Intrinsics.checkNotNullParameter(customerDetails, "customerDetails");
                Intrinsics.checkNotNullParameter(customerType, "customerType");
                return new SupportTickets(allowCreation, customerDetails, customerType);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SupportTickets)) {
                    return false;
                }
                SupportTickets supportTickets = (SupportTickets) other;
                return this.allowCreation == supportTickets.allowCreation && Intrinsics.areEqual(this.customerDetails, supportTickets.customerDetails) && this.customerType == supportTickets.customerType;
            }

            public int hashCode() {
                return (((Boolean.hashCode(this.allowCreation) * 31) + this.customerDetails.hashCode()) * 31) + this.customerType.hashCode();
            }

            public String toString() {
                return "SupportTickets(allowCreation=" + this.allowCreation + ", customerDetails=" + this.customerDetails + ", customerType=" + this.customerType + ')';
            }

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer serializer() {
                    return CustomerCenterConfigData$Support$SupportTickets$$serializer.INSTANCE;
                }
            }

            @Deprecated
            public /* synthetic */ SupportTickets(int i, boolean z, CustomerDetails customerDetails, CustomerType customerType, SerializationConstructorMarker serializationConstructorMarker) {
                this.allowCreation = (i & 1) == 0 ? false : z;
                if ((i & 2) == 0) {
                    this.customerDetails = new CustomerDetails(false, false, false, false, false, false, false, false, false, false, false, false, false, false, 16383, (DefaultConstructorMarker) null);
                } else {
                    this.customerDetails = customerDetails;
                }
                this.customerType = (i & 4) == 0 ? CustomerType.NOT_ACTIVE : customerType;
            }

            public SupportTickets(boolean z, CustomerDetails customerDetails, CustomerType customerType) {
                Intrinsics.checkNotNullParameter(customerDetails, "customerDetails");
                Intrinsics.checkNotNullParameter(customerType, "customerType");
                this.allowCreation = z;
                this.customerDetails = customerDetails;
                this.customerType = customerType;
            }

            /* JADX WARN: Code duplicated, block: B:13:0x0045  */
            public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(SupportTickets self, CompositeEncoder output, SerialDescriptor serialDesc) {
                KSerializer[] kSerializerArr = $childSerializers;
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.allowCreation) {
                    output.encodeBooleanElement(serialDesc, 0, self.allowCreation);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1)) {
                    output.encodeSerializableElement(serialDesc, 1, CustomerCenterConfigData$Support$SupportTickets$CustomerDetails$$serializer.INSTANCE, self.customerDetails);
                } else {
                    if (!Intrinsics.areEqual(self.customerDetails, new CustomerDetails(false, false, false, false, false, false, false, false, false, false, false, false, false, false, 16383, (DefaultConstructorMarker) null))) {
                        output.encodeSerializableElement(serialDesc, 1, CustomerCenterConfigData$Support$SupportTickets$CustomerDetails$$serializer.INSTANCE, self.customerDetails);
                    }
                }
                if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.customerType == CustomerType.NOT_ACTIVE) {
                    return;
                }
                output.encodeSerializableElement(serialDesc, 2, kSerializerArr[2], self.customerType);
            }

            public final boolean getAllowCreation() {
                return this.allowCreation;
            }

            public /* synthetic */ SupportTickets(boolean z, CustomerDetails customerDetails, CustomerType customerType, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? false : z, (i & 2) != 0 ? new CustomerDetails(false, false, false, false, false, false, false, false, false, false, false, false, false, false, 16383, (DefaultConstructorMarker) null) : customerDetails, (i & 4) != 0 ? CustomerType.NOT_ACTIVE : customerType);
            }

            public final CustomerDetails getCustomerDetails() {
                return this.customerDetails;
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0087\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets$CustomerType;", "", "(Ljava/lang/String;I)V", "NOT_ACTIVE", "NONE", "ALL", "ACTIVE", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public enum CustomerType {
                NOT_ACTIVE,
                NONE,
                ALL,
                ACTIVE;


                /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                public static final Companion INSTANCE = new Companion(null);
                private static final Lazy $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Support.SupportTickets.CustomerType.Companion.1
                    @Override // kotlin.jvm.functions.Function0
                    public final KSerializer invoke() {
                        return EnumsKt.createAnnotatedEnumSerializer("com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Support.SupportTickets.CustomerType", CustomerType.values(), new String[]{"not_active", "none", "all", AppStateModule.APP_STATE_ACTIVE}, new Annotation[][]{null, null, null, null}, null);
                    }
                });

                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets$CustomerType$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets$CustomerType;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    private Companion() {
                    }

                    private final /* synthetic */ KSerializer get$cachedSerializer() {
                        return (KSerializer) CustomerType.$cachedSerializer$delegate.getValue();
                    }

                    public final KSerializer serializer() {
                        return get$cachedSerializer();
                    }
                }
            }

            public final CustomerType getCustomerType() {
                return this.customerType;
            }

            @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 M2\u00020\u0001:\u0002LMB\u009b\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\b\u0001\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0012\u001a\u00020\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0015B\u0091\u0001\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005¢\u0006\u0002\u0010\u0016J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\t\u00106\u001a\u00020\u0005HÆ\u0003J\t\u00107\u001a\u00020\u0005HÆ\u0003J\t\u00108\u001a\u00020\u0005HÆ\u0003J\t\u00109\u001a\u00020\u0005HÆ\u0003J\t\u0010:\u001a\u00020\u0005HÆ\u0003J\t\u0010;\u001a\u00020\u0005HÆ\u0003J\t\u0010<\u001a\u00020\u0005HÆ\u0003J\t\u0010=\u001a\u00020\u0005HÆ\u0003J\u0095\u0001\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u0005HÆ\u0001J\u0013\u0010?\u001a\u00020\u00052\b\u0010@\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010A\u001a\u00020\u0003HÖ\u0001J\t\u0010B\u001a\u00020CHÖ\u0001J&\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u00002\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020JHÁ\u0001¢\u0006\u0002\bKR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u001aR\u001c\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001aR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u001c\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0018\u001a\u0004\b!\u0010\u001aR\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u001c\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0018\u001a\u0004\b$\u0010\u001aR\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001aR\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001aR\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001aR\u001c\u0010\u000f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010\u0018\u001a\u0004\b)\u0010\u001aR\u001c\u0010\u0010\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u0018\u001a\u0004\b+\u0010\u001aR\u001c\u0010\u0011\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010\u0018\u001a\u0004\b-\u0010\u001aR\u001c\u0010\u0012\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010\u0018\u001a\u0004\b/\u0010\u001a¨\u0006N"}, d2 = {"Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets$CustomerDetails;", "", "seen1", "", "activeEntitlements", "", "appUserId", "attConsent", "country", "deviceVersion", AuthorizationRequest.Scope.EMAIL, "facebookAnonId", "idfa", "idfv", "ip", "lastOpened", "lastSeenAppVersion", "totalSpent", "userSince", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZZZZZZZZZZZZZZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(ZZZZZZZZZZZZZZ)V", "getActiveEntitlements$annotations", "()V", "getActiveEntitlements", "()Z", "getAppUserId$annotations", "getAppUserId", "getAttConsent$annotations", "getAttConsent", "getCountry", "getDeviceVersion$annotations", "getDeviceVersion", "getEmail", "getFacebookAnonId$annotations", "getFacebookAnonId", "getIdfa", "getIdfv", "getIp", "getLastOpened$annotations", "getLastOpened", "getLastSeenAppVersion$annotations", "getLastSeenAppVersion", "getTotalSpent$annotations", "getTotalSpent", "getUserSince$annotations", "getUserSince", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final /* data */ class CustomerDetails {

                /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                public static final Companion INSTANCE = new Companion(null);
                private final boolean activeEntitlements;
                private final boolean appUserId;
                private final boolean attConsent;
                private final boolean country;
                private final boolean deviceVersion;
                private final boolean email;
                private final boolean facebookAnonId;
                private final boolean idfa;
                private final boolean idfv;
                private final boolean ip;
                private final boolean lastOpened;
                private final boolean lastSeenAppVersion;
                private final boolean totalSpent;
                private final boolean userSince;

                public CustomerDetails() {
                    this(false, false, false, false, false, false, false, false, false, false, false, false, false, false, 16383, (DefaultConstructorMarker) null);
                }

                public static /* synthetic */ void getActiveEntitlements$annotations() {
                }

                public static /* synthetic */ void getAppUserId$annotations() {
                }

                public static /* synthetic */ void getAttConsent$annotations() {
                }

                public static /* synthetic */ void getDeviceVersion$annotations() {
                }

                public static /* synthetic */ void getFacebookAnonId$annotations() {
                }

                public static /* synthetic */ void getLastOpened$annotations() {
                }

                public static /* synthetic */ void getLastSeenAppVersion$annotations() {
                }

                public static /* synthetic */ void getTotalSpent$annotations() {
                }

                public static /* synthetic */ void getUserSince$annotations() {
                }

                /* JADX INFO: renamed from: component1, reason: from getter */
                public final boolean getActiveEntitlements() {
                    return this.activeEntitlements;
                }

                /* JADX INFO: renamed from: component10, reason: from getter */
                public final boolean getIp() {
                    return this.ip;
                }

                /* JADX INFO: renamed from: component11, reason: from getter */
                public final boolean getLastOpened() {
                    return this.lastOpened;
                }

                /* JADX INFO: renamed from: component12, reason: from getter */
                public final boolean getLastSeenAppVersion() {
                    return this.lastSeenAppVersion;
                }

                /* JADX INFO: renamed from: component13, reason: from getter */
                public final boolean getTotalSpent() {
                    return this.totalSpent;
                }

                /* JADX INFO: renamed from: component14, reason: from getter */
                public final boolean getUserSince() {
                    return this.userSince;
                }

                /* JADX INFO: renamed from: component2, reason: from getter */
                public final boolean getAppUserId() {
                    return this.appUserId;
                }

                /* JADX INFO: renamed from: component3, reason: from getter */
                public final boolean getAttConsent() {
                    return this.attConsent;
                }

                /* JADX INFO: renamed from: component4, reason: from getter */
                public final boolean getCountry() {
                    return this.country;
                }

                /* JADX INFO: renamed from: component5, reason: from getter */
                public final boolean getDeviceVersion() {
                    return this.deviceVersion;
                }

                /* JADX INFO: renamed from: component6, reason: from getter */
                public final boolean getEmail() {
                    return this.email;
                }

                /* JADX INFO: renamed from: component7, reason: from getter */
                public final boolean getFacebookAnonId() {
                    return this.facebookAnonId;
                }

                /* JADX INFO: renamed from: component8, reason: from getter */
                public final boolean getIdfa() {
                    return this.idfa;
                }

                /* JADX INFO: renamed from: component9, reason: from getter */
                public final boolean getIdfv() {
                    return this.idfv;
                }

                public final CustomerDetails copy(boolean activeEntitlements, boolean appUserId, boolean attConsent, boolean country, boolean deviceVersion, boolean email, boolean facebookAnonId, boolean idfa, boolean idfv, boolean ip, boolean lastOpened, boolean lastSeenAppVersion, boolean totalSpent, boolean userSince) {
                    return new CustomerDetails(activeEntitlements, appUserId, attConsent, country, deviceVersion, email, facebookAnonId, idfa, idfv, ip, lastOpened, lastSeenAppVersion, totalSpent, userSince);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof CustomerDetails)) {
                        return false;
                    }
                    CustomerDetails customerDetails = (CustomerDetails) other;
                    return this.activeEntitlements == customerDetails.activeEntitlements && this.appUserId == customerDetails.appUserId && this.attConsent == customerDetails.attConsent && this.country == customerDetails.country && this.deviceVersion == customerDetails.deviceVersion && this.email == customerDetails.email && this.facebookAnonId == customerDetails.facebookAnonId && this.idfa == customerDetails.idfa && this.idfv == customerDetails.idfv && this.ip == customerDetails.ip && this.lastOpened == customerDetails.lastOpened && this.lastSeenAppVersion == customerDetails.lastSeenAppVersion && this.totalSpent == customerDetails.totalSpent && this.userSince == customerDetails.userSince;
                }

                public int hashCode() {
                    return (((((((((((((((((((((((((Boolean.hashCode(this.activeEntitlements) * 31) + Boolean.hashCode(this.appUserId)) * 31) + Boolean.hashCode(this.attConsent)) * 31) + Boolean.hashCode(this.country)) * 31) + Boolean.hashCode(this.deviceVersion)) * 31) + Boolean.hashCode(this.email)) * 31) + Boolean.hashCode(this.facebookAnonId)) * 31) + Boolean.hashCode(this.idfa)) * 31) + Boolean.hashCode(this.idfv)) * 31) + Boolean.hashCode(this.ip)) * 31) + Boolean.hashCode(this.lastOpened)) * 31) + Boolean.hashCode(this.lastSeenAppVersion)) * 31) + Boolean.hashCode(this.totalSpent)) * 31) + Boolean.hashCode(this.userSince);
                }

                public String toString() {
                    return "CustomerDetails(activeEntitlements=" + this.activeEntitlements + ", appUserId=" + this.appUserId + ", attConsent=" + this.attConsent + ", country=" + this.country + ", deviceVersion=" + this.deviceVersion + ", email=" + this.email + ", facebookAnonId=" + this.facebookAnonId + ", idfa=" + this.idfa + ", idfv=" + this.idfv + ", ip=" + this.ip + ", lastOpened=" + this.lastOpened + ", lastSeenAppVersion=" + this.lastSeenAppVersion + ", totalSpent=" + this.totalSpent + ", userSince=" + this.userSince + ')';
                }

                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets$CustomerDetails$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets$CustomerDetails;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    private Companion() {
                    }

                    public final KSerializer serializer() {
                        return CustomerCenterConfigData$Support$SupportTickets$CustomerDetails$$serializer.INSTANCE;
                    }
                }

                @Deprecated
                public /* synthetic */ CustomerDetails(int i, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, SerializationConstructorMarker serializationConstructorMarker) {
                    if ((i & 1) == 0) {
                        this.activeEntitlements = false;
                    } else {
                        this.activeEntitlements = z;
                    }
                    if ((i & 2) == 0) {
                        this.appUserId = false;
                    } else {
                        this.appUserId = z2;
                    }
                    if ((i & 4) == 0) {
                        this.attConsent = false;
                    } else {
                        this.attConsent = z3;
                    }
                    if ((i & 8) == 0) {
                        this.country = false;
                    } else {
                        this.country = z4;
                    }
                    if ((i & 16) == 0) {
                        this.deviceVersion = false;
                    } else {
                        this.deviceVersion = z5;
                    }
                    if ((i & 32) == 0) {
                        this.email = false;
                    } else {
                        this.email = z6;
                    }
                    if ((i & 64) == 0) {
                        this.facebookAnonId = false;
                    } else {
                        this.facebookAnonId = z7;
                    }
                    if ((i & 128) == 0) {
                        this.idfa = false;
                    } else {
                        this.idfa = z8;
                    }
                    if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) == 0) {
                        this.idfv = false;
                    } else {
                        this.idfv = z9;
                    }
                    if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) == 0) {
                        this.ip = false;
                    } else {
                        this.ip = z10;
                    }
                    if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) == 0) {
                        this.lastOpened = false;
                    } else {
                        this.lastOpened = z11;
                    }
                    if ((i & 2048) == 0) {
                        this.lastSeenAppVersion = false;
                    } else {
                        this.lastSeenAppVersion = z12;
                    }
                    if ((i & 4096) == 0) {
                        this.totalSpent = false;
                    } else {
                        this.totalSpent = z13;
                    }
                    if ((i & 8192) == 0) {
                        this.userSince = false;
                    } else {
                        this.userSince = z14;
                    }
                }

                public CustomerDetails(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14) {
                    this.activeEntitlements = z;
                    this.appUserId = z2;
                    this.attConsent = z3;
                    this.country = z4;
                    this.deviceVersion = z5;
                    this.email = z6;
                    this.facebookAnonId = z7;
                    this.idfa = z8;
                    this.idfv = z9;
                    this.ip = z10;
                    this.lastOpened = z11;
                    this.lastSeenAppVersion = z12;
                    this.totalSpent = z13;
                    this.userSince = z14;
                }

                public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(CustomerDetails self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    if (output.shouldEncodeElementDefault(serialDesc, 0) || self.activeEntitlements) {
                        output.encodeBooleanElement(serialDesc, 0, self.activeEntitlements);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 1) || self.appUserId) {
                        output.encodeBooleanElement(serialDesc, 1, self.appUserId);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 2) || self.attConsent) {
                        output.encodeBooleanElement(serialDesc, 2, self.attConsent);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 3) || self.country) {
                        output.encodeBooleanElement(serialDesc, 3, self.country);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 4) || self.deviceVersion) {
                        output.encodeBooleanElement(serialDesc, 4, self.deviceVersion);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 5) || self.email) {
                        output.encodeBooleanElement(serialDesc, 5, self.email);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 6) || self.facebookAnonId) {
                        output.encodeBooleanElement(serialDesc, 6, self.facebookAnonId);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 7) || self.idfa) {
                        output.encodeBooleanElement(serialDesc, 7, self.idfa);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 8) || self.idfv) {
                        output.encodeBooleanElement(serialDesc, 8, self.idfv);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 9) || self.ip) {
                        output.encodeBooleanElement(serialDesc, 9, self.ip);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 10) || self.lastOpened) {
                        output.encodeBooleanElement(serialDesc, 10, self.lastOpened);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 11) || self.lastSeenAppVersion) {
                        output.encodeBooleanElement(serialDesc, 11, self.lastSeenAppVersion);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 12) || self.totalSpent) {
                        output.encodeBooleanElement(serialDesc, 12, self.totalSpent);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 13) || self.userSince) {
                        output.encodeBooleanElement(serialDesc, 13, self.userSince);
                    }
                }

                public /* synthetic */ CustomerDetails(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3, (i & 8) != 0 ? false : z4, (i & 16) != 0 ? false : z5, (i & 32) != 0 ? false : z6, (i & 64) != 0 ? false : z7, (i & 128) != 0 ? false : z8, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? false : z9, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? false : z10, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? false : z11, (i & 2048) != 0 ? false : z12, (i & 4096) != 0 ? false : z13, (i & 8192) != 0 ? false : z14);
                }

                public final boolean getActiveEntitlements() {
                    return this.activeEntitlements;
                }

                public final boolean getAppUserId() {
                    return this.appUserId;
                }

                public final boolean getAttConsent() {
                    return this.attConsent;
                }

                public final boolean getCountry() {
                    return this.country;
                }

                public final boolean getDeviceVersion() {
                    return this.deviceVersion;
                }

                public final boolean getEmail() {
                    return this.email;
                }

                public final boolean getFacebookAnonId() {
                    return this.facebookAnonId;
                }

                public final boolean getIdfa() {
                    return this.idfa;
                }

                public final boolean getIdfv() {
                    return this.idfv;
                }

                public final boolean getIp() {
                    return this.ip;
                }

                public final boolean getLastOpened() {
                    return this.lastOpened;
                }

                public final boolean getLastSeenAppVersion() {
                    return this.lastSeenAppVersion;
                }

                public final boolean getTotalSpent() {
                    return this.totalSpent;
                }

                public final boolean getUserSince() {
                    return this.userSince;
                }
            }

            public final boolean allowsActiveCustomers() {
                CustomerType customerType = this.customerType;
                return customerType == CustomerType.ALL || customerType == CustomerType.ACTIVE;
            }

            public final boolean allowsNonActiveCustomers() {
                CustomerType customerType = this.customerType;
                return customerType == CustomerType.ALL || customerType == CustomerType.NOT_ACTIVE;
            }
        }

        public /* synthetic */ Support(String str, Boolean bool, Boolean bool2, SupportTickets supportTickets, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : bool2, (i & 8) != 0 ? new SupportTickets(false, (SupportTickets.CustomerDetails) null, (SupportTickets.CustomerType) null, 7, (DefaultConstructorMarker) null) : supportTickets);
        }

        public final SupportTickets getSupportTickets() {
            return this.supportTickets;
        }
    }

    public final Screen getManagementScreen() {
        return this.screens.get(Screen.ScreenType.MANAGEMENT);
    }

    public final Screen getNoActiveScreen() {
        return this.screens.get(Screen.ScreenType.NO_ACTIVE);
    }
}
