package com.revenuecat.purchases.paywalls;

import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.paywalls.components.properties.FontStyle;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/revenuecat/purchases/paywalls/DownloadedFont;", "", "weight", "", "style", "Lcom/revenuecat/purchases/paywalls/components/properties/FontStyle;", "file", "Ljava/io/File;", "(ILcom/revenuecat/purchases/paywalls/components/properties/FontStyle;Ljava/io/File;)V", "getFile", "()Ljava/io/File;", "getStyle", "()Lcom/revenuecat/purchases/paywalls/components/properties/FontStyle;", "getWeight", "()I", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DownloadedFont {
    private final File file;
    private final FontStyle style;
    private final int weight;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DownloadedFont)) {
            return false;
        }
        DownloadedFont downloadedFont = (DownloadedFont) obj;
        return this.weight == downloadedFont.weight && this.style == downloadedFont.style && Intrinsics.areEqual(this.file, downloadedFont.file);
    }

    public int hashCode() {
        return (((this.weight * 31) + this.style.hashCode()) * 31) + this.file.hashCode();
    }

    public String toString() {
        return "DownloadedFont(weight=" + this.weight + ", style=" + this.style + ", file=" + this.file + ')';
    }

    public DownloadedFont(int i, FontStyle style, File file) {
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(file, "file");
        this.weight = i;
        this.style = style;
        this.file = file;
    }

    public final /* synthetic */ int getWeight() {
        return this.weight;
    }

    public final /* synthetic */ FontStyle getStyle() {
        return this.style;
    }

    public final /* synthetic */ File getFile() {
        return this.file;
    }
}
