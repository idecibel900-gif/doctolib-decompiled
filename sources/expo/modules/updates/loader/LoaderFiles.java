package expo.modules.updates.loader;

import android.content.Context;
import android.content.res.AssetManager;
import expo.modules.updates.UpdatesConfiguration;
import expo.modules.updates.UpdatesUtils;
import expo.modules.updates.db.entity.AssetEntity;
import expo.modules.updates.manifest.EmbeddedManifestUtils;
import expo.modules.updates.manifest.Update;
import expo.modules.updates.utils.AndroidResourceAssetUtils;
import java.io.File;
import java.io.InputStream;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public class LoaderFiles {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = LoaderFiles.class.getSimpleName();

    public final boolean fileExists(Context context, File file, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (str == null) {
            return false;
        }
        if (AndroidResourceAssetUtils.INSTANCE.isAndroidAssetOrResourceExisted(context, str)) {
            return true;
        }
        return new File(file, str).exists();
    }

    public final Update readEmbeddedUpdate(Context context, UpdatesConfiguration configuration) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        return EmbeddedManifestUtils.INSTANCE.getEmbeddedUpdate(context, configuration);
    }

    public final byte[] copyAssetAndGetHash(AssetEntity asset, File destination, Context context) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(context, "context");
        if (asset.getEmbeddedAssetFilename() != null) {
            return copyContextAssetAndGetHash$expo_updates_release(asset, destination, context);
        }
        if (asset.getResourcesFilename() != null && asset.getResourcesFolder() != null) {
            return copyResourceAndGetHash$expo_updates_release(asset, destination, context);
        }
        throw new AssertionError("Failed to copy embedded asset " + asset.getKey() + " from APK assets or resources because not enough information was provided.");
    }

    public final byte[] copyContextAssetAndGetHash$expo_updates_release(AssetEntity asset, File destination, Context context) throws Exception {
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            AssetManager assets = context.getAssets();
            String embeddedAssetFilename = asset.getEmbeddedAssetFilename();
            Intrinsics.checkNotNull(embeddedAssetFilename);
            InputStream inputStreamOpen = assets.open(embeddedAssetFilename);
            try {
                UpdatesUtils updatesUtils = UpdatesUtils.INSTANCE;
                Intrinsics.checkNotNull(inputStreamOpen);
                byte[] bArrVerifySHA256AndWriteToFile = updatesUtils.verifySHA256AndWriteToFile(inputStreamOpen, destination, null);
                CloseableKt.closeFinally(inputStreamOpen, null);
                return bArrVerifySHA256AndWriteToFile;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(inputStreamOpen, th);
                    throw th2;
                }
            }
        } catch (Exception e) {
            asset.getEmbeddedAssetFilename();
            throw e;
        }
    }

    public final byte[] copyResourceAndGetHash$expo_updates_release(AssetEntity asset, File destination, Context context) throws Exception {
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            InputStream inputStreamOpenRawResource = context.getResources().openRawResource(context.getResources().getIdentifier(asset.getResourcesFilename(), asset.getResourcesFolder(), context.getPackageName()));
            try {
                UpdatesUtils updatesUtils = UpdatesUtils.INSTANCE;
                Intrinsics.checkNotNull(inputStreamOpenRawResource);
                byte[] bArrVerifySHA256AndWriteToFile = updatesUtils.verifySHA256AndWriteToFile(inputStreamOpenRawResource, destination, null);
                CloseableKt.closeFinally(inputStreamOpenRawResource, null);
                return bArrVerifySHA256AndWriteToFile;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(inputStreamOpenRawResource, th);
                    throw th2;
                }
            }
        } catch (Exception e) {
            asset.getResourcesFolder();
            asset.getEmbeddedAssetFilename();
            throw e;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
