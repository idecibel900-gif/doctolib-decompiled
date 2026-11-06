package expo.modules.updates.db;

import android.net.Uri;
import expo.modules.updates.UpdatesConfiguration;
import expo.modules.updates.UpdatesUtils;
import expo.modules.updates.db.entity.AssetEntity;
import expo.modules.updates.db.entity.UpdateEntity;
import expo.modules.updates.manifest.ManifestMetadata;
import expo.modules.updates.selectionpolicy.SelectionPolicy;
import expo.modules.updates.utils.AndroidResourceAssetUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class Reaper {
    public static final Reaper INSTANCE = new Reaper();
    private static final String TAG = Reaper.class.getSimpleName();

    private Reaper() {
    }

    public static final void reapUnusedUpdates(UpdatesConfiguration configuration, UpdatesDatabase database, File file, UpdateEntity updateEntity, SelectionPolicy selectionPolicy) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(selectionPolicy, "selectionPolicy");
        if (updateEntity == null) {
            return;
        }
        database.updateDao().deleteUpdates(selectionPolicy.selectUpdatesToDelete(database.updateDao().loadAllUpdates(), updateEntity, ManifestMetadata.INSTANCE.getManifestFilters(database, configuration)));
        List<AssetEntity> listDeleteUnusedAssets = database.assetDao().deleteUnusedAssets();
        ArrayList<AssetEntity> arrayList = new ArrayList();
        for (AssetEntity assetEntity : listDeleteUnusedAssets) {
            if (!assetEntity.getMarkedForDeletion()) {
                Objects.toString(assetEntity.getUrl());
            } else {
                String relativePath = assetEntity.getRelativePath();
                if (relativePath != null && !AndroidResourceAssetUtils.INSTANCE.isAndroidResourceAsset(relativePath)) {
                    if (!UpdatesUtils.INSTANCE.isSafeFilename(relativePath)) {
                        Objects.toString(assetEntity.getUrl());
                    } else {
                        File file2 = new File(file, relativePath);
                        try {
                            if (file2.exists() && !file2.delete()) {
                                Objects.toString(assetEntity.getUrl());
                                file2.toString();
                                arrayList.add(assetEntity);
                            }
                            Unit unit = Unit.INSTANCE;
                        } catch (Exception unused) {
                            Objects.toString(assetEntity.getUrl());
                            file2.toString();
                            arrayList.add(assetEntity);
                        }
                    }
                }
            }
        }
        for (AssetEntity assetEntity2 : arrayList) {
            File file3 = new File(file, assetEntity2.getRelativePath());
            try {
                if (!file3.exists() || file3.delete()) {
                    arrayList.remove(assetEntity2);
                } else {
                    Uri url = assetEntity2.getUrl();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Retried and failed again deleting asset with URL ");
                    sb.append(url);
                    sb.append(" at path ");
                    sb.append(file3);
                }
            } catch (Exception unused2) {
                Objects.toString(assetEntity2.getUrl());
                file3.toString();
                arrayList.add(assetEntity2);
            }
        }
    }
}
