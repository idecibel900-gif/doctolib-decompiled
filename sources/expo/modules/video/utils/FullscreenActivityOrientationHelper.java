package expo.modules.video.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.provider.Settings;
import android.view.OrientationEventListener;
import expo.modules.video.enums.FullscreenOrientation;
import expo.modules.video.records.FullscreenOptions;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class FullscreenActivityOrientationHelper {
    private final Context context;
    private final boolean isLockedToLandscape;
    private final boolean isLockedToPortrait;
    private final Function0 onShouldAutoExit;
    private final Function0 onShouldReleaseOrientation;
    private final FullscreenOptions options;
    private final Lazy orientationEventListener$delegate;
    private boolean userHasRotatedToVideoOrientation;

    public FullscreenActivityOrientationHelper(Context context, FullscreenOptions options, Function0 onShouldAutoExit, Function0 onShouldReleaseOrientation) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(onShouldAutoExit, "onShouldAutoExit");
        Intrinsics.checkNotNullParameter(onShouldReleaseOrientation, "onShouldReleaseOrientation");
        this.context = context;
        this.options = options;
        this.onShouldAutoExit = onShouldAutoExit;
        this.onShouldReleaseOrientation = onShouldReleaseOrientation;
        boolean z = true;
        this.isLockedToLandscape = options.getOrientation() == FullscreenOrientation.LANDSCAPE || options.getOrientation() == FullscreenOrientation.LANDSCAPE_LEFT || options.getOrientation() == FullscreenOrientation.LANDSCAPE_RIGHT;
        if (options.getOrientation() != FullscreenOrientation.PORTRAIT && options.getOrientation() != FullscreenOrientation.PORTRAIT_UP && options.getOrientation() != FullscreenOrientation.PORTRAIT_DOWN) {
            z = false;
        }
        this.isLockedToPortrait = z;
        this.orientationEventListener$delegate = LazyKt.lazy(new Function0() { // from class: expo.modules.video.utils.FullscreenActivityOrientationHelper$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FullscreenActivityOrientationHelper.orientationEventListener_delegate$lambda$0(this.f$0);
            }
        });
    }

    public final Function0 getOnShouldReleaseOrientation() {
        return this.onShouldReleaseOrientation;
    }

    public final FullscreenOptions getOptions() {
        return this.options;
    }

    public final boolean isAutoRotationEnabled() {
        try {
            return Settings.System.getInt(this.context.getContentResolver(), "accelerometer_rotation", 0) == 1;
        } catch (Exception unused) {
        }
    }

    private final FullscreenActivityOrientationHelper$orientationEventListener$2$1 getOrientationEventListener() {
        return (FullscreenActivityOrientationHelper$orientationEventListener$2$1) this.orientationEventListener$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v0, types: [expo.modules.video.utils.FullscreenActivityOrientationHelper$orientationEventListener$2$1] */
    public static final FullscreenActivityOrientationHelper$orientationEventListener$2$1 orientationEventListener_delegate$lambda$0(final FullscreenActivityOrientationHelper fullscreenActivityOrientationHelper) {
        final Context context = fullscreenActivityOrientationHelper.context;
        return new OrientationEventListener(context) { // from class: expo.modules.video.utils.FullscreenActivityOrientationHelper$orientationEventListener$2$1
            /* JADX WARN: Code duplicated, block: B:10:0x0011  */
            /* JADX WARN: Code duplicated, block: B:15:0x001b  */
            @Override // android.view.OrientationEventListener
            public void onOrientationChanged(int i) {
                char c;
                boolean z = false;
                if ((i >= 0 && i <= 10) || (i >= 350 && i < 360)) {
                    c = 1;
                } else if (i >= 80 && i <= 100) {
                    c = 2;
                } else if (i >= 170 && i <= 190) {
                    c = 1;
                } else if (i < 260 || i > 280) {
                    c = 0;
                } else {
                    c = 2;
                }
                if (this.this$0.getOptions().getAutoExitOnRotate()) {
                    boolean z2 = c == 1 && this.this$0.isLockedToLandscape && this.this$0.userHasRotatedToVideoOrientation;
                    if ((c == 2 && this.this$0.isLockedToPortrait && this.this$0.userHasRotatedToVideoOrientation) || z2) {
                        if (!this.this$0.isAutoRotationEnabled()) {
                            return;
                        }
                        this.this$0.getOnShouldReleaseOrientation().invoke();
                        this.this$0.stopOrientationEventListener();
                    }
                    boolean z3 = c == 1 && this.this$0.isLockedToPortrait && !this.this$0.userHasRotatedToVideoOrientation;
                    if (c == 2 && this.this$0.isLockedToLandscape && !this.this$0.userHasRotatedToVideoOrientation) {
                        z = true;
                    }
                    if (z3 || z) {
                        this.this$0.userHasRotatedToVideoOrientation = true;
                    }
                }
            }
        };
    }

    public final void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        int i = newConfig.orientation;
        if (this.options.getAutoExitOnRotate()) {
            if (this.isLockedToPortrait && i == 2) {
                this.onShouldAutoExit.invoke();
            } else if (this.isLockedToLandscape && i == 1) {
                this.onShouldAutoExit.invoke();
            }
        }
    }

    public final void startOrientationEventListener() {
        if (getOrientationEventListener().canDetectOrientation()) {
            getOrientationEventListener().enable();
        }
    }

    public final void stopOrientationEventListener() {
        getOrientationEventListener().disable();
    }
}
