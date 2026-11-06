package expo.modules.updates.selectionpolicy;

import android.net.Uri;
import expo.modules.updates.UpdatesConfiguration;
import expo.modules.updates.db.entity.UpdateEntity;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class LauncherSelectionPolicyDevelopmentClient implements LauncherSelectionPolicy {
    private final UpdatesConfiguration config;
    private final String runtimeVersion;

    public LauncherSelectionPolicyDevelopmentClient(String runtimeVersion, UpdatesConfiguration updatesConfiguration) {
        Intrinsics.checkNotNullParameter(runtimeVersion, "runtimeVersion");
        this.runtimeVersion = runtimeVersion;
        this.config = updatesConfiguration;
    }

    @Override // expo.modules.updates.selectionpolicy.LauncherSelectionPolicy
    public UpdateEntity selectUpdateToLaunch(List updates, JSONObject jSONObject) {
        Object next;
        Intrinsics.checkNotNullParameter(updates, "updates");
        ArrayList arrayList = new ArrayList();
        for (Object obj : updates) {
            UpdateEntity updateEntity = (UpdateEntity) obj;
            if (Intrinsics.areEqual(this.runtimeVersion, updateEntity.getRuntimeVersion()) && SelectionPolicies.INSTANCE.matchesFilters(updateEntity, jSONObject)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (true) {
            next = null;
            if (!it.hasNext()) {
                break;
            }
            Object next2 = it.next();
            UpdateEntity updateEntity2 = (UpdateEntity) next2;
            if (updateEntity2.getUrl() != null || updateEntity2.getRequestHeaders() != null) {
                Uri url = updateEntity2.getUrl();
                UpdatesConfiguration updatesConfiguration = this.config;
                if (Intrinsics.areEqual(url, updatesConfiguration != null ? updatesConfiguration.getUpdateUrl() : null)) {
                    Map requestHeaders = updateEntity2.getRequestHeaders();
                    UpdatesConfiguration updatesConfiguration2 = this.config;
                    if (Intrinsics.areEqual(requestHeaders, updatesConfiguration2 != null ? updatesConfiguration2.getRequestHeaders() : null)) {
                    }
                }
            }
            arrayList2.add(next2);
        }
        Iterator it2 = arrayList2.iterator();
        if (it2.hasNext()) {
            next = it2.next();
            if (it2.hasNext()) {
                Date commitTime = ((UpdateEntity) next).getCommitTime();
                do {
                    Object next3 = it2.next();
                    Date commitTime2 = ((UpdateEntity) next3).getCommitTime();
                    if (commitTime.compareTo(commitTime2) < 0) {
                        next = next3;
                        commitTime = commitTime2;
                    }
                } while (it2.hasNext());
            }
        }
        return (UpdateEntity) next;
    }
}
