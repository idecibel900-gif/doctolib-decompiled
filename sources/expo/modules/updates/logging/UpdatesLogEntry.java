package expo.modules.updates.logging;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import net.openid.appauth.ResponseTypeValues;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class UpdatesLogEntry {
    public static final Companion Companion = new Companion(null);
    private final String assetId;
    private final String code;
    private final Long duration;
    private final String level;
    private final String message;
    private final List stacktrace;
    private final long timestamp;
    private final String updateId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UpdatesLogEntry)) {
            return false;
        }
        UpdatesLogEntry updatesLogEntry = (UpdatesLogEntry) obj;
        return this.timestamp == updatesLogEntry.timestamp && Intrinsics.areEqual(this.message, updatesLogEntry.message) && Intrinsics.areEqual(this.code, updatesLogEntry.code) && Intrinsics.areEqual(this.level, updatesLogEntry.level) && Intrinsics.areEqual(this.duration, updatesLogEntry.duration) && Intrinsics.areEqual(this.updateId, updatesLogEntry.updateId) && Intrinsics.areEqual(this.assetId, updatesLogEntry.assetId) && Intrinsics.areEqual(this.stacktrace, updatesLogEntry.stacktrace);
    }

    public int hashCode() {
        int iHashCode = ((((((Long.hashCode(this.timestamp) * 31) + this.message.hashCode()) * 31) + this.code.hashCode()) * 31) + this.level.hashCode()) * 31;
        Long l = this.duration;
        int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str = this.updateId;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.assetId;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        List list = this.stacktrace;
        return iHashCode4 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "UpdatesLogEntry(timestamp=" + this.timestamp + ", message=" + this.message + ", code=" + this.code + ", level=" + this.level + ", duration=" + this.duration + ", updateId=" + this.updateId + ", assetId=" + this.assetId + ", stacktrace=" + this.stacktrace + ")";
    }

    public UpdatesLogEntry(long j, String message, String code, String level, Long l, String str, String str2, List list) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(level, "level");
        this.timestamp = j;
        this.message = message;
        this.code = code;
        this.level = level;
        this.duration = l;
        this.updateId = str;
        this.assetId = str2;
        this.stacktrace = list;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getLevel() {
        return this.level;
    }

    public final String getUpdateId() {
        return this.updateId;
    }

    public final String getAssetId() {
        return this.assetId;
    }

    public final List getStacktrace() {
        return this.stacktrace;
    }

    public final String asString() throws JSONException {
        JSONObject jSONObject = new JSONObject(MapsKt.mapOf(TuplesKt.to(DiagnosticsEntry.TIMESTAMP_KEY, Long.valueOf(this.timestamp)), TuplesKt.to("message", this.message), TuplesKt.to(ResponseTypeValues.CODE, this.code), TuplesKt.to("level", this.level)));
        Long l = this.duration;
        if (l != null) {
            jSONObject.put("duration", l.longValue());
        }
        String str = this.updateId;
        if (str != null) {
            jSONObject.put("updateId", str);
        }
        String str2 = this.assetId;
        if (str2 != null) {
            jSONObject.put("assetId", str2);
        }
        List list = this.stacktrace;
        if (list != null && !list.isEmpty()) {
            jSONObject.put("stacktrace", new JSONArray((Collection) this.stacktrace));
        }
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UpdatesLogEntry create(String json) {
            Long lValueOf;
            String string;
            String string2;
            String string3;
            Long lValueOf2;
            Long l;
            String string4;
            String str;
            String string5;
            String str2;
            JSONArray jSONArray;
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(json, "json");
            try {
                JSONObject jSONObject = new JSONObject(json);
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Long.class);
                boolean zAreEqual = Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class));
                Class cls = Boolean.TYPE;
                Class cls2 = Long.TYPE;
                Class cls3 = Integer.TYPE;
                Class cls4 = Double.TYPE;
                if (zAreEqual) {
                    Object string6 = jSONObject.getString(DiagnosticsEntry.TIMESTAMP_KEY);
                    if (string6 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                    }
                    lValueOf = (Long) string6;
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls4))) {
                    lValueOf = (Long) Double.valueOf(jSONObject.getDouble(DiagnosticsEntry.TIMESTAMP_KEY));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls3))) {
                    lValueOf = (Long) Integer.valueOf(jSONObject.getInt(DiagnosticsEntry.TIMESTAMP_KEY));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls2))) {
                    lValueOf = Long.valueOf(jSONObject.getLong(DiagnosticsEntry.TIMESTAMP_KEY));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls))) {
                    lValueOf = (Long) Boolean.valueOf(jSONObject.getBoolean(DiagnosticsEntry.TIMESTAMP_KEY));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONArray.class))) {
                    Object jSONArray2 = jSONObject.getJSONArray(DiagnosticsEntry.TIMESTAMP_KEY);
                    if (jSONArray2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                    }
                    lValueOf = (Long) jSONArray2;
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                    Object jSONObject2 = jSONObject.getJSONObject(DiagnosticsEntry.TIMESTAMP_KEY);
                    if (jSONObject2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                    }
                    lValueOf = (Long) jSONObject2;
                } else {
                    Object obj = jSONObject.get(DiagnosticsEntry.TIMESTAMP_KEY);
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                    }
                    lValueOf = (Long) obj;
                }
                long jLongValue = lValueOf.longValue();
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                    string = jSONObject.getString("message");
                    if (string == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls4))) {
                    string = (String) Double.valueOf(jSONObject.getDouble("message"));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls3))) {
                    string = (String) Integer.valueOf(jSONObject.getInt("message"));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls2))) {
                    string = (String) Long.valueOf(jSONObject.getLong("message"));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls))) {
                    string = (String) Boolean.valueOf(jSONObject.getBoolean("message"));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JSONArray.class))) {
                    Object jSONArray3 = jSONObject.getJSONArray("message");
                    if (jSONArray3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    string = (String) jSONArray3;
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                    Object jSONObject3 = jSONObject.getJSONObject("message");
                    if (jSONObject3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    string = (String) jSONObject3;
                } else {
                    Object obj2 = jSONObject.get("message");
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    string = (String) obj2;
                }
                String str3 = string;
                KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                    string2 = jSONObject.getString(ResponseTypeValues.CODE);
                    if (string2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(cls4))) {
                    string2 = (String) Double.valueOf(jSONObject.getDouble(ResponseTypeValues.CODE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(cls3))) {
                    string2 = (String) Integer.valueOf(jSONObject.getInt(ResponseTypeValues.CODE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(cls2))) {
                    string2 = (String) Long.valueOf(jSONObject.getLong(ResponseTypeValues.CODE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(cls))) {
                    string2 = (String) Boolean.valueOf(jSONObject.getBoolean(ResponseTypeValues.CODE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JSONArray.class))) {
                    Object jSONArray4 = jSONObject.getJSONArray(ResponseTypeValues.CODE);
                    if (jSONArray4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    string2 = (String) jSONArray4;
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                    Object jSONObject4 = jSONObject.getJSONObject(ResponseTypeValues.CODE);
                    if (jSONObject4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    string2 = (String) jSONObject4;
                } else {
                    Object obj3 = jSONObject.get(ResponseTypeValues.CODE);
                    if (obj3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    string2 = (String) obj3;
                }
                String str4 = string2;
                KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                    string3 = jSONObject.getString("level");
                    if (string3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls4))) {
                    string3 = (String) Double.valueOf(jSONObject.getDouble("level"));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls3))) {
                    string3 = (String) Integer.valueOf(jSONObject.getInt("level"));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls2))) {
                    string3 = (String) Long.valueOf(jSONObject.getLong("level"));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls))) {
                    string3 = (String) Boolean.valueOf(jSONObject.getBoolean("level"));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JSONArray.class))) {
                    Object jSONArray5 = jSONObject.getJSONArray("level");
                    if (jSONArray5 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    string3 = (String) jSONArray5;
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                    Object jSONObject5 = jSONObject.getJSONObject("level");
                    if (jSONObject5 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    string3 = (String) jSONObject5;
                } else {
                    Object obj4 = jSONObject.get("level");
                    if (obj4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    string3 = (String) obj4;
                }
                String str5 = string3;
                if (jSONObject.has("duration")) {
                    KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Long.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(String.class))) {
                        Object string7 = jSONObject.getString("duration");
                        if (string7 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                        }
                        lValueOf2 = (Long) string7;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(cls4))) {
                        lValueOf2 = (Long) Double.valueOf(jSONObject.getDouble("duration"));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(cls3))) {
                        lValueOf2 = (Long) Integer.valueOf(jSONObject.getInt("duration"));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(cls2))) {
                        lValueOf2 = Long.valueOf(jSONObject.getLong("duration"));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(cls))) {
                        lValueOf2 = (Long) Boolean.valueOf(jSONObject.getBoolean("duration"));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JSONArray.class))) {
                        Object jSONArray6 = jSONObject.getJSONArray("duration");
                        if (jSONArray6 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                        }
                        lValueOf2 = (Long) jSONArray6;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                        Object jSONObject6 = jSONObject.getJSONObject("duration");
                        if (jSONObject6 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                        }
                        lValueOf2 = (Long) jSONObject6;
                    } else {
                        Object obj5 = jSONObject.get("duration");
                        if (obj5 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                        }
                        lValueOf2 = (Long) obj5;
                    }
                    l = lValueOf2;
                } else {
                    l = null;
                }
                if (jSONObject.has("updateId")) {
                    KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(String.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(String.class))) {
                        string4 = jSONObject.getString("updateId");
                        if (string4 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(cls4))) {
                        string4 = (String) Double.valueOf(jSONObject.getDouble("updateId"));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(cls3))) {
                        string4 = (String) Integer.valueOf(jSONObject.getInt("updateId"));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(cls2))) {
                        string4 = (String) Long.valueOf(jSONObject.getLong("updateId"));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(cls))) {
                        string4 = (String) Boolean.valueOf(jSONObject.getBoolean("updateId"));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(JSONArray.class))) {
                        Object jSONArray7 = jSONObject.getJSONArray("updateId");
                        if (jSONArray7 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        string4 = (String) jSONArray7;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                        Object jSONObject7 = jSONObject.getJSONObject("updateId");
                        if (jSONObject7 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        string4 = (String) jSONObject7;
                    } else {
                        Object obj6 = jSONObject.get("updateId");
                        if (obj6 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        string4 = (String) obj6;
                    }
                    str = string4;
                } else {
                    str = null;
                }
                if (jSONObject.has("assetId")) {
                    KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(String.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(String.class))) {
                        string5 = jSONObject.getString("assetId");
                        if (string5 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(cls4))) {
                        string5 = (String) Double.valueOf(jSONObject.getDouble("assetId"));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(cls3))) {
                        string5 = (String) Integer.valueOf(jSONObject.getInt("assetId"));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(cls2))) {
                        string5 = (String) Long.valueOf(jSONObject.getLong("assetId"));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(cls))) {
                        string5 = (String) Boolean.valueOf(jSONObject.getBoolean("assetId"));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(JSONArray.class))) {
                        Object jSONArray8 = jSONObject.getJSONArray("assetId");
                        if (jSONArray8 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        string5 = (String) jSONArray8;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                        Object jSONObject8 = jSONObject.getJSONObject("assetId");
                        if (jSONObject8 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        string5 = (String) jSONObject8;
                    } else {
                        Object obj7 = jSONObject.get("assetId");
                        if (obj7 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        string5 = (String) obj7;
                    }
                    str2 = string5;
                } else {
                    str2 = null;
                }
                if (jSONObject.has("stacktrace")) {
                    KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(JSONArray.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(String.class))) {
                        Object string8 = jSONObject.getString("stacktrace");
                        if (string8 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");
                        }
                        jSONArray = (JSONArray) string8;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(cls4))) {
                        jSONArray = (JSONArray) Double.valueOf(jSONObject.getDouble("stacktrace"));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(cls3))) {
                        jSONArray = (JSONArray) Integer.valueOf(jSONObject.getInt("stacktrace"));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(cls2))) {
                        jSONArray = (JSONArray) Long.valueOf(jSONObject.getLong("stacktrace"));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(cls))) {
                        jSONArray = (JSONArray) Boolean.valueOf(jSONObject.getBoolean("stacktrace"));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(JSONArray.class))) {
                        jSONArray = jSONObject.getJSONArray("stacktrace");
                        if (jSONArray == null) {
                            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                        Object jSONObject9 = jSONObject.getJSONObject("stacktrace");
                        if (jSONObject9 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");
                        }
                        jSONArray = (JSONArray) jSONObject9;
                    } else {
                        Object obj8 = jSONObject.get("stacktrace");
                        if (obj8 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");
                        }
                        jSONArray = (JSONArray) obj8;
                    }
                } else {
                    jSONArray = null;
                }
                if (jSONArray != null) {
                    int length = jSONArray.length();
                    ArrayList arrayList2 = new ArrayList(length);
                    for (int i = 0; i < length; i++) {
                        arrayList2.add(jSONArray.getString(i));
                    }
                    arrayList = arrayList2;
                } else {
                    arrayList = null;
                }
                return new UpdatesLogEntry(jLongValue, str3, str4, str5, l, str, str2, arrayList);
            } catch (Exception unused) {
                return null;
            }
        }
    }
}
