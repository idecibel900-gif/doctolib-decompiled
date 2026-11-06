package com.revenuecat.purchases.ui.revenuecatui.data.processed;

import android.net.Uri;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import com.BV.LinearGradient.LinearGradientManager;
import com.facebook.react.modules.appstate.AppStateModule;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.paywalls.PaywallData;
import com.revenuecat.purchases.ui.revenuecatui.PaywallMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0081\b\u0018\u00002\u00020\u0001:\u0005<=>?@BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b0\r\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0007HÆ\u0003J\t\u0010*\u001a\u00020\tHÆ\u0003J\t\u0010+\u001a\u00020\u000bHÆ\u0003J\u0015\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b0\rHÆ\u0003J\t\u0010-\u001a\u00020\u0010HÆ\u0003J\t\u0010.\u001a\u00020\u0012HÆ\u0003Je\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b0\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012HÆ\u0001J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\r\u00103\u001a\u00020\u0019H\u0007¢\u0006\u0002\u00104J\u0015\u00105\u001a\u00020\u00192\u0006\u00106\u001a\u000207H\u0007¢\u0006\u0002\u00108J\t\u00109\u001a\u00020:HÖ\u0001J\t\u0010;\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&¨\u0006A"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration;", "", "template", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/PaywallTemplate;", "mode", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallMode;", "packages", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageConfiguration;", "configuration", "Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration;", "images", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$Images;", "imagesByTier", "", "", LinearGradientManager.PROP_COLORS, "Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$ColorInformation;", "locale", "Ljava/util/Locale;", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/PaywallTemplate;Lcom/revenuecat/purchases/ui/revenuecatui/PaywallMode;Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageConfiguration;Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration;Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$Images;Ljava/util/Map;Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$ColorInformation;Ljava/util/Locale;)V", "getColors", "()Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$ColorInformation;", "getConfiguration", "()Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration;", "darkModeColors", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$Colors;", "getImages", "()Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$Images;", "getImagesByTier", "()Ljava/util/Map;", "lightModeColors", "getLocale", "()Ljava/util/Locale;", "getMode", "()Lcom/revenuecat/purchases/ui/revenuecatui/PaywallMode;", "getPackages", "()Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageConfiguration;", "getTemplate", "()Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/PaywallTemplate;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "getCurrentColors", "(Landroidx/compose/runtime/Composer;I)Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$Colors;", "getCurrentColorsForTier", "tier", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$TierInfo;", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$TierInfo;Landroidx/compose/runtime/Composer;I)Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$Colors;", "hashCode", "", "toString", "Colors", "Images", "PackageConfiguration", "PackageInfo", "TierInfo", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class TemplateConfiguration {
    public static final int $stable = 0;
    private final PaywallData.Configuration.ColorInformation colors;
    private final PaywallData.Configuration configuration;
    private final Colors darkModeColors;
    private final Images images;
    private final Map<String, Images> imagesByTier;
    private final Colors lightModeColors;
    private final Locale locale;
    private final PaywallMode mode;
    private final PackageConfiguration packages;
    private final PaywallTemplate template;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TemplateConfiguration copy$default(TemplateConfiguration templateConfiguration, PaywallTemplate paywallTemplate, PaywallMode paywallMode, PackageConfiguration packageConfiguration, PaywallData.Configuration configuration, Images images, Map map, PaywallData.Configuration.ColorInformation colorInformation, Locale locale, int i, Object obj) {
        if ((i & 1) != 0) {
            paywallTemplate = templateConfiguration.template;
        }
        if ((i & 2) != 0) {
            paywallMode = templateConfiguration.mode;
        }
        if ((i & 4) != 0) {
            packageConfiguration = templateConfiguration.packages;
        }
        if ((i & 8) != 0) {
            configuration = templateConfiguration.configuration;
        }
        if ((i & 16) != 0) {
            images = templateConfiguration.images;
        }
        if ((i & 32) != 0) {
            map = templateConfiguration.imagesByTier;
        }
        if ((i & 64) != 0) {
            colorInformation = templateConfiguration.colors;
        }
        if ((i & 128) != 0) {
            locale = templateConfiguration.locale;
        }
        PaywallData.Configuration.ColorInformation colorInformation2 = colorInformation;
        Locale locale2 = locale;
        Images images2 = images;
        Map map2 = map;
        return templateConfiguration.copy(paywallTemplate, paywallMode, packageConfiguration, configuration, images2, map2, colorInformation2, locale2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final PaywallTemplate getTemplate() {
        return this.template;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final PaywallMode getMode() {
        return this.mode;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final PackageConfiguration getPackages() {
        return this.packages;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final PaywallData.Configuration getConfiguration() {
        return this.configuration;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Images getImages() {
        return this.images;
    }

    public final Map<String, Images> component6() {
        return this.imagesByTier;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final PaywallData.Configuration.ColorInformation getColors() {
        return this.colors;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Locale getLocale() {
        return this.locale;
    }

    public final TemplateConfiguration copy(PaywallTemplate template, PaywallMode mode, PackageConfiguration packages, PaywallData.Configuration configuration, Images images, Map<String, Images> imagesByTier, PaywallData.Configuration.ColorInformation colors, Locale locale) {
        Intrinsics.checkNotNullParameter(template, "template");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(packages, "packages");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(images, "images");
        Intrinsics.checkNotNullParameter(imagesByTier, "imagesByTier");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(locale, "locale");
        return new TemplateConfiguration(template, mode, packages, configuration, images, imagesByTier, colors, locale);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TemplateConfiguration)) {
            return false;
        }
        TemplateConfiguration templateConfiguration = (TemplateConfiguration) other;
        return this.template == templateConfiguration.template && this.mode == templateConfiguration.mode && Intrinsics.areEqual(this.packages, templateConfiguration.packages) && Intrinsics.areEqual(this.configuration, templateConfiguration.configuration) && Intrinsics.areEqual(this.images, templateConfiguration.images) && Intrinsics.areEqual(this.imagesByTier, templateConfiguration.imagesByTier) && Intrinsics.areEqual(this.colors, templateConfiguration.colors) && Intrinsics.areEqual(this.locale, templateConfiguration.locale);
    }

    public int hashCode() {
        return (((((((((((((this.template.hashCode() * 31) + this.mode.hashCode()) * 31) + this.packages.hashCode()) * 31) + this.configuration.hashCode()) * 31) + this.images.hashCode()) * 31) + this.imagesByTier.hashCode()) * 31) + this.colors.hashCode()) * 31) + this.locale.hashCode();
    }

    public String toString() {
        return "TemplateConfiguration(template=" + this.template + ", mode=" + this.mode + ", packages=" + this.packages + ", configuration=" + this.configuration + ", images=" + this.images + ", imagesByTier=" + this.imagesByTier + ", colors=" + this.colors + ", locale=" + this.locale + ')';
    }

    public TemplateConfiguration(PaywallTemplate template, PaywallMode mode, PackageConfiguration packages, PaywallData.Configuration configuration, Images images, Map<String, Images> imagesByTier, PaywallData.Configuration.ColorInformation colors, Locale locale) {
        Intrinsics.checkNotNullParameter(template, "template");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(packages, "packages");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(images, "images");
        Intrinsics.checkNotNullParameter(imagesByTier, "imagesByTier");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(locale, "locale");
        this.template = template;
        this.mode = mode;
        this.packages = packages;
        this.configuration = configuration;
        this.images = images;
        this.imagesByTier = imagesByTier;
        this.colors = colors;
        this.locale = locale;
        ColorsFactory colorsFactory = ColorsFactory.INSTANCE;
        PaywallData.Configuration.Colors dark = colors.getDark();
        this.darkModeColors = colorsFactory.create(dark == null ? colors.getLight() : dark);
        this.lightModeColors = colorsFactory.create(colors.getLight());
    }

    public final PaywallTemplate getTemplate() {
        return this.template;
    }

    public final PaywallMode getMode() {
        return this.mode;
    }

    public final PackageConfiguration getPackages() {
        return this.packages;
    }

    public final PaywallData.Configuration getConfiguration() {
        return this.configuration;
    }

    public final Images getImages() {
        return this.images;
    }

    public final Map<String, Images> getImagesByTier() {
        return this.imagesByTier;
    }

    public final PaywallData.Configuration.ColorInformation getColors() {
        return this.colors;
    }

    public final Locale getLocale() {
        return this.locale;
    }

    public final Colors getCurrentColors(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1598555926, i, -1, "com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration.getCurrentColors (TemplateConfiguration.kt:30)");
        }
        Colors colors = DarkThemeKt.isSystemInDarkTheme(composer, 0) ? this.darkModeColors : this.lightModeColors;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return colors;
    }

    public final Colors getCurrentColorsForTier(TierInfo tier, Composer composer, int i) {
        Colors colorsCreate;
        Intrinsics.checkNotNullParameter(tier, "tier");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(844077603, i, -1, "com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration.getCurrentColorsForTier (TemplateConfiguration.kt:36)");
        }
        Map<String, PaywallData.Configuration.ColorInformation> colorsByTier = this.configuration.getColorsByTier();
        Colors currentColors = null;
        PaywallData.Configuration.ColorInformation colorInformation = colorsByTier != null ? colorsByTier.get(tier.getId()) : null;
        if (colorInformation != null) {
            if (DarkThemeKt.isSystemInDarkTheme(composer, 0)) {
                ColorsFactory colorsFactory = ColorsFactory.INSTANCE;
                PaywallData.Configuration.Colors dark = colorInformation.getDark();
                if (dark == null) {
                    dark = colorInformation.getLight();
                }
                colorsCreate = colorsFactory.create(dark);
            } else {
                colorsCreate = ColorsFactory.INSTANCE.create(colorInformation.getLight());
            }
            currentColors = colorsCreate;
        }
        if (currentColors == null) {
            currentColors = getCurrentColors(composer, (i >> 3) & 14);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return currentColors;
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\nJ.\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageInfo;", "", "rcPackage", "Lcom/revenuecat/purchases/Package;", "localization", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/ProcessedLocalizedConfiguration;", "discountRelativeToMostExpensivePerMonth", "", "(Lcom/revenuecat/purchases/Package;Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/ProcessedLocalizedConfiguration;Ljava/lang/Double;)V", "getDiscountRelativeToMostExpensivePerMonth", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getLocalization", "()Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/ProcessedLocalizedConfiguration;", "getRcPackage", "()Lcom/revenuecat/purchases/Package;", "component1", "component2", "component3", "copy", "(Lcom/revenuecat/purchases/Package;Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/ProcessedLocalizedConfiguration;Ljava/lang/Double;)Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageInfo;", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class PackageInfo {
        public static final int $stable = 0;
        private final Double discountRelativeToMostExpensivePerMonth;
        private final ProcessedLocalizedConfiguration localization;
        private final Package rcPackage;

        public static /* synthetic */ PackageInfo copy$default(PackageInfo packageInfo, Package r1, ProcessedLocalizedConfiguration processedLocalizedConfiguration, Double d, int i, Object obj) {
            if ((i & 1) != 0) {
                r1 = packageInfo.rcPackage;
            }
            if ((i & 2) != 0) {
                processedLocalizedConfiguration = packageInfo.localization;
            }
            if ((i & 4) != 0) {
                d = packageInfo.discountRelativeToMostExpensivePerMonth;
            }
            return packageInfo.copy(r1, processedLocalizedConfiguration, d);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Package getRcPackage() {
            return this.rcPackage;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ProcessedLocalizedConfiguration getLocalization() {
            return this.localization;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Double getDiscountRelativeToMostExpensivePerMonth() {
            return this.discountRelativeToMostExpensivePerMonth;
        }

        public final PackageInfo copy(Package rcPackage, ProcessedLocalizedConfiguration localization, Double discountRelativeToMostExpensivePerMonth) {
            Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
            Intrinsics.checkNotNullParameter(localization, "localization");
            return new PackageInfo(rcPackage, localization, discountRelativeToMostExpensivePerMonth);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PackageInfo)) {
                return false;
            }
            PackageInfo packageInfo = (PackageInfo) other;
            return Intrinsics.areEqual(this.rcPackage, packageInfo.rcPackage) && Intrinsics.areEqual(this.localization, packageInfo.localization) && Intrinsics.areEqual(this.discountRelativeToMostExpensivePerMonth, packageInfo.discountRelativeToMostExpensivePerMonth);
        }

        public int hashCode() {
            int iHashCode = ((this.rcPackage.hashCode() * 31) + this.localization.hashCode()) * 31;
            Double d = this.discountRelativeToMostExpensivePerMonth;
            return iHashCode + (d == null ? 0 : d.hashCode());
        }

        public String toString() {
            return "PackageInfo(rcPackage=" + this.rcPackage + ", localization=" + this.localization + ", discountRelativeToMostExpensivePerMonth=" + this.discountRelativeToMostExpensivePerMonth + ')';
        }

        public PackageInfo(Package rcPackage, ProcessedLocalizedConfiguration localization, Double d) {
            Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
            Intrinsics.checkNotNullParameter(localization, "localization");
            this.rcPackage = rcPackage;
            this.localization = localization;
            this.discountRelativeToMostExpensivePerMonth = d;
        }

        public final Package getRcPackage() {
            return this.rcPackage;
        }

        public final ProcessedLocalizedConfiguration getLocalization() {
            return this.localization;
        }

        public final Double getDiscountRelativeToMostExpensivePerMonth() {
            return this.discountRelativeToMostExpensivePerMonth;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$Images;", "", "iconUri", "Landroid/net/Uri;", "backgroundUri", "headerUri", "(Landroid/net/Uri;Landroid/net/Uri;Landroid/net/Uri;)V", "getBackgroundUri", "()Landroid/net/Uri;", "getHeaderUri", "getIconUri", "component1", "component2", "component3", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Images {
        public static final int $stable = 0;
        private final Uri backgroundUri;
        private final Uri headerUri;
        private final Uri iconUri;

        public static /* synthetic */ Images copy$default(Images images, Uri uri, Uri uri2, Uri uri3, int i, Object obj) {
            if ((i & 1) != 0) {
                uri = images.iconUri;
            }
            if ((i & 2) != 0) {
                uri2 = images.backgroundUri;
            }
            if ((i & 4) != 0) {
                uri3 = images.headerUri;
            }
            return images.copy(uri, uri2, uri3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Uri getIconUri() {
            return this.iconUri;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Uri getBackgroundUri() {
            return this.backgroundUri;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Uri getHeaderUri() {
            return this.headerUri;
        }

        public final Images copy(Uri iconUri, Uri backgroundUri, Uri headerUri) {
            return new Images(iconUri, backgroundUri, headerUri);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Images)) {
                return false;
            }
            Images images = (Images) other;
            return Intrinsics.areEqual(this.iconUri, images.iconUri) && Intrinsics.areEqual(this.backgroundUri, images.backgroundUri) && Intrinsics.areEqual(this.headerUri, images.headerUri);
        }

        public int hashCode() {
            Uri uri = this.iconUri;
            int iHashCode = (uri == null ? 0 : uri.hashCode()) * 31;
            Uri uri2 = this.backgroundUri;
            int iHashCode2 = (iHashCode + (uri2 == null ? 0 : uri2.hashCode())) * 31;
            Uri uri3 = this.headerUri;
            return iHashCode2 + (uri3 != null ? uri3.hashCode() : 0);
        }

        public String toString() {
            return "Images(iconUri=" + this.iconUri + ", backgroundUri=" + this.backgroundUri + ", headerUri=" + this.headerUri + ')';
        }

        public Images(Uri uri, Uri uri2, Uri uri3) {
            this.iconUri = uri;
            this.backgroundUri = uri2;
            this.headerUri = uri3;
        }

        public final Uri getIconUri() {
            return this.iconUri;
        }

        public final Uri getBackgroundUri() {
            return this.backgroundUri;
        }

        public final Uri getHeaderUri() {
            return this.headerUri;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\bC\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0012J\u0016\u0010%\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010\u0014J\u0016\u0010'\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b(\u0010\u0014J\u0016\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b*J\u0016\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b,J\u0016\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b.J\u0016\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b0J\u0016\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b2J\u0016\u00103\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b4\u0010\u0014J\u0016\u00105\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b6\u0010\u0014J\u0016\u00107\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b8\u0010\u0014J\u0016\u00109\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b:\u0010\u0014J\u0016\u0010;\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b<\u0010\u0014J\u0016\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b>J\u0016\u0010?\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b@\u0010\u0014J\u0016\u0010A\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bB\u0010\u0014Jµ\u0001\u0010C\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0001ø\u0001\u0000¢\u0006\u0004\bD\u0010EJ\u0013\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010I\u001a\u00020JHÖ\u0001J\t\u0010K\u001a\u00020LHÖ\u0001R\u0019\u0010\n\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u000b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0014R\u0019\u0010\f\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0017\u0010\u0014R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0018\u0010\u0014R\u0019\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0019\u0010\u0014R\u0019\u0010\b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001a\u0010\u0014R\u0019\u0010\t\u001a\u0004\u0018\u00010\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\r\u001a\u0004\u0018\u00010\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001e\u0010\u0014R\u0019\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001f\u0010\u0014R\u0019\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b \u0010\u0014R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001cR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001c\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006M"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$Colors;", "", AppStateModule.APP_STATE_BACKGROUND, "Landroidx/compose/ui/graphics/Color;", "text1", "text2", "text3", "callToActionBackground", "callToActionForeground", "callToActionSecondaryBackground", "accent1", "accent2", "accent3", "closeButton", "tierControlBackground", "tierControlForeground", "tierControlSelectedBackground", "tierControlSelectedForeground", "(JJJJJJLandroidx/compose/ui/graphics/Color;JJJLandroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAccent1-0d7_KjU", "()J", "J", "getAccent2-0d7_KjU", "getAccent3-0d7_KjU", "getBackground-0d7_KjU", "getCallToActionBackground-0d7_KjU", "getCallToActionForeground-0d7_KjU", "getCallToActionSecondaryBackground-QN2ZGVo", "()Landroidx/compose/ui/graphics/Color;", "getCloseButton-QN2ZGVo", "getText1-0d7_KjU", "getText2-0d7_KjU", "getText3-0d7_KjU", "getTierControlBackground-QN2ZGVo", "getTierControlForeground-QN2ZGVo", "getTierControlSelectedBackground-QN2ZGVo", "getTierControlSelectedForeground-QN2ZGVo", "component1", "component1-0d7_KjU", "component10", "component10-0d7_KjU", "component11", "component11-QN2ZGVo", "component12", "component12-QN2ZGVo", "component13", "component13-QN2ZGVo", "component14", "component14-QN2ZGVo", "component15", "component15-QN2ZGVo", "component2", "component2-0d7_KjU", "component3", "component3-0d7_KjU", "component4", "component4-0d7_KjU", "component5", "component5-0d7_KjU", "component6", "component6-0d7_KjU", "component7", "component7-QN2ZGVo", "component8", "component8-0d7_KjU", "component9", "component9-0d7_KjU", "copy", "copy-VbAgQ-U", "(JJJJJJLandroidx/compose/ui/graphics/Color;JJJLandroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;)Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$Colors;", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Colors {
        public static final int $stable = 0;
        private final long accent1;
        private final long accent2;
        private final long accent3;
        private final long background;
        private final long callToActionBackground;
        private final long callToActionForeground;
        private final Color callToActionSecondaryBackground;
        private final Color closeButton;
        private final long text1;
        private final long text2;
        private final long text3;
        private final Color tierControlBackground;
        private final Color tierControlForeground;
        private final Color tierControlSelectedBackground;
        private final Color tierControlSelectedForeground;

        public /* synthetic */ Colors(long j, long j2, long j3, long j4, long j5, long j6, Color color, long j7, long j8, long j9, Color color2, Color color3, Color color4, Color color5, Color color6, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, j2, j3, j4, j5, j6, color, j7, j8, j9, color2, color3, color4, color5, color6);
        }

        /* JADX INFO: renamed from: component1-0d7_KjU, reason: not valid java name and from getter */
        public final long getBackground() {
            return this.background;
        }

        /* JADX INFO: renamed from: component10-0d7_KjU, reason: not valid java name and from getter */
        public final long getAccent3() {
            return this.accent3;
        }

        /* JADX INFO: renamed from: component11-QN2ZGVo, reason: not valid java name and from getter */
        public final Color getCloseButton() {
            return this.closeButton;
        }

        /* JADX INFO: renamed from: component12-QN2ZGVo, reason: not valid java name and from getter */
        public final Color getTierControlBackground() {
            return this.tierControlBackground;
        }

        /* JADX INFO: renamed from: component13-QN2ZGVo, reason: not valid java name and from getter */
        public final Color getTierControlForeground() {
            return this.tierControlForeground;
        }

        /* JADX INFO: renamed from: component14-QN2ZGVo, reason: not valid java name and from getter */
        public final Color getTierControlSelectedBackground() {
            return this.tierControlSelectedBackground;
        }

        /* JADX INFO: renamed from: component15-QN2ZGVo, reason: not valid java name and from getter */
        public final Color getTierControlSelectedForeground() {
            return this.tierControlSelectedForeground;
        }

        /* JADX INFO: renamed from: component2-0d7_KjU, reason: not valid java name and from getter */
        public final long getText1() {
            return this.text1;
        }

        /* JADX INFO: renamed from: component3-0d7_KjU, reason: not valid java name and from getter */
        public final long getText2() {
            return this.text2;
        }

        /* JADX INFO: renamed from: component4-0d7_KjU, reason: not valid java name and from getter */
        public final long getText3() {
            return this.text3;
        }

        /* JADX INFO: renamed from: component5-0d7_KjU, reason: not valid java name and from getter */
        public final long getCallToActionBackground() {
            return this.callToActionBackground;
        }

        /* JADX INFO: renamed from: component6-0d7_KjU, reason: not valid java name and from getter */
        public final long getCallToActionForeground() {
            return this.callToActionForeground;
        }

        /* JADX INFO: renamed from: component7-QN2ZGVo, reason: not valid java name and from getter */
        public final Color getCallToActionSecondaryBackground() {
            return this.callToActionSecondaryBackground;
        }

        /* JADX INFO: renamed from: component8-0d7_KjU, reason: not valid java name and from getter */
        public final long getAccent1() {
            return this.accent1;
        }

        /* JADX INFO: renamed from: component9-0d7_KjU, reason: not valid java name and from getter */
        public final long getAccent2() {
            return this.accent2;
        }

        /* JADX INFO: renamed from: copy-VbAgQ-U, reason: not valid java name */
        public final Colors m4440copyVbAgQU(long background, long text1, long text2, long text3, long callToActionBackground, long callToActionForeground, Color callToActionSecondaryBackground, long accent1, long accent2, long accent3, Color closeButton, Color tierControlBackground, Color tierControlForeground, Color tierControlSelectedBackground, Color tierControlSelectedForeground) {
            return new Colors(background, text1, text2, text3, callToActionBackground, callToActionForeground, callToActionSecondaryBackground, accent1, accent2, accent3, closeButton, tierControlBackground, tierControlForeground, tierControlSelectedBackground, tierControlSelectedForeground, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Colors)) {
                return false;
            }
            Colors colors = (Colors) other;
            return Color.m1367equalsimpl0(this.background, colors.background) && Color.m1367equalsimpl0(this.text1, colors.text1) && Color.m1367equalsimpl0(this.text2, colors.text2) && Color.m1367equalsimpl0(this.text3, colors.text3) && Color.m1367equalsimpl0(this.callToActionBackground, colors.callToActionBackground) && Color.m1367equalsimpl0(this.callToActionForeground, colors.callToActionForeground) && Intrinsics.areEqual(this.callToActionSecondaryBackground, colors.callToActionSecondaryBackground) && Color.m1367equalsimpl0(this.accent1, colors.accent1) && Color.m1367equalsimpl0(this.accent2, colors.accent2) && Color.m1367equalsimpl0(this.accent3, colors.accent3) && Intrinsics.areEqual(this.closeButton, colors.closeButton) && Intrinsics.areEqual(this.tierControlBackground, colors.tierControlBackground) && Intrinsics.areEqual(this.tierControlForeground, colors.tierControlForeground) && Intrinsics.areEqual(this.tierControlSelectedBackground, colors.tierControlSelectedBackground) && Intrinsics.areEqual(this.tierControlSelectedForeground, colors.tierControlSelectedForeground);
        }

        public int hashCode() {
            int iM1373hashCodeimpl = ((((((((((Color.m1373hashCodeimpl(this.background) * 31) + Color.m1373hashCodeimpl(this.text1)) * 31) + Color.m1373hashCodeimpl(this.text2)) * 31) + Color.m1373hashCodeimpl(this.text3)) * 31) + Color.m1373hashCodeimpl(this.callToActionBackground)) * 31) + Color.m1373hashCodeimpl(this.callToActionForeground)) * 31;
            Color color = this.callToActionSecondaryBackground;
            int iM1373hashCodeimpl2 = (((((((iM1373hashCodeimpl + (color == null ? 0 : Color.m1373hashCodeimpl(color.m1375unboximpl()))) * 31) + Color.m1373hashCodeimpl(this.accent1)) * 31) + Color.m1373hashCodeimpl(this.accent2)) * 31) + Color.m1373hashCodeimpl(this.accent3)) * 31;
            Color color2 = this.closeButton;
            int iM1373hashCodeimpl3 = (iM1373hashCodeimpl2 + (color2 == null ? 0 : Color.m1373hashCodeimpl(color2.m1375unboximpl()))) * 31;
            Color color3 = this.tierControlBackground;
            int iM1373hashCodeimpl4 = (iM1373hashCodeimpl3 + (color3 == null ? 0 : Color.m1373hashCodeimpl(color3.m1375unboximpl()))) * 31;
            Color color4 = this.tierControlForeground;
            int iM1373hashCodeimpl5 = (iM1373hashCodeimpl4 + (color4 == null ? 0 : Color.m1373hashCodeimpl(color4.m1375unboximpl()))) * 31;
            Color color5 = this.tierControlSelectedBackground;
            int iM1373hashCodeimpl6 = (iM1373hashCodeimpl5 + (color5 == null ? 0 : Color.m1373hashCodeimpl(color5.m1375unboximpl()))) * 31;
            Color color6 = this.tierControlSelectedForeground;
            return iM1373hashCodeimpl6 + (color6 != null ? Color.m1373hashCodeimpl(color6.m1375unboximpl()) : 0);
        }

        public String toString() {
            return "Colors(background=" + ((Object) Color.m1374toStringimpl(this.background)) + ", text1=" + ((Object) Color.m1374toStringimpl(this.text1)) + ", text2=" + ((Object) Color.m1374toStringimpl(this.text2)) + ", text3=" + ((Object) Color.m1374toStringimpl(this.text3)) + ", callToActionBackground=" + ((Object) Color.m1374toStringimpl(this.callToActionBackground)) + ", callToActionForeground=" + ((Object) Color.m1374toStringimpl(this.callToActionForeground)) + ", callToActionSecondaryBackground=" + this.callToActionSecondaryBackground + ", accent1=" + ((Object) Color.m1374toStringimpl(this.accent1)) + ", accent2=" + ((Object) Color.m1374toStringimpl(this.accent2)) + ", accent3=" + ((Object) Color.m1374toStringimpl(this.accent3)) + ", closeButton=" + this.closeButton + ", tierControlBackground=" + this.tierControlBackground + ", tierControlForeground=" + this.tierControlForeground + ", tierControlSelectedBackground=" + this.tierControlSelectedBackground + ", tierControlSelectedForeground=" + this.tierControlSelectedForeground + ')';
        }

        private Colors(long j, long j2, long j3, long j4, long j5, long j6, Color color, long j7, long j8, long j9, Color color2, Color color3, Color color4, Color color5, Color color6) {
            this.background = j;
            this.text1 = j2;
            this.text2 = j3;
            this.text3 = j4;
            this.callToActionBackground = j5;
            this.callToActionForeground = j6;
            this.callToActionSecondaryBackground = color;
            this.accent1 = j7;
            this.accent2 = j8;
            this.accent3 = j9;
            this.closeButton = color2;
            this.tierControlBackground = color3;
            this.tierControlForeground = color4;
            this.tierControlSelectedBackground = color5;
            this.tierControlSelectedForeground = color6;
        }

        /* JADX INFO: renamed from: getBackground-0d7_KjU, reason: not valid java name */
        public final long m4444getBackground0d7_KjU() {
            return this.background;
        }

        /* JADX INFO: renamed from: getText1-0d7_KjU, reason: not valid java name */
        public final long m4449getText10d7_KjU() {
            return this.text1;
        }

        /* JADX INFO: renamed from: getText2-0d7_KjU, reason: not valid java name */
        public final long m4450getText20d7_KjU() {
            return this.text2;
        }

        /* JADX INFO: renamed from: getText3-0d7_KjU, reason: not valid java name */
        public final long m4451getText30d7_KjU() {
            return this.text3;
        }

        /* JADX INFO: renamed from: getCallToActionBackground-0d7_KjU, reason: not valid java name */
        public final long m4445getCallToActionBackground0d7_KjU() {
            return this.callToActionBackground;
        }

        /* JADX INFO: renamed from: getCallToActionForeground-0d7_KjU, reason: not valid java name */
        public final long m4446getCallToActionForeground0d7_KjU() {
            return this.callToActionForeground;
        }

        /* JADX INFO: renamed from: getCallToActionSecondaryBackground-QN2ZGVo, reason: not valid java name */
        public final Color m4447getCallToActionSecondaryBackgroundQN2ZGVo() {
            return this.callToActionSecondaryBackground;
        }

        /* JADX INFO: renamed from: getAccent1-0d7_KjU, reason: not valid java name */
        public final long m4441getAccent10d7_KjU() {
            return this.accent1;
        }

        /* JADX INFO: renamed from: getAccent2-0d7_KjU, reason: not valid java name */
        public final long m4442getAccent20d7_KjU() {
            return this.accent2;
        }

        /* JADX INFO: renamed from: getAccent3-0d7_KjU, reason: not valid java name */
        public final long m4443getAccent30d7_KjU() {
            return this.accent3;
        }

        /* JADX INFO: renamed from: getCloseButton-QN2ZGVo, reason: not valid java name */
        public final Color m4448getCloseButtonQN2ZGVo() {
            return this.closeButton;
        }

        /* JADX INFO: renamed from: getTierControlBackground-QN2ZGVo, reason: not valid java name */
        public final Color m4452getTierControlBackgroundQN2ZGVo() {
            return this.tierControlBackground;
        }

        /* JADX INFO: renamed from: getTierControlForeground-QN2ZGVo, reason: not valid java name */
        public final Color m4453getTierControlForegroundQN2ZGVo() {
            return this.tierControlForeground;
        }

        /* JADX INFO: renamed from: getTierControlSelectedBackground-QN2ZGVo, reason: not valid java name */
        public final Color m4454getTierControlSelectedBackgroundQN2ZGVo() {
            return this.tierControlSelectedBackground;
        }

        /* JADX INFO: renamed from: getTierControlSelectedForeground-QN2ZGVo, reason: not valid java name */
        public final Color m4455getTierControlSelectedForegroundQN2ZGVo() {
            return this.tierControlSelectedForeground;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\bHÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$TierInfo;", "", "name", "", DiagnosticsEntry.ID_KEY, "defaultPackage", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageInfo;", "packages", "", "(Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageInfo;Ljava/util/List;)V", "getDefaultPackage", "()Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageInfo;", "getId", "()Ljava/lang/String;", "getName", "getPackages", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class TierInfo {
        public static final int $stable = 0;
        private final PackageInfo defaultPackage;
        private final String id;
        private final String name;
        private final List<PackageInfo> packages;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ TierInfo copy$default(TierInfo tierInfo, String str, String str2, PackageInfo packageInfo, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = tierInfo.name;
            }
            if ((i & 2) != 0) {
                str2 = tierInfo.id;
            }
            if ((i & 4) != 0) {
                packageInfo = tierInfo.defaultPackage;
            }
            if ((i & 8) != 0) {
                list = tierInfo.packages;
            }
            return tierInfo.copy(str, str2, packageInfo, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final PackageInfo getDefaultPackage() {
            return this.defaultPackage;
        }

        public final List<PackageInfo> component4() {
            return this.packages;
        }

        public final TierInfo copy(String name, String id, PackageInfo defaultPackage, List<PackageInfo> packages) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(defaultPackage, "defaultPackage");
            Intrinsics.checkNotNullParameter(packages, "packages");
            return new TierInfo(name, id, defaultPackage, packages);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TierInfo)) {
                return false;
            }
            TierInfo tierInfo = (TierInfo) other;
            return Intrinsics.areEqual(this.name, tierInfo.name) && Intrinsics.areEqual(this.id, tierInfo.id) && Intrinsics.areEqual(this.defaultPackage, tierInfo.defaultPackage) && Intrinsics.areEqual(this.packages, tierInfo.packages);
        }

        public int hashCode() {
            return (((((this.name.hashCode() * 31) + this.id.hashCode()) * 31) + this.defaultPackage.hashCode()) * 31) + this.packages.hashCode();
        }

        public String toString() {
            return "TierInfo(name=" + this.name + ", id=" + this.id + ", defaultPackage=" + this.defaultPackage + ", packages=" + this.packages + ')';
        }

        public TierInfo(String name, String id, PackageInfo defaultPackage, List<PackageInfo> packages) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(defaultPackage, "defaultPackage");
            Intrinsics.checkNotNullParameter(packages, "packages");
            this.name = name;
            this.id = id;
            this.defaultPackage = defaultPackage;
            this.packages = packages;
        }

        public final String getName() {
            return this.name;
        }

        public final String getId() {
            return this.id;
        }

        public final PackageInfo getDefaultPackage() {
            return this.defaultPackage;
        }

        public final List<PackageInfo> getPackages() {
            return this.packages;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u000b\f\r\u000eB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0082\u0001\u0003\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageConfiguration;", "", "()V", "all", "", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageInfo;", "getAll", "()Ljava/util/List;", "default", "getDefault", "()Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageInfo;", "MultiPackage", "MultiTier", "Multiple", "Single", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageConfiguration$MultiTier;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageConfiguration$Multiple;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageConfiguration$Single;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static abstract class PackageConfiguration {
        public static final int $stable = 0;

        public /* synthetic */ PackageConfiguration(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract List<PackageInfo> getAll();

        public abstract PackageInfo getDefault();

        private PackageConfiguration() {
        }

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageConfiguration$MultiPackage;", "", "first", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageInfo;", "default", "all", "", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageInfo;Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageInfo;Ljava/util/List;)V", "getAll", "()Ljava/util/List;", "getDefault", "()Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageInfo;", "getFirst", "component1", "component2", "component3", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final /* data */ class MultiPackage {
            public static final int $stable = 0;
            private final List<PackageInfo> all;
            private final PackageInfo default;
            private final PackageInfo first;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ MultiPackage copy$default(MultiPackage multiPackage, PackageInfo packageInfo, PackageInfo packageInfo2, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    packageInfo = multiPackage.first;
                }
                if ((i & 2) != 0) {
                    packageInfo2 = multiPackage.default;
                }
                if ((i & 4) != 0) {
                    list = multiPackage.all;
                }
                return multiPackage.copy(packageInfo, packageInfo2, list);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final PackageInfo getFirst() {
                return this.first;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final PackageInfo getDefault() {
                return this.default;
            }

            public final List<PackageInfo> component3() {
                return this.all;
            }

            public final MultiPackage copy(PackageInfo first, PackageInfo packageInfo, List<PackageInfo> all) {
                Intrinsics.checkNotNullParameter(first, "first");
                Intrinsics.checkNotNullParameter(packageInfo, "default");
                Intrinsics.checkNotNullParameter(all, "all");
                return new MultiPackage(first, packageInfo, all);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof MultiPackage)) {
                    return false;
                }
                MultiPackage multiPackage = (MultiPackage) other;
                return Intrinsics.areEqual(this.first, multiPackage.first) && Intrinsics.areEqual(this.default, multiPackage.default) && Intrinsics.areEqual(this.all, multiPackage.all);
            }

            public int hashCode() {
                return (((this.first.hashCode() * 31) + this.default.hashCode()) * 31) + this.all.hashCode();
            }

            public String toString() {
                return "MultiPackage(first=" + this.first + ", default=" + this.default + ", all=" + this.all + ')';
            }

            public MultiPackage(PackageInfo first, PackageInfo packageInfo, List<PackageInfo> all) {
                Intrinsics.checkNotNullParameter(first, "first");
                Intrinsics.checkNotNullParameter(packageInfo, "default");
                Intrinsics.checkNotNullParameter(all, "all");
                this.first = first;
                this.default = packageInfo;
                this.all = all;
            }

            public final PackageInfo getFirst() {
                return this.first;
            }

            public final PackageInfo getDefault() {
                return this.default;
            }

            public final List<PackageInfo> getAll() {
                return this.all;
            }
        }

        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageConfiguration$Single;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageConfiguration;", "singlePackage", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageInfo;", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageInfo;)V", "all", "", "getAll", "()Ljava/util/List;", "default", "getDefault", "()Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageInfo;", "getSinglePackage", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final /* data */ class Single extends PackageConfiguration {
            public static final int $stable = 0;
            private final PackageInfo singlePackage;

            public static /* synthetic */ Single copy$default(Single single, PackageInfo packageInfo, int i, Object obj) {
                if ((i & 1) != 0) {
                    packageInfo = single.singlePackage;
                }
                return single.copy(packageInfo);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final PackageInfo getSinglePackage() {
                return this.singlePackage;
            }

            public final Single copy(PackageInfo singlePackage) {
                Intrinsics.checkNotNullParameter(singlePackage, "singlePackage");
                return new Single(singlePackage);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Single) && Intrinsics.areEqual(this.singlePackage, ((Single) other).singlePackage);
            }

            public int hashCode() {
                return this.singlePackage.hashCode();
            }

            public String toString() {
                return "Single(singlePackage=" + this.singlePackage + ')';
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Single(PackageInfo singlePackage) {
                super(null);
                Intrinsics.checkNotNullParameter(singlePackage, "singlePackage");
                this.singlePackage = singlePackage;
            }

            public final PackageInfo getSinglePackage() {
                return this.singlePackage;
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration.PackageConfiguration
            public List<PackageInfo> getAll() {
                return CollectionsKt.listOf(this.singlePackage);
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration.PackageConfiguration
            public PackageInfo getDefault() {
                return this.singlePackage;
            }
        }

        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageConfiguration$Multiple;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageConfiguration;", "multiPackage", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageConfiguration$MultiPackage;", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageConfiguration$MultiPackage;)V", "all", "", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageInfo;", "getAll", "()Ljava/util/List;", "default", "getDefault", "()Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageInfo;", "getMultiPackage", "()Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageConfiguration$MultiPackage;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final /* data */ class Multiple extends PackageConfiguration {
            public static final int $stable = 0;
            private final MultiPackage multiPackage;

            public static /* synthetic */ Multiple copy$default(Multiple multiple, MultiPackage multiPackage, int i, Object obj) {
                if ((i & 1) != 0) {
                    multiPackage = multiple.multiPackage;
                }
                return multiple.copy(multiPackage);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final MultiPackage getMultiPackage() {
                return this.multiPackage;
            }

            public final Multiple copy(MultiPackage multiPackage) {
                Intrinsics.checkNotNullParameter(multiPackage, "multiPackage");
                return new Multiple(multiPackage);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Multiple) && Intrinsics.areEqual(this.multiPackage, ((Multiple) other).multiPackage);
            }

            public int hashCode() {
                return this.multiPackage.hashCode();
            }

            public String toString() {
                return "Multiple(multiPackage=" + this.multiPackage + ')';
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Multiple(MultiPackage multiPackage) {
                super(null);
                Intrinsics.checkNotNullParameter(multiPackage, "multiPackage");
                this.multiPackage = multiPackage;
            }

            public final MultiPackage getMultiPackage() {
                return this.multiPackage;
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration.PackageConfiguration
            public List<PackageInfo> getAll() {
                return this.multiPackage.getAll();
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration.PackageConfiguration
            public PackageInfo getDefault() {
                return this.multiPackage.getDefault();
            }
        }

        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageConfiguration$MultiTier;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageConfiguration;", "defaultTier", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$TierInfo;", "allTiers", "", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$TierInfo;Ljava/util/List;)V", "all", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageInfo;", "getAll", "()Ljava/util/List;", "getAllTiers", "default", "getDefault", "()Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageInfo;", "getDefaultTier", "()Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$TierInfo;", "component1", "component2", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final /* data */ class MultiTier extends PackageConfiguration {
            public static final int $stable = 0;
            private final List<TierInfo> allTiers;
            private final TierInfo defaultTier;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ MultiTier copy$default(MultiTier multiTier, TierInfo tierInfo, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    tierInfo = multiTier.defaultTier;
                }
                if ((i & 2) != 0) {
                    list = multiTier.allTiers;
                }
                return multiTier.copy(tierInfo, list);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final TierInfo getDefaultTier() {
                return this.defaultTier;
            }

            public final List<TierInfo> component2() {
                return this.allTiers;
            }

            public final MultiTier copy(TierInfo defaultTier, List<TierInfo> allTiers) {
                Intrinsics.checkNotNullParameter(defaultTier, "defaultTier");
                Intrinsics.checkNotNullParameter(allTiers, "allTiers");
                return new MultiTier(defaultTier, allTiers);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof MultiTier)) {
                    return false;
                }
                MultiTier multiTier = (MultiTier) other;
                return Intrinsics.areEqual(this.defaultTier, multiTier.defaultTier) && Intrinsics.areEqual(this.allTiers, multiTier.allTiers);
            }

            public int hashCode() {
                return (this.defaultTier.hashCode() * 31) + this.allTiers.hashCode();
            }

            public String toString() {
                return "MultiTier(defaultTier=" + this.defaultTier + ", allTiers=" + this.allTiers + ')';
            }

            public final TierInfo getDefaultTier() {
                return this.defaultTier;
            }

            public final List<TierInfo> getAllTiers() {
                return this.allTiers;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public MultiTier(TierInfo defaultTier, List<TierInfo> allTiers) {
                super(null);
                Intrinsics.checkNotNullParameter(defaultTier, "defaultTier");
                Intrinsics.checkNotNullParameter(allTiers, "allTiers");
                this.defaultTier = defaultTier;
                this.allTiers = allTiers;
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration.PackageConfiguration
            public List<PackageInfo> getAll() {
                List<TierInfo> list = this.allTiers;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(((TierInfo) it.next()).getPackages());
                }
                return CollectionsKt.flatten(arrayList);
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration.PackageConfiguration
            public PackageInfo getDefault() {
                return this.defaultTier.getDefaultPackage();
            }
        }
    }
}
