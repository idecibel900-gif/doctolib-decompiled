package expo.modules.updates;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import expo.modules.manifests.core.JSONObjectExtensionKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class UpdatesConfigurationOverride {
    public static final Companion Companion = new Companion(null);
    private final Map requestHeaders;
    private final Uri updateUrl;

    public static /* synthetic */ UpdatesConfigurationOverride copy$default(UpdatesConfigurationOverride updatesConfigurationOverride, Uri uri, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            uri = updatesConfigurationOverride.updateUrl;
        }
        if ((i & 2) != 0) {
            map = updatesConfigurationOverride.requestHeaders;
        }
        return updatesConfigurationOverride.copy(uri, map);
    }

    public final UpdatesConfigurationOverride copy(Uri uri, Map map) {
        return new UpdatesConfigurationOverride(uri, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UpdatesConfigurationOverride)) {
            return false;
        }
        UpdatesConfigurationOverride updatesConfigurationOverride = (UpdatesConfigurationOverride) obj;
        return Intrinsics.areEqual(this.updateUrl, updatesConfigurationOverride.updateUrl) && Intrinsics.areEqual(this.requestHeaders, updatesConfigurationOverride.requestHeaders);
    }

    public int hashCode() {
        Uri uri = this.updateUrl;
        int iHashCode = (uri == null ? 0 : uri.hashCode()) * 31;
        Map map = this.requestHeaders;
        return iHashCode + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        return "UpdatesConfigurationOverride(updateUrl=" + this.updateUrl + ", requestHeaders=" + this.requestHeaders + ")";
    }

    public UpdatesConfigurationOverride(Uri uri, Map map) {
        this.updateUrl = uri;
        this.requestHeaders = map;
    }

    public final Uri getUpdateUrl() {
        return this.updateUrl;
    }

    public final Map getRequestHeaders() {
        return this.requestHeaders;
    }

    public final JSONObject toJSONObject$expo_updates_release() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        Uri uri = this.updateUrl;
        if (uri != null) {
            jSONObject.put("updateUrl", uri.toString());
        }
        Map map = this.requestHeaders;
        if (map != null) {
            jSONObject.put("requestHeaders", new JSONObject(map));
        }
        return jSONObject;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UpdatesConfigurationOverride fromJSONObject$expo_updates_release(JSONObject json) throws JSONException {
            String string;
            JSONObject jSONObject;
            Map map;
            Intrinsics.checkNotNullParameter(json, "json");
            boolean zHas = json.has("updateUrl");
            Class cls = Boolean.TYPE;
            Class cls2 = Long.TYPE;
            Class cls3 = Integer.TYPE;
            Class cls4 = Double.TYPE;
            LinkedHashMap linkedHashMap = null;
            if (zHas) {
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                    string = json.getString("updateUrl");
                    if (string == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls4))) {
                    string = (String) Double.valueOf(json.getDouble("updateUrl"));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls3))) {
                    string = (String) Integer.valueOf(json.getInt("updateUrl"));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls2))) {
                    string = (String) Long.valueOf(json.getLong("updateUrl"));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls))) {
                    string = (String) Boolean.valueOf(json.getBoolean("updateUrl"));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONArray.class))) {
                    Object jSONArray = json.getJSONArray("updateUrl");
                    if (jSONArray == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    string = (String) jSONArray;
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                    Object jSONObject2 = json.getJSONObject("updateUrl");
                    if (jSONObject2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    string = (String) jSONObject2;
                } else {
                    Object obj = json.get("updateUrl");
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    string = (String) obj;
                }
            } else {
                string = null;
            }
            Uri uri = string != null ? Uri.parse(string) : null;
            if (json.has("requestHeaders")) {
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(JSONObject.class);
                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                    Object string2 = json.getString("requestHeaders");
                    if (string2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                    }
                    jSONObject = (JSONObject) string2;
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls4))) {
                    jSONObject = (JSONObject) Double.valueOf(json.getDouble("requestHeaders"));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls3))) {
                    jSONObject = (JSONObject) Integer.valueOf(json.getInt("requestHeaders"));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls2))) {
                    jSONObject = (JSONObject) Long.valueOf(json.getLong("requestHeaders"));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls))) {
                    jSONObject = (JSONObject) Boolean.valueOf(json.getBoolean("requestHeaders"));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JSONArray.class))) {
                    Object jSONArray2 = json.getJSONArray("requestHeaders");
                    if (jSONArray2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                    }
                    jSONObject = (JSONObject) jSONArray2;
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                    jSONObject = json.getJSONObject("requestHeaders");
                    if (jSONObject == null) {
                        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                    }
                } else {
                    Object obj2 = json.get("requestHeaders");
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                    }
                    jSONObject = (JSONObject) obj2;
                }
            } else {
                jSONObject = null;
            }
            if (jSONObject != null && (map = JSONObjectExtensionKt.toMap(jSONObject)) != null) {
                linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
                for (Map.Entry entry : map.entrySet()) {
                    linkedHashMap.put(entry.getKey(), entry.getValue().toString());
                }
            }
            return new UpdatesConfigurationOverride(uri, linkedHashMap);
        }

        private Companion() {
        }

        public final UpdatesConfigurationOverride load$expo_updates_release(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            SharedPreferences sharedPreferences = context.getSharedPreferences("dev.expo.updates.prefs", 0);
            String string = sharedPreferences != null ? sharedPreferences.getString("updatesConfigOverride", null) : null;
            if (string != null) {
                return UpdatesConfigurationOverride.Companion.fromJSONObject$expo_updates_release(new JSONObject(string));
            }
            return null;
        }

        public final void save$expo_updates_release(Context context, UpdatesConfigurationOverride updatesConfigurationOverride) {
            Intrinsics.checkNotNullParameter(context, "context");
            SharedPreferences sharedPreferences = context.getSharedPreferences("dev.expo.updates.prefs", 0);
            Intrinsics.checkNotNull(sharedPreferences);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            if (updatesConfigurationOverride != null) {
                editorEdit.putString("updatesConfigOverride", updatesConfigurationOverride.toJSONObject$expo_updates_release().toString());
            } else {
                editorEdit.remove("updatesConfigOverride");
            }
            editorEdit.apply();
        }

        public final UpdatesConfigurationOverride saveRequestHeaders$expo_updates_release(Context context, Map map) {
            Intrinsics.checkNotNullParameter(context, "context");
            UpdatesConfigurationOverride updatesConfigurationOverrideLoad$expo_updates_release = load$expo_updates_release(context);
            if (updatesConfigurationOverrideLoad$expo_updates_release == null) {
                updatesConfigurationOverrideLoad$expo_updates_release = new UpdatesConfigurationOverride(null, null);
            }
            UpdatesConfigurationOverride updatesConfigurationOverrideCopy$default = UpdatesConfigurationOverride.copy$default(updatesConfigurationOverrideLoad$expo_updates_release, null, map, 1, null);
            UpdatesConfigurationOverride updatesConfigurationOverride = (updatesConfigurationOverrideCopy$default.getUpdateUrl() == null && updatesConfigurationOverrideCopy$default.getRequestHeaders() == null) ? null : updatesConfigurationOverrideCopy$default;
            save$expo_updates_release(context, updatesConfigurationOverride);
            return updatesConfigurationOverride;
        }
    }
}
