package com.revenuecat.purchases.ui.revenuecatui.fonts;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\tHÖ\u0001J\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/fonts/PaywallFontFamily;", "Landroid/os/Parcelable;", "fonts", "", "Lcom/revenuecat/purchases/ui/revenuecatui/fonts/PaywallFont;", "(Ljava/util/List;)V", "getFonts", "()Ljava/util/List;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PaywallFontFamily implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<PaywallFontFamily> CREATOR = new Creator();
    private final List<PaywallFont> fonts;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PaywallFontFamily> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PaywallFontFamily createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(parcel.readParcelable(PaywallFontFamily.class.getClassLoader()));
            }
            return new PaywallFontFamily(arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PaywallFontFamily[] newArray(int i) {
            return new PaywallFontFamily[i];
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
        return (obj instanceof PaywallFontFamily) && Intrinsics.areEqual(this.fonts, ((PaywallFontFamily) obj).fonts);
    }

    public int hashCode() {
        return this.fonts.hashCode();
    }

    public String toString() {
        return "PaywallFontFamily(fonts=" + this.fonts + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        List<PaywallFont> list = this.fonts;
        parcel.writeInt(list.size());
        Iterator<PaywallFont> it = list.iterator();
        while (it.hasNext()) {
            parcel.writeParcelable(it.next(), flags);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PaywallFontFamily(List<? extends PaywallFont> fonts) {
        Intrinsics.checkNotNullParameter(fonts, "fonts");
        this.fonts = fonts;
    }

    public final List<PaywallFont> getFonts() {
        return this.fonts;
    }
}
