package com.swmansion.rnscreens.stack.anim;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.swmansion.rnscreens.ScreenFragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ScreensAnimation extends Animation {
    private final ScreenFragment mFragment;

    public ScreensAnimation(ScreenFragment mFragment) {
        Intrinsics.checkNotNullParameter(mFragment, "mFragment");
        this.mFragment = mFragment;
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation t) {
        Intrinsics.checkNotNullParameter(t, "t");
        super.applyTransformation(f, t);
        ScreenFragment screenFragment = this.mFragment;
        screenFragment.dispatchTransitionProgressEvent(f, !screenFragment.isResumed());
    }
}
