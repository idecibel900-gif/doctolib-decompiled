package com.datadog.android.api.context;

import com.datadog.android.core.internal.utils.JsonSerializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.AuthorizationRequest;

/* JADX INFO: loaded from: classes3.dex */
public final class UserInfo {
    public static final Companion Companion = new Companion(null);
    private static final String[] RESERVED_PROPERTIES = {DiagnosticsEntry.ID_KEY, "name", AuthorizationRequest.Scope.EMAIL};
    private final Map additionalProperties;
    private final String anonymousId;
    private final String email;
    private final String id;
    private final String name;

    public static /* synthetic */ UserInfo copy$default(UserInfo userInfo, String str, String str2, String str3, String str4, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userInfo.anonymousId;
        }
        if ((i & 2) != 0) {
            str2 = userInfo.id;
        }
        if ((i & 4) != 0) {
            str3 = userInfo.name;
        }
        if ((i & 8) != 0) {
            str4 = userInfo.email;
        }
        if ((i & 16) != 0) {
            map = userInfo.additionalProperties;
        }
        Map map2 = map;
        String str5 = str3;
        return userInfo.copy(str, str2, str5, str4, map2);
    }

    public final UserInfo copy(String str, String str2, String str3, String str4, Map additionalProperties) {
        Intrinsics.checkNotNullParameter(additionalProperties, "additionalProperties");
        return new UserInfo(str, str2, str3, str4, additionalProperties);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserInfo)) {
            return false;
        }
        UserInfo userInfo = (UserInfo) obj;
        return Intrinsics.areEqual(this.anonymousId, userInfo.anonymousId) && Intrinsics.areEqual(this.id, userInfo.id) && Intrinsics.areEqual(this.name, userInfo.name) && Intrinsics.areEqual(this.email, userInfo.email) && Intrinsics.areEqual(this.additionalProperties, userInfo.additionalProperties);
    }

    public int hashCode() {
        String str = this.anonymousId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.id;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.name;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.email;
        return ((iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.additionalProperties.hashCode();
    }

    public String toString() {
        return "UserInfo(anonymousId=" + this.anonymousId + ", id=" + this.id + ", name=" + this.name + ", email=" + this.email + ", additionalProperties=" + this.additionalProperties + ")";
    }

    public UserInfo(String str, String str2, String str3, String str4, Map additionalProperties) {
        Intrinsics.checkNotNullParameter(additionalProperties, "additionalProperties");
        this.anonymousId = str;
        this.id = str2;
        this.name = str3;
        this.email = str4;
        this.additionalProperties = additionalProperties;
    }

    public final String getAnonymousId() {
        return this.anonymousId;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getEmail() {
        return this.email;
    }

    public /* synthetic */ UserInfo(String str, String str2, String str3, String str4, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? MapsKt.emptyMap() : map);
    }

    public final Map getAdditionalProperties() {
        return this.additionalProperties;
    }

    public final JsonElement toJson$dd_sdk_android_core_release() {
        JsonObject jsonObject = new JsonObject();
        String str = this.anonymousId;
        if (str != null) {
            jsonObject.addProperty("anonymous_id", str);
        }
        String str2 = this.id;
        if (str2 != null) {
            jsonObject.addProperty(DiagnosticsEntry.ID_KEY, str2);
        }
        String str3 = this.name;
        if (str3 != null) {
            jsonObject.addProperty("name", str3);
        }
        String str4 = this.email;
        if (str4 != null) {
            jsonObject.addProperty(AuthorizationRequest.Scope.EMAIL, str4);
        }
        for (Map.Entry entry : this.additionalProperties.entrySet()) {
            String str5 = (String) entry.getKey();
            Object value = entry.getValue();
            if (!ArraysKt.contains(RESERVED_PROPERTIES, str5)) {
                jsonObject.add(str5, JsonSerializer.INSTANCE.toJsonElement(value));
            }
        }
        return jsonObject;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String[] getRESERVED_PROPERTIES$dd_sdk_android_core_release() {
            return UserInfo.RESERVED_PROPERTIES;
        }

        public final UserInfo fromJson(String jsonString) {
            Intrinsics.checkNotNullParameter(jsonString, "jsonString");
            try {
                JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                return fromJsonObject(jsonObject);
            } catch (IllegalStateException e) {
                throw new JsonParseException("Unable to parse json into type UserInfo", e);
            }
        }

        public final UserInfo fromJsonObject(JsonObject jsonObject) {
            Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
            try {
                JsonElement jsonElement = jsonObject.get("anonymous_id");
                String asString = jsonElement != null ? jsonElement.getAsString() : null;
                JsonElement jsonElement2 = jsonObject.get(DiagnosticsEntry.ID_KEY);
                String asString2 = jsonElement2 != null ? jsonElement2.getAsString() : null;
                JsonElement jsonElement3 = jsonObject.get("name");
                String asString3 = jsonElement3 != null ? jsonElement3.getAsString() : null;
                JsonElement jsonElement4 = jsonObject.get(AuthorizationRequest.Scope.EMAIL);
                String asString4 = jsonElement4 != null ? jsonElement4.getAsString() : null;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry entry : jsonObject.entrySet()) {
                    if (!ArraysKt.contains(getRESERVED_PROPERTIES$dd_sdk_android_core_release(), entry.getKey())) {
                        Object key = entry.getKey();
                        Intrinsics.checkNotNullExpressionValue(key, "entry.key");
                        linkedHashMap.put(key, entry.getValue());
                    }
                }
                return new UserInfo(asString, asString2, asString3, asString4, linkedHashMap);
            } catch (IllegalStateException e) {
                throw new JsonParseException("Unable to parse json into type UserInfo", e);
            } catch (NullPointerException e2) {
                throw new JsonParseException("Unable to parse json into type UserInfo", e2);
            } catch (NumberFormatException e3) {
                throw new JsonParseException("Unable to parse json into type UserInfo", e3);
            }
        }
    }
}
