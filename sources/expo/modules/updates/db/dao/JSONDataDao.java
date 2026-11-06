package expo.modules.updates.db.dao;

import expo.modules.updates.db.entity.JSONDataEntity;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class JSONDataDao {
    protected abstract void deleteJSONDataForKeyInternal(String str, String str2);

    protected abstract void deleteJSONDataForKeysForAllScopeKeysInternal(List list);

    protected abstract void insertJSONDataInternal(JSONDataEntity jSONDataEntity);

    protected abstract List loadJSONDataForKeyInternal(String str, String str2);

    public enum JSONDataKey {
        STATIC_BUILD_DATA("staticBuildData"),
        EXTRA_PARAMS("extraParams"),
        MANIFEST_SERVER_DEFINED_HEADERS("serverDefinedHeaders"),
        MANIFEST_FILTERS("manifestFilters");

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
        private final String key;

        JSONDataKey(String str) {
            this.key = str;
        }

        public final String getKey() {
            return this.key;
        }
    }

    public final String loadJSONStringForKey(JSONDataKey key, String scopeKey) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(scopeKey, "scopeKey");
        List listLoadJSONDataForKeyInternal = loadJSONDataForKeyInternal(key.getKey(), scopeKey);
        if (listLoadJSONDataForKeyInternal.isEmpty()) {
            return null;
        }
        return ((JSONDataEntity) listLoadJSONDataForKeyInternal.get(0)).getValue();
    }

    public void setJSONStringForKey(JSONDataKey key, String value, String scopeKey) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(scopeKey, "scopeKey");
        deleteJSONDataForKeyInternal(key.getKey(), scopeKey);
        insertJSONDataInternal(new JSONDataEntity(key.getKey(), value, new Date(), scopeKey));
    }

    public void setMultipleFields(Map fields, String scopeKey) {
        Intrinsics.checkNotNullParameter(fields, "fields");
        Intrinsics.checkNotNullParameter(scopeKey, "scopeKey");
        for (Map.Entry entry : fields.entrySet()) {
            deleteJSONDataForKeyInternal(((JSONDataKey) entry.getKey()).getKey(), scopeKey);
            insertJSONDataInternal(new JSONDataEntity(((JSONDataKey) entry.getKey()).getKey(), (String) entry.getValue(), new Date(), scopeKey));
        }
    }

    public void updateJSONStringForKey(JSONDataKey key, String scopeKey, Function1 updater) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(scopeKey, "scopeKey");
        Intrinsics.checkNotNullParameter(updater, "updater");
        String strLoadJSONStringForKey = loadJSONStringForKey(key, scopeKey);
        deleteJSONDataForKeyInternal(key.getKey(), scopeKey);
        insertJSONDataInternal(new JSONDataEntity(key.getKey(), (String) updater.invoke(strLoadJSONStringForKey), new Date(), scopeKey));
    }

    public void deleteJSONDataForKeysForAllScopeKeys(List keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        List list = keys;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((JSONDataKey) it.next()).getKey());
        }
        deleteJSONDataForKeysForAllScopeKeysInternal(arrayList);
    }
}
