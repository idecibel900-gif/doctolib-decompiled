package expo.modules.asset;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import com.amazon.a.a.o.c.a.b;
import expo.modules.core.errors.InvalidArgumentException;
import java.io.InputStream;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ResourceAssetKt {
    public static final InputStream openAssetResourceStream(Context context, String assetName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(assetName, "assetName");
        Integer numFindResourceId = findResourceId(context, assetName);
        if (numFindResourceId == null) {
            throw new Resources.NotFoundException(assetName);
        }
        InputStream inputStreamOpenRawResource = context.getResources().openRawResource(numFindResourceId.intValue());
        Intrinsics.checkNotNullExpressionValue(inputStreamOpenRawResource, "openRawResource(...)");
        return inputStreamOpenRawResource;
    }

    public static final InputStream openAndroidResStream(Context context, String resourceFilePath) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(resourceFilePath, "resourceFilePath");
        Integer numFindResourceIdForAndroidResPath = findResourceIdForAndroidResPath(context, resourceFilePath);
        if (numFindResourceIdForAndroidResPath == null) {
            throw new Resources.NotFoundException(resourceFilePath);
        }
        InputStream inputStreamOpenRawResource = context.getResources().openRawResource(numFindResourceIdForAndroidResPath.intValue());
        Intrinsics.checkNotNullExpressionValue(inputStreamOpenRawResource, "openRawResource(...)");
        return inputStreamOpenRawResource;
    }

    private static final Integer findResourceId(Context context, String str) {
        Resources resources = context.getResources();
        String packageName = context.getPackageName();
        Integer numValueOf = Integer.valueOf(resources.getIdentifier(str, "raw", packageName));
        if (numValueOf.intValue() == 0) {
            numValueOf = null;
        }
        if (numValueOf != null) {
            return numValueOf;
        }
        Integer numValueOf2 = Integer.valueOf(resources.getIdentifier(str, "drawable", packageName));
        if (numValueOf2.intValue() != 0) {
            return numValueOf2;
        }
        return null;
    }

    private static final Integer findResourceIdForAndroidResPath(Context context, String str) {
        if (!StringsKt.startsWith$default(str, "file:///android_res/", false, 2, (Object) null)) {
            throw new InvalidArgumentException("Invalid resource file path: " + str);
        }
        List<String> pathSegments = Uri.parse(str).getPathSegments();
        if (pathSegments.size() < 3) {
            throw new InvalidArgumentException("Invalid resource file path: " + str);
        }
        String str2 = pathSegments.get(1);
        Intrinsics.checkNotNullExpressionValue(str2, "get(...)");
        String strSubstringBefore$default = StringsKt.substringBefore$default(str2, '-', (String) null, 2, (Object) null);
        String str3 = pathSegments.get(2);
        Intrinsics.checkNotNull(str3);
        Integer numValueOf = Integer.valueOf(context.getResources().getIdentifier(StringsKt.substringBeforeLast(str3, b.a, str3), strSubstringBefore$default, context.getPackageName()));
        if (numValueOf.intValue() != 0) {
            return numValueOf;
        }
        return null;
    }
}
