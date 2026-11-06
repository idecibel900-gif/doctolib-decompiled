package expo.modules.updates.manifest;

import expo.modules.manifests.core.Manifest;
import expo.modules.updates.db.entity.UpdateEntity;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface Update {
    List getAssetEntityList();

    Manifest getManifest();

    UpdateEntity getUpdateEntity();

    boolean isDevelopmentMode();
}
