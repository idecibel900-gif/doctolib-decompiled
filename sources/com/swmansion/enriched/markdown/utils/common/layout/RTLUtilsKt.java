package com.swmansion.enriched.markdown.utils.common.layout;

import android.content.res.Resources;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class RTLUtilsKt {
    public static final boolean isLayoutRTL(Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "<this>");
        return resources.getConfiguration().getLayoutDirection() == 1;
    }
}
