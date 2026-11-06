package com.amazon.device.iap.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.amazon.a.a.o.b;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class Promotion implements Parcelable {
    public static final Parcelable.Creator<Promotion> CREATOR = new Parcelable.Creator<Promotion>() { // from class: com.amazon.device.iap.model.Promotion.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Promotion createFromParcel(Parcel parcel) {
            return new Promotion(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Promotion[] newArray(int i) {
            return new Promotion[i];
        }
    };
    private List<PromotionPlan> promotionPlans;
    private final String promotionType;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Promotion(String str, List<PromotionPlan> list) {
        this.promotionType = str;
        this.promotionPlans = list;
    }

    private Promotion(Parcel parcel) {
        this.promotionType = parcel.readString();
        this.promotionPlans = parcel.createTypedArrayList(PromotionPlan.CREATOR);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.promotionType);
        parcel.writeTypedList(this.promotionPlans);
    }

    public String getPromotionType() {
        return this.promotionType;
    }

    public List<PromotionPlan> getPromotionPlans() {
        return this.promotionPlans;
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(b.r, getPromotionType());
        JSONArray jSONArray = new JSONArray();
        Iterator<PromotionPlan> it = getPromotionPlans().iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().toJSON());
        }
        jSONObject.put(b.s, jSONArray);
        return jSONObject;
    }

    public String toString() {
        try {
            return toJSON().toString(4);
        } catch (JSONException unused) {
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Promotion)) {
            return false;
        }
        Promotion promotion = (Promotion) obj;
        return getPromotionPlans() != null && getPromotionPlans().equals(promotion.getPromotionPlans()) && getPromotionType() != null && getPromotionType().equals(promotion.getPromotionType());
    }
}
