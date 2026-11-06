package expo.modules.updates.loader;

import expo.modules.updates.UpdatesUtils;
import java.util.Date;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public abstract class UpdateDirective {
    public static final Companion Companion = new Companion(null);
    private final SigningInfo signingInfo;

    public /* synthetic */ UpdateDirective(SigningInfo signingInfo, DefaultConstructorMarker defaultConstructorMarker) {
        this(signingInfo);
    }

    public static final class NoUpdateAvailableUpdateDirective extends UpdateDirective {
        public NoUpdateAvailableUpdateDirective(SigningInfo signingInfo) {
            super(signingInfo, null);
        }
    }

    private UpdateDirective(SigningInfo signingInfo) {
        this.signingInfo = signingInfo;
    }

    public final SigningInfo getSigningInfo() {
        return this.signingInfo;
    }

    public static final class RollBackToEmbeddedUpdateDirective extends UpdateDirective {
        private final Date commitTime;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RollBackToEmbeddedUpdateDirective(Date commitTime, SigningInfo signingInfo) {
            super(signingInfo, null);
            Intrinsics.checkNotNullParameter(commitTime, "commitTime");
            this.commitTime = commitTime;
        }

        public final Date getCommitTime() {
            return this.commitTime;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UpdateDirective fromJSONString(String jsonString) throws JSONException {
            JSONObject jSONObject;
            String string;
            JSONObject jSONObject2;
            String string2;
            JSONObject jSONObject3;
            String string3;
            String string4;
            Intrinsics.checkNotNullParameter(jsonString, "jsonString");
            JSONObject jSONObject4 = new JSONObject(jsonString);
            boolean zHas = jSONObject4.has("extra");
            SigningInfo signingInfo = null;
            Class cls = Boolean.TYPE;
            Class cls2 = Long.TYPE;
            Class cls3 = Integer.TYPE;
            Class cls4 = Double.TYPE;
            if (zHas) {
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(JSONObject.class);
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                    Object string5 = jSONObject4.getString("extra");
                    if (string5 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                    }
                    jSONObject = (JSONObject) string5;
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls4))) {
                    jSONObject = (JSONObject) Double.valueOf(jSONObject4.getDouble("extra"));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls3))) {
                    jSONObject = (JSONObject) Integer.valueOf(jSONObject4.getInt("extra"));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls2))) {
                    jSONObject = (JSONObject) Long.valueOf(jSONObject4.getLong("extra"));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls))) {
                    jSONObject = (JSONObject) Boolean.valueOf(jSONObject4.getBoolean("extra"));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONArray.class))) {
                    Object jSONArray = jSONObject4.getJSONArray("extra");
                    if (jSONArray == null) {
                        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                    }
                    jSONObject = (JSONObject) jSONArray;
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                    jSONObject = jSONObject4.getJSONObject("extra");
                    if (jSONObject == null) {
                        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                    }
                } else {
                    Object obj = jSONObject4.get("extra");
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                    }
                    jSONObject = (JSONObject) obj;
                }
            } else {
                jSONObject = null;
            }
            if (jSONObject != null) {
                if (jSONObject.has("signingInfo")) {
                    KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(JSONObject.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                        Object string6 = jSONObject.getString("signingInfo");
                        if (string6 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                        }
                        jSONObject3 = (JSONObject) string6;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls4))) {
                        jSONObject3 = (JSONObject) Double.valueOf(jSONObject.getDouble("signingInfo"));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls3))) {
                        jSONObject3 = (JSONObject) Integer.valueOf(jSONObject.getInt("signingInfo"));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls2))) {
                        jSONObject3 = (JSONObject) Long.valueOf(jSONObject.getLong("signingInfo"));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls))) {
                        jSONObject3 = (JSONObject) Boolean.valueOf(jSONObject.getBoolean("signingInfo"));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JSONArray.class))) {
                        Object jSONArray2 = jSONObject.getJSONArray("signingInfo");
                        if (jSONArray2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                        }
                        jSONObject3 = (JSONObject) jSONArray2;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                        jSONObject3 = jSONObject.getJSONObject("signingInfo");
                        if (jSONObject3 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                        }
                    } else {
                        Object obj2 = jSONObject.get("signingInfo");
                        if (obj2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                        }
                        jSONObject3 = (JSONObject) obj2;
                    }
                } else {
                    jSONObject3 = null;
                }
                if (jSONObject3 != null) {
                    KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(String.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                        string3 = jSONObject3.getString("projectId");
                        if (string3 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(cls4))) {
                        string3 = (String) Double.valueOf(jSONObject3.getDouble("projectId"));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(cls3))) {
                        string3 = (String) Integer.valueOf(jSONObject3.getInt("projectId"));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(cls2))) {
                        string3 = (String) Long.valueOf(jSONObject3.getLong("projectId"));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(cls))) {
                        string3 = (String) Boolean.valueOf(jSONObject3.getBoolean("projectId"));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JSONArray.class))) {
                        Object jSONArray3 = jSONObject3.getJSONArray("projectId");
                        if (jSONArray3 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        string3 = (String) jSONArray3;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                        Object jSONObject5 = jSONObject3.getJSONObject("projectId");
                        if (jSONObject5 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        string3 = (String) jSONObject5;
                    } else {
                        Object obj3 = jSONObject3.get("projectId");
                        if (obj3 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        string3 = (String) obj3;
                    }
                    KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(String.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                        string4 = jSONObject3.getString("scopeKey");
                        if (string4 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls4))) {
                        string4 = (String) Double.valueOf(jSONObject3.getDouble("scopeKey"));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls3))) {
                        string4 = (String) Integer.valueOf(jSONObject3.getInt("scopeKey"));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls2))) {
                        string4 = (String) Long.valueOf(jSONObject3.getLong("scopeKey"));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls))) {
                        string4 = (String) Boolean.valueOf(jSONObject3.getBoolean("scopeKey"));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JSONArray.class))) {
                        Object jSONArray4 = jSONObject3.getJSONArray("scopeKey");
                        if (jSONArray4 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        string4 = (String) jSONArray4;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                        Object jSONObject6 = jSONObject3.getJSONObject("scopeKey");
                        if (jSONObject6 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        string4 = (String) jSONObject6;
                    } else {
                        Object obj4 = jSONObject3.get("scopeKey");
                        if (obj4 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        string4 = (String) obj4;
                    }
                    signingInfo = new SigningInfo(string3, string4);
                }
            }
            KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(String.class);
            if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(String.class))) {
                string = jSONObject4.getString("type");
                if (string == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(cls4))) {
                string = (String) Double.valueOf(jSONObject4.getDouble("type"));
            } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(cls3))) {
                string = (String) Integer.valueOf(jSONObject4.getInt("type"));
            } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(cls2))) {
                string = (String) Long.valueOf(jSONObject4.getLong("type"));
            } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(cls))) {
                string = (String) Boolean.valueOf(jSONObject4.getBoolean("type"));
            } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JSONArray.class))) {
                Object jSONArray5 = jSONObject4.getJSONArray("type");
                if (jSONArray5 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                string = (String) jSONArray5;
            } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                Object jSONObject7 = jSONObject4.getJSONObject("type");
                if (jSONObject7 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                string = (String) jSONObject7;
            } else {
                Object obj5 = jSONObject4.get("type");
                if (obj5 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                string = (String) obj5;
            }
            if (Intrinsics.areEqual(string, "noUpdateAvailable")) {
                return new NoUpdateAvailableUpdateDirective(signingInfo);
            }
            if (!Intrinsics.areEqual(string, "rollBackToEmbedded")) {
                throw new Error("Invalid message messageType: " + string);
            }
            UpdatesUtils updatesUtils = UpdatesUtils.INSTANCE;
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(JSONObject.class);
            if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(String.class))) {
                Object string7 = jSONObject4.getString("parameters");
                if (string7 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                }
                jSONObject2 = (JSONObject) string7;
            } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(cls4))) {
                jSONObject2 = (JSONObject) Double.valueOf(jSONObject4.getDouble("parameters"));
            } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(cls3))) {
                jSONObject2 = (JSONObject) Integer.valueOf(jSONObject4.getInt("parameters"));
            } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(cls2))) {
                jSONObject2 = (JSONObject) Long.valueOf(jSONObject4.getLong("parameters"));
            } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(cls))) {
                jSONObject2 = (JSONObject) Boolean.valueOf(jSONObject4.getBoolean("parameters"));
            } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(JSONArray.class))) {
                Object jSONArray6 = jSONObject4.getJSONArray("parameters");
                if (jSONArray6 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                }
                jSONObject2 = (JSONObject) jSONArray6;
            } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                jSONObject2 = jSONObject4.getJSONObject("parameters");
                if (jSONObject2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                }
            } else {
                Object obj6 = jSONObject4.get("parameters");
                if (obj6 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                }
                jSONObject2 = (JSONObject) obj6;
            }
            KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(String.class);
            if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(String.class))) {
                string2 = jSONObject2.getString("commitTime");
                if (string2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(cls4))) {
                string2 = (String) Double.valueOf(jSONObject2.getDouble("commitTime"));
            } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(cls3))) {
                string2 = (String) Integer.valueOf(jSONObject2.getInt("commitTime"));
            } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(cls2))) {
                string2 = (String) Long.valueOf(jSONObject2.getLong("commitTime"));
            } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(cls))) {
                string2 = (String) Boolean.valueOf(jSONObject2.getBoolean("commitTime"));
            } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(JSONArray.class))) {
                Object jSONArray7 = jSONObject2.getJSONArray("commitTime");
                if (jSONArray7 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                string2 = (String) jSONArray7;
            } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                Object jSONObject8 = jSONObject2.getJSONObject("commitTime");
                if (jSONObject8 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                string2 = (String) jSONObject8;
            } else {
                Object obj7 = jSONObject2.get("commitTime");
                if (obj7 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                string2 = (String) obj7;
            }
            return new RollBackToEmbeddedUpdateDirective(updatesUtils.parseDateString(string2), signingInfo);
        }
    }
}
