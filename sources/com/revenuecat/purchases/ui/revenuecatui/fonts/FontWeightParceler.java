package com.revenuecat.purchases.ui.revenuecatui.fonts;

import android.os.Parcel;
import androidx.compose.ui.text.font.FontWeight;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parceler;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001c\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/fonts/FontWeightParceler;", "Lkotlinx/parcelize/Parceler;", "Landroidx/compose/ui/text/font/FontWeight;", "()V", "create", "parcel", "Landroid/os/Parcel;", "write", "", "flags", "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FontWeightParceler implements Parceler {
    public static final int $stable = 0;
    public static final FontWeightParceler INSTANCE = new FontWeightParceler();

    private FontWeightParceler() {
    }

    /* JADX INFO: renamed from: newArray, reason: merged with bridge method [inline-methods] */
    public FontWeight[] m4519newArray(int i) {
        return (FontWeight[]) Parceler.DefaultImpls.newArray(this, i);
    }

    /* JADX INFO: renamed from: create, reason: merged with bridge method [inline-methods] */
    public FontWeight m4518create(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        return new FontWeight(parcel.readInt());
    }

    public void write(FontWeight fontWeight, Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(fontWeight, "<this>");
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(fontWeight.getWeight());
    }
}
