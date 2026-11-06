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
public final class EmbeddedManifest extends Manifest {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmbeddedManifest(JSONObject json) {
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

    public final long getCommitTimeLong() throws JSONException {
        Long lValueOf;
        JSONObject json = getJson();
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Long.class);
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
            Object string = json.getString("commitTime");
            if (string == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
            }
            lValueOf = (Long) string;
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            lValueOf = (Long) Double.valueOf(json.getDouble("commitTime"));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
            lValueOf = (Long) Integer.valueOf(json.getInt("commitTime"));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            lValueOf = Long.valueOf(json.getLong("commitTime"));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            lValueOf = (Long) Boolean.valueOf(json.getBoolean("commitTime"));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONArray.class))) {
            Object jSONArray = json.getJSONArray("commitTime");
            if (jSONArray == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
            }
            lValueOf = (Long) jSONArray;
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
            Object jSONObject = json.getJSONObject("commitTime");
            if (jSONObject == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
            }
            lValueOf = (Long) jSONObject;
        } else {
            Object obj = json.get("commitTime");
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
            }
            lValueOf = (Long) obj;
        }
        return lValueOf.longValue();
    }

    public String getStableLegacyID() throws JSONException {
        String string;
        JSONObject json = getJson();
        if (json.has("originalFullName")) {
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
            if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONArray.class))) {
                                    if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                                        Object obj = json.get("originalFullName");
                                        if (obj == null) {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                        }
                                        string = (String) obj;
                                    } else {
                                        Object jSONObject = json.getJSONObject("originalFullName");
                                        if (jSONObject == null) {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                        }
                                        string = (String) jSONObject;
                                    }
                                } else {
                                    Object jSONArray = json.getJSONArray("originalFullName");
                                    if (jSONArray == null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                    }
                                    string = (String) jSONArray;
                                }
                            } else {
                                string = (String) Boolean.valueOf(json.getBoolean("originalFullName"));
                            }
                        } else {
                            string = (String) Long.valueOf(json.getLong("originalFullName"));
                        }
                    } else {
                        string = (String) Integer.valueOf(json.getInt("originalFullName"));
                    }
                } else {
                    string = (String) Double.valueOf(json.getDouble("originalFullName"));
                }
            } else {
                string = json.getString("originalFullName");
                if (string == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            }
        } else {
            string = null;
        }
        return string == null ? getLegacyID() : string;
    }

    @Override // expo.modules.manifests.core.Manifest
    public String getScopeKey() throws JSONException {
        String string;
        JSONObject json = getJson();
        if (json.has("scopeKey")) {
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
            if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONArray.class))) {
                                    if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                                        Object obj = json.get("scopeKey");
                                        if (obj == null) {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                        }
                                        string = (String) obj;
                                    } else {
                                        Object jSONObject = json.getJSONObject("scopeKey");
                                        if (jSONObject == null) {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                        }
                                        string = (String) jSONObject;
                                    }
                                } else {
                                    Object jSONArray = json.getJSONArray("scopeKey");
                                    if (jSONArray == null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                    }
                                    string = (String) jSONArray;
                                }
                            } else {
                                string = (String) Boolean.valueOf(json.getBoolean("scopeKey"));
                            }
                        } else {
                            string = (String) Long.valueOf(json.getLong("scopeKey"));
                        }
                    } else {
                        string = (String) Integer.valueOf(json.getInt("scopeKey"));
                    }
                } else {
                    string = (String) Double.valueOf(json.getDouble("scopeKey"));
                }
            } else {
                string = json.getString("scopeKey");
                if (string == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            }
        } else {
            string = null;
        }
        return string == null ? getStableLegacyID() : string;
    }

    @Override // expo.modules.manifests.core.Manifest
    public String getEASProjectID() throws JSONException {
        JSONObject json = getJson();
        if (!json.has("projectId")) {
            return null;
        }
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
        if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
            if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONArray.class))) {
                                if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                                    Object obj = json.get("projectId");
                                    if (obj != null) {
                                        return (String) obj;
                                    }
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                                Object jSONObject = json.getJSONObject("projectId");
                                if (jSONObject != null) {
                                    return (String) jSONObject;
                                }
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            Object jSONArray = json.getJSONArray("projectId");
                            if (jSONArray != null) {
                                return (String) jSONArray;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        return (String) Boolean.valueOf(json.getBoolean("projectId"));
                    }
                    return (String) Long.valueOf(json.getLong("projectId"));
                }
                return (String) Integer.valueOf(json.getInt("projectId"));
            }
            return (String) Double.valueOf(json.getDouble("projectId"));
        }
        String string = json.getString("projectId");
        if (string != null) {
            return string;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
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

    @Override // expo.modules.manifests.core.Manifest
    public String getExpoGoSDKVersion() throws JSONException {
        JSONObject json = getJson();
        if (!json.has(b.I)) {
            return null;
        }
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
        if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
            if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONArray.class))) {
                                if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                                    Object obj = json.get(b.I);
                                    if (obj != null) {
                                        return (String) obj;
                                    }
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                                Object jSONObject = json.getJSONObject(b.I);
                                if (jSONObject != null) {
                                    return (String) jSONObject;
                                }
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            Object jSONArray = json.getJSONArray(b.I);
                            if (jSONArray != null) {
                                return (String) jSONArray;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        return (String) Boolean.valueOf(json.getBoolean(b.I));
                    }
                    return (String) Long.valueOf(json.getLong(b.I));
                }
                return (String) Integer.valueOf(json.getInt(b.I));
            }
            return (String) Double.valueOf(json.getDouble(b.I));
        }
        String string = json.getString(b.I);
        if (string != null) {
            return string;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    @Override // expo.modules.manifests.core.Manifest
    public JSONObject getExpoGoConfigRootObject() {
        return getJson();
    }

    @Override // expo.modules.manifests.core.Manifest
    public JSONObject getExpoClientConfigRootObject() {
        return getJson();
    }
}
