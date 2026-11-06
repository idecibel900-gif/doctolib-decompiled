package expo.modules.updates.db;

import expo.modules.manifests.core.JSONObjectExtensionKt;
import expo.modules.updates.UpdatesConfiguration;
import expo.modules.updates.db.dao.JSONDataDao;
import expo.modules.updates.manifest.ManifestMetadata;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class BuildData {
    public static final BuildData INSTANCE = new BuildData();
    private static final Map defaultBuildData = MapsKt.mapOf(TuplesKt.to("hasEmbeddedUpdate", Boolean.TRUE));

    private BuildData() {
    }

    public final void ensureBuildDataIsConsistent(UpdatesConfiguration updatesConfiguration, UpdatesDatabase database) throws JSONException {
        Intrinsics.checkNotNullParameter(updatesConfiguration, "updatesConfiguration");
        Intrinsics.checkNotNullParameter(database, "database");
        JSONObject buildDataFromDatabase = getBuildDataFromDatabase(database, updatesConfiguration.getScopeKey());
        if (buildDataFromDatabase == null) {
            setBuildDataInDatabase(database, updatesConfiguration);
        } else {
            if (isBuildDataConsistent(updatesConfiguration, buildDataFromDatabase)) {
                return;
            }
            clearAllUpdatesFromDatabase(database);
            clearManifestMetadataFromDatabase(database);
            setBuildDataInDatabase(database, updatesConfiguration);
        }
    }

    public final void clearAllUpdatesFromDatabase(UpdatesDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        database.updateDao().deleteUpdates(database.updateDao().loadAllUpdates());
    }

    public final void clearManifestMetadataFromDatabase(UpdatesDatabase database) {
        Intrinsics.checkNotNullParameter(database, "database");
        ManifestMetadata.INSTANCE.clearMetadataForBuildDataClearOperation(database);
    }

    public final boolean isBuildDataConsistent(UpdatesConfiguration updatesConfiguration, JSONObject databaseBuildData) {
        Intrinsics.checkNotNullParameter(updatesConfiguration, "updatesConfiguration");
        Intrinsics.checkNotNullParameter(databaseBuildData, "databaseBuildData");
        Map map = defaultBuildData;
        return Intrinsics.areEqual(MapsKt.plus(map, JSONObjectExtensionKt.toMap(getBuildDataFromConfig(updatesConfiguration))), MapsKt.plus(map, JSONObjectExtensionKt.toMap(databaseBuildData)));
    }

    public final void setBuildDataInDatabase(UpdatesDatabase database, UpdatesConfiguration updatesConfiguration) throws JSONException {
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(updatesConfiguration, "updatesConfiguration");
        JSONObject buildDataFromConfig = getBuildDataFromConfig(updatesConfiguration);
        JSONDataDao jsonDataDao = database.jsonDataDao();
        if (jsonDataDao != null) {
            JSONDataDao.JSONDataKey jSONDataKey = JSONDataDao.JSONDataKey.STATIC_BUILD_DATA;
            String string = buildDataFromConfig.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            jsonDataDao.setJSONStringForKey(jSONDataKey, string, updatesConfiguration.getScopeKey());
        }
    }

    public final JSONObject getBuildDataFromDatabase(UpdatesDatabase database, String scopeKey) {
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(scopeKey, "scopeKey");
        JSONDataDao jsonDataDao = database.jsonDataDao();
        String strLoadJSONStringForKey = jsonDataDao != null ? jsonDataDao.loadJSONStringForKey(JSONDataDao.JSONDataKey.STATIC_BUILD_DATA, scopeKey) : null;
        if (strLoadJSONStringForKey == null) {
            return null;
        }
        return new JSONObject(strLoadJSONStringForKey);
    }

    private final JSONObject getBuildDataFromConfig(UpdatesConfiguration updatesConfiguration) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry entry : updatesConfiguration.getRequestHeaders().entrySet()) {
            jSONObject.put((String) entry.getKey(), (String) entry.getValue());
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("updateUrl", updatesConfiguration.getUpdateUrl().toString());
        jSONObject2.put("requestHeaders", jSONObject);
        jSONObject2.put("hasEmbeddedUpdate", updatesConfiguration.getHasEmbeddedUpdate());
        return jSONObject2;
    }
}
