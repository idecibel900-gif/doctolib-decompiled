package expo.modules.updates.selectionpolicy;

import expo.modules.updates.db.entity.UpdateEntity;
import expo.modules.updates.loader.UpdateDirective;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public interface LoaderSelectionPolicy {
    boolean shouldLoadNewUpdate(UpdateEntity updateEntity, UpdateEntity updateEntity2, JSONObject jSONObject);

    boolean shouldLoadRollBackToEmbeddedDirective(UpdateDirective.RollBackToEmbeddedUpdateDirective rollBackToEmbeddedUpdateDirective, UpdateEntity updateEntity, UpdateEntity updateEntity2, JSONObject jSONObject);
}
