package expo.modules.updates.selectionpolicy;

import expo.modules.updates.UpdatesConfiguration;
import expo.modules.updates.db.entity.UpdateEntity;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class LauncherSelectionPolicyFilterAware implements LauncherSelectionPolicy {
    private final UpdatesConfiguration config;
    private final String runtimeVersion;

    public LauncherSelectionPolicyFilterAware(String runtimeVersion, UpdatesConfiguration config) {
        Intrinsics.checkNotNullParameter(runtimeVersion, "runtimeVersion");
        Intrinsics.checkNotNullParameter(config, "config");
        this.runtimeVersion = runtimeVersion;
        this.config = config;
    }

    @Override // expo.modules.updates.selectionpolicy.LauncherSelectionPolicy
    public UpdateEntity selectUpdateToLaunch(List updates, JSONObject jSONObject) {
        Object obj;
        Intrinsics.checkNotNullParameter(updates, "updates");
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : updates) {
            UpdateEntity updateEntity = (UpdateEntity) obj2;
            if (Intrinsics.areEqual(this.runtimeVersion, updateEntity.getRuntimeVersion()) && SelectionPolicies.INSTANCE.matchesFilters(updateEntity, jSONObject)) {
                arrayList.add(obj2);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj3 : arrayList) {
            UpdateEntity updateEntity2 = (UpdateEntity) obj3;
            if ((updateEntity2.getUrl() == null && updateEntity2.getRequestHeaders() == null) || (Intrinsics.areEqual(updateEntity2.getUrl(), this.config.getUpdateUrl()) && Intrinsics.areEqual(updateEntity2.getRequestHeaders(), this.config.getRequestHeaders()))) {
                arrayList2.add(obj3);
            }
        }
        Iterator it = arrayList2.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                Date commitTime = ((UpdateEntity) next).getCommitTime();
                do {
                    Object next2 = it.next();
                    Date commitTime2 = ((UpdateEntity) next2).getCommitTime();
                    if (commitTime.compareTo(commitTime2) < 0) {
                        next = next2;
                        commitTime = commitTime2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        return (UpdateEntity) obj;
    }
}
