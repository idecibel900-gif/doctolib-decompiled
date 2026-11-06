package expo.modules.updates.selectionpolicy;

import expo.modules.updates.db.entity.UpdateEntity;
import expo.modules.updates.db.enums.UpdateStatus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class ReaperSelectionPolicyFilterAware implements ReaperSelectionPolicy {
    @Override // expo.modules.updates.selectionpolicy.ReaperSelectionPolicy
    public List selectUpdatesToDelete(List updates, UpdateEntity updateEntity, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(updates, "updates");
        if (updateEntity == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = updates.iterator();
        UpdateEntity updateEntity2 = null;
        UpdateEntity updateEntity3 = null;
        while (it.hasNext()) {
            UpdateEntity updateEntity4 = (UpdateEntity) it.next();
            if (Intrinsics.areEqual(updateEntity4.getScopeKey(), updateEntity.getScopeKey()) && updateEntity4.getCommitTime().before(updateEntity.getCommitTime())) {
                arrayList.add(updateEntity4);
                if (updateEntity3 == null || updateEntity3.getCommitTime().before(updateEntity4.getCommitTime())) {
                    updateEntity3 = updateEntity4;
                }
                if (SelectionPolicies.INSTANCE.matchesFilters(updateEntity4, jSONObject) && (updateEntity2 == null || updateEntity2.getCommitTime().before(updateEntity4.getCommitTime()))) {
                    updateEntity2 = updateEntity4;
                }
            }
        }
        if (updateEntity2 != null) {
            arrayList.remove(updateEntity2);
        } else if (updateEntity3 != null) {
            arrayList.remove(updateEntity3);
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((UpdateEntity) obj).getStatus() != UpdateStatus.EMBEDDED) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }
}
