package com.revenuecat.purchases.ui.revenuecatui.components.properties;

import androidx.compose.ui.text.font.FontFamily;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.paywalls.DownloadedFontFamily;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0006\u0002\u0003\u0004\u0005\u0006\u0007\u0082\u0001\u0006\b\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/FontSpec;", "", "Asset", "Downloaded", "Generic", "Google", "Resource", "System", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/FontSpec$Asset;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/FontSpec$Downloaded;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/FontSpec$Generic;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/FontSpec$Google;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/FontSpec$Resource;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/FontSpec$System;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface FontSpec {

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/FontSpec$Resource;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/FontSpec;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "(Landroidx/compose/ui/text/font/FontFamily;)V", "getFontFamily", "()Landroidx/compose/ui/text/font/FontFamily;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Resource implements FontSpec {
        public static final int $stable = 0;
        private final FontFamily fontFamily;

        public static /* synthetic */ Resource copy$default(Resource resource, FontFamily fontFamily, int i, Object obj) {
            if ((i & 1) != 0) {
                fontFamily = resource.fontFamily;
            }
            return resource.copy(fontFamily);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final FontFamily getFontFamily() {
            return this.fontFamily;
        }

        public final Resource copy(FontFamily fontFamily) {
            Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
            return new Resource(fontFamily);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Resource) && Intrinsics.areEqual(this.fontFamily, ((Resource) other).fontFamily);
        }

        public int hashCode() {
            return this.fontFamily.hashCode();
        }

        public String toString() {
            return "Resource(fontFamily=" + this.fontFamily + ')';
        }

        public Resource(FontFamily fontFamily) {
            Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
            this.fontFamily = fontFamily;
        }

        public final /* synthetic */ FontFamily getFontFamily() {
            return this.fontFamily;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/FontSpec$Asset;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/FontSpec;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "(Landroidx/compose/ui/text/font/FontFamily;)V", "getFontFamily", "()Landroidx/compose/ui/text/font/FontFamily;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Asset implements FontSpec {
        public static final int $stable = 0;
        private final FontFamily fontFamily;

        public static /* synthetic */ Asset copy$default(Asset asset, FontFamily fontFamily, int i, Object obj) {
            if ((i & 1) != 0) {
                fontFamily = asset.fontFamily;
            }
            return asset.copy(fontFamily);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final FontFamily getFontFamily() {
            return this.fontFamily;
        }

        public final Asset copy(FontFamily fontFamily) {
            Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
            return new Asset(fontFamily);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Asset) && Intrinsics.areEqual(this.fontFamily, ((Asset) other).fontFamily);
        }

        public int hashCode() {
            return this.fontFamily.hashCode();
        }

        public String toString() {
            return "Asset(fontFamily=" + this.fontFamily + ')';
        }

        public Asset(FontFamily fontFamily) {
            Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
            this.fontFamily = fontFamily;
        }

        public final /* synthetic */ FontFamily getFontFamily() {
            return this.fontFamily;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/FontSpec$Google;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/FontSpec;", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Google implements FontSpec {
        public static final int $stable = 0;
        private final String name;

        public static /* synthetic */ Google copy$default(Google google, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = google.name;
            }
            return google.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final Google copy(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return new Google(name);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Google) && Intrinsics.areEqual(this.name, ((Google) other).name);
        }

        public int hashCode() {
            return this.name.hashCode();
        }

        public String toString() {
            return "Google(name=" + this.name + ')';
        }

        public Google(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
        }

        public final /* synthetic */ String getName() {
            return this.name;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/FontSpec$Generic;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/FontSpec;", "Monospace", "SansSerif", "Serif", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/FontSpec$Generic$Monospace;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/FontSpec$Generic$SansSerif;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/FontSpec$Generic$Serif;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Generic extends FontSpec {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/FontSpec$Generic$SansSerif;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/FontSpec$Generic;", "()V", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class SansSerif implements Generic {
            public static final int $stable = 0;
            public static final SansSerif INSTANCE = new SansSerif();

            private SansSerif() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/FontSpec$Generic$Serif;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/FontSpec$Generic;", "()V", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Serif implements Generic {
            public static final int $stable = 0;
            public static final Serif INSTANCE = new Serif();

            private Serif() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/FontSpec$Generic$Monospace;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/FontSpec$Generic;", "()V", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Monospace implements Generic {
            public static final int $stable = 0;
            public static final Monospace INSTANCE = new Monospace();

            private Monospace() {
            }
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/FontSpec$Downloaded;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/FontSpec;", "downloadedFontFamily", "Lcom/revenuecat/purchases/paywalls/DownloadedFontFamily;", "(Lcom/revenuecat/purchases/paywalls/DownloadedFontFamily;)V", "getDownloadedFontFamily", "()Lcom/revenuecat/purchases/paywalls/DownloadedFontFamily;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Downloaded implements FontSpec {
        public static final int $stable = 8;
        private final DownloadedFontFamily downloadedFontFamily;

        public static /* synthetic */ Downloaded copy$default(Downloaded downloaded, DownloadedFontFamily downloadedFontFamily, int i, Object obj) {
            if ((i & 1) != 0) {
                downloadedFontFamily = downloaded.downloadedFontFamily;
            }
            return downloaded.copy(downloadedFontFamily);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final DownloadedFontFamily getDownloadedFontFamily() {
            return this.downloadedFontFamily;
        }

        public final Downloaded copy(DownloadedFontFamily downloadedFontFamily) {
            Intrinsics.checkNotNullParameter(downloadedFontFamily, "downloadedFontFamily");
            return new Downloaded(downloadedFontFamily);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Downloaded) && Intrinsics.areEqual(this.downloadedFontFamily, ((Downloaded) other).downloadedFontFamily);
        }

        public int hashCode() {
            return this.downloadedFontFamily.hashCode();
        }

        public String toString() {
            return "Downloaded(downloadedFontFamily=" + this.downloadedFontFamily + ')';
        }

        public Downloaded(DownloadedFontFamily downloadedFontFamily) {
            Intrinsics.checkNotNullParameter(downloadedFontFamily, "downloadedFontFamily");
            this.downloadedFontFamily = downloadedFontFamily;
        }

        public final /* synthetic */ DownloadedFontFamily getDownloadedFontFamily() {
            return this.downloadedFontFamily;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/FontSpec$System;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/FontSpec;", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class System implements FontSpec {
        public static final int $stable = 0;
        private final String name;

        public static /* synthetic */ System copy$default(System system, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = system.name;
            }
            return system.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final System copy(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return new System(name);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof System) && Intrinsics.areEqual(this.name, ((System) other).name);
        }

        public int hashCode() {
            return this.name.hashCode();
        }

        public String toString() {
            return "System(name=" + this.name + ')';
        }

        public System(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
        }

        public final /* synthetic */ String getName() {
            return this.name;
        }
    }
}
