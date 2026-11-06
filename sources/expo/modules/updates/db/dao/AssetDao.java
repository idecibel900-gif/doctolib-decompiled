package expo.modules.updates.db.dao;

import expo.modules.updates.db.entity.AssetEntity;
import expo.modules.updates.db.entity.UpdateAssetEntity;
import expo.modules.updates.db.entity.UpdateEntity;
import expo.modules.updates.utils.AndroidResourceAssetUtils;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AssetDao {
    protected abstract void deleteAssetsMarkedForDeletionInternal();

    protected abstract long insertAssetInternal(AssetEntity assetEntity);

    protected abstract void insertUpdateAssetInternal(UpdateAssetEntity updateAssetEntity);

    protected abstract List loadAssetWithKeyInternal(String str);

    public abstract List loadAssetsForUpdate(UUID uuid);

    protected abstract List loadAssetsMarkedForDeletionInternal();

    protected abstract void markAllAssetsForDeletionInternal();

    protected abstract void setUpdateLaunchAssetInternal(long j, UUID uuid);

    protected abstract void unMarkDuplicateUsedAssetsFromDeletionInternal();

    protected abstract void unMarkUsedAssetsFromDeletionInternal();

    protected abstract void unMarkUsedLaunchAssetsFromDeletionInternal();

    public abstract void updateAsset(AssetEntity assetEntity);

    public void insertAssets(List assets, UpdateEntity update) {
        Intrinsics.checkNotNullParameter(assets, "assets");
        Intrinsics.checkNotNullParameter(update, "update");
        Iterator it = assets.iterator();
        while (it.hasNext()) {
            AssetEntity assetEntity = (AssetEntity) it.next();
            long jInsertAssetInternal = insertAssetInternal(assetEntity);
            insertUpdateAssetInternal(new UpdateAssetEntity(update.getId(), jInsertAssetInternal));
            if (assetEntity.isLaunchAsset()) {
                setUpdateLaunchAssetInternal(jInsertAssetInternal, update.getId());
            }
        }
    }

    public final AssetEntity loadAssetWithKey(String str) {
        AssetEntity assetEntity = (AssetEntity) CollectionsKt.firstOrNull(loadAssetWithKeyInternal(str));
        if (assetEntity == null) {
            return null;
        }
        String relativePath = assetEntity.getRelativePath();
        if (relativePath != null) {
            AndroidResourceAssetUtils.AndroidResourceAsset androidResponseAssetFromPath = AndroidResourceAssetUtils.INSTANCE.parseAndroidResponseAssetFromPath(relativePath);
            String strComponent1 = androidResponseAssetFromPath.component1();
            String strComponent2 = androidResponseAssetFromPath.component2();
            String strComponent3 = androidResponseAssetFromPath.component3();
            assetEntity.setEmbeddedAssetFilename(strComponent1);
            assetEntity.setResourcesFolder(strComponent2);
            assetEntity.setResourcesFilename(strComponent3);
        }
        return assetEntity;
    }

    public final void mergeAndUpdateAsset(AssetEntity existingEntity, AssetEntity newEntity) {
        boolean z;
        Intrinsics.checkNotNullParameter(existingEntity, "existingEntity");
        Intrinsics.checkNotNullParameter(newEntity, "newEntity");
        boolean z2 = true;
        if (newEntity.getUrl() == null || (existingEntity.getUrl() != null && Intrinsics.areEqual(newEntity.getUrl(), existingEntity.getUrl()))) {
            z = false;
        } else {
            existingEntity.setUrl(newEntity.getUrl());
            z = true;
        }
        JSONObject extraRequestHeaders = newEntity.getExtraRequestHeaders();
        if (extraRequestHeaders == null || (existingEntity.getExtraRequestHeaders() != null && Intrinsics.areEqual(extraRequestHeaders, existingEntity.getExtraRequestHeaders()))) {
            z2 = z;
        } else {
            existingEntity.setExtraRequestHeaders(newEntity.getExtraRequestHeaders());
        }
        if (z2) {
            updateAsset(existingEntity);
        }
        existingEntity.setLaunchAsset(newEntity.isLaunchAsset());
        String embeddedAssetFilename = newEntity.getEmbeddedAssetFilename();
        if (embeddedAssetFilename != null) {
            existingEntity.setEmbeddedAssetFilename(embeddedAssetFilename);
        }
        String resourcesFilename = newEntity.getResourcesFilename();
        if (resourcesFilename != null) {
            existingEntity.setResourcesFilename(resourcesFilename);
        }
        String resourcesFolder = newEntity.getResourcesFolder();
        if (resourcesFolder != null) {
            existingEntity.setResourcesFolder(resourcesFolder);
        }
        Float scale = newEntity.getScale();
        if (scale != null) {
            existingEntity.setScale(Float.valueOf(scale.floatValue()));
        }
        Float[] scales = newEntity.getScales();
        if (scales != null) {
            existingEntity.setScales(scales);
        }
    }

    public boolean addExistingAssetToUpdate(UpdateEntity update, AssetEntity asset, boolean z) {
        Intrinsics.checkNotNullParameter(update, "update");
        Intrinsics.checkNotNullParameter(asset, "asset");
        AssetEntity assetEntityLoadAssetWithKey = loadAssetWithKey(asset.getKey());
        if (assetEntityLoadAssetWithKey == null) {
            return false;
        }
        long id = assetEntityLoadAssetWithKey.getId();
        insertUpdateAssetInternal(new UpdateAssetEntity(update.getId(), id));
        if (!z) {
            return true;
        }
        setUpdateLaunchAssetInternal(id, update.getId());
        return true;
    }

    public List deleteUnusedAssets() {
        markAllAssetsForDeletionInternal();
        unMarkUsedAssetsFromDeletionInternal();
        unMarkUsedLaunchAssetsFromDeletionInternal();
        unMarkDuplicateUsedAssetsFromDeletionInternal();
        List listLoadAssetsMarkedForDeletionInternal = loadAssetsMarkedForDeletionInternal();
        deleteAssetsMarkedForDeletionInternal();
        return listLoadAssetsMarkedForDeletionInternal;
    }
}
