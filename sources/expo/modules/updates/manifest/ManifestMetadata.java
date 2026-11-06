package expo.modules.updates.manifest;

import expo.modules.structuredheaders.Dictionary;
import expo.modules.structuredheaders.StringItem;
import expo.modules.updates.UpdatesConfiguration;
import expo.modules.updates.db.UpdatesDatabase;
import expo.modules.updates.db.dao.JSONDataDao;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.sequences.SequencesKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class ManifestMetadata {
    public static final ManifestMetadata INSTANCE = new ManifestMetadata();
    private static final String TAG = ManifestMetadata.class.getSimpleName();

    private ManifestMetadata() {
    }

    private final JSONObject getJSONObject(JSONDataDao.JSONDataKey jSONDataKey, UpdatesDatabase updatesDatabase, UpdatesConfiguration updatesConfiguration) {
        try {
            JSONDataDao jsonDataDao = updatesDatabase.jsonDataDao();
            Intrinsics.checkNotNull(jsonDataDao);
            String strLoadJSONStringForKey = jsonDataDao.loadJSONStringForKey(jSONDataKey, updatesConfiguration.getScopeKey());
            if (strLoadJSONStringForKey != null) {
                return new JSONObject(strLoadJSONStringForKey);
            }
            return null;
        } catch (Exception unused) {
            Objects.toString(jSONDataKey);
            return null;
        }
    }

    public static final JSONObject getServerDefinedHeaders(UpdatesDatabase database, UpdatesConfiguration configuration) {
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        return INSTANCE.getJSONObject(JSONDataDao.JSONDataKey.MANIFEST_SERVER_DEFINED_HEADERS, database, configuration);
    }

    public final JSONObject getManifestFilters(UpdatesDatabase database, UpdatesConfiguration configuration) {
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        return getJSONObject(JSONDataDao.JSONDataKey.MANIFEST_FILTERS, database, configuration);
    }

    public final Map getExtraParams(UpdatesDatabase database, UpdatesConfiguration configuration) {
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        JSONObject jSONObject = getJSONObject(JSONDataDao.JSONDataKey.EXTRA_PARAMS, database, configuration);
        if (jSONObject != null) {
            return asStringStringMap(jSONObject);
        }
        return null;
    }

    public final void setExtraParam(UpdatesDatabase database, UpdatesConfiguration configuration, final String key, final String str) {
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(key, "key");
        JSONDataDao jsonDataDao = database.jsonDataDao();
        Intrinsics.checkNotNull(jsonDataDao);
        jsonDataDao.updateJSONStringForKey(JSONDataDao.JSONDataKey.EXTRA_PARAMS, configuration.getScopeKey(), new Function1() { // from class: expo.modules.updates.manifest.ManifestMetadata$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ManifestMetadata.setExtraParam$lambda$3(str, key, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String setExtraParam$lambda$3(String str, String str2, String str3) {
        Map linkedHashMap;
        Map mapAsStringStringMap;
        JSONObject jSONObject = str3 != null ? new JSONObject(str3) : null;
        if (jSONObject == null || (mapAsStringStringMap = INSTANCE.asStringStringMap(jSONObject)) == null || (linkedHashMap = MapsKt.toMutableMap(mapAsStringStringMap)) == null) {
            linkedHashMap = new LinkedHashMap();
        }
        if (str != null) {
            linkedHashMap.put(str2, str);
        } else {
            linkedHashMap.remove(str2);
        }
        Map map = MapsKt.toMap(linkedHashMap);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            linkedHashMap2.put(entry.getKey(), StringItem.valueOf((String) entry.getValue()));
        }
        Dictionary.valueOf(linkedHashMap2).serialize();
        String string = new JSONObject(map).toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final void saveMetadata(ResponseHeaderData responseHeaderData, UpdatesDatabase database, UpdatesConfiguration configuration) {
        Intrinsics.checkNotNullParameter(responseHeaderData, "responseHeaderData");
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (responseHeaderData.getServerDefinedHeaders() != null) {
            linkedHashMap.put(JSONDataDao.JSONDataKey.MANIFEST_SERVER_DEFINED_HEADERS, String.valueOf(responseHeaderData.getServerDefinedHeaders()));
        }
        if (responseHeaderData.getManifestFilters() != null) {
            linkedHashMap.put(JSONDataDao.JSONDataKey.MANIFEST_FILTERS, String.valueOf(responseHeaderData.getManifestFilters()));
        }
        if (linkedHashMap.isEmpty()) {
            return;
        }
        JSONDataDao jsonDataDao = database.jsonDataDao();
        Intrinsics.checkNotNull(jsonDataDao);
        jsonDataDao.setMultipleFields(linkedHashMap, configuration.getScopeKey());
    }

    public final void clearMetadataForBuildDataClearOperation(UpdatesDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        JSONDataDao jsonDataDao = database.jsonDataDao();
        Intrinsics.checkNotNull(jsonDataDao);
        jsonDataDao.deleteJSONDataForKeysForAllScopeKeys(CollectionsKt.listOf((Object[]) new JSONDataDao.JSONDataKey[]{JSONDataDao.JSONDataKey.EXTRA_PARAMS, JSONDataDao.JSONDataKey.MANIFEST_SERVER_DEFINED_HEADERS, JSONDataDao.JSONDataKey.MANIFEST_FILTERS}));
    }

    private final Map asStringStringMap(JSONObject jSONObject) throws JSONException {
        String string;
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        Iterator<String> itKeys = jSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(itKeys, "keys(...)");
        for (String str : SequencesKt.asSequence(itKeys)) {
            Intrinsics.checkNotNull(str);
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                string = jSONObject.getString(str);
                if (string == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                string = (String) Double.valueOf(jSONObject.getDouble(str));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                string = (String) Integer.valueOf(jSONObject.getInt(str));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                string = (String) Long.valueOf(jSONObject.getLong(str));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                string = (String) Boolean.valueOf(jSONObject.getBoolean(str));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONArray.class))) {
                Object jSONArray = jSONObject.getJSONArray(str);
                if (jSONArray == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                string = (String) jSONArray;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                Object jSONObject2 = jSONObject.getJSONObject(str);
                if (jSONObject2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                string = (String) jSONObject2;
            } else {
                Object obj = jSONObject.get(str);
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                string = (String) obj;
            }
            mapCreateMapBuilder.put(str, string);
        }
        return MapsKt.build(mapCreateMapBuilder);
    }
}
