package com.doctolib.apps.authentication.internal.devicekey;

import com.doctolib.apps.authentication.model.DeviceKey;
import com.doctolib.apps.authentication.model.DeviceKeySlot;
import com.doctolib.apps.authentication.model.DeviceKeyStorage;
import com.doctolib.apps.authentication.model.DeviceKeyUserAuthentication;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class DeviceKeyRecord {
    public static final Companion Companion = new Companion(null);
    private final DeviceKey key;
    private final String pendingRevocationKid;
    private final String pendingRevocationSubject;

    public static /* synthetic */ DeviceKeyRecord copy$default(DeviceKeyRecord deviceKeyRecord, DeviceKey deviceKey, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            deviceKey = deviceKeyRecord.key;
        }
        if ((i & 2) != 0) {
            str = deviceKeyRecord.pendingRevocationKid;
        }
        if ((i & 4) != 0) {
            str2 = deviceKeyRecord.pendingRevocationSubject;
        }
        return deviceKeyRecord.copy(deviceKey, str, str2);
    }

    public final DeviceKeyRecord copy(DeviceKey deviceKey, String str, String str2) {
        return new DeviceKeyRecord(deviceKey, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceKeyRecord)) {
            return false;
        }
        DeviceKeyRecord deviceKeyRecord = (DeviceKeyRecord) obj;
        return Intrinsics.areEqual(this.key, deviceKeyRecord.key) && Intrinsics.areEqual(this.pendingRevocationKid, deviceKeyRecord.pendingRevocationKid) && Intrinsics.areEqual(this.pendingRevocationSubject, deviceKeyRecord.pendingRevocationSubject);
    }

    public int hashCode() {
        DeviceKey deviceKey = this.key;
        int iHashCode = (deviceKey == null ? 0 : deviceKey.hashCode()) * 31;
        String str = this.pendingRevocationKid;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.pendingRevocationSubject;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "DeviceKeyRecord(key=" + this.key + ", pendingRevocationKid=" + this.pendingRevocationKid + ", pendingRevocationSubject=" + this.pendingRevocationSubject + ")";
    }

    public DeviceKeyRecord(DeviceKey deviceKey, String str, String str2) {
        this.key = deviceKey;
        this.pendingRevocationKid = str;
        this.pendingRevocationSubject = str2;
    }

    public /* synthetic */ DeviceKeyRecord(DeviceKey deviceKey, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : deviceKey, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2);
    }

    public final DeviceKey getKey() {
        return this.key;
    }

    public final String getPendingRevocationKid() {
        return this.pendingRevocationKid;
    }

    public final String getPendingRevocationSubject() {
        return this.pendingRevocationSubject;
    }

    public final String toJson() throws JSONException {
        JSONObject jSONObjectPut = new JSONObject().put("v", 1);
        String str = this.pendingRevocationKid;
        if (str != null) {
            jSONObjectPut.put("pendingRevocationKid", str);
        }
        String str2 = this.pendingRevocationSubject;
        if (str2 != null) {
            jSONObjectPut.put("pendingRevocationSubject", str2);
        }
        DeviceKey deviceKey = this.key;
        if (deviceKey != null) {
            JSONObject jSONObjectPut2 = new JSONObject().put("slot", deviceKey.getSlot().getStringValue()).put("kid", deviceKey.getKid()).put("publicJwk", deviceKey.getPublicJwk()).put("userAuthentication", deviceKey.getUserAuthentication().getStringValue()).put("storage", deviceKey.getStorage().getStringValue());
            String subject = deviceKey.getSubject();
            if (subject != null) {
                jSONObjectPut2.put("subject", subject);
            }
            jSONObjectPut.put(SubscriberAttributeKt.JSON_NAME_KEY, jSONObjectPut2);
        }
        String string = jSONObjectPut.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceKeyRecord fromJson(String serialized) {
            DeviceKey deviceKeyDeviceKeyFrom;
            Intrinsics.checkNotNullParameter(serialized, "serialized");
            DeviceKey deviceKey = null;
            try {
                JSONObject jSONObject = new JSONObject(serialized);
                if (jSONObject.optInt("v", 0) != 1) {
                    return null;
                }
                Object objOpt = jSONObject.opt(SubscriberAttributeKt.JSON_NAME_KEY);
                if (objOpt == null || Intrinsics.areEqual(objOpt, JSONObject.NULL)) {
                    objOpt = null;
                }
                if (objOpt != null) {
                    JSONObject jSONObject2 = objOpt instanceof JSONObject ? (JSONObject) objOpt : null;
                    if (jSONObject2 == null || (deviceKeyDeviceKeyFrom = DeviceKeyRecord.Companion.deviceKeyFrom(jSONObject2)) == null) {
                        return null;
                    }
                    deviceKey = deviceKeyDeviceKeyFrom;
                }
                return new DeviceKeyRecord(deviceKey, nullableString(jSONObject, "pendingRevocationKid"), nullableString(jSONObject, "pendingRevocationSubject"));
            } catch (JSONException unused) {
                return null;
            }
        }

        private final DeviceKey deviceKeyFrom(JSONObject jSONObject) {
            Object next;
            Object next2;
            Object next3;
            String strNullableString;
            String strNullableString2;
            Iterator<E> it = DeviceKeySlot.getEntries().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.areEqual(((DeviceKeySlot) next).getStringValue(), jSONObject.optString("slot")));
            DeviceKeySlot deviceKeySlot = (DeviceKeySlot) next;
            if (deviceKeySlot == null) {
                return null;
            }
            Iterator<E> it2 = DeviceKeyUserAuthentication.getEntries().iterator();
            do {
                if (!it2.hasNext()) {
                    next2 = null;
                    break;
                }
                next2 = it2.next();
            } while (!Intrinsics.areEqual(((DeviceKeyUserAuthentication) next2).getStringValue(), jSONObject.optString("userAuthentication")));
            DeviceKeyUserAuthentication deviceKeyUserAuthentication = (DeviceKeyUserAuthentication) next2;
            if (deviceKeyUserAuthentication == null) {
                return null;
            }
            Iterator<E> it3 = DeviceKeyStorage.getEntries().iterator();
            do {
                if (!it3.hasNext()) {
                    next3 = null;
                    break;
                }
                next3 = it3.next();
            } while (!Intrinsics.areEqual(((DeviceKeyStorage) next3).getStringValue(), jSONObject.optString("storage")));
            DeviceKeyStorage deviceKeyStorage = (DeviceKeyStorage) next3;
            if (deviceKeyStorage == null || (strNullableString = nullableString(jSONObject, "kid")) == null || (strNullableString2 = nullableString(jSONObject, "publicJwk")) == null) {
                return null;
            }
            return new DeviceKey(deviceKeySlot, strNullableString, strNullableString2, nullableString(jSONObject, "subject"), deviceKeyUserAuthentication, deviceKeyStorage);
        }

        private final String nullableString(JSONObject jSONObject, String str) {
            if (jSONObject.isNull(str)) {
                return null;
            }
            String strOptString = jSONObject.optString(str);
            Intrinsics.checkNotNull(strOptString);
            if (strOptString.length() > 0) {
                return strOptString;
            }
            return null;
        }
    }
}
