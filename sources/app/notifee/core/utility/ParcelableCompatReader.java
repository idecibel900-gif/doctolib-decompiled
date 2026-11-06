package app.notifee.core.utility;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ParcelableCompatReader {
    public static Parcelable getParcelable(Bundle bundle, String str, Class cls) {
        if (Build.VERSION.SDK_INT >= 33) {
            return (Parcelable) bundle.getParcelable(str, cls);
        }
        return getParcelableLegacy(bundle, str);
    }

    public static ArrayList getParcelableArrayList(Bundle bundle, String str, Class cls) {
        if (Build.VERSION.SDK_INT >= 33) {
            return bundle.getParcelableArrayList(str, cls);
        }
        return getParcelableArrayListLegacy(bundle, str);
    }

    private static Parcelable getParcelableLegacy(Bundle bundle, String str) {
        return bundle.getParcelable(str);
    }

    private static ArrayList getParcelableArrayListLegacy(Bundle bundle, String str) {
        return bundle.getParcelableArrayList(str);
    }
}
