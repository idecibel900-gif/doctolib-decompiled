package com.revenuecat.purchases.ui.revenuecatui.helpers;

import android.content.res.AssetManager;
import androidx.compose.ui.text.font.FontFamily;
import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.paywalls.DownloadedFontFamily;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cJ\b\u0010\u0002\u001a\u00020\u0003H&J$\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H&J\n\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u000fH&J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003H&J+\u0010\u0014\u001a\u00020\u00032\b\b\u0001\u0010\u0015\u001a\u00020\u00112\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0017\"\u00020\u0001H&¢\u0006\u0002\u0010\u0018J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u0011H&¨\u0006\u001d"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResourceProvider;", "", "getApplicationName", "", "getAssetFontPaths", "", "names", "", "getAssetManager", "Landroid/content/res/AssetManager;", "getCachedFontFamilyOrStartDownload", "Lcom/revenuecat/purchases/paywalls/DownloadedFontFamily;", "fontInfo", "Lcom/revenuecat/purchases/UiConfig$AppConfig$FontsConfig$FontInfo$Name;", "getLocale", "Ljava/util/Locale;", "getResourceIdentifier", "", "name", "type", "getString", "resId", "formatArgs", "", "(I[Ljava/lang/Object;)Ljava/lang/String;", "getXmlFontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "resourceId", "Companion", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ResourceProvider {
    public static final String ASSETS_FONTS_DIR = "fonts";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    String getApplicationName();

    Map<String, String> getAssetFontPaths(List<String> names);

    AssetManager getAssetManager();

    DownloadedFontFamily getCachedFontFamilyOrStartDownload(UiConfig.AppConfig.FontsConfig.FontInfo.Name fontInfo);

    Locale getLocale();

    int getResourceIdentifier(String name, String type);

    String getString(int resId, Object... formatArgs);

    FontFamily getXmlFontFamily(int resourceId);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResourceProvider$Companion;", "", "()V", "ASSETS_FONTS_DIR", "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String ASSETS_FONTS_DIR = "fonts";

        private Companion() {
        }
    }
}
