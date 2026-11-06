package androidx.media3.common.util;

import android.os.Bundle;
import android.util.SparseArray;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class BundleCollectionUtil {
    public static ImmutableList toBundleList(List list, Function function) {
        ImmutableList.Builder builder = ImmutableList.builder();
        for (int i = 0; i < list.size(); i++) {
            builder.add(function.apply(list.get(i)));
        }
        return builder.build();
    }

    public static ImmutableList fromBundleList(Function function, List list) {
        ImmutableList.Builder builder = ImmutableList.builder();
        for (int i = 0; i < list.size(); i++) {
            builder.add(function.apply((Bundle) Assertions.checkNotNull((Bundle) list.get(i))));
        }
        return builder.build();
    }

    public static ArrayList toBundleArrayList(Collection collection, Function function) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add((Bundle) function.apply(it.next()));
        }
        return arrayList;
    }

    public static SparseArray toBundleSparseArray(SparseArray sparseArray, Function function) {
        SparseArray sparseArray2 = new SparseArray(sparseArray.size());
        for (int i = 0; i < sparseArray.size(); i++) {
            sparseArray2.put(sparseArray.keyAt(i), (Bundle) function.apply(sparseArray.valueAt(i)));
        }
        return sparseArray2;
    }

    public static Bundle stringMapToBundle(Map map) {
        Bundle bundle = new Bundle();
        for (Map.Entry entry : map.entrySet()) {
            bundle.putString((String) entry.getKey(), (String) entry.getValue());
        }
        return bundle;
    }

    public static HashMap bundleToStringHashMap(Bundle bundle) {
        HashMap map = new HashMap();
        if (bundle != Bundle.EMPTY) {
            for (String str : bundle.keySet()) {
                String string = bundle.getString(str);
                if (string != null) {
                    map.put(str, string);
                }
            }
        }
        return map;
    }

    public static ImmutableMap bundleToStringImmutableMap(Bundle bundle) {
        if (bundle == Bundle.EMPTY) {
            return ImmutableMap.of();
        }
        return ImmutableMap.copyOf((Map) bundleToStringHashMap(bundle));
    }

    public static Bundle getBundleWithDefault(Bundle bundle, String str, Bundle bundle2) {
        Bundle bundle3 = bundle.getBundle(str);
        return bundle3 != null ? bundle3 : bundle2;
    }

    public static ArrayList getIntegerArrayListWithDefault(Bundle bundle, String str, ArrayList arrayList) {
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList(str);
        return integerArrayList != null ? integerArrayList : arrayList;
    }

    public static void ensureClassLoader(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader((ClassLoader) Util.castNonNull(BundleCollectionUtil.class.getClassLoader()));
        }
    }
}
