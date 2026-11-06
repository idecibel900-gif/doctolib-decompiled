package com.revenuecat.purchases.ui.revenuecatui.defaultpaywall;

import android.graphics.Bitmap;
import androidx.compose.ui.graphics.Color;
import com.opentok.android.PublisherKit;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B;\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0010JD\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\t\u0010\u0010R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/defaultpaywall/DefaultPaywallPreviewOverrides;", "", "appName", "", "appIconBitmap", "Landroid/graphics/Bitmap;", "prominentColors", "", "Landroidx/compose/ui/graphics/Color;", "isDebugBuild", "", "(Ljava/lang/String;Landroid/graphics/Bitmap;Ljava/util/List;Ljava/lang/Boolean;)V", "getAppIconBitmap", "()Landroid/graphics/Bitmap;", "getAppName", "()Ljava/lang/String;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getProminentColors", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Landroid/graphics/Bitmap;Ljava/util/List;Ljava/lang/Boolean;)Lcom/revenuecat/purchases/ui/revenuecatui/defaultpaywall/DefaultPaywallPreviewOverrides;", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class DefaultPaywallPreviewOverrides {
    public static final int $stable = 8;
    private final Bitmap appIconBitmap;
    private final String appName;
    private final Boolean isDebugBuild;
    private final List<Color> prominentColors;

    public DefaultPaywallPreviewOverrides() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DefaultPaywallPreviewOverrides copy$default(DefaultPaywallPreviewOverrides defaultPaywallPreviewOverrides, String str, Bitmap bitmap, List list, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = defaultPaywallPreviewOverrides.appName;
        }
        if ((i & 2) != 0) {
            bitmap = defaultPaywallPreviewOverrides.appIconBitmap;
        }
        if ((i & 4) != 0) {
            list = defaultPaywallPreviewOverrides.prominentColors;
        }
        if ((i & 8) != 0) {
            bool = defaultPaywallPreviewOverrides.isDebugBuild;
        }
        return defaultPaywallPreviewOverrides.copy(str, bitmap, list, bool);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAppName() {
        return this.appName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Bitmap getAppIconBitmap() {
        return this.appIconBitmap;
    }

    public final List<Color> component3() {
        return this.prominentColors;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Boolean getIsDebugBuild() {
        return this.isDebugBuild;
    }

    public final DefaultPaywallPreviewOverrides copy(String appName, Bitmap appIconBitmap, List<Color> prominentColors, Boolean isDebugBuild) {
        return new DefaultPaywallPreviewOverrides(appName, appIconBitmap, prominentColors, isDebugBuild);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DefaultPaywallPreviewOverrides)) {
            return false;
        }
        DefaultPaywallPreviewOverrides defaultPaywallPreviewOverrides = (DefaultPaywallPreviewOverrides) other;
        return Intrinsics.areEqual(this.appName, defaultPaywallPreviewOverrides.appName) && Intrinsics.areEqual(this.appIconBitmap, defaultPaywallPreviewOverrides.appIconBitmap) && Intrinsics.areEqual(this.prominentColors, defaultPaywallPreviewOverrides.prominentColors) && Intrinsics.areEqual(this.isDebugBuild, defaultPaywallPreviewOverrides.isDebugBuild);
    }

    public int hashCode() {
        String str = this.appName;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Bitmap bitmap = this.appIconBitmap;
        int iHashCode2 = (iHashCode + (bitmap == null ? 0 : bitmap.hashCode())) * 31;
        List<Color> list = this.prominentColors;
        int iHashCode3 = (iHashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        Boolean bool = this.isDebugBuild;
        return iHashCode3 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "DefaultPaywallPreviewOverrides(appName=" + this.appName + ", appIconBitmap=" + this.appIconBitmap + ", prominentColors=" + this.prominentColors + ", isDebugBuild=" + this.isDebugBuild + ')';
    }

    public DefaultPaywallPreviewOverrides(String str, Bitmap bitmap, List<Color> list, Boolean bool) {
        this.appName = str;
        this.appIconBitmap = bitmap;
        this.prominentColors = list;
        this.isDebugBuild = bool;
    }

    public /* synthetic */ DefaultPaywallPreviewOverrides(String str, Bitmap bitmap, List list, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : bitmap, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : bool);
    }

    public final String getAppName() {
        return this.appName;
    }

    public final Bitmap getAppIconBitmap() {
        return this.appIconBitmap;
    }

    public final List<Color> getProminentColors() {
        return this.prominentColors;
    }

    public final Boolean isDebugBuild() {
        return this.isDebugBuild;
    }
}
