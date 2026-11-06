package com.opentok.android.grafika.gles;

import android.opengl.EGL14;
import android.opengl.EGLSurface;
import com.opentok.android.OtLog;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {
    protected EglCore a;
    private EGLSurface b = EGL14.EGL_NO_SURFACE;
    private int c = -1;
    private int d = -1;
    private final OtLog.LogToken e = new OtLog.LogToken(this);

    protected a(EglCore eglCore) {
        this.a = eglCore;
    }

    public void a(Object obj) {
        if (this.b != EGL14.EGL_NO_SURFACE) {
            throw new IllegalStateException("surface already created");
        }
        this.b = this.a.a(obj);
    }

    public void b() {
        this.a.b(this.b);
        this.b = EGL14.EGL_NO_SURFACE;
        this.d = -1;
        this.c = -1;
    }

    public boolean c() {
        boolean zC = this.a.c(this.b);
        if (!zC) {
            this.e.d("WARNING: swapBuffers() failed", new Object[0]);
        }
        return zC;
    }

    public void a() {
        this.a.a(this.b);
    }
}
