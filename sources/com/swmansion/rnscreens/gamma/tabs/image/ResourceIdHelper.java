package com.swmansion.rnscreens.gamma.tabs.image;

import android.content.Context;
import android.net.Uri;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
final class ResourceIdHelper {
    public static final ResourceIdHelper INSTANCE = new ResourceIdHelper();
    private static final Map idMap = new LinkedHashMap();

    private ResourceIdHelper() {
    }

    private final int getIdForResourceType(Context context, String str, String str2) {
        if (str.length() == 0) {
            return -1;
        }
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String lowerCase = str.toLowerCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String strReplace$default = StringsKt.replace$default(lowerCase, "-", "_", false, 4, (Object) null);
        String str3 = str2 + "/" + strReplace$default;
        synchronized (this) {
            Map map = idMap;
            Integer num = (Integer) map.get(str3);
            if (num != null) {
                return num.intValue();
            }
            int identifier = context.getResources().getIdentifier(strReplace$default, str2, context.getPackageName());
            map.put(str3, Integer.valueOf(identifier));
            return identifier;
        }
    }

    public final Uri getResourceUri(Context context, String name) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String lowerCase = name.toLowerCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        StringsKt.replace$default(lowerCase, "-", "_", false, 4, (Object) null);
        int idForResourceType = getIdForResourceType(context, name, "drawable");
        if (idForResourceType != 0) {
            return Uri.parse("res:/" + idForResourceType);
        }
        int idForResourceType2 = getIdForResourceType(context, name, "raw");
        if (idForResourceType2 != 0) {
            return Uri.parse("res:/" + idForResourceType2);
        }
        if (StringsKt.startsWith$default(name, "asset:/", false, 2, (Object) null)) {
            return Uri.parse("file:///android_asset/" + StringsKt.removePrefix(name, "asset:/"));
        }
        return Uri.parse("file:///android_asset/" + name);
    }
}
