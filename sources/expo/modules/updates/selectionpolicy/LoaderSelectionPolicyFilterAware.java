package expo.modules.updates.selectionpolicy;

import expo.modules.updates.UpdatesConfiguration;
import expo.modules.updates.db.entity.UpdateEntity;
import expo.modules.updates.loader.UpdateDirective;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class LoaderSelectionPolicyFilterAware implements LoaderSelectionPolicy {
    private final UpdatesConfiguration config;

    public LoaderSelectionPolicyFilterAware(UpdatesConfiguration config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
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
        if (updateEntity.getUrl() != null && !Intrinsics.areEqual(updateEntity.getUrl(), this.config.getUpdateUrl())) {
            return false;
        }
        if (updateEntity.getRequestHeaders() != null && !Intrinsics.areEqual(updateEntity.getRequestHeaders(), this.config.getRequestHeaders())) {
            return false;
        }
        if (updateEntity2.getUrl() != null && !Intrinsics.areEqual(updateEntity2.getUrl(), this.config.getUpdateUrl())) {
            return true;
        }
        if (updateEntity2.getRequestHeaders() == null || Intrinsics.areEqual(updateEntity2.getRequestHeaders(), this.config.getRequestHeaders())) {
            return updateEntity.getCommitTime().after(updateEntity2.getCommitTime());
        }
        return true;
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
