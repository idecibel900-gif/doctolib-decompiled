package com.revenuecat.purchases.utils;

import android.os.Parcel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parceler;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001c\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/revenuecat/purchases/utils/JSONObjectParceler;", "Lkotlinx/parcelize/Parceler;", "Lorg/json/JSONObject;", "()V", "create", "parcel", "Landroid/os/Parcel;", "write", "", "flags", "", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class JSONObjectParceler implements Parceler {
    public static final JSONObjectParceler INSTANCE = new JSONObjectParceler();

    private JSONObjectParceler() {
    }

    public JSONObject[] newArray(int i) {
        return (JSONObject[]) Parceler.DefaultImpls.newArray(this, i);
    }

    public JSONObject create(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        return new JSONObject(parcel.readString());
    }

    public void write(JSONObject jSONObject, Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(jSONObject.toString());
    }
}
