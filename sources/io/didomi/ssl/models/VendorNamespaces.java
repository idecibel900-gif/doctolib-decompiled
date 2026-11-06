package io.didomi.ssl.models;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.opentok.android.PublisherKit;
import io.didomi.ssl.f8;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Keep
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001a\u0010\u001bJ\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J(\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u000b\u001a\u00020\u0002HÖ\u0001J\t\u0010\f\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003R$\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\b\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lio/didomi/sdk/models/VendorNamespaces;", "Lio/didomi/sdk/f8;", "", "component1", "", "component2", "()Ljava/lang/Integer;", "iab2", "num", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lio/didomi/sdk/models/VendorNamespaces;", "toString", "hashCode", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "Ljava/lang/String;", "getIab2", "()Ljava/lang/String;", "setIab2", "(Ljava/lang/String;)V", "Ljava/lang/Integer;", "getNum", "setNum", "(Ljava/lang/Integer;)V", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class VendorNamespaces implements f8 {

    @SerializedName("iab2")
    private String iab2;

    @SerializedName("num")
    private Integer num;

    /* JADX WARN: Multi-variable type inference failed */
    public VendorNamespaces() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ VendorNamespaces copy$default(VendorNamespaces vendorNamespaces, String str, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = vendorNamespaces.iab2;
        }
        if ((i & 2) != 0) {
            num = vendorNamespaces.num;
        }
        return vendorNamespaces.copy(str, num);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getIab2() {
        return this.iab2;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getNum() {
        return this.num;
    }

    public final VendorNamespaces copy(String iab2, Integer num) {
        return new VendorNamespaces(iab2, num);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VendorNamespaces)) {
            return false;
        }
        VendorNamespaces vendorNamespaces = (VendorNamespaces) other;
        return Intrinsics.areEqual(this.iab2, vendorNamespaces.iab2) && Intrinsics.areEqual(this.num, vendorNamespaces.num);
    }

    public final String getIab2() {
        return this.iab2;
    }

    @Override // io.didomi.ssl.f8
    public Integer getNum() {
        return this.num;
    }

    public int hashCode() {
        String str = this.iab2;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.num;
        return iHashCode + (num != null ? num.hashCode() : 0);
    }

    public final void setIab2(String str) {
        this.iab2 = str;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String toString() {
        return "VendorNamespaces(iab2=" + this.iab2 + ", num=" + this.num + ')';
    }

    public VendorNamespaces(String str, Integer num) {
        this.iab2 = str;
        this.num = num;
    }

    public /* synthetic */ VendorNamespaces(String str, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num);
    }
}
