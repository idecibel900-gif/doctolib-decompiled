package com.datadog.android.rum.internal.instrumentation.gestures;

import android.content.Context;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ScrollView;
import androidx.core.view.ScrollingView;
import com.datadog.android.api.SdkCore;
import com.datadog.android.rum.tracking.ActionTrackingStrategy;
import com.datadog.android.rum.tracking.ViewTarget;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class AndroidActionTrackingStrategy implements ActionTrackingStrategy {
    private final int[] coordinatesContainer = new int[2];

    @Override // com.datadog.android.rum.tracking.TrackingStrategy
    public void register(SdkCore sdkCore, Context context) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.datadog.android.rum.tracking.TrackingStrategy
    public void unregister(Context context) {
    }

    @Override // com.datadog.android.rum.tracking.ActionTrackingStrategy
    public ViewTarget findTargetForTap(View view, float f, float f2) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (hitTest(view, f, f2, this.coordinatesContainer) && isValidTapTarget(view)) {
            return new ViewTarget(new WeakReference(view), null, 2, null);
        }
        return null;
    }

    @Override // com.datadog.android.rum.tracking.ActionTrackingStrategy
    public ViewTarget findTargetForScroll(View view, float f, float f2) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (hitTest(view, f, f2, this.coordinatesContainer) && isValidScrollableTarget(view)) {
            return new ViewTarget(new WeakReference(view), null, 2, null);
        }
        return null;
    }

    private final boolean isValidTapTarget(View view) {
        return view.isClickable() && isVisible(view);
    }

    private final boolean isVisible(View view) {
        return view.getVisibility() == 0;
    }

    private final boolean hitTest(View view, float f, float f2, int[] iArr) {
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        return f >= ((float) i) && f <= ((float) (i + view.getWidth())) && f2 >= ((float) i2) && f2 <= ((float) (i2 + view.getHeight()));
    }

    private final boolean isValidScrollableTarget(View view) {
        return isVisible(view) && isScrollableView(view);
    }

    private final boolean isScrollableView(View view) {
        return ScrollingView.class.isAssignableFrom(view.getClass()) || AbsListView.class.isAssignableFrom(view.getClass()) || ScrollView.class.isAssignableFrom(view.getClass());
    }
}
