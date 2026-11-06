package expo.modules.manifests.core;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public abstract class JSONObjectExtensionKt {
    public static final Map toMap(JSONObject jSONObject) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Iterator<String> itKeys = jSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(itKeys, "keys(...)");
        Sequence sequenceAsSequence = SequencesKt.asSequence(itKeys);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : sequenceAsSequence) {
            Object map = jSONObject.get((String) obj);
            if (map instanceof JSONObject) {
                map = toMap((JSONObject) map);
            }
            linkedHashMap.put(obj, map);
        }
        return linkedHashMap;
    }
}
