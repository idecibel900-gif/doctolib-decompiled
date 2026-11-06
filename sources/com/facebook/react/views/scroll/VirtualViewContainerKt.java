package com.facebook.react.views.scroll;

import android.graphics.Rect;
import com.facebook.react.common.build.ReactBuildConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class VirtualViewContainerKt {
    private static final boolean IS_DEBUG_BUILD;

    public static final boolean rectsOverlap(Rect rect1, Rect rect2) {
        Intrinsics.checkNotNullParameter(rect1, "rect1");
        Intrinsics.checkNotNullParameter(rect2, "rect2");
        return rect1.top < rect2.bottom && rect2.top < rect1.bottom && rect1.left < rect2.right && rect2.left < rect1.right;
    }

    public static final boolean getIS_DEBUG_BUILD() {
        return IS_DEBUG_BUILD;
    }

    static {
        IS_DEBUG_BUILD = ReactBuildConfig.DEBUG || ReactBuildConfig.IS_INTERNAL_BUILD || ReactBuildConfig.ENABLE_PERFETTO;
    }
}
