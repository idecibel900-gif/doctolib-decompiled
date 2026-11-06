package com.google.android.material.motion;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.view.View;
import android.view.animation.PathInterpolator;
import androidx.activity.BackEventCompat;
import com.google.android.material.R$attr;

/* JADX INFO: loaded from: classes3.dex */
public abstract class MaterialBackAnimationHelper {
    private BackEventCompat backEvent;
    protected final int cancelDuration;
    protected final int hideDurationMax;
    protected final int hideDurationMin;
    private final TimeInterpolator progressInterpolator = new PathInterpolator(0.1f, 0.1f, 0.0f, 1.0f);
    protected final View view;

    public MaterialBackAnimationHelper(View view) {
        this.view = view;
        Context context = view.getContext();
        this.hideDurationMax = MotionUtils.resolveThemeDuration(context, R$attr.motionDurationMedium2, 300);
        this.hideDurationMin = MotionUtils.resolveThemeDuration(context, R$attr.motionDurationShort3, 150);
        this.cancelDuration = MotionUtils.resolveThemeDuration(context, R$attr.motionDurationShort2, 100);
    }

    public float interpolateProgress(float f) {
        return this.progressInterpolator.getInterpolation(f);
    }

    protected void onStartBackProgress(BackEventCompat backEventCompat) {
        this.backEvent = backEventCompat;
    }

    protected BackEventCompat onUpdateBackProgress(BackEventCompat backEventCompat) {
        BackEventCompat backEventCompat2 = this.backEvent;
        this.backEvent = backEventCompat;
        return backEventCompat2;
    }

    public BackEventCompat onHandleBackInvoked() {
        BackEventCompat backEventCompat = this.backEvent;
        this.backEvent = null;
        return backEventCompat;
    }

    protected BackEventCompat onCancelBackProgress() {
        BackEventCompat backEventCompat = this.backEvent;
        this.backEvent = null;
        return backEventCompat;
    }
}
