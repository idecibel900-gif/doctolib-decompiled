package com.facebook.react.views.progressbar;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.facebook.react.R$id;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ProgressBarContainerView extends FrameLayout {
    private static final Companion Companion = new Companion(null);
    private boolean animating;
    private Integer color;
    private boolean indeterminate;
    private double progress;
    private ProgressBar progressBar;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProgressBarContainerView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.indeterminate = true;
        this.animating = true;
    }

    public final Integer getColor$ReactAndroid_release() {
        return this.color;
    }

    public final void setColor$ReactAndroid_release(Integer num) {
        this.color = num;
    }

    public final boolean getIndeterminate$ReactAndroid_release() {
        return this.indeterminate;
    }

    public final void setIndeterminate$ReactAndroid_release(boolean z) {
        this.indeterminate = z;
    }

    public final boolean getAnimating$ReactAndroid_release() {
        return this.animating;
    }

    public final void setAnimating$ReactAndroid_release(boolean z) {
        this.animating = z;
    }

    public final double getProgress$ReactAndroid_release() {
        return this.progress;
    }

    public final void setProgress$ReactAndroid_release(double d) {
        this.progress = d;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        super.onInitializeAccessibilityNodeInfo(info);
        String str = (String) getTag(R$id.react_test_id);
        if (str != null) {
            info.setViewIdResourceName(str);
        }
    }

    public final void apply$ReactAndroid_release() {
        ProgressBar progressBar = this.progressBar;
        if (progressBar != null) {
            progressBar.setIndeterminate(this.indeterminate);
            setColor(progressBar);
            progressBar.setProgress((int) (this.progress * ((double) 1000)));
            progressBar.setVisibility(this.animating ? 0 : 4);
            return;
        }
        throw new JSApplicationIllegalArgumentException("setStyle() not called");
    }

    public final void setStyle$ReactAndroid_release(String str) {
        ReactProgressBarViewManager.Companion companion = ReactProgressBarViewManager.INSTANCE;
        ProgressBar progressBarCreateProgressBar = companion.createProgressBar(getContext(), companion.getStyleFromString$ReactAndroid_release(str));
        progressBarCreateProgressBar.setMax(1000);
        this.progressBar = progressBarCreateProgressBar;
        removeAllViews();
        addView(this.progressBar, new ViewGroup.LayoutParams(-1, -1));
    }

    private final void setColor(ProgressBar progressBar) {
        Drawable progressDrawable;
        if (progressBar.isIndeterminate()) {
            progressDrawable = progressBar.getIndeterminateDrawable();
        } else {
            progressDrawable = progressBar.getProgressDrawable();
        }
        if (progressDrawable == null) {
            return;
        }
        Integer num = this.color;
        if (num != null) {
            progressDrawable.setColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN);
        } else {
            progressDrawable.clearColorFilter();
        }
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
