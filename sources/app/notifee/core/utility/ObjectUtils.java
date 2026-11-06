package app.notifee.core.utility;

import android.os.Bundle;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ObjectUtils {

    public interface TypedCallback {
        void call(Object obj);
    }

    public static int getInt(Object obj) {
        if (obj == null) {
            return 0;
        }
        if (obj instanceof Double) {
            return (int) ((Double) obj).doubleValue();
        }
        return ((Integer) obj).intValue();
    }

    public static long getLong(Object obj) {
        if (obj instanceof Double) {
            return (long) ((Double) obj).doubleValue();
        }
        return ((Long) obj).longValue();
    }

    public static byte[] bundleToBytes(Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeBundle(bundle);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        return bArrMarshall;
    }

    public static Bundle bytesToBundle(byte[] bArr) {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.unmarshall(bArr, 0, bArr.length);
        parcelObtain.setDataPosition(0);
        Bundle bundle = parcelObtain.readBundle(ObjectUtils.class.getClassLoader());
        parcelObtain.recycle();
        Objects.requireNonNull(bundle);
        return bundle;
    }

    public static Map bundleToMap(Bundle bundle) {
        HashMap map = new HashMap();
        for (String str : bundle.keySet()) {
            Object value = BundleValueReader.getValue(bundle, str);
            if (value == null) {
                map.put(str, null);
            } else if (value.getClass().isArray()) {
                map.put(str, arrayToMap(value));
            } else if (value instanceof Bundle) {
                map.put(str, bundleToMap((Bundle) value));
            } else if (value instanceof List) {
                map.put(str, listToMap((List) value));
            } else {
                map.put(str, value);
            }
        }
        return map;
    }

    public static ArrayList arrayToMap(Object obj) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        if (obj instanceof String[]) {
            String[] strArr = (String[]) obj;
            int length = strArr.length;
            while (i < length) {
                arrayList.add(strArr[i]);
                i++;
            }
        } else if (obj instanceof Bundle[]) {
            Bundle[] bundleArr = (Bundle[]) obj;
            int length2 = bundleArr.length;
            while (i < length2) {
                arrayList.add(bundleToMap(bundleArr[i]));
                i++;
            }
        } else if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            int length3 = iArr.length;
            while (i < length3) {
                arrayList.add(Integer.valueOf(iArr[i]));
                i++;
            }
        } else if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            int length4 = fArr.length;
            while (i < length4) {
                arrayList.add(Float.valueOf(fArr[i]));
                i++;
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length5 = dArr.length;
            while (i < length5) {
                arrayList.add(Double.valueOf(dArr[i]));
                i++;
            }
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            int length6 = zArr.length;
            while (i < length6) {
                arrayList.add(Boolean.valueOf(zArr[i]));
                i++;
            }
        } else {
            throw new IllegalArgumentException("Unknown array type " + obj.getClass());
        }
        return arrayList;
    }

    public static ArrayList listToMap(List list) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj == null) {
                arrayList.add(null);
            } else if (obj.getClass().isArray()) {
                arrayList.add(arrayToMap(obj));
            } else if (obj instanceof Bundle) {
                arrayList.add(bundleToMap((Bundle) obj));
            } else if (obj instanceof List) {
                arrayList.add(listToMap((List) obj));
            } else if (obj instanceof String) {
                arrayList.add((String) obj);
            } else if (obj instanceof Integer) {
                arrayList.add((Integer) obj);
            } else if (obj instanceof Number) {
                arrayList.add(Double.valueOf(((Number) obj).doubleValue()));
            } else if (obj instanceof Boolean) {
                arrayList.add((Boolean) obj);
            } else {
                throw new IllegalArgumentException("Unknown value type " + obj.getClass());
            }
        }
        return arrayList;
    }
}
