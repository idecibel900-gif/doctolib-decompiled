package com.facebook.react.modules.debug;

import android.view.Choreographer;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.build.ReactBuildConfig;
import com.facebook.react.uimanager.UIManagerModule;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class FpsDebugFrameCallback implements Choreographer.FrameCallback {
    private static final Companion Companion = new Companion(null);
    private Choreographer choreographer;
    private final DidJSUpdateUiDuringFrameDetector didJSUpdateUiDuringFrameDetector;
    private int expectedNumFramesPrev;
    private long firstFrameTime;
    private int fourPlusFrameStutters;
    private boolean isRunningOnFabric;
    private long lastFrameTime;
    private int numFrameCallbacks;
    private int numFrameCallbacksWithBatchDispatches;
    private final ReactContext reactContext;
    private double targetFps;

    public FpsDebugFrameCallback(ReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        this.didJSUpdateUiDuringFrameDetector = new DidJSUpdateUiDuringFrameDetector();
        this.firstFrameTime = -1L;
        this.lastFrameTime = -1L;
        this.targetFps = 60.0d;
        this.isRunningOnFabric = true;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        if (this.firstFrameTime == -1) {
            this.firstFrameTime = j;
        }
        long j2 = this.lastFrameTime;
        this.lastFrameTime = j;
        if (this.didJSUpdateUiDuringFrameDetector.getDidJSHitFrameAndCleanup(j2, j)) {
            this.numFrameCallbacksWithBatchDispatches++;
        }
        this.numFrameCallbacks++;
        int expectedNumFrames = getExpectedNumFrames();
        if ((expectedNumFrames - this.expectedNumFramesPrev) - 1 >= 4) {
            this.fourPlusFrameStutters++;
        }
        this.expectedNumFramesPrev = expectedNumFrames;
        Choreographer choreographer = this.choreographer;
        if (choreographer != null) {
            choreographer.postFrameCallback(this);
        }
    }

    public static /* synthetic */ void start$default(FpsDebugFrameCallback fpsDebugFrameCallback, double d, int i, Object obj) {
        if ((i & 1) != 0) {
            d = fpsDebugFrameCallback.targetFps;
        }
        fpsDebugFrameCallback.start(d);
    }

    public final void start(double d) {
        if (!ReactBuildConfig.UNSTABLE_ENABLE_MINIFY_LEGACY_ARCHITECTURE) {
            UIManagerModule uIManagerModule = (UIManagerModule) this.reactContext.getNativeModule(UIManagerModule.class);
            if (!this.reactContext.isBridgeless()) {
                this.reactContext.getCatalystInstance().addBridgeIdleDebugListener(this.didJSUpdateUiDuringFrameDetector);
                this.isRunningOnFabric = false;
            } else {
                this.isRunningOnFabric = true;
            }
            if (uIManagerModule != null) {
                uIManagerModule.setViewHierarchyUpdateDebugListener(this.didJSUpdateUiDuringFrameDetector);
            }
        }
        this.targetFps = d;
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.modules.debug.FpsDebugFrameCallback$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                FpsDebugFrameCallback.start$lambda$0(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void start$lambda$0(FpsDebugFrameCallback fpsDebugFrameCallback) {
        Choreographer choreographer = Choreographer.getInstance();
        fpsDebugFrameCallback.choreographer = choreographer;
        if (choreographer != null) {
            choreographer.postFrameCallback(fpsDebugFrameCallback);
        }
    }

    public final void stop() {
        if (!ReactBuildConfig.UNSTABLE_ENABLE_MINIFY_LEGACY_ARCHITECTURE) {
            UIManagerModule uIManagerModule = (UIManagerModule) this.reactContext.getNativeModule(UIManagerModule.class);
            if (!this.reactContext.isBridgeless()) {
                this.reactContext.getCatalystInstance().removeBridgeIdleDebugListener(this.didJSUpdateUiDuringFrameDetector);
            }
            if (uIManagerModule != null) {
                uIManagerModule.setViewHierarchyUpdateDebugListener(null);
            }
        }
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.modules.debug.FpsDebugFrameCallback$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                FpsDebugFrameCallback.stop$lambda$1(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void stop$lambda$1(FpsDebugFrameCallback fpsDebugFrameCallback) {
        Choreographer choreographer = Choreographer.getInstance();
        fpsDebugFrameCallback.choreographer = choreographer;
        if (choreographer != null) {
            choreographer.removeFrameCallback(fpsDebugFrameCallback);
        }
    }

    public final double getFps() {
        if (this.lastFrameTime == this.firstFrameTime) {
            return 0.0d;
        }
        return (((double) getNumFrames()) * 1.0E9d) / (this.lastFrameTime - this.firstFrameTime);
    }

    public final double getJsFPS() {
        if (this.lastFrameTime == this.firstFrameTime) {
            return 0.0d;
        }
        return (((double) getNumJSFrames()) * 1.0E9d) / (this.lastFrameTime - this.firstFrameTime);
    }

    public final int getNumFrames() {
        return this.numFrameCallbacks - 1;
    }

    private final int getNumJSFrames() {
        return this.numFrameCallbacksWithBatchDispatches - 1;
    }

    public final int getExpectedNumFrames() {
        return (int) (((this.targetFps * ((double) getTotalTimeMS())) / ((double) 1000)) + ((double) 1));
    }

    public final boolean isRunningOnFabric() {
        return this.isRunningOnFabric;
    }

    public final int get4PlusFrameStutters() {
        return this.fourPlusFrameStutters;
    }

    private final int getTotalTimeMS() {
        return (int) ((this.lastFrameTime - this.firstFrameTime) / 1000000.0d);
    }

    public final void reset() {
        this.firstFrameTime = -1L;
        this.lastFrameTime = -1L;
        this.numFrameCallbacks = 0;
        this.fourPlusFrameStutters = 0;
        this.numFrameCallbacksWithBatchDispatches = 0;
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
