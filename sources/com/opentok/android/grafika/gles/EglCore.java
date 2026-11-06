package com.opentok.android.grafika.gles;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.view.Surface;
import com.opentok.android.OtLog;

/* JADX INFO: loaded from: classes4.dex */
public final class EglCore {
    private static final OtLog.LogToken e = new OtLog.LogToken();
    private EGLDisplay a;
    private EGLContext b;
    private EGLConfig c;
    private int d;

    public EglCore(EGLContext eGLContext, int i) {
        EGLConfig eGLConfigA;
        EGLDisplay eGLDisplay = EGL14.EGL_NO_DISPLAY;
        this.a = eGLDisplay;
        this.b = EGL14.EGL_NO_CONTEXT;
        this.c = null;
        this.d = -1;
        if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
            throw new RuntimeException("EGL already set up");
        }
        eGLContext = eGLContext == null ? EGL14.EGL_NO_CONTEXT : eGLContext;
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        this.a = eGLDisplayEglGetDisplay;
        if (eGLDisplayEglGetDisplay == EGL14.EGL_NO_DISPLAY) {
            throw new RuntimeException("unable to get EGL14 display");
        }
        int[] iArr = new int[2];
        if (!EGL14.eglInitialize(eGLDisplayEglGetDisplay, iArr, 0, iArr, 1)) {
            this.a = null;
            throw new RuntimeException("unable to initialize EGL14");
        }
        if ((i & 2) != 0 && (eGLConfigA = a(i, 3)) != null) {
            EGLContext eGLContextEglCreateContext = EGL14.eglCreateContext(this.a, eGLConfigA, eGLContext, new int[]{12440, 3, 12344}, 0);
            if (EGL14.eglGetError() == 12288) {
                this.c = eGLConfigA;
                this.b = eGLContextEglCreateContext;
                this.d = 3;
            }
        }
        if (this.b == EGL14.EGL_NO_CONTEXT) {
            EGLConfig eGLConfigA2 = a(i, 2);
            if (eGLConfigA2 == null) {
                throw new RuntimeException("Unable to find a suitable EGLConfig");
            }
            EGLContext eGLContextEglCreateContext2 = EGL14.eglCreateContext(this.a, eGLConfigA2, eGLContext, new int[]{12440, 2, 12344}, 0);
            a("eglCreateContext");
            this.c = eGLConfigA2;
            this.b = eGLContextEglCreateContext2;
            this.d = 2;
        }
        int[] iArr2 = new int[1];
        EGL14.eglQueryContext(this.a, this.b, 12440, iArr2, 0);
        e.d("EGLContext created, client version %d", Integer.valueOf(iArr2[0]));
    }

    private EGLConfig a(int i, int i2) {
        int[] iArr = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, i2 >= 3 ? 68 : 4, 12344, 0, 12344};
        if ((i & 1) != 0) {
            iArr[10] = 12610;
            iArr[11] = 1;
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (EGL14.eglChooseConfig(this.a, iArr, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            return eGLConfigArr[0];
        }
        e.w("unable to find RGB8888 / %d EGLConfig", Integer.valueOf(i2));
        return null;
    }

    public void b(EGLSurface eGLSurface) {
        EGL14.eglDestroySurface(this.a, eGLSurface);
    }

    public boolean c(EGLSurface eGLSurface) {
        return EGL14.eglSwapBuffers(this.a, eGLSurface);
    }

    protected void finalize() throws Throwable {
        try {
            if (this.a != EGL14.EGL_NO_DISPLAY) {
                e.w("WARNING: EglCore was not explicitly released -- state may be leaked", new Object[0]);
                a();
            }
        } finally {
            super.finalize();
        }
    }

    public void a() {
        EGLDisplay eGLDisplay = this.a;
        if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroyContext(this.a, this.b);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.a);
        }
        this.a = EGL14.EGL_NO_DISPLAY;
        this.b = EGL14.EGL_NO_CONTEXT;
        this.c = null;
    }

    public EGLSurface a(Object obj) {
        if (!(obj instanceof Surface) && !(obj instanceof SurfaceTexture)) {
            throw new RuntimeException("invalid surface: " + obj);
        }
        EGLSurface eGLSurfaceEglCreateWindowSurface = EGL14.eglCreateWindowSurface(this.a, this.c, obj, new int[]{12344}, 0);
        a("eglCreateWindowSurface");
        if (eGLSurfaceEglCreateWindowSurface != null) {
            return eGLSurfaceEglCreateWindowSurface;
        }
        throw new RuntimeException("surface was null");
    }

    public void a(EGLSurface eGLSurface) {
        if (this.a == EGL14.EGL_NO_DISPLAY) {
            e.w("NOTE: makeCurrent w/o display", new Object[0]);
        }
        if (!EGL14.eglMakeCurrent(this.a, eGLSurface, eGLSurface, this.b)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    private void a(String str) {
        int iEglGetError = EGL14.eglGetError();
        if (iEglGetError == 12288) {
            return;
        }
        throw new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(iEglGetError));
    }
}
