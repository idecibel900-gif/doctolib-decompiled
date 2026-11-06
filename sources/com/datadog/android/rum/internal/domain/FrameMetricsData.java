package com.datadog.android.rum.internal.domain;

import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.internal.http2.Http2;

/* JADX INFO: loaded from: classes3.dex */
public final class FrameMetricsData {
    public static final Companion Companion = new Companion(null);
    private long animationDuration;
    private long commandIssueDuration;
    private long deadline;
    private double displayRefreshRate;
    private long drawDuration;
    private int droppedFrames;
    private boolean firstDrawFrame;
    private long gpuDuration;
    private long inputHandlingDuration;
    private long intendedVsyncTimestamp;
    private long layoutMeasureDuration;
    private long swapBuffersDuration;
    private long syncDuration;
    private long totalDuration;
    private long unknownDelayDuration;
    private long vsyncTimestamp;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FrameMetricsData)) {
            return false;
        }
        FrameMetricsData frameMetricsData = (FrameMetricsData) obj;
        return this.droppedFrames == frameMetricsData.droppedFrames && this.unknownDelayDuration == frameMetricsData.unknownDelayDuration && this.inputHandlingDuration == frameMetricsData.inputHandlingDuration && this.animationDuration == frameMetricsData.animationDuration && this.layoutMeasureDuration == frameMetricsData.layoutMeasureDuration && this.drawDuration == frameMetricsData.drawDuration && this.syncDuration == frameMetricsData.syncDuration && this.commandIssueDuration == frameMetricsData.commandIssueDuration && this.swapBuffersDuration == frameMetricsData.swapBuffersDuration && this.totalDuration == frameMetricsData.totalDuration && this.firstDrawFrame == frameMetricsData.firstDrawFrame && this.intendedVsyncTimestamp == frameMetricsData.intendedVsyncTimestamp && this.vsyncTimestamp == frameMetricsData.vsyncTimestamp && this.gpuDuration == frameMetricsData.gpuDuration && this.deadline == frameMetricsData.deadline && Double.compare(this.displayRefreshRate, frameMetricsData.displayRefreshRate) == 0;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((Integer.hashCode(this.droppedFrames) * 31) + Long.hashCode(this.unknownDelayDuration)) * 31) + Long.hashCode(this.inputHandlingDuration)) * 31) + Long.hashCode(this.animationDuration)) * 31) + Long.hashCode(this.layoutMeasureDuration)) * 31) + Long.hashCode(this.drawDuration)) * 31) + Long.hashCode(this.syncDuration)) * 31) + Long.hashCode(this.commandIssueDuration)) * 31) + Long.hashCode(this.swapBuffersDuration)) * 31) + Long.hashCode(this.totalDuration)) * 31) + Boolean.hashCode(this.firstDrawFrame)) * 31) + Long.hashCode(this.intendedVsyncTimestamp)) * 31) + Long.hashCode(this.vsyncTimestamp)) * 31) + Long.hashCode(this.gpuDuration)) * 31) + Long.hashCode(this.deadline)) * 31) + Double.hashCode(this.displayRefreshRate);
    }

    public String toString() {
        return "FrameMetricsData(droppedFrames=" + this.droppedFrames + ", unknownDelayDuration=" + this.unknownDelayDuration + ", inputHandlingDuration=" + this.inputHandlingDuration + ", animationDuration=" + this.animationDuration + ", layoutMeasureDuration=" + this.layoutMeasureDuration + ", drawDuration=" + this.drawDuration + ", syncDuration=" + this.syncDuration + ", commandIssueDuration=" + this.commandIssueDuration + ", swapBuffersDuration=" + this.swapBuffersDuration + ", totalDuration=" + this.totalDuration + ", firstDrawFrame=" + this.firstDrawFrame + ", intendedVsyncTimestamp=" + this.intendedVsyncTimestamp + ", vsyncTimestamp=" + this.vsyncTimestamp + ", gpuDuration=" + this.gpuDuration + ", deadline=" + this.deadline + ", displayRefreshRate=" + this.displayRefreshRate + ")";
    }

    public FrameMetricsData(int i, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, boolean z, long j10, long j11, long j12, long j13, double d) {
        this.droppedFrames = i;
        this.unknownDelayDuration = j;
        this.inputHandlingDuration = j2;
        this.animationDuration = j3;
        this.layoutMeasureDuration = j4;
        this.drawDuration = j5;
        this.syncDuration = j6;
        this.commandIssueDuration = j7;
        this.swapBuffersDuration = j8;
        this.totalDuration = j9;
        this.firstDrawFrame = z;
        this.intendedVsyncTimestamp = j10;
        this.vsyncTimestamp = j11;
        this.gpuDuration = j12;
        this.deadline = j13;
        this.displayRefreshRate = d;
    }

    public /* synthetic */ FrameMetricsData(int i, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, boolean z, long j10, long j11, long j12, long j13, double d, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? 0L : j, (i2 & 4) != 0 ? 0L : j2, (i2 & 8) != 0 ? 0L : j3, (i2 & 16) != 0 ? 0L : j4, (i2 & 32) != 0 ? 0L : j5, (i2 & 64) != 0 ? 0L : j6, (i2 & 128) != 0 ? 0L : j7, (i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? 0L : j8, (i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? 0L : j9, (i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) == 0 ? z : false, (i2 & 2048) != 0 ? 0L : j10, (i2 & 4096) != 0 ? 0L : j11, (i2 & 8192) != 0 ? 0L : j12, (i2 & Http2.INITIAL_MAX_FRAME_SIZE) == 0 ? j13 : 0L, (i2 & 32768) != 0 ? 60.0d : d);
    }

    public final void setDroppedFrames(int i) {
        this.droppedFrames = i;
    }

    public final void setUnknownDelayDuration(long j) {
        this.unknownDelayDuration = j;
    }

    public final void setInputHandlingDuration(long j) {
        this.inputHandlingDuration = j;
    }

    public final void setAnimationDuration(long j) {
        this.animationDuration = j;
    }

    public final void setLayoutMeasureDuration(long j) {
        this.layoutMeasureDuration = j;
    }

    public final void setDrawDuration(long j) {
        this.drawDuration = j;
    }

    public final void setSyncDuration(long j) {
        this.syncDuration = j;
    }

    public final void setCommandIssueDuration(long j) {
        this.commandIssueDuration = j;
    }

    public final void setSwapBuffersDuration(long j) {
        this.swapBuffersDuration = j;
    }

    public final void setTotalDuration(long j) {
        this.totalDuration = j;
    }

    public final void setFirstDrawFrame(boolean z) {
        this.firstDrawFrame = z;
    }

    public final void setIntendedVsyncTimestamp(long j) {
        this.intendedVsyncTimestamp = j;
    }

    public final void setVsyncTimestamp(long j) {
        this.vsyncTimestamp = j;
    }

    public final void setGpuDuration(long j) {
        this.gpuDuration = j;
    }

    public final long getDeadline() {
        return this.deadline;
    }

    public final void setDeadline(long j) {
        this.deadline = j;
    }

    public final double getDisplayRefreshRate() {
        return this.displayRefreshRate;
    }

    public final void setDisplayRefreshRate(double d) {
        this.displayRefreshRate = d;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
