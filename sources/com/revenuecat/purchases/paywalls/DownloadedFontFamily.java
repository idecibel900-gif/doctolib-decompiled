package com.revenuecat.purchases.paywalls;

import com.revenuecat.purchases.InternalRevenueCatAPI;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/revenuecat/purchases/paywalls/DownloadedFontFamily;", "", "family", "", "fonts", "", "Lcom/revenuecat/purchases/paywalls/DownloadedFont;", "(Ljava/lang/String;Ljava/util/List;)V", "getFamily", "()Ljava/lang/String;", "getFonts", "()Ljava/util/List;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DownloadedFontFamily {
    private final String family;
    private final List<DownloadedFont> fonts;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DownloadedFontFamily)) {
            return false;
        }
        DownloadedFontFamily downloadedFontFamily = (DownloadedFontFamily) obj;
        return Intrinsics.areEqual(this.family, downloadedFontFamily.family) && Intrinsics.areEqual(this.fonts, downloadedFontFamily.fonts);
    }

    public int hashCode() {
        return (this.family.hashCode() * 31) + this.fonts.hashCode();
    }

    public String toString() {
        return "DownloadedFontFamily(family=" + this.family + ", fonts=" + this.fonts + ')';
    }

    public DownloadedFontFamily(String family, List<DownloadedFont> fonts) {
        Intrinsics.checkNotNullParameter(family, "family");
        Intrinsics.checkNotNullParameter(fonts, "fonts");
        this.family = family;
        this.fonts = fonts;
    }

    public final /* synthetic */ String getFamily() {
        return this.family;
    }

    public /* synthetic */ DownloadedFontFamily(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final /* synthetic */ List getFonts() {
        return this.fonts;
    }
}
