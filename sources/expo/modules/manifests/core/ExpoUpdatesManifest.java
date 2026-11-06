package expo.modules.manifests.core;

import com.amazon.a.a.o.b;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class ExpoUpdatesManifest extends Manifest {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpoUpdatesManifest(JSONObject json) {
        super(json);
        Intrinsics.checkNotNullParameter(json, "json");
    }

    public final String getID() throws JSONException {
        JSONObject json = getJson();
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
            String string = json.getString(DiagnosticsEntry.ID_KEY);
            if (string != null) {
                return string;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            return (String) Double.valueOf(json.getDouble(DiagnosticsEntry.ID_KEY));
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
            return (String) Integer.valueOf(json.getInt(DiagnosticsEntry.ID_KEY));
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            return (String) Long.valueOf(json.getLong(DiagnosticsEntry.ID_KEY));
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            return (String) Boolean.valueOf(json.getBoolean(DiagnosticsEntry.ID_KEY));
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONArray.class))) {
            Object jSONArray = json.getJSONArray(DiagnosticsEntry.ID_KEY);
            if (jSONArray != null) {
                return (String) jSONArray;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
            Object jSONObject = json.getJSONObject(DiagnosticsEntry.ID_KEY);
            if (jSONObject != null) {
                return (String) jSONObject;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        Object obj = json.get(DiagnosticsEntry.ID_KEY);
        if (obj != null) {
            return (String) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    @Override // expo.modules.manifests.core.Manifest
    public String getScopeKey() throws JSONException {
        JSONObject jSONObject;
        JSONObject json = getJson();
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(JSONObject.class);
        boolean zAreEqual = Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class));
        Class cls = Boolean.TYPE;
        Class cls2 = Long.TYPE;
        Class cls3 = Integer.TYPE;
        Class cls4 = Double.TYPE;
        if (zAreEqual) {
            Object string = json.getString("extra");
            if (string == null) {
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
            }
            jSONObject = (JSONObject) string;
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls4))) {
            jSONObject = (JSONObject) Double.valueOf(json.getDouble("extra"));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls3))) {
            jSONObject = (JSONObject) Integer.valueOf(json.getInt("extra"));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls2))) {
            jSONObject = (JSONObject) Long.valueOf(json.getLong("extra"));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls))) {
            jSONObject = (JSONObject) Boolean.valueOf(json.getBoolean("extra"));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONArray.class))) {
            Object jSONArray = json.getJSONArray("extra");
            if (jSONArray == null) {
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
            }
            jSONObject = (JSONObject) jSONArray;
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
            jSONObject = json.getJSONObject("extra");
            if (jSONObject == null) {
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
            }
        } else {
            Object obj = json.get("extra");
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
            }
            jSONObject = (JSONObject) obj;
        }
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
            String string2 = jSONObject.getString("scopeKey");
            if (string2 != null) {
                return string2;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls4))) {
            return (String) Double.valueOf(jSONObject.getDouble("scopeKey"));
        }
        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls3))) {
            return (String) Integer.valueOf(jSONObject.getInt("scopeKey"));
        }
        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls2))) {
            return (String) Long.valueOf(jSONObject.getLong("scopeKey"));
        }
        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls))) {
            return (String) Boolean.valueOf(jSONObject.getBoolean("scopeKey"));
        }
        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JSONArray.class))) {
            Object jSONArray2 = jSONObject.getJSONArray("scopeKey");
            if (jSONArray2 != null) {
                return (String) jSONArray2;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
            Object jSONObject2 = jSONObject.getJSONObject("scopeKey");
            if (jSONObject2 != null) {
                return (String) jSONObject2;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        Object obj2 = jSONObject.get("scopeKey");
        if (obj2 != null) {
            return (String) obj2;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    @Override // expo.modules.manifests.core.Manifest
    public String getEASProjectID() throws JSONException {
        JSONObject jSONObject;
        JSONObject extra = getExtra();
        if (extra != null) {
            boolean zHas = extra.has("eas");
            Class cls = Boolean.TYPE;
            Class cls2 = Long.TYPE;
            Class cls3 = Integer.TYPE;
            Class cls4 = Double.TYPE;
            if (zHas) {
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(JSONObject.class);
                if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                    if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls4))) {
                        if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls3))) {
                            if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls2))) {
                                if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls))) {
                                    if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONArray.class))) {
                                        if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                                            Object obj = extra.get("eas");
                                            if (obj == null) {
                                                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                                            }
                                            jSONObject = (JSONObject) obj;
                                        } else {
                                            jSONObject = extra.getJSONObject("eas");
                                            if (jSONObject == null) {
                                                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                                            }
                                        }
                                    } else {
                                        Object jSONArray = extra.getJSONArray("eas");
                                        if (jSONArray == null) {
                                            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                                        }
                                        jSONObject = (JSONObject) jSONArray;
                                    }
                                } else {
                                    jSONObject = (JSONObject) Boolean.valueOf(extra.getBoolean("eas"));
                                }
                            } else {
                                jSONObject = (JSONObject) Long.valueOf(extra.getLong("eas"));
                            }
                        } else {
                            jSONObject = (JSONObject) Integer.valueOf(extra.getInt("eas"));
                        }
                    } else {
                        jSONObject = (JSONObject) Double.valueOf(extra.getDouble("eas"));
                    }
                } else {
                    Object string = extra.getString("eas");
                    if (string == null) {
                        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                    }
                    jSONObject = (JSONObject) string;
                }
            } else {
                jSONObject = null;
            }
            if (jSONObject == null || !jSONObject.has("projectId")) {
                return null;
            }
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
            if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls4))) {
                    if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls3))) {
                        if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls2))) {
                            if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls))) {
                                if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JSONArray.class))) {
                                    if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                                        Object obj2 = jSONObject.get("projectId");
                                        if (obj2 != null) {
                                            return (String) obj2;
                                        }
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                    }
                                    Object jSONObject2 = jSONObject.getJSONObject("projectId");
                                    if (jSONObject2 != null) {
                                        return (String) jSONObject2;
                                    }
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                                Object jSONArray2 = jSONObject.getJSONArray("projectId");
                                if (jSONArray2 != null) {
                                    return (String) jSONArray2;
                                }
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            return (String) Boolean.valueOf(jSONObject.getBoolean("projectId"));
                        }
                        return (String) Long.valueOf(jSONObject.getLong("projectId"));
                    }
                    return (String) Integer.valueOf(jSONObject.getInt("projectId"));
                }
                return (String) Double.valueOf(jSONObject.getDouble("projectId"));
            }
            String string2 = jSONObject.getString("projectId");
            if (string2 != null) {
                return string2;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        return null;
    }

    public final String getRuntimeVersion() throws JSONException {
        JSONObject json = getJson();
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
            String string = json.getString("runtimeVersion");
            if (string != null) {
                return string;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            return (String) Double.valueOf(json.getDouble("runtimeVersion"));
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
            return (String) Integer.valueOf(json.getInt("runtimeVersion"));
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            return (String) Long.valueOf(json.getLong("runtimeVersion"));
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            return (String) Boolean.valueOf(json.getBoolean("runtimeVersion"));
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONArray.class))) {
            Object jSONArray = json.getJSONArray("runtimeVersion");
            if (jSONArray != null) {
                return (String) jSONArray;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
            Object jSONObject = json.getJSONObject("runtimeVersion");
            if (jSONObject != null) {
                return (String) jSONObject;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        Object obj = json.get("runtimeVersion");
        if (obj != null) {
            return (String) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    @Override // expo.modules.manifests.core.Manifest
    public String getExpoGoSDKVersion() throws JSONException {
        JSONObject expoClientConfigRootObject = getExpoClientConfigRootObject();
        if (expoClientConfigRootObject != null) {
            return expoClientConfigRootObject.getString(b.I);
        }
        return null;
    }

    public final JSONObject getLaunchAsset() throws JSONException {
        JSONObject json = getJson();
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(JSONObject.class);
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
            Object string = json.getString("launchAsset");
            if (string != null) {
                return (JSONObject) string;
            }
            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            return (JSONObject) Double.valueOf(json.getDouble("launchAsset"));
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
            return (JSONObject) Integer.valueOf(json.getInt("launchAsset"));
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            return (JSONObject) Long.valueOf(json.getLong("launchAsset"));
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            return (JSONObject) Boolean.valueOf(json.getBoolean("launchAsset"));
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONArray.class))) {
            Object jSONArray = json.getJSONArray("launchAsset");
            if (jSONArray != null) {
                return (JSONObject) jSONArray;
            }
            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
            JSONObject jSONObject = json.getJSONObject("launchAsset");
            if (jSONObject != null) {
                return jSONObject;
            }
            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
        }
        Object obj = json.get("launchAsset");
        if (obj != null) {
            return (JSONObject) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
    }

    public JSONArray getAssets() throws JSONException {
        JSONObject json = getJson();
        if (!json.has("assets")) {
            return null;
        }
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(JSONArray.class);
        if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
            if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONArray.class))) {
                                if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                                    Object obj = json.get("assets");
                                    if (obj != null) {
                                        return (JSONArray) obj;
                                    }
                                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");
                                }
                                Object jSONObject = json.getJSONObject("assets");
                                if (jSONObject != null) {
                                    return (JSONArray) jSONObject;
                                }
                                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");
                            }
                            JSONArray jSONArray = json.getJSONArray("assets");
                            if (jSONArray != null) {
                                return jSONArray;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");
                        }
                        return (JSONArray) Boolean.valueOf(json.getBoolean("assets"));
                    }
                    return (JSONArray) Long.valueOf(json.getLong("assets"));
                }
                return (JSONArray) Integer.valueOf(json.getInt("assets"));
            }
            return (JSONArray) Double.valueOf(json.getDouble("assets"));
        }
        Object string = json.getString("assets");
        if (string != null) {
            return (JSONArray) string;
        }
        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");
    }

    public final String getCreatedAt() throws JSONException {
        JSONObject json = getJson();
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
            String string = json.getString("createdAt");
            if (string != null) {
                return string;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            return (String) Double.valueOf(json.getDouble("createdAt"));
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
            return (String) Integer.valueOf(json.getInt("createdAt"));
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            return (String) Long.valueOf(json.getLong("createdAt"));
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            return (String) Boolean.valueOf(json.getBoolean("createdAt"));
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONArray.class))) {
            Object jSONArray = json.getJSONArray("createdAt");
            if (jSONArray != null) {
                return (String) jSONArray;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
            Object jSONObject = json.getJSONObject("createdAt");
            if (jSONObject != null) {
                return (String) jSONObject;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        Object obj = json.get("createdAt");
        if (obj != null) {
            return (String) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    @Override // expo.modules.manifests.core.Manifest
    public JSONObject getExpoGoConfigRootObject() throws JSONException {
        JSONObject extra = getExtra();
        if (extra == null || !extra.has("expoGo")) {
            return null;
        }
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(JSONObject.class);
        if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
            if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONArray.class))) {
                                if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                                    Object obj = extra.get("expoGo");
                                    if (obj != null) {
                                        return (JSONObject) obj;
                                    }
                                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                                }
                                JSONObject jSONObject = extra.getJSONObject("expoGo");
                                if (jSONObject != null) {
                                    return jSONObject;
                                }
                                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                            }
                            Object jSONArray = extra.getJSONArray("expoGo");
                            if (jSONArray != null) {
                                return (JSONObject) jSONArray;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                        }
                        return (JSONObject) Boolean.valueOf(extra.getBoolean("expoGo"));
                    }
                    return (JSONObject) Long.valueOf(extra.getLong("expoGo"));
                }
                return (JSONObject) Integer.valueOf(extra.getInt("expoGo"));
            }
            return (JSONObject) Double.valueOf(extra.getDouble("expoGo"));
        }
        Object string = extra.getString("expoGo");
        if (string != null) {
            return (JSONObject) string;
        }
        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
    }

    @Override // expo.modules.manifests.core.Manifest
    public JSONObject getExpoClientConfigRootObject() throws JSONException {
        JSONObject extra = getExtra();
        if (extra == null || !extra.has("expoClient")) {
            return null;
        }
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(JSONObject.class);
        if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
            if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONArray.class))) {
                                if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                                    Object obj = extra.get("expoClient");
                                    if (obj != null) {
                                        return (JSONObject) obj;
                                    }
                                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                                }
                                JSONObject jSONObject = extra.getJSONObject("expoClient");
                                if (jSONObject != null) {
                                    return jSONObject;
                                }
                                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                            }
                            Object jSONArray = extra.getJSONArray("expoClient");
                            if (jSONArray != null) {
                                return (JSONObject) jSONArray;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                        }
                        return (JSONObject) Boolean.valueOf(extra.getBoolean("expoClient"));
                    }
                    return (JSONObject) Long.valueOf(extra.getLong("expoClient"));
                }
                return (JSONObject) Integer.valueOf(extra.getInt("expoClient"));
            }
            return (JSONObject) Double.valueOf(extra.getDouble("expoClient"));
        }
        Object string = extra.getString("expoClient");
        if (string != null) {
            return (JSONObject) string;
        }
        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
    }

    private final JSONObject getExtra() throws JSONException {
        JSONObject json = getJson();
        if (!json.has("extra")) {
            return null;
        }
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(JSONObject.class);
        if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
            if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONArray.class))) {
                                if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                                    Object obj = json.get("extra");
                                    if (obj != null) {
                                        return (JSONObject) obj;
                                    }
                                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                                }
                                JSONObject jSONObject = json.getJSONObject("extra");
                                if (jSONObject != null) {
                                    return jSONObject;
                                }
                                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                            }
                            Object jSONArray = json.getJSONArray("extra");
                            if (jSONArray != null) {
                                return (JSONObject) jSONArray;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                        }
                        return (JSONObject) Boolean.valueOf(json.getBoolean("extra"));
                    }
                    return (JSONObject) Long.valueOf(json.getLong("extra"));
                }
                return (JSONObject) Integer.valueOf(json.getInt("extra"));
            }
            return (JSONObject) Double.valueOf(json.getDouble("extra"));
        }
        Object string = json.getString("extra");
        if (string != null) {
            return (JSONObject) string;
        }
        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
    }
}
