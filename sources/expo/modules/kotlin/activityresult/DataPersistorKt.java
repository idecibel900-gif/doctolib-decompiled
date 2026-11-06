package expo.modules.kotlin.activityresult;

import android.os.Bundle;
import android.os.Parcel;
import android.util.Base64;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class DataPersistorKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Bundle toBundle(String str) {
        byte[] bArrDecode = Base64.decode(str, 0);
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.unmarshall(bArrDecode, 0, bArrDecode.length);
        parcelObtain.setDataPosition(0);
        Bundle bundle = parcelObtain.readBundle(null);
        parcelObtain.recycle();
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String toBase64(Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeBundle(bundle);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        String strEncodeToString = Base64.encodeToString(bArrMarshall, 0);
        Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(...)");
        return strEncodeToString;
    }
}
