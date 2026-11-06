package com.facebook.react.views.imagehelper;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.core.content.res.ResourcesCompat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class ResourceDrawableIdHelper {
    public static final ResourceDrawableIdHelper INSTANCE = new ResourceDrawableIdHelper();
    private static final Map resourceDrawableIdMap = new HashMap();

    private ResourceDrawableIdHelper() {
    }

    public static final synchronized void clear() {
        resourceDrawableIdMap.clear();
    }

    public static final int getResourceDrawableId(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (str == null || str.length() == 0) {
            return 0;
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String strReplace$default = StringsKt.replace$default(lowerCase, "-", "_", false, 4, (Object) null);
        try {
            return Integer.parseInt(strReplace$default);
        } catch (NumberFormatException unused) {
            synchronized (INSTANCE) {
                try {
                    Integer num = (Integer) resourceDrawableIdMap.get(strReplace$default);
                    return num != null ? num.intValue() : INSTANCE.addDrawableId(context, strReplace$default);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private final int addDrawableId(Context context, String str) {
        int identifier = context.getResources().getIdentifier(str, "drawable", context.getPackageName());
        resourceDrawableIdMap.put(str, Integer.valueOf(identifier));
        return identifier;
    }

    public static final Drawable getResourceDrawable(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        int resourceDrawableId = getResourceDrawableId(context, str);
        if (resourceDrawableId > 0) {
            return ResourcesCompat.getDrawable(context.getResources(), resourceDrawableId, null);
        }
        return null;
    }

    public static final Uri getResourceDrawableUri(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        int resourceDrawableId = getResourceDrawableId(context, str);
        if (resourceDrawableId > 0) {
            Uri uriBuild = new Uri.Builder().scheme("res").path(String.valueOf(resourceDrawableId)).build();
            Intrinsics.checkNotNull(uriBuild);
            return uriBuild;
        }
        Uri uri = Uri.EMPTY;
        Intrinsics.checkNotNull(uri);
        return uri;
    }

    public static final ResourceDrawableIdHelper getInstance() {
        return INSTANCE;
    }
}
