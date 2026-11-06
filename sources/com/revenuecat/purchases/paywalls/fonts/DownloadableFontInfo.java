package com.revenuecat.purchases.paywalls.fonts;

import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.paywalls.components.properties.FontStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/revenuecat/purchases/paywalls/fonts/DownloadableFontInfo;", "", "url", "", "expectedMd5", "family", "weight", "", "style", "Lcom/revenuecat/purchases/paywalls/components/properties/FontStyle;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/revenuecat/purchases/paywalls/components/properties/FontStyle;)V", "getExpectedMd5", "()Ljava/lang/String;", "getFamily", "getStyle", "()Lcom/revenuecat/purchases/paywalls/components/properties/FontStyle;", "getUrl", "getWeight", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "toString", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class DownloadableFontInfo {
    private final String expectedMd5;
    private final String family;
    private final FontStyle style;
    private final String url;
    private final int weight;

    public static /* synthetic */ DownloadableFontInfo copy$default(DownloadableFontInfo downloadableFontInfo, String str, String str2, String str3, int i, FontStyle fontStyle, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = downloadableFontInfo.url;
        }
        if ((i2 & 2) != 0) {
            str2 = downloadableFontInfo.expectedMd5;
        }
        if ((i2 & 4) != 0) {
            str3 = downloadableFontInfo.family;
        }
        if ((i2 & 8) != 0) {
            i = downloadableFontInfo.weight;
        }
        if ((i2 & 16) != 0) {
            fontStyle = downloadableFontInfo.style;
        }
        FontStyle fontStyle2 = fontStyle;
        String str4 = str3;
        return downloadableFontInfo.copy(str, str2, str4, i, fontStyle2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getExpectedMd5() {
        return this.expectedMd5;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getFamily() {
        return this.family;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getWeight() {
        return this.weight;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final FontStyle getStyle() {
        return this.style;
    }

    public final DownloadableFontInfo copy(String url, String expectedMd5, String family, int weight, FontStyle style) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(expectedMd5, "expectedMd5");
        Intrinsics.checkNotNullParameter(family, "family");
        Intrinsics.checkNotNullParameter(style, "style");
        return new DownloadableFontInfo(url, expectedMd5, family, weight, style);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DownloadableFontInfo)) {
            return false;
        }
        DownloadableFontInfo downloadableFontInfo = (DownloadableFontInfo) other;
        return Intrinsics.areEqual(this.url, downloadableFontInfo.url) && Intrinsics.areEqual(this.expectedMd5, downloadableFontInfo.expectedMd5) && Intrinsics.areEqual(this.family, downloadableFontInfo.family) && this.weight == downloadableFontInfo.weight && this.style == downloadableFontInfo.style;
    }

    public int hashCode() {
        return (((((((this.url.hashCode() * 31) + this.expectedMd5.hashCode()) * 31) + this.family.hashCode()) * 31) + Integer.hashCode(this.weight)) * 31) + this.style.hashCode();
    }

    public String toString() {
        return "DownloadableFontInfo(url=" + this.url + ", expectedMd5=" + this.expectedMd5 + ", family=" + this.family + ", weight=" + this.weight + ", style=" + this.style + ')';
    }

    public DownloadableFontInfo(String url, String expectedMd5, String family, int i, FontStyle style) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(expectedMd5, "expectedMd5");
        Intrinsics.checkNotNullParameter(family, "family");
        Intrinsics.checkNotNullParameter(style, "style");
        this.url = url;
        this.expectedMd5 = expectedMd5;
        this.family = family;
        this.weight = i;
        this.style = style;
    }

    public final /* synthetic */ String getUrl() {
        return this.url;
    }

    public final /* synthetic */ String getExpectedMd5() {
        return this.expectedMd5;
    }

    public final /* synthetic */ String getFamily() {
        return this.family;
    }

    public final /* synthetic */ int getWeight() {
        return this.weight;
    }

    public final /* synthetic */ FontStyle getStyle() {
        return this.style;
    }
}
