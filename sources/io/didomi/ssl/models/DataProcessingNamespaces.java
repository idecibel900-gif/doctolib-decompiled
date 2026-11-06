package io.didomi.ssl.models;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.opentok.android.PublisherKit;
import io.didomi.ssl.f8;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Keep
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0013\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001a\u0010\u0019J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0007\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\n\u001a\u00020\tHÖ\u0001J\t\u0010\u000b\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0003HÖ\u0001R$\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0017\u0010\u0005\"\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lio/didomi/sdk/models/DataProcessingNamespaces;", "Landroid/os/Parcelable;", "Lio/didomi/sdk/f8;", "", "component1", "()Ljava/lang/Integer;", "num", "copy", "(Ljava/lang/Integer;)Lio/didomi/sdk/models/DataProcessingNamespaces;", "", "toString", "hashCode", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "Ljava/lang/Integer;", "getNum", "setNum", "(Ljava/lang/Integer;)V", "<init>", "android_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class DataProcessingNamespaces implements Parcelable, f8 {
    public static final Parcelable.Creator<DataProcessingNamespaces> CREATOR = new a();

    @SerializedName("num")
    private Integer num;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<DataProcessingNamespaces> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final DataProcessingNamespaces createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DataProcessingNamespaces(parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final DataProcessingNamespaces[] newArray(int i) {
            return new DataProcessingNamespaces[i];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DataProcessingNamespaces() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ DataProcessingNamespaces copy$default(DataProcessingNamespaces dataProcessingNamespaces, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = dataProcessingNamespaces.num;
        }
        return dataProcessingNamespaces.copy(num);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getNum() {
        return this.num;
    }

    public final DataProcessingNamespaces copy(Integer num) {
        return new DataProcessingNamespaces(num);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof DataProcessingNamespaces) && Intrinsics.areEqual(this.num, ((DataProcessingNamespaces) other).num);
    }

    @Override // io.didomi.ssl.f8
    public Integer getNum() {
        return this.num;
    }

    public int hashCode() {
        Integer num = this.num;
        if (num == null) {
            return 0;
        }
        return num.hashCode();
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String toString() {
        return "DataProcessingNamespaces(num=" + this.num + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        int iIntValue;
        Intrinsics.checkNotNullParameter(parcel, "out");
        Integer num = this.num;
        if (num == null) {
            iIntValue = 0;
        } else {
            parcel.writeInt(1);
            iIntValue = num.intValue();
        }
        parcel.writeInt(iIntValue);
    }

    public DataProcessingNamespaces(Integer num) {
        this.num = num;
    }

    public /* synthetic */ DataProcessingNamespaces(Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num);
    }
}
