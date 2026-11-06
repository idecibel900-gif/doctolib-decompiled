package expo.modules.updates.db.dao;

import expo.modules.updates.db.entity.AssetEntity;
import expo.modules.updates.db.entity.UpdateEntity;
import expo.modules.updates.db.enums.UpdateStatus;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class UpdateDao {
    public abstract void _setUpdateScopeKeyInternal(UUID uuid, String str);

    public abstract void deleteUpdates(List list);

    public abstract void incrementFailedLaunchCountInternal(UUID uuid);

    protected abstract void incrementSuccessfulLaunchCountInternal(UUID uuid);

    public abstract void insertUpdate(UpdateEntity updateEntity);

    protected abstract void keepUpdate(UUID uuid);

    public abstract List loadAllUpdates();

    protected abstract AssetEntity loadLaunchAssetForUpdateInternal(UUID uuid);

    protected abstract List loadLaunchableUpdatesForProjectWithStatuses(String str, List list);

    public abstract List loadRecentUpdateIdsWithFailedLaunch();

    protected abstract List loadUpdatesWithId(UUID uuid);

    protected abstract void markUpdateAccessedInternal(UUID uuid, Date date);

    protected abstract void markUpdateWithStatus(UpdateStatus updateStatus, UUID uuid);

    public abstract void setUpdateCommitTimeInternal(UUID uuid, Date date);

    public final List loadLaunchableUpdatesForScope(String scopeKey) {
        Intrinsics.checkNotNullParameter(scopeKey, "scopeKey");
        return loadLaunchableUpdatesForProjectWithStatuses(scopeKey, CollectionsKt.listOf((Object[]) new UpdateStatus[]{UpdateStatus.READY, UpdateStatus.EMBEDDED, UpdateStatus.DEVELOPMENT}));
    }

    public final UpdateEntity loadUpdateWithId(UUID id) {
        Intrinsics.checkNotNullParameter(id, "id");
        List listLoadUpdatesWithId = loadUpdatesWithId(id);
        if (listLoadUpdatesWithId.isEmpty()) {
            return null;
        }
        return (UpdateEntity) listLoadUpdatesWithId.get(0);
    }

    public final AssetEntity loadLaunchAssetForUpdate(UUID updateId) {
        Intrinsics.checkNotNullParameter(updateId, "updateId");
        AssetEntity assetEntityLoadLaunchAssetForUpdateInternal = loadLaunchAssetForUpdateInternal(updateId);
        if (assetEntityLoadLaunchAssetForUpdateInternal == null) {
            return null;
        }
        assetEntityLoadLaunchAssetForUpdateInternal.setLaunchAsset(true);
        return assetEntityLoadLaunchAssetForUpdateInternal;
    }

    public final void setUpdateScopeKey(UpdateEntity update, String newScopeKey) {
        Intrinsics.checkNotNullParameter(update, "update");
        Intrinsics.checkNotNullParameter(newScopeKey, "newScopeKey");
        update.setScopeKey(newScopeKey);
        _setUpdateScopeKeyInternal(update.getId(), newScopeKey);
    }

    public final void setUpdateCommitTime(UpdateEntity update, Date commitTime) {
        Intrinsics.checkNotNullParameter(update, "update");
        Intrinsics.checkNotNullParameter(commitTime, "commitTime");
        update.setCommitTime(commitTime);
        setUpdateCommitTimeInternal(update.getId(), commitTime);
    }

    public void markUpdateFinished(UpdateEntity update, boolean z) {
        Intrinsics.checkNotNullParameter(update, "update");
        UpdateStatus updateStatus = UpdateStatus.READY;
        UpdateStatus status = update.getStatus();
        UpdateStatus updateStatus2 = UpdateStatus.DEVELOPMENT;
        if (status == updateStatus2) {
            updateStatus = updateStatus2;
        } else if (z) {
            updateStatus = UpdateStatus.EMBEDDED;
        }
        markUpdateWithStatus(updateStatus, update.getId());
        keepUpdate(update.getId());
    }

    public final void markUpdateFinished(UpdateEntity update) {
        Intrinsics.checkNotNullParameter(update, "update");
        markUpdateFinished(update, false);
    }

    public final void markUpdateAccessed(UpdateEntity update) {
        Intrinsics.checkNotNullParameter(update, "update");
        Date date = new Date();
        update.setLastAccessed(date);
        markUpdateAccessedInternal(update.getId(), date);
    }

    public final void incrementSuccessfulLaunchCount(UpdateEntity update) {
        Intrinsics.checkNotNullParameter(update, "update");
        update.setSuccessfulLaunchCount(update.getSuccessfulLaunchCount() + 1);
        incrementSuccessfulLaunchCountInternal(update.getId());
    }

    public final void incrementFailedLaunchCount(UpdateEntity update) {
        Intrinsics.checkNotNullParameter(update, "update");
        update.setFailedLaunchCount(update.getFailedLaunchCount() + 1);
        incrementFailedLaunchCountInternal(update.getId());
    }
}
