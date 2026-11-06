package expo.modules.updates.utils;

import android.content.Context;
import android.net.Uri;
import com.amazon.a.a.o.c.a.b;
import expo.modules.core.errors.InvalidArgumentException;
import expo.modules.updates.db.entity.AssetEntity;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
public final class AndroidResourceAssetUtils {
    public static final AndroidResourceAssetUtils INSTANCE = new AndroidResourceAssetUtils();

    private AndroidResourceAssetUtils() {
    }

    public final String createEmbeddedFilenameForAsset(AssetEntity asset) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        String fileExtension$expo_updates_release = asset.getFileExtension$expo_updates_release();
        if (asset.getEmbeddedAssetFilename() != null) {
            return "file:///android_asset/" + asset.getEmbeddedAssetFilename() + fileExtension$expo_updates_release;
        }
        if (asset.getResourcesFolder() == null || asset.getResourcesFilename() == null) {
            return null;
        }
        return "file:///android_res/" + asset.getResourcesFolder() + getDrawableSuffix(asset.getScale()) + "/" + asset.getResourcesFilename() + fileExtension$expo_updates_release;
    }

    public final boolean isAndroidResourceAsset(String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        return StringsKt.startsWith$default(filePath, "file:///android_res/", false, 2, (Object) null) || StringsKt.startsWith$default(filePath, "file:///android_asset/", false, 2, (Object) null);
    }

    public final boolean isAndroidAssetExisted(Context context, String name) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        try {
            context.getAssets().open(name).close();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public final boolean isAndroidResourceExisted(Context context, String resourceFolder, String resourceFilename) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(resourceFolder, "resourceFolder");
        Intrinsics.checkNotNullParameter(resourceFilename, "resourceFilename");
        return context.getResources().getIdentifier(resourceFilename, resourceFolder, context.getPackageName()) != 0;
    }

    public final boolean isAndroidAssetOrResourceExisted(Context context, String filePath) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        AndroidResourceAsset androidResponseAssetFromPath = parseAndroidResponseAssetFromPath(filePath);
        String strComponent1 = androidResponseAssetFromPath.component1();
        String strComponent2 = androidResponseAssetFromPath.component2();
        String strComponent3 = androidResponseAssetFromPath.component3();
        if (strComponent1 != null) {
            return isAndroidAssetExisted(context, strComponent1);
        }
        if (strComponent2 == null || strComponent3 == null) {
            return false;
        }
        return isAndroidResourceExisted(context, strComponent2, strComponent3);
    }

    public static final class AndroidResourceAsset {
        private final String embeddedAssetFilename;
        private final String resourceFilename;
        private final String resourcesFolder;

        public final String component1() {
            return this.embeddedAssetFilename;
        }

        public final String component2() {
            return this.resourcesFolder;
        }

        public final String component3() {
            return this.resourceFilename;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AndroidResourceAsset)) {
                return false;
            }
            AndroidResourceAsset androidResourceAsset = (AndroidResourceAsset) obj;
            return Intrinsics.areEqual(this.embeddedAssetFilename, androidResourceAsset.embeddedAssetFilename) && Intrinsics.areEqual(this.resourcesFolder, androidResourceAsset.resourcesFolder) && Intrinsics.areEqual(this.resourceFilename, androidResourceAsset.resourceFilename);
        }

        public int hashCode() {
            String str = this.embeddedAssetFilename;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.resourcesFolder;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.resourceFilename;
            return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            return "AndroidResourceAsset(embeddedAssetFilename=" + this.embeddedAssetFilename + ", resourcesFolder=" + this.resourcesFolder + ", resourceFilename=" + this.resourceFilename + ")";
        }

        public AndroidResourceAsset(String str, String str2, String str3) {
            this.embeddedAssetFilename = str;
            this.resourcesFolder = str2;
            this.resourceFilename = str3;
        }
    }

    public final AndroidResourceAsset parseAndroidResponseAssetFromPath(String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        if (StringsKt.startsWith$default(filePath, "file:///android_res/", false, 2, (Object) null)) {
            List<String> pathSegments = Uri.parse(filePath).getPathSegments();
            if (pathSegments.size() < 3) {
                throw new InvalidArgumentException("Invalid resource file path: " + filePath);
            }
            String str = pathSegments.get(1);
            Intrinsics.checkNotNullExpressionValue(str, "get(...)");
            String strSubstringBefore$default = StringsKt.substringBefore$default(str, '-', (String) null, 2, (Object) null);
            String str2 = pathSegments.get(2);
            Intrinsics.checkNotNullExpressionValue(str2, "get(...)");
            String str3 = pathSegments.get(2);
            Intrinsics.checkNotNullExpressionValue(str3, "get(...)");
            return new AndroidResourceAsset(null, strSubstringBefore$default, StringsKt.substringBeforeLast(str2, b.a, str3));
        }
        if (StringsKt.startsWith$default(filePath, "file:///android_asset/", false, 2, (Object) null)) {
            return new AndroidResourceAsset(StringsKt.substringAfterLast$default(filePath, '/', (String) null, 2, (Object) null), null, null);
        }
        return new AndroidResourceAsset(null, null, null);
    }

    private final String getDrawableSuffix(Float f) {
        if (Intrinsics.areEqual(f, 0.75f)) {
            return "-ldpi";
        }
        if (Intrinsics.areEqual(f, 1.0f)) {
            return "-mdpi";
        }
        if (Intrinsics.areEqual(f, 1.5f)) {
            return "-hdpi";
        }
        if (Intrinsics.areEqual(f, 2.0f)) {
            return "-xhdpi";
        }
        if (Intrinsics.areEqual(f, 3.0f)) {
            return "-xxhdpi";
        }
        return Intrinsics.areEqual(f, 4.0f) ? "-xxxhdpi" : "";
    }
}
