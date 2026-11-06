package expo.modules.updates.selectionpolicy;

import expo.modules.updates.db.entity.UpdateEntity;
import expo.modules.updates.loader.UpdateDirective;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class SelectionPolicy {
    private final LauncherSelectionPolicy launcherSelectionPolicy;
    private final LoaderSelectionPolicy loaderSelectionPolicy;
    private final ReaperSelectionPolicy reaperSelectionPolicy;

    public SelectionPolicy(LauncherSelectionPolicy launcherSelectionPolicy, LoaderSelectionPolicy loaderSelectionPolicy, ReaperSelectionPolicy reaperSelectionPolicy) {
        Intrinsics.checkNotNullParameter(launcherSelectionPolicy, "launcherSelectionPolicy");
        Intrinsics.checkNotNullParameter(loaderSelectionPolicy, "loaderSelectionPolicy");
        Intrinsics.checkNotNullParameter(reaperSelectionPolicy, "reaperSelectionPolicy");
        this.launcherSelectionPolicy = launcherSelectionPolicy;
        this.loaderSelectionPolicy = loaderSelectionPolicy;
        this.reaperSelectionPolicy = reaperSelectionPolicy;
    }

    public final UpdateEntity selectUpdateToLaunch(List updates, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(updates, "updates");
        return this.launcherSelectionPolicy.selectUpdateToLaunch(updates, jSONObject);
    }

    public final List selectUpdatesToDelete(List updates, UpdateEntity launchedUpdate, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(updates, "updates");
        Intrinsics.checkNotNullParameter(launchedUpdate, "launchedUpdate");
        return this.reaperSelectionPolicy.selectUpdatesToDelete(updates, launchedUpdate, jSONObject);
    }

    public final boolean shouldLoadNewUpdate(UpdateEntity updateEntity, UpdateEntity updateEntity2, JSONObject jSONObject) {
        return this.loaderSelectionPolicy.shouldLoadNewUpdate(updateEntity, updateEntity2, jSONObject);
    }

    public final boolean shouldLoadRollBackToEmbeddedDirective(UpdateDirective.RollBackToEmbeddedUpdateDirective directive, UpdateEntity embeddedUpdate, UpdateEntity updateEntity, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(directive, "directive");
        Intrinsics.checkNotNullParameter(embeddedUpdate, "embeddedUpdate");
        return this.loaderSelectionPolicy.shouldLoadRollBackToEmbeddedDirective(directive, embeddedUpdate, updateEntity, jSONObject);
    }
}
