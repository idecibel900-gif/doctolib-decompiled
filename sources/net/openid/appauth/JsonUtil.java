package net.openid.appauth;

import android.net.Uri;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
final class JsonUtil {
    private JsonUtil() {
        throw new IllegalStateException("This type is not intended to be instantiated");
    }

    public static void put(JSONObject jSONObject, String str, int i) {
        Preconditions.checkNotNull(jSONObject, "json must not be null");
        Preconditions.checkNotNull(str, "field must not be null");
        Preconditions.checkNotNull(Integer.valueOf(i), "value must not be null");
        try {
            jSONObject.put(str, i);
        } catch (JSONException unused) {
            throw new IllegalStateException("JSONException thrown in violation of contract, ex");
        }
    }

    public static void put(JSONObject jSONObject, String str, String str2) {
        Preconditions.checkNotNull(jSONObject, "json must not be null");
        Preconditions.checkNotNull(str, "field must not be null");
        Preconditions.checkNotNull(str2, "value must not be null");
        try {
            jSONObject.put(str, str2);
        } catch (JSONException e) {
            throw new IllegalStateException("JSONException thrown in violation of contract", e);
        }
    }

    public static void put(JSONObject jSONObject, String str, JSONArray jSONArray) {
        Preconditions.checkNotNull(jSONObject, "json must not be null");
        Preconditions.checkNotNull(str, "field must not be null");
        Preconditions.checkNotNull(jSONArray, "value must not be null");
        try {
            jSONObject.put(str, jSONArray);
        } catch (JSONException e) {
            throw new IllegalStateException("JSONException thrown in violation of contract", e);
        }
    }

    public static void put(JSONObject jSONObject, String str, JSONObject jSONObject2) {
        Preconditions.checkNotNull(jSONObject, "json must not be null");
        Preconditions.checkNotNull(str, "field must not be null");
        Preconditions.checkNotNull(jSONObject2, "value must not be null");
        try {
            jSONObject.put(str, jSONObject2);
        } catch (JSONException e) {
            throw new IllegalStateException("JSONException thrown in violation of contract", e);
        }
    }

    public static void putIfNotNull(JSONObject jSONObject, String str, String str2) {
        Preconditions.checkNotNull(jSONObject, "json must not be null");
        Preconditions.checkNotNull(str, "field must not be null");
        if (str2 == null) {
            return;
        }
        try {
            jSONObject.put(str, str2);
        } catch (JSONException e) {
            throw new IllegalStateException("JSONException thrown in violation of contract", e);
        }
    }

    public static void putIfNotNull(JSONObject jSONObject, String str, Uri uri) {
        Preconditions.checkNotNull(jSONObject, "json must not be null");
        Preconditions.checkNotNull(str, "field must not be null");
        if (uri == null) {
            return;
        }
        try {
            jSONObject.put(str, uri.toString());
        } catch (JSONException e) {
            throw new IllegalStateException("JSONException thrown in violation of contract", e);
        }
    }

    public static void putIfNotNull(JSONObject jSONObject, String str, Long l) {
        Preconditions.checkNotNull(jSONObject, "json must not be null");
        Preconditions.checkNotNull(str, "field must not be null");
        if (l == null) {
            return;
        }
        try {
            jSONObject.put(str, l);
        } catch (JSONException e) {
            throw new IllegalStateException("JSONException thrown in violation of contract", e);
        }
    }

    public static void putIfNotNull(JSONObject jSONObject, String str, JSONObject jSONObject2) {
        Preconditions.checkNotNull(jSONObject, "json must not be null");
        Preconditions.checkNotNull(str, "field must not be null");
        if (jSONObject2 == null) {
            return;
        }
        try {
            jSONObject.put(str, jSONObject2);
        } catch (JSONException e) {
            throw new IllegalStateException("JSONException thrown in violation of contract", e);
        }
    }

    static void putIfNotNull(JSONObject jSONObject, String str, Object obj) {
        Preconditions.checkNotNull(jSONObject, "json must not be null");
        Preconditions.checkNotNull(str, "field must not be null");
        if (obj == null) {
            return;
        }
        try {
            if (obj instanceof Collection) {
                jSONObject.put(str, new JSONArray((Collection) obj));
                return;
            }
            if (obj instanceof Map) {
                Map map = (Map) obj;
                JSONObject jSONObject2 = new JSONObject();
                for (String str2 : map.keySet()) {
                    putIfNotNull(jSONObject2, str2, map.get(str2));
                }
                jSONObject.put(str, jSONObject2);
                return;
            }
            jSONObject.put(str, obj);
        } catch (JSONException e) {
            throw new IllegalStateException("JSONException thrown in violation of contract", e);
        }
    }

    public static String getString(JSONObject jSONObject, String str) throws JSONException {
        Preconditions.checkNotNull(jSONObject, "json must not be null");
        Preconditions.checkNotNull(str, "field must not be null");
        if (!jSONObject.has(str)) {
            throw new JSONException("field \"" + str + "\" not found in json object");
        }
        String string = jSONObject.getString(str);
        if (string != null) {
            return string;
        }
        throw new JSONException("field \"" + str + "\" is mapped to a null value");
    }

    public static String getStringIfDefined(JSONObject jSONObject, String str) throws JSONException {
        Preconditions.checkNotNull(jSONObject, "json must not be null");
        Preconditions.checkNotNull(str, "field must not be null");
        if (!jSONObject.has(str)) {
            return null;
        }
        String string = jSONObject.getString(str);
        if (string != null) {
            return string;
        }
        throw new JSONException("field \"" + str + "\" is mapped to a null value");
    }

    public static List<String> getStringListIfDefined(JSONObject jSONObject, String str) throws JSONException {
        Preconditions.checkNotNull(jSONObject, "json must not be null");
        Preconditions.checkNotNull(str, "field must not be null");
        if (!jSONObject.has(str)) {
            return null;
        }
        JSONArray jSONArray = jSONObject.getJSONArray(str);
        if (jSONArray == null) {
            throw new JSONException("field \"" + str + "\" is mapped to a null value");
        }
        return toStringList(jSONArray);
    }

    public static Uri getUri(JSONObject jSONObject, String str) throws JSONException {
        Preconditions.checkNotNull(jSONObject, "json must not be null");
        Preconditions.checkNotNull(str, "field must not be null");
        String string = jSONObject.getString(str);
        if (string == null) {
            throw new JSONException("field \"" + str + "\" is mapped to a null value");
        }
        return Uri.parse(string);
    }

    public static Uri getUriIfDefined(JSONObject jSONObject, String str) throws JSONException {
        Preconditions.checkNotNull(jSONObject, "json must not be null");
        Preconditions.checkNotNull(str, "field must not be null");
        if (!jSONObject.has(str)) {
            return null;
        }
        String string = jSONObject.getString(str);
        if (string == null) {
            throw new JSONException("field \"" + str + "\" is mapped to a null value");
        }
        return Uri.parse(string);
    }

    public static Long getLongIfDefined(JSONObject jSONObject, String str) throws JSONException {
        Preconditions.checkNotNull(jSONObject, "json must not be null");
        Preconditions.checkNotNull(str, "field must not be null");
        if (jSONObject.has(str) && !jSONObject.isNull(str)) {
            try {
                return Long.valueOf(jSONObject.getLong(str));
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public static List<String> getStringList(JSONObject jSONObject, String str) throws JSONException {
        Preconditions.checkNotNull(jSONObject, "json must not be null");
        Preconditions.checkNotNull(str, "field must not be null");
        if (!jSONObject.has(str)) {
            throw new JSONException("field \"" + str + "\" not found in json object");
        }
        return toStringList(jSONObject.getJSONArray(str));
    }

    public static List<Uri> getUriList(JSONObject jSONObject, String str) throws JSONException {
        Preconditions.checkNotNull(jSONObject, "json must not be null");
        Preconditions.checkNotNull(str, "field must not be null");
        if (!jSONObject.has(str)) {
            throw new JSONException("field \"" + str + "\" not found in json object");
        }
        return toUriList(jSONObject.getJSONArray(str));
    }

    public static Map<String, String> getStringMap(JSONObject jSONObject, String str) throws JSONException {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Preconditions.checkNotNull(jSONObject, "json must not be null");
        Preconditions.checkNotNull(str, "field must not be null");
        if (jSONObject.has(str)) {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                linkedHashMap.put(next, (String) Preconditions.checkNotNull(jSONObject2.getString(next), "additional parameter values must not be null"));
            }
        }
        return linkedHashMap;
    }

    public static JSONObject getJsonObjectIfDefined(JSONObject jSONObject, String str) throws JSONException {
        Preconditions.checkNotNull(jSONObject, "json must not be null");
        Preconditions.checkNotNull(str, "field must not be null");
        if (!jSONObject.has(str)) {
            return null;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(str);
        if (jSONObjectOptJSONObject != null) {
            return jSONObjectOptJSONObject;
        }
        throw new JSONException("field \"" + str + "\" is mapped to a null value");
    }

    public static List<String> toStringList(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(Preconditions.checkNotNull(jSONArray.get(i)).toString());
            }
        }
        return arrayList;
    }

    public static Map<String, Object> toMap(JSONObject jSONObject) throws JSONException {
        Preconditions.checkNotNull(jSONObject, "json must not be null");
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object map2 = jSONObject.get(next);
            if (map2 instanceof JSONArray) {
                map2 = toList((JSONArray) map2);
            } else if (map2 instanceof JSONObject) {
                map2 = toMap((JSONObject) map2);
            }
            map.put(next, map2);
        }
        return map;
    }

    public static List<Object> toList(JSONArray jSONArray) throws JSONException {
        Preconditions.checkNotNull(jSONArray, "jsonArray must not be null");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            Object map = jSONArray.get(i);
            if (map instanceof JSONArray) {
                map = toList((JSONArray) map);
            } else if (map instanceof JSONObject) {
                map = toMap((JSONObject) map);
            }
            arrayList.add(map);
        }
        return arrayList;
    }

    public static List<Uri> toUriList(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(Uri.parse(Preconditions.checkNotNull(jSONArray.get(i)).toString()));
            }
        }
        return arrayList;
    }

    public static JSONArray toJsonArray(Iterable<?> iterable) {
        Preconditions.checkNotNull(iterable, "objects cannot be null");
        JSONArray jSONArray = new JSONArray();
        Iterator<?> it = iterable.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().toString());
        }
        return jSONArray;
    }

    public static JSONObject mapToJsonObject(Map<String, String> map) {
        Preconditions.checkNotNull(map);
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            Preconditions.checkNotNull(entry.getKey(), "map entries must not have null keys");
            Preconditions.checkNotNull(entry.getValue(), "map entries must not have null values");
            put(jSONObject, entry.getKey(), entry.getValue());
        }
        return jSONObject;
    }

    public static <T> T get(JSONObject jSONObject, Field<T> field) {
        try {
            if (!jSONObject.has(field.key)) {
                return field.defaultValue;
            }
            return field.convert(jSONObject.getString(field.key));
        } catch (JSONException e) {
            throw new IllegalStateException("unexpected JSONException", e);
        }
    }

    public static <T> List<T> get(JSONObject jSONObject, ListField<T> listField) {
        try {
            if (!jSONObject.has(listField.key)) {
                return listField.defaultValue;
            }
            Object obj = jSONObject.get(listField.key);
            if (!(obj instanceof JSONArray)) {
                throw new IllegalStateException(listField.key + " does not contain the expected JSON array");
            }
            JSONArray jSONArray = (JSONArray) obj;
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(listField.convert(jSONArray.getString(i)));
            }
            return arrayList;
        } catch (JSONException e) {
            throw new IllegalStateException("unexpected JSONException", e);
        }
    }

    static abstract class Field<T> {
        public final T defaultValue;
        public final String key;

        abstract T convert(String str);

        Field(String str, T t) {
            this.key = str;
            this.defaultValue = t;
        }
    }

    static final class UriField extends Field<Uri> {
        UriField(String str, Uri uri) {
            super(str, uri);
        }

        UriField(String str) {
            this(str, null);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // net.openid.appauth.JsonUtil.Field
        public Uri convert(String str) {
            return Uri.parse(str);
        }
    }

    static final class StringField extends Field<String> {
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // net.openid.appauth.JsonUtil.Field
        public String convert(String str) {
            return str;
        }

        StringField(String str, String str2) {
            super(str, str2);
        }

        StringField(String str) {
            this(str, null);
        }
    }

    static final class BooleanField extends Field<Boolean> {
        BooleanField(String str, boolean z) {
            super(str, Boolean.valueOf(z));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // net.openid.appauth.JsonUtil.Field
        public Boolean convert(String str) {
            return Boolean.valueOf(Boolean.parseBoolean(str));
        }
    }

    static abstract class ListField<T> {
        public final List<T> defaultValue;
        public final String key;

        abstract T convert(String str);

        ListField(String str, List<T> list) {
            this.key = str;
            this.defaultValue = list;
        }
    }

    static final class StringListField extends ListField<String> {
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // net.openid.appauth.JsonUtil.ListField
        public String convert(String str) {
            return str;
        }

        StringListField(String str) {
            super(str, null);
        }

        StringListField(String str, List<String> list) {
            super(str, list);
        }
    }
}
