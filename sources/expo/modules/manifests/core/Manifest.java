package expo.modules.manifests.core;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Manifest {
    public static final Companion Companion = new Companion(null);
    private final Lazy jsEngine$delegate;
    private final JSONObject json;

    public abstract String getEASProjectID();

    public abstract JSONObject getExpoClientConfigRootObject();

    public abstract JSONObject getExpoGoConfigRootObject();

    public abstract String getExpoGoSDKVersion();

    public abstract String getScopeKey();

    public Manifest(JSONObject json) {
        Intrinsics.checkNotNullParameter(json, "json");
        this.json = json;
        this.jsEngine$delegate = LazyKt.lazy(new Function0() { // from class: expo.modules.manifests.core.Manifest$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Manifest.jsEngine_delegate$lambda$0(this.f$0);
            }
        });
    }

    protected final JSONObject getJson() {
        return this.json;
    }

    public final JSONObject getRawJson() {
        return this.json;
    }

    public String toString() {
        String string = getRawJson().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final String getLegacyID() throws JSONException {
        JSONObject jSONObject = this.json;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
            String string = jSONObject.getString(DiagnosticsEntry.ID_KEY);
            if (string != null) {
                return string;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            return (String) Double.valueOf(jSONObject.getDouble(DiagnosticsEntry.ID_KEY));
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
            return (String) Integer.valueOf(jSONObject.getInt(DiagnosticsEntry.ID_KEY));
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            return (String) Long.valueOf(jSONObject.getLong(DiagnosticsEntry.ID_KEY));
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            return (String) Boolean.valueOf(jSONObject.getBoolean(DiagnosticsEntry.ID_KEY));
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONArray.class))) {
            Object jSONArray = jSONObject.getJSONArray(DiagnosticsEntry.ID_KEY);
            if (jSONArray != null) {
                return (String) jSONArray;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
            Object jSONObject2 = jSONObject.getJSONObject(DiagnosticsEntry.ID_KEY);
            if (jSONObject2 != null) {
                return (String) jSONObject2;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        Object obj = jSONObject.get(DiagnosticsEntry.ID_KEY);
        if (obj != null) {
            return (String) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    public final JSONObject getMetadata() throws JSONException {
        JSONObject jSONObject = this.json;
        if (!jSONObject.has("metadata")) {
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
                                    Object obj = jSONObject.get("metadata");
                                    if (obj != null) {
                                        return (JSONObject) obj;
                                    }
                                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                                }
                                JSONObject jSONObject2 = jSONObject.getJSONObject("metadata");
                                if (jSONObject2 != null) {
                                    return jSONObject2;
                                }
                                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                            }
                            Object jSONArray = jSONObject.getJSONArray("metadata");
                            if (jSONArray != null) {
                                return (JSONObject) jSONArray;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                        }
                        return (JSONObject) Boolean.valueOf(jSONObject.getBoolean("metadata"));
                    }
                    return (JSONObject) Long.valueOf(jSONObject.getLong("metadata"));
                }
                return (JSONObject) Integer.valueOf(jSONObject.getInt("metadata"));
            }
            return (JSONObject) Double.valueOf(jSONObject.getDouble("metadata"));
        }
        Object string = jSONObject.getString("metadata");
        if (string != null) {
            return (JSONObject) string;
        }
        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
    }

    /* JADX WARN: Code duplicated, block: B:94:0x01a2  */
    public final boolean isDevelopmentMode() {
        JSONObject jSONObject;
        boolean zBooleanValue;
        Boolean boolValueOf;
        JSONObject expoGoConfigRootObject = getExpoGoConfigRootObject();
        if (expoGoConfigRootObject == null) {
            return false;
        }
        try {
            if (expoGoConfigRootObject.has("developer")) {
                boolean zHas = expoGoConfigRootObject.has("packagerOpts");
                Class cls = Boolean.TYPE;
                Class cls2 = Long.TYPE;
                Class cls3 = Integer.TYPE;
                Class cls4 = Double.TYPE;
                Boolean bool = null;
                if (zHas) {
                    KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(JSONObject.class);
                    if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                        if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls4))) {
                            if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls3))) {
                                if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls2))) {
                                    if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls))) {
                                        if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONArray.class))) {
                                            if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                                                Object obj = expoGoConfigRootObject.get("packagerOpts");
                                                if (obj == null) {
                                                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                                                }
                                                jSONObject = (JSONObject) obj;
                                            } else {
                                                jSONObject = expoGoConfigRootObject.getJSONObject("packagerOpts");
                                                if (jSONObject == null) {
                                                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                                                }
                                            }
                                        } else {
                                            Object jSONArray = expoGoConfigRootObject.getJSONArray("packagerOpts");
                                            if (jSONArray == null) {
                                                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                                            }
                                            jSONObject = (JSONObject) jSONArray;
                                        }
                                    } else {
                                        jSONObject = (JSONObject) Boolean.valueOf(expoGoConfigRootObject.getBoolean("packagerOpts"));
                                    }
                                } else {
                                    jSONObject = (JSONObject) Long.valueOf(expoGoConfigRootObject.getLong("packagerOpts"));
                                }
                            } else {
                                jSONObject = (JSONObject) Integer.valueOf(expoGoConfigRootObject.getInt("packagerOpts"));
                            }
                        } else {
                            jSONObject = (JSONObject) Double.valueOf(expoGoConfigRootObject.getDouble("packagerOpts"));
                        }
                    } else {
                        Object string = expoGoConfigRootObject.getString("packagerOpts");
                        if (string == null) {
                            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                        }
                        jSONObject = (JSONObject) string;
                    }
                } else {
                    jSONObject = null;
                }
                if (jSONObject == null) {
                    zBooleanValue = false;
                } else {
                    if (jSONObject.has("dev")) {
                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Boolean.class);
                        if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                            if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls4))) {
                                if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls3))) {
                                    if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls2))) {
                                        if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls))) {
                                            if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JSONArray.class))) {
                                                if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                                                    Object obj2 = jSONObject.get("dev");
                                                    if (obj2 == null) {
                                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                                                    }
                                                    boolValueOf = (Boolean) obj2;
                                                } else {
                                                    Object jSONObject2 = jSONObject.getJSONObject("dev");
                                                    if (jSONObject2 == null) {
                                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                                                    }
                                                    boolValueOf = (Boolean) jSONObject2;
                                                }
                                            } else {
                                                Object jSONArray2 = jSONObject.getJSONArray("dev");
                                                if (jSONArray2 == null) {
                                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                                                }
                                                boolValueOf = (Boolean) jSONArray2;
                                            }
                                        } else {
                                            boolValueOf = Boolean.valueOf(jSONObject.getBoolean("dev"));
                                        }
                                    } else {
                                        boolValueOf = (Boolean) Long.valueOf(jSONObject.getLong("dev"));
                                    }
                                } else {
                                    boolValueOf = (Boolean) Integer.valueOf(jSONObject.getInt("dev"));
                                }
                            } else {
                                boolValueOf = (Boolean) Double.valueOf(jSONObject.getDouble("dev"));
                            }
                        } else {
                            Object string2 = jSONObject.getString("dev");
                            if (string2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                            }
                            boolValueOf = (Boolean) string2;
                        }
                        bool = boolValueOf;
                    }
                    if (bool != null) {
                        zBooleanValue = bool.booleanValue();
                    } else {
                        zBooleanValue = false;
                    }
                }
                if (zBooleanValue) {
                    return true;
                }
            }
        } catch (JSONException unused) {
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:132:0x0254  */
    /* JADX WARN: Code duplicated, block: B:89:0x0197  */
    /* JADX WARN: Code duplicated, block: B:90:0x0199  */
    public static final String jsEngine_delegate$lambda$0(Manifest manifest) throws JSONException {
        String string;
        String string2;
        JSONObject jSONObject;
        JSONObject expoClientConfigRootObject = manifest.getExpoClientConfigRootObject();
        Class cls = Boolean.TYPE;
        Class cls2 = Long.TYPE;
        Class cls3 = Integer.TYPE;
        Class cls4 = Double.TYPE;
        if (expoClientConfigRootObject == null) {
            if (expoClientConfigRootObject == null && expoClientConfigRootObject.has("jsEngine")) {
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                    if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls4))) {
                        if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls3))) {
                            if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls2))) {
                                if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls))) {
                                    if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONArray.class))) {
                                        if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                                            Object obj = expoClientConfigRootObject.get("jsEngine");
                                            if (obj == null) {
                                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                            }
                                            string2 = (String) obj;
                                        } else {
                                            Object jSONObject2 = expoClientConfigRootObject.getJSONObject("jsEngine");
                                            if (jSONObject2 == null) {
                                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                            }
                                            string2 = (String) jSONObject2;
                                        }
                                    } else {
                                        Object jSONArray = expoClientConfigRootObject.getJSONArray("jsEngine");
                                        if (jSONArray == null) {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                        }
                                        string2 = (String) jSONArray;
                                    }
                                } else {
                                    string2 = (String) Boolean.valueOf(expoClientConfigRootObject.getBoolean("jsEngine"));
                                }
                            } else {
                                string2 = (String) Long.valueOf(expoClientConfigRootObject.getLong("jsEngine"));
                            }
                        } else {
                            string2 = (String) Integer.valueOf(expoClientConfigRootObject.getInt("jsEngine"));
                        }
                    } else {
                        string2 = (String) Double.valueOf(expoClientConfigRootObject.getDouble("jsEngine"));
                    }
                } else {
                    string2 = expoClientConfigRootObject.getString("jsEngine");
                    if (string2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                }
                string = string2;
            } else {
                string = null;
            }
        } else {
            if (expoClientConfigRootObject.has("android")) {
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(JSONObject.class);
                if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                    if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls4))) {
                        if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls3))) {
                            if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls2))) {
                                if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls))) {
                                    if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JSONArray.class))) {
                                        if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                                            Object obj2 = expoClientConfigRootObject.get("android");
                                            if (obj2 == null) {
                                                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                                            }
                                            jSONObject = (JSONObject) obj2;
                                        } else {
                                            jSONObject = expoClientConfigRootObject.getJSONObject("android");
                                            if (jSONObject == null) {
                                                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                                            }
                                        }
                                    } else {
                                        Object jSONArray2 = expoClientConfigRootObject.getJSONArray("android");
                                        if (jSONArray2 == null) {
                                            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                                        }
                                        jSONObject = (JSONObject) jSONArray2;
                                    }
                                } else {
                                    jSONObject = (JSONObject) Boolean.valueOf(expoClientConfigRootObject.getBoolean("android"));
                                }
                            } else {
                                jSONObject = (JSONObject) Long.valueOf(expoClientConfigRootObject.getLong("android"));
                            }
                        } else {
                            jSONObject = (JSONObject) Integer.valueOf(expoClientConfigRootObject.getInt("android"));
                        }
                    } else {
                        jSONObject = (JSONObject) Double.valueOf(expoClientConfigRootObject.getDouble("android"));
                    }
                } else {
                    Object string3 = expoClientConfigRootObject.getString("android");
                    if (string3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                    }
                    jSONObject = (JSONObject) string3;
                }
            } else {
                jSONObject = null;
            }
            if (jSONObject != null) {
                if (jSONObject.has("jsEngine")) {
                    KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(String.class);
                    if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                        if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(cls4))) {
                            if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(cls3))) {
                                if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(cls2))) {
                                    if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(cls))) {
                                        if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JSONArray.class))) {
                                            if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                                                Object obj3 = jSONObject.get("jsEngine");
                                                if (obj3 == null) {
                                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                                }
                                                string = (String) obj3;
                                            } else {
                                                Object jSONObject3 = jSONObject.getJSONObject("jsEngine");
                                                if (jSONObject3 == null) {
                                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                                }
                                                string = (String) jSONObject3;
                                            }
                                        } else {
                                            Object jSONArray3 = jSONObject.getJSONArray("jsEngine");
                                            if (jSONArray3 == null) {
                                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                            }
                                            string = (String) jSONArray3;
                                        }
                                    } else {
                                        string = (String) Boolean.valueOf(jSONObject.getBoolean("jsEngine"));
                                    }
                                } else {
                                    string = (String) Long.valueOf(jSONObject.getLong("jsEngine"));
                                }
                            } else {
                                string = (String) Integer.valueOf(jSONObject.getInt("jsEngine"));
                            }
                        } else {
                            string = (String) Double.valueOf(jSONObject.getDouble("jsEngine"));
                        }
                    } else {
                        string = jSONObject.getString("jsEngine");
                        if (string == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    }
                } else {
                    string = null;
                }
                if (string == null) {
                    if (expoClientConfigRootObject == null) {
                        string = null;
                    } else {
                        string = null;
                    }
                }
            } else if (expoClientConfigRootObject == null) {
                string = null;
            } else {
                string = null;
            }
        }
        if (string != null) {
            return string;
        }
        String expoGoSDKVersion = manifest.getExpoGoSDKVersion();
        List listSplit$default = expoGoSDKVersion != null ? StringsKt.split$default((CharSequence) expoGoSDKVersion, new String[]{"."}, false, 0, 6, (Object) null) : null;
        Integer intOrNull = (listSplit$default == null || listSplit$default.size() != 3) ? 0 : StringsKt.toIntOrNull((String) listSplit$default.get(0));
        return (intOrNull == null || !new IntRange(1, 47).contains(intOrNull.intValue())) ? "hermes" : "jsc";
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Manifest fromManifestJson(JSONObject manifestJson) throws Exception {
            Intrinsics.checkNotNullParameter(manifestJson, "manifestJson");
            if (manifestJson.has("releaseId")) {
                throw new Exception("Legacy manifests are no longer supported");
            }
            if (manifestJson.has("metadata")) {
                return new ExpoUpdatesManifest(manifestJson);
            }
            return new EmbeddedManifest(manifestJson);
        }
    }
}
