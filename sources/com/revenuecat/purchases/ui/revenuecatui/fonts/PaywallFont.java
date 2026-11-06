package com.revenuecat.purchases.ui.revenuecatui.fonts;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/fonts/PaywallFont;", "Landroid/os/Parcelable;", "()V", "AssetFont", "GoogleFont", "ResourceFont", "Lcom/revenuecat/purchases/ui/revenuecatui/fonts/PaywallFont$AssetFont;", "Lcom/revenuecat/purchases/ui/revenuecatui/fonts/PaywallFont$GoogleFont;", "Lcom/revenuecat/purchases/ui/revenuecatui/fonts/PaywallFont$ResourceFont;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class PaywallFont implements Parcelable {
    public static final int $stable = 0;

    public /* synthetic */ PaywallFont(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private PaywallFont() {
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0015\u001a\u00020\tHÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0006\u001a\u00020\u0007¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001b"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/fonts/PaywallFont$GoogleFont;", "Lcom/revenuecat/purchases/ui/revenuecatui/fonts/PaywallFont;", "fontName", "", "fontProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/fonts/GoogleFontProvider;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "", "(Ljava/lang/String;Lcom/revenuecat/purchases/ui/revenuecatui/fonts/GoogleFontProvider;Landroidx/compose/ui/text/font/FontWeight;I)V", "getFontName", "()Ljava/lang/String;", "getFontProvider", "()Lcom/revenuecat/purchases/ui/revenuecatui/fonts/GoogleFontProvider;", "getFontStyle", "()I", "getFontWeight$annotations", "()V", "getFontWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class GoogleFont extends PaywallFont {
        public static final int $stable = 0;
        public static final Parcelable.Creator<GoogleFont> CREATOR = new Creator();
        private final String fontName;
        private final GoogleFontProvider fontProvider;
        private final int fontStyle;
        private final FontWeight fontWeight;

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<GoogleFont> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final GoogleFont createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new GoogleFont(parcel.readString(), GoogleFontProvider.CREATOR.createFromParcel(parcel), FontWeightParceler.INSTANCE.m4518create(parcel), parcel.readInt());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final GoogleFont[] newArray(int i) {
                return new GoogleFont[i];
            }
        }

        public static /* synthetic */ void getFontWeight$annotations() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof GoogleFont)) {
                return false;
            }
            GoogleFont googleFont = (GoogleFont) obj;
            return Intrinsics.areEqual(this.fontName, googleFont.fontName) && Intrinsics.areEqual(this.fontProvider, googleFont.fontProvider) && Intrinsics.areEqual(this.fontWeight, googleFont.fontWeight) && this.fontStyle == googleFont.fontStyle;
        }

        public int hashCode() {
            return (((((this.fontName.hashCode() * 31) + this.fontProvider.hashCode()) * 31) + this.fontWeight.hashCode()) * 31) + this.fontStyle;
        }

        public String toString() {
            return "GoogleFont(fontName=" + this.fontName + ", fontProvider=" + this.fontProvider + ", fontWeight=" + this.fontWeight + ", fontStyle=" + this.fontStyle + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.fontName);
            this.fontProvider.writeToParcel(parcel, flags);
            FontWeightParceler.INSTANCE.write(this.fontWeight, parcel, flags);
            parcel.writeInt(this.fontStyle);
        }

        public final String getFontName() {
            return this.fontName;
        }

        public final GoogleFontProvider getFontProvider() {
            return this.fontProvider;
        }

        public /* synthetic */ GoogleFont(String str, GoogleFontProvider googleFontProvider, FontWeight fontWeight, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, googleFontProvider, (i2 & 4) != 0 ? FontWeight.Companion.getNormal() : fontWeight, (i2 & 8) != 0 ? FontStyle.Companion.m2289getNormal_LCdwA() : i);
        }

        public final FontWeight getFontWeight() {
            return this.fontWeight;
        }

        public final int getFontStyle() {
            return this.fontStyle;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GoogleFont(String fontName, GoogleFontProvider fontProvider, FontWeight fontWeight, int i) {
            super(null);
            Intrinsics.checkNotNullParameter(fontName, "fontName");
            Intrinsics.checkNotNullParameter(fontProvider, "fontProvider");
            Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
            this.fontName = fontName;
            this.fontProvider = fontProvider;
            this.fontWeight = fontWeight;
            this.fontStyle = i;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B#\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\u00020\u0005¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/fonts/PaywallFont$ResourceFont;", "Lcom/revenuecat/purchases/ui/revenuecatui/fonts/PaywallFont;", "resourceId", "", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "(ILandroidx/compose/ui/text/font/FontWeight;I)V", "getFontStyle", "()I", "getFontWeight$annotations", "()V", "getFontWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "getResourceId", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ResourceFont extends PaywallFont {
        public static final int $stable = 0;
        public static final Parcelable.Creator<ResourceFont> CREATOR = new Creator();
        private final int fontStyle;
        private final FontWeight fontWeight;
        private final int resourceId;

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<ResourceFont> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final ResourceFont createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new ResourceFont(parcel.readInt(), FontWeightParceler.INSTANCE.m4518create(parcel), parcel.readInt());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final ResourceFont[] newArray(int i) {
                return new ResourceFont[i];
            }
        }

        public static /* synthetic */ void getFontWeight$annotations() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ResourceFont)) {
                return false;
            }
            ResourceFont resourceFont = (ResourceFont) obj;
            return this.resourceId == resourceFont.resourceId && Intrinsics.areEqual(this.fontWeight, resourceFont.fontWeight) && this.fontStyle == resourceFont.fontStyle;
        }

        public int hashCode() {
            return (((this.resourceId * 31) + this.fontWeight.hashCode()) * 31) + this.fontStyle;
        }

        public String toString() {
            return "ResourceFont(resourceId=" + this.resourceId + ", fontWeight=" + this.fontWeight + ", fontStyle=" + this.fontStyle + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(this.resourceId);
            FontWeightParceler.INSTANCE.write(this.fontWeight, parcel, flags);
            parcel.writeInt(this.fontStyle);
        }

        public final int getResourceId() {
            return this.resourceId;
        }

        public /* synthetic */ ResourceFont(int i, FontWeight fontWeight, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i3 & 2) != 0 ? FontWeight.Companion.getNormal() : fontWeight, (i3 & 4) != 0 ? FontStyle.Companion.m2289getNormal_LCdwA() : i2);
        }

        public final FontWeight getFontWeight() {
            return this.fontWeight;
        }

        public final int getFontStyle() {
            return this.fontStyle;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ResourceFont(int i, FontWeight fontWeight, int i2) {
            super(null);
            Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
            this.resourceId = i;
            this.fontWeight = fontWeight;
            this.fontStyle = i2;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0011\u001a\u00020\u0007HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\u00020\u0005¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/fonts/PaywallFont$AssetFont;", "Lcom/revenuecat/purchases/ui/revenuecatui/fonts/PaywallFont;", "path", "", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "", "(Ljava/lang/String;Landroidx/compose/ui/text/font/FontWeight;I)V", "getFontStyle", "()I", "getFontWeight$annotations", "()V", "getFontWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "getPath", "()Ljava/lang/String;", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AssetFont extends PaywallFont {
        public static final int $stable = 0;
        public static final Parcelable.Creator<AssetFont> CREATOR = new Creator();
        private final int fontStyle;
        private final FontWeight fontWeight;
        private final String path;

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<AssetFont> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final AssetFont createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new AssetFont(parcel.readString(), FontWeightParceler.INSTANCE.m4518create(parcel), parcel.readInt());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final AssetFont[] newArray(int i) {
                return new AssetFont[i];
            }
        }

        public static /* synthetic */ void getFontWeight$annotations() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AssetFont)) {
                return false;
            }
            AssetFont assetFont = (AssetFont) obj;
            return Intrinsics.areEqual(this.path, assetFont.path) && Intrinsics.areEqual(this.fontWeight, assetFont.fontWeight) && this.fontStyle == assetFont.fontStyle;
        }

        public int hashCode() {
            return (((this.path.hashCode() * 31) + this.fontWeight.hashCode()) * 31) + this.fontStyle;
        }

        public String toString() {
            return "AssetFont(path=" + this.path + ", fontWeight=" + this.fontWeight + ", fontStyle=" + this.fontStyle + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.path);
            FontWeightParceler.INSTANCE.write(this.fontWeight, parcel, flags);
            parcel.writeInt(this.fontStyle);
        }

        public final String getPath() {
            return this.path;
        }

        public /* synthetic */ AssetFont(String str, FontWeight fontWeight, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i2 & 2) != 0 ? FontWeight.Companion.getNormal() : fontWeight, (i2 & 4) != 0 ? FontStyle.Companion.m2289getNormal_LCdwA() : i);
        }

        public final FontWeight getFontWeight() {
            return this.fontWeight;
        }

        public final int getFontStyle() {
            return this.fontStyle;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AssetFont(String path, FontWeight fontWeight, int i) {
            super(null);
            Intrinsics.checkNotNullParameter(path, "path");
            Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
            this.path = path;
            this.fontWeight = fontWeight;
            this.fontStyle = i;
        }
    }
}
