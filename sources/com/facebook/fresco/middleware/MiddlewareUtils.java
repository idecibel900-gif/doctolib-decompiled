package com.facebook.fresco.middleware;

import android.graphics.PointF;
import android.graphics.Rect;
import android.net.Uri;
import com.facebook.fresco.ui.common.ControllerListener2;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class MiddlewareUtils {
    public static final MiddlewareUtils INSTANCE = new MiddlewareUtils();

    private MiddlewareUtils() {
    }

    public static final ControllerListener2.Extras obtainExtras(Map componentAttribution, Map shortcutAttribution, Map map, Map map2, Rect rect, String str, PointF pointF, Map map3, Object obj, boolean z, Uri uri) {
        Intrinsics.checkNotNullParameter(componentAttribution, "componentAttribution");
        Intrinsics.checkNotNullParameter(shortcutAttribution, "shortcutAttribution");
        ControllerListener2.Extras extras = new ControllerListener2.Extras();
        if (rect != null) {
            extras.viewportWidth = rect.width();
            extras.viewportHeight = rect.height();
        }
        extras.scaleType = str;
        if (pointF != null) {
            extras.focusX = Float.valueOf(pointF.x);
            extras.focusY = Float.valueOf(pointF.y);
        }
        extras.callerContext = obj;
        extras.logWithHighSamplingRate = z;
        extras.mainUri = uri;
        extras.datasourceExtras = map;
        extras.imageExtras = map3;
        extras.shortcutExtras = shortcutAttribution;
        extras.componentExtras = componentAttribution;
        extras.imageSourceExtras = map2;
        return extras;
    }
}
