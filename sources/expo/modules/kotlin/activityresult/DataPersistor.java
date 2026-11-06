package expo.modules.kotlin.activityresult;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
public final class DataPersistor {
    private final Bundle accumulator;
    private final Lazy retrievedData$delegate;
    private final SharedPreferences sharedPreferences;

    public DataPersistor(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences("expo.modules.kotlin.PersistentDataManager", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        this.sharedPreferences = sharedPreferences;
        this.accumulator = new Bundle();
        this.retrievedData$delegate = LazyKt.lazy(new Function0() { // from class: expo.modules.kotlin.activityresult.DataPersistor$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.retrieveData();
            }
        });
    }

    private final Bundle getRetrievedData() {
        return (Bundle) this.retrievedData$delegate.getValue();
    }

    public final DataPersistor addStringArrayList(String key, ArrayList value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.accumulator.putStringArrayList(key, value);
        return this;
    }

    public final ArrayList retrieveStringArrayList(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return getRetrievedData().getStringArrayList(key);
    }

    public final DataPersistor addStringToIntMap(String key, Map value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Bundle bundle = this.accumulator;
        Pair[] pairArr = (Pair[]) MapsKt.toList(value).toArray(new Pair[0]);
        bundle.putBundle(key, BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length)));
        return this;
    }

    public final Map retrieveStringToIntMap(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Bundle bundle = getRetrievedData().getBundle(key);
        if (bundle == null) {
            return null;
        }
        Set<String> setKeySet = bundle.keySet();
        Intrinsics.checkNotNull(setKeySet);
        Set<String> set = setKeySet;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(set, 10)), 16));
        for (Object obj : set) {
            linkedHashMap.put(obj, Integer.valueOf(bundle.getInt((String) obj)));
        }
        return linkedHashMap;
    }

    public final DataPersistor addStringToSerializableMap(String key, Map value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Bundle bundle = this.accumulator;
        Pair[] pairArr = (Pair[]) MapsKt.toList(value).toArray(new Pair[0]);
        bundle.putBundle(key, BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length)));
        return this;
    }

    public final Map retrieveStringToSerializableMap(String key) {
        Serializable serializable;
        Intrinsics.checkNotNullParameter(key, "key");
        Bundle bundle = getRetrievedData().getBundle(key);
        if (bundle == null) {
            return null;
        }
        Set<String> setKeySet = bundle.keySet();
        Intrinsics.checkNotNullExpressionValue(setKeySet, "keySet(...)");
        Set<String> set = setKeySet;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(set, 10)), 16));
        for (Object obj : set) {
            String str = (String) obj;
            if (Build.VERSION.SDK_INT >= 33) {
                serializable = bundle.getSerializable(str, Serializable.class);
            } else {
                serializable = bundle.getSerializable(str);
            }
            if (serializable == null) {
                throw new IllegalStateException("For a key '" + str + "' there should be a serializable class available");
            }
            linkedHashMap.put(obj, serializable);
        }
        return linkedHashMap;
    }

    public final DataPersistor addBundle(String key, Bundle value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.accumulator.putBundle(key, value);
        return this;
    }

    public final Bundle retrieveBundle(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return getRetrievedData().getBundle(key);
    }

    public final DataPersistor addSerializable(String key, Serializable value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.accumulator.putSerializable(key, value);
        return this;
    }

    public final Serializable retrieveSerializable(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Bundle retrievedData = getRetrievedData();
        if (Build.VERSION.SDK_INT >= 33) {
            return retrievedData.getSerializable(key, Serializable.class);
        }
        return retrievedData.getSerializable(key);
    }

    public final void persist() {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putString("bundle", DataPersistorKt.toBase64(this.accumulator));
        editorEdit.putLong("expire", new Date().getTime() + 300000);
        editorEdit.commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bundle retrieveData() {
        String string;
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        if (this.sharedPreferences.getLong("expire", 0L) > new Date().getTime() && (string = this.sharedPreferences.getString("bundle", null)) != null && (bundle = DataPersistorKt.toBundle(string)) != null) {
            bundle2 = bundle;
        }
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.clear();
        editorEdit.commit();
        return bundle2;
    }
}
