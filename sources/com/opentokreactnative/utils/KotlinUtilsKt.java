package com.opentokreactnative.utils;

import com.opentok.android.BaseVideoRenderer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class KotlinUtilsKt {
    public static final String toVideoScaleType(String str) {
        if (Intrinsics.areEqual(str, "fit")) {
            return BaseVideoRenderer.STYLE_VIDEO_FIT;
        }
        Intrinsics.areEqual(str, "fill");
        return BaseVideoRenderer.STYLE_VIDEO_FILL;
    }
}
