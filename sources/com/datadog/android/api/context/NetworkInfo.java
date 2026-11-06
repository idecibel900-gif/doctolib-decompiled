package com.datadog.android.api.context;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class NetworkInfo {
    public static final Companion Companion = new Companion(null);
    private final Long carrierId;
    private final String carrierName;
    private final String cellularTechnology;
    private final Connectivity connectivity;
    private final Long downKbps;
    private final Long strength;
    private final Long upKbps;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetworkInfo)) {
            return false;
        }
        NetworkInfo networkInfo = (NetworkInfo) obj;
        return this.connectivity == networkInfo.connectivity && Intrinsics.areEqual(this.carrierName, networkInfo.carrierName) && Intrinsics.areEqual(this.carrierId, networkInfo.carrierId) && Intrinsics.areEqual(this.upKbps, networkInfo.upKbps) && Intrinsics.areEqual(this.downKbps, networkInfo.downKbps) && Intrinsics.areEqual(this.strength, networkInfo.strength) && Intrinsics.areEqual(this.cellularTechnology, networkInfo.cellularTechnology);
    }

    public int hashCode() {
        int iHashCode = this.connectivity.hashCode() * 31;
        String str = this.carrierName;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Long l = this.carrierId;
        int iHashCode3 = (iHashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.upKbps;
        int iHashCode4 = (iHashCode3 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Long l3 = this.downKbps;
        int iHashCode5 = (iHashCode4 + (l3 == null ? 0 : l3.hashCode())) * 31;
        Long l4 = this.strength;
        int iHashCode6 = (iHashCode5 + (l4 == null ? 0 : l4.hashCode())) * 31;
        String str2 = this.cellularTechnology;
        return iHashCode6 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "NetworkInfo(connectivity=" + this.connectivity + ", carrierName=" + this.carrierName + ", carrierId=" + this.carrierId + ", upKbps=" + this.upKbps + ", downKbps=" + this.downKbps + ", strength=" + this.strength + ", cellularTechnology=" + this.cellularTechnology + ")";
    }

    public NetworkInfo(Connectivity connectivity, String str, Long l, Long l2, Long l3, Long l4, String str2) {
        Intrinsics.checkNotNullParameter(connectivity, "connectivity");
        this.connectivity = connectivity;
        this.carrierName = str;
        this.carrierId = l;
        this.upKbps = l2;
        this.downKbps = l3;
        this.strength = l4;
        this.cellularTechnology = str2;
    }

    public /* synthetic */ NetworkInfo(Connectivity connectivity, String str, Long l, Long l2, Long l3, Long l4, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Connectivity.NETWORK_NOT_CONNECTED : connectivity, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : l2, (i & 16) != 0 ? null : l3, (i & 32) != 0 ? null : l4, (i & 64) != 0 ? null : str2);
    }

    public final Connectivity getConnectivity() {
        return this.connectivity;
    }

    public final String getCarrierName() {
        return this.carrierName;
    }

    public final Long getCarrierId() {
        return this.carrierId;
    }

    public final Long getUpKbps() {
        return this.upKbps;
    }

    public final Long getDownKbps() {
        return this.downKbps;
    }

    public final Long getStrength() {
        return this.strength;
    }

    public final String getCellularTechnology() {
        return this.cellularTechnology;
    }

    public final JsonElement toJson$dd_sdk_android_core_release() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("connectivity", this.connectivity.toJson$dd_sdk_android_core_release());
        String str = this.carrierName;
        if (str != null) {
            jsonObject.addProperty("carrier_name", str);
        }
        Long l = this.carrierId;
        if (l != null) {
            jsonObject.addProperty("carrier_id", Long.valueOf(l.longValue()));
        }
        Long l2 = this.upKbps;
        if (l2 != null) {
            jsonObject.addProperty("up_kbps", Long.valueOf(l2.longValue()));
        }
        Long l3 = this.downKbps;
        if (l3 != null) {
            jsonObject.addProperty("down_kbps", Long.valueOf(l3.longValue()));
        }
        Long l4 = this.strength;
        if (l4 != null) {
            jsonObject.addProperty("strength", Long.valueOf(l4.longValue()));
        }
        String str2 = this.cellularTechnology;
        if (str2 != null) {
            jsonObject.addProperty("cellular_technology", str2);
        }
        return jsonObject;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final NetworkInfo fromJson(String jsonString) {
            Intrinsics.checkNotNullParameter(jsonString, "jsonString");
            try {
                JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
                Intrinsics.checkNotNullExpressionValue(jsonObject, "jsonObject");
                return fromJsonObject(jsonObject);
            } catch (IllegalStateException e) {
                throw new JsonParseException("Unable to parse json into type NetworkInfo", e);
            }
        }

        public final NetworkInfo fromJsonObject(JsonObject jsonObject) {
            Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
            try {
                Connectivity.Companion companion = Connectivity.Companion;
                String asString = jsonObject.get("connectivity").getAsString();
                Intrinsics.checkNotNullExpressionValue(asString, "jsonObject.get(\"connectivity\").asString");
                Connectivity connectivityFromJson = companion.fromJson(asString);
                JsonElement jsonElement = jsonObject.get("carrier_name");
                String asString2 = jsonElement != null ? jsonElement.getAsString() : null;
                JsonElement jsonElement2 = jsonObject.get("carrier_id");
                Long lValueOf = jsonElement2 != null ? Long.valueOf(jsonElement2.getAsLong()) : null;
                JsonElement jsonElement3 = jsonObject.get("up_kbps");
                Long lValueOf2 = jsonElement3 != null ? Long.valueOf(jsonElement3.getAsLong()) : null;
                JsonElement jsonElement4 = jsonObject.get("down_kbps");
                Long lValueOf3 = jsonElement4 != null ? Long.valueOf(jsonElement4.getAsLong()) : null;
                JsonElement jsonElement5 = jsonObject.get("strength");
                Long lValueOf4 = jsonElement5 != null ? Long.valueOf(jsonElement5.getAsLong()) : null;
                JsonElement jsonElement6 = jsonObject.get("cellular_technology");
                return new NetworkInfo(connectivityFromJson, asString2, lValueOf, lValueOf2, lValueOf3, lValueOf4, jsonElement6 != null ? jsonElement6.getAsString() : null);
            } catch (IllegalStateException e) {
                throw new JsonParseException("Unable to parse json into type NetworkInfo", e);
            } catch (NullPointerException e2) {
                throw new JsonParseException("Unable to parse json into type NetworkInfo", e2);
            } catch (NumberFormatException e3) {
                throw new JsonParseException("Unable to parse json into type NetworkInfo", e3);
            }
        }
    }

    public enum Connectivity {
        NETWORK_NOT_CONNECTED("network_not_connected"),
        NETWORK_ETHERNET("network_ethernet"),
        NETWORK_WIFI("network_wifi"),
        NETWORK_WIMAX("network_wimax"),
        NETWORK_BLUETOOTH("network_bluetooth"),
        NETWORK_2G("network_2G"),
        NETWORK_3G("network_3G"),
        NETWORK_4G("network_4G"),
        NETWORK_5G("network_5G"),
        NETWORK_MOBILE_OTHER("network_mobile_other"),
        NETWORK_CELLULAR("network_cellular"),
        NETWORK_OTHER("network_other");

        public static final Companion Companion = new Companion(null);
        private final String jsonValue;

        Connectivity(String str) {
            this.jsonValue = str;
        }

        public final JsonElement toJson$dd_sdk_android_core_release() {
            return new JsonPrimitive(this.jsonValue);
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Connectivity fromJson(String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                try {
                    for (Connectivity connectivity : Connectivity.values()) {
                        if (Intrinsics.areEqual(connectivity.jsonValue, jsonString)) {
                            return connectivity;
                        }
                    }
                    throw new NoSuchElementException("Array contains no element matching the predicate.");
                } catch (NoSuchElementException e) {
                    throw new JsonParseException("Unable to parse json into type NetworkInfo.Connectivity", e);
                }
            }
        }
    }
}
