package expo.modules.updates.db;

import android.net.Uri;
import expo.modules.updates.db.enums.HashType;
import expo.modules.updates.db.enums.UpdateStatus;
import java.nio.ByteBuffer;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class Converters {
    private final String TAG = Converters.class.getSimpleName();

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[UpdateStatus.values().length];
            try {
                iArr[UpdateStatus.READY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[UpdateStatus.PENDING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[UpdateStatus.EMBEDDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[UpdateStatus.DEVELOPMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final int hashTypeToInt(HashType hashType) {
        return 0;
    }

    public final Date longToDate(Long l) {
        if (l == null) {
            return null;
        }
        return new Date(l.longValue());
    }

    public final Long dateToLong(Date date) {
        if (date != null) {
            return Long.valueOf(date.getTime());
        }
        return null;
    }

    public final Uri stringToUri(String str) {
        if (str == null) {
            return null;
        }
        return Uri.parse(str);
    }

    public final String uriToString(Uri uri) {
        if (uri != null) {
            return uri.toString();
        }
        return null;
    }

    public final JSONObject stringToJsonObject(String str) {
        if (str == null) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException unused) {
            return new JSONObject();
        }
    }

    public final String jsonObjectToString(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.toString();
        }
        return null;
    }

    public final UUID bytesToUuid(byte[] bArr) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        return new UUID(byteBufferWrap.getLong(), byteBufferWrap.getLong());
    }

    public final byte[] uuidToBytes(UUID uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[16]);
        byteBufferWrap.putLong(uuid.getMostSignificantBits());
        byteBufferWrap.putLong(uuid.getLeastSignificantBits());
        byte[] bArrArray = byteBufferWrap.array();
        Intrinsics.checkNotNullExpressionValue(bArrArray, "array(...)");
        return bArrArray;
    }

    public final UpdateStatus intToStatus(int i) {
        if (i == 1) {
            return UpdateStatus.READY;
        }
        if (i == 3) {
            return UpdateStatus.PENDING;
        }
        if (i == 5) {
            return UpdateStatus.EMBEDDED;
        }
        if (i == 6) {
            return UpdateStatus.DEVELOPMENT;
        }
        throw new AssertionError("Invalid UpdateStatus value in database: " + i);
    }

    public final int statusToInt(UpdateStatus updateStatus) {
        int i = updateStatus == null ? -1 : WhenMappings.$EnumSwitchMapping$0[updateStatus.ordinal()];
        if (i == 1) {
            return 1;
        }
        if (i == 2) {
            return 3;
        }
        if (i == 3) {
            return 5;
        }
        if (i == 4) {
            return 6;
        }
        throw new AssertionError("Invalid UpdateStatus value: " + updateStatus);
    }

    public final HashType intToHashType(int i) {
        return HashType.SHA256;
    }

    public final Map stringToStringStringMap(String str) {
        if (str == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Intrinsics.checkNotNull(next);
            String strOptString = jSONObject.optString(next);
            Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
            mapCreateMapBuilder.put(next, strOptString);
        }
        return MapsKt.build(mapCreateMapBuilder);
    }

    public final String stringStringMapToString(Map map) throws JSONException {
        if (map == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry entry : map.entrySet()) {
            jSONObject.put((String) entry.getKey(), (String) entry.getValue());
        }
        return jSONObject.toString();
    }
}
