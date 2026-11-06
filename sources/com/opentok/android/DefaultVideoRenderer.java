package com.opentok.android;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.view.View;
import java.nio.ByteBuffer;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import okhttp3.internal.http2.Http2;

/* JADX INFO: loaded from: classes4.dex */
class DefaultVideoRenderer extends BaseVideoRenderer {
    Context context;
    ReentrantLock frameLock = new ReentrantLock();
    boolean isPillarBoxEnabled = true;
    boolean isVideoDisabled = false;
    BaseVideoRenderer.Frame lastFrame;
    protected long nativeInstance;
    MyRenderer renderer;
    GLSurfaceView view;

    private class MyRenderer implements GLSurfaceView.Renderer {
        public MyRenderer() {
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            boolean z;
            DefaultVideoRenderer.this.frameLock.lock();
            DefaultVideoRenderer defaultVideoRenderer = DefaultVideoRenderer.this;
            BaseVideoRenderer.Frame frame = null;
            if (defaultVideoRenderer.isVideoDisabled) {
                z = true;
            } else {
                BaseVideoRenderer.Frame frame2 = defaultVideoRenderer.lastFrame;
                z = false;
                if (frame2 != null) {
                    defaultVideoRenderer.lastFrame = null;
                    frame = frame2;
                }
            }
            defaultVideoRenderer.frameLock.unlock();
            if (z) {
                gl10.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                GLES20.glClear(Http2.INITIAL_MAX_FRAME_SIZE);
            } else if (frame != null) {
                ByteBuffer buffer = frame.getBuffer();
                buffer.clear();
                DefaultVideoRenderer.this.nativeRenderFrame(buffer, frame.getWidth(), frame.getHeight(), frame.getYstride(), frame.getUvStride(), frame.getYplaneSize(), frame.getUVplaneSize(), frame.getUVplaneSize(), frame.getYplane(), frame.getUplane(), frame.getVplane(), frame.isMirroredX(), DefaultVideoRenderer.this.isPillarBoxEnabled);
                frame.destroy();
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            DefaultVideoRenderer.this.nativeSetupRenderer(i, i2);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            gl10.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
            GLES20.glClear(Http2.INITIAL_MAX_FRAME_SIZE);
            DefaultVideoRenderer.this.nativeCreateRenderer();
        }
    }

    public DefaultVideoRenderer(Context context) {
        this.context = context;
        GLSurfaceView gLSurfaceView = new GLSurfaceView(context);
        this.view = gLSurfaceView;
        gLSurfaceView.setEGLContextClientVersion(2);
        MyRenderer myRenderer = new MyRenderer();
        this.renderer = myRenderer;
        this.view.setRenderer(myRenderer);
        this.view.setRenderMode(0);
        this.view.setZOrderMediaOverlay(true);
    }

    @Override // com.opentok.android.BaseVideoRenderer
    public View getView() {
        return this.view;
    }

    native void nativeCreateRenderer();

    native void nativeRenderFrame(ByteBuffer byteBuffer, int i, int i2, int i3, int i4, int i5, int i6, int i7, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, ByteBuffer byteBuffer4, boolean z, boolean z2);

    native void nativeSetupRenderer(int i, int i2);

    @Override // com.opentok.android.BaseVideoRenderer
    public void onFrame(BaseVideoRenderer.Frame frame) {
        this.frameLock.lock();
        BaseVideoRenderer.Frame frame2 = this.lastFrame;
        if (frame2 != null) {
            frame2.destroy();
        }
        this.lastFrame = frame;
        this.frameLock.unlock();
        this.view.requestRender();
    }

    @Override // com.opentok.android.BaseVideoRenderer
    public void onPause() {
        this.view.onPause();
    }

    @Override // com.opentok.android.BaseVideoRenderer
    public void onResume() {
        this.view.onResume();
    }

    @Override // com.opentok.android.BaseVideoRenderer
    public void onVideoPropertiesChanged(boolean z) {
        this.frameLock.lock();
        this.isVideoDisabled = !z;
        this.frameLock.unlock();
        this.view.requestRender();
    }

    @Override // com.opentok.android.BaseVideoRenderer
    public void setStyle(String str, String str2) {
        if (BaseVideoRenderer.STYLE_VIDEO_SCALE.equals(str)) {
            if (BaseVideoRenderer.STYLE_VIDEO_FIT.equals(str2)) {
                this.isPillarBoxEnabled = true;
            } else if (BaseVideoRenderer.STYLE_VIDEO_FILL.equals(str2)) {
                this.isPillarBoxEnabled = false;
            }
        }
    }
}
