package com.revenuecat.purchases.ui.revenuecatui.fonts;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.ui.text.googlefonts.GoogleFont;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B#\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0019\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/fonts/GoogleFontProvider;", "Landroid/os/Parcelable;", "certificates", "", "providerAuthority", "", "providerPackage", "(ILjava/lang/String;Ljava/lang/String;)V", "getCertificates", "()I", "getProviderAuthority", "()Ljava/lang/String;", "getProviderPackage", "describeContents", "toGoogleProvider", "Landroidx/compose/ui/text/googlefonts/GoogleFont$Provider;", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GoogleFontProvider implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<GoogleFontProvider> CREATOR = new Creator();
    private final int certificates;
    private final String providerAuthority;
    private final String providerPackage;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<GoogleFontProvider> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GoogleFontProvider createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new GoogleFontProvider(parcel.readInt(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GoogleFontProvider[] newArray(int i) {
            return new GoogleFontProvider[i];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GoogleFontProvider)) {
            return false;
        }
        GoogleFontProvider googleFontProvider = (GoogleFontProvider) obj;
        return this.certificates == googleFontProvider.certificates && Intrinsics.areEqual(this.providerAuthority, googleFontProvider.providerAuthority) && Intrinsics.areEqual(this.providerPackage, googleFontProvider.providerPackage);
    }

    public int hashCode() {
        return (((this.certificates * 31) + this.providerAuthority.hashCode()) * 31) + this.providerPackage.hashCode();
    }

    public String toString() {
        return "GoogleFontProvider(certificates=" + this.certificates + ", providerAuthority=" + this.providerAuthority + ", providerPackage=" + this.providerPackage + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.certificates);
        parcel.writeString(this.providerAuthority);
        parcel.writeString(this.providerPackage);
    }

    public GoogleFontProvider(int i, String providerAuthority, String providerPackage) {
        Intrinsics.checkNotNullParameter(providerAuthority, "providerAuthority");
        Intrinsics.checkNotNullParameter(providerPackage, "providerPackage");
        this.certificates = i;
        this.providerAuthority = providerAuthority;
        this.providerPackage = providerPackage;
    }

    public final int getCertificates() {
        return this.certificates;
    }

    public /* synthetic */ GoogleFontProvider(int i, String str, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? "com.google.android.gms.fonts" : str, (i2 & 4) != 0 ? "com.google.android.gms" : str2);
    }

    public final String getProviderAuthority() {
        return this.providerAuthority;
    }

    public final String getProviderPackage() {
        return this.providerPackage;
    }

    public final GoogleFont.Provider toGoogleProvider() {
        return new GoogleFont.Provider(this.providerAuthority, this.providerPackage, this.certificates);
    }
}
