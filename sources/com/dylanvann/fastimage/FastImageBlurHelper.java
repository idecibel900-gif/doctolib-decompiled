package com.dylanvann.fastimage;

import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.request.RequestOptions;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
abstract class FastImageBlurHelper {
    static RequestOptions transform(Context context, RequestOptions requestOptions, Map map) {
        ImageView imageView;
        if (map != null && (imageView = getImageView(map.get("view"))) != null) {
            int i = getInt(map.get("blurRadius"));
            if (getBoolean(map.get("blurRadiusShouldClean"))) {
                FastImageBlurTransformation.clean(imageView);
            }
            if (i > 0) {
                return (RequestOptions) requestOptions.transform(new FastImageBlurTransformation(context, i, imageView));
            }
        }
        return requestOptions;
    }

    private static ImageView getImageView(Object obj) {
        if (obj instanceof ImageView) {
            return (ImageView) obj;
        }
        return null;
    }

    private static int getInt(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).intValue();
        }
        return 0;
    }

    private static boolean getBoolean(Object obj) {
        return (obj instanceof Boolean) && ((Boolean) obj).booleanValue();
    }
}
