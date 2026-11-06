package com.facebook.react.modules.debug;

import com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener;
import com.facebook.react.uimanager.debug.NotThreadSafeViewHierarchyUpdateDebugListener;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class DidJSUpdateUiDuringFrameDetector implements NotThreadSafeBridgeIdleDebugListener, NotThreadSafeViewHierarchyUpdateDebugListener {
    private final ArrayList transitionToIdleEvents = new ArrayList(20);
    private final ArrayList transitionToBusyEvents = new ArrayList(20);
    private final ArrayList viewHierarchyUpdateEnqueuedEvents = new ArrayList(20);
    private final ArrayList viewHierarchyUpdateFinishedEvents = new ArrayList(20);
    private volatile boolean wasIdleAtEndOfLastFrame = true;

    @Override // com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener
    public synchronized void onTransitionToBridgeIdle() {
        this.transitionToIdleEvents.add(Long.valueOf(System.nanoTime()));
    }

    @Override // com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener
    public synchronized void onTransitionToBridgeBusy() {
        this.transitionToBusyEvents.add(Long.valueOf(System.nanoTime()));
    }

    @Override // com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener
    public synchronized void onBridgeDestroyed() {
    }

    @Override // com.facebook.react.uimanager.debug.NotThreadSafeViewHierarchyUpdateDebugListener
    public synchronized void onViewHierarchyUpdateEnqueued() {
        this.viewHierarchyUpdateEnqueuedEvents.add(Long.valueOf(System.nanoTime()));
    }

    @Override // com.facebook.react.uimanager.debug.NotThreadSafeViewHierarchyUpdateDebugListener
    public synchronized void onViewHierarchyUpdateFinished() {
        this.viewHierarchyUpdateFinishedEvents.add(Long.valueOf(System.nanoTime()));
    }

    public final synchronized boolean getDidJSHitFrameAndCleanup(long j, long j2) {
        boolean z;
        try {
            boolean zHasEventBetweenTimestamps = DidJSUpdateUiDuringFrameDetectorKt.hasEventBetweenTimestamps(this.viewHierarchyUpdateFinishedEvents, j, j2);
            boolean zDidEndFrameIdle = didEndFrameIdle(j, j2);
            z = true;
            if (!zHasEventBetweenTimestamps && (!zDidEndFrameIdle || DidJSUpdateUiDuringFrameDetectorKt.hasEventBetweenTimestamps(this.viewHierarchyUpdateEnqueuedEvents, j, j2))) {
                z = false;
            }
            DidJSUpdateUiDuringFrameDetectorKt.cleanUp(this.transitionToIdleEvents, j2);
            DidJSUpdateUiDuringFrameDetectorKt.cleanUp(this.transitionToBusyEvents, j2);
            DidJSUpdateUiDuringFrameDetectorKt.cleanUp(this.viewHierarchyUpdateEnqueuedEvents, j2);
            DidJSUpdateUiDuringFrameDetectorKt.cleanUp(this.viewHierarchyUpdateFinishedEvents, j2);
            this.wasIdleAtEndOfLastFrame = zDidEndFrameIdle;
        } catch (Throwable th) {
            throw th;
        }
        return z;
    }

    private final boolean didEndFrameIdle(long j, long j2) {
        long lastEventBetweenTimestamps = DidJSUpdateUiDuringFrameDetectorKt.getLastEventBetweenTimestamps(this.transitionToIdleEvents, j, j2);
        long lastEventBetweenTimestamps2 = DidJSUpdateUiDuringFrameDetectorKt.getLastEventBetweenTimestamps(this.transitionToBusyEvents, j, j2);
        if (lastEventBetweenTimestamps == -1 && lastEventBetweenTimestamps2 == -1) {
            return this.wasIdleAtEndOfLastFrame;
        }
        return lastEventBetweenTimestamps > lastEventBetweenTimestamps2;
    }
}
