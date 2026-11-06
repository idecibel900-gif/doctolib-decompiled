package expo.modules.video.utils;

import android.app.Activity;
import android.app.PictureInPictureParams;
import android.graphics.Rect;
import android.os.Build;
import android.util.Rational;
import android.view.View;
import androidx.media3.common.VideoSize;
import androidx.media3.ui.PlayerView;
import expo.modules.video.PictureInPictureConfigurationException;
import expo.modules.video.VideoView;
import expo.modules.video.enums.ContentFit;
import expo.modules.video.managers.PictureInPictureManager$$ExternalSyntheticApiModelOutline0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public abstract class PictureInPictureUtilsKt {
    public static final Rect calculateRectHint(PlayerView playerView) {
        Intrinsics.checkNotNullParameter(playerView, "playerView");
        Rect rect = new Rect();
        View videoSurfaceView = playerView.getVideoSurfaceView();
        if (videoSurfaceView != null) {
            videoSurfaceView.getGlobalVisibleRect(rect);
        }
        int[] iArr = new int[2];
        View videoSurfaceView2 = playerView.getVideoSurfaceView();
        if (videoSurfaceView2 != null) {
            videoSurfaceView2.getLocationOnScreen(iArr);
        }
        int i = rect.bottom - rect.top;
        int i2 = iArr[1];
        rect.top = i2;
        rect.bottom = i2 + i;
        return rect;
    }

    public static final Rational calculatePiPAspectRatio(VideoSize videoSize, int i, int i2, ContentFit contentFit) {
        Rational rational;
        Intrinsics.checkNotNullParameter(videoSize, "videoSize");
        Intrinsics.checkNotNullParameter(contentFit, "contentFit");
        if (contentFit == ContentFit.CONTAIN) {
            rational = new Rational(videoSize.width, videoSize.height);
        } else {
            rational = new Rational(i, i2);
        }
        Rational rational2 = new Rational(239, 100);
        Rational rational3 = new Rational(100, 239);
        if (rational.floatValue() > rational2.floatValue()) {
            return rational2;
        }
        return rational.floatValue() < rational3.floatValue() ? rational3 : rational;
    }

    public static final void applyRectHint(final Activity activity, final Rect rectHint) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(rectHint, "rectHint");
        if (Build.VERSION.SDK_INT < 26 || !VideoView.INSTANCE.isPictureInPictureSupported(activity)) {
            return;
        }
        runWithPiPMisconfigurationSoftHandling$default(false, new Function0() { // from class: expo.modules.video.utils.PictureInPictureUtilsKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PictureInPictureUtilsKt.applyRectHint$lambda$0(activity, rectHint);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit applyRectHint$lambda$0(Activity activity, Rect rect) {
        activity.setPictureInPictureParams(PictureInPictureManager$$ExternalSyntheticApiModelOutline0.m().setSourceRectHint(rect).build());
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void runWithPiPMisconfigurationSoftHandling$default(boolean z, Function0 function0, int i, Object obj) throws PictureInPictureConfigurationException {
        if ((i & 1) != 0) {
            z = false;
        }
        runWithPiPMisconfigurationSoftHandling(z, function0);
    }

    public static final void runWithPiPMisconfigurationSoftHandling(boolean z, Function0 block) throws PictureInPictureConfigurationException {
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            block.invoke();
        } catch (IllegalStateException unused) {
            if (z) {
                throw new PictureInPictureConfigurationException();
            }
        }
    }

    public static /* synthetic */ void applyPiPParams$default(Activity activity, boolean z, Rational rational, int i, Object obj) {
        if ((i & 4) != 0) {
            rational = null;
        }
        applyPiPParams(activity, z, rational);
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0020  */
    public static final void applyPiPParams(final Activity activity, boolean z, Rational rational) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (rational != null) {
            double dFloatValue = rational.floatValue();
            if (0.41841d > dFloatValue || dFloatValue > 2.39d) {
                rational = null;
            }
        } else {
            rational = null;
        }
        int i = Build.VERSION.SDK_INT;
        if (i < 26 || !VideoView.INSTANCE.isPictureInPictureSupported(activity)) {
            return;
        }
        final PictureInPictureParams.Builder builderM = PictureInPictureManager$$ExternalSyntheticApiModelOutline0.m();
        if (rational != null) {
            builderM.setAspectRatio(rational);
        }
        if (i >= 31) {
            builderM.setAutoEnterEnabled(z);
        }
        runWithPiPMisconfigurationSoftHandling$default(false, new Function0() { // from class: expo.modules.video.utils.PictureInPictureUtilsKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PictureInPictureUtilsKt.applyPiPParams$lambda$3(activity, builderM);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit applyPiPParams$lambda$3(Activity activity, PictureInPictureParams.Builder builder) {
        activity.setPictureInPictureParams(builder.build());
        return Unit.INSTANCE;
    }
}
