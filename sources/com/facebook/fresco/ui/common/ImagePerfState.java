package com.facebook.fresco.ui.common;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ImagePerfState extends ImagePerfLoggingState {
    private ControllerListener2.Extras _extraData;
    private Object callerContext;
    private long controllerFailureTimeMs;
    private long controllerFinalImageSetTimeMs;
    private String controllerId;
    private long controllerIntermediateImageSetTimeMs;
    private long controllerSubmitTimeMs;
    private Throwable errorThrowable;
    private Object imageInfo;
    private ImageLoadStatus imageLoadStatus;
    private Object imageRequest;
    private long imageRequestEndTimeMs;
    private long imageRequestStartTimeMs;
    private long invisibilityEventTimeMs;
    private boolean isPrefetch;
    private int onScreenHeightPx;
    private int onScreenWidthPx;
    private String requestId;
    private long visibilityEventTimeMs;
    private VisibilityState visibilityState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImagePerfState(ImageRenderingInfra infra) {
        super(infra);
        Intrinsics.checkNotNullParameter(infra, "infra");
        this.controllerSubmitTimeMs = -1L;
        this.controllerIntermediateImageSetTimeMs = -1L;
        this.controllerFinalImageSetTimeMs = -1L;
        this.controllerFailureTimeMs = -1L;
        this.imageRequestStartTimeMs = -1L;
        this.imageRequestEndTimeMs = -1L;
        this.onScreenWidthPx = -1;
        this.onScreenHeightPx = -1;
        this.imageLoadStatus = ImageLoadStatus.UNKNOWN;
        this.visibilityState = VisibilityState.UNKNOWN;
        this.visibilityEventTimeMs = -1L;
        this.invisibilityEventTimeMs = -1L;
    }

    public final void setCallerContext(Object obj) {
        this.callerContext = obj;
    }

    public final void setImageLoadStatus(ImageLoadStatus imageLoadStatus) {
        Intrinsics.checkNotNullParameter(imageLoadStatus, "<set-?>");
        this.imageLoadStatus = imageLoadStatus;
    }

    public final void setVisibilityEventTimeMs(long j) {
        this.visibilityEventTimeMs = j;
    }

    public final void reset() {
        this.requestId = null;
        this.imageRequest = null;
        this.callerContext = null;
        this.imageInfo = null;
        this.isPrefetch = false;
        this.onScreenWidthPx = -1;
        this.onScreenHeightPx = -1;
        this.errorThrowable = null;
        this.imageLoadStatus = ImageLoadStatus.UNKNOWN;
        this.visibilityState = VisibilityState.UNKNOWN;
        this._extraData = null;
        resetPointsTimestamps();
        resetLoggingState$ui_common_release();
    }

    public final void resetPointsTimestamps() {
        this.imageRequestStartTimeMs = -1L;
        this.imageRequestEndTimeMs = -1L;
        this.controllerSubmitTimeMs = -1L;
        this.controllerFinalImageSetTimeMs = -1L;
        this.controllerFailureTimeMs = -1L;
        this.visibilityEventTimeMs = -1L;
        this.invisibilityEventTimeMs = -1L;
        getIntermediateImageSetTimes().clear();
        setNewIntermediateImageSetPointAvailable(false);
        setEmptyEventTimestampNs(null);
        setReleasedEventTimestampNs(null);
    }

    public final void setControllerId(String str) {
        this.controllerId = str;
    }

    public final void setRequestId(String str) {
        this.requestId = str;
    }

    public final void setImageRequest(Object obj) {
        this.imageRequest = obj;
    }

    public final void setControllerSubmitTimeMs(long j) {
        this.controllerSubmitTimeMs = j;
    }

    public final void setControllerIntermediateImageSetTimeMs(long j) {
        this.controllerIntermediateImageSetTimeMs = j;
    }

    public final void setControllerFinalImageSetTimeMs(long j) {
        this.controllerFinalImageSetTimeMs = j;
    }

    public final void setControllerFailureTimeMs(long j) {
        this.controllerFailureTimeMs = j;
    }

    public final void setImageRequestStartTimeMs(long j) {
        this.imageRequestStartTimeMs = j;
    }

    public final void setImageRequestEndTimeMs(long j) {
        this.imageRequestEndTimeMs = j;
    }

    public final void setInvisibilityEventTimeMs(long j) {
        this.invisibilityEventTimeMs = j;
    }

    public final void setPrefetch(boolean z) {
        this.isPrefetch = z;
    }

    public final void setImageInfo(Object obj) {
        this.imageInfo = obj;
    }

    public final void setOnScreenWidth(int i) {
        this.onScreenWidthPx = i;
    }

    public final void setOnScreenHeight(int i) {
        this.onScreenHeightPx = i;
    }

    public final void setErrorThrowable(Throwable th) {
        this.errorThrowable = th;
    }

    public final void setVisible(boolean z) {
        this.visibilityState = z ? VisibilityState.VISIBLE : VisibilityState.INVISIBLE;
    }

    public final ImagePerfData snapshot() {
        return new ImagePerfData(getInfra(), this.controllerId, this.requestId, this.imageRequest, this.callerContext, this.imageInfo, this.controllerSubmitTimeMs, this.controllerIntermediateImageSetTimeMs, this.controllerFinalImageSetTimeMs, this.controllerFailureTimeMs, this.imageRequestStartTimeMs, this.imageRequestEndTimeMs, getEmptyEventTimestampNs(), getReleasedEventTimestampNs(), this.isPrefetch, this.onScreenWidthPx, this.onScreenHeightPx, this.errorThrowable, this.visibilityState, this.visibilityEventTimeMs, this.invisibilityEventTimeMs, null, this._extraData, getCallingClassNameOnVisible(), getRootContextNameOnVisible(), getContextChainArrayOnVisible(), getContextChainExtrasOnVisible(), getContentIdOnVisible(), getSurfaceOnVisible(), getSubSurfaceOnVisible(), getMsSinceLastNavigationOnVisible(), getStartupStatusOnVisible(), CollectionsKt.toList(getIntermediateImageSetTimes()), getNewIntermediateImageSetPointAvailable(), getErrorMessageOnFailure(), getErrorStacktraceStringOnFailure(), getErrorCodeOnFailure(), getDensityDpiOnSuccess());
    }

    public final void setExtraData(ControllerListener2.Extras extras) {
        this._extraData = extras;
    }
}
