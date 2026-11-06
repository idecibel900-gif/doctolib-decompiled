package expo.modules.splashscreen;

import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class SplashScreenManager {
    private static boolean preventAutoHideCalled;
    public static final SplashScreenManager INSTANCE = new SplashScreenManager();
    private static boolean keepSplashScreenOnScreen = true;
    private static final ReactMarker.MarkerListener contentAppearedListener = new ReactMarker.MarkerListener() { // from class: expo.modules.splashscreen.SplashScreenManager$$ExternalSyntheticLambda0
        @Override // com.facebook.react.bridge.ReactMarker.MarkerListener
        public final void logMarker(ReactMarkerConstants reactMarkerConstants, String str, int i) {
            SplashScreenManager.contentAppearedListener$lambda$0(reactMarkerConstants, str, i);
        }
    };

    private final void configureSplashScreen(SplashScreenOptions splashScreenOptions) {
    }

    private SplashScreenManager() {
    }

    public final void setPreventAutoHideCalled(boolean z) {
        preventAutoHideCalled = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void contentAppearedListener$lambda$0(ReactMarkerConstants name, String str, int i) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (name != ReactMarkerConstants.CONTENT_APPEARED || preventAutoHideCalled) {
            return;
        }
        INSTANCE.hide();
    }

    public final void hide() {
        keepSplashScreenOnScreen = false;
    }

    public final void setSplashScreenOptions(SplashScreenOptions options) {
        Intrinsics.checkNotNullParameter(options, "options");
        configureSplashScreen(options);
    }

    public final void unregisterContentAppearedListener() {
        ReactMarker.removeListener(contentAppearedListener);
    }
}
