package com.revenuecat.purchases.ui.revenuecatui.data.processed;

import android.net.Uri;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.paywalls.PaywallData;
import com.revenuecat.purchases.ui.revenuecatui.PaywallMode;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JQ\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u0016*\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0012H\u0002\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0018"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfigurationFactory;", "", "()V", "create", "Lkotlin/Result;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration;", "variableDataProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/VariableDataProvider;", "mode", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallMode;", "paywallData", "Lcom/revenuecat/purchases/paywalls/PaywallData;", "availablePackages", "", "Lcom/revenuecat/purchases/Package;", "template", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/PaywallTemplate;", "storefrontCountryCode", "", "create-hUnOzRk", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/VariableDataProvider;Lcom/revenuecat/purchases/ui/revenuecatui/PaywallMode;Lcom/revenuecat/purchases/paywalls/PaywallData;Ljava/util/List;Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/PaywallTemplate;Ljava/lang/String;)Ljava/lang/Object;", "getUriFromImage", "Landroid/net/Uri;", "image", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TemplateConfigurationFactory {
    public static final int $stable = 0;
    public static final TemplateConfigurationFactory INSTANCE = new TemplateConfigurationFactory();

    private TemplateConfigurationFactory() {
    }

    /* JADX INFO: renamed from: create-hUnOzRk, reason: not valid java name */
    public final Object m4456createhUnOzRk(VariableDataProvider variableDataProvider, PaywallMode mode, PaywallData paywallData, List<Package> availablePackages, PaywallTemplate template, String storefrontCountryCode) {
        Map mapEmptyMap;
        Intrinsics.checkNotNullParameter(variableDataProvider, "variableDataProvider");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(paywallData, "paywallData");
        Intrinsics.checkNotNullParameter(availablePackages, "availablePackages");
        Intrinsics.checkNotNullParameter(template, "template");
        PaywallData.Configuration.Images images = paywallData.getConfig().getImages();
        TemplateConfiguration.Images images2 = new TemplateConfiguration.Images(getUriFromImage(paywallData, images.getIcon()), getUriFromImage(paywallData, images.getBackground()), getUriFromImage(paywallData, images.getHeader()));
        Map<String, PaywallData.Configuration.Images> imagesByTier = paywallData.getConfig().getImagesByTier();
        if (imagesByTier == null) {
            mapEmptyMap = MapsKt.emptyMap();
        } else {
            mapEmptyMap = new LinkedHashMap(MapsKt.mapCapacity(imagesByTier.size()));
            Iterator<T> it = imagesByTier.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Object key = entry.getKey();
                TemplateConfigurationFactory templateConfigurationFactory = INSTANCE;
                mapEmptyMap.put(key, new TemplateConfiguration.Images(templateConfigurationFactory.getUriFromImage(paywallData, ((PaywallData.Configuration.Images) entry.getValue()).getIcon()), templateConfigurationFactory.getUriFromImage(paywallData, ((PaywallData.Configuration.Images) entry.getValue()).getBackground()), templateConfigurationFactory.getUriFromImage(paywallData, ((PaywallData.Configuration.Images) entry.getValue()).getHeader())));
            }
        }
        Map map = mapEmptyMap;
        Object objM4423createPackageConfigurationbMdYcbs = PackageConfigurationFactory.INSTANCE.m4423createPackageConfigurationbMdYcbs(variableDataProvider, availablePackages, paywallData.getConfig().getPackageIds(), paywallData.getConfig().getDefaultPackage(), template.getConfigurationType(), paywallData, storefrontCountryCode);
        Throwable thM5246exceptionOrNullimpl = Result.m5246exceptionOrNullimpl(objM4423createPackageConfigurationbMdYcbs);
        if (thM5246exceptionOrNullimpl != null) {
            return Result.m5243constructorimpl(ResultKt.createFailure(thM5246exceptionOrNullimpl));
        }
        Pair pair = (Pair) objM4423createPackageConfigurationbMdYcbs;
        return Result.m5243constructorimpl(new TemplateConfiguration(template, mode, (TemplateConfiguration.PackageConfiguration) pair.getSecond(), paywallData.getConfig(), images2, map, paywallData.getConfig().getColors(), (Locale) pair.getFirst()));
    }

    private final Uri getUriFromImage(PaywallData paywallData, String str) {
        if (str != null) {
            return Uri.parse(paywallData.getAssetBaseURL().toString()).buildUpon().path(str).build();
        }
        return null;
    }
}
