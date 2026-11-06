package app.notifee.core.utility;

import android.os.Bundle;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BundleValueReader {
    public static Object getValue(Bundle bundle, String str) {
        return bundle.get(str);
    }

    public static ArrayList getArrayListValue(Bundle bundle, String str) {
        return (ArrayList) getValue(bundle, str);
    }

    public static int getIntPreserving(Bundle bundle, String str) {
        return ObjectUtils.getInt(getValue(bundle, str));
    }

    public static int getIntPreserving(Bundle bundle, String str, int i) {
        return !bundle.containsKey(str) ? i : getIntPreserving(bundle, str);
    }

    public static long getLongPreserving(Bundle bundle, String str) {
        return ObjectUtils.getLong(getValue(bundle, str));
    }

    public static long getLongPreserving(Bundle bundle, String str, long j) {
        return !bundle.containsKey(str) ? j : getLongPreserving(bundle, str);
    }
}
