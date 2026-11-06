package com.revenuecat.purchases.paywalls;

import com.BV.LinearGradient.LinearGradientManager;
import com.amazon.a.a.o.b;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.facebook.react.modules.appstate.AppStateModule;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.utils.LocaleExtensionsKt;
import com.revenuecat.purchases.utils.serializers.GoogleListSerializer;
import com.revenuecat.purchases.utils.serializers.OptionalURLSerializer;
import com.revenuecat.purchases.utils.serializers.URLSerializer;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import okhttp3.internal.http2.Http2;

/* JADX INFO: loaded from: classes4.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 C2\u00020\u0001:\u0004BCDEB§\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0016\b\u0001\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\"\b\u0001\u0010\u000f\u001a\u001c\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\r\u0018\u00010\r\u0012\u0010\b\u0001\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0015B\u0085\u0001\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\r\u0012 \b\u0002\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\r0\r\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0016J\u0010\u00104\u001a\u0004\u0018\u00010\u000e2\u0006\u00105\u001a\u00020(J\u0084\u0001\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\r2 \b\u0002\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\r0\r2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0007J\"\u0010&\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u000e0'2\f\u00107\u001a\b\u0012\u0004\u0012\u00020(0\u0011H\u0007J\u001e\u00108\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u00105\u001a\u00020(H\u0007J.\u00109\u001a\u001a\u0012\u0004\u0012\u00020(\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\r0'2\f\u00107\u001a\b\u0012\u0004\u0012\u00020(0\u0011H\u0002J&\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u00002\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@HÁ\u0001¢\u0006\u0002\bAR\u001c\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR(\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\r8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0018\u001a\u0004\b\"\u0010#R4\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\r0\r8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u0018\u001a\u0004\b%\u0010#R\u001d\u0010&\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u000e0'8F¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010\u0018\u001a\u0004\b.\u0010\u001fR)\u0010/\u001a\u001a\u0012\u0004\u0012\u00020(\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\r0'8F¢\u0006\u0006\u001a\u0004\b0\u0010*R\"\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u00118\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b1\u0010\u0018\u001a\u0004\b2\u00103¨\u0006F"}, d2 = {"Lcom/revenuecat/purchases/paywalls/PaywallData;", "", "seen1", "", DiagnosticsEntry.ID_KEY, "", "templateName", "config", "Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration;", "assetBaseURL", "Ljava/net/URL;", "revision", "localization", "", "Lcom/revenuecat/purchases/paywalls/PaywallData$LocalizedConfiguration;", "localizationByTier", "zeroDecimalPlaceCountries", "", "defaultLocale", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration;Ljava/net/URL;ILjava/util/Map;Ljava/util/Map;Ljava/util/List;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration;Ljava/net/URL;ILjava/util/Map;Ljava/util/Map;Ljava/util/List;Ljava/lang/String;)V", "getAssetBaseURL$annotations", "()V", "getAssetBaseURL", "()Ljava/net/URL;", "getConfig", "()Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration;", "getDefaultLocale$annotations", "getDefaultLocale", "()Ljava/lang/String;", "getId", "getLocalization$purchases_defaultsBc8Release$annotations", "getLocalization$purchases_defaultsBc8Release", "()Ljava/util/Map;", "getLocalizationByTier$purchases_defaultsBc8Release$annotations", "getLocalizationByTier$purchases_defaultsBc8Release", "localizedConfiguration", "Lkotlin/Pair;", "Ljava/util/Locale;", "getLocalizedConfiguration", "()Lkotlin/Pair;", "getRevision", "()I", "getTemplateName$annotations", "getTemplateName", "tieredLocalizedConfiguration", "getTieredLocalizedConfiguration", "getZeroDecimalPlaceCountries$annotations", "getZeroDecimalPlaceCountries", "()Ljava/util/List;", "configForLocale", "requiredLocale", "copy", "locales", "tieredConfigForLocale", "tieredConfigForLocales", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "Configuration", "LocalizedConfiguration", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PaywallData {
    private static final KSerializer[] $childSerializers;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final URL assetBaseURL;
    private final Configuration config;
    private final String defaultLocale;
    private final String id;
    private final Map<String, LocalizedConfiguration> localization;
    private final Map<String, Map<String, LocalizedConfiguration>> localizationByTier;
    private final int revision;
    private final String templateName;
    private final List<String> zeroDecimalPlaceCountries;

    public static /* synthetic */ void getAssetBaseURL$annotations() {
    }

    public static /* synthetic */ void getDefaultLocale$annotations() {
    }

    public static /* synthetic */ void getLocalization$purchases_defaultsBc8Release$annotations() {
    }

    public static /* synthetic */ void getLocalizationByTier$purchases_defaultsBc8Release$annotations() {
    }

    public static /* synthetic */ void getTemplateName$annotations() {
    }

    public static /* synthetic */ void getZeroDecimalPlaceCountries$annotations() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaywallData)) {
            return false;
        }
        PaywallData paywallData = (PaywallData) obj;
        return Intrinsics.areEqual(this.id, paywallData.id) && Intrinsics.areEqual(this.templateName, paywallData.templateName) && Intrinsics.areEqual(this.config, paywallData.config) && Intrinsics.areEqual(this.assetBaseURL, paywallData.assetBaseURL) && this.revision == paywallData.revision && Intrinsics.areEqual(this.localization, paywallData.localization) && Intrinsics.areEqual(this.localizationByTier, paywallData.localizationByTier) && Intrinsics.areEqual(this.zeroDecimalPlaceCountries, paywallData.zeroDecimalPlaceCountries) && Intrinsics.areEqual(this.defaultLocale, paywallData.defaultLocale);
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (((((((((((((((str == null ? 0 : str.hashCode()) * 31) + this.templateName.hashCode()) * 31) + this.config.hashCode()) * 31) + this.assetBaseURL.hashCode()) * 31) + this.revision) * 31) + this.localization.hashCode()) * 31) + this.localizationByTier.hashCode()) * 31) + this.zeroDecimalPlaceCountries.hashCode()) * 31;
        String str2 = this.defaultLocale;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "PaywallData(id=" + this.id + ", templateName=" + this.templateName + ", config=" + this.config + ", assetBaseURL=" + this.assetBaseURL + ", revision=" + this.revision + ", localization=" + this.localization + ", localizationByTier=" + this.localizationByTier + ", zeroDecimalPlaceCountries=" + this.zeroDecimalPlaceCountries + ", defaultLocale=" + this.defaultLocale + ')';
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/PaywallData$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/PaywallData;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer serializer() {
            return PaywallData$$serializer.INSTANCE;
        }
    }

    static {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        PaywallData$LocalizedConfiguration$$serializer paywallData$LocalizedConfiguration$$serializer = PaywallData$LocalizedConfiguration$$serializer.INSTANCE;
        $childSerializers = new KSerializer[]{null, null, null, null, null, new LinkedHashMapSerializer(stringSerializer, paywallData$LocalizedConfiguration$$serializer), new LinkedHashMapSerializer(stringSerializer, new LinkedHashMapSerializer(stringSerializer, paywallData$LocalizedConfiguration$$serializer)), null, null};
    }

    @Deprecated
    public /* synthetic */ PaywallData(int i, String str, String str2, Configuration configuration, URL url, int i2, Map map, Map map2, List list, String str3, SerializationConstructorMarker serializationConstructorMarker) {
        if (46 != (i & 46)) {
            PluginExceptionsKt.throwMissingFieldException(i, 46, PaywallData$$serializer.INSTANCE.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.id = null;
        } else {
            this.id = str;
        }
        this.templateName = str2;
        this.config = configuration;
        this.assetBaseURL = url;
        if ((i & 16) == 0) {
            this.revision = 0;
        } else {
            this.revision = i2;
        }
        this.localization = map;
        if ((i & 64) == 0) {
            this.localizationByTier = MapsKt.emptyMap();
        } else {
            this.localizationByTier = map2;
        }
        if ((i & 128) == 0) {
            this.zeroDecimalPlaceCountries = CollectionsKt.emptyList();
        } else {
            this.zeroDecimalPlaceCountries = list;
        }
        if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) == 0) {
            this.defaultLocale = null;
        } else {
            this.defaultLocale = str3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PaywallData(String str, String templateName, Configuration config, URL assetBaseURL, int i, Map<String, LocalizedConfiguration> localization, Map<String, ? extends Map<String, LocalizedConfiguration>> localizationByTier, List<String> zeroDecimalPlaceCountries, String str2) {
        Intrinsics.checkNotNullParameter(templateName, "templateName");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(assetBaseURL, "assetBaseURL");
        Intrinsics.checkNotNullParameter(localization, "localization");
        Intrinsics.checkNotNullParameter(localizationByTier, "localizationByTier");
        Intrinsics.checkNotNullParameter(zeroDecimalPlaceCountries, "zeroDecimalPlaceCountries");
        this.id = str;
        this.templateName = templateName;
        this.config = config;
        this.assetBaseURL = assetBaseURL;
        this.revision = i;
        this.localization = localization;
        this.localizationByTier = localizationByTier;
        this.zeroDecimalPlaceCountries = zeroDecimalPlaceCountries;
        this.defaultLocale = str2;
    }

    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(PaywallData self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer[] kSerializerArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.id != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.id);
        }
        output.encodeStringElement(serialDesc, 1, self.templateName);
        output.encodeSerializableElement(serialDesc, 2, PaywallData$Configuration$$serializer.INSTANCE, self.config);
        output.encodeSerializableElement(serialDesc, 3, URLSerializer.INSTANCE, self.assetBaseURL);
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.revision != 0) {
            output.encodeIntElement(serialDesc, 4, self.revision);
        }
        output.encodeSerializableElement(serialDesc, 5, kSerializerArr[5], self.localization);
        if (output.shouldEncodeElementDefault(serialDesc, 6) || !Intrinsics.areEqual(self.localizationByTier, MapsKt.emptyMap())) {
            output.encodeSerializableElement(serialDesc, 6, kSerializerArr[6], self.localizationByTier);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || !Intrinsics.areEqual(self.zeroDecimalPlaceCountries, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 7, GoogleListSerializer.INSTANCE, self.zeroDecimalPlaceCountries);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 8) && self.defaultLocale == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.defaultLocale);
    }

    public final String getId() {
        return this.id;
    }

    public final String getTemplateName() {
        return this.templateName;
    }

    public final Configuration getConfig() {
        return this.config;
    }

    public final URL getAssetBaseURL() {
        return this.assetBaseURL;
    }

    public final int getRevision() {
        return this.revision;
    }

    public final Map<String, LocalizedConfiguration> getLocalization$purchases_defaultsBc8Release() {
        return this.localization;
    }

    public final Map<String, Map<String, LocalizedConfiguration>> getLocalizationByTier$purchases_defaultsBc8Release() {
        return this.localizationByTier;
    }

    public /* synthetic */ PaywallData(String str, String str2, Configuration configuration, URL url, int i, Map map, Map map2, List list, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, str2, configuration, url, (i2 & 16) != 0 ? 0 : i, map, (i2 & 64) != 0 ? MapsKt.emptyMap() : map2, (i2 & 128) != 0 ? CollectionsKt.emptyList() : list, (i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? null : str3);
    }

    public final List<String> getZeroDecimalPlaceCountries() {
        return this.zeroDecimalPlaceCountries;
    }

    public final String getDefaultLocale() {
        return this.defaultLocale;
    }

    public final Pair<Locale, LocalizedConfiguration> getLocalizedConfiguration() {
        return localizedConfiguration(LocaleExtensionsKt.getDefaultLocales());
    }

    public final Pair<Locale, LocalizedConfiguration> localizedConfiguration(List<Locale> locales) {
        Object next;
        Intrinsics.checkNotNullParameter(locales, "locales");
        Iterator<Locale> it = locales.iterator();
        while (it.hasNext()) {
            Locale localeConvertToCorrectlyFormattedLocale = LocaleExtensionsKt.convertToCorrectlyFormattedLocale(it.next());
            LocalizedConfiguration localizedConfigurationConfigForLocale = configForLocale(localeConvertToCorrectlyFormattedLocale);
            if (localizedConfigurationConfigForLocale != null) {
                return TuplesKt.to(localeConvertToCorrectlyFormattedLocale, localizedConfigurationConfigForLocale);
            }
        }
        String str = this.defaultLocale;
        if (str != null) {
            Iterator<T> it2 = this.localization.entrySet().iterator();
            do {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
            } while (!Intrinsics.areEqual(LocaleExtensionsKt.toLocale((String) ((Map.Entry) next).getKey()), LocaleExtensionsKt.toLocale(str)));
            Map.Entry entry = (Map.Entry) next;
            if (entry != null) {
                return TuplesKt.to(LocaleExtensionsKt.toLocale((String) entry.getKey()), entry.getValue());
            }
        }
        Map.Entry entry2 = (Map.Entry) CollectionsKt.first(this.localization.entrySet());
        return TuplesKt.to(LocaleExtensionsKt.toLocale((String) entry2.getKey()), entry2.getValue());
    }

    public final LocalizedConfiguration configForLocale(Locale requiredLocale) {
        Object next;
        Intrinsics.checkNotNullParameter(requiredLocale, "requiredLocale");
        LocalizedConfiguration localizedConfiguration = this.localization.get(requiredLocale.toString());
        if (localizedConfiguration != null) {
            return localizedConfiguration;
        }
        Iterator<T> it = this.localization.entrySet().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!LocaleExtensionsKt.sharedLanguageCodeWith(requiredLocale, LocaleExtensionsKt.toLocale((String) ((Map.Entry) next).getKey())));
        Map.Entry entry = (Map.Entry) next;
        if (entry != null) {
            return (LocalizedConfiguration) entry.getValue();
        }
        return null;
    }

    public final Pair<Locale, Map<String, LocalizedConfiguration>> getTieredLocalizedConfiguration() {
        return tieredConfigForLocales(LocaleExtensionsKt.getDefaultLocales());
    }

    private final Pair<Locale, Map<String, LocalizedConfiguration>> tieredConfigForLocales(List<Locale> locales) {
        Object next;
        Iterator<Locale> it = locales.iterator();
        while (it.hasNext()) {
            Locale localeConvertToCorrectlyFormattedLocale = LocaleExtensionsKt.convertToCorrectlyFormattedLocale(it.next());
            Map<String, LocalizedConfiguration> mapTieredConfigForLocale = tieredConfigForLocale(localeConvertToCorrectlyFormattedLocale);
            if (mapTieredConfigForLocale != null) {
                return TuplesKt.to(localeConvertToCorrectlyFormattedLocale, mapTieredConfigForLocale);
            }
        }
        String str = this.defaultLocale;
        if (str != null) {
            Iterator<T> it2 = this.localizationByTier.entrySet().iterator();
            do {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
            } while (!Intrinsics.areEqual(LocaleExtensionsKt.toLocale((String) ((Map.Entry) next).getKey()), LocaleExtensionsKt.toLocale(str)));
            Map.Entry entry = (Map.Entry) next;
            if (entry != null) {
                return TuplesKt.to(LocaleExtensionsKt.toLocale((String) entry.getKey()), entry.getValue());
            }
        }
        Map.Entry entry2 = (Map.Entry) CollectionsKt.first(this.localizationByTier.entrySet());
        return TuplesKt.to(LocaleExtensionsKt.toLocale((String) entry2.getKey()), entry2.getValue());
    }

    public final Map<String, LocalizedConfiguration> tieredConfigForLocale(Locale requiredLocale) {
        Object next;
        Intrinsics.checkNotNullParameter(requiredLocale, "requiredLocale");
        Map<String, LocalizedConfiguration> map = this.localizationByTier.get(requiredLocale.toString());
        if (map != null) {
            return map;
        }
        Iterator<T> it = this.localizationByTier.entrySet().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!LocaleExtensionsKt.sharedLanguageCodeWith(requiredLocale, LocaleExtensionsKt.toLocale((String) ((Map.Entry) next).getKey())));
        Map.Entry entry = (Map.Entry) next;
        if (entry != null) {
            return (Map) entry.getValue();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PaywallData copy$default(PaywallData paywallData, String str, Configuration configuration, URL url, int i, Map map, Map map2, List list, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = paywallData.templateName;
        }
        if ((i2 & 2) != 0) {
            configuration = paywallData.config;
        }
        if ((i2 & 4) != 0) {
            url = paywallData.assetBaseURL;
        }
        if ((i2 & 8) != 0) {
            i = paywallData.revision;
        }
        if ((i2 & 16) != 0) {
            map = paywallData.localization;
        }
        if ((i2 & 32) != 0) {
            map2 = paywallData.localizationByTier;
        }
        if ((i2 & 64) != 0) {
            list = paywallData.zeroDecimalPlaceCountries;
        }
        if ((i2 & 128) != 0) {
            str2 = paywallData.defaultLocale;
        }
        List list2 = list;
        String str3 = str2;
        Map map3 = map;
        Map map4 = map2;
        return paywallData.copy(str, configuration, url, i, map3, map4, list2, str3);
    }

    @InternalRevenueCatAPI
    public final PaywallData copy(String templateName, Configuration config, URL assetBaseURL, int revision, Map<String, LocalizedConfiguration> localization, Map<String, ? extends Map<String, LocalizedConfiguration>> localizationByTier, List<String> zeroDecimalPlaceCountries, String defaultLocale) {
        Intrinsics.checkNotNullParameter(templateName, "templateName");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(assetBaseURL, "assetBaseURL");
        Intrinsics.checkNotNullParameter(localization, "localization");
        Intrinsics.checkNotNullParameter(localizationByTier, "localizationByTier");
        Intrinsics.checkNotNullParameter(zeroDecimalPlaceCountries, "zeroDecimalPlaceCountries");
        return new PaywallData((String) null, templateName, config, assetBaseURL, revision, localization, localizationByTier, zeroDecimalPlaceCountries, defaultLocale, 1, (DefaultConstructorMarker) null);
    }

    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 L2\u00020\u0001:\u0006IJKLMNB\u009f\u0001\b\u0016\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0015BÑ\u0001\b\u0011\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0010\b\u0001\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u0007\u0012\u0016\b\u0001\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t\u0012\b\b\u0001\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0001\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0016\b\u0001\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\u0002\u0010\u001dB»\u0001\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0007\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u001eJÀ\u0001\u0010@\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u0007J&\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u00002\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020GHÁ\u0001¢\u0006\u0002\bHR\u001c\u0010\u000f\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R*\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010 \u001a\u0004\b&\u0010'R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010 \u001a\u0004\b)\u0010*R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010 \u001a\u0004\b,\u0010*R\u001c\u0010\u0011\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010 \u001a\u0004\b.\u0010\"R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b/\u00100R*\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b1\u0010 \u001a\u0004\b2\u0010'R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00078\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b3\u0010 \u001a\u0004\b4\u00100R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00078\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b5\u0010 \u001a\u0004\b6\u00100R\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b7\u0010 \u001a\u0004\b8\u00109R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b:\u0010 \u001a\u0004\b;\u0010<R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b=\u0010 \u001a\u0004\b>\u0010<R\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u00109¨\u0006O"}, d2 = {"Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration;", "", "packageIds", "", "", "defaultPackage", "images", "Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Images;", "imagesByTier", "", LinearGradientManager.PROP_COLORS, "Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$ColorInformation;", "colorsByTier", "tiers", "Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Tier;", "blurredBackgroundImage", "", "displayRestorePurchases", "termsOfServiceURL", "Ljava/net/URL;", "privacyURL", "(Ljava/util/List;Ljava/lang/String;Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Images;Ljava/util/Map;Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$ColorInformation;Ljava/util/Map;Ljava/util/List;ZZLjava/net/URL;Ljava/net/URL;)V", "seen1", "", "imagesWebp", "legacyImages", "defaultTier", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/lang/String;Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Images;Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Images;Ljava/util/Map;ZZLjava/net/URL;Ljava/net/URL;Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$ColorInformation;Ljava/util/Map;Ljava/util/List;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/util/List;Ljava/lang/String;Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Images;Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Images;Ljava/util/Map;ZZLjava/net/URL;Ljava/net/URL;Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$ColorInformation;Ljava/util/Map;Ljava/util/List;Ljava/lang/String;)V", "getBlurredBackgroundImage$annotations", "()V", "getBlurredBackgroundImage", "()Z", "getColors", "()Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$ColorInformation;", "getColorsByTier$annotations", "getColorsByTier", "()Ljava/util/Map;", "getDefaultPackage$annotations", "getDefaultPackage", "()Ljava/lang/String;", "getDefaultTier$annotations", "getDefaultTier", "getDisplayRestorePurchases$annotations", "getDisplayRestorePurchases", "getImages", "()Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Images;", "getImagesByTier$annotations", "getImagesByTier", "getImagesWebp$purchases_defaultsBc8Release$annotations", "getImagesWebp$purchases_defaultsBc8Release", "getLegacyImages$purchases_defaultsBc8Release$annotations", "getLegacyImages$purchases_defaultsBc8Release", "getPackageIds$annotations", "getPackageIds", "()Ljava/util/List;", "getPrivacyURL$annotations", "getPrivacyURL", "()Ljava/net/URL;", "getTermsOfServiceURL$annotations", "getTermsOfServiceURL", "getTiers", "copy", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "ColorInformation", "Colors", "Companion", "Images", "Tier", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Configuration {
        private static final KSerializer[] $childSerializers;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean blurredBackgroundImage;
        private final ColorInformation colors;
        private final Map<String, ColorInformation> colorsByTier;
        private final String defaultPackage;
        private final String defaultTier;
        private final boolean displayRestorePurchases;
        private final Map<String, Images> imagesByTier;
        private final Images imagesWebp;
        private final Images legacyImages;
        private final List<String> packageIds;
        private final URL privacyURL;
        private final URL termsOfServiceURL;
        private final List<Tier> tiers;

        public static /* synthetic */ void getBlurredBackgroundImage$annotations() {
        }

        public static /* synthetic */ void getColorsByTier$annotations() {
        }

        public static /* synthetic */ void getDefaultPackage$annotations() {
        }

        public static /* synthetic */ void getDefaultTier$annotations() {
        }

        public static /* synthetic */ void getDisplayRestorePurchases$annotations() {
        }

        public static /* synthetic */ void getImagesByTier$annotations() {
        }

        public static /* synthetic */ void getImagesWebp$purchases_defaultsBc8Release$annotations() {
        }

        public static /* synthetic */ void getLegacyImages$purchases_defaultsBc8Release$annotations() {
        }

        public static /* synthetic */ void getPackageIds$annotations() {
        }

        public static /* synthetic */ void getPrivacyURL$annotations() {
        }

        public static /* synthetic */ void getTermsOfServiceURL$annotations() {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Configuration)) {
                return false;
            }
            Configuration configuration = (Configuration) obj;
            return Intrinsics.areEqual(this.packageIds, configuration.packageIds) && Intrinsics.areEqual(this.defaultPackage, configuration.defaultPackage) && Intrinsics.areEqual(this.imagesWebp, configuration.imagesWebp) && Intrinsics.areEqual(this.legacyImages, configuration.legacyImages) && Intrinsics.areEqual(this.imagesByTier, configuration.imagesByTier) && this.blurredBackgroundImage == configuration.blurredBackgroundImage && this.displayRestorePurchases == configuration.displayRestorePurchases && Intrinsics.areEqual(this.termsOfServiceURL, configuration.termsOfServiceURL) && Intrinsics.areEqual(this.privacyURL, configuration.privacyURL) && Intrinsics.areEqual(this.colors, configuration.colors) && Intrinsics.areEqual(this.colorsByTier, configuration.colorsByTier) && Intrinsics.areEqual(this.tiers, configuration.tiers) && Intrinsics.areEqual(this.defaultTier, configuration.defaultTier);
        }

        public int hashCode() {
            int iHashCode = this.packageIds.hashCode() * 31;
            String str = this.defaultPackage;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            Images images = this.imagesWebp;
            int iHashCode3 = (iHashCode2 + (images == null ? 0 : images.hashCode())) * 31;
            Images images2 = this.legacyImages;
            int iHashCode4 = (iHashCode3 + (images2 == null ? 0 : images2.hashCode())) * 31;
            Map<String, Images> map = this.imagesByTier;
            int iHashCode5 = (((((iHashCode4 + (map == null ? 0 : map.hashCode())) * 31) + Boolean.hashCode(this.blurredBackgroundImage)) * 31) + Boolean.hashCode(this.displayRestorePurchases)) * 31;
            URL url = this.termsOfServiceURL;
            int iHashCode6 = (iHashCode5 + (url == null ? 0 : url.hashCode())) * 31;
            URL url2 = this.privacyURL;
            int iHashCode7 = (((iHashCode6 + (url2 == null ? 0 : url2.hashCode())) * 31) + this.colors.hashCode()) * 31;
            Map<String, ColorInformation> map2 = this.colorsByTier;
            int iHashCode8 = (iHashCode7 + (map2 == null ? 0 : map2.hashCode())) * 31;
            List<Tier> list = this.tiers;
            int iHashCode9 = (iHashCode8 + (list == null ? 0 : list.hashCode())) * 31;
            String str2 = this.defaultTier;
            return iHashCode9 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "Configuration(packageIds=" + this.packageIds + ", defaultPackage=" + this.defaultPackage + ", imagesWebp=" + this.imagesWebp + ", legacyImages=" + this.legacyImages + ", imagesByTier=" + this.imagesByTier + ", blurredBackgroundImage=" + this.blurredBackgroundImage + ", displayRestorePurchases=" + this.displayRestorePurchases + ", termsOfServiceURL=" + this.termsOfServiceURL + ", privacyURL=" + this.privacyURL + ", colors=" + this.colors + ", colorsByTier=" + this.colorsByTier + ", tiers=" + this.tiers + ", defaultTier=" + this.defaultTier + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer serializer() {
                return PaywallData$Configuration$$serializer.INSTANCE;
            }
        }

        static {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            $childSerializers = new KSerializer[]{new ArrayListSerializer(stringSerializer), null, null, null, new LinkedHashMapSerializer(stringSerializer, PaywallData$Configuration$Images$$serializer.INSTANCE), null, null, null, null, null, new LinkedHashMapSerializer(stringSerializer, PaywallData$Configuration$ColorInformation$$serializer.INSTANCE), new ArrayListSerializer(PaywallData$Configuration$Tier$$serializer.INSTANCE), null};
        }

        @Deprecated
        public /* synthetic */ Configuration(int i, List list, String str, Images images, Images images2, Map map, boolean z, boolean z2, URL url, URL url2, ColorInformation colorInformation, Map map2, List list2, String str2, SerializationConstructorMarker serializationConstructorMarker) {
            if (512 != (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING)) {
                PluginExceptionsKt.throwMissingFieldException(i, IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING, PaywallData$Configuration$$serializer.INSTANCE.getDescriptor());
            }
            this.packageIds = (i & 1) == 0 ? CollectionsKt.emptyList() : list;
            if ((i & 2) == 0) {
                this.defaultPackage = null;
            } else {
                this.defaultPackage = str;
            }
            if ((i & 4) == 0) {
                this.imagesWebp = null;
            } else {
                this.imagesWebp = images;
            }
            if ((i & 8) == 0) {
                this.legacyImages = null;
            } else {
                this.legacyImages = images2;
            }
            if ((i & 16) == 0) {
                this.imagesByTier = null;
            } else {
                this.imagesByTier = map;
            }
            if ((i & 32) == 0) {
                this.blurredBackgroundImage = false;
            } else {
                this.blurredBackgroundImage = z;
            }
            if ((i & 64) == 0) {
                this.displayRestorePurchases = true;
            } else {
                this.displayRestorePurchases = z2;
            }
            if ((i & 128) == 0) {
                this.termsOfServiceURL = null;
            } else {
                this.termsOfServiceURL = url;
            }
            if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) == 0) {
                this.privacyURL = null;
            } else {
                this.privacyURL = url2;
            }
            this.colors = colorInformation;
            if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) == 0) {
                this.colorsByTier = null;
            } else {
                this.colorsByTier = map2;
            }
            if ((i & 2048) == 0) {
                this.tiers = null;
            } else {
                this.tiers = list2;
            }
            if ((i & 4096) == 0) {
                this.defaultTier = null;
            } else {
                this.defaultTier = str2;
            }
        }

        public Configuration(List<String> packageIds, String str, Images images, Images images2, Map<String, Images> map, boolean z, boolean z2, URL url, URL url2, ColorInformation colors, Map<String, ColorInformation> map2, List<Tier> list, String str2) {
            Intrinsics.checkNotNullParameter(packageIds, "packageIds");
            Intrinsics.checkNotNullParameter(colors, "colors");
            this.packageIds = packageIds;
            this.defaultPackage = str;
            this.imagesWebp = images;
            this.legacyImages = images2;
            this.imagesByTier = map;
            this.blurredBackgroundImage = z;
            this.displayRestorePurchases = z2;
            this.termsOfServiceURL = url;
            this.privacyURL = url2;
            this.colors = colors;
            this.colorsByTier = map2;
            this.tiers = list;
            this.defaultTier = str2;
        }

        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Configuration self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer[] kSerializerArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.packageIds, CollectionsKt.emptyList())) {
                output.encodeSerializableElement(serialDesc, 0, kSerializerArr[0], self.packageIds);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.defaultPackage != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.defaultPackage);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.imagesWebp != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, PaywallData$Configuration$Images$$serializer.INSTANCE, self.imagesWebp);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.legacyImages != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, PaywallData$Configuration$Images$$serializer.INSTANCE, self.legacyImages);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.imagesByTier != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, kSerializerArr[4], self.imagesByTier);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.blurredBackgroundImage) {
                output.encodeBooleanElement(serialDesc, 5, self.blurredBackgroundImage);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 6) || !self.displayRestorePurchases) {
                output.encodeBooleanElement(serialDesc, 6, self.displayRestorePurchases);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 7) || self.termsOfServiceURL != null) {
                output.encodeNullableSerializableElement(serialDesc, 7, OptionalURLSerializer.INSTANCE, self.termsOfServiceURL);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 8) || self.privacyURL != null) {
                output.encodeNullableSerializableElement(serialDesc, 8, OptionalURLSerializer.INSTANCE, self.privacyURL);
            }
            output.encodeSerializableElement(serialDesc, 9, PaywallData$Configuration$ColorInformation$$serializer.INSTANCE, self.colors);
            if (output.shouldEncodeElementDefault(serialDesc, 10) || self.colorsByTier != null) {
                output.encodeNullableSerializableElement(serialDesc, 10, kSerializerArr[10], self.colorsByTier);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 11) || self.tiers != null) {
                output.encodeNullableSerializableElement(serialDesc, 11, kSerializerArr[11], self.tiers);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 12) && self.defaultTier == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 12, StringSerializer.INSTANCE, self.defaultTier);
        }

        public /* synthetic */ Configuration(List list, String str, Images images, Images images2, Map map, boolean z, boolean z2, URL url, URL url2, ColorInformation colorInformation, Map map2, List list2, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((List<String>) ((i & 1) != 0 ? CollectionsKt.emptyList() : list), (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : images, (i & 8) != 0 ? null : images2, (Map<String, Images>) ((i & 16) != 0 ? null : map), (i & 32) != 0 ? false : z, (i & 64) != 0 ? true : z2, (i & 128) != 0 ? null : url, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? null : url2, colorInformation, (Map<String, ColorInformation>) ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? null : map2), (List<Tier>) ((i & 2048) != 0 ? null : list2), (i & 4096) != 0 ? null : str2);
        }

        public final List<String> getPackageIds() {
            return this.packageIds;
        }

        public final String getDefaultPackage() {
            return this.defaultPackage;
        }

        /* JADX INFO: renamed from: getImagesWebp$purchases_defaultsBc8Release, reason: from getter */
        public final Images getImagesWebp() {
            return this.imagesWebp;
        }

        /* JADX INFO: renamed from: getLegacyImages$purchases_defaultsBc8Release, reason: from getter */
        public final Images getLegacyImages() {
            return this.legacyImages;
        }

        public final Map<String, Images> getImagesByTier() {
            return this.imagesByTier;
        }

        public final boolean getBlurredBackgroundImage() {
            return this.blurredBackgroundImage;
        }

        public final boolean getDisplayRestorePurchases() {
            return this.displayRestorePurchases;
        }

        public final URL getTermsOfServiceURL() {
            return this.termsOfServiceURL;
        }

        public final URL getPrivacyURL() {
            return this.privacyURL;
        }

        public final ColorInformation getColors() {
            return this.colors;
        }

        public final Map<String, ColorInformation> getColorsByTier() {
            return this.colorsByTier;
        }

        public final List<Tier> getTiers() {
            return this.tiers;
        }

        public final String getDefaultTier() {
            return this.defaultTier;
        }

        public /* synthetic */ Configuration(List list, String str, Images images, Map map, ColorInformation colorInformation, Map map2, List list2, boolean z, boolean z2, URL url, URL url2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, (i & 2) != 0 ? null : str, images, (i & 8) != 0 ? null : map, colorInformation, (i & 32) != 0 ? null : map2, (i & 64) != 0 ? null : list2, (i & 128) != 0 ? false : z, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? true : z2, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? null : url, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? null : url2);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Configuration(List<String> packageIds, String str, Images images, Map<String, Images> map, ColorInformation colors, Map<String, ColorInformation> map2, List<Tier> list, boolean z, boolean z2, URL url, URL url2) {
            this(packageIds, str, images, (Images) null, map, z, z2, url, url2, colors, map2, list, (String) null, 4104, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(packageIds, "packageIds");
            Intrinsics.checkNotNullParameter(images, "images");
            Intrinsics.checkNotNullParameter(colors, "colors");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Configuration copy$default(Configuration configuration, List list, String str, Images images, Images images2, Map map, boolean z, boolean z2, URL url, URL url2, ColorInformation colorInformation, Map map2, List list2, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = configuration.packageIds;
            }
            return configuration.copy(list, (i & 2) != 0 ? configuration.defaultPackage : str, (i & 4) != 0 ? configuration.imagesWebp : images, (i & 8) != 0 ? configuration.legacyImages : images2, (i & 16) != 0 ? configuration.imagesByTier : map, (i & 32) != 0 ? configuration.blurredBackgroundImage : z, (i & 64) != 0 ? configuration.displayRestorePurchases : z2, (i & 128) != 0 ? configuration.termsOfServiceURL : url, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? configuration.privacyURL : url2, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? configuration.colors : colorInformation, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? configuration.colorsByTier : map2, (i & 2048) != 0 ? configuration.tiers : list2, (i & 4096) != 0 ? configuration.defaultTier : str2);
        }

        @InternalRevenueCatAPI
        public final Configuration copy(List<String> packageIds, String defaultPackage, Images imagesWebp, Images legacyImages, Map<String, Images> imagesByTier, boolean blurredBackgroundImage, boolean displayRestorePurchases, URL termsOfServiceURL, URL privacyURL, ColorInformation colors, Map<String, ColorInformation> colorsByTier, List<Tier> tiers, String defaultTier) {
            Intrinsics.checkNotNullParameter(packageIds, "packageIds");
            Intrinsics.checkNotNullParameter(colors, "colors");
            return new Configuration(packageIds, defaultPackage, imagesWebp, legacyImages, imagesByTier, blurredBackgroundImage, displayRestorePurchases, termsOfServiceURL, privacyURL, colors, colorsByTier, tiers, defaultTier);
        }

        public final Images getImages() {
            String header;
            String background;
            String icon;
            Images images = this.imagesWebp;
            String icon2 = null;
            if (images == null || (header = images.getHeader()) == null) {
                Images images2 = this.legacyImages;
                header = images2 != null ? images2.getHeader() : null;
            }
            Images images3 = this.imagesWebp;
            if (images3 == null || (background = images3.getBackground()) == null) {
                Images images4 = this.legacyImages;
                background = images4 != null ? images4.getBackground() : null;
            }
            Images images5 = this.imagesWebp;
            if (images5 == null || (icon = images5.getIcon()) == null) {
                Images images6 = this.legacyImages;
                if (images6 != null) {
                    icon2 = images6.getIcon();
                }
            } else {
                icon2 = icon;
            }
            return new Images(header, background, icon2);
        }

        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 !2\u00020\u0001:\u0002 !B=\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB)\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ&\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eHÁ\u0001¢\u0006\u0002\b\u001fR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\r8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013¨\u0006\""}, d2 = {"Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Images;", "", "seen1", "", "header", "", AppStateModule.APP_STATE_BACKGROUND, "icon", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "all", "", "getAll$purchases_defaultsBc8Release", "()Ljava/util/List;", "getBackground$annotations", "()V", "getBackground", "()Ljava/lang/String;", "getHeader$annotations", "getHeader", "getIcon$annotations", "getIcon", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Images {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final String background;
            private final String header;
            private final String icon;

            public Images() {
                this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ void getBackground$annotations() {
            }

            public static /* synthetic */ void getHeader$annotations() {
            }

            public static /* synthetic */ void getIcon$annotations() {
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Images)) {
                    return false;
                }
                Images images = (Images) obj;
                return Intrinsics.areEqual(this.header, images.header) && Intrinsics.areEqual(this.background, images.background) && Intrinsics.areEqual(this.icon, images.icon);
            }

            public int hashCode() {
                String str = this.header;
                int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.background;
                int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.icon;
                return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
            }

            public String toString() {
                return "Images(header=" + this.header + ", background=" + this.background + ", icon=" + this.icon + ')';
            }

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Images$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Images;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer serializer() {
                    return PaywallData$Configuration$Images$$serializer.INSTANCE;
                }
            }

            @Deprecated
            public /* synthetic */ Images(int i, String str, String str2, String str3, SerializationConstructorMarker serializationConstructorMarker) {
                if ((i & 1) == 0) {
                    this.header = null;
                } else {
                    this.header = str;
                }
                if ((i & 2) == 0) {
                    this.background = null;
                } else {
                    this.background = str2;
                }
                if ((i & 4) == 0) {
                    this.icon = null;
                } else {
                    this.icon = str3;
                }
            }

            public Images(String str, String str2, String str3) {
                this.header = str;
                this.background = str2;
                this.icon = str3;
            }

            public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Images self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.header != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, EmptyStringToNullSerializer.INSTANCE, self.header);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.background != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, EmptyStringToNullSerializer.INSTANCE, self.background);
                }
                if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.icon == null) {
                    return;
                }
                output.encodeNullableSerializableElement(serialDesc, 2, EmptyStringToNullSerializer.INSTANCE, self.icon);
            }

            public /* synthetic */ Images(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
            }

            public final String getHeader() {
                return this.header;
            }

            public final String getBackground() {
                return this.background;
            }

            public final String getIcon() {
                return this.icon;
            }

            public final List<String> getAll$purchases_defaultsBc8Release() {
                return CollectionsKt.listOfNotNull((Object[]) new String[]{this.header, this.background, this.icon});
            }
        }

        @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001d\u001eBA\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0001\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\fJ&\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bHÁ\u0001¢\u0006\u0002\b\u001cR\u001c\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Tier;", "", "seen1", "", DiagnosticsEntry.ID_KEY, "", "packageIds", "", "defaultPackageId", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/util/List;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getDefaultPackageId$annotations", "()V", "getDefaultPackageId", "()Ljava/lang/String;", "getId", "getPackageIds$annotations", "getPackageIds", "()Ljava/util/List;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Tier {
            private final String defaultPackageId;
            private final String id;
            private final List<String> packageIds;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private static final KSerializer[] $childSerializers = {null, new ArrayListSerializer(StringSerializer.INSTANCE), null};

            public static /* synthetic */ void getDefaultPackageId$annotations() {
            }

            public static /* synthetic */ void getPackageIds$annotations() {
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Tier)) {
                    return false;
                }
                Tier tier = (Tier) obj;
                return Intrinsics.areEqual(this.id, tier.id) && Intrinsics.areEqual(this.packageIds, tier.packageIds) && Intrinsics.areEqual(this.defaultPackageId, tier.defaultPackageId);
            }

            public int hashCode() {
                return (((this.id.hashCode() * 31) + this.packageIds.hashCode()) * 31) + this.defaultPackageId.hashCode();
            }

            public String toString() {
                return "Tier(id=" + this.id + ", packageIds=" + this.packageIds + ", defaultPackageId=" + this.defaultPackageId + ')';
            }

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Tier$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Tier;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer serializer() {
                    return PaywallData$Configuration$Tier$$serializer.INSTANCE;
                }
            }

            @Deprecated
            public /* synthetic */ Tier(int i, String str, List list, String str2, SerializationConstructorMarker serializationConstructorMarker) {
                if (7 != (i & 7)) {
                    PluginExceptionsKt.throwMissingFieldException(i, 7, PaywallData$Configuration$Tier$$serializer.INSTANCE.getDescriptor());
                }
                this.id = str;
                this.packageIds = list;
                this.defaultPackageId = str2;
            }

            public Tier(String id, List<String> packageIds, String defaultPackageId) {
                Intrinsics.checkNotNullParameter(id, "id");
                Intrinsics.checkNotNullParameter(packageIds, "packageIds");
                Intrinsics.checkNotNullParameter(defaultPackageId, "defaultPackageId");
                this.id = id;
                this.packageIds = packageIds;
                this.defaultPackageId = defaultPackageId;
            }

            public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Tier self, CompositeEncoder output, SerialDescriptor serialDesc) {
                KSerializer[] kSerializerArr = $childSerializers;
                output.encodeStringElement(serialDesc, 0, self.id);
                output.encodeSerializableElement(serialDesc, 1, kSerializerArr[1], self.packageIds);
                output.encodeStringElement(serialDesc, 2, self.defaultPackageId);
            }

            public final String getId() {
                return this.id;
            }

            public final List<String> getPackageIds() {
                return this.packageIds;
            }

            public final String getDefaultPackageId() {
                return this.defaultPackageId;
            }
        }

        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0002\u0016\u0017B-\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ&\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014HÁ\u0001¢\u0006\u0002\b\u0015R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$ColorInformation;", "", "seen1", "", "light", "Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Colors;", "dark", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Colors;Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Colors;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Colors;Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Colors;)V", "getDark", "()Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Colors;", "getLight", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class ColorInformation {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final Colors dark;
            private final Colors light;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof ColorInformation)) {
                    return false;
                }
                ColorInformation colorInformation = (ColorInformation) obj;
                return Intrinsics.areEqual(this.light, colorInformation.light) && Intrinsics.areEqual(this.dark, colorInformation.dark);
            }

            public int hashCode() {
                int iHashCode = this.light.hashCode() * 31;
                Colors colors = this.dark;
                return iHashCode + (colors == null ? 0 : colors.hashCode());
            }

            public String toString() {
                return "ColorInformation(light=" + this.light + ", dark=" + this.dark + ')';
            }

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$ColorInformation$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$ColorInformation;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer serializer() {
                    return PaywallData$Configuration$ColorInformation$$serializer.INSTANCE;
                }
            }

            @Deprecated
            public /* synthetic */ ColorInformation(int i, Colors colors, Colors colors2, SerializationConstructorMarker serializationConstructorMarker) {
                if (1 != (i & 1)) {
                    PluginExceptionsKt.throwMissingFieldException(i, 1, PaywallData$Configuration$ColorInformation$$serializer.INSTANCE.getDescriptor());
                }
                this.light = colors;
                if ((i & 2) == 0) {
                    this.dark = null;
                } else {
                    this.dark = colors2;
                }
            }

            public ColorInformation(Colors light, Colors colors) {
                Intrinsics.checkNotNullParameter(light, "light");
                this.light = light;
                this.dark = colors;
            }

            public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(ColorInformation self, CompositeEncoder output, SerialDescriptor serialDesc) {
                PaywallData$Configuration$Colors$$serializer paywallData$Configuration$Colors$$serializer = PaywallData$Configuration$Colors$$serializer.INSTANCE;
                output.encodeSerializableElement(serialDesc, 0, paywallData$Configuration$Colors$$serializer, self.light);
                if (!output.shouldEncodeElementDefault(serialDesc, 1) && self.dark == null) {
                    return;
                }
                output.encodeNullableSerializableElement(serialDesc, 1, paywallData$Configuration$Colors$$serializer, self.dark);
            }

            public /* synthetic */ ColorInformation(Colors colors, Colors colors2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(colors, (i & 2) != 0 ? null : colors2);
            }

            public final Colors getLight() {
                return this.light;
            }

            public final Colors getDark() {
                return this.dark;
            }
        }

        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 A2\u00020\u0001:\u0002@ABÍ\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016B©\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0017J&\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u00002\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>HÁ\u0001¢\u0006\u0002\b?R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001d\u0010\u001bR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u001bR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0019\u001a\u0004\b!\u0010\u001bR\u001c\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0019\u001a\u0004\b#\u0010\u001bR\u001c\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u0019\u001a\u0004\b%\u0010\u001bR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u0019\u001a\u0004\b'\u0010\u001bR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010\u0019\u001a\u0004\b)\u0010\u001bR\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u0019\u001a\u0004\b+\u0010\u001bR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010\u0019\u001a\u0004\b-\u0010\u001bR\u001e\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010\u0019\u001a\u0004\b/\u0010\u001bR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010\u0019\u001a\u0004\b1\u0010\u001bR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b2\u0010\u0019\u001a\u0004\b3\u0010\u001bR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b4\u0010\u0019\u001a\u0004\b5\u0010\u001bR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b6\u0010\u0019\u001a\u0004\b7\u0010\u001b¨\u0006B"}, d2 = {"Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Colors;", "", "seen1", "", AppStateModule.APP_STATE_BACKGROUND, "Lcom/revenuecat/purchases/paywalls/PaywallColor;", "text1", "text2", "text3", "callToActionBackground", "callToActionForeground", "callToActionSecondaryBackground", "accent1", "accent2", "accent3", "closeButton", "tierControlBackground", "tierControlForeground", "tierControlSelectedBackground", "tierControlSelectedForeground", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;Lcom/revenuecat/purchases/paywalls/PaywallColor;)V", "getAccent1$annotations", "()V", "getAccent1", "()Lcom/revenuecat/purchases/paywalls/PaywallColor;", "getAccent2$annotations", "getAccent2", "getAccent3$annotations", "getAccent3", "getBackground$annotations", "getBackground", "getCallToActionBackground$annotations", "getCallToActionBackground", "getCallToActionForeground$annotations", "getCallToActionForeground", "getCallToActionSecondaryBackground$annotations", "getCallToActionSecondaryBackground", "getCloseButton$annotations", "getCloseButton", "getText1$annotations", "getText1", "getText2$annotations", "getText2", "getText3$annotations", "getText3", "getTierControlBackground$annotations", "getTierControlBackground", "getTierControlForeground$annotations", "getTierControlForeground", "getTierControlSelectedBackground$annotations", "getTierControlSelectedBackground", "getTierControlSelectedForeground$annotations", "getTierControlSelectedForeground", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Colors {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final PaywallColor accent1;
            private final PaywallColor accent2;
            private final PaywallColor accent3;
            private final PaywallColor background;
            private final PaywallColor callToActionBackground;
            private final PaywallColor callToActionForeground;
            private final PaywallColor callToActionSecondaryBackground;
            private final PaywallColor closeButton;
            private final PaywallColor text1;
            private final PaywallColor text2;
            private final PaywallColor text3;
            private final PaywallColor tierControlBackground;
            private final PaywallColor tierControlForeground;
            private final PaywallColor tierControlSelectedBackground;
            private final PaywallColor tierControlSelectedForeground;

            public static /* synthetic */ void getAccent1$annotations() {
            }

            public static /* synthetic */ void getAccent2$annotations() {
            }

            public static /* synthetic */ void getAccent3$annotations() {
            }

            public static /* synthetic */ void getBackground$annotations() {
            }

            public static /* synthetic */ void getCallToActionBackground$annotations() {
            }

            public static /* synthetic */ void getCallToActionForeground$annotations() {
            }

            public static /* synthetic */ void getCallToActionSecondaryBackground$annotations() {
            }

            public static /* synthetic */ void getCloseButton$annotations() {
            }

            public static /* synthetic */ void getText1$annotations() {
            }

            public static /* synthetic */ void getText2$annotations() {
            }

            public static /* synthetic */ void getText3$annotations() {
            }

            public static /* synthetic */ void getTierControlBackground$annotations() {
            }

            public static /* synthetic */ void getTierControlForeground$annotations() {
            }

            public static /* synthetic */ void getTierControlSelectedBackground$annotations() {
            }

            public static /* synthetic */ void getTierControlSelectedForeground$annotations() {
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Colors)) {
                    return false;
                }
                Colors colors = (Colors) obj;
                return Intrinsics.areEqual(this.background, colors.background) && Intrinsics.areEqual(this.text1, colors.text1) && Intrinsics.areEqual(this.text2, colors.text2) && Intrinsics.areEqual(this.text3, colors.text3) && Intrinsics.areEqual(this.callToActionBackground, colors.callToActionBackground) && Intrinsics.areEqual(this.callToActionForeground, colors.callToActionForeground) && Intrinsics.areEqual(this.callToActionSecondaryBackground, colors.callToActionSecondaryBackground) && Intrinsics.areEqual(this.accent1, colors.accent1) && Intrinsics.areEqual(this.accent2, colors.accent2) && Intrinsics.areEqual(this.accent3, colors.accent3) && Intrinsics.areEqual(this.closeButton, colors.closeButton) && Intrinsics.areEqual(this.tierControlBackground, colors.tierControlBackground) && Intrinsics.areEqual(this.tierControlForeground, colors.tierControlForeground) && Intrinsics.areEqual(this.tierControlSelectedBackground, colors.tierControlSelectedBackground) && Intrinsics.areEqual(this.tierControlSelectedForeground, colors.tierControlSelectedForeground);
            }

            public int hashCode() {
                int iHashCode = ((this.background.hashCode() * 31) + this.text1.hashCode()) * 31;
                PaywallColor paywallColor = this.text2;
                int iHashCode2 = (iHashCode + (paywallColor == null ? 0 : paywallColor.hashCode())) * 31;
                PaywallColor paywallColor2 = this.text3;
                int iHashCode3 = (((((iHashCode2 + (paywallColor2 == null ? 0 : paywallColor2.hashCode())) * 31) + this.callToActionBackground.hashCode()) * 31) + this.callToActionForeground.hashCode()) * 31;
                PaywallColor paywallColor3 = this.callToActionSecondaryBackground;
                int iHashCode4 = (iHashCode3 + (paywallColor3 == null ? 0 : paywallColor3.hashCode())) * 31;
                PaywallColor paywallColor4 = this.accent1;
                int iHashCode5 = (iHashCode4 + (paywallColor4 == null ? 0 : paywallColor4.hashCode())) * 31;
                PaywallColor paywallColor5 = this.accent2;
                int iHashCode6 = (iHashCode5 + (paywallColor5 == null ? 0 : paywallColor5.hashCode())) * 31;
                PaywallColor paywallColor6 = this.accent3;
                int iHashCode7 = (iHashCode6 + (paywallColor6 == null ? 0 : paywallColor6.hashCode())) * 31;
                PaywallColor paywallColor7 = this.closeButton;
                int iHashCode8 = (iHashCode7 + (paywallColor7 == null ? 0 : paywallColor7.hashCode())) * 31;
                PaywallColor paywallColor8 = this.tierControlBackground;
                int iHashCode9 = (iHashCode8 + (paywallColor8 == null ? 0 : paywallColor8.hashCode())) * 31;
                PaywallColor paywallColor9 = this.tierControlForeground;
                int iHashCode10 = (iHashCode9 + (paywallColor9 == null ? 0 : paywallColor9.hashCode())) * 31;
                PaywallColor paywallColor10 = this.tierControlSelectedBackground;
                int iHashCode11 = (iHashCode10 + (paywallColor10 == null ? 0 : paywallColor10.hashCode())) * 31;
                PaywallColor paywallColor11 = this.tierControlSelectedForeground;
                return iHashCode11 + (paywallColor11 != null ? paywallColor11.hashCode() : 0);
            }

            public String toString() {
                return "Colors(background=" + this.background + ", text1=" + this.text1 + ", text2=" + this.text2 + ", text3=" + this.text3 + ", callToActionBackground=" + this.callToActionBackground + ", callToActionForeground=" + this.callToActionForeground + ", callToActionSecondaryBackground=" + this.callToActionSecondaryBackground + ", accent1=" + this.accent1 + ", accent2=" + this.accent2 + ", accent3=" + this.accent3 + ", closeButton=" + this.closeButton + ", tierControlBackground=" + this.tierControlBackground + ", tierControlForeground=" + this.tierControlForeground + ", tierControlSelectedBackground=" + this.tierControlSelectedBackground + ", tierControlSelectedForeground=" + this.tierControlSelectedForeground + ')';
            }

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Colors$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Colors;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer serializer() {
                    return PaywallData$Configuration$Colors$$serializer.INSTANCE;
                }
            }

            @Deprecated
            public /* synthetic */ Colors(int i, PaywallColor paywallColor, PaywallColor paywallColor2, PaywallColor paywallColor3, PaywallColor paywallColor4, PaywallColor paywallColor5, PaywallColor paywallColor6, PaywallColor paywallColor7, PaywallColor paywallColor8, PaywallColor paywallColor9, PaywallColor paywallColor10, PaywallColor paywallColor11, PaywallColor paywallColor12, PaywallColor paywallColor13, PaywallColor paywallColor14, PaywallColor paywallColor15, SerializationConstructorMarker serializationConstructorMarker) {
                if (51 != (i & 51)) {
                    PluginExceptionsKt.throwMissingFieldException(i, 51, PaywallData$Configuration$Colors$$serializer.INSTANCE.getDescriptor());
                }
                this.background = paywallColor;
                this.text1 = paywallColor2;
                if ((i & 4) == 0) {
                    this.text2 = null;
                } else {
                    this.text2 = paywallColor3;
                }
                if ((i & 8) == 0) {
                    this.text3 = null;
                } else {
                    this.text3 = paywallColor4;
                }
                this.callToActionBackground = paywallColor5;
                this.callToActionForeground = paywallColor6;
                if ((i & 64) == 0) {
                    this.callToActionSecondaryBackground = null;
                } else {
                    this.callToActionSecondaryBackground = paywallColor7;
                }
                if ((i & 128) == 0) {
                    this.accent1 = null;
                } else {
                    this.accent1 = paywallColor8;
                }
                if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) == 0) {
                    this.accent2 = null;
                } else {
                    this.accent2 = paywallColor9;
                }
                if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) == 0) {
                    this.accent3 = null;
                } else {
                    this.accent3 = paywallColor10;
                }
                if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) == 0) {
                    this.closeButton = null;
                } else {
                    this.closeButton = paywallColor11;
                }
                if ((i & 2048) == 0) {
                    this.tierControlBackground = null;
                } else {
                    this.tierControlBackground = paywallColor12;
                }
                if ((i & 4096) == 0) {
                    this.tierControlForeground = null;
                } else {
                    this.tierControlForeground = paywallColor13;
                }
                if ((i & 8192) == 0) {
                    this.tierControlSelectedBackground = null;
                } else {
                    this.tierControlSelectedBackground = paywallColor14;
                }
                if ((i & Http2.INITIAL_MAX_FRAME_SIZE) == 0) {
                    this.tierControlSelectedForeground = null;
                } else {
                    this.tierControlSelectedForeground = paywallColor15;
                }
            }

            public Colors(PaywallColor background, PaywallColor text1, PaywallColor paywallColor, PaywallColor paywallColor2, PaywallColor callToActionBackground, PaywallColor callToActionForeground, PaywallColor paywallColor3, PaywallColor paywallColor4, PaywallColor paywallColor5, PaywallColor paywallColor6, PaywallColor paywallColor7, PaywallColor paywallColor8, PaywallColor paywallColor9, PaywallColor paywallColor10, PaywallColor paywallColor11) {
                Intrinsics.checkNotNullParameter(background, "background");
                Intrinsics.checkNotNullParameter(text1, "text1");
                Intrinsics.checkNotNullParameter(callToActionBackground, "callToActionBackground");
                Intrinsics.checkNotNullParameter(callToActionForeground, "callToActionForeground");
                this.background = background;
                this.text1 = text1;
                this.text2 = paywallColor;
                this.text3 = paywallColor2;
                this.callToActionBackground = callToActionBackground;
                this.callToActionForeground = callToActionForeground;
                this.callToActionSecondaryBackground = paywallColor3;
                this.accent1 = paywallColor4;
                this.accent2 = paywallColor5;
                this.accent3 = paywallColor6;
                this.closeButton = paywallColor7;
                this.tierControlBackground = paywallColor8;
                this.tierControlForeground = paywallColor9;
                this.tierControlSelectedBackground = paywallColor10;
                this.tierControlSelectedForeground = paywallColor11;
            }

            public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Colors self, CompositeEncoder output, SerialDescriptor serialDesc) {
                PaywallColor.Serializer serializer = PaywallColor.Serializer.INSTANCE;
                output.encodeSerializableElement(serialDesc, 0, serializer, self.background);
                output.encodeSerializableElement(serialDesc, 1, serializer, self.text1);
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.text2 != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, serializer, self.text2);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.text3 != null) {
                    output.encodeNullableSerializableElement(serialDesc, 3, serializer, self.text3);
                }
                output.encodeSerializableElement(serialDesc, 4, serializer, self.callToActionBackground);
                output.encodeSerializableElement(serialDesc, 5, serializer, self.callToActionForeground);
                if (output.shouldEncodeElementDefault(serialDesc, 6) || self.callToActionSecondaryBackground != null) {
                    output.encodeNullableSerializableElement(serialDesc, 6, serializer, self.callToActionSecondaryBackground);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 7) || self.accent1 != null) {
                    output.encodeNullableSerializableElement(serialDesc, 7, serializer, self.accent1);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 8) || self.accent2 != null) {
                    output.encodeNullableSerializableElement(serialDesc, 8, serializer, self.accent2);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 9) || self.accent3 != null) {
                    output.encodeNullableSerializableElement(serialDesc, 9, serializer, self.accent3);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 10) || self.closeButton != null) {
                    output.encodeNullableSerializableElement(serialDesc, 10, serializer, self.closeButton);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 11) || self.tierControlBackground != null) {
                    output.encodeNullableSerializableElement(serialDesc, 11, serializer, self.tierControlBackground);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 12) || self.tierControlForeground != null) {
                    output.encodeNullableSerializableElement(serialDesc, 12, serializer, self.tierControlForeground);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 13) || self.tierControlSelectedBackground != null) {
                    output.encodeNullableSerializableElement(serialDesc, 13, serializer, self.tierControlSelectedBackground);
                }
                if (!output.shouldEncodeElementDefault(serialDesc, 14) && self.tierControlSelectedForeground == null) {
                    return;
                }
                output.encodeNullableSerializableElement(serialDesc, 14, serializer, self.tierControlSelectedForeground);
            }

            public /* synthetic */ Colors(PaywallColor paywallColor, PaywallColor paywallColor2, PaywallColor paywallColor3, PaywallColor paywallColor4, PaywallColor paywallColor5, PaywallColor paywallColor6, PaywallColor paywallColor7, PaywallColor paywallColor8, PaywallColor paywallColor9, PaywallColor paywallColor10, PaywallColor paywallColor11, PaywallColor paywallColor12, PaywallColor paywallColor13, PaywallColor paywallColor14, PaywallColor paywallColor15, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(paywallColor, paywallColor2, (i & 4) != 0 ? null : paywallColor3, (i & 8) != 0 ? null : paywallColor4, paywallColor5, paywallColor6, (i & 64) != 0 ? null : paywallColor7, (i & 128) != 0 ? null : paywallColor8, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? null : paywallColor9, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? null : paywallColor10, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? null : paywallColor11, (i & 2048) != 0 ? null : paywallColor12, (i & 4096) != 0 ? null : paywallColor13, (i & 8192) != 0 ? null : paywallColor14, (i & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? null : paywallColor15);
            }

            public final PaywallColor getBackground() {
                return this.background;
            }

            public final PaywallColor getText1() {
                return this.text1;
            }

            public final PaywallColor getText2() {
                return this.text2;
            }

            public final PaywallColor getText3() {
                return this.text3;
            }

            public final PaywallColor getCallToActionBackground() {
                return this.callToActionBackground;
            }

            public final PaywallColor getCallToActionForeground() {
                return this.callToActionForeground;
            }

            public final PaywallColor getCallToActionSecondaryBackground() {
                return this.callToActionSecondaryBackground;
            }

            public final PaywallColor getAccent1() {
                return this.accent1;
            }

            public final PaywallColor getAccent2() {
                return this.accent2;
            }

            public final PaywallColor getAccent3() {
                return this.accent3;
            }

            public final PaywallColor getCloseButton() {
                return this.closeButton;
            }

            public final PaywallColor getTierControlBackground() {
                return this.tierControlBackground;
            }

            public final PaywallColor getTierControlForeground() {
                return this.tierControlForeground;
            }

            public final PaywallColor getTierControlSelectedBackground() {
                return this.tierControlSelectedBackground;
            }

            public final PaywallColor getTierControlSelectedForeground() {
                return this.tierControlSelectedForeground;
            }
        }
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 <2\u00020\u0001:\u0004;<=>B·\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\u0016\b\u0001\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010\u0017B\u009b\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0002\u0010\u0018J&\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u00002\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209HÁ\u0001¢\u0006\u0002\b:R\u001c\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001e\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u001a\u001a\u0004\b\u001e\u0010\u001cR\u001e\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010\u001cR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u001a\u001a\u0004\b$\u0010\u001cR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u001a\u001a\u0004\b&\u0010\u001cR\u001e\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u001a\u001a\u0004\b(\u0010\u001cR\u001e\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010\u001a\u001a\u0004\b*\u0010\u001cR(\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00140\u00138\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010\u001a\u001a\u0004\b,\u0010-R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010\u001a\u001a\u0004\b/\u0010\u001cR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010\u001a\u001a\u0004\b1\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001c¨\u0006?"}, d2 = {"Lcom/revenuecat/purchases/paywalls/PaywallData$LocalizedConfiguration;", "", "seen1", "", b.S, "", "subtitle", "callToAction", "callToActionWithIntroOffer", "callToActionWithMultipleIntroOffers", "offerDetails", "offerDetailsWithIntroOffer", "offerDetailsWithMultipleIntroOffers", "offerName", "features", "", "Lcom/revenuecat/purchases/paywalls/PaywallData$LocalizedConfiguration$Feature;", "tierName", "offerOverrides", "", "Lcom/revenuecat/purchases/paywalls/PaywallData$LocalizedConfiguration$OfferOverride;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/Map;)V", "getCallToAction$annotations", "()V", "getCallToAction", "()Ljava/lang/String;", "getCallToActionWithIntroOffer$annotations", "getCallToActionWithIntroOffer", "getCallToActionWithMultipleIntroOffers$annotations", "getCallToActionWithMultipleIntroOffers", "getFeatures", "()Ljava/util/List;", "getOfferDetails$annotations", "getOfferDetails", "getOfferDetailsWithIntroOffer$annotations", "getOfferDetailsWithIntroOffer", "getOfferDetailsWithMultipleIntroOffers$annotations", "getOfferDetailsWithMultipleIntroOffers", "getOfferName$annotations", "getOfferName", "getOfferOverrides$annotations", "getOfferOverrides", "()Ljava/util/Map;", "getSubtitle$annotations", "getSubtitle", "getTierName$annotations", "getTierName", "getTitle", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "Feature", "OfferOverride", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class LocalizedConfiguration {
        private final String callToAction;
        private final String callToActionWithIntroOffer;
        private final String callToActionWithMultipleIntroOffers;
        private final List<Feature> features;
        private final String offerDetails;
        private final String offerDetailsWithIntroOffer;
        private final String offerDetailsWithMultipleIntroOffers;
        private final String offerName;
        private final Map<String, OfferOverride> offerOverrides;
        private final String subtitle;
        private final String tierName;
        private final String title;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer[] $childSerializers = {null, null, null, null, null, null, null, null, null, new ArrayListSerializer(PaywallData$LocalizedConfiguration$Feature$$serializer.INSTANCE), null, new LinkedHashMapSerializer(StringSerializer.INSTANCE, PaywallData$LocalizedConfiguration$OfferOverride$$serializer.INSTANCE)};

        public static /* synthetic */ void getCallToAction$annotations() {
        }

        public static /* synthetic */ void getCallToActionWithIntroOffer$annotations() {
        }

        public static /* synthetic */ void getCallToActionWithMultipleIntroOffers$annotations() {
        }

        public static /* synthetic */ void getOfferDetails$annotations() {
        }

        public static /* synthetic */ void getOfferDetailsWithIntroOffer$annotations() {
        }

        public static /* synthetic */ void getOfferDetailsWithMultipleIntroOffers$annotations() {
        }

        public static /* synthetic */ void getOfferName$annotations() {
        }

        public static /* synthetic */ void getOfferOverrides$annotations() {
        }

        public static /* synthetic */ void getSubtitle$annotations() {
        }

        public static /* synthetic */ void getTierName$annotations() {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LocalizedConfiguration)) {
                return false;
            }
            LocalizedConfiguration localizedConfiguration = (LocalizedConfiguration) obj;
            return Intrinsics.areEqual(this.title, localizedConfiguration.title) && Intrinsics.areEqual(this.subtitle, localizedConfiguration.subtitle) && Intrinsics.areEqual(this.callToAction, localizedConfiguration.callToAction) && Intrinsics.areEqual(this.callToActionWithIntroOffer, localizedConfiguration.callToActionWithIntroOffer) && Intrinsics.areEqual(this.callToActionWithMultipleIntroOffers, localizedConfiguration.callToActionWithMultipleIntroOffers) && Intrinsics.areEqual(this.offerDetails, localizedConfiguration.offerDetails) && Intrinsics.areEqual(this.offerDetailsWithIntroOffer, localizedConfiguration.offerDetailsWithIntroOffer) && Intrinsics.areEqual(this.offerDetailsWithMultipleIntroOffers, localizedConfiguration.offerDetailsWithMultipleIntroOffers) && Intrinsics.areEqual(this.offerName, localizedConfiguration.offerName) && Intrinsics.areEqual(this.features, localizedConfiguration.features) && Intrinsics.areEqual(this.tierName, localizedConfiguration.tierName) && Intrinsics.areEqual(this.offerOverrides, localizedConfiguration.offerOverrides);
        }

        public int hashCode() {
            int iHashCode = this.title.hashCode() * 31;
            String str = this.subtitle;
            int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.callToAction.hashCode()) * 31;
            String str2 = this.callToActionWithIntroOffer;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.callToActionWithMultipleIntroOffers;
            int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.offerDetails;
            int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.offerDetailsWithIntroOffer;
            int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.offerDetailsWithMultipleIntroOffers;
            int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.offerName;
            int iHashCode8 = (((iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31) + this.features.hashCode()) * 31;
            String str8 = this.tierName;
            return ((iHashCode8 + (str8 != null ? str8.hashCode() : 0)) * 31) + this.offerOverrides.hashCode();
        }

        public String toString() {
            return "LocalizedConfiguration(title=" + this.title + ", subtitle=" + this.subtitle + ", callToAction=" + this.callToAction + ", callToActionWithIntroOffer=" + this.callToActionWithIntroOffer + ", callToActionWithMultipleIntroOffers=" + this.callToActionWithMultipleIntroOffers + ", offerDetails=" + this.offerDetails + ", offerDetailsWithIntroOffer=" + this.offerDetailsWithIntroOffer + ", offerDetailsWithMultipleIntroOffers=" + this.offerDetailsWithMultipleIntroOffers + ", offerName=" + this.offerName + ", features=" + this.features + ", tierName=" + this.tierName + ", offerOverrides=" + this.offerOverrides + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/PaywallData$LocalizedConfiguration$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/PaywallData$LocalizedConfiguration;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer serializer() {
                return PaywallData$LocalizedConfiguration$$serializer.INSTANCE;
            }
        }

        @Deprecated
        public /* synthetic */ LocalizedConfiguration(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, List list, String str10, Map map, SerializationConstructorMarker serializationConstructorMarker) {
            if (5 != (i & 5)) {
                PluginExceptionsKt.throwMissingFieldException(i, 5, PaywallData$LocalizedConfiguration$$serializer.INSTANCE.getDescriptor());
            }
            this.title = str;
            if ((i & 2) == 0) {
                this.subtitle = null;
            } else {
                this.subtitle = str2;
            }
            this.callToAction = str3;
            if ((i & 8) == 0) {
                this.callToActionWithIntroOffer = null;
            } else {
                this.callToActionWithIntroOffer = str4;
            }
            if ((i & 16) == 0) {
                this.callToActionWithMultipleIntroOffers = null;
            } else {
                this.callToActionWithMultipleIntroOffers = str5;
            }
            if ((i & 32) == 0) {
                this.offerDetails = null;
            } else {
                this.offerDetails = str6;
            }
            if ((i & 64) == 0) {
                this.offerDetailsWithIntroOffer = null;
            } else {
                this.offerDetailsWithIntroOffer = str7;
            }
            if ((i & 128) == 0) {
                this.offerDetailsWithMultipleIntroOffers = null;
            } else {
                this.offerDetailsWithMultipleIntroOffers = str8;
            }
            if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) == 0) {
                this.offerName = null;
            } else {
                this.offerName = str9;
            }
            if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) == 0) {
                this.features = CollectionsKt.emptyList();
            } else {
                this.features = list;
            }
            if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) == 0) {
                this.tierName = null;
            } else {
                this.tierName = str10;
            }
            if ((i & 2048) == 0) {
                this.offerOverrides = MapsKt.emptyMap();
            } else {
                this.offerOverrides = map;
            }
        }

        public LocalizedConfiguration(String title, String str, String callToAction, String str2, String str3, String str4, String str5, String str6, String str7, List<Feature> features, String str8, Map<String, OfferOverride> offerOverrides) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(callToAction, "callToAction");
            Intrinsics.checkNotNullParameter(features, "features");
            Intrinsics.checkNotNullParameter(offerOverrides, "offerOverrides");
            this.title = title;
            this.subtitle = str;
            this.callToAction = callToAction;
            this.callToActionWithIntroOffer = str2;
            this.callToActionWithMultipleIntroOffers = str3;
            this.offerDetails = str4;
            this.offerDetailsWithIntroOffer = str5;
            this.offerDetailsWithMultipleIntroOffers = str6;
            this.offerName = str7;
            this.features = features;
            this.tierName = str8;
            this.offerOverrides = offerOverrides;
        }

        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(LocalizedConfiguration self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer[] kSerializerArr = $childSerializers;
            output.encodeStringElement(serialDesc, 0, self.title);
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.subtitle != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, EmptyStringToNullSerializer.INSTANCE, self.subtitle);
            }
            output.encodeStringElement(serialDesc, 2, self.callToAction);
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.callToActionWithIntroOffer != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, EmptyStringToNullSerializer.INSTANCE, self.callToActionWithIntroOffer);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.callToActionWithMultipleIntroOffers != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, EmptyStringToNullSerializer.INSTANCE, self.callToActionWithMultipleIntroOffers);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.offerDetails != null) {
                output.encodeNullableSerializableElement(serialDesc, 5, EmptyStringToNullSerializer.INSTANCE, self.offerDetails);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.offerDetailsWithIntroOffer != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, EmptyStringToNullSerializer.INSTANCE, self.offerDetailsWithIntroOffer);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 7) || self.offerDetailsWithMultipleIntroOffers != null) {
                output.encodeNullableSerializableElement(serialDesc, 7, EmptyStringToNullSerializer.INSTANCE, self.offerDetailsWithMultipleIntroOffers);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 8) || self.offerName != null) {
                output.encodeNullableSerializableElement(serialDesc, 8, EmptyStringToNullSerializer.INSTANCE, self.offerName);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 9) || !Intrinsics.areEqual(self.features, CollectionsKt.emptyList())) {
                output.encodeSerializableElement(serialDesc, 9, kSerializerArr[9], self.features);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 10) || self.tierName != null) {
                output.encodeNullableSerializableElement(serialDesc, 10, EmptyStringToNullSerializer.INSTANCE, self.tierName);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 11) && Intrinsics.areEqual(self.offerOverrides, MapsKt.emptyMap())) {
                return;
            }
            output.encodeSerializableElement(serialDesc, 11, kSerializerArr[11], self.offerOverrides);
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getSubtitle() {
            return this.subtitle;
        }

        public final String getCallToAction() {
            return this.callToAction;
        }

        public final String getCallToActionWithIntroOffer() {
            return this.callToActionWithIntroOffer;
        }

        public final String getCallToActionWithMultipleIntroOffers() {
            return this.callToActionWithMultipleIntroOffers;
        }

        public final String getOfferDetails() {
            return this.offerDetails;
        }

        public final String getOfferDetailsWithIntroOffer() {
            return this.offerDetailsWithIntroOffer;
        }

        public final String getOfferDetailsWithMultipleIntroOffers() {
            return this.offerDetailsWithMultipleIntroOffers;
        }

        public final String getOfferName() {
            return this.offerName;
        }

        public /* synthetic */ LocalizedConfiguration(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, List list, String str10, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2, str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? null : str9, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? CollectionsKt.emptyList() : list, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? null : str10, (i & 2048) != 0 ? MapsKt.emptyMap() : map);
        }

        public final List<Feature> getFeatures() {
            return this.features;
        }

        public final String getTierName() {
            return this.tierName;
        }

        public final Map<String, OfferOverride> getOfferOverrides() {
            return this.offerOverrides;
        }

        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001b\u001cB9\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ*\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0007J&\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019HÁ\u0001¢\u0006\u0002\b\u001aR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/revenuecat/purchases/paywalls/PaywallData$LocalizedConfiguration$Feature;", "", "seen1", "", b.S, "", "content", "iconID", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getIconID$annotations", "()V", "getIconID", "getTitle", "copy", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Feature {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final String content;
            private final String iconID;
            private final String title;

            public static /* synthetic */ void getIconID$annotations() {
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Feature)) {
                    return false;
                }
                Feature feature = (Feature) obj;
                return Intrinsics.areEqual(this.title, feature.title) && Intrinsics.areEqual(this.content, feature.content) && Intrinsics.areEqual(this.iconID, feature.iconID);
            }

            public int hashCode() {
                int iHashCode = this.title.hashCode() * 31;
                String str = this.content;
                int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.iconID;
                return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                return "Feature(title=" + this.title + ", content=" + this.content + ", iconID=" + this.iconID + ')';
            }

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/PaywallData$LocalizedConfiguration$Feature$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/PaywallData$LocalizedConfiguration$Feature;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer serializer() {
                    return PaywallData$LocalizedConfiguration$Feature$$serializer.INSTANCE;
                }
            }

            @Deprecated
            public /* synthetic */ Feature(int i, String str, String str2, String str3, SerializationConstructorMarker serializationConstructorMarker) {
                if (1 != (i & 1)) {
                    PluginExceptionsKt.throwMissingFieldException(i, 1, PaywallData$LocalizedConfiguration$Feature$$serializer.INSTANCE.getDescriptor());
                }
                this.title = str;
                if ((i & 2) == 0) {
                    this.content = null;
                } else {
                    this.content = str2;
                }
                if ((i & 4) == 0) {
                    this.iconID = null;
                } else {
                    this.iconID = str3;
                }
            }

            public Feature(String title, String str, String str2) {
                Intrinsics.checkNotNullParameter(title, "title");
                this.title = title;
                this.content = str;
                this.iconID = str2;
            }

            public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Feature self, CompositeEncoder output, SerialDescriptor serialDesc) {
                output.encodeStringElement(serialDesc, 0, self.title);
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.content != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.content);
                }
                if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.iconID == null) {
                    return;
                }
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.iconID);
            }

            public /* synthetic */ Feature(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
            }

            public final String getTitle() {
                return this.title;
            }

            public final String getContent() {
                return this.content;
            }

            public final String getIconID() {
                return this.iconID;
            }

            public static /* synthetic */ Feature copy$default(Feature feature, String str, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = feature.title;
                }
                if ((i & 2) != 0) {
                    str2 = feature.content;
                }
                if ((i & 4) != 0) {
                    str3 = feature.iconID;
                }
                return feature.copy(str, str2, str3);
            }

            @InternalRevenueCatAPI
            public final /* synthetic */ Feature copy(String title, String content, String iconID) {
                Intrinsics.checkNotNullParameter(title, "title");
                return new Feature(title, content, iconID);
            }
        }

        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 #2\u00020\u0001:\u0002\"#BU\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fB9\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\rJ&\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 HÁ\u0001¢\u0006\u0002\b!R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0011¨\u0006$"}, d2 = {"Lcom/revenuecat/purchases/paywalls/PaywallData$LocalizedConfiguration$OfferOverride;", "", "seen1", "", "offerName", "", "offerDetails", "offerDetailsWithIntroOffer", "offerDetailsWithMultipleIntroOffers", "offerBadge", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getOfferBadge$annotations", "()V", "getOfferBadge", "()Ljava/lang/String;", "getOfferDetails$annotations", "getOfferDetails", "getOfferDetailsWithIntroOffer$annotations", "getOfferDetailsWithIntroOffer", "getOfferDetailsWithMultipleIntroOffers$annotations", "getOfferDetailsWithMultipleIntroOffers", "getOfferName$annotations", "getOfferName", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class OfferOverride {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final String offerBadge;
            private final String offerDetails;
            private final String offerDetailsWithIntroOffer;
            private final String offerDetailsWithMultipleIntroOffers;
            private final String offerName;

            public static /* synthetic */ void getOfferBadge$annotations() {
            }

            public static /* synthetic */ void getOfferDetails$annotations() {
            }

            public static /* synthetic */ void getOfferDetailsWithIntroOffer$annotations() {
            }

            public static /* synthetic */ void getOfferDetailsWithMultipleIntroOffers$annotations() {
            }

            public static /* synthetic */ void getOfferName$annotations() {
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof OfferOverride)) {
                    return false;
                }
                OfferOverride offerOverride = (OfferOverride) obj;
                return Intrinsics.areEqual(this.offerName, offerOverride.offerName) && Intrinsics.areEqual(this.offerDetails, offerOverride.offerDetails) && Intrinsics.areEqual(this.offerDetailsWithIntroOffer, offerOverride.offerDetailsWithIntroOffer) && Intrinsics.areEqual(this.offerDetailsWithMultipleIntroOffers, offerOverride.offerDetailsWithMultipleIntroOffers) && Intrinsics.areEqual(this.offerBadge, offerOverride.offerBadge);
            }

            public int hashCode() {
                int iHashCode = ((this.offerName.hashCode() * 31) + this.offerDetails.hashCode()) * 31;
                String str = this.offerDetailsWithIntroOffer;
                int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.offerDetailsWithMultipleIntroOffers;
                int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.offerBadge;
                return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
            }

            public String toString() {
                return "OfferOverride(offerName=" + this.offerName + ", offerDetails=" + this.offerDetails + ", offerDetailsWithIntroOffer=" + this.offerDetailsWithIntroOffer + ", offerDetailsWithMultipleIntroOffers=" + this.offerDetailsWithMultipleIntroOffers + ", offerBadge=" + this.offerBadge + ')';
            }

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/PaywallData$LocalizedConfiguration$OfferOverride$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/PaywallData$LocalizedConfiguration$OfferOverride;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer serializer() {
                    return PaywallData$LocalizedConfiguration$OfferOverride$$serializer.INSTANCE;
                }
            }

            @Deprecated
            public /* synthetic */ OfferOverride(int i, String str, String str2, String str3, String str4, String str5, SerializationConstructorMarker serializationConstructorMarker) {
                if (3 != (i & 3)) {
                    PluginExceptionsKt.throwMissingFieldException(i, 3, PaywallData$LocalizedConfiguration$OfferOverride$$serializer.INSTANCE.getDescriptor());
                }
                this.offerName = str;
                this.offerDetails = str2;
                if ((i & 4) == 0) {
                    this.offerDetailsWithIntroOffer = null;
                } else {
                    this.offerDetailsWithIntroOffer = str3;
                }
                if ((i & 8) == 0) {
                    this.offerDetailsWithMultipleIntroOffers = null;
                } else {
                    this.offerDetailsWithMultipleIntroOffers = str4;
                }
                if ((i & 16) == 0) {
                    this.offerBadge = null;
                } else {
                    this.offerBadge = str5;
                }
            }

            public OfferOverride(String offerName, String offerDetails, String str, String str2, String str3) {
                Intrinsics.checkNotNullParameter(offerName, "offerName");
                Intrinsics.checkNotNullParameter(offerDetails, "offerDetails");
                this.offerName = offerName;
                this.offerDetails = offerDetails;
                this.offerDetailsWithIntroOffer = str;
                this.offerDetailsWithMultipleIntroOffers = str2;
                this.offerBadge = str3;
            }

            public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(OfferOverride self, CompositeEncoder output, SerialDescriptor serialDesc) {
                output.encodeStringElement(serialDesc, 0, self.offerName);
                output.encodeStringElement(serialDesc, 1, self.offerDetails);
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.offerDetailsWithIntroOffer != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, EmptyStringToNullSerializer.INSTANCE, self.offerDetailsWithIntroOffer);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.offerDetailsWithMultipleIntroOffers != null) {
                    output.encodeNullableSerializableElement(serialDesc, 3, EmptyStringToNullSerializer.INSTANCE, self.offerDetailsWithMultipleIntroOffers);
                }
                if (!output.shouldEncodeElementDefault(serialDesc, 4) && self.offerBadge == null) {
                    return;
                }
                output.encodeNullableSerializableElement(serialDesc, 4, EmptyStringToNullSerializer.INSTANCE, self.offerBadge);
            }

            public /* synthetic */ OfferOverride(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5);
            }

            public final String getOfferName() {
                return this.offerName;
            }

            public final String getOfferDetails() {
                return this.offerDetails;
            }

            public final String getOfferDetailsWithIntroOffer() {
                return this.offerDetailsWithIntroOffer;
            }

            public final String getOfferDetailsWithMultipleIntroOffers() {
                return this.offerDetailsWithMultipleIntroOffers;
            }

            public final String getOfferBadge() {
                return this.offerBadge;
            }
        }
    }
}
