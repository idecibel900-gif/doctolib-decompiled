package expo.modules.image;

import android.content.Context;
import android.net.Uri;
import com.facebook.react.views.imagehelper.ResourceDrawableIdHelper;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class ResourceIdHelper {
    public static final ResourceIdHelper INSTANCE = new ResourceIdHelper();
    private static final Map idMap = new LinkedHashMap();

    private ResourceIdHelper() {
    }

    private final int getResourceRawId(Context context, String str) {
        if (str.length() == 0) {
            return -1;
        }
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String lowerCase = str.toLowerCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String strReplace$default = StringsKt.replace$default(lowerCase, "-", "_", false, 4, (Object) null);
        synchronized (this) {
            Map map = idMap;
            Integer num = (Integer) map.get(strReplace$default);
            if (num != null) {
                return num.intValue();
            }
            int identifier = context.getResources().getIdentifier(strReplace$default, "raw", context.getPackageName());
            map.put(strReplace$default, Integer.valueOf(identifier));
            return identifier;
        }
    }

    public final Uri getResourceUri(Context context, String name) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        Uri resourceDrawableUri = ResourceDrawableIdHelper.getResourceDrawableUri(context, name);
        if (!Intrinsics.areEqual(resourceDrawableUri, Uri.EMPTY)) {
            return resourceDrawableUri;
        }
        int resourceRawId = getResourceRawId(context, name);
        if (resourceRawId > 0) {
            return new Uri.Builder().scheme("res").path(String.valueOf(resourceRawId)).build();
        }
        return null;
    }
}
