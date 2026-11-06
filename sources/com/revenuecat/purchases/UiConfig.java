package com.revenuecat.purchases;

import com.BV.LinearGradient.LinearGradientManager;
import com.revenuecat.purchases.paywalls.components.common.LocaleId;
import com.revenuecat.purchases.paywalls.components.common.LocalizedVariableLocalizationKeyMapSerializer;
import com.revenuecat.purchases.paywalls.components.common.VariableLocalizationKey;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.FontStyle;
import com.revenuecat.purchases.paywalls.components.properties.FontStyleDeserializer;
import java.lang.annotation.Annotation;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes4.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 (2\u00020\u0001:\u0005&'()*Bk\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\"\b\u0001\u0010\u0006\u001a\u001c\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007\u0018\u00010\u0007\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0016\b\u0001\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011BQ\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012 \b\u0002\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u00070\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e0\u0007¢\u0006\u0002\u0010\u0012J&\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$HÁ\u0001¢\u0006\u0002\b%R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R(\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e0\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R4\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u00070\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u001c\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u001d¨\u0006+"}, d2 = {"Lcom/revenuecat/purchases/UiConfig;", "", "seen1", "", "app", "Lcom/revenuecat/purchases/UiConfig$AppConfig;", "localizations", "", "Lcom/revenuecat/purchases/paywalls/components/common/LocaleId;", "Lcom/revenuecat/purchases/paywalls/components/common/VariableLocalizationKey;", "", "variableConfig", "Lcom/revenuecat/purchases/UiConfig$VariableConfig;", "customVariables", "Lcom/revenuecat/purchases/UiConfig$CustomVariableDefinition;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/UiConfig$AppConfig;Ljava/util/Map;Lcom/revenuecat/purchases/UiConfig$VariableConfig;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/revenuecat/purchases/UiConfig$AppConfig;Ljava/util/Map;Lcom/revenuecat/purchases/UiConfig$VariableConfig;Ljava/util/Map;)V", "getApp", "()Lcom/revenuecat/purchases/UiConfig$AppConfig;", "getCustomVariables$annotations", "()V", "getCustomVariables", "()Ljava/util/Map;", "getLocalizations$annotations", "getLocalizations", "getVariableConfig$annotations", "getVariableConfig", "()Lcom/revenuecat/purchases/UiConfig$VariableConfig;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "AppConfig", "Companion", "CustomVariableDefinition", "VariableConfig", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class UiConfig {
    private final AppConfig app;
    private final Map<String, CustomVariableDefinition> customVariables;
    private final Map<LocaleId, Map<VariableLocalizationKey, String>> localizations;
    private final VariableConfig variableConfig;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer[] $childSerializers = {null, null, null, new LinkedHashMapSerializer(StringSerializer.INSTANCE, CustomVariableDefinitionSerializer.INSTANCE)};

    public UiConfig() {
        this((AppConfig) null, (Map) null, (VariableConfig) null, (Map) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ void getCustomVariables$annotations() {
    }

    public static /* synthetic */ void getLocalizations$annotations() {
    }

    public static /* synthetic */ void getVariableConfig$annotations() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UiConfig)) {
            return false;
        }
        UiConfig uiConfig = (UiConfig) obj;
        return Intrinsics.areEqual(this.app, uiConfig.app) && Intrinsics.areEqual(this.localizations, uiConfig.localizations) && Intrinsics.areEqual(this.variableConfig, uiConfig.variableConfig) && Intrinsics.areEqual(this.customVariables, uiConfig.customVariables);
    }

    public int hashCode() {
        return (((((this.app.hashCode() * 31) + this.localizations.hashCode()) * 31) + this.variableConfig.hashCode()) * 31) + this.customVariables.hashCode();
    }

    public String toString() {
        return "UiConfig(app=" + this.app + ", localizations=" + this.localizations + ", variableConfig=" + this.variableConfig + ", customVariables=" + this.customVariables + ')';
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/UiConfig$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/UiConfig;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer serializer() {
            return UiConfig$$serializer.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public /* synthetic */ UiConfig(int i, AppConfig appConfig, Map map, VariableConfig variableConfig, Map map2, SerializationConstructorMarker serializationConstructorMarker) {
        int i2 = 3;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        this.app = (i & 1) == 0 ? new AppConfig((Map) null, (Map) (0 == true ? 1 : 0), i2, (DefaultConstructorMarker) (0 == true ? 1 : 0)) : appConfig;
        if ((i & 2) == 0) {
            this.localizations = MapsKt.emptyMap();
        } else {
            this.localizations = map;
        }
        if ((i & 4) == 0) {
            this.variableConfig = new VariableConfig((Map) (objArr3 == true ? 1 : 0), (Map) (objArr2 == true ? 1 : 0), i2, (DefaultConstructorMarker) (objArr == true ? 1 : 0));
        } else {
            this.variableConfig = variableConfig;
        }
        if ((i & 8) == 0) {
            this.customVariables = MapsKt.emptyMap();
        } else {
            this.customVariables = map2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UiConfig(AppConfig app2, Map<LocaleId, ? extends Map<VariableLocalizationKey, String>> localizations, VariableConfig variableConfig, Map<String, CustomVariableDefinition> customVariables) {
        Intrinsics.checkNotNullParameter(app2, "app");
        Intrinsics.checkNotNullParameter(localizations, "localizations");
        Intrinsics.checkNotNullParameter(variableConfig, "variableConfig");
        Intrinsics.checkNotNullParameter(customVariables, "customVariables");
        this.app = app2;
        this.localizations = localizations;
        this.variableConfig = variableConfig;
        this.customVariables = customVariables;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(UiConfig self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer[] kSerializerArr = $childSerializers;
        int i = 3;
        Map map = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        Object[] objArr5 = 0;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.app, new AppConfig(map, (Map) (objArr5 == true ? 1 : 0), i, (DefaultConstructorMarker) (objArr4 == true ? 1 : 0)))) {
            output.encodeSerializableElement(serialDesc, 0, UiConfig$AppConfig$$serializer.INSTANCE, self.app);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.localizations, MapsKt.emptyMap())) {
            output.encodeSerializableElement(serialDesc, 1, LocalizedVariableLocalizationKeyMapSerializer.INSTANCE, self.localizations);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.variableConfig, new VariableConfig((Map) (objArr3 == true ? 1 : 0), (Map) (objArr2 == true ? 1 : 0), i, (DefaultConstructorMarker) (objArr == true ? 1 : 0)))) {
            output.encodeSerializableElement(serialDesc, 2, UiConfig$VariableConfig$$serializer.INSTANCE, self.variableConfig);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 3) && Intrinsics.areEqual(self.customVariables, MapsKt.emptyMap())) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 3, kSerializerArr[3], self.customVariables);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ UiConfig(AppConfig appConfig, Map map, VariableConfig variableConfig, Map map2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        int i2 = 3;
        this((i & 1) != 0 ? new AppConfig((Map) null, (Map) (0 == true ? 1 : 0), i2, (DefaultConstructorMarker) (0 == true ? 1 : 0)) : appConfig, (i & 2) != 0 ? MapsKt.emptyMap() : map, (i & 4) != 0 ? new VariableConfig((Map) (0 == true ? 1 : 0), (Map) (0 == true ? 1 : 0), i2, (DefaultConstructorMarker) (0 == true ? 1 : 0)) : variableConfig, (i & 8) != 0 ? MapsKt.emptyMap() : map2);
    }

    public final /* synthetic */ AppConfig getApp() {
        return this.app;
    }

    public final /* synthetic */ Map getLocalizations() {
        return this.localizations;
    }

    public final /* synthetic */ VariableConfig getVariableConfig() {
        return this.variableConfig;
    }

    public final /* synthetic */ Map getCustomVariables() {
        return this.customVariables;
    }

    @InternalRevenueCatAPI
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0003\u001a\u001b\u001cBE\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rB1\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0002\u0010\u000eJ&\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018HÁ\u0001¢\u0006\u0002\b\u0019R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/revenuecat/purchases/UiConfig$AppConfig;", "", "seen1", "", LinearGradientManager.PROP_COLORS, "", "Lcom/revenuecat/purchases/ColorAlias;", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;", "fonts", "Lcom/revenuecat/purchases/FontAlias;", "Lcom/revenuecat/purchases/UiConfig$AppConfig$FontsConfig;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/Map;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/util/Map;Ljava/util/Map;)V", "getColors", "()Ljava/util/Map;", "getFonts", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "FontsConfig", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AppConfig {
        private final Map<ColorAlias, ColorScheme> colors;
        private final Map<FontAlias, FontsConfig> fonts;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer[] $childSerializers = {new LinkedHashMapSerializer(ColorAlias$$serializer.INSTANCE, ColorScheme$$serializer.INSTANCE), new LinkedHashMapSerializer(FontAlias$$serializer.INSTANCE, UiConfig$AppConfig$FontsConfig$$serializer.INSTANCE)};

        /* JADX WARN: Multi-variable type inference failed */
        public AppConfig() {
            this((Map) null, (Map) (0 == true ? 1 : 0), 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AppConfig)) {
                return false;
            }
            AppConfig appConfig = (AppConfig) obj;
            return Intrinsics.areEqual(this.colors, appConfig.colors) && Intrinsics.areEqual(this.fonts, appConfig.fonts);
        }

        public int hashCode() {
            return (this.colors.hashCode() * 31) + this.fonts.hashCode();
        }

        public String toString() {
            return "AppConfig(colors=" + this.colors + ", fonts=" + this.fonts + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/UiConfig$AppConfig$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/UiConfig$AppConfig;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer serializer() {
                return UiConfig$AppConfig$$serializer.INSTANCE;
            }
        }

        @Deprecated
        public /* synthetic */ AppConfig(int i, Map map, Map map2, SerializationConstructorMarker serializationConstructorMarker) {
            this.colors = (i & 1) == 0 ? MapsKt.emptyMap() : map;
            if ((i & 2) == 0) {
                this.fonts = MapsKt.emptyMap();
            } else {
                this.fonts = map2;
            }
        }

        public AppConfig(Map<ColorAlias, ColorScheme> colors, Map<FontAlias, FontsConfig> fonts) {
            Intrinsics.checkNotNullParameter(colors, "colors");
            Intrinsics.checkNotNullParameter(fonts, "fonts");
            this.colors = colors;
            this.fonts = fonts;
        }

        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(AppConfig self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer[] kSerializerArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.colors, MapsKt.emptyMap())) {
                output.encodeSerializableElement(serialDesc, 0, kSerializerArr[0], self.colors);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 1) && Intrinsics.areEqual(self.fonts, MapsKt.emptyMap())) {
                return;
            }
            output.encodeSerializableElement(serialDesc, 1, kSerializerArr[1], self.fonts);
        }

        public /* synthetic */ AppConfig(Map map, Map map2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? MapsKt.emptyMap() : map, (i & 2) != 0 ? MapsKt.emptyMap() : map2);
        }

        public final /* synthetic */ Map getColors() {
            return this.colors;
        }

        @InternalRevenueCatAPI
        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0003\u0014\u0015\u0016B#\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ&\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012HÁ\u0001¢\u0006\u0002\b\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/revenuecat/purchases/UiConfig$AppConfig$FontsConfig;", "", "seen1", "", "android", "Lcom/revenuecat/purchases/UiConfig$AppConfig$FontsConfig$FontInfo;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/UiConfig$AppConfig$FontsConfig$FontInfo;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/revenuecat/purchases/UiConfig$AppConfig$FontsConfig$FontInfo;)V", "getAndroid", "()Lcom/revenuecat/purchases/UiConfig$AppConfig$FontsConfig$FontInfo;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "FontInfo", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class FontsConfig {
            private final FontInfo android;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private static final KSerializer[] $childSerializers = {new SealedClassSerializer("com.revenuecat.purchases.UiConfig.AppConfig.FontsConfig.FontInfo", Reflection.getOrCreateKotlinClass(FontInfo.class), new KClass[]{Reflection.getOrCreateKotlinClass(FontInfo.GoogleFonts.class), Reflection.getOrCreateKotlinClass(FontInfo.Name.class)}, new KSerializer[]{UiConfig$AppConfig$FontsConfig$FontInfo$GoogleFonts$$serializer.INSTANCE, UiConfig$AppConfig$FontsConfig$FontInfo$Name$$serializer.INSTANCE}, new Annotation[0])};

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof FontsConfig) && Intrinsics.areEqual(this.android, ((FontsConfig) obj).android);
            }

            public int hashCode() {
                return this.android.hashCode();
            }

            public String toString() {
                return "FontsConfig(android=" + this.android + ')';
            }

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/UiConfig$AppConfig$FontsConfig$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/UiConfig$AppConfig$FontsConfig;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KSerializer serializer() {
                    return UiConfig$AppConfig$FontsConfig$$serializer.INSTANCE;
                }
            }

            @Deprecated
            public /* synthetic */ FontsConfig(int i, FontInfo fontInfo, SerializationConstructorMarker serializationConstructorMarker) {
                if (1 != (i & 1)) {
                    PluginExceptionsKt.throwMissingFieldException(i, 1, UiConfig$AppConfig$FontsConfig$$serializer.INSTANCE.getDescriptor());
                }
                this.android = fontInfo;
            }

            public FontsConfig(FontInfo android2) {
                Intrinsics.checkNotNullParameter(android2, "android");
                this.android = android2;
            }

            public final /* synthetic */ FontInfo getAndroid() {
                return this.android;
            }

            @InternalRevenueCatAPI
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \u00022\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/UiConfig$AppConfig$FontsConfig$FontInfo;", "", "Companion", "GoogleFonts", "Name", "Lcom/revenuecat/purchases/UiConfig$AppConfig$FontsConfig$FontInfo$GoogleFonts;", "Lcom/revenuecat/purchases/UiConfig$AppConfig$FontsConfig$FontInfo$Name;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public interface FontInfo {

                /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                public static final Companion INSTANCE = Companion.$$INSTANCE;

                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/UiConfig$AppConfig$FontsConfig$FontInfo$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/UiConfig$AppConfig$FontsConfig$FontInfo;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                public static final class Companion {
                    static final /* synthetic */ Companion $$INSTANCE = new Companion();

                    private Companion() {
                    }

                    public final KSerializer serializer() {
                        return new SealedClassSerializer("com.revenuecat.purchases.UiConfig.AppConfig.FontsConfig.FontInfo", Reflection.getOrCreateKotlinClass(FontInfo.class), new KClass[]{Reflection.getOrCreateKotlinClass(GoogleFonts.class), Reflection.getOrCreateKotlinClass(Name.class)}, new KSerializer[]{UiConfig$AppConfig$FontsConfig$FontInfo$GoogleFonts$$serializer.INSTANCE, UiConfig$AppConfig$FontsConfig$FontInfo$Name$$serializer.INSTANCE}, new Annotation[0]);
                    }
                }

                @InternalRevenueCatAPI
                @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 #2\u00020\u0001:\u0002\"#BU\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eBI\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u000fJ&\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 HÁ\u0001¢\u0006\u0002\b!R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018¨\u0006$"}, d2 = {"Lcom/revenuecat/purchases/UiConfig$AppConfig$FontsConfig$FontInfo$Name;", "Lcom/revenuecat/purchases/UiConfig$AppConfig$FontsConfig$FontInfo;", "seen1", "", "value", "", "url", "hash", "family", "weight", "style", "Lcom/revenuecat/purchases/paywalls/components/properties/FontStyle;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/revenuecat/purchases/paywalls/components/properties/FontStyle;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/revenuecat/purchases/paywalls/components/properties/FontStyle;)V", "getFamily", "()Ljava/lang/String;", "getHash", "getStyle", "()Lcom/revenuecat/purchases/paywalls/components/properties/FontStyle;", "getUrl", "getValue", "getWeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                public static final class Name implements FontInfo {

                    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                    public static final Companion INSTANCE = new Companion(null);
                    private final String family;
                    private final String hash;
                    private final FontStyle style;
                    private final String url;
                    private final String value;
                    private final Integer weight;

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (!(obj instanceof Name)) {
                            return false;
                        }
                        Name name = (Name) obj;
                        return Intrinsics.areEqual(this.value, name.value) && Intrinsics.areEqual(this.url, name.url) && Intrinsics.areEqual(this.hash, name.hash) && Intrinsics.areEqual(this.family, name.family) && Intrinsics.areEqual(this.weight, name.weight) && this.style == name.style;
                    }

                    public int hashCode() {
                        int iHashCode = this.value.hashCode() * 31;
                        String str = this.url;
                        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
                        String str2 = this.hash;
                        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
                        String str3 = this.family;
                        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
                        Integer num = this.weight;
                        int iHashCode5 = (iHashCode4 + (num == null ? 0 : num.hashCode())) * 31;
                        FontStyle fontStyle = this.style;
                        return iHashCode5 + (fontStyle != null ? fontStyle.hashCode() : 0);
                    }

                    public String toString() {
                        return "Name(value=" + this.value + ", url=" + this.url + ", hash=" + this.hash + ", family=" + this.family + ", weight=" + this.weight + ", style=" + this.style + ')';
                    }

                    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/UiConfig$AppConfig$FontsConfig$FontInfo$Name$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/UiConfig$AppConfig$FontsConfig$FontInfo$Name;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                    public static final class Companion {
                        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                            this();
                        }

                        private Companion() {
                        }

                        public final KSerializer serializer() {
                            return UiConfig$AppConfig$FontsConfig$FontInfo$Name$$serializer.INSTANCE;
                        }
                    }

                    @Deprecated
                    public /* synthetic */ Name(int i, String str, String str2, String str3, String str4, Integer num, FontStyle fontStyle, SerializationConstructorMarker serializationConstructorMarker) {
                        if (1 != (i & 1)) {
                            PluginExceptionsKt.throwMissingFieldException(i, 1, UiConfig$AppConfig$FontsConfig$FontInfo$Name$$serializer.INSTANCE.getDescriptor());
                        }
                        this.value = str;
                        if ((i & 2) == 0) {
                            this.url = null;
                        } else {
                            this.url = str2;
                        }
                        if ((i & 4) == 0) {
                            this.hash = null;
                        } else {
                            this.hash = str3;
                        }
                        if ((i & 8) == 0) {
                            this.family = null;
                        } else {
                            this.family = str4;
                        }
                        if ((i & 16) == 0) {
                            this.weight = null;
                        } else {
                            this.weight = num;
                        }
                        if ((i & 32) == 0) {
                            this.style = null;
                        } else {
                            this.style = fontStyle;
                        }
                    }

                    public Name(String value, String str, String str2, String str3, Integer num, FontStyle fontStyle) {
                        Intrinsics.checkNotNullParameter(value, "value");
                        this.value = value;
                        this.url = str;
                        this.hash = str2;
                        this.family = str3;
                        this.weight = num;
                        this.style = fontStyle;
                    }

                    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Name self, CompositeEncoder output, SerialDescriptor serialDesc) {
                        output.encodeStringElement(serialDesc, 0, self.value);
                        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.url != null) {
                            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.url);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.hash != null) {
                            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.hash);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.family != null) {
                            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.family);
                        }
                        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.weight != null) {
                            output.encodeNullableSerializableElement(serialDesc, 4, IntSerializer.INSTANCE, self.weight);
                        }
                        if (!output.shouldEncodeElementDefault(serialDesc, 5) && self.style == null) {
                            return;
                        }
                        output.encodeNullableSerializableElement(serialDesc, 5, FontStyleDeserializer.INSTANCE, self.style);
                    }

                    public /* synthetic */ Name(String str, String str2, String str3, String str4, Integer num, FontStyle fontStyle, int i, DefaultConstructorMarker defaultConstructorMarker) {
                        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : num, (i & 32) != 0 ? null : fontStyle);
                    }

                    public final /* synthetic */ String getValue() {
                        return this.value;
                    }

                    public final /* synthetic */ String getUrl() {
                        return this.url;
                    }

                    public final /* synthetic */ String getHash() {
                        return this.hash;
                    }

                    public final /* synthetic */ String getFamily() {
                        return this.family;
                    }

                    public final /* synthetic */ Integer getWeight() {
                        return this.weight;
                    }

                    public final /* synthetic */ FontStyle getStyle() {
                        return this.style;
                    }
                }

                @InternalRevenueCatAPI
                @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0002\u0014\u0015B#\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ&\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012HÁ\u0001¢\u0006\u0002\b\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/revenuecat/purchases/UiConfig$AppConfig$FontsConfig$FontInfo$GoogleFonts;", "Lcom/revenuecat/purchases/UiConfig$AppConfig$FontsConfig$FontInfo;", "seen1", "", "value", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                public static final class GoogleFonts implements FontInfo {

                    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                    public static final Companion INSTANCE = new Companion(null);
                    private final String value;

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return (obj instanceof GoogleFonts) && Intrinsics.areEqual(this.value, ((GoogleFonts) obj).value);
                    }

                    public int hashCode() {
                        return this.value.hashCode();
                    }

                    public String toString() {
                        return "GoogleFonts(value=" + this.value + ')';
                    }

                    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/UiConfig$AppConfig$FontsConfig$FontInfo$GoogleFonts$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/UiConfig$AppConfig$FontsConfig$FontInfo$GoogleFonts;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                    public static final class Companion {
                        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                            this();
                        }

                        private Companion() {
                        }

                        public final KSerializer serializer() {
                            return UiConfig$AppConfig$FontsConfig$FontInfo$GoogleFonts$$serializer.INSTANCE;
                        }
                    }

                    @Deprecated
                    public /* synthetic */ GoogleFonts(int i, String str, SerializationConstructorMarker serializationConstructorMarker) {
                        if (1 != (i & 1)) {
                            PluginExceptionsKt.throwMissingFieldException(i, 1, UiConfig$AppConfig$FontsConfig$FontInfo$GoogleFonts$$serializer.INSTANCE.getDescriptor());
                        }
                        this.value = str;
                    }

                    public GoogleFonts(String value) {
                        Intrinsics.checkNotNullParameter(value, "value");
                        this.value = value;
                    }

                    public final /* synthetic */ String getValue() {
                        return this.value;
                    }
                }
            }
        }

        public final /* synthetic */ Map getFonts() {
            return this.fonts;
        }
    }

    @InternalRevenueCatAPI
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001a\u001bBI\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\b\u0001\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0016\b\u0001\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB1\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u000bJ&\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018HÁ\u0001¢\u0006\u0002\b\u0019R(\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR(\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/revenuecat/purchases/UiConfig$VariableConfig;", "", "seen1", "", "variableCompatibilityMap", "", "", "functionCompatibilityMap", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/Map;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/util/Map;Ljava/util/Map;)V", "getFunctionCompatibilityMap$annotations", "()V", "getFunctionCompatibilityMap", "()Ljava/util/Map;", "getVariableCompatibilityMap$annotations", "getVariableCompatibilityMap", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class VariableConfig {
        private static final KSerializer[] $childSerializers;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Map<String, String> functionCompatibilityMap;
        private final Map<String, String> variableCompatibilityMap;

        /* JADX WARN: Multi-variable type inference failed */
        public VariableConfig() {
            this((Map) null, (Map) (0 == true ? 1 : 0), 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
        }

        public static /* synthetic */ void getFunctionCompatibilityMap$annotations() {
        }

        public static /* synthetic */ void getVariableCompatibilityMap$annotations() {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof VariableConfig)) {
                return false;
            }
            VariableConfig variableConfig = (VariableConfig) obj;
            return Intrinsics.areEqual(this.variableCompatibilityMap, variableConfig.variableCompatibilityMap) && Intrinsics.areEqual(this.functionCompatibilityMap, variableConfig.functionCompatibilityMap);
        }

        public int hashCode() {
            return (this.variableCompatibilityMap.hashCode() * 31) + this.functionCompatibilityMap.hashCode();
        }

        public String toString() {
            return "VariableConfig(variableCompatibilityMap=" + this.variableCompatibilityMap + ", functionCompatibilityMap=" + this.functionCompatibilityMap + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/UiConfig$VariableConfig$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/UiConfig$VariableConfig;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer serializer() {
                return UiConfig$VariableConfig$$serializer.INSTANCE;
            }
        }

        static {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            $childSerializers = new KSerializer[]{new LinkedHashMapSerializer(stringSerializer, stringSerializer), new LinkedHashMapSerializer(stringSerializer, stringSerializer)};
        }

        @Deprecated
        public /* synthetic */ VariableConfig(int i, Map map, Map map2, SerializationConstructorMarker serializationConstructorMarker) {
            this.variableCompatibilityMap = (i & 1) == 0 ? MapsKt.emptyMap() : map;
            if ((i & 2) == 0) {
                this.functionCompatibilityMap = MapsKt.emptyMap();
            } else {
                this.functionCompatibilityMap = map2;
            }
        }

        public VariableConfig(Map<String, String> variableCompatibilityMap, Map<String, String> functionCompatibilityMap) {
            Intrinsics.checkNotNullParameter(variableCompatibilityMap, "variableCompatibilityMap");
            Intrinsics.checkNotNullParameter(functionCompatibilityMap, "functionCompatibilityMap");
            this.variableCompatibilityMap = variableCompatibilityMap;
            this.functionCompatibilityMap = functionCompatibilityMap;
        }

        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(VariableConfig self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer[] kSerializerArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.variableCompatibilityMap, MapsKt.emptyMap())) {
                output.encodeSerializableElement(serialDesc, 0, kSerializerArr[0], self.variableCompatibilityMap);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 1) && Intrinsics.areEqual(self.functionCompatibilityMap, MapsKt.emptyMap())) {
                return;
            }
            output.encodeSerializableElement(serialDesc, 1, kSerializerArr[1], self.functionCompatibilityMap);
        }

        public /* synthetic */ VariableConfig(Map map, Map map2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? MapsKt.emptyMap() : map, (i & 2) != 0 ? MapsKt.emptyMap() : map2);
        }

        public final /* synthetic */ Map getVariableCompatibilityMap() {
            return this.variableCompatibilityMap;
        }

        public final /* synthetic */ Map getFunctionCompatibilityMap() {
            return this.functionCompatibilityMap;
        }
    }

    @InternalRevenueCatAPI
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/revenuecat/purchases/UiConfig$CustomVariableDefinition;", "", "type", "", "defaultValue", "(Ljava/lang/String;Ljava/lang/Object;)V", "getDefaultValue", "()Ljava/lang/Object;", "getType", "()Ljava/lang/String;", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class CustomVariableDefinition {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Object defaultValue;
        private final String type;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CustomVariableDefinition)) {
                return false;
            }
            CustomVariableDefinition customVariableDefinition = (CustomVariableDefinition) obj;
            return Intrinsics.areEqual(this.type, customVariableDefinition.type) && Intrinsics.areEqual(this.defaultValue, customVariableDefinition.defaultValue);
        }

        public int hashCode() {
            return (this.type.hashCode() * 31) + this.defaultValue.hashCode();
        }

        public String toString() {
            return "CustomVariableDefinition(type=" + this.type + ", defaultValue=" + this.defaultValue + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/UiConfig$CustomVariableDefinition$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/UiConfig$CustomVariableDefinition;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer serializer() {
                return CustomVariableDefinitionSerializer.INSTANCE;
            }
        }

        public CustomVariableDefinition(String type, Object defaultValue) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
            this.type = type;
            this.defaultValue = defaultValue;
        }

        public final /* synthetic */ String getType() {
            return this.type;
        }

        public final /* synthetic */ Object getDefaultValue() {
            return this.defaultValue;
        }
    }
}
