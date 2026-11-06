package com.opentok.android;

import com.opentok.impl.a;
import com.opentok.otc.opentokJNI;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseVideoCapturer {
    public static final int ABGR = 10;
    public static final int ARGB = 2;
    public static final int BGRA = 7;
    public static final int MJPEG = 9;
    public static final int NV12 = 4;
    public static final int NV21 = 1;
    public static final int RGB = 8;
    public static final int RGBA = 11;
    public static final int UYVY = 6;
    public static final int YUV420P = 3;
    public static final int YUY2 = 5;
    protected boolean frameMirrorX = false;
    boolean isStopped = false;
    private final OtLog.LogToken log = new OtLog.LogToken(this);
    private WeakReference<PublisherKit> publisherKit;

    public static class CaptureSettings {
        public int expectedDelay;
        public int format;
        public int fps;
        public int height;
        public boolean mirrorInLocalRender;
        public int width;
    }

    public interface CaptureSwitch {
        void cycleCamera();

        int getCameraIndex();

        void swapCamera(int i);
    }

    public enum VideoContentHint {
        NONE(0),
        MOTION(1),
        DETAIL(2),
        TEXT(3);

        private static final Map<Object, Object> map = new HashMap();
        private final int value;

        static {
            for (VideoContentHint videoContentHint : values()) {
                map.put(Integer.valueOf(videoContentHint.value), videoContentHint);
            }
        }

        VideoContentHint(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }

        public static VideoContentHint valueOf(int i) {
            return (VideoContentHint) map.get(Integer.valueOf(i));
        }
    }

    private int mapFormatToOTCFormat(int i) {
        switch (i) {
            case 1:
                return 3;
            case 2:
                return 6;
            case 3:
                return 1;
            case 4:
                return 2;
            case 5:
                return 4;
            case 6:
                return 5;
            case 7:
                return 7;
            case 8:
                return 8;
            case 9:
                return 10;
            case 10:
                return 9;
            case RGBA /* 11 */:
                return 11;
            default:
                throw new IllegalArgumentException("Invalid pixel format");
        }
    }

    private native void provideByteBufferFrameNative(long j, ByteBuffer byteBuffer, int i, int i2, int i3, int i4, byte[] bArr);

    private native void provideFramePlanarNative(long j, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, byte[] bArr);

    private native void provideIntArrayFrameNative(long j, int[] iArr, int i, int i2, int i3, int i4, byte[] bArr);

    private native void proviveByteFrameNative(long j, byte[] bArr, int i, int i2, int i3, int i4, byte[] bArr2);

    public abstract void destroy();

    public abstract CaptureSettings getCaptureSettings();

    public VideoContentHint getVideoContentHint() {
        WeakReference<PublisherKit> weakReference = this.publisherKit;
        PublisherKit publisherKit = weakReference != null ? weakReference.get() : null;
        if (publisherKit != null) {
            long j = publisherKit.otcCapturerHandle;
            if (j != 0) {
                return VideoContentHint.valueOf(opentokJNI.otc_video_capturer_get_content_hint(j));
            }
        }
        throw new IllegalStateException("Content hint can only be accessed after constructing the Publisher and Capturer.");
    }

    public abstract void init();

    public abstract boolean isCaptureStarted();

    protected void onCameraChanged(int i) {
        WeakReference<PublisherKit> weakReference = this.publisherKit;
        PublisherKit publisherKit = weakReference != null ? weakReference.get() : null;
        if (publisherKit instanceof Publisher) {
            Publisher publisher = (Publisher) publisherKit;
            publisher.onPublisherCameraPositionChanged(publisher, i);
        }
    }

    protected void onCaptureError(Exception exc) {
        this.log.d("onCaptureError() enter.", new Object[0]);
        OpentokError opentokError = exc != null ? new OpentokError(OpentokError.Domain.PublisherErrorDomain, OpentokError.ErrorCode.VideoCaptureFailed.getErrorCode(), exc) : new a(OpentokError.Domain.PublisherErrorDomain, OpentokError.ErrorCode.VideoCaptureFailed.getErrorCode());
        WeakReference<PublisherKit> weakReference = this.publisherKit;
        PublisherKit publisherKit = weakReference != null ? weakReference.get() : null;
        if (publisherKit != null) {
            publisherKit.throwError(opentokError);
        }
        this.log.d("onCaptureError() exit.", new Object[0]);
    }

    public abstract void onPause();

    public void onRestart() {
        this.log.d("onRestart() enter", new Object[0]);
        if (!this.isStopped) {
            this.log.e("onRestart called on a capturer not being stopped", new Object[0]);
            return;
        }
        init();
        startCapture();
        this.isStopped = false;
        this.log.d("onRestart() exit", new Object[0]);
    }

    public abstract void onResume();

    public void onStop() {
        this.log.d("onStop() enter", new Object[0]);
        if (this.isStopped) {
            this.log.e("onStop() called on a capturer already stopped", new Object[0]);
            return;
        }
        stopCapture();
        destroy();
        this.isStopped = true;
        this.log.d("onStop() exit", new Object[0]);
    }

    public void provideBufferFrame(ByteBuffer byteBuffer, int i, int i2, int i3, int i4, boolean z) {
        provideBufferFrame(byteBuffer, i, i2, i3, i4, z, null);
    }

    public void provideBufferFramePlanar(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z) {
        provideBufferFramePlanar(byteBuffer, byteBuffer2, byteBuffer3, i, i2, i3, i4, i5, i6, i7, i8, i9, z, null);
    }

    public void provideByteArrayFrame(byte[] bArr, int i, int i2, int i3, int i4, boolean z) {
        provideByteArrayFrame(bArr, i, i2, i3, i4, z, null);
    }

    public void provideIntArrayFrame(int[] iArr, int i, int i2, int i3, int i4, boolean z) {
        provideIntArrayFrame(iArr, i, i2, i3, i4, z, null);
    }

    protected void setPublisherKit(PublisherKit publisherKit) {
        this.publisherKit = new WeakReference<>(publisherKit);
    }

    public void setVideoContentHint(VideoContentHint videoContentHint) {
        WeakReference<PublisherKit> weakReference = this.publisherKit;
        PublisherKit publisherKit = weakReference != null ? weakReference.get() : null;
        if (publisherKit != null) {
            long j = publisherKit.otcCapturerHandle;
            if (j != 0) {
                opentokJNI.otc_video_capturer_set_content_hint(j, videoContentHint.getValue());
                return;
            }
        }
        throw new IllegalStateException("Content hint can only be set after constructing the Publisher and Capturer.");
    }

    public abstract int startCapture();

    public abstract int stopCapture();

    @Deprecated
    public void provideBufferFrame(ByteBuffer byteBuffer, int i, int i2, int i3, int i4, boolean z, byte[] bArr) {
        WeakReference<PublisherKit> weakReference = this.publisherKit;
        PublisherKit publisherKit = weakReference != null ? weakReference.get() : null;
        if (publisherKit == null || byteBuffer == null || i2 <= 0 || i3 <= 0) {
            return;
        }
        long j = publisherKit.otcCapturerHandle;
        if (j == 0) {
            return;
        }
        this.frameMirrorX = z;
        provideByteBufferFrameNative(j, byteBuffer, mapFormatToOTCFormat(i), i2, i3, i4, bArr);
    }

    @Deprecated
    public void provideBufferFramePlanar(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z, byte[] bArr) {
        WeakReference<PublisherKit> weakReference = this.publisherKit;
        PublisherKit publisherKit = weakReference != null ? weakReference.get() : null;
        if (publisherKit == null || i7 <= 0 || i8 <= 0) {
            return;
        }
        long j = publisherKit.otcCapturerHandle;
        if (j == 0) {
            return;
        }
        this.frameMirrorX = z;
        provideFramePlanarNative(j, byteBuffer, byteBuffer2, byteBuffer3, i, i2, i3, i4, i5, i6, i7, i8, i9, bArr);
    }

    @Deprecated
    public void provideByteArrayFrame(byte[] bArr, int i, int i2, int i3, int i4, boolean z, byte[] bArr2) {
        WeakReference<PublisherKit> weakReference = this.publisherKit;
        PublisherKit publisherKit = weakReference != null ? weakReference.get() : null;
        if (publisherKit == null || bArr == null || i2 <= 0 || i3 <= 0) {
            return;
        }
        long j = publisherKit.otcCapturerHandle;
        if (j == 0) {
            return;
        }
        this.frameMirrorX = z;
        proviveByteFrameNative(j, bArr, mapFormatToOTCFormat(i), i2, i3, i4, bArr2);
    }

    @Deprecated
    public void provideIntArrayFrame(int[] iArr, int i, int i2, int i3, int i4, boolean z, byte[] bArr) {
        WeakReference<PublisherKit> weakReference = this.publisherKit;
        PublisherKit publisherKit = weakReference != null ? weakReference.get() : null;
        if (publisherKit == null || iArr == null || i2 <= 0 || i3 <= 0) {
            return;
        }
        long j = publisherKit.otcCapturerHandle;
        if (j == 0) {
            return;
        }
        this.frameMirrorX = z;
        provideIntArrayFrameNative(j, iArr, mapFormatToOTCFormat(i), i2, i3, i4, bArr);
    }
}
