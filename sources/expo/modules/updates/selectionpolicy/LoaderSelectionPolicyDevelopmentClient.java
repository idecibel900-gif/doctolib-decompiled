package expo.modules.updates.selectionpolicy;

import android.net.Uri;
import expo.modules.updates.UpdatesConfiguration;
import expo.modules.updates.db.entity.UpdateEntity;
import expo.modules.updates.loader.UpdateDirective;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class LoaderSelectionPolicyDevelopmentClient implements LoaderSelectionPolicy {
    private final UpdatesConfiguration config;

    public LoaderSelectionPolicyDevelopmentClient(UpdatesConfiguration updatesConfiguration) {
        this.config = updatesConfiguration;
    }

    @Override // expo.modules.updates.selectionpolicy.LoaderSelectionPolicy
    public boolean shouldLoadNewUpdate(UpdateEntity updateEntity, UpdateEntity updateEntity2, JSONObject jSONObject) {
        if (updateEntity == null) {
            return false;
        }
        SelectionPolicies selectionPolicies = SelectionPolicies.INSTANCE;
        if (!selectionPolicies.matchesFilters(updateEntity, jSONObject)) {
            return false;
        }
        if (updateEntity2 == null || !selectionPolicies.matchesFilters(updateEntity2, jSONObject)) {
            return true;
        }
        if (updateEntity.getUrl() != null) {
            Uri url = updateEntity.getUrl();
            UpdatesConfiguration updatesConfiguration = this.config;
            if (!Intrinsics.areEqual(url, updatesConfiguration != null ? updatesConfiguration.getUpdateUrl() : null)) {
                return false;
            }
        }
        if (updateEntity.getRequestHeaders() != null) {
            Map requestHeaders = updateEntity.getRequestHeaders();
            UpdatesConfiguration updatesConfiguration2 = this.config;
            if (!Intrinsics.areEqual(requestHeaders, updatesConfiguration2 != null ? updatesConfiguration2.getRequestHeaders() : null)) {
                return false;
            }
        }
        if (updateEntity2.getUrl() != null) {
            Uri url2 = updateEntity2.getUrl();
            UpdatesConfiguration updatesConfiguration3 = this.config;
            if (!Intrinsics.areEqual(url2, updatesConfiguration3 != null ? updatesConfiguration3.getUpdateUrl() : null)) {
                return true;
            }
        }
        if (updateEntity2.getRequestHeaders() != null) {
            Map requestHeaders2 = updateEntity2.getRequestHeaders();
            UpdatesConfiguration updatesConfiguration4 = this.config;
            if (!Intrinsics.areEqual(requestHeaders2, updatesConfiguration4 != null ? updatesConfiguration4.getRequestHeaders() : null)) {
                return true;
            }
        }
        return updateEntity.getCommitTime().after(updateEntity2.getCommitTime());
    }

    @Override // expo.modules.updates.selectionpolicy.LoaderSelectionPolicy
    public boolean shouldLoadRollBackToEmbeddedDirective(UpdateDirective.RollBackToEmbeddedUpdateDirective directive, UpdateEntity embeddedUpdate, UpdateEntity updateEntity, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(directive, "directive");
        Intrinsics.checkNotNullParameter(embeddedUpdate, "embeddedUpdate");
        SelectionPolicies selectionPolicies = SelectionPolicies.INSTANCE;
        if (!selectionPolicies.matchesFilters(embeddedUpdate, jSONObject)) {
            return false;
        }
        if (updateEntity != null && selectionPolicies.matchesFilters(updateEntity, jSONObject)) {
            return directive.getCommitTime().after(updateEntity.getCommitTime());
        }
        return true;
    }
}
