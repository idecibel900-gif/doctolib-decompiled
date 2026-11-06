package com.opentok.android;

import android.content.Context;
import com.opentok.otc.d;
import com.opentok.otc.i;

/* JADX INFO: loaded from: classes4.dex */
public class Publisher extends PublisherKit {
    protected CameraCaptureFrameRate cameraFrameRate;
    protected CameraListener cameraListener;
    protected CameraCaptureResolution cameraResolution;
    private final OtLog.LogToken log;

    public static class Builder extends PublisherKit.Builder {
        CameraCaptureFrameRate frameRate;
        CameraCaptureResolution resolution;

        public Builder(Context context) {
            super(context);
            this.resolution = null;
            this.frameRate = null;
        }

        public Builder frameRate(CameraCaptureFrameRate cameraCaptureFrameRate) {
            this.frameRate = cameraCaptureFrameRate;
            return this;
        }

        public Builder resolution(CameraCaptureResolution cameraCaptureResolution) {
            this.resolution = cameraCaptureResolution;
            return this;
        }

        @Override // com.opentok.android.PublisherKit.Builder
        public Builder allowAudioCaptureWhileMuted(boolean z) {
            return (Builder) super.allowAudioCaptureWhileMuted(z);
        }

        @Override // com.opentok.android.PublisherKit.Builder
        public Builder audioBitrate(int i) {
            return (Builder) super.audioBitrate(i);
        }

        @Override // com.opentok.android.PublisherKit.Builder
        public Builder audioTrack(boolean z) {
            this.audioTrack = z;
            return this;
        }

        @Override // com.opentok.android.PublisherKit.Builder
        public Publisher build() {
            if (this.capturer == null) {
                Context context = this.context;
                CameraCaptureResolution cameraCaptureResolutionDefaultResolution = this.resolution;
                if (cameraCaptureResolutionDefaultResolution == null) {
                    cameraCaptureResolutionDefaultResolution = CameraCaptureResolution.defaultResolution();
                }
                CameraCaptureFrameRate cameraCaptureFrameRateDefaultFrameRate = this.frameRate;
                if (cameraCaptureFrameRateDefaultFrameRate == null) {
                    cameraCaptureFrameRateDefaultFrameRate = CameraCaptureFrameRate.defaultFrameRate();
                }
                capturer(VideoCaptureFactory.constructCapturer(context, cameraCaptureResolutionDefaultResolution, cameraCaptureFrameRateDefaultFrameRate));
            }
            if (this.renderer == null) {
                renderer(VideoRenderFactory.constructRenderer(this.context));
            }
            return new Publisher(this);
        }

        @Override // com.opentok.android.PublisherKit.Builder
        public Builder capturer(BaseVideoCapturer baseVideoCapturer) {
            this.capturer = baseVideoCapturer;
            return this;
        }

        @Override // com.opentok.android.PublisherKit.Builder
        public Builder enableOpusDtx(boolean z) {
            this.enableOpusDtx = z;
            return this;
        }

        @Override // com.opentok.android.PublisherKit.Builder
        public Builder name(String str) {
            this.name = str;
            return this;
        }

        @Override // com.opentok.android.PublisherKit.Builder
        public Builder preferredVideoCodecs(PublisherKit.PreferredVideoCodecs preferredVideoCodecs) {
            return (Builder) super.preferredVideoCodecs(preferredVideoCodecs);
        }

        @Override // com.opentok.android.PublisherKit.Builder
        public Builder publisherAudioFallbackEnabled(boolean z) {
            return (Builder) super.publisherAudioFallbackEnabled(z);
        }

        @Override // com.opentok.android.PublisherKit.Builder
        public Builder renderer(BaseVideoRenderer baseVideoRenderer) {
            this.renderer = baseVideoRenderer;
            return this;
        }

        @Override // com.opentok.android.PublisherKit.Builder
        public Builder scalableScreenshare(boolean z) {
            return (Builder) super.scalableScreenshare(z);
        }

        @Override // com.opentok.android.PublisherKit.Builder
        public Builder senderStatsTrack(boolean z) {
            return (Builder) super.senderStatsTrack(z);
        }

        @Override // com.opentok.android.PublisherKit.Builder
        public Builder subscriberAudioFallbackEnabled(boolean z) {
            return (Builder) super.subscriberAudioFallbackEnabled(z);
        }

        @Override // com.opentok.android.PublisherKit.Builder
        public Builder videoTrack(boolean z) {
            this.videoTrack = z;
            return this;
        }
    }

    public enum CameraCaptureFrameRate {
        FPS_30(0),
        FPS_15(1),
        FPS_7(2),
        FPS_1(3);

        private final int captureFramerate;

        CameraCaptureFrameRate(int i) {
            this.captureFramerate = i;
        }

        static CameraCaptureFrameRate defaultFrameRate() {
            return FPS_30;
        }

        static CameraCaptureFrameRate fromFramerate(int i) {
            for (CameraCaptureFrameRate cameraCaptureFrameRate : values()) {
                if (cameraCaptureFrameRate.getCaptureFrameRate() == i) {
                    return cameraCaptureFrameRate;
                }
            }
            throw new IllegalArgumentException("unknown capture framerate " + i);
        }

        int getCaptureFrameRate() {
            return this.captureFramerate;
        }
    }

    public enum CameraCaptureResolution {
        LOW(0),
        MEDIUM(1),
        HIGH(2),
        HIGH_1080P(3);

        private final int captureResolution;

        CameraCaptureResolution(int i) {
            this.captureResolution = i;
        }

        static CameraCaptureResolution defaultResolution() {
            return MEDIUM;
        }

        static CameraCaptureResolution fromResolution(int i) {
            for (CameraCaptureResolution cameraCaptureResolution : values()) {
                if (cameraCaptureResolution.getCaptureResolution() == i) {
                    return cameraCaptureResolution;
                }
            }
            throw new IllegalArgumentException("unknown capture resolution " + i);
        }

        int getCaptureResolution() {
            return this.captureResolution;
        }
    }

    public interface CameraListener {
        void onCameraChanged(Publisher publisher, int i);

        void onCameraError(Publisher publisher, OpentokError opentokError);
    }

    protected Publisher(Builder builder) {
        super(builder);
        this.log = new OtLog.LogToken(this);
        getCapturer().setPublisherKit(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCameraError$1(OpentokError opentokError) {
        CameraListener cameraListener = this.cameraListener;
        if (cameraListener != null) {
            cameraListener.onCameraError(this, opentokError);
        }
    }

    public void cycleCamera() {
        Object capturer = getCapturer();
        if (capturer == null) {
            this.log.e("cycleCamera() Capturer is not initialized yet.", new Object[0]);
            onCameraError(new OpentokError(OpentokError.Domain.PublisherErrorDomain, OpentokError.ErrorCode.VideoCaptureFailed.getErrorCode(), "cycleCamera() Capturer is not initialized yet."));
            return;
        }
        try {
            ((BaseVideoCapturer.CaptureSwitch) capturer).cycleCamera();
        } catch (ClassCastException e) {
            this.log.e("cycleCamera() BaseVideoCapturer.CaptureSwitch interface not implemented", new Object[0]);
            onCameraError(e);
        } catch (RuntimeException e2) {
            this.log.e(e2.getMessage(), new Object[0]);
            onCameraError(e2);
        }
    }

    void enableSimulcast() {
        setSimulcastLevel(2);
    }

    @Deprecated
    public int getCameraId() {
        Object capturer = getCapturer();
        if (capturer == null) {
            this.log.e("getCameraId() Capturer is not initialized yet.", new Object[0]);
            return -1;
        }
        try {
            return ((BaseVideoCapturer.CaptureSwitch) capturer).getCameraIndex();
        } catch (ClassCastException unused) {
            this.log.e("getCameraId() BaseVideoCapturer.CaptureSwitch interface not implemented", new Object[0]);
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: onCameraChanged, reason: merged with bridge method [inline-methods] */
    public void lambda$onPublisherCameraPositionChanged$0(int i) {
        CameraListener cameraListener = this.cameraListener;
        if (cameraListener != null) {
            cameraListener.onCameraChanged(this, i);
        }
    }

    void onCameraError(Exception exc) {
        onCameraError(new OpentokError(OpentokError.Domain.PublisherErrorDomain, OpentokError.ErrorCode.CameraFailed.getErrorCode(), exc));
    }

    void onPublisherCameraPositionChanged(Publisher publisher, final int i) {
        this.log.d("onPublisherCameraPositionChanged() Publisher has changed the camera position to: %d", Integer.valueOf(i));
        this.handler.post(new Runnable() { // from class: com.opentok.android.Publisher$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onPublisherCameraPositionChanged$0(i);
            }
        });
    }

    @Deprecated
    public void setCameraId(int i) {
        Object capturer = getCapturer();
        if (capturer == null) {
            this.log.e("setCameraId() Capturer is not initialized yet.", new Object[0]);
            onCameraError(new OpentokError(OpentokError.Domain.PublisherErrorDomain, OpentokError.ErrorCode.VideoCaptureFailed.getErrorCode(), "setCameraId() Capturer is not initialized yet."));
            return;
        }
        try {
            ((BaseVideoCapturer.CaptureSwitch) capturer).swapCamera(i);
            onPublisherCameraPositionChanged(this, i);
        } catch (ClassCastException e) {
            this.log.e("setCameraId() BaseVideoCapturer.CaptureSwitch interface not implemented", new Object[0]);
            onCameraError(e);
        }
    }

    public void setCameraListener(CameraListener cameraListener) {
        this.cameraListener = cameraListener;
    }

    public void setCameraTorch(boolean z) {
        if (getCapturer() != null) {
            BaseVideoCapturer baseVideoCapturer = this.capturer;
            if (baseVideoCapturer instanceof Camera2VideoCapturer) {
                ((Camera2VideoCapturer) baseVideoCapturer).setCameraTorch(z);
                return;
            }
        }
        this.log.e("set Camera Torch failed.", new Object[0]);
        onCameraError(new OpentokError(OpentokError.Domain.PublisherErrorDomain, OpentokError.ErrorCode.VideoCaptureFailed.getErrorCode(), "set Camera Torch failed."));
    }

    public void setCameraZoomFactor(float f) {
        if (getCapturer() != null) {
            BaseVideoCapturer baseVideoCapturer = this.capturer;
            if (baseVideoCapturer instanceof Camera2VideoCapturer) {
                ((Camera2VideoCapturer) baseVideoCapturer).setCameraZoomFactor(f);
                return;
            }
        }
        this.log.e("setCameraZoomFactor() Capturer is not initialized yet.", new Object[0]);
        onCameraError(new OpentokError(OpentokError.Domain.PublisherErrorDomain, OpentokError.ErrorCode.VideoCaptureFailed.getErrorCode(), "setCameraZoomFactor() Capturer is not initialized yet."));
    }

    void setSimulcastLevel(int i) {
        i iVar;
        if (i == 0) {
            iVar = i.c;
        } else if (i != 1) {
            iVar = i != 2 ? i.e : i.e;
        } else {
            iVar = i.d;
        }
        d.a(this.otc_publisher, iVar);
    }

    @Deprecated
    public void startPreview() {
    }

    @Deprecated
    public void swapCamera() {
        if (getCapturer() != null) {
            cycleCamera();
        } else {
            this.log.e("swapCamera() Capturer is not initialized yet.", new Object[0]);
            onCameraError(new OpentokError(OpentokError.Domain.PublisherErrorDomain, OpentokError.ErrorCode.VideoCaptureFailed.getErrorCode(), "swapCamera() Capturer is not initialized yet."));
        }
    }

    protected void onCameraError(final OpentokError opentokError) {
        this.log.d("onCameraError() Camera device has failed: " + opentokError.errorMessage, new Object[0]);
        if (this.cameraListener != null) {
            this.handler.post(new Runnable() { // from class: com.opentok.android.Publisher$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onCameraError$1(opentokError);
                }
            });
        }
    }
}
