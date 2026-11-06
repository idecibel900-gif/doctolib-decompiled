package expo.modules.updates.selectionpolicy;

import expo.modules.updates.db.entity.UpdateEntity;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public interface ReaperSelectionPolicy {
    List selectUpdatesToDelete(List list, UpdateEntity updateEntity, JSONObject jSONObject);
}
