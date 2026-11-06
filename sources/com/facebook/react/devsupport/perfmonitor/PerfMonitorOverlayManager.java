package com.facebook.react.devsupport.perfmonitor;

import android.app.Activity;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.devsupport.inspector.TracingState;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class PerfMonitorOverlayManager implements PerfMonitorUpdateListener {
    private final PerfMonitorDevHelper devHelper;
    private boolean enabled;
    private final Function0 onRequestOpenDevTools;
    private int perfIssueCount;
    private TracingState tracingState;
    private PerfMonitorOverlayView view;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TracingState.values().length];
            try {
                iArr[TracingState.ENABLED_IN_BACKGROUND_MODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TracingState.DISABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TracingState.ENABLED_IN_CDP_MODE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public PerfMonitorOverlayManager(PerfMonitorDevHelper devHelper, Function0 onRequestOpenDevTools) {
        Intrinsics.checkNotNullParameter(devHelper, "devHelper");
        Intrinsics.checkNotNullParameter(onRequestOpenDevTools, "onRequestOpenDevTools");
        this.devHelper = devHelper;
        this.onRequestOpenDevTools = onRequestOpenDevTools;
        this.tracingState = TracingState.ENABLED_IN_CDP_MODE;
    }

    public final boolean isEnabled() {
        return this.enabled;
    }

    public final void enable() {
        if (this.enabled) {
            return;
        }
        this.enabled = true;
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.devsupport.perfmonitor.PerfMonitorOverlayManager$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                PerfMonitorOverlayManager.enable$lambda$0(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enable$lambda$0(PerfMonitorOverlayManager perfMonitorOverlayManager) {
        Activity currentActivity = perfMonitorOverlayManager.devHelper.getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        if (perfMonitorOverlayManager.view == null) {
            perfMonitorOverlayManager.view = new PerfMonitorOverlayView(currentActivity, new PerfMonitorOverlayManager$enable$1$1(perfMonitorOverlayManager));
        }
        PerfMonitorOverlayView perfMonitorOverlayView = perfMonitorOverlayManager.view;
        if (perfMonitorOverlayView != null) {
            perfMonitorOverlayView.show();
        }
    }

    public final void disable() {
        this.enabled = false;
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.devsupport.perfmonitor.PerfMonitorOverlayManager$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                PerfMonitorOverlayManager.disable$lambda$1(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void disable$lambda$1(PerfMonitorOverlayManager perfMonitorOverlayManager) {
        PerfMonitorOverlayView perfMonitorOverlayView = perfMonitorOverlayManager.view;
        if (perfMonitorOverlayView != null) {
            perfMonitorOverlayView.hide();
        }
    }

    public final void startBackgroundTrace() {
        PerfMonitorInspectorTarget inspectorTarget;
        if (this.enabled && (inspectorTarget = this.devHelper.getInspectorTarget()) != null) {
            inspectorTarget.resumeBackgroundTrace();
            onRecordingStateChanged(inspectorTarget.getTracingState());
        }
    }

    public final void stopBackgroundTrace() {
        PerfMonitorInspectorTarget inspectorTarget;
        if (this.enabled && (inspectorTarget = this.devHelper.getInspectorTarget()) != null) {
            inspectorTarget.stopBackgroundTrace();
            onRecordingStateChanged(inspectorTarget.getTracingState());
        }
    }

    @Override // com.facebook.react.devsupport.perfmonitor.PerfMonitorUpdateListener
    public void onRecordingStateChanged(final TracingState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.tracingState = state;
        if (state != TracingState.DISABLED) {
            this.perfIssueCount = 0;
        }
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.devsupport.perfmonitor.PerfMonitorOverlayManager$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                PerfMonitorOverlayManager.onRecordingStateChanged$lambda$4(this.f$0, state);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onRecordingStateChanged$lambda$4(PerfMonitorOverlayManager perfMonitorOverlayManager, TracingState tracingState) {
        PerfMonitorOverlayView perfMonitorOverlayView = perfMonitorOverlayManager.view;
        if (perfMonitorOverlayView != null) {
            perfMonitorOverlayView.updateRecordingState(tracingState);
        }
        PerfMonitorOverlayView perfMonitorOverlayView2 = perfMonitorOverlayManager.view;
        if (perfMonitorOverlayView2 != null) {
            perfMonitorOverlayView2.updatePerfIssueCount(perfMonitorOverlayManager.perfIssueCount);
        }
        PerfMonitorOverlayView perfMonitorOverlayView3 = perfMonitorOverlayManager.view;
        if (perfMonitorOverlayView3 != null) {
            perfMonitorOverlayView3.show();
        }
    }

    @Override // com.facebook.react.devsupport.perfmonitor.PerfMonitorUpdateListener
    public void onPerfIssueAdded(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.devsupport.perfmonitor.PerfMonitorOverlayManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                PerfMonitorOverlayManager.onPerfIssueAdded$lambda$5(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPerfIssueAdded$lambda$5(PerfMonitorOverlayManager perfMonitorOverlayManager) {
        PerfMonitorOverlayView perfMonitorOverlayView = perfMonitorOverlayManager.view;
        if (perfMonitorOverlayView != null) {
            int i = perfMonitorOverlayManager.perfIssueCount + 1;
            perfMonitorOverlayManager.perfIssueCount = i;
            perfMonitorOverlayView.updatePerfIssueCount(i);
        }
        PerfMonitorOverlayView perfMonitorOverlayView2 = perfMonitorOverlayManager.view;
        if (perfMonitorOverlayView2 != null) {
            perfMonitorOverlayView2.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleRecordingButtonPress() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.tracingState.ordinal()];
        if (i == 1) {
            PerfMonitorInspectorTarget inspectorTarget = this.devHelper.getInspectorTarget();
            if (inspectorTarget == null || inspectorTarget.pauseAndAnalyzeBackgroundTrace()) {
                return;
            }
            this.onRequestOpenDevTools.invoke();
            return;
        }
        if (i != 2) {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            PerfMonitorInspectorTarget inspectorTarget2 = this.devHelper.getInspectorTarget();
            if (inspectorTarget2 != null) {
                inspectorTarget2.resumeBackgroundTrace();
            }
        }
    }
}
