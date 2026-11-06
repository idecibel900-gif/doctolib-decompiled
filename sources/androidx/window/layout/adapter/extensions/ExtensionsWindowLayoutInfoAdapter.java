package androidx.window.layout.adapter.extensions;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import androidx.window.core.Bounds;
import androidx.window.layout.FoldingFeature;
import androidx.window.layout.HardwareFoldingFeature;
import androidx.window.layout.WindowLayoutInfo;
import androidx.window.layout.WindowMetrics;
import androidx.window.layout.WindowMetricsCalculatorCompat;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ExtensionsWindowLayoutInfoAdapter {
    public static final ExtensionsWindowLayoutInfoAdapter INSTANCE = new ExtensionsWindowLayoutInfoAdapter();

    private ExtensionsWindowLayoutInfoAdapter() {
    }

    public final FoldingFeature translate$window_release(WindowMetrics windowMetrics, androidx.window.extensions.layout.FoldingFeature oemFeature) {
        HardwareFoldingFeature.Type fold;
        FoldingFeature.State state;
        Intrinsics.checkNotNullParameter(windowMetrics, "windowMetrics");
        Intrinsics.checkNotNullParameter(oemFeature, "oemFeature");
        int type = oemFeature.getType();
        if (type == 1) {
            fold = HardwareFoldingFeature.Type.Companion.getFOLD();
        } else {
            if (type != 2) {
                return null;
            }
            fold = HardwareFoldingFeature.Type.Companion.getHINGE();
        }
        int state2 = oemFeature.getState();
        if (state2 == 1) {
            state = FoldingFeature.State.FLAT;
        } else {
            if (state2 != 2) {
                return null;
            }
            state = FoldingFeature.State.HALF_OPENED;
        }
        Rect bounds = oemFeature.getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "oemFeature.bounds");
        if (!validBounds(windowMetrics, new Bounds(bounds))) {
            return null;
        }
        Rect bounds2 = oemFeature.getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds2, "oemFeature.bounds");
        return new HardwareFoldingFeature(new Bounds(bounds2), fold, state);
    }

    public final WindowLayoutInfo translate$window_release(Context context, androidx.window.extensions.layout.WindowLayoutInfo info) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(info, "info");
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            return translate$window_release(WindowMetricsCalculatorCompat.INSTANCE.computeCurrentWindowMetrics(context), info);
        }
        if (i >= 29 && (context instanceof Activity)) {
            return translate$window_release(WindowMetricsCalculatorCompat.INSTANCE.computeCurrentWindowMetrics((Activity) context), info);
        }
        throw new UnsupportedOperationException("Display Features are only supported after Q. Display features for non-Activity contexts are not expected to be reported on devices running Q.");
    }

    public final WindowLayoutInfo translate$window_release(WindowMetrics windowMetrics, androidx.window.extensions.layout.WindowLayoutInfo info) {
        FoldingFeature foldingFeatureTranslate$window_release;
        Intrinsics.checkNotNullParameter(windowMetrics, "windowMetrics");
        Intrinsics.checkNotNullParameter(info, "info");
        List<androidx.window.extensions.layout.FoldingFeature> displayFeatures = info.getDisplayFeatures();
        Intrinsics.checkNotNullExpressionValue(displayFeatures, "info.displayFeatures");
        ArrayList arrayList = new ArrayList();
        for (androidx.window.extensions.layout.FoldingFeature feature : displayFeatures) {
            if (feature instanceof androidx.window.extensions.layout.FoldingFeature) {
                ExtensionsWindowLayoutInfoAdapter extensionsWindowLayoutInfoAdapter = INSTANCE;
                Intrinsics.checkNotNullExpressionValue(feature, "feature");
                foldingFeatureTranslate$window_release = extensionsWindowLayoutInfoAdapter.translate$window_release(windowMetrics, feature);
            } else {
                foldingFeatureTranslate$window_release = null;
            }
            if (foldingFeatureTranslate$window_release != null) {
                arrayList.add(foldingFeatureTranslate$window_release);
            }
        }
        return new WindowLayoutInfo(arrayList);
    }

    private final boolean validBounds(WindowMetrics windowMetrics, Bounds bounds) {
        Rect bounds2 = windowMetrics.getBounds();
        if (bounds.isZero()) {
            return false;
        }
        if (bounds.getWidth() != bounds2.width() && bounds.getHeight() != bounds2.height()) {
            return false;
        }
        if (bounds.getWidth() >= bounds2.width() || bounds.getHeight() >= bounds2.height()) {
            return (bounds.getWidth() == bounds2.width() && bounds.getHeight() == bounds2.height()) ? false : true;
        }
        return false;
    }
}
