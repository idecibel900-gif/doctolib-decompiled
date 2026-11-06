package com.opentok.android;

import android.content.Context;
import android.graphics.Rect;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.hardware.display.DisplayManager;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Range;
import android.util.Size;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.WindowManager;
import com.google.common.util.concurrent.AtomicDouble;
import com.google.firebase.messaging.Constants;
import com.revenuecat.purchases.ui.revenuecatui.components.SensibleDefaults;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
class Camera2VideoCapturer extends BaseVideoCapturer implements BaseVideoCapturer.CaptureSwitch {
    private static final int PIXEL_FORMAT = 35;
    private static final int PREFERRED_FACING_CAMERA = 0;
    private Range<Integer> camFps;
    CameraDevice camera;
    private ImageReader cameraFrame;
    private int cameraIndex;
    private CameraInfoCache cameraInfoCache;
    private final CameraManager cameraManager;
    CameraState cameraState;
    private HandlerThread cameraThread;
    private Handler cameraThreadHandler;
    CaptureRequest.Builder captureRequestBuilder;
    CameraCaptureSession captureSession;
    private final int desiredFps;
    private Display display;
    private DisplayOrientationCache displayOrientationCache;
    Runnable executeAfterCameraOpened;
    Runnable executeAfterCameraSessionConfigured;
    Runnable executeAfterClosed;
    private final Size frameDimensions;
    static final SparseIntArray rotationTable = new SparseIntArray() { // from class: com.opentok.android.Camera2VideoCapturer.1
        {
            append(0, 0);
            append(1, 90);
            append(2, SensibleDefaults.X_OFFSET);
            append(3, 270);
        }
    };
    private static final SparseArray<Size> resolutionTable = new SparseArray<Size>() { // from class: com.opentok.android.Camera2VideoCapturer.2
        {
            append(Publisher.CameraCaptureResolution.LOW.ordinal(), new Size(352, 288));
            append(Publisher.CameraCaptureResolution.MEDIUM.ordinal(), new Size(640, 480));
            append(Publisher.CameraCaptureResolution.HIGH.ordinal(), new Size(1280, 720));
            append(Publisher.CameraCaptureResolution.HIGH_1080P.ordinal(), new Size(1920, 1080));
        }
    };
    private static final SparseIntArray frameRateTable = new SparseIntArray() { // from class: com.opentok.android.Camera2VideoCapturer.3
        {
            append(Publisher.CameraCaptureFrameRate.FPS_1.ordinal(), 1);
            append(Publisher.CameraCaptureFrameRate.FPS_7.ordinal(), 7);
            append(Publisher.CameraCaptureFrameRate.FPS_15.ordinal(), 15);
            append(Publisher.CameraCaptureFrameRate.FPS_30.ordinal(), 30);
        }
    };
    final OtLog.LogToken log = new OtLog.LogToken(this);
    private final AtomicBoolean isPublishingVideo = new AtomicBoolean(false);
    private final AtomicBoolean preferredCameraTorchValue = new AtomicBoolean(false);
    private final AtomicDouble preferredCameraZoomFactorValue = new AtomicDouble(1.0d);
    private final CameraDevice.StateCallback cameraObserver = new CameraDevice.StateCallback() { // from class: com.opentok.android.Camera2VideoCapturer.4
        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onClosed(CameraDevice cameraDevice) {
            Camera2VideoCapturer.this.log.d("CameraDevice.StateCallback onClosed() enter.", new Object[0]);
            super.onClosed(cameraDevice);
            Camera2VideoCapturer camera2VideoCapturer = Camera2VideoCapturer.this;
            camera2VideoCapturer.cameraState = CameraState.CLOSED;
            camera2VideoCapturer.camera = null;
            Runnable runnable = camera2VideoCapturer.executeAfterClosed;
            if (runnable != null) {
                runnable.run();
            }
            Camera2VideoCapturer camera2VideoCapturer2 = Camera2VideoCapturer.this;
            camera2VideoCapturer2.executeAfterClosed = null;
            camera2VideoCapturer2.log.d("CameraDevice.StateCallback onClosed() exit.", new Object[0]);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(CameraDevice cameraDevice) {
            Camera2VideoCapturer.this.log.d("CameraDevice.StateCallback onDisconnected() enter", new Object[0]);
            try {
                Camera2VideoCapturer camera2VideoCapturer = Camera2VideoCapturer.this;
                camera2VideoCapturer.executeAfterClosed = null;
                camera2VideoCapturer.camera.close();
            } catch (Exception e) {
                Camera2VideoCapturer.this.handleException(e);
            }
            Camera2VideoCapturer.this.log.d("CameraDevice.StateCallback onDisconnected() exit", new Object[0]);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(CameraDevice cameraDevice, int i) {
            Camera2VideoCapturer.this.log.d("CameraDevice.StateCallback onError() enter", new Object[0]);
            try {
                cameraDevice.close();
            } catch (Exception e) {
                Camera2VideoCapturer.this.handleException(e);
            }
            Camera2VideoCapturer.this.log.d("CameraDevice.StateCallback onError() exit", new Object[0]);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(CameraDevice cameraDevice) {
            Camera2VideoCapturer.this.log.d("CameraDevice.StateCallback onOpened() enter", new Object[0]);
            Camera2VideoCapturer camera2VideoCapturer = Camera2VideoCapturer.this;
            camera2VideoCapturer.cameraState = CameraState.OPEN;
            camera2VideoCapturer.camera = cameraDevice;
            Runnable runnable = camera2VideoCapturer.executeAfterCameraOpened;
            if (runnable != null) {
                runnable.run();
            }
            Camera2VideoCapturer camera2VideoCapturer2 = Camera2VideoCapturer.this;
            camera2VideoCapturer2.executeAfterCameraOpened = null;
            camera2VideoCapturer2.log.d("CameraDevice.StateCallback onOpened() exit", new Object[0]);
        }
    };
    private final ImageReader.OnImageAvailableListener frameObserver = new ImageReader.OnImageAvailableListener() { // from class: com.opentok.android.Camera2VideoCapturer.5
        @Override // android.media.ImageReader.OnImageAvailableListener
        public void onImageAvailable(ImageReader imageReader) {
            try {
                Image imageAcquireNextImage = imageReader.acquireNextImage();
                if (imageAcquireNextImage != null && (imageAcquireNextImage.getPlanes().length <= 0 || imageAcquireNextImage.getPlanes()[0].getBuffer() != null)) {
                    if ((imageAcquireNextImage.getPlanes().length <= 1 || imageAcquireNextImage.getPlanes()[1].getBuffer() != null) && (imageAcquireNextImage.getPlanes().length <= 2 || imageAcquireNextImage.getPlanes()[2].getBuffer() != null)) {
                        CameraState cameraState = CameraState.CAPTURE;
                        Camera2VideoCapturer camera2VideoCapturer = Camera2VideoCapturer.this;
                        if (cameraState == camera2VideoCapturer.cameraState) {
                            camera2VideoCapturer.provideBufferFramePlanar(imageAcquireNextImage.getPlanes()[0].getBuffer(), imageAcquireNextImage.getPlanes()[1].getBuffer(), imageAcquireNextImage.getPlanes()[2].getBuffer(), imageAcquireNextImage.getPlanes()[0].getPixelStride(), imageAcquireNextImage.getPlanes()[0].getRowStride(), imageAcquireNextImage.getPlanes()[1].getPixelStride(), imageAcquireNextImage.getPlanes()[1].getRowStride(), imageAcquireNextImage.getPlanes()[2].getPixelStride(), imageAcquireNextImage.getPlanes()[2].getRowStride(), imageAcquireNextImage.getWidth(), imageAcquireNextImage.getHeight(), Camera2VideoCapturer.this.calculateCamRotation(), Camera2VideoCapturer.this.isFrontCamera());
                        }
                        imageAcquireNextImage.close();
                        return;
                    }
                }
                Camera2VideoCapturer.this.log.d("onImageAvailable frame provided has no image data", new Object[0]);
            } catch (IllegalStateException e) {
                Camera2VideoCapturer.this.log.e("ImageReader.acquireNextImage() throws error !", new Object[0]);
                throw new Camera2Exception(e.getMessage());
            }
        }
    };
    private final CameraCaptureSession.StateCallback captureSessionObserver = new CameraCaptureSession.StateCallback() { // from class: com.opentok.android.Camera2VideoCapturer.6
        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onClosed(CameraCaptureSession cameraCaptureSession) {
            Camera2VideoCapturer.this.log.d("CameraCaptureSession.StateCallback onClosed() enter.", new Object[0]);
            CameraDevice cameraDevice = Camera2VideoCapturer.this.camera;
            if (cameraDevice != null) {
                cameraDevice.close();
            }
            Camera2VideoCapturer.this.log.d("CameraCaptureSession.StateCallback onClosed() exit.", new Object[0]);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
            Camera2VideoCapturer.this.log.d("CameraCaptureSession.StateCallback onFailed() enter.", new Object[0]);
            Camera2VideoCapturer camera2VideoCapturer = Camera2VideoCapturer.this;
            camera2VideoCapturer.cameraState = CameraState.ERROR;
            camera2VideoCapturer.log.d("CameraCaptureSession.StateCallback onFailed() exit.", new Object[0]);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigured(CameraCaptureSession cameraCaptureSession) {
            Camera2VideoCapturer.this.log.d("CameraCaptureSession.StateCallback onConfigured() enter.", new Object[0]);
            try {
                Camera2VideoCapturer camera2VideoCapturer = Camera2VideoCapturer.this;
                camera2VideoCapturer.cameraState = CameraState.CAPTURE;
                camera2VideoCapturer.captureSession = cameraCaptureSession;
                CaptureRequest captureRequestBuild = camera2VideoCapturer.captureRequestBuilder.build();
                Camera2VideoCapturer camera2VideoCapturer2 = Camera2VideoCapturer.this;
                camera2VideoCapturer2.captureSession.setRepeatingRequest(captureRequestBuild, camera2VideoCapturer2.captureNotification, null);
            } catch (Exception e) {
                Camera2VideoCapturer.this.handleException(e);
            }
            Runnable runnable = Camera2VideoCapturer.this.executeAfterCameraSessionConfigured;
            if (runnable != null) {
                runnable.run();
                Camera2VideoCapturer.this.executeAfterCameraSessionConfigured = null;
            }
            synchronized (Camera2VideoCapturer.this.lock) {
                try {
                    Camera2VideoCapturer camera2VideoCapturer3 = Camera2VideoCapturer.this;
                    if (camera2VideoCapturer3.cycleCameraInProgress) {
                        camera2VideoCapturer3.cycleCameraInProgress = false;
                        camera2VideoCapturer3.onCameraChanged(camera2VideoCapturer3.getCameraIndex());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            Camera2VideoCapturer.this.onCaptureStart();
            Camera2VideoCapturer.this.log.d("CameraCaptureSession.StateCallback onConfigured() exit.", new Object[0]);
        }
    };
    final CameraCaptureSession.CaptureCallback captureNotification = new CameraCaptureSession.CaptureCallback() { // from class: com.opentok.android.Camera2VideoCapturer.7
        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureStarted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long j, long j2) {
            super.onCaptureStarted(cameraCaptureSession, captureRequest, j, j2);
        }
    };
    private boolean cycleCameraInProgress = false;
    private final Object lock = new Object();

    /* JADX INFO: renamed from: com.opentok.android.Camera2VideoCapturer$10, reason: invalid class name */
    static /* synthetic */ class AnonymousClass10 {
        static final /* synthetic */ int[] $SwitchMap$com$opentok$android$Camera2VideoCapturer$CameraState;

        static {
            int[] iArr = new int[CameraState.values().length];
            $SwitchMap$com$opentok$android$Camera2VideoCapturer$CameraState = iArr;
            try {
                iArr[CameraState.CAPTURE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$opentok$android$Camera2VideoCapturer$CameraState[CameraState.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$opentok$android$Camera2VideoCapturer$CameraState[CameraState.CLOSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$opentok$android$Camera2VideoCapturer$CameraState[CameraState.SETUP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static class Camera2Exception extends RuntimeException {
        public Camera2Exception(String str) {
            super(str);
        }
    }

    private static class CameraInfoCache {
        private final boolean frontFacing;
        private final int sensorOrientation;

        public CameraInfoCache(CameraCharacteristics cameraCharacteristics) {
            this.frontFacing = ((Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue() == 0;
            this.sensorOrientation = ((Integer) cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
        }

        public boolean isFrontFacing() {
            return this.frontFacing;
        }

        public int sensorOrientation() {
            return this.sensorOrientation;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    enum CameraState {
        CLOSED,
        CLOSING,
        SETUP,
        OPEN,
        CAPTURE,
        CREATE_SESSION,
        ERROR
    }

    private static class DisplayOrientationCache implements Runnable {
        private static final int POLL_DELAY_MS = 750;
        private final Display display;
        private int displayRotation;
        private final Handler handler;

        public DisplayOrientationCache(Display display, Handler handler) {
            this.display = display;
            this.handler = handler;
            this.displayRotation = Camera2VideoCapturer.rotationTable.get(display.getRotation());
            handler.postDelayed(this, 750L);
        }

        public int getOrientation() {
            return this.displayRotation;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.displayRotation = Camera2VideoCapturer.rotationTable.get(this.display.getRotation());
            this.handler.postDelayed(this, 750L);
        }
    }

    public Camera2VideoCapturer(Context context, Publisher.CameraCaptureResolution cameraCaptureResolution, Publisher.CameraCaptureFrameRate cameraCaptureFrameRate) {
        this.cameraManager = (CameraManager) context.getSystemService("camera");
        if (Build.VERSION.SDK_INT >= 30) {
            try {
                this.display = context.getDisplay();
            } catch (Exception unused) {
                this.display = ((DisplayManager) context.getSystemService(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION)).getDisplay(0);
            }
        } else {
            this.display = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        }
        this.camera = null;
        this.cameraState = CameraState.CLOSED;
        this.frameDimensions = resolutionTable.get(cameraCaptureResolution.ordinal());
        this.desiredFps = frameRateTable.get(cameraCaptureFrameRate.ordinal());
        try {
            String strSelectCamera = selectCamera(0);
            if (strSelectCamera == null && this.cameraManager.getCameraIdList().length > 0) {
                strSelectCamera = this.cameraManager.getCameraIdList()[0];
            }
            setCameraIndex(findCameraIndex(strSelectCamera));
            if (getCameraIndex() == -1) {
                this.log.e("Exception!. Camera Index cannot be -1.", new Object[0]);
            } else {
                initCameraFrame();
            }
        } catch (Exception e) {
            handleException(e);
        }
    }

    private void applyCameraPreferences() {
        setCameraTorch(this.preferredCameraTorchValue.get());
        setCameraZoomFactor((float) this.preferredCameraZoomFactorValue.get());
    }

    private void doInit() {
        this.log.d("doInit() enter", new Object[0]);
        this.cameraInfoCache = null;
        startCamThread();
        startDisplayOrientationCache();
        initCamera();
        this.log.d("doInit() exit", new Object[0]);
    }

    private int findCameraIndex(String str) throws CameraAccessException {
        String[] cameraIdList = this.cameraManager.getCameraIdList();
        for (int i = 0; i < cameraIdList.length; i++) {
            if (cameraIdList[i].equals(str)) {
                return i;
            }
        }
        return -1;
    }

    private Size[] getCameraOutputSizes(String str) {
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) this.cameraManager.getCameraCharacteristics(str).get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        return streamConfigurationMap != null ? streamConfigurationMap.getOutputSizes(PIXEL_FORMAT) : new Size[0];
    }

    private int getNextSupportedCameraIndex() throws CameraAccessException {
        String[] cameraIdList = this.cameraManager.getCameraIdList();
        int length = cameraIdList.length;
        for (int i = 0; i < length; i++) {
            int cameraIndex = ((getCameraIndex() + i) + 1) % length;
            Size[] cameraOutputSizes = getCameraOutputSizes(cameraIdList[cameraIndex]);
            boolean z = cameraOutputSizes != null && cameraOutputSizes.length > 0;
            boolean zIsDepthOutputCamera = isDepthOutputCamera(cameraIdList[cameraIndex]);
            boolean zIsBackwardCompatible = isBackwardCompatible(cameraIdList[cameraIndex]);
            if (z && zIsBackwardCompatible && !zIsDepthOutputCamera) {
                return cameraIndex;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleException(Exception exc) {
        this.cameraState = CameraState.ERROR;
        synchronized (this.lock) {
            this.cycleCameraInProgress = false;
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        exc.printStackTrace(printWriter);
        printWriter.flush();
        this.log.e(stringWriter.toString(), new Object[0]);
        onCaptureError(exc);
    }

    private void initCamera() {
        if (getCameraIndex() == -1) {
            this.log.e(" Camera Index cannot be -1. initCamera() unsuccessful.", new Object[0]);
            return;
        }
        this.log.d("initCamera() enter.", new Object[0]);
        try {
            this.cameraState = CameraState.SETUP;
            String str = this.cameraManager.getCameraIdList()[getCameraIndex()];
            this.camFps = selectCameraFpsRange(str, this.desiredFps);
            this.cameraFrame.setOnImageAvailableListener(this.frameObserver, this.cameraThreadHandler);
            this.cameraInfoCache = new CameraInfoCache(this.cameraManager.getCameraCharacteristics(str));
            this.cameraManager.openCamera(str, this.cameraObserver, (Handler) null);
        } catch (Exception e) {
            this.log.e("Camera cannot be opened. Check the error message below.", new Object[0]);
            handleException(e);
        }
        this.log.d("initCamera() exit.", new Object[0]);
    }

    private void initCameraFrame() {
        if (getCameraIndex() == -1) {
            this.log.e(" Camera Index cannot be -1. initCameraFrame() unsuccessful.", new Object[0]);
            return;
        }
        this.log.d("initCameraFrame() enter.", new Object[0]);
        try {
            Size sizeSelectPreferredSize = selectPreferredSize(this.cameraManager.getCameraIdList()[getCameraIndex()], this.frameDimensions.getWidth(), this.frameDimensions.getHeight());
            ImageReader imageReader = this.cameraFrame;
            if (imageReader != null) {
                imageReader.close();
            }
            this.cameraFrame = ImageReader.newInstance(sizeSelectPreferredSize.getWidth(), sizeSelectPreferredSize.getHeight(), PIXEL_FORMAT, 3);
        } catch (Exception e) {
            handleException(e);
        }
        this.log.d("initCameraFrame() exit.", new Object[0]);
    }

    private boolean isBackwardCompatible(String str) {
        int[] iArr = (int[]) this.cameraManager.getCameraCharacteristics(str).get(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
        if (iArr != null) {
            for (int i : iArr) {
                if (i == 0) {
                    this.log.d(" REQUEST_AVAILABLE_CAPABILITIES_BACKWARD_COMPATIBLE => TRUE", new Object[0]);
                    return true;
                }
            }
        }
        this.log.d(" REQUEST_AVAILABLE_CAPABILITIES_BACKWARD_COMPATIBLE => FALSE", new Object[0]);
        return false;
    }

    private boolean isDepthOutputCamera(String str) {
        int[] iArr = (int[]) this.cameraManager.getCameraCharacteristics(str).get(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
        if (iArr != null) {
            for (int i : iArr) {
                if (i == 8) {
                    this.log.d(" REQUEST_AVAILABLE_CAPABILITIES_DEPTH_OUTPUT => TRUE", new Object[0]);
                    return true;
                }
            }
        }
        this.log.d(" REQUEST_AVAILABLE_CAPABILITIES_DEPTH_OUTPUT => FALSE", new Object[0]);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setCameraTorch$3(boolean z) {
        try {
            this.captureRequestBuilder.set(CaptureRequest.FLASH_MODE, Integer.valueOf(z ? 2 : 0));
            this.captureSession.setRepeatingRequest(this.captureRequestBuilder.build(), null, this.cameraThreadHandler);
        } catch (CameraAccessException unused) {
            this.log.d("Torch feature not available", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setCameraZoomFactor$4(float f) {
        Range range;
        try {
            CameraCharacteristics cameraCharacteristics = this.cameraManager.getCameraCharacteristics(this.camera.getId());
            if (Build.VERSION.SDK_INT >= 30) {
                CameraCharacteristics.Key key = CameraCharacteristics.CONTROL_ZOOM_RATIO_RANGE;
                if (cameraCharacteristics.get(key) != null && (range = (Range) cameraCharacteristics.get(key)) != null) {
                    this.captureRequestBuilder.set(CaptureRequest.CONTROL_ZOOM_RATIO, Float.valueOf(Math.max(((Float) range.getLower()).floatValue(), Math.min(f, ((Float) range.getUpper()).floatValue()))));
                }
            } else {
                ((Float) cameraCharacteristics.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM)).getClass();
                Rect rect = (Rect) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
                int iWidth = rect.width() / 2;
                int iHeight = rect.height() / 2;
                float f2 = f * 2.0f;
                int iWidth2 = (int) (rect.width() / f2);
                int iHeight2 = (int) (rect.height() / f2);
                this.captureRequestBuilder.set(CaptureRequest.SCALER_CROP_REGION, new Rect(iWidth - iWidth2, iHeight - iHeight2, iWidth + iWidth2, iHeight + iHeight2));
            }
            this.captureSession.setRepeatingRequest(this.captureRequestBuilder.build(), null, this.cameraThreadHandler);
        } catch (CameraAccessException unused) {
            this.log.d("Zooming feature not available", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startCapture$0() {
        initCamera();
        scheduleStartCapture();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$stopCapture$1() {
        this.cameraState = CameraState.CLOSING;
        CameraDevice cameraDevice = this.camera;
        if (cameraDevice != null) {
            cameraDevice.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$stopCapture$2() {
        this.captureSession.close();
        this.cameraState = CameraState.CLOSING;
        this.executeAfterCameraSessionConfigured = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$swapCamera$5(CameraState cameraState) {
        if (AnonymousClass10.$SwitchMap$com$opentok$android$Camera2VideoCapturer$CameraState[cameraState.ordinal()] != 1) {
            return;
        }
        initCameraFrame();
        initCamera();
        startCapture();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCaptureStart() {
        if (this.isPublishingVideo.get()) {
            applyCameraPreferences();
        }
    }

    private synchronized void scheduleStartCapture() {
        this.log.d("scheduleStartCapture() enter (cameraState: " + this.cameraState + ")", new Object[0]);
        if (this.camera != null && CameraState.OPEN == this.cameraState) {
            doStartCapture();
            return;
        }
        CameraState cameraState = CameraState.SETUP;
        CameraState cameraState2 = this.cameraState;
        if (cameraState == cameraState2) {
            this.log.d("camera not yet ready, queuing the start until camera is opened.", new Object[0]);
            this.executeAfterCameraOpened = new Runnable() { // from class: com.opentok.android.Camera2VideoCapturer$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.doStartCapture();
                }
            };
        } else if (CameraState.CREATE_SESSION == cameraState2) {
            this.log.d("Camera session creation already requested", new Object[0]);
        } else {
            this.log.d("Start Capture called before init successfully completed.", new Object[0]);
        }
        this.log.d("scheduleStartCapture() exit", new Object[0]);
    }

    private String selectCamera(int i) throws CameraAccessException {
        for (String str : this.cameraManager.getCameraIdList()) {
            CameraCharacteristics cameraCharacteristics = this.cameraManager.getCameraCharacteristics(str);
            CameraCharacteristics.Key key = CameraCharacteristics.LENS_FACING;
            if (i == ((Integer) cameraCharacteristics.get(key)).intValue()) {
                this.log.d("selectCamera() Direction the camera faces relative to device screen: " + cameraCharacteristics.get(key), new Object[0]);
                return str;
            }
        }
        return null;
    }

    private Range<Integer> selectCameraFpsRange(String str, final int i) throws CameraAccessException {
        for (String str2 : this.cameraManager.getCameraIdList()) {
            if (str2.equals(str)) {
                CameraCharacteristics cameraCharacteristics = this.cameraManager.getCameraCharacteristics(str2);
                ArrayList arrayList = new ArrayList();
                Collections.addAll(arrayList, (Range[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES));
                this.log.d("Supported fps ranges = " + arrayList, new Object[0]);
                Range<Integer> range = (Range) Collections.min(arrayList, new Comparator<Range<Integer>>() { // from class: com.opentok.android.Camera2VideoCapturer.8
                    private int calcError(Range<Integer> range2) {
                        return Math.abs(((Integer) range2.getLower()).intValue() - i) + Math.abs(((Integer) range2.getUpper()).intValue() - i);
                    }

                    @Override // java.util.Comparator
                    public int compare(Range<Integer> range2, Range<Integer> range3) {
                        return calcError(range2) - calcError(range3);
                    }
                });
                this.log.d("Desired fps = " + i + " || Selected frame rate range = " + range, new Object[0]);
                return range;
            }
        }
        return null;
    }

    private Size selectPreferredSize(String str, final int i, final int i2) {
        Size[] cameraOutputSizes = getCameraOutputSizes(str);
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, cameraOutputSizes);
        return (Size) Collections.min(arrayList, new Comparator<Size>() { // from class: com.opentok.android.Camera2VideoCapturer.9
            @Override // java.util.Comparator
            public int compare(Size size, Size size2) {
                return (Math.abs(size.getWidth() - i) + Math.abs(size.getHeight() - i2)) - (Math.abs(size2.getWidth() - i) + Math.abs(size2.getHeight() - i2));
            }
        });
    }

    private void setCameraIndex(int i) {
        this.cameraIndex = i;
    }

    private void startCamThread() {
        this.log.d("startCamThread() enter", new Object[0]);
        HandlerThread handlerThread = new HandlerThread("Camera2VideoCapturer-Camera-Thread");
        this.cameraThread = handlerThread;
        handlerThread.start();
        this.cameraThreadHandler = new Handler(this.cameraThread.getLooper());
        this.log.d("startCamThread() exit", new Object[0]);
    }

    private void startDisplayOrientationCache() {
        this.displayOrientationCache = new DisplayOrientationCache(this.display, this.cameraThreadHandler);
    }

    private void stopCamThread() {
        this.log.d("stopCamThread() enter", new Object[0]);
        try {
            try {
                this.cameraThread.quitSafely();
                this.cameraThread.join();
                this.cameraThread = null;
                this.cameraThreadHandler = null;
            } catch (Exception e) {
                handleException(e);
                this.cameraThread = null;
                this.cameraThreadHandler = null;
            }
            this.log.d("stopCamThread() exit", new Object[0]);
        } catch (Throwable th) {
            this.cameraThread = null;
            this.cameraThreadHandler = null;
            throw th;
        }
    }

    private void stopDisplayOrientationCache() {
        DisplayOrientationCache displayOrientationCache;
        Handler handler = this.cameraThreadHandler;
        if (handler == null || (displayOrientationCache = this.displayOrientationCache) == null) {
            return;
        }
        handler.removeCallbacks(displayOrientationCache);
    }

    int calculateCamRotation() {
        if (this.cameraInfoCache == null) {
            return 0;
        }
        int orientation = this.displayOrientationCache.getOrientation();
        int iSensorOrientation = this.cameraInfoCache.sensorOrientation();
        return !this.cameraInfoCache.isFrontFacing() ? Math.abs((orientation - iSensorOrientation) % 360) : ((orientation + iSensorOrientation) + 360) % 360;
    }

    @Override // com.opentok.android.BaseVideoCapturer.CaptureSwitch
    public synchronized void cycleCamera() {
        try {
            synchronized (this.lock) {
                if (this.cycleCameraInProgress) {
                    this.log.w("cycleCamera is still in progress.", new Object[0]);
                    return;
                }
                this.cycleCameraInProgress = true;
                this.log.d("cycleCamera() enter", new Object[0]);
                try {
                    setCameraIndex(getNextSupportedCameraIndex());
                    if (getCameraIndex() != -1) {
                        swapCamera(getCameraIndex());
                    } else {
                        handleException(new Camera2Exception("No cameras with supported outputs found"));
                    }
                } catch (Exception e) {
                    handleException(e);
                }
                this.log.d("cycleCamera() exit", new Object[0]);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.opentok.android.BaseVideoCapturer
    public synchronized void destroy() {
        this.log.d("destroy() enter", new Object[0]);
        stopDisplayOrientationCache();
        stopCamThread();
        this.cameraFrame.close();
        this.log.d("destroy() exit", new Object[0]);
    }

    @Override // com.opentok.android.BaseVideoCapturer.CaptureSwitch
    public int getCameraIndex() {
        return this.cameraIndex;
    }

    @Override // com.opentok.android.BaseVideoCapturer
    public synchronized BaseVideoCapturer.CaptureSettings getCaptureSettings() {
        BaseVideoCapturer.CaptureSettings captureSettings;
        try {
            captureSettings = new BaseVideoCapturer.CaptureSettings();
            captureSettings.fps = this.desiredFps;
            ImageReader imageReader = this.cameraFrame;
            captureSettings.width = imageReader != null ? imageReader.getWidth() : -1;
            ImageReader imageReader2 = this.cameraFrame;
            captureSettings.height = imageReader2 != null ? imageReader2.getHeight() : -1;
            captureSettings.format = 1;
            captureSettings.expectedDelay = 0;
            captureSettings.mirrorInLocalRender = this.frameMirrorX;
        } catch (Throwable th) {
            throw th;
        }
        return captureSettings;
    }

    @Override // com.opentok.android.BaseVideoCapturer
    public synchronized void init() {
        this.log.d("init() enter", new Object[0]);
        doInit();
        this.cameraState = CameraState.SETUP;
        this.log.d("init() exit", new Object[0]);
    }

    @Override // com.opentok.android.BaseVideoCapturer
    public boolean isCaptureStarted() {
        return this.cameraState == CameraState.CAPTURE;
    }

    boolean isFrontCamera() {
        CameraInfoCache cameraInfoCache = this.cameraInfoCache;
        return cameraInfoCache != null && cameraInfoCache.isFrontFacing();
    }

    @Override // com.opentok.android.BaseVideoCapturer
    public synchronized void onPause() {
    }

    @Override // com.opentok.android.BaseVideoCapturer
    public void onResume() {
    }

    public void setCameraTorch(final boolean z) {
        this.preferredCameraTorchValue.set(z);
        if (this.camera == null || this.captureSession == null || CameraState.CAPTURE != this.cameraState) {
            this.log.d("Cannot set Torch: Camera not capturing", new Object[0]);
        } else {
            this.cameraThreadHandler.post(new Runnable() { // from class: com.opentok.android.Camera2VideoCapturer$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setCameraTorch$3(z);
                }
            });
        }
    }

    public void setCameraZoomFactor(final float f) {
        this.preferredCameraZoomFactorValue.set(f);
        if (this.camera == null || this.captureSession == null || CameraState.CAPTURE != this.cameraState) {
            this.log.d("Cannot zoom: Camera not capturing", new Object[0]);
        } else {
            this.cameraThreadHandler.post(new Runnable() { // from class: com.opentok.android.Camera2VideoCapturer$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setCameraZoomFactor$4(f);
                }
            });
        }
    }

    public void setIsPublishingVideo(boolean z) {
        this.isPublishingVideo.set(z);
        if (z) {
            applyCameraPreferences();
        }
    }

    @Override // com.opentok.android.BaseVideoCapturer
    public synchronized int startCapture() {
        try {
            this.log.d("startCapture() enter (cameraState: " + this.cameraState + ")", new Object[0]);
            Runnable runnable = new Runnable() { // from class: com.opentok.android.Camera2VideoCapturer$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$startCapture$0();
                }
            };
            CameraState cameraState = this.cameraState;
            if (cameraState == CameraState.CLOSING) {
                this.executeAfterClosed = runnable;
            } else if (cameraState == CameraState.CLOSED) {
                runnable.run();
            } else {
                scheduleStartCapture();
            }
            this.log.d("startCapture() exit", new Object[0]);
        } catch (Throwable th) {
            throw th;
        }
        return 0;
    }

    @Override // com.opentok.android.BaseVideoCapturer
    public synchronized int stopCapture() {
        CameraCaptureSession cameraCaptureSession;
        this.log.d("stopCapture() enter (cameraState: " + this.cameraState + ")", new Object[0]);
        CameraDevice cameraDevice = this.camera;
        if (cameraDevice != null && (cameraCaptureSession = this.captureSession) != null && CameraState.CAPTURE == this.cameraState) {
            try {
                cameraCaptureSession.stopRepeating();
            } catch (CameraAccessException | IllegalStateException unused) {
            } catch (Exception e) {
                handleException(e);
            }
            this.captureSession.close();
            this.cameraInfoCache = null;
            this.cameraState = CameraState.CLOSING;
        } else if (cameraDevice == null || CameraState.OPEN != this.cameraState) {
            CameraState cameraState = CameraState.SETUP;
            CameraState cameraState2 = this.cameraState;
            if (cameraState == cameraState2) {
                this.executeAfterCameraOpened = new Runnable() { // from class: com.opentok.android.Camera2VideoCapturer$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$stopCapture$1();
                    }
                };
            } else if (CameraState.CREATE_SESSION == cameraState2) {
                this.executeAfterCameraSessionConfigured = new Runnable() { // from class: com.opentok.android.Camera2VideoCapturer$$ExternalSyntheticLambda5
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$stopCapture$2();
                    }
                };
            }
        } else {
            this.cameraState = CameraState.CLOSING;
            cameraDevice.close();
        }
        this.log.d("stopCapture exit", new Object[0]);
        return 0;
    }

    @Override // com.opentok.android.BaseVideoCapturer.CaptureSwitch
    public synchronized void swapCamera(int i) {
        try {
            this.log.d("swapCamera() enter. cameraState = " + this.cameraState, new Object[0]);
            final CameraState cameraState = this.cameraState;
            int i2 = AnonymousClass10.$SwitchMap$com$opentok$android$Camera2VideoCapturer$CameraState[cameraState.ordinal()];
            if (i2 == 1) {
                stopCapture();
            } else if (i2 == 2 || i2 == 3) {
                initCameraFrame();
                initCamera();
                startCapture();
            }
            setCameraIndex(i);
            this.executeAfterClosed = new Runnable() { // from class: com.opentok.android.Camera2VideoCapturer$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$swapCamera$5(cameraState);
                }
            };
            this.log.d("swapCamera() exit", new Object[0]);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doStartCapture() {
        this.log.d("doStartCapture() enter", new Object[0]);
        this.cameraState = CameraState.CREATE_SESSION;
        try {
            if (isFrontCamera()) {
                CaptureRequest.Builder builderCreateCaptureRequest = this.camera.createCaptureRequest(1);
                this.captureRequestBuilder = builderCreateCaptureRequest;
                builderCreateCaptureRequest.addTarget(this.cameraFrame.getSurface());
                this.captureRequestBuilder.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, this.camFps);
                this.captureRequestBuilder.set(CaptureRequest.CONTROL_MODE, 2);
                this.captureRequestBuilder.set(CaptureRequest.CONTROL_AF_MODE, 4);
                this.captureRequestBuilder.set(CaptureRequest.CONTROL_SCENE_MODE, 1);
            } else {
                CaptureRequest.Builder builderCreateCaptureRequest2 = this.camera.createCaptureRequest(3);
                this.captureRequestBuilder = builderCreateCaptureRequest2;
                builderCreateCaptureRequest2.addTarget(this.cameraFrame.getSurface());
                this.captureRequestBuilder.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, this.camFps);
                this.captureRequestBuilder.set(CaptureRequest.CONTROL_AF_MODE, 4);
            }
            this.camera.createCaptureSession(Collections.singletonList(this.cameraFrame.getSurface()), this.captureSessionObserver, null);
        } catch (CameraAccessException e) {
            handleException(e);
        }
        this.log.d("doStartCapture() exit", new Object[0]);
    }
}
