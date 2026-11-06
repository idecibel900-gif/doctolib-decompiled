package expo.modules.updates.selectionpolicy;

import expo.modules.manifests.core.Manifest;
import expo.modules.updates.db.entity.UpdateEntity;
import java.util.Iterator;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class SelectionPolicies {
    public static final SelectionPolicies INSTANCE = new SelectionPolicies();
    private static final String TAG;

    private SelectionPolicies() {
    }

    static {
        String simpleName = SelectionPolicies.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        TAG = simpleName;
    }

    public final boolean matchesFilters(UpdateEntity update, JSONObject jSONObject) {
        JSONObject metadata;
        Intrinsics.checkNotNullParameter(update, "update");
        if (jSONObject == null || (metadata = Manifest.Companion.fromManifestJson(update.getManifest()).getMetadata()) == null) {
            return true;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            Iterator<String> itKeys = metadata.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Intrinsics.checkNotNull(next);
                String lowerCase = next.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                jSONObject2.put(lowerCase, metadata.get(next));
            }
            Iterator<String> itKeys2 = jSONObject.keys();
            while (itKeys2.hasNext()) {
                String next2 = itKeys2.next();
                if (jSONObject2.has(next2) && !Intrinsics.areEqual(jSONObject.get(next2), jSONObject2.get(next2))) {
                    return false;
                }
            }
        } catch (Exception unused) {
        }
        return true;
    }
}
