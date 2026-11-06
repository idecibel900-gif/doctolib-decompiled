package androidx.media3.session.legacy;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public abstract class LegacyParcelableUtil {
    private static Object maybeApplyMediaDescriptionParcelableBugWorkaround(Object obj) {
        return obj;
    }

    public static Parcelable convert(Parcelable parcelable, Parcelable.Creator creator) {
        if (parcelable == null) {
            return null;
        }
        Parcelable parcelable2 = (Parcelable) maybeApplyMediaDescriptionParcelableBugWorkaround(parcelable);
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelable2.writeToParcel(parcelObtain, 0);
            parcelObtain.setDataPosition(0);
            return (Parcelable) maybeApplyMediaDescriptionParcelableBugWorkaround((Parcelable) creator.createFromParcel(parcelObtain));
        } finally {
            parcelObtain.recycle();
        }
    }
}
