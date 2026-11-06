package com.revenuecat.purchases.ui.revenuecatui.data.testdata;

import android.content.res.AssetManager;
import androidx.compose.ui.text.font.FontFamily;
import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.paywalls.DownloadedFontFamily;
import com.revenuecat.purchases.ui.revenuecatui.R;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResourceProvider;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001Bo\u0012 \b\u0002\u0010\u0002\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\u0003\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0004H\u0016J$\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0004H\u0016J)\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00052\u0012\u0010\u001d\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001f0\u001e\"\u00020\u001fH\u0016¢\u0006\u0002\u0010 J\u0012\u0010!\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\"\u001a\u00020\u0005H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0002\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/testdata/MockResourceProvider;", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResourceProvider;", "resourceIds", "", "", "", "assetPaths", "", "downloadedFilesByUrl", "Lcom/revenuecat/purchases/paywalls/DownloadedFontFamily;", "fontFamiliesByXmlResourceId", "Landroidx/compose/ui/text/font/FontFamily;", "mockAssetManager", "Landroid/content/res/AssetManager;", "(Ljava/util/Map;Ljava/util/List;Ljava/util/Map;Ljava/util/Map;Landroid/content/res/AssetManager;)V", "getApplicationName", "getAssetFontPaths", "names", "getAssetManager", "getCachedFontFamilyOrStartDownload", "fontInfo", "Lcom/revenuecat/purchases/UiConfig$AppConfig$FontsConfig$FontInfo$Name;", "getLocale", "Ljava/util/Locale;", "getResourceIdentifier", "name", "type", "getString", "resId", "formatArgs", "", "", "(I[Ljava/lang/Object;)Ljava/lang/String;", "getXmlFontFamily", "resourceId", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MockResourceProvider implements ResourceProvider {
    public static final int $stable = 8;
    private final List<String> assetPaths;
    private final Map<String, DownloadedFontFamily> downloadedFilesByUrl;
    private final Map<Integer, FontFamily> fontFamiliesByXmlResourceId;
    private final AssetManager mockAssetManager;
    private final Map<String, Map<String, Integer>> resourceIds;

    public MockResourceProvider() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MockResourceProvider(Map<String, ? extends Map<String, Integer>> resourceIds, List<String> assetPaths, Map<String, DownloadedFontFamily> downloadedFilesByUrl, Map<Integer, ? extends FontFamily> fontFamiliesByXmlResourceId, AssetManager assetManager) {
        Intrinsics.checkNotNullParameter(resourceIds, "resourceIds");
        Intrinsics.checkNotNullParameter(assetPaths, "assetPaths");
        Intrinsics.checkNotNullParameter(downloadedFilesByUrl, "downloadedFilesByUrl");
        Intrinsics.checkNotNullParameter(fontFamiliesByXmlResourceId, "fontFamiliesByXmlResourceId");
        this.resourceIds = resourceIds;
        this.assetPaths = assetPaths;
        this.downloadedFilesByUrl = downloadedFilesByUrl;
        this.fontFamiliesByXmlResourceId = fontFamiliesByXmlResourceId;
        this.mockAssetManager = assetManager;
    }

    public /* synthetic */ MockResourceProvider(Map map, List list, Map map2, Map map3, AssetManager assetManager, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? MapsKt.emptyMap() : map, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? MapsKt.emptyMap() : map2, (i & 8) != 0 ? MapsKt.emptyMap() : map3, (i & 16) != 0 ? null : assetManager);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.helpers.ResourceProvider
    public String getApplicationName() {
        return "Mock Paywall";
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.helpers.ResourceProvider
    public String getString(int resId, Object... formatArgs) {
        Intrinsics.checkNotNullParameter(formatArgs, "formatArgs");
        if (resId == R.string.restore_purchases) {
            return "Restore purchases";
        }
        if (resId == R.string.annual) {
            return "Annual";
        }
        if (resId == R.string.semester) {
            return "6 month";
        }
        if (resId == R.string.quarter) {
            return "3 month";
        }
        if (resId == R.string.bimonthly) {
            return "2 month";
        }
        if (resId == R.string.monthly) {
            return "Monthly";
        }
        if (resId == R.string.weekly) {
            return "Weekly";
        }
        if (resId == R.string.lifetime) {
            return "Lifetime";
        }
        if (resId == R.string.continue_cta) {
            return "Continue";
        }
        if (resId == R.string.default_offer_details_with_intro_offer) {
            return "Start your {{ sub_offer_duration }} trial, then {{ total_price_and_per_month }}.";
        }
        if (resId == R.string.package_discount) {
            return formatArgs[0] + "% off";
        }
        throw new IllegalStateException(("Unknown string resource " + resId).toString());
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.helpers.ResourceProvider
    public Locale getLocale() {
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        return locale;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.helpers.ResourceProvider
    public int getResourceIdentifier(String name, String type) {
        Integer num;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        Map<String, Integer> map = this.resourceIds.get(type);
        if (map == null || (num = map.get(name)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.helpers.ResourceProvider
    public FontFamily getXmlFontFamily(int resourceId) {
        return this.fontFamiliesByXmlResourceId.get(Integer.valueOf(resourceId));
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.helpers.ResourceProvider
    public Map<String, String> getAssetFontPaths(List<String> names) {
        Intrinsics.checkNotNullParameter(names, "names");
        List<String> list = names;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
        for (Object obj : list) {
            String str = (String) obj;
            if (!StringsKt.endsWith$default(str, ".ttf", false, 2, (Object) null)) {
                str = str + ".ttf";
            }
            linkedHashMap.put(obj, "fonts/" + str);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (this.assetPaths.contains(entry.getValue())) {
                linkedHashMap2.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap2;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.helpers.ResourceProvider
    public DownloadedFontFamily getCachedFontFamilyOrStartDownload(UiConfig.AppConfig.FontsConfig.FontInfo.Name fontInfo) {
        Intrinsics.checkNotNullParameter(fontInfo, "fontInfo");
        return this.downloadedFilesByUrl.get(fontInfo.getUrl());
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.helpers.ResourceProvider
    /* JADX INFO: renamed from: getAssetManager, reason: from getter */
    public AssetManager getMockAssetManager() {
        return this.mockAssetManager;
    }
}
