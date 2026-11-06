package com.canhub.cropper;

import android.graphics.Rect;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public class CropImage$ActivityResult extends CropImageView.CropResult implements Parcelable {
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<CropImage$ActivityResult> CREATOR = new Parcelable.Creator() { // from class: com.canhub.cropper.CropImage$ActivityResult$Companion$CREATOR$1
        @Override // android.os.Parcelable.Creator
        public CropImage$ActivityResult createFromParcel(Parcel in) {
            Intrinsics.checkNotNullParameter(in, "in");
            return new CropImage$ActivityResult(in);
        }

        @Override // android.os.Parcelable.Creator
        public CropImage$ActivityResult[] newArray(int i) {
            return new CropImage$ActivityResult[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CropImage$ActivityResult(Uri uri, Uri uri2, Exception exc, float[] fArr, Rect rect, int i, Rect rect2, int i2) {
        super(null, uri, null, uri2, exc, fArr, rect, rect2, i, i2);
        Intrinsics.checkNotNull(fArr);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    protected CropImage$ActivityResult(Parcel in) {
        Intrinsics.checkNotNullParameter(in, "in");
        Uri uri = (Uri) in.readParcelable(Uri.class.getClassLoader());
        Uri uri2 = (Uri) in.readParcelable(Uri.class.getClassLoader());
        Exception exc = (Exception) in.readSerializable();
        float[] fArrCreateFloatArray = in.createFloatArray();
        Intrinsics.checkNotNull(fArrCreateFloatArray);
        super(null, uri, null, uri2, exc, fArrCreateFloatArray, (Rect) in.readParcelable(Rect.class.getClassLoader()), (Rect) in.readParcelable(Rect.class.getClassLoader()), in.readInt(), in.readInt());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeParcelable(getOriginalUri(), i);
        dest.writeParcelable(getUriContent(), i);
        dest.writeSerializable(getError());
        dest.writeFloatArray(getCropPoints());
        dest.writeParcelable(getCropRect(), i);
        dest.writeParcelable(getWholeImageRect(), i);
        dest.writeInt(getRotation());
        dest.writeInt(getSampleSize());
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
