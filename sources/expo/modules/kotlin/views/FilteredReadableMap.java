package expo.modules.kotlin.views;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import expo.modules.kotlin.Filter;
import expo.modules.kotlin.FilteredIterator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class FilteredReadableMap implements ReadableMap {
    private final ReadableMap backingMap;
    private final FilteredIterator entryIterator;
    private final List filteredKeys;

    @Override // com.facebook.react.bridge.ReadableMap
    public ReadableArray getArray(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.backingMap.getArray(name);
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public boolean getBoolean(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.backingMap.getBoolean(name);
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public double getDouble(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.backingMap.getDouble(name);
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public Dynamic getDynamic(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.backingMap.getDynamic(name);
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public int getInt(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.backingMap.getInt(name);
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public long getLong(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.backingMap.getLong(name);
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public ReadableMap getMap(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.backingMap.getMap(name);
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public String getString(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.backingMap.getString(name);
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public ReadableType getType(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.backingMap.getType(name);
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public boolean hasKey(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.backingMap.hasKey(name);
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public boolean isNull(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.backingMap.isNull(name);
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public HashMap toHashMap() {
        return this.backingMap.toHashMap();
    }

    public FilteredReadableMap(ReadableMap backingMap, List filteredKeys) {
        Intrinsics.checkNotNullParameter(backingMap, "backingMap");
        Intrinsics.checkNotNullParameter(filteredKeys, "filteredKeys");
        this.backingMap = backingMap;
        this.filteredKeys = filteredKeys;
        this.entryIterator = new FilteredIterator(backingMap.getEntryIterator(), new Filter() { // from class: expo.modules.kotlin.views.FilteredReadableMap$$ExternalSyntheticLambda1
            @Override // expo.modules.kotlin.Filter
            public final boolean apply(Object obj) {
                return FilteredReadableMap.entryIterator$lambda$0(this.f$0, (Map.Entry) obj);
            }
        });
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public FilteredIterator getEntryIterator() {
        return this.entryIterator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean entryIterator$lambda$0(FilteredReadableMap filteredReadableMap, Map.Entry it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !filteredReadableMap.filteredKeys.contains(it.getKey());
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public ReadableMapKeySetIterator keySetIterator() {
        return new FilteredReadableMapKeySetIterator(this.backingMap.keySetIterator(), new Filter() { // from class: expo.modules.kotlin.views.FilteredReadableMap$$ExternalSyntheticLambda0
            @Override // expo.modules.kotlin.Filter
            public final boolean apply(Object obj) {
                return FilteredReadableMap.keySetIterator$lambda$1(this.f$0, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean keySetIterator$lambda$1(FilteredReadableMap filteredReadableMap, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !filteredReadableMap.filteredKeys.contains(it);
    }
}
