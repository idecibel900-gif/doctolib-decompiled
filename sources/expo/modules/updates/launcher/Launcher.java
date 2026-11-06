package expo.modules.updates.launcher;

import expo.modules.updates.db.entity.UpdateEntity;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public interface Launcher {

    public interface LauncherCallback {
        void onFailure(Exception exc);

        void onSuccess();
    }

    String getBundleAssetName();

    String getLaunchAssetFile();

    UpdateEntity getLaunchedUpdate();

    /* JADX INFO: renamed from: getLocalAssetFiles */
    Map mo4981getLocalAssetFiles();

    boolean isUsingEmbeddedAssets();
}
