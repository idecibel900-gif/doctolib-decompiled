package com.revenuecat.purchases.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.revenuecat.purchases.ReplacementMode;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\b\u0010\t\u001a\u00020\u0003H\u0016J\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/revenuecat/purchases/models/StoreReplacementMode;", "Lcom/revenuecat/purchases/ReplacementMode;", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "describeContents", "", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class StoreReplacementMode implements ReplacementMode {
    public static final StoreReplacementMode CHARGE_FULL_PRICE;
    public static final StoreReplacementMode CHARGE_PRORATED_PRICE;
    public static final StoreReplacementMode DEFERRED;
    public static final StoreReplacementMode WITHOUT_PRORATION;
    public static final StoreReplacementMode WITH_TIME_PRORATION;
    private static final List<StoreReplacementMode> allModes;
    private final String name;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<StoreReplacementMode> CREATOR = new Creator();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<StoreReplacementMode> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final StoreReplacementMode createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new StoreReplacementMode(parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final StoreReplacementMode[] newArray(int i) {
            return new StoreReplacementMode[i];
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
        return (obj instanceof StoreReplacementMode) && Intrinsics.areEqual(this.name, ((StoreReplacementMode) obj).name);
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.name);
    }

    public StoreReplacementMode(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
    }

    @Override // com.revenuecat.purchases.ReplacementMode
    public String getName() {
        return this.name;
    }

    public String toString() {
        return getName();
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\rH\u0000¢\u0006\u0002\b\u000eR\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/revenuecat/purchases/models/StoreReplacementMode$Companion;", "", "()V", "CHARGE_FULL_PRICE", "Lcom/revenuecat/purchases/models/StoreReplacementMode;", "CHARGE_PRORATED_PRICE", "DEFERRED", "WITHOUT_PRORATION", "WITH_TIME_PRORATION", "allModes", "", "fromName", "name", "", "fromName$purchases_defaultsBc8Release", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final StoreReplacementMode fromName$purchases_defaultsBc8Release(String name) {
            Object next;
            Intrinsics.checkNotNullParameter(name, "name");
            Iterator it = StoreReplacementMode.allModes.iterator();
            while (it.hasNext()) {
                next = it.next();
                if (Intrinsics.areEqual(((StoreReplacementMode) next).getName(), name)) {
                    return (StoreReplacementMode) next;
                }
            }
            next = null;
            return (StoreReplacementMode) next;
        }
    }

    static {
        StoreReplacementMode storeReplacementMode = new StoreReplacementMode("WITHOUT_PRORATION");
        WITHOUT_PRORATION = storeReplacementMode;
        StoreReplacementMode storeReplacementMode2 = new StoreReplacementMode("WITH_TIME_PRORATION");
        WITH_TIME_PRORATION = storeReplacementMode2;
        StoreReplacementMode storeReplacementMode3 = new StoreReplacementMode("CHARGE_FULL_PRICE");
        CHARGE_FULL_PRICE = storeReplacementMode3;
        StoreReplacementMode storeReplacementMode4 = new StoreReplacementMode("CHARGE_PRORATED_PRICE");
        CHARGE_PRORATED_PRICE = storeReplacementMode4;
        StoreReplacementMode storeReplacementMode5 = new StoreReplacementMode("DEFERRED");
        DEFERRED = storeReplacementMode5;
        allModes = CollectionsKt.listOf((Object[]) new StoreReplacementMode[]{storeReplacementMode, storeReplacementMode2, storeReplacementMode3, storeReplacementMode4, storeReplacementMode5});
    }
}
