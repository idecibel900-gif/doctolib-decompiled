package com.amazon.device.simplesignin.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public final class RequestId implements Parcelable {
    public static final Parcelable.Creator<RequestId> CREATOR = new Parcelable.Creator<RequestId>() { // from class: com.amazon.device.simplesignin.model.RequestId.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RequestId createFromParcel(Parcel parcel) {
            return new RequestId(parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RequestId[] newArray(int i) {
            return new RequestId[i];
        }
    };
    private final String id;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RequestId(String str) {
        this.id = str;
    }

    public RequestId() {
        this.id = UUID.randomUUID().toString();
    }

    public String toString() {
        return this.id;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
    }
}
