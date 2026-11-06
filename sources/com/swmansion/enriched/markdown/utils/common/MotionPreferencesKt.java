package com.swmansion.enriched.markdown.utils.common;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MotionPreferencesKt {
    public static final boolean isReducedMotionEnabled(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        return !ValueAnimator.areAnimatorsEnabled();
    }
}
