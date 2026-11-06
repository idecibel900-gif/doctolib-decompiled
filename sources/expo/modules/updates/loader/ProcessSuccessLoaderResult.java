package expo.modules.updates.loader;

import expo.modules.updates.db.entity.UpdateEntity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class ProcessSuccessLoaderResult {
    private final UpdateEntity availableUpdate;
    private final boolean didRollBackToEmbedded;

    public final UpdateEntity component1() {
        return this.availableUpdate;
    }

    public final boolean component2() {
        return this.didRollBackToEmbedded;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProcessSuccessLoaderResult)) {
            return false;
        }
        ProcessSuccessLoaderResult processSuccessLoaderResult = (ProcessSuccessLoaderResult) obj;
        return Intrinsics.areEqual(this.availableUpdate, processSuccessLoaderResult.availableUpdate) && this.didRollBackToEmbedded == processSuccessLoaderResult.didRollBackToEmbedded;
    }

    public int hashCode() {
        UpdateEntity updateEntity = this.availableUpdate;
        return ((updateEntity == null ? 0 : updateEntity.hashCode()) * 31) + Boolean.hashCode(this.didRollBackToEmbedded);
    }

    public String toString() {
        return "ProcessSuccessLoaderResult(availableUpdate=" + this.availableUpdate + ", didRollBackToEmbedded=" + this.didRollBackToEmbedded + ")";
    }

    public ProcessSuccessLoaderResult(UpdateEntity updateEntity, boolean z) {
        this.availableUpdate = updateEntity;
        this.didRollBackToEmbedded = z;
    }

    public final UpdateEntity getAvailableUpdate() {
        return this.availableUpdate;
    }
}
